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

import com.demo.entity.Train;
import com.demo.entity.TrainBooking;
import com.demo.repository.TrainBookingRepository;
import com.demo.repository.TrainRepository;
import com.demo.service.TrainService;

@RestController
@RequestMapping("/train")
public class TrainRestController {
	
	@Autowired
	TrainRepository searchRepo;
	
	@Autowired
	TrainBookingRepository trainRepo;
	
	@Autowired
	TrainService trainService;
	
	@GetMapping(path = "/search/{source}/{destination}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Train>> getAllTrainInformations(@PathVariable("source") String source, @PathVariable("destination") String destination ) {
        return new ResponseEntity<>(trainService.getAllTrainInformations(source,destination), HttpStatus.OK);
        
    }
	
	@PostMapping(path = "/booking/add/{trainNumber}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBookingDetails(@RequestBody TrainBooking train, @PathVariable("trainNumber") int trainNumber) {
		return new ResponseEntity<>(trainService.addBookingDetails(train, trainNumber), HttpStatus.OK);

	}

	@PutMapping(path = "/booking/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateBookingDetails(@RequestBody TrainBooking train) {
		return new ResponseEntity<>(trainService.updateBookingDetails(train), HttpStatus.OK);

	}

	@GetMapping(path = "/listbookings/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrainBooking>> getTrainBookings(@PathVariable("userId") int userId) {
        return new ResponseEntity<>(trainService.getTrainBookings(userId), HttpStatus.OK);

    }
	

}
