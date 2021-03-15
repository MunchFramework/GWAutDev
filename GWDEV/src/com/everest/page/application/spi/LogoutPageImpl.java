package com.everest.page.application.spi;


import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;

import com.everest.page.application.LogoutPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;


public class LogoutPageImpl extends CustomAbstractPage implements LogoutPage {
		
	@SuppressWarnings("static-access")
	@Override
	
	public void ClosePage(String tcID, SoftAssert softAssert,String DeviceName) throws Exception {
		
		_click(getElement(iconLogout));
		func._waitForPageToLoad(getWebDriver(),50L);
		_wait(1000);
	    CustomReporting.logReport("","","Clicked on logout icon!" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
	    _wait(2000);
	    if (getElement(menuLogout).isVisible()==false)
	    {
	    	_click(getElement(iconLogout));
			func._waitForPageToLoad(getWebDriver(),50L);
			
	    }
	    _click(getElement(menuLogout));
	    _wait(2000);
	    func._waitForPageToLoad(getWebDriver(),50L);
	    
	    if (func._isVisible(getElement(btnOk)))
	    {
	    	_click(getElement(btnOk));
	    }
	    _wait(4000);
	    CustomReporting.logReport("","","Logged out of the application successfully!" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
	}

}
