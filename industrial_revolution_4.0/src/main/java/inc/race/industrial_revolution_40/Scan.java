/**
 * Project name: Industrial Revolution 4.0
 * Team name: IndusTech
 * Members: Abhirup Das, Saad Qazi and Ratha Ariyanayagam
 */

package inc.race.industrial_revolution_40;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class Scan extends AppCompatActivity {


    private Button LaunchCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        LaunchCamera = (Button) findViewById(R.id.LaunchCamera);
        final Activity activity = this;
        LaunchCamera.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //on pressing the button
            {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                //  add premission
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult output = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (output != null) {
            if (output.getContents() == null) {
                Toast.makeText(this, " You cancelled the Scan", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, output.getContents(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Scan.this, Data_base.class);
                intent.putExtra("input",  output.getContents() );
                startActivity(intent);


                // output.getContents();

            }

        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }



    public	void	back(View view)	{
        Intent intent	=	null;
        intent	=	new	Intent(Scan.this, Main.class);
        startActivity(intent);


    }		//	end	of	AndroidTestAcDvity
}
