package com.xy.modular.basics.entity;

import com.xy.framework.base.entity.Entity;

/**
 * 用户验证相关
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class UserAuths extends Entity {

	public String userId;
	// 登录类型（手机号 邮箱 用户名）或第三方应用名称（微信 微博等）
	public String identityType;
	// 标识（手机号 邮箱 用户名或第三方应用的唯一标识）
	public String identifier;
	// 密码凭证（站内的保存密码，站外的不保存或保存token）
	public String credential;
	// 随机盐值
	public String salt;

	public UserAuths() {
		super();
	}

	public UserAuths(String identifier, String credential) {
		this.identifier = identifier;
		this.credential = credential;
	}

	public String getUserId() {
		return userId;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

}
