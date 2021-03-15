package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface OptionalCovPage extends Page {

	@ElementDefinition
	public String btnCoverages = "btnCoverages";
	@ElementDefinition
	public String btnOptionalCov = "btnOptionalCov";
	@ElementDefinition
	public String btnAddCoverages = "btnAddCoverages";
	@ElementDefinition
	public String txtKeyword = "txtKeyword";
	@ElementDefinition
	public String btnSearch = "btnSearch";
	@ElementDefinition
	public String chkCoverage = "chkCoverage";
	@ElementDefinition
	public String btnSelectCoverage = "btnSelectCoverage";

	@ElementDefinition
	public String btnAddSelectedCov = "btnAddSelectedCov";
	@ElementDefinition
	public String btnCategory = "btnCategory";
	@ElementDefinition
	public String tabCoverage = "tabCoverage";
	@ElementDefinition
	public String tabDNO = "tabDNO";
	@ElementDefinition
	public String tabEPL = "tabEPL";
	@ElementDefinition
	public String tabCYB = "tabCYB";
	@ElementDefinition
	public String tabKNR = "tabKNR";
	@ElementDefinition
	public String tabFID = "tabFID";
	@ElementDefinition
	public String txtSepDefenseCostLmt = "txtSepDefenseCostLmt";
	@ElementDefinition
	public String txtRptnRepSubLmtReten = "txtRptnRepSubLmtReten";
	@ElementDefinition
	public String txtSysfailLmtReten = "txtSysfailLmtReten";
	@ElementDefinition
	public String txtWrongFullCollLmtReten = "txtWrongFullCollLmtReten";
	@ElementDefinition
	public String txtSocialEnggLmtReten = "txtSocialEnggLmtReten";
	@ElementDefinition
	public String txtRunOffFormSelection = "txtRunOffFormSelection";
	
	@TimeMethod
	@ScreenShot
	public void OptionalCov(String tcID, SoftAssert softAs) throws Exception;
	public void OptionalCovValid(String tcID, SoftAssert softAs) throws Exception;
	public void VerifyRunOffAndERPFields(String tcID, SoftAssert softAssert) throws Exception;

}
