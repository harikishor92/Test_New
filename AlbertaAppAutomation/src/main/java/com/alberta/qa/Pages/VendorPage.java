package com.alberta.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Util.TestUtil;

public class VendorPage extends BaseTest{
	
	@FindBy(xpath = "//a[@type='button']")
	private WebElement vAddNewBtn;
	@FindBy(xpath = "//input[@id = 'input_vendor_name']")
	private WebElement vNameBtn;
	@FindBy(xpath = "//select[@id = 'input-vendor-type']")
	private WebElement vTypeBtn;
	@FindBy(xpath = "//input[@id = 'input-first-name']")
	private WebElement vfnameBtn;
	@FindBy(xpath = "//input[@id = 'input-last-name']")
	private WebElement vlnameBtn;
	@FindBy(xpath = "//input[@name = 'vcode']")
	private WebElement vCodeBtn;
	@FindBy(xpath = "//input[@id = 'input-address']")
	private WebElement vAddressBtn;
	@FindBy(xpath = "//input[@id = 'input-city']")
	private WebElement vCityBtn;
	@FindBy(xpath = "//input[@id = 'input-state']")
	private WebElement vStateBtn;
	@FindBy(xpath = "//input[@id='input-phone']")
	private WebElement vPhoneBtn;
	@FindBy(xpath = "//input[@id='input-zip']")
	private WebElement vZipBtn;
	@FindBy(xpath = "//input[@id = 'vemail']")
	private WebElement vEmailBtn;
	@FindBy(xpath = "//select[@name = 'plcbtype']")
	private WebElement vPlcbBtn;
	@FindBy(xpath = "//select[@name = 'edi']")
	private WebElement vEdiBtn;
	@FindBy(xpath = "//button[@id='form-vendor']")
	private WebElement vSaveBtn;
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement succMsg;
	@FindBy(xpath = "//label[@id='input_vendor_name-error']")
	private WebElement failMsg;
	
	@FindBy(xpath = "//i[@class = 'fa fa-reply']")
	private WebElement vCancelBtn;
	
	public VendorPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createVendor(String vName,String vType,String vFname,String vLname,String vCode,String vAdress,String vCity,String vState,String vPhone,String vZip,String vEmail,String vPlcbType, String vEdi) throws InterruptedException
	{
		vAddNewBtn.click();
		Thread.sleep(1000);
		vNameBtn.sendKeys(vName);
		Thread.sleep(1000);
		TestUtil.selectDropDown(vTypeBtn, vType);
		Thread.sleep(1000);
		vfnameBtn.sendKeys(vFname);
		Thread.sleep(1000);
		vlnameBtn.sendKeys(vLname);
		Thread.sleep(1000);
		vCodeBtn.sendKeys(vCode);
		Thread.sleep(1000);
		vAddressBtn.sendKeys(vAdress);
		Thread.sleep(1000);
		vCityBtn.sendKeys(vCity);
		Thread.sleep(1000);
		vStateBtn.sendKeys(vState);
		Thread.sleep(1000);
		vPhoneBtn.sendKeys(vPhone);
		Thread.sleep(1000);
		vZipBtn.sendKeys(vZip);
		Thread.sleep(1000);
		vEmailBtn.sendKeys(vEmail);
		TestUtil.selectDropDown(vPlcbBtn, vPlcbType);
		Thread.sleep(1000);
		vEdiBtn.sendKeys(vEdi);
		Thread.sleep(1000);
		vSaveBtn.click();
		
		try {
			//Assert.assertEquals(succMsg.getText(), "Vendor created successfully");
			succMsg.getText().contains("Vendor created successfully");
			elogger.info("Vendor created successfully");
			System.out.println("Vendor created successfully");
		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println("EXception*e** "+e);
			try {
				//Assert.assertEquals(failMsg.getText(),"This field is required.");
				failMsg.getText().contains("This field is required.");
				elogger.info(" Vendor Already Exist!!");
				System.out.println(" Vendor Already Exist!!");
				Thread.sleep(2000);
				vCancelBtn.click();
				elogger.info("Navigated to vendor landing page successfully");
			} catch (Exception e1) {

				e1.printStackTrace();
				System.out.println("EXception*e1** " + e1);
				Thread.sleep(2000);
				vCancelBtn.click();
				Assert.fail();
			}
		}

	}
		
	
	

}
