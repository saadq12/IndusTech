package com.humber.industech.industechapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //setting custom font
        t = (TextView) findViewById(R.id.textView);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/Prezident.ttf");
        t.setTypeface(customFont);
    }
}
