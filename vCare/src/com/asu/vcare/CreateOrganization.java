package com.asu.vcare;

import java.util.Date;

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
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import com.asu.models.Events;
import com.asu.session.CurrentSession;
import com.asu.dao.DAOManager;

public class CreateOrganization extends Activity {
	private EditText txtAddress; 
	private Button btnCreate;
	private Spinner spinner;
	private Date selectedDate;
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
		selectedDate = new Date();
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
		Events event = new Events();
		event.setAddress(((EditText)findViewById(R.id.address)).getText().toString());
		event.setEventDescription(((EditText)findViewById(R.id.desc)).getText().toString());
		event.setEventName(((EditText)findViewById(R.id.eventname)).getText().toString());
		event.setOrganizationID(((Spinner)findViewById(R.id.spinner1)).getSelectedItem().toString());
		event.setOrganizerID("0");
		
		 DatePicker datePicker = (DatePicker) findViewById(R.id.calendarView1);

	        int day = datePicker.getDayOfMonth();
	        int month = datePicker.getMonth() + 1;
	        int year = datePicker.getYear();
	        selectedDate = new Date(year, month, day);
		event.setStartDate(selectedDate);
		event.setEndDate(selectedDate);
		
		new DAOManager().createEvent(event, CurrentSession.getUser().getMobileNumber());
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
