package com.engineering.spring.domaci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		

		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		
		RegistrationLicence reg = (RegistrationLicence) context.getBean("registrationlicence");
		System.out.println(reg);
		
		
		((FileSystemXmlApplicationContext)context).close();
		

	}

}
