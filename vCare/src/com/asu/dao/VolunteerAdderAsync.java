package com.asu.dao;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.asu.models.Volunteer;
import com.asu.vcare.Settings;
import com.parse.ParseObject;

public class VolunteerAdderAsync extends AsyncTask<Volunteer, Void, Boolean>{
	
	private Context context;
	private ProgressDialog pdia;

	public VolunteerAdderAsync(Context context) {
		this.context = context;
	}
	
	@Override
	protected void onPreExecute(){ 
	   super.onPreExecute();
	        pdia = new ProgressDialog(context);
	        pdia.setMessage("Loading...");
	        pdia.show();    
	}
	
	
	@Override
	protected Boolean doInBackground(Volunteer... params) {
		// TODO Auto-generated method stub
		Volunteer volunteer = params[0];

		try{
		// TODO Auto-generated method stub
		ParseObject parseObject = new ParseObject("VolunteerStore");
		parseObject.put("eventName", volunteer.getEventName());
		parseObject.put("voluteerID", volunteer.getVoluteerID());
		parseObject.put("eventID", volunteer.getEventID());
		parseObject.saveInBackground();
		}catch(Exception e){
			//log 
			e.printStackTrace();
		}finally{
			pdia.dismiss();
		}
		
		return null;
	}
	
	@Override
	protected void onPostExecute(Boolean result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		Toast.makeText(context,
			 	   "Congrats ! You earned badges for Kindness and respect!! :-)", Toast.LENGTH_LONG).show();
	}

}
