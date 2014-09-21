package com.asu.vcare;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Settings extends Activity{
	 private CheckBox chknotify;
	 @Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_create_event);
	 
				addListenerOnChk();

	  }
	 
	  public void addListenerOnChk() {
	 
		chknotify = (CheckBox) findViewById(R.id.chkNotifiy);
	 
		chknotify.setOnClickListener(new OnClickListener() {
	 
		  @Override
		  public void onClick(View v) {
	                //is chkIos checked?
			if (!((CheckBox) v).isChecked()) {
				Toast.makeText(Settings.this,
			 	   "Disabled Notification :)", Toast.LENGTH_LONG).show();
			}
	 
		  }
		});
	 
	  }
}
