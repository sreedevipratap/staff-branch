package com.staff;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBranch {
	

	public static String expected;
	//public static WebElement entities;
	public static String actual;
	public static String title;
	
	
@Test(description="Delete a Branch",dependsOnGroups= {"UserLogin.login"},enabled=true)
public void delBranch() throws InterruptedException {
		 //Selecting the Branch info
		UserLogin.entities.click();
		String s= UserLogin.entities.getText();
		System.out.println(s);
		//Thread.sleep(3000);
		
		//Navigate to the Branch page
		//driver.findElement(By.xpath("//div[@id='navbar-collapse']/ul/li[2]/ul/li[1]/a/span[2]")).click();//copy as xpath
		UserLogin.driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[@ui-sref='branch']/span[2]")).click();
		//Thread.sleep(3000);
		 
		 title = UserLogin.driver.getTitle();
		 System.out.println(title);
		 expected = "Branches";
		 Assert.assertEquals(title, expected);
		
		 
		
		 //Delete an existing branch
		//driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr[2]/td[4]/button[3]")).click();//copy as xpath
		  
		 //UserLogin.driver.findElement(By.xpath("//button[@href='#/branch/2']//following::button[2]")).click();
		 UserLogin.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr[4]/td[4]/button[3]")).click();
		 Thread.sleep(3000);
		 		 
		 UserLogin.driver.findElement(By.xpath("//*[@id='deleteBranchConfirmation']/div/div/form/div[3]/button[2]")).click();
		 Thread.sleep(3000);
		 //Assert.assertFalse(UserLogin.driver.findElement(By.xpath("//button[@href='#/branch/9']//following::button[2]")).isEnabled());
		 System.out.println("The branch has been deleted successfully");
			
		
		 	}
}

