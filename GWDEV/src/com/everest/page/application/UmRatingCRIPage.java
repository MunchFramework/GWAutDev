package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmRatingCRIPage extends Page{

	@ElementDefinition
	public String Error_SRM_OK_btn="Error_SRM_OK_btn";
	@ElementDefinition
	public String Error_SRM="Error_SRM";
	@ElementDefinition
	public String txtLimitPerOccurence = "txtLimitPerOccurence";
	@ElementDefinition
	public String txtDeductiblePerOccurence = "txtDeductiblePerOccurence";
	
	@ElementDefinition
	public String btnDFNatOfOpsSelectOption = "btnDFNatOfOpsSelectOption";
	@ElementDefinition
	public String txtDFNatOfOpsSelectOption = "txtDFNatOfOpsSelectOption";
	@ElementDefinition
	public String txtDFNatOfOpsSelection  =	"txtDFNatOfOpsSelection";
	
	@ElementDefinition
	public String btnDFProfOfWrkSelectOption  = "btnDFProfOfWrkSelectOption";
	@ElementDefinition
	public String txtDFProfOfrkSelectOption  = "txtDFProfOfrkSelectOption";
	@ElementDefinition
	public String txtDFProfOfrkSelection = "txtDFProfOfrkSelection";
	
	@ElementDefinition
	public String btnDFOrgCompSelectOption = "btnDFOrgCompSelectOption";
	@ElementDefinition
	public String txtDFOrgCompSelectOption = "txtDFOrgCompSelectOption";
	@ElementDefinition
	public String txtDFOrgCompSelection = "txtDFOrgCompSelection";

	@ElementDefinition
	public String btnDFForgnLocExpSelectOption = "btnDFForgnLocExpSelectOption" ;
	@ElementDefinition
	public String txtDFForgnLocExpSelectOption = "txtDFForgnLocExpSelectOption" ;
	@ElementDefinition
	public String txtDFForgnLocExpSelection = "txtDFForgnLocExpSelection" ;

	@ElementDefinition
	public String btnDFHiValProcMatSelectOption = "btnDFHiValProcMatSelectOption" ;
	@ElementDefinition
	public String txtDFHiValProcMatSelectOption = "txtDFHiValProcMatSelectOption" ;
	@ElementDefinition
	public String txtDFHiValProcMatSelection = "txtDFHiValProcMatSelection" ;

	@ElementDefinition
	public String btnDFAudFuncSelectOption = "btnDFAudFuncSelectOption" ;
	@ElementDefinition
	public String txtDFAudFuncSelectOption = "txtDFAudFuncSelectOption" ;
	@ElementDefinition
	public String txtDFAudFuncSelection = "txtDFAudFuncSelection" ;
	
	@ElementDefinition
	public String btnDFIntContSelectOption = "btnDFIntContSelectOption" ;
	@ElementDefinition
	public String txtDFIntContSelectOption = "txtDFIntContSelectOption" ;
	@ElementDefinition
	public String txtDFIntContSelection = "txtDFIntContSelection" ;

	@ElementDefinition
	public String btnDFPreEmpScrSelectOption = "btnDFPreEmpScrSelectOption" ;
	@ElementDefinition
	public String txtDFPreEmpScrSelectOption = "txtDFPreEmpScrSelectOption" ;
	@ElementDefinition
	public String txtDFPreEmpScrSelection = "txtDFPreEmpScrSelection" ;

	@ElementDefinition
	public String btnDFInvMngSelectOption = "btnDFInvMngSelectOption" ;
	@ElementDefinition
	public String txtDFInvMngSelectOption = "txtDFInvMngSelectOption" ;
	@ElementDefinition
	public String txtDFInvMngSelection = "txtDFInvMngSelection" ;

	@ElementDefinition
	public String btnDFVendMngGuidSelectOption = "btnDFVendMngGuidSelectOption" ;	
	@ElementDefinition
	public String txtDFVendMngGuidSelectOption = "txtDFVendMngGuidSelectOption" ;	
	@ElementDefinition
	public String txtDFVendMngGuidSelection = "txtDFVendMngGuidSelection" ;
	
	@ElementDefinition
	public String btnDFNoOfYrsSelectOption = "btnDFNoOfYrsSelectOption" ;	
	@ElementDefinition
	public String txtDFNoOfYrsSelectOption = "txtDFNoOfYrsSelectOption" ;	
	@ElementDefinition
	public String txtDFNoOfYrsSelection = "txtDFNoOfYrsSelection" ;

	@ElementDefinition
	public String btnDFMergAcqActSelectOption = "btnDFMergAcqActSelectOption" ;	
	@ElementDefinition
	public String txtDFMergAcqActSelectOption = "txtDFMergAcqActSelectOption" ;	
	@ElementDefinition
	public String txtDFMergAcqActSelection = "txtDFMergAcqActSelection" ;

	@ElementDefinition
	public String txtSRStrengthOfCorpGovSelection = "txtSRStrengthOfCorpGovSelection" ;	
	@ElementDefinition
	public String txtSRLossExpSelection = "txtSRLossExpSelection" ;	
	@ElementDefinition
	public String txtSROverallFinanLiqSelection = "txtSROverallFinanLiqSelection" ;
	@ElementDefinition
	public String txtSRAffByRecessionSelection = "txtSRAffByRecessionSelection" ;	
	@ElementDefinition
	public String txtSRQualityOfMngmntSelection = "txtSRQualityOfMngmntSelection" ;	
	
	@ElementDefinition
	public String btnCMEndFactSelectOption = "btnCMEndFactSelectOption" ;
	@ElementDefinition
	public String txtCMEndFactSelectOption = "txtCMEndFactSelectOption" ;	
	@ElementDefinition
	public String txtCMEndFactSelection = "txtCMEndFactSelection" ;	
	
	@ElementDefinition
	public String btnCMPremCovSelectOption = "btnCMPremCovSelectOption" ;
	@ElementDefinition
	public String txtCMPremCovSelectOption = "txtCMPremCovSelectOption" ;	
	@ElementDefinition
	public String txtCMPremCovSelection = "txtCMPremCovSelection" ;

	@ElementDefinition
	public String btnCMInTransitCovSelectOption = "btnCMInTransitCovSelectOption" ;
	@ElementDefinition
	public String txtCMInTransitCovSelectOption = "txtCMInTransitCovSelectOption" ;	
	@ElementDefinition
	public String txtCMInTransitCovSelection = "txtCMInTransitCovSelection" ;

	@ElementDefinition
	public String btnCMForgeryCovSelectOption = "btnCMForgeryCovSelectOption" ;
	@ElementDefinition
	public String txtCMForgeryCovSelectOption = "txtCMForgeryCovSelectOption" ;	
	@ElementDefinition
	public String txtCMForgeryCovSelection = "txtCMForgeryCovSelection" ;

	@ElementDefinition
	public String btnCMCompFraudCovSelectOption = "btnCMCompFraudCovSelectOption" ;
	@ElementDefinition
	public String txtCMCompFraudCovSelectOption = "txtCMCompFraudCovSelectOption" ;	
	@ElementDefinition
	public String txtCMCompFraudCovSelection = "txtCMCompFraudCovSelection" ;

	@ElementDefinition
	public String btnCMFundsTransFraudCovSelectOption = "btnCMFundsTransFraudCovSelectOption" ;
	@ElementDefinition
	public String txtCMFundsTransFraudCovSelectOption = "txtCMFundsTransFraudCovSelectOption" ;	
	@ElementDefinition
	public String txtCMFundsTransFraudCovSelection = "txtCMFundsTransFraudCovSelection" ;

	@ElementDefinition
	public String btnCMMoneyOrderCountCurrencySelectOption = "btnCMMoneyOrderCountCurrencySelectOption" ;
	@ElementDefinition
	public String txtCMMoneyOrderCountCurrencySelectOption = "txtCMMoneyOrderCountCurrencySelectOption" ;	
	@ElementDefinition
	public String txtCMMoneyOrderCountCurrencySelection = "txtCMMoneyOrderCountCurrencySelection" ;

	@ElementDefinition
	public String btnCMCreditCardFraudCovSelectOption = "btnCMCreditCardFraudCovSelectOption" ;
	@ElementDefinition
	public String txtCMCreditCardFraudCovSelectOption = "txtCMCreditCardFraudCovSelectOption" ;	
	@ElementDefinition
	public String txtCMCreditCardFraudCovSelection = "txtCMCreditCardFraudCovSelection" ;

	@ElementDefinition
	public String btnCMClientCovSelectOption = "btnCMClientCovSelectOption" ;
	@ElementDefinition
	public String txtCMClientCovSelectOption = "txtCMClientCovSelectOption" ;	
	@ElementDefinition
	public String txtCMClientCovSelection = "txtCMClientCovSelection" ;

	@ElementDefinition
	public String btnCMSocialEnggFraudCovSelectOption = "btnCMSocialEnggFraudCovSelectOption" ;
	@ElementDefinition
	public String txtCMSocialEnggFraudCovSelectOption = "txtCMSocialEnggFraudCovSelectOption" ;	
	@ElementDefinition
	public String txtCMSocialEnggFraudCovSelection = "txtCMSocialEnggFraudCovSelection" ;
	
	@ElementDefinition
	public String chkPremisesCoverage = "chkPremisesCoverage";
	@ElementDefinition
	public String txtPremisesCoverageLimit = "txtPremisesCoverageLimit";
	@ElementDefinition
	public String txtPremisesCoverageDeductible = "txtPremisesCoverageDeductible";
	@ElementDefinition
	public String chkInTransitCoverage = "chkInTransitCoverage";
	@ElementDefinition
	public String txtInTransitCoverageLimit = "txtInTransitCoverageLimit";
	@ElementDefinition
	public String txtInTransitCoverageDeductible = "txtInTransitCoverageDeductible";
	@ElementDefinition
	public String chkForgeryCoverage = "chkForgeryCoverage";
	@ElementDefinition
	public String txtForgeryCoverageLimit = "txtForgeryCoverageLimit";
	@ElementDefinition
	public String txtForgeryCoverageDeductible = "txtForgeryCoverageDeductible";
	@ElementDefinition
	public String chkComputerFraudCoverage = "chkComputerFraudCoverage";
	@ElementDefinition
	public String txtComputerFraudCoverageLimit = "txtComputerFraudCoverageLimit";
	@ElementDefinition
	public String txtComputerFraudCoverageDeductible = "txtComputerFraudCoverageDeductible";
	@ElementDefinition
	public String chkFundsTransferFraudCoverage = "chkFundsTransferFraudCoverage";
	@ElementDefinition
	public String txtFundsTransferFraudCoverageLimit = "txtFundsTransferFraudCoverageLimit";
	@ElementDefinition
	public String txtFundsTransferFraudCoverageDeductible = "txtFundsTransferFraudCoverageDeductible";
	@ElementDefinition
	public String chkMoneyOrdersandCounterfeitCurrencyFraudCoverage = "chkMoneyOrdersandCounterfeitCurrencyFraudCoverage";
	@ElementDefinition
	public String txtMoneyOrdersandCounterfeitCurrencyFraudCoverageLimit = "txtMoneyOrdersandCounterfeitCurrencyFraudCoverageLimit";
	@ElementDefinition
	public String txtMoneyOrdersandCounterfeitCurrencyFraudCoverageDeductible = "txtMoneyOrdersandCounterfeitCurrencyFraudCoverageDeductible";
	@ElementDefinition
	public String chkCreditCardFraudCoverage = "chkCreditCardFraudCoverage";
	@ElementDefinition
	public String txtCreditCardFraudCoverageLimit = "txtCreditCardFraudCoverageLimit";
	@ElementDefinition
	public String txtCreditCardFraudCoverageDeductible = "txtCreditCardFraudCoverageDeductible";
	@ElementDefinition
	public String chkClientCoverage	 = "chkClientCoverage";
	@ElementDefinition
	public String txtClientCoverageLimit = "txtClientCoverageLimit";
	@ElementDefinition
	public String txtClientCoverageDeductible = "txtClientCoverageDeductible";
	@ElementDefinition
	public String chkSocialEngineeringFraudCoverage = "chkSocialEngineeringFraudCoverage";
	@ElementDefinition
	public String txtSocialEngineeringFraudCoverageLimit = "txtSocialEngineeringFraudCoverageLimit";
	@ElementDefinition
	public String txtSocialEngineeringFraudCoverageDeductible = "txtSocialEngineeringFraudCoverageDeductible";
	@ElementDefinition
	public String chkExpenseCoverage = "chkExpenseCoverage";
	@ElementDefinition
	public String txtExpenseCoverageLimit = "txtExpenseCoverageLimit";
	@ElementDefinition
	public String txtExpenseCoverageDeductible = "txtExpenseCoverageDeductible";
	@ElementDefinition
	public String 	btnUpdateCoverages = "btnUpdateCoverages";

	@ElementDefinition
	public String btnRatingCRItab = "btnRatingCRItab";
	
	@ElementDefinition
	public String 	btnOCPremisesCoverageSelection= "btnOCPremisesCoverageSelection";
	@ElementDefinition
	public String btnOCInTransitCoverageSelection= "btnOCInTransitCoverageSelection";
	@ElementDefinition
	public String btnOCForgeryCoverageSelection= "btnOCForgeryCoverageSelection";
	@ElementDefinition
	public String btnOCComputerFraudCoverageSelection= "btnOCComputerFraudCoverageSelection";
	@ElementDefinition
	public String btnOCFundsTransferFraudCoverageSelection= "btnOCFundsTransferFraudCoverageSelection";
	@ElementDefinition
	public String btnOCMoneyOrdersandCounterfeitCurrencyFraudCoverageSelection= "btnOCMoneyOrdersandCounterfeitCurrencyFraudCoverageSelection";
	@ElementDefinition
	public String btnOCCreditCardFraudCoverageSelection= "btnOCCreditCardFraudCoverageSelection";
	@ElementDefinition
	public String btnOCClientCoverageSelection= "btnOCClientCoverageSelection";
	@ElementDefinition
	public String btnOCSocialEngineeringFraudCoverageSelection= "btnOCSocialEngineeringFraudCoverageSelection";
	@ElementDefinition
	public String btnOCExpenseCoverageSelection= "btnOCExpenseCoverageSelection";
	
	@ElementDefinition
	public String txtOCPremisesCoverageSelection = "txtOCPremisesCoverageSelection";
	@ElementDefinition
	public String 	txtOCInTransitCoverageSelection = "txtOCInTransitCoverageSelection";
	@ElementDefinition
	public String txtOCForgeryCoverageSelection = "txtOCForgeryCoverageSelection";
	@ElementDefinition
	public String txtOCComputerFraudCoverageSelection = "txtOCComputerFraudCoverageSelection";
	@ElementDefinition
	public String txtOCFundsTransferFraudCoverageSelection = "txtOCFundsTransferFraudCoverageSelection";
	@ElementDefinition
	public String txtOCMoneyOrdersandCounterfeitCurrencyFraudCoverageSelection = "txtOCMoneyOrdersandCounterfeitCurrencyFraudCoverageSelection";
	@ElementDefinition
	public String txtOCCreditCardFraudCoverageSelection = "txtOCCreditCardFraudCoverageSelection";
	@ElementDefinition
	public String txtOCClientCoverageSelection = "txtOCClientCoverageSelection";
	@ElementDefinition
	public String txtOCSocialEngineeringFraudCoverageSelection = "txtOCSocialEngineeringFraudCoverageSelection";
	@ElementDefinition
	public String txtOCExpenseCoverageSelection = "txtOCExpenseCoverageSelection";

	@TimeMethod
	@ScreenShot
	public void UmRatingCRI(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_SRM_CRI_Error_Msg(String tcID, SoftAssert softAs) throws Exception;
	public void Update_SRM_CRI(String tcID, SoftAssert softAs) throws Exception;

}

