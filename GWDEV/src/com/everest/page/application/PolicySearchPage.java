package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;


public interface PolicySearchPage extends Page {

	@ElementDefinition
    public String tabPolicy = "tabPolicy";
	@ElementDefinition
	public String txtPolicyNo = "txtPolicyNo";
	@ElementDefinition
	public String btnSearch = "btnSearch";
	
	
	

	@TimeMethod
	@ScreenShot
	public void searchPolicy(String tcID, SoftAssert softAs) throws Exception;
	
}
