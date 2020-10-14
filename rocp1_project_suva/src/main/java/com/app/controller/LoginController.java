package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.app.models.*;
import com.app.services.*;
import com.google.gson.Gson;

import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;


public class LoginController {
	
	private static final UserService us = new UserService();

	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		Gson gson=new Gson();
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null) {
		    	//System.out.println(line);
		    	jb.append(line);
		    }
		    //System.out.println(jb);
		   // String jsont = "{ \"name\": \"Baeldung\", \"java\": true }";
		    JsonObject json = new Gson().fromJson(jb.toString(), JsonObject.class);
		    User user = us.login(json.get("username").getAsString(), json.get("password").getAsString());
		    //System.out.println(u.getEmail());
//		    System.out.println(convertedObject.get("name"));
		    
		    //System.out.println(convertedObject2.get("password").getAsString());
		    
		    if( user != null) {
		    	HttpSession ses = request.getSession();
				ses.setAttribute("userid", user.getUserId());
				//System.out.println("userid: "+ user.getUserId());
				ses.setAttribute("username", user.getUsername());
				ses.setAttribute("email", user.getEmail());
				ses.setAttribute("roleId", user.getRole().getRoleId());
				//gson.toJson(player)
				user.setRoleID(user.getRole().getRoleId());
				response.setStatus(200);
				response.getWriter().println(gson.toJson(user));
		    }else {
		    	String message = "{ \"message\": \"Invalid Credentials\" }";
		    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
		    	response.getWriter().println(json2);
		    	HttpSession s = request.getSession(false);
		    	response.setStatus(400);
				if (s != null) {
					
					s.invalidate();
				}
		    }
		    
		    

//		  try {
//		    org.json.JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());
//		    System.out.println(jsonObject.getString("username"));
//		    System.out.println(jsonObject.getString("password"));
//		  } catch (Exception e) {
//		    // crash and burn
//		    throw new IOException("Error parsing JSON request string");
//		  }
		  

		
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession ses = request.getSession(false);
		
		
		if (ses != null) {
			String username = (String) ses.getAttribute("username");
			ses.invalidate();
			response.setStatus(200);
			String message = "{ \"message\": \"You have successfully logged out {username}\" }";
			StringBuffer jb = new StringBuffer();
			jb.append("{ \"message\": \"You have successfully logged out ");
			jb.append(username);
			jb.append("\" }");
	    	JsonObject json2 = new Gson().fromJson(jb.toString(), JsonObject.class);
	    	response.getWriter().println(json2);
		} else {
			response.setStatus(400);
			String message = "{ \"message\": \"There was no user logged into the session\" }";
	    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
	    	response.getWriter().println(json2);
		}
		
		
	}

}
