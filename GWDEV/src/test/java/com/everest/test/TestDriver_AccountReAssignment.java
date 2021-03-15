package test.java.com.everest.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xframium.spi.Device;

import com.everest.functions.GenericFunctions;
import com.everest.functions.settings.Setup;
import com.everest.page.application.spi.PageImplInvoker;
import com.everest.utility.CustomAbstractTest;
import com.everest.utility.CustomReporting;

public class TestDriver_AccountReAssignment extends CustomAbstractTest {
	@Test(dataProvider = "DeviceManager")
	public void TS__Acc_ReAsign_1(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {
			//
						
			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.LoginToEscape(tcID, DeviceName);
			//classInvoker.Verify_Submission_Search(tcID, DeviceName);
			classInvoker.CreateAccount(tcID);
			classInvoker.clk_CreateNewSubmission(tcID);
			classInvoker.NewSubmission(tcID);
			Setup.LoadData();
			classInvoker.clkAddPolicy(tcID);
			classInvoker.IssueNewPolicy(tcID);
			Setup.LoadData();
			
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.getUMPolicy(tcID);
			Setup.LoadData();
			classInvoker.UmClosePage(tcID, DeviceName);
			
			classInvoker.LoginToEscape(tcID, DeviceName);
			classInvoker.Verify_Policy_Search(tcID, DeviceName);
			classInvoker.verify_RenewalPolicy_Version(tcID,"First");
			

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
	public void TS__Acc_ReAsign_2(TestName testName, Device device) throws Exception {
			String tcID = "";
			try {

				SoftAssert softAssert = new SoftAssert();
				tcID = getTestName(testName);
				String DeviceName = getDeviceName(testName);
				String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
				GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

				PageImplInvoker classInvoker = new PageImplInvoker();
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
				
				classInvoker.LoginToEscape(tcID, DeviceName);
				//classInvoker.Verify_Submission_Search(tcID, DeviceName);
				classInvoker.CreateAccount(tcID);
				classInvoker.clk_CreateNewSubmission(tcID);
				classInvoker.NewSubmission(tcID);
				Setup.LoadData();
				
				classInvoker.clkAddPolicy(tcID);
				classInvoker.IssueNewPolicy(tcID);
				Setup.LoadData();
				
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
//				classInvoker.UmSubmissionNumber(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);

				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.Verify_Policy_Search(tcID, DeviceName);
				classInvoker.verify_RenewalPolicy_Version(tcID,"First");
				classInvoker.verify_AccountReAssignment(tcID,"New");
				
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
	public void TS__Acc_ReAsign_3(TestName testName, Device device) throws Exception {
			String tcID = "";
			try {

				SoftAssert softAssert = new SoftAssert();
				tcID = getTestName(testName);
				String DeviceName = getDeviceName(testName);
				String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
				GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

				PageImplInvoker classInvoker = new PageImplInvoker();
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
				
				classInvoker.LoginToEscape(tcID, DeviceName);
				//classInvoker.Verify_Submission_Search(tcID, DeviceName);
				classInvoker.CreateAccount(tcID);
				classInvoker.clk_CreateNewSubmission(tcID);
				classInvoker.NewSubmission(tcID);
				Setup.LoadData();
				
				classInvoker.clkAddPolicy(tcID);
				classInvoker.IssueNewPolicy(tcID);
				Setup.LoadData();
		
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.SubmitApplication(tcID);
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.UM_Submission_Search(tcID, DeviceName);
				classInvoker.verify_AccountReAssignment(tcID, "New");
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.update_Exposure(tcID);
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.UM_Submission_Search(tcID, DeviceName);
				classInvoker.verify_AccountReAssignment(tcID, "Edit");
				
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//				classInvoker.UmSubmissionNumber(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);

				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.Verify_Policy_Search(tcID, DeviceName);
				classInvoker.verify_AccountReAssignment(tcID, "Edit");
				
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
	public void TS__Acc_ReAsign_4(TestName testName, Device device) throws Exception {
			String tcID = "";
			try {

				SoftAssert softAssert = new SoftAssert();
				tcID = getTestName(testName);
				String DeviceName = getDeviceName(testName);
				String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
				GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

				PageImplInvoker classInvoker = new PageImplInvoker();
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
				
				classInvoker.LoginToEscape(tcID, DeviceName);
				//classInvoker.Verify_Submission_Search(tcID, DeviceName);
				classInvoker.CreateAccount(tcID);
				classInvoker.clk_CreateNewSubmission(tcID);
				classInvoker.NewSubmission(tcID);
				Setup.LoadData();
				classInvoker.clkAddPolicy(tcID);
				classInvoker.IssueNewPolicy(tcID);
				classInvoker.CreateAccount(tcID+"_1");
				Setup.LoadData();
				
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.SubmitApplication(tcID);
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.UM_Submission_Search(tcID, DeviceName);
				classInvoker.verify_AccountReAssignment(tcID, "New");
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID+"_1");
				Setup.LoadData();
				classInvoker.update_Exposure(tcID);
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.UM_Submission_Search(tcID, DeviceName);
				classInvoker.verify_AccountReAssignment(tcID, "Edit");
				
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//				classInvoker.UmSubmissionNumber(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);

				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.Verify_Policy_Search(tcID, DeviceName);
				classInvoker.verify_RenewalPolicy_Version(tcID,"First");
				
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
	public void TS_Create_DuplicateAcc_ReAsign_5(TestName testName, Device device) throws Exception 
	{
		String tcID = "";
		try 
		{
			
			
			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			//UM
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.SubmitApplication(tcID);
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
	public void TS__Acc_ReAsign_5(TestName testName, Device device) throws Exception {
		
			String tcID = "";
			try 
			{
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
				Setup.LoadData();
				classInvoker.UmExposures(tcID);
				classInvoker.UmQuoting(tcID);
				
				classInvoker.UmSubmissionDetails(tcID+"_1");
				classInvoker.UmAddingOffice(tcID);
				Setup.LoadData();
				classInvoker.SubmitApplication(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker._click_RiskIsClear(tcID);
				classInvoker.verify_UMAccountReAssignment_ErrorPopup(tcID);
				classInvoker.veify_UMSubmission_Status(tcID);
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
	public void TS__Acc_ReAsign_6(TestName testName, Device device) throws Exception {
		
			String tcID = "";
			try 
			{
				SoftAssert softAssert = new SoftAssert();
				tcID = getTestName(testName);
				String DeviceName = getDeviceName(testName);
				String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
				GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

				PageImplInvoker classInvoker = new PageImplInvoker();
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");

				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.CreateAccount(tcID);
				Setup.LoadData();
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				Setup.LoadData();
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingEZExcess(tcID);
				classInvoker.UmQuoting(tcID);
				
				classInvoker.UmSubmissionDetails(tcID+"_1");
				classInvoker.UmAddingOffice(tcID);
				Setup.LoadData();
				classInvoker.UmExposures(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker._click_RiskIsClear(tcID);
				classInvoker.verify_UMAccountReAssignment_ErrorPopup(tcID);
				classInvoker.veify_UMSubmission_Status(tcID);
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
	public void TS__Acc_ReAsign_7(TestName testName, Device device) throws Exception {
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
			classInvoker.UM_ConvertQuote(tcID);
			classInvoker.UM_GenerateProposal(tcID);
			classInvoker.edit_UmSubmissionDetails(tcID);
			classInvoker.expendCoverages(tcID);
			classInvoker.UMFinalizeProposal(tcID);
			classInvoker.UMSendProposal(tcID);

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
	public void TS__Acc_ReAsign_8(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			
			classInvoker.LoginToEscape(tcID, DeviceName);
			classInvoker.CreateAccount(tcID);
			Setup.LoadData();
			
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.edit_UmSubmissionDetails(tcID);
			classInvoker.expendCoverages(tcID);
			classInvoker.UmRatingSlimCommon(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);
			Setup.LoadData();
			

			classInvoker.LoginToEscape(tcID, DeviceName);
			classInvoker.Verify_Policy_Search(tcID, DeviceName);
			classInvoker.verify_AccountReAssignment(tcID, "Second");
			
			
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
