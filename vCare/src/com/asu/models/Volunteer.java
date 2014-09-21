package com.asu.models;

public class Volunteer {
	private String eventName;
	private String voluteerID; //mobile number of participant
	private String eventID; // which is nothing but oraganizers id
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getVoluteerID() {
		return voluteerID;
	}
	public void setVoluteerID(String voluteerID) {
		this.voluteerID = voluteerID;
	}
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
}
