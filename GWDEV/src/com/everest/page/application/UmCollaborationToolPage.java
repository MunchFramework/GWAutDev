package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmCollaborationToolPage extends Page {
	
	@ElementDefinition
	public String btn_Collaboration="btn_Collaboration" ;
	@ElementDefinition
	public String btn_Tasks="btn_Tasks" ;
	@ElementDefinition
	public String btn_NewTask="btn_NewTask" ;
	
	@ElementDefinition
	public String btn_AttachFile="btn_AttachFile" ;
	@ElementDefinition
	public String btn_ChooseFile="btn_ChooseFile" ;
	@ElementDefinition
	public String btn_Type="btn_Type" ;
	@ElementDefinition
	public String btn_UploadFile="btn_UploadFile" ;
	@ElementDefinition
	public String btn_CloseTask="btn_CloseTask" ;
	@ElementDefinition
	public String btn_Files="btn_Files" ;
	@ElementDefinition
	public String lblFileName="lblFileName" ;
	
	

	
	@TimeMethod
	@ScreenShot
	public void uploadTaskFile(String tcID, SoftAssert softAs, String DeviceName) throws Exception;


	

}
