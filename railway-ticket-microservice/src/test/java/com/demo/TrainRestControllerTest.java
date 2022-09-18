package com.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.entity.Train;
import com.demo.entity.TrainBooking;
import com.demo.repository.TrainBookingRepository;
import com.demo.repository.TrainRepository;
import com.demo.rest.TrainRestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TrainRestControllerTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	TrainBookingRepository trainRepo;

	@MockBean
	TrainRepository searchRepo;

	@InjectMocks
	TrainRestController trc;

	// ------------------------TEST SEARCH TRAIN ROUTES & GET ALL STATIONS-------------------------------------------------------------------------
	@Test
	void testSearchRoute() throws Exception {
		List<Train> user = new ArrayList<>();
		user.add(new Train(18843, "Rajdhani Express", "Bhadrak, Tatanagar, Kanpur, Bokaro", "Bhubaneswar",
				"Delhi", "13-10-2022", "7:15", "8:00", 98));
		Mockito.when(searchRepo.findBySearch("Bhubaneswar", "Delhi")).thenReturn(user);

		mvc.perform(get("/train/search/{source}/{destination}", "Bhubaneswar", "Delhi")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	// ------------------TEST ADD BUS BOOKING-----------------------------
	@Test
	void testAddTrainBookingDetails() throws Exception {
		Mockito.when(searchRepo.findById(18843)).thenReturn(Optional.of(new Train(18843, "Rajdhani Express",
				"Bhadrak, Tatanagar, Kanpur, Bokaro", "Bhubaneswar", "Delhi", "13-10-2022", "7:15", "8:00", 98)));

		TrainBooking train = new TrainBooking(3003 ,1002, 1, 18843, "BBSR Railway Station", "New Delhi Railway Station", "13-10-2022");
		String trainAsJsonStr = new ObjectMapper().writeValueAsString(train);

		mvc.perform(post("/train/booking/add/{trainNumber}", 18843)
				.accept(MediaType.APPLICATION_JSON)
				.content(trainAsJsonStr)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andDo(print());
		// .andExpect(jsonPath("$.firstName").value("Akankshya"));

	}
	
	// -----------------------------TEST LIST OF BOOKED TICKETS-----------------------------------------------------------------
	@Test
	void testGetAllUserListBookings() throws Exception {
		List<TrainBooking> user = new ArrayList<>();
		user.add(new TrainBooking(3003 ,1002, 1, 18843, "BBSR Railway Station", "New Delhi Railway Station", "13-10-2022"));
		Mockito.when(trainRepo.findByUserId(1002)).thenReturn(user);

		mvc.perform(get("/train/listbookings/{userid}", 1002)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}
	
	//-----------------------TEST UPDATE BOOKING DETAILS----------------------------------------------------------------
	@Test
	void testUpdateUser() throws Exception {
		TrainBooking train = new TrainBooking(3003 ,1002, 1, 18843, "BBSR Railway Station", "New Delhi Railway Station", "13-10-2022");
		Mockito.when(trainRepo.findById(1002)).thenReturn(Optional.of(train));

		ObjectMapper om = new ObjectMapper();
		String value = om.writeValueAsString(train);
			
		mvc.perform(put("/train/booking/update")
				.contentType(MediaType.APPLICATION_JSON).content(value))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andDo(print());

		}

}
