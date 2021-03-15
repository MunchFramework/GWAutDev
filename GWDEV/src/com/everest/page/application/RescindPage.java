package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface RescindPage extends Page {
	
	@ElementDefinition
	public String tabActions = "tabActions";
	@ElementDefinition
	public String lnkRescind = "lnkRescind";
	@ElementDefinition
	public String lnkRescindOption = "lnkRescindOption";
	@ElementDefinition
	public String btnCloseOptions = "btnCloseOptions";
	@ElementDefinition
	public String lnkRescindCancellation = "lnkRescindCancellation";
	@ElementDefinition
	

	@TimeMethod
	@ScreenShot

	public void Rescind(String tcID, SoftAssert softAs) throws Exception;
	
}
