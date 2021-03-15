package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.settings.Setup;
import com.everest.page.application.UmRatingManuScriptEndtsPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmRatingManuScriptEndtsPageImpl extends CustomAbstractPage implements UmRatingManuScriptEndtsPage {

	@Override
	public void UmAddingManuScriptEndts(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmMSE = PageDataManager.instance().getPageData("UmManuScriptEndts", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		
		String rows_xpath="(//ui-repeating-rows//ui-repeating-row[1]//input)[1]";
		
		_click(getElement(lnk_RatingMSEndts));
		_wait(2000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(rows_xpath)));
		
		for(int i=1;i<=3;i++)
		{
			String FormNo_xpath="(//ui-repeating-rows//ui-repeating-row["+i+"]//input)[1]";
			String FormDesc_xpath="(//ui-repeating-rows//ui-repeating-row["+i+"]//input)[2]";
			WebElement FormNo = getWebDriver().findElement(By.xpath(FormNo_xpath));
			FormNo.click();
			String FormNumber = "PCIMSEM-TESTA"+i;
			_writeToExcel("UmManuScriptEndts", "FormNo"+i, FormNumber, tcID);
			Setup.LoadData();
			String FormDescription = "Test For Form"+i;
			_writeToExcel("UmManuScriptEndts", "FormDesc"+i, FormDescription, tcID);
			Setup.LoadData();
			FormNo.sendKeys(FormNumber);
			WebElement FormDesc = getWebDriver().findElement(By.xpath(FormDesc_xpath));
			FormDesc.click();
			FormDesc.sendKeys(FormDescription);
			if(i==1)
			{
				FormDesc.sendKeys("MaxLengthForFormDescis256MaxLengthForFormDescis256MaxLengthForFormDescis256MaxLengthForFormDescis256MaxLengthForFormDescis256MaxLengthForFormDescis256MaxLengthForFormDescis256MaxLengthForFormDescis256\r\n" + 
						"MaxLengthForFormDescis256MaxLengthForFormDescis256LastSixMaxLengthForFormDescis256LastSixMaxLengthForFormDescis256LastSix");
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				_click(getElement(btnUpdateCoverages));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				long startTime = System.currentTimeMillis();
				if(getElement(Error_Summary).isVisible())
				{
					_click(getElement(btn_Ok));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "EPRO71013 Form Desc Max Chars 256 Test" , StepStatus.SUCCESS, new String[] {},
							startTime);
					FormDesc.clear();
					FormDesc.sendKeys(FormDescription);
				}
				else
				{
					CustomReporting.logReport("", "", "EPRO71013 Form Desc Max Chars 256 Test" , StepStatus.FAILURE, new String[] {},
							startTime);
				}
				
				
			}
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if(i!=3)
			{
				_click(getElement(btn_addRow));
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
			
		}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(btnUpdateCoverages));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

		
		
	}
	
	@Override
	public void UmManuScriptEndts_Forms(String tcID, SoftAssert softAssert) throws Exception 
	{
		Setup.LoadData();
		PageData dataUmMSE = PageDataManager.instance().getPageData("UmManuScriptEndts", tcID);
		String MSForms = dataUmMSE.getData("FormNo1")+";"
						+dataUmMSE.getData("FormNo2")+";"
						+dataUmMSE.getData("FormNo3")+";"
						+dataUmMSE.getData("FormDesc1")+";"
						+dataUmMSE.getData("FormDesc2")+";"
						+dataUmMSE.getData("FormDesc3")+";";
		_writeToExcel("Forms", "FormsValidation", MSForms, tcID);
		Setup.LoadData();
	}


}
