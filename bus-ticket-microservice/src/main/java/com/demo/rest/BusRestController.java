package com.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Bus;
import com.demo.entity.BusBooking;
import com.demo.repository.BusBookingRepository;
import com.demo.service.BusService;

import io.micrometer.core.annotation.Timed;


@RestController
@RequestMapping("/bus")
public class BusRestController {

	@Autowired
	BusBookingRepository busRepo;

	@Autowired
	BusService busService;

	//---------------------------searching the bus routes available on a particular date-----------------------------------------
	@GetMapping(path = "/search/{source}/{destination}",produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed(value="app_searchBuses")
    public ResponseEntity<List<Bus>> getAllBusRoutes(@PathVariable("source") String source, @PathVariable("destination") String destination ) {
        return new ResponseEntity<>(busService.getAllBusRoutes(source,destination), HttpStatus.OK);
        
    }
	
	//------------------------------- Adding bus seat booking details for the user--------------------------------------------
	@PostMapping(path = "/booking/add/{routeNo}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBookingDetails(@RequestBody BusBooking bus, @PathVariable("routeNo") int routeNo) {
		return new ResponseEntity<>(busService.addBookingDetails(bus, routeNo), HttpStatus.OK);

	}

	//------------------------------ Updating the bus booking details for the user---------------------------------------------------
	@PutMapping(path = "/booking/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateBookingDetails(@RequestBody BusBooking bus) {
		return new ResponseEntity<>(busService.updateBookingDetails(bus), HttpStatus.OK);

	}

	@GetMapping(path = "/bus/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getBoardingPoints(@PathVariable("bookingId") int bookingId) {
		return new ResponseEntity<>(busService.getDetails(bookingId), HttpStatus.OK);

	}

	//-----------------------------------------user list of bus ticket bookings-----------------------------------------------------------
	@GetMapping(path = "/listbookings/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BusBooking>> getBusBookings(@PathVariable("userId") int userId) {
        return new ResponseEntity<>(busRepo.findByUserId(userId), HttpStatus.OK);
    }

}
