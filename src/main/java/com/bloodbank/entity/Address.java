package com.bloodbank.entity;

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
@Table(name = "address")
@NamedStoredProcedureQueries({
	   @NamedStoredProcedureQuery(name = "putAddress", 
	                              procedureName = "putAddress",
	                              parameters = {
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "plot_no", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "street", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "city", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "state", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "pincode", type = String.class)
	                          })
	})
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "address_id", unique = true)
	@NotNull
	private int id;
	@Column(name = "plot_no")
	@NotNull
	private String plotNo;
	@Column(name = "street")
	@NotNull
	private String street;
	@Column(name = "city")
	@NotNull
	private String city;
	@Column(name = "state")
	@NotNull
	private String state;
	@Column(name = "pincode", length = 6)
	@NotNull
	private String pincode;
	
	public Address() {}
	
	public Address(String plotNo, String street, String city, String state, String pincode) {
		this.plotNo = plotNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public String getPlotNo() {
		return plotNo;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPincode() {
		return pincode;
	}
	
}
