package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface RemoveOptionalCovPage extends Page {
	
	@ElementDefinition
	public String tabCoverages = "tabCoverages";
	@ElementDefinition
	public String tabCommon = "tabCommon";
	@ElementDefinition
	public String tabOptionalCov = "tabOptionalCov";
	@ElementDefinition
	public String tabCRI = "tabCRI";
	@ElementDefinition
	public String tabDNO = "tabDNO";
	@ElementDefinition
	public String tabEPL = "tabEPL";
	
	@TimeMethod
	@ScreenShot
	public void RemoveOptionalCov(String tcID, SoftAssert softAs) throws Exception;
	
}
