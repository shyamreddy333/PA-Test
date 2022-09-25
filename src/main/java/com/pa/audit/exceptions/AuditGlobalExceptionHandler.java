package com.pa.audit.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class AuditGlobalExceptionHandler extends ResponseEntityExceptionHandler{
	private static final Logger logger = LoggerFactory.getLogger(AuditGlobalExceptionHandler.class);
	
	
	@ExceptionHandler(value = { AuditException.class })
	public ResponseEntity<String> handleSupplierException(AuditException e) {
		logger.error(e.getExceptionMsg());
		return new ResponseEntity<String>("Error saving audit", HttpStatus.EXPECTATION_FAILED);
	}
	 
}