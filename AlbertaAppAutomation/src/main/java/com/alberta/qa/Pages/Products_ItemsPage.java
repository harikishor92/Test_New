package com.alberta.qa.Pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Util.TestUtil;

public class Products_ItemsPage extends BaseTest{
	@FindBy(xpath = "//a[contains(text(),'Add New')]")
	private WebElement addItems;

	@FindBy(xpath = "//input[@id='input-sku']")
	private WebElement enterSKU;

	@FindBy(xpath = "//input[@id='input_itemname']")
	private WebElement enterItemName;
	@FindBy(xpath = "//input[@id='input-new_cost']")
	private WebElement enterCost;

	@FindBy(xpath = "//input[@id='input-Selling_Price']")
	private WebElement enterPrice;
	@FindBy(xpath = "(//span[@class = 'select2-selection__arrow'])[1]")
	private WebElement clickOnItemType;

	@FindBy(xpath = "(//span[. = 'Select Department'])[1]")
	private WebElement clickOnDept;
	@FindBy(xpath = "//input[@class= 'select2-search__field']")
	private WebElement enterOption;
	@FindBy(xpath = "//ul[@class= 'select2-results__options']")
	private WebElement selectOption;

	@FindBy(xpath = "(//span[@class = 'select2-selection__arrow'])[3]")
	private WebElement clickOnCat;
	@FindBy(xpath = "//select[@id= 'subcat_id']")
	private WebElement clickOnSubCat;

	@FindBy(xpath = "(//span[@class = 'select2-selection__arrow'])[4]")
	private WebElement clickOnSupplier;
	@FindBy(xpath = "//select[@name= 'vtax']")
	private WebElement selectTax;
	@FindBy(xpath = "(//span[@class = 'select2-selection__arrow'])[5]")
	private WebElement clickOnUnit;
	@FindBy(xpath = "(//span[@class = 'select2-selection__arrow'])[6]")
	private WebElement clickOnSize;
	@FindBy(xpath = "(//span[@class = 'select2-selection__arrow'])[7]")
	private WebElement clickOnMfr;
	@FindBy(xpath = "(//span[@class = 'select2-selection__arrow'])[8]")
	private WebElement clickOnAgeVerification;
	@FindBy(xpath = "//input[@placeholder = 'Qty on Hand']")
	private WebElement QOHBtn;

	@FindBy(xpath = "//input[@class = 'btn button-blue basic-button-small save_btn_rotate formsubmit']")
	private WebElement saveBtn;

	@FindBy(xpath = " //div[contains(text(),'Successfully Added Item')]")
	private WebElement itemcreatedPopups;
	@FindBy(xpath = " //div[contains(text(),'SKU Already Exist')]")
	private WebElement itemExitsPopups;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement succMsg;
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	private WebElement failMsg;


	public Products_ItemsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddNewItems()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(addItems));
		ele.click();

	}

	public void CreateNewItems(String sku,String iname, String itemType,String dept,String cat,
			String subCat, String cost, String price,String vendor,String vTax,String sUnit, 
			String sSize,String vMfr,String ageVer,String qoh) throws InterruptedException
	{
		Thread.sleep(1000);
		enterSKU.sendKeys(sku);
		enterItemName.sendKeys(iname);
		//Click on item type Dropdown
		TestUtil.selectSearchDropDown(clickOnItemType, enterOption, itemType, selectOption);
		Thread.sleep(1000);
		//Click on Dept Dropdown
		TestUtil.selectSearchDropDown(clickOnDept, enterOption, dept, selectOption);
		Thread.sleep(2000);

		//Click on Cat Dropdown
		TestUtil.selectSearchDropDown(clickOnCat, enterOption, cat, selectOption);
		//Click on Sub Cat Dropdown
		TestUtil.selectDropDown(clickOnSubCat, subCat);
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].value = '"+cost+"'", enterCost);
		//enterCost.sendKeys(cost);
		enterPrice.clear();
		enterPrice.sendKeys(price);
		TestUtil.scrollPage(0, 500);
		//Click on Supplier Dropdown
		TestUtil.selectSearchDropDown(clickOnSupplier, enterOption, vendor, selectOption);
		//Click on Tax Dropdown
		TestUtil.selectDropDown(selectTax, vTax);
		//Click on Unit Dropdown
		TestUtil.selectSearchDropDown(clickOnUnit, enterOption, sUnit, selectOption);
		//Click on Size Dropdown
		TestUtil.selectSearchDropDown(clickOnSize, enterOption, sSize, selectOption);
		//Click on Manufacturer  Dropdown
		TestUtil.selectSearchDropDown(clickOnMfr, enterOption, vMfr, selectOption);
		//Click on Age Verification  Dropdown
		TestUtil.selectSearchDropDown(clickOnAgeVerification, enterOption, ageVer, selectOption);
		QOHBtn.clear();
		QOHBtn.sendKeys(qoh);
		saveBtn.click();
		Thread.sleep(2000);

		try {
			succMsg.getText().contains("Successfully Added Item");
			elogger.info("Successfully Added Item");
			System.out.println("Successfully Added Item");
		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println("EXception*e** "+e);
			try {
				itemExitsPopups.getText().contains("SKU Already Exist");
				elogger.info("SKU/Item Already Exist!!");
				System.out.println("SKU/Item Already Exist!!");
			} catch (Exception e1) {

				e1.printStackTrace();
				System.out.println("EXception*e1** " + e1);
			}
		}

	}

	/*
	 * public boolean validateCreatedItem() { return itemcreatedPopups.isDisplayed()
	 * || itemExitsPopups.isDisplayed(); }
	 */

}
