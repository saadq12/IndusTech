/**
 * Project name: Industrial Revolution 4.0
 * Team name: IndusTech
 * Members: Abhirup Das, Saad Qazi and Ratha Ariyanayagam
 */

package inc.race.industrial_revolution_40;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Data_base extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
    }
    
     public	void	back(View view)	{
        Intent intent	=	null;
        intent	=	new	Intent(Scan.this, Main.class);
        startActivity(intent);


    }		//	end	of	AndroidTestAcDvity
}
