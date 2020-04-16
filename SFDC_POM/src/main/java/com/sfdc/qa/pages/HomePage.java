package com.sfdc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sfdc.qa.reusable.ResusableParentClass;

public class HomePage extends ResusableParentClass {
	
	@FindBy(id="userNavLabel")
	WebElement UserNavigationDropDown;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logoutLink;

	public HomePage() {
		PageFactory.initElements(driver, this);	
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public LoginPage logout() throws Exception {
		UserNavigationDropDown.click();
		Thread.sleep(2000);
		logoutLink.click();
		return new LoginPage();
		
	}

		
	}


	
