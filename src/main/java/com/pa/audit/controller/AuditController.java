package com.pa.audit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pa.audit.domain.AuditDomain;
import com.pa.audit.exceptions.AuditException;
import com.pa.audit.service.impl.AuditServiceImpl;

@RestController
public class AuditController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuditController.class);
	
	@Autowired
	AuditServiceImpl auditService;
	
	@PostMapping(value = "/save", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> createAudit(@RequestBody AuditDomain auditInput) throws AuditException {
		String respMsg = "success";
		boolean success = auditService.createAudit(auditInput);
		if(!success){
			respMsg = "failed";
		}
		return new ResponseEntity<>(respMsg, HttpStatus.OK);
	}

}
