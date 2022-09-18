package com.demo.dto;

public class LoginDto {
	
	private int userId;
	
	private String mobileNumber;

	public LoginDto(int userId, String mobileNumber) {
		this.userId = userId;
		this.mobileNumber = mobileNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	

}
