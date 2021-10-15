package com.bloodbank.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@Column(name = "aadhar_id", unique = true)
	@NotNull
	private String aadharId;
	@Column(name = "name")
	@NotNull
	private String name;
	@Column(name = "mobile")
	@NotNull
	private String mobile;
	@Column(name = "email")
	@NotNull
	private String email;
	@Column(name = "dob")
	@NotNull
	private Date dob;
	
	@ManyToOne
	@JoinColumn(name = "blood_group", nullable = false)
	@NotNull
	private Blood bloodGroup;
	
}
