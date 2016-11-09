package inc.race.industrial_revolution_40;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


                intent = new Intent(Main.this, RTV.class);
                startActivity(intent);

                break;

        }        //	end	of	AndroidTestAcDvity


    }
}