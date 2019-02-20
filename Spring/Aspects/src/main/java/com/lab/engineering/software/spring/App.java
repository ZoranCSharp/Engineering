package com.lab.engineering.software.spring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class App {

	public static void main(String[] args) {
		
		

		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		
		/*
		 * Camera camera = (Camera) context.getBean("camera");
		 * 
		 * try { camera.snap(); } catch (Exception e) {
		 * System.out.println(e.getMessage()); } //camera.snap(1000);
		 * camera.snap("Vacation in Paris");
		 */
		
		Phone phone = (Phone)context.getBean("phone");
		try {
			phone.makeCall("111222333", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			phone.makeCall("111222333", false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		((FileSystemXmlApplicationContext)context).close();
		

	}

}
