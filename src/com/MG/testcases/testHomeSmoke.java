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

public class testHomeSmoke {
	
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
	public void tchome01() throws IOException, InterruptedException{
				
		//Purpose: launch and exit app

				Thread.sleep(3000);
				
				String filename = "C:\\Mohit\\Java Workspaces\\OLX\\ResultImages\\Home\\tchome01.jpg";
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(filename));
	}
	
	@Test(priority = 2)
	public void tchome02() throws IOException, InterruptedException{
				
		//Purpose: Open settings menu
		
				
				driver.findElement(By.id("com.olx.southasia.hackathon:id/action_bar")).findElement(By.className("android.widget.ImageButton")).click();
				Thread.sleep(3000);
				
				String filename = "C:\\Mohit\\Java Workspaces\\OLX\\ResultImages\\Home\\tchome02.jpg";
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(filename));
	}
	
	@Test(priority = 3)
	public void tchome03() throws IOException, InterruptedException{
				
		//Purpose: Get app version info

				
		driver.findElement(By.id("com.olx.southasia.hackathon:id/action_bar")).findElement(By.className("android.widget.ImageButton")).click();
		WebElement bar1 = driver.findElement(By.id("com.olx.southasia.hackathon:id/navigation_drawer"));
		
		List<WebElement> bar2 = bar1.findElements(By.className("android.widget.LinearLayout"));
		System.out.println(bar2.size());
		bar2.get(11).click();
		
		WebElement bar3 = driver.findElement(By.id("android:id/list"));
		List<WebElement> bar4 = bar3.findElements(By.className("android.widget.LinearLayout"));
		bar4.get(4).click();
		
		String ActualVersion = driver.findElement(By.id("com.olx.southasia.hackathon:id/version_name")).getText();
		String ExpectedVersion = "v1.4.1";
		String filename = "C:\\Mohit\\Java Workspaces\\OLX\\ResultImages\\Home\\tchome03.jpg";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(filename));
		
		Assert.assertEquals(ActualVersion, ExpectedVersion);
		
		
		
	}
	
	

}
