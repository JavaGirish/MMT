package com.mmt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mmt.base.TestBase;
import com.mmt.util.TestUtil;

public class FilterPage extends TestBase{
	
	@FindBy(xpath= "//label[@for='filter_stop0']//span[@class='check']")
	WebElement nonStopCheckBox;
	
	
	@FindBy(xpath= "//label[@for='filter_stop1']//span[@class='check']")
	WebElement oneStopCheckBox;
	
	@FindBy(xpath="//div[@id='fli_filter__stops']//a[text()='Reset']")
	WebElement resetBtn;
	
	
	
	
	public FilterPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void selectNonStepFilter() {
		System.out.println("Selecting Non Stop Filter...");
		nonStopCheckBox.click();
		System.out.println("Non Stop Filter Selected...");
	}
	
	public void selectOneStopFilter() {
		System.out.println("Selecting Non Stop Filter...");
		oneStopCheckBox.click();
		System.out.println("One Stop Filter Selected...");
		
	}
	
	public void clickResetBtn() {
		TestUtil.wait(30, resetBtn);
		resetBtn.click();
	}

}
