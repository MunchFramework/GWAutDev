package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmRatingLPLAdmittedPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmRatingLPLAdmittedPageImpl extends CustomAbstractPage implements UmRatingLPLAdmittedPage {
	long startTime = System.currentTimeMillis();
	@Override
	public void UmRatingLPLAdmitted(String tcID, SoftAssert softAssert) throws Exception 
	{
		
		PageData dataUmLogin = PageDataManager.instance().getPageData("LPLAdmitted", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		_wait(10000);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		Actions ac = new Actions(getWebDriver());
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		long startTime = System.currentTimeMillis();
		String xPath = getElement(txtRatingState).getKey().toString();
		String pm = "return document.evaluate(\"" + xPath + "\", document, null, 9, null).singleNodeValue.innerHTML";
		String UmRatingState = js.executeScript(pm).toString();
		_wait(10000);	
		_click(getElement(btnLPLPage));
		_wait(5000);
		_setValue(getElement(txtPartTimeFactor), dataUmLogin.getData("PartTimeFactor"));
		_wait(2000);
		_setValue(getElement(txtAggregateLimitforPolicyPeriod), dataUmLogin.getData("AggregateLimitforPolicyPeriod"));
		_wait(2000);
		_setValue(getElement(txtAggregateLimitperClaim), dataUmLogin.getData("AggregateLimitperClaim"));
		_wait(2000);
		if(dataUmLogin.getData("IsThereAggregateDeductible").equalsIgnoreCase("Yes"))
		{
            ac.moveToElement(getWebDriver().findElement(By.xpath("//div[contains(text(),'Aggregate Limit per Claim')]"))).click();
			for(int i=0;i<11;i++)
			{
				ac.sendKeys(Keys.ARROW_RIGHT).perform();
			}
			_click(getElement(txtIsThereAggDeduct));
            _wait(5000);
			
            String expoption= "//um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("IsThereAggregateDeductible")+"\")]";
            WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
            expectedOption.click();
            _wait(2000);
           
			ac.moveToElement(getWebDriver().findElement(By.xpath("//div[contains(text(),'Is there an Aggregate Deductible')]"))).click();
			for(int i=0;i<11;i++)
			{
				ac.sendKeys(Keys.ARROW_LEFT).perform();
			}
            func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
            _setValue(getElement(txtAggregateDeductibleforPolicy), dataUmLogin.getData("AggregateDeductibleforPolicy"));
            _wait(2000);
         }
		_setValue(getElement(txtAggregateDeductibleperClaim), dataUmLogin.getData("AggregateDeductibleperClaim"));
		_wait(2000);
		_setValue(getElement(txtRetroactiveDate), dataUmLogin.getData("RetroactiveDate"));
		
		_wait(3000);
		_setValue(getElement(txtCreditDebit), dataUmLogin.getData("CreditDebit"));
		_wait(2000);
		_setValue(getElement(txtAOPComments), dataUmLogin.getData("AOPComments"));
		
		if (UmRatingState.equalsIgnoreCase("New York")) 
		{
			_wait(3000);
			_setValue(getElement(txtQoMDisengagementLetters), dataUmLogin.getData("QoMDisengagementLetters"));
			_wait(3000);
			_setValue(getElement(txtQoMDeclinationLetter), dataUmLogin.getData("QoMDeclinationLetter"));
			_wait(3000);
			_setValue(getElement(txtQoM2FormsofConflict), dataUmLogin.getData("QoM2FormsofConflict"));
			_wait(3000);
			_setValue(getElement(txtQoMMorethan2forms), dataUmLogin.getData("QoMMorethan2forms"));
			_wait(3000);
			_setValue(getElement(txtQoMNoBusinessOrFinancialInvolvement), dataUmLogin.getData("QoMNoBusinessOrFinancialInvolvement"));
			_wait(3000);
			_setValue(getElement(txtQoMSplitFeeArrangement), dataUmLogin.getData("QoMSplitFeeArrangement"));
			_wait(2000);
			_setValue(getElement(txtYearsofExperience), dataUmLogin.getData("YearsofExperience"));
			_wait(3000);
			_setValue(getElement(txtNYLoCThreeOrMoreCalendar), dataUmLogin.getData("NYLoCThreeOrMoreCalendar"));
			_wait(3000);
			_setValue(getElement(txtNYLoCInHouseLoss), dataUmLogin.getData("NYLoCInHouseLoss"));
			_wait(2000);
			_setValue(getElement(txtDate), dataUmLogin.getData("Date"));
			_wait(2000);
			_setValue(getElement(txtNYUniqueFirmManaged), dataUmLogin.getData("NYUniqueFirmManaged"));
			_wait(2000);
			_setValue(getElement(txtIRMComments), dataUmLogin.getData("IRMComments"));
		}
		else if (UmRatingState.equalsIgnoreCase("California")) 
		{
			_wait(3000);
			_setValue(getElement(txtQoMDisengagementLetters), dataUmLogin.getData("QoMDisengagementLetters"));
			_wait(3000);
			_setValue(getElement(txtQoMDeclinationLetter), dataUmLogin.getData("QoMDeclinationLetter"));
			_wait(3000);
			_setValue(getElement(txtQoM2FormsofConflict), dataUmLogin.getData("QoM2FormsofConflict"));
			_wait(3000);
			_setValue(getElement(txtQoMMorethan2forms), dataUmLogin.getData("QoMMorethan2forms"));
			_wait(3000);
			_setValue(getElement(txtQoMNoBusinessOrFinancialInvolvement), dataUmLogin.getData("QoMNoBusinessOrFinancialInvolvement"));
			_wait(3000);
			_setValue(getElement(txtQoMSplitFeeArrangement), dataUmLogin.getData("QoMSplitFeeArrangement"));
			_wait(2000);
			//_setValue(getElement(txtCommonYearsofExperience), dataUmLogin.getData("CommonYearsofExperience"));
			_click(getElement(txtCommonYearsofExperience));
			_wait(3000);
			String expoption = "/html/body/div[3]//*[contains(text(),\""+dataUmLogin.getData("CommonYearsofExperience")+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));		
			expectedOption.click();
			_wait(4000);
			_wait(2000);
			_setValue(getElement(txtYearsofExperience), dataUmLogin.getData("YearsofExperience"));
			func.setValue9();
			_wait(2000);
			_wait(3000);
			_setValue(getElement(txtCALoCParticipationInLoss), dataUmLogin.getData("CALoCParticipationInLoss"));
			_wait(3000);
			_setValue(getElement(txtCALoCAbsenceOfGeneral), dataUmLogin.getData("CALoCAbsenceOfGeneral"));
			_wait(3000);
			_setValue(getElement(txtCADateMultipleDocket), dataUmLogin.getData("CADateMultipleDocket"));
			_wait(3000);
			_setValue(getElement(txtCAUniqueSpecializedFields), dataUmLogin.getData("CAUniqueSpecializedFields"));
			_wait(3000);
			_setValue(getElement(txtCAUniqueDifferentFields), dataUmLogin.getData("CAUniqueDifferentFields"));
			_wait(2000);
			_setValue(getElement(txtIRMComments), dataUmLogin.getData("IRMComments"));
		
		}
		else if (UmRatingState.equalsIgnoreCase("Virginia")) 
		{
			_wait(2000);
			_setValue(getElement(txtQualityofManagement), dataUmLogin.getData("QualityofManagement"));
			_wait(2000);
			//_setValue(getElement(txtCommonYearsofExperience), dataUmLogin.getData("CommonYearsofExperience"));
			_click(getElement(txtCommonYearsofExperience));
			_wait(3000);
			String expoption = "/html/body/div[3]//*[contains(text(),\""+dataUmLogin.getData("CommonYearsofExperience")+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));		
			expectedOption.click();
			_wait(4000);
			_wait(2000);
			_setValue(getElement(txtLossControl), dataUmLogin.getData("LossControl"));
			_wait(2000);
			_setValue(getElement(txtDate), dataUmLogin.getData("Date"));
			_wait(2000);
			_setValue(getElement(txtUnique), dataUmLogin.getData("Unique"));
			_wait(2000);
			_setValue(getElement(txtIRMComments), dataUmLogin.getData("IRMComments"));
		}
		else if (UmRatingState.equalsIgnoreCase("Kansas")) 
		{
			_wait(3000);
			_setValue(getElement(txtQualityofManagement), dataUmLogin.getData("QualityofManagement"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtLossControl), dataUmLogin.getData("LossControl"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtDate), dataUmLogin.getData("Date"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtUnique), dataUmLogin.getData("Unique"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtIRMComments), dataUmLogin.getData("IRMComments"));
		}
		else 
		{
					
			_wait(3000);
			_setValue(getElement(txtQualityofManagement), dataUmLogin.getData("QualityofManagement"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtYearsofExperience), dataUmLogin.getData("YearsofExperience"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtLossControl), dataUmLogin.getData("LossControl"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtDate), dataUmLogin.getData("Date"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtUnique), dataUmLogin.getData("Unique"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtIRMComments), dataUmLogin.getData("IRMComments"));
		}
		if (dataUmLogin.getData("ExperienceModifiers").equalsIgnoreCase("Yes"))
		{
			_wait(2000);
			_setValue(getElement(txtReportDate), dataUmLogin.getData("ReportDate"));
			_wait(2000);
			_setValue(getElement(txtIncurredLoss), dataUmLogin.getData("IncurredLoss"));
			_wait(2000);
			_setValue(getElement(txtIncurredExpense), dataUmLogin.getData("IncurredExpense"));
			_wait(2000);
			_wait(5000);
			_click(getElement(btnUpdateCoverages));
			_wait(5000);
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			
		}
		if (dataUmLogin.getData("EnterModifiers").equalsIgnoreCase("Yes"))
		{
		_wait(2000);
		_setValue(getElement(txtCrisisEventExpensesSublimit), dataUmLogin.getData("CrisisEventExpensesSublimit"));
		_wait(2000);
		_setValue(getElement(txtDisciplinaryProceedingsExpensesEachDisciplinarySublimit), dataUmLogin.getData("DisciplinaryProceedingsExpensesEachDisciplinarySublimit"));
		_wait(2000);
		_setValue(getElement(txtDisciplinaryProceedingsExpensesAllDisciplinarySublimit), dataUmLogin.getData("DisciplinaryProceedingsExpensesAllDisciplinarySublimit"));
		_wait(2000);
		_setValue(getElement(txtSecurityIncidentResponseExpensesEachSecuritySublimit), dataUmLogin.getData("SecurityIncidentResponseExpensesEachSecuritySublimit"));
		_wait(2000);
		_setValue(getElement(txtSecurityIncidentResponseExpensesAllSecuritySublimit), dataUmLogin.getData("SecurityIncidentResponseExpensesAllSecuritySublimit"));
		_wait(2000);
		_setValue(getElement(txtSubpoenaComplianceExpensesSublimit), dataUmLogin.getData("SubpoenaComplianceExpensesSublimit"));
		_wait(2000);
		_setValue(getElement(txtLitigationParticipationExpensesPerdaySublimit), dataUmLogin.getData("LitigationParticipationExpensesPerdaySublimit"));
		_wait(2000);
		_setValue(getElement(txtLitigationParticipationExpensesPerClaimSublimit), dataUmLogin.getData("LitigationParticipationExpensesPerClaimSublimit"));
		_wait(2000);
		_setValue(getElement(txtLitigationParticipationExpensesAllSublimit), dataUmLogin.getData("LitigationParticipationExpensesAllSublimit"));
		
		if (dataUmLogin.getData("SeparateClaimExpensesCoverageEndorsement").equalsIgnoreCase("Yes"))
		{
			_wait(3000);	
			_click(getElement(chkSeparateClaimExpensesCoverage));
		}
		else if (dataUmLogin.getData("ClaimExpensesinAdditiontoLimitofLiabilityEndorsement").equalsIgnoreCase("Yes"))
		{
			_wait(3000);	
			_click(getElement(chkClaimExpensesinAdditiontoLimitofLiabilityEndorsement));
		}
		_wait(5000);
		_click(getElement(btnUpdateCoverages));
		_wait(5000);
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		if (dataUmLogin.getData("SeparateClaimExpensesCoverageEndorsement").equalsIgnoreCase("Yes"))
		{
			_wait(3000);	
			_setValue(getElement(txtSeparateClaimExpensesCoverage), dataUmLogin.getData("SeparateClaimExpensesCoverage"));
			func.setValue9();
			_wait(2000);
		}
		
		}
		_click(getElement(btnUpdateCoverages));
		_wait(3000);
		if(func._isVisible(getElement(btnUpdateCoverages)))
		{
			_click(getElement(btnUpdateCoverages));
			_wait(3000);
		}
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		_wait(3000);
	}
	
	@Override
	public void verifyIRMChanges(String tcID, SoftAssert softAs) throws Exception {
		try {

			_click(getElement(btnLPLPage));
			_wait(10000);
			PageData data = PageDataManager.instance().getPageData("LPLAdmitted", tcID);
			String qoa_maxvalue = data.getData("IRM_QOMMaxValue");
			String qoa_minvalue = data.getData("IRM_QOMMinValue");
			String yoe_maxvalue = data.getData("IRM_YOEMaxValue");
			String yoe_minvalue = data.getData("IRM_YOEMinValue");
			String doc_maxvalue = data.getData("IRM_DOCMaxValue");
			String doc_minvalue = data.getData("IRM_DOCMinValue");
			String lc_maxvalue = data.getData("IRM_LCMaxValue");
			String lc_minvalue = data.getData("IRM_LCMinValue");
			String uc_maxvalue = data.getData("IRM_UCMaxValue");
			String uc_minvalue = data.getData("IRM_UCMinValue");

			_wait(5000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			func._checkAttributeValue(getElement(txtQOM_MINValue), "value", qoa_minvalue, softAs);
			func._checkAttributeValue(getElement(txtQOM_MAXValue), "value", qoa_maxvalue, softAs);
			func._checkAttributeValue(getElement(txtYOE_MINValue), "value", yoe_minvalue, softAs);
			func._checkAttributeValue(getElement(txtYOE_MAXValue), "value", yoe_maxvalue, softAs);
			func._checkAttributeValue(getElement(txtDOC_MINValue), "value", doc_minvalue, softAs);
			func._checkAttributeValue(getElement(txtDOC_MAXValue), "value", doc_maxvalue, softAs);
			func._checkAttributeValue(getElement(txtLC_MINValue), "value", lc_minvalue, softAs);
			func._checkAttributeValue(getElement(txtLC_MAXValue), "value", lc_maxvalue, softAs);
			func._checkAttributeValue(getElement(txtUC_MINValue), "value", uc_minvalue, softAs);
			func._checkAttributeValue(getElement(txtUC_MAXValue), "value", uc_maxvalue, softAs);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		} catch (Exception ex) {
			throw ex;
		}
	}
	@Override
	public void addMultipleExperienceModifiers(String tcID, SoftAssert softAs, String stateCode) throws Exception{
		
		try {
			PageData data = PageDataManager.instance().getPageData("LPLAdmitted", tcID);
			int noOfClaims = Integer.parseInt(data.getData("No.OfClaims"));
			for(int i=1;i<=noOfClaims;i++) {
				if(i>1) {
				_click(getElement(btn_AddExpModifier));
				_wait(5000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				if(i==1) {
					_wait(2000);
					_setValue(getElement(txtReportDate), data.getData("ReportDate"));
					_wait(2000);
					_setValue(getElement(txtIncurredLoss), data.getData("IncurredLoss"));
					_wait(2000);
					_setValue(getElement(txtIncurredExpense), data.getData("IncurredExpense"));
					_wait(2000);
					_wait(5000);
					
				}
				if(i>1) {
					getWebDriver().findElement(By.xpath("//ui-form-viewer/div/div[2]/div[3]/ui-row[3]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row["+i+"]/div/ui-calendar/div/div/div/input")).sendKeys(data.getData("ReportDate"+i));
					_wait(2000);
					getWebDriver().findElement(By.xpath("//ui-form-viewer/div/div[2]/div[3]/ui-row[3]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row["+i+"]/div/ui-text-input[5]/div/div/input")).sendKeys(data.getData("IncurredLoss"+i));
					_wait(2000);
					getWebDriver().findElement(By.xpath("//ui-form-viewer/div/div[2]/div[3]/ui-row[3]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row["+i+"]/div/ui-text-input[6]/div/div/input")).sendKeys(data.getData("IncurredExpense"+i));
					_wait(2000);
				}
			}
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if(stateCode.equalsIgnoreCase("Montana")||stateCode.equalsIgnoreCase("North Carolina")) {
			String value = getWebDriver().findElement(By.xpath("//input[contains(@class,'-lplRatingExpModifierExperienceRatingModifier')]")).getAttribute("disabled");
			if(value.equalsIgnoreCase("disabled")) {
				CustomReporting.logReport("", "", "Experience Rate Modifier field is not editable which is as expected", StepStatus.SUCCESS,
						new String[] {}, startTime);
			}else {
				CustomReporting.logReport("", "", "Experience Rate Modifier field is  editable which is not as expected", StepStatus.FAILURE,
						new String[] {}, startTime);
			}
			}else {
				CustomReporting.logReport("", "", "Experience Rate Modifier field is  editable which is as expected", StepStatus.SUCCESS,
						new String[] {}, startTime);
				getWebDriver().findElement(By.xpath("//input[contains(@class,'-lplRatingExpModifierExperienceRatingModifier')]")).sendKeys(data.getData("ExperienceModificationFactor"));
				_wait(2000);
			}
		}catch(Exception ex) {
			throw ex;
		}
	}

}