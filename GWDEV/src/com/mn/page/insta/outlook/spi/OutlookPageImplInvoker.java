package com.mn.page.insta.outlook.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.device.ng.AbstractSeleniumTest;
import org.xframium.page.PageManager;

import com.mn.page.insta.outlook.OutlookPage;


public class OutlookPageImplInvoker extends AbstractSeleniumTest{
	
/**************************************************/
	
	SoftAssert softAssert= new SoftAssert();
	
	public void launchOutlook(String tcID) throws Exception
 	{
   		
		OutlookPage objReference = (OutlookPage) PageManager.instance().createPage( OutlookPage.class, getWebDriver());
 		objReference.SendEmail(tcID, softAssert);
 		
 	}

	
 /**************************************************/

}
