package com.fakultet.software.spring;

import org.aspectj.lang.JoinPoint;

public class Logger {
	public void prepareToAddSubject(JoinPoint jp){
		Object[] args=jp.getArgs();
		String s= (String)args[0];
		System.out.println("Prepare to add a subject..."+s);
	}
	
	public void added(JoinPoint jp){
		Object[] args=jp.getArgs();
		String s= (String)args[0];
		System.out.println("Added..."+s);
	}
	
	public void error(JoinPoint jp){
		Object[] args=jp.getArgs();
		String s= (String)args[0];
		System.out.println("ERROR: NOT ADDED "+s);
	}
	
	
}
