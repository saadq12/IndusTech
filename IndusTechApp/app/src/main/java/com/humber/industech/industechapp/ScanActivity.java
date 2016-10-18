/**
 * Project name: Industrial Revolution 4.0
 * Team name: IndusTech
 * Members: Abhirup Das, Saad Qazi and Ratha Ariyanayagam
 */

package com.humber.industech.industechapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScanActivity extends AppCompatActivity {

    private Button LaunchCameraBttn;
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);



        //setting custom font
        t = (TextView) findViewById(R.id.textView2);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/Prezident.ttf");
        t.setTypeface(customFont);

        LaunchCameraBttn = (Button)findViewById(R.id.LaunchCamera);

        LaunchCameraBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 0);
            }
        });
        /*
        //setting click listener to the scan button so it can go launch the camera
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
