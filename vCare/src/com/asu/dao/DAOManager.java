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
	
	
	public User getUserDetails(String userID){
		
		return null;
	}
	
	public Organization getOrganizationDetails(String organizationName){
		return null;
	}
	
	public  List<Event> getEventDetails(String userID){
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
