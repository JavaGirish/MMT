package com.mmt.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmt.base.TestBase;
import com.mmt.pages.BookingPage;
import com.mmt.pages.FilterPage;
import com.mmt.pages.HomePage;
import com.mmt.pages.SearchPage;
import com.mmt.util.TestUtil;

public class BookingPageTest extends TestBase {

	HomePage homePage;
	SearchPage searchPage;
	TestUtil testUtil;
	FilterPage filterPage;
	BookingPage bookingPage;

	public BookingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		homePage = new HomePage();
		testUtil = new TestUtil();
		searchPage = new SearchPage();
		filterPage = new FilterPage();
		bookingPage = new BookingPage();

	}

	@Test
	public void selectDepFlight() {
		homePage.clickOnFlightsLink();
		homePage.clickOnRoundTrip();
		homePage.inputFromCity(TestUtil.fromCity);
		homePage.inputToCity(TestUtil.ToCity);
		homePage.selectdepartureDate();
		homePage.selectreturnDate();
		searchPage = homePage.clickOnSearchBtn();
		int depAmount = bookingPage.selectDepFlight();
		int retAmount = bookingPage.selectReturnFlight();

		int finalDepAmount = bookingPage.getfinalDepPrice();
		int finalRetAmount = bookingPage.getfinalRetPrice();
		int totalAmount = bookingPage.calculateTotalAmount();
		Assert.assertEquals(depAmount, finalDepAmount);

		Assert.assertEquals(retAmount, finalRetAmount);
		Assert.assertEquals(totalAmount, (finalDepAmount + finalRetAmount));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
