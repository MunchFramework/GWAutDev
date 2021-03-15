package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.settings.Setup;
import com.everest.page.application.PolicySearchPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class PolicySearchPageImpl extends CustomAbstractPage implements PolicySearchPage {

	@SuppressWarnings("static-access")
	@Override
	public void searchPolicy(String tcID, SoftAssert softAssert) throws Exception {
		Setup.LoadData();
		PageData dataSearchPolicy = PageDataManager.instance().getPageData("SearchPolicy", tcID);

		_click(getElement(tabPolicy));
		_wait(3000);
		if (func._isVisible(getElement(txtPolicyNo)) == false) {
			func.setValue2(getElement(tabPolicy));
			func.setValue4(getElement(tabPolicy));
			//_click(getElement(tabPolicy));
		}
		_wait(3000);
		_wait(3000);
		if (func._isVisible(getElement(txtPolicyNo)) == false) {
			func.setValue2(getElement(tabPolicy));
			func.setValue4(getElement(tabPolicy));
			//_click(getElement(tabPolicy));
		}
		//_clickDown();
		_wait(1000);
		_click(getElement(txtPolicyNo));
		_setValue(getElement(txtPolicyNo), dataSearchPolicy.getData("PolicyNo"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		func.setValue2(getElement(txtPolicyNo));
		//_clickEnter();
		

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		CustomReporting.logReport("", "", "Policy Number found!", StepStatus.REPORT, new String[] {},
				System.currentTimeMillis());
	}

}
