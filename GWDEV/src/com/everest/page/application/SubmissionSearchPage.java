package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface SubmissionSearchPage extends Page {

	@ElementDefinition
    public String tabPolicy = "tabPolicy";
	
	@ElementDefinition
	public String txtSubmissionNo = "txtSubmissionNo";
	@ElementDefinition
	public String btnSearch = "btnSearch";
	

	@TimeMethod
	@ScreenShot
	public void searchSubmission(String tcID, SoftAssert softAs) throws Exception;
	
}
