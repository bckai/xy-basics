package com.xy.framework.exceptions;
/**
 * 用于验证请求参数非法提示
 * @copyright {@link www.centforsoft.com}
 * @author 
 * @version 2015年1月22日 上午9:24:20
 * @see com.centfor.app.exception.ValidateParamException
 */
public class ValidateParamException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2612513697065584639L;
	public ValidateParamException() {
	}
	public ValidateParamException(String errorMessage) {
		super(errorMessage);
	}
	
}
