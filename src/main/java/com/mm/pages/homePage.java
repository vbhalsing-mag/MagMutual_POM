package com.mm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mm.utils.ExtentReporter;
import com.mm.utils.commonAction;
import com.relevantcodes.extentreports.LogStatus;

public class homePage extends commonAction{

	
	WebDriver driver;
	String findPOlicyPageTitleActalText ="Find Policy/Quote";
	
	String selectPOlicyTypePageTitleActalText ="Select Policy Type";
	
	@FindBy(id="CIS")
	WebElement cisTab;
	
	@FindBy(xpath="//li[@id='Policy']//a[@class='fNiv']")
	WebElement Policy_Tab_Home;
	
	
	@FindBy(xpath="//li[@id='PM_POLICY_MENU']//a[@class='fNiv isParent']")
	WebElement Policy_tab;
	
	@FindBy(xpath="//li[@id='PM_NEW_POL_QUOTE_MENU']//a[@class='subMenuLinks isParent']/span")
	WebElement Create_New;

	@FindBy(xpath="//li[@id='PM_CREATE_QUOTE']//a/span")
	WebElement Create_Quote;
	
	@FindBy(name="logoff")
	WebElement logoff;
	
	@FindBy(id="headerLogoTips")
	WebElement logo;
	
	@FindBy(id="topnav_Policy")
	WebElement Policy_link;
	
	@FindBy(name="entitySearch_lastOrOrgName")
	WebElement Last_Org_Name;

	@FindBy(id="CI_ENTITY_SELECT_SCH_SCH")
	WebElement Search_Quote;
	
	//@FindBy(xpath="//div[@id='CCLIENT_NAME' and contains(text()='Gerber, Jon,')]//parent::td//preceding-sibling::td//input[@type='checkbox']")
//	List<WebElement> Select_Entity_Checkbox;
	
	@FindBy(xpath ="//input[@name='chkCSELECTIND']")
	WebElement Select_Entity_Checkbox;
	
	
// @FindBy(xpath="//input[@class='BlueButton' and value = 'Select']")
	@FindBy(id="CI_ENT_SEL_LST_FORM_SEL")
	WebElement Select_Entity;
	
	//Select Policy Type window
	
	@FindBy(name="termEffectiveFromDate")
	WebElement Effe_Date;
	
	@FindBy(name="issueCompanyEntityId")
	WebElement Issue_Comp;

	@FindBy(name="issueStateCode")
	WebElement Issue_State_Code;
	
	@FindBy(id="PM_CREPOL_SRCH")
	WebElement Policy_Search;
	
	@FindBy(id="CPOLICYTYPEDESC")
	WebElement Policy_type;
	
	@FindBy(id="PM_CREPOL_DONE")
	WebElement createPolicyDoneBtn;
	
	@FindBy(id="pageTitleForpageHeader")
	WebElement findPolicyPageTitle;
	
  @FindBy(xpath = "//a[@class='topNavCurrentApp']")
	WebElement headerPolicyTab;
	

	public homePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Verify logo is preent on page.
	public void verifyLogoIsAvailable(){
		visibilityOfElement(logo, "DELPHI TECHNOLOGY");
	}
	
	//Navigate to CIS page
	public void navigateToCISPage()
	{
	click(driver,cisTab,"CIS tab");
		ExtentReporter.logger.log(LogStatus.INFO, "CIS Entity Search page opens");
	}
	
	
	//Navigate to Policy page
	public void navigateToPolicyPage()
	{
		waitForElementToLoad(driver, 10, Policy_link);
		clickButton(driver,Policy_link, "Policy link from top right corner");
		waitForElementToLoad(driver, 10, findPolicyPageTitle);
		verifyTextPresent(findPolicyPageTitle.getAttribute("innerHTML").trim(),findPOlicyPageTitleActalText,"Page Title");
		ExtentReporter.logger.log(LogStatus.INFO, "Search Policy Screen is opened");
	}
			
	
	//navigate to Policy page from policy link[Header]
	public void navigateToPolicyPageThroughPolicyTab()
	{
		click(driver,headerPolicyTab,"Policy tab on Header");
	}
		
	//Logout from application.
	public void logoutFromeOasis()
	{
		click(driver,logoff,"Logoff button");
  	ExtentReporter.logger.log(LogStatus.INFO, "User is logged out from application");
  }
  
  
	//Move to Policy tab and select Create New option from menu
	public void create_New() throws InterruptedException{		
		
		Actions action = new Actions(driver);
		action.moveToElement(Policy_tab).click().build().perform();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Create_New);
	//	clickButton(driver, Create_New, "Create New from Policy Menu ");
		
	}
	
	//Select Create Quote option from POlicy tab menu 
	public String create_Quote() throws InterruptedException{
	
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Create_Quote);
			
		//clickButton(driver, Create_Quote, "Create Quote from Policy Menu");
		ExtentReporter.logger.log(LogStatus.INFO, "Entity Select Search window opens");
		String parentWindow = switchToWindow(driver);
		return parentWindow;
	
}

	/*Entity Select Search window appears and 
	 then we enter Organization name and search
	 Then select the Organization name from populated list.*/
	
	public void search_Quote(String parentWindow)throws InterruptedException{
		
		waitForElementToLoad(driver, 10, Last_Org_Name);
		
		visibilityOfElement(Last_Org_Name, "Last Org Name on Entity Select Search window");
		
		enterTextIn(Last_Org_Name, "Test_Automation_V1", "Last Org Name");
		
		click(Search_Quote,"Search button");
			
		waitForElementToLoad(driver, 30, Select_Entity_Checkbox);
		
		ExtentReporter.logger.log(LogStatus.INFO, "List is populated of risk to select Organization with today's date");
		
		clickButton(driver, Select_Entity_Checkbox, "Select Entity Checkbox");
		
		ExtentReporter.logger.log(LogStatus.INFO, "Risk is selected");	
		click(Select_Entity_Checkbox, "Check box");
		
		click(Select_Entity, "Select button");
			
		ExtentReporter.logger.log(LogStatus.INFO, "Select Policy Type Window displays");	
		switchToParentWindowfromotherwindow(driver, parentWindow);
		
	}
	
	//Selecting Policy type by adding Effective date, Issue company,state and click done.
	public void selectPolicyType() throws InterruptedException{
		String Eff_Date="01012017";
		Thread.sleep(1000);
		switchToFrameUsingId(driver, "popupframe1");
		Thread.sleep(1000);
		//Verify Select Policy Type window appeared, enter data and click done
		verifyTextPresent(findPolicyPageTitle.getAttribute("innerHTML").trim(),selectPOlicyTypePageTitleActalText,"Page Title");
		enterTextIn(Effe_Date,Eff_Date, "Effective Date");
		selectDropdownByValue(Issue_Comp,"363536755","Issue Company");
		selectDropdownByValue(Issue_State_Code,"GA","Issue State");
		click(Policy_Search, "Search button for policy type");
		Thread.sleep(2000);
		ExtentReporter.logger.log(LogStatus.INFO, "Policy Type window will display below");
		click(Policy_type, "Policy Type");
		click(createPolicyDoneBtn, "Done button");
		ExtentReporter.logger.log(LogStatus.INFO, "Policy Folder window is opened");
		switchToParentWindowfromframe(driver);

	}
}
