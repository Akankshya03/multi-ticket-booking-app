package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROUTE_INFO")
public class Bus {

	@Id
	private int routeNo;
	private String busName;
	private String date;
	private String source;
	private String destination;
	private String boardingTime;
	private String droppingTime;
	private int seatsAvailable=100;
	

	public Bus() {

	}


	public Bus(int routeNo, String busName, String date, String source, String destination, String boardingTime,
			String droppingTime, int seatsAvailable) {
		this.routeNo = routeNo;
		this.busName = busName;
		this.date = date;
		this.source = source;
		this.destination = destination;
		this.boardingTime = boardingTime;
		this.droppingTime = droppingTime;
		this.seatsAvailable = seatsAvailable;
	}


	public int getRouteNo() {
		return routeNo;
	}


	public void setRouteNo(int routeNo) {
		this.routeNo = routeNo;
	}


	public String getBusName() {
		return busName;
	}


	public void setBusName(String busName) {
		this.busName = busName;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
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


	public int getSeatsAvailable() {
		return seatsAvailable;
	}


	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	
}
