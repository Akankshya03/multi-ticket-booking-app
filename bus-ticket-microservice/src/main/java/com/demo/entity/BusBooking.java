package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BUS_BOOKING")
public class BusBooking {

	@Id
	private int bookingId;
	private int userId;
	private int ticket;
	private int routeNo;
	private String boardingDate;
	private String boardingTime;
	private String droppingTime;
	private String boardingPoint;
	private String droppingPoint;

	public BusBooking() {

	}

	public BusBooking(int bookingId, int userId, int ticket, int routeNo, String boardingDate, String boardingTime,
			String droppingTime, String boardingPoint, String droppingPoint) {
		this.bookingId = bookingId;
		this.userId = userId;
		this.ticket = ticket;
		this.routeNo = routeNo;
		this.boardingDate = boardingDate;
		this.boardingTime = boardingTime;
		this.droppingTime = droppingTime;
		this.boardingPoint = boardingPoint;
		this.droppingPoint = droppingPoint;
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

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public int getRouteNo() {
		return routeNo;
	}

	public void setRouteNo(int routeNo) {
		this.routeNo = routeNo;
	}

	public String getBoardingDate() {
		return boardingDate;
	}

	public void setBoardingDate(String boardingDate) {
		this.boardingDate = boardingDate;
	}

	public String getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}

	public String getDroppingTime() {
		return droppingTime;
	}

	public void setDroppingTime(String droppingTime) {
		this.droppingTime = droppingTime;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public String getDroppingPoint() {
		return droppingPoint;
	}

	public void setDroppingPoint(String droppingPoint) {
		this.droppingPoint = droppingPoint;
	}

	

}