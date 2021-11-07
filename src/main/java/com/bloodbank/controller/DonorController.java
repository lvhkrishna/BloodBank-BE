package com.bloodbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.entity.Donor;
import com.bloodbank.service.DonorService;

@RestController
public class DonorController {
	
	@Autowired
	private DonorService donorService;
	
	@GetMapping("/donors")
	public List<Donor> getAll() {
		return donorService.getAllDonors();
	}
	
	@GetMapping("/eligibledonors")
	public List<Donor> getEligibleDonors() {
		return donorService.getEligibleDonors();
	}

}
