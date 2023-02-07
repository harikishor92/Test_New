package com.alberta.qa.testcases;

//import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alberta.qa.Base.BaseTest;
import com.alberta.qa.Pages.DashBoardPage;
import com.alberta.qa.Pages.LoginPage;
import com.alberta.qa.Pages.PurchaseOrderPage;
import com.alberta.qa.Pages.WelcomePage;
import com.alberta.qa.Util.TestUtil;

public class QuickPOPageTest extends BaseTest{
	//Logger logger = Logger.getLogger(PurchaseOrderPageTest.class);

	String sheetName = "addQPO";
	WelcomePage wlcm;
	LoginPage loginPage;
	DashBoardPage dashBoard;
	PurchaseOrderPage PO;


	QuickPOPageTest()
	{
		super();
	}

	@BeforeClass
	public void setUp() throws InterruptedException
	{
		initialization();
		elogger.info("Welcome page launched successfully");
		//wlcm = new WelcomePage();
		//wlcm.clickOnLoginButton();
		elogger.info("Login page launched successfully");
		loginPage = new LoginPage();
		loginPage.login(prob.getProperty("userName"), prob.getProperty("password"));
		elogger.info("DashBoard page launched successfully");
		dashBoard = new DashBoardPage();
		Thread.sleep(2000);
		dashBoard.clickOnPurchaseOrderBtn();
		PO = new PurchaseOrderPage();
	}

	
	  @DataProvider() public Object[][] getAlbertaTestData() throws InvalidFormatException { Object[][] data =
	  TestUtil.getTestData(sheetName); 
	  return data;
	  
	  }
	 
	
	@Test(dataProvider = "getAlbertaTestData")
	public void createPoPageTest(String Sl_no,String sku1,String orderQty1,String sku2,String orderQty2, String vendorName) throws InterruptedException
	{
		elogger = extent.createTest("QPoPageTest_"+Sl_no);
		elogger.info("Start executing the test case");
		Thread.sleep(4000);
		PO.clickOnAddNewQPO();
		Thread.sleep(2000);
		PO.createNewQPO(sku1,orderQty1,sku2,orderQty2,vendorName);
	}


}
