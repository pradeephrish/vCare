package com.asu.dao;

import java.util.List;

import android.provider.ContactsContract.CommonDataKinds.Event;
import android.provider.ContactsContract.CommonDataKinds.Organization;

import com.asu.models.User;

public class DAOManager {
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
