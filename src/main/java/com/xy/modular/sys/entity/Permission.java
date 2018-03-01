package com.xy.modular.sys.entity;

import com.xy.framework.base.entity.Entity;

public class Permission extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;// 名称.

	private String resourceType;// 资源类型，[menu|button]
	private String url;// 资源路径.
	private String permission; // 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
	private Long parentId; // 父编号

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
