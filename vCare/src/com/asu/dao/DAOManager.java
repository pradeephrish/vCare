package com.asu.dao;

import java.util.List;

import android.provider.ContactsContract.CommonDataKinds.Event;
import android.provider.ContactsContract.CommonDataKinds.Organization;
import android.util.Log;

import com.asu.models.User;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class DAOManager {
	
	/*
	 * ParseObject gameScore = new ParseObject("GameScore");
        gameScore.put("score", 1337);
        gameScore.put("playerName", "Sean Plott");
        gameScore.put("cheatMode", false);
        gameScore.saveInBackground();
        
        String objectID = gameScore.getObjectId();
		
        ParseQuery<ParseObject> query = ParseQuery.getQuery("GameScore");
        query.whereEqualTo("playerName", "Sean Plott");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
                    for (int i = 0; i < scoreList.size(); i++) {
                    	System.out.println("Cheat Mode is ");
						System.out.println(scoreList.get(i).get("cheatMode"));
					}
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
	 */
	
	private DAOManager daoManager = null;  
	private DAOManager(){
		
	}
	
	public synchronized DAOManager getInstance(){
		if(daoManager == null)
			daoManager =  new DAOManager();
		
		return daoManager;
	}
	
	//userID means mobile Number
	public User getUserDetails(final String userID){
		 User user = new User();
		 ParseQuery<ParseObject> query = ParseQuery.getQuery("UserStore");
		 query.whereEqualTo("mobileNumber", userID);
		 List<ParseObject> userList;
		try {
			userList = query.find();
			if(userList.size() > 0 ){ //should be great than 0
				 //should be equal to one
	                Log.d("user", "Retrieved " + userList.size() + " users");
	                user.setName(userList.get(0).getString("name"));
	                user.setMobileNumber(userID);
	                user.setZipCode(userList.get(0).getString("zipCode"));
	                user.setEmailID(userList.get(0).getString("emailID"));
	                user.setBadgeRespect(userList.get(0).getInt("badgeRespect"));
	                user.setBadgeKindness(userList.get(0).getInt("badgeRespect"));
	                user.setBadgeCompassion(userList.get(0).getInt("badgeCompassion"));
	                user.setBadgeSelfReflection(userList.get(0).getInt("badgeSelfReflection"));
			 }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		/*
	      query.findInBackground(new FindCallback<ParseObject>() {
	            public void done(List<ParseObject> userList, ParseException e) {
	                if (e == null) {
	                	User user = new User();
	                    Log.d("user", "Retrieved " + userList.size() + " users");
	                    user.setName(userList.get(0).getString("name"));
	                    user.setMobileNumber(userID);
	                    user.setZipCode(userList.get(0).getString("zipCode"));
	                    user.setEmailID(userList.get(0).getString("emailID"));
	                    user.setBadgeRespect(userList.get(0).getInt("badgeRespect"));
	                    user.setBadgeKindness(userList.get(0).getInt("badgeRespect"));
	                    user.setBadgeCompassion(userList.get(0).getInt("badgeCompassion"));
	                    user.setBadgeSelfReflection(userList.get(0).getInt("badgeSelfReflection"));     
	                } else {
	                    Log.d("score", "Error: " + e.getMessage());
	                }
	            }
	        });*/
	}
	
	public Organization getOrganizationDetails(String organizationName){
		return null;
	}
	
	public  List<Event> 	get(String userID){
		return null;
	}
	
	public Event createEvent(Event event, String userID){
		return event;
	}
	
	public Organization createOrganization(Organization organization){
		return organization;
	}
	
	public boolean registerUser(User user){
		return false;
	}
	
	public List<Event> getNearbyDetails(String locationDetails){
		return null;
	}
	
}
