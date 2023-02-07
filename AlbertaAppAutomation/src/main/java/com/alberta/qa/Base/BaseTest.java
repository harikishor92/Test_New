package com.alberta.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlSuite;

import com.alberta.qa.Util.TestUtil;
import com.alberta.qa.Util.WebEventListener;
//import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.configuration.Config;
//import com.aventstack.extentreports.configuration.ConfigLoader;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.ExtentXReporterConfiguration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	//static Logger logger = Logger.getLogger(BaseTest.class);
	public static Properties prob;
	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ExtentSparkReporter htmlReporter;
	public  static ExtentReports extent;
	public  static ExtentTest elogger;
	String concate = ".";
	
	public BaseTest()
	{
		//logger.info("Start reading the config file");
		prob = new Properties(); 
		try {
			FileInputStream fis = new FileInputStream("./src/main/java/com/alberta/qa/Config/config.properties");
			prob.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//logger.info("Read the config file");
		
	}
	
	@BeforeSuite
	public void beforeSuite() throws IOException  {
		//extent = ExtentManager.createInstance("extent.html");
		htmlReporter = new ExtentSparkReporter(new File("./Reports/extent.html"));
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/Extent-Config.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@AfterSuite
	public void afterSuite()
	{
		extent.flush();
	}
	
	public static void initialization()
	{
		//logger.info("Lunching the browser");
		String browserName = prob.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("fireFox"))
		{
			//System.setProperty("webdriver.gecko.driver", "./MyDriver/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else 
		{
			System.setProperty("webdriver.ie.driver", "./MyDriver/IEdriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prob.getProperty("url"));
	//	logger.info("Lunched the browser");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void takeScreenshot(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			elogger.fail(MarkupHelper.createLabel(result.getName()+" Test case fail", ExtentColor.RED));
			elogger.log(Status.FAIL,result.getThrowable());
			//TestUtil.takeScreenshotAtEndOfTest();
			//passFailScreenshot("Capability");
			elogger.fail("Test Fail",MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.takeScreenshotAtEndOfTest()).build());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			elogger.pass(MarkupHelper.createLabel(result.getName()+" Test case pass", ExtentColor.GREEN));
			elogger.log(Status.PASS, result.toString());
			//passFailScreenshot("Capability");
			elogger.pass("Test Pass",MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.takeScreenshotAtEndOfTest()).build());
		}
		 else
		{
			elogger.skip(MarkupHelper.createLabel(result.getName()+" Test case skip", ExtentColor.YELLOW));
			elogger.log(Status.SKIP,result.getThrowable());
			//passFailScreenshot("Capability");
			elogger.skip("Test skip",MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.takeScreenshotAtEndOfTest()).build());
		}
		
	}
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
		elogger.info("Closed the browser successfully");
	}
	
	
	////////////////////////////////////////////////////////////////////////////////
	
	public void passFailScreenshot(String name) throws IOException
	{
		String screenShotname = concate+TestUtil.getScreenshot(name);
		screenCapture("Screenshot", screenShotname);
	}
	
	public static Object screenCapture(String logDetails, String imgPath) throws IOException
	{
		return elogger.log(Status.INFO, logDetails, MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
	}
	
	
	////////////////////////////////////////////////////////////////////////////////

	
	
	

}
