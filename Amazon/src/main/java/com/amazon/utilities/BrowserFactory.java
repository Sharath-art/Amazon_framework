package com.amazon.utilities;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String URL )
	{
		if (browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
//			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
//			 driver = new ChromeDriver();
		}
		else if(browserName.equals("IE"))
		{
//			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
//			 driver = new ChromeDriver();
		}
		else {System.out.println("we donot support this browser");}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
