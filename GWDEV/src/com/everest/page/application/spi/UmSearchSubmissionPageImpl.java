package com.everest.page.application.spi;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmSearchSubmissionPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmSearchSubmissionPageImpl extends CustomAbstractPage implements UmSearchSubmissionPage{
	@Override
	public void UmSearchSubmission(String tcID, SoftAssert softAssert) throws Exception 
	{
		_wait(15000);
		PageData dataUmLogin = PageDataManager.instance().getPageData("SearchPolicy", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		
		
		if(!dataUmLogin.getData("tcID_BC_PartB").equals(""))
		{
			dataUmLogin = PageDataManager.instance().getPageData("SearchPolicy", dataUmLogin.getData("tcID_BC_PartB"));	
		}
		
		//Removing Extra Filters : Start
		String abc = "//div[contains(@class,'removeButton')]";
		
		List<WebElement> all = getWebDriver().findElements(By.xpath(abc));
		
		for(int i=1;i<all.size();i++)
		{
			all.get(i).click();
		}
		//Removing Extra Filters : End
     	
     	if (func._isVisible(getElement(btnAdditionalCriteria))==false) 
     	{
     		_wait(10000);
     		_click(getElement(btnSearchIcon));
     	}
     	
     	if (func._isVisible(getElement(txtInsured))==false) 
     	{
     		_wait(10000);
     		_click(getElement(btnAdditionalCriteria));
     		String targetxpath2 = "/html[1]/body[1]/div[3]/div[1]/ul[1]//*[contains(text(),'Insured')]";
     		func.selectDropDownValue(getWebDriver(), targetxpath2, "Insured");
     		
     	}
		_wait(10000);
		_setValue(getElement(txtInsured), dataUmLogin.getData("SubmissionNo"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		
		_click(getElement(btnSubmission));
		_wait(10000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		if (func._isVisible(getElement(btnOK))==true) 
     	{
     		_click(getElement(btnOK));
     	}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		CustomReporting.logReport("", "", "Submission Number found!", StepStatus.REPORT,
				new String[] {}, System.currentTimeMillis());
	}

	public void UmPowerBIReports_LinkVerification(String tcID, SoftAssert softAssert) throws Exception 
	{
		_wait(15000);
		PageData dataUmSearchPolicy = PageDataManager.instance().getPageData("SearchPolicy", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if(func._isVisible(getElement(PowerBI_Links))==true)
		{
			CustomReporting.logReport("", "", "Power BI Report Links are shown on the Search Screen as Expected as per EPRO75724", StepStatus.SUCCESS,
					new String[] {}, System.currentTimeMillis());
			func._scrollToElement(getElement(PowerBI_Links));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			String[] ReportList =dataUmSearchPolicy.getData("ReportName").split(";");
			String[] ReportURL =dataUmSearchPolicy.getData("ReportURL").split(";");
			for(int i=0;i<ReportList.length;i++)
			{
				getWebDriver().switchTo().frame(1);
				_click(getClonedElement(Reports_link).addToken("tkn_reportname", ReportList[i]));
				_wait(3000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				Set<String> allwinids = getWebDriver().getWindowHandles();
				String[] ids =  allwinids.toArray(new String[allwinids.size()]);
				for(int j=0;j<allwinids.size();j++)
				{
					getWebDriver().switchTo().window(ids[j]);
					String wintit = getWebDriver().getTitle();
					if(!wintit.equalsIgnoreCase("Underwriting Management"))
					{
						
						if(getWebDriver().getCurrentUrl().equals(ReportURL[i]))
						{
							func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
							CustomReporting.logReport("", "", "Power BI Report "+ReportList[i]+" is shown with Correct URL "+ReportURL[i], StepStatus.SUCCESS,
									new String[] {}, System.currentTimeMillis());
							CustomReporting.logReport("Closed Report Window");
							
						}
						else
						{
							func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
							CustomReporting.logReport("", "", "Power BI Report "+ReportList[i]+" is NOT shown with Correct URL "+ReportURL[i], StepStatus.FAILURE,
									new String[] {}, System.currentTimeMillis());
						}
						getWebDriver().close();
					}
					
				}
				
				func._switchWindows(getWebDriver(), "BY_WINTITLE", "Underwriting Management");
				String wintit2 = getWebDriver().getTitle();
				if(wintit2.equalsIgnoreCase("Underwriting Management"))
				{
					System.out.println("Switched to UM Window");
					CustomReporting.logReport("Switched to UM Window");
				}
				else
				{
					func._switchWindows(getWebDriver(), "BY_WINTITLE", "Underwriting Management");
				}
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
			}
		}
		else
		{
			CustomReporting.logReport("", "", "Power BI Rport Links are NOT shown on the Search Screen as per EPRO75724", StepStatus.FAILURE,
					new String[] {}, System.currentTimeMillis());
		}
		
	}
	
}
