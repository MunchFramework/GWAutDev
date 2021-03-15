package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmRatingSubInfoPage extends Page{
	@ElementDefinition
	public String GreenRightTickMark = "GreenRightTickMark";
	@ElementDefinition
	public String Verification_Chkbx = "Verification_Chkbx";
	@ElementDefinition
	public String dropdown_WritingApproach = "dropdown_WritingApproach";
	@ElementDefinition
	public String search_box = "search_box";
	@ElementDefinition
	public String Search_Results = "Search_Results";
	@ElementDefinition
	public String Justification_txtbox = "Justification_txtbox";
	@ElementDefinition
	public String lnk_RatingSubInfo = "lnk_RatingSubInfo";
	@ElementDefinition
	public String btnUpdateCoverages = "btnUpdateCoverages";
	@ElementDefinition
	public String txtWritingApproach = "txtWritingApproach";
	@TimeMethod
	@ScreenShot
	public void UmAddingSubInfo(String tcID, SoftAssert softAs) throws Exception;
	public void UmValidateWritingApproach(String tcID, SoftAssert softAs) throws Exception;

}
