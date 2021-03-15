package com.everest.page.application.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.NewSubmissionPage;
import com.everest.utility.CustomAbstractPage;

public class NewSubmissionPageImpl extends CustomAbstractPage implements NewSubmissionPage {

	@SuppressWarnings("static-access")
	@Override
	public void createNewSubmission(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataAccount = PageDataManager.instance().getPageData("NewSubmission", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(4000);
		_click(getElement(tabActions));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(menuLinkNewSubmission));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(btnSelect));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		
		if(dataAccount.getData("Crime").equals("Yes"))
		{
		_click(getElement(chkCrime));
		_wait(2000);
		}
		if(dataAccount.getData("CYB").equals("Yes"))
		{
		_click(getElement(chkCYB));
		_wait(2000);
		
		}
		if(dataAccount.getData("DNO").equals("Yes"))
		{
		_click(getElement(chkDNO));
		_wait(2000);
		}
		if(dataAccount.getData("EPL").equals("Yes"))
		{
		_click(getElement(chkEPL));
		_wait(2000);
		
		}
		if(dataAccount.getData("EMP").equals("Yes"))
		{
		_click(getElement(chkEMP));
		_wait(2000);
		
		}
		if(dataAccount.getData("ENO").equals("Yes"))
		{
		_click(getElement(chkENO));
		_wait(2000);
		
		}
		if(dataAccount.getData("FID").equals("Yes"))
		{
		_click(getElement(chkFID));
		_wait(2000);
		
		}
		if(dataAccount.getData("KNR").equals("Yes"))
		{
		_click(getElement(chkKNR));
		_wait(2000);
		
		}
		
		_selectValueDropDown(getElement(ddPolicyForms), dataAccount.getData("PolicyForms"));
		func._waitForPageToLoad(getWebDriver(), 1000L);
		_wait(3000);
		_click(getElement(btnNext));
		_wait(2000);
		
		_selectValueDropDown(getElement(ddDepartmentCode), dataAccount.getData("DepartmentCode"));
		func._waitForPageToLoad(getWebDriver(), 1000L);
		_wait(3000);
		
		_selectValueDropDown(getElement(ddOffice), dataAccount.getData("Office"));
		func._waitForPageToLoad(getWebDriver(), 1000L);
		_wait(3000);
		
		_selectValueDropDown(getElement(ddUnderwriter), dataAccount.getData("Underwriter"));
		func._waitForPageToLoad(getWebDriver(), 1000L);
		_wait(3000);
		_selectValueDropDown(getElement(ddUnderwriterAssistant), dataAccount.getData("UnderwriterAssistant"));
		func._waitForPageToLoad(getWebDriver(), 1000L);
		_wait(3000);
		_selectValueDropDown(getElement(txtCommissionPercentage), dataAccount.getData("CommissionPercentage"));
		func._waitForPageToLoad(getWebDriver(), 1000L);
		_wait(3000);
		
		_selectValueDropDown(getElement(ddLegalEntity), dataAccount.getData("LegalEntity"));
		func._waitForPageToLoad(getWebDriver(), 1000L);
		_wait(3000);
		_selectValueDropDown(getElement(ddOwnershipType), dataAccount.getData("OwnershipType"));
		func._waitForPageToLoad(getWebDriver(), 1000L);
		_wait(3000);
		
		_selectValueDropDown(getElement(ddAssignedTo), dataAccount.getData("AssignedTo"));
		func._waitForPageToLoad(getWebDriver(), 1000L);
		_wait(3000);
		
		_selectValueDropDown(getElement(txtCommissionPercentage), dataAccount.getData("CommissionPercentage"));
		func._waitForPageToLoad(getWebDriver(), 1000L);
		_wait(3000); 
		
		_selectValueDropDown(getElement(ddWritingApproach), dataAccount.getData("WritingApproach"));
		func._waitForPageToLoad(getWebDriver(), 1000L);
		_clickEnter();
		_wait(3000);
		if (!(dataAccount.getData("txtNYCLass").equals("")))
		{
			_setValue(getElement(txtNYCLass),dataAccount.getData("txtNYCLass"));
		}
		
		func._waitForPageToLoad(getWebDriver(), 1000L);
		_wait(10000);
		_click(getElement(btnNext));
		_wait(2000);
		_click(getElement(btnNext));
		_wait(2000);

		_setValue(getElement(txtRevenue), dataAccount.getData("Revenue"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		
		_setValue(getElement(txtCorporateAssets), dataAccount.getData("CorporateAssets"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		
		
		_wait(1000);
		func.sendData(txtUnionAllClass2,getElement(txtUnionAllClass2),dataAccount.getData("txtUnionAllClass2"),"Exposures");
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		func.sendData(txtNonUnionFulltimeClass2,getElement(txtNonUnionFulltimeClass2),dataAccount.getData("txtNonUnionFulltimeClass2"),"Exposures");
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		func.sendData(txtNonUnionICsClass2,getElement(txtNonUnionICsClass2),dataAccount.getData("txtNonUnionICsClass2"),"Exposures");
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		func.sendData(txtNonUnionFulltimeClass1,getElement(txtNonUnionFulltimeClass1),dataAccount.getData("txtNonUnionFulltimeClass1"),"Exposures");
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
	_click(getElement(btnNext));
		_wait(2000);
		if(func._isVisible(getElement(btnClear)))
		{
		_click(getElement(btnClear));
		_wait(2000);
		}
		if(dataAccount.getData("Additional Side A Limit for D&O Liability").equals("Yes"))
		{
		 String targetxpath= "//*[contains(text(),'Premises Coverage')]/preceding-sibling::div//input";
			
			_wait(7000);
		}
		
//		_setValue(getElement(txtAnnualPremium), dataAccount.getData("AnnualPremium"));
//		func._waitForPageToLoad(getWebDriver(), 50L);
//		_wait(2000);
        
		_wait(7000);
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
}

if(func._isVisible(getElement(tabEPL)))
{
		
		_click(getElement(tabEPL));
		_wait(2000);
		
		_setValue(getElement(txtEplAggLmtLiab), dataAccount.getData("EPLAggregateLimitLiability"));
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
		
}
if(func._isVisible(getElement(tabEMP)))
{	
}
if(func._isVisible(getElement(tabENO)))
{	
}
if(func._isVisible(getElement(tabFID)))
{	
}
if(func._isVisible(getElement(tabKNR)))
{	
}
if(func._isVisible(getElement(tabCYB)))
{	
}
	PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
	if (dataLogin.getData("AddOptionalCoverages").equalsIgnoreCase("Yes"))
	{
		PageImplInvoker classInvoker = new PageImplInvoker();
		classInvoker.OptionalCov(tcID);
	}

		_click(getElement(btnNext));
		_wait(6000);
		
//		PageImplInvoker classInvoker = new PageImplInvoker();
//		classInvoker.Modifiers(tcID);
		
		_wait(5000);
		_click(getElement(btnNext));
		_wait(2000);
		_click(getElement(btnNext));
		_wait(2000);

		_click(getElement(btnQuote));
		_wait(10000);
		
		if (dataLogin.getData("CapturePremium").equalsIgnoreCase("Yes"))
		{
		String Premium = _getAttributeValue(getElement(lblPremium), "TEXT");

		_writeToExcel("InsuredAppLogin", "Premium", Premium, tcID);
		
		String RatingWorkSheetId = _getAttributeValue(getElement(lblRatingWorkSheetId), "TEXT");

		_writeToExcel("InsuredAppLogin", "RatingWorkSheetId", RatingWorkSheetId, tcID);
		
		}
		
		_click(getElement(btnPrintOptions));
		_wait(2000);
		
		_click(getElement(lnkPrintBinder));
		_wait(5000);
		_click(getElement(btnFinalize));
		_wait(4000);
		
		if(func._isVisible(getElement(btnFinalize)))
		{
			_click(getElement(btnFinalize));
		}
		_click(getElement(btnBindOptions));
		_wait(2000);
		_click(getElement(btnIssueOnly));
		_wait(2000);
		_click(getElement(btnOk));
		_wait(2000);
		_click(getElement(lnkViewPolicy));
		_wait(2000);
		
		String PolicyNo = _getAttributeValue(getElement(lblPolicyNo), "TEXT");

		_writeToExcel("SearchPolicy", "PolicyNo", PolicyNo, tcID);
		

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(2000);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

	}

}
