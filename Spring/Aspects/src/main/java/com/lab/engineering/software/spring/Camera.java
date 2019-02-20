package com.lab.engineering.software.spring;

import org.springframework.stereotype.Component;

@Component
public class Camera {
	
	public void snap () throws Exception {
		System.out.println("SNAP!");
		throw new Exception("Bye!");
	}
	
	public void snap(int exposure){
		System.out.println("SNAP! with exposure: " + exposure);
	}
	
	public String snap(String name){
		System.out.println("SNAP! Name: " + name);
		return name;
	}
	
	public void photoSend()
	{
		
		System.out.println("PHOTO SENT!");
	}

}
