package com.alberta.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alberta.qa.Base.BaseTest;

public class WelcomePage extends BaseTest{
	
	@FindBy(xpath = "//a[.='Login ']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElement logotext;
	
	
	
	@FindBy(xpath = "//*[@class='svg-inline--fa fa-cart-plus fa-w-18 fa-2x']")
	WebElement domaintab;
	
	@FindBy(xpath = "//*[@class='svg-inline--fa fa-outdent fa-w-14 fa-2x']")
	WebElement technologytab;
	
	@FindBy(xpath = "//*[@class='svg-inline--fa fa-users fa-w-20 fa-2x']")
	WebElement processtab;
	
	public WelcomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateWelcomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateWelcomePageLOGOText()
	{
		return logotext.isDisplayed();
	}
	
	public LoginPage clickOnLoginButton() throws InterruptedException
	{
		Thread.sleep(1500);
		loginbtn.click();
		
		return new LoginPage();
	}
}
