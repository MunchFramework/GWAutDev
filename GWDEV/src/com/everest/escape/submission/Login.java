package com.everest.escape.submission;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface Login extends Page {
	
	@ElementDefinition
	public String txt_username="txt_username" ;
	@ElementDefinition
	public String txt_password="txt_password" ;
	@ElementDefinition
	public String btn_Login="btn_Login" ;
	
	@ElementDefinition
	public String pag_Search="pag_Search" ;
	
	@ElementDefinition
	public String btn_Search="btn_Search" ;
	
	
	@ElementDefinition
	public String lnk_certificate="lnk_certificate" ;
	@ElementDefinition
	public String lnk_LogOut="lnk_LogOut" ;
	
	@ElementDefinition
	public String lnk_Moreinformation="lnk_Moreinformation" ;
	@ElementDefinition
	public String lnk_Notrecommendedicon="lnk_Notrecommendedicon" ;
	
	@ElementDefinition
	public String lnk_MemLogOut="lnk_MemLogOut" ;
	
	@ElementDefinition
	public String txt_ClUserName="txt_ClUserName" ;
	@ElementDefinition
	public String txt_ClPassword="txt_ClPassword" ;
	@ElementDefinition
	public String btn_CILogin="btn_CILogin" ;
	@ElementDefinition
	public String lnk_CILogout="lnk_CILogout" ;
	
	@ElementDefinition
	public String txt_SIGWROUserName="txt_SIGWROUserName" ;
	@ElementDefinition
	public String txt_SIGWROPassword="txt_SIGWROPassword" ;
	@ElementDefinition
	public String btn_SIGWROLogin="btn_SIGWROLogin" ;
	@ElementDefinition
	public String lnk_SIGLogout="lnk_SIGLogout" ;
	@ElementDefinition
	public String lnk_SIGBroker="lnk_SIGBroker" ;
	@ElementDefinition
	public String lnk_WROUniverse="lnk_WROUniverse" ;
	@ElementDefinition
	public String btn_AdvancedCert="btn_AdvancedCert" ;
	@ElementDefinition
	public String lnk_ProceedToUnsafe="lnk_ProceedToUnsafe" ;
	
	
	
	
	@TimeMethod
	@ScreenShot
	public void LoginToEscape(String tcID, SoftAssert softAssert, String DeviceName) throws Exception;
	public void LogoutFormEscape(String tcID, SoftAssert softAssert, String DeviceName) throws Exception;
	public void LoginToEscape2(String tcID, SoftAssert softAssert, String DeviceName) throws Exception;
	public void LoginAsCashUser(String tcID, SoftAssert softAssert, String DeviceName) throws Exception;
	public void startPrintScreenShots(String tcID, SoftAssert softAssert, String DeviceName) throws Exception ;
	public void LoginToMembership(String tcID, SoftAssert softAssert, String DeviceName) throws Exception ;
	public void MemberShipLogOut(String tcID, SoftAssert softAs, String DeviceName) throws Exception;
	public void LoginToclariondoor(String tcID, SoftAssert softAssert, String DeviceName) throws Exception ;
	public void clariondoorLogOut(String tcID, SoftAssert softAs, String DeviceName) throws Exception;
	public void OceanWide_Applications_Login(String tcID, SoftAssert softAssert, String DeviceName, String Application) throws Exception ;
	public void OceanWide_LogOut(String tcID, SoftAssert softAs, String DeviceName, String Application) throws Exception;
	
}
