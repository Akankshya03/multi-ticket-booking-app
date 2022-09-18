package com.demo.entity;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HOTEL_BOOKING")
public class HotelBooking {

	@Id
	private int bookingId;
	private int userId;
	private int hotelId;
	private String roomType;
	private String checkInDate;
	private int numberOfRooms;
	private int numberOfPeople;
	private String checkOutDate;
	private int days;

	public HotelBooking() {

	}

	public HotelBooking(int bookingId, int userId, int hotelId, String roomType, String checkInDate, int numberOfRooms,
			int numberOfPeople, String checkOutDate, int days) {
		this.bookingId = bookingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.roomType = roomType;
		this.checkInDate = checkInDate;
		this.numberOfRooms = numberOfRooms;
		this.numberOfPeople = numberOfPeople;
		this.checkOutDate = checkOutDate;
		this.days = days;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

}
