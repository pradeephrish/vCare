package com.asu.dao;

import java.util.ArrayList;
import java.util.List;

import com.asu.models.Events;
import com.asu.models.User;
import com.asu.session.CurrentSession;
import com.asu.vcare.CustomList;
import com.asu.vcare.EventList;
import com.asu.vcare.MainActivity;
import com.asu.vcare.R;
import com.asu.vcare.Utils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.ProgressDialog;
import android.app.LauncherActivity.ListItem;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

//Fetches events for particular USer or All Events
public class EventFetchAsyncTask extends AsyncTask<String, Void, List<Events>> {

	private Context context;
	private ProgressDialog pdia;
	private List<Events> events;
	private ListView listView;

	public EventFetchAsyncTask(Context context, ListView listView) {
		this.context = context;
		this.listView = listView;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		pdia = new ProgressDialog(context);
		pdia.setMessage("Fetching...");
		pdia.show();
	}

	@Override
	protected List<Events> doInBackground(String... params) {
		// TODO Auto-generated method stub
		String userID = params[0];
		ParseQuery<ParseObject> query = ParseQuery.getQuery("EventStore");

		// if userID is not passed, assume , method is called for all Events
		if (userID != null) {
			query.whereEqualTo("organizerID", userID);
		}

		List<Events> eventStore = new ArrayList<Events>();
		List<ParseObject> eventParseObject;
		try {
			eventParseObject = query.find();
			if (eventParseObject.size() > 0) { // should be great than 0
				// should be equal to one
				Log.d("events", "Retrieved " + eventParseObject.size()
						+ " events");
				for (int i = 0; i < eventParseObject.size(); i++) {
					Events event = new Events();
					event.setAddress(eventParseObject.get(i).getString(
							"address"));
					event.setStartDate(eventParseObject.get(i).getDate(
							"startDate"));
					event.setEndDate(eventParseObject.get(i).getDate("endDate"));
					event.setEventDescription(eventParseObject.get(i)
							.getString("eventDescription"));
					event.setEventName(eventParseObject.get(i).getString(
							"eventName"));
					event.setOrganizationID(eventParseObject.get(i).getString(
							"organizationID"));
					event.setOrganizerID(userID);
					eventStore.add(event);
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pdia.dismiss();
		}
		return eventStore;
	}

	@Override
	protected void onPostExecute(List<Events> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);

		if (listView == null) {
			CurrentSession.setMyflag(false);
			CurrentSession.setListOfAllEvents(result);
			Intent in = new Intent(context, EventList.class);
			context.startActivity(in);
		} else {
			//if listView is referred, it's from UserView / MainActiviy
			
			

		}
	}
}
