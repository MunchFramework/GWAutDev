package test.java.com.everest.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xframium.spi.Device;

import com.everest.functions.GenericFunctions;
import com.everest.functions.settings.Setup;
import com.everest.page.application.spi.PageImplInvoker;
import com.everest.utility.CustomAbstractTest;
import com.everest.utility.CustomReporting;

public class TestDriver_RunOff extends CustomAbstractTest {
	@Test(dataProvider = "DeviceManager")
	public void TC_R3B_RunOff_EzExcess(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			
			//Logging into PC and performing RunOff
			
			 classInvoker.launchPage(tcID, DeviceName);
			 Setup.LoadData();
			 classInvoker.searchPolicy(tcID, DeviceName);
			 classInvoker.PolicyChangeRunOff(tcID);
			 classInvoker.ClosePage(tcID, DeviceName);
			
			 classInvoker.InsuredAppLogin(tcID);
			 Setup.LoadData();
			 classInvoker.InsuredAppValidationPolicyChangeRunOff(tcID,"ShortTermWorkSheetID","ShortTermPremium");
			 
			 classInvoker.InsuredAppLogin(tcID);
			 Setup.LoadData();
			 classInvoker.InsuredAppValidationPolicyChangeRunOff(tcID,"RunOffWorksheetID","RunOffPremium");
			 
			
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

	//TC_R3B_RunOff_CYB , DS_R2_SIT_E2E_CYBSMOKE, DS_R3B_RunOff_CYB

	@Test(dataProvider = "DeviceManager")
	public void TC_R3B_RunOff_CYB(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			
			//Logging into PC and performing RunOff
			
			 classInvoker.launchPage(tcID, DeviceName);
			 Setup.LoadData();
			 classInvoker.searchPolicy(tcID, DeviceName);
			 Setup.LoadData();
			 classInvoker.PolicyChangeRunOff(tcID);
			 
			classInvoker.ClosePage(tcID, DeviceName);					
			
			classInvoker.InsuredAppLogin(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppValidationPolicyChangeRunOff(tcID,"ShortTermWorkSheetID","ShortTermPremium");
			classInvoker.InsuredAppValidationPolicyChangeRunOff(tcID,"RunOffWorksheetID","RunOffPremium");
			
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	//DS_R3B_RunOff_LPL DS_R3A_LPLNonAdmittedSMOKE
	@Test(dataProvider = "DeviceManager")
	public void TC_R3B_RunOff_LPL(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				classInvoker.UmClosePage(tcID, DeviceName);
			//Logging into PC and performing RunOff
		
			 classInvoker.launchPage(tcID, DeviceName);
			 Setup.LoadData();
			 classInvoker.searchPolicy(tcID, DeviceName);
			 Setup.LoadData();
			 classInvoker.PolicyChangeRunOff(tcID);
			 
			classInvoker.ClosePage(tcID, DeviceName);					
			
			classInvoker.InsuredAppLogin(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppValidationPolicyChangeRunOff(tcID,"ShortTermWorkSheetID","ShortTermPremium");
			classInvoker.InsuredAppValidationPolicyChangeRunOff(tcID,"RunOffWorksheetID","RunOffPremium");
			
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	@Test(dataProvider = "DeviceManager")
	public void TC_R3B_RunOff_EzExcess_Unchanged(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			
			//Logging into PC and performing RunOff
			
			 classInvoker.launchPage(tcID, DeviceName);
			 Setup.LoadData();
			 classInvoker.searchPolicy(tcID, DeviceName);
			 classInvoker.PolicyChangeRunOff(tcID);
			 classInvoker.ClosePage(tcID, DeviceName);
			
			 classInvoker.InsuredAppLogin(tcID);
			 Setup.LoadData();
			 classInvoker.InsuredAppValidationPolicyChangeRunOff(tcID,"ShortTermWorkSheetID","ShortTermPremium");
			 
			 classInvoker.InsuredAppLogin(tcID);
			 Setup.LoadData();
			 classInvoker.InsuredAppValidationPolicyChangeRunOff(tcID,"RunOffWorksheetID","RunOffPremium");
			 
			
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

	//TC_R3B_RunOff_CYB , DS_R2_SIT_E2E_CYBSMOKE, DS_R3B_RunOff_CYB

	@Test(dataProvider = "DeviceManager")
	public void TC_R3B_RunOff_CYB_Unchanged(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			
			//Logging into PC and performing RunOff
			
			 classInvoker.launchPage(tcID, DeviceName);
			 Setup.LoadData();
			 classInvoker.searchPolicy(tcID, DeviceName);
			 Setup.LoadData();
			 classInvoker.PolicyChangeRunOff(tcID);
			 
			classInvoker.ClosePage(tcID, DeviceName);					
			
			classInvoker.InsuredAppLogin(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppValidationPolicyChangeRunOff(tcID,"ShortTermWorkSheetID","ShortTermPremium");
		
			
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		} catch (Exception ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}

	//DS_R3B_RunOff_LPL DS_R3A_LPLNonAdmittedSMOKE
	@Test(dataProvider = "DeviceManager")
	public void TC_R3B_RunOff_LPL_Unchanged(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
				classInvoker.UmBinding(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Bound");
				classInvoker.UmIssuance(tcID);
				GenericFunctions.instance().validateUMStatus(tcID, "Issued");
				classInvoker.UmClosePage(tcID, DeviceName);
			//Logging into PC and performing RunOff
			
			 classInvoker.launchPage(tcID, DeviceName);
			 Setup.LoadData();
			 classInvoker.searchPolicy(tcID, DeviceName);
			 Setup.LoadData();
			 classInvoker.PolicyChangeRunOff(tcID);
			 
			classInvoker.ClosePage(tcID, DeviceName);					
			
			classInvoker.InsuredAppLogin(tcID);
			Setup.LoadData();
			classInvoker.InsuredAppValidationPolicyChangeRunOff(tcID,"ShortTermWorkSheetID","ShortTermPremium");
			
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
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
