package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmSubmissionDetailsPage extends Page {

	@ElementDefinition
	public String DBA_FEIN = "DBA_FEIN";
	@ElementDefinition
	public String DBA_Name = "DBA_Name";
	@ElementDefinition
	public String btnNewSubmission = "btnNewSubmission";
	@ElementDefinition
	public String msg_ErrorMsg = "msg_ErrorMsg";
	@ElementDefinition
	public String btn_Country = "btn_Country";
	@ElementDefinition
	public String txtInsuredName = "txtInsuredName";
	
	@ElementDefinition
	public String btn_RiskClear = "btn_RiskClear";
	@ElementDefinition
	public String btn_Yes = "btn_Yes";
	
	@ElementDefinition
	public String get_SubmissionStatus = "get_SubmissionStatus";
	
	
	
	@ElementDefinition
	public String txt_City = "txt_City";
	@ElementDefinition
	public String txt_Cuntry = "txt_Cuntry";
	
	@ElementDefinition
	public String chkProducts = "chkProducts";
	@ElementDefinition
	public String chkAssumed1="chkAssumed1";
	@ElementDefinition
	public String chkCrime = "chkCrime";
	@ElementDefinition
	public String chkDNO = "chkDNO";
	@ElementDefinition
	public String chkEPL = "chkEPL";
	@ElementDefinition
	public String chkCyber = "chkCyber";
	@ElementDefinition
	public String chkEMP = "chkEMP";
	@ElementDefinition
	public String chkENO = "chkENO";
	@ElementDefinition
	public String chkFID ="chkFID";
	@ElementDefinition
	public String chkKNR = "chkKNR";
	@ElementDefinition
	public String rdbPrimary = "rdbPrimary";
	
	@ElementDefinition
	public String btnDepartment = "btnDepartment";
	@ElementDefinition
	public String txtDepartment = "txtDepartment";
	@ElementDefinition
	public String btnCarrier = "btnCarrier";
	@ElementDefinition
	public String txtCarrier = "txtCarrier";	
	@ElementDefinition
	public String btnProducerOrganization = "btnProducerOrganization";
	@ElementDefinition
	public String txtProducerOrganization = "txtProducerOrganization";
	@ElementDefinition
	public String btnProducerOffice = "btnProducerOffice";
	@ElementDefinition
	public String txtProducerOffice = "txtProducerOffice";
	@ElementDefinition
	
	public String btnProducerContact = "btnProducerContact";
	@ElementDefinition
	public String txtProducerContact = "txtProducerContact";

	@ElementDefinition
	public String btnAdminContact = "btnAdminContact";
	@ElementDefinition
	public String txtAdminContact = "txtAdminContact";

	@ElementDefinition
	public String btnCreateApplication = "btnCreateApplication";

	@ElementDefinition
	public String txtExpiryDate = "txtExpiryDate";
	@ElementDefinition
	public String txtEffDate = "txtEffDate";
	@ElementDefinition
	public String txtStreet1 = "txtStreet1";
	@ElementDefinition
	public String txtZipCode = "txtZipCode";
	@ElementDefinition
	public String txtENOSubtype = "txtENOSubtype";
	@ElementDefinition
	public String btnENOSubtype = "btnENOSubtype";
	@ElementDefinition
	public String txtEverestLimit = "txtEverestLimit";
	@ElementDefinition
	public String txtEverestAttachmentPoint = "txtEverestAttachmentPoint";
	@ElementDefinition
	public String btnInsuredType = "btnInsuredType";
	@ElementDefinition
	public String txtInsuredType = "txtInsuredType";	
	@ElementDefinition
	public String chkPrimary = "chkPrimary";
	@ElementDefinition
	public String chkExcess = "chkExcess";
	@ElementDefinition
	public String chkSlimProducts = "chkSlimProducts";
	@ElementDefinition
	public String txtProjectName = "txtProjectName";
	@ElementDefinition
	public String txtTargetName = "txtTargetName";
	@ElementDefinition
	public String chkQuoteShareYes = "chkQuoteShareYes";
	@ElementDefinition
	public String chkCON = "chkCON";
	@ElementDefinition
	public String chkCRD = "chkCRD";
	@ElementDefinition
	public String chkSLENO = "chkSLENO";
	@ElementDefinition
	public String chkPOL = "chkPOL";
	@ElementDefinition
	public String chkREP = "chkREP";
	@ElementDefinition
	public String chkSUR = "chkSUR";
	@ElementDefinition
	public String chkTAX = "chkTAX";
	@ElementDefinition
	public String btnPolicyCurrency = "btnPolicyCurrency";
	@ElementDefinition
	public String txtPolicyCurrency = "txtPolicyCurrency";
	@ElementDefinition
	public String 	chkDirect = "chkDirect";
	@ElementDefinition
	public String 	chkAssumed = "chkAssumed";
	@ElementDefinition
	public String 	btnSPSubtype = "btnSPSubtype";
	@ElementDefinition
	public String 	txtSPSubtype = "txtSPSubtype";
	@ElementDefinition
	public String btnSPBondType = "btnSPBondType";
	@ElementDefinition
	public String txtSPBondType = "txtSPBondType";
	@ElementDefinition
	public String tab_Submission="tab_Submission";
	@ElementDefinition
	public String chk_editCYB = "chk_editCYB";
	@ElementDefinition
	public String chk_editCRM = "chk_editCRM";
	@ElementDefinition
	public String rd_RenewalYes = "rd_RenewalYes";
	@ElementDefinition
	public String txt_ExpPolicyNum = "txt_ExpPolicyNum";
	
	@ElementDefinition
	public String btn_Accounts = "btn_Accounts";
	@ElementDefinition
	public String lnk_CopySubmission = "lnk_CopySubmission";
	@ElementDefinition
	public String btn_Copy = "btn_Copy";
	@ElementDefinition
	public String Obligor_txtbox = "Obligor_txtbox";
	@ElementDefinition
	public String Obligee_txtbox = "Obligee_txtbox";
	@ElementDefinition
	public String Obligor_Country_dropdown = "Obligor_Country_dropdown";
	@ElementDefinition
	public String Obligee_Country_dropdown = "Obligee_Country_dropdown";
	@ElementDefinition
	public String Obligor_State_dropdown = "Obligor_State_dropdown";
	@ElementDefinition
	public String Obligee_State_dropdown = "Obligee_State_dropdown";
	@ElementDefinition
	public String Obligor_Address = "Obligor_Address";
	@ElementDefinition
	public String Obligee_Address = "Obligee_Address";
	@ElementDefinition
	public String Obligor_City = "Obligor_City";
	@ElementDefinition
	public String Obligee_City = "Obligee_City";
	@ElementDefinition
	public String Obligor_CR = "Obligor_CR";
	@ElementDefinition
	public String Obligee_CR = "Obligee_CR";
	@ElementDefinition
	public String Obligor_ORR = "Obligor_ORR";
	@ElementDefinition
	public String Obligor_Postcode = "Obligor_Postcode";
	@ElementDefinition
	public String Obligee_Postcode = "Obligee_Postcode";
	@ElementDefinition
	public String btnSubmitApplication = "btnSubmitApplication";
	@ElementDefinition
	public String RunOff_Yesbtn = "RunOff_Yesbtn";
	@ElementDefinition
	public String ExpDate_RunOff = "ExpDate_RunOff";
	
	
	
	
	@TimeMethod
	@ScreenShot
	public void UMCopySubmission(String tcID, SoftAssert softAssert) throws Exception;
	public void verify_UmSubmissionDetails(String tcID, SoftAssert softAssert) throws Exception;
	public void UmSubmissionDetails(String tcID, SoftAssert softAs) throws Exception;
	public void edit_UmSubmissionDetails(String tcID, SoftAssert softAssert) throws Exception;
	public void updateTheCreatedApplication(String tcID, SoftAssert softAssert) throws Exception;
	
	public void VerifyTheUpdatedFieldValue(String tcID, SoftAssert softAssert) throws Exception;
	public void veify_UMSubmission_Status(String tcID, SoftAssert softAssert) throws Exception;
	public void _click_RiskIsClear(String tcID, SoftAssert softAssert) throws Exception;
	public void validate_Renewal_ErrorMsg(String tcID, SoftAssert softAssert) throws Exception;
	public void edit_UmAccount_Details(String tcID, SoftAssert softAssert) throws Exception;



}
