package com.everest.escape.submission;
import org.testng.asserts.SoftAssert;
import org.xframium.page.Page.ElementDefinition;
import org.xframium.page.Page.ScreenShot;
import org.xframium.page.Page.TimeMethod;
public interface Payment {
	@ElementDefinition
	public String lnk_Payment="lnk_Payment" ;
	@ElementDefinition
	public String chk_PaymentRevised="chk_PaymentRevised" ;
	@ElementDefinition
	public String dat_Payment_DateDue="dat_Payment_DateDue" ;
	@ElementDefinition
	public String txt_Payment_AmountDue="txt_Payment_AmountDue" ;
	@ElementDefinition
	public String chk_Direct_Billtype="chk_Direct_Billtype" ;
	@ElementDefinition
	public String chk_Agent_Billtype="chk_Agent_Billtype" ;
	
	@ElementDefinition
	public String txt_BillingComments="txt_BillingComments" ;
	
	@ElementDefinition
	public String DateReceived_P="DateReceived_P" ;
	@ElementDefinition
	public String PartialAmount="PartialAmount" ;
	@ElementDefinition
	public String CheckNumber="CheckNumber" ;
	@ElementDefinition
	public String chk_Delete="chk_Delete" ;
	@ElementDefinition
	public String txt_DateReceived="txt_DateReceived" ;
	@ElementDefinition
	public String txt_AmountReceived="txt_AmountReceived" ;
	
	@ElementDefinition
	public String txt_PandingCancelDate="txt_PandingCancelDate" ;
	@ElementDefinition
	public String txt_FinalCancelDate="txt_FinalCancelDate" ;
	@ElementDefinition
	public String txt_ReinstatementDate="txt_ReinstatementDate" ;
	
	@ElementDefinition
	public String txt_CashApplicationComments="txt_CashApplicationComments" ;
	
	@ElementDefinition
	public String btn_Save="btn_Save" ;
	
	@ElementDefinition
	public String PaymentSuccMsg="PaymentSuccMsg" ;
	
	
	
	@TimeMethod
	@ScreenShot
	public void Payment_page_Verification(String tcID, SoftAssert softAs) throws Exception;
	public void CheckPayment(String tcID, SoftAssert softAs) throws Exception;
	public void CheckBillingEditableFields(String tcID, SoftAssert softAs) throws Exception;
	public void CheckCashPayment(String tcID, SoftAssert softAs) throws Exception;
	
	public void MakeCashPayment(String tcID, SoftAssert softAs) throws Exception;
	
	
	
}
