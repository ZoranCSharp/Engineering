package com.fakultet.software.spring;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		
		Faculty f = (Faculty) context.getBean("faculty");
		Professor p = (Professor) context.getBean("professor");
		System.out.println(p);

		try {
			p.addSubject("Basketball");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "\n");
		}
		
		System.out.println(f);
		
		context.close();

	}

}
