package com.humber.industech.industechapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //decalrinig variables for buttons
    private Button ScanButton;
    private Button DataButton;
    private Button RTVButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent RtvButtonIntent = new Intent(MainActivity.this, DataActivity.class);
                startActivity(RtvButtonIntent);
            }
        });





    }
}
