package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/edifyer_db?useSSL=false&serverTimezone=UTC";
		String user="edifyer_admin";
		String pass="edifyer_admin";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = 
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful ");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
