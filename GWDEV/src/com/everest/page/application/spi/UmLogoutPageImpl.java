package com.everest.page.application.spi;


import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmLogoutPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;


public class UmLogoutPageImpl extends CustomAbstractPage implements UmLogoutPage {
		
	@SuppressWarnings("static-access")
	@Override
	
	public void UmClosePage(String tcID, SoftAssert softAssert,String DeviceName) throws Exception {
		
		func._waitForPageToLoad(getWebDriver(),50L);
		_wait(2000);
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		
		if (dataUmLogin.getData("SSO").equalsIgnoreCase("Yes")) {
		_click(getElement(iconLogout));
		func._waitForPageToLoad(getWebDriver(),50L);
		_wait(1000);
		
	   
	    CustomReporting.logReport("","","Clicked on logout icon!" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
	    _wait(2000);
	    if (func._isVisible(getElement(menuLogout)) == false)
		{
	    	_click(getElement(iconLogout));
	    	_wait(2000);
		}
	    _click(getElement(menuLogout));
	    _wait(2000);
	    func._waitForPageToLoad(getWebDriver(),50L);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");


	    CustomReporting.logReport("","","Logged out of the application successfully!" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
	}

}
}