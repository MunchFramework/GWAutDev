package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface ReinstatePage extends Page {
	
	@ElementDefinition
	public String tabActions = "tabActions";
	@ElementDefinition
	public String lnkReinstate = "lnkReinstate";
	@ElementDefinition
	public String txtReason = "txtReason";
	@ElementDefinition
	public String btnQuote = "btnQuote";
	@ElementDefinition
	public String btnReinstate = "btnReinstate";
	@ElementDefinition
	public String btnOk ="btnOk";
	@ElementDefinition
	public String 	lblPayment = "lblPayment";
	
	@TimeMethod
	@ScreenShot
	public void Reinstate(String tcID, SoftAssert softAs) throws Exception;
	
}
