package com.xy.modular.basics.service.impl;

import org.apache.shiro.authc.CredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xy.framework.shiro.ShiroUser;
import com.xy.modular.basics.dao.UserAuthsMapper;
import com.xy.modular.basics.dao.UserMapper;
import com.xy.modular.basics.entity.User;
import com.xy.modular.basics.entity.UserAuths;
import com.xy.modular.basics.service.IShiroService;
import com.xy.modular.sys.dao.PermissionMapper;
import com.xy.modular.sys.dao.RoleMapper;
import com.xy.modular.sys.entity.Role;

import java.util.List;

@Service("shiroService")
@Transactional(readOnly = true)
public class ShiroServiceImpl implements IShiroService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserAuthsMapper userAuthsMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public UserAuths getUserAuths(String principal) {
		UserAuths userAuths = userAuthsMapper.getByIdentifier(principal);
		// 账号不存在
		if (null == userAuths) {
			throw new CredentialsException();
		}
		return userAuthsMapper.getByIdentifier(principal);
	}

	@Override
	public ShiroUser shiroUser(UserAuths userAuths) {
		User user = userMapper.getById(userAuths.getUserId());
		ShiroUser shiroUser = new ShiroUser();

		shiroUser.setId(user.getId());
		shiroUser.setName(user.getName()); // 用户名称
		shiroUser.setRealName(user.getRealName());
		List<Role> roles = roleMapper.getRole(user.getId());
		for (Role role : roles) {
			role.setPermissions(permissionMapper.getPermission(role.getId()));
		}
		shiroUser.setRoleList(roles);
		return shiroUser;
	}

	@Override
	public List<String> findPermissionsByRoleId(Integer roleId) {
		return null;
	}

	@Override
	public String findRoleNameByRoleId(Integer roleId) {
		return null;
	}

	/*
	 * @Override public SimpleAuthenticationInfo info(ShiroUser shiroUser, User
	 * user, String realmName) { String credentials = user.getPassword(); // 密码加盐处理
	 * String source = user.getSalt(); ByteSource credentialsSalt = new
	 * Md5Hash(source); return new SimpleAuthenticationInfo(shiroUser, credentials,
	 * credentialsSalt, realmName); }
	 */

}
