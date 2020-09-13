package com.amazon.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.amazon.pages.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestcasewithoutFW extends BaseClass {

	@Test
	 public void test1(){
		//set up browser
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		/*
		 * WebDriverManager.chromedriver().setup(); WebDriver driver = new
		 * ChromeDriver();
		 */
		driver.get("https://itimer.jkt.in/itimer/login.htm");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//login 
		logger = report.createTest("Login to itimer");
		driver.findElement(By.id("employeeCode")).sendKeys("Gouthami.sr@jktech.com");
		driver.findElement(By.id("employeepassword")).sendKeys(")Q+QZ^c!");
		driver.findElement(By.id("loginbutton")).click();
		
		//
		logger.info("home page displayed");
		WebElement report = driver.findElement(By.linkText("Reports"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(report));
		report.click();
		driver.findElement(By.xpath("//a[text()='Reports']/following-sibling::ul//a[contains(.,'Timesheet')]")).click();
		WebElement txtResourceName = driver.findElement(By.id("resourceName"));
		logger.info("report page displayed");
		wait.until(ExpectedConditions.visibilityOf(txtResourceName));
		
		
	}
}
