package com.datacopy.process;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class TempFile {
	
	private static String tmpDir = System.getProperty("java.io.tmpdir");
	private static String userHome = System.getProperty("user.home");
	private static String fileSeparator = System.getProperty("file.separator");
	String DSI = "DatacopyDSI";
	String fileDir=tmpDir+DSI.trim();
	String fileName=fileDir+fileSeparator+"scidb.properties";
	public TempFile() {
		createDirFile();
	}
	
	public void createDirFile() {
		
		System.out.println(tmpDir);
		System.out.println(userHome);
		System.out.println(fileSeparator);		
		File createDir = new File(fileDir);
		File createFile = new File(fileName);
		if(!createDir.exists()) {
			createDir.mkdir();
			System.out.println("DONE");
		}
		
		if(!createFile.exists()) {
			try {
				createFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				
	}
	
	public Properties loadDbProp() {
		
		Properties prop	= new Properties();	
		System.out.println("Prop"+fileName);
//		InputStream ip = getClass().getClassLoader().getResourceAsStream(fileName);
		
		try {
			InputStream ip = new FileInputStream(fileName);
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;	
	}
	
	
	public void getProperty() {
		
		Properties prop = loadDbProp();
		System.out.println(prop.isEmpty());
		System.out.println(prop.size());
		System.out.println(prop.getProperty("DBConnection"+prop.size()));
	}
	
	public static void main(String[] args) {
		TempFile tf = new TempFile();
		tf.getProperty();
	}
	
	
	
	

}
