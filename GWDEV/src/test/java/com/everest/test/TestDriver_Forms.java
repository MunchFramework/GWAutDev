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
import org.xframium.spi.Device;

import com.everest.functions.GenericFunctions;
import com.everest.functions.settings.Setup;
import com.everest.page.application.spi.PageImplInvoker;
import com.everest.utility.CustomAbstractTest;
import com.everest.utility.CustomReporting;

public class TestDriver_Forms extends CustomAbstractTest 
{
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_AR(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_AZ (TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_CA (TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_CO (TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_CT(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_CW(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_DC(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_DE(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_FL(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_GA(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_IA(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_ID(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_IL(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_IN(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_KS(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_LA(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_MD(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_ME(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_MI(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_MN(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_MO(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_MS(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_MT(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_NC(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_ND(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_NE(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_NH(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_NJ(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_NM(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_NV(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_NY(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_OH(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_OK(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_OR(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_PA(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_RI(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_SC(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_SD(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_TN(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_TX(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_UT(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_VA(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_VT(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_WA(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_WI(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_WV(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_PCI_Pack_Forms_WY(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_NFP_Pack_Forms_HI (TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex) 
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_NFP_Pack_Forms_KY (TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex) 
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_NFP_Pack_Forms_MA (TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex) 
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2_RT_04990(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_Alliant_04787(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_AmWins_04542(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_Arc_04884(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_Arthur_15745(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_Lockton_02722(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_Marsh_14498(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_NFP_28232(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_PBC_04888(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_Willis_14137(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_WWF_20307(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_RT_29925(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_Alliant_04922(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_AmWins_04327(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_Arc_04726(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_Arthur_28960(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_Lockton_13711(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_Marsh_03325(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_NFP_04851(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_PBC_11986(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_Willis_10414(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_WWF_16285(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_CYBForms_RT(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_CYBForms_Alliant(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_CYBForms_AmWins(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_CYBForms_Arc(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_CYBForms_Arthur(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_CYBForms_Lockton(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_CYBForms_Marsh(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_CYBForms_NFP(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_CYBForms_PBC(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_CYBForms_Willis(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_CYBForms_WWF(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UM_DownloadProposal(tcID);
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UM_DownloadBinder(tcID);
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R4_2_AMS_NFP_VAForm(TestName testName, Device device) throws Exception 
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R4_2_AMS_EZ_VAForm(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	//R5A Regression Scenarios
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_CYB_LAE_PBCRR(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());

			PageImplInvoker classInvoker = new PageImplInvoker();
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "START", "", "");
			classInvoker.UmlaunchPage(tcID, DeviceName);
			classInvoker.UmSubmissionDetails(tcID);
			classInvoker.UmAddingOffice(tcID);
			classInvoker.UmExposures(tcID);
			GenericFunctions.instance().ValidatePreSelectedForms(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
			classInvoker.UmQuoting(tcID);
			GenericFunctions.instance().formsValidation(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			Setup.LoadData();
			classInvoker.UmBinding(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			Setup.LoadData();
			classInvoker.UmIssuance(tcID);
			GenericFunctions.instance().validateUMStatus(tcID, "Issued");
			Setup.LoadData();
			classInvoker.UM_DownloadPolicyDoc(tcID);
			classInvoker.UmClosePage(tcID, DeviceName);
			

			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			softAssert.assertAll();

		}
		catch (Exception ex) 
		{
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
	public void TS_R5A_RunOff_Cyb_CT(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_Cyb_MT(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_NFP_CW391A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_NFP_CW391B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_NFP_CW391C(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_NFP_CW391D(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_NFP_ME391A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_NFP_ME391B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_NFP_ME391C(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_NFP_ME391D(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_NFP_MT391A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_NFP_MT391B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_NFP_MT391C(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_NFP_MT391D(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_PCI_CT357A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_PCI_CT357B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_PCI_CT357C(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_PCI_CW357A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_PCI_CW357B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_PCI_CW357C(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_PCI_ME357A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_PCI_ME357B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_PCI_ME357C(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_PCI_VA357A(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_PCI_VA357B(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_PCI_VA357C(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_RunOff_PCI_MT357C(TestName testName, Device device) throws Exception 
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
			classInvoker.UmSetRunOffPremium(tcID);
			GenericFunctions.instance().checkCoverages(tcID);
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

		} 
		catch (Exception ex)
		{
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			CustomReporting.logReport(ex);
			ex.printStackTrace();
			throw ex;
		}
	}
	
	
	
	@Test(dataProvider = "DeviceManager")
	public void TS_R5A_PCRunOff_Cyb_CT328C(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Cyb_MT328C(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Pci_CT357A(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Pci_CT357B(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Pci_CT357C(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Pci_CW357A(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Pci_CW357B(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Pci_CW357C(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Pci_ME357A(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Pci_ME357B(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Pci_ME357C(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Pci_VA357A(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Pci_VA357B(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Pci_VA357C(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Pci_MT357C(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Nfp_CW391A(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Nfp_CW391B(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Nfp_CW391C(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Nfp_CW391D(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Nfp_ME391A(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Nfp_ME391B(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Nfp_ME391C(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Nfp_ME391D(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Nfp_MT391A(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Nfp_MT391B(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Nfp_MT391C(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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
	public void TS_R5A_PCRunOff_Nfp_MT391D(TestName testName, Device device) throws Exception {
		String tcID = "";
		try {

			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
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
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PolicyChangeRunOff_1(tcID);
			classInvoker.ClosePage(tcID, DeviceName);
			
			classInvoker.launchPage(tcID, DeviceName);
			Setup.LoadData();
			classInvoker.searchPolicy(tcID, DeviceName);
			classInvoker.PcPrintForm(tcID);
			classInvoker.PcDownloadForm(tcID);
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


