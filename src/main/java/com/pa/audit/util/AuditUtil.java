package com.pa.audit.util;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuditUtil {
	private static final Logger logger = LoggerFactory.getLogger(AuditUtil.class);
	
	public static String standardizeText(String text) {
		String standardizedText = null;
		if(null != text) {
			standardizedText = text.replaceAll(" ", "");
			logger.debug("Standardized Text: {}", standardizedText);
		}
		return standardizedText;
	}
	
	
	public static String mapEmptyToNull(String txt) {
		if(txt != null && txt.replace(" ", "").length() == 0) {
			txt =null;
		}
		return txt;
	}
	
	public static String mapNullToEmpty(String txt) {
		if(txt == null) {
			txt = "";
		}
		return txt;
	}
	
	
	public  static Timestamp sqlDateTime() {
		long now = System.currentTimeMillis();
        Timestamp sqlTimestamp = new Timestamp(now);
        return sqlTimestamp;
	}
	
}
