/*******************************************************************
*	Name              : Main Function
*	Description       : 
*	Author            : Juvelle Mendes 
*	Date Created      :	02/12/2017
*	Modification Log  :                                                     
*	Date		Initials     	Description of Modifications 
********************************************************************
********************************************************************/
package test.java.com.mn.insta.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xframium.spi.Device;

import com.mn.insta.page.functions.GenericFunctions;
import com.mn.insta.page.functions.settings.Setup;
import com.mn.insta.page.utility.CustomAbstractTest;
import com.mn.insta.page.utility.CustomReporting;
import com.mn.insta.page.utility.PageImplInvoker;

public class TestDriver_ApplicationName extends CustomAbstractTest {
	// Adding

	@Test(dataProvider = "DeviceManager")
	public void TS_InstaLogin(TestName testName, Device device) throws Exception 
	{
		String tcID = "";
		try {
			System.out.println("AAGaithub webhook test with ngrok");
			SoftAssert softAssert = new SoftAssert();
			tcID = getTestName(testName);
			String DeviceName = getDeviceName(testName);
			String gvTestKey = testName.toString().split(device.getBrowserName() + "_")[1].split("\\[")[0];
			GenericFunctions.instance()._addToGlobalVariableList(gvTestKey, testName.toString());
			
			PageImplInvoker classInvoker = new PageImplInvoker();	
			classInvoker.LoginToInsta(tcID, DeviceName);
			Setup.LoadData();
			Thread.sleep(500);
			classInvoker.LogoutInsta(tcID, DeviceName);			
			softAssert.assertAll();
			System.out.println("AAGithub webmhook test with ngrok");

		} catch (Exception ex) {
			
			ex.printStackTrace();
			throw ex;
		}
	}
	

}
