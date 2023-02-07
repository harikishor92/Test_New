package com.alberta.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alberta.qa.Base.BaseTest;

public class SizePage extends BaseTest{
	@FindBy(xpath = "//button[contains(@onclick,'addSize();')]")
	private WebElement addNew;
	@FindBy(xpath = "//input[@id='add_vsize']")
	private WebElement addSizeName;
	@FindBy(xpath = "//input[@id='saveSizeButton']")
	private WebElement saveSizeBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement succMsg;
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	private WebElement failMsg;
	
	public SizePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void createSize(String sName) throws InterruptedException
	{
		addNew.click();
		Thread.sleep(1500);
		addSizeName.sendKeys(sName);
		saveSizeBtn.click();
		try {
			succMsg.getText().contains("Success: You have Added Size Successfully!");
			elogger.info("Success: You have Added Size Successfully!");
			System.out.println("Success: You have Added Size Successfully!");
		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println("EXception*e** "+e);
			try {
				failMsg.getText().contains("The name has already been taken !");
				elogger.info("The name has already been taken !");
				System.out.println("The name has already been taken !");
			} catch (Exception e1) {

				e1.printStackTrace();
				System.out.println("EXception*e1** " + e1);
			}
		}
	}

}
