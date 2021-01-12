package com.mySeleniumExample;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleCase2 {
	public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/myDriver/chromedriver.exe");
			WebDriver myDriver = new ChromeDriver();
		
			//2. accept and validate alerts
			PageObjectModelExample pageobjectmodelexample = new PageObjectModelExample(myDriver);
			myDriver.navigate().to("http://demo.guru99.com/test/delete_customer.php");
			
			//Submit customer to delete
			pageobjectmodelexample.sendKeysToElement("name", "cusid", "123456");
			pageobjectmodelexample.clickElement("name", "submit");
			
			//accept alert
			Alert alert = myDriver.switchTo().alert();
			alert.accept();
			
			
			//Verify alert deleted successfully
			//alert = myDriver.switchTo().alert();
			String alertMessage= myDriver.switchTo().alert().getText();
			Assert.assertEquals(alertMessage,"Customer Successfully Delete!");
			
			myDriver.close();
			Thread.sleep(1500);
	}
			
}
