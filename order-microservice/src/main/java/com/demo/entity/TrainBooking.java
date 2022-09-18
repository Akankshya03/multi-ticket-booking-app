package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRAIN_BOOKINGS")
public class TrainBooking {
	
	@Id
	private int bookingId;
	private int userId;
	private int tickets;
	private int trainNumber;
	private String boardingStation;
	private String droppingStation;
	private String date;
	
	public TrainBooking() {
		
	}

	public TrainBooking(int bookingId, int userId, int tickets, int trainNumber, String boardingStation,
			String droppingStation, String date) {
		this.bookingId = bookingId;
		this.userId = userId;
		this.tickets = tickets;
		this.trainNumber = trainNumber;
		this.boardingStation = boardingStation;
		this.droppingStation = droppingStation;
		this.date = date;
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

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getBoardingStation() {
		return boardingStation;
	}

	public void setBoardingStation(String boardingStation) {
		this.boardingStation = boardingStation;
	}

	public String getDroppingStation() {
		return droppingStation;
	}

	public void setDroppingStation(String droppingStation) {
		this.droppingStation = droppingStation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}	

}
