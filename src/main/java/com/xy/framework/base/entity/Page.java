package com.xy.framework.base.entity;

import java.util.List;

public class Page {

	private int pageIndex; // 当前页（第一页=1）
	private int recCount; // 总记录数
	private int pageSize; // 每页行数
	@SuppressWarnings("rawtypes")
	private List data;// 当前页的记录集

	public Page() {

	}

	@SuppressWarnings("rawtypes")
	public Page(int pageIndex, int recCount, int pageSize, List data) {
		this.pageIndex = pageIndex;
		this.recCount = recCount;
		this.pageSize = pageSize;
		this.data = data;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getRecCount() {
		return recCount;
	}

	public void setRecCount(int recCount) {
		this.recCount = recCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@SuppressWarnings("rawtypes")
	public List getData() {
		return data;
	}

	@SuppressWarnings("rawtypes")
	public void setData(List data) {
		this.data = data;
	}
}
