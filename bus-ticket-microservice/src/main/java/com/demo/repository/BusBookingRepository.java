package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.BusBooking;

@Repository
public interface BusBookingRepository extends JpaRepository<BusBooking, Integer>{
	
	 @Query("select bus from BusBooking bus where bus.userId= ?1")
	    public List<BusBooking> findByUserId(int userId);

}
