package com.everest.page.application.spi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.PolicyChangePage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class PolicyChangePageImpl extends CustomAbstractPage implements PolicyChangePage {

	@SuppressWarnings("static-access")
	@Override
	public void PolicyChange(String tcID, SoftAssert softAssert) throws Exception {
		
		_wait(4000);
		PageData dataPolicyChange = PageDataManager.instance().getPageData("PolicyChange", tcID);
		PageData dataUmSubDet = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		PageData dataPcLogin = PageDataManager.instance().getPageData("Login", tcID);
		
		
		String strURL = "";
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		_click(getElement(btnActionsTab));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(4000);
		_click(getElement(btnPolicyChangeTab));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			_wait(4000);
			
			String eff_date_pol = dataUmSubDet.getData("EffectiveDate");
			int duedate_months=Integer.parseInt(dataPolicyChange.getData("MonthsAfterPolEffDate"));
			String Date_PolChange = func.Date_Manipulation(eff_date_pol, "MONTHS", duedate_months);
			_setValue(getElement(txtEffectiveDate), Date_PolChange);
			
			//_setValue(getElement(txtEffectiveDate), dataPolicyChange.getData("EffectiveDate"));
			func.setValue9();
			_wait(4000);
			_setValue(getElement(ddChangeType), dataPolicyChange.getData("ChangeType"));
			/*if(!(dataPcLogin.getData("RateBearingOptCov").equalsIgnoreCase(""))) {
				
				_setValue(getElement(ddChangeType), "Add/Delete/Modify Coverages");
				
			}
			else {
			_setValue(getElement(ddChangeType), dataPolicyChange.getData("ChangeType"));
			}*/
		func._waitForPageToLoad(getWebDriver(), 1000L);
		func.setValue2(getElement(ddChangeType));
		_wait(3000);
		
		WebElement weChangeDesc=(WebElement)getElement(txtChangeDesc).getNative();
		weChangeDesc.sendKeys(Keys.TAB);
		_wait(3000);
		_setValue(getElement(txtChangeDesc), dataPolicyChange.getData("ChangeDesc"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);

		_click(getElement(btnNext));
		
		_wait(1000);
		
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		
		if(dataPolicyChange.getData("OutOfSeqTxn").equalsIgnoreCase("Yes")) {
			String OutOfSeqAlertMsg=getWebDriver().findElement(By.xpath("//div[@id='messagebox-1001-msg']")).getText();
			
			if(OutOfSeqAlertMsg.contains("This would be an out-of-sequence transaction. Are you sure you want to continue?")) {
				getWebDriver().findElement(By.xpath("//span[text()='OK']")).click();
				CustomReporting.logReport("","","Verified out-of-sequence transaction ",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "out-of-sequence transaction Msg Alert box not present","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
			}
		
		
		// when change type is "change Policy term"
		if( dataPolicyChange.getData("ChangeType").equalsIgnoreCase("Change Policy Term"))
		{
			_wait(2000);
			_click(getElement(btnNextpc));
			_wait(10000);
			
			if(!dataPolicyChange.getData("ExpirationDate").equals(""))
			{
				int exp_months=Integer.parseInt(dataPolicyChange.getData("ExpirationDate"));
				String Exp_PolChange = func.Date_Manipulation(eff_date_pol, "MONTHS", exp_months);
				_setValue(getElement(txtExpDate), Exp_PolChange);
				func._waitForPageToLoad(getWebDriver(), 50L);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			  _wait(10000);
			}
		    if( dataUmSubDet.getData("SlimProducts").equalsIgnoreCase("Yes"))
			  {
				  _click(getElement(txtEndorsementIssuedDate));
				  _wait(2000);
				  _setValue(getElement(txtEndorsementIssuedDate), dataPolicyChange.getData("EndorsementIssuedDate"));
				  _wait(2000);
					func.setValue9();
			  }
				
		}
		
		// when change type is "Change Producer"
		if(dataPolicyChange.getData("ChangeType").equalsIgnoreCase("Change Producer")) {
			_click(getElement(btnCoverageSelectionNext));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(1000);
			_click(getElement(txtOrganization));
			_wait(1000);
			_setValue(getElement(txtOrganization), dataPolicyChange.getData("Organization"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(5000);
			func.setValue3(getElement(txtOrganization));
			//_clickTab();
			_wait(5000);
			_click(getElement(txtProducerCode));
			_wait(1000);
			_setValue(getElement(txtProducerCode), dataPolicyChange.getData("ProducerCode"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(3000);
			func.setValue3(getElement(txtProducerCode));
			_wait(5000);
			_click(getElement(txtProducerContact));
			_wait(1000);
			_setValue(getElement(txtProducerContact), dataPolicyChange.getData("ProducerContact"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(1000);
			func.setValue2(getElement(txtProducerContact));
			_clickTab();
			_wait(3000);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			  _click(getElement(txtBindingContact));
				_wait(1000);
			  _setValue(getElement(txtBindingContact), dataPolicyChange.getData("BindingContact"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(1000);
			func.setValue2(getElement(txtBindingContact));

			_clickTab();
			_wait(2000);
			_click(getElement(btnPolicyInfoNext));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(3000);
			
		}
		
		
		//If its a plain change and no changes is done just a simple submit
		if( dataPolicyChange.getData("ChangeTypeDesc").equalsIgnoreCase("Plain change"))
		{
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(btnCoverageSelectionNext));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(btnPolicyInfoNext));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(btnLocationsNext));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(btnExposuresNext));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(btnCoveragesNext));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		}
		  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		//If we need to add a location as a change
		if( dataPolicyChange.getData("ChangeTypeDesc").equalsIgnoreCase("PolicyChange,AddLocation"))
		{
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_click(getElement(btnNext));
			_wait(2000);
			_click(getElement(btnNext));
			_wait(2000);
			_click(getElement(btnAddNewLoc));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(1000);
			
			_setValue(getElement(txtAddress1), dataPolicyChange.getData("Address1"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(2000);
			_setValue(getElement(txtCity), dataPolicyChange.getData("City"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(2000);
			
			_setValue(getElement(txtZip), dataPolicyChange.getData("Zip"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(2000);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_click(getElement(btnOK));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(1000);
			
			
			
		}
		
		//If we need to change the additional Insured details
				if( dataPolicyChange.getData("ChangeType").equalsIgnoreCase("Change Insured Name and/or Address"))
				{
					_click(getElement(btnNextpc));
					_wait(2000);
					if( dataPolicyChange.getData("ChangeTypeDesc").equalsIgnoreCase("ChangeName"));
					
					{
						_click(getElement(btnName));
						_wait(2000);
						_setValue(getElement(txtName1), dataPolicyChange.getData("NewName"));
						func._waitForPageToLoad(getWebDriver(), 50L);
						
						_click(getElement(btnOK));
						_wait(1000);
						_click(getElement(btnNextpc));
						_wait(2000);
						  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					}
					if( dataPolicyChange.getData("ChangeTypeDesc2").equalsIgnoreCase("ChangeAddress"))
						
					{
						_wait(2000);
						_click(getElement(lblPolicyInfo));
						_wait(4000);
						_click(getElement(btnChangeTo));
						_wait(2000);
						_click(getElement(btnEditAddress));
						_wait(2000);
						
						_setValue(getElement(txtAddress2), dataPolicyChange.getData("txtAddress2"));
						func.setValue9();
						func._waitForPageToLoad(getWebDriver(), 50L);
						_setValue(getElement(txtCity1), dataPolicyChange.getData("txtCity1"));
						func.setValue9();
						func._waitForPageToLoad(getWebDriver(), 50L);
						_setValue(getElement(txtZip1), dataPolicyChange.getData("txtZip1"));
						func.setValue9();
						func._waitForPageToLoad(getWebDriver(), 50L);
						  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						_click(getElement(btnOK));
						_wait(3000);
						
					}
				}
	    //If we need to change the additional Insured details
				if( dataPolicyChange.getData("ChangeType").equalsIgnoreCase("Add/Delete/Modify Coverages"))
				{
					PageImplInvoker classInvoker = new PageImplInvoker();
					classInvoker.PolicyCoverageChange(tcID);
					
				}		
				//If we need to change the additional Insured details
				if( dataPolicyChange.getData("ChangeType").equalsIgnoreCase("Add/Delete/Modify Coverages Non-Rate Bearing"))
				{
					if ( dataPolicyChange.getData("RemoveOptionalCov").equalsIgnoreCase("Yes"))
					{
						PageImplInvoker classInvoker = new PageImplInvoker();
						classInvoker.RemoveOptionalCov(tcID);					}
					else
					{
						PageImplInvoker classInvoker = new PageImplInvoker();
						classInvoker.OptionalCov(tcID);		
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
				
		//If we need to change the additional Insured details
				if( dataPolicyChange.getData("ChangeType").equalsIgnoreCase("Add/Delete/Modify Additional Insureds"))
				{    _wait(5000);
					_click(getElement(lblPolicyInfo));
					_wait(2000);
					_click(getElement(btnName));
					_wait(1000);
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					_click(getElement(btnDBAtab));
					_wait(1000);
					
					if( dataPolicyChange.getData("ChangeTypeDesc").equalsIgnoreCase("AddDBA"))
					{
						_click(getElement(btnAddDBA));
						_wait(1000);
					
					_setValue(getElement(txtName), dataPolicyChange.getData("txtName"));
					func._waitForPageToLoad(getWebDriver(), 50L);
//					_setValue(getElement(txtPhone), dataPolicyChange.getData("txtPhone"));
//					func._waitForPageToLoad(getWebDriver(), 50L);
//					_setValue(getElement(txtFax), dataPolicyChange.getData("txtFax"));
//					func._waitForPageToLoad(getWebDriver(), 50L);
//					_setValue(getElement(txtEmail1), dataPolicyChange.getData("txtEmail1"));
//					func._waitForPageToLoad(getWebDriver(), 50L);
//					_setValue(getElement(txtEmail2), dataPolicyChange.getData("txtEmail2"));
//					func._waitForPageToLoad(getWebDriver(), 50L);
//					_setValue(getElement(txtWebsite), dataPolicyChange.getData("txtWebsite"));
//					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					func._waitForPageToLoad(getWebDriver(), 50L);
					_click(getElement(btnOK));
					_wait(5000);
					
					
					}
					
					
					if( dataPolicyChange.getData("ChangeTypeDesc").equalsIgnoreCase("RemoveDBA"))
					{
						_click(getElement(btnRemove));
						_wait(1000);
						  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					}
					func._waitForPageToLoad(getWebDriver(), 50L);
					_click(getElement(btnOK));
					_wait(1000);
				}
				
				
				
		//Common steps in change
		_click(getElement(btnQuote));
		func._waitForPageToLoad(getWebDriver(), 50L);
		if( dataPolicyChange.getData("ValidateChangePremium").equalsIgnoreCase("Yes"))
		{
			PageData dataAccount = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
			_wait(10000);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			String Premium = _getAttributeValue(getElement(lblPremium), "TEXT");

			_writeToExcel("InsuredAppLogin", "Premium2", Premium, tcID);
			
			String RatingWorkSheetId = _getAttributeValue(getElement(lblRatingWorkSheetId), "TEXT");

			_writeToExcel("InsuredAppLogin", "RatingWorkSheetId2", RatingWorkSheetId, tcID);
			long startTime = System.currentTimeMillis();
			if (dataAccount.getData("Premium2").equalsIgnoreCase(dataAccount.getData("Premium")))
			{
				CustomReporting.logReport("","", "The New Business and Policy change premium is same ", StepStatus.SUCCESS,new String[] { },startTime);
				}
			else
				{
				CustomReporting.logReport("","", "The New Business and Policy change premium is not the same", StepStatus.SUCCESS,new String[] { },startTime);
			  
				}
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(15000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		if(dataPolicyChange.getData("PremiumChange").equalsIgnoreCase("Yes")) 
		{
			_wait(4000);
			_click(getElement(lblPayment));
			_wait(4000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		
				String xpath = "//*[contains(text(),'Total Premium')]/../..//div//div"; 
				String TotalPremium = getWebDriver().findElement(By.xpath(xpath)).getText();
//				String ActualPremium[] = TotalPremium.split(" - ");
				
				String Premiumvalue = TotalPremium.replaceAll("(\\s+|\\$|,)", "");
				double TotalCoveragePremium =Double.parseDouble(Premiumvalue);  
				
				
				
				String Textinputxpath = "//*[contains(text(),'Premium Breakdown')]/../../..//input"; 
				double NumberCvgs = getWebDriver().findElements(By.xpath(Textinputxpath)).size();
				double ActualCvgs = NumberCvgs;	
				double CoveragePremium = (TotalCoveragePremium/ActualCvgs);
				  //DecimalFormat df2 = new DecimalFormat("#.##");
				DecimalFormat df2 = new DecimalFormat("#");
				double CvgValue = Double.parseDouble(df2.format(CoveragePremium));
				String CvgPremium = Double.toString(CvgValue);
				double LastPremium = Double.parseDouble(df2.format(TotalCoveragePremium-(CvgValue*(NumberCvgs-1))));
				String LastPrem = Double.toString(LastPremium);
				for (int i=0;i<NumberCvgs;i++)
				{
					if (i==(NumberCvgs-1))
					{
						int n = i+1;
						String Cvgs = "(//*[contains(text(),'Premium Breakdown')]/../../..//input)[" + n + "]";
						WebElement CvgField = getWebDriver().findElement(By.xpath(Cvgs));
						CvgField.clear();
						CvgField.sendKeys(LastPrem);
						_wait(2000);
						func.setValue9();
					}
					else
					{	
					int n = i+1;
					String Cvgs = "(//*[contains(text(),'Premium Breakdown')]/../../..//input)[" + n + "]";
					WebElement CvgField = getWebDriver().findElement(By.xpath(Cvgs));
					CvgField.clear();
					CvgField.sendKeys(CvgPremium);
					_wait(2000);
					func.setValue9();
					}
				}
				_wait(4000);
			
		}
		
		_wait(15000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(btnIssuePolicy));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(btnIssueOK));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(10000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(lnkViewPolicy));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(2000);

		
	}

	@Override
	public void PolicyChangeFormValid(String tcID, SoftAssert softAssert) throws Exception {
		
		PageData dataPolicyChange = PageDataManager.instance().getPageData("PolicyChange", tcID);
		
		
		String expectedListOfPlicyChangeForm[]=dataPolicyChange.getData("PolicyChangeForms").split(";");
		_wait(5000);
		List<String> listOFFormsPC=new ArrayList<String>();
		
		int k=3;
		while(k>0) {
		_click(getElement(tabForms));
		
		_wait(3000);
		
		k--;
		}
		String NoOfFormPagesPC=func._getAttributeValue(getElement(txtFormsPageCount), "TEXT").split(" ")[1];
		
		for(int j=1;j<=Integer.parseInt(NoOfFormPagesPC);j++) {
		
		int sizeOfFormsPC= (getWebDriver().findElements(By.xpath("//tr[@class='  x-grid-row']")).size());
		
		for(int i=1;i<=sizeOfFormsPC;i++) {
				
			listOFFormsPC.add(func._getAttributeValue(getClonedElement(txtFormsName).addToken("tkn_formNum", Integer.toString(i)), "TEXT"));
			
			_wait(3000);
		}
		getWebDriver().findElement(By.xpath("(//span[@class='x-btn-icon-el x-btn-icon-el-plain-toolbar-small x-tbar-page-next '])[1]")).click();
		
	
		}
		
		
		
		System.out.println(listOFFormsPC);	
		
		
		for(String expPolChngForms:expectedListOfPlicyChangeForm) {
			
			if(listOFFormsPC.contains(expPolChngForms.trim())) {
				
				CustomReporting.logReport("","","Policy Change Form :" +expPolChngForms.trim()+" is present in PC",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","","Policy Change Form :" +expPolChngForms.trim()+" is not present in PC","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		
			
		}
			
		
	}
	public void PolicyChangeRunOff(String tcID, SoftAssert softAs) throws Exception 
	{
		_wait(4000);
		PageImplInvoker classInvoker = new PageImplInvoker();
		PageData dataPolicyChange = PageDataManager.instance().getPageData("PolicyChange", tcID);
		PageData dataUmSubDet = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		
		
		String strURL = "";
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		_click(getElement(btnActionsTab));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(4000);
		_click(getElement(btnPolicyChangeTab));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			_wait(4000);
			//_setValue(getElement(txtEffectiveDate), dataPolicyChange.getData("EffectiveDate"));
			String eff_date_pol = dataUmSubDet.getData("EffectiveDate");
			int duedate_months=Integer.parseInt(dataPolicyChange.getData("MonthsAfterPolEffDate"));
			String Date_PolChange = func.Date_Manipulation(eff_date_pol, "MONTHS", duedate_months);
			_setValue(getElement(txtEffectiveDate), Date_PolChange);
			func.setValue9();
			_wait(4000);
			_setValue(getElement(ddChangeType), dataPolicyChange.getData("ChangeType"));
		func._waitForPageToLoad(getWebDriver(), 1000L);
		func.setValue2(getElement(ddChangeType));
		_wait(3000);
		

		_setValue(getElement(txtChangeDesc), dataPolicyChange.getData("ChangeDesc"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		
		CustomReporting.logReport(dataPolicyChange.getData("ChangeDesc"));
		
		// added new Eff & Expiry Fields 
		int duedate_months_1=Integer.parseInt(dataPolicyChange.getData("NewExpirationDate"));
		String Date_PolExp = func.Date_Manipulation(eff_date_pol, "MONTHS", duedate_months_1);
		_setValue(getElement(txtNewExpirationDate), Date_PolExp);
		func.setValue9();
		_wait(2000);
		_setValue(getElement(txtNewExpirationDate), Date_PolExp);
		func.setValue9();
		_wait(2000);
		int duedate_months_2=Integer.parseInt(dataPolicyChange.getData("RunOffEffectiveDate"));
		String Date_RunOffExp = func.Date_Manipulation(eff_date_pol, "MONTHS", duedate_months_2);
		_setValue(getElement(txtRunoffEffectiveDate), Date_RunOffExp);
		func.setValue9();
		_wait(2000);
		_setValue(getElement(txtRunoffCommission), dataPolicyChange.getData("RunoffCommission"));
		_wait(2000);
		
		_click(getElement(btnNext));
		func._waitForPageToLoad(getWebDriver(), 50L);
		/*if(func._isVisible(getElement(btnClearValidtion)))
		{
		_click(getElement(btnClearValidtion));
		
		}*/
		
		
		if(dataPolicyChange.getData("RunOffTypeChange").equalsIgnoreCase("unchange"))
		{
			if(dataPolicyChange.getData("RunOffType").equalsIgnoreCase("Cyber")||dataPolicyChange.getData("RunOffType").equalsIgnoreCase("LPL"))
			{
				_wait(2000);
				if(func._isVisible(getElement(msgRunoffAdded)))
				{
					_click(getElement(btnClearValidtion));
					_wait(2000);
					
					_click(getElement(tabRunOffCommon));
					func._waitForPageToLoad(getWebDriver(), 50L);
					if(func._isVisible(getElement(txtRunOffPremiumValue)))
					{
					String Premium = _getAttributeValue(getElement(txtRunOffPremiumValue), "TEXT");
					
					if(Premium.equalsIgnoreCase("Null"))
					{
						_setValue(getElement(txtRunOffPremiumValue), dataPolicyChange.getData("RunOffPremium"));
						func.setValue9();
						_wait(2000);
					}
					}
					
				}else if(func._isVisible(getElement(msgRunoffRemoved)))
				{
					_click(getElement(btnClearValidtion));
					_wait(2000);
					
					_click(getElement(tabRunOffCommon));
					func._waitForPageToLoad(getWebDriver(), 50L);
					if(func._isVisible(getElement(txtRunOffPremiumValue)))
					{
					String Premium = _getAttributeValue(getElement(txtRunOffPremiumValue), "TEXT");
					
					if(Premium.equalsIgnoreCase("Null"))
					{
						_setValue(getElement(txtRunOffPremiumValue), dataPolicyChange.getData("RunOffPremium"));
						func.setValue9();
						_wait(2000);
					}
					}
					
				}
				func._waitForPageToLoad(getWebDriver(), 70L);
				_click(getElement(btnQuote));
				func._waitForPageToLoad(getWebDriver(), 70L);
				_wait(15000);
				classInvoker.ChangePremiumCaptureRunoff( tcID,  "ShortTermWorkSheetID", "ShortTermPremium");
				_wait(15000);
				_click(getElement(btnIssuePolicy));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(10000);
				_click(getElement(btnIssueOK));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(10000);
				
				
				
			}
			
			else if(dataPolicyChange.getData("RunOffType").equalsIgnoreCase("Excess"))
			{
				
				_wait(1000);
				_click(getElement(btnNextpc));
				_wait(2000);
				_click(getElement(btnNextpc));
				_wait(2000);
				_click(getElement(btnNextpc));
				_wait(2000);
				_click(getElement(btnQuote));
				func._waitForPageToLoad(getWebDriver(), 70L);
				_wait(15000);
				
				classInvoker.ChangePremiumCaptureRunoff( tcID,  "ShortTermWorkSheetID", "ShortTermPremium");
				
				_click(getElement(btnIssuePolicy));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(10000);
				_click(getElement(btnIssueOK));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(10000);
				
				if(func._isVisible(getElement(btnClearValidtion)))
				{
				_click(getElement(btnClearValidtion));
				
				
				if(dataPolicyChange.getData("PremiumChange").equalsIgnoreCase("Yes")) {
					_wait(4000);
					_click(getElement(lblPayment));
					_wait(4000);
				
						String xpath = "//*[contains(text(),'Total Premium')]/../..//div//div"; 
						String TotalPremium = getWebDriver().findElement(By.xpath(xpath)).getText();
//						String ActualPremium[] = TotalPremium.split(" - ");
						
						String Premiumvalue = TotalPremium.replaceAll("(\\s+|\\$|,)", "");
						double TotalCoveragePremium =Double.parseDouble(Premiumvalue);  
						
						
						
						String Textinputxpath = "//*[contains(text(),'Premium Breakdown')]/../../..//input"; 
						double NumberCvgs = getWebDriver().findElements(By.xpath(Textinputxpath)).size();
						double ActualCvgs = NumberCvgs;	
						double CoveragePremium = (TotalCoveragePremium/ActualCvgs);
						  DecimalFormat df2 = new DecimalFormat("#");
						double CvgValue = Double.parseDouble(df2.format(CoveragePremium));
						String CvgPremium = Double.toString(CvgValue);
						double LastPremium = Double.parseDouble(df2.format(TotalCoveragePremium-(CvgValue*(NumberCvgs-1))));
						String LastPrem = Double.toString(LastPremium);
						for (int i=0;i<NumberCvgs;i++)
						{
							if (i==(NumberCvgs-1))
							{
								int n = i+1;
								String Cvgs = "(//*[contains(text(),'Premium Breakdown')]/../../..//input)[" + n + "]";
								WebElement CvgField = getWebDriver().findElement(By.xpath(Cvgs));
								CvgField.clear();
								CvgField.sendKeys(LastPrem);
								_wait(2000);
								func.setValue9();
							}
							else
							{	
							int n = i+1;
							String Cvgs = "(//*[contains(text(),'Premium Breakdown')]/../../..//input)[" + n + "]";
							WebElement CvgField = getWebDriver().findElement(By.xpath(Cvgs));
							CvgField.clear();
							CvgField.sendKeys(CvgPremium);
							_wait(2000);
							func.setValue9();
							}
						}
						_wait(4000);
					
				}
				}
				_wait(15000);
				_click(getElement(btnIssuePolicy));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				_click(getElement(btnIssueOK));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(10000);
				
			
				if(func._isVisible(getElement(btnClearValidtion)))
				{
				_click(getElement(btnClearValidtion));
				
				}
				
				func._waitForPageToLoad(getWebDriver(), 50L);
				
				_wait(5000);
				//_click(getElement(btnNextpc));
				
				//PolicyCoverageChange
				
				
				_click(getElement(tabRunOffCommon));
				_wait(2000);
				_setValue(getElement(txtPreceedingLayerPremium), dataPolicyChange.getData("ChangePreceedingLPremium"));
				_wait(2000);
				//func.setValue9();
				//func._waitForPageToLoad(getWebDriver(), 50L);
				_click(getElement(btnNextpc));
				_wait(15000);
				_click(getElement(btnNextpc));
				_wait(15000);
				_click(getElement(btnQuote));
				//func._waitForPageToLoad(getWebDriver(), 70L);
				_wait(15000);
				if(func._isVisible(getElement(btnIssuePolicy))==false)
				{
					_wait(15000);
				}
				
				classInvoker.ChangePremiumCaptureRunoff( tcID,  "RunOffWorksheetID", "RunOffPremium");
				_wait(20000);
				_click(getElement(btnIssuePolicy));
				//func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(15000);
				_click(getElement(btnIssueOK));
				//func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(10000);
				
				
				}
		}
		
		else if (dataPolicyChange.getData("RunOffTypeChange").equalsIgnoreCase("change"))
		{
			if(func._isVisible(getElement(btnClearValidtion)))
			{
			_click(getElement(btnClearValidtion));
			
			}
			if(dataPolicyChange.getData("RunOffType").equalsIgnoreCase("Excess"))
		{
		
		_wait(1000);
		_click(getElement(btnNextpc));
		_wait(5000);
		_click(getElement(btnNextpc));
		_wait(5000);
		_click(getElement(btnNextpc));
		_wait(5000);
		_click(getElement(btnQuote));
		//func._waitForPageToLoad(getWebDriver(), 70L);
		_wait(15000);
		
		classInvoker.ChangePremiumCaptureRunoff( tcID,  "ShortTermWorkSheetID", "ShortTermPremium");
		
		_click(getElement(btnIssuePolicy));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(15000);
		_click(getElement(btnIssueOK));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(10000);
		
		if(func._isVisible(getElement(btnClearValidtion)))
		{
		_click(getElement(btnClearValidtion));
		
		
		if(dataPolicyChange.getData("PremiumChange").equalsIgnoreCase("Yes")) {
			_wait(4000);
			_click(getElement(lblPayment));
			_wait(4000);
		
				String xpath = "//*[contains(text(),'Total Premium')]/../..//div//div"; 
				String TotalPremium = getWebDriver().findElement(By.xpath(xpath)).getText();
//				String ActualPremium[] = TotalPremium.split(" - ");
				
				String Premiumvalue = TotalPremium.replaceAll("(\\s+|\\$|,)", "");
				double TotalCoveragePremium =Double.parseDouble(Premiumvalue);  
				
				
				
				String Textinputxpath = "//*[contains(text(),'Premium Breakdown')]/../../..//input"; 
				double NumberCvgs = getWebDriver().findElements(By.xpath(Textinputxpath)).size();
				double ActualCvgs = NumberCvgs;	
				double CoveragePremium = (TotalCoveragePremium/ActualCvgs);
				  DecimalFormat df2 = new DecimalFormat("#");
				double CvgValue = Double.parseDouble(df2.format(CoveragePremium));
				String CvgPremium = Double.toString(CvgValue);
				double LastPremium = Double.parseDouble(df2.format(TotalCoveragePremium-(CvgValue*(NumberCvgs-1))));
				String LastPrem = Double.toString(LastPremium);
				for (int i=0;i<NumberCvgs;i++)
				{
					if (i==(NumberCvgs-1))
					{
						int n = i+1;
						String Cvgs = "(//*[contains(text(),'Premium Breakdown')]/../../..//input)[" + n + "]";
						WebElement CvgField = getWebDriver().findElement(By.xpath(Cvgs));
						CvgField.clear();
						CvgField.sendKeys(LastPrem);
						_wait(2000);
						func.setValue9();
					}
					else
					{	
					int n = i+1;
					String Cvgs = "(//*[contains(text(),'Premium Breakdown')]/../../..//input)[" + n + "]";
					WebElement CvgField = getWebDriver().findElement(By.xpath(Cvgs));
					CvgField.clear();
					CvgField.sendKeys(CvgPremium);
					_wait(2000);
					func.setValue9();
					}
				}
				_wait(4000);
			
		}
		}
		_wait(15000);
		_click(getElement(btnIssuePolicy));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(btnIssueOK));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(10000);
		
	
		if(func._isVisible(getElement(btnClearValidtion)))
		{
		_click(getElement(btnClearValidtion));
		
		}
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		_wait(5000);
		//_click(getElement(btnNextpc));
		
		//PolicyCoverageChange
		
		
		_click(getElement(tabRunOffCommon));
		_wait(2000);
		_setValue(getElement(txtPreceedingLayerPremium), dataPolicyChange.getData("ChangePreceedingLPremium"));
		_wait(2000);
		/*func.setValue9();
		WebElement we = getWebDriver().findElement(By.xpath("//div[text()='Preceding Layer']"));
		we.click();
		Actions ac = new Actions(getWebDriver());
		ac.moveToElement(getWebDriver().findElement(By.xpath("//div[text()='Preceding Layer']"))).click();
		ac.sendKeys(Keys.PAGE_UP).perform();
		ac.sendKeys(Keys.PAGE_UP).perform();
		func._waitForPageToLoad(getWebDriver(), 50L);*/
		_click(getElement(btnNextpc));
		_wait(15000);
		_click(getElement(btnNextpc));
		_wait(15000);
		_click(getElement(btnQuote));
		//func._waitForPageToLoad(getWebDriver(), 70L);
		_wait(15000);
		if(func._isVisible(getElement(btnIssuePolicy))==false)
		{
			_wait(15000);
		}
		
		classInvoker.ChangePremiumCaptureRunoff( tcID,  "RunOffWorksheetID", "RunOffPremium");
		_wait(20000);
		_click(getElement(btnIssuePolicy));
		//func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(15000);
		_click(getElement(btnIssueOK));
		//func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(10000);
		
		
		}else if(dataPolicyChange.getData("RunOffType").equalsIgnoreCase("Cyber")||dataPolicyChange.getData("RunOffType").equalsIgnoreCase("LPL"))
		{
			if(func._isVisible(getElement(btnClearValidtion)))
			{
			_click(getElement(btnClearValidtion));
			
			}
			func._waitForPageToLoad(getWebDriver(), 70L);
		//	_click(getElement(btnQuote));
			func._waitForPageToLoad(getWebDriver(), 70L);
			_wait(15000);
			classInvoker.ChangePremiumCaptureRunoff( tcID,  "ShortTermWorkSheetID", "ShortTermPremium");
			_wait(15000);
			_click(getElement(btnIssuePolicy));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(15000);
			_click(getElement(btnIssueOK));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(10000);
			
			//Added For R5A Optional Cove Run-Off End Addition
			
			if (dataPolicyChange.getData("AddOptionalCoverages").equalsIgnoreCase("Yes"))
			{
				classInvoker.OptionalCov(tcID);
			}
			if(func._isVisible(getElement(msgRunoffAdded)))
			{
				_click(getElement(btnClearValidtion));
				_wait(2000);
				
				_click(getElement(tabRunOffCommon));
				func._waitForPageToLoad(getWebDriver(), 50L);
				if(func._isVisible(getElement(txtRunOffPremiumValue)))
				{
				String Premium = _getAttributeValue(getElement(txtRunOffPremiumValue), "TEXT");
				
				if(Premium.equalsIgnoreCase("Null"))
				{
					_setValue(getElement(txtRunOffPremiumValue), dataPolicyChange.getData("RunOffPremium"));
					func.setValue9();
					_wait(2000);
				}
				}
				
			}else if(func._isVisible(getElement(msgRunoffRemoved)))
			{
				_click(getElement(btnClearValidtion));
				_wait(2000);
				
				_click(getElement(tabRunOffCommon));
				func._waitForPageToLoad(getWebDriver(), 50L);
				if(func._isVisible(getElement(txtRunOffPremiumValue)))
				{
				String Premium = _getAttributeValue(getElement(txtRunOffPremiumValue), "TEXT");
				
				if(Premium.equalsIgnoreCase("Null"))
				{
					_setValue(getElement(txtRunOffPremiumValue), dataPolicyChange.getData("RunOffPremium"));
					func.setValue9();
					_wait(2000);
				}
				}
				
			}
			func._waitForPageToLoad(getWebDriver(), 50L);
			
			_wait(2000);
			
			
			_wait(2000);
			_click(getElement(btnNextpc));
			_wait(5000);
			_click(getElement(btnNextpc));
			_wait(5000);
			_click(getElement(btnQuote));
			//func._waitForPageToLoad(getWebDriver(), 70L);
			_wait(15000);
			if(func._isVisible(getElement(btnIssuePolicy))==false)
			{
				_wait(15000);
			}
			
			classInvoker.ChangePremiumCaptureRunoff( tcID,  "RunOffWorksheetID", "RunOffPremium");
			_wait(15000);
			_click(getElement(btnIssuePolicy));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(15000);
			_click(getElement(btnIssueOK));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(10000);
			
		}
		}
		
		}
	
	public void PolicyChangeRunOff_1(String tcID, SoftAssert softAs) throws Exception 
	{
		_wait(4000);
		PageImplInvoker classInvoker = new PageImplInvoker();
		PageData dataPolicyChange = PageDataManager.instance().getPageData("PolicyChange", tcID);
		PageData dataUmSubDet = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		_click(getElement(btnActionsTab));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(4000);
		_click(getElement(btnPolicyChangeTab));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 _wait(4000);
			
		String eff_date_pol = dataUmSubDet.getData("EffectiveDate");
		int duedate_months=Integer.parseInt(dataPolicyChange.getData("MonthsAfterPolEffDate"));
		String Date_PolChange = func.Date_Manipulation(eff_date_pol, "MONTHS", duedate_months);
		_setValue(getElement(txtEffectiveDate), Date_PolChange);
		func.setValue9();
		_wait(4000);
		_setValue(getElement(ddChangeType), dataPolicyChange.getData("ChangeType"));
		func._waitForPageToLoad(getWebDriver(), 1000L);
		func.setValue2(getElement(ddChangeType));
		_wait(3000);
		_setValue(getElement(txtChangeDesc), dataPolicyChange.getData("ChangeDesc"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		CustomReporting.logReport(dataPolicyChange.getData("ChangeDesc"));
		
		
		int duedate_months_1=Integer.parseInt(dataPolicyChange.getData("NewExpirationDate"));
		String Date_PolExp = func.Date_Manipulation(eff_date_pol, "MONTHS", duedate_months_1);
		_setValue(getElement(txtNewExpirationDate), Date_PolExp);
		func.setValue9();
		_wait(2000);
		_setValue(getElement(txtNewExpirationDate), Date_PolExp);
		func.setValue9();
		_wait(2000);
		int duedate_months_2=Integer.parseInt(dataPolicyChange.getData("RunOffEffectiveDate"));
		String Date_RunOffExp = func.Date_Manipulation(eff_date_pol, "MONTHS", duedate_months_2);
		_setValue(getElement(txtRunoffEffectiveDate), Date_RunOffExp);
		func.setValue9();
		_wait(2000);
		_setValue(getElement(txtRunoffCommission), dataPolicyChange.getData("RunoffCommission"));
		_wait(2000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		_click(getElement(btnNext));
		_wait(5000);
		_click(getElement(btnIssuePolicy));
		_wait(10000);
		_click(getElement(btnIssueOK));
	    _wait(10000);
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
		if(func._isVisible(getElement(btnClearValidtion)))
		{
			_click(getElement(btnClearValidtion));
			_wait(2000);
		}
		_click(getElement(tabRunOffCommon));
		_wait(2000);
		if (dataPolicyChange.getData("AddOptionalCoverages").equalsIgnoreCase("Yes"))
		{
				_setValue(getElement(txtRunOffPremiumValue), dataPolicyChange.getData("RunOffPremium"));
				func.setValue9();
				_wait(2000);
				classInvoker.OptionalCov(tcID);
		}
			
			
			_wait(2000);
			_click(getElement(btnNextpc));
			_wait(5000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_click(getElement(btnNextpc));
			_wait(5000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_click(getElement(btnQuote));
			_wait(15000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if(func._isVisible(getElement(btnIssuePolicy))==false)
			{
				_wait(15000);
			}
			
			/*classInvoker.ChangePremiumCaptureRunoff( tcID,  "RunOffWorksheetID", "RunOffPremium");
			_wait(5000);*/
			_click(getElement(btnIssuePolicy));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(15000);
			_click(getElement(btnIssueOK));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(15000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			

		
		}
		

}
