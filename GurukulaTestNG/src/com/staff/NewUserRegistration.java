package com.staff;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewUserRegistration extends BaseClass{
	
	@Test(priority=1,description="Register a new user",enabled=true)
	@Parameters({"loginId","emailId","pwd","pwd"})
	public void newUser(String login,String email, String pwd, String cpwd) throws InterruptedException 
	{
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println("Title of the page is "+title);
		
		//New User Registration
		
		driver.findElement(By.linkText("Register a new account")).click();
		driver.findElement(By.name("login")).sendKeys(login);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("confirmPassword")).sendKeys(cpwd);
		
		driver.findElement(By.cssSelector("button[type=submit]")).click();
		Thread.sleep(3000);
		
		//String errorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]")).getText();
		//WebElement w1 = driver.findElement(By.cssSelector("div.container"));
		 String errorMsg = driver.findElement(By.cssSelector("div.alert.alert-danger.ng-scope")).getText();
		 String expected = "Registration failed! Please try again later.";
		 Assert.assertEquals(errorMsg, expected);
		 System.out.println("The ërror message is: "+errorMsg);
	}
	
/*@Test(priority=2,description="Register a new user-validating the error messages",enabled=true)
@Parameters({"loginId1","emailId1","pwd1","pwd1"})

			public void errorMsg(String login,String email, String pwd, String cpwd) throws InterruptedException 
{
	
	Thread.sleep(3000);
				String errMsg;
				String actual;
				String title = driver.getTitle();
				System.out.println("Title of the page is "+title);
				
				//New User Registration
				
				//driver.findElement(By.linkText("Register a new account")).click();
				driver.findElement(By.name("login")).clear();
				driver.findElement(By.name("login")).sendKeys(login);
				
				switch(login) {
					case "NULL": 
						errMsg = "Your login is required.";
						actual = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/form/div[1]/div/p[1]")).getText();
						//actual = driver.findElement(By.xpath("//h1[contains(text()='Registration')]//parent::div//child::form/div[1]")).getText();
						Assert.assertEquals(actual, errMsg);
						System.out.println("The error message is: "+actual);
						break;
					case "@*&":
						errMsg ="Your login can only contain lower-case letters and digits.";
						actual = driver.findElement(By.xpath("//form[@name='form']/div[1]/div/p[4]")).getText();
						Assert.assertEquals(actual, errMsg);
						System.out.println("The error message is: "+actual);
						break;
								}
				
				
				Thread.sleep(3000);
				
				driver.findElement(By.name("email")).sendKeys(email);
				driver.findElement(By.name("password")).sendKeys(pwd);
				driver.findElement(By.name("confirmPassword")).sendKeys(cpwd);
				
				driver.findElement(By.cssSelector("button[type=submit]")).click();
				Thread.sleep(3000);
				
				//String errorMsg = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[2]")).getText();
				//WebElement w1 = driver.findElement(By.cssSelector("div.container"));
				 String errorMsg = driver.findElement(By.cssSelector("div.alert.alert-danger.ng-scope")).getText();
				 String expected = "Registration failed! Please try again later.";
				 Assert.assertEquals(errorMsg, expected);
				 System.out.println("The ërror message is: "+errorMsg);		 
		
	}
*/
}
