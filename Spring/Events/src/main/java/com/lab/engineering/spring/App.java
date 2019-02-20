package com.lab.engineering.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class App {
	

	public static void main(String[] args) {
		
		

		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		
		CustomSpringEventPublisher csep = (CustomSpringEventPublisher)context.getBean("customSpringEventPublisher");
		
		csep.doStuffAndPublishAnEvent("Hello");
		
		
		
		((FileSystemXmlApplicationContext)context).close();
		

	}

}
