package com.mmt.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	
}
