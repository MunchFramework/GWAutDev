package com.everest.page.application.spi;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.Element;

import com.everest.page.application.UmRatingEPLPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmRatingEPLPageImpl extends CustomAbstractPage implements UmRatingEPLPage {

	@Override
	public void UmRatingEPL(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		PageData dataUmModifiers = PageDataManager.instance().getPageData("UmModifiers", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		_wait(5000);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		WebDriverWait w1 = new WebDriverWait(getWebDriver(),10);
		_wait(1000);
		_click(getElement(btnRatingEPLtab));
		_wait(4000);
		
		if (func._isVisible(getElement(txtRetention)) == false)
		{
			_wait(1000);
			func._scrollToElement(getElement(btnRatingEPLtab));
			_click(getElement(btnRatingEPLtab));
			_wait(8000);
		}
		
		
		_setValue(getElement(txtAggregateLimit), dataUmLogin.getData("EPLAggregateLimit"));
		_clickTab();
		_wait(4000);

		_setValue(getElement(txtRetention), dataUmLogin.getData("EPLRetention"));
		_clickTab();
		_wait(4000);
		_setValue(getElement(txtDate), dataUmLogin.getData("EPLDate"));
		_clickTab();
		_wait(4000);
		/*if (func._isVisible(getElement(txtAddtnlClaimExpLimit))==true)
		{
			_setValue(getElement(txtAddtnlClaimExpLimit), dataUmLogin.getData("EPLAddtnlClaimExpLimit"));
			_wait(1000);
		}*/
//		_click(getElement(btnCMThirdPartExposure));
//		_setValue(getElement(txtCMThirdPartExposure), dataUmLogin.getData("EPLCMThirdPartExposure"));
//		func.setValue6();
//		_wait(5000);
//		_setValue(getElement(txtEPLWageAndHour), dataUmLogin.getData("EPLWageAndHourSublimit"));
		
		_wait(5000);
		_click(getElement(btnUpdateCoverages));
		_wait(10000);
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		
		
		if (dataUmModifiers.getData("EnterModifiers").equalsIgnoreCase("Yes"))
		{
			String expectedSelectOption[] = {"btnDFHazardCountyLoc","btnDFNatureofOperations","btnDFNumberofYearsinBusiness","btnDFMergerAcquisitionorDivestitureActivity","btnDFPastorContemplatedLayofforClosingActivity","btnDFAnnualCompensationofEmployees","btnDFEmployeeTurnover","btnDFLitigationHistory","btnDFSignificantTransactionorEvent","btnDFManagementStability","btnDFHumanResourcesPoliciesandProcedures"};	
			String expectedSelectOptionValues[] = {"EPLDFHazardCountyLoc","EPLDFNatureofOperations","EPLDFNumberofYearsinBusiness","EPLDFMergerAcquisitionorDivestitureActivity","EPLDFPastorContemplatedLayofforClosingActivity","EPLDFAnnualCompensationofEmployees","EPLDFEmployeeTurnover","EPLDFLitigationHistory","EPLDFSignificantTransactionorEvent","EPLDFManagementStability","EPLDFHumanResourcesPoliciesandProcedures"};	
			String expectedSelection[] = {"txtDFHazardCountyLocSel","txtDFNatureofOperationsSel","txtDFNumberofYearsinBusinessSel","txtDFMergerAcquisitionorDivestitureActivitySel","txtDFPastorContemplatedLayofforClosingActivitySel","txtDFAnnualCompensationofEmployeesSel","txtDFEmployeeTurnoverSel","txtDFLitigationHistorySel","txtDFSignificantTransactionorEventSel","txtDFManagementStabilitySel","txtDFHumanResourcesPoliciesandProceduresSel"};	
			String expectedSelectionValues[] = {"EPLDFHazardCountyLocSel","EPLDFNatureofOperationsSel","EPLDFNumberofYearsinBusinessSel","EPLDFMergerAcquisitionorDivestitureActivitySel","EPLDFPastorContemplatedLayofforClosingActivitySel","EPLDFAnnualCompensationofEmployeesSel","EPLDFEmployeeTurnoverSel","EPLDFLitigationHistorySel","EPLDFSignificantTransactionorEventSel","EPLDFManagementStabilitySel","EPLDFHumanResourcesPoliciesandProceduresSel"};	
		 int l = expectedSelectOption.length;
		 for (int i=0;i<l;i++)
		 {
			 
			 if (i==0)
			 {
			 _wait(1000);
			 func._scrollToElement(getElement(expectedSelectOption[i]));
			 _wait(2000);
			 _click(getElement(expectedSelectOption[i]));
			 }
			 else if (i==5)
			 {
				 func._scrollToElement(getElement(expectedSelectOption[i+5]));  
				 _wait(1000);
				 func.setValue2(getElement(expectedSelectOption[i]));
			 }
			 else if (i==6)
			 {
				 func._scrollToElement(getElement(expectedSelectOption[i+4]));  
				 _wait(1000);
				 func.setValue2(getElement(expectedSelectOption[i]));
			 }
			 else
			 {
				 func.setValue6();
			 }
			 w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/um-dropdown-search/input")));
			String xpath = "/html/body/div[3]/um-dropdown-search/input";
			_wait(4000);
							
				WebElement ele2 = (getWebDriver().findElement(By.xpath(xpath)));
				String SlctOption = (dataUmModifiers.getData(expectedSelectOptionValues[i]));
				ele2.sendKeys(SlctOption);
				_wait(4000);
				String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmModifiers.getData(expectedSelectOptionValues[i])+"\")]";
				WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
				expectedOption.click();
				long startTime = System.currentTimeMillis();
				CustomReporting.logReport("", "", "Set the value of the " + expectedSelectOptionValues[i]+ " element on the page UmRatingEPL " + SlctOption , StepStatus.SUCCESS, new String[] {},
						startTime);

				//func.setValue6();
				func.setValue3(getElement(expectedSelectOption[i]));
				
			 	
				if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	

					func.setValue9();
				}
				else
				{			
			_wait(1000);
			Element e2  = getElement(expectedSelection[i]);
			_wait(1000);
			func._scrollToElement(e2);
			_wait(1000);
			 _click(getElement(expectedSelection[i]));
			 
			 _wait(1000);
			 String value = dataUmModifiers.getData(expectedSelectionValues[i]);
			 String Selectionxpath  = e2.getKey();
			WebElement ele = (getWebDriver().findElement(By.xpath(Selectionxpath)));
			 Element ele3  = getElement(expectedSelection[i]);
			 _wait(1000);
				func._scrollToElement(ele3);
		
			 ele.clear();
			 _wait(1000);
			 ele.sendKeys(value);
			 //report
			 CustomReporting.logReport("", "", "Set the value of the " + expectedSelectionValues[i]+ " element on the page UmRatingEPL " + value , StepStatus.SUCCESS, new String[] {},
						startTime);
			 _wait(1000);
			 _click(getElement(expectedSelection[i]));
		
			 func.setValue3(ele3);
			 func.setValue3(ele3);
				}
				}
//			_wait(1000);
//			_click(getElement(btnDFHazardCountyLoc));
//			_setValue(getElement(txtDFHazardCountyLoc), dataUmModifiers.getData("EPLDFHazardCountyLoc"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFHazardCountyLocSel), dataUmModifiers.getData("EPLDFHazardCountyLocSel"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//			_setValue(getElement(txtDFNatureofOperations), dataUmModifiers.getData("EPLDFNatureofOperations"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFNatureofOperationsSel), dataUmModifiers.getData("EPLDFNatureofOperationsSel"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//			_setValue(getElement(txtDFNumberofYearsinBusiness), dataUmModifiers.getData("EPLDFNumberofYearsinBusiness"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFNumberofYearsinBusinessSel), dataUmModifiers.getData("EPLDFNumberofYearsinBusinessSel"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//			_setValue(getElement(txtDFMergerAcquisitionorDivestitureActivity), dataUmModifiers.getData("EPLDFMergerAcquisitionorDivestitureActivity"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFMergerAcquisitionorDivestitureActivitySel), dataUmModifiers.getData("EPLDFMergerAcquisitionorDivestitureActivitySel"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//			_setValue(getElement(txtDFPastorContemplatedLayofforClosingActivity), dataUmModifiers.getData("EPLDFPastorContemplatedLayofforClosingActivity"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFPastorContemplatedLayofforClosingActivitySel), dataUmModifiers.getData("EPLDFPastorContemplatedLayofforClosingActivitySel"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//			_setValue(getElement(txtDFAnnualCompensationofEmployees), dataUmModifiers.getData("EPLDFAnnualCompensationofEmployees"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFAnnualCompensationofEmployeesSel), dataUmModifiers.getData("EPLDFAnnualCompensationofEmployeesSel"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//			_setValue(getElement(txtDFEmployeeTurnover), dataUmModifiers.getData("EPLDFEmployeeTurnover"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFEmployeeTurnoverSel), dataUmModifiers.getData("EPLDFEmployeeTurnoverSel"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//			_setValue(getElement(txtDFLitigationHistory), dataUmModifiers.getData("EPLDFLitigationHistory"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFLitigationHistorySel), dataUmModifiers.getData("EPLDFLitigationHistorySel"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//			_setValue(getElement(txtDFSignificantTransactionorEvent), dataUmModifiers.getData("EPLDFSignificantTransactionorEvent"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFSignificantTransactionorEventSel), dataUmModifiers.getData("EPLDFSignificantTransactionorEventSel"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//			_setValue(getElement(txtDFManagementStability), dataUmModifiers.getData("EPLDFManagementStability"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFManagementStabilitySel), dataUmModifiers.getData("EPLDFManagementStabilitySel"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//			_setValue(getElement(txtDFHumanResourcesPoliciesandProcedures), dataUmModifiers.getData("EPLDFHumanResourcesPoliciesandProcedures"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtDFHumanResourcesPoliciesandProceduresSel), dataUmModifiers.getData("EPLDFHumanResourcesPoliciesandProceduresSel"));
//			_clickTab();
//			_clickTab();
//			_wait(4000);
			
			_setValue(getElement(txtSRLossExperience), dataUmModifiers.getData("EPLSRLossExperience"));
			_clickTab();
			_setValue(getElement(txtSROverallFinancialLiquidity), dataUmModifiers.getData("EPLSROverallFinancialLiquidity"));
			_clickTab();
			_setValue(getElement(txtSRStrengthofCorporateGovernance), dataUmModifiers.getData("EPLSRStrengthofCorporateGovernance"));
			_clickTab();
			_setValue(getElement(txtSRAffectedbyRecession), dataUmModifiers.getData("EPLSRAffectedbyRecession"));
			_clickTab();
			_setValue(getElement(txtSRQualityofManagement), dataUmModifiers.getData("EPLSRQualityofManagement"));
			_clickTab();
		
			_wait(1000);
			if (dataUmModifiers.getData("EnterModifiers").equalsIgnoreCase("Yes")) 
			{
				WebElement WAH = (WebElement)getClonedElement(chkEPLWageAndHour).getNative();
				if (dataUmModifiers.getData("EPLWageAndHour").equalsIgnoreCase("Yes"))
				{
					if(WAH.isSelected())
					{
						_click(getElement(btnUpdateCoverages));
						_wait(1000);
						w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
					}
					else
					{
						_click(getElement(chkEPLWageAndHour));
						_wait(2000);
					}
				}
				if (dataUmModifiers.getData("EPLWageAndHour").equalsIgnoreCase("No"))
				{
					if(WAH.isSelected())
					{
						_click(getElement(chkEPLWageAndHour));
						_wait(2000);
						
					}
				
				}
				
				_wait(2000);
				_click(getElement(btnUpdateCoverages));
				_wait(2000);
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(4000);
				if (dataUmModifiers.getData("EPLWageAndHour").equalsIgnoreCase("Yes"))
				{
					func._scrollToElement(getElement(txtEPLWageAndHour));
					_wait(2000);
					_setValue(getElement(txtEPLWageAndHour), dataUmModifiers.getData("EPLWageAndHourSublimit"));
					_wait(2000);
				}
				
				
				// Discretionary Factors table
				
				String SelectOption[] = {"btnCMDutytoDefend","btnCMThirdPartyLiabilityCoverageDeletedFactor","btnCMThirdPartyExposure","btnCMEndorsementFactor","btnCMEWageandHourDefense"};	
				String SelectOptionValues[] = {"EPLCMDutytoDefend","EPLCMThirdPartyLiabilityCoverageDeletedFactor","EPLCMThirdPartyExposure","EPLCMEndorsementFactor","EPLCMEWageandHourDefense"};	
				String Selection[] = {"txtCMDutytoDefendSel","txtCMThirdPartyLiabilityCoverageDeletedFactorSel","txtCMThirdPartyExposureSel","txtCMEndorsementFactorSel","txtCMWageandHourDefensSel"};	
				String SelectionValues[] = {"EPLCMDutytoDefendSel","EPLCMThirdPartyLiabilityCoverageDeletedFactorSel","EPLCMThirdPartyExposureSel","EPLCMEndorsementFactorSel","EPLCMEWageandHourDefenseSel"};	
			 int l1 = SelectOption.length;
			 for (int i=1;i<l1;i++)
			 {
				 
				 if (i==1)
				 {
				 _wait(2000);
				 func._scrollToElement(getElement(SelectOption[i]));
				 _wait(2000);
				 _click(getElement(SelectOption[i]));
				 }
				 else
				 {
					 func.setValue6();
				 }
				 if(i==4)
				 {
					 if (dataUmModifiers.getData("EPLWageAndHour").equalsIgnoreCase("No"))
					 {
						 
					 }
					 else
					 {
						 w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/um-dropdown-search/input")));
							String xpath = "/html/body/div[3]/um-dropdown-search/input";
							_wait(3000);
											
								WebElement ele2 = (getWebDriver().findElement(By.xpath(xpath)));
								if (i==0)
								 {
								if (func._isVisible(getElement(txtCMDutytoDefend)) == false)
								{
									_wait(1000);
									 _click(getElement(btnCMDutytoDefend));
									 _wait(1000);
								}
								 }
								String Select = (dataUmModifiers.getData(SelectOptionValues[i]));
								ele2.sendKeys(Select);
								_wait(4000);
								String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmModifiers.getData(SelectOptionValues[i])+"\")]";
								WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
								expectedOption.click();
								
								long startTime = System.currentTimeMillis();
								CustomReporting.logReport("", "", "Set the value of the " + SelectOptionValues[i]+ " element on the page UmRatingEPL " + Select , StepStatus.SUCCESS, new String[] {},
										startTime);
								//func.setValue6();
								func.setValue3(getElement(SelectOption[i]));
								
								if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
									func.setValue9();	
								}
								else
								{ 	
									
							_wait(1000);
							Element e2  = getElement(Selection[i]);
							_wait(1000);
							func._scrollToElement(e2);
							_wait(1000);
							 _click(getElement(Selection[i]));
							 
							 _wait(1000);
							 String value = dataUmModifiers.getData(SelectionValues[i]);
							 String Selectxpath  = e2.getKey();
							WebElement ele = (getWebDriver().findElement(By.xpath(Selectxpath)));
							 Element ele3  = getElement(Selection[i]);
							 _wait(1000);
								func._scrollToElement(ele3);
						
							 ele.clear();
							 _wait(1000);
							 ele.sendKeys(value);
							 CustomReporting.logReport("", "", "Set the value of the " + SelectionValues[i]+ " element on the page UmRatingEPL " + value , StepStatus.SUCCESS, new String[] {},
										startTime);
							 _wait(1000);
							 _click(getElement(Selection[i]));
						
							 func.setValue3(ele3);
							 func.setValue3(ele3);
								}
					 }
					 }
					 else
					 {
						 w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/um-dropdown-search/input")));
				String xpath = "/html/body/div[3]/um-dropdown-search/input";
				_wait(3000);
								
					WebElement ele2 = (getWebDriver().findElement(By.xpath(xpath)));
					if (i==0)
					 {
					if (func._isVisible(getElement(txtCMDutytoDefend)) == false)
					{
						_wait(1000);
						 _click(getElement(btnCMDutytoDefend));
						 _wait(1000);
					}
					 }
					String Select = (dataUmModifiers.getData(SelectOptionValues[i]));
					ele2.sendKeys(Select);
					_wait(4000);
					String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmModifiers.getData(SelectOptionValues[i])+"\")]";
					WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
					expectedOption.click();
					
					long startTime = System.currentTimeMillis();
					CustomReporting.logReport("", "", "Set the value of the " + SelectOptionValues[i]+ " element on the page UmRatingEPL " + Select , StepStatus.SUCCESS, new String[] {},
							startTime);
					//func.setValue6();
					func.setValue3(getElement(SelectOption[i]));
					
					if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
						func.setValue9();	
					}
					else
					{ 	
						
				_wait(1000);
				Element e2  = getElement(Selection[i]);
				_wait(1000);
				func._scrollToElement(e2);
				_wait(1000);
				 _click(getElement(Selection[i]));
				 
				 _wait(1000);
				 String value = dataUmModifiers.getData(SelectionValues[i]);
				 String Selectxpath  = e2.getKey();
				WebElement ele = (getWebDriver().findElement(By.xpath(Selectxpath)));
				 Element ele3  = getElement(Selection[i]);
				 _wait(1000);
					func._scrollToElement(ele3);
			
				 ele.clear();
				 _wait(1000);
				 ele.sendKeys(value);
				 CustomReporting.logReport("", "", "Set the value of the " + SelectionValues[i]+ " element on the page UmRatingEPL " + value , StepStatus.SUCCESS, new String[] {},
							startTime);
				 _wait(1000);
				 _click(getElement(Selection[i]));
			
				 func.setValue3(ele3);
				 func.setValue3(ele3);
					}
					 }
					 
					}
			}
//			_click(getElement(btnCMDutytoDefend));
//			_setValue(getElement(txtCMDutytoDefend), dataUmModifiers.getData("EPLCMDutytoDefend"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtCMDutytoDefendSel), dataUmModifiers.getData("EPLCMDutytoDefendSel"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//			_setValue(getElement(txtCMThirdPartyLiabilityCoverageDeletedFactor), dataUmModifiers.getData("EPLCMThirdPartyLiabilityCoverageDeletedFactor"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtCMThirdPartyLiabilityCoverageDeletedFactorSel), dataUmModifiers.getData("EPLCMThirdPartyLiabilityCoverageDeletedFactorSel"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//			_setValue(getElement(txtCMThirdPartyExposure), dataUmModifiers.getData("EPLCMThirdPartyExposure"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtCMThirdPartyExposureSel), dataUmModifiers.getData("EPLCMThirdPartyExposureSel"));
//			_clickTab();
//			_clickTab();
//			func.setValue6();
//			_setValue(getElement(txtCMEndorsementFactor), dataUmModifiers.getData("EPLCMEndorsementFactor"));
//			func.setValue6();
//			_clickTab();
//			_setValue(getElement(txtCMEndorsementFactorSel), dataUmModifiers.getData("EPLCMEndorsementFactorSel"));
//			_clickTab();
//			_clickTab();
		
		}
		
		_click(getElement(LeftArrow));
	
		if (dataUmModifiers.getData("EPLWorkplaceViolenceExpenses").equalsIgnoreCase("No"))
		{
			
		_click(getElement(chkEPLWorkplaceViolenceExpenses));
		_wait(8000);
		}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		if (dataUmModifiers.getData("EPLCrisis").equalsIgnoreCase("Yes"))
		{
			_click(getElement(txtEPLCrisis));
		//_click(getElement(chkEPLCrisis));
		_wait(8000);
		_setValue(getElement(txtEPLCrisis), dataUmModifiers.getData("EPLCrisisSublimit"));
		_wait(5000);
		}
		if (dataUmModifiers.getData("EPLAdditionalClaimExpensesLimitforEPL").equalsIgnoreCase("No"))
		{
			
		_click(getElement(chkAddtnlClaimExpLimit));
		_wait(8000);
		}
		if (dataUmModifiers.getData("EPLThirdPartyLiability").equalsIgnoreCase("Yes"))
		{
		_click(getElement(chkEPLThirdPartyLiability));
		_wait(5000);
		}
		if (dataUmModifiers.getData("EPLSeparateDefense").equalsIgnoreCase("Yes"))
		{
			_click(getElement(chkEPLSeparateDefense));
			_wait(5000);
		//_setValue(getElement(txtEPLSeparateDefense), dataUmModifiers.getData("EPLSeparateDefenseCostLimit"));
				_wait(5000);
		}
//		if (dataUmModifiers.getData("EPLWageAndHour").equalsIgnoreCase("Yes"))
//		{
//		_click(getElement(chkEPLWageAndHour));
//		_wait(5000);
//		//_setValue(getElement(txtEPLWageAndHour), dataUmModifiers.getData("EPLWageAndHourSublimit"));
//		_wait(5000);
//		}
//		if (dataUmModifiers.getData("EPLWageAndHour").equalsIgnoreCase("No"))
//		{
//		//_click(getElement(chkEPLWageAndHour));
//		_wait(5000);
//		//_setValue(getElement(txtEPLWageAndHour), dataUmModifiers.getData("EPLWageAndHourSublimit"));
//		_wait(5000);
//		}
		
		_wait(5000);
		_click(getElement(btnUpdateCoverages));
		_wait(10000);
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

		
		if (dataUmModifiers.getData("EPLSeparateDefense").equalsIgnoreCase("Yes"))
		{
		//	_click(getElement(chkEPLSeparateDefense));
			_wait(5000);
		_setValue(getElement(txtEPLSeparateDefense), dataUmModifiers.getData("EPLSeparateDefenseCostLimit"));
				_wait(5000);
		}
//		if (dataUmModifiers.getData("EPLWageAndHour").equalsIgnoreCase("Yes"))
//		{
//	//	_click(getElement(chkEPLWageAndHour));
//		_wait(5000);
//		_setValue(getElement(txtEPLWageAndHour), dataUmModifiers.getData("EPLWageAndHourSublimit"));
//		_wait(5000);
//		}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		
		
		_click(getElement(btnUpdateCoverages));
		_wait(20000);
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

	}
	
	@Override
	public void Verify_SRM_EPL_Error_Msg(String tcID, SoftAssert softAs) throws Exception {
		try {
			
			_click(getElement(btnRatingEPLtab));
			_wait(10000);
			List<String> web_elements_list = new ArrayList<String>();
			List<String> SRM_MIN_MAX_VALUES_LIST = new ArrayList<String>();
			List<String> variable_names_list = new ArrayList<String>();

			PageData data = PageDataManager.instance().getPageData("EPL", tcID);
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
			
			
			web_elements_list.add("txtSRStrengthofCorporateGovernance");
			web_elements_list.add("txtSRStrengthofCorporateGovernance");
			web_elements_list.add("txtSRLossExperience");
			web_elements_list.add("txtSRLossExperience");
			web_elements_list.add("txtSROverallFinancialLiquidity");
			web_elements_list.add("txtSROverallFinancialLiquidity");
			web_elements_list.add("txtSRAffectedbyRecession");
			web_elements_list.add("txtSRAffectedbyRecession");
			web_elements_list.add("txtSRQualityofManagement");
			web_elements_list.add("txtSRQualityofManagement");
			
			 
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
   	public void Update_SRM_EPL(String tcID, SoftAssert softAs) throws Exception {
   		try 
   		{
   			
   			PageData data = PageDataManager.instance().getPageData("EPL", tcID);
   			WebDriverWait w = new WebDriverWait(getWebDriver(),250);
			
   			_click(getElement(btnRatingEPLtab));
   			_wait(10000);
   			_setValue(getElement(txtSRStrengthofCorporateGovernance), data.getData("EPLSRStrengthofCorporateGovernance"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSRLossExperience), data.getData("EPLSRLossExperience"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSROverallFinancialLiquidity), data.getData("EPLSROverallFinancialLiquidity"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSRAffectedbyRecession),  data.getData("EPLSRAffectedbyRecession"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSRQualityofManagement), data.getData("EPLSRQualityofManagement"));
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
	
}