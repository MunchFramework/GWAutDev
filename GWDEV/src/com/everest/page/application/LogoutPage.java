package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface LogoutPage extends Page {

	@ElementDefinition
	public String iconLogout = "iconLogout";
	@ElementDefinition
	public String menuLogout = "menuLogout";
	@ElementDefinition
	public String btnOk = "btnOk";

	@TimeMethod
	@ScreenShot
	public void ClosePage(String tcID, SoftAssert softAs, String DeviceName) throws Exception;

}
