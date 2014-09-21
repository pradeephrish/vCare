package com.asu.session;

import java.util.List;

import com.asu.models.Events;
import com.asu.models.User;

public class CurrentSession {
	private static List<Events> listOfAllEvents;
	private static List<Events> listOfMyEvents;
	
	private static String currentUserID; //mobile number
	private static User user;
	private static boolean myflag = false;
	

	public static String getCurrentUserID() {
		return currentUserID;
	}

	public static void setCurrentUserID(String currentUserID) {
		CurrentSession.currentUserID = currentUserID;
	}

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		CurrentSession.user = user;
	}

	public static List<Events> getListOfAllEvents() {
		return listOfAllEvents;
	}

	public static void setListOfAllEvents(List<Events> listOfAllEvents) {
		CurrentSession.listOfAllEvents = listOfAllEvents;
	}

	public static List<Events> getListOfMyEvents() {
		return listOfMyEvents;
	}

	public static void setListOfMyEvents(List<Events> listOfMyEvents) {
		CurrentSession.listOfMyEvents = listOfMyEvents;
	}

	public static boolean isMyflag() {
		return myflag;
	}

	public static void setMyflag(boolean myflag) {
		CurrentSession.myflag = myflag;
	}
}
