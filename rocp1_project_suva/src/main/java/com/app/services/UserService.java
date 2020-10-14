package com.app.services;

import java.util.List;

import com.app.dao.*;
import com.app.models.*;


public class UserService {
	

	private static final RoleDao rdao = RoleDao.getInstance();
	private static final UserDao udao = UserDao.getInstance();
	
	public User login(String username, String password) {
		
		return udao.login(username,password);		
		
	}

	public User InsertUser(User user) {
		Role role = rdao.findRoleById(user.getRoleID());
		user.setRole(role);				
		return udao.insert(user);
		
	}	
	
	public boolean deleteUser(User user) {
		
		
		
		
		return udao.delete(user);		
		
	}
	
	public User register(User user) {
		Role role = rdao.findRoleById(user.getRoleID());
		user.setRole(role);
		return udao.insert(user);
		
		
	}
	
	public User updateUser(User user) {
		Role role = rdao.findRoleById(user.getRoleID());
		user.setRole(role);
		if(udao.update(user)) {
			return findById(user.getUserId());
		}
		return null;
		
	}
		

	
	public User findById(int id) {
		
		User user = udao.findById(id);
		Role role = rdao.findRoleById(user.getRoleID());
		user.setRole(role);
		return user;
		
	}
	public User findByEmail(String e) {
		return udao.findByEmail(e);
	}
	public User findByUsername(String u) {
		return udao.findByUsername(u);
	}

	public List<User> findAllUsers() {
		
		return udao.findAllUsers();
	}
	
	
}