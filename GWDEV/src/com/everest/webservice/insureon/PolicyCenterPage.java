package com.everest.webservice.insureon;

import java.util.List;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface PolicyCenterPage extends Page {
	
	@ElementDefinition
	public String lnk_certificate="lnk_certificate" ;
	@ElementDefinition
	public String lnk_EdgeCertificate="lnk_EdgeCertificate" ;
	
	@TimeMethod
	@ScreenShot
	public void verifySubmissionDetails(String tcID, SoftAssert softAs,String DeviceName,List<Boolean> list) throws Exception;
	public void verifyCoverageSection(String tcID, SoftAssert softAs,String DeviceName,List<Boolean> list) throws Exception;
	public void closeScreenshots(String tcID, SoftAssert softAssert) throws Exception ;
	public void verifyOptionalCoverages(String tcID, SoftAssert softAssert, String DeviceName,List<Boolean> list) throws Exception;
}
