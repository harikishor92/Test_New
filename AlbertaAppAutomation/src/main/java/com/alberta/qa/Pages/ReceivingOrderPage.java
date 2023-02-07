package com.alberta.qa.Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Util.TestUtil;

public class ReceivingOrderPage extends BaseTest{
	DashBoardPage dashBoard;
	@FindBy(xpath = "//a[contains(text(),'Add New')]")
	private WebElement addRO;
	@FindBy(xpath = "//input[@id = 'input_invoice']")
	private WebElement invoiceBtn;
	@FindBy(xpath = "//select[@id = 'loaded_vendor']")
	private WebElement vendorBtn;
	@FindBy(xpath = "//select[@id = 'payment_status']")
	private WebElement selectPaymentStatus;
	@FindBy(xpath = "//input[@id = 'for_item']")
	private WebElement selectCheckBox;
	@FindBy(xpath = "//button[. = 'Yes']")
	private WebElement popups;
	
	@FindBy(xpath = "//button[.='Add Item']")
	private WebElement addItemBtn;
	@FindBy(xpath = "//input[@id='item_name']")
	private WebElement searchItem;
	
	@FindBy(xpath = "//input[@class = 'adjustment-fields orderQty']")
	private WebElement orderQty;
	@FindBy(xpath = "//button[.='Add to RO']")
	private WebElement addToROBtn;
	@FindBy(xpath = "//button[@id = 'item_model_close']")
	private WebElement closeBtn;
	@FindBy(xpath = "//button[@id = 'save_receiving_order']")
	private WebElement saveBtn;
	@FindBy(xpath = "//div[@class='alert alert-danger text-center']")
	private WebElement stst;
	@FindBy(xpath = "(//button[.='Close'])[2]")
	private WebElement closeBtn1;
	
	
	
	@FindBy(xpath = "(//input[@class = 'form-control table-heading-fields text-center'])[2]")
	private WebElement searchInvoice;
	@FindBy(xpath = "(//a[@class= 'edit_btn_rotate'])[2]")
	private WebElement openRec;
	
	
	public ReceivingOrderPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnAddNewBtn()
	{
		addRO.click();
	}
	
	public void createRO(String invoiceNo,String vName,String paymentStatus,String itemName,String itemQty) throws InterruptedException
	{
		invoiceBtn.sendKeys(invoiceNo);
		Thread.sleep(2000);
		System.out.println("VenderName******** "+vName);
		TestUtil.selectDropDown(vendorBtn, vName);
		Thread.sleep(2000);
		//to perform Scroll down on application using Selenium
		TestUtil.scrollPage(0, 350);
		Thread.sleep(2000);
		TestUtil.selectDropDown(selectPaymentStatus, paymentStatus);
		Thread.sleep(2000);
		//to perform Scroll up on application using Selenium
		TestUtil.scrollPage(0,-350);
		Thread.sleep(2000);
		selectCheckBox.click();
		Thread.sleep(2000);
		popups.click();
		Thread.sleep(2000);
		boolean sts = selectCheckBox.isSelected();
		if(sts == false)
		{
			selectCheckBox.click();
		}
		addItemBtn.click();
		Thread.sleep(2000);
		searchItem.sendKeys(itemName);
		Thread.sleep(2000);
		orderQty.sendKeys(itemQty);
		Thread.sleep(2000);
		addToROBtn.click();
		Thread.sleep(2000);
		closeBtn.click();
		Thread.sleep(2000);
		saveBtn.click();
		Thread.sleep(2000);
		System.out.println("status********* "+stst.getText());
		Thread.sleep(2000);
		try {
			if(stst.getText().equalsIgnoreCase("Invoice Already Exist"))
			{
				elogger.info("Invoice Already Exist");
				Thread.sleep(1000);
				closeBtn1.click();
				Thread.sleep(2000);
				dashBoard = new DashBoardPage();
				dashBoard.clickOnReceivingOrderBtn();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Creating new RO");
			elogger.info("Creating new RO");
		}
		Thread.sleep(8000);
		searchInvoice.sendKeys("2205040");
		Thread.sleep(3000);
		System.out.println("Text********** "+openRec.getText());
		Thread.sleep(2000);
		boolean con = openRec.isDisplayed();
		Assert.assertTrue(con, "RO has created successfully");
		
		
		
	}
	public void receiveROwithOutPayment() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", openRec);
		boolean sts = selectCheckBox.isSelected();
		if(sts == false)
		{
			selectCheckBox.click();
		}
		Thread.sleep(2000);
		if(sts == true)
		{
			//to perform Scroll down on application using Selenium
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,350)", "");
			Thread.sleep(2000);
			
		}
	}

	
	

}
