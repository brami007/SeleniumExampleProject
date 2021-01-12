package com.mySeleniumExample;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleCase3 {
	public static void main(String[] args) throws InterruptedException {
	//3. handling multiple windows and verify all windows closed
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/myDriver/chromedriver.exe");
			WebDriver myDriver = new ChromeDriver();
			PageObjectModelExample pageobjectmodelexample = new PageObjectModelExample(myDriver);
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
			
			myDriver.close();
	}
}
