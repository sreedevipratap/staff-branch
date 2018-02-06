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

public class DeleteStaff {
	public static String expected;
	//public static WebElement entities;
	public static String actual;
	public static String title;

@Test(description="Delete Staff",dependsOnGroups= {"UserLogin.login"},enabled=true)

public void delStaff() throws Throwable {
	
		//Selecting the Staff info
		UserLogin.entities.click();
		String s= UserLogin.entities.getText();
		System.out.println(s);
		
		//Navigate to the Staff page
		UserLogin.driver.findElement(By.xpath("//a[@href='#/staff']")).click();		 
		title = UserLogin.driver.getTitle();
		System.out.println(title);
		expected = "Staffs";
		Assert.assertEquals(title, expected);
		 
		//Delete a staff
		UserLogin.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr[6]/td[4]/button[3]")).click();
		Thread.sleep(3000);
		title = UserLogin.driver.getTitle();
		System.out.println("title of page is "+title);
		UserLogin.driver.findElement(By.xpath("//*[@id=\"deleteStaffConfirmation\"]/div/div/form/div[3]/button[2]")).click();
		
		//Assert.assertTrue(UserLogin.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[2]")).isDisplayed());
		System.out.println(" Staff deleted");

	}
}

