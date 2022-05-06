package com.sgtetsing.dataprovider;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Createuser {
     
	private static WebDriver oBrowser=null;
	public static void main(String[] args) {
		
	}
	@Test(priority=1)
	private static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver","E:\\JAVAAUTOMATION\\Web-AutomationAssignments\\Library\\Driver\\chromedriver.exe");
	        oBrowser=new ChromeDriver();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=2)
	private static void navigate()
	{
		try
		{
			oBrowser.get("http://localhost:82/login.do");
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=3,dataProvider="credentails")
	private static void login(String user,String pwd)
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys(user);
			oBrowser.findElement(By.name("pwd")).sendKeys(pwd);
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(4000);
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@DataProvider(name="credentails")
	public Object[][] getLoginDetails()
	{
		return new Object[][] {{"admin","manager"}};
			
	}
	@Test(priority=4,dataProvider="users")
	private static void createuser(String Fn,String Ln,String gmail,String Uname,String pwd,String retypepwd)
	{
		try
		{
			oBrowser.findElement(By.xpath("//div[text()='USERS']")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.name("firstName")).sendKeys(Fn);
			oBrowser.findElement(By.name("lastName")).sendKeys(Ln);
			Thread.sleep(2000);
			oBrowser.findElement(By.id("userDataLightBox_emailField")).sendKeys(gmail);
			Thread.sleep(2000);
			oBrowser.findElement(By.id("userDataLightBox_usernameField")).sendKeys(Uname);
			Thread.sleep(2000);
			oBrowser.findElement(By.name("password")).sendKeys(pwd);
			Thread.sleep(2000);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys(pwd);
			oBrowser.findElement(By.xpath("//span[text()='Create User']")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="users")
	public Object[][] getUsertypeDetails()
	{
		return new Object[][] {{"start","finish","Ambani@gmail.com","Demo","ssss","ssss"}};
			
	}
	@Test(priority=5)
	public static void DeleteUser()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/span[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(1000);
			Alert oAlert=oBrowser.switchTo().alert();
			oAlert.accept();
			Thread.sleep(2000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority=6)
	public static void Logout()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'logoutLink\']")).click();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority=7)
	public static void CloseApplication()
	{
		try
		{
			oBrowser.quit();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
}
