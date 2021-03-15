package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmMarketSegmentPage extends Page {

	@ElementDefinition
	public String btnMarketSegment = "btnMarketSegment";
	
	@ElementDefinition
	public String txtMarketSegment = "txtMarketSegment";

	@ElementDefinition
	public String btnNaicsCode = "btnNaicsCode";
	@ElementDefinition
	public String txtNaicsCode = "txtNaicsCode";
	@ElementDefinition
	public String btnSIC = "btnSIC" ;
	@ElementDefinition
	public String txtSIC = "txtSIC" ;
	
	@ElementDefinition
	public String btnLegalEntity = "btnLegalEntity" ;
	@ElementDefinition
	public String txtLegalEntity = "txtLegalEntity" ;
	@ElementDefinition
	public String btnCreateProposal = "btnCreateProposal" ;

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
	public String ddOwnershipType = "ddOwnershipType";
	@ElementDefinition
	public String txtOwnershipType = "txtOwnershipType";
	@ElementDefinition
	public String btnDepartment = "btnDepartment";
	@ElementDefinition
	public String txtStockTicker ="txtStockTicker";
	@ElementDefinition
	public String 	btnSAACode = "btnSAACode";
	@ElementDefinition
	public String txtSAACode  = "txtSAACode";
	@ElementDefinition
	public String txtOwnershipType_Pri = "txtOwnershipType_Pri";
	@ElementDefinition
	public String txtOwnershipType_Pub = "txtOwnershipType_Pub";
	@TimeMethod
	@ScreenShot
	public void UmMarketSegment(String tcID, SoftAssert softAs) throws Exception;
	public void verifyUmMarketSegment(String tcID, SoftAssert softAssert) throws Exception;
	public void UpdateUmMarketSegment(String tcID, SoftAssert softAssert) throws Exception;

}
