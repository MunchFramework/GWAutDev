package com.everest.page.application.spi;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmSearchPolicyPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmSearchPolicyPageImpl extends CustomAbstractPage implements UmSearchPolicyPage{
	@Override
	public void UmSearchPolicy(String tcID, SoftAssert softAssert) throws Exception {
		_wait(15000);
		PageData dataUmLogin = PageDataManager.instance().getPageData("SearchPolicy", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
	
		//Removing Extra Filters : Start
		String abc = "//div[contains(@class,'removeButton')]";
		
		List<WebElement> all = getWebDriver().findElements(By.xpath(abc));
		
		for(int i=1;i<all.size();i++)
		{
			all.get(i).click();
		}
		//Removing Extra Filters : End
     	
     	if (func._isVisible(getElement(btnAdditionalCriteria))==false) {
     		_wait(10000);

    		_click(getElement(btnSearchIcon));
     	}
     	
     	if (func._isVisible(getElement(txtInsured))==false) {
     		_wait(10000);
     		_click(getElement(btnAdditionalCriteria));
     		String targetxpath2 = "/html[1]/body[1]/div[3]/div[1]/ul[1]//*[contains(text(),'Insured')]";
     		func.selectDropDownValue(getWebDriver(), targetxpath2, "Insured");
     		
     	}
		_wait(10000);
		_setValue(getElement(txtInsured), dataUmLogin.getData("PolicyNo"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		
		_click(getElement(btnSubmission));
		_wait(10000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		if (func._isVisible(getElement(btnOK))==true) 
     	{
     		_click(getElement(btnOK));
     	}
		
		CustomReporting.logReport("", "", "Policy Number found!", StepStatus.REPORT, new String[] {},
				System.currentTimeMillis());
	}}
