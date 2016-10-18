package inc.race.industrial_revolution_40;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RTV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtv);
    }


    public	void	back(View view)	{
        Intent intent	=	null;
        intent	=	new	Intent(RTV.this, Main.class);
        startActivity(intent);
    }





}

