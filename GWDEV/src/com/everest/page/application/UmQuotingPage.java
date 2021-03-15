package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmQuotingPage extends Page {
	
	@ElementDefinition
	public String LoadingBar= "LoadingBar";
	@ElementDefinition
	public String SRMTotal_Error= "SRMTotal_Error";
	@ElementDefinition
	public String Quoting_Link= "Quoting_Link";
	@ElementDefinition
	public String WritingComp_Dropdown= "WritingComp_Dropdown";
	@ElementDefinition
	public String Search_Field= "Search_Field";
	@ElementDefinition
	public String Search_Result_WC= "Search_Result_WC";
	@ElementDefinition
	public String Quoting_link= "Quoting_link";
	@ElementDefinition
	public String Indication_chkbx= "Indication_chkbx";
	@ElementDefinition
	public String NonBinding_Email= "NonBinding_Email";
	
	@ElementDefinition
	public String drpdwn_NYFT = "drpdwn_NYFT";
	@ElementDefinition
	public String drpdwn_Code = "drpdwn_Code";
	@ElementDefinition
	public String Label_SelectedPolicyForms= "Label_SelectedPolicyForms";

	@ElementDefinition
	public String btnGetRate = "btnGetRate";
	@ElementDefinition
	public String btnConvertQuote = "btnConvertQuote";
	@ElementDefinition
	public String btnNYFTZClass = "btnNYFTZClass";
	@ElementDefinition
	public String txtNYFTZClass = "txtNYFTZClass";
	@ElementDefinition
	public String  btnNYFTZCode= "btnNYFTZCode";
	@ElementDefinition
	public String txtNYFTZCode = "txtNYFTZCode";
	@ElementDefinition
	public String btnGenerateQuote = "btnGenerateQuote";
	@ElementDefinition
	public String btnSendProposal = "btnSendProposal";
	@ElementDefinition
	public String btnYes = "btnYes";
	
	@ElementDefinition
	public String msg_AccountReAssigment = "msg_AccountReAssigment";
	
	
	@ElementDefinition
	public String btnAction = "btnAction";
	@ElementDefinition
	public String btnFinalizeQuote = "btnFinalizeQuote";
	@ElementDefinition
	public String btnOK = "btnOK";
	@ElementDefinition
	public String btn_yes_custom = "btn_yes_custom";
	@ElementDefinition
	public String	btnSendEmail = "btnSendEmail";
	@ElementDefinition
	public String txtSendEmail= "txtSendEmail";
	@ElementDefinition
	public String	btnUpdateCoverages = "btnUpdateCoverages";
	@ElementDefinition
	public String	Error_OK = "Error_OK";
	@ElementDefinition
	public String	 email_txtbox= "email_txtbox";
	@ElementDefinition
	public String email_icon= "email_icon";
	@ElementDefinition
	public String UW_emailid= "UW_emailid";
	@ElementDefinition
	public String Wrong_emailid = "Wrong_emailid";
	@ElementDefinition
	public String Close_emailid= "Close_emailid";
	@ElementDefinition
	public String correct_emailid= "correct_emailid";
	@ElementDefinition
	public String lblSubmissionNo= "lblSubmissionNo";
	@ElementDefinition
	public String txtStreet1= "txtStreet1";
	@ElementDefinition
	public String btnCreateProposal= "btnCreateProposal";
	@ElementDefinition
	public String btnCopySubmission= "btnCopySubmission";
	@ElementDefinition
	public String btnCopy= "btnCopy";
	@ElementDefinition
	public String btnCopyApplicationOnly= "btnCopyApplicationOnly";
	@ElementDefinition
	public String btnCreateQuote= "btnCreateQuote";
	@ElementDefinition
	public String txtMultiQuoteErrorMsg= "txtMultiQuoteErrorMsg";
	@ElementDefinition
	public String btnConfirmGetRate= "btnConfirmGetRate";
	@ElementDefinition
	public String btnGenProposalDisabled= "btnGenProposalDisabled";
	@ElementDefinition
	public String txtFormsName= "txtFormsName";
	@ElementDefinition
	public String txtWorksheetArribute= "txtWorksheetArribute";	
	@ElementDefinition
	public String CollaborationIcon= "CollaborationIcon";
	@ElementDefinition
	public String FilesIcon= "FilesIcon";
	@ElementDefinition
	public String LnkProposalDoc= "LnkProposalDoc";
	
	@ElementDefinition
	public String txtWorksheetArribute1= "txtWorksheetArribute1";	
	@ElementDefinition
	public String txtWorksheetArribute2= "txtWorksheetArribute2";	
	@ElementDefinition
	public String txtWorksheetCurrentFYE= "txtWorksheetCurrentFYE";	
	@ElementDefinition
	public String txtWorksheetPriorFYE= "txtWorksheetPriorFYE";	
	@ElementDefinition
	public String lnkWorksheets= "lnkWorksheets";	
	@ElementDefinition
	public String lnkUnderwrittingWS= "lnkUnderwrittingWS";	
	
	@ElementDefinition
	public String btnPolicyForms= "btnPolicyForms";	
	
	@ElementDefinition
	public String btnCopyCreateQuote= "btnCopyCreateQuote";	
	
	@ElementDefinition
	public String chk_checkBoxNotSel= "chk_checkBoxNotSel";
	@ElementDefinition
	public String chk_verificationCheckBox= "chk_verificationCheckBox";
	@ElementDefinition
	public String dd_writtingApproah= "dd_writtingApproah";
	@ElementDefinition
	public String txt_Justification= "txt_Justification";
	@ElementDefinition
	public String lnk_SubInfo= "lnk_SubInfo";
	@ElementDefinition
	public String SelWrittingApproach= "SelWrittingApproach";
	@ElementDefinition
	public String lblErrorText= "lblErrorText";	
	@ElementDefinition
	public String btnPremiumSummary = "btnPremiumSummary";
	@ElementDefinition
	public String txtCrimeSubTotal = "txtCrimeSubTotal";
	@ElementDefinition
	public String btnRatingCRI = "btnRatingCRI";
	@ElementDefinition
	public String txtCrimePremium = "txtCrimePremium";

	@TimeMethod
	@ScreenShot
	public void UmQuoting(String tcID, SoftAssert softAs) throws Exception;
	public void UmGetRate(String tcID, SoftAssert softAs) throws Exception;
	public void UmGenQuote(String tcID, SoftAssert softAs) throws Exception;
	public void UM_ConvertQuote(String tcID, SoftAssert softAssert) throws Exception;
	public void UMFinalizeProposal(String tcID, SoftAssert softAssert) throws Exception ;
	public void UMSendProposal(String tcID, SoftAssert softAssert) throws Exception ;
	public void verify_UMAccountReAssignment_ErrorPopup(String tcID, SoftAssert softAssert) throws Exception;
	public void UM_GenerateProposal(String tcID, SoftAssert softAssert) throws Exception;
	public void UmCreateProposal(String tcID, SoftAssert softAs) throws Exception;
	public void UmCopySubmission(String tcID, SoftAssert softAs, String CopySubType) throws Exception;
	public void UmConvertToQuote(String tcID, SoftAssert softAs) throws Exception;
	public void UmWorkSheetEditVerify(String tcID, SoftAssert softAs) throws Exception;	
	public void UmCreateQuote(String tcID, SoftAssert softAs) throws Exception;
	public void VerifyForms(String tcID, SoftAssert softAs) throws Exception;
	public void UM_DownloadProposal(String tcID, SoftAssert softAssert) throws Exception;
	public void UmCopyCreateQuote(String tcID, SoftAssert softAssert,String QuoteType) throws Exception;
	public void VerifyWrittingApproach(String tcID, SoftAssert softAssert) throws Exception;
	public void verifyErrorForLPLClaimExpenses(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_SRMTotalError(String tcID, SoftAssert softAs) throws Exception;

	
	
}
