/*******************************************************************
*	Name              :	Renters_Driver
*	Description       : Driver class for Renters Quote-NB LOB
*	Author            : Infosys 
*	Date Created      :	11/22/2016
*	Modification Log  :                                                     
*	Date		Initials     	Description of Modifications 
********************************************************************
********************************************************************/
package test.java.com.everest.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//import org.xframium.device.ng.AbstractSeleniumTest.TestName;
import org.xframium.page.PageManager;
import org.xframium.spi.Device;

import com.everest.functions.GenericFunctions;
import com.everest.utility.CustomAbstractTest;
import com.everest.utility.CustomReporting;
import com.everest.webservice.insureon.EscapePage;
import com.everest.webservice.insureon.WebServiceSubmission;

public class TestDriver_Insureon extends CustomAbstractTest {
	
	
	
	
	

	
	
	
	@Test( dataProvider = "DeviceManager")
	public void TS_SubElgbl_C_E_D_F_01(TestName testName, Device device) throws Exception {
		try {

			SoftAssert softAssert = new SoftAssert();
			String tcID = getTestName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			String DeviceName = getDeviceName(testName);

			WebServiceSubmission objReference = (WebServiceSubmission) PageManager.instance()
					.createPage(WebServiceSubmission.class, getWebDriver());
			objReference.verifySubmissionAgainstState(tcID, softAssert, DeviceName);
			
//			QuoteReferDeclineFileValidation objReferenceQuoteLetter = (QuoteReferDeclineFileValidation) PageManager.instance()
//					.createPage(QuoteReferDeclineFileValidation.class, getWebDriver());
//			objReferenceQuoteLetter.verifyQuoteDocDetails(tcID, softAssert);

			EscapePage pageReference = (EscapePage) PageManager.instance().createPage(EscapePage.class, getWebDriver());
			pageReference.closeScreenshots(tcID, softAssert);

			softAssert.assertAll();

		} catch (Exception ex) {

			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	
	@Test( dataProvider = "DeviceManager")
	public void TS_SubCyber_Eligible_F_01(TestName testName, Device device) throws Exception {
		try {

			SoftAssert softAssert = new SoftAssert();
			String tcID = getTestName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			String DeviceName = getDeviceName(testName);

			WebServiceSubmission objReference = (WebServiceSubmission) PageManager.instance()
					.createPage(WebServiceSubmission.class, getWebDriver());
			objReference.verifySubmissionAgainstState(tcID, softAssert, DeviceName);

			EscapePage pageReference = (EscapePage) PageManager.instance().createPage(EscapePage.class, getWebDriver());
			pageReference.closeScreenshots(tcID, softAssert);

			softAssert.assertAll();

		} catch (Exception ex) {

			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	
	@Test( dataProvider = "DeviceManager")
	public void TS_SubDcln_C_E_D_F_01(TestName testName, Device device) throws Exception {
		try {

			SoftAssert softAssert = new SoftAssert();
			String tcID = getTestName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			String DeviceName = getDeviceName(testName);

			WebServiceSubmission objReference = (WebServiceSubmission) PageManager.instance()
					.createPage(WebServiceSubmission.class, getWebDriver());
			objReference.verifySubmissionAgainstState(tcID, softAssert, DeviceName);
			

//			QuoteReferDeclineFileValidation objReferenceQuoteLetter = (QuoteReferDeclineFileValidation) PageManager.instance()
//					.createPage(QuoteReferDeclineFileValidation.class, getWebDriver());
//			objReferenceQuoteLetter.verifyReferalMail(tcID, softAssert);

			

			EscapePage pageReference = (EscapePage) PageManager.instance().createPage(EscapePage.class, getWebDriver());
			pageReference.closeScreenshots(tcID, softAssert);

			softAssert.assertAll();

		} catch (Exception ex) {

			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}	
	
	
	@Test( dataProvider = "DeviceManager")
	public void TS_SubCyber_Decline_NAICS(TestName testName, Device device) throws Exception {
		try {

			SoftAssert softAssert = new SoftAssert();
			String tcID = getTestName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			String DeviceName = getDeviceName(testName);

			WebServiceSubmission objReference = (WebServiceSubmission) PageManager.instance()
					.createPage(WebServiceSubmission.class, getWebDriver());
			objReference.verifySubmissionAgainstState(tcID, softAssert, DeviceName);
			
//			QuoteReferDeclineFileValidation objReferenceQuoteLetter = (QuoteReferDeclineFileValidation) PageManager.instance()
//					.createPage(QuoteReferDeclineFileValidation.class, getWebDriver());
//			objReferenceQuoteLetter.verifyReferalMail(tcID, softAssert);

			EscapePage pageReference = (EscapePage) PageManager.instance().createPage(EscapePage.class, getWebDriver());
			pageReference.closeScreenshots(tcID, softAssert);

			softAssert.assertAll();

		} catch (Exception ex) {

			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test( dataProvider = "DeviceManager")
	public void TS_SubRefrl_C_E_D_F_01(TestName testName, Device device) throws Exception {
		try {

			SoftAssert softAssert = new SoftAssert();
			String tcID = getTestName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			String DeviceName = getDeviceName(testName);

			WebServiceSubmission objReference = (WebServiceSubmission) PageManager.instance()
					.createPage(WebServiceSubmission.class, getWebDriver());
			objReference.verifySubmissionAgainstState(tcID, softAssert, DeviceName);
			
//			QuoteReferDeclineFileValidation objReferenceQuoteLetter = (QuoteReferDeclineFileValidation) PageManager.instance()
//					.createPage(QuoteReferDeclineFileValidation.class, getWebDriver());
//			objReferenceQuoteLetter.verifyReferalMail(tcID, softAssert);

			EscapePage pageReference = (EscapePage) PageManager.instance().createPage(EscapePage.class, getWebDriver());
			pageReference.closeScreenshots(tcID, softAssert);

			softAssert.assertAll();

		} catch (Exception ex) {

			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test( dataProvider = "DeviceManager")
	public void TS_SubCyber_Refer_NAICS(TestName testName, Device device) throws Exception {
		try {

			SoftAssert softAssert = new SoftAssert();
			String tcID = getTestName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			String DeviceName = getDeviceName(testName);	

			WebServiceSubmission objReference = (WebServiceSubmission) PageManager.instance()
					.createPage(WebServiceSubmission.class, getWebDriver());
			objReference.verifySubmissionAgainstState(tcID, softAssert, DeviceName);
			
//			QuoteReferDeclineFileValidation objReferenceQuoteLetter = (QuoteReferDeclineFileValidation) PageManager.instance()
//					.createPage(QuoteReferDeclineFileValidation.class, getWebDriver());
//			objReferenceQuoteLetter.verifyReferalMail(tcID, softAssert);

			EscapePage pageReference = (EscapePage) PageManager.instance().createPage(EscapePage.class, getWebDriver());
			pageReference.closeScreenshots(tcID, softAssert);

			softAssert.assertAll();

		} catch (Exception ex) {

			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	
	@Test( dataProvider = "DeviceManager")
	public void TS_SubOFACBlk_C_E_D_F_01(TestName testName, Device device) throws Exception {
		try {

			SoftAssert softAssert = new SoftAssert();
			String tcID = getTestName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			String DeviceName = getDeviceName(testName);

			WebServiceSubmission objReference = (WebServiceSubmission) PageManager.instance()
					.createPage(WebServiceSubmission.class, getWebDriver());
			objReference.verifySubmissionAgainstState(tcID, softAssert, DeviceName);

			EscapePage pageReference = (EscapePage) PageManager.instance().createPage(EscapePage.class, getWebDriver());
			pageReference.closeScreenshots(tcID, softAssert);

			softAssert.assertAll();

		} catch (Exception ex) {

			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	
	
	
}

