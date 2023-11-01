package com.mrunmai.springbootmvc;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	public void logBefore() {
		LOGGER.info("getAliens method called from aspect...");
	}

	/*By default, @After is after finally which means whatever is the condition
	 whether it is success or error this will get executed.*/
	@After("execution(public * com.mrunmai.springbootmvc.AlienController.getAliens())")
	public void log() {
		LOGGER.info("getAliens method CALLED from aspect");
	}

	/*@AfterReturning will get executed only after the success */
	@AfterReturning("execution(public * com.mrunmai.springbootmvc.AlienController.getAliens())")
	public void logAfterSuccess() {
		LOGGER.info("getAliens method EXECUTED from aspect");
	}

	/*@AfterReturning will get executed only after the exception is thrown(i.e. error) */
	@AfterThrowing("execution(public * com.mrunmai.springbootmvc.AlienController.getAliens())")
	public void logAfterException() {
		LOGGER.info("Issue");
	}

}
