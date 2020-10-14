package com.app.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.app.models.Role;
import com.app.dao.util.mySqlConnector;
public class RoleDao {

	private static RoleDao rd = new RoleDao();
	private RoleDao() {}
	public static RoleDao getInstance() {
		return rd;
	}
	public RoleDao(int x) {
		
	}

	
	public Role findRoleById(int id) {
		
		try(Connection connection = mySqlConnector.getConnection()){
			String sql = "SELECT * FROM roles WHERE role_id = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,id);
			
			ResultSet resultset = statement.executeQuery();
			
			if(resultset.next()) {
				return new Role(
						resultset.getInt("role_id"), 					
						resultset.getString("role_name"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
