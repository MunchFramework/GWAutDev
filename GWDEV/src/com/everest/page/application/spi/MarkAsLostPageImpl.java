package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.MarkAsLostPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class MarkAsLostPageImpl extends CustomAbstractPage implements MarkAsLostPage {

	@Override
	public void MarkAsLost(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmMarkAsLost = PageDataManager.instance().getPageData("MarkAsLost", tcID);
		String strScreenShots=dataUmMarkAsLost.getData("PrintScreens");
		 
        if(strScreenShots.equalsIgnoreCase("Yes"))
        {
          func._takeBrowserScreenShot(getWebDriver(), "START", "", "");
        }
        String strURL="";
		_wait(20000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(btnActions));		

		

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(btnMarkAsLost));
		
		

		_wait(1000);
		
		
		
		_click(getElement(txtReason));
//		Element e = (getElement(ddReasonprefix));
//		e.toString();
//		String Reason = e.getKey().toString();
//		//func._getValue(ddReasonprefix);
//		
//
//	String targetxpath = Reason  + "[contains(text(),\""+dataUmMarkAsLost.getData("txtReason")+"\")]";
//	func.selectDropDownValue(getWebDriver(), targetxpath, dataUmMarkAsLost.getData("txtReason"));
//	 //_selectValueDropDown(getElement(txtReason), dataUmMarkAsLost.getData("txtReason"));
//		//func._selectValueByText(getElement(txtReason), dataUmMarkAsLost.getData("txtReason")); 
//		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		String expoption = "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmMarkAsLost.getData("txtReason")+"\")]";
		WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));		
		expectedOption.click();	
			_wait(3000);
		_click(getElement(txtLostto));
		_wait(2000);
		String expoption1 = "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmMarkAsLost.getData("txtLostto")+"\")]";
		WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));		
		expectedOption1.click();
//		Element f = (getElement(ddLostto));
//		f.toString();
//		String Lost2 = f.getKey().toString();
//		//func._getValue(ddReasonprefix);
//		
//
//	String targetxpath2 = Lost2  + "[contains(text(),\""+dataUmMarkAsLost.getData("txtLostto")+"\")]";
//	func.selectDropDownValue(getWebDriver(), targetxpath2, dataUmMarkAsLost.getData("txtLostto"));
//	
//		//_selectValueDropDown(getElement(txtLostto), dataUmMarkAsLost.getData("txtLostto"));
//		func._waitForPageToLoad(getWebDriver(), 50L);

		_wait(1000);
		_setValue(getElement(txtComment), dataUmMarkAsLost.getData("txtComment"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(btnConfirm));
		func._waitForPageToLoad(getWebDriver(), 80L);
		_wait(1000);
		func._waitForPageToLoad(getWebDriver(), 80L);
		_wait(10000);
		if (func._isVisible(getElement(txtStatus)) == true)
		{
		func._waitForPageToLoad(getWebDriver(), 50L);

//
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		CustomReporting.logReport("", "", "Application Marked as Lost successfully!", StepStatus.REPORT,
				new String[] {}, System.currentTimeMillis());
		}
		else
		{
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.logReport("", "", "Application was not Marked as Lost successfully!", StepStatus.REPORT,
					new String[] {}, System.currentTimeMillis());	
		}
		}


}
