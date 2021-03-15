package com.everest.webservice.insureon;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface WebServiceGetQuote extends Page {

	
	
	
	@TimeMethod
	@ScreenShot
	

	void verifyGetQuoteDetails(String tcID, SoftAssert softAssert, String SelectedQuestion, String QuestionsValue)
			throws Exception;
	
	
	
}






