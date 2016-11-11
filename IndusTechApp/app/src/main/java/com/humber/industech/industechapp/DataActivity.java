package com.humber.industech.industechapp;

import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class DataActivity extends AppCompatActivity {

    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);



        /*
        // Initialize the Amazon Cognito credentials provider
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                getApplicationContext(),
                "us-west-2:0e7ddbfd-a548-43d5-8636-af4ebff8975f", // Identity Pool ID
                Regions.US_WEST_2 // Region
        );

        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(credentialsProvider);
        DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);
        */

        //setting custom font
        t = (TextView) findViewById(R.id.textView3);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/Prezident.ttf");
        t.setTypeface(customFont);




    }
}
