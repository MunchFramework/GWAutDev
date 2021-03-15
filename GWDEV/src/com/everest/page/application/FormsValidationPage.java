package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface FormsValidationPage extends Page {

	
	@ElementDefinition
	public String tabForms = "tabForms";
	
	

	@TimeMethod
	@ScreenShot
	public void formsValidation(String tcID, SoftAssert softAs) throws Exception;
}
