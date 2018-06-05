package com.mm.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mm.utils.ExtentReporter;
import com.mm.utils.commonAction;
import com.relevantcodes.extentreports.LogStatus;

public class quick_Add_Organisation extends commonAction{
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='fNiv isParent']")
	 WebElement Quick_Add;
	
	@FindBy(xpath="//li[@id='CI_QUICKADDORG_MI']//a/span")
	 WebElement Add_Org;
	
	@FindBy(name="entity_organizationName")
	WebElement Org_Name;
	
	@FindBy(name="entity_dateOfBirth")
	WebElement DateOfBirth;
	
	@FindBy(name="entityClass_entityClassCode")
	WebElement classification;
	
	@FindBy(name="entityClass_effectiveToDate")
	WebElement Effe_To_Date;
	
	@FindBy(name="address_addressTypeCode")
	WebElement Address_Type1;
	
	@FindBy(name="address_addressLine1")
	WebElement Addr_Line1;
	
	@FindBy(name="address_city")
	WebElement City;
	
	@FindBy(name="address_stateCode")
	WebElement Zip_code;
	
	@FindBy(xpath="//input[@type='button' and @value='OK']")
	WebElement OK;
	
	@FindBy(name="phoneNumber_phoneNumberTypeCode")
	WebElement Phn_Num_Type;

	@FindBy(name="phoneNumber_areaCode")
	WebElement Area_Code;
	
	@FindBy(name="phoneNumber_phoneNumber_DISP_ONLY")
	WebElement Phn_Num;
	
	@FindBy(id="CI_QCKADDORG_SAVE")
	WebElement Save;
	
	
	public quick_Add_Organisation(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void navigate_To_Add_Org_Window(){
		

		Actions action = new Actions(driver);
		action.moveToElement(Quick_Add).build().perform();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		clickButton(driver, Add_Org, "Add Organisation");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Add_Org);
		ExtentReporter.logger.log(LogStatus.INFO, "Add Organization Quick Entry window displays");
		
	}
	
	public void add_Org_Information() throws InterruptedException{
		
		
		enterTextIn(driver,Org_Name, "Vivek_Test_Organisation2", "Org Name");
		
		enterTextIn(driver,DateOfBirth, "12052005", "Date");
		
		Thread.sleep(3000);
		
		selectDropdownByValue(driver,classification, "HOSPITAL", "Classfication");
		
		enterTextIn(driver,Effe_To_Date, "12052050", "Effec_To_Date");
		
		
		ExtentReporter.logger.log(LogStatus.INFO, "Organization information is added");
		
	}
	
	
	public void add_Org_Address(){
		
		selectDropdownByValue(driver,Address_Type1, "POLICY", "Add_Type1");
		
		enterTextIn(driver,Addr_Line1, "123,Off ITI Road, Aundh", "Line1");
		
		enterTextIn(driver,City, "Atlanta", "city");
		
		selectDropdownByValue(driver,Zip_code, "GA", "state code");
		
	}
	
		
		 public void selectZipCode() throws InterruptedException
		    {
		    	   String parentwindow = switchToWindow(driver);
		    	   Thread.sleep(2000);
		    	  	    	   
		    	   WebElement zipCode = driver.findElement(By.xpath("//input[@value='30301']")); 
		    	   click(driver,zipCode,"ZipCode");

		    	   click(driver,OK,"OK button");

		    	   ExtentReporter.logger.log(LogStatus.INFO, "Address is entered"); 
		    	   Thread.sleep(2000);
	      	       switchToParentWindowfromotherwindow(driver, parentwindow); 
	      	      
			}
		
		public void add_Phone_Number(){
			
		enterTextIn(driver,Phn_Num_Type, "OFFICE", "Phone_No_Type");
		
		enterTextIn(driver,Area_Code, "789", "Area Code");
				
		enterTextIn(driver,Phn_Num, "1234567","Phn_num");
		
		ExtentReporter.logger.log(LogStatus.INFO, "Phone number is added"); 
			 	 	
		click(driver,Save, "Save button");
		
		ExtentReporter.logger.log(LogStatus.INFO, "Organization is added");
		
	}
	
}
