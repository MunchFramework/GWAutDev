package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmLogoutPage extends Page {
	
	@ElementDefinition
	public String iconLogout = "iconLogout";

	@ElementDefinition
	public String menuLogout = "menuLogout";
	
	@TimeMethod
	@ScreenShot
	public void UmClosePage(String tcID, SoftAssert softAs, String DeviceName) throws Exception;

}
