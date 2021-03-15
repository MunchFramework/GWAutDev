package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;


public interface UmGetSubmissionNumberPage extends Page {

	@ElementDefinition
	public String lnkSubmission = "lnkSubmission";

	@ElementDefinition
	public String lblSubmissionNo = "lblSubmissionNo";
	@ElementDefinition
	public String lnkAccountHistory = "lnkAccountHistory";
	@ElementDefinition
	public String get_SubmissionNumr = "get_SubmissionNumr";
	@ElementDefinition
	public String get_Policy = "get_Policy";
	@ElementDefinition
	public String lnkSubmission_01 = "lnkSubmission_01";
	@ElementDefinition
	public String txt_PolicyPremium = "txt_PolicyPremium";
	@ElementDefinition
	public String txt_insuredName = "txt_insuredName";
	@ElementDefinition
	public String txt_OwnerShipType = "txt_OwnerShipType";
	@ElementDefinition
	public String btn_Policy = "btn_Policy";
	@ElementDefinition
	public String lst_PolicyDetails = "lst_PolicyDetails";
	@ElementDefinition
	public String btn_RatingSlimLine = "btn_RatingSlimLine";
	@ElementDefinition
	public String txt_Commission = "txt_Commission";
	@ElementDefinition
	public String txt_LOB = "txt_LOB";
	
	@ElementDefinition
	public String txt_AggregateLimit = "txt_AggregateLimit";
	@ElementDefinition
	public String txt_Retention = "txt_Retention";
	@ElementDefinition
	public String btn_Quoting = "btn_Quoting";
	@ElementDefinition
	public String lbl_InsuringCompany = "lbl_InsuringCompany";
	@ElementDefinition
	public String lbl_SubmissionStatus = "lbl_SubmissionStatus";
	@ElementDefinition
	public String btn_RatingCRI = "btn_RatingCRI";
	@ElementDefinition
	public String txt_CRIMESubtotal = "txt_CRIMESubtotal";
	@ElementDefinition
	public String btn_RatingKNR = "btn_RatingKNR";
	@ElementDefinition
	public String txt_KNRSubtotal = "txt_KNRSubtotal";
	@ElementDefinition
	public String btn_RatingPremiumSummary = "btn_RatingPremiumSummary";
	@ElementDefinition
	public String txt_MNFireSurcharges = "txt_MNFireSurcharges";
	
	@ElementDefinition
	public String btn_RatingFID = "btn_RatingFID";
	@ElementDefinition
	public String txt_FIDPremium = "txt_FIDPremium";
	@ElementDefinition
	public String txt_FIDSubtotal = "txt_FIDSubtotal";
	@ElementDefinition
	public String txt_DNOSubtotal = "txt_DNOSubtotal";
	@ElementDefinition
	public String txt_EPLSubtotal = "txt_EPLSubtotal";
	
	@ElementDefinition
	public String btn_RatingCYB = "btn_RatingCYB";
	@ElementDefinition
	public String txt_CYBPremium = "txt_CYBPremium";
	@ElementDefinition
	public String txt_CYBPremiumSubtotal = "txt_CYBPremiumSubtotal";

	
	
	@TimeMethod
	@ScreenShot
	public void UmSubmissionNumber (String tcID, SoftAssert softAs) throws Exception;
	public void verify_UMPolicy_Renewaval(String tcID, SoftAssert softAssert) throws Exception;
	public void UmSubmissionInformation (String tcID, SoftAssert softAs) throws Exception;
	public void getUWBranchOfficeDetails(String tcID, SoftAssert softAs) throws Exception;
	public void verifyMNPCIMF4Surcharges(String tcID, SoftAssert softAs) throws Exception;
	public void verifyFIDPremium(String tcID, SoftAssert softAs) throws Exception;
	public void verifyCYBPremiumAgainstRater(String tcID, SoftAssert softAs) throws Exception;
	
}
