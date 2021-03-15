package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface RewritePage extends Page{

	@ElementDefinition
	public String lblCanceledPolicy = "lblCanceledPolicy";
	@ElementDefinition
	public String btnActionsTab = "btnActionsTab";
	@ElementDefinition
	public String btnRewriteFullTerm = "btnRewriteFullTerm";
	@ElementDefinition
	public String btnCoverageSelectionNext = "btnCoverageSelectionNext";
	@ElementDefinition
	public String btnPolicyInfoNext = "btnPolicyInfoNext";
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
	@ElementDefinition
	public String lnkRewriteSubmission = "lnkRewriteSubmission";
	@ElementDefinition
	public String lblRewritePolicy = "lblRewritePolicy";
	@ElementDefinition
	public String txtExpDate = "txtExpDate";
	@ElementDefinition
	public String lblCoverageSelection = "lblCoverageSelection";
	@ElementDefinition
	public String txtOrganization = "txtOrganization";
	@ElementDefinition
	public String txtProducerCode = "txtProducerCode";
	@ElementDefinition
	public String txtProducerContact = "txtProducerContact";
	@ElementDefinition
	public String txtBindingContact = "txtBindingContact";
	@ElementDefinition
	public String txtDepartment = "txtDepartment";
	@ElementDefinition
	public String txtUnderwriter = "txtUnderwriter";
	@ElementDefinition
	public String txtUnderwriterAssistant = "txtUnderwriterAssistant";
	@ElementDefinition
	public String txtUnderwritingFees = "txtUnderwritingFees";
	@ElementDefinition
	public String txtCommission = "txtCommission";
	@ElementDefinition
	public String lblPayment = "lblPayment";
	@ElementDefinition
	public String txtWritingApproach = "txtWritingApproach";
	@ElementDefinition
	public String txtSubline = "txtSubline";
	@ElementDefinition
	public String txtSURType = "txtSURType";
	@ElementDefinition
	public String txtBondType = "txtBondType";
	@ElementDefinition
	public String txtSAACode = "txtSAACode";
	@ElementDefinition
	public String chkQuarterly = "chkQuarterly";
	@ElementDefinition
	public String btnSAACodeSearch = "btnSAACodeSearch";
	@ElementDefinition
	public String btnSearch = "btnSearch";
	@ElementDefinition
	public String btnSelect = "btnSelect";
	@ElementDefinition
	public String ExposuresLink = "ExposuresLink";
	@ElementDefinition
	public String HazGroup = "HazGroup";
	@TimeMethod
	@ScreenShot
	public void Rewrite(String tcID, SoftAssert softAs) throws Exception;
}
