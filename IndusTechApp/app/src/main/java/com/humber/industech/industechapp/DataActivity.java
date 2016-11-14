package com.humber.industech.industechapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import static android.R.attr.name;

public class DataActivity extends AppCompatActivity {

    private TextView t;
    private Context mContext;
    public String un,pw, id;
    Handler mhanlder = new Handler();
    TextView tv7;

  DynamoDBMapper mapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        //setting custom font
        t = (TextView) findViewById(R.id.textView3);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/Prezident.ttf");
        t.setTypeface(customFont);

        tv7 = (TextView)findViewById(R.id.textView7);
        tv7.setText("findviewbyid set");


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

        CognitoCachingCredentialsProvider credentialsProvider = CredentialProviderSingleton.getInstance(this);
        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(credentialsProvider);
        mapper = new DynamoDBMapper(ddbClient);

       Runnable runnable = new Runnable() {
           @Override
           public void run() {
               tv7.setText("text set inside runnable");
           }
       };
        mhanlder.post(runnable);

        /*
        testtextview = (TextView)findViewById(R.id.textView7);
        Thread t = new Thread(){
            public void run(){
                testtextview.post(new Runnable() {
                    @Override
                    public void run() {
                        getLogin();
                        testtextview.setText(un + pw + id);
                    }
                });
            }
        };
        t.start();
        */




        new Thread(new Runnable() {
            @Override
            public void run() {

                //saveData();
                //saveLogin();
                //getLogin();
                Log.d("new thread","data thread saying hello");
                Login selectedLogin = mapper.load(Login.class, "2");
                un = selectedLogin.getUsername();
                pw = selectedLogin.getPassword();

                final String username = getUserName();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv7.setText(username);
                    }
                });
            }

        }).start();


        //testtextview = (TextView)findViewById(R.id.textView7);
        //testtextview.setText(un + pw + id);


    }//end onCreate


    public void saveData(){

        Book book = new Book();
        book.setTitle("Test");
        book.setAuthor("Charles Dickens");
        book.setPrice(1299);
        book.setIsbn("1235674");
        book.setHardCover(false);
        mapper.save(book);

    }

    public void saveLogin(){

        Login login = new Login();
        login.setUsername("Saad Qazi");
        login.setPassword("password!");
        login.setId("2");
        mapper.save(login);


    }

    public void getLogin(){
        Login selectedLogin = mapper.load(Login.class, "2");
        un = selectedLogin.getUsername();
        pw = selectedLogin.getPassword();
        id = selectedLogin.getId();
        Log.d("getLogin",selectedLogin.getUsername() + selectedLogin.getId() + selectedLogin.getPassword());
        //testtextview.setText(un + pw + id);

    }

    public String getUserName(){
        String un;
        Login user = mapper.load(Login.class,"2");
        un = user.getPassword();
        return un;
    }

}
