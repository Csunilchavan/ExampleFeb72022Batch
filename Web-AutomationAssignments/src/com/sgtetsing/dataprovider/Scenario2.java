package com.sgtetsing.dataprovider;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Scenario2 {

	public static WebDriver oBrowser=null;

	@Test(priority=1)
	public static void LaunchBrowser()
	{
		try 
		{
			System.setProperty("webdriver.chrome.driver", "E:\\JAVAAUTOMATION\\Web-AutomationAssignments\\Library\\Driver\\chromedriver.exe");
			oBrowser=new ChromeDriver();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority=2)
	public static void navigate()
	{
		try 
		{
			oBrowser.get("http://localhost:82/login.do");
			Thread.sleep(2000);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority=3,dataProvider="credentails")
	public static void Login(String user,String pwd)
	{
		try 
		{
			oBrowser.findElement(By.id("username")).sendKeys(user);
			oBrowser.findElement(By.name("pwd")).sendKeys(pwd);
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//*[@id=\'loginButton\']/div")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
			Thread.sleep(2000);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="credentails")
	public Object[][] getLoginDetails()
	{
		return new Object[][] {{"admin","manager"}};
	}
	
	
	@Test(priority=4,dataProvider="createuser")
	public static void CreateUser(String fn,String ln,String em,String un,String pw,String pwc)
	{
		try 
		{
			oBrowser.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'createUserDiv\']/div/div[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("userDataLightBox_firstNameField")).sendKeys(fn);
			Thread.sleep(2000);
			oBrowser.findElement(By.id("userDataLightBox_lastNameField")).sendKeys(ln);
			Thread.sleep(2000);
			oBrowser.findElement(By.name("email")).sendKeys(em);
			Thread.sleep(2000);
			oBrowser.findElement(By.name("username")).sendKeys(un);
			Thread.sleep(2000);
			oBrowser.findElement(By.id("userDataLightBox_passwordField")).sendKeys(pw);
			Thread.sleep(2000);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys(pwc);
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div")).click();
			Thread.sleep(3000);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="createuser")
	public Object[][] getCreateUserDetails()
	{
		return new Object[][] {{"Sunil","Chavan","sunil@gmail.com","Sample","Welcome123","Welcome123"}};
	}

	
	@Test(priority=5,dataProvider="modifyuser")
	public static void ModifyUser(String username)
	{
		try 
		{
			oBrowser.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/span[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("userDataLightBox_usernameField")).clear();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("userDataLightBox_usernameField")).sendKeys(username);
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div/span")).click();
			Thread.sleep(3000);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="modifyuser")
	public Object[][] getModifyUserDetails()
	{
		return new Object[][] {{"Demo"}};
	}
	
	@Test(priority=6)
	public static void DeleteUser()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/span[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(3000);
			Alert oAlert=oBrowser.switchTo().alert();
			oAlert.accept();
			Thread.sleep(3000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=7)
	public static void Logout()
	{
		try
		{
			oBrowser.findElement(By.id("logoutLink")).click();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority=8)
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
