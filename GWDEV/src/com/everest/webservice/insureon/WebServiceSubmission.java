package com.everest.webservice.insureon;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface WebServiceSubmission extends Page {

	
	
	
	@TimeMethod
	@ScreenShot
	public void CreateAccSubDclnCrime_01(String tcID, SoftAssert softAssert) throws Exception;
	public void verifySubmissionAgainstState(String tcID, SoftAssert softAssert,String DeviceName) throws Exception;
	public void verifySubmissionStatusAgainstElligibilityQues(String tcID, SoftAssert softAssert, String DeviceName,String DataSheetName)
			throws Exception;
	
	
}






