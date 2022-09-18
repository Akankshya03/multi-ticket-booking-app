package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Train;
import com.demo.entity.TrainBooking;
import com.demo.repository.TrainBookingRepository;
import com.demo.repository.TrainRepository;

@Service
public class TrainService {

	@Autowired
	TrainBookingRepository trainRepo;

	@Autowired
	TrainRepository searchRepo;

	// ---------------------------searching the bus routes available on a particular
	// date-----------------------------------------
	public List<Train> getAllTrainInformations(String source, String destination) {
		return searchRepo.findBySearch(source, destination);
	}

	// ------------------------------- Adding train seat booking details for the
	// user--------------------------------------------
	public String addBookingDetails(TrainBooking train, int trainNumber) {
		Train search = searchRepo.findById(trainNumber).get();
		trainRepo.save(train);
		if (train.getTickets() < search.getSeatsAvailable()) {
			search.setSeatsAvailable(search.getSeatsAvailable() - train.getTickets());
			searchRepo.save(search);
			return train.getTickets() + " ticket(s) booked successfully!!";

		} else {
			return "Booking failed! Tickets cannot be booked more than the number of seats available!!";
		}

	}

	// ------------------------------ Updating the train booking details for the
	// user---------------------------------------------------
	public String updateBookingDetails(TrainBooking train) {
		trainRepo.save(train);
		return "Booking details for User: " + train.getUserId() + " has been successfully updated in the database !! ";

	}

	// -----------------------------------------user list of train ticket
	// bookings-----------------------------------------------------------
	public List<TrainBooking> getTrainBookings(int userId) {
		return trainRepo.findByUserId(userId);
	}

}
