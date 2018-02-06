package com.staff;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class InvalidStaffName {
	

public static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sreedevi Pratap\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//Navigate to Gurukula Home Page
		driver.get("http://127.0.0.1:8081");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//implicit wait
		
		String title = driver.getTitle();
		System.out.println("Title of the page is "+title);
	
		//User Login
		driver.findElement(By.linkText("login")).click();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.className("btn")).click();
		//Assert destination page
		title = driver.getTitle();
		System.out.println("Title of login page is "+title);
	    String expected = "Authentication"; 
		Assert.assertEquals(title, expected);
		 
		//Assert the links on the page
		WebElement home = driver.findElement(By.linkText("Home"));
		Assert.assertTrue(home.isDisplayed());
		Thread.sleep(3000);
		 
		WebElement entities = driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[2]/a"));
		String actual = entities.getText();
		expected = "Entities";
		Assert.assertEquals(actual, expected);
		// Assert.assertTrue(entities.isDisplayed());
		WebElement account = driver.findElement(By.linkText("Account"));
		Assert.assertTrue(account.isDisplayed());
		 
		//Selecting the Staff info
		entities.click();
		String s= entities.getText();
		System.out.println(s);
		
		//Navigate to the Staff page
		driver.findElement(By.xpath("//a[@href='#/staff']")).click();		 
		title = driver.getTitle();
		System.out.println(title);
		expected = "Staffs";
		Assert.assertEquals(title, expected);
		 
					
		//Add an invalid staff name
		driver.findElement(By.className("container")).findElement(By.xpath("//button[@data-target='#saveStaffModal']")).click();
		Thread.sleep(3000);
		title = driver.getTitle();
		System.out.println("title of page is "+title);	
		driver.findElement(By.name("name")).sendKeys("malayalam55");
		//String staffName = driver.findElement(By.name("name")).getText();
		//String staffName = driver.findElement(By.xpath("//*[@id=\"saveStaffModal\"]/div/div/form/div[2]/div[2]/input")).getText();
		//System.out.println("The string is :"+staffName);
		//if((staffName != 32 )&& (staffName < 65 || staffName > 90) && (staffName < 97 || staffName > 122))
		String text = driver.findElement(By.xpath("//*[@id=\"saveStaffModal\"]/div/div/form/div[2]/div[2]/div/p[4]")).getText();
		System.out.println(text);
		expected = "This field should follow pattern ^[a-zA-Z\\s]*$.";			
		Assert.assertEquals(text, expected);
		Thread.sleep(3000);
		driver.findElement(By.id("saveStaffModal")).findElement(By.xpath("//form[@name='editForm']/div[3]/button")).click();
		Thread.sleep(3000);
		
		
		Thread.sleep(3000);
	    driver.close();

	}
}

