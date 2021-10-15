package com.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

}
