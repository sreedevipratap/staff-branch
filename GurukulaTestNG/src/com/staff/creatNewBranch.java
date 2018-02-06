package com.staff;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class creatNewBranch {
	  
	//UserLogin ul = new UserLogin();

	WebDriver driver = UserLogin.driver;
	WebElement entities = UserLogin.entities;
	String title ;
	String expected,actual;
/*public static WebDriver driver;
public static String expected;
public static WebElement entities;
public static String actual;
public static String title;
	
@BeforeClass
@Parameters({"url"})
public void beforeClass(String url)
{
	  	System.setProperty("webdriver.chrome.driver","C:\\Users\\Sreedevi Pratap\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//implicit wait
		System.out.println("=======Browser started=========");
}

@Test(description="Login to Gurukula",groups= {"addNewBranch.login"})
@Parameters({"uname","pwd"})
public void login(String uname, String pwd) throws InterruptedException {

		title = driver.getTitle();
		System.out.println("Title of the page is "+title);
		
		//User Login
		driver.findElement(By.linkText("login")).click();
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("login"));
	
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		
		//check again
		driver.findElement(By.className("btn")).click();
		
		 title = driver.getTitle();
		 System.out.println("Title of login page is "+title);
		 expected = "Authentication";
		 
		 Assert.assertEquals(title, expected);
		 
		 WebElement home = driver.findElement(By.linkText("Home"));
		 
		 Assert.assertTrue(home.isDisplayed());
		 Thread.sleep(3000);
		 
		 //WebElement entities = driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[2]/a/span/span[2]"));
		  entities = driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[2]/a"));
		  actual = entities.getText();
		 expected = "Entities";
		 Assert.assertEquals(actual, expected);
		// Assert.assertTrue(entities.isDisplayed());
		 
		WebElement account = driver.findElement(By.linkText("Account"));
		 
		 Assert.assertTrue(account.isDisplayed());
		 
		 System.out.println("Login Successful");
		 
}*/

@Test(description="Create a New Branch",dependsOnMethods="login",enabled=true)
@Parameters({"brName","code"})
public void newBranch(String brName, String code) {
		 //Selecting the Branch info
		entities.click();
		String s= UserLogin.entities.getText();
		System.out.println(s);
		//Thread.sleep(3000);
		
		//Navigate to the Branch page
		//driver.findElement(By.xpath("//div[@id='navbar-collapse']/ul/li[2]/ul/li[1]/a/span[2]")).click();//copy as xpath
		driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[@ui-sref='branch']/span[2]")).click();
		//Thread.sleep(3000);
		 
		 title = driver.getTitle();
		 System.out.println(title);
		 String expected = "Branches";
		 Assert.assertEquals(title, expected);
		
		 
		 //Create new branch
		 driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div/div[1]/button/span[2]")).click();
		 driver.findElement(By.name("name")).sendKeys("Netherlands");
		 driver.findElement(By.name("name")).clear();
		 driver.findElement(By.name("name")).sendKeys(brName);
		 driver.findElement(By.name("code")).sendKeys(code);
		 driver.findElement(By.cssSelector("button[type=submit]")).click();
		 
		 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[4]/button[1]/span[2]")).isDisplayed());
		 System.out.println("New Branch created");
}

/*@Test(priority=1,description="View details of a Branch",dependsOnMethods="login",enabled=true)
public void viewBranch() throws InterruptedException {
		 //Selecting the Branch info
		Thread.sleep(3000);
		entities.click();
		String s= entities.getText();
		System.out.println("The entities link containing Branch and Staff dropdown: "+s);
			
		 driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[@ui-sref='branch']/span[2]")).click();	
		 
		 title = driver.getTitle();
		 System.out.println("Title of the Branch page is: "+title);
		 expected = "Branches";
		 Assert.assertEquals(title, expected);
		 
		// WebElement branch = driver.findElement(By.xpath("//button[@href='#/branch/9']//following::button[2]"));
		 //System.out.println("The element is not present: "+branch );
		 
		 //View branch details
		 driver.findElement(By.xpath("//button[@href='#/branch/1']")).click();
		 //driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr[2]/td[4]/button[1]")).click();
		 Thread.sleep(2000);
		 
		 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/h2/span")).isDisplayed());
		// Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr/td[4]/button[1]/span[2]")).isDisplayed());
		 System.out.println(" Branch details viewed ");
}*/

/*@Test(priority=2,description="Edit Branch Details",dependsOnMethods="login",enabled=false)
public void editBranch() throws InterruptedException {
		 //Selecting the Branch info
	entities.click();
	String s= entities.getText();
	System.out.println(s);
		
	 driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[@ui-sref='branch']/span[2]")).click();	
	 
	 title = driver.getTitle();
	 System.out.println(title);
	 expected = "Branches";
	 Assert.assertEquals(title, expected);
	
		 
		 
		//Edit an existing branch
		//driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/table/tbody/tr[2]/td[4]/button[2]")).click();//copy as xpath
	 
		driver.findElement(By.xpath("//button[@href='#/branch/4']//following::button")).click();
		 WebElement id = driver.findElement(By.xpath("//a[contains(@href,'#/branch/4')]"));
		 String idValue=id.getText();
		 System.out.println("The id is :"+idValue);
		 driver.findElement(By.xpath("//a[contains(@href,'#/branch/4')]//parent::td//following::td//child::button[2]")).click();
		 
		 Thread.sleep(3000);
	   	 driver.findElement(By.name("name")).clear();
		 driver.findElement(By.name("name")).sendKeys("Coc");
		 String errorMsg = driver.findElement(By.xpath("//div[@id='saveBranchModal']/div/div/form/div[2]/div[2]/div/p[2]")).getText();
		 System.out.println("The error message is :"+errorMsg);
		 expected = "This field is required to be at least 5 characters.";
		 Assert.assertEquals(errorMsg, expected);	
		 driver.findElement(By.name("name")).clear();
		 driver.findElement(By.name("name")).sendKeys("Kochi");
		 
		 driver.findElement(By.name("code")).clear();
		 driver.findElement(By.name("code")).sendKeys("COK");
		 driver.findElement(By.xpath("//div[@id='saveBranchModal']//form[@name='editForm']//button[2]")).click();
		 System.out.println("The branch details have been edited successfully");
		 		 
			
}*/

/*@Test(priority=3,description="Edit Branch Details with invalid branch name",dependsOnMethods="login",enabled=false)
public void editBranchInv() throws InterruptedException {
		 //Selecting the Branch info
	Thread.sleep(2000);
	entities.click();
	String s= entities.getText();
	System.out.println(s);
		
	 driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[@ui-sref='branch']/span[2]")).click();	
	 
	 title = driver.getTitle();
	 System.out.println(title);
	 expected = "Branches";
	 Assert.assertEquals(title, expected);
	
		 
		 
		//Edit with invalid branch name 
		 driver.findElement(By.xpath("//button[@href='#/branch/3']//following::button")).click();
		
		 Thread.sleep(3000);
	   	 driver.findElement(By.name("name")).clear();
		 driver.findElement(By.name("name")).sendKeys("Coc");
		 String errorMsg = driver.findElement(By.xpath("//div[@id='saveBranchModal']/div/div/form/div[2]/div[2]/div/p[2]")).getText();
		 System.out.println("The error message is :"+errorMsg);
		 expected = "This field is required to be at least 5 characters.";
		 Assert.assertEquals(errorMsg, expected);	
		 
		 System.out.println("The branch field is required to be at least 5 characters.Edit unsuccessful");
		 driver.findElement(By.xpath("//div[@id='saveBranchModal']//form[@name='editForm']//button[1]")).click();
		 	 
			
}*/
/*@Test(priority=4,description="Delete a Branch",dependsOnMethods="login",enabled=false)
public void delBranch() throws InterruptedException {
		 //Selecting the Branch info
	Thread.sleep(3000);
	entities.click();
	String s= entities.getText();
	System.out.println(s);
	//Thread.sleep(3000);
	
	//Navigate to the Branch page
	//driver.findElement(By.xpath("//div[@id='navbar-collapse']/ul/li[2]/ul/li[1]/a/span[2]")).click();//copy as xpath
	driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[@ui-sref='branch']/span[2]")).click();
	//Thread.sleep(3000);
	 
	 title = driver.getTitle();
	 System.out.println(title);
	 expected = "Branches";
	 Assert.assertEquals(title, expected);
		 
		 
	 driver.findElement(By.xpath("//button[@href='#/branch/9']//following::button[2]")).click();
	 Thread.sleep(3000);
	 System.out.println("ufffffff");
	 
	 driver.findElement(By.xpath("//*[@id='deleteBranchConfirmation']/div/div/form/div[3]/button[2]")).click();
	 Thread.sleep(3000);
	 
	 Assert.assertFalse(driver.findElement(By.xpath("//button[@href='#/branch/9']//following::button[2]")).isEnabled());
	 System.out.println("The branch has been deleted successfully");
		 		 
			
}*/
/*@Test(priority=4,description="Search for a Branch",dependsOnMethods="login",enabled=false)
public void searchBranch() throws InterruptedException {
	//Selecting the Branch info
	Thread.sleep(3000);
	entities.click();
	String s= entities.getText();
	System.out.println(s);
	
	
	//Navigate to the Branch page
	driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[@ui-sref='branch']/span[2]")).click();
	
	 
	 title = driver.getTitle();
	 System.out.println(title);
	 expected = "Branches";
	 Assert.assertEquals(title, expected);
		 
	 driver.findElement(By.id("searchQuery")).clear();	 
	 driver.findElement(By.id("searchQuery")).sendKeys("LON");
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//input[@id='searchQuery']//parent::div//following::button")).click();
	 
	 Thread.sleep(3000);
	 Boolean flag = driver.findElement(By.xpath("//div[@class='table-responsive']//tbody")).getText().isEmpty();
	 System.out.println("The branch does not exist :"+flag);
	 
	 Assert.assertTrue(driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//td[2]")).isDisplayed());
	 System.out.println("The searched branch is :"+driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//td[2]")).getText());
	
}*/
/*@Test(priority=4,description="Search for a Branch that does not exist",dependsOnMethods="login",enabled=false)
public void searchNilBranch() throws InterruptedException {
	//Selecting the Branch info
	Thread.sleep(3000);
	entities.click();
	String s= entities.getText();
	System.out.println(s);
	
	
	//Navigate to the Branch page
	driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[@ui-sref='branch']/span[2]")).click();
	
	 
	 title = driver.getTitle();
	 System.out.println(title);
	 expected = "Branches";
	 Assert.assertEquals(title, expected);
		 
		 
	 driver.findElement(By.id("searchQuery")).clear();

	 driver.findElement(By.id("searchQuery")).sendKeys("DXB");
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//input[@id='searchQuery']//parent::div//following::button")).click();
	 
	 Thread.sleep(3000);
	 
	 Boolean flag = driver.findElement(By.xpath("//div[@class='table-responsive']//tbody")).getText().isEmpty();
	 
	 
	 if(flag==true) {
		 
		 System.out.println("The branch does not exist :"+flag);
	 }
	 else
	 {
		 Assert.assertTrue(driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//td[2]")).isDisplayed());
		 System.out.println("The searched branch is :"+driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//td[2]")).getText());
	 }
	 //System.out.println("The searched branch is :"+driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//td[2]")).getText());
	
}*/

@Test(priority=4,description="Search for a Branch after reloading the jar file",dependsOnMethods="login",enabled=true)
public void invalidBranch() throws InterruptedException {
	//Selecting the Branch info
	Thread.sleep(3000);
	entities.click();
	String s= entities.getText();
	System.out.println(s);
	
	
	//Navigate to the Branch page
	driver.findElement(By.xpath("//div[@id='navbar-collapse']//a[@ui-sref='branch']/span[2]")).click();
	
	 
	 title = driver.getTitle();
	 System.out.println(title);
	 expected = "Branches";
	 Assert.assertEquals(title, expected);
		 
		 
	 driver.findElement(By.id("searchQuery")).clear();

	 driver.findElement(By.id("searchQuery")).sendKeys("COK");
	 Thread.sleep(3000);
	 //click on search
	 driver.findElement(By.xpath("//input[@id='searchQuery']//parent::div//following::button")).click();
	 
	 Thread.sleep(3000);
	 
	 actual = driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//td[1]")).getText();
	 //driver.findElement(By.xpath("//a[@href='#/branch/24']")).getText();
	 System.out.println(actual+ " The ID of cok");
	 expected = "2";
	 //Assert.assertNotEquals(expected, actual);
	 System.out.println("Wrong branch found. View Branch");
	 driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//td[1]/a")).click();
	 Thread.sleep(3000);
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/table/tbody/tr[1]/td[2]/input")).isDisplayed());
	 System.out.println("The branch viewdddddd");
	 //driver.findElement(By.xpath("//div[@class='container']//tbody/tr/td[2]/input")).isDisplayed();
	 /* Boolean flag = driver.findElement(By.xpath("//div[@class='table-responsive']//tbody")).getText().isEmpty();
	 
	 
	 if(flag==true) {
		 
		 System.out.println("The branch does not exist :"+flag);
	 }
	 else
	 {
		 Assert.assertTrue(driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//td[2]")).isDisplayed());
		 System.out.println("The searched branch is :"+driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//td[2]")).getText());
	 }
	 //System.out.println("The searched branch is :"+driver.findElement(By.xpath("//div[@class='table-responsive']//tbody//td[2]")).getText());
	*/
}

/*@AfterClass
public void afterClass() {
		
		 driver.close();
		 System.out.println("===========Browser closed============");

	}*/

}
