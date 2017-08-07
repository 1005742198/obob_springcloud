/**
 * 
 */
package com.huajin.common.domain;

import com.huajin.baymax.support.ResponseCodeBase;
import com.huajin.baymax.support.ResponseCodeProperties;

/**
 * 
 * @author zhangdebin
 * @date 2017年6月9日 上午10:55:19
 */
public class PageResponse<T> extends DataResponse<T> {
	/**
	 * @author zhangdebin
	 * @date 2017年6月9日 上午10:55:11
	 */
	private static final long serialVersionUID = 372580281259778136L;

	private long totalsize;
	private long totalpage;

	public long getTotalsize() {
		return this.totalsize;
	}

	public PageResponse<T> setTotalsize(long totalsize) {
		this.totalsize = totalsize;
		return this;
	}

	public long getTotalpage() {
		return totalpage;
	}

	public PageResponse<T> setTotalpage(long totalpage) {
		this.totalpage = totalpage;
		return this;
	}

	@Override
	public PageResponse<T> setData(T data) {
		super.setData(data);
		return this;
	}

	@Override
	public PageResponse<T> setRetcode(int responseCode) {
		super.setRetcode(responseCode);
		return this;
	}

	@Override
	public PageResponse<T> setMsg(String message) {
		super.setMsg(message);
		return this;
	}

	public static <T> PageResponse<T> create() {
		return new PageResponse<>();
	}

	public static <T> PageResponse<T> emptyParamter() {
		PageResponse<T> response = new PageResponse<>();
		response.setRetcode(ResponseCodeBase.SYSTEM_PARAMETERS_EMPTY);
		response.setMsg(ResponseCodeProperties.getProperty(response.getRetcode()));

		return response;
	}
}
