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

public class EditBranch {
	//public static WebDriver driver;
	public static String expected;
	//public static WebElement entities;
	public static String actual;
	public static String title;

	@Test(priority=6,description="Edit Branch Details",dependsOnGroups= {"UserLogin.login"},enabled=true)
	@Parameters({"shortbrName","brName","code"})
	public void editBranch(String shortbrName,String brName,String code) throws InterruptedException {
			 //Selecting the Branch info
		UserLogin.driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[1]/a[2]/span[2]")).click();
		UserLogin.entities.click();
		String s= UserLogin.entities.getText();
		System.out.println(s);
			
		 UserLogin.driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[@ui-sref='branch']/span[2]")).click();	
		 
		 title = UserLogin.driver.getTitle();
		 System.out.println(title);
		 expected = "Branches";
		 Assert.assertEquals(title, expected);
		
			 
			 
			//Edit an existing branch
			UserLogin.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr[2]/td[4]/button[2]")).click();//copy as xpath
		 
		 //UserLogin.driver.findElement(By.xpath("//button[@href='#/branch/2']//following::button")).click();
			/* WebElement id = driver.findElement(By.xpath("//a[contains(@href,'#/branch/4')]"));
			 String idValue=id.getText();
			 System.out.println("The id is :"+idValue);
			 driver.findElement(By.xpath("//a[contains(@href,'#/branch/4')]//parent::td//following::td//child::button[2]")).click();
			 */
			 Thread.sleep(3000);
			 UserLogin.driver.findElement(By.name("name")).clear();
			 UserLogin.driver.findElement(By.name("name")).sendKeys(shortbrName);
			 String errorMsg = UserLogin.driver.findElement(By.xpath("//div[@id='saveBranchModal']/div/div/form/div[2]/div[2]/div/p[2]")).getText();
			 System.out.println("The error message is :"+errorMsg);
			 expected = "This field is required to be at least 5 characters.";
			 Assert.assertEquals(errorMsg, expected);	
			 UserLogin.driver.findElement(By.name("name")).clear();
			 UserLogin.driver.findElement(By.name("name")).sendKeys(brName);
			 
			 UserLogin.driver.findElement(By.name("code")).clear();
			 UserLogin.driver.findElement(By.name("code")).sendKeys(code);
			 UserLogin.driver.findElement(By.xpath("//div[@id='saveBranchModal']//form[@name='editForm']//button[2]")).click();
			 System.out.println("The branch details have been edited successfully");
			 		 
				
	
	}
	@Test(priority=7,description="Edit Branch Details with invalid branch name",dependsOnGroups= {"UserLogin.login"},enabled=true)
	@Parameters({"shortbrName"})
	public void editBranchInv(String shortBrName) throws InterruptedException {
			 //Selecting the Branch info
		Thread.sleep(2000);
		UserLogin.driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[1]/a[2]/span[2]")).click();
		UserLogin.entities.click();
		String s= UserLogin.entities.getText();
		System.out.println(s);
			
		UserLogin.driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[@ui-sref='branch']/span[2]")).click();	
		 
		 title = UserLogin.driver.getTitle();
		 System.out.println(title);
		 expected = "Branches";
		 Assert.assertEquals(title, expected);
		
			 
			 
			//Edit with invalid branch name 
		 //UserLogin.driver.findElement(By.xpath("//button[@href='#/branch/3']//following::button")).click();
		 UserLogin.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr[2]/td[4]/button[2]")).click();
		 
			 Thread.sleep(3000);
			 UserLogin.driver.findElement(By.name("name")).clear();
			 UserLogin.driver.findElement(By.name("name")).sendKeys(shortBrName);
			 String errorMsg = UserLogin.driver.findElement(By.xpath("//div[@id='saveBranchModal']/div/div/form/div[2]/div[2]/div/p[2]")).getText();
			 System.out.println("The error message is :"+errorMsg);
			 expected = "This field is required to be at least 5 characters.";
			 Assert.assertEquals(errorMsg, expected);	
			 
			 System.out.println("The branch field is required to be at least 5 characters.Edit unsuccessful");
			 UserLogin.driver.findElement(By.xpath("//div[@id='saveBranchModal']//form[@name='editForm']//button[1]")).click();
			 	 
				
	}
}

