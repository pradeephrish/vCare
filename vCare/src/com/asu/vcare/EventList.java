package com.asu.vcare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asu.dao.DAOManager;
import com.asu.models.Events;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class EventList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_list);
		
		List<Events> events = new DAOManager().get("0");
		String datum[] = new String[events.size()];
		String desc[] = new String[events.size()];
		Integer evtImage [] = new Integer[events.size()];
		for(int i=0; i<events.size();i++){
			
			Events event = events.get(i);
			datum[i] = event.getEventName();
			desc[i] = event.getEventDescription();
			evtImage[i] = R.drawable.event;			   	    
						
		}
		
		CustomList adapter = new CustomList(this, datum, desc, evtImage);
		ListView lv = (ListView)findViewById(R.id.eventList);
		lv.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event_list, menu);
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
