package com.hsx.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtil {

	public static <T> T request2FormBean(HttpServletRequest request, Class<T> clazz) {
		try {
			T t = clazz.newInstance();
			Map map = request.getParameterMap();
			BeanUtils.populate(t, map);
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
