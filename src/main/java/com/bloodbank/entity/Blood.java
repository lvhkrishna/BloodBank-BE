package com.bloodbank.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "blood")
public class Blood {

	@Id
	@Column(name = "blood_group", unique = true)
	@NotNull
	private String bloodGroup;
	@Column(name = "units_available")
	@NotNull
	@ColumnDefault("0")
	private double unitsAvailable;
	@OneToMany
	private Set<Person> people;
	
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

	public Set<Person> getPeople() {
		return people;
	}

	public void setPeople(Set<Person> people) {
		this.people = people;
	}
	
}
