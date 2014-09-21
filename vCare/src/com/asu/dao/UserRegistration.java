package com.asu.dao;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.asu.models.User;
import com.asu.vcare.LoginActivity;
import com.asu.vcare.MainActivity;
import com.asu.vcare.Utils;
import com.parse.ParseObject;

public class UserRegistration extends AsyncTask<User, Integer, Integer> {

	private Context context;
	private ProgressDialog pdia;

	public UserRegistration(Context context) {
		this.context = context;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		pdia = new ProgressDialog(context);
		pdia.setMessage("Registering...");
		pdia.show();
	}

	@Override
	protected Integer doInBackground(User... users) {
		User user = users[0];
		// TODO Auto-generated method stub
		ParseObject parseObject = new ParseObject("UserStore");
		parseObject.put("mobileNumber", user.getMobileNumber());
		parseObject.put("zipCode", user.getZipCode());
		parseObject.put("name", user.getName());
		parseObject.put("emailID", user.getEmailID());
		parseObject.put("badgeCompassion", user.getBadgeCompassion());
		parseObject.put("badgeKindness", user.getBadgeKindness());
		parseObject.put("badgeRespect", user.getBadgeRespect());
		parseObject.put("badgeSelfReflection", user.getBadgeSelfReflection());
		parseObject.saveInBackground();
		return 1;
	}

	@Override
	protected void onPostExecute(Integer result) {
		// TODO Auto-generated method stub
		// goto HomePage
		super.onPostExecute(result);
		try {
			Utils.showDialog("Registration Successful ", context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Intent in = new Intent(context, LoginActivity.class);
		context.startActivity(in);
		// startActivity();
	}

}
