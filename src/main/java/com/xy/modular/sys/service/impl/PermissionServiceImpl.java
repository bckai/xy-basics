package com.xy.modular.sys.service.impl;

import javax.annotation.Resource;

import com.xy.framework.base.dao.IBaseDao;
import com.xy.framework.base.service.BaseServiceImpl;
import com.xy.modular.sys.dao.PermissionMapper;
import com.xy.modular.sys.entity.Permission;
import com.xy.modular.sys.service.IPermissionService;

public class PermissionServiceImpl extends BaseServiceImpl<Permission, String> implements IPermissionService {

	@Resource
	private PermissionMapper permissionMapper;

	@SuppressWarnings("rawtypes")
	@Override
	protected IBaseDao getBaseDao() {
		return this.permissionMapper;
	}

}
