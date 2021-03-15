package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmRatingEMPPage extends Page{

	@ElementDefinition
	public String Error_SRM_OK_btn="Error_SRM_OK_btn";
	@ElementDefinition
	public String Error_SRM="Error_SRM";
	@ElementDefinition
	public String btnEMPPage ="btnEMPPage";
	@ElementDefinition
	public String txtEMPAggregateLimit = "txtEMPAggregateLimit";
	@ElementDefinition
	public String txtEMPRetention = "txtEMPRetention";
	@ElementDefinition
	public String txtEMPPriordate = "txtEMPPriordate";
	
	@ElementDefinition
	public String btnAreaofPracticeSelectOption = "btnAreaofPracticeSelectOption";
	@ElementDefinition
	public String btnLitigationHistorySelectOption = "btnLitigationHistorySelectOption";
	@ElementDefinition
	public String btnPublicDebtExposureSelectOption = "btnPublicDebtExposureSelectOption";
	@ElementDefinition
	public String btnMergerAcquisitionorDivestitureActivitySelectOption = "btnMergerAcquisitionorDivestitureActivitySelectOption";
	@ElementDefinition
	public String btnUseofExternalLegalResourcesSelectOption = "btnUseofExternalLegalResourcesSelectOption";
	@ElementDefinition
	public String btnExperienceofEmployedLawyersSelectOption = "btnExperienceofEmployedLawyersSelectOption";
	@ElementDefinition
	public String btnOtherLegalServicesPerformedSelectOption = "btnOtherLegalServicesPerformedSelectOption";

	@ElementDefinition
	public String txtAreaofPracticeSelection = "txtAreaofPracticeSelection";
	@ElementDefinition
	public String txtLitigationHistorySelection = "txtLitigationHistorySelection";
	@ElementDefinition
	public String txtPublicDebtExposureSelection="txtPublicDebtExposureSelection";
	@ElementDefinition
	public String txtMergerAcquisitionorDivestitureActivitySelection="txtMergerAcquisitionorDivestitureActivitySelection";
	@ElementDefinition
	public String txtUseofExternalLegalResourcesSelection="txtUseofExternalLegalResourcesSelection";
	@ElementDefinition
	public String txtExperienceofEmployedLawyersSelection ="txtExperienceofEmployedLawyersSelection";
	@ElementDefinition
	public String txtOtherLegalServicesPerformedSelection="txtOtherLegalServicesPerformedSelection";

	@ElementDefinition
	public String txtSRStrengthofCorporateGovernance = "txtSRStrengthofCorporateGovernance";
	@ElementDefinition
	public String txtSRLossExperience ="txtSRLossExperience";
	@ElementDefinition
	public String txtSROverallFinancialLiquidity = "txtSROverallFinancialLiquidity";
	@ElementDefinition
	public String txtSRAffectedbyRecession = "txtSRAffectedbyRecession";
	@ElementDefinition
	public String txtSRQualityofManagement = "txtSRQualityofManagement";
	@ElementDefinition
	public String chkEMPSeparateDefenseCostCoverage = "chkEMPSeparateDefenseCostCoverage";
	@ElementDefinition
	public String chkEMPSecuritiesCoverage = "chkEMPSecuritiesCoverage";
	@ElementDefinition
	public String txtEMPSeparateDefenseCostCoverage = "txtEMPSeparateDefenseCostCoverage";
	@ElementDefinition
	public String txtEMPSecuritiesCoverage = "txtEMPSecuritiesCoverage";
	@ElementDefinition
	public String	btnUpdateCoverages = "btnUpdateCoverages";
	
	
	@ElementDefinition
	public String btnDutytoDefendSelectionFactorSelectOption = "btnDutytoDefendSelectionFactorSelectOption";
	@ElementDefinition
	public String btnEndorsementFactorSelectOption= "btnEndorsementFactorSelectOption";
	@ElementDefinition
	public String btnSecuritiesCoverageFactorSelectOption= "btnSecuritiesCoverageFactorSelectOption";
	 
	@ElementDefinition
	public String	txtDutytoDefendSelectionFactorSelectOption= "txtDutytoDefendSelectionFactorSelectOption";
	@ElementDefinition
	public String	 txtEndorsementFactorSelectOption= "txtEndorsementFactorSelectOption";
	@ElementDefinition
	public String	txtSecuritiesCoverageFactorSelectOption= "txtSecuritiesCoverageFactorSelectOption";
	 
	@ElementDefinition
	public String	txtDutytoDefendSelectionFactorSelection= "txtDutytoDefendSelectionFactorSelection";
	@ElementDefinition
	public String	txtEndorsementFactorSelection= "txtEndorsementFactorSelection";
	@ElementDefinition
	public String	txtSecuritiesCoverageFactorSelection= "txtSecuritiesCoverageFactorSelection";
	@TimeMethod
	@ScreenShot
	public void UmRatingEMP(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_SRM_EMP_Error_Msg(String tcID, SoftAssert softAs) throws Exception;
	public void Update_SRM_EMP(String tcID, SoftAssert softAs) throws Exception;

}