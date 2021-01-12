package com.mySeleniumExample;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectModelExample {
	public PageObjectModelExample(WebDriver driver){
		this.driver = driver;
	}


	WebDriver driver;
	
	@FindBy(xpath = "//*[@title='Search']")
	WebElement googleSearch;

	
	public void searchGoogleByText(String searchPhrase) {

		PageFactory.initElements(driver, this);
		googleSearch.sendKeys(searchPhrase);
		googleSearch.sendKeys(Keys.ENTER);

	}
	
	public void verifyLinkLoaded(String searchResultsLink) throws InterruptedException {
		//wait for the result to display
		WebElement searchResult = (new WebDriverWait(driver, 10))
	              .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@href='" +searchResultsLink + "']")));
		//verify it is displayed
		searchResult.isDisplayed();
	}
	
	public void clickElement(String elementType, String linkToClick) throws InterruptedException {
		//wait for the result to display
		WebElement searchResult = (new WebDriverWait(driver, 10))
	              .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@" + elementType +"='" +linkToClick + "']")));
		//verify it is displayed
		searchResult.click();
	}
	
	public void sendKeysToElement(String elementType, String typeDescription, String charactersToSend) throws InterruptedException {
		//wait for the result to display
		WebElement searchResult = (new WebDriverWait(driver, 10))
	              .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@" + elementType + "='" +typeDescription + "']")));
		//verify it is displayed
		searchResult.sendKeys(charactersToSend);
	}
	
	


}
