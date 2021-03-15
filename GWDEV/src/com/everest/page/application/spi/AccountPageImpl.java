package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.AccountPage;
import com.everest.utility.CustomAbstractPage;


public class AccountPageImpl extends CustomAbstractPage implements AccountPage {

	@SuppressWarnings("static-access")
	@Override
	public void createAccount(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataAccount = PageDataManager.instance().getPageData("Account", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		_click(getElement(tabActions));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(menuLinkNewAccount));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		// _setValue(getElement(txtCompanyName),dataAccount.getData("CompanyName"));
		// WebElement elm = (WebElement) getElement(txtCompanyName).getNative();
		// elm.sendKeys(Keys.TAB);

		_setValue(getElement(txtCompanyName), dataAccount.getData("CompanyName"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);

		_click(getElement(btnSearch));
		_wait(2000);
		_click(getElement(btnCreateNewAccount));
		_wait(2000);
		_click(getElement(LinkCompanyAccount));
		_wait(2000);
		
		
		_setValue(getElement(txtName), dataAccount.getData("Name"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);

		_setValue(getElement(txtAddress1), dataAccount.getData("MailingAddress"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);

//		_setValue(getElement(txtCity), dataAccount.getData("MailingCity"));
//		func._waitForPageToLoad(getWebDriver(), 50L);
//		_wait(2000);
		
	
	
		
		_setValue(getElement(txtZipCode), dataAccount.getData("MailingZipCode"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		
//		_selectValueDropDown(getElement(ddState), dataAccount.getData("MailingState"));
		func._waitForPageToLoad(getWebDriver(), 1000L);
		_clickEnter();
		
		_wait(3000);
		_setValue(getElement(txtCity), dataAccount.getData("MailingCity"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		_clickTab();	
//		_click(getElement(iconOrganization));
//		_wait(2000);
		
		_setValue(getElement(txtOrgName), dataAccount.getData("OrganizationName"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_clickTab();
		_wait(4000);

//		_click(getElement(btnSearchOrg));
//		_wait(2000);
//
//		_click(getElement(btnSelect));
//		_wait(2000);
		_setValue(getElement(txtProd), dataAccount.getData("Producer"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		
		
		_click(getElement(btnUpdate));
		_wait(5000);

//		String AccountNo = _getAttributeValue(getElement(lblAccntNo), "TEXT");
//
//		_writeToExcel("SearchAccount", "AccountNo", AccountNo, tcID);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(2000);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

	}

}
