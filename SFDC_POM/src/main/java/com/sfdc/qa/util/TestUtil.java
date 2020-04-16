package com.sfdc.qa.util;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.sfdc.qa.reusable.ResusableParentClass;

public class TestUtil extends ResusableParentClass {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public void switchToFrame() {
		driver.switchTo().frame(prop.getProperty("framename"));
	}

	
	public static  void EnterText(WebElement element, String text, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName);
		}else {
			logger.log(LogStatus.INFO, objName);
			element.sendKeys(text);
		}		
	}
	public  void Click(WebElement element, String objName) {
		if (element == null || !element.isDisplayed()) {
			logger.log(LogStatus.ERROR, objName);
		}else {
			logger.log(LogStatus.INFO, objName);
			element.click();
		}
}
}
