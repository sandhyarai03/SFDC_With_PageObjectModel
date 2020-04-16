package com.sfdc.qa.testcases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sfdc.qa.pages.ForgotPasswordPage;
import com.sfdc.qa.pages.HomePage;
import com.sfdc.qa.pages.LoginPage;
import com.sfdc.qa.reusable.ResusableParentClass;

@SuppressWarnings("unused")
public class LoginPageTest extends ResusableParentClass{
	
	private static final LoginPage String = null;
	LoginPage loginpage;
	HomePage homepage;
	ForgotPasswordPage forgotpasswordpage;
	
	
	public LoginPageTest() throws Exception {
		super();
	}
	@Parameters("browser")
 @BeforeMethod
public void setUp() {
	
	Initialize();
	CreatReport();
	loginpage = new LoginPage();
	
}
 
 @Test(priority = 1)
 public void TC1_LoginErrorMsgWithNoPwd() throws Exception {
	 logger = report.startTest("TC1_LoginErrorMsgWithNoPwd");
	
	 Boolean error = loginpage.loginErrorMessage(prop.getProperty("username"), prop.getProperty("password"));
	 Assert.assertTrue(error);
 }
 	
 @Test(priority=2)
 public void TC2_loginTest() {
	 logger = report.startTest("TC1_LoginErrorMsgWithNoPwd");
	 homepage = loginpage.logIn(prop.getProperty("username"), prop.getProperty("password"));
	 String HomepageTitle = loginpage.homePageTitle();
	 System.out.println(HomepageTitle);
	 Assert.assertEquals(HomepageTitle, prop.getProperty("homepagetitle"));
	 
 }	
 
 @Test(priority=3)
	 public void TC3_checkRememberMe() throws Exception {
	 homepage = loginpage.LoginWithCheckBox(prop.getProperty("username"), prop.getProperty("password"));
	// Thread.sleep(2000);
	 String homePageTitle = homepage.homePageTitle();
	 Assert.assertEquals(homePageTitle, prop.getProperty("homepagetitle"), "Home page title not matched");
	 loginpage = homepage.logout();
	 Thread.sleep(2000);
	 String loginpageTitle = loginpage.verifyLoginPageTitle();
	 System.out.println(loginpageTitle);
	 Assert.assertEquals(loginpageTitle, prop.getProperty("loginPageTitle"), "login page title not matched");
	 Thread.sleep(2000);
	 Assert.assertTrue(loginpage.verifyUserNameIsDisplayed(), "UserName is not displayed in username textBox");
	 
	 
 }
 
 @Test(priority=4)  
 	public void TC4_A_forgotPassword() {
	 forgotpasswordpage = loginpage.clickForgotPwdLink(prop.getProperty("username"));
	 Boolean forgotPwd= forgotpasswordpage.verifypasswordReSetMessage(prop.getProperty("username"));
	 Assert.assertTrue(forgotPwd);
	 
 }
 
 @Test (priority=5)
 	public void TC5_verifyIncorrectPasswordErrorMessage() throws Exception {
	 logger = report.startTest("TC5_verifyIncorrectPasswordErrorMessage");
	 String errorMsg = loginpage.verifyIncorrectPasswordErrorMsg(prop.getProperty("username"), prop.getProperty("incorrectpassword"));
	 System.out.println(errorMsg);
	Assert.assertEquals(errorMsg, "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
	 
 }
  @AfterMethod
  public void tearDown() {
	 driver.quit();
	 
 }
  
}
