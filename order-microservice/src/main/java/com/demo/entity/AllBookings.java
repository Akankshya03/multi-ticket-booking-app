package com.demo.entity;

import java.util.List;

public class AllBookings {
	List<BusBooking> bus;
	List<HotelBooking> hotel;
	List<TrainBooking> train;
	User user;
	
	public AllBookings() {
		
	}

	public AllBookings(List<BusBooking> bus, List<HotelBooking> hotel, List<TrainBooking> train, User user) {
		this.bus = bus;
		this.hotel = hotel;
		this.train = train;
		this.user = user;
	}

	public List<BusBooking> getBus() {
		return bus;
	}

	public void setBus(List<BusBooking> bus) {
		this.bus = bus;
	}

	public List<HotelBooking> getHotel() {
		return hotel;
	}

	public void setHotel(List<HotelBooking> hotel) {
		this.hotel = hotel;
	}

	public List<TrainBooking> getTrain() {
		return train;
	}

	public void setTrain(List<TrainBooking> train) {
		this.train = train;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
