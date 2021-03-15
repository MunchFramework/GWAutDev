package test.java.com.everest.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xframium.spi.Device;

import com.everest.functions.GenericFunctions;
import com.everest.functions.settings.Setup;
import com.everest.page.application.spi.PageImplInvoker;
import com.everest.utility.CustomAbstractTest;
import com.everest.utility.CustomReporting;

public class TestDriver_InternationalAddress extends CustomAbstractTest  {
	@Test(dataProvider = "DeviceManager")
	public void TS_ItlAdd_SuretyContract(TestName testName, Device device) throws Exception {
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
				classInvoker.UmClosePage(tcID, DeviceName);
				
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchPolicy(tcID, DeviceName);
				classInvoker.pcPremiumCaptureItlAdd(tcID);
				Setup.LoadData();
				GenericFunctions.instance().umpcPremiumValidationIntlAdd(tcID);
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

	// DS_ItlAdd_SuretyComm  DS_R3B_SIT_E2E_SC10_PriComSurety
	@Test(dataProvider = "DeviceManager")
	public void TS_ItlAdd_SuretyComm(TestName testName, Device device) throws Exception {
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
				classInvoker.UmClosePage(tcID, DeviceName);
				
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchPolicy(tcID, DeviceName);
				classInvoker.pcPremiumCaptureItlAdd(tcID);
				Setup.LoadData();
				GenericFunctions.instance().umpcPremiumValidationIntlAdd(tcID);
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

	// DS_ItlAdd_BrokerENOP DS_R3B_SIT_E2E_SC01_Primary_ENO
	@Test(dataProvider = "DeviceManager")
	public void TS_ItlAdd_BrokerENOP(TestName testName, Device device) throws Exception {
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
				
				classInvoker.UmClosePage(tcID, DeviceName);
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchPolicy(tcID, DeviceName);
				classInvoker.pcPremiumCaptureItlAdd(tcID);
				Setup.LoadData();
				GenericFunctions.instance().umpcPremiumValidationIntlAdd(tcID);
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
	// DS_ItlAdd_ContLiabE DS_R3B_SIT_E2E_SC02_Excess_CON
	@Test(dataProvider = "DeviceManager")
	public void TS_ItlAdd_ContLiabE(TestName testName, Device device) throws Exception {
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
				classInvoker.UmClosePage(tcID, DeviceName);
				
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchPolicy(tcID, DeviceName);
				classInvoker.pcPremiumCaptureItlAdd(tcID);
				Setup.LoadData();
				GenericFunctions.instance().umpcPremiumValidationIntlAdd(tcID);
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

	// DS_ItlAdd_RepsWarE DS_R3B_SIT_E2E_SC09_Excess_REP
	@Test(dataProvider = "DeviceManager")
	public void TS_ItlAdd_RepsWarE(TestName testName, Device device) throws Exception {
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
				classInvoker.UmClosePage(tcID, DeviceName);
				
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchPolicy(tcID, DeviceName);
				classInvoker.pcPremiumCaptureItlAdd(tcID);
				Setup.LoadData();
				GenericFunctions.instance().umpcPremiumValidationIntlAdd(tcID);
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
	// DS_ItlAdd_TaxLiabP  DS_R3B_SIT_E2E_SC11_Primary_TAX
	@Test(dataProvider = "DeviceManager")
	public void TS_ItlAdd_TaxLiabP(TestName testName, Device device) throws Exception {
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
				
				classInvoker.UmClosePage(tcID, DeviceName);
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchPolicy(tcID, DeviceName);
				classInvoker.pcPremiumCaptureItlAdd(tcID);
				Setup.LoadData();
				GenericFunctions.instance().umpcPremiumValidationIntlAdd(tcID);
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
	// DS_ItlAdd_Credit   DS_R3B_SIT_E2E_SC04_Primary_CRD
	@Test(dataProvider = "DeviceManager")
	public void TS_ItlAdd_Credit(TestName testName, Device device) throws Exception {
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
				classInvoker.UmPremiumCapture(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				Setup.LoadData();
				classInvoker.BillingInvoice_WriteDetails(tcID);
				Setup.LoadData();
				classInvoker.BillingInvoice_Validation(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchPolicy(tcID, DeviceName);
				classInvoker.pcPremiumCaptureItlAdd(tcID);
				Setup.LoadData();
				GenericFunctions.instance().umpcPremiumValidationIntlAdd(tcID);
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
	public void TS_ItlAdd_Credit_Euro(TestName testName, Device device) throws Exception {
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
				classInvoker.UmPremiumCapture(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				Setup.LoadData();
				classInvoker.BillingInvoice_WriteDetails(tcID);
				Setup.LoadData();
				classInvoker.BillingInvoice_Validation(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchPolicy(tcID, DeviceName);
				classInvoker.pcPremiumCaptureItlAdd(tcID);
				Setup.LoadData();
				GenericFunctions.instance().umpcPremiumValidationIntlAdd(tcID);
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

	// DS_ItlAdd_AirCraftP DS_R3B_SIT_E2E_SC03_Primary_ACF
	@Test(dataProvider = "DeviceManager")
	public void TS_ItlAdd_AirCraftP(TestName testName, Device device) throws Exception {
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
				classInvoker.UmPremiumCapture(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				Setup.LoadData();
				classInvoker.BillingInvoice_WriteDetails(tcID);
				Setup.LoadData();
				classInvoker.BillingInvoice_Validation(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchPolicy(tcID, DeviceName);
				classInvoker.pcPremiumCaptureItlAdd(tcID);
				Setup.LoadData();
				GenericFunctions.instance().umpcPremiumValidationIntlAdd(tcID);
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

	// DS_ItlAdd_ProjectFP DS_R3B_SIT_E2E_SC08_PriPF_CRD
	@Test(dataProvider = "DeviceManager")
	public void TS_ItlAdd_ProjectFP(TestName testName, Device device) throws Exception {
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
				classInvoker.UmClosePage(tcID, DeviceName);
				
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchPolicy(tcID, DeviceName);
				classInvoker.pcPremiumCaptureItlAdd(tcID);
				Setup.LoadData();
				GenericFunctions.instance().umpcPremiumValidationIntlAdd(tcID);
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

	// DS_ItlAdd_EquityE  DS_R3B_SIT_E2E_SC05_Excess_PRE
	@Test(dataProvider = "DeviceManager")
	public void TS_ItlAdd_EquityE(TestName testName, Device device) throws Exception {
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
				classInvoker.UmPremiumCapture(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				Setup.LoadData();
				classInvoker.BillingInvoice_WriteDetails(tcID);
				Setup.LoadData();
				classInvoker.BillingInvoice_Validation(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchPolicy(tcID, DeviceName);
				classInvoker.pcPremiumCaptureItlAdd(tcID);
				Setup.LoadData();
				GenericFunctions.instance().umpcPremiumValidationIntlAdd(tcID);
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

	//DS_ItlAdd_NonHonoringE  DS_R3B_SIT_E2E_SC07_Excess_PRN
	@Test(dataProvider = "DeviceManager")
	public void TS_ItlAdd_NonHonoringE(TestName testName, Device device) throws Exception {
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
				classInvoker.UmPremiumCapture(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				Setup.LoadData();
				classInvoker.BillingInvoice_WriteDetails(tcID);
				Setup.LoadData();
				classInvoker.BillingInvoice_Validation(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchPolicy(tcID, DeviceName);
				classInvoker.pcPremiumCaptureItlAdd(tcID);
				Setup.LoadData();
				GenericFunctions.instance().umpcPremiumValidationIntlAdd(tcID);
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

	// DS_ItlAdd_NonHonoringP DS_R3B_SIT_E2E_SC07_Primary_PRN
	@Test(dataProvider = "DeviceManager")
	public void TS_ItlAdd_NonHonoringP(TestName testName, Device device) throws Exception {
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
				classInvoker.UmClosePage(tcID, DeviceName);
				
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchPolicy(tcID, DeviceName);
				classInvoker.pcPremiumCaptureItlAdd(tcID);
				Setup.LoadData();
				GenericFunctions.instance().umpcPremiumValidationIntlAdd(tcID);
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
	public void TS_R4_2_AMS_PCI_INTLAdrs(TestName testName, Device device) throws Exception {
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
				classInvoker.UmBindPremium(tcID);
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				classInvoker.UmClosePage(tcID, DeviceName);
				
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchPolicy(tcID, DeviceName);
				classInvoker.pcPremiumCaptureItlAdd(tcID);
				Setup.LoadData();
				GenericFunctions.instance().umpcPremiumValidationIntlAdd(tcID);
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


}
