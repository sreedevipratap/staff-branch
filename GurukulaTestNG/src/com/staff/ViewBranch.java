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

public class ViewBranch {
	//UserLogin addNewBranch  = new UserLogin();

	@Test(description="View details of a Branch",dependsOnGroups= {"UserLogin.login"},enabled=true)
	public void viewBranch() throws InterruptedException {
			 //Selecting the Branch info
			Thread.sleep(3000);
			
			
			UserLogin.entities.click();
			String s= UserLogin.entities.getText();
			System.out.println("The entities link containing Branch and Staff dropdown: "+s);
				
			 UserLogin.driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[@ui-sref='branch']/span[2]")).click();	
			 
			 UserLogin.title = UserLogin.driver.getTitle();
			 System.out.println("Title of the Branch page is: "+UserLogin.title);
			 UserLogin.expected = "Branches";
			 Assert.assertEquals(UserLogin.title, UserLogin.expected);
			 
			// WebElement branch = driver.findElement(By.xpath("//button[@href='#/branch/9']//following::button[2]"));
			 //System.out.println("The element is not present: "+branch );
			 
			 //View branch details
			 UserLogin.driver.findElement(By.xpath("//button[@href='#/branch/1']")).click();
			 //driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr[2]/td[4]/button[1]")).click();
			 Thread.sleep(2000);
			 
			 Assert.assertTrue(UserLogin.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/h2/span")).isDisplayed());
			// Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[4]/button[1]/span[2]")).isDisplayed());
			 System.out.println(" Branch details viewed ");
	}
}

