package com.ict.erp;

import java.lang.reflect.Method;

public class ReflTest {
	
	public static void main(String[] args) {
		String classPath = "com.ict.erp.Person";
		
		try {
		Class clazz = Class.forName(classPath);
		Object obj = clazz.newInstance();
		System.out.println(obj);
		Method[] methods = clazz.getMethods();
		
		for(Method meth : methods) {
			System.out.println(meth.getName());
		}
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
