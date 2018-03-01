package com.xy.modular.sys.entity;

import java.util.List;

import com.xy.framework.base.entity.Entity;

@SuppressWarnings("serial")
public class Role extends Entity {

	private String name;
	private String sort;
	private String isValid;
	private String description;
	private List<Permission> permissions;

	public Role() {
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

}
