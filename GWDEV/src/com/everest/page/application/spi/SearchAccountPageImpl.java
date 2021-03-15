package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.AccountSearchPage;
import com.everest.utility.CustomAbstractPage;

public class SearchAccountPageImpl extends CustomAbstractPage implements AccountSearchPage {

	@SuppressWarnings("static-access")
	@Override
	public void searchAccount(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataAccount = PageDataManager.instance().getPageData("Account", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		_click(getElement(tabAccount));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_setValue(getElement(txtAccountNo), dataAccount.getData("AccountNo"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		_click(getElement(iconSearch));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(2000);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

	}

}
