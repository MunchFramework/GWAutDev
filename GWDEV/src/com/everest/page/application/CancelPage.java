package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface CancelPage extends Page {
	
	@ElementDefinition
	public String tabActions = "tabActions";
	@ElementDefinition
	public String btnSelectCancel = "btnSelectCancel";
	@ElementDefinition
	public String txtSource = "txtSource";
	@ElementDefinition
	public String txtReason = "txtReason";
	@ElementDefinition
	public String txtReasonDescription = "txtReasonDescription";
	@ElementDefinition
	public String txtRefundMethod = "txtRefundMethod";
	@ElementDefinition
	public String txtCancelEffDate = "txtCancelEffDate";
	@ElementDefinition
	public String btnStartCancellation = "btnStartCancellation";
	@ElementDefinition
	public String btnBindOptions = "btnBindOptions";
	@ElementDefinition
	public String lnkCancelNow = "lnkCancelNow";
	@ElementDefinition
	public String btnOk = "btnOk";
	@ElementDefinition
	public String lnkViewPolicy = "lnkViewPolicy";
	@ElementDefinition
	public String lnkScheduleCancel = "lnkScheduleCancel";
	
	@TimeMethod
	@ScreenShot
	public void cancelPolicy(String tcID, SoftAssert softAs) throws Exception;
	
}
