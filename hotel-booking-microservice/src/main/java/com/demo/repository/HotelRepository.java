package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	
	@Query("select h from Hotel h where h.city=?1 and h.hotelName=?2")
	public List<Hotel> findByHotel(String city, String hotelName);
	
	

}
