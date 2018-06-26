package com.automation.TWIA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	@FindBy (xpath= "")
	public WebElement userName;
	
	@FindBy (xpath= "")
	public WebElement password;
	
	@FindBy (xpath= "")
	public WebElement loginButton;
	
	
	WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
}
