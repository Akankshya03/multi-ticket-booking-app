package com.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Hotel;
import com.demo.entity.HotelBooking;
import com.demo.entity.Room;
import com.demo.repository.HotelBookingRepository;
import com.demo.repository.HotelRepository;
import com.demo.repository.RoomRepository;
import com.demo.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelRestController {

	@Autowired
	HotelRepository hotelRepo;

	@Autowired
	HotelBookingRepository bookingRepo;

	@Autowired
	RoomRepository roomRepo;

	@Autowired
	HotelService hotelService;

	// --------------------------SEARCH HOTELS---------------------------------------
	@GetMapping(path = "/search/{city}/{hotelName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Hotel>> getAllHotelsList(@PathVariable("city") String city,
			@PathVariable("hotelName") String hotelName) {
		return new ResponseEntity<>(hotelService.getAllHotelsList(city, hotelName), HttpStatus.OK);

	}

	// ----------------List Rooms in Hotel --------------------------------------------------------------------
	@GetMapping(path = "/room/{hotelId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Room>> getRoomDetails(@PathVariable("hotelId") int hotelId) {
		return new ResponseEntity<>(hotelService.getRoomDetails(hotelId), HttpStatus.OK);
		
	}

	// ----------------------------Hotel Room Booking-------------------------------------------------------------
	@PostMapping(path = "/booking/add/{roomType}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBookingDetails(@RequestBody HotelBooking hotel,
			@PathVariable("roomType") String roomType) {
		return new ResponseEntity<>(hotelService.addBookingDetails(hotel, roomType), HttpStatus.OK);
	}

	// --------------get hotel booking details by user id------------------------------------------------------------------
	@GetMapping(path = "/listbookings/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HotelBooking>> getAllHotelBookings(@PathVariable("userId") int userId) {
		return new ResponseEntity<>(hotelService.getAllHotelBookings(userId), HttpStatus.OK);

	}

}
