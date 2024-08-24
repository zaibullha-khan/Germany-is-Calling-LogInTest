package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actionDriver.Action;

public class LogInPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@type='text']") public WebElement userNameField;

	@FindBy(xpath="//input[@type='password']") public WebElement passWord;
	
	@FindBy(xpath="//button[@type='submit']") public WebElement ClickOnLoginButton;
	
	
	
	 public LogInPage(WebDriver d)
	 {
		 driver=d;
		 PageFactory.initElements(driver,this);
	 }
	
	 
	public Boolean enterTheCredentialInUserName(String Id)
	{
		
		return Action.type(userNameField, Id);
	}
	public Boolean enterTheCredentialInPassword(String PW)
	{
		
	   return Action.type(passWord,PW);
	}
	public void clickOnLoginButton()
	{
		
		Action.click(driver, ClickOnLoginButton);
	}
	
	
}
