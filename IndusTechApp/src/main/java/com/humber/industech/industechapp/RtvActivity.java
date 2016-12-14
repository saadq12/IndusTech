/*
Team Name: IndusTech
Members: Ratha Ariyanayagam, Saad Qazi, Abhirup Das
 */
package com.humber.industech.industechapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class RtvActivity extends AppCompatActivity  {

    private TextView t;
    TextView temp, volt, err,sid,stemp,svolt,serr;
    DynamoDBMapper mapper;
    EditText searchID;
    Button searchbtn;


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
                        temp.setTextColor(Color.parseColor("#031A85"));
                        volt.setText(v);
                        volt.setTextColor(Color.parseColor("#031A85"));
                        err.setText(er);
                        err.setTextColor(Color.parseColor("#031A85"));
                    }
                });
            }

        }).start();


        searchID = (EditText)findViewById(R.id.editText3);
        searchbtn = (Button)findViewById(R.id.sbutton);

        sid = (TextView)findViewById(R.id.textView25);
        stemp = (TextView)findViewById(R.id.textView16) ;
        svolt = (TextView)findViewById(R.id.textView17);
        serr = (TextView)findViewById(R.id.textView18);

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create new thread for searching a machine by ID
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        String id = searchID.getText().toString();
                        Log.d("new thread","rtv thread(search onClickListen) saying hello" + id);
                        Machines mach = mapper.load(Machines.class,id);

                        final String idf = mach.getmId();
                        final String stempr = mach.getTemp();
                        final String sv = mach.getVoltage();
                        final String ser = mach.getError();

                        if(idf.equals(id)){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RtvActivity.this, "Found ID", Toast.LENGTH_SHORT).show();


                                    sid.setText(idf);
                                    sid.setTextColor(Color.parseColor("#031A85"));
                                    stemp.setText(stempr);
                                    stemp.setTextColor(Color.parseColor("#031A85"));
                                    svolt.setText(sv);
                                    svolt.setTextColor(Color.parseColor("#031A85"));
                                    serr.setText(ser);
                                    serr.setTextColor(Color.parseColor("#031A85"));
                                }
                            });

                        }
                        else if (idf.equals(id) != true){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RtvActivity.this, "No ID # Found - Try Again", Toast.LENGTH_SHORT).show();

                                }
                            });
                        }


                    }

                }).start();
            }
        });





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
            Intent intent	=	new	Intent(RtvActivity.this, AboutActivity.class);
            startActivity(intent);
            Toast.makeText(this, character1, Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }









}
