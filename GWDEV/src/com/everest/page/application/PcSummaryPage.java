package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface PcSummaryPage extends Page {

	@ElementDefinition
	public String Issuance_Tran = "Issuance_Tran";
	@ElementDefinition
	public String PaymentPageLink = "PaymentPageLink";
	@ElementDefinition
	public String BillingMethod = "BillingMethod";
	@ElementDefinition
	public String PaymentPlan = "PaymentPlan";
	@ElementDefinition
	public String tabENO = "tabENO";
	@ElementDefinition
	public String tabKNR = "tabKNR";
	@ElementDefinition
	public String btnNext = "btnNext";
	@ElementDefinition
	public String txtFIDAggregateLimitofLiability = "txtFIDAggregateLimitofLiability";
	@ElementDefinition
	public String txtFIDRetention = "txtFIDRetention";
	@ElementDefinition
	public String chkVoluntaryComplianceProgramCosts = "chkVoluntaryComplianceProgramCosts";
	@ElementDefinition
	public String txtCYBAggregateLimitofLiability = "txtCYBAggregateLimitofLiability";
	@ElementDefinition
	public String txtCYBRetention = "txtCYBRetention";
	@ElementDefinition
	public String chkBreachResponseCosts = "chkBreachResponseCosts";
	@ElementDefinition
	public String txtEMPAggregateLimitofLiability = "txtEMPAggregateLimitofLiability";
	@ElementDefinition
	public String txtEMPRetention = "txtEMPRetention";
	@ElementDefinition
	public String txtENOAggregateLimitofLiability = "txtENOAggregateLimitofLiability";
	@ElementDefinition
	public String txtENORetention = "txtENORetention";
	@ElementDefinition
	public String txtKNRRansomLimitofLiability = "txtKNRRansomLimitofLiability";
	@ElementDefinition
	public String txtKNRDeductible = "txtKNRDeductible";
	@ElementDefinition
	public String txtKNRAccidentalDeathMaximumBenefit = "txtKNRAccidentalDeathMaximumBenefit";
		
	@ElementDefinition
	public String btnOk = "btnOk";

		@ElementDefinition
	public String chkDNO = "chkDNO";
	@ElementDefinition
	public String tabDno = "tabDno";
	
	@ElementDefinition
	public String btnClear = "btnClear";
	
	@ElementDefinition
	public String txtAggLmtLiability = "txtAggLmtLiability";
	@ElementDefinition
	public String txtRetention = "txtRetention";
	@ElementDefinition
	public String dtPriorDate = "dtPriorDate";
	@ElementDefinition
	public String txtLimitPerOccurrence = "txtLimitPerOccurrence";
	@ElementDefinition
	public String txtDeductiblePerOccurence = "txtDeductiblePerOccurence";
	
	@ElementDefinition
	public String chkCrime = "chkCrime";
	@ElementDefinition
	public String chkEPL = "chkEPL";
	
	@ElementDefinition
	public String tabEPL = "tabEPL";

	@ElementDefinition
	public String txtEplAggLmtLiability = "txtEplAggLmtLiability";
	@ElementDefinition
	public String txtEplRetention = "txtEplRetention";
	
	@ElementDefinition
	public String dtEplPriorDate = "dtEplPriorDate";
	
	@ElementDefinition
	public String txtWorkPlaceVioExp = "txtWorkPlaceVioExp";
	
	@ElementDefinition
	public String txtAddClaimLmt = "txtAddClaimLmt";
	@ElementDefinition
	public String btnOK = "btnOK";
	@ElementDefinition
	public String chkPremisesCov = "chkPremisesCov";
	@ElementDefinition
	public String chkForgeryCov = "chkForgeryCov";
	@ElementDefinition
	public String txtLimitPremisesCov = "txtLimitPremisesCov";
	@ElementDefinition
	public String txtDeductiblePremisesCov = "txtDeductiblePremisesCov";
	@ElementDefinition
	public String txtLimitForgeryCov = "txtLimitForgeryCov";
	@ElementDefinition
	public String txtDeductibleForgeryCov = "txtDeductibleForgeryCov";	
	@ElementDefinition
	public String chkAdditionalSideCov = "chkAdditionalSideCov";
	@ElementDefinition
	public String lblAdditionalSideCov = "lblAdditionalSideCov";
	@ElementDefinition
	public String txtLimitAdditionalSideCov = "txtLimitAdditionalSideCov";
	@ElementDefinition
	public String chkEPLCrisisCov = "chkEPLCrisisCov";
	@ElementDefinition
	public String txtSubLimitEPLCrisisCov = "txtSubLimitEPLCrisisCov";
	@ElementDefinition
	public String btnCovtab = "btnCovtab";
	@ElementDefinition
	public String txtExcessAggregateLimit = "txtExcessAggregateLimit";
	@ElementDefinition 	
	public String txtExcessUnderlyingAggregateLimit = "txtExcessUnderlyingAggregateLimit";
	@ElementDefinition 	
	public String tabCredit = "tabCredit";
	@ElementDefinition 	
	public String txtCRDPolicyLimit = "txtCRDPolicyLimit";
	@ElementDefinition 	
	public String tabBrokerDealerENO = "tabBrokerDealerENO";
	@ElementDefinition 	
	public String txtBrokerDealerENOPolicyLimit = "txtBrokerDealerENOPolicyLimit";
	@ElementDefinition 	
	public String 	tabCON = "tabCON";
	@ElementDefinition 	
	public String 	txtCONPolicyLimit = "txtCONPolicyLimit";
	@ElementDefinition
	public String tabPRN = "tabPRN";
	@ElementDefinition
	public String txtPRNLimit = "txtPRNLimit";
	@ElementDefinition
	public String txtPRNPartOf = "txtPRNPartOf";
	@ElementDefinition
	public String txtPRNIndemnityPercent = "txtPRNIndemnityPercent";
	
	@ElementDefinition
	public String txtPRLLimit = "txtPRLLimit";
	@ElementDefinition
	public String txtPRLPartOf = "txtPRLPartOf";
	@ElementDefinition
	public String txtPRLIndemnityPercent = "txtPRLIndemnityPercent";
	@ElementDefinition
	public String chkArbitrationAwardDefault = "chkArbitrationAwardDefault";
	@ElementDefinition
	public String Crime = "Crime";
	@ElementDefinition
	public String Cyber_1 = "Cyber_1";
	@ElementDefinition
	public String Cyber_2 = "Cyber_2";
	@ElementDefinition
	public String 	DNO = "DNO";
	@ElementDefinition
	public String EMP = "EMP";
	@ElementDefinition
	public String ENO = "ENO";
	@ElementDefinition
	public String EPL = "EPL";
	@ElementDefinition
	public String FID = "FID";
	@ElementDefinition
	public String KNR = "KNR";
	@ElementDefinition
	public String Print_btn = "Print_btn";
	@ElementDefinition
	public String Finalize_btn = "Finalize_btn";
	@ElementDefinition
	public String DocumentsPage = "DocumentsPage";
	@ElementDefinition
	public String EndDoc_Link = "EndDoc_Link";
	
	@TimeMethod
	@ScreenShot
	public void PcPaymentDetailsValidation(String tcID, SoftAssert softAs) throws Exception;
	public void PcPremiumBreakdownValidation(String tcID, SoftAssert softAssert) throws Exception; 
	public void PcDownloadForm(String tcID, SoftAssert softAssert) throws Exception; 
	public void PcPrintForm(String tcID, SoftAssert softAssert) throws Exception;
}