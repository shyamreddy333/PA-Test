package com.pa.audit.service;

import com.pa.audit.domain.AuditDomain;
import com.pa.audit.exceptions.AuditException;

public interface AuditService {

	boolean createAudit(AuditDomain auditDetails) throws AuditException;

}
