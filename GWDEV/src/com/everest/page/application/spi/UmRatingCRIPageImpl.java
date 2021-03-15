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

import com.everest.page.application.UmRatingCRIPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmRatingCRIPageImpl extends CustomAbstractPage implements UmRatingCRIPage {

	@Override
	public void UmRatingCRI(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
	
		_wait(5000);
		
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		WebDriverWait w1 = new WebDriverWait(getWebDriver(),10);
		_wait(1000);
		_click(getElement(btnRatingCRItab));
		_wait(1000);
		_click(getElement(btnRatingCRItab));
		_wait(5000);
		_setValue(getElement(txtLimitPerOccurence), dataUmLogin.getData("LimitPerOccurence"));
		_clickTab();
		_wait(2000);

		_setValue(getElement(txtDeductiblePerOccurence), dataUmLogin.getData("DeductiblePerOccurence"));
		_wait(4000);
		_clickTab();
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		
		PageData dataUmModifiers = PageDataManager.instance().getPageData("UmModifiers", tcID);
		
		if (dataUmModifiers.getData("EnterModifiers").equalsIgnoreCase("Yes"))
		{
			_wait(2000);
			
			//_click(getElement(txtDFForgnLocExpSelection));
			_wait(2000);

			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
	
			
			String expectedSelectOption[] = {"btnDFNatOfOpsSelectOption","btnDFProfOfWrkSelectOption","btnDFOrgCompSelectOption","btnDFForgnLocExpSelectOption","btnDFHiValProcMatSelectOption","btnDFAudFuncSelectOption","btnDFIntContSelectOption","btnDFPreEmpScrSelectOption","btnDFInvMngSelectOption","btnDFVendMngGuidSelectOption","btnDFNoOfYrsSelectOption","btnDFMergAcqActSelectOption"};	
			String expectedSelectOptionValues[] = {"CRIDFNatOfOpsSelectOption","CRIDFProfOfrkSelectOption","CRIDFOrgCompSelectOption","CRIDFForgnLocExpSelectOption","CRIDFHiValProcMatSelectOption","CRIDFAudFuncSelectOption","CRIDFIntContSelectOption","CRIDFPreEmpScrSelectOption","CRIDFInvMngSelectOption","CRIDFVendMngGuidSelectOption","CRIDFNoOfYrsSelectOption","CRIDFMergAcqActSelectOption"};	
			String expectedSelection[] = 		{"txtDFNatOfOpsSelection","txtDFProfOfrkSelection","txtDFOrgCompSelection","txtDFForgnLocExpSelection","txtDFHiValProcMatSelection","txtDFAudFuncSelection","txtDFIntContSelection","txtDFPreEmpScrSelection","txtDFInvMngSelection","txtDFVendMngGuidSelection","txtDFNoOfYrsSelection","txtDFMergAcqActSelection"};	
			String expectedSelectionValues[] = {"CRIDFNatOfOpsSelection","CRIDFProfOfrkSelection","CRIDFOrgCompSelection","CRIDFForgnLocExpSelection","CRIDFHiValProcMatSelection","CRIDFAudFuncSelection","CRIDFIntContSelection","CRIDFPreEmpScrSelection","CRIDFInvMngSelection","CRIDFVendMngGuidSelection","CRIDFNoOfYrsSelection","CRIDFMergAcqActSelection"};	
			
		 int l = expectedSelectOption.length;
		 for (int i=0;i<l;i++)
		 {
			 
			 if (i==0)
			 {
			 _wait(1000);
			 _click(getElement(expectedSelectOption[i]));
			 }
			 else if (i==5)
			 {
				 func._scrollToElement(getElement(expectedSelectOption[i+6]));  
				 _wait(1000);
				 func.setValue2(getElement(expectedSelectOption[i]));
			 }
			 else
			 {
				 if (i==9)
				 {	
					 _wait(2000);
					 func._scrollToElement(getElement(expectedSelectOption[i+2]));
					// _click(getElement(expectedSelection[i+2])); 
					 _wait(2000);
				 }
				 func.setValue2(getElement(expectedSelectOption[i]));
			 }
			 w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/um-dropdown-search/input")));
			String xpath = "/html/body/div[3]/um-dropdown-search/input";
			
			_wait(3000);
							
				WebElement ele2 = (getWebDriver().findElement(By.xpath(xpath)));
				String SlctOption = (dataUmModifiers.getData(expectedSelectOptionValues[i]));
				ele2.sendKeys(SlctOption);
				_wait(4000);
				String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmModifiers.getData(expectedSelectOptionValues[i])+"\")]";
				WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
				expectedOption.click();
				
				//REPORT
				_wait(1000);
				long startTime = System.currentTimeMillis();
				CustomReporting.logReport("", "", "Set the value of the " + expectedSelectOptionValues[i]+ " element on the page UmRatingCRI " + SlctOption , StepStatus.SUCCESS, new String[] {},
						startTime);
				//func.setValue6();
				_wait(1000);
				func.setValue3(getElement(expectedSelectOption[i]));
				
				if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
					func.setValue3(getElement(expectedSelectOption[i]));
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
			 CustomReporting.logReport("", "", "Set the value of the " + expectedSelectionValues[i]+ " element on the page UmRatingCRI " + value , StepStatus.SUCCESS, new String[] {},
						startTime);
			 _wait(1000);
			 _click(getElement(expectedSelection[i]));
		
			 func.setValue3(ele3);
			 func.setValue3(ele3);
				}
				}
						
			_setValue(getElement(txtSRStrengthOfCorpGovSelection), dataUmModifiers.getData("CRISRStrengthOfCorpGovSelection"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			_setValue(getElement(txtSRLossExpSelection), dataUmModifiers.getData("CRISRLossExpSelection"));
			_clickTab();
			_setValue(getElement(txtSROverallFinanLiqSelection), dataUmModifiers.getData("CRISROverallFinanLiqSelection"));
			_clickTab();
			_setValue(getElement(txtSRAffByRecessionSelection), dataUmModifiers.getData("CRISRAffByRecessionSelection"));
			_clickTab();
			_setValue(getElement(txtSRQualityOfMngmntSelection), dataUmModifiers.getData("CRISRQualityOfMngmntSelection"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			if (dataUmModifiers.getData("EnterModifiers").equalsIgnoreCase("Yes")) {
				String SelectOption[] = {"btnCMEndFactSelectOption"};	
				String SelectOptionValues[] = {"CRICMEndFactSelectOption"};	
				String Selection[] = {"txtCMEndFactSelection"};	
				String SelectionValues[] = {"CRICMEndFactSelection"};	
			 int l1 = SelectOption.length;
			 for (int i=0;i<l1;i++)
			 {
				
				 if (i==0)
				 {
				 _wait(3000);
				 _click(getElement(SelectOption[i]));
				 }
				 else
				 {
					 func.setValue6();
				 }
				 w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/um-dropdown-search/input")));
				String xpath = "/html/body/div[3]/um-dropdown-search/input";
				_wait(3000);
								
					WebElement ele2 = (getWebDriver().findElement(By.xpath(xpath)));
					String Select = (dataUmModifiers.getData(SelectOptionValues[i]));
					if (ele2.isDisplayed())
					{	
					ele2.sendKeys(Select);
					}
					else
					{	
						
						 _click(getElement(SelectOption[i]));	
						 _wait(4000);
						 w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/um-dropdown-search/input")));
						 ele2.sendKeys(Select);
					}
					String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmModifiers.getData(SelectOptionValues[i])+"\")]";
					WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
					expectedOption.click();
					//report
					_wait(1000);
					long startTime = System.currentTimeMillis();
					 CustomReporting.logReport("", "", "Set the value of the " + SelectOptionValues[i]+ " element on the page UmRatingCRI " + Select , StepStatus.SUCCESS, new String[] {},
								startTime);
					//func.setValue6();
					func.setValue3(getElement(SelectOption[i]));
					
				 	
					if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
						
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
				 CustomReporting.logReport("", "", "Set the value of the " + SelectionValues[i]+ " element on the page UmRatingCRI " + value, StepStatus.SUCCESS, new String[] {},
							startTime);
				 _wait(1000);
				 _click(getElement(Selection[i]));
			
				 func.setValue3(ele3);
				 func.setValue3(ele3);
					}
					}
			 
			}
			
			
				

		
		}
		if (dataUmModifiers.getData("EnterModifiers").equalsIgnoreCase("Yes"))
		{

		//Optional Coverage Enhancements check
		if (dataUmLogin.getData("CRIPremisesCoverage").equalsIgnoreCase("No"))
		{
		_click(getElement(chkPremisesCoverage));
		_wait(5000);
		func.validateCheckbox(getElement(chkPremisesCoverage));
		}
		
		if (dataUmLogin.getData("CRIInTransitCoverage").equalsIgnoreCase("No"))
		{
		_click(getElement(chkInTransitCoverage));
		_wait(5000);
		func.validateCheckbox(getElement(chkInTransitCoverage));
		}
		
		if (dataUmLogin.getData("CRIForgeryCoverage").equalsIgnoreCase("No"))
		{
		_click(getElement(chkForgeryCoverage));
		_wait(5000);
		func.validateCheckbox(getElement(chkForgeryCoverage));
       func.setValue9();
		}
		if (dataUmLogin.getData("CRIComputerFraudCoverage").equalsIgnoreCase("No"))
		{
		_wait(2000);
		_click(getElement(chkComputerFraudCoverage));
		_wait(5000);
		func.validateCheckbox(getElement(chkComputerFraudCoverage));

		}
//		if (tcID.equalsIgnoreCase("DS_R2_SIT_E2E_SC29"))
//		{
//			func.validateCheckbox(getElement(chkComputerFraudCoverage));
//			_wait(4000);
//	
//		}
		if (dataUmLogin.getData("CRIFundsTransferFraudCoverage").equalsIgnoreCase("No"))
		{
			
			_click(getElement(chkFundsTransferFraudCoverage));
		_wait(5000);
		func.validateCheckbox(getElement(chkFundsTransferFraudCoverage));
	
		}
		if (dataUmLogin.getData("CRIMoneyOrdersandCounterfeitCurrencyFraudCoverage").equalsIgnoreCase("No"))
		{
			
		_click(getElement(chkMoneyOrdersandCounterfeitCurrencyFraudCoverage));
		_wait(5000);
		func.validateCheckbox(getElement(chkMoneyOrdersandCounterfeitCurrencyFraudCoverage));
	
		}
		if (dataUmLogin.getData("CRICreditCardFraudCoverage").equalsIgnoreCase("No"))
		{
		
		_click(getElement(chkCreditCardFraudCoverage));
		_wait(5000);
		func.validateCheckbox(getElement(chkCreditCardFraudCoverage));
	
		}
		if (dataUmLogin.getData("CRIClientCoverage").equalsIgnoreCase("Yes"))
		{
			
		_click(getElement(chkClientCoverage));
		_wait(5000);
		func.validateCheckbox(getElement(chkClientCoverage));
		
	
		}
		if (dataUmLogin.getData("CRISocialEngineeringFraudCoverage").equalsIgnoreCase("Yes"))
		{
			
		_click(getElement(chkSocialEngineeringFraudCoverage));
		_wait(3000);
		func.validateCheckbox(getElement(chkSocialEngineeringFraudCoverage));
	
		}
		if (dataUmLogin.getData("CRIExpenseCoverage").equalsIgnoreCase("Yes"))
		{
			
		_click(getElement(chkExpenseCoverage));
		_wait(3000);
		func.validateCheckbox(getElement(chkExpenseCoverage));
		
		}
		_wait(5000);
		_click(getElement(btnUpdateCoverages));
		_wait(10000);
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

		
		//Optional Coverage Enhancements Values
		if (dataUmLogin.getData("CRIPremisesCoverage").equalsIgnoreCase("Yes"))
		{
		_wait(10000);
		func._scrollToElement(getElement(txtPremisesCoverageLimit));
		_setValue(getElement(txtPremisesCoverageLimit), dataUmLogin.getData("PremisesCoverageLimit"));
		_setValue(getElement(txtPremisesCoverageDeductible), dataUmLogin.getData("PremisesCoverageDeductible"));
		
		}
		
		if (dataUmLogin.getData("CRIInTransitCoverage").equalsIgnoreCase("Yes"))
		{
		_wait(3000);
		_setValue(getElement(txtInTransitCoverageLimit), dataUmLogin.getData("InTransitCoverageLimit"));
		_setValue(getElement(txtInTransitCoverageDeductible), dataUmLogin.getData("InTransitCoverageDeductible"));
		
		}
		
		if (dataUmLogin.getData("CRIForgeryCoverage").equalsIgnoreCase("Yes"))
		{
		_wait(3000);
		_setValue(getElement(txtForgeryCoverageLimit), dataUmLogin.getData("ForgeryCoverageLimit"));
		_setValue(getElement(txtForgeryCoverageDeductible), dataUmLogin.getData("ForgeryCoverageDeductible"));
		
		}
		if (dataUmLogin.getData("CRIComputerFraudCoverage").equalsIgnoreCase("Yes"))
		{
		_clickTab();
		_wait(3000);
		_setValue(getElement(txtComputerFraudCoverageLimit), dataUmLogin.getData("ComputerFraudCoverageLimit"));
		_setValue(getElement(txtComputerFraudCoverageDeductible), dataUmLogin.getData("ComputerFraudCoverageDeductible"));
		
		}
		if (dataUmLogin.getData("CRIFundsTransferFraudCoverage").equalsIgnoreCase("Yes"))
		{
			_clickTab();
		_wait(3000);
		_clickTab();
		_setValue(getElement(txtFundsTransferFraudCoverageLimit), dataUmLogin.getData("FundsTransferFraudCoverageLimit"));
		_clickTab();
		_setValue(getElement(txtFundsTransferFraudCoverageDeductible), dataUmLogin.getData("FundsTransferFraudCoverageDeductible"));
		
		}
		if (dataUmLogin.getData("CRIMoneyOrdersandCounterfeitCurrencyFraudCoverage").equalsIgnoreCase("Yes"))
		{
			_clickTab();
		_wait(3000);
		_clickTab();
		_setValue(getElement(txtMoneyOrdersandCounterfeitCurrencyFraudCoverageLimit), dataUmLogin.getData("MoneyOrdersandCounterfeitCurrencyFraudCoverageLimit"));
		_clickTab();
		_setValue(getElement(txtMoneyOrdersandCounterfeitCurrencyFraudCoverageDeductible), dataUmLogin.getData("MoneyOrdersandCounterfeitCurrencyFraudCoverageDeductible"));
		
		}
		if (dataUmLogin.getData("CRICreditCardFraudCoverage").equalsIgnoreCase("Yes"))
		{
			_clickTab();
		_wait(3000);
		_clickTab();
		_setValue(getElement(txtCreditCardFraudCoverageLimit), dataUmLogin.getData("CreditCardFraudCoverageLimit"));
		_clickTab();
		_setValue(getElement(txtCreditCardFraudCoverageDeductible), dataUmLogin.getData("CreditCardFraudCoverageDeductible"));
		
		}
		if (dataUmLogin.getData("CRIClientCoverage").equalsIgnoreCase("Yes"))
		{
			_clickTab();
		_wait(3000);
		_clickTab();
		_setValue(getElement(txtClientCoverageLimit), dataUmLogin.getData("ClientCoverageLimit"));
		_clickTab();
		_setValue(getElement(txtClientCoverageDeductible), dataUmLogin.getData("ClientCoverageDeductible"));
		
		}
		if (dataUmLogin.getData("CRISocialEngineeringFraudCoverage").equalsIgnoreCase("Yes"))
		{
			_clickTab();
		_wait(3000);
		_clickTab();
		_setValue(getElement(txtSocialEngineeringFraudCoverageLimit), dataUmLogin.getData("SocialEngineeringFraudCoverageLimit"));
		_clickTab();
		_setValue(getElement(txtSocialEngineeringFraudCoverageDeductible), dataUmLogin.getData("SocialEngineeringFraudCoverageDeductible"));
		
		}
		if (dataUmLogin.getData("CRIExpenseCoverage").equalsIgnoreCase("Yes"))
		{
			_clickTab();
		_wait(3000);
		_clickTab();
		_setValue(getElement(txtExpenseCoverageLimit), dataUmLogin.getData("ExpenseCoverageLimit"));
		_clickTab();
		func.setValue3(getElement(txtExpenseCoverageLimit));
		
		}	
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		_wait(8000);
		
		String expectedSelectOption[] = {"btnOCPremisesCoverageSelection","btnOCInTransitCoverageSelection","btnOCForgeryCoverageSelection","btnOCComputerFraudCoverageSelection","btnOCFundsTransferFraudCoverageSelection","btnOCMoneyOrdersandCounterfeitCurrencyFraudCoverageSelection","btnOCCreditCardFraudCoverageSelection","btnOCClientCoverageSelection","btnOCSocialEngineeringFraudCoverageSelection","btnOCExpenseCoverageSelection"};	
		String expectedSelectOptionValues[] = {"CRIOCPremisesCoverageSelectOption","CRIOCInTransitCoverageSelectOption","CRIOCForgeryCoverageSelectOption","CRIOCComputerFraudCoverageSelectOption","CRIOCFundsTransferFraudCoverageSelectOption","CRIOCMoneyOrdersandCounterfeitCurrencyFraudCoverageSelectOption","CRIOCCreditCardFraudCoverageSelectOption","CRIOCClientCoverageSelectOption","CRIOCSocialEngineeringFraudCoverageSelectOption","CRIOCExpenseCoverageSelectOption"};	
		String expectedSelection[] = {"txtOCPremisesCoverageSelection","txtOCInTransitCoverageSelection","txtOCForgeryCoverageSelection","txtOCComputerFraudCoverageSelection","txtOCFundsTransferFraudCoverageSelection","txtOCMoneyOrdersandCounterfeitCurrencyFraudCoverageSelection","txtOCCreditCardFraudCoverageSelection","txtOCClientCoverageSelection","txtOCSocialEngineeringFraudCoverageSelection","txtOCExpenseCoverageSelection"};	
		String expectedSelectionValues[] = {"CRIOCPremisesCoverageSelection","CRIOCInTransitCoverageSelection","CRIOCForgeryCoverageSelection","CRIOCComputerFraudCoverageSelection","CRIOCFundsTransferFraudCoverageSelection","CRIOCMoneyOrdersandCounterfeitCurrencyFraudCoverageSelection","CRIOCCreditCardFraudCoverageSelection","CRIOCClientCoverageSelection","CRIOCSocialEngineeringFraudCoverageSelection","CRIOCExpenseCoverageSelection"};	
		String coveragelist[] = {"CRIPremisesCoverage","CRIInTransitCoverage","CRIForgeryCoverage","CRIComputerFraudCoverage","CRIFundsTransferFraudCoverage","CRIMoneyOrdersandCounterfeitCurrencyFraudCoverage","CRICreditCardFraudCoverage","CRIClientCoverage","CRISocialEngineeringFraudCoverage","CRIExpenseCoverage"};
	 int l = expectedSelectOption.length;
	
	 for (int i=0;i<l-1;i++)
	 {
		 PageData dataUmLogin1 = PageDataManager.instance().getPageData("UmLogin", tcID);
			
		if (dataUmLogin1.getData(coveragelist[i]).equalsIgnoreCase("Yes"))
		{	
		 if (!(expectedSelectOptionValues[i].isEmpty())) {
		 if (i==0)
		 {
		 _wait(1000);
		 func._scrollToElement(getElement(expectedSelectOption[i+1]));
		 _wait(2000);
		 _click(getElement(expectedSelectOption[i]));
		 _wait(2000);
		 }
		
		 else
		 {
			 _wait(2000);
			 func.setValue2(getElement(expectedSelectOption[i]));
		 }
		_wait(1000);
		
		if (i==4)
		{
			func._scrollToElement(getElement("txtClientCoverageDeductible"));
		}
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/um-dropdown-search/input")));

		String xpath = "/html/body/div[3]/um-dropdown-search/input";
		_wait(2000);
						
			WebElement ele2 = (getWebDriver().findElement(By.xpath(xpath)));
			String SlctOption = (dataUmModifiers.getData(expectedSelectOptionValues[i]));
			ele2.sendKeys(SlctOption);
			_wait(4000);
			
			String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmModifiers.getData(expectedSelectOptionValues[i])+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			expectedOption.click();
		
			//REPORT
			_wait(2000);
			long startTime = System.currentTimeMillis();
			CustomReporting.logReport("", "", "Set the value of the " + expectedSelectOptionValues[i]+ " element on the page UmRatingCRI " + SlctOption , StepStatus.SUCCESS, new String[] {},
					startTime);
		
			_wait(2000);
			func.setValue3(getElement(expectedSelectOption[i]));
			
			if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
				
				func.setValue9();
				func.setValue9();
				func.setValue9();
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
		 CustomReporting.logReport("", "", "Set the value of the " + expectedSelectionValues[i]+ " element on the page UmRatingCRI " + value , StepStatus.SUCCESS, new String[] {},
					startTime);
		 _wait(1000);
		 _click(getElement(expectedSelection[i]));
	
		 func.setValue3(ele3);
		 func.setValue3(ele3);
		 func.setValue3(ele3);
		 func.setValue3(ele3);
		 func.setValue3(ele3);
	 }
		 }
	 }
	 }
		}
		}
	
	@Override
	public void Verify_SRM_CRI_Error_Msg(String tcID, SoftAssert softAs) throws Exception {
		try {
			
			_click(getElement(btnRatingCRItab));
			_wait(10000);
			List<String> web_elements_list = new ArrayList<String>();
			List<String> SRM_MIN_MAX_VALUES_LIST = new ArrayList<String>();
			List<String> variable_names_list = new ArrayList<String>();

			PageData data = PageDataManager.instance().getPageData("CRI", tcID);
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
			
			web_elements_list.add("txtSRStrengthOfCorpGovSelection");
			web_elements_list.add("txtSRStrengthOfCorpGovSelection");
			web_elements_list.add("txtSRLossExpSelection");
			web_elements_list.add("txtSRLossExpSelection");
			web_elements_list.add("txtSROverallFinanLiqSelection");
			web_elements_list.add("txtSROverallFinanLiqSelection");
			web_elements_list.add("txtSRAffByRecessionSelection");
			web_elements_list.add("txtSRAffByRecessionSelection");
			web_elements_list.add("txtSRQualityOfMngmntSelection");
			web_elements_list.add("txtSRQualityOfMngmntSelection");
			
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
   	public void Update_SRM_CRI(String tcID, SoftAssert softAs) throws Exception {
   		try 
   		{
   			
   			PageData data = PageDataManager.instance().getPageData("CRI", tcID);
   			WebDriverWait w = new WebDriverWait(getWebDriver(),250);
			
   			_click(getElement(btnRatingCRItab));
   			_wait(10000);
   			_setValue(getElement(txtSRStrengthOfCorpGovSelection), data.getData("CRISRStrengthOfCorpGovSelection"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSRLossExpSelection), data.getData("CRISRLossExpSelection"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSROverallFinanLiqSelection), data.getData("CRISROverallFinanLiqSelection"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSRAffByRecessionSelection),  data.getData("CRISRAffByRecessionSelection"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSRQualityOfMngmntSelection), data.getData("CRISRQualityOfMngmntSelection"));
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
