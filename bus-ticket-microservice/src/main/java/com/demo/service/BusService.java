package com.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.BusBooking;
import com.demo.entity.Bus;
import com.demo.repository.BusBookingRepository;
import com.demo.repository.BusRepository;

@Service
public class BusService {

	@Autowired
	BusBookingRepository busRepo;

	@Autowired
	BusRepository searchRepo;

	//------------------------------- Adding bus seat booking details for the user--------------------------------------------
	public String addBookingDetails(BusBooking bus, int routeNo) {
		Bus search = searchRepo.findById(routeNo).get();
		busRepo.save(bus);
		if (bus.getTicket() < search.getSeatsAvailable()) {
			search.setSeatsAvailable(search.getSeatsAvailable() - bus.getTicket());
			searchRepo.save(search);
			return bus.getTicket() + " ticket(s) booked successfully!!";
		} else {
			return "Booking failed! Tickets cannot be booked more than the number of seats available!!";
		}
	}
	

	//------------------------------ Updating the bus booking details for the user---------------------------------------------------
	public String updateBookingDetails(BusBooking bus) {
		busRepo.save(bus);
		return "Booking details for User: " + bus.getUserId() + " has been successfully updated in the database !! ";

	}

	//---------------------------searching the bus routes available on a particular date-----------------------------------------
    public List<Bus> getAllBusRoutes(String source,String destination) {
        return searchRepo.findBySearch(source, destination);
    }

	//------------------------------ Get boarding point and dropping point for the user-----------------------------------------
	public String getDetails(int bookingId) {
		Optional<BusBooking> busOpt = busRepo.findById(bookingId);
		if (busOpt.isPresent()) {
			return "Boarding Point: " + busOpt.get().getBoardingPoint() + " , " + "Dropping Point: "
					+ busOpt.get().getDroppingPoint();
		} else {
			return "No content found!!";
		}
	}

	//-----------------------------------------user list of bus ticket bookings-----------------------------------------------------------
    public List<BusBooking> getBusBookings(int userId) {
        return busRepo.findByUserId(userId);
    }

}
