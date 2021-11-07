package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
