package com.asu.vcare;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateOrganization extends Activity {
	private EditText txtAddress; 
	private Button btnCreate;
	private Spinner spinner;
    private static final String[]paths = {"Select an Organisation","Teach for America", "Kids of America", "Whole Life Foundation","Central AZ Shelter Services"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_event);
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.banner));
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
		
		spinner = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(CreateOrganization.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				  switch (arg2) {
		            case 0:
		                // Whatever you want to happen when the first item gets selected
		                break;
		            case 1:
		                // Whatever you want to happen when the second item gets selected
		                break;
		            case 2:
		                // Whatever you want to happen when the thrid item gets selected
		                break;

		        }
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        	
		});     
		
		txtAddress = (EditText) findViewById(R.id.address);
		btnCreate = (Button) findViewById(R.id.CreateEvent);
		btnCreate.setOnClickListener(Create);	
	}
	
	View.OnClickListener Create = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
		Intent in = new Intent(CreateOrganization.this, MainActivity.class);
		startActivity(in);
		}
	};
	
	/*public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }
	
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}*/
}
