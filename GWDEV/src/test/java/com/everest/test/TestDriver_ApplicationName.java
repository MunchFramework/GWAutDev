/*******************************************************************
*	Name              : Main Function
*	Description       : 
*	Author            : Juvelle Mendes 
*	Date Created      :	02/12/2017
*	Modification Log  :                                                     
*	Date		Initials     	Description of Modifications 
********************************************************************
********************************************************************/
package test.java.com.everest.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//import org.xframium.device.ng.AbstractSeleniumTest.TestName;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.spi.Device;

import com.everest.functions.GenericFunctions;
import com.everest.functions.settings.Setup;
import com.everest.page.application.spi.PageImplInvoker;
import com.everest.utility.CustomAbstractTest;
import com.everest.utility.CustomReporting;

public class TestDriver_ApplicationName extends CustomAbstractTest {
	// Adding

	@Test(dataProvider = "DeviceManager")
	public void TS_PcCreateAccount(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			// classInvoker.PcFormInferenceValidation(tcID);
			classInvoker.createAccount(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_PcCreatePolicy(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.createAccount(tcID);
			classInvoker.createNewSubmission(tcID);
			classInvoker.cancelPolicy(tcID);
			classInvoker.InsuredAppLogin(tcID);
			// classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_UmPcCreatePolicy(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			// // Launching PC and searching for Account created in UM.
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_UmTestCreatePolicy(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// //classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			// //classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			// // Launching PC and searching for Account created in UM.
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_UmCreateSubmission(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);

			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);

			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			// // Launching PC and searching for Account created in UM.
			classInvoker.launchPage(tcID, DeviceName);

			classInvoker.searchPolicy(tcID, DeviceName);

			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_PcCancelPolicy(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_PolicyChange(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.launchPage(tcID, DeviceName);

			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChange(tcID);

			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_OptionalCoverages(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchSubmission(tcID);
			classInvoker.OptionalCov(tcID);
			// classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_MarkAsLost(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);

			classInvoker.MarkAsLost(tcID);

			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_01(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			// Launching PC and searching for Account created in UM.
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchSubmission(tcID);
			classInvoker.CoverageValidation(tcID);
			// Validate coverage and terms
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.MarkAsLost(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			// Launching PC
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchSubmission(tcID);
			GenericFunctions.instance().validatePCStatus(tcID, "Not-taken");
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_02(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			// Launching PC and searching for Account created in UM.
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchSubmission(tcID);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.MarkAsLost(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			// Launching PC
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchSubmission(tcID);
			GenericFunctions.instance().validatePCStatus(tcID, "Not-taken");
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_03(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChange(tcID);
			classInvoker.cancelPolicy(tcID);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_04(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_05(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			// Policy Center
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			GenericFunctions.instance().validateExclusions(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_06(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Modifiers(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_07(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_08(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_09(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			// Launching PC
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_10(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			// GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			// Policy Center
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);

			classInvoker.Modifiers(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_11(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_12(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			GenericFunctions.instance().validateExclusions(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_13(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_15(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);
			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_16(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);

			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_17(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			classInvoker.SubmitRenewal(tcID);
			// Function for submit renewal

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_19(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			// classInvoker.UmBinding(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			// classInvoker.UmIssuance(tcID);
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),

					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_20(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmDecline(tcID);
			classInvoker.UmSubmissionNumber(tcID);

			classInvoker.UmClosePage(tcID, DeviceName);

			// Launching PC and searching for Account created in UM.
			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchSubmission(tcID);
			GenericFunctions.instance().validatePCStatus(tcID, "Declined");
			// Add validation in PC for decline thats not working now
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_23(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.cancelPolicy(tcID);
			classInvoker.Rescind(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	// Pre-Renewal Direction Functionality
	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_24(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PreRenewalDirection(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued(Flag for Non Renewal)");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_25(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_26(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_27(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Reinstatement");
			classInvoker.UmClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC28(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);

			// GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PolicyChange(tcID);
			classInvoker.cancelPolicy(tcID);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	// Forms Script

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_54(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.formsValidation(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	// Forms scripts -DNO

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_51(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.formsValidation(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	// forms script-EPL
	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_32(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.formsValidation(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	// R2 Test cases
	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC01(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			Setup.LoadData();
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			Setup.LoadData();
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			Setup.LoadData();
			classInvoker.BillingInvoice_WriteDetails(tcID);
			Setup.LoadData();
			classInvoker.BillingInvoice_Validation(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPaymentDetailsValidation(tcID);
			GenericFunctions.instance().validateExclusions(tcID);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}
			/*** end ***/
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC05(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			GenericFunctions.instance().validateExclusions(tcID);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC06(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			GenericFunctions.instance().validateExclusions(tcID);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Reinstatement");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC07(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			GenericFunctions.instance().validateExclusions(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Reinstatement");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC08(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);

			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID,
			// "Reinstatement");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC09(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			;
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID,
			// "Reinstatement");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC14(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			GenericFunctions.instance().validateExclusions(tcID);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID,
			// "Reinstatement");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC15(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			// classInvoker.searchPolicy(tcID, DeviceName);
			// GenericFunctions.instance().removeOptionalCov(tcID);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID,
			// "Reinstatement");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC16(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			// classInvoker.InsuredAppLogin(tcID);
			// classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.InsuredAppLogin(tcID);
			// classInvoker.InsuredAppValidationPolicyChange(tcID);
			// GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID,
			// "Reinstatement");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC17(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {
			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			// GenericFunctions.instance().removeOptionalCov(tcID);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID,
			// "Reinstatement");
			// classInvoker.UmClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC18(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID,
			// "Reinstatement");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC19(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC20(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC21(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC22(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC26a(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PcPolicyInfoValidation(tcID);
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			// classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);

			// classInvoker.InsuredAppLogin(tcID);
			// classInvoker.InsuredAppValidationPolicyChange(tcID);
			// GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC26(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			// GenericFunctions.instance().removeOptionalCov(tcID);
			// classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.InsuredAppLogin(tcID);
			// classInvoker.InsuredAppValidationPolicyChange(tcID);
			// GenericFunctions.instance().PremiumValidation(tcID);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID,
			// "Reinstatement");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC27(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.CaptureUMTax_KY(tcID);
			Setup.LoadData();
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			Setup.LoadData();
			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			/*** end ***/
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC28(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			// classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}

			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}
			/*** end ***/

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC29(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC31(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			// classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID,
			// "Reinstatement");
			// classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}

			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}
			/*** end ***/

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC35(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC36(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID,
			// "Reinstatement");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC37(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID,
			// "Reinstatement");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC38(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC39(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			// classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC40(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "PolicyChange");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			// GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			// classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			// GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			// classInvoker.UmlaunchPage(tcID, DeviceName);
			// classInvoker.UmSearchSubmission(tcID);
			// GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// GenericFunctions.instance().validateTransactionHistory(tcID,
			// "Reinstatement");
			// classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}

			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC41(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			GenericFunctions.instance().validateExclusions(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC43(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			GenericFunctions.instance().validateExclusions(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC42(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			GenericFunctions.instance().validateExclusions(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	// R2 Test cases
	// R2 Smoke Test cases
	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_PCISMOKE(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			/*
			 * classInvoker.UmAddingOffice(tcID); classInvoker.UmExposures(tcID);
			 * //classInvoker.UmCallingCov(tcID);
			 * GenericFunctions.instance().checkCoverages(tcID);
			 * classInvoker.UmQuoting(tcID);
			 * GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			 * classInvoker.UmBinding(tcID);
			 * GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			 * classInvoker.UmIssuance(tcID);
			 * GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			 */
			classInvoker.UmClosePage(tcID, DeviceName);

			/*
			 * classInvoker.launchPage(tcID, DeviceName); Setup.LoadData();
			 * classInvoker.searchPolicy(tcID, DeviceName); classInvoker.ClosePage(tcID,
			 * DeviceName);
			 */

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_PCISMOKE2(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			// classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	// Non Rate Bearing Scenario

	@Test(dataProvider = "DeviceManager")
	public void NonRateBearing_E2E(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			// classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_NFPSMOKE(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			// classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_NFPSMOKE2(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			// classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_CYBSMOKE(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmValidateWritingApproach(tcID);
			// classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	// R2 Smoke Test case end
	// R3A Smoke Test cases start
	@Test(dataProvider = "DeviceManager")
	public void R3A_EZExcessSMOKE(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_LPLAdmittedSMOKE(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_1_LPLAdm_EZ_RL(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_LPLNonAdmittedSMOKE(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			;
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	// R3A Smoke Test cases

	// *********************R3A Scenarios****************
	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC01(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			Setup.LoadData();
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			classInvoker.UmClosePage(tcID, DeviceName);

			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);
			}

			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC02(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC03(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC04(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC05(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC06(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Reinstatement");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC07(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC08(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC09(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC10(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC11(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			GenericFunctions.instance().validateSubmissionNo(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Rewrite");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC12(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			Setup.LoadData();
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.BillingInvoice_WriteDetails(tcID);
			Setup.LoadData();
			classInvoker.BillingInvoice_Validation(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Cancellation");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchPolicy(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().validateTransactionHistory(tcID, "Reinstatement");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC13(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC17(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			;
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	// Juned : R5A : Added Premium Breakdown Validation for UM-PC
	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC18(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.CapturePremiumBreakdown(tcID);
			Setup.LoadData();
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPremiumBreakdownValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC20_TC01(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC20_TC02(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC20_TC03(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC20_TC04(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC20_TC05(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC20_TC06(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC20_TC07(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC20_TC08(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC21_TC01(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			;
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC21_TC02(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC21_TC03(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}
			/*** end ***/

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	// R3B Smoke Scenarios
	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_PRIMARY_CON(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_PRIMARY_CRD_ACF(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_PRIMARY_CRD_CREDIT(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_PRIMARY_CRD_PRO(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_PRIMARY_ENO(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_PRIMARY_POL_PRL(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_PRIMARY_POL_PRE(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_PRIMARY_POL_PRN(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_PRIMARY_REP(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_PRIMARY_SUR(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_PRIMARY_TAX(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_EXCESS_CON(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_EXCESS_CRD_ACF(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_EXCESS_CRD_CREDIT(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_EXCESS_CRD_PRO(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_EXCESS_ENO(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_EXCESS_POL_PRL(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);
			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_EXCESS_POL_PRE(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_EXCESS_POL_PRN(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_EXCESS_REP(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_E2E_SMOKE_EXCESS_TAX(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	// R3B Smoke Scenarios end

	// R3B SIT Scenarios

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC01_Primary_ENO(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC01_Excess_ENO(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);
				/*
				 * classInvoker.loginToImageRight(tcID, DeviceName);
				 * classInvoker.searchFile(tcID); classInvoker.verifyPolicyDocuments(tcID);
				 */
			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}
			/*** end ***/

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC02_Primary_CON(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.BillingInvoice_WriteDetails(tcID);
			Setup.LoadData();
			classInvoker.BillingInvoice_Validation(tcID);
			classInvoker.UmSubmissionNumber(tcID);
			Setup.LoadData();
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChange(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC02_Excess_CON(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChange(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC03_Primary_ACF_CRD(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC03_Excess_ACF_CRD(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC04_Primary_CRD(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.BillingInvoice_WriteDetails(tcID);
			Setup.LoadData();
			classInvoker.BillingInvoice_Validation(tcID);
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChange(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC04_Excess_CRD(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChange(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC05_Primary_PRE(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);

			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC05_Excess_PRE(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC07_Primary_PRN(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			/*** end ***/

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC07_Excess_PRN(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC08_Primary_PF_CRD(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			Setup.LoadData();
			Thread.sleep(6000);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPaymentDetailsValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC08_Excess_PF_CRD(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC09_Primary_REP(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChange(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC09_Excess_REP(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.BillingInvoice_WriteDetails(tcID);
			Setup.LoadData();
			classInvoker.BillingInvoice_Validation(tcID);
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);

			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPaymentDetailsValidation(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChange(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC10_PriComSurety(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.BillingInvoice_WriteDetails(tcID);
			Setup.LoadData();
			classInvoker.BillingInvoice_Validation(tcID);
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChange(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC11_Primary_TAX(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.BillingInvoice_WriteDetails(tcID);
			Setup.LoadData();
			classInvoker.BillingInvoice_Validation(tcID);
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}

			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChange(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC11_Excess_TAX(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);

			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}

			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChange(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC13_PriContSurety(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageData data = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);
			if (data.getData("IsEscapeValidationRequired").equalsIgnoreCase("Yes")) {
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.searchSubmissionInEscape(tcID);
				classInvoker.verify_UMAccountDetails_InEscape(tcID);
				classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);
				classInvoker.verify_UMPoloicyDetails_inEscape(tcID);

			}
			if (data.getData("IsIRValidationRequired").equalsIgnoreCase("Yes")) {

				classInvoker.loginToImageRight(tcID, DeviceName);
				classInvoker.searchFile(tcID);
				classInvoker.verifyPolicyDocuments(tcID);
			}

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_33_A(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.VerifyForms(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			/*
			 * classInvoker.launchPage(tcID, DeviceName); Setup.LoadData();
			 * classInvoker.searchPolicy(tcID, DeviceName);
			 * classInvoker.PremiumCapture(tcID); classInvoker.ClosePage(tcID, DeviceName);
			 * Setup.LoadData(); GenericFunctions.instance().UmPcPremiumValidation(tcID);
			 * classInvoker.InsuredAppLogin(tcID);
			 * classInvoker.InsuredAppValidationNB(tcID);
			 */

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.PolicyChangeFormValid(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_33_B(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.VerifyForms(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			// classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			/*
			 * classInvoker.launchPage(tcID, DeviceName); Setup.LoadData();
			 * classInvoker.searchPolicy(tcID, DeviceName);
			 * classInvoker.PremiumCapture(tcID); classInvoker.ClosePage(tcID, DeviceName);
			 * Setup.LoadData(); GenericFunctions.instance().UmPcPremiumValidation(tcID);
			 * classInvoker.InsuredAppLogin(tcID);
			 * classInvoker.InsuredAppValidationNB(tcID);
			 */

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.PolicyChangeFormValid(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_14(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			/*
			 * classInvoker.searchPolicy(tcID, DeviceName);
			 * classInvoker.ChangePremiumCapture(tcID); Setup.LoadData();
			 */
			classInvoker.ClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_33_C(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.VerifyForms(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.PolicyChangeFormValid(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_34(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.VerifyForms(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			// classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			/*
			 * classInvoker.launchPage(tcID, DeviceName); Setup.LoadData();
			 * classInvoker.searchPolicy(tcID, DeviceName);
			 * classInvoker.PremiumCapture(tcID); classInvoker.ClosePage(tcID, DeviceName);
			 * Setup.LoadData(); GenericFunctions.instance().UmPcPremiumValidation(tcID);
			 * classInvoker.InsuredAppLogin(tcID);
			 * classInvoker.InsuredAppValidationNB(tcID);
			 */
			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.PolicyChangeFormValid(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_40(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.VerifyForms(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			// classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_52(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.VerifyForms(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			// classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_45(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmWorkSheetEditVerify(tcID);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.VerifyForms(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC02(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			// classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.OptionalCovValid(tcID);
			classInvoker.cancelPolicy(tcID);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC03(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			// classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.OptionalCovValid(tcID);
			classInvoker.cancelPolicy(tcID);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC04(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			// classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.OptionalCovValid(tcID);
			classInvoker.cancelPolicy(tcID);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC13(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			// classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.OptionalCovValid(tcID);
			classInvoker.cancelPolicy(tcID);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_30(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.VerifyWrittingApproach(tcID);
			classInvoker.UmWorkSheetEditVerify(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.verify_UmSubmissionDetails(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_39(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.VerifyForms(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			// classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_SIT_E2E_SC_35(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.VerifyForms(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC33(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmValMinMaxClauseTerm(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.PolicyChange(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);
			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.Rewrite(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R2_SIT_E2E_SC34(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmValMinMaxClauseTerm(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.PolicyChange(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);
			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.cancelPolicy(tcID);
			classInvoker.Reinstate(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	// R3B SIT Scenarios end

	// AMS Scenarios Start: Juned

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_1_AMS_PCI_MSE(TestName testName, Device device) throws Exception {// Rating ManuScript Endts
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmAddingManuScriptEndts(tcID);
			Setup.LoadData();
			classInvoker.UmManuScriptEndts_Forms(tcID);
			Setup.LoadData();
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			// classInvoker.UmAddingManuScriptEndts(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R3_3_AMS_PCIPack_RaterBPrem(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmAddingSubInfo(tcID);
			classInvoker.Verify_SRM_CYB_Error_Msg(tcID);
			/*
			 * classInvoker.Verify_SRM_CRI_Error_Msg(tcID);
			 * classInvoker.Verify_SRM_DNO_Error_Msg(tcID);
			 * classInvoker.Verify_SRM_EMP_Error_Msg(tcID);
			 * classInvoker.Verify_SRM_ENO_Error_Msg(tcID);
			 * classInvoker.Verify_SRM_EPL_Error_Msg(tcID);
			 * classInvoker.Verify_SRM_FID_Error_Msg(tcID);
			 * classInvoker.Verify_SRM_KNR_Error_Msg(tcID);
			 */
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidation_BP(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidation_ST(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R3_4_AMS_EZ_RaterMGMHoldings(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R3_4_AMS_LPLAdm_CA(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmAddingSubInfo(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R3_2_R3_3_AMS_Forms_CYB(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R3_4_AMS_PowerBIReportLinks(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmPowerBIReports_LinkVerification(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R3_4_WY_LPL_Rater(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R3_4_AMS_NYFTZ_CYB(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmAddingSubInfo(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_1_AMS_PCI_ROE(TestName testName, Device device) throws Exception {// Rating Optional Endts
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().VerifyOptionalEndts(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			GenericFunctions.instance().VerifyOptionalEndts(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().VerifyOptionalEndts(tcID);
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_1_AMS_NFP_ROE(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().VerifyOptionalEndts(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			GenericFunctions.instance().VerifyOptionalEndts(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().VerifyOptionalEndts(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_1_AMS_CYB_ROE(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().VerifyOptionalEndts(tcID);
			classInvoker.Verify_SRM_CYB(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			GenericFunctions.instance().VerifyOptionalEndts(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().VerifyOptionalEndts(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_1_AMS_EZ_ROE(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			GenericFunctions.instance().VerifyOptionalEndts(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			GenericFunctions.instance().VerifyOptionalEndts(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			GenericFunctions.instance().VerifyOptionalEndts(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_1_SurNonBindingEmail(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			Setup.LoadData();
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_1_AMS_LPLAdm_PA(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_1_AMS_NOTFS_NJ(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmAddingSubInfo(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	// AMS Scenarios End: Juned

	// AMS Tickets Starts : Amit

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC18_KY(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {
			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC18_CA(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {
			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void R3B_SIT_E2E_SC18_MT(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_PCI_MulQt_CovUpdateVal(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {
			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			// UM
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			Setup.LoadData();
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.edit_UmSubmissionDetails(tcID);
			Setup.LoadData();
			classInvoker.UmCreateProposal(tcID);
			classInvoker.UmCreateQuote(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.verifyCovUpdatedForProposal(tcID);
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			// classInvoker.UmSubmissionNumber(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_PCI_RunOffERP_Val_PA(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.VerifyCybSharedCheckBox(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmValidateRatingCommon(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.VerifyRunOffAndERPFields(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_PCI_RunOffERP_Val_MA(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmValidateRatingCommon(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.VerifyRunOffAndERPFields(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_PCI_RunOffERP_Val_RI(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmValidateRatingCommon(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.VerifyRunOffAndERPFields(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_PCI_RunOffERP_Val_MT(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmValidateRatingCommon(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.VerifyRunOffAndERPFields(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_NFP_RunOffERP_Val_OH(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmValidateRatingCommon(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.VerifyRunOffAndERPFields(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_NFP_RunOffERP_Val_PA(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmValidateRatingCommon(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.VerifyRunOffAndERPFields(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_NFP_RunOffERP_Val_MT(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCopyCreateQuote(tcID, "Copy Quote");
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmValidateRatingCommon(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.VerifyRunOffAndERPFields(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_CYB_RunOffERP_Val_OK(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmValidateRatingCommon(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.VerifyRunOffAndERPFields(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_CYB_RunOffERP_Val_TX(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmValidateRatingCommon(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.VerifyRunOffAndERPFields(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_CYB_RunOffERP_Val_MT(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmValidateRatingCommon(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.VerifyRunOffAndERPFields(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_CYB_RunOffERP_Val_RI(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmValidateRatingCommon(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.VerifyRunOffAndERPFields(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_EZExcess_MulQt_CovUpdt(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {
			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			// UM
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmRatingEZExcessMinMaxValidation(tcID);
			classInvoker.UmConvertToQuote(tcID);
			classInvoker.UmCreateQuote(tcID);
			classInvoker.edit_UmSubmissionDetails(tcID);
			classInvoker.UmConvertToQuote(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			// classInvoker.UmSubmissionNumber(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_EZExcess_ModFac_Valid(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {
			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			// UM
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_LPL_Valid_AggDeduct(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.verifyLossControl(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			// classInvoker.UmSubmissionNumber(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_PCI_MunicipalTax_Val_KY(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			GenericFunctions.instance().UmMunicipalTaxValidation(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_PCI_PriToXXSwitchVal(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {
			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			// UM
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.edit_UmSubmissionDetails(tcID);
			classInvoker.UmCreateProposal(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			Setup.LoadData();
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			// classInvoker.UmSubmissionNumber(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_LPL_ST_PC_Valid_SC1(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			;
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_EZ_Excess_ST_PC_Valid_SC2(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_PCI_ST_PC_Valid_SC3(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			// classInvoker.UmGeneralInfo(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Clear");
			// classInvoker.UmMarketSegment(tcID);
			// classInvoker.UmRatingCommon(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);

			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_NFP_ST_PC_SC4(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_CYB_ST_PC_SC5(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.PolicyChange(tcID);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ChangePremiumCapture(tcID);
			Setup.LoadData();
			classInvoker.ClosePage(tcID, DeviceName);
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationPolicyChange(tcID);
			GenericFunctions.instance().PremiumValidation(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	// AMS Tickets Ends : Amit
	// AMS tickets sanjana

	@Test(dataProvider = "DeviceManager")
	public void TS_4_1_LPLAdm_NE_IRMChange(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.verifyIRMChanges(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_4_1_LPLNonAdm_HI_IRMChange(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.verifyIRMChangesNonAdmitted(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_4_1_LPLAdm_ME_IRMChange(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.verifyIRMChanges(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_4_1_LPLNonAdm_NC_IRMChange(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmAddingSubInfo(tcID);
			classInvoker.verifyIRMChangesNonAdmitted(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_4_1_LPL_MT_ClaimsExpChng_Err(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.verifyErrorForLPLClaimExpenses(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_4_1_LPL_MT_ClaimsExpChng_Err2(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);

			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.verifyErrorForLPLClaimExpenses(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_4_1_LPL_MT_Last5yrs_CC(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_4_1_LPL_NC_Last5yrs_CC(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);

			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_4_1_LPL_MT_AddMultipleClaims_CC(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);

			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_4_1_LPL_KY_AddMultipleClaims_CC(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);

			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_4_1_ObligeeClearance(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.verifyObligeeDetails(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_4_1_ObligeeClearanceBlocked(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_3_4_PCI_LOBUpdateInEscape_FirstClrnc(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.getUWBranchOfficeDetails(tcID);
			Thread.sleep(6000);
			Setup.LoadData();
			classInvoker.LoginToEscape(tcID, DeviceName);
			classInvoker.searchSubmissionInEscape(tcID);
			classInvoker.verify_LOB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_4_1_IntrnlProducers_01(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Thread.sleep(6000);
			Setup.LoadData();
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.LoginToEscape(tcID, DeviceName);
			classInvoker.searchSubmissionInEscape(tcID);
			classInvoker.verify_UMAccountDetails_InEscape(tcID);
			classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_4_1_IntrnlProducers_02(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmBindPremium(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmSubmissionInformation(tcID);
			Thread.sleep(6000);
			Setup.LoadData();
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.LoginToEscape(tcID, DeviceName);
			classInvoker.searchSubmissionInEscape(tcID);
			classInvoker.verify_UMAccountDetails_InEscape(tcID);
			classInvoker.verify_UMSUbmissionDetais_inEscape(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_3_1_AttachDocForTask_CollaborationTool(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.uploadTaskFile(tcID, DeviceName);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			Setup.LoadData();
			classInvoker.UmSubmissionInformation(tcID);
			Setup.LoadData();
			Thread.sleep(6000);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_3_1_MN_Surcharges(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			// classInvoker.UmCallingCov(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.verifyMNPCIMF4Surcharges(tcID);
			Setup.LoadData();
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.verifyMNFireCharges(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_3_1_SHaredLimit(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			classInvoker.UmBinding(tcID);
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			classInvoker.verifyFIDPremium(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.CoverageValidation(tcID);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);
			classInvoker.verifySubtotalWhenSharedLimitChecked(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_3_1_Cyber_PremiumRater(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmCallingCov(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			// classInvoker.UmSubmissionNumber(tcID);
			classInvoker.verifyCYBPremiumAgainstRater(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2_AMS_TC21750(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppValidationNB(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2_AMS_DefFormDNO(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.VerifyDnoFormEdit(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2_AMS_CYB_NE_SRM(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmAddingSubInfo(tcID);
			classInvoker.Verify_SRM_CYB(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2_AMS_NFP_NE_SRM(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmAddingSubInfo(tcID);
			classInvoker.Verify_SRM_CYB(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2_AMS_NFP_HI_SRM(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.Verify_SRM_CYB_Error_Msg(tcID);
			classInvoker.Verify_SRM_CRI_Error_Msg(tcID);
			classInvoker.Verify_SRM_DNO_Error_Msg(tcID);
			classInvoker.Verify_SRM_EMP_Error_Msg(tcID);
			classInvoker.Verify_SRM_ENO_Error_Msg(tcID);
			classInvoker.Verify_SRM_EPL_Error_Msg(tcID);
			classInvoker.Verify_SRM_FID_Error_Msg(tcID);
			classInvoker.Verify_SRM_KNR_Error_Msg(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2_AMS_PCI_WV_SRM_Adreg(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmAddingSubInfo(tcID);
			classInvoker.Verify_SRM_CYB_Error_Msg(tcID);
			classInvoker.Verify_SRM_CRI_Error_Msg(tcID);
			classInvoker.Verify_SRM_DNO_Error_Msg(tcID);
			classInvoker.Verify_SRM_EMP_Error_Msg(tcID);
			classInvoker.Verify_SRM_ENO_Error_Msg(tcID);
			classInvoker.Verify_SRM_EPL_Error_Msg(tcID);
			classInvoker.Verify_SRM_FID_Error_Msg(tcID);
			classInvoker.Verify_SRM_KNR_Error_Msg(tcID);
			classInvoker.Update_SRM_CYB(tcID);
			classInvoker.Update_SRM_CRI(tcID);
			classInvoker.Update_SRM_DNO(tcID);
			classInvoker.Update_SRM_EMP(tcID);
			classInvoker.Update_SRM_ENO(tcID);
			classInvoker.Update_SRM_EPL(tcID);
			classInvoker.Update_SRM_FID(tcID);
			classInvoker.Update_SRM_KNR(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2_AMS_PCI_CA_SRM_NonAdm(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmAddingSubInfo(tcID);
			classInvoker.Update_SRM_CYB(tcID);
			classInvoker.Update_SRM_CRI(tcID);
			classInvoker.Update_SRM_DNO(tcID);
			classInvoker.Update_SRM_EMP(tcID);
			classInvoker.Update_SRM_ENO(tcID);
			classInvoker.Update_SRM_EPL(tcID);
			classInvoker.Update_SRM_FID(tcID);
			classInvoker.Update_SRM_KNR(tcID);
			classInvoker.Verify_SRMTotalError(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2_AMS_PCI_NJ_SurCharge(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.CaptureUMTax_NJ(tcID);
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.BillingInvoice_Validation(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2_AMS_LPL_NY_NA_BRT(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppSearch(tcID);
			classInvoker.InsuredAppVerifyBaseRate(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}

	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2_AMS_LPL_NY_A_BRT(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmAddingSubInfo(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppSearch(tcID);
			classInvoker.InsuredAppVerifyBaseRate(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}

	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2_AMS_LPL_NY_AD_BRT(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmAddingSubInfo(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppSearch(tcID);
			classInvoker.InsuredAppVerifyBaseRate(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}

	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2LPL_NYNAYYCF(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			/*
			 * classInvoker.UmQuoting(tcID);
			 * GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			 * classInvoker.CaptureIRMFactor(tcID); Setup.LoadData();
			 * classInvoker.CalcComboFactor(tcID); Setup.LoadData();
			 * classInvoker.UmBinding(tcID);
			 * GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			 * classInvoker.UmIssuance(tcID); classInvoker.UmPremiumCapture(tcID);
			 * GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			 */
			classInvoker.UmClosePage(tcID, DeviceName);

			/*
			 * classInvoker.launchPage(tcID, DeviceName); Setup.LoadData();
			 * classInvoker.searchPolicy(tcID, DeviceName);
			 * classInvoker.PremiumCapture(tcID); classInvoker.ClosePage(tcID, DeviceName);
			 * Setup.LoadData(); GenericFunctions.instance().UmPcPremiumValidation(tcID);
			 * 
			 * classInvoker.InsuredAppLogin(tcID); classInvoker.InsuredAppSearch(tcID);
			 * classInvoker.InsuredAppVerifyComboFactor(tcID);
			 */

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}

	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2LPL_NYNA_NYCF_UL(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.CaptureIRMFactor(tcID);
			Setup.LoadData();
			classInvoker.CalcComboFactor(tcID);
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppSearch(tcID);
			classInvoker.InsuredAppVerifyComboFactor(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}

	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2LPL_NYNA_NYCF_LL(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.CaptureIRMFactor(tcID);
			Setup.LoadData();
			classInvoker.CalcComboFactor(tcID);
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppSearch(tcID);
			classInvoker.InsuredAppVerifyComboFactor(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}

	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2LPL_NYNA_NNCF(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.CaptureIRMFactor(tcID);
			Setup.LoadData();
			classInvoker.CalcComboFactor(tcID);
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppSearch(tcID);
			classInvoker.InsuredAppVerifyComboFactor(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}

	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2LPL_NYNA_YNCF_UL(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.CaptureIRMFactor(tcID);
			Setup.LoadData();
			classInvoker.CalcComboFactor(tcID);
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppSearch(tcID);
			classInvoker.InsuredAppVerifyComboFactor(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}

	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2LPL_NYNA_YNCF_LL(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.CaptureIRMFactor(tcID);
			Setup.LoadData();
			classInvoker.CalcComboFactor(tcID);
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppSearch(tcID);
			classInvoker.InsuredAppVerifyComboFactor(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}

	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2LPL_NYAD_YYCF(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.CaptureIRMFactor(tcID);
			Setup.LoadData();
			classInvoker.CalcComboFactor(tcID);
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppSearch(tcID);
			classInvoker.InsuredAppVerifyComboFactor(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}

	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2LPL_NYAD_YNCF(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.CaptureIRMFactor(tcID);
			Setup.LoadData();
			classInvoker.CalcComboFactor(tcID);
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppSearch(tcID);
			classInvoker.InsuredAppVerifyComboFactor(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}

	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2LPL_NYAD_NYCF(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.CaptureIRMFactor(tcID);
			Setup.LoadData();
			classInvoker.CalcComboFactor(tcID);
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppSearch(tcID);
			classInvoker.InsuredAppVerifyComboFactor(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}

	}

	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2LPL_NYAD_NNCF(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.CaptureIRMFactor(tcID);
			Setup.LoadData();
			classInvoker.CalcComboFactor(tcID);
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmPremiumCapture(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PremiumCapture(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			Setup.LoadData();
			GenericFunctions.instance().UmPcPremiumValidation(tcID);

			classInvoker.InsuredAppLogin(tcID);
			classInvoker.InsuredAppSearch(tcID);
			classInvoker.InsuredAppVerifyComboFactor(tcID);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}

	}

	// R5A Test Cases

	// PCI-QuotaShare Scenario
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_ML_QS(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmSetPartOfRatingCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPolicyInfoValidation(tcID);
			classInvoker.PcPolicyReviewValidation(tcID);
			classInvoker.ClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

}
