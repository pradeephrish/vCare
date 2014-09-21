package com.asu.dao;

import com.asu.models.User;
import com.asu.vcare.CreateOrganization;
import com.asu.vcare.Register;
import com.parse.ParseObject;

import android.content.Intent;
import android.os.AsyncTask;

public class UserRegistration extends AsyncTask<User, Integer, Integer>{

	@Override
	protected Integer doInBackground(User... users) {
		/*
		users.get
		// TODO Auto-generated method stub
		ParseObject gameScore = new ParseObject("UserStore");
        gameScore.put("score", user.getMobileNumber());
        gameScore.put("zipCode", user.getZipCode());
        gameScore.put("name", user.getName());
        gameScore.put("emailID", user.getEmailID());
        gameScore.put("badgeCompassion", user.getBadgeCompassion());
        gameScore.put("badgeKindness", user.getBadgeKindness());
        gameScore.put("badgeRespect", user.getBadgeRespect());
        gameScore.put("badgeSelfReflection", user.getBadgeSelfReflection());
        gameScore.saveInBackground();
        return 1;
        */
		return 1;
	}
	
	@Override
	protected void onPostExecute(Integer result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		//goto HomePage
	//	Intent in = new Intent(Register.this, CreateOrganization.class);
	//	startActivity(in);
	}

}
