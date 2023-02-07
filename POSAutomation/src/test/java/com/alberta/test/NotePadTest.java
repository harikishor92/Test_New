package com.alberta.test;





import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;


  
  public class NotePadTest { 
	  public WindowsDriver<WebElement> driver = null;
  
  
  @BeforeClass 
  public void setUp() throws MalformedURLException { 
	  DesiredCapabilities cap = new DesiredCapabilities(); 
	  cap.setCapability("app","C:\\Windows\\System32\\notepad.exe"); 
	  driver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723/"), cap);
  //cap.setCapability("platformName","Windows"); 
  //cap.setCapability("deviceName", "WindowsPC");
  

  
  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  
  
  }
  
  @Test 
  public void notePadTest() throws InterruptedException {
  driver.findElement(By.name("Help")).click();
  driver.findElement(By.name("About Notepad")).click();
  driver.findElement(By.name("OK")).click();
  driver.findElementByName("Text Editor").sendKeys("Desktop application automation testing");
  driver.findElementByName("Close").click();
  driver.findElementByName("Don't Save").click();
  Thread.sleep(2000);
  System.out.println("Note pad completed"); 
  
  }
  
  @AfterClass
  public void tearDown() {
	  driver.quit();
	  
  }
  
  }
 
