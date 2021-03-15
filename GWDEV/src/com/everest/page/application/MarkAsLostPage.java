package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface MarkAsLostPage extends Page {


@ElementDefinition
	public String btnActions = "btnActions";
        @ElementDefinition
	public String btnMarkAsLost = "btnMarkAsLost";
        @ElementDefinition
	public String txtReason = "txtReason";	
        @ElementDefinition
    	public String ddReasonprefix = "ddReasonprefix";
       
        @ElementDefinition
	public String txtLostto = "txtLostto";
        @ElementDefinition
        public String  ddLostto = "ddLostto";
        @ElementDefinition
	public String txtComment = "txtComment";
        @ElementDefinition
	public String btnConfirm = "btnConfirm";
        @ElementDefinition
	public String txtStatus = "txtStatus";


	@TimeMethod
	@ScreenShot
	public void MarkAsLost(String tcID, SoftAssert softAs) throws Exception;

}
