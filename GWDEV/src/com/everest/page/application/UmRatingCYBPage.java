package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmRatingCYBPage extends Page{

	@ElementDefinition
	public String Error_SRM_OK_btn="Error_SRM_OK_btn";
	@ElementDefinition
	public String Error_SRM="Error_SRM";
	@ElementDefinition
	public String txtSCG_MINValue="txtSCG_MINValue";
	@ElementDefinition
	public String txtSCG_MAXValue="txtSCG_MAXValue";
	@ElementDefinition
	public String txtLE_MINValue="txtLE_MINValue";
	@ElementDefinition
	public String txtLE_MAXValue="txtLE_MAXValue";
	@ElementDefinition
	public String txtOFL_MINValue="txtOFL_MINValue";
	@ElementDefinition
	public String txtOFL_MAXValue="txtOFL_MAXValue";
	@ElementDefinition
	public String txtABR_MINValue="txtABR_MINValue";
	@ElementDefinition
	public String txtABR_MAXValue="txtABR_MAXValue";
	@ElementDefinition
	public String txtQOM_MINValue="txtQOM_MINValue";
	@ElementDefinition
	public String txtQOM_MAXValue="txtQOM_MAXValue";
	@ElementDefinition
	public String txtSTATE_MINValue="txtSTATE_MINValue";
	@ElementDefinition
	public String txtSTATE_MAXValue="txtSTATE_MAXValue";
	
	
	@ElementDefinition
	public String 	txtCYBAggregateLimit="txtCYBAggregateLimit";
	@ElementDefinition
	public String txtCYBRetention="txtCYBRetention";
	@ElementDefinition
	public String txtCYBRetroDate="txtCYBRetroDate";
	@ElementDefinition
	public String 	btnCYBPage ="btnCYBPage";
	@ElementDefinition
	public String 	txtBreachResponseCostsSublimit = "txtBreachResponseCostsSublimit";
	@ElementDefinition
	public String 	txtCyberExtortionCostsSublimit = "txtCyberExtortionCostsSublimit";
	@ElementDefinition
	public String 	txtDataLossCostsSublimit = "txtDataLossCostsSublimit";
	@ElementDefinition
	public String 	txtBusinessInterruptionLossSublimit = "txtBusinessInterruptionLossSublimit";	
	@ElementDefinition
	public String 	txtContingentBusinessInterruptionLossSublimit = "txtContingentBusinessInterruptionLossSublimit";
	@ElementDefinition
	public String 	txtBreachLiabilitySublimit = "txtBreachLiabilitySublimit";
	@ElementDefinition
	public String 	txtRegulatoryPenaltiesSublimit = "txtRegulatoryPenaltiesSublimit";
	@ElementDefinition
	public String 	txtPCIAssessmentsSublimit = "txtPCIAssessmentsSublimit";
	@ElementDefinition
	public String 	txtPCIRecertificationCostsSublimit = "txtPCIRecertificationCostsSublimit";
	@ElementDefinition
	public String 	txtMediaLiabilitySublimit = "txtMediaLiabilitySublimit";

	@ElementDefinition
	public String 	txtBreachResponseCostsRetention = "txtBreachResponseCostsRetention";
	@ElementDefinition
	public String 	txtCyberExtortionCostsRetention = "txtCyberExtortionCostsRetention";
	@ElementDefinition
	public String 	txtDataLossCostsRetention = "txtDataLossCostsRetention";
	@ElementDefinition
	public String 	txtBusinessInterruptionLossRetention = "txtBusinessInterruptionLossRetention";	
	@ElementDefinition
	public String 	txtContingentBusinessInterruptionLossRetention = "txtContingentBusinessInterruptionLossRetention";
	@ElementDefinition
	public String 	txtBreachLiabilityRetention = "txtBreachLiabilityRetention";
	@ElementDefinition
	public String 	txtRegulatoryPenaltiesRetention = "txtRegulatoryPenaltiesRetention";
	@ElementDefinition
	public String 	txtPCIAssessmentsRetention = "txtPCIAssessmentsRetention";
	@ElementDefinition
	public String 	txtPCIRecertificationCostsRetention = "txtPCIRecertificationCostsRetention";
	@ElementDefinition
	public String 	txtMediaLiabilityRetention = "txtMediaLiabilityRetention";
	@ElementDefinition
	public String 	txtCommontextSelOption = "txtCommontextSelOption";


	@ElementDefinition
	public String 	txtBusinessInterruptionLossWaitingPeriod = "txtBusinessInterruptionLossWaitingPeriod";	
	@ElementDefinition
	public String 	txtContingentBusinessInterruptionLossWaitingPeriod= "txtContingentBusinessInterruptionLossWaitingPeriod";


	@ElementDefinition
	public String 	txtBreachResponseCostsSelectOption= "txtBreachResponseCostsSelectOption";
	@ElementDefinition
	public String 	txtCyberExtortionCostsSelectOption= "txtCyberExtortionCostsSelectOption";
	@ElementDefinition
	public String 	txtDataLossCostsSelectOption= "txtDataLossCostsSelectOption";
	@ElementDefinition
	public String 	txtBusinessInterruptionLossSelectOption	= "txtBusinessInterruptionLossSelectOption";
	@ElementDefinition
	public String 	txtContingentBusinessInterruptionLossSelectOption= "txtContingentBusinessInterruptionLossSelectOption";
	@ElementDefinition
	public String 	txtBreachLiabilitySelectOption= "txtBreachLiabilitySelectOption";
	@ElementDefinition
	public String 	txtRegulatoryPenaltiesSelectOption= "txtRegulatoryPenaltiesSelectOption";
	@ElementDefinition
	public String 	txtPCIAssessmentsSelectOption= "txtPCIAssessmentsSelectOption";
	@ElementDefinition
	public String 	txtPCIRecertificationCostsSelectOption= "txtPCIRecertificationCostsSelectOption";
	@ElementDefinition
	public String 	txtMediaLiabilitySelectOption= "txtMediaLiabilitySelectOption";


	@ElementDefinition
	public String 	txtBreachResponseCostsSelection= "txtBreachResponseCostsSelection";
	@ElementDefinition
	public String 	txtCyberExtortionCostsSelection= "txtCyberExtortionCostsSelection";
	@ElementDefinition
	public String 	txtDataLossCostsSelection= "txtDataLossCostsSelection";
	@ElementDefinition
	public String 	txtBusinessInterruptionLossSelection= "txtBusinessInterruptionLossSelection";	
	@ElementDefinition
	public String 	txtContingentBusinessInterruptionLossSelection= "txtContingentBusinessInterruptionLossSelection";
	@ElementDefinition
	public String 	txtBreachLiabilitySelection= "txtBreachLiabilitySelection";
	@ElementDefinition
	public String 	txtRegulatoryPenaltiesSelection= "txtRegulatoryPenaltiesSelection";
	@ElementDefinition
	public String 	txtPCIAssessmentsSelection= "txtPCIAssessmentsSelection";
	@ElementDefinition
	public String 	txtPCIRecertificationCostsSelection= "txtPCIRecertificationCostsSelection";
	@ElementDefinition
	public String 	txtMediaLiabilitySelection= "txtMediaLiabilitySelection";
	
	@ElementDefinition
	public String 	btnNext = "btnNext";
	@ElementDefinition
	public String 	btnNextDF ="btnNextDF";
	
	@ElementDefinition
	public String 		txtTechnologyErrorsandOmissionsLiabilitySublimit = "txtTechnologyErrorsandOmissionsLiabilitySublimit";
	@ElementDefinition
	public String 	txtTechnologyErrorsandOmissionsLiabilityRetention = "txtTechnologyErrorsandOmissionsLiabilityRetention";
	@ElementDefinition
	public String 	txtTechnologyErrorsandOmissionsLiabilitySelectOption = "txtTechnologyErrorsandOmissionsLiabilitySelectOption";
	@ElementDefinition
	public String 	txtTechnologyErrorsandOmissionsLiabilitySelection = "txtTechnologyErrorsandOmissionsLiabilitySelection";
	
	@ElementDefinition
	public String 	txtDFNatureandAmountofThirdPartyPersonalInformationSelectOption = "txtDFNatureandAmountofThirdPartyPersonalInformationSelectOption";
	@ElementDefinition
	public String 	txtDFLocationJurisdictionFactorSelectOption= "txtDFLocationJurisdictionFactorSelectOption";
	@ElementDefinition
	public String 	txtDFFormalIncidentResponsePlanSelectOption= "txtDFFormalIncidentResponsePlanSelectOption";
	@ElementDefinition
	public String 	txtDFFormalBusinessContinuityDisasterSelectOption= "txtDFFormalBusinessContinuityDisasterSelectOption";
	@ElementDefinition
	public String 	txtDFSharingofConfidentialInformationSelectOption= "txtDFSharingofConfidentialInformationSelectOption";

	@ElementDefinition
	public String 	txtDFAssetInventorySelectOption= "txtDFAssetInventorySelectOption";
	@ElementDefinition
	public String 	txtDFSecurityConfigurationsSelectOption= "txtDFSecurityConfigurationsSelectOption";
	@ElementDefinition
	public String 	txtDFVulnerabilityAssessmentandRemediationSelectOption= "txtDFVulnerabilityAssessmentandRemediationSelectOption";
	@ElementDefinition
	public String 	txtDFEmployeeTrainingSelectOption= "txtDFEmployeeTrainingSelectOption";
	@ElementDefinition
	public String 	txtDFAccessControlSelectOption= "txtDFAccessControlSelectOption";

	@ElementDefinition
	public String 	txtDFUseofEncryptionSelectOption= "txtDFUseofEncryptionSelectOption";
	@ElementDefinition
	public String 	txtDFRelianceonCriticalVendorsorServiceProvidersSelectOption= "txtDFRelianceonCriticalVendorsorServiceProvidersSelectOption";
	@ElementDefinition
	public String 	txtDFOnlineSalesSelectOption= "txtDFOnlineSalesSelectOption";
	@ElementDefinition
	public String 	txtDFContractbasedRiskManagementControlsSelectOption= "txtDFContractbasedRiskManagementControlsSelectOption";
	@ElementDefinition
	public String 	txtDFMergerandAcquisitionActivitySelectOption= "txtDFMergerandAcquisitionActivitySelectOption";

	
	@ElementDefinition
	public String 	txtDFNatureandAmountofThirdPartyPersonalInformationSelection= "txtDFNatureandAmountofThirdPartyPersonalInformationSelection";
	@ElementDefinition
	public String 	txtDFLocationJurisdictionFactorSelection= "txtDFLocationJurisdictionFactorSelection";
	@ElementDefinition
	public String 	txtDFFormalIncidentResponsePlanSelection= "txtDFFormalIncidentResponsePlanSelection";
	@ElementDefinition
	public String 	txtDFFormalBusinessContinuityDisasterSelection= "txtDFFormalBusinessContinuityDisasterSelection";
	@ElementDefinition
	public String 	txtDFSharingofConfidentialInformationSelection= "txtDFSharingofConfidentialInformationSelection";
	@ElementDefinition
	public String 	txtDFAssetInventorySelection= "txtDFAssetInventorySelection";
	@ElementDefinition
	public String 	txtDFSecurityConfigurationsSelection= "txtDFSecurityConfigurationsSelection";
	@ElementDefinition
	public String 	txtDFVulnerabilityAssessmentandRemediationSelection= "txtDFVulnerabilityAssessmentandRemediationSelection";
	@ElementDefinition
	public String 	txtDFEmployeeTrainingSelection= "txtDFEmployeeTrainingSelection";
	@ElementDefinition
	public String 	txtDFAccessControlSelection= "txtDFAccessControlSelection";

	@ElementDefinition
	public String 	txtDFUseofEncryptionSelection= "txtDFUseofEncryptionSelection";
	@ElementDefinition
	public String 	txtDFRelianceonCriticalVendorsorServiceProvidersSelection= "txtDFRelianceonCriticalVendorsorServiceProvidersSelection";
	@ElementDefinition
	public String 	txtDFOnlineSalesSelection= "txtDFOnlineSalesSelection";
	@ElementDefinition
	public String 	txtDFContractbasedRiskManagementControlsSelection= "txtDFContractbasedRiskManagementControlsSelection";
	@ElementDefinition
	public String 	txtDFMergerandAcquisitionActivitySelection= "txtDFMergerandAcquisitionActivitySelection";
	
	
	@ElementDefinition
	public String 	txtSRStrengthofCorporateGovernance = "txtSRStrengthofCorporateGovernance";
	@ElementDefinition
	public String txtSRLossExperience = "txtSRLossExperience";
	@ElementDefinition
	public String txtSROverallFinancialLiquidity = "txtSROverallFinancialLiquidity";
	@ElementDefinition
	public String txtSRAffectedbyRecession = "txtSRAffectedbyRecession";
	@ElementDefinition
	public String txtSRQualityofManagement = "txtSRQualityofManagement";
	
	@ElementDefinition
	public String btnUpdateCoverages = "btnUpdateCoverages";
	@ElementDefinition
	public String btnCMEndorsementFactorSelectOption="btnCMEndorsementFactorSelectOption";
	@ElementDefinition
	public String txtCMEndorsementFactorSelectOption="txtCMEndorsementFactorSelectOption";
	
	@ElementDefinition
	public String txtCMEndorsementFactorSelection="txtCMEndorsementFactorSelection";
	
	@ElementDefinition
	public String 	chkOCPCIRecertificationCosts = "chkOCPCIRecertificationCosts";
	@ElementDefinition
	public String chkOCReputationRepair= "chkOCReputationRepair";
	@ElementDefinition
	public String chkOCSystemFailure= "chkOCSystemFailure";
	@ElementDefinition
	public String chkOCWrongfulCollection= "chkOCWrongfulCollection";
	@ElementDefinition
	public String chkOCSocialEngineering= "chkOCSocialEngineering";
	
	@ElementDefinition
	public String btnPrev = "btnPrev";
	
	@ElementDefinition
	public String txtOCPCIRecertificationCostsSublimit = "txtOCPCIRecertificationCostsSublimit";
	@ElementDefinition
	public String txtOCReputationRepairSublimit= "txtOCReputationRepairSublimit";
	@ElementDefinition
	public String txtOCSystemFailureSublimit= "txtOCSystemFailureSublimit";
	@ElementDefinition
	public String txtOCWrongfulCollectionSublimit= "txtOCWrongfulCollectionSublimit";
	@ElementDefinition
	public String txtOCSocialEngineeringSublimit= "txtOCSocialEngineeringSublimit";

	@ElementDefinition
	public String txtOCPCIRecertificationCostsRetention= "txtOCPCIRecertificationCostsRetention";
	@ElementDefinition
	public String txtOCReputationRepairRetention= "txtOCReputationRepairRetention";
	@ElementDefinition
	public String txtOCSystemFailureRetention= "txtOCSystemFailureRetention";
	@ElementDefinition
	public String txtOCWrongfulCollectionRetention= "txtOCWrongfulCollectionRetention";
	@ElementDefinition
	public String txtOCSocialEngineeringRetention= "txtOCSocialEngineeringRetention";

	@ElementDefinition
	public String txtOCPCIRecertificationCostsSelectOption= "txtOCPCIRecertificationCostsSelectOption";
	@ElementDefinition
	public String txtOCReputationRepairSelectOption= "txtOCReputationRepairSelectOption";
	@ElementDefinition
	public String txtOCSystemFailureSelectOption= "txtOCSystemFailureSelectOption";
	@ElementDefinition
	public String txtOCWrongfulCollectionSelectOption= "txtOCWrongfulCollectionSelectOption";
	@ElementDefinition
	public String txtOCSocialEngineeringSelectOption= "txtOCSocialEngineeringSelectOption";

	@ElementDefinition
	public String txtOCPCIRecertificationCostsSelection= "txtOCPCIRecertificationCostsSelection";
	@ElementDefinition
	public String txtOCReputationRepairSelection= "txtOCReputationRepairSelection";
	@ElementDefinition
	public String txtOCSystemFailureSelection= "txtOCSystemFailureSelection";
	@ElementDefinition
	public String txtOCWrongfulCollectionSelection= "txtOCWrongfulCollectionSelection";
	@ElementDefinition
	public String txtOCSocialEngineeringSelection= "txtOCSocialEngineeringSelection";
	@ElementDefinition
	public String txtOCSystemFailureWaitingPeriod = "txtOCSystemFailureWaitingPeriod";
	@ElementDefinition
	public String 	chkOCTechnologyErrorsandOmissionsLiability ="chkOCTechnologyErrorsandOmissionsLiability";
	
	@ElementDefinition
	public String chkOCCYBSeparateDefenseCostCoverage = "chkOCCYBSeparateDefenseCostCoverage";
	@ElementDefinition
	public String chkEXPOCReputationRepair= "chkEXPOCReputationRepair";
	@ElementDefinition
	public String chkEXPOCSystemFailure= "chkEXPOCSystemFailure";
	@ElementDefinition
	public String chkEXPOCWrongfulCollection= "chkEXPOCWrongfulCollection";
	@ElementDefinition
	public String chkEXPOCSocialEngineering= "chkEXPOCSocialEngineering";
	@ElementDefinition
	public String txtOCCYBSeparateDefenseCostCoverage = "txtOCCYBSeparateDefenseCostCoverage";

	@ElementDefinition
	public String txtEXPOCReputationRepairSublimit= "txtEXPOCReputationRepairSublimit";
	@ElementDefinition
	public String txtEXPOCSystemFailureSublimit= "txtEXPOCSystemFailureSublimit";
	@ElementDefinition
	public String txtEXPOCWrongfulCollectionSublimit= "txtEXPOCWrongfulCollectionSublimit";
	@ElementDefinition
	public String txtEXPOCSocialEngineeringSublimit= "txtEXPOCSocialEngineeringSublimit";

	@ElementDefinition
	public String txtEXPOCReputationRepairRetention= "txtEXPOCReputationRepairRetention";
	@ElementDefinition
	public String txtEXPOCSystemFailureRetention= "txtEXPOCSystemFailureRetention";
	@ElementDefinition
	public String txtEXPOCWrongfulCollectionRetention= "txtEXPOCWrongfulCollectionRetention";
	@ElementDefinition
	public String txtEXPOCSocialEngineeringRetention= "txtEXPOCSocialEngineeringRetention";
	
	@ElementDefinition
	public String txtEXPOCReputationRepairSelection= "txtEXPOCReputationRepairSelection";
	@ElementDefinition
	public String txtEXPOCSystemFailureSelection= "txtEXPOCSystemFailureSelection";
	@ElementDefinition
	public String txtEXPOCWrongfulCollectionSelection= "txtEXPOCWrongfulCollectionSelection";
	@ElementDefinition
	public String txtEXPOCSocialEngineeringSelection= "txtEXPOCSocialEngineeringSelection";
	@ElementDefinition
	public String txtEXPOCSystemFailureWaitingPeriod = "txtEXPOCSystemFailureWaitingPeriod";
	

	@ElementDefinition
	public String txtEXPOCReputationRepairSelectOption= "txtEXPOCReputationRepairSelectOption";
	@ElementDefinition
	public String txtEXPOCSystemFailureSelectOption= "txtEXPOCSystemFailureSelectOption";
	@ElementDefinition
	public String txtEXPOCWrongfulCollectionSelectOption= "txtEXPOCWrongfulCollectionSelectOption";
	@ElementDefinition
	public String txtEXPOCSocialEngineeringSelectOption= "txtEXPOCSocialEngineeringSelectOption";
	@ElementDefinition
	public String txtCYRatingAtrr="txtCYRatingAtrr";
	@TimeMethod
	@ScreenShot
	public void UmRatingCYB(String tcID, SoftAssert softAs) throws Exception;
	public void UmValMinMaxClauseTerm(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_SRM_CYB(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_SRM_CYB_Error_Msg(String tcID, SoftAssert softAs) throws Exception;
	public void Update_SRM_CYB(String tcID, SoftAssert softAs) throws Exception;

	
}
