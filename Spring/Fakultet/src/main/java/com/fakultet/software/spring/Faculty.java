package com.fakultet.software.spring;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Faculty {
	private String name;
	private String address;
	private List<String> subjectsFaculty;
	
	
	public Faculty() {
		this.name = "Fakultet";
		this.address = "Bez Broja 1";
		
		subjectsFaculty = Arrays.asList("Spring","Oracle", "HTML", "FrontEnd", "Java");
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	


	public List<String> getSubjectsFaculty() {
		return subjectsFaculty;
	}


	public void setSubjectsFaculty(List<String> subjectsFaculty) {
		this.subjectsFaculty = subjectsFaculty;
	}


	@Override
	public String toString(){
		StringBuilder sb1 = new StringBuilder();
		
		sb1.append(getName() + " on address " + "'" +getAddress() + "'");
		sb1.append( " is containing:\n");
		for (String s: subjectsFaculty){
			sb1.append(s);
			sb1.append("\n");
		}
		return sb1.toString();
	}	

	
	
}
