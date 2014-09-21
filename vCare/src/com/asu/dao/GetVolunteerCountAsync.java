package com.asu.dao;

import java.util.ArrayList;
import java.util.List;

import com.asu.models.Events;
import com.asu.models.Volunteer;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class GetVolunteerCountAsync extends AsyncTask<Events, Void, Integer>{

	
	
	@Override
	protected Integer doInBackground(Events... params) {
		// TODO Auto-generated method stub
		
		Events event = params[0];
		String keyOne = event.getOrganizerID();
		String keyTwo = event.getEventName();
		Integer count = 0;
		List<Volunteer> eventStore = new ArrayList<Volunteer>();
		 ParseQuery<ParseObject> query = ParseQuery.getQuery("VolunteerStore");
		 query.whereEqualTo("eventName", keyTwo);
		 query.whereEqualTo("eventID", keyOne);
		 List<ParseObject> eventParseObject;
		try {
			eventParseObject = query.find();
			count = eventParseObject.size();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;

		
	}

}
