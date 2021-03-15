package com.everest.page.imageright;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface IROpenFile extends Page {

	@ElementDefinition
	public String btn_MainFolderCorrespondance="btn_MainFolderCorrespondance" ;
	@ElementDefinition
	public String btn_SubFolderCorrespondance="btn_SubFolderCorrespondance" ;
	@ElementDefinition
	public String btn_Email1="btn_Email1" ;
	@ElementDefinition
	public String btn_Email2="btn_Email2" ;
	@ElementDefinition
	public String btn_Email3="btn_Email3" ;
	@ElementDefinition
	public String btn_RatingQuoting="btn_RatingQuoting" ;
	@ElementDefinition
	public String btn_Quote="btn_Quote" ;
	
	@ElementDefinition
	public String txt_QuoteLetter="txt_QuoteLetter" ;
	
	@ElementDefinition
	public String btn_BindBilling="btn_BindBilling" ;
	
	@ElementDefinition
	public String btn_BillingInvoice="btn_BillingInvoice" ;
	@ElementDefinition
	public String txt_InvoiceLetter="txt_InvoiceLetter" ;
	
	@ElementDefinition
	public String btn_Bind="btn_Bind" ;
	
	@ElementDefinition
	public String txt_BindLetter="txt_BindLetter" ;
	
	@ElementDefinition
	public String btn_Policy="btn_Policy" ;
	
	@ElementDefinition
	public String btn_PolicySubFolder="btn_PolicySubFolder" ;
	
	@ElementDefinition
	public String txt_PolicyDoc="txt_PolicyDoc" ;
	
	@ElementDefinition
	public String btn_Action="btn_Action" ;
	
	@ElementDefinition
	public String btn_Download="btn_Download" ;
	
	@ElementDefinition
	public String txt_AttachmentName="txt_AttachmentName" ;
	@ElementDefinition
	public String btn_Next="btn_Next" ;
	
	@ElementDefinition
	public String lbl_SubmissionNumber="lbl_SubmissionNumber" ;
	@ElementDefinition
	public String lbl_InsuredName="lbl_InsuredName" ;
	@ElementDefinition
	public String lbl_InsuredFileName="lbl_InsuredFileName" ;
	
	
	@TimeMethod
	@ScreenShot
	public void verifyPolicyDocuments(String tcID, SoftAssert softAs)throws Exception ;
	

}
