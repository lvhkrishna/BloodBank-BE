package com.bloodbank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "event")
public class Events {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "event_id", unique = true)
	@NotNull
	private int id;
	@Column(name = "name")
	@NotNull
	private String name;
	@Column(name = "event_date")
	@NotNull
	private String eventDate;
	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
	@NotNull
	private Address address;
	
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
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
