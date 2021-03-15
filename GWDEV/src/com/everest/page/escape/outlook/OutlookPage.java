package com.everest.page.escape.outlook;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface OutlookPage extends Page {

	
	@TimeMethod
	@ScreenShot
	public void SendEmail(String tcID, SoftAssert softAs)throws Exception ;
	public void VerifyEmailSent(String tcID, SoftAssert softAs)throws Exception ;

}
