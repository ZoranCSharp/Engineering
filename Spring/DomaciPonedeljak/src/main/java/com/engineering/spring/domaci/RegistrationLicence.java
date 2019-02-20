package com.engineering.spring.domaci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RegistrationLicence {
	
	private Car car;
	private Person person;
	
	
	
	public Car getCar() {
		return car;
	}
	@Autowired
	@Qualifier("car")
	public void setCar(Car car) {
		this.car = car;
	}
	public Person getPerson() {
		return person;
	}
	
	@Autowired
	@Qualifier("person")
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
//	public RegistrationLicence(Car car, Person person) {
//		
//		this.car = car;
//		this.person = person;
//	}
	@Override
	public String toString() {
		return "RegistrationLicence [car=" + car + ", person=" + person + "]";
	}
	
	
	
	
	

}
