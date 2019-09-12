package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
     WebDriver driver;
     //Constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath = "//span[@class='nav-line-1' and text()='Hello. Sign in']") 
	WebElement loginButton;
	
	@FindBy(id = "ap_email")
	WebElement  UserName;
	
	@FindBy(id = "continue")//continue
	WebElement ContinueButton;
	
	@FindBy(id = "ap_password")
	WebElement Password;
	
	@FindBy(id = "signInSubmit")
	WebElement SubmitButton;
	
	public void LogintoAmazon(String UserNametologin, String Passwordtologin) {
		
		loginButton.click();
		UserName.sendKeys(UserNametologin);
		ContinueButton.click();
		Password.sendKeys(Passwordtologin);
		SubmitButton.click();
		
	}

}
