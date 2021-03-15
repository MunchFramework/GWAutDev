package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmPremiumCapturePage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmPremiumCapturePageImpl extends CustomAbstractPage implements UmPremiumCapturePage {

	@Override
	public void UmPremiumCapture(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		PageData dataUmLogin1= PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		PageData dataUmAddOfc= PageDataManager.instance().getPageData("UmAddingOffice", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);

		
		int policyIndx=0;
		
		 int divs=getWebDriver().findElements(By.xpath("//span[text()='Worksheets']/../../../../div")).size();
		for(int i=1 ; i<=divs ; i++)
		{
			String SubTabxpath="//span[text()='Worksheets']/../../../../div["+ i+"]//button/span";
			WebElement weLinks=getWebDriver().findElement(By.xpath(SubTabxpath));
			if(weLinks.getText().trim().equalsIgnoreCase("Worksheets"))
			{
				policyIndx=i;
				break;
			}
		}
		_wait(5000);
		
			 String PolicyLinkXpath="//span[text()='Worksheets']/../../../../div["+(policyIndx-1)+"]/div[1]/button";		
			 WebElement wePolicyLink=getWebDriver().findElement(By.xpath(PolicyLinkXpath));
			 wePolicyLink.click();
				
		_wait(5000);
		String UMPremium = _getAttributeValue(getElement(lblTotalPremium), "TEXT");
		
		if(tcID.equalsIgnoreCase("DS_R4_2_AMS_TC21750"))
		{
			int premium = Integer.parseInt(UMPremium);
			if(!(premium==0))
			{
				CustomReporting.logReport("", "", "Premium is Not Zero for EZ Excess Policy with DNO Coverage and CA State. Expected Premium : Non Zero. Actual Premium : "+UMPremium, StepStatus.SUCCESS, System.currentTimeMillis());
			}
			else
			{
				CustomReporting.logReport("", "", "Premium is Zero for EZ Excess Policy with DNO Coverage and CA State. Expected Premium : Non Zero. Actual Premium : "+UMPremium, StepStatus.FAILURE, System.currentTimeMillis());

			}
		}
		
		  _click(getElement(tabRatingPremiumSummary));
	       _wait(5000);
			String UMKYMunicipalTax="";
			if(func._isVisible(getElement(txtUMKYMuncipalTax)))
			{
			 UMKYMunicipalTax = getElement(txtUMKYMuncipalTax).getAttribute("value");	
			_writeToExcel("InsuredAppLogin", "UMKYMuncipalTax", UMKYMunicipalTax, tcID);
			}
		
		_writeToExcel("InsuredAppLogin", "UMPremium", UMPremium, tcID);

	}
	
	@Override
	public void CaptureUMTax_KY(String tcID, SoftAssert softAssert) throws Exception 
	{
		_click(getElement(tabRatingPremiumSummary));
	    _wait(5000);
	    String UMTax_KY_Pub_Ser_Charge="";
	    
			if(func._isVisible(getElement(KY_PubSerCrg)))
			{
				UMTax_KY_Pub_Ser_Charge = getElement(KY_PubSerCrg).getAttribute("value");	
				_writeToExcel("InsuredAppLogin", "UMTax_KY_Pub_Ser_Charge", UMTax_KY_Pub_Ser_Charge, tcID);
				_writeToExcel("Forms", "FormsValidation", UMTax_KY_Pub_Ser_Charge, tcID);
				CustomReporting.logReport("", "", "Captured UM Tax for KY - Public Service Charge : "+UMTax_KY_Pub_Ser_Charge, StepStatus.SUCCESS, System.currentTimeMillis());
			
			}
			else
			{
				CustomReporting.logReport("", "", "Failed to Capture UM Tax for KY", StepStatus.FAILURE, System.currentTimeMillis());
			}
	}
	
	@Override
	public void CaptureUMTax_NJ(String tcID, SoftAssert softAssert) throws Exception 
	{
		_click(getElement(tabRatingPremiumSummary));
	    _wait(5000);
	    String UMTax_NJ_SurCharge="";
	    
			if(func._isVisible(getElement(KY_PubSerCrg)))
			{
				UMTax_NJ_SurCharge = getElement(KY_PubSerCrg).getAttribute("value");	
				_writeToExcel("InsuredAppLogin", "UMTax_NJ_SurCharge", UMTax_NJ_SurCharge, tcID);
				_writeToExcel("Forms", "FormsValidation", UMTax_NJ_SurCharge, tcID);
				CustomReporting.logReport("", "", "Captured UM Tax for NJ - SurCharge : "+UMTax_NJ_SurCharge, StepStatus.SUCCESS, System.currentTimeMillis());
			
			}
			else
			{
				CustomReporting.logReport("", "", "Failed to Capture UM Tax for NJ", StepStatus.FAILURE, System.currentTimeMillis());
			}
	}
	
	@Override
	public void CapturePremiumBreakdown(String tcID, SoftAssert softAssert) throws Exception 
	{
		_click(getElement(Binding_Page));
		 _wait(5000);
		 try {
			_writeToExcel("UmBinding", "UM_CrimeP", getElement(Crime).getAttribute("value"), tcID);
			_writeToExcel("UmBinding", "UM_Cyber1P", getElement(Cyber_1).getAttribute("value"), tcID);
			_writeToExcel("UmBinding", "UM_Cyber2P", getElement(Cyber_2).getAttribute("value"), tcID);
			_writeToExcel("UmBinding", "UM_DNOP", getElement(DNO).getAttribute("value"), tcID);
			_writeToExcel("UmBinding", "UM_EMPP", getElement(EMP).getAttribute("value"), tcID);
			_writeToExcel("UmBinding", "UM_ENOP", getElement(ENO).getAttribute("value"), tcID);
			_writeToExcel("UmBinding", "UM_EPLP", getElement(EPL).getAttribute("value"), tcID);
			_writeToExcel("UmBinding", "UM_FIDP", getElement(FID).getAttribute("value"), tcID);
			_writeToExcel("UmBinding", "UM_KNRP", getElement(KNR).getAttribute("value"), tcID);
			CustomReporting.logReport("", "", "Captured UM Premium Breakdowns Successfully", StepStatus.SUCCESS, System.currentTimeMillis());
		} catch (Exception e) {
			CustomReporting.logReport("", "", "Failed to Capture UM Premium Breakdowns", StepStatus.FAILURE, System.currentTimeMillis());
		}
		
		 
	}
	
}