package com.alberta.qa.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alberta.qa.Base.BaseTest;

public class DashBoardPage extends BaseTest{
	//Dec
	
	//@FindBy(xpath = "//span[contains(text(),' Dashboard')]")
	//private WebElement dashboard;
	@FindBy(xpath = "//a[contains(text(),'DASHBOARD ')]")
	private WebElement dashboard;
	@FindBy(xpath = "//h6[text() = 'News & Updates']")
	private WebElement dashboardContent;
	@FindBy(xpath = "//a[contains(text(),'VENDOR ')]")
	private WebElement vendorBtn;
	@FindBy(xpath = "//a[contains(text(),' CUSTOMER')]")
	private WebElement customerBtn;
	
	@FindBy(xpath = "//a[contains(text(),' Customer')]")
	private WebElement cstBtn;
	
	@FindBy(xpath = "//a[contains(text(),' PRODUCTS')]")
	private WebElement productbtn;
	
	@FindBy(xpath = "//a[contains(text(),'Items')]")
	private WebElement itembtn;
	@FindBy(xpath = "//a[contains(text(),' INVENTORY')]")
	private WebElement inventoryBtn;
	@FindBy(xpath = "//a[contains(text(),' Purchase Order ')]")
	private WebElement purchaseOrderBtn;
	@FindBy(xpath = "//a[contains(text(),' Receiving Order')]")
	private WebElement ROBtn;
	@FindBy(xpath = "//a[contains(text(),' Item Classification ')]")
	private WebElement DeptBtn;
	@FindBy(xpath = "//a[contains(text(),' Item Classification ')]")
	private WebElement CatBtn;
	@FindBy(xpath = "//a[contains(text(),' Item Classification ')]")
	private WebElement SubCatBtn;
	@FindBy(xpath = "//a[contains(text(),' Unit ')]")
	private WebElement unitBtn;
	@FindBy(xpath = "//a[contains(text(),'Size')]")
	private WebElement sizeBtn;
	@FindBy(xpath = "//a[contains(text(),'Manufacturer')]")
	private WebElement manufacturerBtn;
	
	//init
	
	public DashBoardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions //Uti
	
	public boolean validateDashBoard()
	{
		return dashboard.isDisplayed();
	}
	public boolean validateDashBoardContent()
	{
		return dashboardContent.isDisplayed();
	}
	
	public VendorPage clickOnVendorBtn()
	{
		vendorBtn.click();
		return new VendorPage();
	}
	
	public CustomerPage clickOnCustomerBtn() throws InterruptedException
	{
		customerBtn.click();
		Thread.sleep(2000);
		cstBtn.click();
		return new CustomerPage();
	}
	
	
	
	public Products_ItemsPage clickOnProducts_ItemsBtn() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(productbtn));
		ele.click();
		//productbtn.click();
		//Thread.sleep(2000);
		itembtn.click();
		return new Products_ItemsPage();
	}
	
	public ReceivingOrderPage clickOnReceivingOrderBtn() throws InterruptedException
	{
		inventoryBtn.click();
		Thread.sleep(2000);
		ROBtn.click();
		return new ReceivingOrderPage();
	}
	
	public PurchaseOrderPage clickOnPurchaseOrderBtn() throws InterruptedException
	{
		inventoryBtn.click();
		Thread.sleep(2000);
		purchaseOrderBtn.click();
		return new PurchaseOrderPage();
	}
	
	public DeptPage clickOnDeptBtn() throws InterruptedException
	{
		inventoryBtn.click();
		Thread.sleep(2000);
		DeptBtn.click();
		return new DeptPage();
	}
	
	public CategoryPage clickOnCatBtn() throws InterruptedException
	{
		inventoryBtn.click();
		Thread.sleep(2000);
		CatBtn.click();
		return new CategoryPage();
		
	}
	
	public SubCategoryPage clickOnSubCatBtn() throws InterruptedException
	{
		inventoryBtn.click();
		Thread.sleep(2000);
		SubCatBtn.click();
		return new SubCategoryPage();
		
	}
	
	public UnitPage clickOnUnitBtn() throws InterruptedException
	{
		inventoryBtn.click();
		Thread.sleep(2000);
		unitBtn.click();
		return new UnitPage();
		
	}
	
	public SizePage clickOnSizeBtn() throws InterruptedException
	{
		inventoryBtn.click();
		Thread.sleep(2000);
		sizeBtn.click();
		return new SizePage();
		
	}


	public ManufacturerPage clickOnManufacturerBtn() throws InterruptedException {
		inventoryBtn.click();
		Thread.sleep(2000);
		manufacturerBtn.click();
		return new ManufacturerPage();
		
	}
	

}
