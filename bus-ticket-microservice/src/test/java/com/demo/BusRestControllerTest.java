package com.demo;

import static org.mockito.Mockito.when;
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

import com.demo.entity.BusBooking;
import com.demo.entity.Bus;
import com.demo.repository.BusBookingRepository;
import com.demo.repository.BusRepository;
import com.demo.rest.BusRestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BusRestControllerTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	BusBookingRepository bookingRepo;

	@MockBean
	BusRepository searchRepo;

	@InjectMocks
	BusRestController brc;

	// -----------------------------TEST LIST OF BOOKED TICKETS-----------------------------------------------------------------
	@Test
	void testGetAllListBooking() throws Exception {
		List<BusBooking> user = new ArrayList<>();
		user.add(
				new BusBooking(2001, 1001, 2, 6, "22-10-2022", "4:00", "10:00", "Delhi ISBT", "Noida Bus Terminal"));
		Mockito.when(bookingRepo.findByUserId(1001)).thenReturn(user);

		mvc.perform(get("/bus/listbookings/{userId}", 1001).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	// ------------------TEST ADD BUS BOOKING-----------------------------
	@Test
	void testAddBookingDetails() throws Exception {
		Mockito.when(searchRepo.findById(6)).thenReturn(Optional.of(new Bus(6, "OSRTC 6-A", "22-10-2022", "Delhi", "Noida", "4:00", "10:00", 90 )));

		BusBooking bus = new BusBooking(2001, 1001, 2, 6, "22-10-2022", "4:00", "10:00", "Delhi ISBT", "Noida Bus Terminal");
        String busAsJsonStr = new ObjectMapper().writeValueAsString(bus);
		
		mvc.perform(post("/bus/booking/add/{routeNo}",6).accept(MediaType.APPLICATION_JSON).content(busAsJsonStr).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andDo(print());
		// .andExpect(jsonPath("$.firstName").value("Akankshya"));

	}

	// ------------------------TEST SEARCH BUS ROUTES-------------------------------------------------------------------------
	@Test
	void testSearchRoute() throws Exception {
		List<Bus> user = new ArrayList<>();
		user.add(new Bus(2, "OSRTC 2-A", "19-10-2022", "Bhubaneswar", "Mumbai", "4:00", "10:00", 100));
		Mockito.when(searchRepo.findBySearch("Bhubaneswar", "Mumbai")).thenReturn(user);

		mvc.perform(get("/bus/search/{source}/{destination}", "Bhubaneswar", "Mumbai").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}
	
	//-------------------------TEST GET BOARDING POINT AND DROPPING POINT-------------------------------------------------
	@Test
	void testGetBoardingDetails() throws Exception {
		Mockito.when(bookingRepo.findById(1001)).thenReturn(Optional.of(new BusBooking(2001, 1001, 2, 6, "22-10-2022", "4:00", "10:00", "Delhi ISBT", "Noida Bus Terminal")));
		
		
		mvc.perform(get("/bus/bus/{bookingId}",2001).accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		//.andExpect(jsonPath("$.[0].firstName").value("Akankshya"));
		
	}
	
	//-----------------------TEST UPDATE BOOKING DETAILS----------------------------------------------------------------
	@Test
	void testUpdateUser() throws Exception {
		BusBooking bus = new BusBooking(2001, 1001, 2, 6, "22-10-2022", "4:00", "10:00", "Delhi ISBT", "Noida Bus Terminal");
		Mockito.when(bookingRepo.findById(1001)).thenReturn(Optional.of(bus));

		ObjectMapper om = new ObjectMapper();
		String value = om.writeValueAsString(bus);
		
		mvc.perform(put("/bus/booking/update").contentType(MediaType.APPLICATION_JSON).content(value))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());

	}

}
