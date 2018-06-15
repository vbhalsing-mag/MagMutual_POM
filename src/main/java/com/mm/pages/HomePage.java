package com.mm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mm.dto.HomePageDTO;
import com.mm.utils.CommonAction;
import com.mm.utils.ExtentReporter;
import com.mm.utils.CommonAction;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends CommonAction{

	
	WebDriver driver;
	HomePageDTO homepageDTO;
	String findPOlicyPageTitleActualText ="Find Policy/Quote";
	String selectPOlicyTypePageTitleActualText ="Select Policy Type";
	
	
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
	
	// Constructor to initialize driver, page elements and DTO PageObject for HomePage
	public HomePage(WebDriver driver) throws IllegalArgumentException, IllegalAccessException, SecurityException
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		homepageDTO = new HomePageDTO();
	}
	
	//Verify logo is present on page.
	public void verifyLogoIsAvailable(){
		visibilityOfElement(driver,logo, "DELPHI TECHNOLOGY");
	}
	
	//Verify user Navigated to Policy page when clicked on Policy tab present on Header.
	public RateApolicyPage headerPolicyTab() throws Exception
	{
		Thread.sleep(5000);
		clickButton(driver, headerPolicyTab, "Policy (from header");
		return new RateApolicyPage(driver);
	}


	// Navigate to CIS page.
	public CISPage navigateToCISPage() throws Exception {
		click(driver, cisTab, "CIS tab");
		return new CISPage(driver);
	}

	// Navigate to policy page from Policy tab.
	public HomePage navigateToPolicyPage() throws Exception {
		clickButton(driver, headerPolicyTab, "Header Policy Tab");
		ExtentReporter.logger.log(LogStatus.INFO, "Search Policy Screen is opened");
		click(driver, Policy_tab, "Policy tab");
		return new HomePage(driver);
	}
		
	
	// Navigate to policy page using Policy tab from EndorsePolicyPage.
		public EndorsePolicyPage navigateToPolicyPageFromEndorsePolicyPage() throws Exception {
			navigateToPolicyPage();
			return new EndorsePolicyPage(driver);
		}
		
	// Navigate to policy page using Policy tab from rateApolicyPage.
		public RateApolicyPage navigateToPolicyPageFromrateApolicyPage () throws Exception {
			navigateToPolicyPage();
			return new RateApolicyPage(driver);
		}
		
	// Navigate to policy page using Policy tab from rateApolicyPage.
		public RateApolicyPage navigateToPolicyPageFromPolicyBinderPage() throws Exception {
			navigateToPolicyPage();
			return new RateApolicyPage(driver);
		}
		
	//Navigate to Policy page from policy link[Header]
	public void navigateToPolicyPageThroughPolicyTab()
	{
		click(driver,headerPolicyTab,"Policy tab on Header");
	}
		
	//Logout from application.
	public void logoutFromeOasis()
	{
		ExtentReporter.logger.log(LogStatus.INFO, "User is logged out from application");
		click(driver,logoff,"Logoff button");
  }
  
  
	//Move to Policy tab and select Create New option from menu
	public HomePage create_New() throws InterruptedException, IllegalArgumentException, IllegalAccessException, SecurityException{		
		waitForElementToLoad(driver, 20, Policy_tab);
		Actions action = new Actions(driver);
		action.moveToElement(Policy_tab).click().build().perform();
		Thread.sleep(2000);
		clickButton(driver, Create_New, "Create New from Policy Menu ");
		return new HomePage(driver);
	}
	
	/*Entity Select Search window appears and then we enter Organization name and search
	 Then select the Organization name from populated list.*/
	public HomePage search_Quote(String parentWindow)throws InterruptedException, IllegalArgumentException, IllegalAccessException, SecurityException{
		
		waitForElementToLoad(driver, 30, Last_Org_Name);
		visibilityOfElement(driver, Last_Org_Name, "Last Org Name on Entity Select Search window");
		enterTextIn(driver, Last_Org_Name, homepageDTO.lastOrgName, "Last Org Name");
		ExtentReporter.logger.log(LogStatus.INFO, "List is populated of risk to select Organization with today's date");
		click(driver, Search_Quote,"Search button");
		waitForElementToLoad(driver, 60, Select_Entity_Checkbox);
		ExtentReporter.logger.log(LogStatus.INFO, "Risk is selected");	
		clickButton(driver, Select_Entity_Checkbox, "Select Entity Checkbox");
		ExtentReporter.logger.log(LogStatus.INFO, "Select Policy Type Window displays");	
		click(driver, Select_Entity, "Select button");
		switchToParentWindowfromotherwindow(driver, parentWindow);
		
		return new HomePage(driver);
		
	}
	
	//Selecting Policy type by adding Effective date, Issue company,state and click done.
	public PolicySubmissionPage selectPolicyType() throws InterruptedException, IllegalArgumentException, IllegalAccessException, SecurityException{
		String Eff_Date="01012017";
		Thread.sleep(1000);
		switchToFrameUsingId(driver, "popupframe1");
		Thread.sleep(1000);
		//Verify Select Policy Type window appeared, enter data and click done
		verifyTextPresent(findPolicyPageTitle.getAttribute("innerHTML").trim(),selectPOlicyTypePageTitleActualText,"Page Title");
		enterTextIn(driver, Effe_Date,homepageDTO.effectiveFromDate, "Effective Date");
		selectDropdownByValue(driver,Issue_Comp,homepageDTO.issueCompany,"Issue Company");
		selectDropdownByValue(driver,Issue_State_Code,homepageDTO.issueState,"Issue State");
		ExtentReporter.logger.log(LogStatus.INFO, "Policy Type window will display below");
		click(driver,Policy_Search, "Search button for policy type");
		Thread.sleep(2000);
		click(driver,Policy_type, "Policy Type");
		ExtentReporter.logger.log(LogStatus.INFO, "Policy Folder window is opened");
		click(driver,createPolicyDoneBtn, "Done button");
		switchToParentWindowfromframe(driver);
		return new PolicySubmissionPage(driver);

	}

	//Select Create Quote option from POlicy tab menu 
	public String create_Quote() throws InterruptedException {
		Thread.sleep(2000);
		ExtentReporter.logger.log(LogStatus.INFO, "Entity Select Search window opens");
		clickButton(driver, Create_Quote, "Create Quote from Policy Menu");
		String parentWindow = switchToWindow(driver);
		return parentWindow;
	}
}
