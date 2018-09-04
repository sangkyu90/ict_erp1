package com.ict.erp.common;

import java.util.HashMap;
import java.util.Map;

import com.ict.erp.service.CommonService;

public class ServiceFactory {
	private static final Map<String,CommonService> SERVICE_CONTAINER; 
	static {
    	SERVICE_CONTAINER = new HashMap<String,CommonService>();
	}
	
	public static CommonService getService(String key) {
		return SERVICE_CONTAINER.get(key);
	}
	public static void setService(String key, String className) {
		try {
			Class clazz = Class.forName(className);
			SERVICE_CONTAINER.put(key, (CommonService)clazz.newInstance());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (InstantiationException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}