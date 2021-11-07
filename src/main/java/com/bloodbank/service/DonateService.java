package com.bloodbank.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.entity.Donate;

@Service
public class DonateService {
	
	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public int addDonation(Donate donate) {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("putDonation")
						.setParameter("donor_aadhar_id", donate.getDonorAadharId())
						.setParameter("donated_units", donate.getDonatedUnits())
						.setParameter("staff_id", donate.getStaffId())
						.setParameter("test_result", donate.getTestResult())
						.setParameter("event_id", donate.getEventId());
		return (Integer) query.getSingleResult();
	}

}
