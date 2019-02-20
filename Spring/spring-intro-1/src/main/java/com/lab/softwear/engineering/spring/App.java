package com.lab.softwear.engineering.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
	public static void main(String args[]) {
		
		
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		
//		Person person =(Person) context.getBean("person");
//		person.speak();
//		System.out.println(person.toString());
//		
//		Address address = (Address) context.getBean("address");
//		System.out.println(address.toString());
		
//		FruitBasket basket = (FruitBasket) context.getBean("basket");
//		System.out.println(basket);
		
		Zoo zoo = (Zoo) context.getBean("zoo");
		System.out.println(zoo);
		
		Lunch lunch = (Lunch) context.getBean("lunch");
		System.out.println(lunch.toString());
		
		((FileSystemXmlApplicationContext)context).close();
		
		
	}

}
