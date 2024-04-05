package com.Generic.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile_Utilities {
	
	public String readData(String key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	
}
