package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRAIN_INFO")
public class Train {

	@Id
	private int trainNumber;
	private String trainName;
	private String cities;
	private String source;
	private String destination;
	private String dateFrom;
	private String arrivalTime;
	private String departureTime;
	private int seatsAvailable=100;

	public Train() {
		
	}

	public Train(int trainNumber, String trainName, String cities, String source, String destination,
			String dateFrom, String arrivalTime, String departureTime, int seatsAvailable) {
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.cities = cities;
		this.source = source;
		this.destination = destination;
		this.dateFrom = dateFrom;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seatsAvailable = seatsAvailable;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getCities() {
		return cities;
	}

	public void setCities(String cities) {
		this.cities = cities;
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

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

}