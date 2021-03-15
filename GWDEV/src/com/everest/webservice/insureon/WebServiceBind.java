package com.everest.webservice.insureon;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface WebServiceBind extends Page {

	
	
	
	@TimeMethod
	@ScreenShot
	

	void verifyBindDetails(String tcID, SoftAssert softAssert)
			throws Exception;
	
	
	
}






