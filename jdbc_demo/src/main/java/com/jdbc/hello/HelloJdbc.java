package com.jdbc.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJdbc {

	public static void main(String[] args) {

		Connection connection = null;
		try {
			// Step - 1 - Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully");

			// Step - 2 - Open Connection(url,username,password)
			String url = "jdbc:mysql://localhost:3306/bms";
			String username = "root";
			String password = "Suvashahria2";
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection sucessful");
			
			//Step - 3 - Create Statement
			Statement statement=connection.createStatement();
			String sql="select id,name,age,teamName,gender,city from player";
			System.out.println("Statement Created");
			
			//Step - 4 - Execute Query
			ResultSet resultSet=statement.executeQuery(sql);
			System.out.println("Query executed");
			
			//Step - 5 - Process Results
			while(resultSet.next()) {
				System.out.print("Id :  "+resultSet.getInt("id"));
				System.out.print(" Name :  "+resultSet.getString("name"));
				System.out.print(" Age :  "+resultSet.getInt("age"));
				System.out.print(" Gender :  "+resultSet.getString("gender"));
				System.out.print(" City :  "+resultSet.getString("city"));
				System.out.println(" TeamName :  "+resultSet.getString("teamName"));
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
//Recreate the same and try doing Insert to the player table using Statement object only