package com.mmt.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmt.base.TestBase;
import com.mmt.util.TestUtil;

public class BookingPage extends TestBase {

	String leftgrid = "//div[@class='splitVw-sctn pull-left']";
	String rightgrid = "//div[@class='splitVw-sctn pull-right']";
	String list = "//div[@class='fli-list splitVw-listing'][";
	String radio = "]";
	String depElement = leftgrid + list + TestUtil.depIndex + radio;
	String retElement = rightgrid + list + TestUtil.retIndex + radio;
	String price = "//p[@class='actual-price']";
	String depPriceFinal = "//div[@class='splitVw-footer-left ']";
	String depPriceElement = depPriceFinal + price;
	String retPriceFinal = "//div[@class='splitVw-footer-right ']";
	String retPriceElement = retPriceFinal + price;
	int finalDeparturePrice;
	int finalReturnPrice;
	int finalAmount;

	@FindBy(xpath = "//div[@class='splitVw-sctn pull-left']//div[@class='fli-list splitVw-listing']")
	List<WebElement> departureResults;

	@FindBy(xpath = "//div[@class='splitVw-sctn pull-right']//div[@class='fli-list splitVw-listing']")
	List<WebElement> returnResults;

	@FindBy(xpath = "//div[@class='splitVw-footer-left ']//p[@class='actual-price']//span")
	WebElement depPrice;

	@FindBy(xpath = "//div[@class='splitVw-footer-right ']//p[@class='actual-price']//span")
	WebElement retPrice;
	
	@FindBy(xpath="//p[text()='Departure Flight']")
	WebElement depFlightBar;

	public BookingPage() {
		PageFactory.initElements(driver, this);
	}

	public int selectDepFlight() {
		TestUtil.wait(20, depFlightBar);
		WebElement depRadioBtn = driver.findElement(By.xpath(depElement));
		TestUtil.wait(45, depRadioBtn);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", depRadioBtn);
		String strPrice= driver.findElement(By.xpath(depElement + price)).getText().replaceAll("[^0-9]","").trim();
		int amt = Integer.parseInt(strPrice);
		return amt;

	}

	public int selectReturnFlight() {

		WebElement retRadioBtn = driver.findElement(By.xpath(retElement));
		TestUtil.wait(45, retRadioBtn);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", retRadioBtn);
		int amt = Integer.parseInt(driver.findElement(By.xpath(retElement + price)).getText().replaceAll("[^0-9]","").trim());
		return amt;

	}

	public int getfinalDepPrice() {

		WebElement depCost = driver.findElement(By.xpath(depPriceElement));
		TestUtil.wait(45, depCost);
		finalDeparturePrice = Integer.parseInt(depCost.getText().replaceAll("[^0-9]","").trim());
		return finalDeparturePrice;

	}

	public int getfinalRetPrice() {

		WebElement retCost = driver.findElement(By.xpath(retPriceElement));
		TestUtil.wait(45, retCost);
		finalReturnPrice = Integer.parseInt(retCost.getText().replaceAll("[^0-9]","").trim());
		return finalReturnPrice;

	}
	
	
	public int calculateTotalAmount() {
		
		finalAmount = Integer.parseInt(driver.findElement(By.xpath("//span[@class='splitVw-total-fare']")).getText().replaceAll("[^0-9]","").trim());
		return finalAmount;
	}
	

}
