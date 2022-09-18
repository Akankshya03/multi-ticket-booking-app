package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM_INFO")
public class Room {

	@Id
	private int roomNo;
	private int hotelId;
	private String roomType;
	private int price;
	private int roomAvailable=100;

	public Room() {

	}

	public Room(int roomNo, int hotelId, String roomType, int price, int roomAvailable) {
		this.roomNo = roomNo;
		this.hotelId = hotelId;
		this.roomType = roomType;
		this.price = price;
		this.roomAvailable = roomAvailable;
		
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRoomAvailable() {
		return roomAvailable;
	}

	public void setRoomAvailable(int roomAvailable) {
		this.roomAvailable = roomAvailable;
	}
	
	
	

}
