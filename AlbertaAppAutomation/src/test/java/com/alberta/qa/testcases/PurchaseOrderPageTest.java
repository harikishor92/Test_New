package com.alberta.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Pages.DashBoardPage;
import com.alberta.qa.Pages.LoginPage;
import com.alberta.qa.Pages.PurchaseOrderPage;
import com.alberta.qa.Pages.WelcomePage;
import com.alberta.qa.Util.TestUtil;

public class PurchaseOrderPageTest extends BaseTest{
	//Logger logger = Logger.getLogger(PurchaseOrderPageTest.class);

	String sheetName = "addPO";
	WelcomePage wlcm;
	LoginPage loginPage;
	DashBoardPage dashBoard;
	PurchaseOrderPage PO;

	
	PurchaseOrderPageTest()
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
		Thread.sleep(2000);
		dashBoard.clickOnPurchaseOrderBtn();
		PO = new PurchaseOrderPage();
	}
	
	
	  @DataProvider() public Object[][] getAlbertaTestData() throws InvalidFormatException { Object[][] data =
	  TestUtil.getTestData(sheetName); return data;
	  
	  }
	 
	
	@Test(dataProvider = "getAlbertaTestData")
	public void createPoPageTest(String Sl_no,String itemName, String orderQty, String vendorName) throws InterruptedException
	{
		elogger = extent.createTest("PoPageTest_"+Sl_no);
		elogger.info("Start executing the test case");
		Thread.sleep(2000);
		PO.clickOnAddNewPO();
		Thread.sleep(2000);
		PO.createNewPO(itemName,orderQty,vendorName);
		//dashBoard.clickOnReceivingOrderBtn();
	}

}
