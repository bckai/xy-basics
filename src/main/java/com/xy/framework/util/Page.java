package com.xy.framework.util;

public class Page {

	/**
	 * 当前页显示几行
	 */
	private String limit;
	/**
	 * 当前页
	 */
	private String offset;
	/**
	 * 当前页数据
	 */
	private Object rows;

	public Page() {
		// TODO Auto-generated constructor stub
	}

	/***
	 * 分页数据封装
	 * 
	 * @param limit
	 * @param offset
	 * @param rows
	 */
	public Page(String limit, String offset, Object rows) {
		this.limit = limit;
		this.offset = offset;
		this.rows = rows;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

}
