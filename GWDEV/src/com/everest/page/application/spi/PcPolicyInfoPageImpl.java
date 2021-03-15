package com.everest.page.application.spi;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.PcPolicyInfoPage;
import com.everest.utility.CustomAbstractPage;

public class PcPolicyInfoPageImpl extends CustomAbstractPage implements PcPolicyInfoPage {

	@SuppressWarnings("static-access")
	@Override
	public void PcPolicyInfoValidation(String tcID, SoftAssert softAssert) throws Exception 
	{
		
		_wait(2000);
		PageData dataUmSubDetails = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		Robot rb = new Robot();
		
		_wait(2000);
		_click(getElement(Issuance_Tran));
		_wait(2000);
		_click(getElement(PolicyInfoPageLink));
		_wait(2000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(2000);
		
		if(!dataUmSubDetails.getData("InsuredType").equalsIgnoreCase(""))
		{
			_click(getElement(PortfolioGrouping));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		    func._checkAttributeValue(getElement(PortfolioGrouping), "TEXT", dataUmSubDetails.getData("InsuredType"), softAssert);
		}
		
		if(dataUmSubDetails.getData("QuoteShare").equalsIgnoreCase("Yes"))
		{
			rb.keyPress(KeyEvent.VK_HOME);
			rb.keyRelease(KeyEvent.VK_HOME);
			func._checkAttributeValue(getElement(QuotaShare), "TEXT", dataUmSubDetails.getData("QuoteShare"), softAssert);
		}
		
	}

	
	
		

}
