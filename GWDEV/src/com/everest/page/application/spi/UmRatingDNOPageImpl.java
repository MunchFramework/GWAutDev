package com.everest.page.application.spi;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.Element;

import com.everest.page.application.UmRatingDNOPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmRatingDNOPageImpl extends CustomAbstractPage implements UmRatingDNOPage {

	@Override
	public void UmRatingDNO(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		_wait(9000);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		WebDriverWait w1 = new WebDriverWait(getWebDriver(),10);
		Actions ac = new Actions(getWebDriver());
		
		_click(getElement(btnRatingDNOtab));
		
		// Directors and Officers Liability table
		_wait(4000);
		_setValue(getElement(txtAggregateLimit), dataUmLogin.getData("DNOAggregateLimit"));
		_clickTab();
		_wait(4000);

		_setValue(getElement(txtRetention), dataUmLogin.getData("DNORetention"));
		_clickTab();
		_wait(4000);

		_wait(6000);

		_setValue(getElement(txtDate), dataUmLogin.getData("DNOPriorDate"));
		_clickTab();
		_wait(4000);
//		_click(getElement(ddDutytodefend));
		
		_wait(5000);
		_click(getElement(btnUpdateCoverages));
		_wait(15000);
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

		_wait(4000);
		//_setValue(getElement(ddDutytodefend), dataUmLogin.getData("Dutytodefend"));
		_clickTab();
		_wait(4000);
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		

		if (dataUmLogin.getData("EnterModifiers").equalsIgnoreCase("Yes")) 
		{
			ac.moveToElement(getWebDriver().findElement(By.xpath("//div[contains(text(),'Aggregate Limit')]"))).click();
			for(int r=0;r<7;r++)
			{
				ac.sendKeys(Keys.ARROW_DOWN).perform();
			}
			
			// Discretionary Factors table
			if (dataUmLogin.getData("PrivateCo").equalsIgnoreCase("Yes"))
			{
				String expectedSelectOption[] = {	"btnDFNatureOpsSelectOption","btnDFNoYrBusSelectOption","btnDFNoOfSubsSelectOption","btnDFMergerActivitySelectOption","btnDFManageOwnerSelectOption","btnDFSecurityOffSelectOption","btnDFLitHisSelectOption","btnDFSigTranSelectOption","btnDFMangStabilitySelectOption","btnDFQualityBalanceSheetSelectOption","btnDFQualityIncSelectOption","btnDFQualityCashFlowsSelectOption"};	
				String expectedSelectOptionValues[] = {	"DNODFNatureOpsSelectOption","DNODFNoYrBusSelectOption","DNODFNoOfSubsSelectOption","DNODFMergerActivitySelectOption","DNODFManageOwnerSelectOption","DNODFSecurityOffSelectOption","DNODFLitHisSelectOption","DNODFSigTranSelectOption","DNODFMangStabilitySelectOption","DNODFQualityBalanceSheetSelectOption","DNODFQualityIncSelectOption","DNODFQualityCashFlowsSelectOption"};	
				String expectedSelection[] = {"txtDFNatureOpsSelection","txtDFNoYrBusSelection","txtDFNoOfSubsSelection","txtDFMergerActivitySelection","txtDFManageOwnerSelection","txtDFSecurityOffSelection","txtDFLitHisSelection","txtDFSigTranSelection","txtDFMangStabilitySelection","txtDFQualityBalanceSheetSelection","txtDFQualityIncSelection","txtDFQualityCashFlowsSelection"};	
				String expectedSelectionValues[] = {"DNODFNatureOpsSelection","DNODFNoYrBusSelection","DNODFNoOfSubsSelection","DNODFMergerActivitySelection","DNODFManageOwnerSelection","DNODFSecurityOffSelection","DNODFLitHisSelection","DNODFSigTranSelection","DNODFMangStabilitySelection","DNODFQualityBalanceSheetSelection","DNODFQualityIncSelection","DNODFQualityCashFlowsSelection"};	

				
				
			int l = expectedSelectOption.length;
			for (int i=0;i<l;i++)
		 	{
			 
					 if (i==0)
					 {
						 _wait(2000);
						 //1func._scrollToElement(getElement(expectedSelectOption[i+2])); 
						 _wait(1000);
						 _click(getElement(expectedSelectOption[i]));
					 }
					 else if (i==5)
					 {
						//2 func._scrollToElement(getElement(expectedSelectOption[i+6]));  
						 _wait(1000);
						 func.setValue2(getElement(expectedSelectOption[i]));
					 }
					 else
					 {
						 func.setValue2(getElement(expectedSelectOption[i]));
					 }
					 w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/um-dropdown-search/input")));
					 String xpath = "/html/body/div[3]/um-dropdown-search/input";
					 //String targetxpath =  "//*[contains(text(),\""+dataUmLogin.getData(expectedSelectOptionValues[i])+"\")]";
					 _wait(2000);
									
						WebElement ele2 = (getWebDriver().findElement(By.xpath(xpath)));
						String SlctOption = (dataUmLogin.getData(expectedSelectOptionValues[i]));
						ele2.sendKeys(SlctOption);
						//report
						_wait(4000);
						String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData(expectedSelectOptionValues[i])+"\")]";
						WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
						expectedOption.click();
						long startTime = System.currentTimeMillis();
						CustomReporting.logReport("", "", "Set the value of the " + expectedSelectOptionValues[i]+ " element on the page UmRatingDNO " + SlctOption , StepStatus.SUCCESS, new String[] {},
								startTime);
		
						//func.setValue6();
						func.setValue3(getElement(expectedSelectOption[i]));
						//_clickTab();
					 	
							//func.selectDropDownValue(getWebDriver(), targetxpath, dataUmLogin.getData(expectedSelectOptionValues[i]));
						if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes"))
						{	
							func.setValue3(getElement(expectedSelectOption[i]));
							
						}
						else
						{
							_wait(1000);
							Element e2  = getElement(expectedSelection[i]);
							_wait(1000);
							//3func._scrollToElement(e2);
							_wait(1000);
							 _click(getElement(expectedSelection[i]));
							 
							 _wait(1000);
							 String value = dataUmLogin.getData(expectedSelectionValues[i]);
							 String Selectionxpath  = e2.getKey();
							WebElement ele = (getWebDriver().findElement(By.xpath(Selectionxpath)));
							 Element ele3  = getElement(expectedSelection[i]);
							 _wait(1000);
								//4func._scrollToElement(ele3);
						
							 ele.clear();
							 _wait(1000);
							 ele.sendKeys(value);
							 //report
							 CustomReporting.logReport("", "", "Set the value of the " + expectedSelectionValues[i]+ " element on the page UmRatingDNO " + value , StepStatus.SUCCESS, new String[] {},
										startTime);
							 _wait(1000);
							 _click(getElement(expectedSelection[i]));
							// _clickTab();
							 //_clickTab();
							 func.setValue3(ele3);
							 func.setValue3(ele3);
						}
		 		}//for end
			}			
			else 
			{

				String expectedSelectOption[] = {"btnDFNatureOpsSelectOption","btnDFNoYrBusSelectOption","btnDFNoOfSubsSelectOption","btnDFMergerActivitySelectOption","btnDFSecuritiesOfferingActivitySelectOption","btnDFLitigationHistorySelectOption","btnDFSignificantTransactionorEventSelectOption","btnDFManagementStabilitySelectOption","btnDFQualityofStatementofFinancialPositionSelectOption","btnDFQualityofStatementofActivitiesSelectOption","btnDFQualityofStatementofCashFlowsSelectOption"};	
				String expectedSelectOptionValues[] = {"DNODFNatureOpsSelectOption","DNODFNoYrBusSelectOption","DNODFNoOfSubsSelectOption","DNODFMergerActivitySelectOption","DNODFSecuritiesOfferingActivitySelectOption","DNODFLitigationHistorySelectOption","DNODFSignificantTransactionorEventSelectOption","DNODFManagementStabilitySelectOption","DNODFQualityofStatementofFinancialPositionSelectOption","DNODFQualityofStatementofActivitiesSelectOption","DNODFQualityofStatementofCashFlowsSelectOption"};	
				String expectedSelection[] = {"txtDFNatureOpsSelection","txtDFNoYrBusSelection","txtDFNoOfSubsSelection","txtDFMergerActivitySelection","txtDFSecuritiesOfferingActivitySelection","txtDFLitigationHistorySelection","txtDFSignificantTransactionorEventSelection","txtDFManagementStabilitySelection","txtDFQualityofStatementofFinancialPositionSelection","txtDFQualityofStatementofActivitiesSelection","txtDFQualityofStatementofCashFlowsSelection"};	
				String expectedSelectionValues[] = {"DNODFNatureOpsSelection","DNODFNoYrBusSelection","DNODFNoOfSubsSelection","DNODFMergerActivitySelection","DNODFSecuritiesOfferingActivitySelection","DNODFLitigationHistorySelection","DNODFSignificantTransactionorEventSelection","DNODFManagementStabilitySelection","DNODFQualityofStatementofFinancialPositionSelection","DNODFQualityofStatementofActivitiesSelection","DNODFQualityofStatementofCashFlowsSelection"};	

				
				int l = expectedSelectOption.length;
				for (int i=0;i<l;i++)
				{
					
				 if (i==0)
				 {
				_wait(2000);
				//1func._scrollToElement(getElement(expectedSelectOption[i+2])); 		
				 _wait(1000);
				 _click(getElement(expectedSelectOption[i]));
				 }
				 else if (i==5)
				 {
					 //2func._scrollToElement(getElement(expectedSelectOption[i+5]));  
					 _wait(1000);
					 func.setValue2(getElement(expectedSelectOption[i]));
				 }
				 else
				 {
					 func.setValue2(getElement(expectedSelectOption[i]));
				 }
				 w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/um-dropdown-search/input")));
				String xpath = "/html/body/div[3]/um-dropdown-search/input";
				//String targetxpath =  "//*[contains(text(),\""+dataUmLogin.getData(expectedSelectOptionValues[i])+"\")]";
				_wait(2000);
								
					WebElement ele2 = (getWebDriver().findElement(By.xpath(xpath)));
					String SlctOption = (dataUmLogin.getData(expectedSelectOptionValues[i]));
					ele2.sendKeys(SlctOption);
					//report
					_wait(4000);
					String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData(expectedSelectOptionValues[i])+"\")]";
					WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
					expectedOption.click();
					long startTime = System.currentTimeMillis();
					CustomReporting.logReport("", "", "Set the value of the " + expectedSelectOptionValues[i]+ " element on the page UmRatingDNO " + SlctOption , StepStatus.SUCCESS, new String[] {},
							startTime);

					//func.setValue6();
					func.setValue3(getElement(expectedSelectOption[i]));
					//_clickTab();
				 	
						//func.selectDropDownValue(getWebDriver(), targetxpath, dataUmLogin.getData(expectedSelectOptionValues[i]));
					if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) 
					{	
						func.setValue3(getElement(expectedSelectOption[i]));
					}
					else
					{	
							_wait(1000);
						Element e2  = getElement(expectedSelection[i]);
						_wait(1000);
						//3func._scrollToElement(e2);
						_wait(1000);
						 _click(getElement(expectedSelection[i]));
						 
						 _wait(1000);
						 String value = dataUmLogin.getData(expectedSelectionValues[i]);
						 String Selectionxpath  = e2.getKey();
						WebElement ele = (getWebDriver().findElement(By.xpath(Selectionxpath)));
						 Element ele3  = getElement(expectedSelection[i]);
						 _wait(1000);
							//4func._scrollToElement(ele3);
					
						 ele.clear();
						 _wait(1000);
						 ele.sendKeys(value);
						 //report
						 CustomReporting.logReport("", "", "Set the value of the " + expectedSelectionValues[i]+ " element on the page UmRatingDNO " + value , StepStatus.SUCCESS, new String[] {},
									startTime);
						 _wait(1000);
						 _click(getElement(expectedSelection[i]));
						// _clickTab();
						 //_clickTab();
						 func.setValue3(ele3);
						 func.setValue3(ele3);
					}
				}
				
			}
			
//			_click(getElement(btnDFNatureOpsSelectOption));
//			_wait(2000);
//
//			_setValue(getElement(txtDFNatureOpsSelectOption), dataUmLogin.getData("DNODFNatureOpsSelectOption"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFNatureOpsSelection), dataUmLogin.getData("DNODFNatureOpsSelection"));
//			_clickTab();
//			_clickTab();
//
//			func.setValue6();
//
//			_setValue(getElement(txtDFNoYrBusSelectOption), dataUmLogin.getData("DNODFNoYrBusSelectOption"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFNoYrBusSelection), dataUmLogin.getData("DNODFNoYrBusSelection"));
//			_clickTab();
//			_clickTab();
//
//			func.setValue6();
//
//			_wait(1000);
//
//			_setValue(getElement(txtDFNoOfSubsSelectOption), dataUmLogin.getData("DNODFNoOfSubsSelectOption"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFNoOfSubsSelection), dataUmLogin.getData("DNODFNoOfSubsSelection"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//
//			_wait(2000);
//
//			_setValue(getElement(txtDFMergerActivitySelectOption),dataUmLogin.getData("DNODFMergerActivitySelectOption"));
//			func.setValue6();
//			_wait(2000);
//			_wait(2000);
//			_clickTab();
//			_setValue(getElement(txtDFMergerActivitySelection), dataUmLogin.getData("DNODFMergerActivitySelection"));
//			_clickTab();
//			_clickTab();
//
//			func.setValue6();
//			_setValue(getElement(txtDFManageOwnerSelectOption), dataUmLogin.getData("DNODFManageOwnerSelectOption"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFManageOwnerSelection), dataUmLogin.getData("DNODFManageOwnerSelection"));
//
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//			_setValue(getElement(txtDFSecurityOffSelectOption), dataUmLogin.getData("DNODFSecurityOffSelectOption"));
//			func.setValue6();
//			_wait(2000);
//			_clickTab();
//			_setValue(getElement(txtDFSecurityOffSelection), dataUmLogin.getData("DNODFSecurityOffSelection"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//
//			_wait(2000);
//
//			_setValue(getElement(txtDFLitHisSelectOption), dataUmLogin.getData("DNODFLitHisSelectOption"));
//			func.setValue6();
//			_wait(2000);
//			_clickTab();
//			_setValue(getElement(txtDFLitHisSelection), dataUmLogin.getData("DNODFLitHisSelection"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//
//			_setValue(getElement(txtDFSigTranSelectOption), dataUmLogin.getData("DNODFSigTranSelectOption"));
//			func.setValue6();
//			_wait(2000);
//			_clickTab();
//			_setValue(getElement(txtDFSigTranSelection), dataUmLogin.getData("DNODFSigTranSelection"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//
//			_setValue(getElement(txtDFMangStabilitySelectOption),dataUmLogin.getData("DNODFMangStabilitySelectOption"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFMangStabilitySelection), dataUmLogin.getData("DNODFMangStabilitySelection"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//
//			_wait(2000);
//
//			_setValue(getElement(txtDFQualityBalanceSheetSelectOption),dataUmLogin.getData("DNODFQualityBalanceSheetSelectOption"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFQualityBalanceSheetSelection),dataUmLogin.getData("DNODFQualityBalanceSheetSelection"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//
//			_setValue(getElement(txtDFQualityIncSelectOption), dataUmLogin.getData("DNODFQualityIncSelectOption"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFQualityIncSelection), dataUmLogin.getData("DNODFQualityIncSelection"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//
//			_wait(2000);
//
//			_setValue(getElement(txtDFQualityCashFlowsSelectOption),dataUmLogin.getData("DNODFQualityCashFlowsSelectOption"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFQualityCashFlowsSelection), dataUmLogin.getData("DNODFQualityCashFlowsSelection"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();

			// Schedule Rating table
			
		 	_wait(2000);
			_setValue(getElement(txtSRStregthCorpGovtSelection), dataUmLogin.getData("DNOSRStregthCorpGovtSelection"));
			_wait(2000);
			_setValue(getElement(txtSRLossExpSelection), dataUmLogin.getData("DNOSRLossExpSelection"));
			_wait(2000);
			_setValue(getElement(txtSROverallFinLiqSelection), dataUmLogin.getData("DNOSROverallFinLiqSelection"));
			_wait(2000);
			_setValue(getElement(txtSRAffRecessionSelection), dataUmLogin.getData("DNOSRAffRecessionSelection"));
			_wait(2000);
			_setValue(getElement(txtSRQualityManageSelection), dataUmLogin.getData("DNOSRQualityManageSelection"));
			
//			// Optional Coverage Enhancements
//			_setValue(getElement(txtSRAdditionalSideLimit), dataUmLogin.getData("txtSRAdditionalSideLimit"));
//			_wait(2000);
//			_setValue(getElement(txtSRAdditionalSideSubLimit), dataUmLogin.getData("txtSRAdditionalSideSubLimit"));
//			_wait(2000);
//			_setValue(getElement(txtOCEAssetProCostsLimit), dataUmLogin.getData("txtOCEAssetProCostsLimit"));
//			_wait(2000);
//			_setValue(getElement(txtOCEInvestigativeCostsLimit), dataUmLogin.getData("txtOCEInvestigativeCostsLimit"));
//			_wait(2000);
//			_setValue(getElement(txtOCEPublicRelationsCostsLimit),
//					dataUmLogin.getData("txtOCEPublicRelationsCostsLimit"));
//			_wait(2000);

			// Coverage Modifiers
//			func._scrollToElement(getElement(btnCMEndFact));
//			_wait(2000);
//			_click(getElement(btnCMDutytoDefend));
//			_wait(2000);
//			if (func._isVisible(getElement(txtCMDutytoDefend)) == false)
//			{
//				_wait(2000);
//				_click(getElement(btnCMDutytoDefend));
//				_wait(2000);
//				_setValue(getElement(txtCMDutytoDefend), dataUmLogin.getData("DNOCMDutytoDefend"));
//				String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("DNOCMDutytoDefend")+"\")]";
//				WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
//				expectedOption.click();
//				//func.setValue6();
//				_wait(5000);
//			}
//			else
//			{
//			_setValue(getElement(txtCMDutytoDefend), dataUmLogin.getData("DNOCMDutytoDefend"));
//			_wait(2000);
//			String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("DNOCMDutytoDefend")+"\")]";
//			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
//			expectedOption.click();
//			//func.setValue6();
//			_wait(5000);
//			}
//			if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
//					
//			}
//			else
//			{	
//			_setValue(getElement(txtCMDutytoDefendSel), dataUmLogin.getData("DNOCMDutytoDefendSelection"));
//			}
			_wait(2000);
			_click(getElement(btnCMEndFact));
			_wait(2000);
			_setValue(getElement(txtCMEndFact), dataUmLogin.getData("DNOCMEndFact"));
			//func.setValue6();
			_wait(2000);
			String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("DNOCMEndFact")+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			expectedOption.click();
			if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) 
			{	
				
			}
			else
			{
				_setValue(getElement(txtCMEndFactSel), dataUmLogin.getData("DNOCMEndFactSelection"));
			}
		
			
		

		if (dataUmLogin.getData("DNOInvestigativeCosts").equalsIgnoreCase("Yes")) {
			//_click(getElement(chkInvestigativeCosts));
			_wait(5000);
			_setValue(getElement(txtInvestigativeCosts), dataUmLogin.getData("DNOInvestigativeCostsSublimit"));
			_wait(5000);
		}
		
		
		if (dataUmLogin.getData("DNOAssetProtectionCosts").equalsIgnoreCase("Yes")) {
			//_click(getElement(chkAssetProtectionCosts));
			_setValue(getElement(txtAssetProtectionCosts), dataUmLogin.getData("DNOAssetProtectionCostsSublimit"));

			_wait(5000);
		}
		if (dataUmLogin.getData("DNOPublicRelationsCosts").equalsIgnoreCase("Yes")) {
			//_click(getElement(chkPublicRelationsCosts));
			_wait(5000);
			_setValue(getElement(txtPublicRelationsCosts), dataUmLogin.getData("DNOPublicRelationsCostsSublimit"));
			_wait(5000);
		}
		/*if (dataUmLogin.getData("DNOAdditionalSideALimit").equalsIgnoreCase("Yes")) 
		{
//			_click(getElement(chkAdditionalSideALimit));
			_wait(5000);
			//func.validateCheckbox(getElement(chkAdditionalSideALimit));
		//	_setValue(getElement(txtAdditionalSideALimit), dataUmLogin.getData("DNOAdditionalSideALimitvalue"));
			_wait(5000);
		}*/
		if (dataUmLogin.getData("DNOSeparateDefenseCostCoverage").equalsIgnoreCase("Yes")) 
		{
			_click(getElement(chkDNOSeparateDefenseCostCoverage));
			_wait(5000);
			//_setValue(getElement(txtDNOSeparateDefenseCostCoverage),dataUmLogin.getData("DNOSeparateDefenseCostLimit"));
			_wait(5000);
		}
		
		_wait(5000);
		_click(getElement(btnUpdateCoverages));
		_wait(15000);
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		
		

		
		/*if (dataUmLogin.getData("DNOAdditionalSideALimit").equalsIgnoreCase("Yes"))
		{
			//_click(getElement(chkAdditionalSideALimit));
			_wait(5000);
			_setValue(getElement(txtAdditionalSideALimit), dataUmLogin.getData("DNOAdditionalSideALimitvalue"));
			_wait(5000);
		}*/
		
		if (dataUmLogin.getData("DNOAdditionalSideALimit").equalsIgnoreCase("Yes")) 
		{
			/*_click(getElement(chkAdditionalSideALimit));
			_wait(3000);*/
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_END);
			rb.keyRelease(KeyEvent.VK_END);
			WebElement we = (WebElement)getClonedElement(chkAdditionalSideALimit).getNative();
			if(we.isSelected())
			{
				_click(getElement(btnUpdateCoverages));
				_wait(3000);
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(5000);
			}
			else
			{
				_click(getElement(chkAdditionalSideALimit));
				_wait(3000);
				_click(getElement(btnUpdateCoverages));
				_wait(3000);
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(5000);
				
			}
			
			_setValue(getElement(txtAdditionalSideALimit), dataUmLogin.getData("DNOAdditionalSideALimitvalue"));
			_wait(5000);
		}
		if (dataUmLogin.getData("DNOSeparateDefenseCostCoverage").equalsIgnoreCase("Yes")) 
		{
			//_click(getElement(chkDNOSeparateDefenseCostCoverage));
			_wait(5000);
			_setValue(getElement(txtDNOSeparateDefenseCostCoverage),dataUmLogin.getData("DNOSeparateDefenseCostLimit"));
			_wait(5000);
		}
		
		}
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
}
	
	
	@Override
	public void VerifyDnoFormEdit(String tcID, SoftAssert softAssert) throws Exception 
	{
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(3000);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		
		_click(getElement(btnRatingDNOtab));
		_wait(5000);
		WebElement chkbx = (WebElement)getElement(chkDNOSeparateDefenseCostCoverage).getNative();
		if(!chkbx.isSelected())
		{
			CustomReporting.logReport("", "", "DNA Separate Cost Coverage Form is not added by default as expected" , StepStatus.SUCCESS, new String[] {},
						System.currentTimeMillis());
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_click(getElement(btnUpdateCoverages));
			_wait(3000);
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(2000);
			_click(getElement(btnGetRate));
			_wait(3000);
			if(func._isVisible(getElement(btnGetRate)))
			{
				_click(getElement(btnGetRate));
				_wait(3000);
			}
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(2000);
			getWebDriver().findElement(By.xpath("//*[contains(text(),'Policy Forms')]")).click();
			String FormDesc2 = getWebDriver().findElement(By.xpath("(//div[@class='formRowContainer row18']//input[@type='text'])[2]")).getAttribute("value");
			if(FormDesc2.equalsIgnoreCase("Separate Defense Cost Coverage"))
			{
				CustomReporting.logReport("", "", "DNA Separate Cost Coverage Form is Present in Policy Forms even after removal which is unexpected as per ESUP36254" , StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
			}
			else
			{
				CustomReporting.logReport("", "", "DNA Separate Cost Coverage Form is NOT Present as expected as per ESUP36254" , StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
			}
		}
			
			_click(getElement(btnRatingDNOtab));
			_wait(5000);
			_click(getElement(chkDNOSeparateDefenseCostCoverage));
			_wait(5000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_click(getElement(btnUpdateCoverages));
			_wait(3000);
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_setValue(getElement(txtDNOSeparateDefenseCostCoverage),"100000");
			_wait(3000);
			_click(getElement(btnGetRate));
			_wait(3000);
			if(func._isVisible(getElement(btnGetRate)))
			{
				_click(getElement(btnGetRate));
				_wait(3000);
			}
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			getWebDriver().findElement(By.xpath("//*[contains(text(),'Policy Forms')]")).click();
			_wait(5000);
				
			String FormNo = getWebDriver().findElement(By.xpath("(//div[@class='formRowContainer row18']//input[@type='text'])[1]")).getAttribute("value");
			String FormDesc = getWebDriver().findElement(By.xpath("(//div[@class='formRowContainer row18']//input[@type='text'])[2]")).getAttribute("value");

			if(FormNo.equalsIgnoreCase("PCI-CWF358A-1"))
			{
				CustomReporting.logReport("", "", "Form No for DNA Separate Cost Coverage is as expected as per ESUP36254. Actual : "+FormNo+"Expected : PCI-CWF358A-1", StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
			}
			else
			{
				CustomReporting.logReport("", "", "Form No for DNA Separate Cost Coverage is NOT as expected as per ESUP36254. Actual : "+FormNo+"Expected : PCI-CWF358A-1" , StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
			}
			if(FormDesc.equalsIgnoreCase("Separate Defense Cost Coverage"))
			{
				CustomReporting.logReport("", "", "Form Desc for DNA Separate Cost Coverage is as expected as per ESUP36254. Actual : "+FormDesc+"Expected : Separate Defense Cost Coverage" , StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
			}
			else
			{
				CustomReporting.logReport("", "", "Form Desc for DNA Separate Cost Coverage is NOT as expected as per ESUP36254.Actual : "+FormDesc+"Expected : Separate Defense Cost Coverage" , StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
			}
			
	}
	
	 @Override
		public void Verify_SRM_DNO_Error_Msg(String tcID, SoftAssert softAs) throws Exception {
			try {
				
				_click(getElement(btnRatingDNOtab));
				_wait(10000);
				List<String> web_elements_list = new ArrayList<String>();
				List<String> SRM_MIN_MAX_VALUES_LIST = new ArrayList<String>();
				List<String> variable_names_list = new ArrayList<String>();

				PageData data = PageDataManager.instance().getPageData("DNO", tcID);
				String SRM_SCG_MIN = data.getData("SRM_SCG_MIN");
				String SRM_SCG_MAX = data.getData("SRM_SCG_MAX");
				String SRM_LE_MIN = data.getData("SRM_LE_MIN");
				String SRM_LE_MAX = data.getData("SRM_LE_MAX");
				String SRM_OFL_MIN = data.getData("SRM_OFL_MIN");
				String SRM_OFL_MAX = data.getData("SRM_OFL_MAX");
				String SRM_ABR_MIN = data.getData("SRM_ABR_MIN");
				String SRM_ABR_MAX = data.getData("SRM_ABR_MAX");
				String SRM_QOM_MIN = data.getData("SRM_QOM_MIN");
				String SRM_QOM_MAX = data.getData("SRM_QOM_MAX");
				String SRM_STATE_MIN = data.getData("SRM_STATE_MIN");
				String SRM_STATE_MAX = data.getData("SRM_STATE_MAX");

					
				_wait(5000);
				
				
				web_elements_list.add("txtSRStregthCorpGovtSelection");
				web_elements_list.add("txtSRStregthCorpGovtSelection");
				web_elements_list.add("txtSRLossExpSelection");
				web_elements_list.add("txtSRLossExpSelection");
				web_elements_list.add("txtSROverallFinLiqSelection");
				web_elements_list.add("txtSROverallFinLiqSelection");
				web_elements_list.add("txtSRAffRecessionSelection");
				web_elements_list.add("txtSRAffRecessionSelection");
				web_elements_list.add("txtSRQualityManageSelection");
				web_elements_list.add("txtSRQualityManageSelection");
				_wait(2000);
				
				
				SRM_MIN_MAX_VALUES_LIST.add(SRM_SCG_MIN);
				SRM_MIN_MAX_VALUES_LIST.add(SRM_SCG_MAX);
				SRM_MIN_MAX_VALUES_LIST.add(SRM_LE_MIN);
				SRM_MIN_MAX_VALUES_LIST.add(SRM_LE_MAX);
				SRM_MIN_MAX_VALUES_LIST.add(SRM_OFL_MIN);
				SRM_MIN_MAX_VALUES_LIST.add(SRM_OFL_MAX);
				SRM_MIN_MAX_VALUES_LIST.add(SRM_ABR_MIN);
				SRM_MIN_MAX_VALUES_LIST.add(SRM_ABR_MAX);
				SRM_MIN_MAX_VALUES_LIST.add(SRM_QOM_MIN);
				SRM_MIN_MAX_VALUES_LIST.add(SRM_QOM_MAX);
				SRM_MIN_MAX_VALUES_LIST.add(SRM_STATE_MIN);
				SRM_MIN_MAX_VALUES_LIST.add(SRM_STATE_MAX);
				
				variable_names_list.add("SRM_SCG_MIN");
				variable_names_list.add("SRM_SCG_MAX");
				variable_names_list.add("SRM_LE_MIN");
				variable_names_list.add("SRM_LE_MAX");
				variable_names_list.add("SRM_OFL_MIN");
				variable_names_list.add("SRM_OFL_MAX");
				variable_names_list.add("SRM_ABR_MIN");
				variable_names_list.add("SRM_ABR_MAX");
				variable_names_list.add("SRM_QOM_MIN");
				variable_names_list.add("SRM_QOM_MAX");
				variable_names_list.add("SRM_STATE_MIN");
				variable_names_list.add("SRM_STATE_MAX");
				
				for(int i=0;i<web_elements_list.size();i++)
				{
					if(variable_names_list.get(i).contains("MIN"))
					{
						_setValue(getElement(web_elements_list.get(i)), String.valueOf(((Double.parseDouble(SRM_MIN_MAX_VALUES_LIST.get(i)))-0.01)));
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
						_clickTab();
						_wait(2000);
						if(func._isVisible(getClonedElement(Error_SRM).addToken("tkn_SRM","This value can not be less than ")))
						{
							CustomReporting.logReport("", "", "Error is thrown as expected for schedule rate modifier. MIN Limit : "+SRM_MIN_MAX_VALUES_LIST.get(i)+" Entered Value : "+String.valueOf(((Double.parseDouble(SRM_MIN_MAX_VALUES_LIST.get(i)))-0.01)), StepStatus.SUCCESS, System.currentTimeMillis());
							func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
							_click(getElement(Error_SRM_OK_btn));
							_wait(2000);
							
						}
						else
						{
							CustomReporting.logReport("", "", "Error is not thrown for a wrong value of schedule rate modifier. MIN Limit : "+SRM_MIN_MAX_VALUES_LIST.get(i)+" Entered Value : "+String.valueOf(((Double.parseDouble(SRM_MIN_MAX_VALUES_LIST.get(i)))-0.01)), StepStatus.FAILURE, System.currentTimeMillis());
							func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
						}
					}
					else
					{
						_setValue(getElement(web_elements_list.get(i)), String.valueOf(((Double.parseDouble(SRM_MIN_MAX_VALUES_LIST.get(i)))+0.01)));
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
						_clickTab();
						_wait(2000);
						if(func._isVisible(getClonedElement(Error_SRM).addToken("tkn_SRM","This value can not be more than ")))
						{
							CustomReporting.logReport("", "", "Error is thrown as expected for schedule rate modifier. MAX Limit : "+SRM_MIN_MAX_VALUES_LIST.get(i)+" Entered Value : "+String.valueOf(((Double.parseDouble(SRM_MIN_MAX_VALUES_LIST.get(i)))+0.01)), StepStatus.SUCCESS, System.currentTimeMillis());
							func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
							_click(getElement(Error_SRM_OK_btn));
							_wait(2000);
							
						}
						else
						{
							CustomReporting.logReport("", "", "Error is not thrown for a wrong value of schedule rate modifier. MAX Limit : "+SRM_MIN_MAX_VALUES_LIST.get(i)+" Entered Value : "+String.valueOf(((Double.parseDouble(SRM_MIN_MAX_VALUES_LIST.get(i)))+0.01)), StepStatus.FAILURE, System.currentTimeMillis());
							func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
						}
					}
				}
				
				

			} catch (Exception ex) {
				throw ex;
			}
		}
	 
	 	@Override
	   	public void Update_SRM_DNO(String tcID, SoftAssert softAs) throws Exception {
	   		try 
	   		{
	   			
	   			PageData data = PageDataManager.instance().getPageData("DNO", tcID);
	   			WebDriverWait w = new WebDriverWait(getWebDriver(),250);
				
	   			_click(getElement(btnRatingDNOtab));
	   			_wait(10000);
	   			_setValue(getElement(txtSRStregthCorpGovtSelection), data.getData("DNOSRStregthCorpGovtSelection"));
				_clickTab();
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
				_wait(2000);
				_setValue(getElement(txtSRLossExpSelection), data.getData("DNOSRLossExpSelection"));
				_clickTab();
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
				_wait(2000);
				_setValue(getElement(txtSROverallFinLiqSelection), data.getData("DNOSROverallFinLiqSelection"));
				_clickTab();
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
				_wait(2000);
				_setValue(getElement(txtSRAffRecessionSelection),  data.getData("DNOSRAffRecessionSelection"));
				_clickTab();
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
				_wait(2000);
				_setValue(getElement(txtSRQualityManageSelection), data.getData("DNOSRQualityManageSelection"));
				_clickTab();
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
				_wait(2000);
				_click(getElement(btnUpdateCoverages));
				_wait(2000);
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(3000);
	   		} 
	   		catch (Exception ex) 
	   		{
	   			throw ex;
	   		}
	   	}
	 	
	 	
	 	
	 	@Override
		public void UmRatingDNO_1(String tcID, SoftAssert softAssert) throws Exception 
		{
			PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
			func._waitForPageToLoad(getWebDriver(), 50L);
			
			_wait(9000);
			WebDriverWait w = new WebDriverWait(getWebDriver(),250);
			Actions ac = new Actions(getWebDriver());
			
			_click(getElement(btnRatingDNOtab));
			_wait(4000);
			
			_setValue(getElement(txtAggregateLimit), dataUmLogin.getData("DNOAggregateLimit"));
			_clickTab();
			_wait(4000);

			_setValue(getElement(txtRetention), dataUmLogin.getData("DNORetention"));
			_clickTab();
			_wait(4000);

			_setValue(getElement(txtDate), dataUmLogin.getData("DNOPriorDate"));
			_clickTab();
			_wait(4000);
			
			
			_click(getElement(btnUpdateCoverages));
			_wait(5000);
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

			_wait(4000);
			/*_setValue(getElement(ddDutytodefend), dataUmLogin.getData("Dutytodefend"));
			_clickTab();
			_wait(4000);*/
			
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			

			if (dataUmLogin.getData("EnterModifiers").equalsIgnoreCase("Yes")) 
			{
				ac.moveToElement(getWebDriver().findElement(By.xpath("//div[contains(text(),'Aggregate Limit')]"))).click();
				for(int r=0;r<7;r++)
				{
					ac.sendKeys(Keys.ARROW_DOWN).perform();
				}
				
				// Discretionary Factors table
				if (dataUmLogin.getData("PrivateCo").equalsIgnoreCase("Yes"))
				{
					String expectedSelectOption[] = {	"btnDFNatureOpsSelectOption","btnDFNoYrBusSelectOption","btnDFNoOfSubsSelectOption","btnDFMergerActivitySelectOption","btnDFManageOwnerSelectOption","btnDFSecurityOffSelectOption","btnDFLitHisSelectOption","btnDFSigTranSelectOption","btnDFMangStabilitySelectOption","btnDFQualityBalanceSheetSelectOption","btnDFQualityIncSelectOption","btnDFQualityCashFlowsSelectOption"};	
					String expectedSelectOptionValues[] = {	"DNODFNatureOpsSelectOption","DNODFNoYrBusSelectOption","DNODFNoOfSubsSelectOption","DNODFMergerActivitySelectOption","DNODFManageOwnerSelectOption","DNODFSecurityOffSelectOption","DNODFLitHisSelectOption","DNODFSigTranSelectOption","DNODFMangStabilitySelectOption","DNODFQualityBalanceSheetSelectOption","DNODFQualityIncSelectOption","DNODFQualityCashFlowsSelectOption"};	
					String expectedSelection[] = {"txtDFNatureOpsSelection","txtDFNoYrBusSelection","txtDFNoOfSubsSelection","txtDFMergerActivitySelection","txtDFManageOwnerSelection","txtDFSecurityOffSelection","txtDFLitHisSelection","txtDFSigTranSelection","txtDFMangStabilitySelection","txtDFQualityBalanceSheetSelection","txtDFQualityIncSelection","txtDFQualityCashFlowsSelection"};	
					String expectedSelectionValues[] = {"DNODFNatureOpsSelection","DNODFNoYrBusSelection","DNODFNoOfSubsSelection","DNODFMergerActivitySelection","DNODFManageOwnerSelection","DNODFSecurityOffSelection","DNODFLitHisSelection","DNODFSigTranSelection","DNODFMangStabilitySelection","DNODFQualityBalanceSheetSelection","DNODFQualityIncSelection","DNODFQualityCashFlowsSelection"};	

					
					
				int l = expectedSelectOption.length;
				for (int i=0;i<l;i++)
			 	{
				 
						
					_click(getElement(expectedSelectOption[i]));
					_wait(2000);
					String xpath = "/html/body/div[3]/um-dropdown-search/input";
					 try 
					 {
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
					 } 
					 catch (Exception e) 
					 {
						_click(getElement(expectedSelectOption[i]));
						_wait(2000);
					 }
					 
					 WebElement ele2 = (getWebDriver().findElement(By.xpath(xpath)));
					 String SlctOption = (dataUmLogin.getData(expectedSelectOptionValues[i]));
					 ele2.sendKeys(SlctOption);
					_wait(4000);
					
					String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData(expectedSelectOptionValues[i])+"\")]";
					WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
					expectedOption.click();
					long startTime = System.currentTimeMillis();
					CustomReporting.logReport("", "", "Set the value of the " + expectedSelectOptionValues[i]+ " element on the page UmRatingDNO " + SlctOption , StepStatus.SUCCESS, new String[] {},
									startTime);
					func.setValue3(getElement(expectedSelectOption[i]));
					
					if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes"))
					{	
						func.setValue3(getElement(expectedSelectOption[i]));
					}
					else
					{
						_wait(1000);
						Element e2  = getElement(expectedSelection[i]);
						_wait(1000);
						_click(getElement(expectedSelection[i]));
						_wait(1000);
						
						String value = dataUmLogin.getData(expectedSelectionValues[i]);
						String Selectionxpath  = e2.getKey();
						WebElement ele = (getWebDriver().findElement(By.xpath(Selectionxpath)));
						Element ele3  = getElement(expectedSelection[i]);
						_wait(1000);
						ele.clear();
						_wait(1000);
						ele.sendKeys(value);
						CustomReporting.logReport("", "", "Set the value of the " + expectedSelectionValues[i]+ " element on the page UmRatingDNO " + value , StepStatus.SUCCESS, new String[] {},
											startTime);
					}
					
					
			 		}//for end
				}			
				else 
				{

					String expectedSelectOption[] = {"btnDFNatureOpsSelectOption","btnDFNoYrBusSelectOption","btnDFNoOfSubsSelectOption","btnDFMergerActivitySelectOption","btnDFSecuritiesOfferingActivitySelectOption","btnDFLitigationHistorySelectOption","btnDFSignificantTransactionorEventSelectOption","btnDFManagementStabilitySelectOption","btnDFQualityofStatementofFinancialPositionSelectOption","btnDFQualityofStatementofActivitiesSelectOption","btnDFQualityofStatementofCashFlowsSelectOption"};	
					String expectedSelectOptionValues[] = {"DNODFNatureOpsSelectOption","DNODFNoYrBusSelectOption","DNODFNoOfSubsSelectOption","DNODFMergerActivitySelectOption","DNODFSecuritiesOfferingActivitySelectOption","DNODFLitigationHistorySelectOption","DNODFSignificantTransactionorEventSelectOption","DNODFManagementStabilitySelectOption","DNODFQualityofStatementofFinancialPositionSelectOption","DNODFQualityofStatementofActivitiesSelectOption","DNODFQualityofStatementofCashFlowsSelectOption"};	
					String expectedSelection[] = {"txtDFNatureOpsSelection","txtDFNoYrBusSelection","txtDFNoOfSubsSelection","txtDFMergerActivitySelection","txtDFSecuritiesOfferingActivitySelection","txtDFLitigationHistorySelection","txtDFSignificantTransactionorEventSelection","txtDFManagementStabilitySelection","txtDFQualityofStatementofFinancialPositionSelection","txtDFQualityofStatementofActivitiesSelection","txtDFQualityofStatementofCashFlowsSelection"};	
					String expectedSelectionValues[] = {"DNODFNatureOpsSelection","DNODFNoYrBusSelection","DNODFNoOfSubsSelection","DNODFMergerActivitySelection","DNODFSecuritiesOfferingActivitySelection","DNODFLitigationHistorySelection","DNODFSignificantTransactionorEventSelection","DNODFManagementStabilitySelection","DNODFQualityofStatementofFinancialPositionSelection","DNODFQualityofStatementofActivitiesSelection","DNODFQualityofStatementofCashFlowsSelection"};	

					
					int l = expectedSelectOption.length;
					for (int i=0;i<l;i++)
					{
						
					 if (i==0)
					 {
					_wait(2000);
					//1func._scrollToElement(getElement(expectedSelectOption[i+2])); 		
					 _wait(1000);
					 _click(getElement(expectedSelectOption[i]));
					 }
					 else if (i==5)
					 {
						 //2func._scrollToElement(getElement(expectedSelectOption[i+5]));  
						 _wait(1000);
						 func.setValue2(getElement(expectedSelectOption[i]));
					 }
					 else
					 {
						 func.setValue2(getElement(expectedSelectOption[i]));
					 }
					 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/um-dropdown-search/input")));
					String xpath = "/html/body/div[3]/um-dropdown-search/input";
					//String targetxpath =  "//*[contains(text(),\""+dataUmLogin.getData(expectedSelectOptionValues[i])+"\")]";
					_wait(2000);
									
						WebElement ele2 = (getWebDriver().findElement(By.xpath(xpath)));
						String SlctOption = (dataUmLogin.getData(expectedSelectOptionValues[i]));
						ele2.sendKeys(SlctOption);
						//report
						_wait(4000);
						String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData(expectedSelectOptionValues[i])+"\")]";
						WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
						expectedOption.click();
						long startTime = System.currentTimeMillis();
						CustomReporting.logReport("", "", "Set the value of the " + expectedSelectOptionValues[i]+ " element on the page UmRatingDNO " + SlctOption , StepStatus.SUCCESS, new String[] {},
								startTime);

						//func.setValue6();
						func.setValue3(getElement(expectedSelectOption[i]));
						//_clickTab();
					 	
							//func.selectDropDownValue(getWebDriver(), targetxpath, dataUmLogin.getData(expectedSelectOptionValues[i]));
						if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) 
						{	
							func.setValue3(getElement(expectedSelectOption[i]));
						}
						else
						{	
								_wait(1000);
							Element e2  = getElement(expectedSelection[i]);
							_wait(1000);
							//3func._scrollToElement(e2);
							_wait(1000);
							 _click(getElement(expectedSelection[i]));
							 
							 _wait(1000);
							 String value = dataUmLogin.getData(expectedSelectionValues[i]);
							 String Selectionxpath  = e2.getKey();
							WebElement ele = (getWebDriver().findElement(By.xpath(Selectionxpath)));
							 Element ele3  = getElement(expectedSelection[i]);
							 _wait(1000);
								//4func._scrollToElement(ele3);
						
							 ele.clear();
							 _wait(1000);
							 ele.sendKeys(value);
							 //report
							 CustomReporting.logReport("", "", "Set the value of the " + expectedSelectionValues[i]+ " element on the page UmRatingDNO " + value , StepStatus.SUCCESS, new String[] {},
										startTime);
							 _wait(1000);
							 _click(getElement(expectedSelection[i]));
							// _clickTab();
							 //_clickTab();
							 func.setValue3(ele3);
							 func.setValue3(ele3);
						}
					}
					
				}
				


				// Schedule Rating table
				
			 	_wait(2000);
				_setValue(getElement(txtSRStregthCorpGovtSelection), dataUmLogin.getData("DNOSRStregthCorpGovtSelection"));
				_wait(2000);
				_setValue(getElement(txtSRLossExpSelection), dataUmLogin.getData("DNOSRLossExpSelection"));
				_wait(2000);
				_setValue(getElement(txtSROverallFinLiqSelection), dataUmLogin.getData("DNOSROverallFinLiqSelection"));
				_wait(2000);
				_setValue(getElement(txtSRAffRecessionSelection), dataUmLogin.getData("DNOSRAffRecessionSelection"));
				_wait(2000);
				_setValue(getElement(txtSRQualityManageSelection), dataUmLogin.getData("DNOSRQualityManageSelection"));
				

				_wait(2000);
				_click(getElement(btnCMEndFact));
				_wait(2000);
				_setValue(getElement(txtCMEndFact), dataUmLogin.getData("DNOCMEndFact"));
				//func.setValue6();
				_wait(2000);
				String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("DNOCMEndFact")+"\")]";
				WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
				expectedOption.click();
				if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) 
				{	
					
				}
				else
				{
					_setValue(getElement(txtCMEndFactSel), dataUmLogin.getData("DNOCMEndFactSelection"));
				}
			
				
			

			if (dataUmLogin.getData("DNOInvestigativeCosts").equalsIgnoreCase("Yes")) {
				//_click(getElement(chkInvestigativeCosts));
				_wait(5000);
				_setValue(getElement(txtInvestigativeCosts), dataUmLogin.getData("DNOInvestigativeCostsSublimit"));
				_wait(5000);
			}
			
			
			if (dataUmLogin.getData("DNOAssetProtectionCosts").equalsIgnoreCase("Yes")) {
				//_click(getElement(chkAssetProtectionCosts));
				_setValue(getElement(txtAssetProtectionCosts), dataUmLogin.getData("DNOAssetProtectionCostsSublimit"));

				_wait(5000);
			}
			if (dataUmLogin.getData("DNOPublicRelationsCosts").equalsIgnoreCase("Yes")) {
				//_click(getElement(chkPublicRelationsCosts));
				_wait(5000);
				_setValue(getElement(txtPublicRelationsCosts), dataUmLogin.getData("DNOPublicRelationsCostsSublimit"));
				_wait(5000);
			}
			
			if (dataUmLogin.getData("DNOSeparateDefenseCostCoverage").equalsIgnoreCase("Yes")) 
			{
				_click(getElement(chkDNOSeparateDefenseCostCoverage));
				_wait(5000);
				//_setValue(getElement(txtDNOSeparateDefenseCostCoverage),dataUmLogin.getData("DNOSeparateDefenseCostLimit"));
				_wait(5000);
			}
			
			_wait(5000);
			_click(getElement(btnUpdateCoverages));
			_wait(15000);
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			
			

			
			
			
			if (dataUmLogin.getData("DNOAdditionalSideALimit").equalsIgnoreCase("Yes")) 
			{
				/*_click(getElement(chkAdditionalSideALimit));
				_wait(3000);*/
				Robot rb = new Robot();
				rb.keyPress(KeyEvent.VK_END);
				rb.keyRelease(KeyEvent.VK_END);
				WebElement we = (WebElement)getClonedElement(chkAdditionalSideALimit).getNative();
				if(we.isSelected())
				{
					_click(getElement(btnUpdateCoverages));
					_wait(3000);
					w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
					_wait(5000);
				}
				else
				{
					_click(getElement(chkAdditionalSideALimit));
					_wait(3000);
					_click(getElement(btnUpdateCoverages));
					_wait(3000);
					w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
					_wait(5000);
					
				}
				
				_setValue(getElement(txtAdditionalSideALimit), dataUmLogin.getData("DNOAdditionalSideALimitvalue"));
				_wait(5000);
			}
			if (dataUmLogin.getData("DNOSeparateDefenseCostCoverage").equalsIgnoreCase("Yes")) 
			{
				//_click(getElement(chkDNOSeparateDefenseCostCoverage));
				_wait(5000);
				_setValue(getElement(txtDNOSeparateDefenseCostCoverage),dataUmLogin.getData("DNOSeparateDefenseCostLimit"));
				_wait(5000);
			}
			
			}
			
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	}

}

