package com.app.dao.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBtest {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			// Step - 1 - Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully");

			// Step - 2 - Open Connection(url,username,password)
			String url = "jdbc:mysql://localhost:3306/bank";
			String username = "root";
			String password = "Suvashahria2";
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection sucessful");
			
			//Step - 3 - Create Statement
			Statement statement=connection.createStatement();
			String sql="select role_id from roles";
			System.out.println("Statement Created");
			
			//Step - 4 - Execute Query
			ResultSet resultSet=statement.executeQuery(sql);
			System.out.println("Query executed");
			
			//Step - 5 - Process Results
			while(resultSet.next()) {
				System.out.println("Id :  "+resultSet.getInt("role_id"));

			}
			System.out.println("Results Processed");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			try {
				//Step - 6 - Close Connection 
				connection.close();
				System.out.println("Connection closed");
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

	}

}
