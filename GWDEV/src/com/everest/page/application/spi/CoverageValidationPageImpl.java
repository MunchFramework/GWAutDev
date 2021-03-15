package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.CoverageValidationPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class CoverageValidationPageImpl extends CustomAbstractPage implements CoverageValidationPage {
	public void CoverageValidation(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataForms = PageDataManager.instance().getPageData("UmLogin", tcID);
		
		func._waitForPageToLoad(getWebDriver(), 100L);
		_wait(5000);
		/*String strScreenShots=dataForms.getData("PrintScreens");
		 
        if(strScreenShots.equalsIgnoreCase("Yes"))
        {
          func._takeBrowserScreenShot(getWebDriver(), "START", "", "");
        }*/
        String strURL="";
        WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		
		


		_click(getElement(tabCoverages));
		_wait(5000);
		_click(getElement(tabStandardCoverages));
		_wait(5000);
		if (dataForms.getData("Excess").equalsIgnoreCase("Yes"))
		{
			PageData dataForms1 = PageDataManager.instance().getPageData("EZExcess", tcID);
			String UMPrimaryLimit = (dataForms1.getData("PrimaryLimit").replaceAll("(\\s+|,)", ""));
			CustomReporting.logReport("The Primary Limit Value in UM is:" + UMPrimaryLimit, StepStatus.SUCCESS);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Primary Limit')]/../following-sibling::div/div")));
        	WebElement element = getWebDriver().findElement(By.xpath("//*[contains(text(),'Primary Limit')]/../following-sibling::div/div"));
	        
        	String PCPrimaryLimit= (element.getText().replaceAll("(\\s+|,)", ""));
            CustomReporting.logReport("The PCPrimaryLimit value in PC is :" + PCPrimaryLimit, StepStatus.SUCCESS);
            if (PCPrimaryLimit.matches(UMPrimaryLimit)) 
			{
				CustomReporting.logReport(UMPrimaryLimit+" matches " + PCPrimaryLimit, StepStatus.SUCCESS);
			} else 
			{
			CustomReporting.logReport(UMPrimaryLimit+" does not match " + PCPrimaryLimit,StepStatus.FAILURE);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}

            
			String UMPrecedingLayerAttachmentPoint = (dataForms1.getData("AttachmentPoint").replaceAll("(\\s+|,)", ""));
			CustomReporting.logReport("The UMPrecedingLayerAttachmentPoint Value in UM is:" + UMPrecedingLayerAttachmentPoint, StepStatus.SUCCESS);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Preceding Layer Attachment Point')]/../following-sibling::div/div")));
        	WebElement element1 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Preceding Layer Attachment Point')]/../following-sibling::div/div"));
	        
        	String PCPrecedingLayerAttachmentPoint= (element1.getText().replaceAll("(\\s+|,)", ""));
            CustomReporting.logReport("The PCPrecedingLayerAttachmentPoint value in PC is :" + PCPrecedingLayerAttachmentPoint, StepStatus.SUCCESS);
            if (PCPrecedingLayerAttachmentPoint.matches(UMPrecedingLayerAttachmentPoint)) 
			{
				CustomReporting.logReport(UMPrecedingLayerAttachmentPoint+" matches " + PCPrecedingLayerAttachmentPoint, StepStatus.SUCCESS);
			} else 
			{
			CustomReporting.logReport(UMPrecedingLayerAttachmentPoint+" does not match " + PCPrecedingLayerAttachmentPoint,StepStatus.FAILURE);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
            
			String UMPrecedingLayerPremium = (dataForms1.getData("PrecedingLayerPremium").replaceAll("(\\s+|,)", ""));
			CustomReporting.logReport("The UMPrecedingLayerPremium Value in UM is:" + UMPrecedingLayerPremium, StepStatus.SUCCESS);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Preceding Layer Premium')]/../following-sibling::div/div")));
        	WebElement element2 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Preceding Layer Premium')]/../following-sibling::div/div"));
	        
        	String PCPrecedingLayerPremium= (element2.getText().replaceAll("(\\s+|,)", ""));
            CustomReporting.logReport("The PCPrecedingLayerPremium value in PC is :" + PCPrecedingLayerPremium, StepStatus.SUCCESS);
            if (PCPrecedingLayerPremium.matches(UMPrecedingLayerPremium)) 
			{
				CustomReporting.logReport(UMPrecedingLayerPremium+" matches " + PCPrecedingLayerPremium, StepStatus.SUCCESS);
			} else 
			{
			CustomReporting.logReport(UMPrecedingLayerPremium+" does not match " + PCPrecedingLayerPremium,StepStatus.FAILURE);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
			
			String UMEverestLimit = (dataForms.getData("EverestLimit").replaceAll("(\\s+|,)", ""));
			CustomReporting.logReport("The UMEverestLimit Value in UM is:" + UMEverestLimit, StepStatus.SUCCESS);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Everest Limit')]/../following-sibling::div/div")));
        	WebElement element3 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Everest Limit')]/../following-sibling::div/div"));
	        
        	String PCEverestLimit= (element3.getText().replaceAll("(\\s+|,)", ""));
            CustomReporting.logReport("The PCEverestLimit value in PC is :" + PCEverestLimit, StepStatus.SUCCESS);
            if (PCPrecedingLayerPremium.matches(UMEverestLimit)) 
			{
				CustomReporting.logReport(UMEverestLimit+" matches " + PCEverestLimit, StepStatus.SUCCESS);
			} else 
			{
			CustomReporting.logReport(UMEverestLimit+" does not match " + PCEverestLimit,StepStatus.FAILURE);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
			
			String UMEverestAttachmentPoint = (dataForms.getData("EverestAttachmentPoint").replaceAll("(\\s+|,)", ""));
			CustomReporting.logReport("The UMEverestAttachmentPoint Value in UM is:" + UMEverestAttachmentPoint, StepStatus.SUCCESS);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Everest Attachment Point')]/../following-sibling::div/div")));
        	WebElement element4 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Everest Attachment Point')]/../following-sibling::div/div"));
	        
        	String PCEverestAttachmentPoint= (element4.getText().replaceAll("(\\s+|,)", ""));
            CustomReporting.logReport("The PCEverestAttachmentPoint value in PC is :" + PCEverestAttachmentPoint, StepStatus.SUCCESS);
            if (PCEverestAttachmentPoint.matches(UMEverestAttachmentPoint)) 
			{
				CustomReporting.logReport(UMEverestAttachmentPoint+" matches " + PCEverestAttachmentPoint, StepStatus.SUCCESS);
			} else 
			{
			CustomReporting.logReport(UMEverestAttachmentPoint+" does not match " + PCEverestAttachmentPoint,StepStatus.FAILURE);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
		}
		
		else
		{
		if (func._isVisible(getElement(tabCRI))) 
		{

			_click(getElement(tabCRI));

			String UMLimitPerOccurence = (dataForms.getData("LimitPerOccurence").replaceAll("(\\s+|,)", ""));
			CustomReporting.logReport("The LimitPerOccurence Value in UM is:" + UMLimitPerOccurence, StepStatus.SUCCESS);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Limit Per Occurrence')]/../following-sibling::div/div")));
        	WebElement element = getWebDriver().findElement(By.xpath("//*[contains(text(),'Limit Per Occurrence')]/../following-sibling::div/div"));
	        
        	String PCLimitValue= (element.getText().replaceAll("(\\s+|,)", ""));
            CustomReporting.logReport("The LimitPerOccurence value in PC is :" + PCLimitValue, StepStatus.SUCCESS);
            if (PCLimitValue.matches(UMLimitPerOccurence)) 
			{
				CustomReporting.logReport(UMLimitPerOccurence+" matches " + PCLimitValue, StepStatus.SUCCESS);
			} else 
			{
			CustomReporting.logReport(UMLimitPerOccurence+" does not match " + PCLimitValue,StepStatus.FAILURE);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}

			String UMDeductiblePerOccurence = (dataForms.getData("DeductiblePerOccurence").replaceAll("(\\s+|,)", ""));
			CustomReporting.logReport("The Deductible per occurence in UM is :" + UMDeductiblePerOccurence, StepStatus.SUCCESS);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Deductible Per Occurrence')]/../following-sibling::div/div")));
        	WebElement element2 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Deductible Per Occurrence')]/../following-sibling::div/div"));
		    String PCDeductibleValue= (element2.getText().replaceAll("(\\s+|,)", ""));
            CustomReporting.logReport("The Deductible per occurence value in PC is :" + PCDeductibleValue, StepStatus.SUCCESS);

			if (PCDeductibleValue.matches(UMDeductiblePerOccurence)) {
			    CustomReporting.logReport(UMDeductiblePerOccurence+" matches" + PCDeductibleValue, StepStatus.SUCCESS);
			} else {
				CustomReporting.logReport(UMDeductiblePerOccurence+" does not match" + PCDeductibleValue, StepStatus.FAILURE);
				  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
		}
		_wait(5000);
		if (func._isVisible(getElement(tabDno))) 
		{
			_click(getElement(tabDno));	
			
			String UMAggregateLimit = (dataForms.getData("DNOAggregateLimit").replaceAll("(\\s+|,)", ""));
			CustomReporting.logReport("The AggregateLimit Value in UM is:" + UMAggregateLimit, StepStatus.SUCCESS);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Aggregate')]/../following-sibling::div[1]/div")));
        	WebElement coverageDNO1 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Aggregate')]/../following-sibling::div[1]/div"));																							
        	String PCAggregateLimitValue= (coverageDNO1.getText().replaceAll("(\\s+|,)", ""));
            CustomReporting.logReport("The AggregateLimit value in PC is :" + PCAggregateLimitValue, StepStatus.SUCCESS);
            if (PCAggregateLimitValue.matches(UMAggregateLimit)) 
			{
				CustomReporting.logReport(UMAggregateLimit+" matches " + PCAggregateLimitValue, StepStatus.SUCCESS);
			} else 
			{
			CustomReporting.logReport(UMAggregateLimit+" does not match " + PCAggregateLimitValue,StepStatus.FAILURE);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
            
            String UMRetention = (dataForms.getData("DNORetention").replaceAll("(\\s+|,)", ""));
			CustomReporting.logReport("The Retention Value in UM is:" + UMRetention, StepStatus.SUCCESS);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Retention')]/../following-sibling::div[1]/div")));
        	WebElement elementDNO2 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Retention')]/../following-sibling::div[1]/div"));
	        String PCRetention= (elementDNO2.getText().replaceAll("(\\s+|,)", ""));
            CustomReporting.logReport("The Retention value in PC is :" + PCRetention, StepStatus.SUCCESS);
            if (PCRetention.matches(UMRetention)) 
			{
				CustomReporting.logReport(UMRetention+" matches " + PCRetention, StepStatus.SUCCESS);
			} else 
			{
			CustomReporting.logReport(UMRetention+" does not match " + PCRetention,StepStatus.FAILURE);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
            
//            String UMDate = dataForms.getData("DNOPriorDate");
//			CustomReporting.logReport("The Date Value in UM is:" + UMDate, StepStatus.SUCCESS);
//        	WebElement elementDNO3 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Pending or Prior Date')]/../following-sibling::div[1]/div"));
//	        String PCDate= elementDNO3.getText();
//            CustomReporting.logReport("The Date value in PC is :" + PCDate, StepStatus.SUCCESS);
//            if (PCDate.matches(UMDate)) 
//			{
//				CustomReporting.logReport(UMDate+" matches " + PCDate, StepStatus.SUCCESS);
//			} else 
//			{
//			CustomReporting.logReport(UMDate+" does not match " + PCDate,StepStatus.FAILURE);
//			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
//			}
		}
		_wait(5000);
		if (func._isVisible(getElement(tabEPL))) 
		{
			_click(getElement(tabEPL));	
			_wait(5000);
			String UMEPLAggregateLimit = dataForms.getData("EPLAggregateLimit");
			CustomReporting.logReport("The AggregateLimit Value in UM is:" + UMEPLAggregateLimit, StepStatus.SUCCESS);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Aggregate Limit of Liability')]/../following-sibling::div/div")));
        	WebElement elementEPL = getWebDriver().findElement(By.xpath("//*[contains(text(),'Aggregate Limit of Liability')]/../following-sibling::div/div"));
        	_wait(2000);
        	String PCEPLAggregateLimitValue = (elementEPL.getText().replaceAll("(\\s+|,)", ""));
            CustomReporting.logReport("The AggregateLimit value in PC is :" + PCEPLAggregateLimitValue, StepStatus.SUCCESS);
            _wait(2000);
            if (PCEPLAggregateLimitValue.matches(UMEPLAggregateLimit)) 
			{
				CustomReporting.logReport(UMEPLAggregateLimit+" matches " + PCEPLAggregateLimitValue, StepStatus.SUCCESS);
			} else 
			{
			CustomReporting.logReport(UMEPLAggregateLimit+" does not match " + PCEPLAggregateLimitValue,StepStatus.FAILURE);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
            
            String UMEPLRetention = dataForms.getData("EPLRetention");
			CustomReporting.logReport("The Retention Value in UM is:" + UMEPLRetention, StepStatus.SUCCESS);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Retention')]/../following-sibling::div[1]/div")));
        	WebElement elementEPL2 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Retention')]/../following-sibling::div[1]/div"));
        	_wait(2000);
        	String PCEPLRetention= (elementEPL2.getText().replaceAll("(\\s+|,)", ""));	        	
	        CustomReporting.logReport("The Retention value in PC is :" + PCEPLRetention, StepStatus.SUCCESS);
            if (PCEPLRetention.matches(UMEPLRetention)) 
			{
				CustomReporting.logReport(UMEPLRetention+" matches " + PCEPLRetention, StepStatus.SUCCESS);
			} else 
			{
			CustomReporting.logReport(UMEPLRetention+" does not match " + PCEPLRetention,StepStatus.FAILURE);
		    }
            
            String UMEPLDate = dataForms.getData("EPLDate");
//			CustomReporting.logReport("The Date Value in UM is:" + UMEPLDate, StepStatus.SUCCESS);
//        	WebElement elementEPL3 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Pending or Prior Date')]/../following-sibling::div[1]/div"));
//        	_wait(2000);
//        	String PCEPLDate= elementEPL3.getText();
//            CustomReporting.logReport("The Date value in PC is :" + PCEPLDate, StepStatus.SUCCESS);
//            if (PCEPLDate.matches(UMEPLDate)) 
//			{
//				CustomReporting.logReport(PCEPLDate+" matches " + UMEPLDate, StepStatus.SUCCESS);
//			} else 
//			{
//			CustomReporting.logReport(PCEPLDate+" does not match " + UMEPLDate,StepStatus.FAILURE);
//			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
//			}
		}
		if (func._isVisible(getElement(tabCYB))) 
		{

			_click(getElement(tabCYB));
			PageData dataForms1 = PageDataManager.instance().getPageData("CYB", tcID);

			String UMCYBAggregateLimitOfLiability = (dataForms1.getData("CYBAggregateLimit").replaceAll("(\\s+|,)", ""));
			CustomReporting.logReport("The CYB Aggregate Limit of Liability Value in UM is:" + UMCYBAggregateLimitOfLiability, StepStatus.SUCCESS);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Aggregate Limit of Liability')]/../following-sibling::div[1]/div[1]")));
			WebElement element = getWebDriver().findElement(By.xpath("//*[contains(text(),'Aggregate Limit of Liability')]/../following-sibling::div[1]/div[1]"));
	        String PCAggregateLimitOfLiabilityValue = (element.getText().replaceAll("(\\s+|,)", ""));
            CustomReporting.logReport("The CYB Aggregate Limit of Liability Value in PC is :" + PCAggregateLimitOfLiabilityValue, StepStatus.SUCCESS);
            if (PCAggregateLimitOfLiabilityValue.matches(UMCYBAggregateLimitOfLiability)) 
			{
				CustomReporting.logReport(UMCYBAggregateLimitOfLiability+" matches " + PCAggregateLimitOfLiabilityValue, StepStatus.SUCCESS);
			} else 
			{
			CustomReporting.logReport(UMCYBAggregateLimitOfLiability+" does not match " + PCAggregateLimitOfLiabilityValue,StepStatus.FAILURE);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}

			String UMRetention = (dataForms1.getData("CYBRetention").replaceAll("(\\s+|,)", ""));
			CustomReporting.logReport("The CYB Retention in UM is :" + UMRetention, StepStatus.SUCCESS);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Cyber')]/../..//*[contains(text(),'Retention')]/../following-sibling::div[1]/div[1]")));
        	WebElement element2 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Cyber')]/../..//*[contains(text(),'Retention')]/../following-sibling::div[1]/div[1]"));
		    String PCRetentionValue = (element2.getText().replaceAll("(\\s+|,)", ""));
            CustomReporting.logReport("The Retention Value value in PC is :" + PCRetentionValue, StepStatus.SUCCESS);

			if (PCRetentionValue.matches(UMRetention)) {
			    CustomReporting.logReport(UMRetention+" matches" + PCRetentionValue, StepStatus.SUCCESS);
			} else {
				CustomReporting.logReport(UMRetention+" does not match" + PCRetentionValue, StepStatus.FAILURE);
				  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
		}
	

	if (func._isVisible(getElement(tabEMP))) 
	{

		_click(getElement(tabEMP));
		PageData dataForms1 = PageDataManager.instance().getPageData("EMP", tcID);

		String UMEMPAggregateLimitOfLiability = (dataForms1.getData("EMPAggregateLimit").replaceAll("(\\s+|,)", ""));
		CustomReporting.logReport("The EMP Aggregate Limit of Liability Value in UM is:" + UMEMPAggregateLimitOfLiability, StepStatus.SUCCESS);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Aggregate Limit of Liability')]/../following-sibling::div[1]/div[1]")));
		WebElement element = getWebDriver().findElement(By.xpath("//*[contains(text(),'Aggregate Limit of Liability')]/../following-sibling::div[1]/div[1]"));
        String PCAggregateLimitOfLiabilityValue = (element.getText().replaceAll("(\\s+|,)", ""));
        CustomReporting.logReport("The EMP Aggregate Limit of Liability Value in PC is :" + PCAggregateLimitOfLiabilityValue, StepStatus.SUCCESS);
        if (PCAggregateLimitOfLiabilityValue.matches(UMEMPAggregateLimitOfLiability)) 
		{
			CustomReporting.logReport(UMEMPAggregateLimitOfLiability+" matches " + PCAggregateLimitOfLiabilityValue, StepStatus.SUCCESS);
		} else 
		{
		CustomReporting.logReport(UMEMPAggregateLimitOfLiability+" does not match " + PCAggregateLimitOfLiabilityValue,StepStatus.FAILURE);
		  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}

		String UMRetention = (dataForms1.getData("EMPRetention").replaceAll("(\\s+|,)", ""));
		CustomReporting.logReport("The EMP Retention in UM is :" + UMRetention, StepStatus.SUCCESS);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Retention')]/../following-sibling::div[1]/div")));
    	WebElement element2 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Retention')]/../following-sibling::div[1]/div"));
	    String PCRetentionValue = (element2.getText().replaceAll("(\\s+|,)", ""));
        CustomReporting.logReport("The Retention Value value in PC is :" + PCRetentionValue, StepStatus.SUCCESS);

		if (PCRetentionValue.matches(UMRetention)) {
		    CustomReporting.logReport(UMRetention+" matches" + PCRetentionValue, StepStatus.SUCCESS);
		} else {
			CustomReporting.logReport(UMRetention+" does not match" + PCRetentionValue, StepStatus.FAILURE);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
	}

	if (func._isVisible(getElement(tabENO))) 
	{

		_click(getElement(tabENO));
		PageData dataForms1 = PageDataManager.instance().getPageData("ENO", tcID);

		String UMENOAggregateLimitOfLiability = (dataForms1.getData("ENOAggregateLimit").replaceAll("(\\s+|,)", ""));
		CustomReporting.logReport("The ENO Aggregate Limit of Liability Value in UM is:" + UMENOAggregateLimitOfLiability, StepStatus.SUCCESS);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Aggregate Limit of Liability')]/../following-sibling::div[1]/div[1]")));
		WebElement element = getWebDriver().findElement(By.xpath("//*[contains(text(),'Aggregate Limit of Liability')]/../following-sibling::div[1]/div[1]"));
        String PCAggregateLimitOfLiabilityValue = (element.getText().replaceAll("(\\s+|,)", ""));
        CustomReporting.logReport("The ENO Aggregate Limit of Liability Value in PC is :" + PCAggregateLimitOfLiabilityValue, StepStatus.SUCCESS);
        if (PCAggregateLimitOfLiabilityValue.matches(UMENOAggregateLimitOfLiability)) 
		{
			CustomReporting.logReport(UMENOAggregateLimitOfLiability+" matches " + PCAggregateLimitOfLiabilityValue, StepStatus.SUCCESS);
		} else 
		{
		CustomReporting.logReport(UMENOAggregateLimitOfLiability+" does not match " + PCAggregateLimitOfLiabilityValue,StepStatus.FAILURE);
		  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}

		String UMRetention = (dataForms1.getData("ENORetention").replaceAll("(\\s+|,)", ""));
		CustomReporting.logReport("The ENO Retention in UM is :" + UMRetention, StepStatus.SUCCESS);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Retention')]/../following-sibling::div[1]/div")));
    	WebElement element2 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Retention')]/../following-sibling::div[1]/div"));
	    String PCRetentionValue = (element2.getText().replaceAll("(\\s+|,)", ""));
        CustomReporting.logReport("The Retention Value value in PC is :" + PCRetentionValue, StepStatus.SUCCESS);

		if (PCRetentionValue.matches(UMRetention)) {
		    CustomReporting.logReport(UMRetention+" matches" + PCRetentionValue, StepStatus.SUCCESS);
		} else {
			CustomReporting.logReport(UMRetention+" does not match" + PCRetentionValue, StepStatus.FAILURE);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
	}


if (func._isVisible(getElement(tabFID))) 
{
	_click(getElement(tabFID));
	PageData dataForms1 = PageDataManager.instance().getPageData("FID", tcID);

	String UMFIDAggregateLimitOfLiability = (dataForms1.getData("FIDAggregateLimit").replaceAll("(\\s+|,)", ""));
	CustomReporting.logReport("The FID Aggregate Limit of Liability Value in UM is:" + UMFIDAggregateLimitOfLiability, StepStatus.SUCCESS);
	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Aggregate Limit of Liability')]/../following-sibling::div[1]/div[1]")));
	WebElement element = getWebDriver().findElement(By.xpath("//*[contains(text(),'Aggregate Limit of Liability')]/../following-sibling::div[1]/div[1]"));
    String PCAggregateLimitOfLiabilityValue = (element.getText().replaceAll("(\\s+|,)", ""));
    CustomReporting.logReport("The FID Aggregate Limit of Liability Value in PC is :" + PCAggregateLimitOfLiabilityValue, StepStatus.SUCCESS);
    if (PCAggregateLimitOfLiabilityValue.matches(UMFIDAggregateLimitOfLiability)) 
	{
		CustomReporting.logReport(UMFIDAggregateLimitOfLiability+" matches " + PCAggregateLimitOfLiabilityValue, StepStatus.SUCCESS);
	} else 
	{
	CustomReporting.logReport(UMFIDAggregateLimitOfLiability+" does not match " + PCAggregateLimitOfLiabilityValue,StepStatus.FAILURE);
	  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	}

	String UMRetention = (dataForms1.getData("FIDRetention").replaceAll("(\\s+|,)", ""));
	CustomReporting.logReport("The FID Retention in UM is :" + UMRetention, StepStatus.SUCCESS);
	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Retention')]/../following-sibling::div[1]/div")));
	WebElement element2 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Retention')]/../following-sibling::div[1]/div"));
    String PCRetentionValue = (element2.getText().replaceAll("(\\s+|,)", ""));
    CustomReporting.logReport("The Retention Value value in PC is :" + PCRetentionValue, StepStatus.SUCCESS);

	if (PCRetentionValue.matches(UMRetention)) {
	    CustomReporting.logReport(UMRetention+" matches" + PCRetentionValue, StepStatus.SUCCESS);
	} else {
		CustomReporting.logReport(UMRetention+" does not match" + PCRetentionValue, StepStatus.FAILURE);
		  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	}
}
	
	if (func._isVisible(getElement(tabKNR))) 
	{
		_click(getElement(tabKNR));
		PageData dataForms1 = PageDataManager.instance().getPageData("KNR", tcID);
		
		String UMRansomLimitofLiabilty = (dataForms1.getData("RansomLimitOfLiability").replaceAll("(\\s+|,)", ""));
		CustomReporting.logReport("The KNR Ransom Limit of Liability Value in UM is:" + UMRansomLimitofLiabilty, StepStatus.SUCCESS);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Limit of Liability')]/../following-sibling::div[1]/div[1]")));
		WebElement element = getWebDriver().findElement(By.xpath("(//*[contains(text(),'Limit of Liability')]/../following-sibling::div[1]/div[1])[2]"));
	    String PCRansomLimitOfLiabilityValue = (element.getText().replaceAll("(\\s+|,)", ""));
	    CustomReporting.logReport("The KNR Ransom Limit of Liability Value in PC is :" + PCRansomLimitOfLiabilityValue, StepStatus.SUCCESS);
	    if (UMRansomLimitofLiabilty.matches(PCRansomLimitOfLiabilityValue)) 
		{
			CustomReporting.logReport(UMRansomLimitofLiabilty+" matches " + PCRansomLimitOfLiabilityValue, StepStatus.SUCCESS);
		} else 
		{
		CustomReporting.logReport(UMRansomLimitofLiabilty+" does not match " + PCRansomLimitOfLiabilityValue,StepStatus.FAILURE);
		  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}

		String UMDeductible = (dataForms1.getData("RansomDeductible").replaceAll("(\\s+|,)", ""));
		CustomReporting.logReport("The KNR Deductible in UM is :" + UMDeductible, StepStatus.SUCCESS);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Deductible')]/../following-sibling::div[1]/div")));
		WebElement element2 = getWebDriver().findElement(By.xpath("//*[contains(text(),'Deductible')]/../following-sibling::div[1]/div"));
	    String PCDeductibleValue = (element2.getText().replaceAll("(\\s+|,)", ""));
	    CustomReporting.logReport("The Deductible Value value in PC is :" + PCDeductibleValue, StepStatus.SUCCESS);

		if (PCDeductibleValue.matches(UMDeductible)) {
		    CustomReporting.logReport(UMDeductible+" matches" + PCDeductibleValue, StepStatus.SUCCESS);
		} else {
			CustomReporting.logReport(UMDeductible+" does not match" + PCDeductibleValue, StepStatus.FAILURE);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
	}
	}	
}
}
