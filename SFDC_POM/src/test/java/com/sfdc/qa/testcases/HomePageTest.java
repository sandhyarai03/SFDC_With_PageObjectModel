package com.sfdc.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sfdc.qa.pages.HomePage;
import com.sfdc.qa.pages.LoginPage;
import com.sfdc.qa.reusable.ResusableParentClass;

public class HomePageTest extends ResusableParentClass  {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	@Parameters("browser")
	 @BeforeMethod
	 public void setUp() {
	 	
	 	Initialize();
	 	loginpage = new LoginPage();
	 	//homepage = loginpage.logIn(prop.getProperty("username"), prop.getProperty("password"));
	 	CreatReport();
	 }
	 
	 @Test
	 public void TC6_verifyLogoutTest() throws Exception {
		homepage = loginpage.logIn(prop.getProperty("username"), prop.getProperty("password"));
		String homePageTitl= homepage.homePageTitle();
		Thread.sleep(2000);
		System.out.println(homePageTitl);
		Assert.assertEquals(homePageTitl, prop.getProperty("homepagetitle"), "Home page title not matched");
		loginpage = homepage.logout();
		Thread.sleep(3000);
		String loginpageTitle = loginpage.verifyLoginPageTitle();
		System.out.println(loginpageTitle);
		Assert.assertEquals(loginpageTitle, prop.getProperty("loginPageTitle"), "login page title not matched");
		 
		 
		 
	 }
	 	 
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
		 
	 }
	 
	 
}
