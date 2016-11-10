package com.humber.industech.industechapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //decalrinig variables for buttons
    private Button ScanButton;
    private Button DataButton;
    private Button RTVButton;
    private TextView t;
    private TextView sss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //setting custom font
        t = (TextView) findViewById(R.id.textView);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/Prezident.ttf");
        t.setTypeface(customFont);


        //setting click listener to the scan button so it can go to a ScanActivity
        ScanButton = (Button) findViewById(R.id.ScanBtn);
        ScanButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent ScanButtonIntent = new Intent(MainActivity.this, ScanActivity.class);
                startActivity(ScanButtonIntent);
            }
        });


        //setting click listener to the data button so it can go to a DataActivity
        DataButton = (Button) findViewById(R.id.DataBtn);
        DataButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent DataButtonIntent = new Intent(MainActivity.this, DataActivity.class);
                startActivity(DataButtonIntent);
            }
        });

        //setting click listener to the real time value button so it can go to a RtvActivity
        RTVButton = (Button) findViewById(R.id.RtvBtn);
        RTVButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent RtvButtonIntent = new Intent(MainActivity.this, RtvActivity.class);
                startActivity(RtvButtonIntent);
            }
        });


        /*

            DATA BASE TEST

         */


        DBHandler DB = new DBHandler(this);
        //inserting rows(login creds)
        //DB.addLoginCred(new LoginCred("SaadQazi","NotMyPassword"));
        //DB.addLoginCred(new LoginCred("AbhirupDas","testPassword"));
        //DB.addLoginCred(new LoginCred("Tanav Sharma","nopassword"));
        //DB.addLoginCred(new LoginCred("Saad","Password"));

        // Reading all login creds
        Log.d("Reading: ","Reading all logins creds");
        List<LoginCred> loginCreds = DB.getAllLogins();

        for (LoginCred loginCred : loginCreds){

            String log = "ID: " + loginCred.getId() + " , Username: " + loginCred.getUsername() + " , Password: " + loginCred.getPassword();
            //writing to log
            Log.d("Login:", log);
        }


    }//end onCreate function








}
