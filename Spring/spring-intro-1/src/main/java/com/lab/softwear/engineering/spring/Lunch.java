package com.lab.softwear.engineering.spring;

import java.util.HashMap;
import java.util.Map;

public class Lunch {

	private Map<String, Animal> animals = new HashMap<String, Animal>();
	private Map<String, String> foods = new  HashMap<String, String>();
	
	
	public void setAnimals(Map<String, Animal> animals) {
		this.animals = animals;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(Map.Entry<String, Animal> entry: animals.entrySet()) {
			
			sb.append(entry.getKey() + ":" + entry.getValue() + "\n");
		}
		return sb.toString();
	}
	
	
}
