package com.xy.modular.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xy.framework.base.dao.IBaseDao;
import com.xy.framework.base.service.BaseServiceImpl;
import com.xy.modular.sys.dao.RoleMapper;
import com.xy.modular.sys.entity.Role;
import com.xy.modular.sys.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role, String> implements IRoleService {

	@Resource
	private RoleMapper roleMapper;

	@SuppressWarnings("rawtypes")
	@Override
	protected IBaseDao getBaseDao() {
		return this.roleMapper;
	}

}
