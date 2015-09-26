package com.MG.testcases;

import java.io.File;
import java.io.IOException;
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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class rough {

public static AndroidDriver driver;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.0.2");
		capabilities.setCapability("appPackage", "com.olx.southasia.hackathon");
		capabilities.setCapability("appActivity", "pl.tablica2.activities.MainActivity");
		capabilities.setCapability("deviceName", "Android HTC Device");
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		for (int i = 0; i < 5; i++) {
			
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Submit a Free Ad')]")).click();
			driver.pressKeyCode(AndroidKeyCode.BACK);
			
			Thread.sleep(3000);
			String filename = "C:\\Mohit\\Java Workspaces\\OLX\\ResultImages\\Home\\tcPosting01-"+i+".jpg";
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(filename));
			
		}

		
		
		
		

	}

}
