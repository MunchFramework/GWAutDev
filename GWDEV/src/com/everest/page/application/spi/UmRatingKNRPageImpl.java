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

import com.everest.page.application.UmRatingKNRPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmRatingKNRPageImpl extends CustomAbstractPage implements UmRatingKNRPage {

	@Override
	public void UmRatingKNR(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmLogin = PageDataManager.instance().getPageData("KNR", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		/*String strScreenShots = dataUmLogin.getData("PrintScreens");
		if (strScreenShots.equalsIgnoreCase("Yes")) {
			func._takeScreenShot(getWebDriver(), "START", "", "");
		}*/
		_wait(1000);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		WebDriverWait w1 = new WebDriverWait(getWebDriver(),10);
		_click(getElement(btnKNRPage));
		_wait(4000);
		_wait(4000);
		_setValue(getElement(txtRansomLimitOfLiability), dataUmLogin.getData("RansomLimitOfLiability"));
		_clickTab();
		_setValue(getElement(txtRansomDeductible), dataUmLogin.getData("RansomDeductible"));
		_clickTab();
		/*_setValue(getElement(txtTransitLossLimitOfLiability), dataUmLogin.getData("TransitLossLimitOfLiability"));
		_clickTab();
		_setValue(getElement(txtLegalLiabilityLimitOfLiability), dataUmLogin.getData("LegalLiabilityLimitOfLiability"));
		_clickTab();
		_setValue(getElement(txtInsuredEventExpensesLimitOfLiability), dataUmLogin.getData("InsuredEventExpensesLimitOfLiability"));
		_clickTab();*/
		
//		_click(getElement(btnKNRExculdedCountry));
//		_wait(2000);
//		_setValue(getElement(txtKNRExculdedCountry), dataUmLogin.getData("KNRExculdedCountry"));
//		_wait(4000);
//		func.setValue6();
//		_wait(2000);
//		_clickTab();
//		_click(getElement(btnKNRExculdedCountry));
//		_wait(2000);
//		_click(getElement(btnRecallExpensesBasePremiumFactorSelectOption));
//		_wait(4000);
//		_setValue(getElement(txtRecallExpensesBasePremiumFactorSelectOption), dataUmLogin.getData("RecallExpensesBasePremiumFactorSelectOption"));
//		_clickTab();
//		_setValue(getElement(txtRecallExpensesBasePremiumFactorSelection), dataUmLogin.getData("RecallExpensesBasePremiumFactorSelection"));
//		_clickTab();
		if (dataUmLogin.getData("EnterModifiers").equalsIgnoreCase("Yes"))
		{
		String expectedSelectOption[] = {"btnDFRiskinessofCountriesTraveledToSelectOption","btnDFFrequencyofTravelSelectOption","btnDFSecurityMeasuresinForeignCountriesSelectOption","btnDFIndustryGroupSelectOption","btnDFTravelAdvisoryPolicySelectOption","btnDFProductExposureSelectOption"};	
		String expectedSelectOptionValues[] = {"KNRDFRiskinessofCountriesTraveledToSelectOption","KNRDFFrequencyofTravelSelectOption","KNRDFSecurityMeasuresinForeignCountriesSelectOption","KNRDFIndustryGroupSelectOption","KNRDFTravelAdvisoryPolicySelectOption","KNRDFProductExposureSelectOption"};	
		String expectedSelection[] = 		{"txtDFRiskinessofCountriesTraveledToSelection","txtDFFrequencyofTravelSelection","txtDFSecurityMeasuresinForeignCountriesSelection","txtDFIndustryGroupSelection","txtDFTravelAdvisoryPolicySelection","txtDFProductExposureSelection"};	
		String expectedSelectionValues[] = {"KNRDFRiskinessofCountriesTraveledToSelection","KNRDFFrequencyofTravelSelection","KNRDFSecurityMeasuresinForeignCountriesSelection","KNRDFIndustryGroupSelection","KNRDFTravelAdvisoryPolicySelection","KNRDFProductExposureSelection"};	
		
	 int l = expectedSelectOption.length;
	 for (int i=0;i<l;i++)
	 {
		 
		 if (i==0)
		 {
		 _wait(1000);
		 _click(getElement(expectedSelectOption[i]));
		 }
		 else
		 {
			 func.setValue6();
		 }
		 w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/um-dropdown-search/input")));
		String xpath = "/html/body/div[3]/um-dropdown-search/input";
		_wait(2000);
						
			WebElement ele2 = (getWebDriver().findElement(By.xpath(xpath)));
			String SlctOption = (dataUmLogin.getData(expectedSelectOptionValues[i]));
			ele2.sendKeys(SlctOption);
			//REPORT
			_wait(4000);
			String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData(expectedSelectOptionValues[i])+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			expectedOption.click();
			long startTime = System.currentTimeMillis();
			CustomReporting.logReport("", "", "Set the value of the " + expectedSelectOptionValues[i]+ " element on the page UmRatingEMP " + SlctOption , StepStatus.SUCCESS, new String[] {},
					startTime);
			//func.setValue6();
			_wait(1000);
			func.setValue3(getElement(expectedSelectOption[i]));
			
			if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
				
				func.setValue9();
//				_clickTab();
//				_clickTab();
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
		 String value = dataUmLogin.getData(expectedSelectionValues[i]);
		 String Selectionxpath  = e2.getKey();
		WebElement ele = (getWebDriver().findElement(By.xpath(Selectionxpath)));
		 Element ele3  = getElement(expectedSelection[i]);
		 _wait(1000);
			func._scrollToElement(ele3);
	
		 ele.clear();
		 _wait(1000);
		 ele.sendKeys(value);
		//report
		 CustomReporting.logReport("", "", "Set the value of the " + expectedSelectionValues[i]+ " element on the page UmRatingEMP " + value , StepStatus.SUCCESS, new String[] {},
					startTime);
		 _wait(1000);
		 _click(getElement(expectedSelection[i]));
	
		 func.setValue3(ele3);
		 func.setValue3(ele3);
			}
			}

		
		}
		_wait(5000);
		if (dataUmLogin.getData("EnterModifiers").equalsIgnoreCase("Yes"))
		{
			String expectedSelectOption[] = {"btnCMEndorsementFactorSelectOption","btnCMRecallExpensesBasePremiumFactorSelectOption","btnCMBusinessInterruptionEndorsementAggregateLimitofLiabilitySelectOption","btnCMTravelSecurityEvacuationEndorsementAggregateLimitofLiabilitySelectOption","btnCMExpatriateSecurityEvacuationEndorsementAggregateLimitofLiabilitySelectOption"};	
			String expectedSelectOptionValues[] = {"KNRCMEndorsementFactorSelectOption","KNRCMRecallExpensesBasePremiumFactorSelectOption","KNRCMBusinessInterruptionEndorsementAggregateLimitofLiabilitySelectOption","KNRCMTravelSecurityEvacuationEndorsementAggregateLimitofLiabilitySelectOption","KNRCMExpatriateSecurityEvacuationEndorsementAggregateLimitofLiabilitySelectOption"};	
			String expectedSelection[] = 		{"txtCMEndorsementFactorSelection","txtCMRecallExpensesBasePremiumFactorSelection","txtCMBusinessInterruptionEndorsementAggregateLimitofLiabilitySelection","txtCMTravelSecurityEvacuationEndorsementAggregateLimitofLiabilitySelection","txtCMExpatriateSecurityEvacuationEndorsementAggregateLimitofLiabilitySelection"};	
			String expectedSelectionValues[] = {"KNRCMEndorsementFactorSelection","KNRCMRecallExpensesBasePremiumFactorSelection","KNRCMBusinessInterruptionEndorsementAggregateLimitofLiabilitySelection","KNRCMTravelSecurityEvacuationEndorsementAggregateLimitofLiabilitySelection","KNRCMExpatriateSecurityEvacuationEndorsementAggregateLimitofLiabilitySelection"};	
			
	 int l = expectedSelectOption.length;
	 for (int i=0;i<l;i++)
	 {
		 
		 if (i==0)
		 {
		 _wait(1000);
		 _click(getElement(expectedSelectOption[i]));
		 }
		 else
		 {
			 func.setValue6();
		 }
		 w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/um-dropdown-search/input")));
		String xpath = "/html/body/div[3]/um-dropdown-search/input";
		_wait(2000);
						
			WebElement ele2 = (getWebDriver().findElement(By.xpath(xpath)));
			String SlctOption = (dataUmLogin.getData(expectedSelectOptionValues[i]));
			ele2.sendKeys(SlctOption);
			//REPORT
			_wait(4000);
			String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData(expectedSelectOptionValues[i])+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			expectedOption.click();
			long startTime = System.currentTimeMillis();
			CustomReporting.logReport("", "", "Set the value of the " + expectedSelectOptionValues[i]+ " element on the page UmRatingEMP " + SlctOption , StepStatus.SUCCESS, new String[] {},
					startTime);
			//func.setValue6();
			_wait(1000);
			func.setValue3(getElement(expectedSelectOption[i]));
			
			if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
				
				func.setValue9();
				//_clickTab();
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
		 String value = dataUmLogin.getData(expectedSelectionValues[i]);
		 String Selectionxpath  = e2.getKey();
		WebElement ele = (getWebDriver().findElement(By.xpath(Selectionxpath)));
		 Element ele3  = getElement(expectedSelection[i]);
		 _wait(1000);
			func._scrollToElement(ele3);
	
		 ele.clear();
		 _wait(1000);
		 ele.sendKeys(value);
		//report
		 CustomReporting.logReport("", "", "Set the value of the " + expectedSelectionValues[i]+ " element on the page UmRatingEMP " + value , StepStatus.SUCCESS, new String[] {},
					startTime);
		 _wait(1000);
		 _click(getElement(expectedSelection[i]));
	
		 func.setValue3(ele3);
		 func.setValue3(ele3);

			}
			}
	 _setValue(getElement(txtSRStrengthofCorporateGovernance), dataUmLogin.getData("KNRSRStrengthofCorporateGovernance"));
		_clickTab();
		_setValue(getElement(txtSRLossExperience), dataUmLogin.getData("KNRSRLossExperience"));
		_clickTab();
		_setValue(getElement(txtSROverallFinancialLiquidity), dataUmLogin.getData("KNRSROverallFinancialLiquidity"));
		_clickTab();
		_setValue(getElement(txtSRAffectedbyRecession), dataUmLogin.getData("KNRSRAffectedbyRecession"));
		_clickTab();
		_setValue(getElement(txtSRQualityofManagement), dataUmLogin.getData("KNRSRQualityofManagement"));
		_clickTab();

		_wait(5000);
		_click(getElement(btnUpdateCoverages));
		_wait(10000);
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

		
		}
	}
	
	@Override
	public void Verify_SRM_KNR_Error_Msg(String tcID, SoftAssert softAs) throws Exception {
		try {
			
			_click(getElement(btnKNRPage));
			_wait(10000);
			List<String> web_elements_list = new ArrayList<String>();
			List<String> SRM_MIN_MAX_VALUES_LIST = new ArrayList<String>();
			List<String> variable_names_list = new ArrayList<String>();

			PageData data = PageDataManager.instance().getPageData("KNR", tcID);
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
   	public void Update_SRM_KNR(String tcID, SoftAssert softAs) throws Exception {
   		try 
   		{
   			
   			PageData data = PageDataManager.instance().getPageData("KNR", tcID);
   			WebDriverWait w = new WebDriverWait(getWebDriver(),250);
			
   			_click(getElement(btnKNRPage));
   			_wait(10000);
   			_setValue(getElement(txtSRStrengthofCorporateGovernance), data.getData("KNRSRStrengthofCorporateGovernance"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSRLossExperience), data.getData("KNRSRLossExperience"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSROverallFinancialLiquidity), data.getData("KNRSROverallFinancialLiquidity"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSRAffectedbyRecession),  data.getData("KNRSRAffectedbyRecession"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSRQualityofManagement), data.getData("KNRSRQualityofManagement"));
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