package com.everest.page.application.spi;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmGeneralInfoPage;
import com.everest.utility.CustomAbstractPage;

public class UmGeneralInfoPageImpl extends CustomAbstractPage implements UmGeneralInfoPage {

	@Override
	public void UmGeneralInfo(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		String strScreenShots = dataUmLogin.getData("PrintScreens");
		if (strScreenShots.equalsIgnoreCase("Yes")) {
			func._takeScreenShot(getWebDriver(), "START", "", "");
		}
		
		String timeStamp = (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())).replace(".", "");

		_wait(1000);
		_setValue(getElement(txtStreet1), dataUmLogin.getData("Street1") + "_" + timeStamp);
		func._waitForPageToLoad(getWebDriver(), 50L);

		_wait(1000);
		_setValue(getElement(txtZipCode), dataUmLogin.getData("ZipCode"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

//		_setValue(getElement(txtFEIN), dataUmLogin.getData("FEIN"));
//		func._waitForPageToLoad(getWebDriver(), 50L);

//		_click(getElement(ddOwnershipType));
//		_wait(2000);
//		_click(getElement(txtOwnershipType));
//		_wait(3000);
//		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");


	}

}
