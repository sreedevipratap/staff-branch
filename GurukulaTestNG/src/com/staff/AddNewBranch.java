package com.staff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddNewBranch {
	
	//WebDriver driver = UserLogin.driver;
	//WebElement entities = UserLogin.entities;
	String title ;
	String expected,actual;

	@Test(description="Create a New Branch",dependsOnGroups= {"UserLogin.login"},enabled=true)
	@Parameters({"brName","code"})
	public void newBranch(String brName, String code) {
			
		   //Selecting the Branch info
		    
		    UserLogin.entities.click();
			String s= UserLogin.entities.getText();
			System.out.println(s);
			
			
			//Navigate to the Branch page
			
			UserLogin.driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[@ui-sref='branch']/span[2]")).click();
						 
			 title = UserLogin.driver.getTitle();
			 System.out.println(title);
			 String expected = "Branches";
			 Assert.assertEquals(title, expected);
			
			 
			 //Create new branch
			 UserLogin.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div/div[1]/button/span[2]")).click();
			 UserLogin.driver.findElement(By.name("name")).sendKeys("Netherlands");
			 UserLogin.driver.findElement(By.name("name")).clear();
			 UserLogin.driver.findElement(By.name("name")).sendKeys(brName);
			 UserLogin.driver.findElement(By.name("code")).sendKeys(code);
			 UserLogin.driver.findElement(By.cssSelector("button[type=submit]")).click();
			 
			 Assert.assertTrue(UserLogin.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[4]/button[1]/span[2]")).isDisplayed());
			 System.out.println("New Branch created");
	}
}
