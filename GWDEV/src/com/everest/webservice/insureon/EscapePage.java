package com.everest.webservice.insureon;

import java.util.List;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface EscapePage extends Page {
	
	@ElementDefinition
	public String lnk_certificate="lnk_certificate" ;
	@ElementDefinition
	public String txt_UserNameESC="txt_UserNameESC" ;
	@ElementDefinition
	public String txt_PasswordESC="txt_PasswordESC" ;
	@ElementDefinition
	public String txt_EscInsuredName="txt_EscInsuredName" ;
	@ElementDefinition
	public String btn_LoginESC="btn_LoginESC";
	@ElementDefinition
	public String btn_Search="btn_Search" ;
	@ElementDefinition
	public String txt_FEINNumber="txt_FEINNumber" ;
	@ElementDefinition
	public String lnk_AccountNum="lnk_AccountNum" ;
	
	@ElementDefinition
	public String txt_Fname="txt_Fname" ;
	@ElementDefinition
	public String txt_PrimaryFEIN="txt_PrimaryFEIN" ;
	@ElementDefinition
	public String txt_MailingStreetAddress="txt_MailingStreetAddress" ;
	@ElementDefinition
	public String txt_MailingCity="txt_MailingCity" ;
	@ElementDefinition
	public String txt_MailingState="txt_MailingState" ;
	@ElementDefinition
	public String txt_MailingZipcode="txt_MailingZipcode" ;
	
	@ElementDefinition
	public String lbl_SubmissionStatus="lbl_SubmissionStatus" ;
	@ElementDefinition
	public String lst_TradeNames="lst_TradeNames" ;
	@ElementDefinition
	public String lbl_SubmissionNum="lbl_SubmissionNum" ;
	@ElementDefinition
	public String lbl_StatusEverlink="lbl_StatusEverlink" ;
	@ElementDefinition
	public String lnk_SubmissionNum="lnk_SubmissionNum" ;
	@ElementDefinition
	public String txt_QuoteDate="txt_QuoteDate" ;
	@ElementDefinition
	public String lbl_PolicyPremium="lbl_PolicyPremium" ;
	@ElementDefinition
	public String lbl_NAICSCode="lbl_NAICSCode" ;
	@ElementDefinition
	public String lbl_SubmsnExpMod="lbl_SubmsnExpMod" ;
	
	@ElementDefinition
	public String lnk_PolicyNumber="lnk_PolicyNumber" ;
	
	@ElementDefinition
	public String lbl_BoundDate="lbl_BoundDate" ;
	
	@ElementDefinition
	public String lbl_Commission="lbl_Commission" ;
	
	@ElementDefinition
	public String lbl_BillType="lbl_BillType" ;
	@ElementDefinition
	public String lbl_PaymentPlan="lbl_PaymentPlan" ;
	
	@ElementDefinition
	public String lnk_SubmissionNum1="lnk_SubmissionNum1" ;
	
	@ElementDefinition
	public String lst_SubmissionReasonCode="lst_SubmissionReasonCode" ;
	
	@ElementDefinition
	public String lbl_Status="lbl_Status" ;
	
	@ElementDefinition
	public String lbl_PredominantState="lbl_PredominantState" ;
	
	@ElementDefinition
	public String txt_ExplainSubmissionStatus="txt_ExplainSubmissionStatus" ;
	
	
	@ElementDefinition
	public String lnk_EdgeCertificate="lnk_EdgeCertificate" ;
	
	@ElementDefinition
	public String lnk_Block="lnk_Block" ;
	
	@ElementDefinition
	public String txt_BusinessSegment="txt_BusinessSegment" ;
	
	@ElementDefinition
	public String txt_BranchOffice="txt_BranchOffice" ;
	
	@ElementDefinition
	public String txt_MarketSegment="txt_MarketSegment" ;
	@ElementDefinition
	public String txt_SubmissionType="txt_SubmissionType" ;
	@ElementDefinition
	public String txt_SubmissionEffectiveDate="txt_SubmissionEffectiveDate" ;
	
	@ElementDefinition
	public String txt_SubmissionExpirationDate="txt_SubmissionExpirationDate" ;
	
	@ElementDefinition
	public String txt_IncumbentCarrier="txt_IncumbentCarrier" ;
	
	@ElementDefinition
	public String txt_ProducerName="txt_ProducerName" ;
	
	@ElementDefinition
	public String txt_SubmittedLOB="txt_SubmittedLOB" ;
	
	@ElementDefinition
	public String txt_ProducerOffice="txt_ProducerOffice" ;
	@ElementDefinition
	public String txt_UnderwriterName="txt_UnderwriterName" ;
	@ElementDefinition
	public String txt_UnderwriterAssistant="txt_UnderwriterAssistant" ;
	@ElementDefinition
	public String txt_InsuringCompanyId="txt_InsuringCompanyId" ;
	
	@ElementDefinition
	public String txt_QuotedLOB="txt_QuotedLOB" ;
	
	@ElementDefinition
	public String txt_ScheduleModRate="txt_ScheduleModRate" ;
	
	@ElementDefinition
	public String txt_PolicyEffectiveDate="txt_PolicyEffectiveDate" ;
	@ElementDefinition
	public String txt_PolicyStatus="txt_PolicyStatus" ;
	@ElementDefinition
	public String txt_PolicyPremium="txt_PolicyPremium" ;
	@ElementDefinition
	public String txt_PolicyCommission="txt_PolicyCommission" ;
	@ElementDefinition
	public String txt_ProductCode="txt_ProductCode" ;
	
	@ElementDefinition
	public String txt_SubmissionNumSearch="txt_SubmissionNumSearch" ;
	
	
	
	
	
	
	
	
	
	@TimeMethod
	@ScreenShot
	public void verifyAccountDetailsInEscape(String tcID, SoftAssert softAs,String DeviceName,String ExpectedSubStstus,List<Boolean> list) throws Exception;
	
	/****phase 2 EPRO-31928******/
	public void verifySubmissionStatusReasonInEscape(String tcID, SoftAssert softAssert,String DeviceName,String ExpectedStatus) throws Exception;
	public void closeScreenshots(String tcID, SoftAssert softAssert) throws Exception ;

	
}
