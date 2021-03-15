package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.RescindPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class RescindPageImpl extends CustomAbstractPage implements RescindPage  {
	@SuppressWarnings("static-access")
	@Override
	public void Rescind(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataRescind = PageDataManager.instance().getPageData("Rescind", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(5000);
		
		_click(getElement(tabActions));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(lnkRescind));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(3000);
		func.setValue8();
		//_clickRight();
		_wait(2000);
		_click(getElement(lnkRescindOption));
		  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(btnCloseOptions));
		
		_wait(1000);
		_click(getElement(lnkRescindCancellation));
		  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		  func._waitForPageToLoad(getWebDriver(),50L);
		  
		    CustomReporting.logReport("","","Rescind is successful!" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
		}
			
		
	}

