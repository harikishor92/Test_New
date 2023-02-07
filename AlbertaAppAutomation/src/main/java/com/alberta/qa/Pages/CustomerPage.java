package com.alberta.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Util.TestUtil;

public class CustomerPage extends BaseTest{
	@FindBy(xpath = "//a[contains(text(),'ADD NEW')]")
	private WebElement addNew;
	@FindBy(xpath = "//input[@id='vcustomername']")
	private WebElement addCustName;
	@FindBy(xpath = "//input[@id='input-first-name']")
	private WebElement addFirstName;
	@FindBy(xpath = "//input[@id='input-last-name']")
	private WebElement addLastName;
	@FindBy(xpath = "//input[@id='input-address']")
	private WebElement addAdress;
	@FindBy(xpath = "//input[@id='input-city']")
	private WebElement addCity;
	@FindBy(xpath = "//input[@id='input-state']")
	private WebElement addState;
	@FindBy(xpath = "//input[@id='input-zip']")
	private WebElement addZip;
	@FindBy(xpath = "//input[@id='email_field']")
	private WebElement addEmail;
	@FindBy(xpath = "//input[@id='vphone']")
	private WebElement addPhone;
	@FindBy(xpath = "//textarea[@name='note']")
	private WebElement addNote;
	@FindBy(xpath = "//select[@name='pricelevel']")
	private WebElement addLevelPrice;
	@FindBy(xpath = "//button[@id='saveCustomer']")
	private WebElement saveBtn;
	
	public CustomerPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void createCustomer() throws InterruptedException {
		addNew.click();
		Thread.sleep(1500);
		addCustName.sendKeys("Test Customer");
		addFirstName.sendKeys("Test");
		addLastName.sendKeys("Customer");
		addAdress.sendKeys("50 E PENNSYLVANIA");
		addCity.sendKeys("PENNSYLVANIA");
		addState.sendKeys("New Jersey");
		addZip.sendKeys("70010");
		addPhone.sendKeys("9807766778");
		addEmail.sendKeys("testcustomer@gmail.com");
		addNote.sendKeys("Testing customer module");
		TestUtil.selectDropDown(addLevelPrice,"Level 4");
		Thread.sleep(3000);
		saveBtn.click();
		Thread.sleep(10000);
		System.out.println("Tc completed");
	}

}
