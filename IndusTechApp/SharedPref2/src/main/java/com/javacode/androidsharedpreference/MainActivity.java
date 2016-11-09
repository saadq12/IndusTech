package com.javacode.androidsharedpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity  {

	CheckBox checkBox;
	EditText editText;
	Button btnSave;
	Button btnRetrieve;
    EditText editNumSave;
    int num;
	
	TextView nameRet;
	TextView cbValue;
    TextView numRet;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		checkBox = (CheckBox) findViewById(R.id.checkBox1);
		editText = (EditText) findViewById(R.id.editText1);
        editNumSave = (EditText) findViewById(R.id.editText5);


        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor =sharedPreferences.edit();
      //  editor.clear();



		btnSave = (Button) findViewById(R.id.button1);
		btnRetrieve = (Button) findViewById(R.id.button2);
		
		nameRet = (TextView) findViewById(R.id.tvName);
		cbValue = (TextView) findViewById(R.id.tvCheckBox);
        numRet = (TextView) findViewById(R.id.tvnumValue);
		
		//loadSavedPreferences();
		
		

		
		btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	// TODO Auto-generated method stub
        		//savePreferences("CheckBox_Value", checkBox.isChecked());
        	//	if (checkBox.isChecked()) // value is saved only if box is checked!
        	//		savePreferences("storedName", editText.getText().toString());

        	//	finish();
                String txtValue = editNumSave.getText().toString();

                try
                {
                    num = Integer.parseInt(txtValue);
                }
                catch (NumberFormatException e)
                {
                    // handle the exception
                    num = 0;
                }

                SharedPreferences sharedPreferences = PreferenceManager
                        .getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("CheckBox_Value", checkBox.isChecked());
                editor.putString("Name_Value", editText.getText().toString());
                editor.putInt("Num_Value", num);

                editor.commit();
            }
        });



	}





}