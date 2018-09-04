package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ict.erp.service.DepartService;
import com.ict.erp.service.MenuService;
import com.ict.erp.service.impl.DepartServiceImpl;
import com.ict.erp.service.impl.MenuServiceImpl;
import com.ict.erp.vo.DepartInfo;
import com.ict.erp.vo.MenuInfo;

public class JsonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Gson gs = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> pMap = gs.fromJson(request.getParameter("param"), Map.class);
		System.out.println(pMap);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		DepartService ds = new DepartServiceImpl();
		try {
			List<DepartInfo> departList = ds.getDepartInfoNonePageList(null);
			String resStr = gs.toJson(departList);
			pw.println(resStr);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		/*List<String> strList = new ArrayList<String>();
		for(int i=1; i<=10; i++) {
			strList.add("번호 : " + i);
		}
		String resStr = gs.toJson(strList);
		pw.println(resStr);*/

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> pMap = gs.fromJson(request.getParameter("param"), Map.class);
		System.out.println(pMap);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		MenuService ms = new MenuServiceImpl();
		try {
			List<MenuInfo> menuList = ms.selectMenuList(null);
			String resStr = gs.toJson(menuList);
			pw.println(resStr);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String jsonStr = "[{\"a\":\"1\"},{\"b\":\"2\"}]";
		Gson gs = new Gson();
		List<Map<String,String>> list = gs.fromJson(jsonStr, List.class);
		System.out.println(list);
	}
}
