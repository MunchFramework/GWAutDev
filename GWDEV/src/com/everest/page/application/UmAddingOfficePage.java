package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmAddingOfficePage extends Page {

	@ElementDefinition
	public String lnkSubmission = "lnkSubmission";
	@ElementDefinition
	public String btnOffice = "btnOffice";
	@ElementDefinition
	public String txtOffice = "txtOffice";
	@ElementDefinition
	public String btnApplication = "btnApplication";
	@ElementDefinition
	public String txtUWAssistant = "txtUWAssistant";
	@ElementDefinition
	public String btnUWAssistant = "btnUWAssistant";
	@ElementDefinition
	public String txtUW = "txtUW";
	@ElementDefinition
	public String btnUW = "btnUW";
	@ElementDefinition
	public String txtWebsite = "txtWebsite";	
	@ElementDefinition
	public String btnCarrierBranch = "btnCarrierBranch";
	@ElementDefinition
	public String txtCarrierBranch = "txtCarrierBranch";
	@TimeMethod
	@ScreenShot
	public void UmAddingOffice(String tcID, SoftAssert softAs) throws Exception;
	public void Edit_UmAddingOffice(String tcID, SoftAssert softAssert) throws Exception;

}
