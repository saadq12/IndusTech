/**
 * Project name: Industrial Revolution 4.0
 * Team name: IndusTech
 * Members: Abhirup Das, Saad Qazi and Ratha Ariyanayagam
 */

package inc.race.industrial_revolution_40;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RTV extends AppCompatActivity {

    private Button machinelist;
    private Button backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtv);

        machinelist = (Button) findViewById(R.id.BackButton);
        machinelist.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent ScanButtonIntent = new Intent(RTV.this, Machine_list.class);
                startActivity(ScanButtonIntent);
            }
        });

        backbutton = (Button) findViewById(R.id.buttonbackmain);
        backbutton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent ScanButtonIntent = new Intent(RTV.this, Main.class);
                startActivity(ScanButtonIntent);
            }
        });
    }
}

