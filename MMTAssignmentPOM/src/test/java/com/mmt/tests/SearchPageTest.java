package com.mmt.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mmt.base.TestBase;
import com.mmt.pages.HomePage;
import com.mmt.pages.SearchPage;
import com.mmt.util.TestUtil;

public class SearchPageTest extends TestBase {
	
	HomePage homePage;
	SearchPage searchPage;
	TestUtil testUtil;
	
	@BeforeClass
	public void setUp() {
		initilization();
		homePage = new HomePage();
		testUtil = new TestUtil();
		searchPage= new SearchPage();
	}
	
	
	@Test(priority=1)
	public void getTotalDepartureFlights() {
		homePage.clickOnFlightsLink();
		homePage.clickOnRoundTrip();
		homePage.inputFromCity(TestUtil.fromCity);
		homePage.inputToCity(TestUtil.ToCity);
		homePage.selectdepartureDate();
		homePage.selectreturnDate();
		searchPage=homePage.clickOnSearchBtn();
		searchPage.getTotalDepartureFlights();
		searchPage.getTotalReturnFlights();
		
	}
	
	
	
	
//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}

}
