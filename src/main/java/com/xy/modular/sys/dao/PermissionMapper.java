package com.xy.modular.sys.dao;

import java.util.List;

import com.xy.framework.base.dao.IBaseDao;
import com.xy.modular.sys.entity.Permission;

public interface PermissionMapper extends IBaseDao<Permission, String> {

	List<Permission> getPermission(String roleId);

}
