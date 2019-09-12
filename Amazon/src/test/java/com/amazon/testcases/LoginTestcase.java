package com.amazon.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.amazon.pages.BaseClass;
import com.amazon.pages.LoginPage;

public class LoginTestcase extends BaseClass {
	
	
    @Test
	public void loginApp() {
		
    	logger = report.createTest("Login to Amazon");
	    //lazy initialization
	    LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	    
	    logger.info("Starting Application");
	    loginpage.LogintoAmazon(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1) );
	    helper.Capturescreenshot(driver);
	    logger.pass("User is able to login");
	    
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	}
}
