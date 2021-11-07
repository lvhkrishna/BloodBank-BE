package com.bloodbank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "staff")
@NamedStoredProcedureQueries({
	   @NamedStoredProcedureQuery(name = "putStaff", 
	                              procedureName = "putStaff",
	                              parameters = {
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "name", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "email", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "mobile", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "address_id", type = Integer.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "type", type = Integer.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "degree", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "dl_no", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "ambulance_no", type = String.class)
	                          }),
	   @NamedStoredProcedureQuery(name = "getStaffDetails", 
							       procedureName = "getStaffDetails",
							       resultClasses = {Staff.class}
			   					)
	})
public class Staff {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "staff_id", unique = true)
	@NotNull
	private int id;
	@Column(name = "name")
	@NotNull
	private String name;
	@Column(name = "email")
	@NotNull
	private String email;
	@Column(name = "mobile")
	@NotNull
	private String mobile;
	@OneToOne
	@JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
	@NotNull
	private Address address;
	private int type;
	private String plotNo;
	private String street;
	private String city;
	private String state;
	private String pincode;
	private String degree;
	private String licenseNo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPlotNo() {
		return plotNo;
	}
	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
}
