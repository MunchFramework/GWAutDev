package com.everest.page.application.spi;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.RewritePage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class RewritePageImpl extends CustomAbstractPage implements RewritePage{
	@SuppressWarnings("static-access")
	@Override
	public void Rewrite(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataRewrite = PageDataManager.instance().getPageData("Rewrite", tcID);
		PageData dataSubDet = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		String CanceledPolicyNo = _getAttributeValue(getElement(lblCanceledPolicy), "TEXT");
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		_click(getElement(btnActionsTab));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(5000);
		_click(getElement(btnRewriteFullTerm));
		func._waitForPageToLoad(getWebDriver(), 50L);
		  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if (func._isVisible(getElement(btnIssueOK)) == true)
		{
			_wait(2000);
			_click(getElement(btnIssueOK));
		}
		  
		  if(dataRewrite.getData("PolicyChange").equalsIgnoreCase("Yes")) 
		  { 
			  
			if (dataRewrite.getData("Change Subline").equalsIgnoreCase("Yes"))
			{
				_wait(3000);
				_click(getElement(txtSubline));
				_wait(3000);
				String expoption1 = "//*[contains(text(),\"" + dataRewrite.getData("SubLine") + "\")]";
				WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
				expectedOption1.click();
				  
			  }
			if(dataRewrite.getData("Change Surety Type").equalsIgnoreCase("Yes")) 
			{
				  _click(getElement(lblCoverageSelection)); 
				  _wait(4000); 
				  _click(getElement(btnCoverageSelectionNext));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(1000);
					_click(getElement(txtSURType));
					_wait(1000);
					_setValue(getElement(txtSURType), dataRewrite.getData("SURType"));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(5000);
					func.setValue3(getElement(txtSURType));
					_wait(5000);
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(1000);
					_click(getElement(txtBondType));
					_wait(2000);
					String expoption1 = "//*[contains(text(),\"" + dataRewrite.getData("BondType") + "\")]";
					WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
					expectedOption1.click();
//					_setValue(getElement(txtBondType), dataRewrite.getData("BondType"));
//					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(5000);
					func.setValue3(getElement(txtBondType));
					_wait(5000);
					_wait(1000);
					_click(getElement(btnSAACodeSearch));
					_wait(5000);
					_setValue(getElement(txtSAACode), dataRewrite.getData("SAA Code"));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(5000);
					_click(getElement(btnSearch));
					_wait(5000);
					_click(getElement(btnSelect));
					_wait(5000);
//					func.setValue3(getElement(txtSAACode));
					_wait(5000);
			  }
			   if(dataRewrite.getData("Change Writing Approach").equalsIgnoreCase("Yes"))
			   {
				  _click(getElement(lblCoverageSelection)); 
				  _wait(4000); 
				  _click(getElement(btnCoverageSelectionNext));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(1000);
					_click(getElement(txtWritingApproach));
					_wait(1000);
					_setValue(getElement(txtWritingApproach), dataRewrite.getData("WritingApproach"));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(5000);
					func.setValue3(getElement(txtWritingApproach));
					_wait(5000);
			  }
			  if(dataRewrite.getData("Change Producer").equalsIgnoreCase("Yes"))
			  {
				  _click(getElement(lblCoverageSelection)); 
				  _wait(4000); 
				  _click(getElement(btnCoverageSelectionNext));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(1000);
					_click(getElement(txtOrganization));
					_wait(1000);
					_setValue(getElement(txtOrganization), dataRewrite.getData("Organization"));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(5000);
					func.setValue3(getElement(txtOrganization));
					_wait(5000);
					_click(getElement(txtProducerCode));
					_wait(1000);
					_setValue(getElement(txtProducerCode), dataRewrite.getData("ProducerCode"));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(3000);
					func.setValue3(getElement(txtProducerCode));
					_wait(5000);
					_click(getElement(txtProducerContact));
					_wait(1000);
					_setValue(getElement(txtProducerContact), dataRewrite.getData("ProducerContact"));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(1000);
					func.setValue2(getElement(txtProducerContact));
					_clickTab();
					_wait(3000);
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					  _click(getElement(txtBindingContact));
						_wait(1000);
					  _setValue(getElement(txtBindingContact), dataRewrite.getData("BindingContact"));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(1000);
					func.setValue2(getElement(txtBindingContact));

					_clickTab();
					_wait(2000);
//					_click(getElement(btnPolicyInfoNext));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(3000);

			  }
			 if(dataRewrite.getData("ChangeDepartment").equalsIgnoreCase("Yes")) 
			 {
				  _click(getElement(lblCoverageSelection)); 
				  _wait(4000);
				  _wait(2000);
					_click(getElement(btnCoverageSelectionNext));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(4000);
				  _wait(5000);
					_click(getElement(txtDepartment));
					_wait(1000);
					_setValue(getElement(txtDepartment), dataRewrite.getData("Department"));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(3000);
					func.setValue3(getElement(txtDepartment));
					_wait(5000); 
					_click(getElement(txtUnderwriter));
					_wait(1000);
					_setValue(getElement(txtUnderwriter), dataRewrite.getData("Underwriter"));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(3000);
					_click(getElement(txtUnderwriterAssistant));
					_wait(1000);
					_setValue(getElement(txtUnderwriterAssistant), dataRewrite.getData("UnderwriterAssistant"));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(3000);
					func.setValue3(getElement(txtUnderwriterAssistant));
					_wait(5000); 
			  }
			 if(dataRewrite.getData("ChangeUWUWA").equalsIgnoreCase("Yes")) 
			 {
				  _click(getElement(lblCoverageSelection)); 
				  _wait(4000);
				  _wait(2000);
					_click(getElement(btnCoverageSelectionNext));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(4000);
					_click(getElement(txtUnderwriter));
					_wait(1000);
					_setValue(getElement(txtUnderwriter), dataRewrite.getData("Underwriter"));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(3000);
					func.setValue3(getElement(txtUnderwriter));
					_wait(5000); 
					
					_click(getElement(txtUnderwriterAssistant));
					_wait(1000);
					_setValue(getElement(txtUnderwriterAssistant), dataRewrite.getData("UnderwriterAssistant"));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(3000);
					func.setValue3(getElement(txtUnderwriterAssistant));
					_wait(5000); 
			  }
			  if(dataRewrite.getData("ChangeCommission").equalsIgnoreCase("Yes"))
			  {
				  _click(getElement(lblCoverageSelection)); 
				  _wait(4000);
				  _wait(2000);
					_click(getElement(btnCoverageSelectionNext));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(4000);
					_click(getElement(txtUnderwritingFees));
					_wait(1000);
					_setValue(getElement(txtUnderwritingFees), dataRewrite.getData("UnderwritingFees"));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(3000);
					func.setValue3(getElement(txtUnderwritingFees));
					_wait(5000); 
					
					_click(getElement(txtCommission));
					_wait(1000);
					_setValue(getElement(txtCommission), dataRewrite.getData("Commission"));
					func._waitForPageToLoad(getWebDriver(), 50L);
					_wait(3000);
					func.setValue3(getElement(txtCommission));
					_wait(5000); 
			  }
			 if(dataRewrite.getData("ChangePolicyTerm").equalsIgnoreCase("Yes")) {
				_wait(4000);

				_setValue(getElement(txtExpDate), dataRewrite.getData("ExpirationDate"));
				_wait(4000);
				func._waitForPageToLoad(getWebDriver(), 50L);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

				_click(getElement(btnPolicyInfoNext));
				func._waitForPageToLoad(getWebDriver(), 50L);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				  
			  }
			 
			 if(dataRewrite.getData("SelectMPLHazardGroup").equalsIgnoreCase("Yes")) 
			  {
				  _click(getElement(ExposuresLink));
				  _wait(4000);
				  _setValue(getElement(HazGroup), dataRewrite.getData("MPLHazardGroup"));
				  _wait(4000);
				func._waitForPageToLoad(getWebDriver(), 50L);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

				_click(getElement(btnPolicyInfoNext));
				func._waitForPageToLoad(getWebDriver(), 50L);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					  
			}
			 
			 if(dataRewrite.getData("Add/Delete/Modify Coverages").equalsIgnoreCase("Yes"))
			 {
				 
				  PageImplInvoker classInvoker = new PageImplInvoker();
					classInvoker.PolicyCoverageChange(tcID);
			  }
			 
//			  else {
//				_wait(2000);
//				_click(getElement(btnCoverageSelectionNext));
//				func._waitForPageToLoad(getWebDriver(), 50L);
//				_wait(4000);
//
//				_setValue(getElement(txtExpDate), dataRewrite.getData("ExpirationDate"));
//				_wait(4000);
//				func._waitForPageToLoad(getWebDriver(), 50L);
//				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
//
//				_click(getElement(btnPolicyInfoNext));
//				func._waitForPageToLoad(getWebDriver(), 50L);
//				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
//  
//			  }
//			  
			  
		  }
		  else {
				_wait(2000);
				_click(getElement(btnCoverageSelectionNext));
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(4000);
				
				
				String eff_date_pol = dataSubDet.getData("EffectiveDate");
				int duedate_months=Integer.parseInt(dataRewrite.getData("MonthsAfterPolEffDate"));
				String Date_Rewrite = func.Date_Manipulation(eff_date_pol, "MONTHS", duedate_months);
				_setValue(getElement(txtExpDate), Date_Rewrite);
				
			//_setValue(getElement(txtExpDate), dataRewrite.getData("ExpirationDate"));
			_wait(5000);
			func._waitForPageToLoad(getWebDriver(), 50L);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			  _click(getElement(btnPolicyInfoNext));
			  _wait(4000);
				func._waitForPageToLoad(getWebDriver(), 50L);
				  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			  
		  }
		  
		  
		  
		_wait(10000);
		_click(getElement(btnQuote));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(20000);
		
		if (func._isVisible(getElement(btnIssuePolicy)) == false)
		{
			_wait(20000);
			
		}
		if(dataRewrite.getData("PremiumChange").equalsIgnoreCase("Yes")) {
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
				 // DecimalFormat df2 = new DecimalFormat("#.##");
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
						CvgField.sendKeys(LastPrem);
						_wait(2000);
						func.setValue9();
					}
					else
					{	
					int n = i+1;
					String Cvgs = "(//*[contains(text(),'Premium Breakdown')]/../../..//input)[" + n + "]";
					WebElement CvgField = getWebDriver().findElement(By.xpath(Cvgs));
					CvgField.sendKeys(CvgPremium);
					_wait(2000);
					func.setValue9();
					}
				}
				_wait(4000);
			
		}
		if (tcID.equalsIgnoreCase("DS_R3B_SIT_E2E_SC10_PriComSurety"))
		{
			_wait(4000);
			_click(getElement(lblPayment));
			_wait(4000);
			_click(getElement(chkQuarterly));
			
		}
		func._waitForPageToLoad(getWebDriver(), 50L);
		_click(getElement(btnIssuePolicy));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(4000);
		_click(getElement(btnIssueOK));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(15000);
		
		if (func._isVisible(getElement(lnkViewPolicy)) == false)
		{
			_wait(20000);
			
		}
		func._waitForPageToLoad(getWebDriver(), 50L);
		_click(getElement(lnkViewPolicy));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		String RewritePolicyNo = _getAttributeValue(getElement(lblRewritePolicy), "TEXT");
		if(CanceledPolicyNo.equals(RewritePolicyNo))
        {
            
                 CustomReporting.logReport("","","Policy Number Matches " ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
                 
        }
        else
            
        {
                 CustomReporting.logReport("","","Policy Numbers are different " ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
                 
        }


		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(2000);

		
}

	private void If(boolean equals) {
		// TODO Auto-generated method stub
		
	}
}
