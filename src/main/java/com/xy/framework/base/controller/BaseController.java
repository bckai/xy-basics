package com.xy.framework.base.controller;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xy.modular.basics.entity.User;

public class BaseController {
	
	static Logger log = LoggerFactory.getLogger(BaseController.class);

	protected User getCurrentMember() {
		return (User) SecurityUtils.getSubject().getSession().getAttribute("user");
	}

}
