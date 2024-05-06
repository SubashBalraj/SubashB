package com.abc.cabservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.cabservice.entity.Cab;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {
    
	@Query("select distinct carType from Cab")
	public List<String> viewCarType(String carType);
}

