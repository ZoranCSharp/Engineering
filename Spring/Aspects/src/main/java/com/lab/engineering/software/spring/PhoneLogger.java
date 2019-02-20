package com.lab.engineering.software.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PhoneLogger {
	
	@Pointcut("execution(* com.lab.engineering.software.spring.Phone.* (..))")
	public void makeCallPointcut(){
		
	}
	
	@Before("makeCallPointcut()")
	public void beforeAdvice(JoinPoint jp){
		System.out.println("Phone advice - before...");
		System.out.println("Retrieving arguments of intercepted method...");
		
		for (Object obj: jp.getArgs()){
			System.out.println("ARG: " + obj);
		}
		Object[] args = jp.getArgs();
		String phoneNumber = (String)args[0];
		System.out.println("Before advice: outgoing call to number " + phoneNumber);
	}
	
	@After("makeCallPointcut()")
	public void afterAdvice(){
		System.out.println("Phone advice - after...");	
	}
	
	@AfterReturning("makeCallPointcut()")
	public void afterReturningAdvice(){
		System.out.println("Phone advice - after returning...");
	}
	
	@AfterThrowing("makeCallPointcut()")
	public void afterThrowingAdvice(){
		System.out.println("Phone advice - after throwing...");
	}
	
	@Around("makeCallPointcut()")
	public void aroundAdvice(ProceedingJoinPoint p){
		System.out.println("Around advice - before...");	
		
		try {
			p.proceed();
		} catch (Throwable e) {
			System.out.println("Around advice - after throwing...");
		}
		
		System.out.println("Around advice - after...");	
		
	}
}

