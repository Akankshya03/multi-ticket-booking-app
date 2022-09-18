package com.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.demo.entity.AllBookings;
import com.demo.entity.BusBooking;
import com.demo.entity.HotelBooking;
import com.demo.entity.TrainBooking;
import com.demo.entity.User;
import com.demo.repository.BusBookingRepository;
import com.demo.repository.HotelBookingRepository;
import com.demo.repository.TrainBookingRepository;
import com.demo.repository.UserRepository;
import com.demo.rest.OrderRestController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OrderRestControllerTest {
	
	@Autowired
	MockMvc mvc;

	@MockBean
	UserRepository userRepo;

	@MockBean
	BusBookingRepository busRepo;

	@MockBean
	TrainBookingRepository trainRepo;
	
	@MockBean
	HotelBookingRepository bookingRepo;

	@InjectMocks
	OrderRestController orc;
	
	// -----------------------------TEST LIST OF BOOKED
		// TICKETS-----------------------------------------------------------------
		@Test
		void testGetAllBookings() throws Exception {
			
			List<BusBooking> bus = new ArrayList<>();
			bus.add(new BusBooking(2001, 1001, 2, 6, "22-10-2022", "4:00", "10:00", "Delhi ISBT", "Noida Bus Terminal"));
			Mockito.when(busRepo.findByUserId(1001)).thenReturn(bus);
			
			List<TrainBooking> train = new ArrayList<>();
			train.add(new TrainBooking(3001 ,1001, 1, 16478, "BBSR Railway Station", "Mumbai Central Station", "12-10-2022"));
			Mockito.when(trainRepo.findByUserId(1001)).thenReturn(train);
			
			List<HotelBooking> hotel = new ArrayList<>();
			hotel.add(new HotelBooking(2001, 1001, 1018849, "Non AC Standard Room", "12-12-2022", 1, 4, "16-12-2022", 4));
			Mockito.when(bookingRepo.findByUserId(1001)).thenReturn(hotel);
			
			User user = new User(1001, "Akankshya", "Tripathy", "India", "Odisha", "Khordha", "akankshyat@gmail.com",
					"7893892988");
			Mockito.when(userRepo.findById(1001)).thenReturn(Optional.of(user));
			
			AllBookings allbooking =new AllBookings(bus,hotel,train,user);

			mvc.perform(get("/order/listbookings/{userId}", 1001).accept(MediaType.APPLICATION_JSON)).andDo(print())
					.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

		}


}
