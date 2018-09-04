package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.DepartService;
import com.ict.erp.service.impl.DepartServiceImpl;
import com.ict.erp.vo.DepartInfo;
import com.ict.erp.vo.PageInfo;

@WebServlet(
		urlPatterns = "/depart/*",
		name="DepartServlet"
)
public class DepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartService ds = new DepartServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cmd = ICTUtils.getCmd(req.getRequestURI());
		try {
			if(cmd.equals("departList")) {
				String pageStr = req.getParameter("page");
				if(pageStr==null || pageStr.equals("")) {
					pageStr = "1"; 
				}
				int page = Integer.parseInt(pageStr);
				PageInfo pi = new PageInfo();
				pi.setPage(page);
				DepartInfo di = new DepartInfo(); 
				di.setPi(pi);
				req.setAttribute("diList",ds.getDepartInfoList(di));
				req.setAttribute("page", pi);
			}else if(cmd.equals("departView")||cmd.equals("departUpdate")) {
				String diNumStr = req.getParameter("diNum");
				req.setAttribute("di",ds.getDepartInfo(Integer.parseInt(diNumStr)));
			}else {
				
			}
		}catch(SQLException e) {
			
		} 
		doService(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cmd = ICTUtils.getCmd(req.getRequestURI());
		req.setCharacterEncoding("utf-8");
		try {
			if(cmd.equals("departInsert")) {
				String diCode = req.getParameter("diCode");
				String diName = req.getParameter("diName");
				String diDesc = req.getParameter("diDsc");
				DepartInfo di = new DepartInfo(0,diCode, diName, diDesc);
				req.setAttribute("rMap", ds.insertDepartInfo(null));
			}else if(cmd.equals("departUpdate")) {
				String diNumStr = req.getParameter("diNum");
				String diCode = req.getParameter("diCode");
				String diName = req.getParameter("diName");
				String diDesc = req.getParameter("diDesc");
				DepartInfo di = new DepartInfo(Integer.parseInt(diNumStr),diCode, diName, diDesc);
				req.setAttribute("rMap", ds.updateDepartInfo(di));
			}else if(cmd.equals("departDelete")) {
				String diNumStr = req.getParameter("diNum");
				System.out.println(diNumStr);
				DepartInfo di = new DepartInfo(Integer.parseInt(diNumStr),null, null, null);
				req.setAttribute("rMap", ds.deleteDepartInfo(di));
			}else {
				
			}
		}catch(SQLException e) {
			
		}
		doService(req,res);
	}
	
	public void doService(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		String uri = "/views" + req.getRequestURI();
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}
}