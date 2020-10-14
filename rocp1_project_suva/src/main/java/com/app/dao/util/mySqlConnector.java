package com.app.dao.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class mySqlConnector {

	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driver Loaded Successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/bank";
		String username = "root";
		String password = "Suvashahria2";

		return DriverManager.getConnection(url, username, password);
		//System.out.println("Connection sucessful");
	
	}

}
