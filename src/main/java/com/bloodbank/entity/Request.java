package com.bloodbank.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "request")
@NamedStoredProcedureQueries({
	   @NamedStoredProcedureQuery(name = "serveDonationRequest", 
	                              procedureName = "serveDonationRequest",
	                              parameters = {
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "hospital_id", type = Integer.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "blood_group", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "units_needed", type = BigDecimal.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "driver_id", type = Integer.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "ambulance_no", type = String.class)
	                          })
	})
public class Request {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "request_id", unique = true)
	@NotNull
	private int id;
	@Column(name = "hospital_id")
	@NotNull
	private int hospitalId;
	@Column(name = "blood_group", length = 5, unique = true)
	@NotNull
	private String bloodGroup;
	@Column(name = "units_needed", precision=18, scale=3)
	@NotNull
	private BigDecimal unitsNeeded;
	@Column(name = "request_date")
	private Date requestDate;
	@Column(name = "driver")
	@NotNull
	private int driver;
	@Column(name = "ambulance_no")
	@NotNull
	private String ambulanceNo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
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
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public int getDriver() {
		return driver;
	}
	public void setDriver(int driver) {
		this.driver = driver;
	}
	public String getAmbulanceNo() {
		return ambulanceNo;
	}
	public void setAmbulanceNo(String ambulanceNo) {
		this.ambulanceNo = ambulanceNo;
	}
	
}
