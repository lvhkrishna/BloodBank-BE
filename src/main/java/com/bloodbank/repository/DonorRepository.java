package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entity.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, String> {

}
