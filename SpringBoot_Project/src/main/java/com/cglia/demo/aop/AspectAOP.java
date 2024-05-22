package com.cglia.demo.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cglia.demo.entity.Course;


@Aspect
@Component


public class AspectAOP {
	// Define an aspect for logging
	

//	    @Before("execution(* com.cglia.demo.controller.Controller.*(..))")
//	    public void beforeControllerMethods() {
//	        System.out.println("Executing method in Controller...");
//	    }
//
//	    @After("execution(* com.cglia.demo.controller.Controller.*(..))")
//	    public void afterControllerMethods() {
//	        System.out.println("Method execution in Controller completed.");
//	    }
	Logger log = LoggerFactory.getLogger(AspectAOP .class);

	@Pointcut("execution(* com.cglia.demo.controller.*.*(..))")
	public void loggingPointCut() {

	}

	/*
	 * @Before("loggingPointCut()") public void before(JoinPoint joinPoint) {
	 * log.info("Before method invoke::"+joinPoint.getSignature()); }
	 */

	/*
	 * @After("loggingPointCut()") public void after(JoinPoint joinPoint) {
	 * log.info("After method invoke::"+joinPoint.getSignature()); }
	 */

	/*
	  @AfterReturning(value="execution( com.cglia.springrest.controller.*.*(..))",
	 * returning="courses") public void after(JoinPoint joinPoint,Course courses) {
	 * log.info("After method invoke::"+courses); }
	 * 
	  @AfterThrowing(value="execution( com.cglia.springrest.controller.*.*(..))",
	 * throwing="e") public void after(JoinPoint joinPoint,Exception e ) {
	 * log.info("After method invoke::"+e.getMessage()); }
	 */

	@Around("loggingPointCut()")
	public Object around(ProceedingJoinPoint joinPoint)throws Throwable {
		log.info("Before method invoke::" +joinPoint.getSignature());
		Object object=joinPoint.proceed();
		
		if(object instanceof Course) {
			log.info("After Method invoked..."+joinPoint.getSignature());
		}
		return object;
	}
	}

