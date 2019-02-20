package com.fakultet.software.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@Around("addPointcut()")
	public void prepareToAddSubject(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args=pjp.getArgs();
		String s= (String)args[0];
		System.out.println("Prepare to add a subject..."+s);
		
		try {
			pjp.proceed();
			System.out.println("Added..."+s);
			
		}catch (Exception e){
			
			System.out.println("ERROR: NOT ADDED "+s +"\n");
		}
	}
	
	
	
	
}
