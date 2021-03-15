package test.java.com.everest.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.spi.Device;

import com.everest.functions.GenericFunctions;
import com.everest.functions.settings.Setup;
import com.everest.page.application.spi.PageImplInvoker;
import com.everest.utility.CustomAbstractTest;
import com.everest.utility.CustomReporting;

public class TestDriver_Renewal extends CustomAbstractTest {
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pakage_Renewal(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {	
			
			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			
			PageData dataSearchPolicy = PageDataManager.instance().getPageData("SearchPolicy",tcID);
			if(dataSearchPolicy.getData("IsPolicyCreatedInWins").equalsIgnoreCase("No"))
			{
				
			
			classInvoker.LoginToEscape(tcID, DeviceName);
			//classInvoker.Verify_Submission_Search(tcID, DeviceName);
			classInvoker.CreateAccount(tcID);
			classInvoker.clk_CreateNewSubmission(tcID);
			classInvoker.NewSubmission(tcID);
			Setup.LoadData();
			
			classInvoker.clkAddPolicy(tcID);
			classInvoker.IssueNewPolicy(tcID);
			Setup.LoadData();
			}
			else
			{
			classInvoker.UmlaunchPage(tcID, DeviceName);
			//classInvoker.UmSubmissionDetails(tcID);
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
	public void TS_EZExc_Pakage_Renewal(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			
			PageData dataSearchPolicy = PageDataManager.instance().getPageData("SearchPolicy",tcID);
			if(dataSearchPolicy.getData("IsPolicyCreatedInWins").equalsIgnoreCase("No"))
			{
			classInvoker.LoginToEscape(tcID, DeviceName);
			//classInvoker.Verify_Submission_Search(tcID, DeviceName);
			classInvoker.CreateAccount(tcID);
			classInvoker.clk_CreateNewSubmission(tcID);
			classInvoker.NewSubmission(tcID);
			Setup.LoadData();
			classInvoker.clkAddPolicy(tcID);
			classInvoker.IssueNewPolicy(tcID);
			Setup.LoadData();
			}
			else
			{
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
		
			/*classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");*/
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
		public void TS_NFP_Pakage_Renewal(TestName testName, Device device) throws Exception {
			String tcID = "";
			try {

				SoftAssert softAssert = new SoftAssert();
				tcID = getTestName(testName);
				String DeviceName = getDeviceName(testName);
				String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
				GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

				PageImplInvoker classInvoker = new PageImplInvoker();
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
				
				PageData dataSearchPolicy = PageDataManager.instance().getPageData("SearchPolicy",tcID);
				if(dataSearchPolicy.getData("IsPolicyCreatedInWins").equalsIgnoreCase("No"))
				{
				classInvoker.LoginToEscape(tcID, DeviceName);
				//classInvoker.Verify_Submission_Search(tcID, DeviceName);
				classInvoker.CreateAccount(tcID);
				classInvoker.clk_CreateNewSubmission(tcID);
				classInvoker.NewSubmission(tcID);
				Setup.LoadData();
				classInvoker.clkAddPolicy(tcID);
				classInvoker.IssueNewPolicy(tcID);
				Setup.LoadData();
				}
				else
				{
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
		public void TS_CYB_Mano_Renewal(TestName testName, Device device) throws Exception {
			String tcID = "";
			try {

				SoftAssert softAssert = new SoftAssert();
				tcID = getTestName(testName);
				String DeviceName = getDeviceName(testName);
				String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
				GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

				PageImplInvoker classInvoker = new PageImplInvoker();
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
				
				PageData dataSearchPolicy = PageDataManager.instance().getPageData("SearchPolicy",tcID);
				if(dataSearchPolicy.getData("IsPolicyCreatedInWins").equalsIgnoreCase("No"))
				{
				classInvoker.LoginToEscape(tcID, DeviceName);
				//classInvoker.Verify_Submission_Search(tcID, DeviceName);
				classInvoker.CreateAccount(tcID);
				classInvoker.clk_CreateNewSubmission(tcID);
				classInvoker.NewSubmission(tcID);
				Setup.LoadData();
				classInvoker.clkAddPolicy(tcID);
				classInvoker.IssueNewPolicy(tcID);
				Setup.LoadData();
				}
				else
				{
				/*classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID)
				//classInvoker.UmCallingCov(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				classInvoker.getUMPolicy(tcID);
				Setup.LoadData();
				classInvoker.UmClosePage(tcID, DeviceName);*/
			
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.Verify_Policy_Search(tcID, DeviceName);
				classInvoker.verify_RenewalPolicy_Version(tcID,"First");
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
		public void TS_PolExpDt_Morethen90_Rew(TestName testName, Device device) throws Exception {
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
				classInvoker.Verify_Submission_Search(tcID, DeviceName);
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
				classInvoker.validate_Renewal_ErrorMsg(tcID);
				
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),tcID);
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
		public void TS_SUR_Renewal(TestName testName, Device device) throws Exception {
				String tcID = "";
				try {

					SoftAssert softAssert = new SoftAssert();
					tcID = getTestName(testName);
					String DeviceName = getDeviceName(testName);
					String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
					GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

					PageImplInvoker classInvoker = new PageImplInvoker();
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
					
					PageData dataSearchPolicy = PageDataManager.instance().getPageData("SearchPolicy",tcID);
					
					if(dataSearchPolicy.getData("IsPolicyCreatedInWins").equalsIgnoreCase("No"))
					{
						
					
					classInvoker.LoginToEscape(tcID, DeviceName);
					//classInvoker.Verify_Submission_Search(tcID, DeviceName);
					classInvoker.CreateAccount(tcID);
					classInvoker.clk_CreateNewSubmission(tcID);
					classInvoker.NewSubmission(tcID);
					Setup.LoadData();
					
					classInvoker.clkAddPolicy(tcID);
					classInvoker.IssueNewPolicy(tcID);
					Setup.LoadData();
					}
					else
					{
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
//					classInvoker.UmSubmissionNumber(tcID);
					classInvoker.UmClosePage(tcID, DeviceName);
					Setup.LoadData();
					classInvoker.LoginToEscape(tcID, DeviceName);
					classInvoker.Verify_Policy_Search(tcID, DeviceName);
					classInvoker.verify_RenewalPolicy_Version(tcID,"First");
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
		public void TS_CON_Exces_Renewal(TestName testName, Device device) throws Exception {
				String tcID = "";
				try {

					SoftAssert softAssert = new SoftAssert();
					tcID = getTestName(testName);
					String DeviceName = getDeviceName(testName);
					String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
					GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

					PageImplInvoker classInvoker = new PageImplInvoker();
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
					
					PageData dataSearchPolicy = PageDataManager.instance().getPageData("SearchPolicy",tcID);
					
					if(dataSearchPolicy.getData("IsPolicyCreatedInWins").equalsIgnoreCase("No"))
					{
						
					
					classInvoker.LoginToEscape(tcID, DeviceName);
					//classInvoker.Verify_Submission_Search(tcID, DeviceName);
					classInvoker.CreateAccount(tcID);
					classInvoker.clk_CreateNewSubmission(tcID);
					classInvoker.NewSubmission(tcID);
					Setup.LoadData();
					
					classInvoker.clkAddPolicy(tcID);
					classInvoker.IssueNewPolicy(tcID);
					Setup.LoadData();
					}
					else
					{
						
					
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
//					classInvoker.UmSubmissionNumber(tcID);
					classInvoker.UmClosePage(tcID, DeviceName);
					Setup.LoadData();
					classInvoker.LoginToEscape(tcID, DeviceName);
					classInvoker.Verify_Policy_Search(tcID, DeviceName);
					classInvoker.verify_RenewalPolicy_Version(tcID,"First");
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
		public void TS_ENO_Primary_Renewal(TestName testName, Device device) throws Exception {
				String tcID = "";
				try {

					
					SoftAssert softAssert = new SoftAssert();
					tcID = getTestName(testName);
					String DeviceName = getDeviceName(testName);
					String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
					GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

					PageImplInvoker classInvoker = new PageImplInvoker();
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
					PageData dataSearchPolicy = PageDataManager.instance().getPageData("SearchPolicy",tcID);
					
					if(dataSearchPolicy.getData("IsPolicyCreatedInWins").equalsIgnoreCase("No"))
					{
						
					
					classInvoker.LoginToEscape(tcID, DeviceName);
					//classInvoker.Verify_Submission_Search(tcID, DeviceName);
					classInvoker.CreateAccount(tcID);
					classInvoker.clk_CreateNewSubmission(tcID);
					classInvoker.NewSubmission(tcID);
					Setup.LoadData();
					
					classInvoker.clkAddPolicy(tcID);
					classInvoker.IssueNewPolicy(tcID);
					Setup.LoadData();
					}
					else
					{
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
					classInvoker.UmClosePage(tcID, DeviceName);
					
					Setup.LoadData();
					classInvoker.LoginToEscape(tcID, DeviceName);
					classInvoker.Verify_Policy_Search(tcID, DeviceName);
					classInvoker.verify_RenewalPolicy_Version(tcID,"First");
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
		public void TS_PCI_ALL_Renewal(TestName testName, Device device) throws Exception {
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
				//classInvoker.UmCallingCov(tcID);
				GenericFunctions.instance().checkCoverages(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				Setup.LoadData();
//				classInvoker.UmSubmissionNumber(tcID);
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
		
		@Test(dataProvider = "DeviceManager",dependsOnMethods="TS_PCI_ALL_Renewal")
		public void TS_PCI_ALL_Renewal_2(TestName testName, Device device) throws Exception {
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
				//classInvoker.UmCallingCov(tcID);
				GenericFunctions.instance().checkCoverages(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//				classInvoker.UmSubmissionNumber(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);

				
				Setup.LoadData();
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
		public void TS_LPLAdmitted_Renewal(TestName testName, Device device) throws Exception {
			String tcID = "";
			try {

				SoftAssert softAssert = new SoftAssert();
				tcID = getTestName(testName);
				String DeviceName = getDeviceName(testName);
				String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
				GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

				PageImplInvoker classInvoker = new PageImplInvoker();
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
				
				PageData dataSearchPolicy = PageDataManager.instance().getPageData("SearchPolicy",tcID);
				
				if(dataSearchPolicy.getData("IsPolicyCreatedInWins").equalsIgnoreCase("No"))
				{
					classInvoker.LoginToEscape(tcID, DeviceName);
					//classInvoker.Verify_Submission_Search(tcID, DeviceName);
					classInvoker.CreateAccount(tcID);
					classInvoker.clk_CreateNewSubmission(tcID);
					classInvoker.NewSubmission(tcID);
					Setup.LoadData();
					
					classInvoker.clkAddPolicy(tcID);
					classInvoker.IssueNewPolicy(tcID);
					Setup.LoadData();
				}else
				{
				
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
	//				classInvoker.UmSubmissionNumber(tcID);
					classInvoker.UmClosePage(tcID, DeviceName);
					classInvoker.LoginToEscape(tcID, DeviceName);
					classInvoker.Verify_Policy_Search(tcID, DeviceName);
					classInvoker.verify_RenewalPolicy_Version(tcID,"First");
					
					classInvoker.UmlaunchPage(tcID+"_1", DeviceName);
					classInvoker.UmSubmissionDetails(tcID+"_1");
					classInvoker.UmAddingOffice(tcID+"_1");
					classInvoker.UmExposures(tcID+"_1");
					classInvoker.UmRatingLPLNonAdmitted(tcID+"_1");
					classInvoker.UmQuoting(tcID+"_1");
					GenericFunctions.instance().validateUMStatus(tcID+"_1", "Quoted");
					
					classInvoker.UmBinding(tcID+"_1");
					GenericFunctions.instance().validateUMStatus(tcID+"_1", "Bound");
					classInvoker.UmIssuance(tcID+"_1");
					GenericFunctions.instance().validateUMStatus(tcID+"_1", "Issued");
	//				classInvoker.UmSubmissionNumber(tcID);
	 				classInvoker.verify_UMPolicy_Renewaval(tcID);
					classInvoker.UmClosePage(tcID+"_1", DeviceName);
					classInvoker.LoginToEscape(tcID+"_1", DeviceName);
					classInvoker.Verify_Policy_Search(tcID+"_1", DeviceName);
					classInvoker.verify_RenewalPolicy_Version(tcID+"_1","Second");
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

		

}
