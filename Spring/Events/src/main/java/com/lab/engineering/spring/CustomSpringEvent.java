package com.lab.engineering.spring;

import org.springframework.context.ApplicationEvent;

public class CustomSpringEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public CustomSpringEvent(Object source,String message) {
		super(source);
		this.message=message;
		// TODO Auto-generated constructor stub
	}

	

	public String getMessage() {
		return this.message;
	}
	
	
	

	
}
