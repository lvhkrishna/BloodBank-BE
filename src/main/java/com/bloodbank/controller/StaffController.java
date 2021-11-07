package com.bloodbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.entity.Staff;
import com.bloodbank.service.StaffService;

@RestController
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping("/staff")
	public List<Staff> getAll() {
		return staffService.getStaffDetails();
	}
	
	@GetMapping("/medicalstaff")
	public List<Staff> getMedicalStaff() {
		return staffService.getMedicalStaffDetails();
	}
	
	@GetMapping("/staff/drivers")
	public List<Staff> getDrivers() {
		return staffService.getDriverDetails();
	}
	
	@PostMapping("/staff/add")
	public ResponseEntity<Object> addStaff(@RequestBody Staff staff) {
		try {
			if (staff.getName() == null || staff.getName().isEmpty()
					|| staff.getEmail() == null || staff.getEmail().isEmpty()
					|| staff.getMobile() == null || staff.getMobile().isEmpty()
					|| staff.getPlotNo() == null || staff.getPlotNo().isEmpty()
					|| staff.getStreet() == null || staff.getStreet().isEmpty()
					|| staff.getCity() == null || staff.getCity().isEmpty()
					|| staff.getState() == null || staff.getState().isEmpty()
					|| staff.getPincode() == null || staff.getPincode().isEmpty()) {
				return ResponseEntity.badRequest().body("None of the Staff details can be empty");
			}
			if (staff.getType() != 1 && staff.getType() != 2) {
				return ResponseEntity.badRequest().body("Staff should either be medical or driver");
			}
			if (staff.getType() == 1 && (staff.getDegree() == null || staff.getDegree().isEmpty())) {
				return ResponseEntity.badRequest().body("Medical Staff should have a degree associated");
			}
			if (staff.getType() == 2 &&
					(staff.getLicenseNo() == null || staff.getLicenseNo().isEmpty())) {
				return ResponseEntity.badRequest().body("Driver should have both the Driving license and ambulance associated");
			}
			if (!(staff.getPincode().matches("[0-9]+") && staff.getPincode().length() == 6)) {
				return ResponseEntity.badRequest().body("Pincode should have 6 digits");
			}
			
			int staffId = staffService.addStaff(staff);
			return ResponseEntity.ok(staffId);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body(e);
		}
	}
	
}
