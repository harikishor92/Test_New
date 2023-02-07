package com.alberta.qa.testcases;

//import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Pages.DashBoardPage;
import com.alberta.qa.Pages.LoginPage;
import com.alberta.qa.Pages.Products_ItemsPage;
import com.alberta.qa.Pages.WelcomePage;
import com.alberta.qa.Util.TestUtil;
import com.aventstack.extentreports.Status;

public class Products_ItemsPageTest extends BaseTest{
	//Logger logger = Logger.getLogger(Products_ItemsPageTest.class);

	String sheetName = "addItems";
	WelcomePage wlcm;
	LoginPage loginPage;
	DashBoardPage dashBoard;
	Products_ItemsPage pi;
	
	Products_ItemsPageTest()
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
		dashBoard = new DashBoardPage();
		pi = new Products_ItemsPage();
	}
	
	@DataProvider()
	public Object[][] getAlbertaTestData() throws InvalidFormatException
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(dataProvider = "getAlbertaTestData")
	public void createItemPageTest(String Sl_no,String sku, String itemName, String itemType,
			String dept,String cat,String subCat, String cost, String price,String vendor, 
			String vTax,String sUnit, String sSize,String vMfr,String ageVer,String qoh) throws InterruptedException
	{
		elogger = extent.createTest("ItemPageTest_"+Sl_no);
		elogger.info("Start executing the test case");
		Thread.sleep(1000);
		dashBoard.clickOnProducts_ItemsBtn();
		Thread.sleep(1000);
		pi.clickOnAddNewItems();
		Thread.sleep(1000);
		pi.CreateNewItems(sku,itemName,itemType,dept,cat,subCat,cost,price,vendor,vTax,sUnit,
				sSize,vMfr,ageVer,qoh);
		//boolean status = pi.validateCreatedItem();
		//Assert.assertTrue(true);
		elogger.log(Status.PASS, "Test case pass");
		elogger.info("Test case execution completed");
	}
}
