package com.everest.page.imageright;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface IRFileSearch extends Page {

	@ElementDefinition
	public String btn_FileSearch="btn_FileSearch" ;
	@ElementDefinition
	public String txt_FileNumber="txt_FileNumber" ;
	@ElementDefinition
	public String txt_FileName="txt_FileName" ;
	@ElementDefinition
	public String lst_Drawers="lst_Drawers" ;
	@ElementDefinition
	public String lst_FileTypes="lst_FileTypes" ;
	@ElementDefinition
	public String lst_FileMarks="lst_FileMarks" ;
	@ElementDefinition
	public String btn_IRSearch="btn_IRSearch" ;
	
	@ElementDefinition
	public String lbl_Results="lbl_Results" ;
	
	@ElementDefinition
	public String lbl_SubmissionNumber="lbl_SubmissionNumber" ;
	
	
	@TimeMethod
	@ScreenShot
	public void searchFile(String tcID, SoftAssert softAs)throws Exception ;
	

}
