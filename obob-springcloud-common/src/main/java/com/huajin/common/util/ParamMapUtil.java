package com.huajin.common.util;

import java.util.Map;

import com.huajin.baymax.db.Page;

public class ParamMapUtil {
	
	public static long getTotalsize(Map<String, Object> map, long defaultValue) {
		Object object = map.get("page");
		if(object != null && object instanceof Page) {
			return ((Page)object).getCount();
		}
		return defaultValue;
	}
	
	public static long getTotalpage(Map<String, Object> map, long defaultValue) {
		Object object = map.get("page");
		if(object != null && object instanceof Page) {
			return ((Page)object).getLast();
		}
		return defaultValue;
	}
}
