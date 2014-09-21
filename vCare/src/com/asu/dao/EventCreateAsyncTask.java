package com.asu.dao;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.asu.models.Event;
import com.asu.models.Events;
import com.asu.vcare.Event_Success;
import com.asu.vcare.LoginActivity;
import com.asu.vcare.MainActivity;
import com.asu.vcare.Utils;
import com.parse.ParseObject;
import com.parse.ParsePush;

public class EventCreateAsyncTask  extends AsyncTask<Events, Void, Boolean>{
	
	private Context context;
	private ProgressDialog pdia;
	private Events event;

	public EventCreateAsyncTask(Context context) {
		this.context = context;
	}
	
	@Override
	protected void onPreExecute(){ 
	   super.onPreExecute();
	        pdia = new ProgressDialog(context);
	        pdia.setMessage("Fetching...");
	        pdia.show();    
	}

	@Override
	protected Boolean doInBackground(Events... params) {
		// TODO Auto-generated method stub
		event = params[0];
		ParseObject orgStore = new ParseObject("EventStore");
        orgStore.put("address", event.getAddress()); 
        orgStore.put("startDate", event.getStartDate());
        orgStore.put("endDate", event.getEndDate());
        orgStore.put("eventDescription", event.getEventDescription());
        orgStore.put("eventName", event.getEventName());
        orgStore.put("organizationID", event.getOrganizationID());
        orgStore.put("organizerID", event.getOrganizerID());//mobileNumber
        orgStore.saveInBackground();
		return true;
		
	}
	
	@Override
	protected void onPostExecute(Boolean result) {
		// TODO Auto-generated method stub
		// goto HomePage
		super.onPostExecute(result);
		try {
			Utils.showDialog("Event Registered ", context);
				
			/*send push notification*/
			
			ParsePush push = new ParsePush();
			push.setChannel("vcare");
			push.setMessage("Humanity Event :"+event.getEventName()+" at "+event.getAddress());
			push.sendInBackground();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Intent in = new Intent(context, Event_Success.class);
		context.startActivity(in);
		// startActivity();
	}

}
