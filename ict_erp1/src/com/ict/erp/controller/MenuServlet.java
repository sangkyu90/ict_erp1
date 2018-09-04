package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.MenuService;
import com.ict.erp.service.impl.MenuServiceImpl;
import com.ict.erp.vo.MenuInfo;

public class MenuServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private String uri;
   private MenuService ms = new MenuServiceImpl();

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      uri = request.getRequestURI();
      String cmd = ICTUtils.getCmd(uri);
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      try {
         if (cmd.equals("menuList")) {
           
           request.setAttribute("menuList",ms.selectMenuList(null));
            doService(request, response);
         } else if (cmd.equals("menuView")) {
            String meiNumStr = request.getParameter("meiNum");
            if (meiNumStr == null || meiNumStr.equals("")) {
               throw new SQLException("메뉴번호 없음");
            }
            MenuInfo menu = new MenuInfo();
            menu.setMeiNum((Long.parseLong(meiNumStr)));
            out.print(ms.selectMenu(menu));
         }
      } catch (SQLException e) {
         out.println("에러");
         out.println("이유는 " + e);
      }
      // doService(request,response);
   }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         uri = request.getRequestURI();
         String cmd = ICTUtils.getCmd(uri);
         response.setContentType("text/html;charset=utf-8");
         PrintWriter pw = response.getWriter();
         request.setCharacterEncoding("utf-8");
         try {
            if(cmd.equals("menuInsert")) {
               String meiName = request.getParameter("meiName");
               String meiPrice = request.getParameter("meiPrice");
               String meiDesc = request.getParameter("meiDesc");
               MenuInfo menu = new MenuInfo(null, meiName, Long.parseLong(meiPrice),meiDesc);
                  pw.println(ms.insertMenu(menu));
                     
            }else if(cmd.equals("menuUpdate")) {
               
            }else if(cmd.equals("menuDelete")) {
               
            }
         }catch(SQLException e) {
            pw.print("error");
            pw.print("reason:"+e);
         }
      }

    
    
  /* public static void main(String[] args) {
      MenuServlet hs = new MenuServlet();
      try {
         hs.doGet(null, null);
      } catch (ServletException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }
*/
   public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String uri = "/views" + request.getRequestURI();
      RequestDispatcher rd = request.getRequestDispatcher(uri);
      rd.forward(request, response);
   }

}