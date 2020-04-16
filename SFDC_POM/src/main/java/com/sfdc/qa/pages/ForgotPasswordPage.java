package com.sfdc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sfdc.qa.reusable.ResusableParentClass;

public class ForgotPasswordPage extends ResusableParentClass {
	
	
	@FindBy(id="un")
	WebElement EmailField;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(xpath="//p[contains(text(),'ve sent you an email with a link to finish rese')]")
	WebElement passwordReSetMessage;
	
	@FindBy(linkText="Return to Login")
	WebElement returnToLoginText;
	
	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public boolean verifypasswordReSetMessage(String un) {
		EmailField.sendKeys(un);
		continueBtn.click();
		return passwordReSetMessage.isDisplayed();
		
		
	}
}
