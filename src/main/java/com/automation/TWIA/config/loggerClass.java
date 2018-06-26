package com.automation.TWIA.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class loggerClass {
	
	
	public void logs() {
		
//		Properties prop= new Properties();
//		
//		try {
//			InputStream input= new FileInputStream(System.getProperty("user.dir")+"//log4j.properties");
//			prop.load(input);
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
		String log4jObj = "log4j.properties";
		PropertyConfigurator.configure(log4jObj);
		
	}
	

}
