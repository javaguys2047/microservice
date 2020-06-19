package com.javaguy.app.service.helper;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
public class LoggerHelper {
	private Logger logger = LoggerFactory.getLogger(LoggerHelper.class);
	@Before("execution(* com.javaguy.app.service.services.*.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.info("Before calling a method "+joinPoint.getSignature().getName()+" from class "+joinPoint.getTarget().getClass());
	}
	@After("execution(* com.javaguy.app.service.services.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("After calling a method "+ joinPoint.getSignature().getName()+" from class "+joinPoint.getTarget().getClass());
	}
}
