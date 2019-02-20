package com.lab.softwear.engineering.spring;

import java.util.List;

public class Zoo {

	private Animal greatest;
	private List<Animal> animals;
	
	public void setGreatest(Animal greatest) {
		this.greatest = greatest;
	}
	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Greatest: " + this.greatest + "\n");
		sb.append("Other animals in our Zoo: " + "\n");
		for (Animal animal : animals) {
			sb.append(animal);
			sb.append("\n");
		}
		return sb.toString();
	}
}