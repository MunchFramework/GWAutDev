package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface PcPolicyReviewPage extends Page {

	
	@ElementDefinition
	public String PolicyReviewLink = "PolicyReviewLink";
	@ElementDefinition
	public String PartOf = "PartOf";
	
	
	@TimeMethod
	@ScreenShot
	public void PcPolicyReviewValidation(String tcID, SoftAssert softAs) throws Exception;
}
