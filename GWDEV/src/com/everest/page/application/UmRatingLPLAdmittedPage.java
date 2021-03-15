package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmRatingLPLAdmittedPage extends Page{

	@ElementDefinition
	public String txtIsThereAggDeduct="txtIsThereAggDeduct";
	@ElementDefinition
	public String txtRatingState="txtRatingState";
	@ElementDefinition
	//Common LPL fields- Admitted states all
	public String btnLPLPage="btnLPLPage";
	@ElementDefinition
	public String txtPartTimeFactor="txtPartTimeFactor";
	@ElementDefinition
	public String txtAggregateLimitforPolicyPeriod="txtAggregateLimitforPolicyPeriod";
	@ElementDefinition
	public String txtAggregateLimitperClaim="txtAggregateLimitperClaim";
	@ElementDefinition
	public String txtAggregateDeductibleforPolicy="txtAggregateDeductibleforPolicy";
	@ElementDefinition
	public String txtAggregateDeductibleperClaim="txtAggregateDeductibleperClaim";
	@ElementDefinition
	public String txtRetroactiveDate="txtRetroactiveDate";
	@ElementDefinition
	public String txtCreditDebit="txtCreditDebit";
	@ElementDefinition
	public String txtAOPComments="txtAOPComments";
	@ElementDefinition
	public String txtQualityofManagement="txtQualityofManagement";
	@ElementDefinition
	public String txtYearsofExperience="txtYearsofExperience";
	@ElementDefinition
	public String txtLossControl="txtLossControl";
	@ElementDefinition
	public String txtDate="txtDate";
	@ElementDefinition
	public String txtUnique="txtUnique";
	@ElementDefinition
	public String txtIRMComments="txtIRMComments";
	//NY CA common fields IRM
	@ElementDefinition
	public String txtQoMDisengagementLetters="txtQoMDisengagementLetters";
	@ElementDefinition
	public String txtQoMDeclinationLetter="txtQoMDeclinationLetter";
	@ElementDefinition
	public String txtQoM2FormsofConflict="txtQoM2FormsofConflict";
	@ElementDefinition
	public String txtQoMMorethan2forms="txtQoMMorethan2forms:";
	@ElementDefinition
	public String txtQoMNoBusinessOrFinancialInvolvement="txtQoMNoBusinessOrFinancialInvolvement";
	@ElementDefinition
	public String txtQoMSplitFeeArrangement="txtQoMSplitFeeArrangement";
	// CA VA common fields
	@ElementDefinition
	public String txtCommonYearsofExperience="txtCommonYearsofExperience";
	//CA IRM fields
	@ElementDefinition
	public String txtCALoCParticipationInLoss="txtCALoCParticipationInLoss";
	@ElementDefinition
	public String txtCALoCAbsenceOfGeneral="txtCALoCAbsenceOfGeneral";
	@ElementDefinition
	public String txtCADateMultipleDocket="txtCADateMultipleDocket";
	@ElementDefinition
	public String txtCAUniqueSpecializedFields="txtCAUniqueSpecializedFields";
	@ElementDefinition
	public String txtCAUniqueDifferentFields="txtCAUniqueDifferentFields";
	//NY IRM fields
	@ElementDefinition
	public String txtNYLoCThreeOrMoreCalendar="txtNYLoCThreeOrMoreCalendar";
	@ElementDefinition
	public String txtNYLoCInHouseLoss="txtNYLoCInHouseLoss";
	@ElementDefinition
	public String txtNYUniqueFirmManaged="txtNYUniqueFirmManaged";
	@ElementDefinition
	public String txtReportDate="txtReportDate";
	@ElementDefinition
	public String txtIncurredLoss="txtIncurredLoss";
	@ElementDefinition
	public String txtIncurredExpense="txtIncurredExpense";
	@ElementDefinition
	public String txtCrisisEventExpensesSublimit="txtCrisisEventExpensesSublimit";
	@ElementDefinition
	public String txtDisciplinaryProceedingsExpensesEachDisciplinarySublimit="txtDisciplinaryProceedingsExpensesEachDisciplinarySublimit";
	@ElementDefinition
	public String txtDisciplinaryProceedingsExpensesAllDisciplinarySublimit="txtDisciplinaryProceedingsExpensesAllDisciplinarySublimit";
	@ElementDefinition
	public String txtSecurityIncidentResponseExpensesEachSecuritySublimit="txtSecurityIncidentResponseExpensesEachSecuritySublimit";
	@ElementDefinition
	public String txtSecurityIncidentResponseExpensesAllSecuritySublimit="txtSecurityIncidentResponseExpensesAllSecuritySublimit";
	@ElementDefinition
	public String txtSubpoenaComplianceExpensesSublimit="txtSubpoenaComplianceExpensesSublimit";
	@ElementDefinition
	public String txtLitigationParticipationExpensesPerdaySublimit="txtLitigationParticipationExpensesPerdaySublimit";
	@ElementDefinition
	public String txtLitigationParticipationExpensesPerClaimSublimit="txtLitigationParticipationExpensesPerClaimSublimit";
	@ElementDefinition
	public String txtLitigationParticipationExpensesAllSublimit="txtLitigationParticipationExpensesAllSublimit";
	@ElementDefinition
	public String txtSeparateClaimExpensesCoverage="txtSeparateClaimExpensesCoverage";
	@ElementDefinition
	public String chkSeparateClaimExpensesCoverage = "chkSeparateClaimExpensesCoverage";
	@ElementDefinition
	public String chkClaimExpensesinAdditiontoLimitofLiabilityEndorsement = "chkClaimExpensesinAdditiontoLimitofLiabilityEndorsement";
	@ElementDefinition
	public String btnUpdateCoverages = "btnUpdateCoverages";
	//IRM checks
		@ElementDefinition
		public String txtQOM_MINValue = "txtQOM_MINValue";
		@ElementDefinition
		public String txtQOM_MAXValue = "txtQOM_MAXValue";
		@ElementDefinition
		public String txtLC_MINValue = "txtLC_MINValue";
		@ElementDefinition
		public String txtLC_MAXValue = "txtLC_MAXValue";
		@ElementDefinition
		public String txtDOC_MINValue = "txtDOC_MINValue";
		@ElementDefinition
		public String txtDOC_MAXValue = "txtDOC_MAXValue";
		@ElementDefinition
		public String txtYOE_MINValue = "txtYOE_MINValue";
		@ElementDefinition
		public String txtYOE_MAXValue = "txtYOE_MAXValue";
		
		@ElementDefinition
		public String txtUC_MINValue = "txtUC_MINValue";
		@ElementDefinition
		public String txtUC_MAXValue = "txtUC_MAXValue";
		@ElementDefinition
		public String btn_AddExpModifier = "btn_AddExpModifier";
		
	
	@TimeMethod
	@ScreenShot
	public void UmRatingLPLAdmitted(String tcID, SoftAssert softAs) throws Exception;
	public void verifyIRMChanges(String tcID, SoftAssert softAs) throws Exception;
	//public void optionalCoverageEnhancements(String tcID, SoftAssert softAs) throws Exception;
	public void addMultipleExperienceModifiers(String tcID, SoftAssert softAs,String stateCode) throws Exception;


}


