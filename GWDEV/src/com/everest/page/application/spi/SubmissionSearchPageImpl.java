package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.settings.Setup;
import com.everest.page.application.SubmissionSearchPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class SubmissionSearchPageImpl extends CustomAbstractPage implements SubmissionSearchPage {

	@SuppressWarnings("static-access")
	@Override
	public void searchSubmission(String tcID, SoftAssert softAssert) throws Exception {
		Setup.LoadData();
		PageData dataSearchAccount = PageDataManager.instance().getPageData("SearchPolicy", tcID);

		_click(getElement(tabPolicy));
		_wait(3000);
		if (func._isVisible(getElement(txtSubmissionNo)) == false) {
			func.setValue2(getElement(tabPolicy));
			func.setValue4(getElement(tabPolicy));
			//_click(getElement(tabPolicy));
			}
		_wait(3000);
		if (func._isVisible(getElement(txtSubmissionNo)) == false) {
			func.setValue2(getElement(tabPolicy));
			func.setValue4(getElement(tabPolicy));
			//_click(getElement(tabPolicy));
			}
		_wait(3000);
		//_clickDown();
		_wait(1000);
		_click(getElement(txtSubmissionNo));
		_setValue(getElement(txtSubmissionNo), dataSearchAccount.getData("SubmissionNo"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(btnSearch));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		CustomReporting.logReport("", "", "Submission Number found!", StepStatus.REPORT, new String[] {},
				System.currentTimeMillis());
	}

}
