package com.ict.erp.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.BeanProcessor;

public class ICTUtils {
	private static final String PRE_FIX = "/WEB-INF";
	private static final String SUF_FIX = ".jsp";
	private static final String SEP_STR = "/";
	
	public static String getCmd(String uri) {
		int idx = uri.lastIndexOf(SEP_STR);
		if(idx==-1) {
			return null;
		}
		return uri.substring(idx+1);
	}
	
	public static String getJSPPage(String uri) {
		return PRE_FIX + uri + SUF_FIX;
	}
	
	public static <T> List<T> parseList(ResultSet rs ,Class clazz) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int cnt = rsmd.getColumnCount();
		List<T> list = new ArrayList<T>();
		while(rs.next()) {
			try {
				T t = (T) clazz.newInstance();
				Method[] methods = clazz.getMethods();
				for(Method method : methods) {
					String mNm = method.getName();
					if(mNm.indexOf("set")==0) {
						for(int i=1;i<=cnt;i++) {
							String colNm = rsmd.getColumnLabel(i);
							if(mNm.toUpperCase().indexOf(colNm.toUpperCase())!=-1) {
								String colTypeNm = rsmd.getColumnTypeName(i);
								if(colTypeNm.equals("NUMBER")) {

									Class<?>[] types = method.getParameterTypes();
									System.out.println(types[0]);
									
									if(types[0].getTypeName().equalsIgnoreCase("java.lang.Long")) {
										method.invoke(t, rs.getLong(colNm));
									}else if(types[0].getTypeName().equalsIgnoreCase("java.lang.Integer")){
										method.invoke(t, rs.getInt(colNm));
									}
								}else {
									method.invoke(t, rs.getString(colNm));
								}
							}
						}
					}
				}
				list.add(t);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public static <T> T parse(ResultSet rs ,Class clazz) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int cnt = rsmd.getColumnCount();
		T t = null;
		while(rs.next()) {
			try {
				t = (T) clazz.newInstance();
				Method[] methods = clazz.getMethods();
				for(Method method : methods) {
					String mNm = method.getName();
					if(mNm.indexOf("set")==0) {
						for(int i=1;i<=cnt;i++) {
							String colNm = rsmd.getColumnLabel(i);
							if(mNm.toUpperCase().indexOf(colNm.toUpperCase())!=-1) {
								String colTypeNm = rsmd.getColumnTypeName(i);
								if(colTypeNm.equals("NUMBER")) {
									method.invoke(t, rs.getLong(colNm));
								}else {
									method.invoke(t, rs.getString(colNm));
								}
							}
						}
					}
				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return t;
	}
	public static <T> T parse(HttpServletRequest req, Class clazz){
		Map<String,String[]> pMap = req.getParameterMap();
		Iterator<String> it = pMap.keySet().iterator();
		Method[] methods = clazz.getMethods();
		T obj = null;
		try {
			obj = (T) clazz.newInstance();
			while(it.hasNext()) {
				String key = it.next();
				for(Method method : methods) {
					String mName = method.getName();
					if(mName.indexOf("set")==0) {
						if(mName.toUpperCase().indexOf(key.toUpperCase())!=-1) {
							Class<?>[] types = method.getParameterTypes();
							System.out.println(types[0]);
							
							if(types[0].getTypeName().equalsIgnoreCase("java.lang.Long")) {
								method.invoke(obj, Long.parseLong(pMap.get(key)[0]));
							}else {
								method.invoke(obj, pMap.get(key)[0]);
							}
						}
					}
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}