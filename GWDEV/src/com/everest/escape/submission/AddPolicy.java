package com.everest.escape.submission;

import java.util.List;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;


public interface AddPolicy extends Page {
	@ElementDefinition
	public String lst_SubmissionStatus="lst_SubmissionStatus" ;
	@ElementDefinition
	public String txt_PolicyLimit="txt_PolicyLimit" ;
	@ElementDefinition
	public String txt_PolRetentionAttachment="txt_PolRetentionAttachment" ;
	@ElementDefinition
	public String lst_TPA="lst_TPA" ;
	@ElementDefinition
	public String chk_Unbundling="chk_Unbundling" ;
	
	@ElementDefinition
	public String btn_CancelReWritePolicy="btn_CancelReWritePolicy" ;
	
	
	@ElementDefinition
	public String tab_Submission="tab_Submission" ;
	
	@ElementDefinition
	public String lst_SelectedSubmissionLOB="lst_SelectedSubmissionLOB" ;

	public String radio_QuotedPrimary="radio_QuotedPrimary" ;
	
	@ElementDefinition
	public String radio_QuotedExcess="radio_QuotedExcess" ;

	@ElementDefinition
	public String btn_Save="btn_Save" ;
	
	@ElementDefinition
	public String btn_AddPolicy="btn_AddPolicy" ;
	
	@ElementDefinition
	public String msg_AddPolicySuccss="msg_AddPolicySuccss" ;
	
	@ElementDefinition
	public String btn_IssuePolicyNumber="btn_IssuePolicyNumber" ;
	
	@ElementDefinition
	public String PolicyNumber="PolicyNumber" ;
	@ElementDefinition
	public String getPolicyMod="PolicyMod" ;
	
	@ElementDefinition
	public String btn_issueBill="btn_issueBill" ;
	
	@ElementDefinition
	public String msg_issueBillSuccess="msg_issueBillSuccess" ;
	@ElementDefinition
	public String btn_confirmPoliceissue1="btn_confirmPoliceissue1" ;
	@ElementDefinition
	public String btn_confirmPoliceissue2="btn_confirmPoliceissue2" ;
	
	
	@ElementDefinition
	public String lst_PolicyStatus="lst_PolicyStatus" ;
	
	@ElementDefinition
	public String dat_PolicyEffectiveDate="dat_PolicyEffectiveDate" ;
	@ElementDefinition
	public String dat_PolicyExpirationDate="dat_PolicyExpirationDate" ;
	@ElementDefinition
	public String lst_CancelledReasonCode="lst_CancelledReasonCode" ;
	@ElementDefinition
	public String dat_DateBound="dat_DateBound" ;
	@ElementDefinition
	public String txt_PolicyPremium="txt_PolicyPremium" ;
	@ElementDefinition
	public String lst_BoundLineBusiness="lst_BoundLineBusiness" ;
	
	@ElementDefinition
	public String lst_BoundLineBusinessSelected="lst_BoundLineBusinessSelected" ;
	
	
	@ElementDefinition
	public String lst_PropertyPolicyType="lst_PropertyPolicyType" ;
	@ElementDefinition
	public String red_MultiStatePolicy_Yes="red_MultiStatePolicy_Yes" ;
	@ElementDefinition
	public String red_MultiStatePolicy_No="red_MultiStatePolicy_No" ;
	@ElementDefinition
	public String lst_ProductCode="lst_ProductCode" ;   

	@ElementDefinition
	public String lst_BillType="lst_BillType" ;
	@ElementDefinition
	public String lst_PaymentPlan="lst_PaymentPlan" ;
	@ElementDefinition
	public String lst_RenewalStatus="lst_RenewalStatus" ;
	
	@ElementDefinition
	public String lst_CancelState="lst_CancelState" ;
	
	@ElementDefinition
	public String getPolicyNumber="getPolicyNumber" ;
	@ElementDefinition
	public String msg_issuePolicy="msg_issuePolicy" ;
	
	@ElementDefinition
	public String Btn_Invoice="Btn_Invoice" ;
	@ElementDefinition
	public String Btn_PaymentSchedule="Btn_PaymentSchedule" ;
	
	@ElementDefinition
	public String img_ErrorIcon="img_ErrorIcon" ;
	@ElementDefinition
	public String chk_Public="chk_Public" ;
	@ElementDefinition
	public String msg_Error="msg_Error" ;
	@ElementDefinition
	public String chk_Pravite="chk_Pravite" ;
	
	@ElementDefinition
	public String dat_DatePolicyIssued="dat_DatePolicyIssued" ;
	
	@ElementDefinition
	public String rb_PremiumAuditInd_Yes="rb_PremiumAuditInd_Yes" ;
	
	@ElementDefinition
	public String rb_PremiumAuditInd_No="rb_PremiumAuditInd_No" ;
	
	
	@ElementDefinition
	public String tab_Policynumber="tab_Policynumber" ;
	
	@ElementDefinition
	public String rad_PolicyPrimary="rad_PolicyPrimary" ;
	@ElementDefinition
	public String rad_PolicyExcess="rad_PolicyExcess" ;
	@ElementDefinition
	public String txt_Commission="txt_Commission" ;
	@ElementDefinition
	public String txt_NonCommissionableFee="txt_NonCommissionableFee" ;
	
	@ElementDefinition
	public String ExpiringPolicyNo="ExpiringPolicyNo" ;
	@ElementDefinition
	public String ExpiringMod="ExpiringMod" ;
	
	@ElementDefinition
	public String lst_BoundProduct="lst_BoundProduct" ;
	@ElementDefinition
	public String chk_PolPublic="chk_PolPublic" ;
	@ElementDefinition
	public String chk_PolPrivate="chk_PolPrivate" ;
	
	@ElementDefinition
	public String red_Portfolio_No="red_Portfolio_No" ;
	
	@ElementDefinition
	public String red_Portfolio_Yes="red_Portfolio_Yes" ;
	
	
	@ElementDefinition
	public String lst_EverestCompany="lst_EverestCompany" ;
	
	@ElementDefinition
	public String chk_BillIssued="chk_BillIssued" ;
	
	@ElementDefinition
	public String lbl_PolPrivate="lbl_PolPrivate" ;
	
	@ElementDefinition
	public String lbl_PolPublic="lbl_PolPublic" ;
	
	@ElementDefinition
	public String msg_SubmissionSuccessmsg="msg_SubmissionSuccessmsg" ;
	
	@ElementDefinition
	public String lnk_PolicyNum="lnk_PolicyNum" ;
	
	@ElementDefinition
	public String txt_ExplainCancelledReason="txt_ExplainCancelledReason" ;
	
	@ElementDefinition
	public String chk_Policy_FRPurchased="chk_Policy_FRPurchased" ;
	
	@ElementDefinition
	public String chk_PremiumFinanced="chk_PremiumFinanced" ;
	
	@ElementDefinition
	public String txt_FinanceCompanyName="txt_FinanceCompanyName" ;
	@ElementDefinition
	public String txt_FinanceCompanyAddress1="txt_FinanceCompanyAddress1" ;
	@ElementDefinition
	public String txt_FinanceCompanyAddress2="txt_FinanceCompanyAddress2" ;
	@ElementDefinition
	public String txt_FinanceCompanyAddress3="txt_FinanceCompanyAddress3" ;
	@ElementDefinition
	public String txt_FinanceCompanyCity="txt_FinanceCompanyCity" ;
	@ElementDefinition
	public String txt_FinanceCompanyState="txt_FinanceCompanyState" ;
	@ElementDefinition
	public String txt_FinanceCompanyZip2="txt_FinanceCompanyZip2" ;
	@ElementDefinition
	public String txt_FinanceCompanyZip1="txt_FinanceCompanyZip1" ;
	@ElementDefinition
	public String txt_FinanceCompanyContact="txt_FinanceCompanyContact" ;
	
	@ElementDefinition
	public String lst_RenewalStatusCode="lst_RenewalStatusCode" ;
	
	@ElementDefinition
	public String lbl_BSConfirm="lbl_BSConfirm" ;
	@ElementDefinition
	public String lbl_BranchOfficeConfirm="lbl_BranchOfficeConfirm" ;
	@ElementDefinition
	public String lbl_BoundLOBConfirm="lbl_BoundLOBConfirm" ;
	@ElementDefinition
	public String lbl_PolicyEffDteConfirm="lbl_PolicyEffDteConfirm" ;
	
	@ElementDefinition
	public String btn_Policy_Close="btn_Policy_Close" ;
	
	@ElementDefinition
	public String btn_ReviseBill="btn_ReviseBill" ;
	
	@ElementDefinition
	public String txt_ScheduleRatingMod="txt_ScheduleRatingMod" ;
	@ElementDefinition
	public String txt_ExperienceMod="txt_ExperienceMod" ;
	@ElementDefinition
	public String chk_InstallmentFees="chk_InstallmentFees" ;
	
	@ElementDefinition




	public String lst_SelectedEverestCompany="lst_SelectedEverestCompany" ;
	@ElementDefinition
	public String lbl_RNConfirm1="lbl_RNConfirm1" ;
	@ElementDefinition
	public String lbl_RNConfirm2="lbl_RNConfirm2" ;
	@ElementDefinition
	public String tab_BoundProfileHeader="tab_BoundProfileHeader" ;
	@ElementDefinition
	public String chk_BoundProfile="chk_BoundProfile" ;
	@ElementDefinition
	public String lst_CancelledReasonCodeSelected="lst_CancelledReasonCodeSelected" ;
	@ElementDefinition
	public String lst_PolicyStatusSelected="lst_PolicyStatusSelected" ;
	@ElementDefinition
	public String txt_CancelReWritePolicyErrmsg="txt_CancelReWritePolicyErrmsg" ;
	
	
	@ElementDefinition
	public String lst_PaymentPlanSelected="lst_PaymentPlanSelected" ;
	@ElementDefinition
	public String lst_BillTypeSelected="lst_BillTypeSelected" ;
	@ElementDefinition
	public String lst_ProductCodeSelected="lst_ProductCodeSelected" ;
	@ElementDefinition
	public String lst_CancelStateSelected="lst_CancelStateSelected" ;
	@ElementDefinition
	public String lst_TPASelected="lst_TPASelected" ;
	@ElementDefinition
	public String btn_Send_PolicyNo_ToPD="btn_Send_PolicyNo_ToPD" ;
	@ElementDefinition
	public String lnk_PolicyNumber="lnk_PolicyNumber" ;
	
	@ElementDefinition
	public String lnk_SearchBar="lnk_SearchBar" ;
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	@TimeMethod
	@ScreenShot

	
	public void IssueNewPolicy(String tcID, SoftAssert softAs) throws Exception;
	public void VerifyBillingPage(String tcID, SoftAssert softAs) throws Exception;
	public void VerifyRenewalPolicyEffDate(String tcID, SoftAssert softAs) throws Exception;
	public void RenewalPolicy(String tcID, SoftAssert softAs) throws Exception;
	public void verify_errormsg_afterclk_CanReWrte_BeforeBookPolicy (String tcID, SoftAssert softAssert) throws Exception;
	public void Check_Invoice_Downloaded(String tcID, SoftAssert softAs,String Driver,String DownloadType) throws Exception;
	public void Vrify_BusinessIndicator_CarryForward(String tcID, SoftAssert softAs) throws Exception;
	public void Vrify_Policy_ScreenDetails(String tcID, SoftAssert softAs) throws Exception;
	public void clkAddPolicy(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_BillType_Changes(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_RenewalPolicy_Status(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_DefaultTPA(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_Active_TPAvalues(String tcID, SoftAssert softAs,List<String> ActiveTPA) throws Exception;
	public void Verify_ExpairePolicyNum_Retained(String tcID, SoftAssert softAs) throws Exception;
	public void Check_BusinessIndicator_Status_InPolicyScreen(String tcID, SoftAssert softAs) throws Exception;
	public void OpenPolicySearchResult(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_Policy_ReadOnly_Fields(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_ChkInstallFee_DefaultValue(String tcID,SoftAssert softAS) throws Exception;
	public void Verify_ColInstallFee_BillInstalment(String tcID,SoftAssert softAS,String PaymentType) throws Exception;
	public void Verify_RenewalPolicy_Stataus(String tcID,SoftAssert softAS) throws Exception;
	
	public void Verify_Column_TaxesFees_and_Surcharges(String tcID,SoftAssert softAS,String PaymentType) throws Exception;
	public void Verify_Wording_Bills_InstallmentSchedule(String tcID,SoftAssert softAS,String PaymentType) throws Exception;
	public void Verify_GateKeeper_Editable_PolicyEffDate(String tcID,SoftAssert softAS) throws Exception;
	public void Verify_Otherthen_GateKeeperUser_Editable_PolicyEffDate(String tcID,SoftAssert softAS) throws Exception;
	
	public void verify_PaymentPlan_editable_After_AddPayment(String tcID,SoftAssert softAS,String transType) throws Exception;
	public void verify_PaymentPlan_CarryForward_Renewal(String tcID,SoftAssert softAS) throws Exception;
	public void verify_AdminUser_Edit_EffDate(String tcID,SoftAssert softAS) throws Exception;
	public void verify_PaymentPlan_MakeSelection(String tcID,SoftAssert softAS,String transType) throws Exception;
	public void verify_PaymentPlan_editable_Before_AddPayment(String tcID,SoftAssert softAS,String transType) throws Exception;
	public void verify_PolicyScreen_BeforeEnterDetails(String tcID,SoftAssert softAS) throws Exception;

	//public void verify_PolicyNumberSchematic(String tcID,SoftAssert softAS) throws Exception;
	public void verify_RenewalPolicyScreen_BeforeEnterDetails(String tcID,SoftAssert softAS) throws Exception;
	public void verify_RenewalPolicyNumberFormat(String tcID, SoftAssert softAS, String format,String policyNumber) throws Exception;
	
	public void verify_PolicyNumberFormat(String tcID,SoftAssert softAS, String format,String policyNumber) throws Exception;
	public void remove_BoundProfiles(String tcID,SoftAssert softAS) throws Exception;
	public void verify_PolicyNumberFieldEnable(String tcID, SoftAssert softAs) throws Exception;
	
	public void verify_PolicyCreatred_Automatically_AfterBindProcess(String tcID, SoftAssert softAS,String type) throws Exception;
	public void clk_CancelReWritePolicy (String tcID, SoftAssert softAssert) throws Exception;
	public void Verify_OriginalRenpolicy_Voided_Cancelreason_ReWrite (String tcID, SoftAssert softAssert) throws Exception;
	public void verify_CancReWritePolicy_button_Available(String tcID, SoftAssert softAS) throws Exception;
	public void verify_NoButton_Policy_ToPD_Available (String tcID, SoftAssert softAssert) throws Exception;
	public void verify_RenewalPolicy_Version (String tcID, SoftAssert softAssert,String RENVertion) throws Exception;
	public void verify_UMPoloicyDetails_inEscape(String tcID, SoftAssert softAssert) throws Exception;

}

