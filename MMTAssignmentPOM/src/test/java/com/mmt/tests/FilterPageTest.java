package com.mmt.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmt.base.TestBase;
import com.mmt.pages.FilterPage;
import com.mmt.pages.HomePage;
import com.mmt.pages.SearchPage;
import com.mmt.util.TestUtil;

public class FilterPageTest extends TestBase {

	HomePage homePage;
	SearchPage searchPage;
	TestUtil testUtil;
	FilterPage filterPage;

	public FilterPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		homePage = new HomePage();
		testUtil = new TestUtil();
		searchPage = new SearchPage();
		filterPage = new FilterPage();

	}

	@Test
	public void selectNonStopFilter() {
		homePage.clickOnFlightsLink();
		homePage.clickOnRoundTrip();
		homePage.inputFromCity(TestUtil.fromCity);
		homePage.inputToCity(TestUtil.ToCity);
		homePage.selectdepartureDate();
		homePage.selectreturnDate();
		searchPage = homePage.clickOnSearchBtn();
		filterPage.selectNonStepFilter();
		searchPage.getTotalDepartureFlights();
		searchPage.getTotalReturnFlights();
		filterPage.clickResetBtn();
		filterPage.selectOneStopFilter();
		searchPage.getTotalDepartureFlights();
		searchPage.getTotalReturnFlights();

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
