package com.demo.dto;

public class UserDto {


	private int userId;
	private String firstName;
	private String lastName;
	private String country;
	private String state;
	private String district;
	private String email;
	private String mobileNumber;
	private boolean isLoggedIn;


	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public UserDto() {

	}

	public UserDto(int userId, String firstName, String lastName, String country, String state, String district,
			String email, String mobileNumber) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.state = state;
		this.district = district;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	
	public UserDto(int userId, String firstName, String lastName, String country, String state, String district, String email, String mobileNumber, boolean isLoggedIn) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.state = state;
		this.district = district;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.isLoggedIn = isLoggedIn;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
