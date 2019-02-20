package com.lab.engineering.software.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
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

	//This pointcut advises all methods with name snap and void return type
		//without considering arguments
		@Pointcut("execution(void com.lab.engineering.software.spring.Camera.snap(..))")
		public void cameraSnap(){
			
		}
		
		//This pointcut refers to all methods with name snap, any return type,
		//and exactly one argument of type String
		@Pointcut("execution(* com.lab.engineering.software.spring.Camera.snap(String))")
		public void cameraSnapName(){
			
		}
		
		
		@Pointcut("execution(* com.lab.engineering.software.spring.Camera.*(..))")
		public void cameraRelatedAction(){
			
		}
		
		@Pointcut("execution(* com.lab.engineering.software.spring.Camera.photoSend(..))")
		public void cameraPhotoSend() {
			
		}
		
		@Before("cameraSnap()")
		public void beforeAdvice(){
			System.out.println("Aspect: before advice...about to take a photo...");
		}
		
		//After executes every time method finishes
		@After("cameraSnap()")
		public void afterAdvice(){
			System.out.println("Aspect: after advice... photo has been taken...");
		}
		
		@AfterThrowing("cameraSnap()")
		public void afterThrowingAdvice(){
			System.out.println("Aspect: after throwing advice...");
		}
		
//		@Around("cameraSnap()")
//		public void aroundAdvice(ProceedingJoinPoint p){
//			System.out.println("Around advice: before...");
//			
//			try {
//				p.proceed();
//			} catch (Throwable e) {
//				System.out.println("In around advice: " + e.getMessage());
//			}
//			
//			System.out.println("Around advice: after");
//		}
		
		@Around("cameraPhotoSend()")
		public void aroundAdvice2(ProceedingJoinPoint p){
			System.out.println("Around advice: before photo send...");
			
			try {
				p.proceed();
			} catch (Throwable e) {
				System.out.println("In around advice: " + e.getMessage());
			}
			
			System.out.println("Around advice: after photo send");
		}
		
		@Before("cameraSnapName()")
		public void aboutToTakePhotoWithName() {
			System.out.println("Aspect: taking photo with name...");
		}
		
		//After returning executes only after successful finish method (without exception)
		@AfterReturning("cameraSnapName()")
		public void afterReturningAdvice(){
			System.out.println("After returning advice");
		}
		
		/*
		@Before("cameraRelatedAction()")
		public void aboutToDoSomeCameraRelatedAction(){
			System.out.println("Aspect: Doing something with camera...");
		}*/
	}
