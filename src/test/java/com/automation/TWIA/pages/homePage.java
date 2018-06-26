package com.automation.TWIA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.TWIA.TestBase.TestBase;
import com.automation.TWIA.Utils.commonUtils;

public class homePage {
	WebDriver driver;
	commonUtils utils;

	@FindBy (xpath= "//span[text()='Hello. Sign in']")
	public WebElement HomePageSigninOrders;

	@FindBy( xpath="//span[text()='Sign in']")
	public WebElement signInbutton;

	@FindBy(xpath="//label[contains(text(),'Email or mobile phone number')]")
	public WebElement emailORmobilelabel;
	
	@FindBy(id= "ap_email")
	public WebElement emailAdress;
	
	@FindBy(id= "continue")
	public WebElement continueButton;
	
	@FindBy(id= "ap_password")
	public WebElement password;
	



	public homePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		utils= new commonUtils(driver);
	}

	public void login(String email, String pwd) {
		
		try {
		utils.mouseOverAction(HomePageSigninOrders, signInbutton);
		utils.WaitForElement(emailORmobilelabel, 3);
		
		emailAdress.sendKeys(email);
		continueButton.click();
		utils.WaitForElement(password, 2);
		
		password.sendKeys(pwd);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			TestBase.status1=1;
		}
		
	}
	

}
