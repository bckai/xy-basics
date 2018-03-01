package com.xy.modular.sys.dao;

import java.util.List;

import com.xy.framework.base.dao.IBaseDao;
import com.xy.modular.sys.entity.Role;

public interface RoleMapper extends IBaseDao<Role, String> {

	public List<Role> getRole(String userId);
	
}
