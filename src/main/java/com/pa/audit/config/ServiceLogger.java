package com.pa.audit.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLogger {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLogger.class);

	/**
	 * <h>logBeforeAndAfterServiceMethods</h> Adds trace logging before a proceeding
	 * join point method call.
	 * 
	 * @param pjp The proceeding joint point
	 * @return Result of method call
	 * @throws Throwable
	 */
	@Around("execution(* com.pa.audit..*.* (..))")
	public Object logBeforeAndAfterServiceMethods(ProceedingJoinPoint pjp) throws Throwable {
		LOGGER.debug("{}:{}() has started execution.", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName());
		Object resultOfMethodCall = pjp.proceed();
		LOGGER.debug("{}:{}() has finished execution.", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName());
		return resultOfMethodCall;
	}
}