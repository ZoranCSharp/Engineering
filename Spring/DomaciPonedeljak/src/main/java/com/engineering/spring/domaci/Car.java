package com.engineering.spring.domaci;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("car")
public class Car {
	
	private String fuel;
	private int power;
	private String brand;
	
	
	public Car() {
		
		this.fuel="Diesel";
		this.power=3500;
		this.brand="Opel";
		
	}


	
	
	
	
	
	
	
	

}
