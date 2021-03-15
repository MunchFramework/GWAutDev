package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface NewSubmissionPage extends Page {

	@ElementDefinition
	public String tabActions = "tabActions";
	@ElementDefinition
	public String menuLinkNewSubmission = "menuLinkNewSubmission";
	@ElementDefinition
	public String btnSelect = "btnSelect";
	@ElementDefinition
	public String ddWritingApproach = "ddWritingApproach";
	@ElementDefinition
	public String ddPolicyForms = "ddPolicyForms";
	@ElementDefinition
	public String txtRevenue = "txtRevenue";
	@ElementDefinition
	public String txtAnnualPremium = "txtAnnualPremium";
	@ElementDefinition
	public String txtLimitPerOccurrence = "txtLimitPerOccurrence";
	@ElementDefinition
	public String txtDeductiblePerOccurence = "txtDeductiblePerOccurence";
	@ElementDefinition
	public String tabCRI = "tabCRI";
	@ElementDefinition
	public String btnNext = "btnNext";
	@ElementDefinition
	public String btnQuote = "btnQuote";
	@ElementDefinition
	public String btnBindOptions = "btnBindOptions";
	@ElementDefinition
	public String btnIssueOnly = "btnIssueOnly";
	@ElementDefinition
	public String btnOk = "btnOk";

	@ElementDefinition
	public String ddDepartmentCode = "ddDepartmentCode";
	@ElementDefinition
	public String ddLegalEntity = "ddLegalEntity";
	@ElementDefinition
	public String ddOwnershipType = "ddOwnershipType";
	@ElementDefinition
	public String txtCommissionPercentage = "txtCommissionPercentage";

	@ElementDefinition
	public String tabForms = "tabForms";

	@ElementDefinition
	public String lnkViewPolicy = "lnkViewPolicy";

	@ElementDefinition
	public String lblPolicyNo = "lblPolicyNo";

	@ElementDefinition
	public String txtCorporateAssets = "txtCorporateAssets";

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
	public String chkCrime = "chkCrime";
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
	public String tabEPL = "tabEPL";

	@ElementDefinition
	public String txtEplAggLmtLiab = "txtEplAggLmtLiab";
	@ElementDefinition
	public String txtEplRetention = "txtEplRetention";
	
	@ElementDefinition
	public String dtEplPriorDate = "dtEplPriorDate";
	
	@ElementDefinition
	public String txtWorkPlaceVioExp = "txtWorkPlaceVioExp";
	
	@ElementDefinition
	public String txtAddClaimLmt = "txtAddClaimLmt";
	
	@ElementDefinition
	public String ddOffice = "ddOffice";
	
	@ElementDefinition
	public String ddUnderwriter = "ddUnderwriter";
	
	@ElementDefinition
	public String ddUnderwriterAssistant = "ddUnderwriterAssistant";
	
	@ElementDefinition
	public String ddAssignedTo = "ddAssignedTo";
	
	@ElementDefinition
	public String btnPrintOptions = "btnPrintOptions";
	
	@ElementDefinition
	public String lnkPrintBinder = "lnkPrintBinder";
	
	@ElementDefinition
	public String btnFinalize = "btnFinalize";
	
	
	@ElementDefinition
	public String lblPremium = "lblPremium";
	@ElementDefinition
	public String lblRatingWorkSheetId = "lblRatingWorkSheetId";
	
	@ElementDefinition
	public String txtUnionAllClass3CA = "txtUnionAllClass3CA";
	@ElementDefinition
	public String txtUnionAllClass3NJ = "txtUnionAllClass3NJ";
	
	@ElementDefinition
	public String txtUnionAllClass2  = "txtUnionAllClass2";
	@ElementDefinition
	public String txtUnionAllClass1 = "txtUnionAllClass1";
	@ElementDefinition
	public String txtNonUnionFulltimeClass3CA = "txtNonUnionFulltimeClass3CA";
	@ElementDefinition
	public String txtNonUnionFulltimeClass3NJ = "txtNonUnionFulltimeClass3NJ";
	
	@ElementDefinition
	public String txtNonUnionFulltimeClass2 = "txtNonUnionFulltimeClass2";
	@ElementDefinition
	public String txtNonUnionFulltimeClass1 = "txtNonUnionFulltimeClass1";
	@ElementDefinition
	public String txtNonUnionICsClass3CA = "txtNonUnionICsClass3CA";
	@ElementDefinition
	public String txtNonUnionICsClass3NJ = "txtNonUnionICsClass3NJ";
	
	@ElementDefinition
	public String txtNonUnionICsClass2 = "txtNonUnionICsClass2";
	@ElementDefinition
	public String txtNonUnionICsClass1 = "txtNonUnionICsClass1";
	@ElementDefinition
	public String txtNYCLass = "txtNYCLass";
	
	@ElementDefinition
	public String txtForeignEmpl = "txtForeignEmpl";
	@ElementDefinition
	public String txtPlanAssets = "txtPlanAssets"; 
	@ElementDefinition
	public String txtMPLHazard = "txtMPLHazard";
	@ElementDefinition
	public String txtEmployedLawyers = "txtEmployedLawyers";
	@ElementDefinition
	public String 	tabEMP ="tabEMP";
	@ElementDefinition
	public String 	tabENO="tabENO";
	@ElementDefinition
	public String 	tabFID="tabFID";
	@ElementDefinition
	public String 	tabKNR="tabKNR";
	@ElementDefinition
	public String tabCYB="tabCYB";
	
	@ElementDefinition
	public String txtEMPAggLimit= "txtEMPAggLimit";
	@ElementDefinition
	public String txtEMPRetention="txtEMPRetention";
	@ElementDefinition
	public String txtEMPPriorDate= "txtEMPPriorDate"; 
	@ElementDefinition
	public String  txtEMPDutytoDefend=   "txtEMPDutytoDefend";
	@ElementDefinition
	public String 	txtENOAggLimit =	"txtENOAggLimit"; 
	@ElementDefinition
	public String 	txtENORetention =	"txtENORetention"; 
	@ElementDefinition
	public String 	txtENOPriorDate =    "txtENOPriorDate"; 
	@ElementDefinition
	public String 	txtENODutytoDefend =    "txtENODutytoDefend"; 
	@ElementDefinition
	public String 	txtENODProffessionalServices =	"txtENODProffessionalServices"; 
	@ElementDefinition
	public String 	txtENORetroDate =	"txtENORetroDate";
		
	@ElementDefinition
	public String 	txtFIDAggLimit =	"txtFIDAggLimit";
	@ElementDefinition
	public String 	txtFIDRetention =     "txtFIDRetention"; 
	@ElementDefinition
	public String 	txtFIDPriorDate =    "txtFIDPriorDate"; 
	@ElementDefinition
	public String 	 txtFIDDutytoDefend =   "txtFIDDutytoDefend";
	@ElementDefinition
	public String 	chkFIDVoluntary =	"chkFIDVoluntary"; 
	@ElementDefinition
	public String 	txtFIDVoluntary =	"txtFIDVoluntary"; 
	@ElementDefinition
	public String 	chkFIDPenaltiesHIPAA = "chkFIDPenaltiesHIPAA";
	@ElementDefinition
	public String 	txtFIDPenaltiesHIPAA =	"txtFIDPenaltiesHIPAA"; 
	@ElementDefinition
	public String 	chkFIDPenalties502 =	"chkFIDPenalties502"; 
	@ElementDefinition
	public String 	txtFIDPenalties502 =	"txtFIDPenalties502"; 
	@ElementDefinition
	public String 	chkFIDPenalties2006 = 	"chkFIDPenalties2006"; 
	@ElementDefinition
	public String 	txtFIDPenalties2006 =	"txtFIDPenalties2006";
	@ElementDefinition
	public String 	chkFIDPenaltiesCareAct =	"chkFIDPenaltiesCareAct"; 
	@ElementDefinition
	public String 	txtFIDPenaltiesCareAct =	"txtFIDPenaltiesCareAct"; 
	@ElementDefinition
	public String 	chkFIDPenalty4975 =	"chkFIDPenalty4975"; 
	@ElementDefinition
	public String 	txtFIDenalty4975 ="txtFIDenalty4975"; 
	@ElementDefinition
	public String 	chkFIDAdditionalClaim =	"chkFIDAdditionalClaim"; 
	@ElementDefinition
	public String 	txtFIDAdditionalClaim =	"txtFIDAdditionalClaim"; 
	

	@ElementDefinition
	public String 	txtKNRRasomLimit = "txtKNRRasomLimit";
	@ElementDefinition
	public String 	txtKNRRasomDedcuctible = "txtKNRRasomDedcuctible";

	@ElementDefinition
	public String 	txtKNRInsuredEventExpenses = "txtKNRInsuredEventExpenses";

	@ElementDefinition
	public String 	txtKNRRecallExpenses = "txtKNRRecallExpenses";

	@ElementDefinition
	public String 	txtKNRAccidentmaxben = "txtKNRAccidentmaxben";
	@ElementDefinition
	public String 	txtKNRAccidentAgg = "txtKNRAccidentAgg";
	@ElementDefinition
	public String 	txtKNRAccidentDeathBen = "txtKNRAccidentDeathBen";
	@ElementDefinition
	public String 	txtKNRAccidentlimbloss = "txtKNRAccidentlimbloss";
	@ElementDefinition
	public String 	txtKNRAccidentsightloss = "txtKNRAccidentsightloss";
	@ElementDefinition
	public String 	txtKNRAccidentspeechloss = "txtKNRAccidentspeechloss";
	@ElementDefinition
	public String 	txtKNRAccidentpermntotal = "txtKNRAccidentpermntotal";
	@ElementDefinition
	public String 	txtKNRAccidentmutilationben = "txtKNRAccidentmutilationben";

	@ElementDefinition
	public String 	chkKNRthreatresponse = "chkKNRthreatresponse";
	@ElementDefinition
	public String 	txtKNRthreatresponselimit = "txtKNRthreatresponselimit";
	@ElementDefinition
	public String 	txtKNRthreatresponseIndemnity = "txtKNRthreatresponseIndemnity";

	@ElementDefinition
	public String 	chkKNRdissapearance = "chkKNRdissapearance";
	@ElementDefinition
	public String 	txtKNRdissapearancelimit = "txtKNRdissapearancelimit";
	@ElementDefinition
	public String 	txtKNRdissapearanceindemnity = "txtKNRdissapearanceindemnity";
	@ElementDefinition
	public String 	txtKNRdissapearancewaitingperiod = "txtKNRdissapearancewaitingperiod";

	@ElementDefinition
	public String 	chkKNRBussinessInteruption = "chkKNRBussinessInteruption";
	@ElementDefinition
	public String 	txtKNRBusinessInteruptionLimit = "txtKNRBusinessInteruptionLimit";
	@ElementDefinition
	public String 	txtKNRBusinessInteruptionAggLimit = "txtKNRBusinessInteruptionAggLimit";
	@ElementDefinition
	public String 	txtKNRBusinessInteruptionIndemnity = "txtKNRBusinessInteruptionIndemnity";
	@ElementDefinition
	public String 	txtKNRBusinessInteruptionWaitingPeriod = "txtKNRBusinessInteruptionWaitingPeriod";

	@ElementDefinition
	public String 	chkKNRTravelevacuationExp = "chkKNRTravelevacuationExp";
	@ElementDefinition
	public String 	txtKNRTravelevacuationExpLimit = "txtKNRTravelevacuationExpLimit";
	@ElementDefinition
	public String 	txtKNRTravelevacuationExpAggregate = "txtKNRTravelevacuationExpAggregate";
	@ElementDefinition
	public String 	txtKNRTravelevacuationExpPersonaleffects = "txtKNRTravelevacuationExpPersonaleffects";
	@ElementDefinition
	public String 	txtKNRTravelevacuationExpRelocationcosts = "txtKNRTravelevacuationExpRelocationcosts";


	@ElementDefinition
	public String 	chkKNRExpariatevacuationExp = "chkKNRExpariatevacuationExp";
	@ElementDefinition
	public String 	txtKNRExpariatevacuationExpLimit = "txtKNRExpariatevacuationExpLimit";
	@ElementDefinition
	public String 	txtKNRExpariatevacuationExpAggregate = "txtKNRExpariatevacuationExpAggregate";
	@ElementDefinition
	public String 	txtKNRExpariatevacuationExpPersonal = "txtKNRExpariatevacuationExpPersonal";
	@ElementDefinition
	public String 	txtKNRExpariatevacuationExpSalary = "txtKNRExpariatevacuationExpSalary";
	@ElementDefinition
	public String 	txtKNRExpariatevacuationExpRelocation = "txtKNRExpariatevacuationExpRelocation";
	@ElementDefinition
	public String 	txtKNRExpariatevacuationExpRepatriation = "txtKNRExpariatevacuationExpRepatriation";
	

	@ElementDefinition
	public String 	txtCYBAggregateLimit="txtCYBAggregateLimit";
	@ElementDefinition
	public String 	txtCYBRetention="txtCYBRetention";
	@ElementDefinition
	public String 	txtCYBRetroDate="txtCYBRetroDate";
	@ElementDefinition
	public String 	txtCYBContinuityDate="txtCYBContinuityDate";

	@ElementDefinition
	public String 	chkCYBBreachResponseCosts="chkCYBBreachResponseCosts";
	@ElementDefinition
	public String 	txtCYBBreachResponseCostsSublimit="txtCYBBreachResponseCostsSublimit";
	@ElementDefinition
	public String 	txtCYBBreachResponseCostsRetention="txtCYBBreachResponseCostsRetention";

	@ElementDefinition
	public String 	chkCYBCyberExtortionCosts="chkCYBCyberExtortionCosts";
	@ElementDefinition
	public String 	txtCYBCyberExtortionCostsSublimit="txtCYBCyberExtortionCostsSublimit";
	@ElementDefinition
	public String 	txtCYBCyberExtortionCostsRetention="txtCYBCyberExtortionCostsRetention";

	@ElementDefinition
	public String 	chkCYBDataLossCosts="chkCYBDataLossCosts";
	@ElementDefinition
	public String 	txtCYBDataLossCostsSublimit="txtCYBDataLossCostsSublimit";
	@ElementDefinition
	public String 	txtCYBDataLossCostsRetention="txtCYBDataLossCostsRetention";

	@ElementDefinition
	public String 	chkCYBBusinessInteruptions="chkCYBBusinessInteruptions";
	@ElementDefinition
	public String 	txtCYBBusinessInteruptionsSublimit="txtCYBBusinessInteruptionsSublimit";
	@ElementDefinition
	public String 	txtCYBBusinessInteruptionsRetention="txtCYBBusinessInteruptionsRetention";

	@ElementDefinition
	public String 	chkCYBContigentBusinessInteruptions="chkCYBContigentBusinessInteruptions";
	@ElementDefinition
	public String 	txtCYBContigentBusinessInteruptionsSublimit="txtCYBContigentBusinessInteruptionsSublimit";
	@ElementDefinition
	public String 	txtCYBContigentBusinessInteruptionsRetention="txtCYBContigentBusinessInteruptionsRetention";

	@ElementDefinition
	public String 	chkCYBBreachLiability="chkCYBBreachLiability";
	@ElementDefinition
	public String 	txtCYBBreachLiabilitySublimit="txtCYBBreachLiabilitySublimit";
	@ElementDefinition
	public String 	txtCYBBreachLiabilityRetention="txtCYBBreachLiabilityRetention";

	@ElementDefinition
	public String 	chkCYBRegulatoryPenalties="chkCYBRegulatoryPenalties";
	@ElementDefinition
	public String 	txtCYBRegulatoryPenaltiesSublimit="txtCYBRegulatoryPenaltiesSublimit";
	@ElementDefinition
	public String 	txtCYBRegulatoryPenaltiesRetention="txtCYBRegulatoryPenaltiesRetention";

	@ElementDefinition
	public String 	chkCYBPCIAssessments="chkCYBPCIAssessments";
	@ElementDefinition
	public String 	txtCYBPCIAssessmentsSublimit="txtCYBPCIAssessmentsSublimit";
	@ElementDefinition
	public String 	txtCYBPCIAssessmentsRetention="txtCYBPCIAssessmentsRetention";

	@ElementDefinition
	public String 	chkCYBMediaLiability="chkCYBMediaLiability";
	@ElementDefinition
	public String 	txtCYBMediaLiabilitySublimit="txtCYBMediaLiabilitySublimit";
	@ElementDefinition
	public String 	txtCYBMediaLiabilityRetention="txtCYBMediaLiabilityRetention";

	@ElementDefinition
	public String 	chkCYBTechnologyErrors="chkCYBTechnologyErrors";
	@ElementDefinition
	public String 	txtCYBTechnologyErrorsSublimit="txtCYBTechnologyErrorsSublimit";
	@ElementDefinition
	public String 	txtCYBTechnologyErrorsRetention="txtCYBTechnologyErrorsRetention";

	@ElementDefinition
	public String 	chkCYBPCIRecertifications="chkCYBPCIRecertifications";
	@ElementDefinition
	public String 	txtCYBPCIRecertificationsSublimit="txtCYBPCIRecertificationsSublimit";
	@ElementDefinition
	public String 	txtCYBPCIRecertificationsRetention="txtCYBPCIRecertificationsRetention";
	@TimeMethod
	@ScreenShot
	public void createNewSubmission(String tcID, SoftAssert softAs) throws Exception;
}
