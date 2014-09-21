package com.asu.vcare;

import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.asu.dao.VolunteerAdderAsync;
import com.asu.models.Events;
import com.asu.models.Volunteer;
import com.asu.session.CurrentSession;

public class EventDetail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_detail);
		
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.banner));
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
		
		
		List<Events> events = CurrentSession.getListOfEvens();
		Bundle bundle = getIntent().getExtras();
		int pos = Integer.parseInt(bundle.get("pos").toString());
		
		Events evt = events.get(pos);
		if(evt != null){
		((TextView)findViewById(R.id.evtName)).setText(evt.getEventName());
		((TextView)findViewById(R.id.txtDesc)).setText(evt.getEventDescription());
		((TextView)findViewById(R.id.txtDate)).setText(evt.getStartDate().toString());
		((TextView)findViewById(R.id.txtLocation)).setText(evt.getAddress());
		}
		

		final Volunteer volunter = new Volunteer();
		volunter.setEventID(evt.getOrganizerID());
		volunter.setEventName(evt.getEventName());
		volunter.setVoluteerID(CurrentSession.getUser().getMobileNumber());
		
		Button volunteerButton = (Button) findViewById(R.id.btnVolunteer);
		volunteerButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new VolunteerAdderAsync(EventDetail.this).execute(volunter);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event_detail, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
