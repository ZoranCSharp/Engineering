package com.lab.software.engineering.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Qualifier("writetofile")
@Component("file")
public class FileWriter implements LogWriter {

	public void write(String text) {				
		
		System.out.println("Writing to file: " + text);
	}
	
	
	
	

}
