package com.ict.erp.common;

import java.util.ArrayList;
import java.util.List;

import com.ict.erp.vo.Menu;

public class MenuUtils {
	private static List<Menu> menuList; 
			
	
	public static List<Menu> getMenuList(Object obj){
		menuList = new ArrayList<Menu>();
		Menu m = new Menu("views/index.jsp","home","Home");
		menuList.add(m);
		if(obj==null) {
			m = new Menu("views/user/login.jsp","login","Login");
			menuList.add(m);
		}else {
			m = new Menu("views/user/logout.jsp","logout","Logout");
			menuList.add(m);
		}
		m = new Menu("views/user/signup.jsp","signup","Signup");
		menuList.add(m);
		m = new Menu("views/user/userList.jsp","userlist","User List");
		menuList.add(m);
		return menuList;
	}
	
	public static String getCommand(String uri) {
		return uri.substring(uri.lastIndexOf("/")+1);
	}
}
