package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;


public interface UmRatingENOPage extends Page{

	@ElementDefinition
	public String Error_SRM_OK_btn="Error_SRM_OK_btn";
	@ElementDefinition
	public String Error_SRM="Error_SRM";
	@ElementDefinition
	public String btnENOPage ="btnENOPage";
	@ElementDefinition
	public String txtENOAggregateLimit = "txtENOAggregateLimit";
	@ElementDefinition
	public String txtENORetention = "txtENORetention";
	@ElementDefinition
	public String txtENOPriordate = "txtENOPriordate";
	@ElementDefinition
	public String txtENOProffServices = "txtENOProffServices";
	@ElementDefinition
	public String btnMediaLiabilityCoverageFactorSelectOption = "btnMediaLiabilityCoverageFactorSelectOption";
	@ElementDefinition
	public String txtMediaLiabilityCoverageFactorSelectOption = "txtMediaLiabilityCoverageFactorSelectOption";
	
	@ElementDefinition
	public String btnDFYearsinBusinessSelectOption ="btnDFYearsinBusinessSelectOption";              
	@ElementDefinition
	public String btnDFComplexityofRiskSelectOption="btnDFComplexityofRiskSelectOption";
	@ElementDefinition
	public String btnDFProfessionalExperienceSelectOption="btnDFProfessionalExperienceSelectOption";
	@ElementDefinition
	public String btnDFWrittenContractsSelectOption="btnDFWrittenContractsSelectOption";
	@ElementDefinition
	public String btnDFSeverityPotentialSelectOption="btnDFSeverityPotentialSelectOption";
	@ElementDefinition
	public String btnDFRiskManagementSelectOption="btnDFRiskManagementSelectOption";
	@ElementDefinition
	public String btnDFPriorActsCoverageSelectOption="btnDFPriorActsCoverageSelectOption";
	@ElementDefinition
	public String btnDFTerritoriesofOperationsSelectOption="btnDFTerritoriesofOperationsSelectOption";
	@ElementDefinition
	public String btnDFClientIndustriesSelectOption="btnDFClientIndustriesSelectOption";
	
	@ElementDefinition
	public String txtDFYearsinBusinessSelection="txtDFYearsinBusinessSelection";
	@ElementDefinition
	public String txtDFComplexityofRiskSelection="txtDFComplexityofRiskSelection";
	@ElementDefinition
	public String txtDFProfessionalExperienceSelection="txtDFProfessionalExperienceSelection";
	@ElementDefinition
	public String txtDFWrittenContractsSelection="txtDFWrittenContractsSelection";
	@ElementDefinition
	public String txtDFSeverityPotentialSelection="txtDFSeverityPotentialSelection";
	@ElementDefinition
	public String txtDFRiskManagementSelection="txtDFRiskManagementSelection";
	@ElementDefinition
	public String txtDFPriorActsCoverageSelection="txtDFPriorActsCoverageSelection";
	@ElementDefinition
	public String txtDFTerritoriesofOperationsSelection="txtDFTerritoriesofOperationsSelection";
	@ElementDefinition
	public String txtDFClientIndustriesSelection="txtDFClientIndustriesSelection";
	
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
	public String chkMPLSeparateDefenseCostCoverage = "chkMPLSeparateDefenseCostCoverage";
	@ElementDefinition
	public String chkMediaLiabilityCoverage = "chkMediaLiabilityCoverage";
	@ElementDefinition
	public String txtMPLSeparateDefenseCostCoverageDefCostLimit = "txtMPLSeparateDefenseCostCoverageDefCostLimit";
	@ElementDefinition
	public String txtMediaLiabilityCoverageAggregateLimit = "txtMediaLiabilityCoverageAggregateLimit";
	@ElementDefinition
	public String txtMediaLiabilityCoverageRetroDate = "txtMediaLiabilityCoverageRetroDate";
	@ElementDefinition
	public String btnUpdateCoverages = "btnUpdateCoverages";
	@ElementDefinition
	public String btnDutytoDefendSelectionFactorSelectOption = "btnDutytoDefendSelectionFactorSelectOption";
	@ElementDefinition
	public String btnEndorsementFactorSelectOption= "btnEndorsementFactorSelectOption";
	 
	@ElementDefinition
	public String	txtDutytoDefendSelectionFactorSelectOption= "txtDutytoDefendSelectionFactorSelectOption";
	@ElementDefinition
	public String	 txtEndorsementFactorSelectOption= "txtEndorsementFactorSelectOption";
	 
	@ElementDefinition
	public String	txtDutytoDefendSelectionFactorSelection= "txtDutytoDefendSelectionFactorSelection";
	@ElementDefinition
	public String	txtEndorsementFactorSelection= "txtEndorsementFactorSelection";
	@ElementDefinition
	public String	txtMediaLiabilityCoverageFactorSelection= "txtMediaLiabilityCoverageFactorSelection";
	
	@TimeMethod
	@ScreenShot
	public void UmRatingENO(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_SRM_ENO_Error_Msg(String tcID, SoftAssert softAs) throws Exception;
	public void Update_SRM_ENO(String tcID, SoftAssert softAs) throws Exception;

}