package com.staff;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	
	@BeforeTest
	@Parameters({"url"})
	public void openSession(String url)
	{
		  	System.setProperty("webdriver.chrome.driver","C:\\Users\\Sreedevi Pratap\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//implicit wait
			System.out.println("=======Browser started=========");
	}
	
	@AfterTest
	public void closeSession() 
	{
			
			 driver.close();
			 System.out.println("===========Browser closed============");

		}
}
