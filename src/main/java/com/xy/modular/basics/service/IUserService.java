package com.xy.modular.basics.service;

import com.xy.framework.base.service.IBaseService;
import com.xy.framework.exceptions.ValidateParamException;
import com.xy.modular.basics.entity.User;
import com.xy.modular.basics.entity.UserAuths;

public interface IUserService extends IBaseService<User, java.lang.String>{

	User login(UserAuths userAuths);
	
	/**
	 * 验证实体
	 * @param userAuths
	 * @return
	 */
	Boolean validateEntity(UserAuths userAuths);
	
	void validateEntity(User lineNode) throws ValidateParamException;

}
