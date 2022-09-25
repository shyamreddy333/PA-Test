package com.pa.audit.repository;

import org.springframework.data.repository.CrudRepository;
import com.pa.audit.repository.entity.AuditEntity;

public interface AuditRepository extends CrudRepository<AuditEntity, String>{

}
