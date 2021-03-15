package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmGeneralInfoPage extends Page {

	@ElementDefinition
	public String txtStreet1 = "txtStreet1";
	@ElementDefinition
	public String txtZipCode = "txtZipCode";
	@ElementDefinition
	public String txtCity = "txtCity";
	@ElementDefinition
	public String txtCountry = "txtCountry";
	@ElementDefinition
	public String txtFEIN = "txtFEIN";
	@ElementDefinition
	public String ddState = "ddState";
	@ElementDefinition
	public String lnkProducerOffice = "lnkProducerOffice";
	@ElementDefinition
	public String btnNewSubmission = "btnNewSubmission";
	@ElementDefinition
	public String btnSubmitApplication = "btnSubmitApplication";

	@ElementDefinition
	public String btnMarketSegment = "btnMarketSegment";
	
	@ElementDefinition
	public String ddOwnershipType = "ddOwnershipType";
	@ElementDefinition
	public String txtOwnershipType = "txtOwnershipType";
	
	@TimeMethod
	@ScreenShot
	public void UmGeneralInfo(String tcID, SoftAssert softAs) throws Exception;

}
