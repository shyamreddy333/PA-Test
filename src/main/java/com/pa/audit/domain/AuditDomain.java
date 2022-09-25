package com.pa.audit.domain;

import com.pa.audit.util.AuditUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditDomain {
	private String function;
	private String what;
	private String who;
	private String details;
	private String notify;

	@Override
	public String toString() {
		String auditTxt = AuditUtil.mapNullToEmpty(this.what) + ", " + AuditUtil.mapNullToEmpty(this.who) + ", "
				+ AuditUtil.mapNullToEmpty(this.details) + ", " + AuditUtil.mapNullToEmpty(this.notify);
		return auditTxt;
	}

}
