package com.staff;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchBranch {
	public static String expected;
	//public static WebElement entities;
	public static String actual;
	public static String title;
	
	@Test(description="Search for a Branch",dependsOnGroups= {"UserLogin.login"},enabled=true)
	@Parameters({"branchName"})
	public void searchBranch(String brName) throws InterruptedException {
		//Selecting the Branch info
		Thread.sleep(3000);
		UserLogin.entities.click();
		String s= UserLogin.entities.getText();
		System.out.println(s);
		
		
		//Navigate to the Branch page
		UserLogin.driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[@ui-sref='branch']/span[2]")).click();
		
		 
		 title = UserLogin.driver.getTitle();
		 System.out.println(title);
		 expected = "Branches";
		 Assert.assertEquals(title, expected);
			 
		 UserLogin.driver.findElement(By.id("searchQuery")).clear();	 
		 UserLogin.driver.findElement(By.id("searchQuery")).sendKeys(brName);
		 Thread.sleep(3000);
		 UserLogin.driver.findElement(By.xpath("//input[@id='searchQuery']//parent::div//following::button")).click();
		 
		 Thread.sleep(3000);
		 Boolean flag = UserLogin.driver.findElement(By.xpath("//div[@class='table-responsive']//tbody")).getText().isEmpty();
		 
		 if(flag==false) {
		 System.out.println("The branch exists :"+flag);
		 Assert.assertTrue(UserLogin.driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//td[2]")).isDisplayed());
		 System.out.println("The searched branch is :"+UserLogin.driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//td[2]")).getText());
		 System.out.println("The branch details have been viewed.");
		 }
		 else
		 {
			 System.out.println("The branch does not exist :"+flag);
			// Assert.assertTrue(UserLogin.driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//td[2]")).isDisplayed());
			 //System.out.println("The searched branch is :"+UserLogin.driver.findElement(By.id("searchQuery")).getText());
			 System.out.println("The branch details could not be viewed.");
		 }
	}
	
}
