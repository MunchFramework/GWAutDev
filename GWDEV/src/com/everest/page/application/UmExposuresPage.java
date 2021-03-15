package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmExposuresPage extends Page {


	@ElementDefinition
	public String DBA_Name = "DBA_Name";
	@ElementDefinition
	public String DBA_FEIN = "DBA_FEIN";
	@ElementDefinition
	public String btnExposuresTab = "btnExposuresTab";
	@ElementDefinition
	public String txtRevenue = "txtRevenue";
	@ElementDefinition
	public String txtCorporateAssets = "txtCorporateAssets";	
	@ElementDefinition
	public String txtTotalEmployees = "txtTotalEmployees";
	@ElementDefinition
	public String btnSubmitApplication = "btnSubmitApplication";
	@ElementDefinition
	public String txtStatus = "txtStatus";
	@ElementDefinition
	public String get_SubmissionNumber = "get_SubmissionNumber";
	
	@ElementDefinition
	public String txtMarketSegment = "txtMarketSegment";

	@ElementDefinition
	public String btnNaicsCode = "btnNaicsCode";
	@ElementDefinition
	public String txtNaicsCode = "txtNaicsCode";
	
	@ElementDefinition
	public String txtUnionAllClass3 = "txtUnionAllClass3";
	@ElementDefinition
	public String txtUnionAllClass3NJ = "txtUnionAllClass3NJ";
	@ElementDefinition
	public String txtUnionAllClass2  = "txtUnionAllClass2";
	@ElementDefinition
	public String txtUnionAllClass1 = "txtUnionAllClass1";
	@ElementDefinition
	public String txtNonUnionFulltimeClass3 = "txtNonUnionFulltimeClass3";
	@ElementDefinition
	public String txtNonUnionFulltimeClass3NJ = "txtNonUnionFulltimeClass3NJ";
	@ElementDefinition
	public String txtNonUnionFulltimeClass2 = "txtNonUnionFulltimeClass2";
	@ElementDefinition
	public String txtNonUnionFulltimeClass1 = "txtNonUnionFulltimeClass1";
	@ElementDefinition
	public String txtNonUnionICsClass3 = "txtNonUnionICsClass3";
	@ElementDefinition
	public String txtNonUnionICsClass3NJ = "txtNonUnionICsClass3NJ";
	@ElementDefinition
	public String txtNonUnionICsClass2 = "txtNonUnionICsClass2";
	@ElementDefinition
	public String txtNonUnionICsClass1 = "txtNonUnionICsClass1";
	
	@ElementDefinition
	public String txtNonUnionParttimetimeClass3 = "txtNonUnionParttimetimeClass3";
	@ElementDefinition
	public String txtNonUnionParttimetimeClass3NJ = "txtNonUnionParttimetimeClass3NJ";
	@ElementDefinition
	public String txtNonUnionParttimetimeClass2 = "txtNonUnionParttimetimeClass2";
	@ElementDefinition
	public String txtNonUnionParttimetimeClass1 = "txtNonUnionParttimetimeClass1";
	
	@ElementDefinition
	public String txtForeignEmpClass3 = "txtForeignEmpClass3";
	
	@ElementDefinition
	public String btnOK = "btnOK";
	
	@ElementDefinition
	public String chkCyber = "chkCyber";
	@ElementDefinition
	public String chkNFP = "chkNFP";
	@ElementDefinition
	public String chkPrivateCo = "chkPrivateCo";
	
	@ElementDefinition
	public String txtPlanAsssets = "txtPlanAsssets";
	@ElementDefinition
	public String txtMPLHazard ="txtMPLHazard";
	@ElementDefinition
	public String txtMPLHazardInput = "txtMPLHazardInput";
	@ElementDefinition
	public String txtEmployedLawyer = "txtEmployedLawyer";
	@ElementDefinition
	public String btnCreateProposal = "btnCreateProposal";
	@ElementDefinition
	public String btnUpdateCoverages = "btnUpdateCoverages";
	
	@ElementDefinition
	public String chkCYBPrivateCo = "chkCYBPrivateCo";
	@ElementDefinition
	public String chkCYBNFP = "chkCYBNFP";
	@ElementDefinition
	public String lblSelectProduct = "lblSelectProduct";
	@ElementDefinition
	public String	btnproposedWritingApproach = "btnproposedWritingApproach";
	@ElementDefinition
	public String	txtWritingApproachInput ="txtWritingApproachInput";
	@ElementDefinition
	public String btnAdd ="btnAdd";
	@ElementDefinition
	public String txtAttorneyName = "txtAttorneyName";
	@ElementDefinition
	public String txtAttorneyDate = "txtAttorneyDate";
	@ElementDefinition
	public String lblAttorneyName = "lblAttorneyName";
	@ElementDefinition
	public String txtAreasofPractice = "txtAreasofPractice";
	@ElementDefinition
	public String 	txtAssetsUnderManagement = "txtAssetsUnderManagement";
	@ElementDefinition
	public String 	txtCommissionRevenue = "txtCommissionRevenue";
	@ElementDefinition
	public String 	txtGrossPremium = "txtGrossPremium";
	@ElementDefinition
	public String 	txtRepCount = "txtRepCount";
	@ElementDefinition
	public String 	txtMarketCap = "txtMarketCap";
	@ElementDefinition
	public String lnkExpQuote2 = "lnkExpQuote2";
	@ElementDefinition
	public String lnkExpQuote1 = "lnkExpQuote1";
	@ElementDefinition
	public String lnkExpQuote3 = "lnkExpQuote3";
	@ElementDefinition
	public String lnkExpQuote4 = "lnkExpQuote4";
	@ElementDefinition
	public String lnkExpQuote5 = "lnkExpQuote5";
	@ElementDefinition
	public String txtBIPDPlaintiff = "txtBIPDPlaintiff";
	@ElementDefinition
	public String txtInusuranceDefense = "txtInusuranceDefense";
	@ElementDefinition
	public String txtLitigationDefense = "txtLitigationDefense";
	@ElementDefinition
	public String txtBusinessCoporation = "txtBusinessCoporation";
	@ElementDefinition
	public String txtConstructionBuildingContracts = "txtConstructionBuildingContracts";
	@ElementDefinition
	public String txtMedicalMalpractice = "txtMedicalMalpractice";
	@ElementDefinition
	public String txtLitigationPlaintiff = "txtLitigationPlaintiff";
	@ElementDefinition
	public String txtOther = "txtOther";
	@ElementDefinition
	public String btnNext = "btnNext";
	@ElementDefinition
	public String btnAttorneyNext = "btnAttorneyNext";
	@ElementDefinition
	public String 	txtEmployeesAll = "txtEmployeesAll";
	@ElementDefinition
	public String txtForeignEmployeesAll = "txtForeignEmployeesAll";
	@ElementDefinition
	public String btnCreateQuote = "btnCreateQuote";
	@ElementDefinition
	public String chkAircraftFinance = "chkAircraftFinance";
	@ElementDefinition
	public String chkCredit = "chkCredit";
	@ElementDefinition
	public String chkProjectFinance = "chkProjectFinance";
	@ElementDefinition
	public String txtRegisteredRepresentatives = "txtRegisteredRepresentatives";
	
	@ElementDefinition
	public String 	chkPOLEquity = "chkPOLEquity";
	@ElementDefinition
	public String 	chkPOLLenders= "chkPOLLenders";
	@ElementDefinition
	public String 	chkPOLNonHonouring= "chkPOLNonHonouring";
	@ElementDefinition
	public String chkSharedLimitCheckBox= "chkSharedLimitCheckBox";
	@ElementDefinition
	public String lnkCybRating= "lnkCybRating";
	@TimeMethod
	@ScreenShot
	public void UmExposures(String tcID, SoftAssert softAs) throws Exception;
	public void SubmitApplication(String tcID, SoftAssert softAssert) throws Exception;
	public void update_Exposure(String tcID, SoftAssert softAssert) throws Exception;
    public void submitApp(String tcID, SoftAssert softAssert) throws Exception;
	public void EditExposureInformation(String tcID, SoftAssert softAssert) throws Exception;
	public void VerifyExposureInformation(String tcID, SoftAssert softAssert) throws Exception;
	public void VerifyCybSharedCheckBox(String tcID, SoftAssert softAssert) throws Exception;

}
