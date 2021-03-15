package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.PolicyCoverageChangePage;
import com.everest.utility.CustomAbstractPage;

public class PolicyCoverageChangePageImpl extends CustomAbstractPage implements PolicyCoverageChangePage {

	@SuppressWarnings("static-access")
	@Override
	public void PolicyCoverageChange(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataAccount = PageDataManager.instance().getPageData("PolicyChange", tcID);
		PageData dataUmLogin = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		
		
		String strURL = "";
		_wait(5000);
		if(dataAccount.getData("Crime").equalsIgnoreCase("Yes"))
		{
		_click(getElement(chkCrime));
		_wait(2000);
		}
		if(dataAccount.getData("Crime").equalsIgnoreCase("No"))
		{
		_click(getElement(chkCrime));
		_click(getElement(btnOK));
		_wait(2000);
		}
		
		if(dataAccount.getData("DNO").equalsIgnoreCase("Yes"))
		{
		_click(getElement(chkDNO));
		_wait(2000);
		}
		
		if(dataAccount.getData("DNO").equalsIgnoreCase("No"))
		{
		_click(getElement(chkDNO));
		_click(getElement(btnOK));
		_wait(2000);
		}
		if(dataAccount.getData("EPL").equalsIgnoreCase("Yes"))
		{
		_click(getElement(chkEPL));
		_wait(2000);
		
		}
		if(dataAccount.getData("EPL").equalsIgnoreCase("No"))
		{
		_click(getElement(chkEPL));
		_click(getElement(btnOK));
		_wait(2000);
		}
		_click(getElement(btnNext));
		_wait(4000);
		_click(getElement(btnNext));
		_wait(4000);
		_click(getElement(btnNext));
		_wait(4000);
		_click(getElement(btnNext));
		_wait(4000);
				
		if(func._isVisible(getElement(btnClear)))
		{_click(getElement(btnClear));
		_wait(2000);
		}		
		
		_click(getElement(btnCovtab));
		_wait(8000);
		if (dataUmLogin.getData("Excess").equalsIgnoreCase("Yes"))
		{
			_wait(2000);
			_setValue(getElement(txtExcessAggregateLimit), dataAccount.getData("ExcessAggregateLimit"));
			func.setValue9();
			func._waitForPageToLoad(getWebDriver(), 50L);
			
			_wait(10000);
			_setValue(getElement(txtExcessUnderlyingAggregateLimit), dataAccount.getData("ExcessUnderlyingAggregateLimit"));
			func.setValue9();
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(10000);
		}
		else if (dataUmLogin.getData("SlimProducts").equalsIgnoreCase("Yes"))
		{
			 if (dataUmLogin.getData("CRD").equalsIgnoreCase("Yes"))
			 {
			_wait(2000);
			//_click(getElement(tabCredit));
			_wait(10000);
			_setValue(getElement(txtCRDPolicyLimit), dataAccount.getData("CRDPolicyLimit"));
			func.setValue9();
			 }
			 
			 if (dataUmLogin.getData("SLENO").equalsIgnoreCase("Yes"))
			 {
			_wait(2000);
			_click(getElement(tabBrokerDealerENO));
			_wait(10000);
			_setValue(getElement(txtBrokerDealerENOPolicyLimit), dataAccount.getData("BrokerDealerENOPolicyLimit"));
			func.setValue9();
			 }
			 
			 if (dataUmLogin.getData("CON").equalsIgnoreCase("Yes"))
			 {
			_wait(2000);
			//_click(getElement(tabCON));
			_wait(10000);
			_setValue(getElement(txtCONPolicyLimit), dataAccount.getData("CONPolicyLimit"));
			func.setValue9();
			 }
			 if (dataAccount.getData("POLNonHonouring").equalsIgnoreCase("Yes"))
			 {
			_wait(2000);
			_click(getElement(tabPRN));
			_wait(10000);
			_setValue(getElement(txtPRNLimit), dataAccount.getData("PRNLimit"));
			func.setValue9();
			_wait(5000);
			_setValue(getElement(txtPRNPartOf), dataAccount.getData("PRNPartOf"));
			func.setValue9();
			_wait(5000);
			_setValue(getElement(txtPRNIndemnityPercent), dataAccount.getData("PRNIndemnityPercent"));
			func.setValue9();
			 }
			 
			 if (dataAccount.getData("POLLenders").equalsIgnoreCase("Yes"))
			 {
			_wait(2000);
			_click(getElement(tabPRN));
			_wait(10000);
			_click(getElement(chkArbitrationAwardDefault));
			_wait(2000);
			_wait(5000);
			_setValue(getElement(txtPRLLimit), dataAccount.getData("PRLLimit"));
			func.setValue9();
			_wait(5000);
			_setValue(getElement(txtPRLPartOf), dataAccount.getData("PRLPartOf"));
			func.setValue9();
			_wait(5000);
			_setValue(getElement(txtPRLIndemnityPercent), dataAccount.getData("PRLIndemnityPercent"));
			func.setValue9();
			 }
			
		}
		else
		{	

		if(func._isVisible(getElement(tabCRI)))
		{	
				_click(getElement(tabCRI));
				_wait(2000);
				_setValue(getElement(txtLimitPerOccurrence), dataAccount.getData("LimitPerOccurrence"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				_setValue(getElement(txtDeductiblePerOccurence), dataAccount.getData("DeductiblePerOccurence"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				if( dataAccount.getData("Premises Coverage").equalsIgnoreCase("No"));
				{
					_click(getElement(chkPremisesCov));
					_wait(2000);
				}
				
				if( dataAccount.getData("Premises Coverage").equalsIgnoreCase("Yes"));
				{
					//_click(getElement(chkPremisesCov));
					_wait(2000);
				}
				_wait(2000);
				if (func._isVisible(getElement(txtLimitPremisesCov))==true){
				_setValue(getElement(txtLimitPremisesCov), dataAccount.getData("txtLimitPremisesCov"));
				_wait(2000);
				//_setValue(getElement(txtDeductiblePremisesCov), dataAccount.getData("txtDeductiblePremisesCov"));
				}
		}
		if( dataAccount.getData("Forgery Coverage").equalsIgnoreCase("Yes"));
		{
			_clickTab();
			_clickTab();
		//	_click(getElement(chkForgeryCov));
			_wait(2000);
		}
		_wait(2000);
		if (func._isVisible(getElement(txtLimitForgeryCov))==true){
		_setValue(getElement(txtLimitForgeryCov), dataAccount.getData("txtLimitForgeryCov"));
		_wait(2000);
		//_setValue(getElement(txtDeductibleForgeryCov), dataAccount.getData("txtDeductibleForgeryCov"));
		}


		if(func._isVisible(getElement(tabDno)))
		{
				_click(getElement(tabDno));
				_wait(2000);
				
				_click(getElement(txtAggLmtLiability));
				_wait(2000);
				
				
				_setValue(getElement(txtAggLmtLiability), dataAccount.getData("AggregateLimitLiability"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				
				
				_click(getElement(txtRetention));
				_wait(5000);
				
				_setValue(getElement(txtRetention), dataAccount.getData("Retention"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				
				_click(getElement(txtRetention));
				_wait(2000);
				
				_setValue(getElement(dtPriorDate), dataAccount.getData("PriorDate"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
		
				if( dataAccount.getData("Select Additional Coverage").equalsIgnoreCase("Yes"));
				{
					
					func._scrollToElement((getElement(chkAdditionalSideCov)));
					_wait(8000);
					_click(getElement(lblAdditionalSideCov));
					//_click(getElement(chkAdditionalSideCov));
					_wait(2000);
				}
				_wait(2000);
				if (func._isVisible(getElement(txtLimitAdditionalSideCov))==true){
					func._scrollToElement((getElement(txtLimitAdditionalSideCov)));
					_wait(2000);
					_click(getElement(txtLimitAdditionalSideCov));
				_setValue(getElement(txtLimitAdditionalSideCov), dataAccount.getData("txtLimitAdditionalSideCov"));
				_wait(2000);
				}
		}

		if(func._isVisible(getElement(tabEPL)))
		{
				
				_click(getElement(tabEPL));
				_wait(2000);
				
				_setValue(getElement(txtEplAggLmtLiability), dataAccount.getData("EPLAggregateLimitLiability"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				
				_click(getElement(txtEplRetention));
				_wait(2000);
				
				_setValue(getElement(txtEplRetention), dataAccount.getData("EPLRetention"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				
				_setValue(getElement(dtEplPriorDate), dataAccount.getData("EPLPriorDate"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				
				_setValue(getElement(txtWorkPlaceVioExp), dataAccount.getData("EPLWorkPlaceViolenceExp"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				
				_setValue(getElement(txtAddClaimLmt), dataAccount.getData("AddClaimLmt"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				
				if( dataAccount.getData("EPL Crisis Expenses").equalsIgnoreCase("Yes"));
				{
					//_click(getElement(chkEPLCrisisCov));
					_wait(2000);
				}
				_wait(2000);
				if (func._isVisible(getElement(txtSubLimitEPLCrisisCov))==true){
				_setValue(getElement(txtSubLimitEPLCrisisCov), dataAccount.getData("txtSubLimitEPLCrisisCov"));
				_wait(2000);
				}
				
		}
		if(func._isVisible(getElement(tabCYB)))
		{	
				_click(getElement(tabCYB));
				_wait(2000);
				_wait(2000);
				_setValue(getElement(txtCYBAggregateLimitofLiability), dataAccount.getData("CYBAggregateLimitofLiability"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				_setValue(getElement(txtCYBRetention), dataAccount.getData("CYBRetention"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				if( dataAccount.getData("BreachResponseCosts").equalsIgnoreCase("No"));
				{
					_click(getElement(chkBreachResponseCosts));
					_wait(2000);
				}
				
		}		
		if(func._isVisible(getElement(tabFID)))
		{	
				_click(getElement(tabFID));
				_wait(2000);
				_wait(2000);
				_setValue(getElement(txtFIDAggregateLimitofLiability), dataAccount.getData("FIDAggregateLimitofLiability"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				_setValue(getElement(txtFIDRetention), dataAccount.getData("FIDRetention"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				if( dataAccount.getData("VoluntaryComplianceProgramCosts").equalsIgnoreCase("No"));
				{
					_click(getElement(chkVoluntaryComplianceProgramCosts));
					_wait(2000);
				}
				
		}		
		if(func._isVisible(getElement(tabEMP)))
		{	
				_click(getElement(tabEMP));
				_wait(2000);
				_wait(2000);
				_setValue(getElement(txtEMPAggregateLimitofLiability), dataAccount.getData("EMPAggregateLimitofLiability"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				//	_click(getElement(txtEMPRetention));
//				WebDriverWait w = new WebDriverWait(getWebDriver(),250);
//				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Retention')]/../following-sibling::div//input")));
	        	
//				_setValue(getElement(txtEMPRetention), dataAccount.getData("EMPRetention"));
//				func._waitForPageToLoad(getWebDriver(), 50L);
//				_wait(2000);
				//func.setValue3(getElement(txtEMPRetention));
				//func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(4000);
					
		}
		if(func._isVisible(getElement(tabENO)))
		{	
				_click(getElement(tabENO));
				_wait(2000);
				_wait(2000);
				_setValue(getElement(txtENOAggregateLimitofLiability), dataAccount.getData("ENOAggregateLimitofLiability"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				_setValue(getElement(txtENORetention), dataAccount.getData("ENORetention"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
								
		}	
		if(func._isVisible(getElement(tabKNR)))
		{	
				_click(getElement(tabKNR));
				_wait(2000);
				_wait(2000);
				_setValue(getElement(txtKNRRansomLimitofLiability), dataAccount.getData("KNRRansomLimitofLiability"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				_setValue(getElement(txtKNRDeductible), dataAccount.getData("KNRDeductible"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				_setValue(getElement(txtKNRAccidentalDeathMaximumBenefit), dataAccount.getData("KNRAccidentalDeathMaximumBenefit"));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
								
		}	
		_wait(2000);
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(2000);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
	}

}
