package com.alberta.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alberta.qa.Base.BaseTest;

public class UnitPage extends BaseTest{
	
	@FindBy(xpath = "//button[contains(@onclick,'addUnit();')]")
	private WebElement addNew;
	@FindBy(xpath = "//input[@id='add_vunitcode']")
	private WebElement addUnitCode;
	@FindBy(xpath = "//input[@id='add_vunitname']")
	private WebElement addUnitName;
	@FindBy(xpath = "//textarea[@id='add_vunitdesc']")
	private WebElement addUnitDesc;
	@FindBy(xpath = "//button[@id='save_unit']")
	private WebElement saveBtn;
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement succMsg;
	@FindBy(xpath = "//div[@class='alert alert-warning']")
	private WebElement failMsg;
	
	public UnitPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createUnit(String uCode, String uName, String uDesc, String uStatus) throws InterruptedException
	{
		addNew.click();
		Thread.sleep(1000);
		addUnitCode.sendKeys(uCode);
		addUnitName.sendKeys(uName);
		addUnitDesc.sendKeys(uDesc);
		saveBtn.click();
		
		try {
			succMsg.getText().contains("unit updated successfully!");
			elogger.info("unit updated successfully!");
			System.out.println("unit updated successfully!");
		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println("EXception*e** "+e);
			try {
				failMsg.getText().contains("unit Already Exist!!");
				elogger.info("unit Already Exist!!");
				System.out.println("unit Already Exist!!");
			} catch (Exception e1) {

				e1.printStackTrace();
				System.out.println("EXception*e1** " + e1);
			}
		}
		
	}
	
	

}
