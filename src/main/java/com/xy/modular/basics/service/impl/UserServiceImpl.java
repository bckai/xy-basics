package com.xy.modular.basics.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xy.framework.base.dao.IBaseDao;
import com.xy.framework.base.service.BaseServiceImpl;
import com.xy.framework.exceptions.ValidateParamException;
import com.xy.modular.basics.dao.UserAuthsMapper;
import com.xy.modular.basics.dao.UserMapper;
import com.xy.modular.basics.entity.User;
import com.xy.modular.basics.entity.UserAuths;
import com.xy.modular.basics.service.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, java.lang.String> implements IUserService {

	@Resource
	private UserMapper userMapper;

	@Resource
	private UserAuthsMapper userAuthsMapper;

	@SuppressWarnings("rawtypes")
	@Override
	protected IBaseDao getBaseDao() {
		return this.userMapper;
	}

	@Override
	public User login(UserAuths userAuths) {
		UserAuths uA = userAuthsMapper.getByIC(userAuths);
		if (uA != null) {
			return userMapper.getById(uA.getUserId()).setUserAuths(uA);
		}
		return null;
	}

	@Override
	public Boolean validateEntity(UserAuths userAuths) {
		return true;
	}

	@Override
	public void validateEntity(User user) throws ValidateParamException {
		// TODO Auto-generated method stub

	}

}
