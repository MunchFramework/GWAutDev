package com.everest.escape.submission;

import java.util.ArrayList;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface Search extends Page {

	
	@ElementDefinition
	public String msg_NoSearchResult="msg_NoSearchResult";
	@ElementDefinition
	public String btn_Searchtab="btn_Searchtab" ;

	@ElementDefinition
	public String btn_Cancel="btn_Cancel" ;
		
	@ElementDefinition
	public String img_clearselection="img_clearselection" ;
	@ElementDefinition
	public String lst_clkSelectBusinessSegment="lst_clkSelectBusinessSegment" ;
	
	@ElementDefinition
	public String lst_clkIESelectBusinessSegment="lst_clkIESelectBusinessSegment" ;
	
	@ElementDefinition
	public String opt_ChoseBusinessSegment="opt_ChoseBusinessSegment" ;
	
	@ElementDefinition
	public String opt_IEChoseBusinessSegment="opt_IEChoseBusinessSegment" ;
	@ElementDefinition
	public String DefaultBusinessSegment="DefaultBusinessSegment" ;
		
	
	@ElementDefinition
	public String txt_AccountNumber="txt_AccountNumber" ;
	
	@ElementDefinition
	public String txt_FEIN="txt_FEIN" ;
	@ElementDefinition
	public String txt_InsuredName="txt_InsuredName" ;
	@ElementDefinition
	public String txt_MailingAddress="txt_MailingAddress" ;
	@ElementDefinition
	public String txt_MailingCity="txt_MailingCity" ;
	@ElementDefinition
	public String lst_MailingState="lst_MailingState" ;
	
	@ElementDefinition
	public String txt_MailZipCode="txt_MailZipCode" ;
	
	
	@ElementDefinition
	public String txt_SubmissionNumber="txt_SubmissionNumber" ;
	
	@ElementDefinition
	public String lst_SubmissionStatus="lst_SubmissionStatus" ;
	@ElementDefinition
	public String lst_MarketSegment="lst_MarketSegment" ;
	@ElementDefinition
	public String lst_PredominantState="lst_PredominantState" ;
	@ElementDefinition
	public String lst_Distribution="lst_Distribution" ;
	@ElementDefinition
	public String lst_ProducerName="lst_ProducerName" ;
	
	@ElementDefinition
	public String lst_BranchOffice="lst_BranchOffice" ;
	@ElementDefinition
	public String lst_ProducerOffice="lst_ProducerOffice" ;
	@ElementDefinition
	public String lst_Underwriter="lst_Underwriter" ;
	@ElementDefinition
	public String dat_SubmissionEffDateAfter="dat_SubmissionEffDateAfter" ;
	@ElementDefinition
	public String dat_SubmissionEffDateBefore="dat_SubmissionEffDateBefore" ;
	@ElementDefinition
	public String lst_SubmittedLOB="lst_SubmittedLOB" ;

	@ElementDefinition
	public String txt_PolicyNumber="txt_PolicyNumber" ;
	@ElementDefinition
	public String txt_PolicyEffectiveDateFrom="txt_PolicyEffectiveDateFrom" ;
	@ElementDefinition
	public String txt_PolicyEffectiveDateTo="txt_PolicyEffectiveDateTo" ;
	
	@ElementDefinition
	public String lst_PolicyStatus="lst_PolicyStatus" ;
	@ElementDefinition
	public String lst_CancelledReasonCode="lst_CancelledReasonCode" ;
	@ElementDefinition
	public String lst_RenewalStatus="lst_RenewalStatus" ;
	@ElementDefinition
	public String dat_PaymentDueDateAfter="dat_PaymentDueDateAfter" ;
	@ElementDefinition
	public String dat_PaymentDueDateBefore="dat_PaymentDueDateBefore" ;
	@ElementDefinition
	public String radio_And="radio_And" ;
	@ElementDefinition
	public String radio_Or="radio_Or" ;

	@ElementDefinition
	public String btn_Search="btn_Search" ;
	
	@ElementDefinition
	public String lnk_SearchPolicy="lnk_SearchPolicy" ;
	@ElementDefinition
	public String lnk_AccountNum="lnk_AccountNum" ;
	@ElementDefinition
	public String lnk_SubmissionNum="lnk_SubmissionNum" ;
	
	@ElementDefinition
	public String txt_CheckNumber="txt_CheckNumber" ;
	@ElementDefinition
	public String txt_AmountReceived="txt_AmountReceived" ;
	
	@ElementDefinition
	public String lst_RecordsPerPage="lst_RecordsPerPage" ;
	
	
	@ElementDefinition
	public String lbl_AccountNumber="lbl_AccountNumber" ;
	@ElementDefinition
	public String lbl_FEIN="lbl_FEIN" ;
	
	@ElementDefinition
	public String lbl_InsuredName="lbl_InsuredName" ;
	
	@ElementDefinition
	public String lbl_MailAddress="lbl_MailAddress" ;
	
	@ElementDefinition
	public String lbl_MailCity="lbl_MailCity" ;
	@ElementDefinition
	public String lbl_MailState="lbl_MailState" ;
	@ElementDefinition
	public String lbl_MailZipCode="lbl_MailZipCode" ;
	
	@ElementDefinition
	public String lbl_SubmissionNum="lbl_SubmissionNum" ;
	
	@ElementDefinition
	public String lbl_SubmissionStatus="lbl_SubmissionStatus" ;
	
	@ElementDefinition
	public String lbl_PredominantState="lbl_PredominantState" ;
	@ElementDefinition
	public String lbl_SubmissionLOB="lbl_SubmissionLOB" ;
	@ElementDefinition
	public String lbl_ProducerName="lbl_ProducerName" ;
	@ElementDefinition
	public String lbl_ProducerOffice="lbl_ProducerOffice" ;
	
	@ElementDefinition
	public String lbl_BranchOffice="lbl_BranchOffice" ;
	
	@ElementDefinition
	public String lbl_Underwriter="lbl_Underwriter" ;
	@ElementDefinition
	public String lbl_SubEffDate_greater="lbl_SubEffDate_greater" ;
	@ElementDefinition
	public String lbl_SubEffDate_Less="lbl_SubEffDate_Less" ;
	@ElementDefinition
	public String lbl_MarketSegment="lbl_MarketSegment" ;
	@ElementDefinition
	public String lbl_Distribution="lbl_Distribution" ;
	

	@ElementDefinition
	public String lbl_PolicyNumber="lbl_PolicyNumber" ;
	@ElementDefinition
	public String lbl_PolicyStatus="lbl_PolicyStatus" ;
	@ElementDefinition
	public String lbl_CancelledReasonCode="lbl_CancelledReasonCode" ;
	@ElementDefinition
	public String lbl_RenewalStatus="lbl_RenewalStatus" ;
	@ElementDefinition
	public String lbl_PaymentDueDateFrom="lbl_PaymentDueDateFrom" ;
	
	@ElementDefinition
	public String lbl_PaymentDueDateTo="lbl_PaymentDueDateTo" ;
	@ElementDefinition
	public String lbl_PolicyEffectiveDateFrom="lbl_PolicyEffectiveDateFrom" ;
	@ElementDefinition
	public String lbl_PolicyEffectiveDateTo="lbl_PolicyEffectiveDateTo" ;
	@ElementDefinition
	public String msg_NoSearchResult_ForUW="msg_NoSearchResult_ForUW" ;
	@ElementDefinition
	public String msg_NoWinsResults="msg_NoWinsResults" ;
	@ElementDefinition
	public String SearchGrid_Header="SearchGrid_Header" ;
	@ElementDefinition
	public String SearchTitle="SearchTitle" ;
	
	@ElementDefinition
	public String SearchWinsTitle="SearchWinsTitle" ;
	
	@ElementDefinition
	public String lst_WINSRecordsPerPage="lst_WINSRecordsPerPage" ;
	
	@ElementDefinition
	public String IEDefaultBusinessSegment="IEDefaultBusinessSegment" ;
	
	
	
	@ElementDefinition
	public String lnk_AccountNo="lnk_AccountNo" ;
	@ElementDefinition
	public String lnk_SubmissionNo="lnk_SubmissionNo" ;
	@ElementDefinition
	public String getSubmissionNumber="getSubmissionNumber" ;
	@ElementDefinition
	public String getAccountNumber="getAccountNumber" ;
	@ElementDefinition
	public String txt_SelectedState="txt_SelectedState" ;
	@ElementDefinition
	public String AccountTab="AccountTab" ;
	@ElementDefinition
	public String txt_AccFEIN="txt_AccFEIN" ;
	
	@ElementDefinition
	public String txt_SubmissionNumSearch="txt_SubmissionNumSearch" ;
	
	
	@TimeMethod
	@ScreenShot
	public void Search(String tcID, SoftAssert softAs,String DeviceName) throws Exception;
	public void Verify_Account_Search(String tcID, SoftAssert softAs ) throws Exception;
	public void Verify_Submission_Search(String tcID, SoftAssert softAs,String DeviceName ) throws Exception;
	public void Verify_Policy_Search(String tcID, SoftAssert softAs,String DeviceName ) throws Exception;
	public int get_ColumnNum_InSearchGrid(String tcID,String ColName, SoftAssert softAs,String SearchType ) throws Exception;
	public boolean verify_General_Search_Result(String tcID, SoftAssert softAs,String DeviceName ) throws Exception;
	public void BillingCashSearchResult(String tcID, SoftAssert softAs,String DeviceName ) throws Exception;
	public void verify_SearchGrid(String tcID, SoftAssert softAs ) throws Exception;
	public void Check_Default_SearchScreen(String tcID, SoftAssert softAs,String DeviceName ) throws Exception;
	public void verify_NonBillinguser_SearchGrid(String tcID, SoftAssert softAs,String SearchType) throws Exception;
	public void verify_SearchFilter_Result(String tcID, SoftAssert softAs,String DeviceName) throws Exception;
	public boolean verify_Search_Result(String tcID, int ColNum,String ExpValue,SoftAssert softAs) throws Exception;
	public ArrayList getHeaderNumbers(String tcID, SoftAssert softAssert,String DeviceName,String SearchType) throws Exception;
	public boolean verify_Search_Records (String tcID,int intpagenum,int totRow,ArrayList arrSearchCriteria, SoftAssert softAssert,String SearchType,String Operator) throws Exception;
	public int getSpanIndex (int pageCount, SoftAssert softAssert) throws Exception;
	public void Verify_CommCol_DisplayPlace(String tcID,SoftAssert softAS) throws Exception;
	public boolean verify_WINS_Search_Result(String tcID, SoftAssert softAs,String DeviceName ) throws Exception;
	public void verify_WINSSearchFilter_Result(String tcID, SoftAssert softAs,String DeviceName) throws Exception;
	public void Verify_Renewal_Records_InSearchScreen(String tcID, SoftAssert softAs,String DeviceName) throws Exception;
	//public boolean Verify_SearchResult_EffectiveDateAfter(String tcID, SoftAssert softAs,String cellValue) throws Exception;
	public boolean Verify_SearchResult_EffectiveDate(String tcID, SoftAssert softAs,String cellValue) throws Exception;
	public void Open_Submission_Search_Result(String tcID, SoftAssert softAs) throws Exception;
	public void Submission_Search(String tcID, SoftAssert softAs,String DeviceName) throws Exception;
	public void Verify_Subdesc_InSearchresult(String tcID, SoftAssert softAs,String DeviceName) throws Exception;
	public void Verify_SubDesc_lenght_SearchResult(String tcID, SoftAssert softAs) throws Exception;
	public void NewBusiness_Search(String tcID, SoftAssert softAs) throws Exception;
	public void Open_NewBusiness_Search_Result(String tcID, SoftAssert softAs) throws Exception;
	public void clonedSubmission_Search (String tcID, SoftAssert softAssert,String DeviceName) throws Exception;
	public void verify_OceanWide_AccountDetails(String tcID, SoftAssert softAssert, String DeviceName, String Application) throws Exception;
	public void SisSubmission_Search (String tcID, SoftAssert softAssert,String DeviceName) throws Exception;
	public void UM_Submission_Search (String tcID, SoftAssert softAssert,String DeviceName) throws Exception;
    public void searchSubmissionInEscape (String tcID, SoftAssert softAssert) throws Exception;
}
