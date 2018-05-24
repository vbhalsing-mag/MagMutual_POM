package com.mm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mm.utils.commonAction;

public class Policy_Submission_Page extends commonAction {
	
	WebDriver driver;
	
	String indicationPhaseValue="INDICATION";
	String valueOfPolicyActionCopy = "javascript:copyQuote();";
	
	@FindBy(id="PM_COMMON_TABS_SAVEWIP")
	WebElement saveWIP;
	
	@FindBy(name="policyPhaseCode")
	WebElement policyPhase;
	
	@FindBy(xpath="//div[@id='globalDropdownActionItems']//select[@class='globalActionItemList']")
	WebElement policyAction;
	
	public Policy_Submission_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void copyFromActionDropDown(String policyNum) throws InterruptedException
	{
		selectDropdownByValue(policyAction, valueOfPolicyActionCopy, "Policy Action");
		Thread.sleep(3000);
	}
	
	public void changePhaseToIndication() throws InterruptedException
	{
		selectDropdownByValue(policyPhase, indicationPhaseValue, "Phase");
		Thread.sleep(3000);
	}
	
	public void saveWip() throws InterruptedException
	{
		clickButton(driver, saveWIP, "Save WIP");
		Thread.sleep(2000);
	}

}
