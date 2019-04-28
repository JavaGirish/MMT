package com.mmt.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmt.base.TestBase;
import com.mmt.util.TestUtil;

public class SearchPage extends TestBase {
	
	@FindBy(xpath="//div[@class='fli-intl-lhs pull-left']")
	WebElement allResults;

	@FindBy(xpath = "//div[@class='splitVw-sctn pull-left']//div[@class='fli-list splitVw-listing']")
	WebElement depResults;

	@FindBy(xpath = "//div[@class='splitVw-sctn pull-right']//div[@class='fli-list splitVw-listing']")
	WebElement retResults;

	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	public void getTotalDepartureFlights()

	{
		TestUtil.wait(90, allResults);
		TestUtil.scrollToBottomofpage();
		ArrayList<WebElement> totalDep = (ArrayList<WebElement>) driver.findElements(
				By.xpath("//div[@class='splitVw-sctn pull-left']//div[@class='fli-list splitVw-listing']"));
		int totalDepflights = totalDep.size();
		System.out.println("Total Departure flights are: " + totalDepflights);
	}

	public void getTotalReturnFlights()

	{

		TestUtil.wait(90, allResults);
		TestUtil.scrollToBottomofpage();
		ArrayList<WebElement> totalRet = (ArrayList<WebElement>) driver.findElements(
				By.xpath("//div[@class='splitVw-sctn pull-right']//div[@class='fli-list splitVw-listing']"));
		int totalRetFlights = totalRet.size();
		System.out.println("Total Return flights are: " + totalRetFlights);
	}

}
