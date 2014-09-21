package com.asu.models;

public class User {
	private String name;
	private String mobileNumber;
	private String emailID;
	private String zipCode;
	private Integer badgeRespect;
	private Integer badgeKindness;
	private Integer badgeSelfReflection;
	private Integer badgeCompassion;
	
	public Integer getBadgeRespect() {
		return badgeRespect;
	}
	public void setBadgeRespect(Integer badgeRespect) {
		this.badgeRespect = badgeRespect;
	}
	public Integer getBadgeKindness() {
		return badgeKindness;
	}
	public void setBadgeKindness(Integer badgeKindness) {
		this.badgeKindness = badgeKindness;
	}
	public Integer getBadgeSelfReflection() {
		return badgeSelfReflection;
	}
	public void setBadgeSelfReflection(Integer badgeSelfReflection) {
		this.badgeSelfReflection = badgeSelfReflection;
	}
	public Integer getBadgeCompassion() {
		return badgeCompassion;
	}
	public void setBadgeCompassion(Integer badgeCompassion) {
		this.badgeCompassion = badgeCompassion;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}
