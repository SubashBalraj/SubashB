package com.abc.cabservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.cabservice.entity.Cab;
import com.abc.cabservice.model.CabResponse;
import com.abc.cabservice.service.CabService;

@RestController
@RequestMapping("/cab")
public class CabController {

	@Autowired
	private CabService cabService;

	@PostMapping("/save")
	public ResponseEntity<Cab> saveCab(@RequestBody Cab cab) {
		cabService.addCab(cab);
		ResponseEntity<Cab> responseEntity = new ResponseEntity<>(cab, HttpStatus.CREATED);
		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<Cab> editCab(@RequestBody Cab cab) {
		cabService.updateCab(cab);
		ResponseEntity<Cab> responseEntity = new ResponseEntity<>(cab, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCab(@PathVariable("id") int cabId) {
		String msg = "Successfully deleted";
		cabService.deleteCab(cabId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(msg, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/all")
	public List<CabResponse> getAllCabs() {
		List<CabResponse> cabs = cabService.getAllCabs();
		return cabs;
	}


	@GetMapping("/cabCount")
	public String countCabsOfType() {
		int countCab = cabService.countCabsOfType();

		return "Available cabs " + countCab;
	}

}