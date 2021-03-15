package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmRatingEZExcessPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmRatingEZExcessPageImpl extends CustomAbstractPage implements UmRatingEZExcessPage {

	@Override
	public void UmRatingEZExcess(String tcID, SoftAssert softAssert) throws Exception {
	
		PageData dataUmLogin = PageDataManager.instance().getPageData("EZExcess", tcID);
		PageData dataUmSubDetails = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		_wait(5000);
		if(!dataUmLogin.getData("tcID_BC_PartB").equals(""))
		{
		 dataUmLogin = PageDataManager.instance().getPageData("EZExcess", dataUmLogin.getData("tcID_BC_PartB"));	
		}
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		_wait(1000);
		
		_click(getElement(lblEZExcessScreen));
		_wait(4000);
		_setValue(getElement(txtCommission), dataUmLogin.getData("Commission"));
		_wait(2000);
		_setValue(getElement(txtPrimaryLimit), dataUmLogin.getData("PrimaryLimit"));
		func.setValue9();
		_wait(2000);
		if (dataUmLogin.getData("PositioninTower").equalsIgnoreCase("Higher than 1st Excess"))
		{
			_wait(1000);
			_click(getElement(txtPositionInTower));	
			_wait(2000);
			_setValue(getElement(txtCommontextfield), dataUmLogin.getData("PositioninTower"));
			_wait(3000);
			String expoption = "/html/body/div[3]//*[contains(text(),\""+dataUmLogin.getData("PositioninTower")+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));		
			expectedOption.click();
			_wait(4000);
			_wait(2000);
			_setValue(getElement(txtPrecedingLimit), dataUmLogin.getData("PrecedingLimit"));
		}	
		
		if(!((dataUmSubDetails.getData("State").equalsIgnoreCase("California")||
				dataUmSubDetails.getData("State").equalsIgnoreCase("Florida")||
						dataUmSubDetails.getData("State").equalsIgnoreCase("Hawaii")||
								dataUmSubDetails.getData("State").equalsIgnoreCase("Missouri")||
										dataUmSubDetails.getData("State").equalsIgnoreCase("New Hampshire")||
												dataUmSubDetails.getData("State").equalsIgnoreCase("Rhode Island")||
														dataUmSubDetails.getData("State").equalsIgnoreCase("South Dakota")||
																dataUmSubDetails.getData("State").equalsIgnoreCase("Texas")))){
			_setValue(getElement(txtRateShiftFactor), dataUmLogin.getData("RateShiftFactor"));
			_wait(2000);
												}
		
		WebElement partof = (WebElement)getClonedElement(txtPrecedingLimitPartOf).getNative();
		partof.clear();
		
			_setValue(getElement(txtPrecedingLimitPartOf), dataUmLogin.getData("PrecedingLimitPartOf"));
			_wait(2000);
			_setValue(getElement(txtAttachmentPoint), dataUmLogin.getData("AttachmentPoint"));
			_wait(2000);
			_setValue(getElement(txtPrecedingLayerPremium), dataUmLogin.getData("PrecedingLayerPremium"));
			_wait(2000);
			WebElement partof1 = (WebElement)getClonedElement(txtEverestLimitPartOf).getNative();
			partof1.clear();
			_setValue(getElement(txtEverestLimitPartOf), dataUmLogin.getData("EverestLimitPartOf"));
			func.setValue3(getElement(txtEverestLimitPartOf));
		
			if (func._isVisible(getElement(btnTerrorism)) == true)
			{
				_wait(1000);
				_click(getElement(btnTerrorism));	
				_wait(1000);
				_setValue(getElement(txtCommontextfield), dataUmLogin.getData("Terrorism"));
				_wait(3000);
				String expoption = "/html/body/div[3]//*[contains(text(),\""+dataUmLogin.getData("Terrorism")+"\")]";
				WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));		
				expectedOption.click();
				_wait(4000);
			}
			
			if (dataUmLogin.getData("InadequateExcessivePricingforPrecedingLayerPremium").equalsIgnoreCase("Yes"))
			{
				_wait(1000);
				_click(getElement(btnInadequateExcessivePricing));	
				_wait(2000);
				_setValue(getElement(txtCommontextfield), dataUmLogin.getData("InadequateExcessivePricingforPrecedingLayerPremium"));
				_wait(3000);
				String expoption = "/html/body/div[3]//*[contains(text(),\""+dataUmLogin.getData("InadequateExcessivePricingforPrecedingLayerPremium")+"\")]";
				WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));		
				expectedOption.click();
				_wait(4000);
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));		
				_wait(15000);
				_click(getElement(btnType));	
				_wait(2000);
				_setValue(getElement(txtCommontextfield), dataUmLogin.getData("Type"));
				_wait(3000);
				String expoption1 = "/html/body/div[3]//*[(text()=\""+dataUmLogin.getData("Type")+"\")]";
				WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));		
				expectedOption1.click();
				_wait(4000);
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(5000);
				_click(getElement(btnUpdateCoverages));
				_wait(3000);
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(5000);
				_setValue(getElement(txtInadequateExcessivePricingSel), dataUmLogin.getData("InadequateExcessivePricingSel"));
				func.setValue9();
			}
			_wait(2000);
//			_click(getElement(btnGetRater));
//			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(5000);
			
			_wait(2000);
			_setValue(getElement(txtAggregateLimitofLiabilitySel), dataUmLogin.getData("AggregateLimitofLiabilitySel"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtUnderlyingAggregateLimitofLiabilitySel), dataUmLogin.getData("UnderlyingAggregateLimitofLiabilitySel"));
			func.setValue9();
			if (dataUmLogin.getData("EnterModifiers").equalsIgnoreCase("Yes"))
			{	
			_wait(3000);
			_setValue(getElement(txtGRMFinancials), dataUmLogin.getData("GRMFinancials"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtGRMClaimsHistory), dataUmLogin.getData("GRMClaimsHistory"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtGRMGeographicLocation), dataUmLogin.getData("GRMGeographicLocation"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtGRMIndustryClassification), dataUmLogin.getData("GRMIndustryClassification"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtGRMLossHistory), dataUmLogin.getData("GRMLossHistory"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtGRMOthersFactorsUnique), dataUmLogin.getData("GRMOthersFactorsUnique"));
			func.setValue9();
			
			if (func._isVisible(getElement(lblAdditionalRateModifierCYB)) == true)
			{
			_wait(3000);
			_setValue(getElement(txtARMCYBBusinessActivities), dataUmLogin.getData("ARMCYBBusinessActivities"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtARMCYBOrganizationandGovernance), dataUmLogin.getData("ARMCYBOrganizationandGovernance"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtARMCYBNetworkSecurity), dataUmLogin.getData("ARMCYBNetworkSecurity"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtARMCYBDataManagement), dataUmLogin.getData("ARMCYBDataManagement"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtARMCYBIncidentResponse), dataUmLogin.getData("ARMCYBIncidentResponse"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtARMCYBBusinessContinuityPlanning), dataUmLogin.getData("ARMCYBBusinessContinuityPlanning"));
			func.setValue9();
			_wait(2000);
			_setValue(getElement(txtARMCYBIncidentHistory), dataUmLogin.getData("ARMCYBIncidentHistory"));
			func.setValue9();
			}
			if (func._isVisible(getElement(lblAdditionalRateModifierDNO)) == true)
			{
				_wait(2000);
				_setValue(getElement(txtARMDNOAcquisitionDivestitureActivity), dataUmLogin.getData("ARMDNOAcquisitionDivestitureActivity"));
				func.setValue9();	
			}
			if (func._isVisible(getElement(lblAdditionalRateModifierEMP)) == true)
			{
				_wait(2000);
				_setValue(getElement(txtARMEMPLegalServiceMultiplier), dataUmLogin.getData("ARMEMPLegalServiceMultiplier"));
				func.setValue9();
				_wait(2000);
				_setValue(getElement(txtARMEMPLegalDeptRiskManagement), dataUmLogin.getData("ARMEMPLegalDeptRiskManagement"));
				func.setValue9();
				_wait(2000);
				_setValue(getElement(txtARMEMPUnusualRiskCharacteristics), dataUmLogin.getData("ARMEMPUnusualRiskCharacteristics"));
				func.setValue9();
			}
			if (func._isVisible(getElement(lblAdditionalRateModifierENO)) == true)
			{
				_wait(2000);
				_setValue(getElement(txtARMENOUseofContracts), dataUmLogin.getData("ARMENOUseofContracts"));
				func.setValue9();
				_wait(2000);
				_setValue(getElement(txtARMENORiskManagementPractices), dataUmLogin.getData("ARMENORiskManagementPractices"));
				func.setValue9();
				_wait(2000);
				_setValue(getElement(txtARMENOUseofSubcontractors), dataUmLogin.getData("ARMENOUseofSubcontractors"));
				func.setValue9();
				_wait(2000);
				_setValue(getElement(txtARMENOLongevityofOperations), dataUmLogin.getData("ARMENOLongevityofOperations"));
				func.setValue9();
			}
			if (func._isVisible(getElement(lblAdditionalRateModifierEPL)) == true)
			{
				_wait(2000);
				_setValue(getElement(txtARMEPLEEO1Ratios), dataUmLogin.getData("ARMEPLEEO1Ratios"));
				func.setValue9();
			}
			if (func._isVisible(getElement(lblAdditionalRateModifierFID)) == true)
			{
				_wait(2000);
				_setValue(getElement(txtARMFIDEmployerSecurities), dataUmLogin.getData("ARMFIDEmployerSecurities"));
				func.setValue9();
				_wait(2000);
				_setValue(getElement(txtARMFIDFundingStatusoftheCompany), dataUmLogin.getData("ARMFIDFundingStatusoftheCompany"));
				func.setValue9();
				_wait(2000);
				_setValue(getElement(txtARMFIDAssetsUnderManagement), dataUmLogin.getData("ARMFIDAssetsUnderManagement"));
				func.setValue9();
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
	public void UmRatingEZExcessMinMaxValidation(String tcID, SoftAssert softAssert) throws Exception {
		
		PageData dataUmLogin = PageDataManager.instance().getPageData("EZExcess", tcID);
		
		String PricingType=dataUmLogin.getData("Type");
		
		int AttachmentPoint=Integer.parseInt(getElement(txtUpdtAttachPoint).getAttribute("value").replace("$", "").replace(",", ""));
		
		String minVal=getElement(txtMinVal).getAttribute("value");
		String maxVal=getElement(txtMaxVal).getAttribute("value");		
		if(0<=AttachmentPoint && AttachmentPoint<=99999999 && PricingType.equalsIgnoreCase("Non-Claim Situation") ) {
			
			if(minVal.equalsIgnoreCase("-10%") && maxVal.equalsIgnoreCase("5%")) {
				
				CustomReporting.logReport("","","Verified Min and Max value is updated as expected - Min=" +minVal+ ", Max=" +maxVal,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			}else {
				
				CustomReporting.logReport("","","Verified Min and Max value is not updated as expected - Min=" +minVal+ ", Max=" +maxVal,StepStatus.FAILURE,new String[] { },System.currentTimeMillis());
			}
		}
		
          if(100000000<=AttachmentPoint && PricingType.equalsIgnoreCase("Non-Claim Situation") ) {
			
			if(minVal.equalsIgnoreCase("-10%") && maxVal.equalsIgnoreCase("15%")) {
				
				CustomReporting.logReport("","","Verified Min and Max value is updated as expected - Min=" +minVal+ ", Max=" +maxVal,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			}else {
				
				CustomReporting.logReport("","","Verified Min and Max value is not updated as expected - Min=" +minVal+ ", Max=" +maxVal,StepStatus.FAILURE,new String[] { },System.currentTimeMillis());
			}
		}
          
      	
          if(0<=AttachmentPoint && AttachmentPoint<=49999999 && PricingType.equalsIgnoreCase("Claim Situation") ) {
			
			if(minVal.equalsIgnoreCase("-15%") && maxVal.equalsIgnoreCase("10%")) {
				
				CustomReporting.logReport("","","Verified Min and Max value is updated as expected - Min=" +minVal+ ", Max=" +maxVal,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			}else {
				
				CustomReporting.logReport("","","Verified Min and Max value is not updated as expected - Min=" +minVal+ ", Max=" +maxVal,StepStatus.FAILURE,new String[] { },System.currentTimeMillis());
			}
		}
          
          if(50000000<=AttachmentPoint && PricingType.equalsIgnoreCase("Claim Situation") ) {
  			
  			if(minVal.equalsIgnoreCase("-15%") && maxVal.equalsIgnoreCase("15%")) {
  				
  				CustomReporting.logReport("","","Verified Min and Max value is updated as expected - Min=" +minVal+ ", Max=" +maxVal,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
  			}else {
  				
  				CustomReporting.logReport("","","Verified Min and Max value is not updated as expected - Min=" +minVal+ ", Max=" +maxVal,StepStatus.FAILURE,new String[] { },System.currentTimeMillis());
  			}
  		}
            
	}


}