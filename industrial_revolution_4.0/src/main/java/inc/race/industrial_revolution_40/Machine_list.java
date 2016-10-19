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

public class Machine_list extends AppCompatActivity {

    private Button Machine1;
    private Button Machine2;
    private Button Machine3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_list);

        Machine1 = (Button) findViewById(R.id.button2);
        Machine1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent ScanButtonIntent = new Intent(Machine_list.this, RTV.class);
                startActivity(ScanButtonIntent);
            }
        });

        Machine2 = (Button) findViewById(R.id.button3);
        Machine2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent ScanButtonIntent = new Intent(Machine_list.this, RTV.class);
                startActivity(ScanButtonIntent);
            }
        });

        Machine3 = (Button) findViewById(R.id.button4);
        Machine3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent ScanButtonIntent = new Intent(Machine_list.this, RTV.class);
                startActivity(ScanButtonIntent);
            }
        });
    }


    //back button to main page
    public	void	back(View view)	{
        Intent intent	=	null;
        intent	=	new	Intent(Machine_list.this, Main.class);
        startActivity(intent);


    }		//	end	of	AndroidTestAcDvity
}
