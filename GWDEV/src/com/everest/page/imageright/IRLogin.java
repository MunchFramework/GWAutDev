package com.everest.page.imageright;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface IRLogin extends Page {

	@ElementDefinition
	public String txt_IRUserName="txt_IRUserName" ;
	@ElementDefinition
	public String txt_IRPassword="txt_IRPassword" ;
	@ElementDefinition
	public String btn_IRLogin="btn_IRLogin" ;
	@ElementDefinition
	public String btn_AdvancedCert="btn_AdvancedCert" ;
	@ElementDefinition
	public String lnk_ProceedToUnsafe="lnk_ProceedToUnsafe" ;
	@ElementDefinition
	public String lnk_certificate="lnk_certificate" ;
	@ElementDefinition
	public String lnk_Moreinformation="lnk_Moreinformation" ;
	@ElementDefinition
	public String lnk_Notrecommendedicon="lnk_Notrecommendedicon" ;
	
	@TimeMethod
	@ScreenShot
	public void loginToImageRight(String tcID, SoftAssert softAs,String DeviceName)throws Exception ;
	//public void VerifyEmailSent(String tcID, SoftAssert softAs)throws Exception ;

}
