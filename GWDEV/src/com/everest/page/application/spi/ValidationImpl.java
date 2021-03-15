package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.PCValidationPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class ValidationImpl extends CustomAbstractPage implements PCValidationPage  {
	@SuppressWarnings("static-access")
	@Override
	public void PCValidation(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataRescind = PageDataManager.instance().getPageData("Rescind", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		
		_click(getElement(lnkViewPolicy));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(lblPremium));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(lblEffectiveDate));
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(lblPolicyNumber));
		
		  func._waitForPageToLoad(getWebDriver(),50L);
		  
		CustomReporting.logReport("","","Rescind is successfully!" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
		}
	@Override
	public void verifyObligeeDetails(String tcID, SoftAssert softAssert) throws Exception {
		PageData data = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);

		_click(getElement(lblPolicyInfo));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(lnkObligee));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		func._checkAttributeValue(getElement(lblRelationShip), "TEXT", "Obligee", softAssert);
		func._checkAttributeValue(getElement(lblObligeeName), "TEXT", data.getData("ObligeeName"), softAssert);
		func._checkAttributeValue(getElement(lblObligeeAddress), "TEXT", data.getData("ObligeeAddress")
				+ data.getData("ObligeeCity") + data.getData("ObligeePostCode") + data.getData("ObligeeCountry"),
				softAssert);

	}
			
		
	}

