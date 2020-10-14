package com.app.controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.app.models.*;
import com.app.services.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class AccountController {
	private static final AccountServices as = new AccountServices();

	public void insertAccount(HttpServletRequest request, HttpServletResponse response, int roleId)throws ServletException, IOException{
		
		Gson gson=new Gson();
		
		Account ac =gson.fromJson(request.getReader(), Account.class);
		//response.getWriter().println(gson.toJson(ac));
		HttpSession ses = request.getSession(false);
		if(ses != null) {
			if(roleId == 1 || roleId == 2 || ac.getUserId()== (int)ses.getAttribute("userid")) {
				//response.getWriter().println(gson.toJson(ac));
				Account ac2 = as.insertAccount(ac);
				if(ac2 != null) {
					response.getWriter().println(gson.toJson(ac2));
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
		    	return;
			}
		}
		
	}

	public void updateAccount(HttpServletRequest request, HttpServletResponse response, int roleId)throws ServletException, IOException {
Gson gson=new Gson();
		
		Account ac =gson.fromJson(request.getReader(), Account.class);
		//response.getWriter().println(gson.toJson(ac));
		HttpSession ses = request.getSession(false);
		System.out.println(ac.getUserId());
		System.out.println((int)ses.getAttribute("userid"));
		if(ses != null) {
			if(roleId == 1 || roleId == 2 || ac.getUserId()== (int)ses.getAttribute("userid")) {
				//response.getWriter().println(gson.toJson(ac));
				Account ac2 = as.updateAccount(ac,roleId);
				if(ac2 != null) {
					response.getWriter().println(gson.toJson(ac2));
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
		    	return;
			}
		}
		
	}

	public void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Gson gson=new Gson();
		Account act=gson.fromJson(request.getReader(), Account.class);
		//response.getWriter().println(gson.toJson(act));
		Account result = as.deleteUser(act);
		if(result != null) {
			response.setStatus(201);
			response.getWriter().println(gson.toJson(result));
		}else {
			response.setStatus(400);
			String message = "{ \"message\": \"Deletion Error - Check Input\" }";
	    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
	    	response.getWriter().println(json2);
		}
		
	}

	public void findAll(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("test");
		List<Account> accounts = as.findAll();
		Gson gson=new Gson();
		
		response.getWriter().println(gson.toJson(accounts));
		
	}

	public void findById(HttpServletRequest request, HttpServletResponse response, int roleId, String s) throws ServletException, IOException{
		// TODO Auto-generated method stub
		int id = Integer.parseInt(s);
		Gson gson=new Gson();
		HttpSession ses = request.getSession(false);
		Account account = as.findById(id);
		if(account != null) {
			if(roleId == 1 || roleId == 2 || account.getUserId()== (int)ses.getAttribute("userid")) {
				response.getWriter().println(gson.toJson(account));
				response.setStatus(200);
			}else {
				response.setStatus(401);		
				String message = "{ \"message\": \"The requested action is not permitted\" }";
		    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
		    	response.getWriter().println(json2);
		    	return;
			}
		}else {
			response.setStatus(401);
			String message = "{ \"message\": \"Failed to find account\" }";
	    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
	    	response.getWriter().println(json2);
		}
		
//		if(roleId == 1 || roleId == 2 || id== (int)ses.getAttribute("userid")) {
//			
//			Account account = as.findById(id);
//			
//			if(account != null) {
//				response.getWriter().println(gson.toJson(account));
//				response.setStatus(200);
//			}else {
//				String message = "{ \"message\": \"Failed to find accounts\" }";
//		    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
//		    	response.getWriter().println(json2);
//			}
//		}else {
//			response.setStatus(401);		
//			String message = "{ \"message\": \"The requested action is not permitted\" }";
//	    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
//	    	response.getWriter().println(json2);
//	    	return;
//		}
	}
	
	public void findByAllId(HttpServletRequest request, HttpServletResponse response, int roleId, String s) throws ServletException, IOException{
		// TODO Auto-generated method stub
		int id = Integer.parseInt(s);
		Gson gson=new Gson();
		HttpSession ses = request.getSession(false);
		if(roleId == 1 || roleId == 2 || id== (int)ses.getAttribute("userid")) {
			
			List<Account> accounts = as.findAccountsById(id);
			
			if(accounts != null) {
				response.getWriter().println(gson.toJson(accounts));
				response.setStatus(200);
			}else {
				String message = "{ \"message\": \"Failed to find accounts\" }";
		    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
		    	response.getWriter().println(json2);
			}
		}else {
			response.setStatus(401);		
			String message = "{ \"message\": \"The requested action is not permitted\" }";
	    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
	    	response.getWriter().println(json2);
	    	return;
		}
	}

	public void findAllByStatusId(HttpServletRequest request, HttpServletResponse response, String s) throws ServletException, IOException{
		// TODO Auto-generated method stub
		int id = Integer.parseInt(s);
		Gson gson=new Gson();
		HttpSession ses = request.getSession(false);
			
			List<Account> accounts = as.findAccountsByStatusId(id);
			
			if(accounts != null) {
				response.getWriter().println(gson.toJson(accounts));
				response.setStatus(200);
			}else {
				String message = "{ \"message\": \"Failed to find accounts\" }";
		    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
		    	response.getWriter().println(json2);
			}
		
		
		
	}

	public void deposit(HttpServletRequest request, HttpServletResponse response, int roleId) throws ServletException, IOException {
		// System.out.println("test");
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
		    JsonObject json = new Gson().fromJson(jb.toString(), JsonObject.class);
		    JsonElement tmp =  json.get("accountId");
		    int acId = tmp.getAsInt();
		    HttpSession ses = request.getSession(false);
		    if(ses == null) {
		    	return;
		    }
			Account account = as.findById(acId);
			if(account != null) {
				if(roleId == 1 ||  account.getUserId()== (int)ses.getAttribute("userid")) {
					tmp = json.get("amount");
					float f = tmp.getAsFloat();
					if(account.getStatusId() == 2) {
						account.setBalance(account.getBalance()+f);
						as.updateBalance(account);
						response.setStatus(401);		
						StringBuffer jb2 = new StringBuffer();
						//"message": "${amount} has been withdrawn from Account #{accountId}"
						//{ \"message\": \"The account is not Open\" }
						jb2.append("{ \"message\": \"$");
						jb2.append(f);
						jb2.append(" has been deposited to Account #");
						jb2.append(account.getAccountId());
						jb2.append("\" }");
				    	JsonObject json2 = new Gson().fromJson(jb2.toString(), JsonObject.class);
				    	response.getWriter().println(json2);
				    	response.setStatus(200);
				    	return;
					}else {
						response.setStatus(401);		
						String message = "{ \"message\": \"The account is not Open\" }";
				    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
				    	response.getWriter().println(json2);
				    	return;
					}
				}else {
					response.setStatus(401);		
					String message = "{ \"message\": \"The requested action is not permitted\" }";
			    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
			    	response.getWriter().println(json2);
			    	return;
				}
			}else {
				response.setStatus(401);
				String message = "{ \"message\": \"Failed to find account\" }";
		    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
		    	response.getWriter().println(json2);
			}
		    
//		HttpSession ses = request.getSession(false);
//		if(roleId == 1 ||  id== (int)ses.getAttribute("userid")) {
//			
//		}
		
	}
	public void withdraw(HttpServletRequest request, HttpServletResponse response, int roleId) throws ServletException, IOException {
		// System.out.println("test");
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
		    JsonObject json = new Gson().fromJson(jb.toString(), JsonObject.class);
		    JsonElement tmp =  json.get("accountId");
		    int acId = tmp.getAsInt();
		    HttpSession ses = request.getSession(false);
		    if(ses == null) {
		    	return;
		    }
			Account account = as.findById(acId);
			if(account != null) {
				if(roleId == 1 ||  account.getUserId()== (int)ses.getAttribute("userid")) {
					tmp = json.get("amount");
					float f = tmp.getAsFloat();
					if(account.getStatusId() == 2) {
						if((account.getBalance() - f) >= 0 ) {
							account.setBalance(account.getBalance()-f);
							as.updateBalance(account);
							response.setStatus(401);		
							StringBuffer jb2 = new StringBuffer();
							//"message": "${amount} has been withdrawn from Account #{accountId}"
							//{ \"message\": \"The account is not Open\" }
							jb2.append("{ \"message\": \"$");
							jb2.append(f);
							jb2.append(" has been withdrawn from Account #");
							jb2.append(account.getAccountId());
							jb2.append("\" }");
					    	JsonObject json2 = new Gson().fromJson(jb2.toString(), JsonObject.class);
					    	response.getWriter().println(json2);
					    	response.setStatus(200);
					    	return;
						}else {
							response.setStatus(401);		
							String message = "{ \"message\": \"Not enough funds\" }";
					    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
					    	response.getWriter().println(json2);
					    	return;
						}
						
					}else {
						response.setStatus(401);		
						String message = "{ \"message\": \"The account is not Open\" }";
				    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
				    	response.getWriter().println(json2);
				    	return;
					}
				}else {
					response.setStatus(401);		
					String message = "{ \"message\": \"The requested action is not permitted\" }";
			    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
			    	response.getWriter().println(json2);
			    	return;
				}
			}else {
				response.setStatus(401);
				String message = "{ \"message\": \"Failed to find account\" }";
		    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
		    	response.getWriter().println(json2);
			}
		    
//		HttpSession ses = request.getSession(false);
//		if(roleId == 1 ||  id== (int)ses.getAttribute("userid")) {
//			
//		}
		
	}
	public void transfer(HttpServletRequest request, HttpServletResponse response, int roleId) throws ServletException, IOException {
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
		    JsonObject json = new Gson().fromJson(jb.toString(), JsonObject.class);
		    JsonElement tmp =  json.get("sourceAccountId");
		    int ac1 = tmp.getAsInt();
		    tmp =  json.get("targetAccountId");
		    int ac2 = tmp.getAsInt();
		    tmp = json.get("amount");
			float f = tmp.getAsFloat();
		    HttpSession ses = request.getSession(false);
		    
			Account acc1 = as.findById(ac1);
			Account acc2 = as.findById(ac2);
			
			if(acc1 == null || acc2 == null) {
				response.setStatus(401);
				String message = "{ \"message\": \"Failed to find account\" }";
		    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
		    	response.getWriter().println(json2);
				return;
			}
			
			if(ses == null) {
				return;
			}
			if(roleId == 1 ||  acc1.getUserId()== (int)ses.getAttribute("userid")) {
				if(acc1.getStatusId() == 2  &&  acc2.getStatusId() == 2) {
					
					if((acc1.getBalance() - f) >= 0 ) {
						acc1.setBalance(acc1.getBalance()-f);
						acc2.setBalance(acc2.getBalance()+f);
						as.updateBalance(acc1);
						as.updateBalance(acc2);
		
						StringBuffer jb2 = new StringBuffer();
						//"message": "${amount} has been withdrawn from Account #{accountId}"
						//{ \"message\": \"The account is not Open\" }
						jb2.append("{ \"message\": \"$");
						jb2.append(f);
						jb2.append(" has been transferred from Account #");
						jb2.append(acc1.getAccountId());
						jb2.append(" to account #");
						jb2.append(acc2.getAccountId());
						jb2.append("\" }");
				    	JsonObject json2 = new Gson().fromJson(jb2.toString(), JsonObject.class);
				    	response.getWriter().println(json2);
				    	response.setStatus(200);
				    	return;
					}else {
						response.setStatus(401);		
						String message = "{ \"message\": \"Not enough funds\" }";
				    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
				    	response.getWriter().println(json2);
				    	return;
					}
					
				}else {
					response.setStatus(401);		
					String message = "{ \"message\": \"The accounts is not Open\" }";
			    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
			    	response.getWriter().println(json2);
			    	return;
				}
			}else {
				response.setStatus(401);		
				String message = "{ \"message\": \"The requested action is not permitted\" }";
		    	JsonObject json2 = new Gson().fromJson(message, JsonObject.class);
		    	response.getWriter().println(json2);
		    	return;
			}
			
	}

}
