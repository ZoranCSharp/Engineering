package com.lab.software.engineering.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class App {

	public static void main(String[] args) {
		
		

		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		
		Logger logger = (Logger) context.getBean("logger");
		logger.writeConsole("Hello there");
		logger.writeFile("Hello again");
		
		LogWriter console=(LogWriter) context.getBean("console");
		logger.writeConsole("Hello there");
		logger.writeFile("Hello again");
		
		
		
		((FileSystemXmlApplicationContext)context).close();
		

	}

}
