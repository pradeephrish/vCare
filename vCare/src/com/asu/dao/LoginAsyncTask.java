package com.asu.dao;

import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.asu.models.User;
import com.asu.session.CurrentSession;
import com.asu.vcare.MainActivity;
import com.asu.vcare.Utils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class LoginAsyncTask extends AsyncTask<String, Void, User> {
	private Context context;
	private ProgressDialog pdia;

	public LoginAsyncTask(Context context) {
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
	protected User doInBackground(String... params) {
		// TODO Auto-generated method stub
		String userID = params[0];
		User user = new User();
		ParseQuery<ParseObject> query = ParseQuery.getQuery("UserStore");
		query.whereEqualTo("mobileNumber", userID);
		List<ParseObject> userList;
		try {
			userList = query.find();
			if (userList.size() > 0) { // should be great than 0
				// should be equal to one
				Log.d("user", "Retrieved " + userList.size() + " users");
				user.setName(userList.get(0).getString("name"));
				user.setMobileNumber(userID);
				user.setZipCode(userList.get(0).getString("zipCode"));
				user.setEmailID(userList.get(0).getString("emailID"));
				user.setBadgeRespect(userList.get(0).getInt("badgeRespect"));
				user.setBadgeKindness(userList.get(0).getInt("badgeKindness"));
				user.setBadgeCompassion(userList.get(0).getInt(
						"badgeCompassion"));
				user.setBadgeSelfReflection(userList.get(0).getInt(
						"badgeSelfReflection"));
			} else {
				user.setMobileNumber("-1");// could not find user
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pdia.dismiss();
		}
		return user;
	}
	

	@Override
	protected void onPostExecute(User result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (result.getMobileNumber().equals("-1")) {
			try {
				Utils.showDialog("Invalid User", context);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Intent in = new Intent(context, MainActivity.class);
			CurrentSession.setUser(result);
			in.putExtra("name", result.getName());
			in.putExtra("phone", result.getMobileNumber());
			context.startActivity(in);
			//startActivity();
			
		}
	}
}
