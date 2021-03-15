package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.ChangePremiumCapturePage;
import com.everest.utility.CustomAbstractPage;

public class ChangePremiumCapturePageImpl extends CustomAbstractPage implements ChangePremiumCapturePage {

	@SuppressWarnings("static-access")
	@Override
	public void ChangePremiumCapture(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataAccount = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_click(getElement(btnQuote));
		_wait(5000);
		String strScreenShots=dataAccount.getData("PrintScreens");
		 
        if(strScreenShots.equalsIgnoreCase("Yes"))
        {
          func._takeBrowserScreenShot(getWebDriver(), "START", "", "");
        }
        String strURL="";


		String Premium = _getAttributeValue(getElement(lblPremium), "TEXT");

		_writeToExcel("InsuredAppLogin", "Premium2", Premium, tcID);
		
		String RatingWorkSheetId = _getAttributeValue(getElement(lblRatingWorkSheetId), "TEXT");

		_writeToExcel("InsuredAppLogin", "RatingWorkSheetId2", RatingWorkSheetId, tcID);
		
		
		
			
		

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(2000);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

	}
	
	@Override
	public void ChangePremiumCaptureRunoff(String tcID, SoftAssert softAs, String ShortTermWorkSheetID, String ShortTermPremium) throws Exception
	{
		PageData dataAccount = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		if(func._isVisible(getElement(btnQuote))==true)
		{
		_click(getElement(btnQuote));
		}
		_wait(5000);
		
        String strURL="";


		String Premium = _getAttributeValue(getElement(lblPremium), "TEXT");

		_writeToExcel("InsuredAppLogin", ShortTermPremium, Premium, tcID);
		
		String RatingWorkSheetId = _getAttributeValue(getElement(lblRatingWorkSheetId), "TEXT");

		_writeToExcel("InsuredAppLogin", ShortTermWorkSheetID, RatingWorkSheetId, tcID);
		
		
		
			
		

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(2000);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		
	}

}
