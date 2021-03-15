package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface AccountSearchPage extends Page {

	@ElementDefinition
	public String tabAccount = "tabAccount";
	@ElementDefinition
	public String txtAccountNo = "txtAccountNo";
	@ElementDefinition
	public String iconSearch = "iconSearch";

	@TimeMethod
	@ScreenShot
	public void searchAccount(String tcID, SoftAssert softAs) throws Exception;
}
