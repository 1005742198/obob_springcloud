/**
 * 
 */
package com.huajin.common.domain;

import com.huajin.baymax.rest.response.BaseResponse;
import com.huajin.baymax.support.ResponseCodeBase;
import com.huajin.baymax.support.ResponseCodeProperties;

/**
 * 
 * @author zhangdebin
 * @date 2017年6月9日 上午10:15:25
 */
public class DataResponse<T> extends BaseResponse {
	/**
	 * @author zhangdebin
	 * @date 2017年6月9日 上午10:35:28
	 */
	private static final long serialVersionUID = 6296361397569742734L;

	private T data;

	public T getData() {
		return data;
	}

	public DataResponse<T> setData(T data) {
		this.data = data;
		return this;
	}

	@Override
	public DataResponse<T> setRetcode(int responseCode) {
		super.setRetcode(responseCode);
		return this;
	}

	@Override
	public DataResponse<T> setMsg(String message) {
		super.setMsg(message);
		return this;
	}

	public static <T> DataResponse<T> create() {
		return new DataResponse<>();
	}

	public static <T> DataResponse<T> emptyParamter() {
		DataResponse<T> response = new DataResponse<>();
		response.setRetcode(ResponseCodeBase.SYSTEM_PARAMETERS_EMPTY);
		response.setMsg(ResponseCodeProperties.getProperty(response.getRetcode()));
		
		return response;
	}
}
