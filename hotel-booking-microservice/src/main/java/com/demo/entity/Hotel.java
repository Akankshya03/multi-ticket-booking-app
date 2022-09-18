package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HOTEL_INFO")
public class Hotel {
	
	@Id
	private int hotelId;
	private String hotelName;
	private String city;
	private String address;
	private String phoneNumber;
	private String email;
	 
	
	public Hotel() {
		
	}

	public Hotel(int hotelId, String hotelName, String city, String address, String phoneNumber, String email) {
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.city = city;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

}
