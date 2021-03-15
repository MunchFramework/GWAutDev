package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;


public interface SubmitRenewalPage extends Page{

	@ElementDefinition
	public String btnActions = "btnActions";
	@ElementDefinition
	public String btnSubmitRenewal = "btnSubmitRenewal";
	@ElementDefinition
	public String btnYes = "btnYes";
	
	@TimeMethod
	@ScreenShot
	public void SubmitRenewal(String tcID, SoftAssert softAs) throws Exception;

}
