package com.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bloodbank.entity.Blood;
import com.bloodbank.repository.BloodRepository;

@Service
public class BloodService {
	
	@Autowired
	private BloodRepository bloodRepository;
	
	public List<Blood> getAllBloodGroups() {
		return bloodRepository.findAll(Sort.by("bloodGroup"));
	}
	
	@Transactional
	public Blood addBloodGroup(Blood blood) {
		return bloodRepository.saveAndFlush(blood);
	}
	
}
