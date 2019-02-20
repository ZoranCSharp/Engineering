package com.lab.softwear.engineering.spring;

public class Address {
	
	private String street;
	private String postalCode;
	public Address(String street, String postalCode) {
		
		this.street = street;
		this.postalCode = postalCode;
	}
	public Address() {
		
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", postalCode=" + postalCode + "]";
	}
	
	
	
	
	
	

}
