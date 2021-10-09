package com.bloodbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.entity.Blood;
import com.bloodbank.service.BloodService;

@RestController
public class BloodController {

	@Autowired
	private BloodService bloodService;
	
	@GetMapping("/blood")
	public List<Blood> getAll() {
		return bloodService.getAllBloodGroups();
	}
	
	@PostMapping("/blood/save")
	public Blood saveBloodGroup(@RequestParam String group) {
		return bloodService.addBloodGroup(new Blood(group));
	}
	
}
