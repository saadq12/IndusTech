package com.humber.industech.industechapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanActivity extends AppCompatActivity {

    private Button QR_scanBttn;
    private Button Barcode_scanBttn;

    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);



        //setting custom font
        t = (TextView) findViewById(R.id.textView2);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/Prezident.ttf");
        t.setTypeface(customFont);

        QR_scanBttn = (Button)findViewById(R.id.QR_scan);
        Barcode_scanBttn = (Button)findViewById(R.id.Barcode);



        QR_scanBttn = (Button)findViewById(R.id.QR_scan);
        Barcode_scanBttn = (Button)findViewById(R.id.Barcode);
        final Activity activity = this;


        QR_scanBttn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //on pressing the button
            {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt(getString(R.string.scan));
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });



        Barcode_scanBttn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //on pressing the button
            {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.PRODUCT_CODE_TYPES);
                integrator.setPrompt(getString(R.string.scan));
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });


    }//endoncreate

    //handle result of QR code, and show result as a toast
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult output = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (output != null) {
            if (output.getContents() == null) {
                Toast.makeText(this, getString(R.string.scanfail), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, output.getContents(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ScanActivity.this, DataActivity.class);
                intent.putExtra("input",  output.getContents() );
                startActivity(intent);
            }

        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}


