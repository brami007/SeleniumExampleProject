package com.mySeleniumExample;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ExampleCase1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//1. search on google then verify search returned results and go to page
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/myDriver/chromedriver.exe");
		WebDriver myDriver = new ChromeDriver();
		myDriver.navigate().to("http://www.google.com");
		
		
		PageObjectModelExample pageobjectmodelexample = new PageObjectModelExample(myDriver);
		
		//search google and verify search result loaded
		pageobjectmodelexample.searchGoogleByText("testing 123");
		pageobjectmodelexample.verifyLinkLoaded("https://testing123.education.mn.gov/");
		
		//go to page and verify new page loads
		pageobjectmodelexample.clickElement("href", "https://testing123.education.mn.gov/");
		pageobjectmodelexample.verifyLinkLoaded("/test/");
		
		myDriver.close();
		Thread.sleep(1500);
		
		
		
	}

}
