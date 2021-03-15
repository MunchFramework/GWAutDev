package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.CancelPage;
import com.everest.utility.CustomAbstractPage;

public class CancelPageImpl extends CustomAbstractPage implements CancelPage{

	@SuppressWarnings("static-access")
	@Override
	public void cancelPolicy(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataCancellation = PageDataManager.instance().getPageData("Cancellation", tcID);
		PageData dataSubDet = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		
        String strURL="";
		
		
		_click(getElement(tabActions));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(btnSelectCancel));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_setValue(getElement(txtSource), dataCancellation.getData("Source"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		
		_click(getElement(txtReason));
		_wait(3000);
		
		_setValue(getElement(txtReason), dataCancellation.getData("Reason"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(3000);
		
		func.setValue2(getElement(txtReason));
		_wait(3000);
		
		if( dataCancellation.getData("Reason").equalsIgnoreCase("Non-pay")) {
		_setValue(getElement(txtReasonDescription), dataCancellation.getData("ReasonDescription"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_setValue(getElement(txtRefundMethod), dataCancellation.getData("RefundMethod"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		func.setValue9();
		_wait(1000);
		
		}
		if( dataCancellation.getData("Reason").equalsIgnoreCase("Other Reason(s)")) {
			_setValue(getElement(txtReasonDescription), dataCancellation.getData("ReasonDescription"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(1000);
			_setValue(getElement(txtRefundMethod), dataCancellation.getData("RefundMethod"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			func.setValue9();
			_wait(1000);
		}
		if( dataCancellation.getData("Reason").equalsIgnoreCase("At Underwriter's request")) {
			_setValue(getElement(txtReasonDescription), dataCancellation.getData("ReasonDescription"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(1000);
			_setValue(getElement(txtRefundMethod), dataCancellation.getData("RefundMethod"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			func.setValue9();
			_wait(1000);	
		
			}
		if( dataCancellation.getData("Reason").equalsIgnoreCase("Cancelled Due to Losses")) {
			_setValue(getElement(txtReasonDescription), dataCancellation.getData("ReasonDescription"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(1000);
			_setValue(getElement(txtRefundMethod), dataCancellation.getData("RefundMethod"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			func.setValue9();
			_wait(1000);
			
		
			}
		
		if( dataCancellation.getData("Reason").equalsIgnoreCase("Business Sold")) {
			_setValue(getElement(txtReasonDescription), dataCancellation.getData("ReasonDescription"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(1000);
			_setValue(getElement(txtRefundMethod), dataCancellation.getData("RefundMethod"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			func.setValue9();
			_wait(1000);
		}
		if( dataCancellation.getData("Reason").equalsIgnoreCase("Change in Underlying")) {
			_setValue(getElement(txtReasonDescription), dataCancellation.getData("ReasonDescription"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(1000);
			_setValue(getElement(txtRefundMethod), dataCancellation.getData("RefundMethod"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			func.setValue9();
			_wait(1000);
		}
		if( dataCancellation.getData("Reason").equalsIgnoreCase("Loss Control")) {
			_setValue(getElement(txtReasonDescription), dataCancellation.getData("ReasonDescription"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(1000);
			_setValue(getElement(txtRefundMethod), dataCancellation.getData("RefundMethod"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			func.setValue9();
			_wait(1000);
		}
		_wait(5000);
		
		if( !dataCancellation.getData("RefundMethod").equalsIgnoreCase("Flat")) 
		{
		    if (func._isVisible(getElement(txtCancelEffDate)) == true)
			{
				_click(getElement(txtCancelEffDate));
				_wait(1000);
				String eff_date_pol = dataSubDet.getData("EffectiveDate");
				int duedate_months=Integer.parseInt(dataCancellation.getData("MonthsAfterPolEffDate"));
				String Date_PolCancel = func.Date_Manipulation(eff_date_pol, "MONTHS", duedate_months);
				_setValue(getElement(txtCancelEffDate), Date_PolCancel);
				_wait(1000);
				//_setValue(getElement(txtCancelEffDate), dataCancellation.getData("CancelEffDate"));
				func.setValue9();
			}
		}
		_wait(2000);
		

		_click(getElement(btnStartCancellation));
		_wait(10000);
		if (func._isVisible(getElement(btnStartCancellation)) == true)
		{
			_click(getElement(btnStartCancellation));
			_wait(10000);
		}
		_wait(10000);
		_click(getElement(btnBindOptions));
		_wait(2000);
		if(dataCancellation.getData("Rescind").equalsIgnoreCase("Yes"))
		{
		_click(getElement(lnkScheduleCancel));
		}else
		{
		_click(getElement(lnkCancelNow));	
		}
		_wait(4000);
		_click(getElement(btnOk));
		_wait(4000);
		
		if (func._isVisible(getElement(lnkViewPolicy)) == true)
		{
		_wait(2000);
		_click(getElement(lnkViewPolicy));
		_wait(2000);
		}
		_wait(2000);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(2000);


		
		}

}
