package com.asu.vcare;

import java.util.List;

import com.asu.session.CurrentSession;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.asu.models.Event;
import com.asu.models.Events;
import com.asu.session.CurrentSession;

public class EventDetail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_detail);
		
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
