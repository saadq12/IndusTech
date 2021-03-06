/*
Team Name: IndusTech
Members: Ratha Ariyanayagam, Saad Qazi, Abhirup Das
 */
package com.humber.industech.industechapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saad on 2016-10-18.
 */

public class DBHandler extends SQLiteOpenHelper {


    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "industech.db";
    // Contacts table name
    private static final String TABLE_LOGIN = "login_creds";
    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    public DBHandler(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_LOGIN + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USERNAME + " TEXT," + KEY_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_LOGIN_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        //drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_LOGIN);
        //creating tables again
        onCreate(db);

    }


    //Insert Record:
    //adding login creds
    public void addLoginCred(LoginCred loginCred){


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //putting login credentinals into ContentValues object
        values.put(KEY_USERNAME, loginCred.getUsername());//user name
        values.put(KEY_PASSWORD, loginCred.getPassword());//password
        //insert the rows into the data base
        db.insert(TABLE_LOGIN, null, values);
        db.close();

    }


    //Read Record(s):
    // will read a logincred and take primary ID as pararmeter
    public LoginCred getLogin(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LOGIN, new String[] {KEY_ID, KEY_USERNAME, KEY_PASSWORD}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
            LoginCred contact = new LoginCred(cursor.getString(0),cursor.getString(1));
            return contact;
    }

    // Getting All Logins
    public List<LoginCred> getAllLogins() {
        List<LoginCred> LoginList = new ArrayList<LoginCred>();
        //select all query
        String selectQuery = "SELECT * FROM " + TABLE_LOGIN;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        //looping through all rows and adding to the list
        if(cursor.moveToFirst()){
            do {
                LoginCred LoginCred = new LoginCred();
                LoginCred.setId(Integer.parseInt(cursor.getString(0)));
                LoginCred.setUsername(cursor.getString(1));
                LoginCred.setPassword(cursor.getString(2));
                //adding login creds to list
                LoginList.add(LoginCred);
            }while(cursor.moveToNext());
        }
        return LoginList;
    }


    // Getting total # of login creds in databse
    public int getLoginCredCounts(){
        String countQuery = "SELECT * FROM " + TABLE_LOGIN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }


    // Updating a login cred
    public int updateLoginCred(LoginCred loginCred){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, loginCred.getUsername());
        values.put(KEY_PASSWORD, loginCred.getPassword());
        //update the row
        return db.update(TABLE_LOGIN, values, KEY_ID + "=?", new String[] {String.valueOf(loginCred.getId())});

    }


    // Deleting a login cred
    public void deleteLoginCred(LoginCred loginCred){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LOGIN, KEY_ID + " = ?",
                new String[] {String.valueOf(loginCred.getId())});
        db.close();
    }



    //validate login cred(logging in)

    public boolean validateLogin(String username, String password){
        boolean foundUser = false;
        Log.d("LFDBHANDLER: ", "validateLogin FUNCTION CHECKING IN");
        String query = "SELECT username, password FROM " + TABLE_LOGIN;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query,null);



        String u,p;
        if(cursor.moveToFirst()){
            do {
                u = cursor.getString(0);
                p = cursor.getString(1);

                if(u.equals(username) && p.equals(password)){
                    Log.d("DBHANDLER: ", "IF STATEMENT CHECKING IN, found user");
                    foundUser = true;
                }
                else
                {
                    //searched whole query, no user found.
                   foundUser = false;
                }

            }while(cursor.moveToNext());
        }
        return foundUser;
    }






}
