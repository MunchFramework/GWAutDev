package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmRatingEPLPage extends Page{

	@ElementDefinition
	public String Error_SRM_OK_btn="Error_SRM_OK_btn";
	@ElementDefinition
	public String Error_SRM="Error_SRM";
	@ElementDefinition
	public String btnRatingEPLtab = "btnRatingEPLtab";
	@ElementDefinition
	public String txtTotalEmployees = "txtTotalEmployees";
	@ElementDefinition
	public String txtAggregateLimit = "txtAggregateLimit";
	@ElementDefinition
	public String txtRetention = "txtRetention";
	@ElementDefinition
	public String txtDate = "txtDate";
	@ElementDefinition
	public String ddDutyToDefend = "ddDutyToDefend";
	@ElementDefinition
	public String ddDFSelectOption = "ddDFSelectOption";
	@ElementDefinition
	public String ddCMSelectOption = "ddCMSelectOption";
	@ElementDefinition
	public String txtCMSelection = "txtCMSelection";
	@ElementDefinition
	public String txtAddtnlClaimExpLimit = "txtAddtnlClaimExpLimit";
	@ElementDefinition
	public String btnCMThirdPartExposure = "btnCMThirdPartExposure";
	@ElementDefinition
	public String txtCMThirdPartExposure = "txtCMThirdPartExposure";

	@ElementDefinition
	public String btnDFHazardCountyLoc = "btnDFHazardCountyLoc";   
	@ElementDefinition
	public String txtDFHazardCountyLoc = "txtDFHazardCountyLoc";
	@ElementDefinition
	public String txtDFHazardCountyLocSel = "txtDFHazardCountyLocSel";
	@ElementDefinition
	public String btnDFNatureofOperations = "btnDFNatureofOperations";
	@ElementDefinition
	public String txtDFNatureofOperations = "txtDFNatureofOperations";
	@ElementDefinition
	public String txtDFNatureofOperationsSel = "txtDFNatureofOperationsSel";
	@ElementDefinition
	public String btnDFNumberofYearsinBusiness = "btnDFNumberofYearsinBusiness";
	@ElementDefinition
	public String txtDFNumberofYearsinBusiness = "txtDFNumberofYearsinBusiness";
	@ElementDefinition
	public String txtDFNumberofYearsinBusinessSel = "txtDFNumberofYearsinBusinessSel";
	@ElementDefinition
	public String btnDFMergerAcquisitionorDivestitureActivity = "btnDFMergerAcquisitionorDivestitureActivity";
	@ElementDefinition
	public String txtDFMergerAcquisitionorDivestitureActivity = "txtDFMergerAcquisitionorDivestitureActivity";
	@ElementDefinition
	public String txtDFMergerAcquisitionorDivestitureActivitySel = "txtDFMergerAcquisitionorDivestitureActivitySel";
	@ElementDefinition
	public String btnDFPastorContemplatedLayofforClosingActivity = "btnDFPastorContemplatedLayofforClosingActivity";
	@ElementDefinition
	public String txtDFPastorContemplatedLayofforClosingActivity = "txtDFPastorContemplatedLayofforClosingActivity";
	@ElementDefinition
	public String txtDFPastorContemplatedLayofforClosingActivitySel = "txtDFPastorContemplatedLayofforClosingActivitySel";
	@ElementDefinition
	public String btnDFAnnualCompensationofEmployees = "btnDFAnnualCompensationofEmployees";
	@ElementDefinition
	public String txtDFAnnualCompensationofEmployees = "txtDFAnnualCompensationofEmployees";
	@ElementDefinition
	public String txtDFAnnualCompensationofEmployeesSel = "txtDFAnnualCompensationofEmployeesSel";
	@ElementDefinition
	public String btnDFEmployeeTurnover = "btnDFEmployeeTurnover";
	@ElementDefinition
	public String txtDFEmployeeTurnover = "txtDFEmployeeTurnover";
	@ElementDefinition
	public String txtDFEmployeeTurnoverSel = "txtDFEmployeeTurnoverSel";
	@ElementDefinition
	public String btnDFLitigationHistory = "btnDFLitigationHistory";
	@ElementDefinition
	public String txtDFLitigationHistory = "txtDFLitigationHistory";
	@ElementDefinition
	public String txtDFLitigationHistorySel = "txtDFLitigationHistorySel";
	@ElementDefinition
	public String btnDFSignificantTransactionorEvent = "btnDFSignificantTransactionorEvent";
	@ElementDefinition
	public String txtDFSignificantTransactionorEvent = "txtDFSignificantTransactionorEvent";
	@ElementDefinition
	public String txtDFSignificantTransactionorEventSel = "txtDFSignificantTransactionorEventSel";
	@ElementDefinition
	public String btnDFManagementStability = "btnDFManagementStability";
	@ElementDefinition
	public String txtDFManagementStability = "txtDFManagementStability";
	@ElementDefinition
	public String txtDFManagementStabilitySel = "txtDFManagementStabilitySel";
	@ElementDefinition
	public String btnDFHumanResourcesPoliciesandProcedures = "btnDFHumanResourcesPoliciesandProcedures";
	@ElementDefinition
	public String txtDFHumanResourcesPoliciesandProcedures = "txtDFHumanResourcesPoliciesandProcedures";
	@ElementDefinition
	public String txtDFHumanResourcesPoliciesandProceduresSel = "txtDFHumanResourcesPoliciesandProceduresSel";

	@ElementDefinition
	public String txtSRLossExperience = "txtSRLossExperience";
	@ElementDefinition
	public String txtSROverallFinancialLiquidity = "txtSROverallFinancialLiquidity";
	@ElementDefinition
	public String txtSRStrengthofCorporateGovernance = "txtSRStrengthofCorporateGovernance";
	@ElementDefinition
	public String txtSRAffectedbyRecession = "txtSRAffectedbyRecession";
	@ElementDefinition
	public String txtSRQualityofManagement = "txtSRQualityofManagement";

	@ElementDefinition
	public String btnCMDutytoDefend = "btnCMDutytoDefend";
	@ElementDefinition
	public String txtCMDutytoDefend = "txtCMDutytoDefend";
	@ElementDefinition
	public String txtCMDutytoDefendSel = "txtCMDutytoDefendSel";
	@ElementDefinition
	public String btnCMThirdPartyLiabilityCoverageDeletedFactor = "btnCMThirdPartyLiabilityCoverageDeletedFactor";
	@ElementDefinition
	public String txtCMThirdPartyLiabilityCoverageDeletedFactor = "txtCMThirdPartyLiabilityCoverageDeletedFactor";
	@ElementDefinition
	public String txtCMThirdPartyLiabilityCoverageDeletedFactorSel = "txtCMThirdPartyLiabilityCoverageDeletedFactorSel";
	@ElementDefinition
	public String btnCMThirdPartyExposure = "btnCMThirdPartyExposure";
	@ElementDefinition
	public String txtCMThirdPartyExposure = "txtCMThirdPartyExposure";
	@ElementDefinition
	public String txtCMThirdPartyExposureSel = "txtCMThirdPartyExposureSel";	
	@ElementDefinition
	public String btnCMEndorsementFactor = "btnCMEndorsementFactor";
	@ElementDefinition
	public String txtCMEndorsementFactor = "txtCMEndorsementFactor";
	@ElementDefinition
	public String txtCMEndorsementFactorSel = "txtCMEndorsementFactorSel";
	
	
	@ElementDefinition
	public String chkEPLCrisis = "chkEPLCrisis";
	@ElementDefinition
	public String txtEPLCrisis = "txtEPLCrisis";
	@ElementDefinition
	public String chkEPLThirdPartyLiability = "chkEPLThirdPartyLiability";
	@ElementDefinition
	public String chkEPLSeparateDefense = "chkEPLSeparateDefense";
	@ElementDefinition
	public String txtEPLSeparateDefense = "txtEPLSeparateDefense";
	@ElementDefinition
	public String chkEPLWageAndHour = "chkEPLWageAndHour";
	@ElementDefinition
	public String txtEPLWageAndHour = "txtEPLWageAndHour";
	@ElementDefinition
	public String chkAddtnlClaimExpLimit ="chkAddtnlClaimExpLimit";
	@ElementDefinition
	public String chkEPLWorkplaceViolenceExpenses ="chkEPLWorkplaceViolenceExpenses";
	@ElementDefinition
	public String txtEPLWorkplaceViolenceExpenses ="txtEPLWorkplaceViolenceExpenses";
	@ElementDefinition
	public String 	btnUpdateCoverages = "btnUpdateCoverages";
	@ElementDefinition
	public String btnCMEWageandHourDefense = "btnCMEWageandHourDefense";
	@ElementDefinition
	public String txtCMWageandHourDefense = "txtCMWageandHourDefense";
	@ElementDefinition
	public String txtCMWageandHourDefensSel = "txtCMWageandHourDefensSel";
	@ElementDefinition
	public String LeftArrow = "LeftArrow";
	@ElementDefinition
	public String RightArrow = "RightArrow";
	@TimeMethod
	@ScreenShot
	public void UmRatingEPL(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_SRM_EPL_Error_Msg(String tcID, SoftAssert softAs) throws Exception;
	public void Update_SRM_EPL(String tcID, SoftAssert softAs) throws Exception;

}
