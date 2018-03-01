package com.xy.framework.shiro;

import java.io.Serializable;
import java.util.List;

import com.xy.modular.sys.entity.Role;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 *
 * @author fengshuonan
 * @date 2016年12月5日 上午10:26:43
 */
public class ShiroUser implements Serializable {

	private static final long serialVersionUID = 1L;

	public String id; // 主键ID
	public String name; // 姓名
	public String realName;
	public Integer deptId; // 部门id
	public List<Role> roleList; // 角色集
	public String deptName; // 部门名称
	public String token; //

	public ShiroUser(String id, String name, String realName) {
		this.id = id;
		this.name = name;
		this.realName = realName;
	}

	public ShiroUser() {

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
