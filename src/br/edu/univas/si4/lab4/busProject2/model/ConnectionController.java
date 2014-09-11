package br.edu.univas.si4.lab4.busProject2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionController {
	
	public static Connection createConnection(){
		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String pass = "djorge";
		String url = "jdbc:postgresql://localhost:5432/busproject";
		
		Connection conn = null;
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			
			conn = (Connection) DriverManager.getConnection(url,user,pass);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	/*
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
	}

	public static Connection createConnection(){
		try {
			Connection connection=  DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/busproject", "postgres", "abc123");
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return 
	}
	*/
}
