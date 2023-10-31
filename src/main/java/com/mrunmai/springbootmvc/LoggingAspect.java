package com.mrunmai.springbootmvc;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(public * com.mrunmai.springbootmvc.AlienController.getAliens())")
	public void log() {
		LOGGER.info("getAliens method called from aspect...");
	}
}
