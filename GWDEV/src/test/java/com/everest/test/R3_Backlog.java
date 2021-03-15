package test.java.com.everest.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xframium.spi.Device;

import com.everest.functions.GenericFunctions;
import com.everest.functions.settings.Setup;
import com.everest.page.application.spi.PageImplInvoker;
import com.everest.utility.CustomAbstractTest;
import com.everest.utility.CustomReporting;

public class R3_Backlog extends CustomAbstractTest {
	
	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC14(TestName testName, Device device) throws Exception {
			String tcID = "";
			try {

				SoftAssert softAssert = new SoftAssert();
				tcID = getTestName(testName);
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
//				classInvoker.UmSubmissionNumber(tcID);
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
				
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.Verify_Policy_Search(tcID, DeviceName);

				 
					
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
						tcID);
				softAssert.assertAll();

			} catch (Exception ex) {
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
						tcID);
				CustomReporting.logReport(ex);
				ex.printStackTrace();
				throw ex;
			}
		}

	@Test(dataProvider = "DeviceManager")
	public void R3A_SIT_E2E_SC15(TestName testName, Device device) throws Exception {
			String tcID = "";
			try {

				SoftAssert softAssert = new SoftAssert();
				tcID = getTestName(testName);
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
//				classInvoker.UmSubmissionNumber(tcID);
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
				
				classInvoker.LoginToEscape(tcID, DeviceName);
				classInvoker.Verify_Policy_Search(tcID, DeviceName);

				 
					
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
						tcID);
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
