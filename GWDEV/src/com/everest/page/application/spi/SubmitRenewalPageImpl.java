package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;

import com.everest.page.application.SubmitRenewalPage;
import com.everest.utility.CustomAbstractPage;


public class SubmitRenewalPageImpl extends CustomAbstractPage implements SubmitRenewalPage  {
	@SuppressWarnings("static-access")
	@Override
	public void SubmitRenewal(String tcID, SoftAssert softAssert) throws Exception {

		_wait(10000);
		
		_click(getElement(btnActions));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		_click(getElement(btnSubmitRenewal));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(3000);
		_click(getElement(btnYes));	
		_wait(5000);
		
			
		  func._waitForPageToLoad(getWebDriver(),50L);
		  
	}
			
		
	}

