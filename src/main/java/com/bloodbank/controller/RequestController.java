package com.bloodbank.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.entity.Deliver;
import com.bloodbank.entity.Request;
import com.bloodbank.service.RequestService;

@RestController
public class RequestController {

	@Autowired
	private RequestService requestService;
	
	@GetMapping("/request/pending")
	public List<Deliver> getPendingRequests() {
		return requestService.getPendingRequests();
	}
	
	@PostMapping("/request/serve")
	public ResponseEntity<Object> addRequest(@RequestBody Request request) {
		try {
			if (request.getHospitalId() <= 0 || request.getBloodGroup() == null || request.getBloodGroup().isEmpty()
					|| request.getUnitsNeeded().compareTo(BigDecimal.ZERO) <= 0 || request.getDriver() <= 0
					|| request.getAmbulanceNo() == null || request.getAmbulanceNo().isEmpty()) {
				return ResponseEntity.badRequest().body("Invalid data");
			}
			
//			Deliver info = requestService.addRequest(request);
			BigDecimal info = requestService.addRequest(request);
			return ResponseEntity.ok(info);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e);
		}
	}
	
}
