package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmRatingKNRPage extends Page{

	@ElementDefinition
	public String Error_SRM_OK_btn="Error_SRM_OK_btn";
	@ElementDefinition
	public String Error_SRM="Error_SRM";
	@ElementDefinition
	public String btnKNRPage ="btnKNRPage";

	@ElementDefinition
	public String 	txtRansomLimitOfLiability = "txtRansomLimitOfLiability";
	@ElementDefinition
	public String  txtRansomDeductible= "txtRansomDeductible";
	 
	@ElementDefinition
	public String txtTransitLossLimitOfLiability= "txtTransitLossLimitOfLiability";
	@ElementDefinition
	public String txtLegalLiabilityLimitOfLiability= "txtLegalLiabilityLimitOfLiability";
	@ElementDefinition
	public String txtInsuredEventExpensesLimitOfLiability= "txtInsuredEventExpensesLimitOfLiability";
	@ElementDefinition
	public String 	 txtRecallExpensesLimitOfLiability = "txtRecallExpensesLimitOfLiability";
	
	@ElementDefinition
	public String  btnRecallExpensesBasePremiumFactorSelectOption= "btnRecallExpensesBasePremiumFactorSelectOption";
	@ElementDefinition
	public String  txtRecallExpensesBasePremiumFactorSelectOption= "txtRecallExpensesBasePremiumFactorSelectOption";
	@ElementDefinition
	public String  txtRecallExpensesBasePremiumFactorSelection= "txtRecallExpensesBasePremiumFactorSelection";
	
	
	@ElementDefinition
	public String btnDFRiskinessofCountriesTraveledToSelectOption ="btnDFRiskinessofCountriesTraveledToSelectOption";              
	@ElementDefinition
	public String btnDFFrequencyofTravelSelectOption="btnDFFrequencyofTravelSelectOption";
	@ElementDefinition
	public String btnDFSecurityMeasuresinForeignCountriesSelectOption="btnDFSecurityMeasuresinForeignCountriesSelectOption";
	@ElementDefinition
	public String btnDFIndustryGroupSelectOption="btnDFIndustryGroupSelectOption";
	@ElementDefinition
	public String btnDFTravelAdvisoryPolicySelectOption="btnDFTravelAdvisoryPolicySelectOption";
	@ElementDefinition
	public String btnDFProductExposureSelectOption="btnDFProductExposureSelectOption";
	
	
	@ElementDefinition
	public String txtDFRiskinessofCountriesTraveledToSelection ="txtDFRiskinessofCountriesTraveledToSelection";              
	@ElementDefinition
	public String txtDFFrequencyofTravelSelection="txtDFFrequencyofTravelSelection";
	@ElementDefinition
	public String txtDFSecurityMeasuresinForeignCountriesSelection="txtDFSecurityMeasuresinForeignCountriesSelection";
	@ElementDefinition
	public String txtDFIndustryGroupSelection="txtDFIndustryGroupSelection";
	@ElementDefinition
	public String txtDFTravelAdvisoryPolicySelection="txtDFTravelAdvisoryPolicySelection";
	@ElementDefinition
	public String txtDFProductExposureSelection="txtDFProductExposureSelection";
	
	
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
	public String 	btnKNRExculdedCountry = "btnKNRExculdedCountry";
	@ElementDefinition
	public String 	txtKNRExculdedCountry = "txtKNRExculdedCountry";	
	
	
	
	@ElementDefinition
	public String btnCMEndorsementFactorSelectOption="btnCMEndorsementFactorSelectOption";
	@ElementDefinition
	public String btnCMRecallExpensesBasePremiumFactorSelectOption="btnCMRecallExpensesBasePremiumFactorSelectOption";
	@ElementDefinition
	public String btnCMBusinessInterruptionEndorsementAggregateLimitofLiabilitySelectOption="btnCMBusinessInterruptionEndorsementAggregateLimitofLiabilitySelectOption";
	@ElementDefinition
	public String btnCMTravelSecurityEvacuationEndorsementAggregateLimitofLiabilitySelectOption="btnCMTravelSecurityEvacuationEndorsementAggregateLimitofLiabilitySelectOption";
	@ElementDefinition
	public String btnCMExpatriateSecurityEvacuationEndorsementAggregateLimitofLiabilitySelectOption="btnCMExpatriateSecurityEvacuationEndorsementAggregateLimitofLiabilitySelectOption";
	
	
	@ElementDefinition
	public String txtCMEndorsementFactorSelection="txtCMEndorsementFactorSelection";
	@ElementDefinition
	public String txtCMRecallExpensesBasePremiumFactorSelection="txtCMRecallExpensesBasePremiumFactorSelection";
	@ElementDefinition
	public String txtCMBusinessInterruptionEndorsementAggregateLimitofLiabilitySelection="txtCMBusinessInterruptionEndorsementAggregateLimitofLiabilitySelection";
	@ElementDefinition
	public String txtCMTravelSecurityEvacuationEndorsementAggregateLimitofLiabilitySelection="txtCMTravelSecurityEvacuationEndorsementAggregateLimitofLiabilitySelection";
	@ElementDefinition
	public String txtCMExpatriateSecurityEvacuationEndorsementAggregateLimitofLiabilitySelection="txtCMExpatriateSecurityEvacuationEndorsementAggregateLimitofLiabilitySelection";
	
	@TimeMethod
	@ScreenShot
	public void UmRatingKNR(String tcID, SoftAssert softAs) throws Exception;
	public void Verify_SRM_KNR_Error_Msg(String tcID, SoftAssert softAs) throws Exception;
	public void Update_SRM_KNR(String tcID, SoftAssert softAs) throws Exception;

}
