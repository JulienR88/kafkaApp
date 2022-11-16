package com.exemple.kafkaApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemple.kafkaApp.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

	
}
