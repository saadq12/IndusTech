/*
Team Name: IndusTech
Members: Ratha Ariyanayagam, Saad Qazi, Abhirup Das
 */
package com.humber.industech.industechapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        CharSequence character1 = getString(R.string.action_settings_text);
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent	=	new	Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
            Toast.makeText(this, character1, Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed()
    {
        new AlertDialog.Builder(this)
                .setTitle(R.string.sing_out)
                .setMessage(R.string.out_message)
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();


    }

}
