package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmRatingCommonPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmRatingCommonPageImpl extends CustomAbstractPage implements UmRatingCommonPage {

	@Override
	public void UmRatingCommon(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		_wait(12000);
		_wait(2000);
		_click(getElement(btnCommission));
				_wait(2000);
				if (func._isVisible(getElement(chkCRI)) == true)
				{
				_click(getElement(chkCRI));
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				_wait(1000);
				if (func._isVisible(getElement(chkDNO)) == true)
				{
				_click(getElement(chkDNO));
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				_wait(1000);
				if (func._isVisible(getElement(chkEPL)) == true)
				{
				_click(getElement(chkEPL));
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				_wait(1000);
				if (func._isVisible(getElement(chkEMP)) == true)
				{
				_click(getElement(chkEMP));
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				_wait(1000);
				if (func._isVisible(getElement(chkENO)) == true)
				{
				_click(getElement(chkENO));
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				_wait(1000);
				if (func._isVisible(getElement(chkFID)) == true)
				{
				_click(getElement(chkFID));
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				_wait(1000);
				if (func._isVisible(getElement(chkKNR)) == true)
				{
				_click(getElement(chkKNR));
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				_wait(1000);
				if (func._isVisible(getElement(chkCYB)) == true)
				{
				_click(getElement(chkCYB));
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
		_wait(4000);
		_setValue(getElement(txtCommission), dataUmLogin.getData("Commission"));
		_clickTab();
		_wait(2000);
	
		_wait(5000);
		_click(getElement(btnGetRater));
		_wait(10000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
//		_click(getElement(btnRatingCommontab));
		
		_wait(12000);
//		getWebDriver().navigate().refresh();
		_wait(5000);
		
		if (func._isVisible(getElement(txtCMSharedSeparateDefenseCost)) == false)
		{
			_wait(10000);
			if (func._isVisible(getElement(btnGetRater)) == true)
					{
			_click(getElement(btnGetRater));
					}
			WebDriverWait w = new WebDriverWait(getWebDriver(),250);
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

		}
//		_setValue(getElement(txtCMSharedLimits), dataUmLogin.getData("CMSharedLimits"));
//		_clickTab();
//		_wait(5000);
//		_setValue(getElement(txtCMSharedSeparateDefenseCost), dataUmLogin.getData("CMSharedSeparateDefenseCost"));
//		_clickTab();
//		_clickTab();
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		_wait(5000);
		getWebDriver().navigate().refresh();
		_wait(5000);
		_wait(3000);
			_setValue(getElement(txtPercentageAnnualPremium), dataUmLogin.getData("PercentageAnnualPremium"));
			//func.setValue2(getElement(txtPercentageAnnualPremium));
			//_clickEnter();
			func.setValue3(getElement(txtPercentageAnnualPremium));
			//_clickTab();
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			
			if (func._isVisible(getElement(txtPercentageAnnualPremium2)) == true)
			{
				
				_setValue(getElement(txtPercentageAnnualPremium2), dataUmLogin.getData("PercentageAnnualPremium2"));
				func.setValue3(getElement(txtPercentageAnnualPremium2));
				_setValue(getElement(txtAdditionalPeriod1), dataUmLogin.getData("AdditionalPeriod1"));
				func.setValue3(getElement(txtAdditionalPeriod1));
				_wait(2000);
				_setValue(getElement(txtPercentageAnnualPremium3), dataUmLogin.getData("PercentageAnnualPremium3"));
				func.setValue3(getElement(txtPercentageAnnualPremium3));
				_setValue(getElement(txtAdditionalPeriod2), dataUmLogin.getData("AdditionalPeriod2"));
				func.setValue3(getElement(txtAdditionalPeriod2));
				
			}
//			_setValue(getElement(txtAdditionalPeriod), dataUmLogin.getData("txtAdditionalPeriod"));
//			_clickEnter();
//			_wait(2000);

//			_click(getElement(ddERPCoverageStatus));
//	        _setValue(getElement(txtERPCoverageStatus), dataUmLogin.getData("ERPCoverageStatus"));
//			_wait(2000);
//	        func.setValue2(getElement(txtERPCoverageStatus));
////	        //_clickEnter();
////			_wait(4000);
			
			
//			_click(getElement(btnCreateProposal));
//			_wait(6000);
//		
	}

	@Override
	public void UmClickGetRater(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		String strScreenShots = dataUmLogin.getData("PrintScreens");
		if (strScreenShots.equalsIgnoreCase("Yes")) {
			func._takeScreenShot(getWebDriver(), "START", "", "");
		}
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		
		   while(getWebDriver().findElements(By.xpath
	        		 ("//button[@class='btn-link glyphicon glyphicon-chevron-right ng-scope enableTransition']")).size()>0
	        		 ) {
	      		 
	        		 getWebDriver().findElement(By.xpath
	    	        		 ("(//button[@class='btn-link glyphicon glyphicon-chevron-right ng-scope enableTransition'])")).click();
	        		 
	        		 _wait(2000);   		      		
	        	 
	         } 
		
		if(func._isVisible(getElement(btnRatingEZExcess))) {
			
			_click(getElement(btnRatingEZExcess));
		}
		else if(func._isVisible(getElement(btnRatingSlimCommontab))) {
			
			_click(getElement(btnRatingSlimCommontab));
			
		}
		else {
		_click(getElement(btnRatingCommontab));
		}
		_wait(12000);
		
	
		_wait(5000);
		_click(getElement(btnGetRater));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		_wait(10000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		
	}


	@Override
	public void UmUpdateRatingCommon(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		String strScreenShots = dataUmLogin.getData("PrintScreens");
		if (strScreenShots.equalsIgnoreCase("Yes")) {
			func._takeScreenShot(getWebDriver(), "START", "", "");
		}
		_wait(12000);
		_wait(2000);
		_click(getElement(btnCommission));
				_wait(2000);
				if (func._isVisible(getElement(chkCRI)) == true)
				{
				_click(getElement(chkCRI));
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				_wait(1000);
				if (func._isVisible(getElement(chkDNO)) == true)
				{
				_click(getElement(chkDNO));
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				_wait(1000);
				if (func._isVisible(getElement(chkEPL)) == true)
				{
				_click(getElement(chkEPL));
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				_wait(1000);
				if (func._isVisible(getElement(chkEMP)) == true)
				{
				_click(getElement(chkEMP));
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				_wait(1000);
				if (func._isVisible(getElement(chkENO)) == true)
				{
				_click(getElement(chkENO));
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				_wait(1000);
				if (func._isVisible(getElement(chkFID)) == true)
				{
				_click(getElement(chkFID));
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				_wait(1000);
				if (func._isVisible(getElement(chkKNR)) == true)
				{
				_click(getElement(chkKNR));
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				_wait(1000);
				if (func._isVisible(getElement(chkCYB)) == true)
				{
				_click(getElement(chkCYB));
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
		_wait(4000);
		_setValue(getElement(txtCommission), dataUmLogin.getData("Commission"));
		_clickTab();
		_wait(2000);
	
		_wait(5000);
		_click(getElement(btnGetRater));
		_wait(10000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
//		_click(getElement(btnRatingCommontab));
		
		_wait(12000);
//		getWebDriver().navigate().refresh();
		_wait(5000);
		
		if (func._isVisible(getElement(txtCMSharedSeparateDefenseCost)) == false)
		{
			_wait(10000);
			if (func._isVisible(getElement(btnGetRater)) == true)
					{
			_click(getElement(btnGetRater));
					}
			
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

		}
//		_setValue(getElement(txtCMSharedLimits), dataUmLogin.getData("CMSharedLimits"));
//		_clickTab();
//		_wait(5000);
//		_setValue(getElement(txtCMSharedSeparateDefenseCost), dataUmLogin.getData("CMSharedSeparateDefenseCost"));
//		_clickTab();
//		_clickTab();
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		
//    	getWebDriver().navigate().refresh();
	
			if(!(dataUmLogin.getData("ERPCoverageStatus").equalsIgnoreCase(""))) {
			_click(getElement(txtERPCoverageStatus1));
		//	_setValue(getElement(txtERPCoverageStatus1), dataUmLogin.getData("ERPCoverageStatus"));
			_wait(4000);
			String expoption= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("ERPCoverageStatus")+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			expectedOption.click();
			}
			

			if(!(dataUmLogin.getData("ERPRiskClassification").equalsIgnoreCase(""))) {
			_click(getElement(txtERPRiskClassification));
			_wait(2000);
		//	_setValue(getElement(txtERPRiskClassification), dataUmLogin.getData("ERPRiskClassification"));
			_wait(4000);
			String expoption= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("ERPRiskClassification")+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			expectedOption.click();
			
			_click(getElement(btnUpdateCoverages));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			
			}
			
			

			
			_setValue(getElement(txtERPPercentageAnnualPremium), dataUmLogin.getData("PercentageAnnualPremium"));
			func.setValue3(getElement(txtERPPercentageAnnualPremium));
			
			_click(getElement(btnUpdateCoverages));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			if(!(dataUmLogin.getData("RunOffRiskClassification").equalsIgnoreCase(""))) {
				_click(getElement(txtRunOffRiskClassification));
				_wait(2000);
		//		_setValue(getElement(txtRunOffRiskClassification), dataUmLogin.getData("RunOffRiskClassification"));
				_wait(4000);
				String expoption= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("RunOffRiskClassification")+"\")]";
				WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
				expectedOption.click();
				}
			
			_click(getElement(btnUpdateCoverages));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			
	/*		if (func._isVisible(getElement(txtPercentageAnnualPremium2)) == true)
			{
				
				_setValue(getElement(txtPercentageAnnualPremium2), dataUmLogin.getData("PercentageAnnualPremium2"));
				func.setValue3(getElement(txtPercentageAnnualPremium2));
				_setValue(getElement(txtAdditionalPeriod1), dataUmLogin.getData("AdditionalPeriod1"));
				func.setValue3(getElement(txtAdditionalPeriod1));
				_wait(2000);
				_setValue(getElement(txtPercentageAnnualPremium3), dataUmLogin.getData("PercentageAnnualPremium3"));
				func.setValue3(getElement(txtPercentageAnnualPremium3));
				_setValue(getElement(txtAdditionalPeriod2), dataUmLogin.getData("AdditionalPeriod2"));
				func.setValue3(getElement(txtAdditionalPeriod2));
				
			} */
//			_setValue(getElement(txtAdditionalPeriod), dataUmLogin.getData("txtAdditionalPeriod"));
//			_clickEnter();
//			_wait(2000);

//			_click(getElement(ddERPCoverageStatus));
//	        _setValue(getElement(txtERPCoverageStatus), dataUmLogin.getData("ERPCoverageStatus"));
//			_wait(2000);
//	        func.setValue2(getElement(txtERPCoverageStatus));
////	        //_clickEnter();
////			_wait(4000);
			
			
//			_click(getElement(btnCreateProposal));
//			_wait(6000);
//		
	}


	@Override
	public void UmValidateRatingCommon(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		/*String strScreenShots = dataUmLogin.getData("PrintScreens");
		if (strScreenShots.equalsIgnoreCase("Yes")) {
			func._takeScreenShot(getWebDriver(), "START", "", "");
		}*/
		
		long startTime = System.currentTimeMillis();
		String ExpectedRunOffPercentageAnnualPrem1="";
		String ExpectedRunOffPercentageAnnualPrem3="";
		String ExpectedRunOffPercentageAnnualPrem6="";
		
		
		getWebDriver().findElement(By.xpath("//span[contains(text(),'Policy Issuance')]")).click();
		
		_wait(3000);
		
		getWebDriver().findElement(By.xpath("//span[text()='Rating: Common']")).click();
		
		
		if(dataUmLogin.getData("RunOffRiskClassification").equalsIgnoreCase("Average")) {
			
			ExpectedRunOffPercentageAnnualPrem1="100";
			ExpectedRunOffPercentageAnnualPrem3="125";
			ExpectedRunOffPercentageAnnualPrem6="150";
		}else if(dataUmLogin.getData("RunOffRiskClassification").equalsIgnoreCase("Low")) {
			ExpectedRunOffPercentageAnnualPrem1="75";
			ExpectedRunOffPercentageAnnualPrem3="100";
			ExpectedRunOffPercentageAnnualPrem6="125";
		}else if(dataUmLogin.getData("RunOffRiskClassification").equalsIgnoreCase("Moderate")) {
			ExpectedRunOffPercentageAnnualPrem1="150";
			ExpectedRunOffPercentageAnnualPrem3="250";
			ExpectedRunOffPercentageAnnualPrem6="350";
		}else if(dataUmLogin.getData("RunOffRiskClassification").equalsIgnoreCase("Moderate")) {
			ExpectedRunOffPercentageAnnualPrem1="200";
			ExpectedRunOffPercentageAnnualPrem3="350";
			ExpectedRunOffPercentageAnnualPrem6="500";
		}
		
		String UmActualERPPerOfAnnualPremium=getElement(txtERPPercentageAnnualPremium).getAttribute("value");
		
		String ExpectedERPPerOfAnnualPremium=dataUmLogin.getData("PercentageAnnualPremium");
		String UmActualERPCoverageStatus=func._getAttributeValue(getElement(txtERPCoverageStatus1), "TEXT");
		
		String ExpectedERPCoverageStatus=dataUmLogin.getData("ERPCoverageStatus");
		String UmActualERPRiskClassification=func._getAttributeValue(getElement(txtERPRiskClassification), "TEXT");
		String ExpectedERPRiskClassification=dataUmLogin.getData("ERPRiskClassification");
		String UmActualRunOffRiskClassification=func._getAttributeValue(getElement(txtRunOffRiskClassification), "TEXT");
		
		
		String ExpectedRunOffRiskClassification=dataUmLogin.getData("RunOffRiskClassification");		
		String UmActualRunOffPercentageAnnualPrem1=getElement(txtPercentageAnnualPrem1).getAttribute("value");
		String UmActualRunOffPercentageAnnualPrem3=getElement(txtPercentageAnnualPrem3).getAttribute("value");
		String UmActualRunOffPercentageAnnualPrem6=getElement(txtPercentageAnnualPrem6).getAttribute("value");
		
		CustomReporting.logReport("Validating ERP and Run-Off coverage Fields");
		
		func._scrollToElement(getElement(txtPercentageAnnualPrem1));
		_wait(3000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
	if(UmActualERPPerOfAnnualPremium.contains(ExpectedERPPerOfAnnualPremium)) {
			
			CustomReporting.logReport("", "", "Actual Value: " + UmActualERPPerOfAnnualPremium + "is as expected: " + ExpectedERPPerOfAnnualPremium, StepStatus.SUCCESS, new String[] {},
					startTime);
		}else {
			
			CustomReporting.logReport("", "", "Actual  Value: " + UmActualERPPerOfAnnualPremium + "is not as expected: "+ ExpectedERPPerOfAnnualPremium, StepStatus.FAILURE, new String[] {},
					startTime);
		}
	
if(UmActualERPCoverageStatus.contains(ExpectedERPCoverageStatus)) {
		
		CustomReporting.logReport("", "", "Actual Value: " + UmActualERPCoverageStatus + "is as expected: " + ExpectedERPCoverageStatus, StepStatus.SUCCESS, new String[] {},
				startTime);
	}else {
		
		CustomReporting.logReport("", "", "Actual  Value: " + UmActualERPCoverageStatus + "is not as expected: "+ ExpectedERPCoverageStatus, StepStatus.FAILURE, new String[] {},
				startTime);
	}
if(UmActualERPRiskClassification.contains(ExpectedERPRiskClassification)) {
	
	CustomReporting.logReport("", "", "Actual Value: " + UmActualERPRiskClassification + "is as expected: " + ExpectedERPRiskClassification, StepStatus.SUCCESS, new String[] {},
			startTime);
}else {
	
	CustomReporting.logReport("", "", "Actual  Value: " + UmActualERPRiskClassification + "is not as expected: "+ ExpectedERPRiskClassification, StepStatus.FAILURE, new String[] {},
			startTime);
}


if(UmActualRunOffRiskClassification.contains(ExpectedRunOffRiskClassification)) {
	
	CustomReporting.logReport("", "", "Actual Value: " + UmActualRunOffRiskClassification + "is as expected: " + ExpectedRunOffRiskClassification, StepStatus.SUCCESS, new String[] {},
			startTime);
}else {
	
	CustomReporting.logReport("", "", "Actual  Value: " + UmActualRunOffRiskClassification + "is not as expected: "+ ExpectedRunOffRiskClassification, StepStatus.FAILURE, new String[] {},
			startTime);
}

if(UmActualRunOffPercentageAnnualPrem1.contains(ExpectedRunOffPercentageAnnualPrem1)) {
	
	CustomReporting.logReport("", "", "Actual Value: " + UmActualRunOffPercentageAnnualPrem1 + "is as expected: " + ExpectedRunOffPercentageAnnualPrem1, StepStatus.SUCCESS, new String[] {},
			startTime);
}else {
	
	CustomReporting.logReport("", "", "Actual  Value: " + UmActualRunOffPercentageAnnualPrem1 + "is not as expected: "+ ExpectedRunOffPercentageAnnualPrem1, StepStatus.FAILURE, new String[] {},
			startTime);
}

if(UmActualRunOffPercentageAnnualPrem3.contains(ExpectedRunOffPercentageAnnualPrem3)) {
	
	CustomReporting.logReport("", "", "Actual Value: " + UmActualRunOffPercentageAnnualPrem3 + "is as expected: " + ExpectedRunOffPercentageAnnualPrem3, StepStatus.SUCCESS, new String[] {},
			startTime);
}else {
	
	CustomReporting.logReport("", "", "Actual  Value: " + UmActualRunOffPercentageAnnualPrem3 + "is not as expected: "+ ExpectedRunOffPercentageAnnualPrem3, StepStatus.FAILURE, new String[] {},
			startTime);
}

if(UmActualRunOffPercentageAnnualPrem6.contains(ExpectedRunOffPercentageAnnualPrem6)) {
	
	CustomReporting.logReport("", "", "Actual Value: " + UmActualRunOffPercentageAnnualPrem6 + "is as expected: " + ExpectedRunOffPercentageAnnualPrem6, StepStatus.SUCCESS, new String[] {},
			startTime);
}else {
	
	CustomReporting.logReport("", "", "Actual  Value: " + UmActualRunOffPercentageAnnualPrem6 + "is not as expected: "+ ExpectedRunOffPercentageAnnualPrem6, StepStatus.FAILURE, new String[] {},
			startTime);
}


	}
	
	
	
	@Override
	public void UmSetPartOfRatingCommon(String tcID, SoftAssert softAssert) throws Exception 
	{
		
		PageData dataUmRatCom = PageDataManager.instance().getPageData("UmRatingCommon", tcID);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		
		_click(getElement(btnRatingCommontab));
		_wait(5000);
		_setValue(getElement(PartOf), dataUmRatCom.getData("PartOf"));
		_wait(2000);
		_click(getElement(btnUpdateCoverages));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		
	}
	
	@Override
	public void UmSetRunOffPremium(String tcID, SoftAssert softAssert) throws Exception 
	{
		
		PageData dataUmRatCom = PageDataManager.instance().getPageData("UmRatingCommon", tcID);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		
		_click(getElement(btnRatingCommontab));
		_wait(5000);
		_setValue(getElement(RunOffPremium), dataUmRatCom.getData("RunOffPremium"));
		_wait(2000);
		_click(getElement(btnUpdateCoverages));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		
	}
	
	

}
