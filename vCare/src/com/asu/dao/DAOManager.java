package com.asu.dao;

import java.util.ArrayList;
import java.util.List;

import android.provider.ContactsContract.CommonDataKinds.Event;
import android.util.Log;

import com.asu.models.Organization;
import com.asu.models.User;
import com.asu.models.Events;
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
	
	
	public DAOManager(){
		
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
	                user.setBadgeKindness(userList.get(0).getInt("badgeKindness"));
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
	
	public  List<Events> get(String userID){
		List<Events> eventStore = new ArrayList<Events>();
		 ParseQuery<ParseObject> query = ParseQuery.getQuery("EventStore");
		 query.whereEqualTo("organizerID", userID);
		 List<ParseObject> eventParseObject;
		try {
			eventParseObject = query.find();
			if(eventParseObject.size() > 0 ){ //should be great than 0
				 //should be equal to one
	                Log.d("events", "Retrieved " + eventParseObject.size() + " events");
	                for (int i = 0; i < eventParseObject.size(); i++) {
	                	Events  event = new Events();
	  	                event.setAddress(eventParseObject.get(i).getString("address"));
	  	                event.setStartDate(eventParseObject.get(i).getDate("startDate"));
	  	                event.setEndDate(eventParseObject.get(i).getDate("endDate"));
	  	                event.setEventDescription(eventParseObject.get(i).getString("eventDescription"));
	  	                event.setEventName(eventParseObject.get(i).getString("eventName"));
	  	                event.setOrganizationID(eventParseObject.get(i).getString("organizationID"));
	  	                event.setOrganizerID(userID);
	  	                eventStore.add(event);
					}
			 }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventStore;
	}
	
	public Events createEvent(Events event, String userID){
		ParseObject orgStore = new ParseObject("EventStore");
        orgStore.put("address", event.getAddress()); 
        orgStore.put("startDate", event.getStartDate());
        orgStore.put("endDate", event.getEndDate());
        orgStore.put("eventDescription", event.getEventDescription());
        orgStore.put("eventName", event.getEventName());
        orgStore.put("organizationID", event.getOrganizationID());
        orgStore.put("organizerID", event.getOrganizerID());//mobileNumber
        orgStore.saveInBackground();
		return event;
	}
	
	public Organization createOrganization(Organization organization){
		ParseObject orgStore = new ParseObject("OrganizationStore");
        orgStore.put("score", organization.getOrganizationName()); 
        orgStore.put("zipCode", organization.getEmailID());
        orgStore.put("name", organization.getAddress());
        orgStore.put("emailID", organization.getContactNumber());
        orgStore.put("badgeCompassion", organization.getDescription());
        orgStore.saveInBackground();
		return organization;
	}
	
	public User registerUser(User user){
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
        return user;
	}
	
	public List<Event> getNearbyDetails(String locationDetails){
		return null;
	}
	
}
