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

import org.hibernate.annotations.Type;

@Entity
@Table(name = "donate")
@NamedStoredProcedureQueries({
	   @NamedStoredProcedureQuery(name = "putDonation", 
	                              procedureName = "putDonation",
	                              parameters = {
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "donor_aadhar_id", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "donated_units", type = BigDecimal.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "staff_id", type = Integer.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "test_result", type = Boolean.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "event_id", type = Integer.class)
	                          }),
//	   @NamedStoredProcedureQuery(name = "getStaffDetails", 
//							       procedureName = "getStaffDetails",
//							       resultClasses = {Staff.class}
//			   					)
	})
public class Donate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "donate_id", unique = true)
	@NotNull
	private int id;
	@Column(name = "donor_aadhar_id")
	@NotNull
	private String donorAadharId;
	@Column(name = "donated_date")
	private Date donatedDate;
	@Column(name = "donated_units")
	private BigDecimal donatedUnits;
	
	@Column(name = "test_id")
	private String testId;
	@Column(name = "staff_id")
	@NotNull
	private int staffId;
	@Column(name = "test_result")
	@NotNull
	private boolean testResult;
	
	@Column(name = "participate_id")
	private String participateId;
	@Column(name = "event_id")
	private int eventId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDonorAadharId() {
		return donorAadharId;
	}
	public void setDonorAadharId(String donorAadharId) {
		this.donorAadharId = donorAadharId;
	}
	public Date getDonatedDate() {
		return donatedDate;
	}
	public void setDonatedDate(Date donatedDate) {
		this.donatedDate = donatedDate;
	}
	public BigDecimal getDonatedUnits() {
		return donatedUnits;
	}
	public void setDonatedUnits(BigDecimal donatedUnits) {
		this.donatedUnits = donatedUnits;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public boolean getTestResult() {
		return testResult;
	}
	public void setTestResult(boolean testResult) {
		this.testResult = testResult;
	}
	public String getParticipateId() {
		return participateId;
	}
	public void setParticipateId(String participateId) {
		this.participateId = participateId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
}
