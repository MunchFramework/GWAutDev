package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface LoginPage extends Page {
	
	@ElementDefinition
	public String txt_username="txt_username" ;
	@ElementDefinition
	public String txt_password="txt_password" ;
	@ElementDefinition
	public String btn_Login="btn_Login" ;

	
	@TimeMethod
	@ScreenShot
	public void launchPage(String tcID, SoftAssert softAs, String DeviceName) throws Exception;

}
