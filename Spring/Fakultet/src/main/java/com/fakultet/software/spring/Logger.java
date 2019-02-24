package com.fakultet.software.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class Logger {
	
	@Pointcut("execution(void com.fakultet.software.spring.Professor.addSubject(..))")
	public void addPointcut() {
		
		
	}
	
	@Before("addPointcut()")
	public void prepareToAddSubject(JoinPoint jp){
		Object[] args=jp.getArgs();
		String s= (String)args[0];
		System.out.println("Prepare to add a subject..."+s);
	}
	
	@AfterReturning("addPointcut()")
	public void added(JoinPoint jp){
		Object[] args=jp.getArgs();
		String s= (String)args[0];
		System.out.println("Added..."+s);
	}
	@AfterThrowing("addPointcut()")
	public void error(JoinPoint jp){
		Object[] args=jp.getArgs();
		String s= (String)args[0];
		System.out.println("ERROR: NOT ADDED "+s);
	}
	
	
}
