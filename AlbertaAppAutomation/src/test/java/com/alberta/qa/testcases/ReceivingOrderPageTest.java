package com.alberta.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Pages.DashBoardPage;
import com.alberta.qa.Pages.LoginPage;
import com.alberta.qa.Pages.ReceivingOrderPage;
import com.alberta.qa.Pages.WelcomePage;
import com.alberta.qa.Util.TestUtil;

public class ReceivingOrderPageTest extends BaseTest{
	//Logger logger = Logger.getLogger(ReceivingOrderPageTest.class);

	String sheetName = "addRO";
	WelcomePage wlcm;
	LoginPage loginPage;
	DashBoardPage dashBoard;
	ReceivingOrderPage ro;
	
	ReceivingOrderPageTest()
	{
		super();
	}
	
	@BeforeClass
	public void setUp() throws InterruptedException
	{
		initialization();
		//elogger.info("Welcome page launched successfully");
		//wlcm = new WelcomePage();
		//wlcm.clickOnLoginButton();
		//elogger.info("Login page launched successfully");
		loginPage = new LoginPage();
		loginPage.login(prob.getProperty("userName"), prob.getProperty("password"));
		//elogger.info("DashBoard page launched successfully");
		Thread.sleep(3000);
		dashBoard = new DashBoardPage();
		dashBoard.clickOnReceivingOrderBtn();
		Thread.sleep(5000);
		ro = new ReceivingOrderPage();
		
	}
	
	@DataProvider
	public Object[][] getROdata() throws InvalidFormatException
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getROdata")
	public void receivingOrderPageTest(String Sl_no,String invoiceNo,String vName,String paymentStatus,String itemName,String itemQty) throws InterruptedException
	{
		elogger = extent.createTest("RoPageTest_"+Sl_no);
		elogger.info("Start executing the test case");
		ro.clickOnAddNewBtn();
		Thread.sleep(2000);
		ro.createRO(invoiceNo,vName,paymentStatus,itemName,itemQty);
	}

}
