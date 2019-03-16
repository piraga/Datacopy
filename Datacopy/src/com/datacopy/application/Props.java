package com.datacopy.application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class Props {
	
	private static final String PropertiesPath = "Datacopy/Properties/datacopy.properties";


	
	public Properties getProperties() throws Exception {
		Properties p = new Properties();
		InputStream is = new FileInputStream(PropertiesPath);	
		p.load(is);
		System.out.println(p.getProperty("SEED"));
		return p;
	}


}
