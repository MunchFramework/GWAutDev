

package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmIssuancePage extends Page{

	@ElementDefinition
	public String btnSendProposal = "btnSendProposal";
	@ElementDefinition
	public String btnYes = "btnYes";
	
	@ElementDefinition
	public String lnk_ExpandPolicy = "lnk_ExpandPolicy";
	
	
	@ElementDefinition
	public String btn_yes_custom = "btn_yes_custom";
	@ElementDefinition
	public String btnOK = "btnOK";
	@ElementDefinition
	public String btnSubmitIssuance = "btnSubmitIssuance";
	@ElementDefinition
	public String btnMarkAsIssued = "btnMarkAsIssued";

	@ElementDefinition
	public String btnPolicyPage = "btnPolicyPage";
	@ElementDefinition
	public String txtPolicyNumber = "txtPolicyNumber";
	@ElementDefinition
	public String lnkPolicyIssuance = "lnkPolicyIssuance";
	@ElementDefinition
	public String lnkArrow = "lnkArrow";
	@ElementDefinition
	public String	btnSendEmail = "btnSendEmail";
	@ElementDefinition
	public String txtSendEmail= "txtSendEmail";
	@ElementDefinition
	public String lnkArrow1 = "lnkArrow1";
	@ElementDefinition
	public String lnkArrow2 = "lnkArrow2";
	@ElementDefinition
	public String lnkArrow3 = "lnkArrow3";
	@ElementDefinition
	public String lnkArrow4 = "lnkArrow4";
	@ElementDefinition
	public String lnkArrow5 = "lnkArrow5";
	@ElementDefinition
	public String lnkArrow6 = "lnkArrow6";
	@ElementDefinition
	public String lnkArrow7 = "lnkArrow7";
	@ElementDefinition
	public String lnkArrow8 = "lnkArrow8";
	@ElementDefinition
	public String lnkArrow9 = "lnkArrow9";
	@ElementDefinition
	public String lnkArrow10 = "lnkArrow10";
	@ElementDefinition
	public String lnkArrow11 = "lnkArrow11";
	@ElementDefinition
	public String lnkArrow12 = "lnkArrow12";
	
	@ElementDefinition
	public String btnPolicyPage1 = "btnPolicyPage1";
	@ElementDefinition
	public String btnPolicyPage2 = "btnPolicyPage2";
	@ElementDefinition
	public String btnPolicyPage3 = "btnPolicyPage3";	
	@ElementDefinition
	public String btnPolicyPage4 = "btnPolicyPage4";
	@ElementDefinition
	public String btnPolicyPage5 = "btnPolicyPage5";	
	@ElementDefinition
	public String btnPolicyPage6 = "btnPolicyPage6";
	@ElementDefinition
	public String btnPolicyPage7 = "btnPolicyPage7";
	@ElementDefinition
	public String btnPolicyPage8 = "btnPolicyPage8";
	@ElementDefinition
	public String btnPolicyPage9 = "btnPolicyPage9";
	@ElementDefinition
	public String btnPolicyPage10 = "btnPolicyPage10";
	@ElementDefinition
	public String btnPolicyPage11 = "btnPolicyPage11";
	@ElementDefinition
	public String btnPolicyPage12 = "btnPolicyPage12";
	@ElementDefinition
	public String btnPolicyPage13 = "btnPolicyPage13";
	@ElementDefinition
	public String btnACF = "btnACF";
	@ElementDefinition
	public String btnCRD = "btnCRD";
	@ElementDefinition
	public String btnPRO = "btnPRO";
	@ElementDefinition
	public String btnENO = "btnENO";
	@ElementDefinition
	public String btnPRE = "btnPRE";
	@ElementDefinition
	public String btnPRL = "btnPRL";
	@ElementDefinition
	public String btnPRN = "btnPRN";
	@ElementDefinition
	public String btnREP = "btnREP";
	@ElementDefinition
	public String btnTAX = "btnTAX";
	@ElementDefinition
	public String btnSUR = "btnSUR";
	@ElementDefinition
	public String Error_OK = "Error_OK";
	@ElementDefinition
	public String	 email_txtbox= "email_txtbox";
	@ElementDefinition
	public String email_icon= "email_icon";
	@ElementDefinition
	public String Close_emailid= "Close_emailid";
	@ElementDefinition
	public String correct_emailid= "correct_emailid";
	@ElementDefinition
	public String UW_emailid= "UW_emailid";
	@ElementDefinition
	public String Wrong_emailid = "Wrong_emailid";
	@ElementDefinition
	public String lnkArrow_PC8E= "lnkArrow_PC8E";
	@ElementDefinition
	public String btnPolicyPage_PC8E= "btnPolicyPage_PC8E";
	@ElementDefinition
	public String CollaborationIcon= "CollaborationIcon";
	@ElementDefinition
	public String FilesIcon= "FilesIcon";
	@ElementDefinition
	public String LnkPolicyDoc= "LnkPolicyDoc";
	@ElementDefinition
	public String LnkSenProposal= "LnkSenProposal";
	@ElementDefinition
	public String LnkBillingInvoiceDoc ="LnkBillingInvoiceDoc";
	@ElementDefinition
	public String LnkBillingInvoiceDoc_Slim ="LnkBillingInvoiceDoc_Slim";
	
	
	@TimeMethod
	@ScreenShot
	public void UmIssuance(String tcID, SoftAssert softAs) throws Exception;
	public void getUMPolicy(String tcID, SoftAssert softAssert) throws Exception; 
	public void BillingInvoice_WriteDetails(String tcID, SoftAssert softAs) throws Exception;
	public void BillingInvoice_Validation(String tcID, SoftAssert softAs) throws Exception;
	public void UM_DownloadPolicyDoc(String tcID, SoftAssert softAssert) throws Exception;
	

}


