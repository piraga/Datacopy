package com.datacopy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.datacopy.application.PopUp;
import com.datacopy.application.Props;

public class DataManager {
	
	private static Connection con;
	private PopUp popUp=null;
	
	
	
	public void connectDb(String userName, String  passWord, String sid, String hostName, String port) {
		popUp=new PopUp();
		try {
			Class.forName("oracle.jdbc.driver.oracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@"+hostName+":"+port+":"+sid,userName,passWord);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Please check connection");
			popUp.connectionFail();
		}
		
	}
	
	public ResultSet executeQueryByName(String query, Object[] pstm) {
		
		
		ResultSet rs = null ;
		
		DataManager dm = new DataManager();
		try {
			
			String sql = dm.getQuery(query);
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			for (int i=0;i<pstm.length;i++) {
				System.out.println();
				String value=(String) pstm[i];
				ps.setString(i,value);
			}
			System.out.println(ps);
//			rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
		
	}
	
	public String getQuery(String query) {
		Props props = new Props();
		try {
			System.out.println(props.getProperties().getProperty(query));
			query = props.getProperties().getProperty(query);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return query;
		
		
	}
	
	public static void disconnectDb() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public static void main(String ards[]) {
//		DataManager dm = new DataManager();
//		Object[] pstat= {"hai"};
//		dm.executeQueryByName("SEED", pstat);
//	}
	
	

}
