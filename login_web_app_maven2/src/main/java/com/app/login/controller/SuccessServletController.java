package com.app.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SuccessServletController
 */
public class SuccessServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("application/json");
//		int roleId = 0;
//		int authUserId = 0;
//		HttpSession ses = request.getSession(false);
//		if(ses != null) {
//			roleId = (int) ses.getAttribute("roleId");
//			authUserId = (int) ses.getAttribute("userid");
//			System.out.println(roleId);
//		}
//		System.out.println(roleId);
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int roleId = 0;
		roleId = Integer.parseInt(request.getParameter("roleId"));
		
//		HttpSession ses = request.getSession(false);
//		if(ses != null) {
//			roleId = (int) ses.getAttribute("roleId");
//			
//			System.out.println(roleId);
//		}
		System.out.println(roleId);	
	}

}
