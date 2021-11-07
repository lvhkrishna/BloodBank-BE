package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
	
}
