package com.bloodbank.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.entity.Staff;

@Service
public class StaffService {
	
	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Staff> getStaffDetails() {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("getStaffDetails");
		@SuppressWarnings("unchecked")
		List<Staff> details = query.getResultList();
		return details;
	}
	
	public List<Staff> getMedicalStaffDetails() {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("getStaffDetails");
		@SuppressWarnings("unchecked")
		List<Staff> details = query.getResultList();
		List<Staff> medicalStaff = details.stream().filter(staff -> (staff.getType() == 1)).collect(Collectors.toList());
		return medicalStaff;
	}
	
	public List<Staff> getDriverDetails() {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("getStaffDetails");
		@SuppressWarnings("unchecked")
		List<Staff> details = query.getResultList();
		List<Staff> medicalStaff = details.stream().filter(staff -> (staff.getType() == 2)).collect(Collectors.toList());
		return medicalStaff;
	}

	@Transactional
	public int addStaff(Staff staff) {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("putAddress")
						.setParameter("plot_no", staff.getPlotNo())
						.setParameter("street", staff.getStreet())
						.setParameter("city", staff.getCity())
						.setParameter("state", staff.getState())
						.setParameter("pincode", staff.getPincode());
		int addressId = (Integer) query.getSingleResult();
		
		query = entityManager.createNamedStoredProcedureQuery("putStaff")
				.setParameter("name", staff.getName())
				.setParameter("email", staff.getEmail())
				.setParameter("mobile", staff.getMobile())
				.setParameter("address_id", addressId)
				.setParameter("type", staff.getType())
				.setParameter("degree", staff.getDegree())
				.setParameter("dl_no", staff.getLicenseNo());
		return (Integer) query.getSingleResult();
	}
	
}
