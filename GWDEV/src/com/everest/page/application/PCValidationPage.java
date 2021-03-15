package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface PCValidationPage extends Page {
	

	@ElementDefinition
	public String lnkViewPolicy = "lnkViewPolicy";
	@ElementDefinition
	public String lblPremium = "lblPremium";
	@ElementDefinition
	public String lblEffectiveDate = "lblEffectiveDate";
	@ElementDefinition
	public String lblPolicyNumber = "lblPolicyNumber";
	@ElementDefinition
	public String lblPolicyInfo = "lblPolicyInfo";
	@ElementDefinition
	public String lnkObligee = "lnkObligee";
	@ElementDefinition
	public String lblRelationShip = "lblRelationShip";
	@ElementDefinition
	public String lblObligeeName = "lblObligeeName";
	@ElementDefinition
	public String lblObligeeAddress = "lblObligeeAddress";

	@TimeMethod
	@ScreenShot

	public void PCValidation(String tcID, SoftAssert softAs) throws Exception;
	public void verifyObligeeDetails(String tcID, SoftAssert softAs) throws Exception;
	
}
