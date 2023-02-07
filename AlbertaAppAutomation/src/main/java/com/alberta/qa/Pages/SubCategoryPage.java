package com.alberta.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Util.TestUtil;

public class SubCategoryPage extends BaseTest{
	@FindBy(xpath = "//button[contains(@onclick,'addCategory();')]")
	private WebElement addNew;
	@FindBy(xpath = "//input[@id = 'add_vsubcategoryname']")
	private WebElement enterSubcatName;
	@FindBy(xpath = "//select[@id = 'add_cat_code']")
	private WebElement selectCatType;
	@FindBy(xpath = "//input[@id = 'save_subcategory']")
	private WebElement saveBtn;
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement succMsg;
	@FindBy(xpath = "//div[@class='alert alert-warning']")
	private WebElement failMsg;
	
	
	
	public SubCategoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createSubCat(String subCatName, String catType) throws InterruptedException
	{
		addNew.click();
		Thread.sleep(1000);
		enterSubcatName.sendKeys(subCatName);
		Thread.sleep(1000);
		TestUtil.selectDropDown(selectCatType,catType);
		Thread.sleep(1000);
		saveBtn.click();
		try {
			succMsg.getText().contains("SubCategory Added Successfully!!");
			elogger.info("SubCategory Added Successfully!!");
			System.out.println("SubCategory Added Successfully!!!");
		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println("EXception*e** "+e);
			try {
				failMsg.getText().contains("SubCategory Already Exist!!");
				elogger.info("SubCategory Already Exist!!");
				System.out.println("SubCategory Already Exist!!");
			} catch (Exception e1) {

				e1.printStackTrace();
				System.out.println("EXception*e1** " + e1);
			}
		}
	}

}
