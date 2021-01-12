package com.mySeleniumExample;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Example1 {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/myDriver/chromedriver.exe");

		WebDriver myDriver = new ChromeDriver();
		
		myDriver.navigate().to("http://www.google.com");
	}

}
