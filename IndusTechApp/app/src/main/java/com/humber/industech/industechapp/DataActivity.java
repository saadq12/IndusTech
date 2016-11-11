package com.humber.industech.industechapp;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import static android.R.attr.name;

public class DataActivity extends AppCompatActivity {

    private TextView t;
    private Context mContext;

  //  CognitoCachingCredentialsProvider credentialsProvider = CredentialProviderSingleton.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        //setting custom font
        t = (TextView) findViewById(R.id.textView3);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/Prezident.ttf");
        t.setTypeface(customFont);


       // CredentialProviderSingleton test = new CredentialProviderSingleton();
        //test.getInstance(getApplicationContext());

       // CredentialProviderSingleton.getInstance(this);

        //CognitoCachingCredentialsProvider credentialsProvider = CredentialProviderSingleton.getInstance(this);
        /*
        // Initialize the Amazon Cognito credentials provider
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                getApplicationContext(),
                "us-west-2:0e7ddbfd-a548-43d5-8636-af4ebff8975f", // Identity Pool ID
                Regions.US_WEST_2 // Region
        );
        */
        //AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(credentialsProvider);
       // final DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);
    /*
       final Runnable runnable = new Runnable() {
            public void run() {
                //DynamoDB calls go here
            }
            Thread mythread = new Thread(runnable);
            mythread.start();

*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                saveData();
                Log.d("new thread","data thread saying hello");
            }

        }).start();


    }

    public void saveData(){

        CognitoCachingCredentialsProvider credentialsProvider = CredentialProviderSingleton.getInstance(this);
        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(credentialsProvider);
        DynamoDBMapper mapper = new DynamoDBMapper(ddbClient);
        Book book = new Book();
        book.setTitle("Test");
        book.setAuthor("Charles Dickens");
        book.setPrice(1299);
        book.setIsbn("1235674");
        book.setHardCover(false);
        mapper.save(book);

    }

}
