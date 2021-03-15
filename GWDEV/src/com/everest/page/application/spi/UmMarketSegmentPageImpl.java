package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmMarketSegmentPage;
import com.everest.utility.CustomAbstractPage;

public class UmMarketSegmentPageImpl extends CustomAbstractPage implements UmMarketSegmentPage {

	@Override
	public void UmMarketSegment(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmMarSeg = PageDataManager.instance().getPageData("UmMarketSegment", tcID);
		PageData dataSub = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		PageData dataSub1 = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		
		if(!dataSub.getData("tcID_BC_PartB").equals(""))
		{
			dataSub = PageDataManager.instance().getPageData("UMSubmissionDetails", dataSub.getData("tcID_BC_PartB"));	
		}
		if(!dataUmMarSeg.getData("tcID_BC_PartB").equals(""))
		{
			dataUmMarSeg = PageDataManager.instance().getPageData("UmMarketSegment", dataUmMarSeg.getData("tcID_BC_PartB"));	
		}
		func._waitForPageToLoad(getWebDriver(), 50L);
		/*String strScreenShots = dataUmMarSeg.getData("PrintScreens");
		if (strScreenShots.equalsIgnoreCase("Yes")) {
			func._takeScreenShot(getWebDriver(), "START", "", "");
		}*/
		

		_wait(4000);
		func._scrollToElement(getElement(btnMarketSegment));
		_click(getElement(btnMarketSegment));

		_wait(4000);
		try {
			_setValue(getElement(txtMarketSegment), dataUmMarSeg.getData("MarketSegment"));
		} catch (Exception e) {
			// TODO: handle exception
			Actions ac = new Actions(getWebDriver());
			ac.moveToElement(getWebDriver().findElement(By.xpath("//div[contains(text(),'Coverage(s):')]"))).click();
			ac.sendKeys(Keys.PAGE_DOWN).perform();
			_click(getElement(btnMarketSegment));
			_wait(4000);
			_setValue(getElement(txtMarketSegment), dataUmMarSeg.getData("MarketSegment"));
		}
		_wait(2000);
		String expoption1= "//um-dropdown-list//*[contains(text(),\""+dataUmMarSeg.getData("MarketSegment")+"\")]";
		WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
		expectedOption1.click();
		//func.setValue2(getElement(txtMarketSegment));
		// _clickEnter();
		_wait(4000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		_wait(5000);
		_click(getElement(btnNaicsCode));
		_wait(6000);

		_setValue(getElement(txtNaicsCode), dataUmMarSeg.getData("NaicsCode"));
		_wait(2000);
		String expoption = "//um-dropdown-list//*[contains(text(),\""+dataUmMarSeg.getData("NaicsCode")+"\")]";
		WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
		expectedOption.click();
		//func.setValue2(getElement(txtNaicsCode));
		// _clickEnter();
		_wait(4000);
	
			 		func.setValue3(getElement(btnNaicsCode));
			 		func.setValue3(getElement(btnNaicsCode));
			 		func.setValue3(getElement(btnNaicsCode));
			 		func.setValue3(getElement(btnNaicsCode));
			
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		/*if (!dataSub1.getData("Submission_Type").equalsIgnoreCase("Renewal"))
		{*/
			
			_wait(4000);
			_click(getElement(ddOwnershipType));
			_wait(2000);	
			if (dataUmMarSeg.getData("OwnershipType").equalsIgnoreCase("Public")) {
				_click(getElement(txtOwnershipType_Pub));
			}
			else
			{
				_click(getElement(txtOwnershipType_Pri));
			}
			_wait(3000);
			_clickTab();
		//}
		
		WebElement weOT=(WebElement)getElement(btnNaicsCode).getNative();
		weOT.sendKeys(Keys.PAGE_DOWN);
		_wait(10000);
		
		if (func._isVisible(getElement(btnSAACode)) == true)
		{
			_click(getElement(btnSAACode));
			_wait(2000);
			_setValue(getElement(txtSAACode), dataUmMarSeg.getData("SPSAACode"));
			_wait(2000);
			String expoption2= "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmMarSeg.getData("SPSAACode")+"\")]";
			WebElement expectedOption2 = (getWebDriver().findElement(By.xpath(expoption2)));
			expectedOption2.click();
		}
		
		


		_click(getElement(btnLegalEntity));
		
		
		if (func._isVisible(getElement(txtLegalEntity)) == false) 
		{
			func._scrollToElement(getElement(btnDepartment));
			_wait(2000);
			_click(getElement(btnLegalEntity));
			_wait(2000);
			
		}
		_setValue(getElement(txtLegalEntity), dataUmMarSeg.getData("LegalEntity"));
		_wait(3000);
		String expoption2 = "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmMarSeg.getData("LegalEntity")+"\")]";
		WebElement expectedOption2 = (getWebDriver().findElement(By.xpath(expoption2)));
		expectedOption2.click();
		_wait(4000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		if(dataUmMarSeg.getData("OwnershipType").equalsIgnoreCase("Public")) 
		{
			_setValue(getElement(txtStockTicker), dataUmMarSeg.getData("StockTicker"));
			_wait(8000);
			WebElement weUW=(WebElement)getElement(txtStockTicker).getNative();
			weUW.sendKeys(Keys.PAGE_DOWN);
			_wait(8000);
		}

	}


	@Override
	public void UpdateUmMarketSegment(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmMarketSegment", tcID);
        _click(getElement(btnLegalEntity));
		
		//func.setValue2(getElement(btnLegalEntity));
		if (func._isVisible(getElement(txtLegalEntity)) == false) {
			func._scrollToElement(getElement(btnLegalEntity));
			_wait(2000);
			_click(getElement(btnLegalEntity));
			_wait(2000);
			
		}
		_setValue(getElement(txtLegalEntity), dataUmLogin.getData("LegalEntity"));
		_wait(3000);
		String expoption2 = "//um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("LegalEntity")+"\")]";
		WebElement expectedOption2 = (getWebDriver().findElement(By.xpath(expoption2)));
		expectedOption2.click();
		_wait(4000);
		
	}
	
	
	@Override
	public void verifyUmMarketSegment(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmMarketSegment", tcID);
       
		
		//func.setValue2(getElement(btnLegalEntity));
        func._checkAttributeValue(getElement(btnLegalEntity), "TEXT",dataUmLogin.getData("LegalEntity"), softAssert);
		
	}
	

}
