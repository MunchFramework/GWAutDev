package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface ExposureValidationPage extends Page {

	@ElementDefinition
	public String tabExposures = "tabExposures";

	@TimeMethod
	@ScreenShot
	public void ExposureValidation(String tcID, SoftAssert softAssert) throws Exception;
}
