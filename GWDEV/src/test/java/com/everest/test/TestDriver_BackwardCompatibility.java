package test.java.com.everest.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xframium.spi.Device;

import com.everest.functions.GenericFunctions;
import com.everest.functions.settings.Setup;
import com.everest.page.application.spi.PageImplInvoker;
import com.everest.utility.CustomAbstractTest;
import com.everest.utility.CustomReporting;

public class TestDriver_BackwardCompatibility extends CustomAbstractTest {
	
	@Test(dataProvider = "DeviceManager")
	public void TS_BC_PCI_SA_1A(TestName testName, Device device) throws Exception 
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
			classInvoker.expendCoverages(tcID);
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
	public void TS_BC_EZExces_SA_1A(TestName testName, Device device) throws Exception 
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
	public void TS_BC_ENO_SA_1A(TestName testName, Device device) throws Exception 
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
	public void TS_BC_Slim_Surety_SA_1A(TestName testName, Device device) throws Exception 
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
	public void TC_BC_NFP_CreateProposal_1A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
			//classInvoker.UmQuoting(tcID);
			//GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
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
	public void TC_BC_CYB_CreateProposal_1A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
			//classInvoker.UmQuoting(tcID);
			//GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
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
	public void TC_BC_Slim_AS_CreateProposal_1A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
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
	public void BC_PCI_QS_1A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			//PC
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
	public void BC_PCI_BI_1B(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.ClosePage(tcID, DeviceName);
			 


			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} 
		catch (Exception ex) 
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void BC_NFP_BS_2A(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void BC_NFP_Issue_2B(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}


	@Test(dataProvider = "DeviceManager")
	public void BC_CYB_GetRate_3A(TestName testName, Device device) throws Exception {
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
			classInvoker.UmGetRate(tcID);
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
	public void BC_CYB_Issue_3B(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//			classInvoker.UmSubmissionNumber(tcID);
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
	public void BC_LPL_IssueFC(TestName testName, Device device) throws Exception 
	{
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
//			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			
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
	public void BC_EZExcess_Issue_5A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PCI_Issue_EPL_175A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_EZExcess_Issue_EPL_176A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_Pri_ENO_Issue_185A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_Issue_PriComSur_186A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_CYB_Issue_MTC_187A(TestName testName, Device device) throws Exception {
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
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmClosePage(tcID, DeviceName);
			
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
	public void TS_BC_PriREP_Issue_MTC_198A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmClosePage(tcID, DeviceName);
				
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
	public void TS_BC_LPL_IssueFC_199A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_Pri_TAX_IssueFC_210A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmClosePage(tcID, DeviceName);
				
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
	public void TS_BC_CYB_Issue_211A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_EZExcess_Pack_Issue_212A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PCI_Pack_Bound_139A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_EZExcess_Pack_Bound_140A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_Pri_ENO_Bound_150A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_NFP_Quoted_103A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_LPL_Quoted_82A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriContSur_Quoted_125A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PCI_Quoted_115A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_CYB_Quoted_116A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_Pri_TAX_Quoted_120A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_Pri_PRE_Quoted_126A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_NFP_QuoteGen_127A(TestName testName, Device device) throws Exception {
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
			classInvoker.UmGenQuote(tcID);
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
	public void TS_BC_CYB_QuoteGen_128A(TestName testName, Device device) throws Exception {
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
			classInvoker.UmGenQuote(tcID);
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
	public void TS_BC_LPL_QuoteGen_129A(TestName testName, Device device) throws Exception {
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
			classInvoker.UmGenQuote(tcID);
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
	public void TS_BC_PriContSur_QuoteGen_137A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGenQuote(tcID);
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
	public void TS_BC_PriPRN_QuoteGen_138A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGenQuote(tcID);
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
	public void TS_BC_PCI_Quoted_105A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PCI_Quoted_93A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PCI_Quoted_63A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_CYB_Quoted_69A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_CYB_Quoted_94A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_CYB_Quoted_106A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_EZExcess_Pack_Quoted_51A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_EZExcess_Cyb_Quoted_66A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_EZExcess_Pack_Quoted_71A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_EZExcess_3Cov_Quoted_83A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_EZExcess_3Cov_Quoted_95A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_EZExcess_4Cov_Quoted_107A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_EZExcess_4Cov_Quoted_119A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriREP_Quoted_56A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriREP_Quoted_75A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriREP_Quoted_86A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriREP_Quoted_108A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriREP_Quoted_121A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriCON_Quoted_58A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriCON_Quoted_77A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriCON_Quoted_98A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriCON_Quoted_110A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriCON_Quoted_122A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriENO_Quoted_89A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriENO_Quoted_99A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriENO_Quoted_111A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriENO_Quoted_123A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriTAX_Quoted_76A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriTAX_Quoted_57A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriTAX_Quoted_87A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriTAX_Quoted_97A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriTAX_Quoted_109A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_LPL_Quoted_64A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_LPL_Quoted_70A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_LPL_Quoted_118A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_LPL_Quoted_104A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriContSur_Quoted_100A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_PriContSur_Quoted_114A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_Pri_PRE_Quoted_101A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_Pri_PRE_Quoted_112A(TestName testName, Device device) throws Exception {
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
	public void TS_BC_LPL_IssueMTC_191A(TestName testName, Device device) throws Exception 
	{
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
	public void TS_BC_CRD_Quoted_113A(TestName testName, Device device) throws Exception {
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



	
	//R3B SIT Scenarios end

	//Backward Compatibility Scenarios- Amit
		
	@Test(dataProvider = "DeviceManager")
		
		public void BC_SLIM_POL_Draft_10A(TestName testName, Device device) throws Exception {
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
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
							tcID);
					CustomReporting.logReport(ex);
					ex.printStackTrace();
					throw ex;
				}
				
		}
		
	@Test(dataProvider = "DeviceManager")
		
		public void BC_SLIM_CRD_Draft_11A(TestName testName, Device device) throws Exception {
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
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
							tcID);
					CustomReporting.logReport(ex);
					ex.printStackTrace();
					throw ex;
				}
				
		}
		
	@Test(dataProvider = "DeviceManager")
		
		public void BC_SLIM_AS_TAX_Draft_9A(TestName testName, Device device) throws Exception {
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
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
							tcID);
					CustomReporting.logReport(ex);
					ex.printStackTrace();
					throw ex;
				}
				
		}
		
	@Test(dataProvider = "DeviceManager")
		
		public void BC_SLIM_AS_REP_Draft_8A(TestName testName, Device device) throws Exception {
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
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
							tcID);
					CustomReporting.logReport(ex);
					ex.printStackTrace();
					throw ex;
				}
				
		}
		
	@Test(dataProvider = "DeviceManager")
		
		public void BC_SLIM_AS_CON_Draft_7A(TestName testName, Device device) throws Exception {
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
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
							tcID);
					CustomReporting.logReport(ex);
					ex.printStackTrace();
					throw ex;
				}
				
		}
		
	@Test(dataProvider = "DeviceManager")
		
		public void BC_CYB_Draft_5A(TestName testName, Device device) throws Exception {
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
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
							tcID);
					CustomReporting.logReport(ex);
					ex.printStackTrace();
					throw ex;
				}
				
		}
		
	@Test(dataProvider = "DeviceManager")
		
		public void BC_LPL_Draft_4A(TestName testName, Device device) throws Exception {
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
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
							tcID);
					CustomReporting.logReport(ex);
					ex.printStackTrace();
					throw ex;
				}
				
		}


		@Test(dataProvider = "DeviceManager")
		
		public void BC_NFP_Draft_3A(TestName testName, Device device) throws Exception {
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
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
							tcID);
					CustomReporting.logReport(ex);
					ex.printStackTrace();
					throw ex;
				}
				
		}

	@Test(dataProvider = "DeviceManager")
	public void BC_Draft_PRIMARY_SUR_12A(TestName testName, Device device) throws Exception {
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
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
						tcID);
				CustomReporting.logReport(ex);
				ex.printStackTrace();
				throw ex;
			}
			
	}
			
@Test(dataProvider = "DeviceManager")
			
	public void BC_Issuance_PRIMARY_SUR_12B(TestName testName, Device device) throws Exception {
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
						classInvoker.UmSearchSubmission(tcID);
						classInvoker.updateTheCreatedApplication(tcID);
						classInvoker.UmAddingOffice(tcID);
						classInvoker.UmExposures(tcID);
						classInvoker.VerifyTheUpdatedFieldValue(tcID);
						classInvoker.UmRatingSlimCommon(tcID);			
						classInvoker.UmQuoting(tcID);
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
			
		public void BC_QS_SLIM_Primary_SUR_78A(TestName testName, Device device) throws Exception {
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
	public void BC_Issuance_Primary_ENO_6B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.updateTheCreatedApplication(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.VerifyTheUpdatedFieldValue(tcID);
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
	public void BC_Draft_Primary_ENO_6A(TestName testName, Device device) throws Exception {
			String tcID = "";
			try {

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
	public void BC_Draft_Issue_1A(TestName testName, Device device) throws Exception 
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

	public void BC_PCI_Issuance_1B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.updateTheCreatedApplication(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.VerifyTheUpdatedFieldValue(tcID);
			classInvoker.UmQuoting(tcID);
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
	public void BC_EZExcess_Draft_2A(TestName testName, Device device) throws Exception {
			String tcID = "";
			try {
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

	public void BC_EZExcess_Issuance_2B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.updateTheCreatedApplication(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.VerifyTheUpdatedFieldValue(tcID); 
			classInvoker.UmRatingEZExcess(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
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

	public void BC_CYB_Draft_To_Issue_5B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.updateTheCreatedApplication(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.VerifyTheUpdatedFieldValue(tcID); 
			classInvoker.UmQuoting(tcID);
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

	public void BC_LPL_Draft_To_Issue_4B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.updateTheCreatedApplication(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);		
			classInvoker.VerifyTheUpdatedFieldValue(tcID); 
			classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");		
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName); 
			//PC	
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

	public void BC_Slim_POL_Dft_To_Iss_10B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.updateTheCreatedApplication(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.VerifyTheUpdatedFieldValue(tcID); 
			classInvoker.UmRatingSlimCommon(tcID);	
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");		
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName); 
			//PC	
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

	public void BC_Slim_CRD_Dft_To_Iss_11B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.updateTheCreatedApplication(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.VerifyTheUpdatedFieldValue(tcID); 
			classInvoker.UmRatingSlimCommon(tcID);	
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");	
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName); 
			//PC		
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
	public void BC_Slim_TAX_Dft_To_Iss_9B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.updateTheCreatedApplication(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.VerifyTheUpdatedFieldValue(tcID); 
			classInvoker.UmRatingSlimCommon(tcID);	
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted"); 
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued"); 		
			classInvoker.UmSubmissionNumber(tcID);		
			classInvoker.UmClosePage(tcID, DeviceName); 
			//PC
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchSubmission(tcID);		
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

	public void BC_Slim_REP_Dft_To_Iss_8B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.updateTheCreatedApplication(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.VerifyTheUpdatedFieldValue(tcID); 
			classInvoker.UmRatingSlimCommon(tcID);	
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");		
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName); 
			//PC
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

	public void BC_Slim_CON_Dft_To_Iss_7B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.updateTheCreatedApplication(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.VerifyTheUpdatedFieldValue(tcID); 
			classInvoker.UmRatingSlimCommon(tcID);	
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName); 
			//PC
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchSubmission(tcID);		
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
	public void BC_NFP_Dft_To_Issue_3B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.updateTheCreatedApplication(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.VerifyTheUpdatedFieldValue(tcID); 
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName); 
			//PC
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchSubmission(tcID);		
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
	public void BC_PCI_QS_67A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			//PC
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
	public void BC_QS_SLIM_Primary_ENO_72A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);			
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmSubmissionNumber(tcID);
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
	public void BC_PCI_QS_RI_42A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			//PC
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
	public void BC_PCI_QS_PA_43A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			//PC
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
	public void BC_PCI_QS_MT_44A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			//PC
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
	public void BC_PCI_QS_MA_45A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			//PC
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
	public void BC_NFP_QS_RI_46A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void BC_NFP_QS_PA_47A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void BC_NFP_QS_MT_48A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void BC_NFP_QS_MA_49A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}


	@Test(dataProvider = "DeviceManager")
	public void BC_LPL_RI_ENO_QS_50A(TestName testName, Device device) throws Exception 
	{
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
	public void BC_EZExcess_PA_QS_51A(TestName testName, Device device) throws Exception {

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
	public void BC_SLIM_Primary_ENO_QS_52A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);			
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmSubmissionNumber(tcID);
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

	public void BC_SLIM_PRIMARY_SUR_53A(TestName testName, Device device) throws Exception {
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
	public void BC_Slim_POL_QS_54A(TestName testName, Device device) throws Exception {
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
	public void BC_Slim_CRED_QS_55A(TestName testName, Device device) throws Exception {
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
	public void BC_NFP_Cyb_QS_65A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}


	@Test(dataProvider = "DeviceManager")
	public void BC_NFP_All_QS_68A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}



	@Test(dataProvider = "DeviceManager")
	public void BC_NFP_All_Bound_141A(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}



	@Test(dataProvider = "DeviceManager")
	public void BC_NFP_EPL_IssuePol_177A(TestName testName, Device device) throws Exception {
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
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}


	@Test(dataProvider = "DeviceManager")
	public void BC_CYB_IssuePol_178A(TestName testName, Device device) throws Exception {
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
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}


	@Test(dataProvider = "DeviceManager")
	public void BC_LPL_ENO_IssuePol_179A(TestName testName, Device device) throws Exception 
	{
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
	public void BC_Slim_POL_IssuePol_181A(TestName testName, Device device) throws Exception {
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
	public void BC_Slim_CRED_IssuePol_180A(TestName testName, Device device) throws Exception {
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
	public void BC_Slim_AS_Con_IssuePol_183A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSubmissionNumber(tcID);
					classInvoker.UmClosePage(tcID, DeviceName);
					Setup.LoadData();						
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
	public void BC_Slim_AS_REP_IssuePol_184A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSubmissionNumber(tcID);
					classInvoker.UmClosePage(tcID, DeviceName);
					Setup.LoadData();						
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
	public void BC_SLIM_AS_TAX_IssuePol_182A(TestName testName, Device device) throws Exception {
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
	public void BC_CYB_Bound_142A(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}




	@Test(dataProvider = "DeviceManager")
	public void BC_Slim_AS_Con_Bound_146A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSubmissionNumber(tcID);
					classInvoker.UmClosePage(tcID, DeviceName);
					Setup.LoadData();						
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
	public void BC_Slim_AS_REP_Bound_145A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSubmissionNumber(tcID);
					classInvoker.UmClosePage(tcID, DeviceName);
					Setup.LoadData();						
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
	public void BC_Slim_POL_Bound_149A(TestName testName, Device device) throws Exception {
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
	public void BC_Slim_CRED_Bound_147A(TestName testName, Device device) throws Exception {
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
	public void BC_LPL_ENO_Bound_143A(TestName testName, Device device) throws Exception 
	{
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
	public void BC_NFP_CybCriFidEpl_QS_117A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void BC_PCI_CybFID_GenQS_130A(TestName testName, Device device) throws Exception {
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
			classInvoker.UmGenQuote(tcID);
		//	GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")

	public void BC_EZExcess_CybFid_GenQS_131A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmGenQuote(tcID);
		//	GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmSubmissionNumber(tcID);
			classInvoker.UmClosePage(tcID, DeviceName); 
			//PC
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchSubmission(tcID);		
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
	public void BC_Slim_AS_Con_GenQS_134A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmGenQuote(tcID);
				//	GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
					classInvoker.UmSubmissionNumber(tcID);
					classInvoker.UmClosePage(tcID, DeviceName);
					Setup.LoadData();						
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
	public void BC_Slim_AS_REP_GenQS_133A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmGenQuote(tcID);
			//		GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
					classInvoker.UmSubmissionNumber(tcID);
					classInvoker.UmClosePage(tcID, DeviceName);
					Setup.LoadData();						
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
	public void BC_SLIM_AS_TAX_GenQS_132A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmGenQuote(tcID);
				//	GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
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
	public void BC_QS_SLIM_Pri_ENO_GenQS_135A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingSlimCommon(tcID);			
			classInvoker.UmGenQuote(tcID);
		//	GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmSubmissionNumber(tcID);
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
	public void BC_Slim_CRD_GenQS_136A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGenQuote(tcID);
			//	GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
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
	public void BC_NFP_Cyb_Cncl_190A(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

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
			classInvoker.UmExposures(tcID);
			 classInvoker.UmQuoting(tcID);
			 GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			 classInvoker.UmBinding(tcID);
			 GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			 classInvoker.UmIssuance(tcID);		 
			 GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			 classInvoker.UmSubmissionNumber(tcID);
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
			//PC
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchSubmission(tcID);		
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void BC_PCI_Cyb_Cncl_188A(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

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
			classInvoker.UmExposures(tcID);
			 classInvoker.UmQuoting(tcID);
			 GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			 classInvoker.UmBinding(tcID);
			 GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			 classInvoker.UmIssuance(tcID);		 
			 GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			 classInvoker.UmSubmissionNumber(tcID);
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
			//PC
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchSubmission(tcID);		
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")

	public void BC_EZExcess_Cyb_cncl_189A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
			classInvoker.UmRatingEZExcess(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			 classInvoker.UmQuoting(tcID);
			 GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			 classInvoker.UmBinding(tcID);
			 GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			 classInvoker.UmIssuance(tcID);		 
			 GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			 classInvoker.UmSubmissionNumber(tcID);
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
			//PC
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchSubmission(tcID);		
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
	public void BC_Slim_POL_Cncl_193A(TestName testName, Device device) throws Exception {
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
				 classInvoker.UmSubmissionNumber(tcID);
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
				//PC
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchSubmission(tcID);		
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
	public void BC_Slim_CRED_Cncl_192A(TestName testName, Device device) throws Exception {
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
				 classInvoker.UmSubmissionNumber(tcID);
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
				//PC
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchSubmission(tcID);		
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
	public void BC_Slim_AS_Con_Cncl_197A(TestName testName, Device device) throws Exception {
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
					 classInvoker.UmSubmissionNumber(tcID);
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
					//PC
					classInvoker.UmlaunchPage(tcID, DeviceName);
					classInvoker.UmSearchSubmission(tcID);		
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
	public void BC_SLIM_AS_TAX_Cncl_196A(TestName testName, Device device) throws Exception {
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
					 classInvoker.UmSubmissionNumber(tcID);
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
					//PC
					classInvoker.UmlaunchPage(tcID, DeviceName);
					classInvoker.UmSearchSubmission(tcID);		
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
	public void BC_SLIM_PRI_SUR_Cncl_195A(TestName testName, Device device) throws Exception {
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
				 classInvoker.UmSubmissionNumber(tcID);
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
				//PC
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchSubmission(tcID);		
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
	public void BC_SLIM_Pri_ENO_Cncl_194A(TestName testName, Device device) throws Exception 
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
			//PC
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSearchSubmission(tcID);		
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
	public void BC_Slim_CRD_QS_124A(TestName testName, Device device) throws Exception {
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
	public void BC_Slim_POL_QS_73A(TestName testName, Device device) throws Exception {
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
	public void BC_Slim_CRED_QS_74A(TestName testName, Device device) throws Exception {
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
	public void BC_Slim_CRED_QS_85A(TestName testName, Device device) throws Exception {
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




	@Test(dataProvider = "DeviceManager")
	public void BC_SLIM_PRIMARY_SUR_88A(TestName testName, Device device) throws Exception {
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

	public void BC_CYB_QS_TX_59A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void BC_CYB_QS_OK_60A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	@Test(dataProvider = "DeviceManager")
	public void BC_CYB_QS_MT_61A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void BC_CYB_QS_RI_62A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}



	@Test(dataProvider = "DeviceManager")
	public void BC_PCI_CybEmpKnr_QS_79A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void BC_NFP_CybEmpKnr_QS_80A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void BC_Cyb_QS_81A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}


	@Test(dataProvider = "DeviceManager")
	public void BC_Slim_AS_Con_QS_90A(TestName testName, Device device) throws Exception {
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
					Setup.LoadData();						
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
	public void BC_Slim_POL_QS_84A(TestName testName, Device device) throws Exception {
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
	public void BC_NFP_EplCybEno_QS_91A(TestName testName, Device device) throws Exception {
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

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();
		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}


	@Test(dataProvider = "DeviceManager")	
	public void BC_SLIM_AS_TAX_Bound_144A(TestName testName, Device device) throws Exception {
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

	public void BC_SLIM_PRI_Bind_SUR_148A(TestName testName, Device device) throws Exception {
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
	public void BC_LPL_ENO_QS_92A(TestName testName, Device device) throws Exception 
	{
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
	public void BC_Slim_AS_REP_QS_96A(TestName testName, Device device) throws Exception {
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
					Setup.LoadData();						
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
	public void BC_Slim_CRED_QS_102A(TestName testName, Device device) throws Exception {
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

//SHivaraj COde
	
	@Test(dataProvider = "DeviceManager")
	public void TS_BC_PCI_SA_13A(TestName testName, Device device) throws Exception 
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
	public void TS_BC_EZExces_SA_14A(TestName testName, Device device) throws Exception 
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
	public void TS_BC_ENO_SA_18A(TestName testName, Device device) throws Exception 
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
	public void TS_BC_Slim_Surety_SA_24A(TestName testName, Device device) throws Exception 
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
	public void TC_BC_NFP_CreateProposal_26A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
			//classInvoker.UmQuoting(tcID);
			//GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
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
	public void TC_BC_CYB_CreateProposal_25A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
			//classInvoker.UmQuoting(tcID);
			//GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
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
	public void TC_BC_Slim_AS_CreateProposal_34A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
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
	public void TC_BC_PCI_CreateProposal_27A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
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
	public void TC_BC_PCI_CreateProposal_35A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
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
	public void TC_BC_EZExces_CreateProposal_37A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
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
	public void TC_BC_Slim_Credit_CreateProposal_30A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
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
	public void TC_BC_LPL_CreateProposal_29A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
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
	public void TC_BC_Slim_FI_CreateProposal_40A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
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
	public void TC_BC_Slim_SUR_CreateProposal_41A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmExposures(tcID);
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
	public void TS_BC_LPL_EPO_Issue_223A(TestName testName, Device device) throws Exception 
	{
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
			//classInvoker.UmRatingLPLNonAdmitted(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//			classInvoker.UmSubmissionNumber(tcID);
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
	public void TS_BC_EZExcess_Issue_224A(TestName testName, Device device) throws Exception {
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
	
	//R3B Smoke Scenarios
	@Test(dataProvider = "DeviceManager")
	public void TS_BC_CON_Issue_233A(TestName testName, Device device) throws Exception {
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
	
	@Test(dataProvider = "DeviceManager")
	public void TS_BC_CRD_CREDIT_Issue_234A(TestName testName, Device device) throws Exception {
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
		public void TS_BC_PCI_ALL_Issue_235A(TestName testName, Device device) throws Exception {
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
				////classInvoker.UmCallingCov(tcID);
				classInvoker.UmQuoting(tcID);
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
		public void TS_BC_EZExcess_ALL_Issue_236A(TestName testName, Device device) throws Exception {
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
//				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_Slim_REP_Issue_221A(TestName testName, Device device) throws Exception {
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
		public void TS_BC_Slim_CRD_POL_Issue_222A(TestName testName, Device device) throws Exception {
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
		
		// R2 Test cases
		// R2 Smoke Test cases
		@Test(dataProvider = "DeviceManager")
		public void TS_BC_PCI_DNO_EMP_GateRate_163A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGetRate(tcID);
				
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
		public void TS_BC_EZExc_DNO_EMP_GR_167A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGetRate(tcID);
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
		public void TS_BC_LPL_ENO_GR_155A(TestName testName, Device device) throws Exception 
		{
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
				classInvoker.UmGetRate(tcID);
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
		public void TS_BC_FI_ENO_GR_160A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGetRate(tcID);
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
		
		//R3B Smoke Scenarios
		@Test(dataProvider = "DeviceManager")
		public void TS_BC_CON_GR_158A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmGetRate(tcID);
					
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
		
		//R3B Smoke Scenarios
				@Test(dataProvider = "DeviceManager")
				public void TS_BC_CON_GR_173A(TestName testName, Device device) throws Exception {
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
							classInvoker.UmGetRate(tcID);
							
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
		public void TS_BC_REP_GR_157A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGetRate(tcID);
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
		public void TS_BC_REP_GR_174A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGetRate(tcID);
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
		public void TS_BC_NFP_GR_151A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGetRate(tcID);
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
		public void TS_BC_CYB_GR_152A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGetRate(tcID);
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
		public void TS_BC_SUR_GR_161A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmGetRate(tcID);
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
		public void TS_BC_POL_GR_162A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGetRate(tcID);
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
		public void TS_BC_LPL_SA_16A(TestName testName, Device device) throws Exception 
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
		public void TS_BC_NFP_SA_15A(TestName testName, Device device) throws Exception 
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
		public void TS_BC_CYB_SA_17A(TestName testName, Device device) throws Exception 
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
		public void TS_BC_CON_SA_19A(TestName testName, Device device) throws Exception 
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
		public void TS_BC_REP_SA_20A(TestName testName, Device device) throws Exception 
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
		public void TS_BC_TAX_SA_21A(TestName testName, Device device) throws Exception 
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
		public void TS_BC_CRD_SA_23A(TestName testName, Device device) throws Exception 
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
		public void TS_BC_POL_SA_22A(TestName testName, Device device) throws Exception 
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
		public void TC_BC_PCI_CP_27A(TestName testName, Device device) throws Exception 
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
				classInvoker.UmExposures(tcID);
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
		public void TC_BC_EZExces_CP_28A(TestName testName, Device device) throws Exception 
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
				classInvoker.UmExposures(tcID);
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
		public void TC_BC_LPL_CP_36A(TestName testName, Device device) throws Exception 
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
				classInvoker.UmExposures(tcID);
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
		public void TC_BC_CRD_CP_31A(TestName testName, Device device) throws Exception {
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
		public void TC_BC_REP_CP_32A(TestName testName, Device device) throws Exception {
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
		public void TC_BC_TAX_CP_33A(TestName testName, Device device) throws Exception {
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
		public void TC_BC_NFP_CP_39A(TestName testName, Device device) throws Exception 
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
				classInvoker.UmExposures(tcID);

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
		
		
		// R2 Test cases
		// R2 Smoke Test cases
		@Test(dataProvider = "DeviceManager")
		public void TC_BC_PCI_GR_153A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGetRate(tcID);
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
		public void TC_BC_EZExce_GR_154A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGetRate(tcID);
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
		public void TC_BC_TAX_GR_156A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmGetRate(tcID);
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
		public void TC_BC_CRD_GR_159A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmGetRate(tcID);
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
		public void TS_BC_NFP_GR_164A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGetRate(tcID);
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
		public void TC_BC_CYB_CP_38A(TestName testName, Device device) throws Exception 
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
				classInvoker.UmExposures(tcID);
				//classInvoker.UmQuoting(tcID);
				//GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
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
		public void TS_BC_CYB_GR_165A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGetRate(tcID);
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
		public void TC_BC_LPL_CP_166A(TestName testName, Device device) throws Exception 
		{
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
				classInvoker.UmGetRate(tcID);
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
		public void TC_BC_CRD_GR_170A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmGetRate(tcID);
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
		public void TS_BC_FI_ENO_GR_168A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGetRate(tcID);
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
		public void TS_BC_SUR_GR_169A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmGetRate(tcID);
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
		public void TS_BC_POL_GR_171A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmGetRate(tcID);
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
		public void TS_BC_TAX_GR_172A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmGetRate(tcID);
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
		public void TS_BC_NFP_Issue_225A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmQuoting(tcID);
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
		
		// R2 Test cases
		// R2 Smoke Test cases
		@Test(dataProvider = "DeviceManager")
		public void TS_BC_PCI_Issue_226A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_CYB_Issue_227A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmQuoting(tcID);
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
		public void TS_BC_POL_Issue_228A(TestName testName, Device device) throws Exception {
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
		public void TS_BC_ENO_Issue_229A(TestName testName, Device device) throws Exception {
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
		
		@Test(dataProvider = "DeviceManager")
		public void TS_BC_SUR_Issue_230A(TestName testName, Device device) throws Exception {
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
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_REP_Issue_231A(TestName testName, Device device) throws Exception {
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
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_TAX_Issue_232A(TestName testName, Device device) throws Exception {
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
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_CON_Issue_244A(TestName testName, Device device) throws Exception {
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
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_LPL_Issue_237A(TestName testName, Device device) throws Exception 
		{
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
				//classInvoker.UmRatingLPLNonAdmitted(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
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
		
		@Test(dataProvider = "DeviceManager")
		public void TS_BC_CYB_Issue_238A(TestName testName, Device device) throws Exception {
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
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_NFP_Issue_239A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmQuoting(tcID);
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
		public void TS_BC_ENO_Issue_240A(TestName testName, Device device) throws Exception {
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
		
		
		@Test(dataProvider = "DeviceManager")
		public void TS_BC_SUR_Issue_241A(TestName testName, Device device) throws Exception {
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
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_CRD_Issue_242A(TestName testName, Device device) throws Exception {
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
		public void TS_BC_CRD_Issue_216A(TestName testName, Device device) throws Exception {
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
		public void TS_BC_TAX_Issue_243A(TestName testName, Device device) throws Exception {
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
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_REP_Issue_245A(TestName testName, Device device) throws Exception {
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
		public void TS_BC_LPL_Issue_213A(TestName testName, Device device) throws Exception 
		{
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
		
		@Test(dataProvider = "DeviceManager")
		public void TS_BC_NFP_Issue_214A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmQuoting(tcID);
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
		public void TS_BC_PCI_ALL_Issue_215A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
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
		
		@Test(dataProvider = "DeviceManager")
		public void TS_BC_POL_Issue_217A(TestName testName, Device device) throws Exception {
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
		public void TS_BC_ENO_Issue_218A(TestName testName, Device device) throws Exception {
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
		public void TS_BC_SUR_Issue_219A(TestName testName, Device device) throws Exception {
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
		public void TS_BC_REP_Issue_221A(TestName testName, Device device) throws Exception {
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
		public void TS_BC_TAX_Issue_222A(TestName testName, Device device) throws Exception {
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
		public void TS_BC_CYB_IssueCancel_200A(TestName testName, Device device) throws Exception {
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
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PCI_IssueCancel_201A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_EZExc_IssueCancel_202A(TestName testName, Device device) throws Exception {
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
				    classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_NFP_IssueCancel_203A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_CRD_IssueCancel_204A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_POL_IssueCancel_205A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_FI_ENO_IssueCancel_206A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_SUR_IssueCancel_207A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_REP_IssueCancel_209A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_CON_Issue_220A(TestName testName, Device device) throws Exception {
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
		public void TS_BC_CON_IssueCancel_208A(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_POL_Issue_246A(TestName testName, Device device) throws Exception {
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
				//classInvoker.UmCallingCov(tcID);
				classInvoker.UmQuoting(tcID);
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
		
//@@@@@@@@@@@@@@@@@@@@@@@Part B Test scripts@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
		@Test(dataProvider = "DeviceManager")
		public void TS_BC_PCI_EditSub_Issue_13B(TestName testName, Device device) throws Exception 
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.update_Exposure(tcID);
				
				//classInvoker.UmExposures(tcID);
				//classInvoker.UmCallingCov(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
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
		public void TS_BC_EzExc_EditSub_Issue_14B(TestName testName, Device device) throws Exception 
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.update_Exposure(tcID);
				classInvoker.UmRatingEZExcess(tcID);
		
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
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
		public void TS_BC_NPF_EditSub_Issue_15B(TestName testName, Device device) throws Exception 
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.update_Exposure(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
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
		public void TS_BC_LPL_EditSub_Issue_16B(TestName testName, Device device) throws Exception 
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.update_Exposure(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				
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
		public void TS_BC_CYB_EditSub_Issue_17B(TestName testName, Device device) throws Exception 
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.update_Exposure(tcID);
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
		public void TS_BC_ENO_EditSub_Issue_18B(TestName testName, Device device) throws Exception 
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
				classInvoker.UmSearchSubmission(tcID);
				//classInvoker.edit_UmSubmissionDetails(tcID);
				//classInvoker.update_Exposure(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				
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
		public void TS_BC_CON_EditSub_Issue_19B(TestName testName, Device device) throws Exception 
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.update_Exposure(tcID);
				classInvoker.UmRatingSlimCommon(tcID);			
				
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				
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
		public void TS_BC_REP_EditSub_Issue_20B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.update_Exposure(tcID);
				classInvoker.UmRatingSlimCommon(tcID);			
				classInvoker.UmQuoting(tcID);
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
		public void TS_BC_TAX_EditSub_Issue_21B(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSearchSubmission(tcID);
					classInvoker.edit_UmSubmissionDetails(tcID);
					classInvoker.update_Exposure(tcID);
					classInvoker.UmRatingSlimCommon(tcID);		
							
					classInvoker.UmQuoting(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
					classInvoker.UmBinding(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Bound");
					classInvoker.UmIssuance(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_POL_EditSub_Issue_22B(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSearchSubmission(tcID);
					classInvoker.edit_UmSubmissionDetails(tcID);
					classInvoker.update_Exposure(tcID);
					classInvoker.UmRatingSlimCommon(tcID);		
					classInvoker.UmQuoting(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
					classInvoker.UmBinding(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Bound");
					classInvoker.UmIssuance(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_CRD_EditSub_Issue_23B(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSearchSubmission(tcID);
					classInvoker.edit_UmSubmissionDetails(tcID);
					classInvoker.update_Exposure(tcID);
					classInvoker.UmRatingSlimCommon(tcID);					
					classInvoker.UmQuoting(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
					classInvoker.UmBinding(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Bound");
					classInvoker.UmIssuance(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_SUR_EditSub_Issue_24B(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSearchSubmission(tcID);
					classInvoker.edit_UmSubmissionDetails(tcID);
					classInvoker.update_Exposure(tcID);
					classInvoker.UmRatingSlimCommon(tcID);					
					classInvoker.UmQuoting(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
					classInvoker.UmBinding(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Bound");
					classInvoker.UmIssuance(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_CYB_EditSub_Issue_25B(TestName testName, Device device) throws Exception 
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				//classInvoker.update_Exposure(tcID);
				classInvoker.UmCallingCov(tcID);
				//classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				
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
		public void TS_BC_NFP_EditSub_Issue_26B(TestName testName, Device device) throws Exception 
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				//classInvoker.update_Exposure(tcID);
				classInvoker.expendCoverages(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				
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
		public void TS_BC_PCI_EditSub_Issue_27B(TestName testName, Device device) throws Exception 
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
				classInvoker.UmSearchSubmission(tcID);
		/*		classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.EditExposureInformation(tcID);*/
				classInvoker.UmClickGetRater(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				
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
		public void TS_BC_EZExc_EditSub_Issue_28B(TestName testName, Device device) throws Exception 
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmRatingEZExcess(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				
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
		public void TS_BC_LPL_EditSub_Issue_29B(TestName testName, Device device) throws Exception 
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				
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
		public void TS_BC_POL_EditSub_Issue_30B(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSearchSubmission(tcID);
					//classInvoker.edit_UmSubmissionDetails(tcID);
					//classInvoker.update_Exposure(tcID);
					//classInvoker.UmRatingSlimCommon(tcID);		
					/*classInvoker.UmQuoting(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Quoted")*/;
					//classInvoker.verify_UmSubmissionDetails(tcID);;
					classInvoker.UmBinding(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Bound");
					classInvoker.UmIssuance(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_SUR_EditSub_Issue_31B(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSearchSubmission(tcID);
					classInvoker.edit_UmSubmissionDetails(tcID);
					classInvoker.update_Exposure(tcID);
					classInvoker.UmRatingSlimCommon(tcID);		
					classInvoker.UmQuoting(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
					//classInvoker.verify_UmSubmissionDetails(tcID);
					classInvoker.UmBinding(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Bound");
					classInvoker.UmIssuance(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_REP_EditSub_Issue_32B(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSearchSubmission(tcID);
					classInvoker.edit_UmSubmissionDetails(tcID);
					classInvoker.update_Exposure(tcID);
					classInvoker.UmRatingSlimCommon(tcID);		
					classInvoker.UmQuoting(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
					//classInvoker.verify_UmSubmissionDetails(tcID);;
					classInvoker.UmBinding(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Bound");
					classInvoker.UmIssuance(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_TAX_EditSub_Issue_33B(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSearchSubmission(tcID);
					classInvoker.edit_UmSubmissionDetails(tcID);
					classInvoker.update_Exposure(tcID);
					classInvoker.UmRatingSlimCommon(tcID);		
					classInvoker.UmQuoting(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
					//classInvoker.verify_UmSubmissionDetails(tcID);;
					classInvoker.UmBinding(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Bound");
					classInvoker.UmIssuance(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_CON_EditSub_Issue_34B(TestName testName, Device device) throws Exception {
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
					classInvoker.UmSearchSubmission(tcID);
					classInvoker.edit_UmSubmissionDetails(tcID);
					classInvoker.UmRatingSlimCommon(tcID);		
					classInvoker.UmQuoting(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
					//classInvoker.verify_UmSubmissionDetails(tcID);
					classInvoker.UmBinding(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Bound");
					classInvoker.UmIssuance(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//					classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PCI_EditSub_Issue_35B(TestName testName, Device device) throws Exception {
				String tcID = "";
				try {

					SoftAssert softAssert = new SoftAssert();
					tcID = getTestName(testName);
					String DeviceName = getDeviceName(testName);
					String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
					GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

					PageImplInvoker classInvoker = new PageImplInvoker();
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
					//UM
					classInvoker.UmlaunchPage(tcID, DeviceName);
					classInvoker.UmSearchSubmission(tcID);
					classInvoker.edit_UmSubmissionDetails(tcID);
					//classInvoker.update_Exposure(tcID);
					classInvoker.expendCoverages(tcID);
					classInvoker.UmQuoting(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
					//classInvoker.verify_UmSubmissionDetails(tcID);
					
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
		public void TS_BC_LPL_EditSub_Issue_36B(TestName testName, Device device) throws Exception {
				String tcID = "";
				try {

					SoftAssert softAssert = new SoftAssert();
					tcID = getTestName(testName);
					String DeviceName = getDeviceName(testName);
					String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
					GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

					PageImplInvoker classInvoker = new PageImplInvoker();
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
					//UM
					classInvoker.UmlaunchPage(tcID, DeviceName);
					classInvoker.UmSearchSubmission(tcID);
					classInvoker.edit_UmSubmissionDetails(tcID);
					classInvoker.expendCoverages(tcID);
					classInvoker.UmRatingLPLNonAdmitted(tcID);

					classInvoker.UmQuoting(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
					//classInvoker.verify_UmSubmissionDetails(tcID);
					
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
		public void TS_BC_EZExc_EditSub_Issue_37B(TestName testName, Device device) throws Exception {
				String tcID = "";
				try {

					SoftAssert softAssert = new SoftAssert();
					tcID = getTestName(testName);
					String DeviceName = getDeviceName(testName);
					String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
					GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

					PageImplInvoker classInvoker = new PageImplInvoker();
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
					//UM
					classInvoker.UmlaunchPage(tcID, DeviceName);
					classInvoker.UmSearchSubmission(tcID);
					//classInvoker.edit_UmSubmissionDetails(tcID);
					classInvoker.expendCoverages(tcID);
					classInvoker.UmRatingEZExcess(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
					//classInvoker.verify_UmSubmissionDetails(tcID);
					
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
		public void TS_BC_CYB_EditSub_Issue_38B(TestName testName, Device device) throws Exception {
				String tcID = "";
				try {

					SoftAssert softAssert = new SoftAssert();
					tcID = getTestName(testName);
					String DeviceName = getDeviceName(testName);
					String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
					GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

					PageImplInvoker classInvoker = new PageImplInvoker();
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
					//UM
					classInvoker.UmlaunchPage(tcID, DeviceName);
					classInvoker.UmSearchSubmission(tcID);
					classInvoker.edit_UmSubmissionDetails(tcID);
					classInvoker.expendCoverages(tcID);
					classInvoker.UmQuoting(tcID);
					GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
					//classInvoker.verify_UmSubmissionDetails(tcID);
					
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
		public void TS_BC_NFP_EditSub_Issue_39B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.update_Exposure(tcID);
				classInvoker.expendCoverages(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			
				classInvoker.UmClosePage(tcID, DeviceName);
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
						tcID);
				softAssert.assertAll();

			} 
			catch (Exception ex)
			{
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
						tcID);
				CustomReporting.logReport(ex);
				ex.printStackTrace();
				throw ex;
			}
		}
		
		@Test(dataProvider = "DeviceManager")
		public void TS_BC_ENO_EditSub_Issue_40B(TestName testName, Device device) throws Exception 
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.update_Exposure(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				
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
		public void TS_BC_SUR_EditSub_Issue_41B(TestName testName, Device device) throws Exception 
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.update_Exposure(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				
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
		public void TS_BC_NFP_EditSub_Issue_151B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.expendCoverages(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			
				classInvoker.UmClosePage(tcID, DeviceName);
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
						tcID);
				softAssert.assertAll();

			} 
			catch (Exception ex)
			{
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
						tcID);
				CustomReporting.logReport(ex);
				ex.printStackTrace();
				throw ex;
			}
		}
		
		@Test(dataProvider = "DeviceManager")
		public void TS_BC_CYB_EditSub_Issue_152B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.expendCoverages(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			
				classInvoker.UmClosePage(tcID, DeviceName);
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
						tcID);
				softAssert.assertAll();

			} 
			catch (Exception ex)
			{
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
						tcID);
				CustomReporting.logReport(ex);
				ex.printStackTrace();
				throw ex;
			}
		}

		@Test(dataProvider = "DeviceManager")
		public void TS_BC_PCI_EditSub_Issue_153B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.expendCoverages(tcID);
				classInvoker.UmCallingCov(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
//				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PCI_ALL_REN_235B(TestName testName, Device device) throws Exception {
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
				classInvoker.verify_UMPolicy_Renewaval(tcID);
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
		public void TS_BC_EZEx_ALL_REN_236B(TestName testName, Device device) throws Exception {
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
				classInvoker.verify_UMPolicy_Renewaval(tcID);
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
		public void TS_BC_LPL_Rew_237B(TestName testName, Device device) throws Exception 
		{
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
				//classInvoker.UmRatingLPLNonAdmitted(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				classInvoker.verify_UMPolicy_Renewaval(tcID);
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
		public void TS_BC_CYB_REN_238B(TestName testName, Device device) throws Exception {
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
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				classInvoker.verify_UMPolicy_Renewaval(tcID);
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
		public void TS_BC_NFP_REN_239B(TestName testName, Device device) throws Exception {
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
				classInvoker.verify_UMPolicy_Renewaval(tcID);
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
		public void TS_BC_ENO_REN_240B(TestName testName, Device device) throws Exception {
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
				classInvoker.verify_UMPolicy_Renewaval(tcID);
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
		public void TS_BC_SUR_REN_241B(TestName testName, Device device) throws Exception {
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
					classInvoker.verify_UMPolicy_Renewaval(tcID);
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
		public void TS_BC_CRD_REN_242B(TestName testName, Device device) throws Exception {
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
				classInvoker.verify_UMPolicy_Renewaval(tcID);
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
		public void TS_BC_TAX_REN_243B(TestName testName, Device device) throws Exception {
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
					classInvoker.verify_UMPolicy_Renewaval(tcID);
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
		public void TS_BC_CON_REN_244B(TestName testName, Device device) throws Exception {
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
					classInvoker.verify_UMPolicy_Renewaval(tcID);
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
		public void TS_BC_REP_REN_245B(TestName testName, Device device) throws Exception {
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
				//classInvoker.UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);			
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				classInvoker.verify_UMPolicy_Renewaval(tcID);
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
		public void TS_BC_POL_REN_246B(TestName testName, Device device) throws Exception {
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
				//classInvoker.UmCallingCov(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				classInvoker.verify_UMPolicy_Renewaval(tcID);
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

//-------------------------------------------------------------------------------------------------------------------------------------------
		
		

		@Test(dataProvider = "DeviceManager")
		public void BC_SLIM_AS_TAX_Rewrite_196B(TestName testName, Device device) throws Exception {
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
		public void BC_PCI_MarkAsLost_67B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.MarkAsLost(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
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
		public void BC_NFP_Dcln_68B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmDecline(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
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

		@Test(dataProvider = "DeviceManager")
		public void TS_BC_CYB_Dcln_69B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmDecline(tcID);
				classInvoker.UmClosePage(tcID, DeviceName); 
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

		@Test(dataProvider = "DeviceManager")
		public void TS_BC_LPL_MrkAsLost_70B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.MarkAsLost(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
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
		public void TS_BC_EZExcess_Pack_MrkAsLost_71B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.MarkAsLost(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
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
		public void BC_SLIM_Pri_ENO_Dcln_72B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmDecline(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
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

		@Test(dataProvider = "DeviceManager")
		public void BC_Slim_POL_MarkAsLost_73B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.MarkAsLost(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
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
		public void BC_Slim_CRED_MarkAsLost_74B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.MarkAsLost(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
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
		public void TS_BC_PriREP_MrkAsLost_75B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.MarkAsLost(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
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
		public void TS_BC_PriTAX_Dcln_76B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmDecline(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				
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

		@Test(dataProvider = "DeviceManager")
		public void TS_BC_PriCON_Dcln_77B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmDecline(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				
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

		@Test(dataProvider = "DeviceManager")
		public void BC_SLIM_Pri_SUR_Dcln_78B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmDecline(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
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

		@Test(dataProvider = "DeviceManager")

		public void BC_Slim_AS_REP_Issue_145b(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
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

		public void BC_Slim_POL_Issue_149B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
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

		public void TS_BC_Pri_ENO_Issue_150B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
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

		public void BC_Slim_CRED_Issue_147B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
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

		public void BC_LPL_ENO_Issue_143B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
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

		public void BC_SLIM_PRI_Issue_SUR_148B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
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

		public void BC_SLIM_AS_TAX_Issue_144B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
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

		public void BC_CYB_Issue_142B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
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

		public void TS_BC_EZExcess_Pack_Issue_140B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
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

		public void TS_BC_PCI_Pack_Issue_139B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
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

		public void BC_NFP_All_Issue_141B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
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

		public void BC_Slim_AS_Con_Issue_146B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
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

		public void BC_NFP_EPL_ChngPol_177B(TestName testName, Device device) throws Exception {
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

		public void TS_BC_PCI_ChngPol_EPL_175B(TestName testName, Device device) throws Exception {
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

		public void TS_BC_EZExcess_ChngPol_EPL_176B(TestName testName, Device device) throws Exception {
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

		public void BC_CYB_ChngPol_178B(TestName testName, Device device) throws Exception {
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

		public void BC_LPL_ENO_ChngPol_179B(TestName testName, Device device) throws Exception {
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

		public void BC_Slim_CRED_ChngPol_180B(TestName testName, Device device) throws Exception {
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

		public void BC_Slim_POL_ChngPol_181B(TestName testName, Device device) throws Exception {
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

		public void BC_SLIM_AS_TAX_ChngPol_182B(TestName testName, Device device) throws Exception {
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

		public void BC_Slim_AS_Con_ChngPol_183B(TestName testName, Device device) throws Exception {
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

		public void BC_Slim_AS_REP_ChngPol_184B(TestName testName, Device device) throws Exception {
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

		public void TS_BC_Pri_ENO_ChngPol_185B(TestName testName, Device device) throws Exception {
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

		public void TS_BC_ChngPol_PriComSur_186B(TestName testName, Device device) throws Exception {
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
		public void BC_PCI_Issue_RI_42B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void BC_PCI_Issue_PA_43B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void BC_PCI_Issue_MT_44B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void BC_PCI_Issue_MA_45B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void BC_NFP_Issue_RI_46B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void BC_NFP_Issue_PA_47B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void BC_NFP_Issue_MT_48B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void BC_NFP_Issue_MA_49B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void BC_LPL_RI_ENO_Issue_50B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void BC_CYB_Issue_TX_59B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void BC_CYB_Issue_OK_60B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void BC_CYB_Issue_RI_62B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void BC_CYB_Issue_MT_61B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void TS_BC_PCI_Issue_63B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void BC_NFP_Cyb_Issue_65B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void TS_BC_LPL_QtIss_64B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void TS_BC_EZEx_Cyb_QtIss_66B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmValidateRatingCommon(tcID);
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
		public void BC_PCI_Cyb_Reinstate_188B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_CYB_Reinstate_187B(TestName testName, Device device) throws Exception {
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
		public void BC_EZExcess_Cyb_Reinstate_189B(TestName testName, Device device) throws Exception {
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
		public void BC_NFP_Cyb_Reinstate_190B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_LPL_Reinstate_191B(TestName testName, Device device) throws Exception {
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
		public void BC_Slim_CRED_Reinstate_192B(TestName testName, Device device) throws Exception {
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
		public void BC_Slim_POL_Reinstate_193B(TestName testName, Device device) throws Exception {
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
		public void BC_SLIM_Pri_ENO_Reinstate_194B(TestName testName, Device device) throws Exception {
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
		public void BC_SLIM_PRI_SUR_Reinstate_195B(TestName testName, Device device) throws Exception {
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
		public void BC_SLIM_AS_TAX_Reinstate_196B(TestName testName, Device device) throws Exception {
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
		public void BC_Slim_AS_Con_Reinstate_197B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_PriREP_Reinstate_198B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_LPL_Issue_82B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.EditExposureInformation(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.VerifyExposureInformation(tcID);
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_EZExcess_Issue_83B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.EditExposureInformation(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.VerifyExposureInformation(tcID);
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PriREP_Issue_86B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.EditExposureInformation(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.VerifyExposureInformation(tcID);
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PriTAX_Issue_87B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.EditExposureInformation(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.VerifyExposureInformation(tcID);
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_PCI_CybEmpKnr_Iss_79B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.EditExposureInformation(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.VerifyExposureInformation(tcID);
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_NFP_CybEmpKnr_Iss_80B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.EditExposureInformation(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.VerifyExposureInformation(tcID);
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_Cyb_Issue_81B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.EditExposureInformation(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.VerifyExposureInformation(tcID);
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_Slim_AS_Con_Issue_90B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.EditExposureInformation(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.VerifyExposureInformation(tcID);
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_BC_Slim_CRED_issue_85B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.EditExposureInformation(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.VerifyExposureInformation(tcID);
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_Slim_POL_Issue_84B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.EditExposureInformation(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.VerifyExposureInformation(tcID);
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_SLIM_PRI_SUR_Issue_88B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.EditExposureInformation(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.VerifyExposureInformation(tcID);
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PriENO_Iss_89B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.EditExposureInformation(tcID);
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.VerifyExposureInformation(tcID);
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_NFP_EplCybEno_Iss_91B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmCreateProposal(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_LPL_ENO_Iss_92B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmCreateProposal(tcID);
				classInvoker.UmRatingLPLNonAdmitted(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PCI_Iss_93B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmCreateProposal(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_CYB_Iss_94B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmCreateProposal(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_Slim_AS_REP_CS_Iss_108B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "Full");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_EZExcess_CS_Iss_107B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "Full");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingEZExcess(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_CYB_CS_Iss_106B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "Full");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PCI_CS_Iss_105A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "Full");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_LPL_CS_Iss_104B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "Full");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingLPLNonAdmitted(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_NFP_CS_Iss_103B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "Full");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PriTAX_CS_Iss_109B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "Full");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PriCON_CS_Iss_110B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "Full");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PriENO_CS_Iss_111B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "Full");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_Pri_PRE_CS_Iss_112B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "Full");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_CRD_CS_Iss_113B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "Full");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PriSur_CS_Iss_114B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "Full");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PriSur_CSApp_Iss_125B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "ApplicationOnly");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				Setup.LoadData();
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound"); 
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PriPOL_CSAPP_Iss_126B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "ApplicationOnly");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_SlimCRD_CSAPP_Iss_124B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "ApplicationOnly");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PriENO_CSAPP_Iss_123B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "ApplicationOnly");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PriCON_CSAPP_Iss_122B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "ApplicationOnly");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_SlimAsREP_CSApp_Iss_121B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "ApplicationOnly");
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PriTAX_CSAPP_Iss_120B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "ApplicationOnly");
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingSlimCommon(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_EZExcess_CS_Iss_119B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "ApplicationOnly");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingEZExcess(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_LPL_CSAPP_Iss_118B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "ApplicationOnly");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				Setup.LoadData();
				classInvoker.UmExposures(tcID);
				classInvoker.UmRatingLPLNonAdmitted(tcID);
				classInvoker.UmQuoting(tcID);
				Setup.LoadData();
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_NFP_CSAPP_Iss_117B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "ApplicationOnly");
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmQuoting(tcID);
				Setup.LoadData();
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_CYB_CSAPP_Iss_116B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "ApplicationOnly");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PCI_CSAPP_Iss_115B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.UmCopySubmission(tcID, "ApplicationOnly");
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmAddingOffice(tcID);
				classInvoker.UmExposures(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				classInvoker.UmBinding(tcID);
				//classInvoker.verify_UmSubmissionDetails(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_LPL_ReInstFC_199B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_CYB_ReInstFC_200B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_PCI_ReInstFC_201B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_EZExc_ReInstFC_202B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_NFP_ReInstFC_203B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_CRD_ReInstFC_204B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_POL_ReInstFC_205B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_FI_ENO_ReInstFC_206B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_SUR_ReInstFC_207B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_CON_ReInstFC_208B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_REP_ReInstFC_209B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_Pri_TAX_ReInstFC_210B(TestName testName, Device device) throws Exception {
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
		public void TS_BC_PriSur_QG_Iss_137B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_Slim_CRD_GQ_Iss_136B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_SLIM_PriENO_GQ_Iss_135B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_Slim_ASCon_GQ_Iss_134B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_Slim_AS_REP_GQ_Iss_133B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_SLIM_AS_TAX_GQ_Iss_132B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_EZExCybFid_Iss_131B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();				
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_PCI_CybFID_GQ_Iss_130B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();		
				classInvoker.UmGetRate(tcID); 		
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_LPL_GQ_Iss_129B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_CYB_GQ_Iss_128B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_NFP_GQ_Iss_127B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_PriPRN_GQIss_138B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
	
	public void TC_BC_EZExce_GRIss_154B(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.edit_UmSubmissionDetails(tcID);
			Setup.LoadData();				
            classInvoker.UmClickGetRater(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			classInvoker.verify_UmSubmissionDetails(tcID);
			Setup.LoadData();
			classInvoker.UmBinding(tcID);		
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmSubmissionNumber(tcID);
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
	public void TS_BC_LPL_ENO_GRIss_155B(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.edit_UmSubmissionDetails(tcID);
			classInvoker.UmClickGetRater(tcID);
			Setup.LoadData();
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.verify_UmSubmissionDetails(tcID);
			classInvoker.UmBinding(tcID);		
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmSubmissionNumber(tcID);
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
	public void TC_BC_TAX_GRIss_156B(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.edit_UmSubmissionDetails(tcID);
			classInvoker.UmClickGetRater(tcID);
			Setup.LoadData();
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.verify_UmSubmissionDetails(tcID);
			classInvoker.UmBinding(tcID);		
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmSubmissionNumber(tcID);
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
	public void TS_BC_REP_GRIss_157B(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.edit_UmSubmissionDetails(tcID);
			classInvoker.UmClickGetRater(tcID);
			Setup.LoadData();
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.verify_UmSubmissionDetails(tcID); 
			classInvoker.UmBinding(tcID);		
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmSubmissionNumber(tcID);
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
	public void TS_BC_CON_GRIss_158B(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.edit_UmSubmissionDetails(tcID);
			classInvoker.UmClickGetRater(tcID);
			Setup.LoadData();
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.verify_UmSubmissionDetails(tcID);
			classInvoker.UmBinding(tcID);		
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmSubmissionNumber(tcID);
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
	public void TC_BC_CRD_GRIss_159B(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSearchSubmission(tcID);
		     classInvoker.edit_UmSubmissionDetails(tcID);
			classInvoker.UmClickGetRater(tcID);
			Setup.LoadData();
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.verify_UmSubmissionDetails(tcID); 
			classInvoker.UmBinding(tcID);		
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmSubmissionNumber(tcID);
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
	public void TS_BC_FI_ENO_GRIss_160B(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.edit_UmSubmissionDetails(tcID);
			classInvoker.UmClickGetRater(tcID);
			Setup.LoadData();
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.verify_UmSubmissionDetails(tcID);
			classInvoker.UmBinding(tcID);		
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmSubmissionNumber(tcID);
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
	public void TS_BC_SUR_GRIss_161B(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.edit_UmSubmissionDetails(tcID);
			Setup.LoadData();
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.verify_UmSubmissionDetails(tcID);
			classInvoker.UmBinding(tcID);		
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmSubmissionNumber(tcID);
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
	public void TS_BC_POL_GRIss_162B(TestName testName, Device device) throws Exception {
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
			classInvoker.UmSearchSubmission(tcID);
			classInvoker.edit_UmSubmissionDetails(tcID);
			Setup.LoadData();
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.verify_UmSubmissionDetails(tcID);
			classInvoker.UmBinding(tcID);		
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			classInvoker.UmIssuance(tcID);
			classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_Slim_CRD_POL_IssFC_222B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_Slim_REP_IssFC_221B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_CON_IssFC_220B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_SUR_IssFC_219B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_ENO_IssFC_218B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_POL_IssFC_217B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_CRD_IssFC_216B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_PCI_IssFC_215B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_NFP_IssFC_214B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_LPL_IssFC_213B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_EZExces_IssFC_212B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_CYB_IsSFC_211B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_CRD_PRCncl_234B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_CON_PRCncl_233B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_TAX_PRCncl_232B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_REP_PRCncl_231B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_SUR_PRCncl_230B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_ENO_PRCncl_229B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_POL_PRCncl_228B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_CYB_PRCncl_227B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_PCI_PRCncl_226B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_NFP_PRCncl_225B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_EZEx_PRCncl_224B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		public void TS_BC_LPL_EPO_PRCncl_223B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmlaunchPage(tcID, DeviceName);
				classInvoker.UmSearchPolicy(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Cancelled");
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
		
		public void TS_BC_PCI_DE_GRIss_163B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();	
				classInvoker.UmClickGetRater(tcID);
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				//classInvoker.verify_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_NFP_GRIss_164B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmClickGetRater(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_CYB_GRIss_165B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TC_BC_LPL_ENO_GRIss_166B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				classInvoker.UmClickGetRater(tcID);
			//	classInvoker.UmCallingCov(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_EZExc_DE_GRIss_167B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_FI_ENO_GRIss_168B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_SUR_GRIss_169B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TC_BC_CRD_GRIss_170B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_POL_GRIss_171B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_TAX_GRIss_172B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_ASCon_GRIss_173B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TS_BC_ASRep_GRIss_174B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_PCI_CnvrtToQt_250A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmConvertToQuote(tcID);
				classInvoker.UmSubmissionNumber(tcID);
				classInvoker.UmClosePage(tcID, DeviceName);
				// PC
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
		public void BC_PCI_CTQ_Iss_250B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_LPL_CnvrtToQt_249A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmConvertToQuote(tcID);
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
		public void BC_LPL_CTQ_Iss_249B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
			//s	classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_SlimPOL_CnvrtToQt_248A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmConvertToQuote(tcID);
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
		public void BC_SlimPOL_CTQ_Iss_248B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void BC_XXREP_CnvrtToQt_247A(TestName testName, Device device) throws Exception {
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
				classInvoker.UmConvertToQuote(tcID);
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
		public void BC_XXREP_CTQ_Iss_247B(TestName testName, Device device) throws Exception {
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
				classInvoker.UmSearchSubmission(tcID);
				classInvoker.edit_UmSubmissionDetails(tcID);
				Setup.LoadData();
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				//classInvoker.verify_UmSubmissionDetails(tcID);
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				classInvoker.UmSubmissionNumber(tcID);
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
		public void TC_PCI_MulQt_251(TestName testName, Device device) throws Exception {
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
				classInvoker.UmConvertToQuote(tcID);
				classInvoker.UmCreateQuote(tcID);		
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
				classInvoker.UmBinding(tcID);		
				GenericFunctions.instance().validateUMStatus(tcID, "Bound"); 
				classInvoker.UmIssuance(tcID);
		//		classInvoker.UmSubmissionNumber(tcID);
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
		public void TC_NFP_MulQt_252(TestName testName, Device device) throws Exception {
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
				classInvoker.UmConvertToQuote(tcID);
				classInvoker.UmCreateQuote(tcID);		
				classInvoker.UmQuoting(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				Setup.LoadData();
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
		