package com.bloodbank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "blood")
public class Blood {

	@Id
	@Column(name = "blood_group", length = 5, unique = true)
	@NotNull
	private String bloodGroup;
	@Column(name = "units_available")
	@NotNull
	@ColumnDefault("0")
	private double unitsAvailable;
	
	public Blood() {}
	
	public Blood(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public double getUnitsAvailable() {
		return unitsAvailable;
	}

	public void setUnitsAvailable(double unitsAvailable) {
		this.unitsAvailable = unitsAvailable;
	}
	
}
