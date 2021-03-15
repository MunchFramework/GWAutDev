package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmLoginPage extends Page {

	@ElementDefinition
	public String txtUmUserName = "txtUmUserName";
	@ElementDefinition
	public String txtUmPassword = "txtUmPassword";
	@ElementDefinition
	public String btnUmLogin = "btnUmLogin";
	
	@ElementDefinition
	public String iconLogout = "iconLogout";

	@ElementDefinition
	public String menuLogout = "menuLogout";
	
	@ElementDefinition
	public String 	btnNewSubmission = "btnNewSubmission";
	@TimeMethod
	@ScreenShot
	public void UmlaunchPage(String tcID, SoftAssert softAs, String DeviceName) throws Exception;

}
