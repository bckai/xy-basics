package com.xy.modular.sys.entity;

import com.xy.framework.base.entity.Entity;

/**
 * 菜单表
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Module extends Entity {

	private String name;
	private String url;
	private int isValid;
	private int sort;
	private String icon;
	private String superMod;

	public Module() {
		// TODO Auto-generated constructor stub
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getSuperMod() {
		return superMod;
	}

	public void setSuperMod(String superMod) {
		this.superMod = superMod;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIsValid() {
		return isValid;
	}

	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
}
