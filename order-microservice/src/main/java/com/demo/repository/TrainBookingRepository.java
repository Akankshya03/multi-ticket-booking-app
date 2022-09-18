package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entity.TrainBooking;

public interface TrainBookingRepository extends JpaRepository<TrainBooking, Integer> {
	
	@Query("select train from TrainBooking train where train.userId= ?1")
    public List<TrainBooking> findByUserId(int userId);

}
