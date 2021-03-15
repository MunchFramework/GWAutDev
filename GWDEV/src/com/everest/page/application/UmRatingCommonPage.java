package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmRatingCommonPage extends Page{
	@ElementDefinition
	public String chkCRI = "chkCRI";
	@ElementDefinition
	public String chkDNO = "chkDNO";
	@ElementDefinition
	public String chkEPL = "chkEPL";
	@ElementDefinition
	public String chkEMP = "chkEMP";
	@ElementDefinition
	public String chkENO = "chkENO";
	@ElementDefinition
	public String chkFID = "chkFID";
	@ElementDefinition
	public String chkKNR = "chkKNR";
	@ElementDefinition
	public String chkCYB = "chkCYB";
	@ElementDefinition
	public String txtCommission = "txtCommission";
	@ElementDefinition
	public String btnGetRater = "btnGetRater";
	@ElementDefinition
	public String txtPercentageAnnualPremium = "txtPercentageAnnualPremium";
	@ElementDefinition
	public String txtAdditionalPeriod = "txtAdditionalPeriod";
	@ElementDefinition
	public String ddERPCoverageStatus = "ddERPCoverageStatus";
	@ElementDefinition
	public String txtERPCoverageStatus = "txtERPCoverageStatus";
	@ElementDefinition
	public String btnRatingDNOtab = "btnRatingDNOtab";
	@ElementDefinition
	public String btnRatingCommontab = "btnRatingCommontab";
	
	@ElementDefinition
	public String txtCMSharedLimits = "txtCMSharedLimits";
	@ElementDefinition
	public String txtCMSharedSeparateDefenseCost = "txtCMSharedSeparateDefenseCost";
	@ElementDefinition
	public String	btnCommission = "btnCommission";
	
	@ElementDefinition
	public String txtPercentageAnnualPremium2 = "txtPercentageAnnualPremium2";
	@ElementDefinition
	public String txtPercentageAnnualPremium3 = "txtPercentageAnnualPremium3";
	
	@ElementDefinition
	public String txtAdditionalPeriod1 = "txtAdditionalPeriod1";
	@ElementDefinition
	public String txtAdditionalPeriod2 = "txtAdditionalPeriod2";
	

	@ElementDefinition
	public String txtERPRiskClassification = "txtERPRiskClassification";
	@ElementDefinition
	public String txtRunOffRiskClassification = "txtRunOffRiskClassification";
	@ElementDefinition
	public String txtERPCoverageStatus1 = "txtERPCoverageStatus1";
	@ElementDefinition
	public String txtERPPercentageAnnualPremium = "txtERPPercentageAnnualPremium";
	@ElementDefinition
	public String btnUpdateCoverages = "btnUpdateCoverages";
	
	@ElementDefinition
	public String txtPercentageAnnualPrem1 = "txtPercentageAnnualPrem1";
	
	@ElementDefinition
	public String txtPercentageAnnualPrem3 = "txtPercentageAnnualPrem3";	
	
	@ElementDefinition
	public String txtPercentageAnnualPrem6 = "txtPercentageAnnualPrem6";	
	
	@ElementDefinition
	public String btnRatingEZExcess = "btnRatingEZExcess";	
	
	
	@ElementDefinition
	public String btnRatingSlimCommontab = "btnRatingSlimCommontab";
	@ElementDefinition
	public String PartOf = "PartOf";
	@ElementDefinition
	public String RunOffPremium = "RunOffPremium";
	
	
	
	
	@TimeMethod
	@ScreenShot
	public void UmRatingCommon(String tcID, SoftAssert softAs) throws Exception;
	public void UmUpdateRatingCommon(String tcID, SoftAssert softAssert) throws Exception;
	public void UmValidateRatingCommon(String tcID, SoftAssert softAssert) throws Exception;
	public void UmClickGetRater(String tcID, SoftAssert softAssert) throws Exception;
	public void UmSetPartOfRatingCommon(String tcID, SoftAssert softAssert) throws Exception; 
	public void UmSetRunOffPremium(String tcID, SoftAssert softAssert) throws Exception; 

}
