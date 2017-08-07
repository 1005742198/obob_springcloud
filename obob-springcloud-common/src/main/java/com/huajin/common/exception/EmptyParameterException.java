package com.huajin.common.exception;

import com.huajin.baymax.exception.BayMaxBaseException;
import com.huajin.baymax.support.ResponseCodeBase;


/**
 * 接口参数为空时抛出的异常。
 *  
 * @author bo.yang
 * @date 2017年6月27日 上午9:52:54
 */
public class EmptyParameterException extends BayMaxBaseException {
	
	private static final long serialVersionUID = -3355223256665852240L;

	public EmptyParameterException() {
		super(ResponseCodeBase.SYSTEM_PARAMETERS_EMPTY, null);
	}

}
