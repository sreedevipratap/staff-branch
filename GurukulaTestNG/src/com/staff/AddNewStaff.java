package com.staff;

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

public class AddNewStaff {
	public static String expected;
	//public static WebElement entities;
	public static String actual;
	public static String title;

@Test(priority=10,description="Add a New Staff",dependsOnGroups= {"UserLogin.login"},enabled=true)
@Parameters({"staffName","index"})
public void addStaff(String staffName,int index) throws Throwable {
	
		//Selecting the Staff info
		UserLogin.driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[1]/a[2]/span[2]")).click();
	
		UserLogin.entities.click();
		String s= UserLogin.entities.getText();
		System.out.println(s);
		
		//Navigate to the Staff page
		UserLogin.driver.findElement(By.xpath("//a[@href='#/staff']")).click();		 
		title = UserLogin.driver.getTitle();
		System.out.println(title);
		expected = "Staffs";
		Assert.assertEquals(title, expected);
		 
		//Add a new staff
		UserLogin.driver.findElement(By.className("container")).findElement(By.xpath("//button[@data-target='#saveStaffModal']")).click();
		Thread.sleep(3000);
		title = UserLogin.driver.getTitle();
		System.out.println("title of page is "+title);
		UserLogin.driver.findElement(By.name("name")).sendKeys(staffName);
		WebElement dropdown = UserLogin.driver.findElement(By.name("related_branch"));
		//search.sendKeys("dubai");
	    Thread.sleep(2000);
		Select sel=new Select(dropdown);	
		//sel.selectByVisibleText(brName);
		//sel.selectByValue("number:21");
		sel.selectByIndex(index);	
		UserLogin.driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);	
		
		Assert.assertTrue(UserLogin.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[2]")).isDisplayed());
		System.out.println("New Staff added");

	}

@Test(priority=11,description="Add a New Staff",dependsOnGroups= {"UserLogin.login"},enabled=true)
@Parameters({"staffName1","index1"})
public void addStaff1(String staffName,int index) throws Throwable {
	
		//Selecting the Staff info
		UserLogin.driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[1]/a[2]/span[2]")).click();
	
		UserLogin.entities.click();
		String s= UserLogin.entities.getText();
		System.out.println(s);
		
		//Navigate to the Staff page
		UserLogin.driver.findElement(By.xpath("//a[@href='#/staff']")).click();		 
		title = UserLogin.driver.getTitle();
		System.out.println(title);
		expected = "Staffs";
		Assert.assertEquals(title, expected);
		 
		//Add a new staff
		UserLogin.driver.findElement(By.className("container")).findElement(By.xpath("//button[@data-target='#saveStaffModal']")).click();
		Thread.sleep(3000);
		title = UserLogin.driver.getTitle();
		System.out.println("title of page is "+title);
		UserLogin.driver.findElement(By.name("name")).sendKeys(staffName);
		WebElement dropdown = UserLogin.driver.findElement(By.name("related_branch"));
		//search.sendKeys("dubai");
	    Thread.sleep(2000);
		Select sel=new Select(dropdown);	
		//sel.selectByVisibleText(brName);
		//sel.selectByValue("number:21");
		sel.selectByIndex(index);	
		UserLogin.driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);	
		
		Assert.assertTrue(UserLogin.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[2]")).isDisplayed());
		System.out.println("New Staff added");

	}

@Test(priority=12,description="Add a New Staff",dependsOnGroups= {"UserLogin.login"},enabled=true)
@Parameters({"staffName2","index2"})
public void addStaff2(String staffName,int index) throws Throwable {
	
		//Selecting the Staff info
		UserLogin.driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[1]/a[2]/span[2]")).click();
	
		UserLogin.entities.click();
		String s= UserLogin.entities.getText();
		System.out.println(s);
		
		//Navigate to the Staff page
		UserLogin.driver.findElement(By.xpath("//a[@href='#/staff']")).click();		 
		title = UserLogin.driver.getTitle();
		System.out.println(title);
		expected = "Staffs";
		Assert.assertEquals(title, expected);
		 
		//Add a new staff
		UserLogin.driver.findElement(By.className("container")).findElement(By.xpath("//button[@data-target='#saveStaffModal']")).click();
		Thread.sleep(3000);
		title = UserLogin.driver.getTitle();
		System.out.println("title of page is "+title);
		UserLogin.driver.findElement(By.name("name")).sendKeys(staffName);
		WebElement dropdown = UserLogin.driver.findElement(By.name("related_branch"));
		//search.sendKeys("dubai");
	    Thread.sleep(2000);
		Select sel=new Select(dropdown);	
		//sel.selectByVisibleText(brName);
		//sel.selectByValue("number:21");
		sel.selectByIndex(index);	
		UserLogin.driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);	
		
		Assert.assertTrue(UserLogin.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[2]")).isDisplayed());
		System.out.println("New Staff added");

	}
@Test(priority=13,description="Add a New Staff",dependsOnGroups= {"UserLogin.login"},enabled=true)
@Parameters({"staffName3","index3"})
public void addStaff3(String staffName,int index) throws Throwable {
	
		//Selecting the Staff info
		UserLogin.driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[1]/a[2]/span[2]")).click();
	
		UserLogin.entities.click();
		String s= UserLogin.entities.getText();
		System.out.println(s);
		
		//Navigate to the Staff page
		UserLogin.driver.findElement(By.xpath("//a[@href='#/staff']")).click();		 
		title = UserLogin.driver.getTitle();
		System.out.println(title);
		expected = "Staffs";
		Assert.assertEquals(title, expected);
		 
		//Add a new staff
		UserLogin.driver.findElement(By.className("container")).findElement(By.xpath("//button[@data-target='#saveStaffModal']")).click();
		Thread.sleep(3000);
		title = UserLogin.driver.getTitle();
		System.out.println("title of page is "+title);
		UserLogin.driver.findElement(By.name("name")).sendKeys(staffName);
		WebElement dropdown = UserLogin.driver.findElement(By.name("related_branch"));
		//search.sendKeys("dubai");
	    Thread.sleep(2000);
		Select sel=new Select(dropdown);	
		//sel.selectByVisibleText(brName);
		//sel.selectByValue("number:21");
		sel.selectByIndex(index);	
		UserLogin.driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);	
		
		Assert.assertTrue(UserLogin.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[2]")).isDisplayed());
		System.out.println("New Staff added");

	}
}

