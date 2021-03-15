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

import com.everest.page.application.UmRatingCYBPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmRatingCYBPageImpl extends CustomAbstractPage implements UmRatingCYBPage {

	@Override
	public void UmRatingCYB(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmLogin = PageDataManager.instance().getPageData("CYB", tcID);
		PageData dataUmLogin1 = PageDataManager.instance().getPageData("Exposures", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		/*String strScreenShots = dataUmLogin.getData("PrintScreens");
		if (strScreenShots.equalsIgnoreCase("Yes")) {
			func._takeScreenShot(getWebDriver(), "START", "", "");
		}*/
		_wait(1000); 
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		WebDriverWait w1 = new WebDriverWait(getWebDriver(),10);
		 long startTime = System.currentTimeMillis();
		_click(getElement(btnCYBPage));
		_wait(4000);
		_setValue(getElement(txtCYBAggregateLimit), dataUmLogin.getData("CYBAggregateLimit"));
		_clickTab();
		_wait(4000);

		_setValue(getElement(txtCYBRetention), dataUmLogin.getData("CYBRetention"));
		_clickTab();
		_wait(4000);
		_setValue(getElement(txtCYBRetroDate), dataUmLogin.getData("CYBRetroDate"));
		_clickTab();
		_wait(4000);

		
		if (dataUmLogin.getData("EnterModifiers").equalsIgnoreCase("Yes"))
		{
			String SelectOption[] = {"txtDFNatureandAmountofThirdPartyPersonalInformationSelectOption","txtDFLocationJurisdictionFactorSelectOption","txtDFFormalIncidentResponsePlanSelectOption","txtDFFormalBusinessContinuityDisasterSelectOption","txtDFSharingofConfidentialInformationSelectOption","txtDFAssetInventorySelectOption","txtDFSecurityConfigurationsSelectOption","txtDFVulnerabilityAssessmentandRemediationSelectOption","txtDFEmployeeTrainingSelectOption","txtDFAccessControlSelectOption","txtDFUseofEncryptionSelectOption","txtDFRelianceonCriticalVendorsorServiceProvidersSelectOption","txtDFOnlineSalesSelectOption","txtDFContractbasedRiskManagementControlsSelectOption","txtDFMergerandAcquisitionActivitySelectOption"};	
			String SelectOptionValues[] = {"CYBDFNatureandAmountofThirdPartyPersonalInformationSelectOption","CYBDFLocationJurisdictionFactorSelectOption","CYBDFFormalIncidentResponsePlanSelectOption","CYBDFFormalBusinessContinuityDisasterSelectOption","CYBDFSharingofConfidentialInformationSelectOption","CYBDFAssetInventorySelectOption","CYBDFSecurityConfigurationsSelectOption","CYBDFVulnerabilityAssessmentandRemediationSelectOption","CYBDFEmployeeTrainingSelectOption","CYBDFAccessControlSelectOption","CYBDFUseofEncryptionSelectOption","CYBDFRelianceonCriticalVendorsorServiceProvidersSelectOption","CYBDFOnlineSalesSelectOption","CYBDFContractbasedRiskManagementControlsSelectOption","CYBDFMergerandAcquisitionActivitySelectOption"};	
			String Selection[] = {"txtDFNatureandAmountofThirdPartyPersonalInformationSelection","txtDFLocationJurisdictionFactorSelection","txtDFFormalIncidentResponsePlanSelection","txtDFFormalBusinessContinuityDisasterSelection","txtDFSharingofConfidentialInformationSelection","txtDFAssetInventorySelection","txtDFSecurityConfigurationsSelection","txtDFVulnerabilityAssessmentandRemediationSelection","txtDFEmployeeTrainingSelection","txtDFAccessControlSelection","txtDFUseofEncryptionSelection","txtDFRelianceonCriticalVendorsorServiceProvidersSelection","txtDFOnlineSalesSelection","txtDFContractbasedRiskManagementControlsSelection","txtDFMergerandAcquisitionActivitySelection"};	
			String SelectionValues[] = {"CYBDFNatureandAmountofThirdPartyPersonalInformationSelection","CYBDFLocationJurisdictionFactorSelection","CYBDFFormalIncidentResponsePlanSelection","CYBDFFormalBusinessContinuityDisasterSelection","CYBDFSharingofConfidentialInformationSelection","CYBDFAssetInventorySelection","CYBDFSecurityConfigurationsSelection","CYBDFVulnerabilityAssessmentandRemediationSelection","CYBDFEmployeeTrainingSelection","CYBDFAccessControlSelection","CYBDFUseofEncryptionSelection","CYBDFRelianceonCriticalVendorsorServiceProvidersSelection","CYBDFOnlineSalesSelection","CYBDFContractbasedRiskManagementControlsSelection","CYBDFMergerandAcquisitionActivitySelection"};	
		 int l = SelectOption.length;
		 for (int i=0;i<l;i++)
		 {
			 
			 if (i==0)
			 {
			 _wait(1000);
			 _click(getElement(SelectOption[i]));
			 }
			 else if (i==6)
			 {
				 func._scrollToElement(getElement(SelectOption[i+6]));  
				 _wait(1000);
				 func.setValue2(getElement(SelectOption[i]));
			 }
			 else if (i==7)
			 {
				 func._scrollToElement(getElement(SelectOption[i+7]));  
				 _wait(1000);
				 func.setValue2(getElement(SelectOption[i]));
			 }
			 else if (i==8)
			 {
				 func._scrollToElement(getElement(SelectOption[i+6]));  
				 _wait(1000);
				 func.setValue2(getElement(SelectOption[i]));
			 }
			 else if (i==9)
			 {
				 func._scrollToElement(getElement(SelectOption[i+5]));  
				 _wait(1000);
				 func.setValue2(getElement(SelectOption[i]));
			 }
			  
			 else
			 {
				 
				 func.setValue2(getElement(SelectOption[i]));
			 }

			 w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/um-dropdown-search/input")));
			String xpath = "/html/body/div[3]/um-dropdown-search/input";
			_wait(2000);
							
				WebElement ele2 = (getWebDriver().findElement(By.xpath(xpath)));
				String Select = (dataUmLogin.getData(SelectOptionValues[i]));
				ele2.sendKeys(Select);
				_wait(4000);
			
				if (i==7)
				 {
					 func.setValue6();
				 }
				else
				{
				String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData(SelectOptionValues[i])+"\")]";
				WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
				expectedOption.click();
				//func.setValue6();
				_wait(2000);
		
				CustomReporting.logReport("", "", "Set the value of the " + SelectOptionValues[i]+ " element on the page UmRatingCYB " + Select , StepStatus.SUCCESS, new String[] {},
						startTime);
				}	 
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
			 String value = dataUmLogin.getData(SelectionValues[i]);
			 String Selectxpath  = e2.getKey();
			WebElement ele = (getWebDriver().findElement(By.xpath(Selectxpath)));
			 Element ele3  = getElement(Selection[i]);
			 _wait(1000);
				func._scrollToElement(ele3);
		
			 ele.clear();
			 _wait(1000);
			 ele.sendKeys(value);
			 CustomReporting.logReport("", "", "Set the value of the " + SelectionValues[i]+ " element on the page UmRatingCYB " + value , StepStatus.SUCCESS, new String[] {},
						startTime);
			 _wait(1000);
			 _click(getElement(Selection[i]));
		
			 func.setValue3(ele3); 
			 func.setValue3(ele3);
		 }
		 }
		 _setValue(getElement(txtSRStrengthofCorporateGovernance), dataUmLogin.getData("CYBSRStrengthofCorporateGovernance"));
			_clickTab();
			_setValue(getElement(txtSRLossExperience), dataUmLogin.getData("CYBSRLossExperience"));
			_clickTab();
			_setValue(getElement(txtSROverallFinancialLiquidity), dataUmLogin.getData("CYBSROverallFinancialLiquidity"));
			_clickTab();
			_setValue(getElement(txtSRAffectedbyRecession), dataUmLogin.getData("CYBSRAffectedbyRecession"));
			_clickTab();
			_setValue(getElement(txtSRQualityofManagement), dataUmLogin.getData("CYBSRQualityofManagement"));
			_clickTab();
				
			//OC
			_wait(2000);
			_setValue(getElement(txtBreachResponseCostsSublimit), dataUmLogin.getData("CYBOCBreachResponseCostsSublimit"));
			_clickTab();
			_setValue(getElement(txtBreachResponseCostsRetention), dataUmLogin.getData("CYBOCBreachResponseCostsRetention"));
			_clickTab();
			func.setValue6();
			if (func._isVisible(getElement(txtCommontextSelOption)) == false)
			{
				_wait(3000);
				 _click(getElement(txtBreachResponseCostsSelectOption));
					_wait(3000);
			}
			_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCBreachResponseCostsSelectOption"));
			_wait(3000);
			//func.setValue6();
			func.selectDropdown(dataUmLogin.getData("CYBOCBreachResponseCostsSelectOption"));
			_clickTab();
			if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {		
				}
				else
				{ 	
			_setValue(getElement(txtBreachResponseCostsSelection), dataUmLogin.getData("CYBOCBreachResponseCostsSelection"));
				}
			_clickTab();
			_clickTab();
			_clickTab();
			
			_setValue(getElement(txtCyberExtortionCostsSublimit), dataUmLogin.getData("CYBOCCyberExtortionCostsSublimit"));
			_clickTab();
			_setValue(getElement(txtCyberExtortionCostsRetention), dataUmLogin.getData("CYBOCCyberExtortionCostsRetention"));
			//_clickTab();
			func.setValue3(getElement(txtCyberExtortionCostsRetention));
			//func.setValue6();
			func.setValue2(getElement(txtCyberExtortionCostsSelectOption));
			_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCCyberExtortionCostsSelectOption"));
			_wait(3000);
			//func.setValue6();
			func.selectDropdown(dataUmLogin.getData("CYBOCCyberExtortionCostsSelectOption"));
			_clickTab();
			if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {		
			}
			else
			{ 	
			_setValue(getElement(txtCyberExtortionCostsSelection), dataUmLogin.getData("CYBOCCyberExtortionCostsSelection"));
			}
			_clickTab();
			_clickTab();
			_clickTab();
			
			_setValue(getElement(txtDataLossCostsSublimit), dataUmLogin.getData("CYBOCDataLossCostsSublimit"));
			_clickTab();
			_setValue(getElement(txtDataLossCostsRetention), dataUmLogin.getData("CYBOCDataLossCostsRetention"));
			//_clickTab();
			func.setValue3(getElement(txtDataLossCostsRetention));
			//func.setValue6();
			func.setValue2(getElement(txtDataLossCostsSelectOption));
			_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCDataLossCostsSelectOption"));
			_wait(3000);
			func.selectDropdown(dataUmLogin.getData("CYBOCDataLossCostsSelectOption"));
			//func.setValue6();
			_clickTab();
			if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {		
			}
			else
			{ 
			_setValue(getElement(txtDataLossCostsSelection), dataUmLogin.getData("CYBOCDataLossCostsSelection"));
			}
			_clickTab();
			_clickTab();
			_clickTab();
			
			_setValue(getElement(txtBusinessInterruptionLossSublimit), dataUmLogin.getData("CYBOCBusinessInterruptionLossSublimit"));
			_clickTab();
			_setValue(getElement(txtBusinessInterruptionLossRetention), dataUmLogin.getData("CYBOCBusinessInterruptionLossRetention"));
			_clickTab();
			_setValue(getElement(txtBusinessInterruptionLossWaitingPeriod), dataUmLogin.getData("CYBOCBusinessInterruptionLossWaitingPeriod"));
			//_clickTab();
			func.setValue3(getElement(txtBusinessInterruptionLossWaitingPeriod));
			//func.setValue6();
			func.setValue2(getElement(txtBusinessInterruptionLossSelectOption));
			try {
				_setValue(getElement(txtCommontextSelOption),
						dataUmLogin.getData("CYBOCBusinessInterruptionLossSelectOption"));
			} catch (Exception e) {
				_clickTab();
				func.setValue2(getElement(txtBusinessInterruptionLossSelectOption));
				_setValue(getElement(txtCommontextSelOption),
						dataUmLogin.getData("CYBOCBusinessInterruptionLossSelectOption"));
				
			}
			_wait(3000);
			//func.setValue6();
			func.selectDropdown(dataUmLogin.getData("CYBOCBusinessInterruptionLossSelectOption"));
			_clickTab();
			if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {		
			}
			else
			{ 
			_setValue(getElement(txtBusinessInterruptionLossSelection), dataUmLogin.getData("CYBOCBusinessInterruptionLossSelection"));
			}
			_clickTab();
			_clickTab();
			_clickTab();
			
			
			_setValue(getElement(txtContingentBusinessInterruptionLossSublimit), dataUmLogin.getData("CYBOCContingentBusinessInterruptionLossSublimit"));
			_clickTab();
			_setValue(getElement(txtContingentBusinessInterruptionLossRetention), dataUmLogin.getData("CYBOCContingentBusinessInterruptionLossRetention"));
			_clickTab();
			_setValue(getElement(txtContingentBusinessInterruptionLossWaitingPeriod), dataUmLogin.getData("CYBOCContingentBusinessInterruptionLossWaitingPeriod"));
			//_clickTab();
			func.setValue3(getElement(txtContingentBusinessInterruptionLossWaitingPeriod));
			//func.setValue6();
			func.setValue2(getElement(txtContingentBusinessInterruptionLossSelectOption));
			_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCContingentBusinessInterruptionLossSelectOption"));
			_wait(3000);
			func.selectDropdown(dataUmLogin.getData("CYBOCContingentBusinessInterruptionLossSelectOption"));
			//func.setValue6();
			_clickTab();
			if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {		
			}
			else
			{ 
			_setValue(getElement(txtContingentBusinessInterruptionLossSelection), dataUmLogin.getData("CYBOCContingentBusinessInterruptionLossSelection"));
			}
			_clickTab();
			_clickTab();
			_clickTab();
			
			
			
			if (dataUmLogin1.getData("CYBER").equalsIgnoreCase("Yes")||dataUmLogin1.getData("NFP").equalsIgnoreCase("Yes")||dataUmLogin1.getData("PrivateCo").equalsIgnoreCase("Yes")) {
				_clickTab();	
			}

			_setValue(getElement(txtRegulatoryPenaltiesSublimit), dataUmLogin.getData("CYBOCRegulatoryPenaltiesSublimit"));
			_clickTab();
			_setValue(getElement(txtRegulatoryPenaltiesRetention), dataUmLogin.getData("CYBOCRegulatoryPenaltiesRetention"));
			//_clickTab();
			func.setValue3(getElement(txtRegulatoryPenaltiesRetention));
			//func._scrollToElement(getElement(txtRegulatoryPenaltiesSelection));
			//func.setValue6();
			if (tcID.equalsIgnoreCase("DS_R2_SIT_E2E_SC19")){
				_wait(5000);
				func._scrollToElement(getElement(txtPCIAssessmentsSelectOption));
				_wait(5000);
				
		}
			func.setValue2(getElement(txtRegulatoryPenaltiesSelectOption));
			_wait(1000);
			_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCRegulatoryPenaltiesSelectOption"));
			_wait(3000);
			//func.setValue6();
			func.selectDropdown(dataUmLogin.getData("CYBOCRegulatoryPenaltiesSelectOption"));
			_clickTab();
			if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {		
			}
			else
			{ 
			_setValue(getElement(txtRegulatoryPenaltiesSelection), dataUmLogin.getData("CYBOCRegulatoryPenaltiesSelection"));
			}
			_clickTab();
			_clickTab();
			_clickTab();
			
			_setValue(getElement(txtPCIAssessmentsSublimit), dataUmLogin.getData("CYBOCPCIAssessmentsSublimit"));
			_clickTab();
			_setValue(getElement(txtPCIAssessmentsRetention), dataUmLogin.getData("CYBOCPCIAssessmentsRetention"));
			//_clickTab();
			func.setValue3(getElement(txtPCIAssessmentsRetention));
			//func._scrollToElement(getElement(txtPCIAssessmentsSelection));
			//func.setValue6();
			func.setValue2(getElement(txtPCIAssessmentsSelectOption));
			_wait(7000);
			_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCPCIAssessmentsSelectOption"));
			_wait(7000);
			func.selectDropdown(dataUmLogin.getData("CYBOCPCIAssessmentsSelectOption"));
			_clickTab();
			if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {		
			}
			else
			{ 
			_setValue(getElement(txtPCIAssessmentsSelection), dataUmLogin.getData("CYBOCPCIAssessmentsSelection"));
			}
			_clickTab();
			_clickTab();
			_clickTab();
			
			
			_setValue(getElement(txtMediaLiabilitySublimit), dataUmLogin.getData("CYBOCMediaLiabilitySublimit"));
			_clickTab();
			_setValue(getElement(txtMediaLiabilityRetention), dataUmLogin.getData("CYBOCMediaLiabilityRetention"));
			//_clickTab();
			func.setValue3(getElement(txtMediaLiabilityRetention));
			func._scrollToElement(getElement(txtMediaLiabilitySelection));
			//func.setValue6();
			func.setValue2(getElement(txtMediaLiabilitySelectOption));
			_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCMediaLiabilitySelectOption"));
			_wait(3000);
			func.selectDropdown(dataUmLogin.getData("CYBOCMediaLiabilitySelectOption"));
			//func.setValue6();
			_clickTab();
			if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {		
			}
			else
			{ 
			
			_setValue(getElement(txtMediaLiabilitySelection), dataUmLogin.getData("CYBOCMediaLiabilitySelection"));
			}
			_clickTab();
			_clickTab();
			_clickTab();
			
			/*if (dataUmLogin.getData("OCTechnologyErrorsandOmissionsLiability").equalsIgnoreCase("No"))
			{
			_click(getElement(chkOCTechnologyErrorsandOmissionsLiability));
			_wait(2000);

			}
			else
			{

			_wait(3000);
			_setValue(getElement(txtTechnologyErrorsandOmissionsLiabilitySublimit), dataUmLogin.getData("CYBOCTechnologyErrorsandOmissionsLiabilitySublimit"));
			_clickTab();
			_setValue(getElement(txtTechnologyErrorsandOmissionsLiabilityRetention), dataUmLogin.getData("CYBOCTechnologyErrorsandOmissionsLiabilityRetention"));
			_clickTab();
			}*/
			WebElement TEOL = (WebElement)getClonedElement(chkOCTechnologyErrorsandOmissionsLiability).getNative();
			if (dataUmLogin.getData("OCTechnologyErrorsandOmissionsLiability").equalsIgnoreCase("Yes"))
			{
				_click(getElement(chkOCTechnologyErrorsandOmissionsLiability));
				_wait(2000);
				
				if(!TEOL.isSelected())
				{
					_click(getElement(chkOCTechnologyErrorsandOmissionsLiability));
					_wait(2000);
					
				}
				_click(getElement(btnUpdateCoverages));
				_wait(2000);
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(3000);
				_setValue(getElement(txtTechnologyErrorsandOmissionsLiabilitySublimit), dataUmLogin.getData("CYBOCTechnologyErrorsandOmissionsLiabilitySublimit"));
				_clickTab();
				_setValue(getElement(txtTechnologyErrorsandOmissionsLiabilityRetention), dataUmLogin.getData("CYBOCTechnologyErrorsandOmissionsLiabilityRetention"));
				_clickTab();

			}
			else
			{
				if(TEOL.isSelected())
				{
					_click(getElement(chkOCTechnologyErrorsandOmissionsLiability));
					_wait(2000);
					_click(getElement(btnUpdateCoverages));
					_wait(2000);
					w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
					_wait(3000);
					
				}
			}
			
			//OC
	
	
			if (dataUmLogin.getData("OCPCIRecertificationCosts").equalsIgnoreCase("Yes"))
			{
				func._scrollToElement(getElement(txtPCIAssessmentsSublimit));
				_wait(1000);
			_click(getElement(chkOCPCIRecertificationCosts));
			_wait(2000);

			}
//			_click(getElement(btnNext));
			_wait(3000);
//IF loop

				
			if (dataUmLogin1.getData("CYBER").equalsIgnoreCase("Yes")) {
					
			
			if (dataUmLogin.getData("OCReputationRepair").equalsIgnoreCase("Yes"))
			{
			_click(getElement(chkOCReputationRepair));
			_wait(2000);

			}
			
			if (dataUmLogin.getData("OCSystemFailure").equalsIgnoreCase("Yes"))
			{
			_click(getElement(chkOCSystemFailure));
			_wait(2000);

			}
			if (dataUmLogin.getData("OCWrongfulCollection").equalsIgnoreCase("Yes"))
			{
			_click(getElement(chkOCWrongfulCollection));
			_wait(2000);

			}
			if (dataUmLogin.getData("OCSocialEngineering").equalsIgnoreCase("Yes"))
			{
			_click(getElement(chkOCSocialEngineering));
			_wait(2000);

			}
			
				
//			_click(getElement(btnPrev));
			_wait(3000);
			_wait(5000);
			_click(getElement(btnUpdateCoverages));
			_wait(10000);
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

			if (dataUmLogin.getData("OCPCIRecertificationCosts").equalsIgnoreCase("Yes"))
			{	
//				func._scrollToElement(getElement(btnPrev));
				_wait(5000);
				func._scrollToElement(getElement(txtOCPCIRecertificationCostsSublimit));
				_wait(5000);
				_setValue(getElement(txtOCPCIRecertificationCostsSublimit), dataUmLogin.getData("CYBOCPCIRecertificationCostsSublimit"));
				_clickTab();
				_setValue(getElement(txtOCPCIRecertificationCostsRetention), dataUmLogin.getData("CYBOCPCIRecertificationCostsRetention"));
				//_clickTab();
				func.setValue3(getElement(txtOCPCIRecertificationCostsRetention));
				//func.setValue6();
				func.setValue2(getElement(txtPCIRecertificationCostsSelectOption));
				_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCPCIRecertificationCostsSelectOption"));
				_wait(5000);
				//func.setValue6();
				func.selectDropdown(dataUmLogin.getData("CYBOCPCIRecertificationCostsSelectOption"));
				_clickTab();
				if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
					
				}
				else
				{
				_setValue(getElement(txtOCPCIRecertificationCostsSelection), dataUmLogin.getData("CYBOCPCIRecertificationCostsSelection"));
				}
				_clickTab();
				_clickTab();
				_clickTab();
			}
//			_click(getElement(btnNext));
			_wait(3000);
			
//			func._scrollToElement(getElement(txtOCCYBSeparateDefenseCostCoverage));
			_wait(2000);
			if (dataUmLogin.getData("OCCYBSeparateDefenseCostCoverage").equalsIgnoreCase("Yes"))
			{
				_setValue(getElement(txtOCCYBSeparateDefenseCostCoverage), dataUmLogin.getData("OCCYBSeparateDefenseCostCoverage"));
				_clickTab();
			_wait(2000);

			}
			_wait(5000);
			func._scrollToElement(getElement(chkOCReputationRepair));
			_wait(2000);
			if (dataUmLogin.getData("OCReputationRepair").equalsIgnoreCase("Yes"))
			{
				_setValue(getElement(txtOCReputationRepairSublimit), dataUmLogin.getData("CYBOCReputationRepairSublimit"));
				_clickTab();
				_setValue(getElement(txtOCReputationRepairRetention), dataUmLogin.getData("CYBOCReputationRepairRetention"));
				//_clickTab();
				func.setValue3(getElement(txtOCReputationRepairRetention));
				//func.setValue6();
				func.setValue2(getElement(txtOCReputationRepairSelectOption));
				_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCReputationRepairSelectOption"));
				_wait(1000);
				func.selectDropdown(dataUmLogin.getData("CYBOCReputationRepairSelectOption"));
				//func.setValue6();
				_clickTab();
				if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
					
				}
				else
				{
				_setValue(getElement(txtOCReputationRepairSelection), dataUmLogin.getData("CYBOCReputationRepairSelection"));
				}
				_clickTab();
				_clickTab();
				_clickTab();

			}
			
			if (dataUmLogin.getData("OCSystemFailure").equalsIgnoreCase("Yes"))
			{
				_setValue(getElement(txtOCSystemFailureSublimit), dataUmLogin.getData("CYBOCSystemFailureSublimit"));
				_clickTab();
				_setValue(getElement(txtOCSystemFailureRetention), dataUmLogin.getData("CYBOCSystemFailureRetention"));
				_clickTab();
				_setValue(getElement(txtOCSystemFailureWaitingPeriod), dataUmLogin.getData("CYBOCSystemFailureWaitingPeriod"));
				//_clickTab();
				func.setValue3(getElement(txtOCSystemFailureWaitingPeriod));
				//func.setValue6();
				func.setValue2(getElement(txtOCSystemFailureSelectOption));
				_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCSystemFailureSelectOption"));
				_wait(1000);
				//func.setValue6();
				func.selectDropdown(dataUmLogin.getData("CYBOCSystemFailureSelectOption"));
				_clickTab();
				if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
					
				}
				else
				{
				_setValue(getElement(txtOCSystemFailureSelection), dataUmLogin.getData("CYBOCSystemFailureSelection"));
				}
				_clickTab();
				_clickTab();
				_clickTab();
			}
			if (dataUmLogin.getData("OCWrongfulCollection").equalsIgnoreCase("Yes"))
			{
				_setValue(getElement(txtOCWrongfulCollectionSublimit), dataUmLogin.getData("CYBOCWrongfulCollectionSublimit"));
				_clickTab();
				_setValue(getElement(txtOCWrongfulCollectionRetention), dataUmLogin.getData("CYBOCWrongfulCollectionRetention"));
				//_clickTab();
				func.setValue3(getElement(txtOCWrongfulCollectionRetention));
				//func.setValue6();
				func.setValue2(getElement(txtOCWrongfulCollectionSelectOption));
				
				_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCWrongfulCollectionSelectOption"));
				_wait(1000);
				//func.setValue6();
				func.selectDropdown(dataUmLogin.getData("CYBOCWrongfulCollectionSelectOption"));
				
				_clickTab();
				if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
					
				}
				else
				{
				_setValue(getElement(txtOCWrongfulCollectionSelection), dataUmLogin.getData("CYBOCWrongfulCollectionSelection"));
				}
				_clickTab();
				_clickTab();
				_clickTab();


			}
			if (dataUmLogin.getData("OCSocialEngineering").equalsIgnoreCase("Yes"))
			{
			
				_setValue(getElement(txtOCSocialEngineeringSublimit), dataUmLogin.getData("CYBOCSocialEngineeringSublimit"));
				_clickTab();
				_setValue(getElement(txtOCSocialEngineeringRetention), dataUmLogin.getData("CYBOCSocialEngineeringRetention"));
				//_clickTab();
				func.setValue3(getElement(txtOCSocialEngineeringRetention));
				//func.setValue6();
				func.setValue2(getElement(txtOCSocialEngineeringSelectOption));
				
				_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCSocialEngineeringSelectOption"));
				_wait(1000);
				//func.setValue6();
				func.selectDropdown(dataUmLogin.getData("CYBOCSocialEngineeringSelectOption"));
				_clickTab();
				if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
					
				}
				else
				{
				_setValue(getElement(txtOCSocialEngineeringSelection), dataUmLogin.getData("CYBOCSocialEngineeringSelection"));
				}
				_clickTab();
				_clickTab();
				_clickTab();

			}
			}
			else
			{
				_wait(3000);
				func._scrollToElement(getElement(chkOCCYBSeparateDefenseCostCoverage));
				_wait(2000);
				if (dataUmLogin.getData("OCCYBSeparateDefenseCostCoverage").equalsIgnoreCase("Yes"))
				{
				_click(getElement(chkOCCYBSeparateDefenseCostCoverage));
				_wait(2000);

				}
				
				if (dataUmLogin.getData("OCReputationRepair").equalsIgnoreCase("Yes"))
				{
				_click(getElement(chkEXPOCReputationRepair));
				_wait(2000);

				}
				
				if (dataUmLogin.getData("OCSystemFailure").equalsIgnoreCase("Yes"))
				{
				_click(getElement(chkEXPOCSystemFailure));
				_wait(2000);

				}
				if (dataUmLogin.getData("OCWrongfulCollection").equalsIgnoreCase("Yes"))
				{
				_click(getElement(chkEXPOCWrongfulCollection));
				_wait(2000);

				}
				if (dataUmLogin.getData("OCSocialEngineering").equalsIgnoreCase("Yes"))
				{
				_click(getElement(chkEXPOCSocialEngineering));
				_wait(2000);

				}
			
//
		
//				_click(getElement(btnPrev));
				_wait(3000);
				_wait(5000);
				_click(getElement(btnUpdateCoverages));
				_wait(10000);
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		
				if (dataUmLogin.getData("OCPCIRecertificationCosts").equalsIgnoreCase("Yes"))
				{
//					func._scrollToElement(getElement(btnPrev));
					_wait(5000);
					func._scrollToElement(getElement(txtOCPCIRecertificationCostsSublimit));
					_wait(5000);
	
					_setValue(getElement(txtOCPCIRecertificationCostsSublimit), dataUmLogin.getData("CYBOCPCIRecertificationCostsSublimit"));
					_clickTab();
					_setValue(getElement(txtOCPCIRecertificationCostsRetention), dataUmLogin.getData("CYBOCPCIRecertificationCostsRetention"));
					//_clickTab();
					func.setValue3(getElement(txtOCPCIRecertificationCostsRetention));
					//func.setValue6();
//					if (tcID.equalsIgnoreCase("DS_R2_SIT_E2E_SC06")){
//						_wait(5000);
//						func._scrollToElement(getElement(txtEXPOCSocialEngineeringSelectOption));
//						_wait(5000);
//						
//				}
//					if (tcID.equalsIgnoreCase("DS_R2_SIT_E2E_SC19")){
//					_wait(5000);
//					func._scrollToElement(getElement(txtDataLossCostsSelectOption));
//					_wait(5000);
//			}
					func.setValue2(getElement(txtPCIRecertificationCostsSelectOption));
					_wait(5000);
					_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCPCIRecertificationCostsSelectOption"));
					_wait(5000);
					//func.setValue6();
					func.selectDropdown(dataUmLogin.getData("CYBOCPCIRecertificationCostsSelectOption"));
					
					_clickTab();
					if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
						
					}
					else
					{
					_setValue(getElement(txtOCPCIRecertificationCostsSelection), dataUmLogin.getData("CYBOCPCIRecertificationCostsSelection"));
					}
					_clickTab();
					_clickTab();
					_clickTab();
				}
				//
				
//				_click(getElement(btnNext));
				_wait(15000);

				func._scrollToElement(getElement(chkEXPOCReputationRepair));
				_wait(5000);
				if (dataUmLogin.getData("OCReputationRepair").equalsIgnoreCase("Yes"))
				{
					_click(getElement(txtEXPOCReputationRepairSublimit));
					//func._scrollToElement(getElement(txtEXPOCReputationRepairSublimit));
					_wait(10000);
					_setValue(getElement(txtEXPOCReputationRepairSublimit), dataUmLogin.getData("CYBOCReputationRepairSublimit"));
					_clickTab();
					_setValue(getElement(txtEXPOCReputationRepairRetention), dataUmLogin.getData("CYBOCReputationRepairRetention"));
					//_clickTab();
					func.setValue3(getElement(txtEXPOCReputationRepairRetention));
					//func.setValue6();
					func.setValue2(getElement(txtEXPOCReputationRepairSelectOption));
					_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCReputationRepairSelectOption"));
					_wait(1000);
					//func.setValue6();
					func.selectDropdown(dataUmLogin.getData("CYBOCReputationRepairSelectOption"));
					_clickTab();
					if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
						
					}
					else
					{
					_setValue(getElement(txtEXPOCReputationRepairSelection), dataUmLogin.getData("CYBOCReputationRepairSelection"));
					}
					_clickTab();
					_clickTab();
					_clickTab();

				}
				
				if (dataUmLogin.getData("OCSystemFailure").equalsIgnoreCase("Yes"))
				{
					_setValue(getElement(txtEXPOCSystemFailureSublimit), dataUmLogin.getData("CYBOCSystemFailureSublimit"));
					_clickTab();
					_setValue(getElement(txtEXPOCSystemFailureRetention), dataUmLogin.getData("CYBOCSystemFailureRetention"));
					_clickTab();
					_setValue(getElement(txtEXPOCSystemFailureWaitingPeriod), dataUmLogin.getData("CYBOCSystemFailureWaitingPeriod"));
					//_clickTab();
					func.setValue3(getElement(txtEXPOCSystemFailureWaitingPeriod));
					//func.setValue6();
					func.setValue2(getElement(txtEXPOCSystemFailureSelectOption));

					_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCSystemFailureSelectOption"));
					_wait(1000);
					//func.setValue6();
					func.selectDropdown(dataUmLogin.getData("CYBOCSystemFailureSelectOption"));
					_clickTab();
					if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
						
					}
					else
					{
					_setValue(getElement(txtEXPOCSystemFailureSelection), dataUmLogin.getData("CYBOCSystemFailureSelection"));
					}
					_clickTab();
					_clickTab();
					_clickTab();
				}
				if (dataUmLogin.getData("OCWrongfulCollection").equalsIgnoreCase("Yes"))
				{
					_setValue(getElement(txtEXPOCWrongfulCollectionSublimit), dataUmLogin.getData("CYBOCWrongfulCollectionSublimit"));
					_clickTab();
					_setValue(getElement(txtEXPOCWrongfulCollectionRetention), dataUmLogin.getData("CYBOCWrongfulCollectionRetention"));
					//_clickTab();
					func.setValue3(getElement(txtEXPOCWrongfulCollectionRetention));
					//func.setValue6();
					func.setValue2(getElement(txtEXPOCWrongfulCollectionSelectOption));
					_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCWrongfulCollectionSelectOption"));
					_wait(1000);
					//func.setValue6();
					func.selectDropdown(dataUmLogin.getData("CYBOCWrongfulCollectionSelectOption"));
					_clickTab();
					if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
						
					}
					else
					{
					_setValue(getElement(txtEXPOCWrongfulCollectionSelection), dataUmLogin.getData("CYBOCWrongfulCollectionSelection"));
					}
					_clickTab();
					_clickTab();
					_clickTab();


				}
				if (dataUmLogin.getData("OCSocialEngineering").equalsIgnoreCase("Yes"))
				{
				
					_setValue(getElement(txtEXPOCSocialEngineeringSublimit), dataUmLogin.getData("CYBOCSocialEngineeringSublimit"));
					_clickTab();
					_setValue(getElement(txtEXPOCSocialEngineeringRetention), dataUmLogin.getData("CYBOCSocialEngineeringRetention"));
					//_clickTab();
					func.setValue3(getElement(txtEXPOCSocialEngineeringRetention));
					//func.setValue6();
					func.setValue2(getElement(txtEXPOCSocialEngineeringSelectOption));
					_setValue(getElement(txtCommontextSelOption), dataUmLogin.getData("CYBOCSocialEngineeringSelectOption"));
					_wait(1000);
					//func.setValue6();
					func.selectDropdown(dataUmLogin.getData("CYBOCSocialEngineeringSelectOption"));
					_clickTab();
					if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes")) {	
						
					}	
					else
					{	
					_setValue(getElement(txtEXPOCSocialEngineeringSelection), dataUmLogin.getData("CYBOCSocialEngineeringSelection"));
					}
					_clickTab();
					_clickTab();
					_clickTab();
					
				}
		//END	
			}
//			_click(getElement(btnPrev));
			_wait(5000);
			
			_wait(2000);
			func._scrollToElement(getElement(btnCMEndorsementFactorSelectOption));
			_wait(2000);
			_click(getElement(btnCMEndorsementFactorSelectOption));
			_wait(2000);
			_setValue(getElement(txtCMEndorsementFactorSelectOption), dataUmLogin.getData("CMEndorsementFactorSelectOption"));
			func.setValue6();
			_clickTab();
			if (dataUmLogin.getData("FlatState").equalsIgnoreCase("Yes"))
			{	
				
			}
			else
			{
			_setValue(getElement(txtCMEndorsementFactorSelection), dataUmLogin.getData("CMEndorsementFactorSelection"));
			}
			_clickTab();
			_clickTab();
		//End
		}
	 }

    public void UmValMinMaxClauseTerm(String tcID, SoftAssert softAssert) throws Exception{
		
    	_wait(5000);
    	_click(getElement(btnCYBPage));
    	
    	_wait(3000);
    	
    	_click(getElement(btnCYBPage));
    	
    	_wait(10000);
    	
    	PageData dataUmLogin = PageDataManager.instance().getPageData("CYB", tcID);
    	
    	
    	int sizeOfModifier=getWebDriver().findElements(By.xpath("(//input[@class='formFieldComponent-scheduleRatingMinCyber ui-number-without-commas-formatter']/../../../..//input)")).size();
    	
		for(int i=0;i<(sizeOfModifier/5);i++) {
			
			
			String expMinVal=dataUmLogin.getData("MinModFactorVal");
			
			String expMaxVal=dataUmLogin.getData("MaxModfactorValue");
			String umModFacName=getClonedElement(txtCYRatingAtrr).addToken("tkn_num",Integer.toString(5*i+1)).getAttribute("value");
			String umMinVal=getClonedElement(txtCYRatingAtrr).addToken("tkn_num",Integer.toString(5*i+2)).getAttribute("value");
			String umMaxVal=getClonedElement(txtCYRatingAtrr).addToken("tkn_num",Integer.toString(5*i+3)).getAttribute("value");		
					
			
			if(expMinVal.equalsIgnoreCase(umMinVal)) {
				
				CustomReporting.logReport("", "",
						"The Min factor for the modifier  :" + umModFacName + " is :"+umMinVal+" is as expected ",
						StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				
			}
			else {
				
				CustomReporting.logReport("", "",
						"The Min factor for the modifier  :" + umModFacName + " is :"+umMinVal+" is not as expected ",
						StepStatus.FAILURE, new String[] {}, System.currentTimeMillis());
				
			}
            if(expMaxVal.equalsIgnoreCase(umMaxVal)) {
				
            	CustomReporting.logReport("", "",
						"The Max factor for the modifier  :" + umModFacName + " is :"+umMaxVal+" is as expected ",
						StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				
			}
            else {
            	
            	CustomReporting.logReport("", "",
						"The Max factor for the modifier  :" + umModFacName + " is :"+umMaxVal+" is not as expected ",
						StepStatus.FAILURE, new String[] {}, System.currentTimeMillis());
            }
			
			
			
		}
	}
    
    @Override
	public void Verify_SRM_CYB(String tcID, SoftAssert softAs) throws Exception {
		try {
			
			_click(getElement(btnCYBPage));
			_wait(10000);

			PageData data = PageDataManager.instance().getPageData("CYB", tcID);
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
			func._checkAttributeValue(getElement(txtSCG_MINValue), "value", SRM_SCG_MIN, softAs);
			func._checkAttributeValue(getElement(txtSCG_MAXValue), "value", SRM_SCG_MAX, softAs);
			func._checkAttributeValue(getElement(txtLE_MINValue), "value", SRM_LE_MIN, softAs);
			func._checkAttributeValue(getElement(txtLE_MAXValue), "value", SRM_LE_MAX, softAs);
			func._checkAttributeValue(getElement(txtOFL_MINValue), "value", SRM_OFL_MIN, softAs);
			func._checkAttributeValue(getElement(txtOFL_MAXValue), "value", SRM_OFL_MAX, softAs);
			func._checkAttributeValue(getElement(txtABR_MINValue), "value", SRM_ABR_MIN, softAs);
			func._checkAttributeValue(getElement(txtABR_MAXValue), "value", SRM_ABR_MAX, softAs);
			func._checkAttributeValue(getElement(txtQOM_MINValue), "value", SRM_QOM_MIN, softAs);
			func._checkAttributeValue(getElement(txtQOM_MAXValue), "value", SRM_QOM_MAX, softAs);
			func._checkAttributeValue(getElement(txtSTATE_MINValue), "value", SRM_STATE_MIN, softAs);
			func._checkAttributeValue(getElement(txtSTATE_MAXValue), "value", SRM_STATE_MAX, softAs);

		} catch (Exception ex) {
			throw ex;
		}
	}
    
    @Override
	public void Verify_SRM_CYB_Error_Msg(String tcID, SoftAssert softAs) throws Exception {
		try {
			
			_click(getElement(btnCYBPage));
			_wait(10000);
			List<String> web_elements_list = new ArrayList<String>();
			List<String> SRM_MIN_MAX_VALUES_LIST = new ArrayList<String>();
			List<String> variable_names_list = new ArrayList<String>();

			PageData data = PageDataManager.instance().getPageData("CYB", tcID);
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
   	public void Update_SRM_CYB(String tcID, SoftAssert softAs) throws Exception {
   		try 
   		{
   			
   			PageData data = PageDataManager.instance().getPageData("CYB", tcID);
   			WebDriverWait w = new WebDriverWait(getWebDriver(),250);
			
   			_click(getElement(btnCYBPage));
   			_wait(10000);
   			_setValue(getElement(txtSRStrengthofCorporateGovernance), data.getData("CYBSRStrengthofCorporateGovernance"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSRLossExperience), data.getData("CYBSRLossExperience"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSROverallFinancialLiquidity), data.getData("CYBSROverallFinancialLiquidity"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSRAffectedbyRecession),  data.getData("CYBSRAffectedbyRecession"));
			_clickTab();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", "", "");
			_wait(2000);
			_setValue(getElement(txtSRQualityofManagement), data.getData("CYBSRQualityofManagement"));
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
//	