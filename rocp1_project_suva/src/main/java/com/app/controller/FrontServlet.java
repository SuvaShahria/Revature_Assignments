package com.app.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


/**
 * Servlet implementation class FrontServlet
 */
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int count;
	private static final LoginController login = new LoginController();
	private static final UserController userController = new UserController();
	private static final AccountController accountController = new AccountController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("in doGet"); 
		entry(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		entry(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		entry(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		entry(request, response);
	}
	protected void entry(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(404);
		int roleId = 0;
		
		HttpSession ses = request.getSession(false);
		if(ses != null) {
			roleId = (int) ses.getAttribute("roleId");
			
		}
		String url = request.getRequestURI().replace("/rocp1_project/", "");
		String method = request.getMethod();
		String[] urlSplit = url.split("/");
//		System.out.println("url is: "+url);
//		System.out.println(method);				
//		System.out.println("Url "+Arrays.toString(urlSplit));
//		System.out.println("url length is "+urlSplit.length);
//		System.out.println("Url "+Arrays.toString(urlSplit));
//		for(int i = 0; i <urlSplit.length; i++) {
//			System.out.println(urlSplit[i]);
//		}
//		System.out.println("-------"+urlSplit[0]);
		switch(urlSplit[0]) {
		case "login":
			if (method.equals("POST")) {
				
				login.login(request, response);
			}else {
				response.getWriter().println("Not supported method");			
			}
			//System.out.println("login");
			break;
		case "logout":
			if (method.equals("POST")) {
				login.logout(request, response);
			}else {
				response.setStatus(400);			
			}
			//System.out.println("logout");
			break;
		case "users":
			if (method.equals("POST")) {
				if(roleId == 1) {
					userController.register(request, response);
				}else {
					response.setStatus(401);
					String message = "{ \"message\": \"The requested action is not permitted\" }";
			    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
			    	response.getWriter().println(json2);	
				}
			}else if(method.equals("DELETE")) {
				if(roleId == 1) {
					userController.delete(request, response);
				}else {
					response.setStatus(401);
					String message = "{ \"message\": \"The requested action is not permitted\" }";
			    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
			    	response.getWriter().println(json2);		
				}
			}else if(method.equals("PUT")) {
				userController.update(request,response,roleId);
				
			}else if(method.equals("GET")) {
				if(urlSplit.length != 2) {
					if(roleId == 1 || roleId == 2) {
						userController.findAllUsers(request,response);
					}else {
						response.setStatus(401);		
						String message = "{ \"message\": \"The requested action is not permitted\" }";
				    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
				    	response.getWriter().println(json2);
					}
				}else {
					userController.findById(request,response,urlSplit[1],roleId);
				}
				//System.out.println(urlSplit.length);
//				if(userController.findById2(request,response,urlSplit[1])) {
//					
//				}else {
//					
//				}
//				if(roleId == 1 || roleId == 2) {
//					
//					if(urlSplit.length != 2) {
//						userController.findAllUsers(request,response);
//						//System.out.println(urlSplit.length);
//						//System.out.println("t"+ urlSplit[1]);
//						
//					} else {
//						userController.findById(request,response,urlSplit[1]);
//						//System.out.println(urlSplit[1]);
//						//System.out.println(urlSplit[1]);
//						
//					}
//				}else {
//				
//					response.setStatus(401);		
//					String message = "{ \"message\": \"The requested action is not permitted\" }";
//			    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
//			    	response.getWriter().println(json2);
//				}
			}
			
			//System.out.println("users");
			break;
		case "accounts":
			
			if (method.equals("POST")) {
				if(urlSplit.length == 1) {
					accountController.insertAccount(request,response,roleId);
				}else {
					if(urlSplit[1].equals("deposit")) {
						accountController.deposit(request,response,roleId);
					}else if(urlSplit[1].equals("withdraw")) {
						accountController.withdraw(request,response,roleId);
					}else if(urlSplit[1].equals("transfer")) {
						accountController.transfer(request,response,roleId);
					}
				}
				
			}else if (method.equals("PUT")) {
				
				accountController.updateAccount(request,response,roleId);
			}else if (method.equals("DELETE")) {
				if(roleId == 1) {
					accountController.delete(request,response);
				}else {
					response.setStatus(401);		
					String message = "{ \"message\": \"The requested action is not permitted\" }";
			    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
			    	response.getWriter().println(json2);
				}
			}else if (method.equals("GET")) {
				if(urlSplit.length == 1) {
					if(roleId == 1 || roleId == 2) {
						accountController.findAll(request,response);
					}else {
						response.setStatus(401);		
						String message = "{ \"message\": \"The requested action is not permitted\" }";
				    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
				    	response.getWriter().println(json2);
					}
				}else if(urlSplit.length == 2) {
					accountController.findById(request,response, roleId, urlSplit[1] );
				}else {
					if(urlSplit[1].equals("status")) {
						if(roleId == 1 || roleId == 2) {
							accountController.findAllByStatusId(request, response, urlSplit[2]);
						}else {
							response.setStatus(401);		
							String message = "{ \"message\": \"The requested action is not permitted\" }";
					    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
					    	response.getWriter().println(json2);
						}
					}else {
						if(roleId == 1 || roleId == 2 ||  (urlSplit[1].equals(ses.getAttribute("username")) && Integer.parseInt(urlSplit[2])==  (int)ses.getAttribute("userid")) ) {
							accountController.findByAllId(request, response, roleId, urlSplit[2]);
							System.out.println(urlSplit[1]+" "+urlSplit[2]);
							
							
						}else {
							response.setStatus(401);		
							String message = "{ \"message\": \"The requested action is not permitted\" }";
					    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
					    	response.getWriter().println(json2);
					    	
						}
					}
					
					
				}
					
			}
			
			break;
		default:
			//System.out.println("default");
			break;
		}
		
		
		
		
	}

}
