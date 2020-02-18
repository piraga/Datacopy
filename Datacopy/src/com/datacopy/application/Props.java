package com.datacopy.application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class Props {
	
	private static final String PropertiesPath = "/datacopy.properties";

	private Properties prop;
	
	public Properties getProperties() throws Exception {
//		Properties p = new Properties();
//		InputStream is = new FileInputStream(PropertiesPath);	
//		p.load(is);
//		System.out.println(p.getProperty("SEED"));
//		return p;
		
//		String fileName = "/db.properties";
		
		prop	= new Properties();
		
		
		InputStream ip = Props.class.getResourceAsStream(PropertiesPath);
		try {
			prop.load(ip);
			
//			return prop;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	


}
