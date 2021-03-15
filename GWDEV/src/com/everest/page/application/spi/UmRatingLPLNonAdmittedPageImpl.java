package com.everest.page.application.spi;

import java.text.DecimalFormat;

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

import com.everest.page.application.UmRatingLPLNonAdmittedPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmRatingLPLNonAdmittedPageImpl extends CustomAbstractPage implements UmRatingLPLNonAdmittedPage {

	@Override
	public void UmRatingLPLNonAdmitted(String tcID, SoftAssert softAssert) throws Exception 
	{
	
		PageData dataUmLogin = PageDataManager.instance().getPageData("LPLNonAdmitted", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		_wait(10000);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		 Actions ac = new Actions(getWebDriver());
		_click(getElement(btnSubmissionInfo));
		_wait(5000);
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		long startTime = System.currentTimeMillis();
		String xPath = getElement(txtWritingApproach).getKey().toString();
		String pm = "return document.evaluate(\"" + xPath + "\", document, null, 9, null).singleNodeValue.value";
		String UmWritingApproach = js.executeScript(pm).toString();
		
		//EPRO-74697 Start
		
				String xPath_state = getElement(txtRatingState).getKey().toString();
				String pm_state = "return document.evaluate(\"" + xPath_state + "\", document, null, 9, null).singleNodeValue.innerHTML";
				String UmRatingState = js.executeScript(pm_state).toString();
				if (UmRatingState.equalsIgnoreCase("California")) 
				{
					if(UmWritingApproach.equalsIgnoreCase("Admitted"))
					{
						CustomReporting.logReport("", "", " EPRO-74697 AMS CA is Made Admitted State for LPL as Expected " , StepStatus.SUCCESS, new String[] {},
								startTime);
					}
					else
					{
						CustomReporting.logReport("", "", "Writing Approach for this Policy Should be Admitted for CA State as Per EPRO-74697 where as Actual Writing Approach is : "+UmWritingApproach , StepStatus.FAILURE, new String[] {},
								startTime);
					}
				}
				
		//EPRO-74697 End
		
		WebElement ver_chkbox = (WebElement)getClonedElement(Verification_Chkbx).getNative();
				
				
		if (UmWritingApproach.equalsIgnoreCase("Admitted") && ver_chkbox.isSelected()==false ) 
		{
			
			PageImplInvoker classInvoker = new PageImplInvoker();
			classInvoker.UmRatingLPLAdmitted(tcID);
		}
		else
		{
			_wait(10000);	
			_click(getElement(btnLPLPage));
			_wait(5000);
			_setValue(getElement(txtFullTimeLawyers), dataUmLogin.getData("FullTimeLawyers"));
			_wait(2000);
			_setValue(getElement(txtPartTimeLawyers), dataUmLogin.getData("PartTimeLawyers"));
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
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_setValue(getElement(txtCreditDebit), dataUmLogin.getData("AOPCreditDebit"));
			_wait(2000);
			_setValue(getElement(txtAOPComments), dataUmLogin.getData("AOPComments"));
			_wait(3000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			if (UmRatingState.equalsIgnoreCase("New York")) 
			{
				func.setValue9();
				_wait(3000);
				 //_click(getElement(txtQoMDisengagementLetters));
				_setValue(getElement(txtQoMDisengagementLetters), dataUmLogin.getData("QoMDisengagementLetters"));
				
				_wait(3000);
				//_click(getElement(txtQoMDeclinationLetter));
				_setValue(getElement(txtQoMDeclinationLetter), dataUmLogin.getData("QoMDeclinationLetter"));
				
				_wait(3000);
				// _click(getElement(txtQoM2FormsofConflict));
				_setValue(getElement(txtQoM2FormsofConflict), dataUmLogin.getData("QoM2FormsofConflict"));
				
				_wait(3000);
				_setValue(getElement(Morethan2forms), dataUmLogin.getData("QoMMorethan2forms"));
				
				_wait(3000);
				//_click(getElement(txtQoMNoBusinessOrFinancialInvolvement));
				_setValue(getElement(txtQoMNoBusinessOrFinancialInvolvement), dataUmLogin.getData("QoMNoBusinessOrFinancialInvolvement"));
				
				_wait(3000);
				//_click(getElement(txtQoMSplitFeeArrangement));
				_setValue(getElement(txtQoMSplitFeeArrangement), dataUmLogin.getData("QoMSplitFeeArrangement"));
				
				_wait(2000);
				_setValue(getElement(NY_YOE), dataUmLogin.getData("YearsofExperience"));
				
				_wait(3000);
				_click(getElement(txtNYLoCThreeOrMoreCalendar));
				_setValue(getElement(txtNYLoCThreeOrMoreCalendar), dataUmLogin.getData("NYLoCThreeOrMoreCalendar"));
				
				_wait(3000);
				_click(getElement(txtNYLoCInHouseLoss));
				_setValue(getElement(txtNYLoCInHouseLoss), dataUmLogin.getData("NYLoCInHouseLoss"));
				
				_wait(2000);
				_setValue(getElement(NY_DOCCS), dataUmLogin.getData("Date"));
				
				_wait(2000);
				_click(getElement(txtNYUniqueFirmManaged));
				_setValue(getElement(txtNYUniqueFirmManaged), dataUmLogin.getData("NYUniqueFirmManaged"));
				
				_wait(2000);
				_setValue(getElement(txtIRMComments), dataUmLogin.getData("IRMComments"));
				
			}
			
			else if (UmRatingState.equalsIgnoreCase("California")) 
			{
				/*_wait(3000);
				_setValue(getElement(txtQoMDisengagementLetters), dataUmLogin.getData("QoMDisengagementLetters"));
				_wait(3000);
				_setValue(getElement(txtQoMDeclinationLetter), dataUmLogin.getData("QoMDeclinationLetter"));
				_wait(3000);
				_setValue(getElement(txtQoM2FormsofConflict), dataUmLogin.getData("QoM2FormsofConflict"));
				_wait(3000);
				_setValue(getElement(Morethan2forms), dataUmLogin.getData("QoMMorethan2forms"));
				_wait(3000);
				_setValue(getElement(txtQoMNoBusinessOrFinancialInvolvement), dataUmLogin.getData("QoMNoBusinessOrFinancialInvolvement"));
				_wait(3000);
				_setValue(getElement(txtQoMSplitFeeArrangement), dataUmLogin.getData("QoMSplitFeeArrangement"));*/
				_wait(2000);
				//_setValue(getElement(txtCommonYearsofExperience), dataUmLogin.getData("CommonYearsofExperience"));
				_click(getElement(txtCommonYearsofExperience));
				_wait(3000);
				String expoption = "/html/body/div[3]//*[contains(text(),\""+dataUmLogin.getData("CommonYearsofExperience")+"\")]";
				WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));		
				expectedOption.click();
				_wait(4000);
				_wait(2000);
				/*_setValue(getElement(txtYearsofExperience), dataUmLogin.getData("YearsofExperience"));
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
				_wait(2000);*/
				_setValue(getElement(txtIRMComments), dataUmLogin.getData("IRMComments"));
			
			}
			
			else
			{
			
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
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
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
				
				//ExpRatingMod
				if (!dataUmLogin.getData("ExpRatingMod").equalsIgnoreCase(""))
				{
					ac.moveToElement(getWebDriver().findElement(By.xpath("//div[contains(text(),'Incurred Expense')]"))).click();
	    			for(int i=0;i<7;i++)
	    			{
	    				ac.sendKeys(Keys.ARROW_LEFT).perform();
	    			}
	    			ac.sendKeys(Keys.PAGE_DOWN).perform();
					_setValue(getElement(ExpModifier), dataUmLogin.getData("ExpRatingMod"));
					_wait(2000);
				}
				
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
	public void verifyLossControl(String tcID, SoftAssert softAssert) throws Exception{
		
		String docketControlsystem=getClonedElement(txtLossControlRiskClass).addToken("tkn_num","1").getAttribute("value");
		
		String InHouseControlProced=getClonedElement(txtLossControlRiskClass).addToken("tkn_num","2").getAttribute("value");
		
		String docketControlsystemMinPer=getClonedElement(txtLossCtrlMinPer).addToken("tkn_num","1").getAttribute("value");
		String InHouseControlProcedMinPer=getClonedElement(txtLossCtrlMinPer).addToken("tkn_num","2").getAttribute("value");
		
		String docketControlsystemMaxPer=getClonedElement(txtLossCtrlMaxPer).addToken("tkn_num","1").getAttribute("value");
		String InHouseControlProcedMaxPer=getClonedElement(txtLossCtrlMaxPer).addToken("tkn_num","2").getAttribute("value");
		
		if(docketControlsystem.equalsIgnoreCase("Three or more calendar/docket docket control systems")) {
			
			CustomReporting.logReport("Verified :-"," 'Three or more calendar/docket docket control system' " ,"field is present under Loss control",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			if(docketControlsystemMinPer.equalsIgnoreCase("-5.0%")) {
				CustomReporting.logReport("Verified min % for :-"," 'Three or more calendar/docket docket control system' " ,"field is as expected -:"+docketControlsystemMinPer,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			}else {
				CustomReporting.logReport("Verified min % for :-"," 'Three or more calendar/docket docket control system' " ,"field is not as expected -:"+docketControlsystemMinPer,StepStatus.FAILURE,new String[] { },System.currentTimeMillis());
			}
			
            if(docketControlsystemMaxPer.equalsIgnoreCase("100.0%")) {
				
            	CustomReporting.logReport("Verified max % for :-"," 'Three or more calendar/docket docket control system' " ,"field is as expected -:"+docketControlsystemMaxPer,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			} 
            else {
            	CustomReporting.logReport("Verified max % for :-"," 'Three or more calendar/docket docket control system' " ,"field is not as expected -:"+docketControlsystemMaxPer,StepStatus.FAILURE,new String[] { },System.currentTimeMillis());
			}
		}else {
			
			CustomReporting.logReport("Verified max % for :-"," 'Three or more calendar/docket docket control system' " ,"field is not present -:"+docketControlsystem,StepStatus.FAILURE,new String[] { },System.currentTimeMillis());
		}
		
		
		if(InHouseControlProced.equalsIgnoreCase("In-house loss control procedures")) {
			
			CustomReporting.logReport("Verified :-"," 'In-house loss control procedures' " ,"field is present under Loss control",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			if(InHouseControlProcedMinPer.equalsIgnoreCase("-5.0%")) {
				CustomReporting.logReport("Verified min % for :-"," 'In-house loss control procedures' " ,"field is as expected -:"+InHouseControlProcedMinPer,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			}else {
				CustomReporting.logReport("Verified min % for :-"," 'In-house loss control procedures' " ,"field is not as expected -:"+InHouseControlProcedMinPer,StepStatus.FAILURE,new String[] { },System.currentTimeMillis());
			}
			
            if(InHouseControlProcedMaxPer.equalsIgnoreCase("100.0%")) {
				
            	CustomReporting.logReport("Verified max % for :-"," 'In-house loss control procedures' " ,"field is as expected -:"+InHouseControlProcedMaxPer,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			} 
            else {
            	CustomReporting.logReport("Verified max % for :-"," 'In-house loss control procedures' " ,"field is not as expected -:"+InHouseControlProcedMaxPer,StepStatus.FAILURE,new String[] { },System.currentTimeMillis());
			}
		}else {
			
			CustomReporting.logReport("Verified :-"," 'In-house loss control procedures' " ,"field is not present -:"+InHouseControlProced,StepStatus.FAILURE,new String[] { },System.currentTimeMillis());
		}
	}
	
	@Override
	public void verifyIRMChangesNonAdmitted(String tcID, SoftAssert softAs) throws Exception {
		try {
			
			_click(getElement(btnLPLPage));
			_wait(10000);

			PageData data = PageDataManager.instance().getPageData("LPLNonAdmitted", tcID);
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

		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public void CaptureIRMFactor(String tcID, SoftAssert softAs) throws Exception {
		try {
			
			PageData data_Exposures = PageDataManager.instance().getPageData("Exposures", tcID);
			
			_click(getElement(LinkLPL_PageRating));
			_wait(10000);

			String IRM_Value = func._getAttributeValue(getElement(IRMFactor), "value", softAs);
			
			if(data_Exposures.getData("WritingApproachInput").equalsIgnoreCase("Non-Admitted"))
			{
				func._writeToExcel("LPLNonAdmitted", "IRMFactor", IRM_Value, tcID);
			}
			else
			{
				func._writeToExcel("LPLAdmitted", "IRMFactor", IRM_Value, tcID);
			}
		}
		catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public void CalcComboFactor(String tcID, SoftAssert softAs) throws Exception {
		try {
			
			PageData data_LplNA = PageDataManager.instance().getPageData("LPLNonAdmitted", tcID);
			PageData data_LplA = PageDataManager.instance().getPageData("LPLAdmitted", tcID);
			PageData data_Exposures = PageDataManager.instance().getPageData("Exposures", tcID);
			String ComboFactor;
			DecimalFormat df = new DecimalFormat("0.0000");
			
			if(data_Exposures.getData("WritingApproachInput").equalsIgnoreCase("Non-Admitted"))
			{
				ComboFactor = df.format((Double.parseDouble(data_LplNA.getData("IRMFactor"))*Double.parseDouble(data_LplNA.getData("ExpRatingMod")))).toString();
				func._writeToExcel("LPLNonAdmitted", "ComboFactor", ComboFactor, tcID);
			}
			else
			{
				ComboFactor = df.format((Double.parseDouble(data_LplA.getData("IRMFactor"))*Double.parseDouble(data_LplA.getData("ExpRatingMod")))).toString();
				func._writeToExcel("LPLAdmitted", "ComboFactor", ComboFactor, tcID);
			}
				
				
			
		}
		catch (Exception ex) {
			throw ex;
		}
	}


}