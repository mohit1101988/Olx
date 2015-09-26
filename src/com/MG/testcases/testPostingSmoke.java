package com.MG.testcases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class testPostingSmoke {

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
	public void tcposting02() throws IOException, InterruptedException{
		
			//purpose : Enter Submit screen and return back 

			driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Submit a Free Ad')]")).click();
			driver.pressKeyCode(AndroidKeyCode.BACK);
			
			Thread.sleep(3000);
			String filename = "C:\\Mohit\\Java Workspaces\\OLX\\ResultImages\\Home\\tcPosting02.jpg";
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(filename));
			
		
				
	}
	
}
	
	
