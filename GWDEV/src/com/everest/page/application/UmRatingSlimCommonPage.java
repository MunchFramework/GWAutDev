package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmRatingSlimCommonPage extends Page{
	@ElementDefinition
	public String btnRatingSlimCommon = "btnRatingSlimCommon";
	@ElementDefinition
	public String btnRatingSubmissionInformation = "btnRatingSubmissionInformation";
	@ElementDefinition
	public String btnRatingPremiumSummary = "btnRatingPremiumSummary";
	@ElementDefinition
	public String btnWritingApproach = "btnWritingApproach";
	@ElementDefinition
	public String txtPremium = "txtPremium";
	@ElementDefinition
	public String txtCommission = "txtCommission";
	@ElementDefinition
	public String txtCedingCommission = "txtCedingCommission";
	@ElementDefinition
	public String btnGetRater = "btnGetRater";
	@ElementDefinition
	public String txtCONAggregarateLimit = "txtCONAggregarateLimit";
	@ElementDefinition
	public String txtCONRetetntion = "txtCONRetetntion";
	
	@ElementDefinition
	public String 	txtCRDPolicyLimit = "txtCRDPolicyLimit";
	@ElementDefinition
	public String 	txtCRDInsuredExposure = "txtCRDInsuredExposure";
	@ElementDefinition
	public String 	txtCRDPartOf = "txtCRDPartOf";
	@ElementDefinition
	public String 	txtCRDCoveredPercentage = "txtCRDCoveredPercentage";
	@ElementDefinition
	public String 	txtCRDIndemnityPercentage = "txtCRDIndemnityPercentage";
	@ElementDefinition
	public String 	txtCRDWaitingPeriod = "txtCRDWaitingPeriod";
	@ElementDefinition
	public String 	txtCRDTradeYes = "txtCRDTradeYes";
	@ElementDefinition
	public String 	txtCRDTradeNo = "txtCRDTradeNo";
	@ElementDefinition
	public String 	txtCRDNuclearExclusionYes = "txtCRDNuclearExclusionYes";
	@ElementDefinition
	public String 	txtCRDNuclearExclusionNo = "txtCRDNuclearExclusionNo";
	
	@ElementDefinition
	public String 	txtENOAggregateLimit = "txtENOAggregateLimit";
	@ElementDefinition
	public String 	txtENOPerClaimLimit = "txtENOPerClaimLimit";
	@ElementDefinition
	public String 	txtENORetention = "txtENORetention";
	@ElementDefinition
	public String 	txtENOPartOf = "txtENOPartOf";
	@ElementDefinition
	public String 	chkENOCvgAAddtoPolicy = "chkENOCvgAAddtoPolicy";
	@ElementDefinition
	public String 	txtENOCvgAAggregateLimit = "txtENOCvgAAggregateLimit";
	@ElementDefinition
	public String 	txtENOCvgAPerClaimLimit = "txtENOCvgAPerClaimLimit";
	@ElementDefinition
	public String 	txtENOCvgARetention = "txtENOCvgARetention";
	@ElementDefinition
	public String 	txtENOCvgAPartOf = "txtENOCvgAPartOf";
	@ElementDefinition
	public String 	chkENORegisteredRepreAddtoPolicy = "chkENORegisteredRepreAddtoPolicy";
	@ElementDefinition
	public String 	txtENORegisteredRepreAggregateLimit = "txtENORegisteredRepreAggregateLimit";
	@ElementDefinition
	public String 	txtENORegisteredReprePerClaimLimit = "txtENORegisteredReprePerClaimLimit";
	@ElementDefinition
	public String 	txtENORegisteredRepreRetention = "txtENORegisteredRepreRetention";
	@ElementDefinition
	public String 	txtENORegisteredReprePartOf = "txtENORegisteredReprePartOf";
	@ElementDefinition
	public String 	chkArbitrationAwardDefault = "chkArbitrationAwardDefault";
	@ElementDefinition
	public String 	chkBusinessInterruption = "chkBusinessInterruption";
	@ElementDefinition
	public String 	chkCurrencyInconvertiblityTransfer = "chkCurrencyInconvertiblityTransfer";
	@ElementDefinition
	public String 	chkEmbargo = "chkEmbargo";
	@ElementDefinition
	public String 	chkExpropriation = "chkExpropriation";
	@ElementDefinition
	public String 	chkForcedAbandonment = "chkForcedAbandonment";
	@ElementDefinition
	public String 	chkForcedDivestiture = "chkForcedDivestiture";
	@ElementDefinition
	public String 	chkLicenseConcessionCancellation = "chkLicenseConcessionCancellation";
	@ElementDefinition
	public String 	chkPoliticalViolence = "chkPoliticalViolence";
	@ElementDefinition
	public String 	chkWrongfulCalling = "chkWrongfulCalling";
	@ElementDefinition
	public String 	btnUpdateCoverage = "btnUpdateCoverage";
	
	@ElementDefinition
	public String 	txtArbitrationAwardDefaultLimit = "txtArbitrationAwardDefaultLimit";
	@ElementDefinition
	public String 	txtBusinessInterruptionLimit = "txtBusinessInterruptionLimit";
	@ElementDefinition
	public String 	txtCurrencyInconvertiblityTransferLimit = "txtCurrencyInconvertiblityTransferLimit";
	@ElementDefinition
	public String 	txtEmbargoLimit = "txtEmbargoLimit";
	@ElementDefinition
	public String 	txtExpropriationLimit = "txtExpropriationLimit";
	@ElementDefinition
	public String 	txtForcedAbandonmentLimit = "txtForcedAbandonmentLimit";
	@ElementDefinition
	public String 	txtForcedDivestitureLimit = "txtForcedDivestitureLimit";
	@ElementDefinition
	public String 	txtLicenseConcessionCancellationLimit = "txtLicenseConcessionCancellationLimit";
	@ElementDefinition
	public String 	txtPoliticalViolenceLimit = "txtPoliticalViolenceLimit";
	@ElementDefinition
	public String 	txtWrongfulCallingLimit = "txtWrongfulCallingLimit";
	
	@ElementDefinition
	public String 		txtArbitrationAwardDefaultPartOf = "txtArbitrationAwardDefaultPartOf";
	@ElementDefinition
	public String 	txtBusinessInterruptionPartOf = "txtBusinessInterruptionPartOf";
	@ElementDefinition
	public String 	txtCurrencyInconvertiblityTransferPartOf = "txtCurrencyInconvertiblityTransferPartOf";
	@ElementDefinition
	public String 	txtEmbargoPartOf = "txtEmbargoPartOf";
	@ElementDefinition
	public String 	txtExpropriationPartOf = "txtExpropriationPartOf";
	@ElementDefinition
	public String 	txtForcedAbandonmentPartOf = "txtForcedAbandonmentPartOf";
	@ElementDefinition
	public String 	txtForcedDivestiturePartOf = "txtForcedDivestiturePartOf";
	@ElementDefinition
	public String 	txtLicenseConcessionCancellationPartOf= "txtLicenseConcessionCancellationPartOf";
	@ElementDefinition
	public String 	txtPoliticalViolencePartOf= "txttxtiticalViolencePartOf";
	@ElementDefinition
	public String 	txtWrongfulCallingPartOf= "txtWrongfulCallingPartOf";
	
	@ElementDefinition
	public String 	txtArbitrationAwardDefaultIdemnityPercent = "txtArbitrationAwardDefaultIdemnityPercent";
	@ElementDefinition
	public String 	txtBusinessInterruptionIdemnityPercent = "txtBusinessInterruptionIdemnityPercent";
	@ElementDefinition
	public String 	txtCurrencyInconvertiblityTransferIdemnityPercent = "txtCurrencyInconvertiblityTransferIdemnityPercent";
	@ElementDefinition
	public String 	txtEmbargoIdemnityPercent = "txtEmbargoIdemnityPercent";
	@ElementDefinition
	public String 	txtExpropriationIdemnityPercent = "txtExpropriationIdemnityPercent";
	@ElementDefinition
	public String 	txtForcedAbandonmentIdemnityPercent ="txtForcedAbandonmentIdemnityPercent";
	@ElementDefinition
	public String 	txtForcedDivestitureIdemnityPercent = "txtForcedDivestitureIdemnityPercent";
	@ElementDefinition
	public String 	txtLicenseConcessionCancellationIdemnityPercent = "txtLicenseConcessionCancellationIdemnityPercent";
	@ElementDefinition
	public String 	txtPoliticalViolenceIdemnityPercent = "txtPoliticalViolenceIdemnityPercent";
	@ElementDefinition
	public String 	txtWrongfulCallingIdemnityPercent = "txtWrongfulCallingIdemnityPercent";
	@ElementDefinition
	public String 	txtNonPaymentLimit = "txtNonPaymentLimit";
	@ElementDefinition
	public String 	txtNonPaymentPartOf = "txtNonPaymentPartOf";
	@ElementDefinition
	public String 	txtNonPaymentIdemnityPercent = "txtNonPaymentIdemnityPercent";
	@ElementDefinition
	public String 	txtREPAggregateLimit = "txtREPAggregateLimit";
	@ElementDefinition
	public String 	txtREPRetetntion = "txtREPRetetntion";	
	@ElementDefinition
	public String 	txtTAXAggregateLimit = "txtTAXAggregateLimit";
	@ElementDefinition
	public String 	txtTAXRetetntion = "txtTAXRetetntion";
	@ElementDefinition
	public String 	txtTAXPartOf = "txtTAXPartOf";
	@ElementDefinition
	public String 	txtSURBondAmount = "txtSURBondAmount";
	@ElementDefinition
	public String 	txtSURPMLPercentage = "txtSURPMLPercentage";
	@ElementDefinition
	public String 	txtREPPartOf = "txtREPPartOf";
	
	@TimeMethod
	@ScreenShot
	public void UmRatingSlimCommon(String tcID, SoftAssert softAs) throws Exception;

}
