package com.exemple.kafkaApp.Model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private UUID id;
	private final String name;
	private final String firstname;
	
	private Person(PersonBuilder builder) {
		this.name = builder.name;
		this.firstname = builder.firstname;
	}
	
	public String getName() {
		return name;
	}


	public String getFirstname() {
		return firstname;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", firstname=" + firstname + "]";
	}

	public static class PersonBuilder {
		
		private String name;
		private String firstname;
		
		public PersonBuilder() {}
		
		public PersonBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public PersonBuilder setFirstname(String firstname) {
			this.firstname = firstname;
			return this;
		}
		
		public Person build() {
			Person Person = new Person(this);
			validatePersonObject(Person);
			return Person;
		}
		
		private void validatePersonObject(Person Person) {}
	}
	
	
}
