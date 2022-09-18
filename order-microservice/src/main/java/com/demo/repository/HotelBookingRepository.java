package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.HotelBooking;

@Repository
public interface HotelBookingRepository extends JpaRepository<HotelBooking, Integer>{
	
	@Query("select hb from HotelBooking hb where hb.userId= ?1")
	public List<HotelBooking> findByUserId(int userId);

}
