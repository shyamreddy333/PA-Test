package com.pa.audit.service.impl;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pa.audit.domain.AuditDomain;
import com.pa.audit.exceptions.AuditException;
import com.pa.audit.repository.AuditRepository;
import com.pa.audit.repository.entity.AuditEntity;
import com.pa.audit.service.AuditService;
import com.pa.audit.util.AuditConstants;
import com.pa.audit.util.AuditUtil;

@Service
public class AuditServiceImpl implements AuditService{
	
	private static final Logger logger = LoggerFactory.getLogger(AuditServiceImpl.class);
	
	@Autowired
	AuditRepository auditRepo;
	
	@Override
	public boolean createAudit(AuditDomain auditDetails) throws AuditException {
		boolean auditAdded = false;
		logger.warn("Audit input {}", auditDetails.toString());
		AuditEntity auditEntity = buildEntity(auditDetails); 
		if(auditEntity != null){
			try {
				auditRepo.save(auditEntity);
				auditAdded = true;
			}catch(Exception e){
				logger.warn("Exception in {}", Thread.currentThread().getStackTrace()[1].getMethodName());
				e.printStackTrace();
				throw new AuditException(AuditConstants.AUDIT_CREATION_ERR, AuditConstants.AUDIT_CREATION_MSG,e.toString());
			}
		}
		return auditAdded;
	}
	
	private AuditEntity buildEntity(AuditDomain inputData){
		AuditEntity auditEntity = null;
		if(inputData != null) {
			auditEntity = new AuditEntity();
			auditEntity.setAuditId(UUID.randomUUID().toString());
			auditEntity.setDetails(inputData.getDetails());
			auditEntity.setNotify(inputData.getNotify());
			auditEntity.setWhat(inputData.getWhat());
			auditEntity.setWho(inputData.getWho());
			auditEntity.setWhen(AuditUtil.sqlDateTime());
			auditEntity.setFunction(inputData.getFunction());
		}
		return auditEntity;
	} 
}
