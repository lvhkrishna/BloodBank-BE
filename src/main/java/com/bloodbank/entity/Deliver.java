package com.bloodbank.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

@Entity
@Table(name = "deliver")
@NamedStoredProcedureQueries({
	   @NamedStoredProcedureQuery(name = "getPendingRequests", 
							       procedureName = "getPendingRequests",
							       resultClasses = {Deliver.class}
			   					)
	})
public class Deliver {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "request_id")
	private int id;
	@Column(name = "units_delivered")
	private BigDecimal unitsDelivered;
	@Column(name = "blood_group")
	private String bloodGroup;
	@Column(name = "units_needed")
	private BigDecimal unitsNeeded;
	@Column(name = "request_date")
	private Timestamp requestDate;
	@Column(name = "hospital_id")
	private String hospitald;
	@Column(name = "hospital_name")
	private String hospitalName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getUnitsDelivered() {
		return unitsDelivered;
	}
	public void setUnitsDelivered(BigDecimal unitsDelivered) {
		this.unitsDelivered = unitsDelivered;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public BigDecimal getUnitsNeeded() {
		return unitsNeeded;
	}
	public void setUnitsNeeded(BigDecimal unitsNeeded) {
		this.unitsNeeded = unitsNeeded;
	}
	public Timestamp getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}
	public String getHospitald() {
		return hospitald;
	}
	public void setHospitald(String hospitald) {
		this.hospitald = hospitald;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
}
