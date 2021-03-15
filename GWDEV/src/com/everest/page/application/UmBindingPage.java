package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmBindingPage extends Page{

	
	@ElementDefinition
	public String Instalmnt_Amt = "Instalmnt_Amt";
	@ElementDefinition
	public String Paymnt_Eff = "Paymnt_Eff";
	@ElementDefinition
	public String Paymnt_Exp = "Paymnt_Exp";
	@ElementDefinition
	public String Paymnt_Due = "Paymnt_Due";
	@ElementDefinition
	public String lbl_CYB1ed = "lbl_CYB1ed";
	@ElementDefinition
	public String lbl_CYB3ed = "lbl_CYB3ed";
	
	@ElementDefinition
	public String btnYes = "btnYes";
	@ElementDefinition
	public String btnBeginBinding = "btnBeginBinding";
	@ElementDefinition
	public String btnBeginBinding2 = "btnBeginBinding2";
	
	@ElementDefinition
	public String totalPremium = "totalPremium";
	@ElementDefinition
	public String BindFXRate = "BindFXRate";
	@ElementDefinition
	public String usdPremium = "usdPremium";
	@ElementDefinition
	public String policyCurrency = "policyCurrency";
	
	@ElementDefinition
	public String btnPaymentPlan = "btnPaymentPlan";
	@ElementDefinition
	public String txtPaymentPlan = "txtPaymentPlan";
	@ElementDefinition
	public String chkDirectBill = "chkDirectBill";
	@ElementDefinition
	public String btnGenerateBinder = "btnGenerateBinder";
	@ElementDefinition
	public String btnBind = "btnBind";
	@ElementDefinition
	public String btnBind2 = "btnBind2";
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
	public String btnAction = "btnAction";
	@ElementDefinition
	public String btnFinalizeQuote = "btnFinalizeQuote";
	
	@ElementDefinition
	public String lnkExpQuote1 = "lnkExpQuote1";
	@ElementDefinition
	public String btnFinalizeBinder = "btnFinalizeBinder";
	@ElementDefinition
	public String btnSendBinder = "btnSendBinder";
	@ElementDefinition
	public String btnSend = "btnSend";
	
	@ElementDefinition
	public String lnkArrowProposal= "lnkArrowProposal";
	@ElementDefinition
	public String lnkEditDocument= "lnkEditDocument";
	@ElementDefinition
	public String lnkFinalizePolicyDocuments= "lnkFinalizePolicyDocuments";
	@ElementDefinition
	public String lnkExpQuote2 = "lnkExpQuote2";
	
	@ElementDefinition
	public String lnkExpQuote3 = "lnkExpQuote3";
	@ElementDefinition
	public String	btnSendEmail = "btnSendEmail";
	@ElementDefinition
	public String txtSendEmail= "txtSendEmail";
	@ElementDefinition
	public String lnkExpQuote4 = "lnkExpQuote4";
	@ElementDefinition
	public String lnkExpQuote5 = "lnkExpQuote5";
	@ElementDefinition
	public String txtSublimitCoverageRecognitionEndorsement = "txtSublimitCoverageRecognitionEndorsement";
	@ElementDefinition
	public String btnFormsFillIn = "btnFormsFillIn"; 
	@ElementDefinition
	public String btnProposal1Arrow = "btnProposal1Arrow";
	@ElementDefinition
	public String btnProposal1Arrow2 = "btnProposal1Arrow2";
	@ElementDefinition
	public String txtSuretyPolicyNo = "txtSuretyPolicyNo";
	@ElementDefinition
	public String txtIssueDate = "txtIssueDate";
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
	public String rd_AgencyType= "rd_AgencyType";
	@ElementDefinition
	public String rd_DirectType= "rd_DirectType";
	@ElementDefinition
	public String btnConfirm= "btnConfirm";

	@ElementDefinition
	public String CollaborationIcon= "CollaborationIcon";
	@ElementDefinition
	public String FilesIcon= "FilesIcon";
	@ElementDefinition
	public String LnkBinderDoc= "LnkBinderDoc";
	
	@ElementDefinition
	public String lnkProposal= "lnkProposal";	
	@ElementDefinition
	public String txtQuoteDesForProp2= "txtQuoteDesForProp2";
	@ElementDefinition
	public String txtQuoteDesForProp1= "txtQuoteDesForProp1";
	@ElementDefinition
	public String txtConPolicyNo= "txtConPolicyNo";
	@ElementDefinition
	public String txtRepPolicyNo= "txtRepPolicyNo";
	
	
	@TimeMethod
	@ScreenShot
	public void UmBinding(String tcID, SoftAssert softAs) throws Exception;
	public void UmBindPremium(String tcID, SoftAssert softAs) throws Exception;
	public void UM_DownloadBinder(String tcID, SoftAssert softAs) throws Exception;
	public void verifyCovUpdatedForProposal(String tcID, SoftAssert softAssert);

}

