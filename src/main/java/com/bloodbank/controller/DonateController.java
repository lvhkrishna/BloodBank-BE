package com.bloodbank.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.entity.Donate;
import com.bloodbank.service.DonateService;

@RestController
public class DonateController {
	
	@Autowired
	private DonateService donateService;
	
	@PostMapping("/donation/add")
	public ResponseEntity<Object> addDonation(@RequestBody Donate donate) {
		try {
			if (donate.getDonorAadharId() == null || donate.getDonorAadharId().isEmpty()
					|| donate.getStaffId() < 0) {
				return ResponseEntity.badRequest().body("Donor or Staff cannot be empty");
			}
			if (donate.getTestResult() && (donate.getDonatedUnits().compareTo(BigDecimal.ZERO) <= 0
					|| donate.getDonatedUnits().compareTo(BigDecimal.valueOf(3)) > 0)) {
				return ResponseEntity.badRequest().body("Donor cannot donate <= 0 or > 3 units at a time");
			}
			int donateId = donateService.addDonation(donate);
			return ResponseEntity.ok(donateId);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e);
		}
	}

}
