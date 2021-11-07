package com.bloodbank.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "donor")
@NamedStoredProcedureQueries({
	   @NamedStoredProcedureQuery(name = "getEligibleDonors", 
							       procedureName = "getEligibleDonors",
							       resultClasses = {Donor.class}
			   					)
	})
public class Donor {
	
	@Id
	@Column(name = "aadhar_id", unique = true)
	@NotNull
	private String aadharId;
	@Column(name = "name")
	@NotNull
	private String name;
	@Column(name = "email")
	@NotNull
	private String email;
	@Column(name = "mobile")
	@NotNull
	private String mobile;
	@Column(name = "dob")
	@NotNull
	private Date dob;
	
	@ManyToOne
	@JoinColumn(name = "blood_group", referencedColumnName = "blood_group", nullable = false)
	@NotNull
	private Blood bloodGroup;

	public String getAadharId() {
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Blood getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(Blood bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
}
