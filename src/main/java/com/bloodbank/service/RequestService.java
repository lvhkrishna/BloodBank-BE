package com.bloodbank.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.entity.Deliver;
import com.bloodbank.entity.Request;
import com.bloodbank.entity.Staff;

@Service
public class RequestService {

	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Deliver> getPendingRequests() {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("getPendingRequests");
		List<Deliver> details = query.getResultList();
		return details;
	}
	
	@Transactional
	public BigDecimal addRequest(Request request) {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("serveDonationRequest")
						.setParameter("hospital_id", request.getHospitalId())
						.setParameter("blood_group", request.getBloodGroup())
						.setParameter("units_needed", request.getUnitsNeeded())
						.setParameter("driver_id", request.getDriver())
						.setParameter("ambulance_no", request.getAmbulanceNo());
//		List<Deliver> deliveryInfo = query.getResultList();
//		Deliver val = deliveryInfo.get(0);
		BigDecimal val = (BigDecimal) query.getSingleResult();
		return val;
	}
	
}
