package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
	
	@Query("select r from Room r where r.roomType=?1 ")
	public Room findByRoomType(String roomType);

	@Query("select r from Room r where r.hotelId=?1")
	public List<Room> findByHotelId(int hotelId);

}
