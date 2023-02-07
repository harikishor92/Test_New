package com.alberta.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class PosTest {
	public WindowsDriver<WindowsElement> driver = null;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "C:\\Program Files (x86)\\AlbertaPOS\\POS2020.exe");
		//cap.setCapability("", "{7C5A40EF-A0FB-4BFC-874A-C0F2E0B9FA8E}\\AlbertaPOS\\POS2020.exe");
		driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723/"), cap);
		// cap.setCapability("platformName","Windows");
		// cap.setCapability("deviceName", "WindowsPC");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void posTest() throws InterruptedException {
		 WebDriverWait w = new WebDriverWait(driver,30);
		 w.until(ExpectedConditions.presenceOfElementLocated(By.name("POS2020")));
		//boolean sts = driver.findElementByName("POS2020");
		//boolean sts = driver.findElementByName("POS2020").findElementByName("Terminal:101").isDisplayed();
		//System.out.println("*********  "+sts);
		//Thread.sleep(2000);
		//driver.findElementByXPath("//pane/window[@AutomationId='frmlogin']").click();
		
		  driver.findElementByAccessibilityId("txtUserName").sendKeys("567"); 
		  //Thread.sleep(2000);
		  driver.findElementByAccessibilityId("txtPassword").sendKeys("123456");
		  Thread.sleep(2000); driver.findElementByName("Login").click();
		  System.out.println("Note pad completed");
		 

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
