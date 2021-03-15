package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.PremiumCapturePage;
import com.everest.utility.CustomAbstractPage;

public class PremiumCapturePageImpl extends CustomAbstractPage implements PremiumCapturePage {

	@SuppressWarnings("static-access")
	@Override
	public void PremiumCapture(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataAccount = PageDataManager.instance().getPageData("NewSubmission", tcID);
		_wait(5000);
		_click(getElement(btnQuote));
		_wait(5000);
		
		if (func._isVisible(getElement(lblPremium)) == false)
		{
			_click(getElement(btnQuote));
		}

		String Premium = _getAttributeValue(getElement(lblPremium), "TEXT");

		_writeToExcel("InsuredAppLogin", "Premium", Premium, tcID);
		
		String RatingWorkSheetId = _getAttributeValue(getElement(lblRatingWorkSheetId), "TEXT");

		_writeToExcel("InsuredAppLogin", "RatingWorkSheetId", RatingWorkSheetId, tcID);
		
	

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(2000);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

	}
	
	@SuppressWarnings("static-access")
	@Override
	public void pcPremiumCaptureItlAdd(String tcID, SoftAssert softAs) throws Exception 
	{


		PageData dataAccount = PageDataManager.instance().getPageData("InternationalAddress", tcID);
		_wait(5000);
		_click(getElement(btnQuote));
		_wait(5000);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		String pcTotalPremium = _getAttributeValue(getElement(lblPremium), "TEXT");
		//String pcPolicyCurrency = _getAttributeValue(getElement(lblPolicyCurrency), "TEXT");
		_writeToExcel("InternationalAddress", "pcTotalPremium", pcTotalPremium, tcID);
		//_writeToExcel("InternationalAddress", "pcPolicyCurrency", pcPolicyCurrency, tcID);
		
		if(!dataAccount.getData("umPolicyCurrency").equalsIgnoreCase("USD"))
		{
			String pcBINDFXRate = _getAttributeValue(getElement(lblQuoteFx), "TEXT");
			String pcUSDPremium = _getAttributeValue(getElement(lblUSDPremium), "TEXT");
			_writeToExcel("InternationalAddress", "pcBINDFXRate", pcBINDFXRate, tcID);
			_writeToExcel("InternationalAddress", "pcUSDPremium", pcUSDPremium, tcID);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void verifyMNFireCharges(String tcID, SoftAssert softAs) throws Exception 
	{


		PageData data= PageDataManager.instance().getPageData("Login", tcID);
		_wait(5000);
		_click(getElement(btnQuote));
		_wait(5000);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		func._checkAttributeValue(getElement(lblMNFireSurcharges), "TEXT", data.getData("MNFireSurcharges"), softAs);
		
	}
}
