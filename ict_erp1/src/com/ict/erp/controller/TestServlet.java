package com.ict.erp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.TestService;
import com.ict.erp.service.impl.TestServiceImpl;
import com.ict.erp.vo.TestInfo;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TestService ts = new TestServiceImpl();   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		try {
			if(cmd.equals("testList")) {
				String shType = request.getParameter("shType");
				String shText = request.getParameter("shText");
				TestInfo ti = null;
				if(shText!=null) {
					ti = new TestInfo();
					if(shType.equals("tiNum")) {
						ti.setTiNum(Integer.parseInt(shText));
					}else if(shType.equals("tiName")) {
						ti.setTiName(shText);
					}else if(shType.equals("tiId")) {
						ti.setTiId(shText);
					}else if(shType.equals("tiText")) {
						ti.setTiText(shText);
					}
				}
				request.setAttribute("tiList", ts.getTestList(ti));
			}else if(cmd.equals("testView")) {
				int tiNum = Integer.parseInt(request.getParameter("tiNum"));
				request.setAttribute("testInfo", ts.getTestInf(tiNum));
			}
		}catch(Exception e) {
			uri = "/error";
			request.setAttribute("error", e.getMessage());
		}
		uri = "/views" + uri;
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
