package com.MG.testcases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class testHomeRegression {

	public static AndroidDriver driver;
	
	@BeforeMethod
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.0.2");
		capabilities.setCapability("appPackage", "com.olx.southasia.hackathon");
		capabilities.setCapability("appActivity", "pl.tablica2.activities.MainActivity");
		capabilities.setCapability("deviceName", "Android HTC Device");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void tearDown(){
	
		driver.quit();
	}

	@Test(priority = 1)
	public void tchome04() throws IOException, InterruptedException{
		
		//purpose : Change City in home screen

		driver.findElement(By.id("com.olx.southasia.hackathon:id/location_picker")).click();
		WebElement bar3 = driver.findElement(By.id("com.olx.southasia.hackathon:id/list"));
		List<WebElement> bar4 = bar3.findElements(By.className("android.widget.LinearLayout"));
		bar4.get(4).click();
		String ActualLocation = driver.findElement(By.id("com.olx.southasia.hackathon:id/selected_location")).getText();
		String ExpectedLocation = "Ahmedabad";
		
		String filename = "C:\\Mohit\\Java Workspaces\\OLX\\ResultImages\\Home\\tchome04.jpg";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(filename));
		
		Assert.assertEquals(ActualLocation, ExpectedLocation);
	}
	
	@Test(priority = 2)
	public void tchome05() throws IOException, InterruptedException{
				
		//purpose: view chats for 0 messages scenario		
				
		driver.findElement(By.id("com.olx.southasia.hackathon:id/chatCounterPanel")).click();
		String ActualMessage = driver.findElement(By.id("com.olx.southasia.hackathon:id/txtMessage")).getText();		
		String ExpectedMessage = "There are no conversations... Yet!";
		
		String filename = "C:\\Mohit\\Java Workspaces\\OLX\\ResultImages\\Home\\tchome05.jpg";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(filename));
		
		Assert.assertEquals(ActualMessage, ExpectedMessage);
		
	}
	
}
