package com.xy.modular.basics.entity;

import java.util.Date;

import com.xy.framework.base.entity.Entity;

/**
 * 用户信息
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class User extends Entity {

	public String name;
	public int sex;
	public Date birthday;
	public String avatar;
	public String realName;
	public String userType;

	private UserAuths userAuths;

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public UserAuths getUserAuths() {
		return userAuths;
	}

	public User setUserAuths(UserAuths userAuths) {
		this.userAuths = userAuths;
		return this;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
