package com.abc.cabservice.service;

import java.util.List;

import com.abc.cabservice.entity.Cab;
import com.abc.cabservice.exception.ResourceNotFoundException;
import com.abc.cabservice.model.CabResponse;


public interface CabService {
	
	public Cab addCab(Cab cab);

	public Cab updateCab(Cab cab) throws ResourceNotFoundException;
	
	public void deleteCab(int cabId) ;
	
	List<CabResponse> getAllCabs();

	public List<String> viewCabsOfType(String carType) throws ResourceNotFoundException;

	public int countCabsOfType() throws ResourceNotFoundException;
}