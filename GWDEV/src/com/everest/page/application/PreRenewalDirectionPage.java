package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface PreRenewalDirectionPage extends Page {

	@ElementDefinition
	public String tabActions = "tabActions";
	@ElementDefinition
	public String btnPrerenewalDirectionTab = "btnPrerenewalDirectionTab";
	@ElementDefinition
	public String btnEdit = "btnEdit";
	@ElementDefinition
	public String txtDirection = "txtDirection";
	@ElementDefinition
	public String txtText = "txtText";
	@ElementDefinition
	public String txtNonRenewReason = "txtNonRenewReason";

	@ElementDefinition
	public String btnUpdate = "btnUpdate";

	
	@TimeMethod
	@ScreenShot
	public void PreRenewalDirection(String tcID, SoftAssert softAssert) throws Exception;
}
