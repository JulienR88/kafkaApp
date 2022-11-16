package com.exemple.kafkaApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.kafkaApp.Model.Person;
import com.exemple.kafkaApp.Repository.PersonRepository;

@Service
public class PersonService {

	
	@Autowired
	private PersonRepository PersonRepository;
	
	public void insert(Person person) {
		
		PersonRepository.save(person);
	}
}
