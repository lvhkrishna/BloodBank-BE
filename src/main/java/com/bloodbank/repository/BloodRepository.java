package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloodbank.entity.Blood;

public interface BloodRepository extends JpaRepository<Blood, String> {

}
