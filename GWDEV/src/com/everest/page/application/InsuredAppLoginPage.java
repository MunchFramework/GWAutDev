package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface InsuredAppLoginPage extends Page {
	
	@ElementDefinition
	public String txt_username="txt_username" ;
	@ElementDefinition
	public String txt_password="txt_password" ;
	@ElementDefinition
	public String btn_Login="btn_Login" ;
	@ElementDefinition
	public String lnkQuotes="lnkQuotes" ;
	@ElementDefinition
	public String txtRetrieveRequest="txtRetrieveRequest" ;
	@ElementDefinition
	public String btnRetrieveRequest="btnRetrieveRequest" ;
	@ElementDefinition
	public String rel_dropdown="rel_dropdown";
	@ElementDefinition
	public String id_txt="id_txt";
	@ElementDefinition
	public String premium_insuredapp="premium_insuredapp";
	@ElementDefinition
	public String invalid_id="invalid_id" ;
	@ElementDefinition
	public String NoQuotes="NoQuotes";
	@ElementDefinition
	public String btnLogout="btnLogout" ;
	@ElementDefinition
	public String Packaged_Quotes="Packaged_Quotes";
	@ElementDefinition
	public String Rate_Plan="Rate_Plan";
	@ElementDefinition
	public String BP_InsApp="BP_InsApp";
	@ElementDefinition
	public String SubTotal_InsApp="SubTotal_InsApp";
	@ElementDefinition
	public String SubTotal_InsApp_DNO_EPL="SubTotal_InsApp_DNO_EPL";
	@ElementDefinition
	public String SubTotal_InsApp_EMP="SubTotal_InsApp_EMP";
	@ElementDefinition
	public String AvgPriorAct="AvgPriorAct";
	@ElementDefinition
	public String ExpMod_TabB="ExpMod_TabB";
	@ElementDefinition
	public String lblFIDPremium="lblFIDPremium" ;
	@ElementDefinition
	public String lblDNOPremium="lblDNOPremium" ;
	@ElementDefinition
	public String lblEPLPremium="lblEPLPremium" ;
	@ElementDefinition
	public String BaseRate="BaseRate" ;
	@ElementDefinition
	public String ComboCap="ComboCap" ;
	@ElementDefinition
	public String Prem_Insured="Prem_Insured" ;
	@ElementDefinition
	public String Prem_Final="Prem_Final" ;
	
	

	@TimeMethod
	@ScreenShot
	public void InsuredAppLogin(String tcID, SoftAssert softAs) throws Exception;
	public void InsuredAppValidationPolicyChange(String tcID, SoftAssert softAssert) throws Exception;
	public void InsuredAppValidationNB(String tcID, SoftAssert softAssert) throws Exception;
	public void InsuredAppValidationPolicyChangeRunOff(String tcID, SoftAssert softAssert, String shortRun, String Premium1)
			throws Exception;
	public void InsuredAppLogOut(String tcID, SoftAssert softAssert) throws Exception;
	public void InsuredAppValidation_BP(String tcID, SoftAssert softAssert) throws Exception; 
	public void InsuredAppValidation_ST(String tcID, SoftAssert softAssert) throws Exception;
	public void verifySubtotalWhenSharedLimitChecked(String tcID, SoftAssert softAssert) throws Exception;
	public void InsuredAppSearch(String tcID, SoftAssert softAssert) throws Exception ;
	public void InsuredAppVerifyBaseRate(String tcID, SoftAssert softAssert) throws Exception ;
	public void InsuredAppVerifyComboFactor(String tcID, SoftAssert softAssert) throws Exception ;
}
