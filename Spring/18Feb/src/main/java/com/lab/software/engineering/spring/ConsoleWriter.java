package com.lab.software.engineering.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("console")
//@Qualifier("writetoconsole")
public class ConsoleWriter implements LogWriter{

	public void write(String text) {
		// TODO Auto-generated method stub
		System.out.println("Writing to console: " + text);
		
	}

	
}
