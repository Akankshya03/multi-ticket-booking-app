package com.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

import com.demo.entity.Hotel;
import com.demo.entity.HotelBooking;
import com.demo.entity.Room;
import com.demo.repository.HotelBookingRepository;
import com.demo.repository.HotelRepository;
import com.demo.repository.RoomRepository;
import com.demo.rest.HotelRestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HotelRestControllerTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	HotelRepository hotelRepo;

	@MockBean
	RoomRepository roomRepo;

	@MockBean
	HotelBookingRepository bookingRepo;

	@InjectMocks
	HotelRestController trc;

	// ------------------------TEST SEARCH TRAIN ROUTES & GET ALL
	// STATIONS-------------------------------------------------------------------------
	@Test
	void testSearchHotel() throws Exception {
		List<Hotel> user = new ArrayList<>();
		user.add(new Hotel(1018849, "Mayfair", "Bhubaneswar", "Jaydev Vihar", "3759258373", "mayfair1@gmail.com"));
		Mockito.when(hotelRepo.findByHotel("Bhubaneswar", "Mayfair")).thenReturn(user);

		mvc.perform(get("/hotel/search/{city}/{hotelName}", "Bhubaneswar", "Mayfair").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	// -------------------------TEST LIST OF ROOMS IN
	// HOTEL---------------------------------------
	@Test
	void testListRooms() throws Exception {
		List<Room> user = new ArrayList<>();
		user.add(new Room(201, 1018849, "Non AC Standard Room", 500, 100));
		Mockito.when(roomRepo.findByHotelId(1018849)).thenReturn(user);

		mvc.perform(get("/hotel/room/{hotelId}", 1018849).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	// ------------------TEST ADD Hotel BOOKING-----------------------------
	@Test
	void testAddHotelBooking() throws Exception {
		Mockito.when(roomRepo.findByRoomType("Non AC Standard Room"))
				.thenReturn(new Room(201, 1018849, "Non AC Standard Room", 500, 100));

		HotelBooking hotel = new HotelBooking(2001, 1001, 1018849, "Non AC Standard Room", "12-12-2022", 1, 4,
				"16-12-2022", 4);
		String hotelAsJsonStr = new ObjectMapper().writeValueAsString(hotel);

		mvc.perform(post("/hotel/booking/add/{roomType}", "Non AC Standard Room").accept(MediaType.APPLICATION_JSON)
				.content(hotelAsJsonStr).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
		// .andExpect(jsonPath("$.firstName").value("Akankshya"));

	}

	// -----------------------------TEST LIST OF BOOKED
	// TICKETS-----------------------------------------------------------------
	@Test
	void testGetAllHotelBookings() throws Exception {
		List<HotelBooking> user = new ArrayList<>();
		user.add(new HotelBooking(2001, 1001, 1018849, "Non AC Standard Room", "12-12-2022", 1, 4, "16-12-2022", 4));
		Mockito.when(bookingRepo.findByUserId(1001)).thenReturn(user);

		mvc.perform(get("/hotel/listbookings/{userId}", 1001).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

}
