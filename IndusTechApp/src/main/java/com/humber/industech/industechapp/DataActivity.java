/*
Team Name: IndusTech
Members: Ratha Ariyanayagam, Saad Qazi, Abhirup Das
 */
package com.humber.industech.industechapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
    TextView tv7,scantv;

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

        //scantv = (TextView)findViewById(R.id.textView19);




        //create AWS client connection
        CognitoCachingCredentialsProvider credentialsProvider = CredentialProviderSingleton.getInstance(this);
        AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(credentialsProvider);
        mapper = new DynamoDBMapper(ddbClient);



       /*
       Runnable runnable = new Runnable() {
           @Override
           public void run() {
               tv7.setText("text set inside runnable");
           }
       };
        mhanlder.post(runnable);
        */


        new Thread(new Runnable() {
            @Override
            public void run() {


                Log.d("new thread","data thread saying hello");
                Login selectedLogin = mapper.load(Login.class, "2");
                un = selectedLogin.getUsername();
                pw = selectedLogin.getPassword();

                final String username = getUserName();
                //saveData("test");
                String x = getIntent().getStringExtra("input");
                saveData(x);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String x = getIntent().getStringExtra("input");
                        tv7.setText("Scanned Data: " + x + "has been saved!");
                    }
                });
            }

        }).start();



    }//end onCreate

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
            Toast.makeText(this, character1, Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
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


    }

    public String getUserName(){
        String un;
        Login user = mapper.load(Login.class,"2");
        un = user.getUsername();
        return un;
    }

    //this will store data recived from barcode scan to database on cloud
    public void saveData(String data){
        //assign data sent from intent (QR code data) to this string
        String dataRecviecd = data;

        //split the strings, to grab ID and Data
        String dataid = dataRecviecd.substring(0,1);
        String data2 = dataRecviecd.substring(2);
        Log.d("saveDataFunc",dataid + data2);

        Data DataAWS = new Data();
        DataAWS.setDataid(dataid);
        DataAWS.setData(data2);
        mapper.save(DataAWS);


    }

}
