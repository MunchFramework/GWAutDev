package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.device.ng.AbstractSeleniumTest;
import org.xframium.page.PageManager;

import com.everest.escape.submission.Account;
import com.everest.escape.submission.AddPolicy;
import com.everest.escape.submission.Login;
import com.everest.escape.submission.NewSubmission;
import com.everest.escape.submission.Search;
import com.everest.page.application.AccountPage;
import com.everest.page.application.AccountSearchPage;
import com.everest.page.application.CancelPage;
import com.everest.page.application.ChangePremiumCapturePage;
import com.everest.page.application.CoverageValidationPage;
import com.everest.page.application.ExcelRaterPage;
import com.everest.page.application.ExposureValidationPage;
import com.everest.page.application.FormsValidationPage;
import com.everest.page.application.InsuredAppLoginPage;
import com.everest.page.application.LoginPage;
import com.everest.page.application.LogoutPage;
import com.everest.page.application.MarkAsLostPage;
import com.everest.page.application.ModifiersPage;
import com.everest.page.application.ModifiersValidationPage;
import com.everest.page.application.NewSubmissionPage;
import com.everest.page.application.OptionalCovPage;
import com.everest.page.application.PCValidationPage;
import com.everest.page.application.PcPolicyInfoPage;
import com.everest.page.application.PcPolicyReviewPage;
import com.everest.page.application.PcSummaryPage;
import com.everest.page.application.PolicyChangePage;
import com.everest.page.application.PolicyCoverageChangePage;
import com.everest.page.application.PolicySearchPage;
import com.everest.page.application.PreRenewalDirectionPage;
import com.everest.page.application.PremiumCapturePage;
import com.everest.page.application.ReinstatePage;
import com.everest.page.application.RemoveOptionalCovPage;
import com.everest.page.application.RescindPage;
import com.everest.page.application.RewritePage;
import com.everest.page.application.SubmissionSearchPage;
import com.everest.page.application.SubmitRenewalPage;
import com.everest.page.application.UmAddingOfficePage;
import com.everest.page.application.UmBindingPage;
import com.everest.page.application.UmCallingCovPage;
import com.everest.page.application.UmCollaborationToolPage;
import com.everest.page.application.UmCvgLvlPremiumValidatnPage;
import com.everest.page.application.UmDeclinePage;
import com.everest.page.application.UmExposuresPage;
import com.everest.page.application.UmGeneralInfoPage;
import com.everest.page.application.UmGetSubmissionNumberPage;
import com.everest.page.application.UmIssuancePage;
import com.everest.page.application.UmLoginPage;
import com.everest.page.application.UmLogoutPage;
import com.everest.page.application.UmMarketSegmentPage;
import com.everest.page.application.UmPremiumCapturePage;
import com.everest.page.application.UmQuotingPage;
import com.everest.page.application.UmRatingCRIPage;
import com.everest.page.application.UmRatingCYBPage;
import com.everest.page.application.UmRatingCommonPage;
import com.everest.page.application.UmRatingDNOPage;
import com.everest.page.application.UmRatingEMPPage;
import com.everest.page.application.UmRatingENOPage;
import com.everest.page.application.UmRatingEPLPage;
import com.everest.page.application.UmRatingEZExcessPage;
import com.everest.page.application.UmRatingFIDPage;
import com.everest.page.application.UmRatingKNRPage;
import com.everest.page.application.UmRatingLPLAdmittedPage;
import com.everest.page.application.UmRatingLPLNonAdmittedPage;
import com.everest.page.application.UmRatingManuScriptEndtsPage;
import com.everest.page.application.UmRatingSlimCommonPage;
import com.everest.page.application.UmRatingSubInfoPage;
import com.everest.page.application.UmSearchPolicyPage;
import com.everest.page.application.UmSearchSubmissionPage;
import com.everest.page.application.UmSubmissionDetailsPage;
import com.everest.page.imageright.IRFileSearch;
import com.everest.page.imageright.IRLogin;
import com.everest.page.imageright.IROpenFile;

public class PageImplInvoker extends AbstractSeleniumTest {

	/************************
	 * Alliance Flow Controller for Renter LOB
	 **************************/

	SoftAssert softAssert = new SoftAssert();

	/**************** Login Page *************************/

	public void PcPolicyInfoValidation(String tcID) throws Exception {

		PcPolicyInfoPage objReference = (PcPolicyInfoPage) PageManager.instance().createPage(PcPolicyInfoPage.class, getWebDriver());
		objReference.PcPolicyInfoValidation(tcID, softAssert);
	}
	
	public void PcPolicyReviewValidation(String tcID) throws Exception {

		PcPolicyReviewPage objReference = (PcPolicyReviewPage) PageManager.instance().createPage(PcPolicyReviewPage.class, getWebDriver());
		objReference.PcPolicyReviewValidation(tcID, softAssert);
	}
	
	public void PcPaymentDetailsValidation(String tcID) throws Exception {

		PcSummaryPage objReference = (PcSummaryPage) PageManager.instance().createPage(PcSummaryPage.class, getWebDriver());
		objReference.PcPaymentDetailsValidation(tcID, softAssert);
	}
	
	public void PcPremiumBreakdownValidation(String tcID) throws Exception {

		PcSummaryPage objReference = (PcSummaryPage) PageManager.instance().createPage(PcSummaryPage.class, getWebDriver());
		objReference.PcPremiumBreakdownValidation(tcID, softAssert);
	}
	
	public void PcPrintForm(String tcID) throws Exception {

		PcSummaryPage objReference = (PcSummaryPage) PageManager.instance().createPage(PcSummaryPage.class, getWebDriver());
		objReference.PcPrintForm(tcID, softAssert);
	}
	
	public void PcDownloadForm(String tcID) throws Exception {

		PcSummaryPage objReference = (PcSummaryPage) PageManager.instance().createPage(PcSummaryPage.class, getWebDriver());
		objReference.PcDownloadForm(tcID, softAssert);
	}
	
	public void launchPage(String tcID, String DeviceName) throws Exception {

		LoginPage objReference = (LoginPage) PageManager.instance().createPage(LoginPage.class, getWebDriver());
		objReference.launchPage(tcID, softAssert, DeviceName);
	}
	public void verify_UMAccountReAssignment_ErrorPopup(String tcID) throws Exception 
	{

	
		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.verify_UMAccountReAssignment_ErrorPopup(tcID, softAssert);
	}
	

	public void UmlaunchPage(String tcID, String DeviceName) throws Exception {

		UmLoginPage objReference = (UmLoginPage) PageManager.instance().createPage(UmLoginPage.class, getWebDriver());
		objReference.UmlaunchPage(tcID, softAssert, DeviceName);
	}
	public void ClosePage(String tcID, String DeviceName) throws Exception {

		LogoutPage objReference = (LogoutPage) PageManager.instance().createPage(LogoutPage.class, getWebDriver());
		objReference.ClosePage(tcID, softAssert, DeviceName);
	}
	
	public void edit_UmSubmissionDetails(String tcID) throws Exception {

		UmSubmissionDetailsPage objReference = (UmSubmissionDetailsPage) PageManager.instance().createPage(UmSubmissionDetailsPage.class, getWebDriver());
		objReference.edit_UmSubmissionDetails(tcID, softAssert);
		}
	public void edit_UmAccount_Details(String tcID) throws Exception {

		UmSubmissionDetailsPage objReference = (UmSubmissionDetailsPage) PageManager.instance().createPage(UmSubmissionDetailsPage.class, getWebDriver());
		objReference.edit_UmAccount_Details(tcID, softAssert);
		}
	public void UMCopySubmission(String tcID) throws Exception {

		UmSubmissionDetailsPage objReference = (UmSubmissionDetailsPage) PageManager.instance().createPage(UmSubmissionDetailsPage.class, getWebDriver());
		objReference.UMCopySubmission(tcID, softAssert);
		}
	
	
	
	public void validate_Renewal_ErrorMsg(String tcID) throws Exception {

		UmSubmissionDetailsPage objReference = (UmSubmissionDetailsPage) PageManager.instance().createPage(UmSubmissionDetailsPage.class, getWebDriver());
		objReference.validate_Renewal_ErrorMsg(tcID, softAssert);
		}
	
	
	
	public void update_Exposure(String tcID) throws Exception {

		UmExposuresPage objReference = (UmExposuresPage) PageManager.instance().createPage(UmExposuresPage.class, getWebDriver());
		objReference.update_Exposure(tcID, softAssert);
	}
	public void expendCoverages(String tcID) throws Exception {

		UmCallingCovPage objReference = (UmCallingCovPage) PageManager.instance().createPage(UmCallingCovPage.class,
				getWebDriver());
		objReference.expendCoverages(tcID, softAssert);
	}
	
	public void verify_UmSubmissionDetails(String tcID) throws Exception {

		UmSubmissionDetailsPage objReference = (UmSubmissionDetailsPage) PageManager.instance().createPage(UmSubmissionDetailsPage.class, getWebDriver());
		objReference.verify_UmSubmissionDetails(tcID, softAssert);
	}

	public void UmClosePage(String tcID, String DeviceName) throws Exception {

		UmLogoutPage objReference = (UmLogoutPage) PageManager.instance().createPage(UmLogoutPage.class,
				getWebDriver());
		objReference.UmClosePage(tcID, softAssert, DeviceName);
	}

	public void createAccount(String tcID) throws Exception {

		AccountPage objReference = (AccountPage) PageManager.instance().createPage(AccountPage.class, getWebDriver());
		objReference.createAccount(tcID, softAssert);
	}
	
	public void verify_AccountReAssignment(String tcID,String ActionType) throws Exception {

		Account objReference = (Account) PageManager.instance().createPage(Account.class, getWebDriver());
		objReference.verify_AccountReAssignment(tcID, softAssert,ActionType);
	}
	
	

	public void createNewSubmission(String tcID) throws Exception {

		NewSubmissionPage objReference = (NewSubmissionPage) PageManager.instance().createPage(NewSubmissionPage.class,
				getWebDriver());
		objReference.createNewSubmission(tcID, softAssert);
	}

	

	public void searchAccount(String tcID) throws Exception {

		AccountSearchPage objReference = (AccountSearchPage) PageManager.instance().createPage(AccountSearchPage.class,getWebDriver());
		objReference.searchAccount(tcID, softAssert);
	}

	
	public void searchSubmission(String tcID) throws Exception {

		SubmissionSearchPage objReference = (SubmissionSearchPage) PageManager.instance().createPage(SubmissionSearchPage.class, getWebDriver());
		objReference.searchSubmission(tcID, softAssert);
	}
	
	public void formsValidation(String tcID) throws Exception {

		FormsValidationPage objReference = (FormsValidationPage) PageManager.instance().createPage(FormsValidationPage.class, getWebDriver());
		objReference.formsValidation(tcID, softAssert);
	}

	
	public void searchPolicy(String tcID, String DeviceName) throws Exception {

		PolicySearchPage objReference = (PolicySearchPage) PageManager.instance().createPage(PolicySearchPage.class, getWebDriver());
		objReference.searchPolicy(tcID, softAssert);
	}
	

	public void OptionalCov(String tcID) throws Exception {

		OptionalCovPage objReference = (OptionalCovPage) PageManager.instance().createPage(OptionalCovPage.class, getWebDriver());
		objReference.OptionalCov(tcID, softAssert);
	}
	
	public void OptionalCovValid(String tcID) throws Exception {

		OptionalCovPage objReference = (OptionalCovPage) PageManager.instance().createPage(OptionalCovPage.class, getWebDriver());
		objReference.OptionalCovValid(tcID, softAssert);
	}
	
	public void VerifyRunOffAndERPFields(String tcID) throws Exception {

		OptionalCovPage objReference = (OptionalCovPage) PageManager.instance().createPage(OptionalCovPage.class, getWebDriver());
		objReference.VerifyRunOffAndERPFields(tcID, softAssert);
	}
	
	public void cancelPolicy(String tcID) throws Exception {

		CancelPage objReference = (CancelPage) PageManager.instance().createPage(CancelPage.class, getWebDriver());
		objReference.cancelPolicy(tcID, softAssert);
	}
	public void MarkAsLost(String tcID) throws Exception {

		MarkAsLostPage objReference = (MarkAsLostPage) PageManager.instance().createPage(MarkAsLostPage.class, getWebDriver());
		objReference.MarkAsLost(tcID, softAssert);
	}
	
	public void UmSubmissionDetails(String tcID) throws Exception {

		UmSubmissionDetailsPage objReference = (UmSubmissionDetailsPage) PageManager.instance().createPage(UmSubmissionDetailsPage.class, getWebDriver());
		objReference.UmSubmissionDetails(tcID, softAssert);
	}
	
	public void veify_UMSubmission_Status(String tcID) throws Exception {

		UmSubmissionDetailsPage objReference = (UmSubmissionDetailsPage) PageManager.instance().createPage(UmSubmissionDetailsPage.class, getWebDriver());
		objReference.veify_UMSubmission_Status(tcID, softAssert);
	}
	
	public void _click_RiskIsClear(String tcID) throws Exception {

		UmSubmissionDetailsPage objReference = (UmSubmissionDetailsPage) PageManager.instance().createPage(UmSubmissionDetailsPage.class, getWebDriver());
		objReference._click_RiskIsClear(tcID, softAssert);
	}
	
	

	public void updateTheCreatedApplication(String tcID) throws Exception {

		UmSubmissionDetailsPage objReference = (UmSubmissionDetailsPage) PageManager.instance().createPage(UmSubmissionDetailsPage.class, getWebDriver());
		objReference.updateTheCreatedApplication(tcID, softAssert);
	}
	
	public void VerifyTheUpdatedFieldValue(String tcID) throws Exception {

		UmSubmissionDetailsPage objReference = (UmSubmissionDetailsPage) PageManager.instance().createPage(UmSubmissionDetailsPage.class, getWebDriver());
		objReference.VerifyTheUpdatedFieldValue(tcID, softAssert);
	}
	
	
	public void UmGeneralInfo(String tcID) throws Exception {

		UmGeneralInfoPage objReference = (UmGeneralInfoPage) PageManager.instance().createPage(UmGeneralInfoPage.class, getWebDriver());
		objReference.UmGeneralInfo(tcID, softAssert);
	}
	
	public void UmExposures(String tcID) throws Exception {

		UmExposuresPage objReference = (UmExposuresPage) PageManager.instance().createPage(UmExposuresPage.class, getWebDriver());
		objReference.UmExposures(tcID, softAssert);
	}
	
	public void VerifyWrittingApproach(String tcID) throws Exception 
	{

		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.VerifyWrittingApproach(tcID, softAssert);
	}
	public void SubmitApplication(String tcID) throws Exception {

		UmExposuresPage objReference = (UmExposuresPage) PageManager.instance().createPage(UmExposuresPage.class, getWebDriver());
		objReference.SubmitApplication(tcID, softAssert);
	}
	

	public void submitApp(String tcID) throws Exception {

		UmExposuresPage objReference = (UmExposuresPage) PageManager.instance().createPage(UmExposuresPage.class, getWebDriver());
		objReference.submitApp(tcID, softAssert);
	}
	
	public void EditExposureInformation(String tcID) throws Exception {

		UmExposuresPage objReference = (UmExposuresPage) PageManager.instance().createPage(UmExposuresPage.class, getWebDriver());
		objReference.EditExposureInformation(tcID, softAssert);
	}
	
	public void Edit_UmAddingOffice(String tcID) throws Exception {

		UmAddingOfficePage objReference = (UmAddingOfficePage) PageManager.instance().createPage(UmAddingOfficePage.class,
				getWebDriver());
		objReference.Edit_UmAddingOffice(tcID, softAssert);
	}
	
	public void VerifyExposureInformation(String tcID) throws Exception {

		UmExposuresPage objReference = (UmExposuresPage) PageManager.instance().createPage(UmExposuresPage.class, getWebDriver());
		objReference.VerifyExposureInformation(tcID, softAssert);
	}
	public void UmSubmissionNumber(String tcID) throws Exception {

		UmGetSubmissionNumberPage objReference = (UmGetSubmissionNumberPage) PageManager.instance().createPage(UmGetSubmissionNumberPage.class, getWebDriver());
		objReference.UmSubmissionNumber(tcID, softAssert);
	}
	public void verify_UMPolicy_Renewaval(String tcID) throws Exception {

		UmGetSubmissionNumberPage objReference = (UmGetSubmissionNumberPage) PageManager.instance().createPage(UmGetSubmissionNumberPage.class, getWebDriver());
		objReference.verify_UMPolicy_Renewaval(tcID, softAssert);
	}
	
	
	public void UmMarketSegment(String tcID) throws Exception {

		UmMarketSegmentPage objReference = (UmMarketSegmentPage) PageManager.instance().createPage(UmMarketSegmentPage.class, getWebDriver());
		objReference.UmMarketSegment(tcID, softAssert);
	}
	
	public void UpdateUmMarketSegment(String tcID) throws Exception {

		UmMarketSegmentPage objReference = (UmMarketSegmentPage) PageManager.instance().createPage(UmMarketSegmentPage.class, getWebDriver());
		objReference.UpdateUmMarketSegment(tcID, softAssert);
	}
	
	public void verifyUmMarketSegment(String tcID) throws Exception {

		UmMarketSegmentPage objReference = (UmMarketSegmentPage) PageManager.instance().createPage(UmMarketSegmentPage.class, getWebDriver());
		objReference.verifyUmMarketSegment(tcID, softAssert);
	}
	public void PolicyChange(String tcID) throws Exception {

		PolicyChangePage objReference = (PolicyChangePage) PageManager.instance().createPage(PolicyChangePage.class,
				getWebDriver());
		objReference.PolicyChange(tcID, softAssert);
	}
	
	public void PolicyChangeFormValid(String tcID) throws Exception {

		PolicyChangePage objReference = (PolicyChangePage) PageManager.instance().createPage(PolicyChangePage.class,
				getWebDriver());
		objReference.PolicyChangeFormValid(tcID, softAssert);
	}
	public void Rewrite(String tcID) throws Exception {

		RewritePage objReference = (RewritePage) PageManager.instance().createPage(RewritePage.class,
				getWebDriver());
		objReference.Rewrite(tcID, softAssert);
	}
	
	public void UmClickGetRater(String tcID) throws Exception {

		UmRatingCommonPage objReference = (UmRatingCommonPage) PageManager.instance().createPage(UmRatingCommonPage.class,
				getWebDriver());
		objReference.UmClickGetRater(tcID, softAssert);
	}
	
	public void UmSetPartOfRatingCommon(String tcID) throws Exception {

		UmRatingCommonPage objReference = (UmRatingCommonPage) PageManager.instance().createPage(UmRatingCommonPage.class,
				getWebDriver());
		objReference.UmSetPartOfRatingCommon(tcID, softAssert);
	}
	
	public void UmSetRunOffPremium(String tcID) throws Exception {

		UmRatingCommonPage objReference = (UmRatingCommonPage) PageManager.instance().createPage(UmRatingCommonPage.class,
				getWebDriver());
		objReference.UmSetRunOffPremium(tcID, softAssert);
	}
	
	public void UmRatingCommon(String tcID) throws Exception {

		UmRatingCommonPage objReference = (UmRatingCommonPage) PageManager.instance().createPage(UmRatingCommonPage.class,
				getWebDriver());
		objReference.UmRatingCommon(tcID, softAssert);
	}
	
	public void UmUpdateRatingCommon(String tcID) throws Exception {

		UmRatingCommonPage objReference = (UmRatingCommonPage) PageManager.instance().createPage(UmRatingCommonPage.class,
				getWebDriver());
		objReference.UmUpdateRatingCommon(tcID, softAssert);
	}
	
	public void UmValidateRatingCommon(String tcID) throws Exception {

		UmRatingCommonPage objReference = (UmRatingCommonPage) PageManager.instance().createPage(UmRatingCommonPage.class,
				getWebDriver());
		objReference.UmValidateRatingCommon(tcID, softAssert);
	}
	
	
	public void UmRatingDNO(String tcID) throws Exception {

		UmRatingDNOPage objReference = (UmRatingDNOPage) PageManager.instance().createPage(UmRatingDNOPage.class,
				getWebDriver());
		objReference.UmRatingDNO(tcID, softAssert);
	}
	
	public void UmRatingDNO_1(String tcID) throws Exception {

		UmRatingDNOPage objReference = (UmRatingDNOPage) PageManager.instance().createPage(UmRatingDNOPage.class,
				getWebDriver());
		objReference.UmRatingDNO_1(tcID, softAssert);
	}
	
	public void VerifyDnoFormEdit(String tcID) throws Exception {

		UmRatingDNOPage objReference = (UmRatingDNOPage) PageManager.instance().createPage(UmRatingDNOPage.class,
				getWebDriver());
		objReference.VerifyDnoFormEdit(tcID, softAssert);
	}
	public void Verify_SRM_DNO_Error_Msg(String tcID) throws Exception {

		UmRatingDNOPage objReference = (UmRatingDNOPage) PageManager.instance().createPage(UmRatingDNOPage.class,
				getWebDriver());
		objReference.Verify_SRM_DNO_Error_Msg(tcID, softAssert);
	}
	public void Update_SRM_DNO(String tcID) throws Exception {

		UmRatingDNOPage objReference = (UmRatingDNOPage) PageManager.instance().createPage(UmRatingDNOPage.class,
				getWebDriver());
		objReference.Update_SRM_DNO(tcID, softAssert);
	}
	
	public void UmRatingCRI(String tcID) throws Exception {

		UmRatingCRIPage objReference = (UmRatingCRIPage) PageManager.instance().createPage(UmRatingCRIPage.class,
				getWebDriver());
		objReference.UmRatingCRI(tcID, softAssert);
	}
	
	public void Verify_SRM_CRI_Error_Msg(String tcID) throws Exception {

		UmRatingCRIPage objReference = (UmRatingCRIPage) PageManager.instance().createPage(UmRatingCRIPage.class,
				getWebDriver());
		objReference.Verify_SRM_CRI_Error_Msg(tcID, softAssert);
	}
	public void Update_SRM_CRI(String tcID) throws Exception {

		UmRatingCRIPage objReference = (UmRatingCRIPage) PageManager.instance().createPage(UmRatingCRIPage.class,
				getWebDriver());
		objReference.Update_SRM_CRI(tcID, softAssert);
	}
	
	public void UmRatingEPL(String tcID) throws Exception {

		UmRatingEPLPage objReference = (UmRatingEPLPage) PageManager.instance().createPage(UmRatingEPLPage.class,
				getWebDriver());
		objReference.UmRatingEPL(tcID, softAssert);
	}
	public void Verify_SRM_EPL_Error_Msg(String tcID) throws Exception {

		UmRatingEPLPage objReference = (UmRatingEPLPage) PageManager.instance().createPage(UmRatingEPLPage.class,
				getWebDriver());
		objReference.Verify_SRM_EPL_Error_Msg(tcID, softAssert);
	}
	public void Update_SRM_EPL(String tcID) throws Exception {

		UmRatingEPLPage objReference = (UmRatingEPLPage) PageManager.instance().createPage(UmRatingEPLPage.class,
				getWebDriver());
		objReference.Update_SRM_EPL(tcID, softAssert);
	}
	
	public void UmQuoting(String tcID) throws Exception 
	{

		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.UmQuoting(tcID, softAssert);
	}
	public void Verify_SRMTotalError(String tcID) throws Exception 
	{

		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.Verify_SRMTotalError(tcID, softAssert);
	}
	
	public void VerifyCybSharedCheckBox(String tcID) throws Exception {

		UmExposuresPage objReference = (UmExposuresPage) PageManager.instance().createPage(UmExposuresPage.class, getWebDriver());
		objReference.VerifyCybSharedCheckBox(tcID, softAssert);
	}
	public void UM_DownloadProposal(String tcID) throws Exception 
	{

		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.UM_DownloadProposal(tcID, softAssert);
	}
	
	public void UMFinalizeProposal(String tcID) throws Exception 
	{

		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.UMFinalizeProposal(tcID, softAssert);
	}
	
	
	public void UM_ConvertQuote(String tcID) throws Exception 
	{

		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.UM_ConvertQuote(tcID, softAssert);
	}
	
	public void UmCopyCreateQuote(String tcID,String QuoteType) throws Exception 
	{

		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.UmCopyCreateQuote(tcID, softAssert,QuoteType);
	}
	
	
	
	public void UmWorkSheetEditVerify(String tcID) throws Exception 
	{

		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.UmWorkSheetEditVerify(tcID, softAssert);
	}
	
	public void UM_GenerateProposal(String tcID) throws Exception 
	{

		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.UM_GenerateProposal(tcID, softAssert);
	}
	
	public void UMSendProposal(String tcID) throws Exception 
	{

		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.UMSendProposal(tcID, softAssert);
	}
	
	
	public void UmGetRate(String tcID) throws Exception 
	{

		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.UmGetRate(tcID, softAssert);
	}
	
	public void UmGenQuote(String tcID) throws Exception 
	{

		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.UmGenQuote(tcID, softAssert);
	}
	
	public void UmCreateQuote(String tcID ) throws Exception 
	{

		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.UmCreateQuote(tcID, softAssert);
	}
	
	public void VerifyForms(String tcID ) throws Exception 
	{

		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.VerifyForms(tcID, softAssert);
	}
	
	

	public void UmCreateProposal(String tcID) throws Exception 
	{
		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.UmCreateProposal(tcID, softAssert);
	}
	

	public void UmCopySubmission(String tcID, String CopySubType) throws Exception 
	{
		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.UmCopySubmission(tcID, softAssert,CopySubType);
	}
	
	public void UmConvertToQuote(String tcID) throws Exception 
	{
		UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
				getWebDriver());
		objReference.UmConvertToQuote(tcID, softAssert);
	}
	
	public void UmCallingCov(String tcID) throws Exception {

		UmCallingCovPage objReference = (UmCallingCovPage) PageManager.instance().createPage(UmCallingCovPage.class,
				getWebDriver());
		objReference.UmCallingCov(tcID, softAssert);
	}
	public void UmDecline(String tcID) throws Exception {

		UmDeclinePage objReference = (UmDeclinePage) PageManager.instance().createPage(UmDeclinePage.class,
				getWebDriver());
		objReference.UmDecline(tcID, softAssert);
	}
	
	public void PolicyCoverageChange(String tcID) throws Exception {

		PolicyCoverageChangePage objReference = (PolicyCoverageChangePage) PageManager.instance().createPage(PolicyCoverageChangePage.class,
				getWebDriver());
		objReference.PolicyCoverageChange(tcID, softAssert);
	}
	
	
	public void UmBinding(String tcID) throws Exception {

		UmBindingPage objReference = (UmBindingPage) PageManager.instance().createPage(UmBindingPage.class,
			getWebDriver());
	objReference.UmBinding(tcID, softAssert);
}
	
	public void Reinstate(String tcID) throws Exception {

		ReinstatePage objReference = (ReinstatePage) PageManager.instance().createPage(ReinstatePage.class,
				getWebDriver());
		objReference.Reinstate(tcID, softAssert);
	}
	

	public void verifyCovUpdatedForProposal(String tcID) throws Exception {

		UmBindingPage objReference = (UmBindingPage) PageManager.instance().createPage(UmBindingPage.class,
			getWebDriver());
	objReference.verifyCovUpdatedForProposal(tcID, softAssert);
}
	public void UmAddingOffice(String tcID) throws Exception {

		UmAddingOfficePage objReference = (UmAddingOfficePage) PageManager.instance().createPage(UmAddingOfficePage.class,
				getWebDriver());
		objReference.UmAddingOffice(tcID, softAssert);
	}
	public void InsuredAppLogin(String tcID) throws Exception {

		InsuredAppLoginPage objReference = (InsuredAppLoginPage) PageManager.instance().createPage(InsuredAppLoginPage.class,
				getWebDriver());
		objReference.InsuredAppLogin(tcID, softAssert);
	}
	
	public void InsuredAppSearch(String tcID) throws Exception {

		InsuredAppLoginPage objReference = (InsuredAppLoginPage) PageManager.instance().createPage(InsuredAppLoginPage.class,
				getWebDriver());
		objReference.InsuredAppSearch(tcID, softAssert);
	}
	public void InsuredAppVerifyBaseRate(String tcID) throws Exception {

		InsuredAppLoginPage objReference = (InsuredAppLoginPage) PageManager.instance().createPage(InsuredAppLoginPage.class,
				getWebDriver());
		objReference.InsuredAppVerifyBaseRate(tcID, softAssert);
	}
	public void InsuredAppVerifyComboFactor(String tcID) throws Exception {

		InsuredAppLoginPage objReference = (InsuredAppLoginPage) PageManager.instance().createPage(InsuredAppLoginPage.class,
				getWebDriver());
		objReference.InsuredAppVerifyComboFactor(tcID, softAssert);
	}
	
	public void InsuredAppValidationPolicyChange(String tcID) throws Exception {

		InsuredAppLoginPage objReference = (InsuredAppLoginPage) PageManager.instance().createPage(InsuredAppLoginPage.class,
				getWebDriver());
		objReference.InsuredAppValidationPolicyChange(tcID, softAssert);
	}
	public void InsuredAppValidationNB(String tcID) throws Exception {

		InsuredAppLoginPage objReference = (InsuredAppLoginPage) PageManager.instance().createPage(InsuredAppLoginPage.class,
				getWebDriver());
		objReference.InsuredAppValidationNB(tcID, softAssert);
	}
	
	public void InsuredAppValidation_BP(String tcID) throws Exception {

		InsuredAppLoginPage objReference = (InsuredAppLoginPage) PageManager.instance().createPage(InsuredAppLoginPage.class,
				getWebDriver());
		objReference.InsuredAppValidation_BP(tcID, softAssert);
	}
	public void InsuredAppValidation_ST(String tcID) throws Exception {

		InsuredAppLoginPage objReference = (InsuredAppLoginPage) PageManager.instance().createPage(InsuredAppLoginPage.class,
				getWebDriver());
		objReference.InsuredAppValidation_ST(tcID, softAssert);
	}
	
	public void InsuredAppLogOut(String tcID) throws Exception {

		InsuredAppLoginPage objReference = (InsuredAppLoginPage) PageManager.instance().createPage(InsuredAppLoginPage.class,
				getWebDriver());
		objReference.InsuredAppLogOut(tcID, softAssert);
	}
	
	public void Rescind(String tcID) throws Exception {

		RescindPage objReference = (RescindPage) PageManager.instance().createPage(RescindPage.class,
				getWebDriver());
		objReference.Rescind(tcID, softAssert);
	}
	
	public void PCValidation(String tcID) throws Exception {

		PCValidationPage objReference = (PCValidationPage) PageManager.instance().createPage(PCValidationPage.class,
				getWebDriver());
		objReference.PCValidation(tcID, softAssert);
	}
	public void PremiumCapture(String tcID) throws Exception {

		PremiumCapturePage objReference = (PremiumCapturePage) PageManager.instance().createPage(PremiumCapturePage.class,
				getWebDriver());
		objReference.PremiumCapture(tcID, softAssert);
	}
	public void Modifiers(String tcID) throws Exception {

		ModifiersPage objReference = (ModifiersPage) PageManager.instance().createPage(ModifiersPage.class,
				getWebDriver());
		objReference.Modifiers(tcID, softAssert);
	}
	public void RemoveOptionalCov(String tcID) throws Exception {

		RemoveOptionalCovPage objReference = (RemoveOptionalCovPage) PageManager.instance().createPage(RemoveOptionalCovPage.class,
				getWebDriver());
		objReference.RemoveOptionalCov(tcID, softAssert);
	}
	public void ChangePremiumCapture(String tcID) throws Exception {

		ChangePremiumCapturePage objReference = (ChangePremiumCapturePage) PageManager.instance().createPage(ChangePremiumCapturePage.class,
				getWebDriver());
		objReference.ChangePremiumCapture(tcID, softAssert);
	}
	
	public void PreRenewalDirection(String tcID) throws Exception {

		PreRenewalDirectionPage objReference = (PreRenewalDirectionPage) PageManager.instance().createPage(PreRenewalDirectionPage.class,
				getWebDriver());
		objReference.PreRenewalDirection(tcID, softAssert);
	}
	
	public void CoverageValidation(String tcID) throws Exception {

		CoverageValidationPage objReference = (CoverageValidationPage) PageManager.instance().createPage(CoverageValidationPage.class,getWebDriver());
		objReference.CoverageValidation(tcID, softAssert);
	}
	public void ExposureValidation(String tcID) throws Exception {

		ExposureValidationPage objReference = (ExposureValidationPage) PageManager.instance().createPage(ExposureValidationPage.class,getWebDriver());
		objReference.ExposureValidation(tcID, softAssert);
	}
	
	public void ModifiersValidation(String tcID) throws Exception {

		ModifiersValidationPage objReference = (ModifiersValidationPage) PageManager.instance().createPage(ModifiersValidationPage.class,getWebDriver());
		objReference.ModifiersValidation(tcID, softAssert);
	}
	public void UmIssuance(String tcID) throws Exception {

		UmIssuancePage objReference = (UmIssuancePage) PageManager.instance().createPage(UmIssuancePage.class,
			getWebDriver());
	objReference.UmIssuance(tcID, softAssert);
}
	
	public void CaptureUMTax_KY(String tcID) throws Exception {

		UmPremiumCapturePage objReference = (UmPremiumCapturePage) PageManager.instance().createPage(UmPremiumCapturePage.class,
			getWebDriver());
	objReference.CaptureUMTax_KY(tcID, softAssert);
}
	
	public void CaptureUMTax_NJ(String tcID) throws Exception {

		UmPremiumCapturePage objReference = (UmPremiumCapturePage) PageManager.instance().createPage(UmPremiumCapturePage.class,
			getWebDriver());
	objReference.CaptureUMTax_NJ(tcID, softAssert);
}
	
	public void CapturePremiumBreakdown(String tcID) throws Exception {

		UmPremiumCapturePage objReference = (UmPremiumCapturePage) PageManager.instance().createPage(UmPremiumCapturePage.class,
			getWebDriver());
	objReference.CapturePremiumBreakdown(tcID, softAssert);
}
	
	public void UM_DownloadPolicyDoc(String tcID) throws Exception {

		UmIssuancePage objReference = (UmIssuancePage) PageManager.instance().createPage(UmIssuancePage.class,
			getWebDriver());
	objReference.UM_DownloadPolicyDoc(tcID, softAssert);
}
	
	public void getUMPolicy(String tcID) throws Exception {

		UmIssuancePage objReference = (UmIssuancePage) PageManager.instance().createPage(UmIssuancePage.class,
			getWebDriver());
	objReference.getUMPolicy(tcID, softAssert);
}
	
	public void BillingInvoice_WriteDetails(String tcID) throws Exception {

		UmIssuancePage objReference = (UmIssuancePage) PageManager.instance().createPage(UmIssuancePage.class,
			getWebDriver());
	objReference.BillingInvoice_WriteDetails(tcID, softAssert);
}
	
	public void BillingInvoice_Validation(String tcID) throws Exception {

		UmIssuancePage objReference = (UmIssuancePage) PageManager.instance().createPage(UmIssuancePage.class,
			getWebDriver());
	objReference.BillingInvoice_Validation(tcID, softAssert);
}

	public void UmSearchSubmission(String tcID) throws Exception {

		UmSearchSubmissionPage objReference = (UmSearchSubmissionPage) PageManager.instance().createPage(UmSearchSubmissionPage.class,
			getWebDriver());
	objReference.UmSearchSubmission(tcID, softAssert);
}
	
	public void UmPowerBIReports_LinkVerification(String tcID) throws Exception {

		UmSearchSubmissionPage objReference = (UmSearchSubmissionPage) PageManager.instance().createPage(UmSearchSubmissionPage.class,
			getWebDriver());
	objReference.UmPowerBIReports_LinkVerification(tcID, softAssert);
}
	
	public void UmPremiumCapture(String tcID) throws Exception {

		UmPremiumCapturePage objReference = (UmPremiumCapturePage) PageManager.instance().createPage(UmPremiumCapturePage.class,
			getWebDriver());
	objReference.UmPremiumCapture(tcID, softAssert);
}
	


	public void UmSearchPolicy(String tcID) throws Exception {

		UmSearchPolicyPage objReference = (UmSearchPolicyPage) PageManager.instance().createPage(UmSearchPolicyPage.class,
			getWebDriver());
	objReference.UmSearchPolicy(tcID, softAssert);
}
	public void excelRater(String tcID) throws Exception {

		ExcelRaterPage objReference = (ExcelRaterPage) PageManager.instance().createPage(ExcelRaterPage.class,
			getWebDriver());
	objReference.excelRater(tcID, softAssert);
}
	public void SubmitRenewal(String tcID) throws Exception {

		SubmitRenewalPage objReference = (SubmitRenewalPage) PageManager.instance().createPage(SubmitRenewalPage.class,
			getWebDriver());
	objReference.SubmitRenewal(tcID, softAssert);
}
	public void UmRatingEMP(String tcID) throws Exception {

		UmRatingEMPPage objReference = (UmRatingEMPPage) PageManager.instance().createPage(UmRatingEMPPage.class,
				getWebDriver());
		objReference.UmRatingEMP(tcID, softAssert);
	}
	
	public void Verify_SRM_EMP_Error_Msg(String tcID) throws Exception {

		UmRatingEMPPage objReference = (UmRatingEMPPage) PageManager.instance().createPage(UmRatingEMPPage.class,
				getWebDriver());
		objReference.Verify_SRM_EMP_Error_Msg(tcID, softAssert);
	}
	public void Update_SRM_EMP(String tcID) throws Exception {

		UmRatingEMPPage objReference = (UmRatingEMPPage) PageManager.instance().createPage(UmRatingEMPPage.class,
				getWebDriver());
		objReference.Update_SRM_EMP(tcID, softAssert);
	}
	
	public void UmRatingENO(String tcID) throws Exception {

		UmRatingENOPage objReference = (UmRatingENOPage) PageManager.instance().createPage(UmRatingENOPage.class,
				getWebDriver());
		objReference.UmRatingENO(tcID, softAssert);
	}
	public void Verify_SRM_ENO_Error_Msg(String tcID) throws Exception {

		UmRatingENOPage objReference = (UmRatingENOPage) PageManager.instance().createPage(UmRatingENOPage.class,
				getWebDriver());
		objReference.Verify_SRM_ENO_Error_Msg(tcID, softAssert);
	}
	public void Update_SRM_ENO(String tcID) throws Exception {

		UmRatingENOPage objReference = (UmRatingENOPage) PageManager.instance().createPage(UmRatingENOPage.class,
				getWebDriver());
		objReference.Update_SRM_ENO(tcID, softAssert);
	}
	public void UmRatingKNR(String tcID) throws Exception {

		UmRatingKNRPage objReference = (UmRatingKNRPage) PageManager.instance().createPage(UmRatingKNRPage.class,
				getWebDriver());
		objReference.UmRatingKNR(tcID, softAssert);
	}
	public void Verify_SRM_KNR_Error_Msg(String tcID) throws Exception {

		UmRatingKNRPage objReference = (UmRatingKNRPage) PageManager.instance().createPage(UmRatingKNRPage.class,
				getWebDriver());
		objReference.Verify_SRM_KNR_Error_Msg(tcID, softAssert);
	}
	public void Update_SRM_KNR(String tcID) throws Exception {

		UmRatingKNRPage objReference = (UmRatingKNRPage) PageManager.instance().createPage(UmRatingKNRPage.class,
				getWebDriver());
		objReference.Update_SRM_KNR(tcID, softAssert);
	}
	public void UmRatingFID(String tcID) throws Exception {

		UmRatingFIDPage objReference = (UmRatingFIDPage) PageManager.instance().createPage(UmRatingFIDPage.class,
				getWebDriver());
		objReference.UmRatingFID(tcID, softAssert);
	}	
	public void Verify_SRM_FID_Error_Msg(String tcID) throws Exception {

		UmRatingFIDPage objReference = (UmRatingFIDPage) PageManager.instance().createPage(UmRatingFIDPage.class,
				getWebDriver());
		objReference.Verify_SRM_FID_Error_Msg(tcID, softAssert);
	}
	public void Update_SRM_FID(String tcID) throws Exception {

		UmRatingFIDPage objReference = (UmRatingFIDPage) PageManager.instance().createPage(UmRatingFIDPage.class,
				getWebDriver());
		objReference.Update_SRM_FID(tcID, softAssert);
	}
	

	public void UmRatingCYB(String tcID) throws Exception {

		UmRatingCYBPage objReference = (UmRatingCYBPage) PageManager.instance().createPage(UmRatingCYBPage.class,
				getWebDriver());
		objReference.UmRatingCYB(tcID, softAssert);
	}
	public void Verify_SRM_CYB(String tcID) throws Exception {

		UmRatingCYBPage objReference = (UmRatingCYBPage) PageManager.instance().createPage(UmRatingCYBPage.class,
				getWebDriver());
		objReference.Verify_SRM_CYB(tcID, softAssert);
	}
	public void Verify_SRM_CYB_Error_Msg(String tcID) throws Exception {

		UmRatingCYBPage objReference = (UmRatingCYBPage) PageManager.instance().createPage(UmRatingCYBPage.class,
				getWebDriver());
		objReference.Verify_SRM_CYB_Error_Msg(tcID, softAssert);
	}
	public void Update_SRM_CYB(String tcID) throws Exception {

		UmRatingCYBPage objReference = (UmRatingCYBPage) PageManager.instance().createPage(UmRatingCYBPage.class,
				getWebDriver());
		objReference.Update_SRM_CYB(tcID, softAssert);
	}
	

	public void UmValMinMaxClauseTerm(String tcID) throws Exception {

		UmRatingCYBPage objReference = (UmRatingCYBPage) PageManager.instance().createPage(UmRatingCYBPage.class,
				getWebDriver());
		objReference.UmValMinMaxClauseTerm(tcID, softAssert);
	}
	public void UmCvgLvlPremiumValidatn(String tcID) throws Exception {

		UmCvgLvlPremiumValidatnPage objReference = (UmCvgLvlPremiumValidatnPage) PageManager.instance().createPage(UmCvgLvlPremiumValidatnPage.class,
				getWebDriver());
		objReference.UmCvgLvlPremiumValidatn(tcID, softAssert);
	}
	
	public void UmRatingEZExcess(String tcID) throws Exception {

		UmRatingEZExcessPage objReference = (UmRatingEZExcessPage) PageManager.instance().createPage(UmRatingEZExcessPage.class,
				getWebDriver());
		objReference.UmRatingEZExcess(tcID, softAssert);
	}
	
	public void verifyLossControl(String tcID) throws Exception {

		UmRatingLPLNonAdmittedPage objReference = (UmRatingLPLNonAdmittedPage) PageManager.instance().createPage(UmRatingLPLNonAdmittedPage.class,
				getWebDriver());
		objReference.verifyLossControl(tcID, softAssert);
	}
	
	public void CaptureIRMFactor(String tcID) throws Exception {

		UmRatingLPLNonAdmittedPage objReference = (UmRatingLPLNonAdmittedPage) PageManager.instance().createPage(UmRatingLPLNonAdmittedPage.class,
				getWebDriver());
		objReference.CaptureIRMFactor(tcID, softAssert);
	}
	
	public void CalcComboFactor(String tcID) throws Exception {

		UmRatingLPLNonAdmittedPage objReference = (UmRatingLPLNonAdmittedPage) PageManager.instance().createPage(UmRatingLPLNonAdmittedPage.class,
				getWebDriver());
		objReference.CalcComboFactor(tcID, softAssert);
	}
	public void UmRatingEZExcessMinMaxValidation(String tcID) throws Exception {

		UmRatingEZExcessPage objReference = (UmRatingEZExcessPage) PageManager.instance().createPage(UmRatingEZExcessPage.class,
				getWebDriver());
		objReference.UmRatingEZExcessMinMaxValidation(tcID, softAssert);
	}

	public void UmRatingLPLAdmitted(String tcID) throws Exception {

		UmRatingLPLAdmittedPage objReference = (UmRatingLPLAdmittedPage) PageManager.instance().createPage(UmRatingLPLAdmittedPage.class,
				getWebDriver());
		objReference.UmRatingLPLAdmitted(tcID, softAssert);
	}
	public void UmRatingLPLNonAdmitted(String tcID) throws Exception {

		UmRatingLPLNonAdmittedPage objReference = (UmRatingLPLNonAdmittedPage) PageManager.instance().createPage(UmRatingLPLNonAdmittedPage.class,
				getWebDriver());
		objReference.UmRatingLPLNonAdmitted(tcID, softAssert);
	}
	public void UmRatingSlimCommon(String tcID) throws Exception {

		UmRatingSlimCommonPage objReference = (UmRatingSlimCommonPage) PageManager.instance().createPage(UmRatingSlimCommonPage.class,
				getWebDriver());
		objReference.UmRatingSlimCommon(tcID, softAssert);
	}
	
	public void UmAddingManuScriptEndts(String tcID) throws Exception {

		UmRatingManuScriptEndtsPage objReference = (UmRatingManuScriptEndtsPage) PageManager.instance().createPage(UmRatingManuScriptEndtsPage.class,
				getWebDriver());
		objReference.UmAddingManuScriptEndts(tcID, softAssert);
	}
	
	public void UmManuScriptEndts_Forms(String tcID) throws Exception {

		UmRatingManuScriptEndtsPage objReference = (UmRatingManuScriptEndtsPage) PageManager.instance().createPage(UmRatingManuScriptEndtsPage.class,
				getWebDriver());
		objReference.UmManuScriptEndts_Forms(tcID, softAssert);
	}
	
	public void UmAddingSubInfo(String tcID) throws Exception {

		UmRatingSubInfoPage objReference = (UmRatingSubInfoPage) PageManager.instance().createPage(UmRatingSubInfoPage.class,
				getWebDriver());
		objReference.UmAddingSubInfo(tcID, softAssert);
	}
	
	public void UmValidateWritingApproach(String tcID) throws Exception {

		UmRatingSubInfoPage objReference = (UmRatingSubInfoPage) PageManager.instance().createPage(UmRatingSubInfoPage.class,
				getWebDriver());
		objReference.UmValidateWritingApproach(tcID, softAssert);
	}
	
	//Escape Code
	
	public void LoginToEscape(String tcID,String DeviceName) throws Exception
 	{
 		Login objLogin = (Login) PageManager.instance().createPage( Login.class, getWebDriver());
 		objLogin.LoginToEscape(tcID, softAssert,DeviceName);
 	}
	public void LogoutFormEscape(String tcID,String DeviceName) throws Exception
 	{
		
 		Login objLogin = (Login) PageManager.instance().createPage( Login.class, getWebDriver());
 		objLogin.LogoutFormEscape(tcID, softAssert,DeviceName);
 	}
	public void CreateAccount(String tcID) throws Exception
 	{
   		
		Account objAccount = (Account) PageManager.instance().createPage( Account.class, getWebDriver());
		objAccount.CreateAccount(tcID, softAssert);
 	}
	public void clk_CreateNewSubmission(String tcID) throws Exception
 	{
   		
		Account objAccount = (Account) PageManager.instance().createPage( Account.class, getWebDriver());
		objAccount.clk_CreateNewSubmission(tcID, softAssert);
 	}
	
	
	
	
	public void verify_UMAccountDetails_InEscape(String tcID) throws Exception
 	{
   		
		Account objAccount = (Account) PageManager.instance().createPage( Account.class, getWebDriver());
		objAccount.verify_UMAccountDetails_InEscape(tcID, softAssert);
 	}
	
	
	public void NewSubmission(String tcID) throws Exception
 	{
   		
		NewSubmission objNewSubmission = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
		objNewSubmission.NewSubmission(tcID, softAssert);
 	}
	public void verify_UMSUbmissionDetais_inEscape(String tcID) throws Exception
 	{
   		
		NewSubmission objNewSubmission = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
		objNewSubmission.verify_UMSUbmissionDetais_inEscape(tcID, softAssert);
 	}
	
	
	
	
	public void EditSubmission(String tcID,String CopyOREdit) throws Exception
 	{
   		
		NewSubmission objNewSubmission = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
		objNewSubmission.EditSubmission(tcID, softAssert,CopyOREdit);
 	}
	
	public void clkCreateThisSubmission(String tcID) throws Exception
 	{
   		
		NewSubmission objNewSubmission = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
		objNewSubmission.clkCreateThisSubmission(tcID, softAssert);
 	}
	
	public void clkSave(String tcID) throws Exception
 	{
   		
		NewSubmission objNewSubmission = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
		objNewSubmission.clkSave(tcID, softAssert);
 	}
	public void ProcessForNextYearRenewal(String tcID) throws Exception
 	{
   		
		NewSubmission objSubmission = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
		objSubmission.ProcessForNextYearRenewal(tcID,softAssert);
 	}
	public void AddPolicy(String tcID,String type) throws Exception
 	{
   		
		NewSubmission objSubmission = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
		objSubmission.AddNewPolicy(tcID, softAssert,type);
 	}
	
	public void verify_RenewalPolicy_Version(String tcID,String RENVertion) throws Exception
 	{
   		
		AddPolicy objSubmission = (AddPolicy) PageManager.instance().createPage( AddPolicy.class, getWebDriver());
		objSubmission.verify_RenewalPolicy_Version(tcID, softAssert,RENVertion);
 	}
	
	
	public void IssueNewPolicy(String tcID) throws Exception
 	{
   		
		AddPolicy objPolicy = (AddPolicy) PageManager.instance().createPage( AddPolicy.class, getWebDriver());
		objPolicy.IssueNewPolicy(tcID, softAssert);
 	}
	public void clkAddPolicy(String tcID) throws Exception
 	{
   		
		AddPolicy objPolicy = (AddPolicy) PageManager.instance().createPage( AddPolicy.class, getWebDriver());
		objPolicy.clkAddPolicy(tcID, softAssert);
 	}
	
	public void verify_UMPoloicyDetails_inEscape(String tcID) throws Exception
 	{
   		
		AddPolicy objPolicy = (AddPolicy) PageManager.instance().createPage( AddPolicy.class, getWebDriver());
		objPolicy.verify_UMPoloicyDetails_inEscape(tcID, softAssert);
 	}
	
	
	
	public void Verify_Submission_Search(String tcID,String DeviceName) throws Exception
 	{
   		
		Search objSearch = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
		objSearch.Verify_Submission_Search(tcID, softAssert,DeviceName);
 	}
	
	public void UM_Submission_Search(String tcID,String DeviceName) throws Exception
 	{
   		
		Search objSearch = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
		objSearch.UM_Submission_Search(tcID, softAssert,DeviceName);
 	}
	
	public void Verify_Policy_Search(String tcID,String DeviceName) throws Exception
 	{
		
   		
		Search objSearch = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
		objSearch.Verify_Policy_Search(tcID, softAssert,DeviceName);
 	}
	public void OpenSubSearchResult(String tcID) throws Exception
 	{
   		
		NewSubmission objVerifyCopySubmission = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
		objVerifyCopySubmission.OpenSubSearchResult(tcID, softAssert);
 	}
	public void VerifyProcessNextYearRenewal(String tcID) throws Exception
 	{
   		
		NewSubmission objVerifyCopySubmission = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
		objVerifyCopySubmission.VerifyProcessNextYearRenewal(tcID, softAssert);
 	}
	public void clkOFACSearchProcessRenewal(String tcID,String type) throws Exception
 	{
   		
		NewSubmission objVerifyCopySubmission = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
		objVerifyCopySubmission.clkOFACSearchProcessRenewal(tcID, softAssert,type);
 	}
	
	public void UmBindPremium(String tcID) throws Exception {

		UmBindingPage objReference = (UmBindingPage) PageManager.instance().createPage(UmBindingPage.class,
			getWebDriver());
	objReference.UmBindPremium(tcID, softAssert);
	}
	
	public void UM_DownloadBinder(String tcID) throws Exception {

		UmBindingPage objReference = (UmBindingPage) PageManager.instance().createPage(UmBindingPage.class,
			getWebDriver());
	objReference.UM_DownloadBinder(tcID, softAssert);
	}
	public void pcPremiumCaptureItlAdd(String tcID) throws Exception {

		PremiumCapturePage objReference = (PremiumCapturePage) PageManager.instance().createPage(PremiumCapturePage.class,
				getWebDriver());
		objReference.pcPremiumCaptureItlAdd(tcID, softAssert);
	}
	public void InsuredAppValidationPolicyChangeRunOff(String tcID, String shortRun, String premium) throws Exception {

		InsuredAppLoginPage objReference = (InsuredAppLoginPage) PageManager.instance().createPage(InsuredAppLoginPage.class,
				getWebDriver());
		objReference.InsuredAppValidationPolicyChangeRunOff(tcID, softAssert,shortRun, premium);
	}
	//Added policy change runoff 
		public void PolicyChangeRunOff(String tcID) throws Exception {

			PolicyChangePage objReference = (PolicyChangePage) PageManager.instance().createPage(PolicyChangePage.class,
					getWebDriver());
			objReference.PolicyChangeRunOff(tcID, softAssert);
		}
		
		public void PolicyChangeRunOff_1(String tcID) throws Exception {

			PolicyChangePage objReference = (PolicyChangePage) PageManager.instance().createPage(PolicyChangePage.class,
					getWebDriver());
			objReference.PolicyChangeRunOff_1(tcID, softAssert);
		}
		
		public void ChangePremiumCaptureRunoff(String tcID, String rate, String premium) throws Exception {

			ChangePremiumCapturePage objReference = (ChangePremiumCapturePage) PageManager.instance().createPage(ChangePremiumCapturePage.class,
					getWebDriver());
			objReference.ChangePremiumCaptureRunoff(tcID, softAssert, rate , premium);
		}
		public void UmSubmissionInformation(String tcID) throws Exception {

			UmGetSubmissionNumberPage objReference = (UmGetSubmissionNumberPage) PageManager.instance().createPage(UmGetSubmissionNumberPage.class, getWebDriver());
			objReference.UmSubmissionInformation(tcID, softAssert);
		}
		
		public void loginToImageRight(String tcID, String DeviceName) throws Exception
	 	{
	   		
			IRLogin objLoginIR = (IRLogin) PageManager.instance().createPage( IRLogin.class, getWebDriver());
			objLoginIR.loginToImageRight(tcID, softAssert,DeviceName);
	 	}
		
		public void searchFile(String tcID) throws Exception
	 	{
	   		
			IRFileSearch objFileSearch = (IRFileSearch) PageManager.instance().createPage( IRFileSearch.class, getWebDriver());
			objFileSearch.searchFile(tcID, softAssert);
	 	}
		
		public void verifyPolicyDocuments(String tcID) throws Exception
	 	{
	   		
			IROpenFile objFileVerify = (IROpenFile) PageManager.instance().createPage( IROpenFile.class, getWebDriver());
			objFileVerify.verifyPolicyDocuments(tcID, softAssert);
	 	}
		
		public void searchSubmissionInEscape(String tcID) throws Exception
	 	{
	   		
			Search searchSubmission = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
			searchSubmission.searchSubmissionInEscape(tcID, softAssert);
	 	
	 	}
		public void verifyIRMChangesNonAdmitted(String tcID) throws Exception {

			UmRatingLPLNonAdmittedPage objReference = (UmRatingLPLNonAdmittedPage) PageManager.instance().createPage(UmRatingLPLNonAdmittedPage.class,
					getWebDriver());
			objReference.verifyIRMChangesNonAdmitted(tcID, softAssert);
		}
		public void verifyIRMChanges(String tcID) throws Exception {

			UmRatingLPLAdmittedPage objReference = (UmRatingLPLAdmittedPage) PageManager.instance().createPage(UmRatingLPLAdmittedPage.class,
					getWebDriver());
			objReference.verifyIRMChanges(tcID, softAssert);
		}
		public void verifyErrorForLPLClaimExpenses(String tcID) throws Exception 
		{

			UmQuotingPage objReference = (UmQuotingPage) PageManager.instance().createPage(UmQuotingPage.class,
					getWebDriver());
			objReference.verifyErrorForLPLClaimExpenses(tcID, softAssert);
		}
		public void getUWBranchOfficeDetails(String tcID) throws Exception {

			UmGetSubmissionNumberPage objReference = (UmGetSubmissionNumberPage) PageManager.instance().createPage(UmGetSubmissionNumberPage.class, getWebDriver());
			objReference.getUWBranchOfficeDetails(tcID, softAssert);
		}
		public void verify_LOB(String tcID) throws Exception
	 	{
	   		
			NewSubmission objNewSubmission = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
			objNewSubmission.verify_LOB(tcID, softAssert);
	 	}
		public void uploadTaskFile(String tcID, String DeviceName) throws Exception {

			UmCollaborationToolPage objReference = (UmCollaborationToolPage) PageManager.instance().createPage(UmCollaborationToolPage.class, getWebDriver());
			objReference.uploadTaskFile(tcID, softAssert, DeviceName);
		}
		public void verifyObligeeDetails(String tcID) throws Exception {

			PCValidationPage objReference = (PCValidationPage) PageManager.instance().createPage(PCValidationPage.class,
					getWebDriver());
			objReference.verifyObligeeDetails(tcID, softAssert);
		}
		public void verifyMNPCIMF4Surcharges(String tcID) throws Exception {

			UmGetSubmissionNumberPage objReference = (UmGetSubmissionNumberPage) PageManager.instance().createPage(UmGetSubmissionNumberPage.class, getWebDriver());
			objReference.verifyMNPCIMF4Surcharges(tcID, softAssert);
		}
		public void verifyMNFireCharges(String tcID) throws Exception {

			PremiumCapturePage objReference = (PremiumCapturePage) PageManager.instance().createPage(PremiumCapturePage.class,
					getWebDriver());
			objReference.verifyMNFireCharges(tcID, softAssert);
		}
		public void verifyFIDPremium(String tcID) throws Exception {

			UmGetSubmissionNumberPage objReference = (UmGetSubmissionNumberPage) PageManager.instance().createPage(UmGetSubmissionNumberPage.class,
					getWebDriver());
			objReference.verifyFIDPremium(tcID, softAssert);
		}
		
		public void verifyCYBPremiumAgainstRater(String tcID) throws Exception {

			UmGetSubmissionNumberPage objReference = (UmGetSubmissionNumberPage) PageManager.instance().createPage(UmGetSubmissionNumberPage.class,
					getWebDriver());
			objReference.verifyCYBPremiumAgainstRater(tcID, softAssert);
		}
		public void verifySubtotalWhenSharedLimitChecked(String tcID) throws Exception {

			InsuredAppLoginPage objReference = (InsuredAppLoginPage) PageManager.instance().createPage(InsuredAppLoginPage.class,
					getWebDriver());
			objReference.verifySubtotalWhenSharedLimitChecked(tcID, softAssert);
		}
		
		

	
	
}
