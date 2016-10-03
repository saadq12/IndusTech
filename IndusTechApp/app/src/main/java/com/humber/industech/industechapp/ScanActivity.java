package com.humber.industech.industechapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScanActivity extends AppCompatActivity {

    private Button ScanButtonIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        /*
        //setting click listener to the scan button so it can go to a new activity
        ScanButtonIntent = (Button) findViewById(R.id.ScanBtn);
        ScanButtonIntent.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, 0);
            }
        });
        */

    }
}
