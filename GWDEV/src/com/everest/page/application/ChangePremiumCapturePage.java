package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface ChangePremiumCapturePage extends Page {
	
	@ElementDefinition
	public String lblPremium = "lblPremium";
	@ElementDefinition
	public String lblRatingWorkSheetId = "lblRatingWorkSheetId";
	@ElementDefinition
	public String btnQuote = "btnQuote";	
	
	@TimeMethod
	@ScreenShot
	public void ChangePremiumCapture(String tcID, SoftAssert softAs) throws Exception;
	public void ChangePremiumCaptureRunoff(String tcID, SoftAssert softAs, String ShortTermWorkSheetID, String ShortTermPremium) throws Exception;
}
