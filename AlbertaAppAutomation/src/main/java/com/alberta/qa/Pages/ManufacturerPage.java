package com.alberta.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alberta.qa.Base.BaseTest;

public class ManufacturerPage extends BaseTest{
	@FindBy(xpath = "//button[contains(@onclick,'addManufacturer();')]")
	private WebElement addNew;
	@FindBy(xpath = "//input[@id='add_manufacturer_name']")
	private WebElement addManufacturerName;
	@FindBy(xpath = "//input[@id='add_manufacturer_code']")
	private WebElement addManufacturerCode;
	@FindBy(xpath = "//input[@id='saveManufacturerButton']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement succMsg;
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	private WebElement failMsg;
	
	public ManufacturerPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void createManufacturer(String mName, String mCode) {
		addNew.click();
		addManufacturerName.sendKeys(mName);
		addManufacturerCode.sendKeys(mCode);
		saveBtn.click();
		
		try {
			succMsg.getText().contains("Success: You have Added Manufacturer Successfully!");
			elogger.info("Success: You have Added Manufacturer Successfully!");
			System.out.println("Success: You have Added Manufacturer Successfully!");
		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println("EXception*e** "+e);
			try {
				failMsg.getText().contains("The mfr name has already been taken.");
				elogger.info("The mfr name has already been taken.");
				System.out.println("The mfr name has already been taken.");
			} catch (Exception e1) {

				e1.printStackTrace();
				System.out.println("EXception*e1** " + e1);
			}
		}
		
	}

}
