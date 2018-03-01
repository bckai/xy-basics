package com.xy.framework.base.entity;

import java.io.Serializable;

import org.apache.http.client.CookieStore;

public class CookieModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3440839199871074360L;

	public CookieModel() {
		// TODO Auto-generated constructor stub
	}

	// 用户 id
	private String userId;

	// 随机生成的 uuid
	private CookieStore cookieStore;

	// 随机生成的 uuid
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public CookieStore getCookieStore() {
		return cookieStore;
	}

	public void setCookieStore(CookieStore cookieStore) {
		this.cookieStore = cookieStore;
	}

}
