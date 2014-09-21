package com.asu.session;

import java.util.List;

import com.asu.models.Events;
import com.asu.models.User;

public class CurrentSession {
	private static List<Events> listOfEvens;
	private static String currentUserID; //mobile number
	private static User user;

	public static List<Events> getListOfEvens() {
		return listOfEvens;
	}

	public static void setListOfEvens(List<Events> listOfEvens) {
		CurrentSession.listOfEvens = listOfEvens;
	}

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
}
