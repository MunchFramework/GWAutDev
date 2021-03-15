package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmRatingSlimCommonPage;
import com.everest.utility.CustomAbstractPage;

public class UmRatingSlimCommonPageImpl extends CustomAbstractPage implements UmRatingSlimCommonPage {

	@Override
	public void UmRatingSlimCommon(String tcID, SoftAssert softAssert) throws Exception {
	
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmRatingSlimCommon", tcID);
		PageData dataUmLogin1 = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		
		if(!dataUmLogin.getData("tcID_BC_PartB").equals(""))
		{
			dataUmLogin = PageDataManager.instance().getPageData("UmRatingSlimCommon", dataUmLogin.getData("tcID_BC_PartB"));	
		}
		if(!dataUmLogin1.getData("tcID_BC_PartB").equals(""))
		{
			dataUmLogin1 = PageDataManager.instance().getPageData("UMSubmissionDetails", dataUmLogin1.getData("tcID_BC_PartB"));	
		}
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		/*String strScreenShots = dataUmLogin.getData("PrintScreens");
		if (strScreenShots.equalsIgnoreCase("Yes")) {
			func._takeScreenShot(getWebDriver(), "START", "", "");
		}*/
		
		_wait(10000);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		
		_click(getElement(btnRatingSlimCommon));
		_wait(10000);
		int icount=0;
		do
		{
			
			if(func._isVisible(getElement(txtCommission)))
			{
				break;
				
			}
			_click(getElement(btnRatingSlimCommon));
			//func._waitFor(getElement(txtCommission), 50L, WAIT_FOR.VISIBLE);
			_wait(5000);
			if(!func._isVisible(getElement(txtCommission)))
			{
				WebElement weRatingSlimComm=(WebElement)getElement(btnRatingSlimCommon).getNative();
				Actions bilder=new Actions(getWebDriver());
				bilder.moveToElement(weRatingSlimComm).build().perform();
				
				
			}
			
			
			icount=icount+1;
		}while(icount<10);
		_setValue(getElement(txtCommission), dataUmLogin.getData("Commission"));
		_wait(2000);
		_setValue(getElement(txtCedingCommission), dataUmLogin.getData("CedingCommission"));
		_wait(4000);
		
		
		//RatingInformation
		if (dataUmLogin1.getData("CON").equalsIgnoreCase("Yes")) {			
			_wait(2000);
			_setValue(getElement(txtCONAggregarateLimit), dataUmLogin.getData("CONAggregarateLimit"));
			_wait(2000);
			_setValue(getElement(txtCONRetetntion), dataUmLogin.getData("CONRetetntion"));
			_wait(4000);
		}
		if (dataUmLogin1.getData("CRD").equalsIgnoreCase("Yes")) {		
			_wait(2000);
			_setValue(getElement(txtCRDPolicyLimit), dataUmLogin.getData("CRDPolicyLimit"));
			_wait(2000);
			_setValue(getElement(txtCRDInsuredExposure), dataUmLogin.getData("CRDInsuredExposure"));
			_wait(2000);
			_setValue(getElement(txtCRDPartOf), dataUmLogin.getData("CRDPartOf"));
			_wait(2000);
			_setValue(getElement(txtCRDCoveredPercentage), dataUmLogin.getData("CRDCoveredPercentage"));
			_wait(2000);
			_setValue(getElement(txtCRDIndemnityPercentage), dataUmLogin.getData("CRDIndemnityPercentage"));
			_wait(2000);
			_setValue(getElement(txtCRDWaitingPeriod), dataUmLogin.getData("CRDWaitingPeriod"));
			
			/*if (dataUmLogin.getData("CRDTrade").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_click(getElement(txtCRDTradeYes));
			}
			else
			{
				_wait(2000);
				_click(getElement(txtCRDTradeNo));
			}*/
			
			if (dataUmLogin.getData("CRDNuclearExclusion").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_click(getElement(txtCRDNuclearExclusionYes));
			}
			else
			{
				_wait(2000);
				_click(getElement(txtCRDNuclearExclusionNo));
			}
		}
		
		if (dataUmLogin1.getData("SLENO").equalsIgnoreCase("Yes")) {			
			_wait(2000);
			_setValue(getElement(txtENOAggregateLimit), dataUmLogin.getData("ENOAggregateLimit"));
			_wait(2000);
			_setValue(getElement(txtENOPerClaimLimit), dataUmLogin.getData("ENOPerClaimLimit"));
			_wait(2000);
			_setValue(getElement(txtENORetention), dataUmLogin.getData("ENORetention"));
			_wait(2000);
			_setValue(getElement(txtENOPartOf), dataUmLogin.getData("ENOPartOf"));
			_wait(2000);
			
			if (dataUmLogin.getData("ENOCvgA").equalsIgnoreCase("No")) {
				_wait(2000);
				_click(getElement(chkENOCvgAAddtoPolicy));
			}
			else
			{
			_setValue(getElement(txtENOCvgAAggregateLimit), dataUmLogin.getData("ENOCvgAAggregateLimit"));
			_wait(2000);
			_setValue(getElement(txtENOCvgAPerClaimLimit), dataUmLogin.getData("ENOCvgAPerClaimLimit"));
			_wait(2000);
			_setValue(getElement(txtENOCvgARetention), dataUmLogin.getData("ENOCvgARetention"));
			_wait(2000);
			_setValue(getElement(txtENOCvgAPartOf), dataUmLogin.getData("ENOCvgAPartOf"));
			_wait(2000);
			}
			
			if (dataUmLogin.getData("ENORegisteredRepresentatives").equalsIgnoreCase("No")) {
				_wait(2000);
				_click(getElement(chkENORegisteredRepreAddtoPolicy));
			}
			else
			{
			_setValue(getElement(txtENORegisteredRepreAggregateLimit), dataUmLogin.getData("ENORegisteredRepreAggregateLimit"));
			_wait(2000);
			_setValue(getElement(txtENORegisteredReprePerClaimLimit), dataUmLogin.getData("ENORegisteredReprePerClaimLimit"));
			_wait(2000);
			_setValue(getElement(txtENORegisteredRepreRetention), dataUmLogin.getData("ENORegisteredRepreRetention"));
			_wait(2000);
			_setValue(getElement(txtENORegisteredReprePartOf), dataUmLogin.getData("ENORegisteredReprePartOf"));
			_wait(2000);
			}
		}
		
		if (dataUmLogin1.getData("POL").equalsIgnoreCase("Yes")) {	
			
			if (dataUmLogin1.getData("POLNonHonouring").equalsIgnoreCase("Yes")) {
				_setValue(getElement(txtNonPaymentLimit), dataUmLogin.getData("POLNonPaymentLimit"));
				_wait(2000);
				_setValue(getElement(txtNonPaymentPartOf), dataUmLogin.getData("POLNonPaymentPartOf"));
				_wait(2000);
				_setValue(getElement(txtNonPaymentIdemnityPercent), dataUmLogin.getData("POLNonPaymentIdemnityPercent"));
				_wait(2000);
			}
			else
			{
			if (dataUmLogin.getData("POLArbitrationAwardDefault").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_click(getElement(chkArbitrationAwardDefault));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLBusinessInterruption").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_click(getElement(chkBusinessInterruption));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLCurrencyInconvertiblityTransfer").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_click(getElement(chkCurrencyInconvertiblityTransfer));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLEmbargo").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_click(getElement(chkEmbargo));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLExpropriation").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_click(getElement(chkExpropriation));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLForcedAbandonment").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_click(getElement(chkForcedAbandonment));
				_wait(2000);
			}
			
			
			if (dataUmLogin.getData("POLForcedDivestiture").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_click(getElement(chkForcedDivestiture));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLLicenseConcessionCancellation").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_click(getElement(chkLicenseConcessionCancellation));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLPoliticalViolence").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_click(getElement(chkPoliticalViolence));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLWrongfulCalling").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_click(getElement(chkWrongfulCalling));
				_wait(2000);
			}
			
			_wait(2000);
			_click(getElement(btnUpdateCoverage));
			_wait(20000);
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(5000);
			if (dataUmLogin.getData("POLArbitrationAwardDefault").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_setValue(getElement(txtArbitrationAwardDefaultLimit), dataUmLogin.getData("POLArbitrationAwardDefaultLimit"));
				_wait(2000);
				_setValue(getElement(txtArbitrationAwardDefaultPartOf), dataUmLogin.getData("POLArbitrationAwardDefaultPartOf"));
				_wait(2000);
				_setValue(getElement(txtArbitrationAwardDefaultIdemnityPercent), dataUmLogin.getData("POLArbitrationAwardDefaultIdemnityPercent"));
				func.setValue9();
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLBusinessInterruption").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_setValue(getElement(txtBusinessInterruptionLimit), dataUmLogin.getData("POLBusinessInterruptionLimit"));
				_wait(2000);
				_setValue(getElement(txtBusinessInterruptionPartOf), dataUmLogin.getData("POLBusinessInterruptionPartOf"));
				_wait(2000);
				_setValue(getElement(txtBusinessInterruptionIdemnityPercent), dataUmLogin.getData("POLBusinessInterruptionIdemnityPercent"));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLCurrencyInconvertiblityTransfer").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_setValue(getElement(txtCurrencyInconvertiblityTransferLimit), dataUmLogin.getData("POLCurrencyInconvertiblityTransferLimit"));
				_wait(2000);
				_setValue(getElement(txtCurrencyInconvertiblityTransferPartOf), dataUmLogin.getData("POLCurrencyInconvertiblityTransferPartOf"));
				_wait(2000);
				_setValue(getElement(txtCurrencyInconvertiblityTransferIdemnityPercent), dataUmLogin.getData("POLCurrencyInconvertiblityTransferIdemnityPercent"));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLEmbargo").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_setValue(getElement(txtEmbargoLimit), dataUmLogin.getData("POLEmbargoLimit"));
				_wait(2000);
				_setValue(getElement(txtEmbargoPartOf), dataUmLogin.getData("POLEmbargoPartOf"));
				_wait(2000);
				_setValue(getElement(txtEmbargoIdemnityPercent), dataUmLogin.getData("POLEmbargoIdemnityPercent"));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLExpropriation").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_setValue(getElement(txtExpropriationLimit), dataUmLogin.getData("POLExpropriationLimit"));
				_wait(2000);
				_setValue(getElement(txtExpropriationPartOf), dataUmLogin.getData("POLExpropriationPartOf"));
				_wait(2000);
				_setValue(getElement(txtExpropriationIdemnityPercent), dataUmLogin.getData("POLExpropriationIdemnityPercent"));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLForcedAbandonment").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_setValue(getElement(txtForcedAbandonmentLimit), dataUmLogin.getData("POLForcedAbandonmentLimit"));
				_wait(2000);
				_setValue(getElement(txtForcedAbandonmentPartOf), dataUmLogin.getData("POLForcedAbandonmentPartOf"));
				_wait(2000);
				_setValue(getElement(txtForcedAbandonmentIdemnityPercent), dataUmLogin.getData("POLForcedAbandonmentIdemnityPercent"));
				_wait(2000);
			}
			
			
			if (dataUmLogin.getData("POLForcedDivestiture").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_setValue(getElement(txtForcedDivestitureLimit), dataUmLogin.getData("POLForcedDivestitureLimit"));
				_wait(2000);
				_setValue(getElement(txtForcedDivestiturePartOf), dataUmLogin.getData("POLForcedDivestiturePartOf"));
				_wait(2000);
				_setValue(getElement(txtForcedDivestitureIdemnityPercent), dataUmLogin.getData("POLForcedDivestitureIdemnityPercent"));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLLicenseConcessionCancellation").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_setValue(getElement(txtLicenseConcessionCancellationLimit), dataUmLogin.getData("POLLicenseConcessionCancellationLimit"));
				_wait(2000);
				_setValue(getElement(txtLicenseConcessionCancellationPartOf), dataUmLogin.getData("POLLicenseConcessionCancellationPartOf"));
				_wait(2000);
				_setValue(getElement(txtLicenseConcessionCancellationIdemnityPercent), dataUmLogin.getData("POLLicenseConcessionCancellationIdemnityPercent"));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLPoliticalViolence").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_setValue(getElement(txtPoliticalViolenceLimit), dataUmLogin.getData("POLPoliticalViolenceLimit"));
				_wait(2000);
				_setValue(getElement(txtPoliticalViolencePartOf), dataUmLogin.getData("PoliticalViolencePartOf"));
				_wait(2000);
				_setValue(getElement(txtPoliticalViolenceIdemnityPercent), dataUmLogin.getData("POLPoliticalViolenceIdemnityPercent"));
				_wait(2000);
			}
			
			if (dataUmLogin.getData("POLWrongfulCalling").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_setValue(getElement(txtWrongfulCallingLimit), dataUmLogin.getData("POLWrongfulCallingLimit"));
				_wait(2000);
				_setValue(getElement(txtWrongfulCallingPartOf), dataUmLogin.getData("POLWrongfulCallingPartOf"));
				_wait(2000);
				_setValue(getElement(txtWrongfulCallingIdemnityPercent), dataUmLogin.getData("POLWrongfulCallingIdemnityPercent"));
				_wait(2000);
			}
		  }
		}
		if (dataUmLogin1.getData("REP").equalsIgnoreCase("Yes")) {			
			_wait(2000);
			_setValue(getElement(txtREPAggregateLimit), dataUmLogin.getData("REPAggregateLimit"));
			_wait(2000);
			_setValue(getElement(txtREPRetetntion), dataUmLogin.getData("REPRetetntion"));
			_wait(2000);
			_setValue(getElement(txtREPPartOf), dataUmLogin.getData("REPPartOf"));
			_wait(4000);
		}
		if (dataUmLogin1.getData("TAX").equalsIgnoreCase("Yes")) {			
			_wait(2000);
			_setValue(getElement(txtTAXAggregateLimit), dataUmLogin.getData("TAXAggregateLimit"));
			_wait(2000);
			_setValue(getElement(txtTAXRetetntion), dataUmLogin.getData("TAXRetetntion"));
			_wait(2000);
			_setValue(getElement(txtTAXPartOf), dataUmLogin.getData("TAXPartOf"));
			
			_wait(4000);
		}
		if (dataUmLogin1.getData("SUR").equalsIgnoreCase("Yes")) {			
			_wait(2000);
			_setValue(getElement(txtSURBondAmount), dataUmLogin.getData("SURBondAmount"));
			_wait(2000);
			_setValue(getElement(txtSURPMLPercentage), dataUmLogin.getData("SURPMLPercentage"));
			_wait(4000);
		}
		//Common
		_click(getElement(btnRatingSubmissionInformation));
		_wait(15000);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_click(getElement(btnWritingApproach));
		_wait(2000);
		String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""
				+ dataUmLogin.getData("WritingApproach") + "\")]";
		WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
		expectedOption.click();
		
		//Premium
		_wait(4000);
		_click(getElement(btnRatingPremiumSummary));
		_wait(15000);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_setValue(getElement(txtPremium), dataUmLogin.getData("Premium"));
		_wait(4000);
		func.setValue9();
	}
}