package com.bloodbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.entity.Hospital;
import com.bloodbank.service.HospitalService;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping("/hospitals")
	public List<Hospital> getAll() {
		return hospitalService.getHospitals();
	}
	
}
