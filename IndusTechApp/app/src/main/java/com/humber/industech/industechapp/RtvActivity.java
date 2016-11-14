package com.humber.industech.industechapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class RtvActivity extends AppCompatActivity {

    private TextView t;
    TextView temp, volt, err;
    DynamoDBMapper mapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtv);

        //setting custom font
        t = (TextView) findViewById(R.id.textView5);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/Prezident.ttf");
        t.setTypeface(customFont);


        temp = (TextView)findViewById(R.id.textView12);
        volt = (TextView)findViewById(R.id.textView13);
        err = (TextView)findViewById(R.id.textView14);

        CognitoCachingCredentialsProvider credentialsProvider = CredentialProviderSingleton.getInstance(this);
        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(credentialsProvider);
        mapper = new DynamoDBMapper(ddbClient);

        new Thread(new Runnable() {
            @Override
            public void run() {

                //saveData();
                //saveLogin();
                //getLogin();
                Log.d("new thread","rtv thread saying hello");
                Machines mach = mapper.load(Machines.class, "1");

                final String tempr = mach.getTemp();
                final String v = mach.getVoltage();
                final String er = mach.getError();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        temp.setText(tempr);
                        temp.setTextColor(Color.RED);
                        volt.setText(v);
                        volt.setTextColor(Color.RED);
                        err.setText(er);
                        err.setTextColor(Color.RED);
                    }
                });
            }

        }).start();



    }//end onCreate









}
