package com.lab.softwear.engineering.spring;

public class Person {
	

	private int jmbg;
	private String ime;
	
	private int age;
	private Address address;
	
	
	public Person(String  ime,int jmbg) {
		
		this.jmbg = jmbg;
		this.ime=ime;
	}
		

	public Person() {
		
	}



	public void speak(){
		
			System.out.println("Hello, i am "+ime);
	}


	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Person [jmbg=" + jmbg + ", ime=" + ime + ", age=" + age + ", address=" + address + "]";
	}
	
	
	public void onCreate() {
		
		System.out.println("Person created: " + this);
	}
	
	public void onDestroy() {
		System.out.println("Bean destroyed: " + this);
	}
}
