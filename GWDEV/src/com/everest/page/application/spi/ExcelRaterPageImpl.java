package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.ExcelRaterPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class ExcelRaterPageImpl extends CustomAbstractPage implements ExcelRaterPage {
	public void excelRater(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataForms = PageDataManager.instance().getPageData("ExcelRater", tcID);
		func._waitForPageToLoad(getWebDriver(), 100L);
		_wait(5000);
		_click(getElement(tabPremiumSummary));
		String ExcelRaterCRISubtotal = dataForms.getData("CRISubtotal");
		String ExcelRaterDNOSubtotal = dataForms.getData("DNOSubtotal");
		String ExcelRaterEPLSubtotal = dataForms.getData("EPLSubtotal");
		String ExcelRaterTotalPremium = dataForms.getData("TotalPremium");
		
		

		if (func._isVisible(getElement(tabEPL)) == true)
		{
			_click(getElement(tabEPL));
			String ExcelRaterEPLBasePremium = dataForms.getData("EPLBasePremium");
			String ExcelRaterEPLLimitRetention = dataForms.getData("EPLLimitRetention");
			String ExcelRaterEPLDiscretionaryFactors = dataForms.getData("EPLDiscretionaryFactors");
			String ExcelRaterEPLScheduleRating = dataForms.getData("EPLScheduleRating");
			String ExcelRaterEPLOptCovEnhancement = dataForms.getData("EPLOptCovEnhancement");
			
			
		//	CustomReporting.logReport("The Value in UM is:" + UMEPLBasePremium, StepStatus.SUCCESS);
        	WebElement element = getWebDriver().findElement(By.xpath("//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiabilityEU_Esu_GLEScreen:rev-inputEl']"));
	        String UMEPLBasePremium= element.getText();
            CustomReporting.logReport("The Revenue value in ExcelRater is :" + ExcelRaterEPLBasePremium, StepStatus.SUCCESS);
            if (UMEPLBasePremium.matches(ExcelRaterEPLBasePremium)) 
			{
				CustomReporting.logReport(UMEPLBasePremium+" matches " + ExcelRaterEPLBasePremium, StepStatus.SUCCESS);
			} else 
			{
			CustomReporting.logReport(UMEPLBasePremium+" does not match " + ExcelRaterEPLBasePremium,StepStatus.FAILURE);
		    }
		}
		if (dataForms.getData("DNO").equalsIgnoreCase("Yes"))
		{
		

			String UMCorporateAssests = dataForms.getData("txtCorporateAssets");
			CustomReporting.logReport("The CorporateAssests in UM is :" + UMCorporateAssests, StepStatus.SUCCESS);
        	WebElement element2 = getWebDriver().findElement(By.xpath("//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiabilityEU_Esu_GLEScreen:corpAssests-inputEl']"));
		    String PCCorporateAssests= element2.getText();
            CustomReporting.logReport("The CorporateAssests value in PC is :" + PCCorporateAssests, StepStatus.SUCCESS);

			if (UMCorporateAssests.matches(PCCorporateAssests)) {
			    CustomReporting.logReport(UMCorporateAssests+" matches" + PCCorporateAssests, StepStatus.SUCCESS);
			} else {
				CustomReporting.logReport(UMCorporateAssests+" does not match" + PCCorporateAssests, StepStatus.FAILURE);
			}
		}
		if (dataForms.getData("EPL").equalsIgnoreCase("Yes"))
		{
		
		}
	}


		
	}



	
