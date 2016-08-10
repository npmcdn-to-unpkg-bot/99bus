package org.hopen.framework.exception;

import org.apache.log4j.Logger;

public class JYRunException extends RuntimeException {
	Logger logger = Logger.getLogger(JYRunException.class);
	private static final long serialVersionUID = 1L;
	public JYRunException(String msg){
		super(msg);
	}
	public JYRunException(String errorId,String errorMsg){
		super(errorMsg);
		if (errorId != null && !errorId.equals("")) {
			logger.error("**message define error: 【"+ errorId + "】 is not defined");
		}
	}
}
