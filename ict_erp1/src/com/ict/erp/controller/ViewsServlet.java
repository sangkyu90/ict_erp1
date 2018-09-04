package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewsServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String uri =(String)request.getRequestURI();
		uri ="/WEB-INF"+uri+".jsp";
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request,response);
	}
	}
	
	

