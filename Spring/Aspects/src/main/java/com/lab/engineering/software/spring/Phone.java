package com.lab.engineering.software.spring;

import org.springframework.stereotype.Component;

@Component
public class Phone {
			
		public void makeCall(String number, boolean status) throws Exception{
			
			System.out.println("Calling..." + number);
			
			if(!status) throw new Exception("Cannot make a call!!!");
			
			System.out.println("Call successful");
		}
	}

