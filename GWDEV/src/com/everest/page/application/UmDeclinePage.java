package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmDeclinePage extends Page {


	@ElementDefinition
	public String btnActions = "btnActions";
        @ElementDefinition
	public String btnDecline = "btnDecline";
        @ElementDefinition
	public String txtReason = "txtReason";	
        @ElementDefinition
	public String txtReasonfield = "txtReasonfield";	
        @ElementDefinition
	public String txtComment = "txtComment";
        @ElementDefinition
	public String btnConfirm = "btnConfirm";
        @ElementDefinition
    	public String btnNo = "btnNo";
        @ElementDefinition
    	public String btnOk = "btnOk";
        @ElementDefinition
	    public String txtStatus = "txtStatus";
        public String UW_emailid= "UW_emailid";
    	@ElementDefinition
    	public String txtSendEmail = "txtSendEmail";
    	@ElementDefinition
    	public String btnSendEmail = "btnSendEmail";
    	@ElementDefinition
    	public String btnUpdateCoverages = "btnUpdateCoverages";
    	@ElementDefinition
    	public String Error_OK = "Error_OK";
    	
      	@ElementDefinition
    	public String email_txtbox = "email_txtbox";
       	@ElementDefinition
    	public String Wrong_emailid = "Wrong_emailid";
       	
     	@ElementDefinition
    	public String Close_emailid = "Close_emailid";
     	@ElementDefinition
    	public String email_icon = "email_icon";
     	@ElementDefinition
    	public String correct_emailid = "correct_emailid";
     
     	

	@TimeMethod
	@ScreenShot
	public void UmDecline(String tcID, SoftAssert softAs) throws Exception;

}
