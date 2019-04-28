package com.mmt.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mmt.base.TestBase;
import com.mmt.pages.HomePage;
import com.mmt.pages.SearchPage;
import com.mmt.util.TestUtil;

public class HomePageTest extends TestBase {

	HomePage homePage;
	TestUtil testUtil;
	SearchPage searchPage;

	public HomePageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeClass
	public void setUp() {
		initilization();
		homePage = new HomePage();
		testUtil = new TestUtil();
	}

	@Test(priority = 0)
	public void closeAdbox() {
		homePage.closeAdWindow();

	}

	@Test(priority = 1)
	public void clickFlightsLink() {
		homePage.clickOnFlightsLink();
	}

	@Test(priority = 2)
	public void clickReturnTrip() {
		homePage.clickOnRoundTrip();
	}

	@Test(priority = 3)
	public void selectFromCity() {
		homePage.inputFromCity(TestUtil.fromCity);
	}

	@Test(priority = 4)
	public void selectToCity() {
		homePage.inputToCity(TestUtil.ToCity);

	}

	@Test(priority = 5)
	public void selectDepDate() {
		homePage.selectdepartureDate();

	}

	@Test(priority = 6)
	public void selectReturnDate() {
		homePage.selectreturnDate();
	}

	@Test(priority = 7)
	public void clickOnSearchBtn() {
		homePage.clickOnSearchBtn();
		driver.manage().deleteAllCookies();

	}

	// @AfterClass
	// public void tearDown() {
	// driver.quit();
	// }

}
