package com.app.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

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