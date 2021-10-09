package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloodbank.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor, String> {

}
