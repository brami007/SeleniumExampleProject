package com.mySeleniumExample;
import java.util.Iterator;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SampleTestSuite {
	public static WebDriver myDriver;
	public static PageObjectModelExample pageobjectmodelexample;
	
	
	
	@BeforeClass
	public static void beforeTestCase(){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/myDriver/chromedriver.exe");
	}
	
	
	@Test
	public void test1() throws InterruptedException {
		
		//1. search on google then verify search returned results and go to page
		myDriver = new ChromeDriver();
		pageobjectmodelexample = new PageObjectModelExample(myDriver);
		myDriver.navigate().to("http://www.google.com");
		
		//search google and verify search result loaded
		pageobjectmodelexample.searchGoogleByText("testing 123");
		pageobjectmodelexample.verifyLinkLoaded("https://testing123.education.mn.gov/");
		
		//go to page and verify new page loads
		pageobjectmodelexample.clickElement("href", "https://testing123.education.mn.gov/");
		pageobjectmodelexample.verifyLinkLoaded("/test/");
		
		myDriver.quit();
		Thread.sleep(2000);
	}
	
	@Test
	public void test2() throws InterruptedException {
		
		//2. accept and validate alerts
		myDriver = new ChromeDriver();
		pageobjectmodelexample = new PageObjectModelExample(myDriver);
		myDriver.navigate().to("http://demo.guru99.com/test/delete_customer.php");
		String main = myDriver.getWindowHandle();
		
		//Submit customer to delete
		pageobjectmodelexample.sendKeysToElement("name", "cusid", "123456");
		pageobjectmodelexample.clickElement("name", "submit");
		
		//accept alert
		Alert alert = myDriver.switchTo().alert();
		alert.accept();
		
		
		//Verify alert deleted successfully
		String alertMessage= myDriver.switchTo().alert().getText();
		Assert.assertEquals(alertMessage,"Customer Successfully Delete!");
		myDriver.switchTo().window(main);
		
		myDriver.quit();
		Thread.sleep(2000);
	}
	
	@Test
	public void test3() throws InterruptedException {
		
		//3. handling multiple windows and verify all windows closed
		myDriver = new ChromeDriver();
		pageobjectmodelexample = new PageObjectModelExample(myDriver);
		myDriver.navigate().to("http://www.naukri.com/");
		
		String main = myDriver.getWindowHandle();
		
		//get the number of pop ups currently open and close each window
		Set<String> set = myDriver.getWindowHandles();

		Iterator<String> itr= set.iterator();
		while(itr.hasNext()){
			String childWindow=itr.next();
			if(!main.equals(childWindow)){
			myDriver.switchTo().window(childWindow);
			myDriver.close();
			}
		}
		
		//switch back to main window and verify no windows are open anymore
		myDriver.switchTo().window(main);
		Assert.assertEquals(myDriver.getWindowHandles().size(), 1);
		
		//verify main window is still open
		pageobjectmodelexample.verifyLinkLoaded("https://www.naukri.com/");
		
		myDriver.quit();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public static void quit() throws InterruptedException {
		
	}

}
