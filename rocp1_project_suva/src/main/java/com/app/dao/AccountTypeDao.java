package com.app.dao;
import com.app.models.*;
import com.app.dao.util.mySqlConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountTypeDao {
	private static AccountTypeDao ATD = new AccountTypeDao();
	private AccountTypeDao() {
		
	}
	public AccountTypeDao(int x) {
	
	}
	public static AccountTypeDao getInstance() {
		return ATD;
	}
	
	public AccountType findById(int id) {
		try(Connection conn = mySqlConnector.getConnection()){
			String sql = "SELECT * FROM account_types WHERE type_id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1,id);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				AccountType ac = new AccountType(rs.getInt("type_id"),rs.getString("acc_type")  );
				return ac;					
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
