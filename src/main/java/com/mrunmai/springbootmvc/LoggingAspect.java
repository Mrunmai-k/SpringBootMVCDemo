package com.mrunmai.springbootmvc;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(public * com.mrunmai.springbootmvc.AlienController.getAliens())")
	public void log() {
		System.out.println("getAliens method called from aspect...");
	}
}
