package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entity.Donate;

@Repository
public interface DonateRepository extends JpaRepository<Donate, Integer> {

}
