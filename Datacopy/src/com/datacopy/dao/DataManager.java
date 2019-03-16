package com.datacopy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.datacopy.application.PopUp;
import com.datacopy.application.Props;

import javafx.scene.control.ProgressBar;

public class DataManager {
	
	private static Connection con;
	private PopUp popUp=null;
	
	
	
	public void connectDb(String userName, String  passWord, String sid, String hostName, String port) {
		popUp=new PopUp();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@"+hostName+":"+port+":"+sid,userName,passWord);
//			jdbc:oracle:thin:[USER/PASSWORD]@HOST:PORT:SID
//			jdbc:oracle:thin:[USER/PASSWORD]@//HOST:PORT/SERVICE
			
			ProgressBar pb = new ProgressBar();
			pb.setProgress(0.5);
			con.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Please check connection");
			popUp.connectionFail();
		}
		
	}
	
	public ResultSet executeQueryByName(String query, String[] pstm) {
		
		
		ResultSet rs = null ;
		
		DataManager dm = new DataManager();
		try {
			
			String sql = dm.getQuery(query);
			
//			PreparedStatement ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
//				    ResultSet.CONCUR_READ_ONLY);
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println(ps);
			if(query.contains("ACCOUNT_MASTER") || query.contains("_ACCT")) {
				String value=pstm[0];
				ps.setString(1,value);
			}else if(query.contains("SEC_MASTER")){
				String value=pstm[1];
				ps.setString(1,value);
			}else {
				for (int i=1;i<=pstm.length;i++) {
					System.out.println();
					String value=pstm[i-1];
					ps.setString(i,value);
				}
			}
			
			System.out.println(ps.toString());
			
			rs = ps.executeQuery();
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
