package com.app.login.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.login.dao.LoginDAO;
import com.app.login.dao.dbutil.MySqlConnection;
import com.app.login.exception.BusinessException;
import com.app.login.model.User;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean isValidUserCredentials(User user) throws BusinessException {
		boolean b=false;
		
		try(Connection connection=MySqlConnection.getConnection()){
			String sql="select userName from login_master where userName=? and password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				b=true;
			}else {
				throw new BusinessException("Invalid Login Credentials");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); //this line you should take it off before going live(production)
			throw new BusinessException("Internal error occured... Kindly contact SYSADMIN.....");
		}
		
		return b;
	}

}
