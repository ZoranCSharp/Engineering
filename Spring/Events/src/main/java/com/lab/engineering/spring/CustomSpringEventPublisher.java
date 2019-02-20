package com.lab.engineering.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventPublisher {
	
	//this is Spring component, which we are using
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	public void doStuffAndPublishAnEvent(final String message) {
		
		System.out.println("Doing our stuff...");
		System.out.println("Publishing custom event");
		
		//create object of custom event
		CustomSpringEvent event = new CustomSpringEvent(this, message);
		
		applicationEventPublisher.publishEvent(event);
	}
	
	

}
