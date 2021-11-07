package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entity.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

}
