package com.xy.modular.basics.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xy.framework.base.dao.IBaseDao;
import com.xy.framework.base.service.BaseServiceImpl;
import com.xy.modular.basics.dao.UserAuthsMapper;
import com.xy.modular.basics.entity.UserAuths;
import com.xy.modular.basics.service.IUserAuthsService;

@Service("userAuthsService")
public class UserAuthsServiceImpl extends BaseServiceImpl<UserAuths, String> implements IUserAuthsService {

	@Resource
	private UserAuthsMapper userAuthsMapper;

	@SuppressWarnings("rawtypes")
	@Override
	protected IBaseDao getBaseDao() {
		return this.userAuthsMapper;
	}

	@Override
	public UserAuths getByIdentifier(String identifier) {
		return userAuthsMapper.getByIdentifier(identifier);
	}

}
