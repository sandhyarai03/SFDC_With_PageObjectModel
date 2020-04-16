package com.sfdc.qa.reusable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sfdc.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class ResusableParentClass {
	
	public static ExtentTest logger;
	public static ExtentReports report;
	public static WebDriver driver;
	public static Properties prop;
	
	public ResusableParentClass(){
		try {
		prop = new Properties();
		
		FileInputStream	ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/sfdc/qa/config/config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void Initialize() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if ((browserName.equalsIgnoreCase("Firefox"))) {
		
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else {
			System.out.println("No Browser is setup");
		}
		
		CreatReport();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		//logger.log(LogStatus.INFO, "url opened successfully");
		
	}
	
		//Create Extent Report
	public void CreatReport() {
	String fileName = new SimpleDateFormat("'SFDCReport_'YYYYMMddHHmm'.html'").format(new Date());
	String path = "/Users/sandhya/Desktop/TC_Report/" + fileName;
	//String path = "/Users/sandhya/Desktop/TC_Report/testfile.html";
	report = new ExtentReports(path);
	}
	
	public static void CloseBrowser() {
	driver.quit();
	}

	public static void CloseReport() {
	report.flush();
	}

	}
