package com.humber.industech.industechapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private TextView t;
    private Button loginbttn;
    private EditText username, password;
    private String unm, psw;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //setting custom font
        t = (TextView) findViewById(R.id.textView6);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/Prezident.ttf");
        t.setTypeface(customFont);




        //add login data upon launching the app
        addUser();


        //assign EditText to layouts (to get username, password)
        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);


        //assign button to layout
        loginbttn = (Button)findViewById(R.id.loginbutton);
        loginbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get user values and assign to string.
                unm = username.getText().toString();
                psw = password.getText().toString();
                //hash the password to compare to the database
                psw = md5(psw);



                boolean userFound = checkLogin(unm,psw);
                if(userFound == true) {
                    Intent loginintent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(loginintent);
                }
                else if (userFound == false) {
                    Toast.makeText(LoginActivity.this, "No user found in DB, try again" , Toast.LENGTH_LONG).show();
                }

            }
        });



    }//end oncreate


    //used for logging in the user
    public boolean checkLogin(String user, String pass){

        boolean foundUser = false;
        DBHandler DB = new DBHandler(this);
        //DB.addLoginCred(new LoginCred("SaadQazi","NotMyPassword"));
        boolean testfunc = false;
        testfunc = DB.validateLogin(user,pass);
        if(testfunc == true){
            //Toast.makeText(this, "validateLogin function called, returned TRUE", Toast.LENGTH_SHORT).show();
            Log.d("LFDBHANDLER: ", "found user");
            foundUser = true;
        }
        else if (testfunc == false){
            //Toast.makeText(this, "validateLogin function called, returned FALSE", Toast.LENGTH_SHORT).show();
            //Log.d("LFDBHANDLER: ", "did not find user");
            username.setError("Login not found");
            foundUser = false;
        }

        return foundUser;
    }


    public void addUser(){
        DBHandler DB = new DBHandler(this);
        //hardcode user
        String user,pass;
        user = "industech";
        pass = "password";
        //hash the password
        pass = md5(pass);
        DB.addLoginCred(new LoginCred(user,pass));
        Log.d("Reading: ","Reading all logins creds");
        List<LoginCred> loginCreds = DB.getAllLogins();

        for (LoginCred loginCred : loginCreds){
            String log = "ID: " + loginCred.getId() + " , Username: " + loginCred.getUsername() + " , Password: " + loginCred.getPassword();
            //writing to log
            Log.d("Login:", log);
        }

    }

    public static String md5(String s)
    {
        MessageDigest digest;
        try
        {
            digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes(Charset.forName("US-ASCII")),0,s.length());
            byte[] magnitude = digest.digest();
            BigInteger bi = new BigInteger(1, magnitude);
            String hash = String.format("%0" + (magnitude.length << 1) + "x", bi);
            return hash;
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return "";
    }











}
