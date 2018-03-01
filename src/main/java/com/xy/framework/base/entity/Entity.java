package com.xy.framework.base.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共的实体
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Entity implements Serializable {

	/**
	 * 
	 */
	public String id;
	public Date createTime;
	public Date modifyTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}
