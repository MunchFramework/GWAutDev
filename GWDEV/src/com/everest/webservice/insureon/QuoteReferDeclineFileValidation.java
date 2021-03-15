package com.everest.webservice.insureon;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface QuoteReferDeclineFileValidation extends Page {

	
	
	
	@TimeMethod
	@ScreenShot
	



	void verifyQuoteDocDetails(String tcID, SoftAssert softAssert) throws Exception;

	void verifyReferalMail(String tcID, SoftAssert softAssert) throws Exception;
	void uploadSignedAppDocument(String tcID, SoftAssert softAssert) throws Exception;
	
	//void extractNAICSData(String tcID, SoftAssert softAssert) throws Exception;
	
	
	
}






