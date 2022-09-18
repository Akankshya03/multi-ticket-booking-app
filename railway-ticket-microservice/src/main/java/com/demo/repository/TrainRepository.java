package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entity.Train;

public interface TrainRepository extends JpaRepository<Train, Integer> {
	
	@Query("select search from Train search where search.source = ?1 and search.destination = ?2")
	public List<Train> findBySearch(String source, String destination);

}
