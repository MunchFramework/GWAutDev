package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmSearchSubmissionPage extends Page
{
	@ElementDefinition
	public String PowerBI_Links = "PowerBI_Links";
	@ElementDefinition
	public String Reports_link = "Reports_link";
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
	public void UmSearchSubmission (String tcID, SoftAssert softAs) throws Exception;
	public void UmPowerBIReports_LinkVerification(String tcID, SoftAssert softAssert) throws Exception; 

}
