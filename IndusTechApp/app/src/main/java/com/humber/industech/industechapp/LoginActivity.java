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
        Log.d("DBhandler"," before call");
        addUser();
        Log.d("DBhandler"," after call");

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
                Toast.makeText(LoginActivity.this, unm + psw , Toast.LENGTH_LONG).show();



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
            Toast.makeText(this, "validateLogin function called, returned TRUE", Toast.LENGTH_SHORT).show();
            Log.d("LFDBHANDLER: ", "found user");
            foundUser = true;
        }
        else if (testfunc == false){
            Toast.makeText(this, "validateLogin function called, returned FALSE", Toast.LENGTH_SHORT).show();
            Log.d("LFDBHANDLER: ", "did not find user");
            username.setError("Login not found");
            foundUser = false;
        }

        return foundUser;
    }


    public void addUser(){
        DBHandler DB = new DBHandler(this);
       // DB.addLoginCred(new LoginCred("Saad","Password"));
        Log.d("Reading: ","Reading all logins creds");
        List<LoginCred> loginCreds = DB.getAllLogins();

        for (LoginCred loginCred : loginCreds){

            String log = "ID: " + loginCred.getId() + " , Username: " + loginCred.getUsername() + " , Password: " + loginCred.getPassword();
            //writing to log
            Log.d("Login:", log);
        }

    }










}
