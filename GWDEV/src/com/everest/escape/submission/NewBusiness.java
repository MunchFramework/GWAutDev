package com.everest.escape.submission;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface NewBusiness extends Page {
	
	@ElementDefinition
	public String lnk_NewBusiness="lnk_NewBusiness" ;
	@ElementDefinition
	public String red_NewSubmissionType="red_NewSubmissionType" ;
	@ElementDefinition
	public String red_RenewalSubmissionType="red_RenewalSubmissionType" ;

	@ElementDefinition
	public String read_SubmissionStatus="read_SubmissionStatus" ;
	@ElementDefinition
	public String txt_InsuredName="txt_InsuredName" ;
	@ElementDefinition
	public String red_Renewal_SubStatus="red_Renewal_SubStatus" ;
	@ElementDefinition
	public String txt_MailingStreetAddress="txt_MailingStreetAddress" ;
	@ElementDefinition
	public String txt_MailingCity="txt_MailingCity" ;
	@ElementDefinition
	public String lst_MailingState="lst_MailingState" ;
	@ElementDefinition
	public String lst_Country="lst_Country" ;
	@ElementDefinition
	public String txt_MailingZipCode="txt_MailingZipCode" ;
	
	@ElementDefinition
	public String txt_MailingZipAddon="txt_MailingZipAddon" ;
	
	@ElementDefinition
	public String txt_NaicsCode="txt_NaicsCode" ;
	
	
	@ElementDefinition
	public String txt_FEIN="txt_FEIN" ;
	@ElementDefinition
	public String btn_FEIN="btn_FEIN" ;
	@ElementDefinition
	public String dat_Submission_EffDate="dat_Submission_EffDate" ;
	@ElementDefinition
	public String dat_Submission_ExpDate="dat_Submission_ExpDate" ;
	@ElementDefinition
	public String lst_BusinessSegment="lst_BusinessSegment" ;
	@ElementDefinition
	public String lst_IncumbentCarrier="lst_IncumbentCarrier" ;
	
	@ElementDefinition
	public String lst_PredominantState="lst_PredominantState" ;
	@ElementDefinition
	public String lst_Distribution="lst_Distribution" ;
	@ElementDefinition
	public String lst_UnderwriterName="lst_UnderwriterName" ;
	@ElementDefinition
	public String lst_MarketSegment="lst_MarketSegment" ;
	@ElementDefinition
	public String lst_BranchOffice="lst_BranchOffice" ;
	@ElementDefinition
	public String lst_SubmittedLOB="lst_SubmittedLOB" ;
	@ElementDefinition
	public String btn_NBCreateThisSubmission="btn_NBCreateThisSubmission" ;
	
	@ElementDefinition
	public String get_SubmissionStatusValue="get_SubmissionStatusValue" ;
	
	@ElementDefinition
	public String lst_SubmissionStatus="lst_SubmissionStatus" ;
	
	@ElementDefinition
	public String SubmissionNumber="SubmissionNumber" ;
	
	@ElementDefinition
	public String Accountnumber="Accountnumber" ;
	@ElementDefinition
	public String newBusinessMsg="newBusinessMsg" ;
	
	@ElementDefinition
	public String dat_ReceivedDate="dat_ReceivedDate" ;
	
	@ElementDefinition
	public String txt_PaSubmission="txt_PaSubmission" ;
	
	
	@ElementDefinition
	public String get_FIEN="get_FIEN" ;

	@ElementDefinition
	public String btn_Submission_Email="btn_Submission_Email" ;
	
	@ElementDefinition
	public String btn_NBCopySubmission="btn_NBCopySubmission" ;
	
	@ElementDefinition
	public String tab_NBSubmission="tab_NBSubmission" ;
	
	@ElementDefinition
	public String tab_NBAccount="tab_NBAccount" ;
	
	@ElementDefinition
	public String tab_SubProfile="tab_SubProfile" ;
	
	@ElementDefinition
	public String chk_SubProfileNames="chk_SubProfileNames" ;

	@ElementDefinition
	public String getAccountNumber="getAccountNumber" ;
	@TimeMethod
	@ScreenShot
	public void CreateSubmission_For_NewBusiness(String tcID, SoftAssert softAs,String duplicateFEIN) throws Exception;
	public void Verify_SubmissionStatus_Received(String tcID, SoftAssert softAs,String type) throws Exception;
	public void Verify_SubmissionStatus_Unsubmitted(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_SubmissionStatus_Blocked(String tcID, SoftAssert softAs) throws Exception;
	
	public void Verify_PAUSValues(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_PASubmission_FieldValues(String tcID, SoftAssert softAs,String type) throws Exception;
	public void Verify_RFCYValues(String tcID, SoftAssert softAs) throws Exception;
	public void Vrify_BusinessSubmission_Screen(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_SubStatus_Blocked_For_DupInsuredName(String tcID, SoftAssert softAs) throws Exception;
	
	public void verify_NewBusiness_InDWHDB (String tcID, SoftAssert softAs,String DBServer) throws Exception;

	public void verify_NewBusinessAccount_InDB (String tcID, SoftAssert softAs,String DBServer) throws Exception;
	public void verify_NewBusinessSubmission_InDB (String tcID, SoftAssert softAs,String DBServer) throws Exception;
	public void verify_Business_Customer_DnB_EIN_InDB(String tcID, SoftAssert softAs, String DBServer) throws Exception;
}
