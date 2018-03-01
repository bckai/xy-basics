package com.xy.modular.basics.service;

import com.xy.framework.base.service.IBaseService;
import com.xy.modular.basics.entity.UserAuths;

public interface IUserAuthsService extends IBaseService<UserAuths, java.lang.String> {

	/**
	 * 登录验证用户名 密码
	 * 
	 * @param userAuths
	 * @return
	 */
	UserAuths getByIdentifier(String identifier);
}
