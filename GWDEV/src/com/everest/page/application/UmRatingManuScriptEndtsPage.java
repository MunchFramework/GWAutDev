package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmRatingManuScriptEndtsPage extends Page{
	@ElementDefinition
	public String lnk_RatingMSEndts = "lnk_RatingMSEndts";
	@ElementDefinition
	public String btn_addRow = "btn_addRow";
	@ElementDefinition
	public String btnUpdateCoverages = "btnUpdateCoverages";
	@ElementDefinition
	public String Error_Summary = "Error_Summary";
	@ElementDefinition
	public String btn_Ok = "btn_Ok";
	@TimeMethod
	@ScreenShot
	public void UmAddingManuScriptEndts(String tcID, SoftAssert softAs) throws Exception;
	public void UmManuScriptEndts_Forms(String tcID, SoftAssert softAssert) throws Exception;

}
