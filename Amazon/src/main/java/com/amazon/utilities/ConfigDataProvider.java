package com.amazon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
Properties Pro;
	public ConfigDataProvider() {
		File src = new File("./Config/Config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			Pro = new Properties();
			try {
				Pro.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
		
			e1.printStackTrace();
		}
		
	}
	
	public String getBrowser() {
		return Pro.getProperty("Browser");
		
	}
	public String getURL() {
		return Pro.getProperty("URL");
		
	}
	
	public String getDataFromCoonfig(String KeySearch) {
		return Pro.getProperty(KeySearch);
			}

}
