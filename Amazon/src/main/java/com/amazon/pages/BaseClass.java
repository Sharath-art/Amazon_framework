package com.amazon.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.amazon.utilities.BrowserFactory;
import com.amazon.utilities.ConfigDataProvider;
import com.amazon.utilities.ExcelDataprovider;
import com.amazon.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataprovider excel;
	public ConfigDataProvider Config;
	public Helper helper;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	
	public void SetupSuite() throws IOException {
		 excel= new ExcelDataprovider();
		 Config = new ConfigDataProvider();
		 helper = new Helper();
		 ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Amazon"+helper.getCurrentDateTime()+".html"));
		 report = new ExtentReports();
		 report.attachReporter(extent);
	}

	@BeforeClass
	
	public void Setup() {
		driver=BrowserFactory.startApplication(driver, Config.getBrowser(), Config.getURL());
	    System.out.println(driver.getTitle());	
	}
	
	@AfterClass
	
	public void Teardown() {
		BrowserFactory.quitBrowser(driver);
	}
    
	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			helper.Capturescreenshot(driver);
			logger.fail("Test case failed", MediaEntityBuilder.createScreenCaptureFromPath(helper.Capturescreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			helper.Capturescreenshot(driver);
			logger.fail("Test case passed", MediaEntityBuilder.createScreenCaptureFromPath(helper.Capturescreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			helper.Capturescreenshot(driver);
			logger.fail("Test case skipped ", MediaEntityBuilder.createScreenCaptureFromPath(helper.Capturescreenshot(driver)).build());
		}
		report.flush();
	}
}
