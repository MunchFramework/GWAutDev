package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface PolicyChangePage extends Page {

	@ElementDefinition
	public String btnActionsTab = "btnActionsTab";
	@ElementDefinition
	public String btnPolicyChangeTab = "btnPolicyChangeTab";
	@ElementDefinition
	public String ddChangeType = "ddChangeType";
	@ElementDefinition
	public String btnChangeDesc = "btnChangeDesc";
	@ElementDefinition
	public String txtChangeDesc = "txtChangeDesc";
	@ElementDefinition
	public String btnNext = "btnNext";
	@ElementDefinition
	public String btnCoverageSelectionNext = "btnCoverageSelectionNext";
	@ElementDefinition
	public String txtOrganization = "txtOrganization";
	@ElementDefinition
	public String txtProducerCode = "txtProducerCode";
	@ElementDefinition
	public String txtProducerContact = "txtProducerContact";
	@ElementDefinition
	public String txtBindingContact = "txtBindingContact";
	@ElementDefinition
	public String btnPolicyInfoNext = "btnPolicyInfoNext";
	@ElementDefinition
	public String btnAddNewLoc = "btnAddNewLoc";
	@ElementDefinition
	public String txtAddress1 = "txtAddress1";
	@ElementDefinition
	public String txtCity = "txtCity";
	@ElementDefinition
	public String txtZip = "txtZip";
	@ElementDefinition
	public String btnOK = "btnOK";
	@ElementDefinition
	public String btnLocationsNext = "btnLocationsNext";
	@ElementDefinition
	public String btnExposuresNext = "btnExposuresNext";
	@ElementDefinition
	public String btnCoveragesNext = "btnCoveragesNext";
	@ElementDefinition
	public String btnModifiersNext = "btnModifiersNext";
	@ElementDefinition
	public String btnRiskAnalysisNext = "btnRiskAnalysisNext";
	@ElementDefinition
	public String btnQuote = "btnQuote";
	@ElementDefinition
	public String btnIssuePolicy = "btnIssuePolicy";
	@ElementDefinition
	public String btnIssueOK = "btnIssueOK";
	@ElementDefinition
	public String lnkViewPolicy = "lnkViewPolicy";

	// Objects for Change Add/Delete/Modify Additional Insureds
	@ElementDefinition
	public String btnInsuredName = "btnInsuredName";
	@ElementDefinition
	public String btnDBAtab = "btnDBAtab";
	@ElementDefinition
	public String btnAddDBA = "btnAddDBA";
	@ElementDefinition
	public String btnRemove = "btnRemove";
	@ElementDefinition
	public String txtName = "txtName";
	@ElementDefinition
	public String txtPhone = "txtPhone";
	@ElementDefinition
	public String txtFax = "txtFax";
	@ElementDefinition
	public String txtEmail1 = "txtEmail1";
	@ElementDefinition
	public String txtEmail2 = "txtEmail2";
	@ElementDefinition
	public String txtWebsite = "txtWebsite";
	@ElementDefinition
	public String txtFEIN = "txtFEIN";
	@ElementDefinition
	public String btnCancel = "btnCancel";

	// Objects for Change Insureds name and Address
	@ElementDefinition
	public String btnName = "btnName";
	@ElementDefinition
	public String txtName1 = "txtName1";
	@ElementDefinition
	public String txtOfficialPhone = "txtOfficialPhone";
	@ElementDefinition
	public String txtFax1 = "txtFax1";
	@ElementDefinition
	public String txtPrimaryEmail = "txtPrimaryEmail";
	@ElementDefinition
	public String txtSecondaryEmail = "txtSecondaryEmail";
	@ElementDefinition
	public String txtFEIN1 = "txtFEIN1";

	@ElementDefinition
	public String btnChangeTo = "btnChangeTo";
	@ElementDefinition
	public String btnEditAddress = "btnEditAddress";
	@ElementDefinition
	public String txtAddress2 = "txtAddress2";
	@ElementDefinition
	public String txtCity1 = "txtCity1";
	@ElementDefinition
	public String txtZip1 = "txtZip1";
	@ElementDefinition
	public String lblPremium = "lblPremium";
	@ElementDefinition
	public String lblRatingWorkSheetId = "lblRatingWorkSheetId";

	@ElementDefinition
	public String txtExpDate = "txtExpDate";
	@ElementDefinition
	public String txtWrittenDate = "txtWrittenDate";
	@ElementDefinition
	public String txtRateAsOfDate = "txtRateAsOfDate";
	@ElementDefinition
	public String txtOffice = "txtOffice";
	@ElementDefinition
	public String txtUnderwriter = "txtUnderwriter";
	@ElementDefinition
	public String txtUnderwriterAsst = "txtUnderwriterAsst";
	@ElementDefinition
	public String btnNextpc = "btnNextpc";
	@ElementDefinition
	public String txtAssignedTo = "txtAssignedTo";
	@ElementDefinition
	public String txtEffectiveDate = "txtEffectiveDate";
	@ElementDefinition
	public String lblPayment = "lblPayment";
	@ElementDefinition
	public String txtEndorsementIssuedDate = "txtEndorsementIssuedDate";
	@ElementDefinition
	public String lblPolicyInfo = "lblPolicyInfo";
	@ElementDefinition
	public String tabForms = "tabForms";
	@ElementDefinition
	public String txtFormsName = "txtFormsName";	
	@ElementDefinition
	public String txtFormsPageCount = "txtFormsPageCount";
	
	@ElementDefinition
	public String txtPreceedingLayerPremium = "txtPreceedingLayerPremium";
	
	@ElementDefinition
	public String txtNewExpirationDate = "txtNewExpirationDate";
	@ElementDefinition
	public String txtRunoffEffectiveDate = "txtRunoffEffectiveDate";
	
	@ElementDefinition
	public String txtRunoffCommission = "txtRunoffCommission";
	@ElementDefinition
	public String msgRunoffAdded = "msgRunoffAdded";
	@ElementDefinition
	public String tabRunOffCommon = "tabRunOffCommon";
	
	@ElementDefinition
	public String txtRunOffPremiumValue = "txtRunOffPremiumValue";
	@ElementDefinition
	public String btnClearValidtion = "btnClearValidtion";
	@ElementDefinition
	public String msgRunoffRemoved = "msgRunoffRemoved";
	
	@TimeMethod
	@ScreenShot
	public void PolicyChange(String tcID, SoftAssert softAs) throws Exception;
	public void PolicyChangeFormValid(String tcID, SoftAssert softAssert) throws Exception;
	public void PolicyChangeRunOff(String tcID, SoftAssert softAs) throws Exception;
	public void PolicyChangeRunOff_1(String tcID, SoftAssert softAs) throws Exception;

	// @TimeMethod
	// @ScreenShot
	// public void PolicyChangeAll(String tcID, SoftAssert softAs) throws Exception;
}
