package com.everest.webservice.insureon;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface WebServiceGenerateAuthToken extends Page {

	
	@TimeMethod
	@ScreenShot
	
	public String generateAuthTokenCode(String tcID, SoftAssert softAs) throws Exception;
	public String generateAuthTokenCodeForUserDocumentOperation(String tcID, SoftAssert softAs) throws Exception;
	
	
	

}
