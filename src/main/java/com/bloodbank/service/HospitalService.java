package com.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bloodbank.entity.Hospital;
import com.bloodbank.repository.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	public List<Hospital> getHospitals() {
		return hospitalRepository.findAll(Sort.by("name"));
	}
	
}
