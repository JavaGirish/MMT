package com.mmt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmt.base.TestBase;
import com.mmt.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[text()='Flights']")
	WebElement flightsLink;

	@FindBy(xpath = "//li[text()='Round Trip']//span")
	WebElement roundTripBtn;

	@FindBy(id = "fromCity")
	WebElement fromCityBtn;

	@FindBy(xpath = "//input[@placeholder='From']")
	WebElement fromCityInput;

	@FindBy(xpath = "//div[@id='react-autowhatever-1']//p[contains(text(),'Delhi')]")
	WebElement fromCitydropbox;

	@FindBy(xpath = "//input[@placeholder='To']")
	WebElement toCityInput;

	@FindBy(xpath = "//div[@id='react-autowhatever-1']//p[contains(text(),'Bangalore')]")
	WebElement toCityDropbox;

	

//	@FindBy(xpath="//div[@class='DayPicker-Month']//div[@class='DayPicker-Week']//div[contains(@aria-label,'Apr 26 2019')]")
//	WebElement departureDate;
//	
//	@FindBy(xpath="//div[@class='DayPicker-Month']//div[@class='DayPicker-Week']//div[contains(@aria-label,'May 06 2019')]")
//	WebElement returnDate;

	@FindBy(xpath = "//a[text()='Search']")
	WebElement searchBtn;
	
	
	@FindBy(xpath="//iframe[@name='notification-frame-~19714b447']")
	WebElement adFrame;
	
	@FindBy(xpath="//a[@id='webklipper-publisher-widget-container-notification-close-div']")
	WebElement closeAdBtn;
	
	

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void closeAdWindow() {
		
		//TestUtil.wait(30,adFrame);
		//TestUtil.switchToAdFrame();
		closeAdBtn.click();
		
		
	}
	
	
	
	public void clickOnFlightsLink() {
		flightsLink.click();
	}

	public void clickOnRoundTrip() {
		roundTripBtn.click();

	}

	public void inputFromCity(String fromCity) {
		fromCityBtn.click();
		TestUtil.wait(10, fromCityInput);
		fromCityInput.sendKeys(fromCity);
		TestUtil.wait(10, fromCitydropbox);
		fromCitydropbox.click();
	}

	public void inputToCity(String toCity) {
		TestUtil.wait(10, toCityInput);
		toCityInput.sendKeys(toCity);
		TestUtil.wait(15, toCityDropbox);
		toCityDropbox.click();
	}

	public void selectdepartureDate() {
		String day = TestUtil.getcurrentDate();
		WebElement departureDate = driver.findElement(By.xpath("//div[contains(@aria-label,'" + day + "')]"));
		TestUtil.wait(10, departureDate);
		departureDate.click();

	}

	public void selectreturnDate() {
		String day = TestUtil.getReturnDate();
		WebElement returnDate = driver.findElement(By.xpath("//div[contains(@aria-label,'" + day + "')]"));
		TestUtil.wait(10, returnDate);
		returnDate.click();

	}

	public SearchPage clickOnSearchBtn() {
		TestUtil.wait(10, searchBtn);
		searchBtn.click();
		driver.manage().deleteAllCookies();
		return new SearchPage();
		
	}

	
}
