package com.ict.erp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ict.erp.common.IBean;
import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.MusicService;
import com.ict.erp.service.impl.MusicServiceImpl;
import com.ict.erp.vo.MusicChart;
/*
 * web.xml에 해당 서블릿이 등록 되어 있어야 함.
 * 
  <servlet>
    <servlet-name>MusicServlet</servlet-name>
    <servlet-class>com.ict.erp.servlet.MusicServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>MusicServlet</servlet-name>
    <url-pattern>/music/*</url-pattern>
  </servlet-mapping>
  
  url-pattern은 클라어인트의 요청에 대한 패턴으로 예를들어
	  localhost/music/abc
	  localhost/music
	  localhost/music/1
	  localhost/music/1/2/3
     위의 url-pattern모두 MusicServlet을 호출한다.
  localhost이후부터 /music/ <--이 들어가 있으면 만족함.
 */
public class MusicServlet extends HttpServlet {

	private Log log = LogFactory.getLog(this.getClass());
	private static final long serialVersionUID = 1L;
	private String uri;
    private MusicService ms = new MusicServiceImpl();
    /*
     * doGet 메소드는 클라이언트에서 get방식으로 보냈을때 실행되는 함수이다.
	  	예를들어 localhost/music/musicChart 라는 url로 method방식을 get으로 요청할경우
	  	web.xml에 기술되어있는 url-pattern /music/*을 만족하기 때문에
	  	MusicServlet을 생성(생성되어있을경우엔 다시 생성안함) 하고
	  	doGet메소드를 자동으로 호출한다.
     */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		uri =  req.getRequestURI();
		//클라이언트의 요청이 무엇인지 판단하기 위해 마지막 '/'를 기준으로 uri를 잘라준다.
		String cmd = ICTUtils.getCmd(uri);
		try {
			
			MusicChart mc = IBean.parseRequest(req,MusicChart.class);

			log.trace(mc);
			log.debug(mc);
			log.info(mc);
			log.warn(mc);
			log.error(mc);
			log.fatal(mc); 
			//클라이언트의 요청이 musicChart일경우(uri : localhost/music/musicChart)
			if(cmd.equals("musicChart")) {
				//뮤직서비스에서 music리스트를 리턴하는 함수를 호출해준다.
				List<MusicChart> musicList = ms.selectMusicList(mc);
				req.setAttribute("musicList", musicList);
				//해당 리스트를 포워딩할 jsp에서 포문을 돌리며 출력해주기위해
				//musicList라는 키값을 저장한다.
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//최하단에 있는 doService 메소드를 호출한다.
		doService(req,res);
	}

	/*
	 * doPost 메소드는 클라이언트에서 post방식으로 보냈을때 실행되는 함수이다.
		예를들어 localhost/music/musicInsert 라는 url로 method방식을 post으로 요청할경우
		web.xml에 기술되어있는 url-pattern /music/*을 만족하기 때문에
		MusicServlet을 생성(생성되어있을경우엔 다시 생성안함) 하고
		doPost메소드를 자동으로 호출한다.
		위의 설명된것과 같이 똑같은 url로 호출한다고 하더라도
		클라이언트의 method방식에 따라 doGet//doPost가 실행된다.
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		uri =  req.getRequestURI();
		//클라이언트의 요청이 무엇인지 판단하기 위해 마지막 '/'를 기준으로 uri를 잘라준다.
		String cmd = ICTUtils.getCmd(uri);
		try {
			MusicChart mc = IBean.parseRequest(req,MusicChart.class);
			log.debug(mc);
			//클라이언트의 요청이 musicInsert일경우(uri : localhost/music/musicInsert)
			if(cmd.equals("musicInsert")) {
				//뮤직서비스에서 music목록을 인서트 함수를 호출해준다.
				//cnt라는 키값으로 저장된 로우갯수를 저장한다.(1건일경우 1이여야 정상)
				req.setAttribute("cnt", ms.insertMusic(mc));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//최하단에 있는 doService 메소드를 호출한다.
		doService(req,res);
	}
	private void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 클라이언트에서 요청한 uri앞에 '/views'를 붙여서 포워딩해준다.
		// '/views'를 붙이는 이유는 ViewServlet을 호출하기 위해서임.
		RequestDispatcher rd = req.getRequestDispatcher("/views" + uri);
		rd.forward(req, res);
	}

}