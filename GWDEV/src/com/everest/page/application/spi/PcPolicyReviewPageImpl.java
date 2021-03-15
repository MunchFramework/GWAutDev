package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.PcPolicyReviewPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class PcPolicyReviewPageImpl extends CustomAbstractPage implements PcPolicyReviewPage {

	@SuppressWarnings("static-access")
	@Override
	public void PcPolicyReviewValidation(String tcID, SoftAssert softAssert) throws Exception 
	{
		
		_wait(4000);
		PageData dataUmRatCom = PageDataManager.instance().getPageData("UmRatingCommon", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		_click(getElement(PolicyReviewLink));
		func._waitForPageToLoad(getWebDriver(), 50L);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(4000);
		
		if(!dataUmRatCom.getData("PartOf").equalsIgnoreCase(""))
		{
			String PartOf_PC = func._getAttributeValue(getElement(PartOf), "TEXT", softAssert).replace(",", "");
		    //func._checkAttributeValue(getElement(PartOf), "TEXT", dataUmRatCom.getData("PartOf"), softAssert);
			if(PartOf_PC.equalsIgnoreCase(dataUmRatCom.getData("PartOf")))
			{
				CustomReporting.logReport("", "", "PC Part Of Value: " + PartOf_PC + " matches with UM Part Of Value : "+ dataUmRatCom.getData("PartOf"), StepStatus.SUCCESS, new String[] {},
						System.currentTimeMillis());
			}
			else
			{
				CustomReporting.logReport("", "", "PC Part Of  Value: " + PartOf_PC + " does not matches with UM Part Of Value  "+ dataUmRatCom.getData("PartOf"), StepStatus.FAILURE, new String[] {},
						System.currentTimeMillis());
			}
			
		}
		
		
		
	}

	
	
		

}
