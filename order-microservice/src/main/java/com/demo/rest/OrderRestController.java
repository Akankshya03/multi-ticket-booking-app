package com.demo.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.AllBookings;
import com.demo.entity.User;
import com.demo.repository.BusBookingRepository;
import com.demo.repository.HotelBookingRepository;
import com.demo.repository.TrainBookingRepository;
import com.demo.repository.UserRepository;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/order")
public class OrderRestController {
	
	@Autowired
	BusBookingRepository busRepo;
	
	@Autowired
	TrainBookingRepository trainRepo;
	
	@Autowired
	HotelBookingRepository bookingRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	@GetMapping(path = "/listbookings/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed(value="app_listBookings")
	public ResponseEntity<AllBookings> findAllBookings(@PathVariable int userId){
		AllBookings bookings = new AllBookings();
		Optional<User> user= userRepo.findById(userId);
		
		bookings.setBus(busRepo.findByUserId(userId));
		bookings.setHotel(bookingRepo.findByUserId(userId));
		bookings.setTrain(trainRepo.findByUserId(userId));
		
		if(user.isPresent()) {
		bookings.setUser(userRepo.findById(userId).get());
		}
		return ResponseEntity.ok(bookings);
	}

}
