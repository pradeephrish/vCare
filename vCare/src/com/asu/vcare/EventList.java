package com.asu.vcare;

import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.asu.models.Events;
import com.asu.session.CurrentSession;

public class EventList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_list);
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.banner));
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
		
		List<Events> events = CurrentSession.getListOfEvens();
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
		
		final ListView lv = (ListView)findViewById(R.id.eventList);
		
		lv.setAdapter(adapter);
		lv.setClickable(true);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		        @Override
		        public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		        	
		            Object o = lv.getItemAtPosition(position);
		            String str=(String)o;//As you are using Default String Adapter
		            Intent i = new Intent(EventList.this, EventDetail.class);
		            i.putExtra("pos", Integer.toString(position));
		            startActivity(i);
		        }
		    });
		
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
