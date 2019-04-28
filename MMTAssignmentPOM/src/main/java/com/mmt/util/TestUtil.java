package com.mmt.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mmt.base.TestBase;

public class TestUtil extends TestBase {

	public static String fromCity = "Delhi";
	public static String ToCity = "Bangalore";
	public static String depDate;
	public static String returnDate;

	public static void wait(int timeout, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static String getcurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");

		Date date = new Date();

		depDate = dateFormat.format(date);

		return depDate;
	
	}

	
	public static String getReturnDate() {
		DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");

		Date date = new Date();

		depDate = dateFormat.format(date);

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 7);
		returnDate = dateFormat.format(c.getTime());
		return returnDate;
			

	}
	
	public static void switchToAdFrame() {
		
		driver.switchTo().frame("notification-frame-~19714b447");
		
	}
	
	
	public static void scrollToBottomofpage() {
		try { 
			long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight"); 
			while (true) { ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);"); 
			Thread.sleep(2000); 
			long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight"); 
			if (newHeight == lastHeight) 
			{ break; } 
			lastHeight = newHeight; } } 
		
		
		catch (InterruptedException e) 
		{ e.printStackTrace(); }
	}
	
	public static void scrollToTopPage() {
		WebElement element =  driver.findElement(By.xpath("//span[@class='logoContainer']"));   
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element); 
		
	}
	
}
