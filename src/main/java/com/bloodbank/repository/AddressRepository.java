package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
