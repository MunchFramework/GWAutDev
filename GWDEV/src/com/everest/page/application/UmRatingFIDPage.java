package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;


public interface UmRatingFIDPage extends Page{

	@ElementDefinition
	public String Error_SRM_OK_btn="Error_SRM_OK_btn";
	@ElementDefinition
	public String Error_SRM="Error_SRM";
	@ElementDefinition
	public String btnFIDPage ="btnFIDPage";
	@ElementDefinition
	public String txtFIDAggregateLimit = "txtFIDAggregateLimit";
	@ElementDefinition
	public String txtFIDRetention = "txtFIDRetention";
	@ElementDefinition
	public String txtFIDPriordate = "txtFIDPriordate";
	@ElementDefinition
	public String txtFIDAdditionalClaimExpensesLimit = "txtFIDAdditionalClaimExpensesLimit";
	
	@ElementDefinition
	public String btnDFNatureofOperationsSelectOption ="btnDFNatureofOperationsSelectOption";              
	@ElementDefinition
	public String btnDFNumberofYearsinBusinessSelectOption="btnDFNumberofYearsinBusinessSelectOption";
	@ElementDefinition
	public String btnDFPlanTerminationMergingorFreezingActivitySelectOption="btnDFPlanTerminationMergingorFreezingActivitySelectOption";
	@ElementDefinition
	public String btnDFPlanTypeSelectOption="btnDFPlanTypeSelectOption";
	@ElementDefinition
	public String btnDFFundingStatusofDefinedBenefitPlansSelectOption="btnDFFundingStatusofDefinedBenefitPlansSelectOption";
	@ElementDefinition
	public String btnDFPlanParticipantsSelectOption="btnDFPlanParticipantsSelectOption";
	@ElementDefinition
	public String btnDFLitigationHistorySelectOption="btnDFLitigationHistorySelectOption";
	@ElementDefinition
	public String btnDFSignificantTransactionorEventSelectOption="btnDFSignificantTransactionorEventSelectOption";
	@ElementDefinition
	public String btnDFQualityandDiversityofPlanInvestmentsSelectOption="btnDFQualityandDiversityofPlanInvestmentsSelectOption";
	
	@ElementDefinition
	public String txtDFNatureofOperationsSelection="txtDFNatureofOperationsSelection";
	@ElementDefinition
	public String txtDFNumberofYearsinBusinessSelection="txtDFNumberofYearsinBusinessSelection";
	@ElementDefinition
	public String txtDFPlanTerminationMergingorFreezingActivitySelection="txtDFPlanTerminationMergingorFreezingActivitySelection";
	@ElementDefinition
	public String txtDFPlanTypeSelection="txtDFPlanTypeSelection";
	@ElementDefinition
	public String txtDFFundingStatusofDefinedBenefitPlansSelection="txtDFFundingStatusofDefinedBenefitPlansSelection";
	@ElementDefinition
	public String txtDFPlanParticipantsSelection="txtDFPlanParticipantsSelection";
	@ElementDefinition
	public String txtDFLitigationHistorySelection="txtDFLitigationHistorySelection";
	@ElementDefinition
	public String txtDFSignificantTransactionorEventSelection="txtDFSignificantTransactionorEventSelection";
	@ElementDefinition
	public String txtDFQualityandDiversityofPlanInvestmentsSelection="txtDFQualityandDiversityofPlanInvestmentsSelection";
	
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
	public String	chkVoluntaryComplianceProgramCosts = "chkVoluntaryComplianceProgramCosts";
	@ElementDefinition
	public String	chkPenaltiesforViolationsofHIPAAPrivacyProvisions= "chkPenaltiesforViolationsofHIPAAPrivacyProvisions";
	@ElementDefinition
	public String	chkPenaltiesunderSection502cofERISA= "chkPenaltiesunderSection502cofERISA";
	@ElementDefinition
	public String	chkPenaltiesunderthePensionProtectionActof2006= "chkPenaltiesunderthePensionProtectionActof2006";
	@ElementDefinition
	public String	chkPenaltiesundertheAffordableCareAct= "chkPenaltiesundertheAffordableCareAct";
	@ElementDefinition
	public String	chkPenaltyunderIRCSection4975= "chkPenaltyunderIRCSection4975";
	@ElementDefinition
	public String	chkAdditionalClaimExpensesLimitforFiduciaryLiability= "chkAdditionalClaimExpensesLimitforFiduciaryLiability";
	@ElementDefinition
	public String	chkFIDSeparateDefenseCostCoverage= "chkFIDSeparateDefenseCostCoverage";
	
	@ElementDefinition
	public String btnUpdateCoverages = "btnUpdateCoverages";
	@ElementDefinition
	public String		txtVoluntaryComplianceProgramCostsSublimit = "txtVoluntaryComplianceProgramCostsSublimit";
	@ElementDefinition
	public String	txtPenaltiesforViolationsofHIPAAPrivacyProvisionsSublimit = "txtPenaltiesforViolationsofHIPAAPrivacyProvisionsSublimit";
	@ElementDefinition
	public String	txtPenaltiesunderSection502cofERISASublimit = "txtPenaltiesunderSection502cofERISASublimit";
	@ElementDefinition
	public String	txtPenaltiesunderthePensionProtectionActof2006Sublimit ="txtPenaltiesunderthePensionProtectionActof2006Sublimit";
	@ElementDefinition
	public String	txtPenaltiesundertheAffordableCareActSublimit = "txtPenaltiesundertheAffordableCareActSublimit";
	@ElementDefinition
	public String	txtPenaltyunderIRCSection4975Sublimit = "txtPenaltyunderIRCSection4975Sublimit";
	@ElementDefinition
	public String	txtFIDSeparateDefenseCostCoverageDefCostLimit = "txtFIDSeparateDefenseCostCoverageDefCostLimit";
	@ElementDefinition
	public String txtDFEXPEmployeeStockOwnershipPlanSelection = "txtDFEXPEmployeeStockOwnershipPlanSelection";	
	@ElementDefinition
	public String txtDFEXPFundingStatusofDefinedBenefitPlansSelection="txtDFEXPFundingStatusofDefinedBenefitPlansSelection";
	@ElementDefinition
	public String txtDFEXPPlanParticipantsSelection="txtDFEXPPlanParticipantsSelection";
	@ElementDefinition
	public String txtDFEXPLitigationHistorySelection="txtDFEXPLitigationHistorySelection";
	@ElementDefinition
	public String txtDFEXPSignificantTransactionorEventSelection="txtDFEXPSignificantTransactionorEventSelection";
	@ElementDefinition
	public String txtDFEXPQualityandDiversityofPlanInvestmentsSelection="txtDFEXPQualityandDiversityofPlanInvestmentsSelection";
	
	
	@ElementDefinition
	public String btnDFEXFundingStatusofDefinedBenefitPlansSelectOption="btnDFEXFundingStatusofDefinedBenefitPlansSelectOption";
	@ElementDefinition
	public String btnDFEXPlanParticipantsSelectOption="btnDFEXPlanParticipantsSelectOption";
	@ElementDefinition
	public String btnDFEXLitigationHistorySelectOption="btnDFEXLitigationHistorySelectOption";
	@ElementDefinition
	public String btnDFEXSignificantTransactionorEventSelectOption="btnDFEXSignificantTransactionorEventSelectOption";
	@ElementDefinition
	public String btnDFEXQualityandDiversityofPlanInvestmentsSelectOption="btnDFEXQualityandDiversityofPlanInvestmentsSelectOption";
	@ElementDefinition
	public String 	btnDFEXPEmployeeStockOwnershipPlanSelectOption = "btnDFEXPEmployeeStockOwnershipPlanSelectOption";
	@TimeMethod
	@ScreenShot
	public void UmRatingFID(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_SRM_FID_Error_Msg(String tcID, SoftAssert softAs) throws Exception;
	public void Update_SRM_FID(String tcID, SoftAssert softAs) throws Exception;

}