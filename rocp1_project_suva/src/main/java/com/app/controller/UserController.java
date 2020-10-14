package com.app.controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.app.models.*;
import com.app.services.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class UserController {
	private static final UserService userService = new UserService();
	public void register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Gson gson=new Gson();
		User user=gson.fromJson(request.getReader(), User.class);
		//response.getWriter().println(gson.toJson(user));
		
		if(userService.findByEmail(user.getEmail())!=null ||  userService.findByUsername(user.getUsername())!=null ) {
			response.setStatus(400);
			
			String message = "{ \"message\": \"Invalid fields\" }";
	    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
	    	response.getWriter().println(json2);
		}else {
			User u = userService.register(user);
			if(u != null) {
				response.setStatus(201);
				response.getWriter().println(gson.toJson(u));
			}
		}
		
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Gson gson=new Gson();
		User user=gson.fromJson(request.getReader(), User.class);
		
		boolean result = userService.deleteUser(user);
		if(result) {
			response.setStatus(201);
			response.getWriter().println(gson.toJson(user));
		}else {
			response.setStatus(400);
			String message = "{ \"message\": \"Deletion Error - Check Input\" }";
	    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
	    	response.getWriter().println(json2);
		}
	}

	public void update(HttpServletRequest request, HttpServletResponse response, int roleId)throws ServletException, IOException {
		
		Gson gson=new Gson();
		User user=gson.fromJson(request.getReader(), User.class);
		//System.out.println(user.getUserId());
		HttpSession ses = request.getSession(false);
		if(ses != null) {
			if(roleId ==1 || user.getUserId() == (int)ses.getAttribute("userid")) {
				User u2 = userService.updateUser(user);
				if(u2 != null) {
					response.getWriter().println(gson.toJson(user));
					response.setStatus(200);
				}else {
					String message = "{ \"message\": \"Failed to Update- Check ID\" }";
			    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
			    	response.getWriter().println(json2);
				}
			}else {
				response.setStatus(401);
				String message = "{ \"message\": \"The requested action is not permitted\" }";
		    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
		    	response.getWriter().println(json2);
			}
		}
		
		
	}
	public void findById(HttpServletRequest request, HttpServletResponse response, String s,int roleId)throws ServletException, IOException {
		int id = Integer.parseInt(s);
		Gson gson=new Gson();
		User user = userService.findById(id);
		HttpSession ses = request.getSession(false);
		if(ses != null) {
			if(id == (int)ses.getAttribute("userid")|| roleId==1 || roleId ==2  ) {
				
			}else {
				response.setStatus(401);		
				String message = "{ \"message\": \"The requested action is not permitted\" }";
		    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
		    	response.getWriter().println(json2);
		    	return;
			}
		}
		
		if(user!= null) {
			response.setStatus(200);
			response.getWriter().println(gson.toJson(user));
		}else {
			response.setStatus(400);
			String message = "{ \"message\": \"Invalid entry\" }";
	    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
	    	response.getWriter().println(json2);
		}
		
	}
	public boolean findById2(HttpServletRequest request, HttpServletResponse response, String s)throws ServletException, IOException {
		int id = Integer.parseInt(s);
		Gson gson=new Gson();
		User user = userService.findById(id);
		HttpSession ses = request.getSession(false);
//		if(user.getUserId() != (int)ses.getAttribute("userid")) {
//			return false;
//		}
		if(user!= null) {
			response.setStatus(200);
			response.getWriter().println(gson.toJson(user));
			
		}else {
			response.setStatus(400);
			String message = "{ \"message\": \"Invalid\" }";
	    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
	    	response.getWriter().println(json2);
		}
		return true;
	}
	
	public void findAllUsers(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<User> UL =userService.findAllUsers();
		Gson gson=new Gson();
		
		response.getWriter().println(gson.toJson(UL));
		
	}

}
