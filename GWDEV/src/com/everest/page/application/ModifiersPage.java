package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface ModifiersPage extends Page {
	//Common
	@ElementDefinition
	public String txtSharedLimit ="txtSharedLimit" ;
	@ElementDefinition
	public String txtSharedSepDefense = "txtSharedSepDefense" ;
	@ElementDefinition
	public String tabCRI = "tabCRI";
	@ElementDefinition
	public String tabDNO = "tabDNO";
	@ElementDefinition
	public String tabEPL = "tabEPL";
	@ElementDefinition
	public String btnSaveDraft = "btnSaveDraft";
	@ElementDefinition
	public String tabModifiers ="tabModifiers";
	
	
	//Crime
	@ElementDefinition
	public String txtNatureofops="txtNatureofops" ;
	@ElementDefinition
	public String txtProfileofWorkspace="txtProfileofWorkspace" ;
	@ElementDefinition
	public String OrganizationComplx="OrganizationComplx" ;
	@ElementDefinition
	public String txtForeignLocExposure="txtForeignLocExposure" ;
	@ElementDefinition
	public String txtHighValue="txtHighValue" ;
	@ElementDefinition
	public String txtAuditfunc="txtAuditfunc" ;
	@ElementDefinition
	public String txtInternalControls="txtInternalControls" ;
	@ElementDefinition
	public String txtPreEmpl="txtPreEmpl" ;
	@ElementDefinition
	public String txtInventoryMan ="txtInventoryMan" ;
	@ElementDefinition
	public String txtVendorMan ="txtVendorMan" ;
	@ElementDefinition
	public String txtNoOfYears="txtNoOfYears" ;
	@ElementDefinition
	public String txtMergerandAcq ="txtMergerandAcq" ;
	
	@ElementDefinition
	public String txtStrengthofCorp="txtStrengthofCorp" ;
	@ElementDefinition
	public String txtLossExperience="txtLossExperience" ;
	@ElementDefinition
	public String txtOverallFinLiq="txtOverallFinLiq" ;
	@ElementDefinition
	public String txtAffectedByRecession="txtAffectedByRecession" ;
	@ElementDefinition
	public String txtQualityofMan="txtQualityofMan" ;
	
	@ElementDefinition
	public String txtEndFactor ="txtEndFactor" ;
	@ElementDefinition
	public String txtPremisesCov="txtPremisesCov" ;
	@ElementDefinition
	public String txtInTransitCov="txtInTransitCov" ;
	@ElementDefinition
	public String txtForgeryCov="txtForgeryCov" ;
	@ElementDefinition
	public String txtFundsTransfercov ="txtFundsTransfercov" ;
	@ElementDefinition
	public String txtComputerFraudCov ="txtComputerFraudCov" ;
	@ElementDefinition
	public String txtMoneyOrderCov ="txtMoneyOrderCov" ;
	@ElementDefinition
	public String txtCreditCardCov="txtCreditCardCov" ;
	@ElementDefinition
	public String txtClientCov="txtClientCov" ;
	@ElementDefinition
	public String txtSocialEngCov ="txtSocialEngCov" ;
	
	

//DNO	
	@ElementDefinition
    public String txtNatureOfOperations="txtNatureOfOperations" ;
    @ElementDefinition
    public String txtNoOfYrsBus="txtNoOfYrsBus" ;
    @ElementDefinition
    public String txtNoOfSubsidaries="txtNoOfSubsidaries" ;
    @ElementDefinition
    public String txtMerger="txtMerger" ;
    @ElementDefinition
    public String txtManOwnership="txtManOwnership" ;
    @ElementDefinition
    public String txtSecuritiesOffering="txtSecuritiesOffering" ;
    @ElementDefinition
    public String txtLitigationHistory="txtLitigationHistory" ;
    @ElementDefinition
    public String txtSigTransaction="txtSigTransaction" ;
    @ElementDefinition
    public String txtManStability="txtManStability" ;
    @ElementDefinition
    public String txtQualityOfBalSheet="txtQualityOfBalSheet" ;
    @ElementDefinition
    public String txtQualityOfIncState="txtQualityOfIncState" ;
    @ElementDefinition
    public String txtQualityOfCashFlow="txtQualityOfCashFlow" ;
    @ElementDefinition
    public String txtCorporatGovernance="txtCorporatGovernance" ;
    @ElementDefinition
    public String txtLossExper= "txtLossExper" ;
    @ElementDefinition
    public String txtOverallFinLiquidity="txtOverallFinLiquidity" ;
    @ElementDefinition
    public String txtAffByRecession="txtAffByRecession" ;
    @ElementDefinition
    public String txtQualityOfManagement="txtQualityOfManagement" ;
    @ElementDefinition
    public String txtDutyToDefend="txtDutyToDefend" ;
    @ElementDefinition
    public String EndorsementFactor="EndorsementFactor" ;
	
    //EPL
    @ElementDefinition
	public String btnEPLtab = "btnEPLtab";
	@ElementDefinition
	public String txtHazardCounty = "txtHazardCounty";
	@ElementDefinition
	public String txtNatureOfOps = "txtNatureOfOps";
	@ElementDefinition
	public String txtNoOfYrsInBusiness = "txtNoOfYrsInBusiness";
	@ElementDefinition
	public String txtMergerAquDivActivity = "txtMergerAquDivActivity";
	@ElementDefinition
	public String txtLayoffClosingActivity = "txtLayoffClosingActivity";
	@ElementDefinition
	public String txtCompensationOfEmployees = "txtCompensationOfEmployees";
	@ElementDefinition
	public String txtEmployeeTurnover = "txtEmployeeTurnover";
	@ElementDefinition
	public String txtLitigationHist = "txtLitigationHist";
	@ElementDefinition
	public String txtSignificantTransEvent = "txtSignificantTransEvent";
	@ElementDefinition
	public String txtManagementStability = "txtManagementStability";
	@ElementDefinition
	public String txtHRPolicyProcedure = "txtHRPolicyProcedure";
	@ElementDefinition
	public String txtStrengthCorporate = "txtStrengthCorporate";
	@ElementDefinition
	public String txtLossExp = "txtLossExp";
	@ElementDefinition
	public String txtFinancialLiquidity = "txtFinancialLiquidity";
	@ElementDefinition
	public String txtAffectedByRecession1 = "txtAffectedByRecession1";
	@ElementDefinition
	public String txtQualityOfManagement1 = "txtQualityOfManagement1";
	@ElementDefinition
	public String txtDutyToDefend1 = "txtDutyToDefend1";
	@ElementDefinition
	public String txtThirdPartyLiability = "txtThirdPartyLiability";
	@ElementDefinition
	public String txtThirdPartyExposure = "txtThirdPartyExposure";
	@ElementDefinition
	public String txtEndorsementFactor = "txtEndorsementFactor";
	@ElementDefinition
	public String 	txtWageandHour ="txtWageandHour";
	@ElementDefinition
	public String 	tabEMP = "tabEMP";
	@ElementDefinition
	public String 	tabENO = "tabENO";
	@ElementDefinition
	public String 	tabFID = "tabENO";
	@ElementDefinition
	public String 	tabKNR = "tabKNR";
	@ElementDefinition
	public String 	tabCYB = "tabCYB";
	
	@TimeMethod
	@ScreenShot
	public void Modifiers(String tcID, SoftAssert softAs) throws Exception;

}
