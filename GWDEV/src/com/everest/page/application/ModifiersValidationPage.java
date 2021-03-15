package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface ModifiersValidationPage extends Page {

	@ElementDefinition
	public String tabModifiers = "tabModifiers";

	@TimeMethod
	@ScreenShot
	public void ModifiersValidation(String tcID, SoftAssert softAssert) throws Exception;
}
