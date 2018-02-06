package com.staff;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchStaff {
	

//public static WebDriver driver;
public static String expected;
//public static WebElement entities;
public static String actual;
public static String title;

@Test(description="Search Staff",dependsOnGroups= {"UserLogin.login"},enabled=true)
@Parameters({"staffName"})
	public void searchStaff(String staffName) throws InterruptedException {
		
		//Selecting the Staff info
		Thread.sleep(3000);
		UserLogin.entities.click();
		String s= UserLogin.entities.getText();
		System.out.println(s);
		
		//Navigate to the Staff page
		UserLogin.driver.findElement(By.xpath("//a[@href='#/staff']")).click();		 
		title = UserLogin.driver.getTitle();
		System.out.println(title);
		expected = "Staffs";
		Assert.assertEquals(title, expected);
		 
			
		//Search a staff
		UserLogin.driver.findElement(By.id("searchQuery")).sendKeys(staffName);
		UserLogin.driver.findElement(By.xpath("//form[@name='searchForm']//button[@ng-click='search()']")).click();
		Thread.sleep(3000); 
		WebElement id = UserLogin.driver.findElement(By.xpath("//div[@class='container']//tbody//a[1]"));
		String idValue =id.getText();
		System.out.println("id is: "+idValue);
		
		id.findElement(By.xpath("//parent::td//following::td//child::button")).click();
		//driver.findElement(By.xpath("//a[contains(@href,'#/staff/')]//parent::td//following::td//child::button")).click();
		Thread.sleep(2000);
		
		String staffNo=UserLogin.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/h2")).getText();
		System.out.println("hereee: "+staffNo);
		String no=staffNo.substring(5);
		System.out.println(no);
		if(no.isEmpty())
		{
			System.out.println("Invalid staff");
		}
		else {
			Assert.assertFalse(no.isEmpty());
		//Assert.assertTrue(UserLogin.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/h2")).isDisplayed());
		System.out.println("Found Staff data");
	}}
}

