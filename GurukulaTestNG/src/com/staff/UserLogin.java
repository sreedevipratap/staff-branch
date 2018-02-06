package com.staff;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserLogin extends BaseClass{
	

//public static WebDriver driver;
public static String expected;
public static WebElement entities;
public static String actual;
public static String title;
	
/*@BeforeTest
@Parameters({"url"})
public void openSession(String url)
{
	  	System.setProperty("webdriver.chrome.driver","C:\\Users\\Sreedevi Pratap\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//implicit wait
		System.out.println("=======Browser started=========");
}*/

@Test(description="Login to Gurukula",groups= {"UserLogin.login"})
@Parameters({"uname","pwd"})
public void login(String uname, String pwd) throws InterruptedException {

		title = driver.getTitle();
		System.out.println("Title of the page is "+title);
		
		//User Login
		driver.findElement(By.linkText("login")).click();
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("login"));
	
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		
		//check again
		driver.findElement(By.className("btn")).click();
		
		 title = driver.getTitle();
		 System.out.println("Title of login page is "+title);
		 expected = "Authentication";
		 
		 Assert.assertEquals(title, expected);
		 
		 WebElement home = driver.findElement(By.linkText("Home"));
		 
		 Assert.assertTrue(home.isDisplayed());
		 Thread.sleep(3000);
		 
		 //WebElement entities = driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[2]/a/span/span[2]"));
		  entities = driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[2]/a"));
		  actual = entities.getText();
		 expected = "Entities";
		 Assert.assertEquals(actual, expected);
		// Assert.assertTrue(entities.isDisplayed());
		 
		WebElement account = driver.findElement(By.linkText("Account"));
		 
		 Assert.assertTrue(account.isDisplayed());
		 
		 System.out.println("Login Successful");
		 
}

/*@AfterTest
public void closeSession() {
		
		 driver.close();
		 System.out.println("===========Browser closed============");

	}*/
}