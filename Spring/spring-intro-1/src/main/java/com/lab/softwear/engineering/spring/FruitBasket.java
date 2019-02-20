package com.lab.softwear.engineering.spring;

import java.util.List;

public class FruitBasket {
	
	private String name;
	private List<String> fruits;
	public FruitBasket(String name, List<String> fruits) {
		super();
		this.name = name;
		this.fruits = fruits;
	}
	public FruitBasket() {
		
	}
	
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.name);
		sb.append(" contains: \n");
		for(String fruit: fruits) {
			sb.append(fruit);
			sb.append("\n");
		}
		return sb.toString();
	}
	

}
