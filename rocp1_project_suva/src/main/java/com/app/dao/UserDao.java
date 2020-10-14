package com.app.dao;
import com.app.models.Role;
import com.app.models.User;
//import com.app.models.users.UserLoginDTO;
import com.app.dao.util.mySqlConnector;
import com.app.utils.Hashing;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

public class UserDao {
	private static final RoleDao roledoa = RoleDao.getInstance();
	private static UserDao ud = new UserDao();
	private UserDao() {}
	public static UserDao getInstance() {
		return ud;
	}
	
	public UserDao(int x) {
		
	}
	public User login(String username, String password)  {	
		//System.out.println("Attempting to login");
		
		try {
			password = Hashing.getHash(password);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try(Connection connector = mySqlConnector.getConnection()){			
			String sql = "SELECT * FROM users WHERE username = ? AND pass_word = ?;";
			PreparedStatement statement = connector.prepareStatement(sql);
			statement.setString(1,username);
			statement.setString(2,password);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				User user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("pass_word"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),roledoa.findRoleById(rs.getInt("role_id_users")));
				return user;
			}else{
				throw new LoginException("Invalid Credentials");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	public User insert2(User user) {

		try {
			user.setPassword(Hashing.getHash(user.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		try(Connection connector = mySqlConnector.getConnection()){
			String sql = "INSERT INTO users (user_id,username,pass_word,first_name,last_name,email,role_id_users) "+ "VALUES (?,?,?,?,?,?,?);";

			
			PreparedStatement statement = connector.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1,22);
			statement.setString(2,user.getUsername().trim());
			statement.setString(3,user.getPassword());
			statement.setString(4,user.getFirstName().trim());
			statement.setString(5,user.getLastName().trim());
			statement.setString(6,user.getEmail().trim().toLowerCase());
			statement.setInt(7,user.getRole().getRoleId());

			int succ = statement.executeUpdate();
			//System.out.println(succ);
			
			if(succ > 0) {
				ResultSet rs = statement.getGeneratedKeys();
				
				while(rs.next()) {		
					
					User u2 = new User();
					u2 = findById(rs.getInt(1));
					u2.setRole(user.getRole());
					return u2;
				}
			}else {
				return null;
			}
			
			
		}catch(SQLException e) {
			System.out.println(e);			
		}
		return null;
	}
	
	public User insert(User user) {

		try {
			user.setPassword(Hashing.getHash(user.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		try(Connection connector = mySqlConnector.getConnection()){
			String sql = "INSERT INTO users (username,pass_word,first_name,last_name,email,role_id_users) "+ "VALUES (?,?,?,?,?,?);";

			
			PreparedStatement statement = connector.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1,user.getUsername().trim());
			statement.setString(2,user.getPassword());
			statement.setString(3,user.getFirstName().trim());
			statement.setString(4,user.getLastName().trim());
			statement.setString(5,user.getEmail().trim().toLowerCase());
			statement.setInt(6,user.getRole().getRoleId());

			int succ = statement.executeUpdate();
			//System.out.println(succ);
			
			if(succ > 0) {
				ResultSet rs = statement.getGeneratedKeys();
				
				while(rs.next()) {		
					
					User u2 = new User();
					u2 = findById(rs.getInt(1));
					u2.setRole(user.getRole());
					return u2;
				}
			}else {
				return null;
			}
			
			
		}catch(SQLException e) {
			System.out.println(e);			
		}
		return null;
	}
	public boolean update(User user) {
		try {
			user.setPassword(Hashing.getHash(user.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		
		try(Connection c = mySqlConnector.getConnection()){			
			String sql = "UPDATE users SET username = ?, pass_word = ?, first_name = ?,last_name = ?, email = ? WHERE user_id = ?;";
		
		
			PreparedStatement statement = c.prepareStatement(sql);
			statement.setString(1,user.getUsername().trim());
			statement.setString(2,user.getPassword());
			statement.setString(3,user.getFirstName().trim());
			statement.setString(4,user.getLastName().trim());
			statement.setString(5,user.getEmail().trim().toLowerCase());
			statement.setInt(6,user.getUserId()); //manual input fornow
			
			statement.executeUpdate();		
			
			return true;
						
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return false;
	}
	
	public boolean delete(User u) {

		try(Connection connector = mySqlConnector.getConnection();){
		
			String sql ="DELETE "+ "FROM users "+"WHERE user_id = ?;";	
			PreparedStatement statement = connector.prepareStatement(sql);
			statement = connector.prepareStatement(sql);
			statement.setInt(1,u.getUserId());
			
			statement.executeUpdate();
			return true;
							
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public User findById(int id) {
		
		try(Connection connector = mySqlConnector.getConnection()){
			String sql = "SELECT * FROM users WHERE user_id = ?";
			PreparedStatement statement = connector.prepareStatement(sql);
			statement.setInt(1,id);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				User u = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("pass_word"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),roledoa.findRoleById(rs.getInt("role_id_users")));
				u.setRoleID(u.getRole().getRoleId());
				return u;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
	public User findByEmail(String email) {
		try(Connection c = mySqlConnector.getConnection()){
			String sql = "SELECT * FROM users WHERE email = ?";
			PreparedStatement statement = c.prepareStatement(sql);
			statement.setString(1,email);
		
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				User u = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("pass_word"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),roledoa.findRoleById(rs.getInt("role_id_users")));
				u.setRoleID(u.getRole().getRoleId());
				return u;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	public User findByUsername(String u) {
		try(Connection c = mySqlConnector.getConnection()){
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement statement = c.prepareStatement(sql);
			statement.setString(1,u);
		
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				User us = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("pass_word"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),roledoa.findRoleById(rs.getInt("role_id_users")));
				us.setRoleID(us.getRole().getRoleId());
				return us;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<User> findAllUsers() {
		try(Connection conn = mySqlConnector.getConnection()){
			List<User> users = new ArrayList<>();
			String sql = "SELECT * FROM users ORDER BY last_name, first_name;";
			Statement statement = conn.createStatement();	
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				User user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("pass_word"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),roledoa.findRoleById(rs.getInt("role_id_users")));
				user.setRoleID(user.getRole().getRoleId());
				users.add(user);
			}
			
			return users;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
