package com.alberta.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alberta.qa.Base.BaseTest;

public class LoginPage extends BaseTest{
	//declearation
	
	@FindBy(xpath = "//h3[contains(text(),'check out all our other products & services')]")
	WebElement LoginPagelogotext;
	
	
	@FindBy(xpath = "//input[@id = 'input_email']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id = 'input-password']")
	WebElement passwd;
	
	@FindBy(xpath = "//button[text() = 'Login']")
	WebElement loginbtn;
	
	//Initilization
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	  public boolean validateLoginPage() { 
		  return LoginPagelogotext.isDisplayed();
	  }
	 
	
	public DashBoardPage login(String un, String pwd) throws InterruptedException
	{
		username.sendKeys(un);
		Thread.sleep(1000);
		passwd.sendKeys(pwd);
		Thread.sleep(1000);
		loginbtn.click();
		return new DashBoardPage();
	}

}
