package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.PreRenewalDirectionPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class PreRenewalDirectionPageImpl extends CustomAbstractPage implements PreRenewalDirectionPage {
	@SuppressWarnings("static-access")
	@Override
	public void PreRenewalDirection(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataPreRenewal = PageDataManager.instance().getPageData("PreRenewalDirection", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);

		_click(getElement(tabActions));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(btnPrerenewalDirectionTab));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(btnEdit));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_setValue(getElement(txtDirection), dataPreRenewal.getData("Direction"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		func.setValue2(getElement(txtDirection));
		//_clickEnter();
		_setValue(getElement(txtNonRenewReason), dataPreRenewal.getData("NonRenewReason"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		func.setValue2(getElement(txtNonRenewReason));
		//_clickEnter();
		_setValue(getElement(txtText), dataPreRenewal.getData("Text"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(btnUpdate));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		CustomReporting.logReport("", "", "Policy is flagged for Non-Renewal!", StepStatus.REPORT,
				new String[] {}, System.currentTimeMillis());

	}
}
