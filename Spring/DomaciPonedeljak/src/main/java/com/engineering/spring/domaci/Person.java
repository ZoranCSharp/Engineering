package com.engineering.spring.domaci;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("person")
public class Person {

	private String name;
	private String lastName;
	private String  address;
	
	
	
	
	public Person() {
		
		this.name="Petar";
		this.lastName="Petrovic";
		this.address="Bez broja 1";
	}




	
	
	
	
}
