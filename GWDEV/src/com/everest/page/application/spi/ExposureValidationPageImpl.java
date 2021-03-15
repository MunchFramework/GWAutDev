package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.ExposureValidationPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class ExposureValidationPageImpl extends CustomAbstractPage implements ExposureValidationPage {
	public void ExposureValidation(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataForms = PageDataManager.instance().getPageData("UmLogin", tcID);
		func._waitForPageToLoad(getWebDriver(), 100L);
		_wait(5000);
		String strScreenShots=dataForms.getData("PrintScreens");
		 
        if(strScreenShots.equalsIgnoreCase("Yes"))
        {
          func._takeBrowserScreenShot(getWebDriver(), "START", "", "");
        }
        String strURL="";

		if (dataForms.getData("CRIME").equalsIgnoreCase("Yes"))
		{

			String UMRevenue = dataForms.getData("Revenue");
			CustomReporting.logReport("The Revenue Value in UM is:" + UMRevenue, StepStatus.SUCCESS);
        	WebElement element = getWebDriver().findElement(By.xpath("//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiabilityEU_Esu_GLEScreen:rev-inputEl']"));
	        String PCRevenue= element.getText();
            CustomReporting.logReport("The Revenue value in PC is :" + PCRevenue, StepStatus.SUCCESS);
            if (PCRevenue.matches(UMRevenue)) 
			{
				CustomReporting.logReport(UMRevenue+" matches " + PCRevenue, StepStatus.SUCCESS);
			} else 
			{
			CustomReporting.logReport(UMRevenue+" does not match " + PCRevenue,StepStatus.FAILURE);
		    }
            func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
		if (dataForms.getData("DNO").equalsIgnoreCase("Yes"))
		{
		

			String UMCorporateAssests = dataForms.getData("CorporateAssets");
			CustomReporting.logReport("The CorporateAssests in UM is :" + UMCorporateAssests, StepStatus.SUCCESS);
        	WebElement element2 = getWebDriver().findElement(By.xpath("//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiabilityEU_Esu_GLEScreen:corpAssests-inputEl']"));
		    String PCCorporateAssests= element2.getText();
            CustomReporting.logReport("The CorporateAssests value in PC is :" + PCCorporateAssests, StepStatus.SUCCESS);

			if (UMCorporateAssests.matches(PCCorporateAssests)) {
			    CustomReporting.logReport(UMCorporateAssests+" matches" + PCCorporateAssests, StepStatus.SUCCESS);
			} else {
				CustomReporting.logReport(UMCorporateAssests+" does not match" + PCCorporateAssests, StepStatus.FAILURE);
			}
			
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
		if (dataForms.getData("EPL").equalsIgnoreCase("Yes"))
		{
		
		}
	}



	
}