package com.everest.escape.submission;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface Account extends Page {
	
	@ElementDefinition
	public String btn_NewAccount="btn_NewAccount" ;
	@ElementDefinition
	public String txt_InsuredName="txt_InsuredName" ;
	@ElementDefinition
	public String txt_FEIN="txt_FEIN" ;
	@ElementDefinition
	public String btn_AddInsured="btn_AddInsured" ;
	@ElementDefinition
	public String btn_OFACSearch="btn_OFACSearch" ;
	@ElementDefinition
	public String msg_OFACSearchResult="msg_OFACSearchResult" ;
	@ElementDefinition
	public String btn_OFACSearchClose="btn_OFACSearchClose" ;
	@ElementDefinition
	public String btn_CreateAccount="btn_CreateAccount" ;
	@ElementDefinition
	public String msg_SuccessAccountCreated="msg_SuccessAccountCreated" ;
	
	@ElementDefinition
	public String txt_MailingAddress="txt_MailingAddress" ;
	@ElementDefinition
	public String txt_MailingCity="txt_MailingCity" ;
	@ElementDefinition
	public String lst_MailingState="lst_MailingState" ;
	@ElementDefinition
	public String lst_MailingCountry="lst_MailingCountry" ;
	@ElementDefinition
	public String txt_MailingZipCode="txt_MailingZipCode" ;
	@ElementDefinition
	public String txt_ZipAddOn="txt_ZipAddOn" ;
	@ElementDefinition
	public String lst_OwnershipType="lst_OwnershipType" ;
	
	@ElementDefinition
	public String lst_OwnerShipTypeSelected="lst_OwnerShipTypeSelected" ;
	
	
	
	@ElementDefinition
	public String tab_Account="tab_Account" ;
	@ElementDefinition
	public String btn_Save="btn_Save" ;
	
	@ElementDefinition
	public String getAccountNumber="getAccountNumber" ;
	
	@ElementDefinition
	public String getFEINValue="getFEINValue" ;
	
	@ElementDefinition
	public String chk_OfacBlocked="chk_OfacBlocked" ;
	@ElementDefinition
	public String txt_AccompanyingAccount="txt_AccompanyingAccount" ;
	
	@ElementDefinition
	public String lbl_OwnershipType="lbl_OwnershipType" ;
	
	@ElementDefinition
	public String lbl_DisplayOrder_OwnershipType="lbl_DisplayOrder_OwnershipType" ;
	
	
	
	@ElementDefinition
	public String btn_CreateNewSubmission="btn_CreateNewSubmission" ;
	
	@ElementDefinition
	public String txt_NoOfEmp_Diabled="txt_NoOfEmp_Diabled" ;
	
	@ElementDefinition
	public String txt_Revenue_Diabled="txt_Revenue_Diabled" ;
	
	@ElementDefinition
	public String lnk_AccountNum="lnk_AccountNum" ;
	
	@TimeMethod
	@ScreenShot
		public void CreateAccount(String tcID, SoftAssert softAs) throws Exception;
		public void EditAccount(String tcID, SoftAssert softAs) throws Exception;
		public void VerifyInsurename(String tcID, SoftAssert softAs) throws Exception;
		public void VerifyAccountDetails(String tcID, SoftAssert softAs,String type) throws Exception;
		public void Verify_Account_ReadOnly_Fields(String tcID, SoftAssert softAs) throws Exception;
		public void clk_CreateNewSubmission(String tcID, SoftAssert softAs) throws Exception;
		public void verify_OwnershipType_FieldDetails(String tcID, SoftAssert softAs) throws Exception;
		public void verify_AccountCustomaerDetails_DB(String tcID, SoftAssert softAs) throws Exception;
		public void verify_Account_InDWHDB (String tcID, SoftAssert softAs,String DBServer) throws Exception;
		
		public void verify_OnlyAccount_InBothDB (String tcID, SoftAssert softAs,String DBServer) throws Exception;
		public void verify_Customer_DnB_EIN_InDB (String tcID, SoftAssert softAs,String DBServer) throws Exception;
		public void verify_Revenue_NOEmp_FEINFeilds_Account(String tcID, SoftAssert softAS, String DeviceName) throws Exception;
		public void verify_CustomerID_AddiInsuredName_InDB(String tcID, SoftAssert softAs,String DBServer) throws Exception;
		public void verify_PDNew_LOB_InDB(String tcID, SoftAssert softAs,String DBServer) throws Exception;
		public void verify_UMAccountDetails_InEscape(String tcID, SoftAssert softAssert) throws Exception;
		public void verify_AccountReAssignment (String tcID, SoftAssert softAssert,String ActionType) throws Exception;
}
