package com.datacopy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataManager {
	
	public static Connection con;
	
	public static void connectDb(String userName, String  passWord, String sid, String hostName, String port) {
		
		try {
			Class.forName("oracle.jdbc.driver.oracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@"+hostName+":"+port+":"+sid,userName,passWord);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Please check connection");
		}
		
	}
	
	public ResultSet executeQueryByName(String query, Object pstm) {
		
		ResultSet rs = null ;
		return rs;
		
	}
	
	public static void disconnectDb() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
