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
import android.widget.TextView;
import android.widget.Toast;

public class Data_base extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);


        String x = getIntent().getStringExtra("input");
        Toast.makeText(Data_base.this, x, Toast.LENGTH_SHORT).show();

        TextView textElement = (TextView) findViewById(R.id.Scaninput);
        textElement.setText(x); //leave this line to assign a specific text

    }
    
     public	void	back(View view)	{
        Intent intent	=	null;
        intent	=	new	Intent(Data_base.this, Main.class);
        startActivity(intent);


    }		//	end	of	AndroidTestAcDvity
}
