package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmRatingEZExcessPage extends Page{

	@ElementDefinition
	public String lblEZExcessScreen = "lblEZExcessScreen";
	@ElementDefinition
	public String txtCommission = "txtCommission";
	@ElementDefinition
	public String btnGetRater = "btnGetRater";
	@ElementDefinition
	public String txtPrimaryLimit = "txtPrimaryLimit";
	@ElementDefinition
	public String txtPositionInTower = "txtPositionInTower";
	@ElementDefinition
	public String txtCommontextfield = "txtCommontextfield";
	@ElementDefinition
	public String txtRateShiftFactor = "txtRateShiftFactor";
	@ElementDefinition
	public String txtPrecedingLimit = "txtPrecedingLimit";
	@ElementDefinition
	public String txtPrecedingLimitPartOf = "txtPrecedingLimitPartOf";
	@ElementDefinition
	public String txtEverestLimitPartOf = "txtEverestLimitPartOf";
	@ElementDefinition
	public String btnTerrorism = "btnTerrorism";
	@ElementDefinition
	public String btnInadequateExcessivePricing = "btnInadequateExcessivePricing";
	@ElementDefinition
	public String btnType = "btnType";
	@ElementDefinition
	public String txtAggregateLimitofLiabilitySel = "txtAggregateLimitofLiabilitySel";
	@ElementDefinition
	public String txtUnderlyingAggregateLimitofLiabilitySel = "txtUnderlyingAggregateLimitofLiabilitySel";
	@ElementDefinition
	public String txtAttachmentPoint = "txtAttachmentPoint";
	@ElementDefinition
	public String txtPrecedingLayerPremium = "txtPrecedingLayerPremium";
	@ElementDefinition
	public String btnUpdateCoverages = "btnUpdateCoverages";
	@ElementDefinition
	public String txtInadequateExcessivePricingSel = "txtInadequateExcessivePricingSel";
	
	@ElementDefinition
	public String txtGRMFinancials = "txtGRMFinancials";
	@ElementDefinition
	public String 	txtGRMClaimsHistory = "txtGRMClaimsHistory";
	@ElementDefinition
	public String txtGRMGeographicLocation = "txtGRMGeographicLocation";
	@ElementDefinition
	public String txtGRMIndustryClassification = "txtGRMIndustryClassification";
	@ElementDefinition
	public String txtGRMLossHistory = "txtGRMLossHistory";
	@ElementDefinition
	public String txtGRMOthersFactorsUnique = "txtGRMOthersFactorsUnique";
	
	@ElementDefinition
	public String txtARMCYBBusinessActivities = "txtARMCYBBusinessActivities";
	@ElementDefinition
	public String txtARMCYBOrganizationandGovernance = "txtARMCYBOrganizationandGovernance";
	@ElementDefinition
	public String txtARMCYBNetworkSecurity = "txtARMCYBNetworkSecurity";
	@ElementDefinition
	public String txtARMCYBDataManagement = "txtARMCYBDataManagement";
	@ElementDefinition
	public String txtARMCYBIncidentResponse = "txtARMCYBIncidentResponse";
	@ElementDefinition
	public String txtARMCYBBusinessContinuityPlanning = "txtARMCYBBusinessContinuityPlanning";
	@ElementDefinition
	public String txtARMCYBIncidentHistory = "txtARMCYBIncidentHistory";
	@ElementDefinition
	public String txtARMDNOAcquisitionDivestitureActivity = "txtARMDNOAcquisitionDivestitureActivity";
	@ElementDefinition
	public String txtARMEMPLegalServiceMultiplier = "txtARMEMPLegalServiceMultiplier";
	@ElementDefinition
	public String txtARMEMPLegalDeptRiskManagement = "txtARMEMPLegalDeptRiskManagement";
	@ElementDefinition
	public String txtARMEMPUnusualRiskCharacteristics = "txtARMEMPUnusualRiskCharacteristics";
	@ElementDefinition
	public String txtARMENOUseofContracts = "txtARMENOUseofContracts";
	@ElementDefinition
	public String txtARMENORiskManagementPractices = "txtARMENORiskManagementPractices";
	@ElementDefinition
	public String txtARMENOUseofSubcontractors = "txtARMENOUseofSubcontractors";
	@ElementDefinition
	public String txtARMENOLongevityofOperations = "txtARMENOLongevityofOperations";
	@ElementDefinition
	public String txtARMEPLEEO1Ratios = "txtARMEPLEEO1Ratios";
	@ElementDefinition
	public String txtARMFIDEmployerSecurities = "txtARMFIDEmployerSecurities";
	@ElementDefinition
	public String txtARMFIDFundingStatusoftheCompany = "txtARMFIDFundingStatusoftheCompany";
	@ElementDefinition
	public String txtARMFIDAssetsUnderManagement = "txtARMFIDAssetsUnderManagement";
	@ElementDefinition
	public String lblAdditionalRateModifierCYB = "lblAdditionalRateModifierCYB";
	@ElementDefinition
	public String lblAdditionalRateModifierDNO = "lblAdditionalRateModifierDNO";
	@ElementDefinition
	public String lblAdditionalRateModifierEMP = "lblAdditionalRateModifierEMP";
	@ElementDefinition
	public String lblAdditionalRateModifierENO = "lblAdditionalRateModifierENO";
	@ElementDefinition
	public String lblAdditionalRateModifierEPL = "lblAdditionalRateModifierEPL";
	@ElementDefinition
	public String lblAdditionalRateModifierFID = "lblAdditionalRateModifierFID";
	@ElementDefinition
	public String lnkExpQuote4 = "lnkExpQuote4";
	
	@ElementDefinition
	public String txtMaxVal = "txtMaxVal";
	@ElementDefinition
	public String txtMinVal = "txtMinVal";
	@ElementDefinition
	public String txtUpdtAttachPoint = "txtUpdtAttachPoint";
	
	@TimeMethod
	@ScreenShot
	public void UmRatingEZExcess(String tcID, SoftAssert softAs) throws Exception;

	public void UmRatingEZExcessMinMaxValidation(String tcID, SoftAssert softAssert) throws Exception;

}
