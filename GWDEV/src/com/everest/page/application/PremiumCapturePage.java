package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface PremiumCapturePage extends Page {
	
	@ElementDefinition
	public String lblPremium = "lblPremium";
	@ElementDefinition
	public String lblRatingWorkSheetId = "lblRatingWorkSheetId";
	@ElementDefinition
	public String btnQuote = "btnQuote";
	
	@ElementDefinition
	public String lblQuoteFx = "lblQuoteFx";
	@ElementDefinition
	public String lblUSDPremium = "lblUSDPremium";
	@ElementDefinition
	public String lblMNFireSurcharges = "lblMNFireSurcharges";

	
	@TimeMethod
	@ScreenShot
	public void PremiumCapture(String tcID, SoftAssert softAs) throws Exception;
	public void pcPremiumCaptureItlAdd(String tcID, SoftAssert softAs) throws Exception;
	public void verifyMNFireCharges(String tcID, SoftAssert softAs) throws Exception;
}
