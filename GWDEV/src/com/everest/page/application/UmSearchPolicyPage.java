package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;


public interface UmSearchPolicyPage extends Page {
	@ElementDefinition
	public String btnAdditionalCriteria = "btnAdditionalCriteria";
	@ElementDefinition
	public String btnSearchIcon = "btnSearchIcon";
	@ElementDefinition
	public String txtInsured = "txtInsured";
	@ElementDefinition
	public String btnSubmission = "btnSubmission";
	@ElementDefinition
	public String btnOK = "btnOK";
	
	@TimeMethod
	@ScreenShot
	public void UmSearchPolicy (String tcID, SoftAssert softAs) throws Exception;

}
