package com.sfdc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sfdc.qa.reusable.ResusableParentClass;
import com.sfdc.qa.util.TestUtil;

public class LoginPage extends ResusableParentClass {
	
	TestUtil testutil;
	//Using Page Factory or OR (Object Repository)
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="pw")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement loginBtb;
	
	@FindBy(name="rememberUn")
	WebElement rememberMeChkBox;
	
	@FindBy(id="forgot_password_link")
	WebElement ForgotPasswordLink;
	
	@FindBy(id="logo")
	WebElement sFLOGO;
	
	@FindBy(id="error")
	WebElement NoPwdErrorMessage;
	
	@FindBy(id="rememberUn")
	WebElement rememberMeCheckBox;
	
	@FindBy(xpath="//input[contains(@value, 'raisandhya2006@gmail.com')]")
	WebElement usernameFieldWithUsername;
	
	@FindBy(id="error")
	WebElement incorrectPwdErrMsg;
	
	//Initialize the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);	
	}
	
	
	
	//Actions 
	public String verifyLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public Boolean verifySFLogo() {
		return sFLOGO.isDisplayed();
	}
	
	public HomePage logIn(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtb.click();
		return new HomePage();
		
	}
	
	public Boolean loginErrorMessage(String un, String pwd) throws Exception {
		username.sendKeys(un);
		password.sendKeys(pwd);
		password.clear();
		loginBtb.click();
		return NoPwdErrorMessage.isDisplayed();
		
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public void checkCheckBox() {
		if (rememberMeCheckBox.isSelected()) {
			System.out.println("checkBox is checked");
		}else
		{
			rememberMeCheckBox.click();
		}	
	}
	
	public HomePage LoginWithCheckBox(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		checkCheckBox();
		loginBtb.click();
		return new HomePage();
	}
	
	public Boolean verifyUserNameIsDisplayed() {
		return usernameFieldWithUsername.isDisplayed();
	}
	
	public ForgotPasswordPage clickForgotPwdLink(String un) {
		username.sendKeys(un);
		ForgotPasswordLink.click();
		return new ForgotPasswordPage();
	}
	
	public String verifyIncorrectPasswordErrorMsg(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtb.click();
		return incorrectPwdErrMsg.getText();
		
	}
		
}
