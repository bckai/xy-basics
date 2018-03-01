package com.xy.framework.mreturn;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MReturnObject implements Serializable {

	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String TIMEOUT = "timeout";// session超时
	public static final String FATAL_ERROR = "fatalError";
	public static final String WARNING = "warning";
	public static final String LOGIN_ERROR = "login_error";

	private String code;// 返回该次请求状态code
	private String message;// 消息内容
	private Object result;// 封装好的返回对象数据模型（可能是json对象或者json数组，亦或者是一个value）
	private String sessionId;// 加入sessionid参数，保存会话

	public MReturnObject() {
		// TODO Auto-generated constructor stub
	}

	public MReturnObject(String code) {
		this.code = code;
	}

	public MReturnObject(String code, Object result) {
		this.code = code;
		this.result = result;
	}

	public MReturnObject PageMReturnObject() {
		return this;
	}

	public MReturnObject(String code, String message, Object result) {
		this.code = code;
		this.result = result;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
