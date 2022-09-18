package com.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Hotel;
import com.demo.entity.HotelBooking;
import com.demo.entity.Room;
import com.demo.repository.HotelBookingRepository;
import com.demo.repository.HotelRepository;
import com.demo.repository.RoomRepository;

@Service
public class HotelService {

	@Autowired
	HotelRepository hotelRepo;

	@Autowired
	HotelBookingRepository bookingRepo;

	@Autowired
	RoomRepository roomRepo;

	// --------------------------SEARCH HOTELS----------------------------------------------------------------------------------
	public List<Hotel> getAllHotelsList(String city, String hotelName) {
		return hotelRepo.findByHotel(city, hotelName);
	}

	// ----------------List Rooms in Hotel --------------------------
	public List<Room> getRoomDetails(int hotelId) {
		return roomRepo.findByHotelId(hotelId);
	}

	// ----------------------------Hotel Room Booking--------------------------------
	public String addBookingDetails(HotelBooking hotel, String roomType) {
		Room room = roomRepo.findByRoomType(roomType);
		bookingRepo.save(hotel);
		if(hotel.getNumberOfRooms() < room.getRoomAvailable()) {
			room.setRoomAvailable(room.getRoomAvailable() - hotel.getNumberOfRooms());
			return hotel.toString();
		}
		else {
			return "No rooms available";
		}
		
	}

	// --------------get hotel booking details by user id-----------------------------------
	public List<HotelBooking> getAllHotelBookings(int userId) {
		return bookingRepo.findByUserId(userId);
	}

}
