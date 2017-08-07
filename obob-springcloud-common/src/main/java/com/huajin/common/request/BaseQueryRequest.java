package com.huajin.common.request;

import java.io.Serializable;

public class BaseQueryRequest implements Serializable {

	/**
	 * @author hongbo.zhao
	 * 2017年6月16日 上午10:39:05
	 */
	private static final long serialVersionUID = -5857683997351554141L;
	
	/**
	 * 当前页
	 */
	private Integer pageNumber;
	
	/**
	 * 每页记录数
	 */
	private Integer pageSize;

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
