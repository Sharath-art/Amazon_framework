package com.amazon.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public String Capturescreenshot(WebDriver driver) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Screenshotpath = System.getProperty("user.dir")+"/Screenshots/Amazon"+ getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File(Screenshotpath));
			//"./Screenshots/Amazon"+ getCurrentDateTime()+".png"
			System.out.println("*****Screenshot captured*******");
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("Unable to capturescreenshot"+e.getMessage());
		}
				
		return Screenshotpath;
	}
	
	public String getCurrentDateTime() {
		DateFormat Customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return Customformat.format(date);
		
			}
	public void HandleFrame() {}
	public void HandleAlerts() {}
	public void HandleWindow() {}
	public void javascriptExecutor() {}
	

}
