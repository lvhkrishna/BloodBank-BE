package com.bloodbank.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bloodbank.entity.Donate;
import com.bloodbank.entity.Donor;
import com.bloodbank.repository.DonorRepository;

@Service
public class DonorService {
	
	@Autowired
	private DonorRepository donorRepository;
	
	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Donor> getAllDonors() {
		return donorRepository.findAll(Sort.by("name"));
	}
	
	@SuppressWarnings("unchecked")
	public List<Donor> getEligibleDonors() {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("getEligibleDonors");
		List<Donor> donors = query.getResultList();
		return donors;
	}
	
}
