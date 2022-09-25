package com.pa.audit.repository.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="catalogaudit")
public class AuditEntity {
	
	@Id
	@Column(name="AuditId", length = 50, nullable = false)
	private String auditId;
	
	@Column(name="Function", length = 20, nullable = false)
	private String function;
	
	
	@Column(name="What", length = 100, nullable = false)
	private String what;
	
	@Column(name="Who", length = 50, nullable = false)
	private String who;
	
	@Column(name="created", nullable = false)
	private Timestamp when;
	
	@Column(name="Details", length = 200, nullable = false)
	private String details;
	
	@Column(name="Notify", length = 1, nullable = false)
	private String notify; 
}
