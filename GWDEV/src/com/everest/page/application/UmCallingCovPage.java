package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmCallingCovPage extends Page{

	@ElementDefinition
	public String btnDNOPage = "btnDNOPage";
	@ElementDefinition
	public String btnCRIPage = "btnCRIPage";
	@ElementDefinition
	public String btnEPLPage = "btnEPLPage";
	@ElementDefinition
	public String btnEMPPage = "btnEMPPage";
	@ElementDefinition
	public String btnENOPage = "btnENOPage";
	@ElementDefinition
	public String btnKNRPage = "btnKNRPage";
	@ElementDefinition
	public String btnFIDPage = "btnFIDPage";
	@ElementDefinition
	public String btnCYBPage = "btnCYBPage";
	@ElementDefinition
	public String btnOptnlEndtab ="btnOptnlEndtab";
	@ElementDefinition
	public String btnLPLPage = "btnLPLPage";
	@ElementDefinition
	public String btnEZExcessPage = "btnEZExcessPage";
	
	@ElementDefinition
	public String CoverageExp3 = "CoverageExp3";
	
	@ElementDefinition
	public String CoverageExp2 = "CoverageExp2";
	@ElementDefinition
	public String CoverageExp1 = "CoverageExp1";
	
	@TimeMethod
	@ScreenShot
	public void UmCallingCov(String tcID, SoftAssert softAs) throws Exception;
	public void expendCoverages(String tcID, SoftAssert softAssert) throws Exception;

}

