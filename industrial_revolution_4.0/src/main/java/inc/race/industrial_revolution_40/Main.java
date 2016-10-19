/**
 * Project name: Industrial Revolution 4.0
 * Team name: IndusTech
 * Members: Abhirup Das, Saad Qazi and Ratha Ariyanayagam
 */
 
package inc.race.industrial_revolution_40;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class Main extends AppCompatActivity {

    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting custom font
        t = (TextView) findViewById(R.id.textView);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/Prezident.ttf");
        t.setTypeface(customFont);

        /*

            DATA BASE TEST

         */


        DBHandler DB = new DBHandler(this);
        //inserting rows(login creds)
        DB.addLoginCred(new LoginCred("SaadQazi","NotMyPassword"));
        DB.addLoginCred(new LoginCred("AbhirupDas","testPassword"));

        // Reading all login creds
        Log.d("Reading: ","Reading all logins creds");
        List<LoginCred> loginCreds = DB.getAllLogins();

        for (LoginCred loginCred : loginCreds){

            String log = "ID: " + loginCred.getId() + " , Username: " + loginCred.getUsername() + " , Password: " + loginCred.getPassword();
            //writing to log
            Log.d("Login:", log);
        }
    }


    public void menu(View view) {
        Intent intent = null;
        switch (view.getId())
        {

            case  R.id.ScanBtn:

                intent = new Intent(Main.this, Scan.class);
                startActivity(intent);
                break;

            case R.id.DataBtn:

                intent = new Intent(Main.this, Data_base.class);
                startActivity(intent);

                break;


            case R.id.RtvBtn:


                intent = new Intent(Main.this, Machine_list.class);
                startActivity(intent);

                break;

        }        //	end	of	AndroidTestAcDvity


    }
}