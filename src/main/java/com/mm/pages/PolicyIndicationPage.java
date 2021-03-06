package com.mm.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mm.utils.ExtentReporter;
import com.mm.dto.PolicyIndicationPageDTO;
import com.mm.utils.CommonAction;
import com.relevantcodes.extentreports.LogStatus;

public class PolicyIndicationPage extends CommonAction {

	WebDriver driver;

	PolicyIndicationPageDTO hospitalIndicationDTO;
	String producerAgentEntryPageTitle = "Producer Agent Entry";
	String maintainUnderwritingTeamPageTitle = "Maintain Underwriting Team";
	String addUnderwriterPageTitle = "Add Underwriter";
	String limitSharingPageTitle = "Limit Sharing";
	String ExcelPath = System.getProperty("user.dir") + "\\src\\main\\resources\\QA_Form_Data.xlsx";

	@FindBy(id = "PM_COMMON_TABS_SAVEWIP")
	WebElement Save_WIP;

	@FindBy(id = "PM_QT_UNDW_PUP")
	WebElement Underwriter;

	@FindBy(id = "PM_UNDWRI_ADD")
	WebElement Add_Underwriter;

	@FindBy(name = "entityId")
	WebElement underWritingTeamMemberName;

	@FindBy(id = "PM_ADD_UNDWRTR_OK")
	WebElement Add_Underwriter_Ok;

	@FindBy(name = "uwTypeCode")
	WebElement UnderwriterType;

	@FindBy(name = "entityId")
	WebElement Underwriter_name;

	@FindBy(id = "PM_UNDWRI_SAVE")
	WebElement Save_Underwritter;

	@FindBy(id = "PM_UNDWRI_BACK")
	WebElement Close_Underwritter;
	
	@FindBy(id="PM_CPT_TRAN_OK")
	WebElement OK_Capt_Trans_Details;

	@FindBy(id = "PM_QT_LIMIT_SHARING")
	WebElement Limit_Sharing;

	@FindBy(id = "PM_SHARED_GROUP_ADD")
	WebElement Add_Shared_Group;

	@FindBy(name = "shareGroupDesc")
	WebElement Desc_Shared_Group;

	@FindBy(id = "PM_SHARED_DETAIL_ADD")
	WebElement Add_Shared_Group_Details;

	@FindBy(id = "PM_QT_POLICY_FOLDER_AG")
	WebElement Policy_Action;

	@FindBy(id = "PM_AGNT_ADD")
	WebElement Add_Agent;

	@FindBy(name = "producerAgentLicId")
	WebElement Producer;

	@FindBy(id = "PM_AGNT_SAVE")
	WebElement Save_Agent;

	@FindBy(id = "PM_AGNT_CLOSE")
	WebElement Close_Agent;

	@FindBy(xpath = "//a[@id='PM_PT_VIEWRISK']//span")
	WebElement Risk_tab;

	@FindBy(xpath = "//a[@id='PM_PT_VIEWPOL']//span")
	WebElement Policy_tab;

	@FindBy(xpath = "//td//div[@id='CRISKTYPECODELOVLABEL']")
	WebElement Risk_Type;

	@FindBy(name = "riskCounty")
	WebElement Risk_Country;

	@FindBy(name = "riskClass")
	WebElement Risk_Speciality;

	@FindBy(xpath = "//a[@id='PM_PT_VIEWCVG']//span")
	WebElement Coverage_tab;

	@FindBy(id = "PM_QT_COVG_ADD")
	WebElement Add_Coverage;

	@FindBy(xpath = "//div[text()='Excess Liab-Out']//parent::td//preceding-sibling:://td[@type='checkbox']")
	WebElement Checkbox;

	@FindBy(name = "annualBaseRate_DISP_ONLY")
	WebElement Premium;

	@FindBy(name = "retroDate")
	WebElement Retro_Date;

	@FindBy(id = "PM_SEL_COVG_DONE")
	WebElement Select_coverage;

	@FindBy(xpath = "//a[@id='PM_PT_VIEWCLASS']//span")
	WebElement Coverage_Class_tab;

	@FindBy(id = "PM_QT_COVGCLAZ_ADD")
	WebElement Add_CoverageClass;

	@FindBy(name = "exposureUnit")
	WebElement ExposureUnit;

	@FindBy(id = "PM_SEL_CLASS_DONE")
	WebElement Select_CoverageClass;

	@FindBy(id = "PM_QT_MANU_PUP")
	WebElement Optional_Forms;

	@FindBy(id = "PM_MANU_ADD")
	WebElement Add_Manuscript;

	@FindBy(id = "PM_SEL_MANU_DONE")
	WebElement Done_Manuscript;

	@FindBy(id = "PM_MANU_SAVE")
	WebElement Save_Manuscript;

	@FindBy(id = "PM_MANU_CLOSE")
	WebElement Close_Manuscript;

	@FindBy(xpath = "//table[@id='selectCoverageGrid']//tr//input[@name='chkCSELECT_IND']")
	List<WebElement> selectCoverageChkBox;

	@FindBy(xpath = "//table[@id='selectCoverageGrid']//tr//div[@id='CPRODUCTCOVERAGEDESC']")
	List<WebElement> selectCoveragevalues;

	@FindBy(xpath = "//table[@id='selectCoverageGrid']//tr//div[@id='CPOLICYFORMCODEDESCRIPTION']")
	List<WebElement> selectPolicyForm;

	@FindBy(xpath = "//table[@id='selectCoverageClassGrid']//tr//input[@name='chkCSELECT_IND']")
	List<WebElement> selectCoverageClassChkBox;

	@FindBy(xpath = "//table[@id='selectCoverageClassGrid']//tr//div[@id='CCOVERAGECLASSLONGDESCRIPTION']")
	List<WebElement> selectCoverageClass;

	@FindBy(xpath = "//table[@id='selectSharedDetailGrid']//tr//input[@name='chkCSELECT_IND']")
	List<WebElement> selectSharedGroupDetailChkBox;

	@FindBy(xpath = "//table[@id='selectSharedDetailGrid']//tr//input[@name='chkCSHAREDTLOWNERB']")
	List<WebElement> selectSharedGroupOwnerChkBox;

	@FindBy(xpath = "//table[@id='selectSharedDetailGrid']//tr//div[@id='CSHAREDTLCOVERAGESHORTDESC']")
	List<WebElement> selectCoverage;

	@FindBy(id = "CSHAREDTLCOVERAGESHORTDESC")
	WebElement sharedGroupDetailsCoverage;

	@FindBy(id = "PM_SEL_SHARED_DTL_DONE")
	WebElement Done_Shared_Details;

	@FindBy(xpath = "//div[@id='globalDropdownActionItems']//select[@class='globalActionItemList']")
	WebElement policyAction;

	@FindBy(id = "pageTitleForpageHeaderForPolicyFolder")
	WebElement pageHeaderForPolicyFolder;

	@FindBy(xpath = "//table[@id='formFieldsTableForHeaderFieldsSecond']//span[@id='polPhaseCodeROSPAN']")
	WebElement policyPhaseBinder;

	@FindBy(xpath = "//select[@name='paymentPlanId']")
	WebElement paymentPlan;

	@FindBy(xpath = "//div[@class='horizontalButtonCollection']//input[@id='PM_BILLNG_SAVE']")
	WebElement billingSetupSaveBtn;

	@FindBy(xpath = "//a[@id='PM_PT_VIEWCVG']//span[@class='tabWithNoDropDownImage']")
	WebElement coverageTab;

	@FindBy(xpath = "//table[@id='coverageListGrid']//tbody//td//div[@id='CPRODUCTCOVERAGEDESC']")
	List<WebElement> coverageList;

	@FindBy(xpath = "//input[@id='PM_QT_MANU_PUP']")
	WebElement optionalFormBtn;

	@FindBy(xpath = "//table[@id='maintainManuscriptListGrid']")
	WebElement manuscriptList;

	@FindBy(id = "PM_MANU_DELETE")
	WebElement manuscriptPageDeleteBtn;

	@FindBy(id = "PM_MANU_ADD")
	WebElement manuscriptPageAddBtn;

	@FindBy(xpath = "//table[@id='selectManuscriptGrid']//tr//div[@id='CSHORTDESCRIPTION']")
	List<WebElement> manuscriptAddListformName;

	@FindBy(xpath = "//table[@id='selectManuscriptGrid']//tr//input[@name='chkCSELECT_IND']")
	List<WebElement> manuscriptAddListformNameChkBox;

	@FindBy(id = "PM_SEL_MANU_DONE")
	WebElement manuscriptAddListDoneBtn;

	@FindBy(id = "PM_MANU_SAVE")
	WebElement manuscriptPageSaveBtn;

	@FindBy(id = "PM_MANU_CLOSE")
	WebElement manuscriptPageCloseBtn;

	@FindBy(xpath = "//iframe[contains(@id='popupframe')]")
	List<WebElement> allIframes;

	@FindBy(id = "PM_COMMON_TABS_RATE")
	WebElement rateBtn;

	@FindBy(id = "PM_COMMON_TABS_RATE")
	WebElement closeBtnOnViewPremiumPopup;

	@FindBy(name = "workflowExit_Ok")
	WebElement okBtnExitSaveAsPopup;

	@FindBy(id = "PM_COMMON_TABS_PREVIEW")
	WebElement previewBtn;

	@FindBy(id = "PM_LIMIT_SHARING_SAVE")
	WebElement Save_Limit_Sharing;

	@FindBy(id = "PM_LIMIT_SHARING_CLOSE")
	WebElement Close_Limit_Sharing;

	// Constructor to initialize driver, page elements and DTO PageObject for
	// PolicyIndicationPage
	public PolicyIndicationPage(WebDriver driver)
			throws IllegalArgumentException, IllegalAccessException, SecurityException {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		hospitalIndicationDTO = new PolicyIndicationPageDTO();
	}

	// Select Underwriter button from Policy tab and move to pop up window frame
	public List<WebElement> open_Underwriter() throws InterruptedException {

		ExtentReporter.logger.log(LogStatus.INFO, "Underwriter window displays");
		waitForElementToLoad(driver, 30, Underwriter);
		clickButton(driver, Underwriter, "Underwriter button");
		Thread.sleep(4000);

		List<WebElement> firstFrame = driver.findElements(By.id("popupframe1"));
		driver.switchTo().frame(firstFrame.get(0));
		return firstFrame;
	}

	// Select under writer button from policy page, Add Underwriters info to
	// create underwriters and Save underwriter
	public PolicyIndicationPage add_Underwriter(List<WebElement> firstFrame) throws Exception {

		getPageTitle(driver, maintainUnderwritingTeamPageTitle);

		// Get count of underwriterNames from excel file
		for (int underwritercount = 0; underwritercount < hospitalIndicationDTO.underwriterName.size()/3; underwritercount++) {

			ExtentReporter.logger.log(LogStatus.INFO, "Add Underwriter window displays");
			waitForElementToLoad(driver, 30, Add_Underwriter);

			// Open Add underwriter tab from the first pop up frame and move to
			// second pop up frame using list
			click(driver, Add_Underwriter, "Add Underwriter");
			Thread.sleep(3000);
			List<WebElement> secondFrame = driver.findElements(By.id("popupframe1"));
			driver.switchTo().frame(secondFrame.get(0));
			Thread.sleep(1000);
			getPageTitle(driver, addUnderwriterPageTitle);

			// Select underwriter name from DDL
			ExtentReporter.logger.log(LogStatus.INFO, "Underwriter is added to list");
			selectDropdownByVisibleText(driver, underWritingTeamMemberName,
					hospitalIndicationDTO.underwriterName.get(underwritercount), "Underwriter name");
			// Verify the value is selected and it is correct
			// verifyValueFromField(driver, underWritingTeamMemberName,
			// hospitalIndicationDTO.underwriterName.get(underwritercount),"innerHTML");
			Thread.sleep(1000);

			// Switch back to first frame from second frame
			click(driver, Add_Underwriter_Ok, "OK button");
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.switchTo().frame(firstFrame.get(0));
			Thread.sleep(2000);

			// select underwriter info for the selected underwriter using DDL
			// and save
			ExtentReporter.logger.log(LogStatus.INFO,
					"Underwriting Team Member List displays the updated type for Entity");
			selectDropdownByVisibleText(driver, UnderwriterType, hospitalIndicationDTO.teamName.get(underwritercount),
					"Type");
			ExtentReporter.logger.log(LogStatus.INFO, "Underwriter name is displayed");
			selectDropdownByVisibleText(driver, Underwriter_name,
					hospitalIndicationDTO.teamMembername.get(underwritercount), "Underwriter team member name");
			// Verify the Under writer name value is selected and it is correct
			// verifyValueFromField(driver, Underwriter_name,
			// hospitalIndicationDTO.teamMembername.get(underwritercount),"value");
			Thread.sleep(1000);
			click(driver, Save_Underwritter, "Save button");
			
			//Below code for QA envt only
			
			List<WebElement> secondFrame2 = driver.findElements(By.id("popupframe1"));
			driver.switchTo().frame(secondFrame2.get(0));
			Thread.sleep(2000);
			clickButton(driver, OK_Capt_Trans_Details, "Ok"); 
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame(firstFrame.get(0));
		}
		return new PolicyIndicationPage(driver);
	}

	// Close 'Maintain Underwriting team' pop up, move control to parent window
	// and Save WIP
	public PolicyIndicationPage closeUnderwriter() throws Exception {

		Thread.sleep(2000);
		ExtentReporter.logger.log(LogStatus.INFO, "Underwriter Window closes");
		click(driver, Close_Underwritter, "Close button");
		Thread.sleep(2000);
		switchToParentWindowfromframe(driver);
		Thread.sleep(3000);
		ExtentReporter.logger.log(LogStatus.INFO, "WIP is saved");
		click(driver, Save_WIP, "Save WIP button");
		return new PolicyIndicationPage(driver);
	}

	// Select Agent from Policy Action drop down and Add Agent info in pop up,
	// save Agent and move to parent window
	public PolicyIndicationPage addAgent()
			throws InterruptedException, IllegalArgumentException, IllegalAccessException, SecurityException {

		Thread.sleep(3000);
		// Select Agent from Policy Action drop down list
		ExtentReporter.logger.log(LogStatus.INFO, "	Agent window is open");
		selectDropdownByVisibleText(driver, Policy_Action, hospitalIndicationDTO.policyAction, "Policy Action");
		Thread.sleep(3000);
		switchToFrameUsingId(driver, "popupframe1");
		Thread.sleep(2000);
		getPageTitle(driver, producerAgentEntryPageTitle);

		// Add Agent information and save agent
		ExtentReporter.logger.log(LogStatus.INFO, "Producer Agent Entry window opens");
		click(driver, Add_Agent, "Add button");
		Thread.sleep(3000);
		ExtentReporter.logger.log(LogStatus.INFO, "Agent is selected");
		//Select producer value using DDL // Add in excel sheet
		selectDropdownByVisibleText(driver,Producer,hospitalIndicationDTO.producer, "Producer");
		//Verify producer value is selected and it is correct
	//	verifyValueFromField(driver,Producer, hospitalIndicationDTO.producer,"value");
		click(driver,Save_Agent, "Save button");
		Thread.sleep(2000);

		// Close agent and switch to parent window
		ExtentReporter.logger.log(LogStatus.INFO, "Agent is saved to policy and window is closed");
		click(driver, Close_Agent, "Close button");
		switchToParentWindowfromframe(driver);
		return new PolicyIndicationPage(driver);

	}

	// Select Risk tab, select Risk type and fill the Risk Information
	public PolicyIndicationPage addRiskInformation() throws Exception {

		Thread.sleep(3000);
		ExtentReporter.logger.log(LogStatus.INFO, "Risk tab displays");
		click(driver, Risk_tab, "Risk tab");
		Thread.sleep(3000);
		ExtentReporter.logger.log(LogStatus.INFO, "Hospital Risk is highlighted");
		click(driver, Risk_Type, "Risk Type");
		Thread.sleep(3000);
		ExtentReporter.logger.log(LogStatus.INFO, "Risk information is displayed and selected");
		// Select Risk country and Risk specialty using DDL
		selectDropdownByVisibleText(driver, Risk_Country, hospitalIndicationDTO.riskCountry, "Risk Country");
		selectDropdownByVisibleText(driver, Risk_Speciality, hospitalIndicationDTO.riskSpeciality, "Risk speciality");
		return new PolicyIndicationPage(driver);
	}

	// Select Coverage tab, click on Add button and switch to pop up window
	public PolicyIndicationPage addCoverage() throws Exception {

		Thread.sleep(2000);
		ExtentReporter.logger.log(LogStatus.INFO, "Coverage tab displays with the primary defaulting in the dropdown");
		click(driver, Coverage_tab, "Coverage tab");
		Thread.sleep(3000);
		ExtentReporter.logger.log(LogStatus.INFO, "Select Coverage window displays");
		click(driver, Add_Coverage, "Add button");
		Thread.sleep(3000);
		switchToFrameUsingId(driver, "popupframe1");
		return new PolicyIndicationPage(driver);
	}

	// Select Coverage from the pop up List appearing after 'Add' button on
	// coverage tab
	public PolicyIndicationPage selectCoverageFromPopupListAddDatePremium()
			throws InterruptedException, IllegalArgumentException, IllegalAccessException, SecurityException {

		// Get the count of coverage check boxes
		Thread.sleep(2000);
		for (int i = 0; i < selectCoverageChkBox.size(); i++) {
			// Select coverage check box if Coverage and Policy Form combination
			// is as expected
			if (selectCoveragevalues.get(i).getAttribute("innerHTML").equals(hospitalIndicationDTO.coverageFromPopup)
					&& selectPolicyForm.get(i).getAttribute("innerHTML").equals(hospitalIndicationDTO.policyForms)) {
				ExtentReporter.logger.log(LogStatus.INFO,
						hospitalIndicationDTO.coverageFromPopup + " Coverage is selected from popup list");
				clickButton(driver, selectCoverageChkBox.get(i), "Coverage check box");
				Assert.assertTrue(selectCoverageChkBox.get(i).isSelected(),
						selectCoverageChkBox.get(i) + "is NOt selected");

				// select retroDate from excel sheet
				for (int retroDateCount = 0; retroDateCount < hospitalIndicationDTO.retroDate
						.size(); retroDateCount++) {
					try {
						// Add Retro date and premium amount for the selected
						// coverage
						if (Retro_Date.isDisplayed()) {
							clearTextBox(driver, Premium, "Premium Amount");
							enterDataIn(driver, Premium, hospitalIndicationDTO.premiumAmount.get(retroDateCount),
									"Premium text box");
							// Verify that premium amount is entered and it is
							// correct
							verifyValueFromField(driver, Premium,
									hospitalIndicationDTO.premiumAmount.get(retroDateCount), "value", "Premium Amount");
							Thread.sleep(1000);
							enterDataIn(driver, Retro_Date, hospitalIndicationDTO.retroDate.get(retroDateCount),
									"Retro Date");
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;

				// Select coverage check box if Coverage is as expected
			} else if (selectCoveragevalues.get(i).getAttribute("innerHTML")
					.equals(hospitalIndicationDTO.coverageFromPopup)) {
				ExtentReporter.logger.log(LogStatus.INFO,
						hospitalIndicationDTO.coverageFromPopup + " Coverage is selected from popup list");
				clickButton(driver, selectCoverageChkBox.get(i), "Coverage check box");
				// Assert.assertTrue(selectCoverageChkBox.get(i).isSelected(),selectCoverageChkBox.get(i)+"is
				// NOt selected");

				// select retroDate from excel sheet
				for (int retroDateCount = 0; retroDateCount < hospitalIndicationDTO.retroDate
						.size(); retroDateCount++) {
					try {
						// Add Retro date and premium amount for the selected
						// coverage
						if (Retro_Date.isDisplayed()) {
							clearTextBox(driver, Premium, "Premium Amount");
							enterDataIn(driver, Premium, hospitalIndicationDTO.premiumAmount.get(retroDateCount),
									"Premium text box");
							// Verify that premium amount is entered and it is
							// correct
							Thread.sleep(1000);
							enterDataIn(driver, Retro_Date, hospitalIndicationDTO.retroDate.get(retroDateCount),
									"Retro Date");
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;
			}
		}
		return new PolicyIndicationPage(driver);
	}

	// Close Select Coverage pop up
	public PolicyIndicationPage closeAddCoveragetab() throws Exception {

		ExtentReporter.logger.log(LogStatus.INFO,
				"Information has been entered and coverage has been added to primary risk");
		click(driver, Select_coverage, "Select button for coverage");
		switchToParentWindowfromframe(driver);
		return new PolicyIndicationPage(driver);
	}

	// Select and return the policy# from source of a frame to be utilized for
	// switching to frame
	public String policyNo() throws InterruptedException {
		Thread.sleep(2000);
		String profileNoLable = pageHeaderForPolicyFolder.getAttribute("innerHTML");
		String[] portfolioNo = profileNoLable.split(" ", 3);
		return portfolioNo[2];
	}

	// Select Coverage from the Grid on Coverage tab and add Retro Date &
	// Premium
	public PolicyIndicationPage selectCoverageFromGridList() throws Exception {

		// Get coverage count from the excel sheet column
		for (int coverageCount = 0; coverageCount < hospitalIndicationDTO.coverage.size(); coverageCount++) {
			Thread.sleep(5000);
			// Get coverage count from the grid list on coverage page
			for (int i = 0; i < coverageList.size(); i++) {
				// compare if the coverage selected from excel sheet is same as
				// coverage from grid on coverage page
				if (coverageList.get(i).getAttribute("innerHTML").trim()
						.equalsIgnoreCase(hospitalIndicationDTO.coverage.get(coverageCount))) {
					ExtentReporter.logger.log(LogStatus.INFO,
							hospitalIndicationDTO.coverage.get(coverageCount) + " Coverage is selected from Grid");
					// select the coverage from grid if it matches
					selectValue(driver, coverageList.get(i), hospitalIndicationDTO.coverage.get(coverageCount));
					// Assert.assertTrue(coverageList.get(i).isSelected(),coverageList.get(i)+"is
					// NOt selected");

					// If retro date field is displayed,add Retro Date and
					// Premium Amount for selected coverage
					if (Retro_Date.isDisplayed()) {

						clearTextBox(driver, Premium, "Premium Amount");
						enterDataIn(driver, Premium, hospitalIndicationDTO.premiumAmount.get(coverageCount),
								"Premium text box");
						Thread.sleep(1000);
						enterDataIn(driver, Retro_Date, hospitalIndicationDTO.retroDate.get(coverageCount),
								"Retro Date");

					} // else add only premium for selected coverage
					else if (Premium.isDisplayed()) {

						clearTextBox(driver, Premium, "Premium Amount");
						enterDataIn(driver, Premium, hospitalIndicationDTO.premiumAmount.get(coverageCount),
								"Premium text box");
					}
					break;
				}
			}
		}

		// Select coverage from Grid List and add only Retro Date
		// Get coverage count from excel sheet another column in excel sheet
		for (int coverageTitleCount = 0; coverageTitleCount < hospitalIndicationDTO.coverageTitle
				.size(); coverageTitleCount++) {
			String ProfLiabCoverage="Prof Liab-Out";
			Thread.sleep(4000);
			// Get coverage count from the grid on coverage page
			for (int i = 0; i < coverageList.size(); i++) {
				// Compare if the coverage from excel sheet column is same as
				// coverage from grid
				if (coverageList.get(i).getAttribute("innerHTML").trim()
						.equalsIgnoreCase(hospitalIndicationDTO.coverageTitle.get(coverageTitleCount))) {
					ExtentReporter.logger.log(LogStatus.INFO,
							hospitalIndicationDTO.coverageTitle.get(coverageTitleCount)
									+ " Coverage is selected from Grid");
					// select the coverage if it matches
					selectValue(driver, coverageList.get(i),
							hospitalIndicationDTO.coverageTitle.get(coverageTitleCount));
					// Assert.assertTrue(coverageList.get(i).isSelected(),coverageList.get(i)+"is
					// NOt selected");
					// TODO - change hard coded value in if statement
					// Add Retro Date for selected coverage except "Prof
					// Liab-Out".
					if (hospitalIndicationDTO.coverageTitle.get(coverageTitleCount) != ProfLiabCoverage) {
						try {
							Thread.sleep(1000);
							if (Retro_Date.isDisplayed()) {
								Thread.sleep(1000);
								enterDataIn(driver, Retro_Date,
										hospitalIndicationDTO.retroDateValue.get(coverageTitleCount), "Retro Date");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					break;
				}
			}
		}
		return new PolicyIndicationPage(driver);
	}

	// Select Coverage Class tab, Add Coverage Class,save and move to coverage
	// tab
	public void addCoverageClass() throws InterruptedException {

		ExtentReporter.logger.log(LogStatus.INFO, "Coverage Class Tab Displays");
		waitForElementToLoad(driver, 10, Coverage_Class_tab);
		clickButton(driver, Coverage_Class_tab, "Coverage class tab");
		Thread.sleep(3000);

		// Click 'Add' button for coverage class and move to pop up window
		ExtentReporter.logger.log(LogStatus.INFO, "Select Coverage class window displays");
		clickButton(driver, Add_CoverageClass, "Add button for coverage class");
		Thread.sleep(4000);
		switchToFrameUsingId(driver, "popupframe1");
		Thread.sleep(4000);
		// Search the coverage class from pop up window and if it matches select
		// check box
		for (int i = 0; i < selectCoverageClassChkBox.size(); i++) {
			if (selectCoverageClass.get(i).getAttribute("innerHTML").equals(hospitalIndicationDTO.coverageClass)) {
				clickButton(driver, selectCoverageClassChkBox.get(i), "Coverage Class selection");
				break;
			}
		}
		Thread.sleep(2000);
		enterDataIn(driver, ExposureUnit, hospitalIndicationDTO.exposureUnit, "Exposure Unit");
		// Close coverage class tab and move to coverage tab
		ExtentReporter.logger.log(LogStatus.INFO, "Coverage class is saved.");
		click(driver, Select_CoverageClass, "Select button for Coverage class");
		switchToParentWindowfromframe(driver);
		Thread.sleep(2000);
		click(driver, Coverage_tab, "Coverage tab");
	}

	// Select 'Coverage' tab and add Manuscript from optional forms and Save
	public PolicyIndicationPage coverageUpdates(String PolicyNo) throws Exception {
		Thread.sleep(4000);
		// Get the coverage count from excel sheet column
		for (int coverageNameCount = 0; coverageNameCount <hospitalIndicationDTO.coverageName.size()/2; coverageNameCount++) // divide by 2 for indication
		{
			// Get Coverage count from list on coverage page
			for (int i = 0; i < coverageList.size(); i++) {
				// compare coverage from coverage list with coverage from excel
				// sheet
				if (coverageList.get(i).getAttribute("innerHTML")
						.equals(hospitalIndicationDTO.coverageName.get(coverageNameCount))) {
					// Select the coverage from the list if it matches
					clickButton(driver, coverageList.get(i), hospitalIndicationDTO.coverageName.get(coverageNameCount));
					ExtentReporter.logger.log(LogStatus.INFO,
							hospitalIndicationDTO.coverageName.get(coverageNameCount) + "Coverage is highlighted");
					break;
				}
			}
			// Click on 'Optional forms', navigate to pop up window and click
			// 'Add' button
			Thread.sleep(2000);
			ExtentReporter.logger.log(LogStatus.INFO, "Manuscript Information Window displays");
			clickButton(driver, optionalFormBtn, "Optional Form");
			Thread.sleep(2000);
			switchToFrameUsingElement(driver,
					driver.findElement(By.xpath("//iframe[contains(@src,'policyNo=" + PolicyNo + "')]")));
			ExtentReporter.logger.log(LogStatus.INFO, "Add Manuscript window displays");
			clickButton(driver, manuscriptPageAddBtn, "Manu script Add");
			Thread.sleep(1000);
			switchToFrameUsingElement(driver,
					driver.findElement(By.xpath("//iframe[contains(@src,'policyNo=" + PolicyNo + "')]")));

			// Search manuscript Form from pop up window and select check box
			Thread.sleep(5000);
			for (int i = 0; i < manuscriptAddListformName.size(); i++) {
				if (manuscriptAddListformName.get(i).getAttribute("innerHTML")
						.equals(hospitalIndicationDTO.form.get(coverageNameCount))) {
					clickButton(driver, manuscriptAddListformNameChkBox.get(i),
							"check Box for " + hospitalIndicationDTO.form.get(coverageNameCount));
					break;
				}
			}
			ExtentReporter.logger.log(LogStatus.INFO, "Window closes and forms are attached to Policy");
			clickButton(driver, manuscriptAddListDoneBtn, "Done");
			switchToParentWindowfromframe(driver);
			Thread.sleep(3000);
			switchToFrameUsingElement(driver,
					driver.findElement(By.xpath("//iframe[contains(@src,'policyNo=" + PolicyNo + "')]")));
			Thread.sleep(2000);

			// Save manuscript and close the window
			clickButton(driver, manuscriptPageSaveBtn, "Manu Script page Save");
			Thread.sleep(2000);
			ExtentReporter.logger.log(LogStatus.INFO, "Form is saved to coverage and window closes");
			clickButton(driver, manuscriptPageCloseBtn, "Manu Script page Close");
			switchToParentWindowfromframe(driver);
			Thread.sleep(2000);
			click(driver, Save_WIP, "Save WIP");
			Thread.sleep(2000);
		}
		return new PolicyIndicationPage(driver);
	}

	// Open Limit Sharing pop up from coverage tab and switch to pop up window
	public PolicyIndicationPage openLimitSharingTab(String PolicyNo) throws Exception {
		Thread.sleep(2000);
		ExtentReporter.logger.log(LogStatus.INFO, "Policy Page is displayed");
		clickButton(driver, Policy_tab, "Policy tab");
		Thread.sleep(1000);
		click(driver, Limit_Sharing, "Limit Sharing button");
		ExtentReporter.logger.log(LogStatus.INFO, "Limit Sharing Window Displays");
		Thread.sleep(2000);
		switchToFrameUsingElement(driver,
				driver.findElement(By.xpath("//iframe[contains(@src,'policyNo=" + PolicyNo + "')]")));
		getPageTitle(driver, limitSharingPageTitle);
		return new PolicyIndicationPage(driver);
	}

	// Add Shared group from the limit sharing tab
	public PolicyIndicationPage addSharedGroup(String PolicyNo) throws Exception {

		for (int sharedGroupCoverageCount = 0; sharedGroupCoverageCount < hospitalIndicationDTO.sharedGroupCoverage
				.size() / 3; sharedGroupCoverageCount++) {

			// Click on 'Add' button from pop up to add shared group
			Thread.sleep(2000);
			ExtentReporter.logger.log(LogStatus.INFO, "Line is added to Shared Group");
			click(driver, Add_Shared_Group, "Add button for Shared group");
			Thread.sleep(1000);
			selectDropdownByVisibleText(driver, Desc_Shared_Group,
					hospitalIndicationDTO.sharedGroupDescription.get(sharedGroupCoverageCount),
					"Shared group description");
			// verifyValueFromField(driver, Desc_Shared_Group,
			// hospitalIndicationDTO.sharedGroupDescription.get(sharedGroupCoverageCount),"value");

			// Click on 'Add' button from pop up to add shared group details
			ExtentReporter.logger.log(LogStatus.INFO, "Select Shared Group Detail window displays");
			click(driver, Add_Shared_Group_Details, "Add button for Shared Group details");
			Thread.sleep(3000);
			List<WebElement> firstName = driver.findElements(By.id("popupframe1"));
			driver.switchTo().frame(firstName.get(0));
			Thread.sleep(2000);

			// Get the count of check boxes on the pop up window
			for (int i = 0; i < selectSharedGroupDetailChkBox.size(); i++) {

				// Compare the coverage class and select Coverage class and
				// owner check box from the coverage list on pop up.
				if (selectCoverage.get(i).getAttribute("innerHTML")
						.equals(hospitalIndicationDTO.sharedGroupCoverage.get(sharedGroupCoverageCount))) {
					clickButton(driver, selectSharedGroupDetailChkBox.get(i), "Coverage Class selection");
					clickButton(driver, selectSharedGroupOwnerChkBox.get(i), "Owner checkbox");
					break;
				}
			}
			// Select Done button and switch back to first window for its
			// closure
			ExtentReporter.logger.log(LogStatus.INFO, "Selected Risks are added to Shared Group Details");
			click(driver, Done_Shared_Details, "Done button for Select Shared Group details");
			switchToParentWindowfromframe(driver);
			Thread.sleep(1000);
			switchToFrameUsingId(driver, "popupframe1");
			/*Assert.assertEquals(sharedGroupDetailsCoverage.getAttribute("innerHTML"),
					hospitalIndicationDTO.sharedGroupCoverage.get(sharedGroupCoverageCount),
					"Shared group coverage is not added");*/
			// ToDo-Use Verify value from field instead of assert
		}
		//writeData("TC42238", "policyNum", PolicyNo, 1, ExcelPath);
		return new PolicyIndicationPage(driver);
	}

	// Close Limit Sharing pop up and switch to parent window
	public RateApolicyPage closeLimitSharingtab() throws Exception {

		Thread.sleep(3000);
		click(driver, Save_Limit_Sharing, "Save button");
		ExtentReporter.logger.log(LogStatus.INFO, "Limit Sharing Window Closes");
		click(driver, Close_Limit_Sharing, "Close button");
		switchToParentWindowfromframe(driver);
		return new RateApolicyPage(driver);
	}
}
