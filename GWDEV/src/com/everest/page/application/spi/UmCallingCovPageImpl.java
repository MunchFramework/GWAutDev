package com.everest.page.application.spi;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmCallingCovPage;
import com.everest.utility.CustomAbstractPage;

public class UmCallingCovPageImpl extends CustomAbstractPage implements UmCallingCovPage {
	
	@Override
	public void expendCoverages(String tcID, SoftAssert softAssert) throws Exception 
	{
		
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(5000);
		
		try
		{
				WebElement weCoverageArrow1=(WebElement)getElement(CoverageExp1).getNative();
				if(!weCoverageArrow1.getAttribute("class").contains("isOpen"))
				{
					_click(getElement(CoverageExp1));
				}
				WebElement weCoverageArrow2=(WebElement)getElement(CoverageExp2).getNative();
				if(!weCoverageArrow2.getAttribute("class").contains("isOpen"))
				{
					_click(getElement(CoverageExp2));
				}
				_wait(5000);
				_click(getElement(CoverageExp3));
		}
		catch(Exception e)
		{
			
		}
		
		
	}

	@Override
	public void UmCallingCov(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
	
		_wait(15000);
		if (func._isVisible(getElement(btnLPLPage)) == true)
		{
			PageImplInvoker classInvoker = new PageImplInvoker();
			classInvoker.UmRatingLPLNonAdmitted(tcID);
		}
		
		
		if (func._isVisible(getElement(btnDNOPage)) == true)
		{
			PageImplInvoker classInvoker = new PageImplInvoker();
			classInvoker.UmRatingDNO_1(tcID);
		}
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");


		if (func._isVisible(getElement(btnCRIPage)) == true)
		{
			PageImplInvoker classInvoker = new PageImplInvoker();
			classInvoker.UmRatingCRI(tcID);
		}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		_wait(5000);
		
		if (func._isVisible(getElement(btnCYBPage)) == true)
		{
			PageImplInvoker classInvoker = new PageImplInvoker();
			classInvoker.UmRatingCYB(tcID);
		}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		_wait(5000);

		_wait(5000);
		if (func._isVisible(getElement(btnEMPPage)) == true)
		{
			PageImplInvoker classInvoker = new PageImplInvoker();
			classInvoker.UmRatingEMP(tcID);
		}
		
		_wait(5000);
		func._scrollToElement(getElement(btnOptnlEndtab));
		_wait(5000);
		if (func._isVisible(getElement(btnENOPage)) == true)
		{
			PageImplInvoker classInvoker = new PageImplInvoker();
			classInvoker.UmRatingENO(tcID);
		}
		
		_wait(5000);
		func._scrollToElement(getElement(btnOptnlEndtab));
		_wait(5000);
		if (func._isVisible(getElement(btnKNRPage)) == true)
		{
			PageImplInvoker classInvoker = new PageImplInvoker();
			classInvoker.UmRatingKNR(tcID);
		}
		_wait(5000);
		func._scrollToElement(getElement(btnOptnlEndtab));
		_wait(5000);
		if (func._isVisible(getElement(btnEPLPage)) == true)
		{
			PageImplInvoker classInvoker = new PageImplInvoker();
			classInvoker.UmRatingEPL(tcID);
		}
		
		_wait(5000);
		func._scrollToElement(getElement(btnOptnlEndtab));
		_wait(5000);
		if (func._isVisible(getElement(btnFIDPage)) == true)
		{
			PageImplInvoker classInvoker = new PageImplInvoker();
			classInvoker.UmRatingFID(tcID);
		}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");


	}


}

