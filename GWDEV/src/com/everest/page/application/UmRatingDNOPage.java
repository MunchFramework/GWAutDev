package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmRatingDNOPage extends Page{
	
	@ElementDefinition
	public String Error_SRM_OK_btn="Error_SRM_OK_btn";
	@ElementDefinition
	public String Error_SRM="Error_SRM";
	@ElementDefinition
	public String btnRatingDNOtab = "btnRatingDNOtab";
	@ElementDefinition
	public String txtAggregateLimit = "txtAggregateLimit";
	@ElementDefinition
	public String txtRetention = "txtRetention";
	@ElementDefinition
	public String txtDate = "txtDate";
	@ElementDefinition
	public String btnDFLitHisSelectOption = "btnDFLitHisSelectOption";
	@ElementDefinition
	public String txtDFLitHisSelectOption = "txtDFLitHisSelectOption";
	@ElementDefinition
	public String txtDFLitHisSelection = "txtDFLitHisSelection";
	@ElementDefinition
	public String btnDFNoYrBusSelectOption = "btnDFNoYrBusSelectOption";
	@ElementDefinition
	public String txtDFNoYrBusSelectOption = "txtDFNoYrBusSelectOption";
	@ElementDefinition
	public String txtDFNoYrBusSelection = "txtDFNoYrBusSelection";
	@ElementDefinition
	public String btnDFManageOwnerSelectOption = "btnDFManageOwnerSelectOption";
	@ElementDefinition
	public String txtDFManageOwnerSelectOption = "txtDFManageOwnerSelectOption";
	@ElementDefinition
	public String txtDFManageOwnerSelection = "txtDFManageOwnerSelection";
	@ElementDefinition
	public String btnDFSecurityOffSelectOption = "btnDFSecurityOffSelectOption";
	@ElementDefinition
	public String txtDFSecurityOffSelectOption = "txtDFSecurityOffSelectOption";
	@ElementDefinition
	public String txtDFSecurityOffSelection = "txtDFSecurityOffSelection";
	@ElementDefinition
	public String btnDFNatureOpsSelectOption = "btnDFNatureOpsSelectOption";
	@ElementDefinition
	public String txtDFNatureOpsSelectOption = "txtDFNatureOpsSelectOption";
	@ElementDefinition
	public String txtDFNatureOpsSelection = "txtDFNatureOpsSelection";
	@ElementDefinition
	public String btnDFQualityIncSelectOption = "btnDFQualityIncSelectOption";
	@ElementDefinition
	public String txtDFQualityIncSelectOption = "txtDFQualityIncSelectOption";
	@ElementDefinition
	public String txtDFQualityIncSelection = "txtDFQualityIncSelection";
	@ElementDefinition
	public String btnDFSigTranSelectOption = "btnDFSigTranSelectOption";
	@ElementDefinition
	public String txtDFSigTranSelectOption = "txtDFSigTranSelectOption";
	@ElementDefinition
	public String txtDFSigTranSelection = "txtDFSigTranSelection";
	@ElementDefinition
	public String btnDFNoOfSubsSelectOption = "btnDFNoOfSubsSelectOption";
	@ElementDefinition
	public String txtDFNoOfSubsSelectOption = "txtDFNoOfSubsSelectOption";
	@ElementDefinition
	public String txtDFNoOfSubsSelection = "txtDFNoOfSubsSelection";
	@ElementDefinition
	public String btnDFQualityCashFlowsSelectOption = "btnDFQualityCashFlowsSelectOption";
	@ElementDefinition
	public String txtDFQualityCashFlowsSelectOption = "txtDFQualityCashFlowsSelectOption";
	@ElementDefinition
	public String txtDFQualityCashFlowsSelection = "txtDFQualityCashFlowsSelection";
	@ElementDefinition
	public String btnDFMangStabilitySelectOption = "btnDFMangStabilitySelectOption";
	@ElementDefinition
	public String txtDFMangStabilitySelectOption = "txtDFMangStabilitySelectOption";
	@ElementDefinition
	public String txtDFMangStabilitySelection = "txtDFMangStabilitySelection";
	@ElementDefinition
	public String btnDFMergerActivitySelectOption = "btnDFMergerActivitySelectOption";
	@ElementDefinition
	public String txtDFMergerActivitySelectOption = "txtDFMergerActivitySelectOption";
	@ElementDefinition
	public String txtDFMergerActivitySelection = "txtDFMergerActivitySelection";
	@ElementDefinition
	public String btnDFQualityBalanceSheetSelectOption = "btnDFQualityBalanceSheetSelectOption";
	@ElementDefinition
	public String txtDFQualityBalanceSheetSelectOption = "txtDFQualityBalanceSheetSelectOption";
	@ElementDefinition
	public String txtDFQualityBalanceSheetSelection = "txtDFQualityBalanceSheetSelection";
	@ElementDefinition
	public String txtSRQualityManageSelection = "txtSRQualityManageSelection";
	@ElementDefinition
	public String txtSRAffRecessionSelection = "txtSRAffRecessionSelection";
	@ElementDefinition
	public String txtSRLossExpSelection = "txtSRLossExpSelection";
	@ElementDefinition
	public String txtSROverallFinLiqSelection = "txtSROverallFinLiqSelection";
	@ElementDefinition
	public String txtSRStregthCorpGovtSelection = "txtSRStregthCorpGovtSelection";
	@ElementDefinition
	public String txtSRAdditionalSideLimit ="txtSRAdditionalSideLimit";
	@ElementDefinition
	public String txtSRAdditionalSideSubLimit ="txtSRAdditionalSideSubLimit";
	@ElementDefinition
	public String txtOCEAssetProCostsLimit = "txtOCEAssetProCostsLimit";
	@ElementDefinition
	public String txtOCEInvestigativeCostsLimit = "txtOCEInvestigativeCostsLimit";
	@ElementDefinition
	public String txtOCEPublicRelationsCostsLimit = "txtOCEPublicRelationsCostsLimit";
	
	
	@ElementDefinition
	public String txtCMSelection = "txtCMSelection";
	@ElementDefinition
	public String btnCMEndFact = "btnCMEndFact";
	@ElementDefinition
	public String txtCMEndFact = "txtCMEndFact";
	@ElementDefinition
	public String btnCMDutytoDefend = "btnCMDutytoDefend";
	@ElementDefinition
	public String txtCMDutytoDefend = "txtCMDutytoDefend";
	@ElementDefinition
	public String btnGetRate ="btnGetRate";
	@ElementDefinition
	public String txtCMEndFactSel = "txtCMEndFactSel";
	@ElementDefinition
	public String txtCMDutytoDefendSel = "txtCMDutytoDefendSel";
	
	@ElementDefinition
	public String  chkInvestigativeCosts = "chkInvestigativeCosts";
	@ElementDefinition
	public String  txtInvestigativeCosts = "txtInvestigativeCosts";
	@ElementDefinition
	public String chkAssetProtectionCosts  = "chkAssetProtectionCosts";
	@ElementDefinition
	public String  txtAssetProtectionCosts = "txtAssetProtectionCosts";
	@ElementDefinition
	public String  chkPublicRelationsCosts = "chkPublicRelationsCosts";
	@ElementDefinition
	public String txtPublicRelationsCosts  = "txtPublicRelationsCosts";
	@ElementDefinition
	public String  chkAdditionalSideALimit = "chkAdditionalSideALimit";
	@ElementDefinition
	public String txtAdditionalSideALimit  = "txtAdditionalSideALimit";
	@ElementDefinition
	public String  chkDNOSeparateDefenseCostCoverage = "chkDNOSeparateDefenseCostCoverage";
	@ElementDefinition
	public String  txtDNOSeparateDefenseCostCoverage = "txtDNOSeparateDefenseCostCoverage";
	@ElementDefinition
	public String 	btnUpdateCoverages = "btnUpdateCoverages";
	@ElementDefinition
	public String 	ddDutytodefend = "ddDutytodefend";
	
	// NFP related DF's
	@ElementDefinition
	public String btnDFSecuritiesOfferingActivitySelectOption ="btnDFSecuritiesOfferingActivitySelectOption";
	@ElementDefinition
	public String	btnDFLitigationHistorySelectOption="btnDFLitigationHistorySelectOption";
	@ElementDefinition
	public String 	btnDFSignificantTransactionorEventSelectOption="btnDFSignificantTransactionorEventSelectOption";
	@ElementDefinition
	public String btnDFManagementStabilitySelectOption="btnDFManagementStabilitySelectOption";
	@ElementDefinition
	public String btnDFQualityofStatementofFinancialPositionSelectOption="btnDFQualityofStatementofFinancialPositionSelectOption";
	@ElementDefinition
	public String btnDFQualityofStatementofActivitiesSelectOption="btnDFQualityofStatementofActivitiesSelectOption";
	@ElementDefinition
	public String btnDFQualityofStatementofCashFlowsSelectOption="btnDFQualityofStatementofCashFlowsSelectOption";

	@ElementDefinition
	public String txtDFSecuritiesOfferingActivitySelectOption ="txtDFSecuritiesOfferingActivitySelectOption";
	@ElementDefinition
	public String	txtDFLitigationHistorySelectOption="txtDFLitigationHistorySelectOption";
	@ElementDefinition
	public String 	txtDFSignificantTransactionorEventSelectOption="txtDFSignificantTransactionorEventSelectOption";
	@ElementDefinition
	public String txtDFManagementStabilitySelectOption="txtDFManagementStabilitySelectOption";
	@ElementDefinition
	public String txtDFQualityofStatementofFinancialPositionSelectOption="txtDFQualityofStatementofFinancialPositionSelectOption";
	@ElementDefinition
	public String txtDFQualityofStatementofActivitiesSelectOption="txtDFQualityofStatementofActivitiesSelectOption";
	@ElementDefinition
	public String txtDFQualityofStatementofCashFlowsSelectOption="txtDFQualityofStatementofCashFlowsSelectOption";
	
	
	@ElementDefinition
	public String 	txtDFSecuritiesOfferingActivitySelection ="txtDFSecuritiesOfferingActivitySelection";
	@ElementDefinition
	public String txtDFLitigationHistorySelection="txtDFLitigationHistorySelection";
	@ElementDefinition
	public String txtDFSignificantTransactionorEventSelection="txtDFSignificantTransactionorEventSelection";
	@ElementDefinition
	public String txtDFManagementStabilitySelection="txtDFManagementStabilitySelection";
	@ElementDefinition
	public String txtDFQualityofStatementofFinancialPositionSelection="txtDFQualityofStatementofFinancialPositionSelection";
	@ElementDefinition
	public String txtDFQualityofStatementofActivitiesSelection="txtDFQualityofStatementofActivitiesSelection";
	@ElementDefinition
	public String txtDFQualityofStatementofCashFlowsSelection="txtDFQualityofStatementofCashFlowsSelection";
	
	
	@TimeMethod
	@ScreenShot
	public void UmRatingDNO(String tcID, SoftAssert softAs) throws Exception;
	public void UmRatingDNO_1(String tcID, SoftAssert softAs) throws Exception;
	public void VerifyDnoFormEdit(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_SRM_DNO_Error_Msg(String tcID, SoftAssert softAs) throws Exception;
	public void Update_SRM_DNO(String tcID, SoftAssert softAs) throws Exception;

}
