/**
 * Project name: Industrial Revolution 4.0
 * Team name: IndusTech
 * Members: Abhirup Das, Saad Qazi and Ratha Ariyanayagam
 */
 
package inc.race.industrial_revolution_40;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public	void	press(View view)	{
        Intent intent	=	null;
        intent	=	new	Intent(Login.this, Main.class);
                startActivity(intent);


    }		//	end	of	AndroidTestAcDvity



}