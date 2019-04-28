package com.mmt.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmt.base.TestBase;
import com.mmt.pages.HomePage;
import com.mmt.pages.SearchPage;
import com.mmt.util.TestUtil;

public class SearchPageTest extends TestBase {

	HomePage homePage;
	SearchPage searchPage;
	TestUtil testUtil;

	@BeforeMethod
	public void setUp() {
		initilization();
		homePage = new HomePage();
		testUtil = new TestUtil();
		searchPage = new SearchPage();
	}

	@Test(priority = 1)
	public void getTotalDepartureFlights() {
		homePage.clickOnFlightsLink();
		homePage.clickOnRoundTrip();
		homePage.inputFromCity(TestUtil.fromCity);
		homePage.inputToCity(TestUtil.ToCity);
		homePage.selectdepartureDate();
		homePage.selectreturnDate();
		searchPage = homePage.clickOnSearchBtn();
		searchPage.getTotalDepartureFlights();

	}

	@Test(priority = 2)
	public void getTotalReturnFlights() {
		homePage.clickOnFlightsLink();
		homePage.clickOnRoundTrip();
		homePage.inputFromCity(TestUtil.fromCity);
		homePage.inputToCity(TestUtil.ToCity);
		homePage.selectdepartureDate();
		homePage.selectreturnDate();
		searchPage = homePage.clickOnSearchBtn();
		searchPage.getTotalReturnFlights();

	}

@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
