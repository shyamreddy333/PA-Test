package com.pa.audit.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditException extends Exception{

	private static final long serialVersionUID = 1L;
	private String code;
	private String msg;
	private String exceptionMsg;
	private int httpCode;

	public AuditException(String code, String msg, String exceptionMsg) {
		this.code=code;
		this.exceptionMsg=exceptionMsg;
		this.msg=msg;
	}
	
	public AuditException(String code, String msg, String exceptionMsg, int httpErrorCode) {
		this.code=code;
		this.exceptionMsg=exceptionMsg;
		this.msg=msg;
		this.httpCode=httpErrorCode;
	}
}
