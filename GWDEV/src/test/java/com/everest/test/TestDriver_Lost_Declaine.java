package test.java.com.everest.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xframium.spi.Device;

import com.everest.functions.GenericFunctions;
import com.everest.functions.settings.Setup;
import com.everest.page.application.spi.PageImplInvoker;
import com.everest.utility.CustomAbstractTest;
import com.everest.utility.CustomReporting;

public class TestDriver_Lost_Declaine  extends CustomAbstractTest  {
	
	// Mark as Lost and Decline 
	// Author : Manju
	@Test(dataProvider = "DeviceManager")
	public void TS_MarkAsLost_ClearEzExcess(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			// Launching PC and searching for Account created in UM.
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchSubmission(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.UmlaunchPage(tcID, DeviceName);
			 Setup.LoadData();
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
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(),
					"");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
		

	// Cyber Mark as Lost
		@Test(dataProvider = "DeviceManager")
		public void TS_MarkAsLost_ClearCYB(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			
			// Launching PC and searching for Account created in UM.
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchSubmission(tcID);
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
		public void TS_DeclineCYB(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			
			// Launching PC and searching for Account created in UM.
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchSubmission(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.UmDecline(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			// Launching PC
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchSubmission(tcID);
			GenericFunctions.instance().validatePCStatus(tcID, "Declined");
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
		
		// Decline LPL  DS_MarkAsLost_DeclineLPL
		@Test(dataProvider = "DeviceManager")
		public void TS_Decline_ClearLPL(TestName testName, Device device) throws Exception {
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
				 classInvoker.UmRatingLPLNonAdmitted(tcID);;
				 classInvoker.UmQuoting(tcID);
				 GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				 classInvoker.UmSubmissionNumber(tcID);
				 classInvoker.UmClosePage(tcID, DeviceName);
				
				// Launching PC and searching for Account created in UM.
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchSubmission(tcID);
				classInvoker.ClosePage(tcID, DeviceName);
				
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchSubmission(tcID);	
				classInvoker.UmDecline(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				// Launching PC
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchSubmission(tcID);
				GenericFunctions.instance().validatePCStatus(tcID, "Declined");
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

		// contingent primary  mark as lost DS : DS_MarkAsLost_ContingentP DS_R3B_E2E_SMOKE_PRIMARY_CON
		
		@Test(dataProvider = "DeviceManager")
		public void TS_MarkAsLostContingentP(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSubmissionNumber(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				
				// Launching PC and searching for Account created in UM.
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchSubmission(tcID);
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
		
	// Decline Political Risk // DS_MarkAsLost_DeclinePolitcalE // DS_R3B_E2E_SMOKE_EXCESS_POL_PRN

	@Test(dataProvider = "DeviceManager")
	public void TS_DeclinePolitcalRiskNE(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSubmissionNumber(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				
				// Launching PC and searching for Account created in UM.
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchSubmission(tcID);
				classInvoker.ClosePage(tcID, DeviceName);
				
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmDecline(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				// Launching PC
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchSubmission(tcID);
				GenericFunctions.instance().validatePCStatus(tcID, "Declined");
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

	// EZ Excess Decline DS_MarkAsLost_DeclineEzExcess  DS_MarkAsLost_ClearEzExcess

	@Test(dataProvider = "DeviceManager")
	public void TS_DeclineEzExcess(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			// Launching PC and searching for Account created in UM.
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchSubmission(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.UmlaunchPage(tcID, DeviceName);
			 Setup.LoadData();
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.UmDecline(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			// Launching PC
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchSubmission(tcID);
			GenericFunctions.instance().validatePCStatus(tcID, "Declined");
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
	//  DS_MarkAsLost_MarkAslostSurety DS_R3B_SIT_E2E_SC10_PriComSurety

	@Test(dataProvider = "DeviceManager")
	public void TS_MarkAsLostSurety(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSubmissionNumber(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				
				// Launching PC and searching for Account created in UM.
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchSubmission(tcID);
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
	public void TS_DeclineCredit(TestName testName, Device device) throws Exception {
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
							classInvoker.UmSubmissionNumber(tcID);
							classInvoker.UmClosePage(tcID, DeviceName);

							// Launching PC and searching for Account created in UM.
							classInvoker.launchPage(tcID, DeviceName);
							Setup.LoadData();
							classInvoker.searchSubmission(tcID);
							classInvoker.ClosePage(tcID, DeviceName);
							
							classInvoker.UmlaunchPage(tcID, DeviceName);
							 Setup.LoadData();
							classInvoker.UmSearchSubmission(tcID);
							classInvoker.UmDecline(tcID);
							classInvoker.UmClosePage(tcID, DeviceName);
							// Launching PC
							classInvoker.launchPage(tcID, DeviceName);
							Setup.LoadData();
							classInvoker.searchSubmission(tcID);
							GenericFunctions.instance().validatePCStatus(tcID, "Declined");
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

	// DS_R3B_SIT_E2E_SC09_Primary_REP DS_MarkAsLost_MarkAslostReps
	@Test(dataProvider = "DeviceManager")
	public void TS_MarkAsLostReps(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSubmissionNumber(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				
				// Launching PC and searching for Account created in UM.
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchSubmission(tcID);
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
	public void TS_DeclineCredit_Clear(TestName testName, Device device) throws Exception {
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

				// Launching PC and searching for Account created in UM.
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchSubmission(tcID);
				classInvoker.ClosePage(tcID, DeviceName);
							
				classInvoker.UmlaunchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmDecline(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				
				// Launching PC
				classInvoker.launchPage(tcID, DeviceName);
				Setup.LoadData();
				classInvoker.searchSubmission(tcID);
				GenericFunctions.instance().validatePCStatus(tcID, "Declined");
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
