package com.everest.escape.submission;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface NewSubmission extends Page {
	
	@ElementDefinition
	public String txt_NAICSCode="txt_NAICSCode" ;
	
	@ElementDefinition
	public String lst_BusinessSegment="lst_BusinessSegment" ;
	
	@ElementDefinition
	public String lst_SelectedBusinessSegment="lst_SelectedBusinessSegment" ;
	@ElementDefinition
	public String lst_PredominantStateSelected="lst_PredominantStateSelected" ;
	@ElementDefinition
	public String lst_QuotedLineBusinessSelected="lst_QuotedLineBusinessSelected" ;
	@ElementDefinition
	public String lst_QuotedSubmittedProduct="lst_QuotedSubmittedProduct" ;
	@ElementDefinition
	public String lst_BranchOffice="lst_BranchOffice" ;
	@ElementDefinition
	public String lst_SubmissionStatus="lst_SubmissionStatus" ;
	@ElementDefinition
	public String lst_SubmissionType="lst_SubmissionType" ;
	@ElementDefinition
	public String lst_PredominantState="lst_PredominantState" ;
	@ElementDefinition
	public String lst_marketSegment="lst_marketSegment" ;
	@ElementDefinition
	public String dat_ReceivedDate="dat_ReceivedDate" ;
	@ElementDefinition
	public String lst_Distribution="lst_Distribution" ;
	@ElementDefinition
	public String dat_SubmissionEffectiveDate="dat_SubmissionEffectiveDate" ;
	@ElementDefinition
	public String dat_SubmissionExpaireDate="dat_SubmissionExpaireDate" ;
	@ElementDefinition
	public String get_SubmissionStatusValue="get_SubmissionStatusValue" ;
	@ElementDefinition
	public String lst_BranchOfficeSelected="lst_BranchOfficeSelected" ;
	
	
	
	@ElementDefinition
	public String lst_IncumbentCarrier="lst_IncumbentCarrier" ;
	@ElementDefinition
	public String lst_SubmissionLOB="lst_SubmissionLOB" ;
	@ElementDefinition
	public String lst_Producername="lst_Producername" ;
	@ElementDefinition
	public String lst_ProducerOffice="lst_ProducerOffice" ;
	@ElementDefinition
	public String lst_SubProducer="lst_SubProducer" ;
	
	
	@ElementDefinition
	public String radio_Primary="radio_Primary" ;
	@ElementDefinition
	public String radio_Excess="radio_Excess" ;
	@ElementDefinition
	public String lst_SubmittedProduct="lst_SubmittedProduct" ;
	@ElementDefinition
	public String chk_Public="chk_Public" ;
	
	@ElementDefinition
	public String lbl_chkprivate="lbl_chkprivate" ;
	
	@ElementDefinition
	public String lbl_chkPublic="lbl_chkPublic" ;
	@ElementDefinition
	public String lst_UWNameSelected="lst_UWNameSelected" ;
	
	
	@ElementDefinition
	public String chk_Pravite="chk_Pravite" ;
	@ElementDefinition
	public String lst_UWName="lst_UWName" ;
	
	@ElementDefinition
	public String lst_UWAssistant="lst_UWAssistant" ;
	
	@ElementDefinition
	public String lst_UWAssistantSelected="lst_UWAssistantSelected" ;
	
	@ElementDefinition
	public String txt_EstimatedPremium="txt_EstimatedPremium" ;
	@ElementDefinition
	public String lst_EverestCompany="lst_EverestCompany" ;
	@ElementDefinition
	public String btn_CreateThisSubmission="btn_CreateThisSubmission" ;
	
	@ElementDefinition
	public String msg_SubmissionSuccessmsg="msg_SubmissionSuccessmsg" ;
	
	@ElementDefinition
	public String getSubmissionNumber="getSubmissionNumber" ;
	
	@ElementDefinition
	public String btn_CopySubmission="btn_CopySubmission" ;
	@ElementDefinition
	public String lnk_SubmissionNum="lnk_SubmissionNum" ;
	
	@ElementDefinition
	public String tab_CopySubmission="tab_CopySubmission" ;
	
	@ElementDefinition
	public String btn_ProcessNextYearRenewal="btn_ProcessNextYearRenewal" ;
	
	@ElementDefinition
	public String btn_OFACSearchProcessRenewal="btn_OFACSearchProcessRenewal" ;

	@ElementDefinition
	public String btn_OFACSearch="btn_OFACSearch" ;
	@ElementDefinition
	public String msg_SubmissionRenewal="msg_SubmissionRenewal" ;
	
	@ElementDefinition
	public String tab_TabSubmission="tab_TabSubmission" ;
	
	@ElementDefinition
	public String msg_Error="msg_Error" ;
	@ElementDefinition
	public String img_ErrorIcon="img_ErrorIcon" ;
	
	@ElementDefinition
	public String btn_Save="btn_Save" ;
	
	@ElementDefinition
	public String txt_SubDescription="txt_SubDescription" ;
	@ElementDefinition
	public String getSubmissionNumber2="getSubmissionNumber2" ;
	
	@ElementDefinition
	public String getMarketSegmentValue="getMarketSegmentValue" ;
	
	@ElementDefinition
	public String getRenewalSubmissionNumber="getRenewalSubmissionNumber" ;
	
	@ElementDefinition
	public String txt_Comment="txt_Comment" ;
	
	@ElementDefinition
	public String dat_DateQuoted="dat_DateQuoted" ;
	
	@ElementDefinition
	public String txt_QuotedPremium="txt_QuotedPremium" ;
	
	@ElementDefinition
	public String lst_QuotedLineBusiness="lst_QuotedLineBusiness" ;
	
	@ElementDefinition
	public String txt_NaicsCode="txt_NaicsCode" ;
	
	@ElementDefinition
	public String chk_SubmittedProfile="chk_SubmittedProfile" ;
	
	@ElementDefinition
	public String tab_SubmittedProfile="tab_SubmittedProfile" ;
	
	@ElementDefinition
	public String txt_Sublimit="txt_Sublimit" ;
	@ElementDefinition
	public String txt_SubRetention="txt_SubRetention" ;
	@ElementDefinition
	public String txt_SubPremium="txt_SubPremium" ;
	@ElementDefinition
	public String lbl_SublinesStatus="lbl_SublinesStatus" ;
	
	@ElementDefinition
	public String btn_NAICSCodeSearch="btn_NAICSCodeSearch" ;
	
	@ElementDefinition
	public String chk_ProspectForNextYear="chk_ProspectForNextYear" ;
	
	@ElementDefinition
	public String btn_WorkOnProspect="btn_WorkOnProspect" ;
	
	@ElementDefinition
	public String tab_QuotedProfileHeader="tab_QuotedProfileHeader";
	
	@ElementDefinition
	public String lst_SubResonCode="lst_SubResonCode" ;
	
	@ElementDefinition
	public String chk_QuotedProfile="chk_QuotedProfile" ;
	
	@ElementDefinition
	public String txt_QuotedSublimit="txt_QuotedSublimit" ;
	@ElementDefinition
	public String txt_QuotedSubRetention="txt_QuotedSubRetention" ;
	@ElementDefinition
	public String txt_QuotedSubPremium="txt_QuotedSubPremium" ;
	
	@ElementDefinition
	public String lst_CompetingCarrier="lst_CompetingCarrier" ;
	
	@ElementDefinition
	public String lst_CompetingPremium="lst_CompetingPremium" ;
	
	@ElementDefinition
	public String radio_QuotedPrimary="radio_QuotedPrimary" ;
	
	@ElementDefinition
	public String radio_QuotedExcess="radio_QuotedExcess" ;
	
	@ElementDefinition
	public String txt_PaSubmission="txt_PaSubmission" ;
	
	@ElementDefinition
	public String btn_ResubmitCurYear="btn_ResubmitCurYear" ;
	
	@ElementDefinition
	public String lst_marketSegmentSelected="lst_marketSegmentSelected" ;
	
	
	
	
	@ElementDefinition
	public String btn_Submission_Email="btn_Submission_Email" ;
	
	@ElementDefinition
	public String chk_RenewalProcessed="chk_RenewalProcessed" ;
	
	@ElementDefinition
	public String btn_CreateNewSubmission="btn_CreateNewSubmission" ;
	
	@ElementDefinition
	public String txt_Limit="txt_Limit" ;
	@ElementDefinition
	public String txt_RetentionAttachment="txt_RetentionAttachment" ;
	@ElementDefinition
	public String btn_AddPolicy="btn_AddPolicy" ;

	@ElementDefinition
	public String lst_PolicyBound="lst_PolicyBound" ;
	
	@ElementDefinition
	public String OFC_insureName="OFC_insureName" ;
	
	@ElementDefinition
	public String txt_ExplainSubmissionStatus="txt_ExplainSubmissionStatus" ;
	
	@ElementDefinition
	public String rdb_AffinityBusiness_No="rdb_AffinityBusiness_No" ;
	
	@ElementDefinition
	public String rdb_AffinityBusiness_Yes="rdb_AffinityBusiness_Yes" ;
	
	@ElementDefinition
	public String lst_AffinityBusiness="lst_AffinityBusiness" ;
	
	@ElementDefinition
	public String txt_ScheduleRatingMod="txt_ScheduleRatingMod" ;
	
	@ElementDefinition
	public String txt_ExperienceMod="txt_ExperienceMod" ;
	
	@ElementDefinition
	public String isMandatroychkPublic="isMandatroychkPublic" ;
	@ElementDefinition
	public String isMandatroychkPrivate="isMandatroychkPrivate" ;
	
	@ElementDefinition
	public String DisplayOrderPublic="DisplayOrderPublic" ;
	@ElementDefinition
	public String DisplayOrderPrivate="DisplayOrderPrivate" ;
	
	@ElementDefinition
	public String isMandatroySubDesc="isMandatroySubDesc" ;
	
	@ElementDefinition
	public String OFACSearchReq="OFACSearchReq" ;
	
	@ElementDefinition
	public String InsuredNameReq="InsuredNameReq" ;
	
	@ElementDefinition
	public String OFACSearchResults="OFACSearchResults" ;
	@ElementDefinition
	public String tab_AccountNum="tab_AccountNum" ;
	@ElementDefinition
	public String btn_SendToPD="btn_SendToPD" ;
	@ElementDefinition
	public String txt_PDQuoteNumber="txt_PDQuoteNumber" ;
	
	@ElementDefinition
	public String lst_IncumbentCarNonRenewal="lst_IncumbentCarNonRenewal" ;
	@ElementDefinition
	public String txt_CreditScore="txt_CreditScore" ;
	
	@ElementDefinition
	public String txt_Priority="txt_Priority" ;
	@ElementDefinition
	public String lst_SelectdProdName="lst_SelectdProdName" ;
	
	@ElementDefinition
	public String lst_SelectedSubmissionLOB="lst_SelectedSubmissionLOB" ;
	
	@ElementDefinition
	public String lst_SelectedSubmittedProduct="lst_SelectedSubmittedProduct" ;
	
	@ElementDefinition
	public String lst_SelectedProducerOffice="lst_SelectedProducerOffice" ;
	
	@ElementDefinition
	public String lst_SelectedEverestCompany="lst_SelectedEverestCompany" ;
	
	@ElementDefinition
	public String txt_CurrencyMandatory="txt_CurrencyMandatory" ;
	@ElementDefinition
	public String Sld_DefaultPredominantState="Sld_DefaultPredominantState" ;
	@ElementDefinition
	public String lst_Currency="lst_Currency" ;
	@ElementDefinition
	public String Sld_DefaultCurrency="Sld_DefaultCurrency" ;
	
	@ElementDefinition
	public String radio_CurrentlyLossYes="radio_CurrentlyLossYes" ;
	@ElementDefinition
	public String radio_CurrentlyLossNo="radio_CurrentlyLossNo" ;
	@ElementDefinition
	public String lst_ProductCoveragePeril="lst_ProductCoveragePeril" ;
	
	@ElementDefinition
	public String txt_FEINMissed="txt_FEINMissed" ;
	
	@ElementDefinition
	public String btn_FEINCancel="btn_FEINCancel" ;
	@ElementDefinition
	public String btn_FEINSaved="btn_FEINSaved" ;
	@ElementDefinition
	public String lst_SelectedMarketSegment="lst_SelectedMarketSegment" ;
	
	@ElementDefinition
	public String req_CreditScore="req_CreditScore" ;
	@ElementDefinition
	public String lbl_CurrentlyValuedLoss="lbl_CurrentlyValuedLoss" ;
	@ElementDefinition
	public String req_CurrentlyValuedLoss="req_CurrentlyValuedLoss" ;
	@ElementDefinition
	public String req_IncumbentCarNonRenewal="req_IncumbentCarNonRenewal" ;
@ElementDefinition
	public String txt_SICCode="txt_SICCode" ;

@ElementDefinition
public String lnk_RenevalAccount_expOrColpse="lnk_RenevalAccount_expOrColpse" ;

@ElementDefinition
public String lnk_RenevalSubNum="lnk_RenevalSubNum" ;


@ElementDefinition
public String lst_SubmissionTypeSelected="lst_SubmissionTypeSelected" ;

@ElementDefinition
public String btn_CreateSisterPolicy="btn_CreateSisterPolicy" ;

@ElementDefinition
public String get_SisterSubNum="get_SisterSubNum" ;

	
	@TimeMethod
	@ScreenShot
	public void NewSubmission(String tcID, SoftAssert softAs) throws Exception;
	//public void VerifyCopySubForActiveProducer(String tcID, SoftAssert softAs) throws Exception;
	public void OpenSubSearchResult(String tcID, SoftAssert softAs) throws Exception;
	public void ProcessForNextYearRenewal(String tcID,SoftAssert softAs) throws Exception;
	public void VerifyProcessNextYearRenewal(String tcID,SoftAssert softAs) throws Exception;
	public void clkOFACSearchProcessRenewal(String tcID,SoftAssert softAs,String type) throws Exception;
	public void VerifyRenewalSubEffDate(String tcID,SoftAssert softAs) throws Exception;
	public void VerifySubDescription(String tcID,SoftAssert softAs,String CopyOREdit) throws Exception;
	public void EditSubmission(String tcID,SoftAssert softAs,String CopyOREdit) throws Exception;
	public void clkCopySubmission(String tcID,SoftAssert softAs) throws Exception;
	public void clkCreateThisSubmission(String tcID,SoftAssert softAs) throws Exception;
	public void clkSave(String tcID,SoftAssert softAs) throws Exception;
	public void Verify_MarketSegment_FieldValuee(String tcID,SoftAssert softAs,String type) throws Exception;
	public void Verify_Renewal_SubDescription(String tcID,SoftAssert softAs) throws Exception;
	public void Check_DescLength_TransTree(String tcID,SoftAssert softAs) throws Exception;
	public void Check_BusinessIndicator_Status_RenewalSubmission(String tcID,SoftAssert softAs) throws Exception;
	public void Verify_CopySub_fieldvalues(String tcID,SoftAssert softAs,String type) throws Exception;
	public void Verify_CopySubbtn_exist_NS(String tcID,SoftAssert softAs) throws Exception;
	public void Verify_RenewalSub_fieldvalues(String tcID,SoftAssert softAs,String type) throws Exception;
	public void ProspectFromPreviousYear(String tcID,SoftAssert softAs) throws Exception;
	public void Verify_PANBValues(String tcID, SoftAssert softAs) throws Exception;
	
	public void Verify_NewSubmission_Fieldvalues(String tcID, SoftAssert softAs) throws Exception;
	public void AddNewPolicy(String tcID, SoftAssert softAs,String type) throws Exception;
	public void Verify_ChangeBS_fieldvalues(String tcID, SoftAssert softAs) throws Exception;
	
	public void Verify_Submission_ReadOnly_fields(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_Sub_Pol_Billing_UnderWriter(String tcID, SoftAssert softAs,String DeviceName) throws Exception;
	public void Check_BusinessIndicator_Status_Submission(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_RenSub_EffDate_ExpDate(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_Submission_Field_Charactorstic(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_OFACSearch_Screen_Renewal(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_Delete_SubDescription(String tcID, SoftAssert softAs) throws Exception;
	public void sendTo_PD(String tcID, SoftAssert softAs) throws Exception;
	public void verify_AutoPopulated_Priority(String tcID, SoftAssert softAs) throws Exception;
	
	public void verify_Submission_InDWHDB (String tcID, SoftAssert softAssert) throws Exception;
	
	public void verify_Submission_Currency_PredominantState_FieldValue(String tcID, SoftAssert softAs) throws Exception;
	public void verify_SubmissionDetails_DB(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_CreditScroreField(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_PriorityField(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_CurrentlyValuedLossRunsField(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_EstimatedTargetPremiumField(String tcID,SoftAssert softAs)throws Exception;
	public void Verify_IncumbentCarrNonRenewalField(String tcID,SoftAssert softAs)throws Exception;
	public void Verify_copySubmisssionField(String tcID,SoftAssert softAs)throws Exception;
	public void verify_FEINPopUp_MissedInAccountScreen(String tcID, SoftAssert softAs) throws Exception;
	
	public void verify_OnlySubmission_InBothDB(String tcID, SoftAssert softAs, String DBServer) throws Exception;
	public void verify_NAISC_SICFiled_Submission(String tcID, SoftAssert softAs, String DeviceName) throws Exception;
	public void verify_LOBValue_Submission(String tcID, SoftAssert softAs, String ActionType) throws Exception;
	public void verify_PD_Input_Output_XML(String tcID, SoftAssert softAs,String SubType) throws Exception;
	public void verify_BookPolicyXML_BindPost(String tcID, SoftAssert softAs,String type) throws Exception;	
	public void verify_ESCSubmission_WithPDChanges (String tcID, SoftAssert softAssert,String type) throws Exception;
	public void verify_ClonedSubmission_AfterCancelRewritetoNewPolicy(String tcID, SoftAssert softAS) throws Exception;
	public void verify_OriginalSubmissionStatus_AfterCancelRewritetoNewPolicy(String tcID, SoftAssert softAS) throws Exception;
	public void verify_Populateonly_BSsupport_SubLOB(String tcID, SoftAssert softAS) throws Exception;
	public void clk_SisterPolicy(String tcID, SoftAssert softAS) throws Exception;
	public void verify_OriginalSub_NewClonedSub_SisterPolicy(String tcID, SoftAssert softAS) throws Exception;
	public void Verify_ClonedSubmission_Fieldvalues (String tcID, SoftAssert softAssert,String type) throws Exception;
	public void verify_Defult_ProdName_ProdOffice (String tcID, SoftAssert softAssert) throws Exception;
	public void verify_Vosco_Quote_SAN_InDB(String tcID, SoftAssert softAs) throws Exception;
	public void verify_SisterPolicy_button_Available(String tcID, SoftAssert softAS) throws Exception;
	public void verify_BookPolicyXML_BindPost_VoscoAgent(String tcID, SoftAssert softAs) throws Exception;
	public void verify_errorlogs_RecordedInDB(String tcID, SoftAssert softAS) throws Exception;
	public void verify_SendTo_PD_buttion (String tcID, SoftAssert softAssert) throws Exception;
	public void Renewal_SisterPolicy (String tcID,SoftAssert softAssert) throws Exception;
	public void verify_Nocalls_Madeto_Escape(String tcID, SoftAssert softAs,String SubType ) throws Exception;
	public void verify_UMSUbmissionDetais_inEscape(String tcID, SoftAssert softAssert) throws Exception;
	public void verify_LOB(String tcID, SoftAssert softAssert) throws Exception;
	
}
