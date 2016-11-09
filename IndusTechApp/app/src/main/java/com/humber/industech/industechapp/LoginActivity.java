package com.humber.industech.industechapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                Toast.makeText(LoginActivity.this, unm + psw , Toast.LENGTH_SHORT).show();
                Intent loginintent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(loginintent);
            }
        });

    }
}
