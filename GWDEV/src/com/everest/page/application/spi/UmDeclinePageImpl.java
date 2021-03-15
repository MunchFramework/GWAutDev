package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmDeclinePage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmDeclinePageImpl extends CustomAbstractPage implements UmDeclinePage {

	
@Override
public void UmDecline(String tcID, SoftAssert softAssert) throws Exception {
PageData dataUmDecline = PageDataManager.instance().getPageData("Decline", tcID);
func._waitForPageToLoad(getWebDriver(), 50L);
String strScreenShots = dataUmDecline.getData("PrintScreens");
if (strScreenShots.equalsIgnoreCase("Yes")) {
	func._takeScreenShot(getWebDriver(), "START", "", "");
}
		_wait(20000);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(btnActions));		

		

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(btnDecline));
		
		

		_wait(1000);
		_click(getElement(txtReason));
		func._waitForPageToLoad(getWebDriver(), 50L);


		_wait(1000);
		_setValue(getElement(txtReasonfield), dataUmDecline.getData("txtReasonfield"));
		func.setValue2(getElement(txtReasonfield));
		//_clickEnter();
		func._waitForPageToLoad(getWebDriver(), 50L);

		_wait(1000);
		_setValue(getElement(txtComment), dataUmDecline.getData("txtComment"));
		func._waitForPageToLoad(getWebDriver(), 50L);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(btnConfirm));
		_wait(10000);
		func._waitForPageToLoad(getWebDriver(), 100L);
		_wait(6000);
		_click(getElement(btnNo));
		_wait(6000);
		func._waitForPageToLoad(getWebDriver(), 100L);
		_wait(6000);
		_click(getElement(btnOk));
		
		_wait(1000);
		func._waitForPageToLoad(getWebDriver(), 80L);
		

		_wait(1000);

				

		_wait(7000);
		if (func._isVisible(getElement(txtStatus)) == true)
		{
		func._waitForPageToLoad(getWebDriver(), 50L);

//
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		CustomReporting.logReport("", "", "Application Declined successfully!", StepStatus.REPORT,
				new String[] {}, System.currentTimeMillis());
		}
		else
		{
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.logReport("", "", "Application was not Declined successfully!", StepStatus.REPORT,
					new String[] {}, System.currentTimeMillis());	
		}
		}


}
