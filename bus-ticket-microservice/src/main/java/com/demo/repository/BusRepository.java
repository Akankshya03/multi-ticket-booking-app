package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer>{
	
	@Query("select search from Bus search where search.source = ?1 and search.destination = ?2")
	public List<Bus> findBySearch(String source, String destination);

}