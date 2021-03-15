package com.everest.escape.submission.spi;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.PageManager;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.Element.WAIT_FOR;

import com.everest.escape.submission.Payment;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class PaymentImpl extends CustomAbstractPage implements Payment{
	

	@Override
	public void Payment_page_Verification (String tcID, SoftAssert softAssert) throws Exception{
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		Payment PI = (Payment) PageManager.instance().createPage( Payment.class, getWebDriver());
		 func._waitForPageToLoad(getWebDriver(),50L);
			Thread.sleep(3000);
		if(dataIssuePolicy.getData("PaymentPlan").equals("Annual Installment"))
		{
			 func._waitForPageToLoad(getWebDriver(),50L);
			 Thread.sleep(2000);
			_click(getElement(lnk_Payment));
			
			func._waitFor(getElement(txt_BillingComments), 100, WAIT_FOR.VISIBLE, "");
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			if(!func._isEnabled(getElement(txt_Payment_AmountDue)))
			{
				 CustomReporting.logReport("","","Amount Due Text Box is displayed as disabled" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
			}
			else
			{
			 CustomReporting.logReport("","", "Amount Due Text Box is not displayed as disabled","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
				
			}
			Double polPremium=Double.parseDouble(dataIssuePolicy.getData("PolicyPremium"));
			Double Commission= 0.00;
			Double NonCommission= 0.00;
			if(!dataIssuePolicy.getData("Commission").equals(""))
			{
				Commission=Double.parseDouble(dataIssuePolicy.getData("Commission"));
			}
			if(!dataIssuePolicy.getData("NonCommissionableFee").equals(""))
			{
				NonCommission=Double.parseDouble(dataIssuePolicy.getData("NonCommissionableFee"));
			}

			Double CommAmount = (polPremium * Commission/100);
			Double ExpAmountDue = (polPremium - CommAmount) + NonCommission;
			Double ActAmountDue=Double.parseDouble(getElement(txt_Payment_AmountDue).getAttribute("value").replace(",", ""));
			//Long ActAmountDue=Long.valueOf(getElement(txt_Payment_AmountDue).getAttribute("value").replace(",", ""));
			
			if(ExpAmountDue.compareTo(ActAmountDue)==0)
			{
				 CustomReporting.logReport("","","Value displayed in Amount Due TextBox is correct payment screen" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
			}
			else
			{
			 CustomReporting.logReport("","", "Value displayed in Amount Due TextBox is not correct payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
				
			}
			String BUser=getWebDriver().findElement(By.xpath("//a[text()='Logout']/..")).getText();
			if(BUser.contains("Billing"))
			{
			
			PI.CheckPayment(tcID, softAssert);
			}
			if(BUser.contains("Cash"))
			{
				PI.CheckCashPayment(tcID, softAssert);
			}
	

		}
		if(!dataIssuePolicy.getData("PaymentPlan").equals("Annual Installment"))
		{
			if(dataIssuePolicy.getData("PaymentPlan").contains("%"))
			{
				String EqualInstal=dataIssuePolicy.getData("PaymentPlan").split("&")[1].trim().substring(0, 1);
				int TotalInstalMents=Integer.valueOf(EqualInstal)+1;
				for(int i=1;i<=TotalInstalMents;i++)
				{
					getWebDriver().findElement(By.xpath("//a[text()='" + i + "']")).click();
					func._waitFor(getElement(txt_BillingComments), 100, WAIT_FOR.VISIBLE, "");
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					String BUser=getWebDriver().findElement(By.xpath("//a[text()='Logout']/..")).getText();
					if(BUser.contains("Billing"))
					{
					
					PI.CheckPayment(tcID, softAssert);
					}
					if(BUser.contains("Cash"))
					{
						PI.CheckCashPayment(tcID, softAssert);
					}
					

				}
			}
			
		}

	}
	@Override
	public void CheckPayment (String tcID, SoftAssert softAssert) throws Exception{
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		PageData dataPayment = PageDataManager.instance().getPageData("Payment",tcID);
		
		if(!func._isEnabled(getElement(dat_Payment_DateDue)))
		{
			CustomReporting.logReport("","","Date Due Text Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Date Due Text Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		if(!func._isEnabled(getElement(DateReceived_P)))
		{
			CustomReporting.logReport("","","Date Received Partial Text Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Date Received Partial Text Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		if(!func._isEnabled(getElement(PartialAmount)))
		{
			CustomReporting.logReport("","","Partial Amount Received Text Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Partial Amount Received Text Box is displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		if(!func._isEnabled(getElement(CheckNumber)))
		{
			CustomReporting.logReport("","","Check Number Text Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Check Number Text Box is displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		if(!func._isEnabled(getElement(txt_AmountReceived)))
		{
			CustomReporting.logReport("","","Amount Received Text Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Amount Received Text Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		if(func._isReadOnly(getElement(txt_CashApplicationComments)))
		{
			CustomReporting.logReport("","","Cash Application Comments Text Box is displayed as readonly in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Cash Application Comments Text Box is not displayed as readonly in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		
		if(!func._isEnabled(getElement(chk_PaymentRevised)))
		{
			CustomReporting.logReport("","","Payment Revised Check Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Payment Revised Check Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		if(!func._isEnabled(getElement(chk_Delete)))
		{
			CustomReporting.logReport("","","Delete Check Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Delete Check Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		
		if(!func._isEnabled(getElement(chk_Direct_Billtype)))
		{
			CustomReporting.logReport("","","BillType-Direct Check Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "BillType-Direct Check Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		if(!func._isEnabled(getElement(chk_Agent_Billtype)))
		{
			CustomReporting.logReport("","","BillType-Agent Check Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "BillType-Agent Check Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		String BUser=getWebDriver().findElement(By.xpath("//a[text()='Logout']/..")).getText();
		if(BUser.contains("Billing"))
		{
			Payment objPayment = (Payment) PageManager.instance().createPage( Payment.class, getWebDriver());
			objPayment.CheckBillingEditableFields(tcID, softAssert);
			
		}
		else
		{
			
			if(!func._isEnabled(getElement(txt_PandingCancelDate)))
			{
				CustomReporting.logReport("","","Pending Cancel Date Text Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());

			}
			else
			{
				CustomReporting.logReport("","", "Pending Cancel Date Text Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			}
			if(!func._isEnabled(getElement(txt_FinalCancelDate)))
			{
				CustomReporting.logReport("","","Final Cancel Date Text Box  is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());

			}
			else
			{
				CustomReporting.logReport("","", "Final Cancel Date Text Box  is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			}
			
			if(!func._isEnabled(getElement(txt_ReinstatementDate)))
			{
				CustomReporting.logReport("","","Reinstatement Date Text Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());

			}
			else
			{
				CustomReporting.logReport("","", "Reinstatement Date Text Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			}
			if(func._isReadOnly((getElement(txt_BillingComments))))
			{
				CustomReporting.logReport("","","BillingComments Text Box is displayed as Readonly in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());

			}
			else
			{
				CustomReporting.logReport("","", "BillingComments Text Box is not displayed as Readonly in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			}
			
		}
		
		
		
		
	}
	
	@Override
	public void MakeCashPayment (String tcID, SoftAssert softAssert) throws Exception{
		WebElement elm =null;
		func._waitForPageToLoad(getWebDriver(),200L);
		Thread.sleep(3000);
		_click(getElement(lnk_Payment));
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		PageData dataPayment = PageDataManager.instance().getPageData("Payment",tcID);
		if(!dataPayment.getData("Date_Received").equals(""))
		{
			_setValue(getElement(DateReceived_P),dataPayment.getData("Date_Received"));
			elm = (WebElement) getElement(DateReceived_P).getNative();
	         elm.sendKeys(Keys.TAB);
			 func._waitForPageToLoad(getWebDriver(),50L);
		}
		else
		{
			_setValue(getElement(DateReceived_P),func.Date_Manipulation("", "Now", 0));
			elm = (WebElement) getElement(DateReceived_P).getNative();
	         elm.sendKeys(Keys.TAB);
			 func._waitForPageToLoad(getWebDriver(),50L);
		}
		_setValue(getElement(PartialAmount),dataPayment.getData("PartialAmount_Received"));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 _setValue(getElement(CheckNumber),dataPayment.getData("CheckNumber"));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 
		_click(getElement(btn_Save));
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(2000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if(func._checkAttributeValue(getElement(PaymentSuccMsg), "TEXT", "Payment information updated successfully", softAssert))
	 	{
			CustomReporting.logReport("","","Payment information updated successfully!" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());

		}
		else
		{
			CustomReporting.logReport("","", "Payment information is not updated!","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		}
	
	}
	
	
	@Override
	public void CheckCashPayment (String tcID, SoftAssert softAssert) throws Exception{
		WebElement elm =null;
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		PageData dataPayment = PageDataManager.instance().getPageData("Payment",tcID);
		
		if(!func._isEnabled(getElement(dat_Payment_DateDue)))
		{
			CustomReporting.logReport("","","Date Due Text Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Date Due Text Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		
		if(!func._isEnabled(getElement(txt_Payment_AmountDue)))
		{
			CustomReporting.logReport("","","Amount Due Text Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Amount Due Text Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		if(func._isEnabled(getElement(chk_Delete)))
		{
			CustomReporting.logReport("","","Delete Check Box is displayed as Enabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Delete Check Box is not displayed as Enabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		
		if(func._isEnabled(getElement(DateReceived_P)))
		{
			CustomReporting.logReport("","","Date Received Partial Text Box is displayed as Enable in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
			if(!dataPayment.getData("Date_Received").equals(""))
			{
				_setValue(getElement(DateReceived_P),dataPayment.getData("Date_Received"));
				elm = (WebElement) getElement(DateReceived_P).getNative();
		         elm.sendKeys(Keys.TAB);
				 func._waitForPageToLoad(getWebDriver(),50L);
			}
			else
			{
				_setValue(getElement(DateReceived_P),func.Date_Manipulation("", "Now", 0));
				elm = (WebElement) getElement(DateReceived_P).getNative();
		         elm.sendKeys(Keys.TAB);
				 func._waitForPageToLoad(getWebDriver(),50L);
			}
			
		}
		else
		{
			CustomReporting.logReport("","", "Date Received Partial Text Box is not displayed as Enabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		if(func._isEnabled(getElement(PartialAmount)))
		{
			CustomReporting.logReport("","","Partial Amount Received Text Box is displayed as Enabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
			_setValue(getElement(PartialAmount),dataPayment.getData("PartialAmount_Received"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		}
		else
		{
			CustomReporting.logReport("","", "Partial Amount Received Text Box is not displayed as Enabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		if(func._isEnabled(getElement(CheckNumber)))
		{
			CustomReporting.logReport("","","Check Number Text Box is displayed as Enabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
			_setValue(getElement(CheckNumber),dataPayment.getData("CheckNumber"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		}
		else
		{
			CustomReporting.logReport("","", "Check Number Text Box is not displayed as Enabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		
		if(!func._isEnabled(getElement(txt_DateReceived)))
		{
			CustomReporting.logReport("","","Date Received Text Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Date Received Text Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		if(!func._isEnabled(getElement(txt_AmountReceived)))
		{
			CustomReporting.logReport("","","Amount Received Text Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Amount Received Text Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		if(!func._isReadOnly(getElement(txt_CashApplicationComments)))
		{
			CustomReporting.logReport("","","Cash Application Comments Text Box is displayed as editable in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
			_setValue(getElement(txt_CashApplicationComments),dataPayment.getData("CashComments"));
		}
		else
		{
			CustomReporting.logReport("","", "Cash Application Comments Text Box is not displayed as editable in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		
		if(!func._isEnabled(getElement(chk_PaymentRevised)))
		{
			CustomReporting.logReport("","","Payment Revised Check Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Payment Revised Check Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		
		
		if(!func._isEnabled(getElement(chk_Direct_Billtype)))
		{
			CustomReporting.logReport("","","BillType-Direct Check Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "BillType-Direct Check Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		if(!func._isEnabled(getElement(chk_Agent_Billtype)))
		{
			CustomReporting.logReport("","","BillType-Agent Check Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "BillType-Agent Check Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		/*String BUser=getWebDriver().findElement(By.xpath("//a[text()='Logout']/..")).getText();
		 if(BUser.contains("Billing"))
		{
			Payment objPayment = (Payment) PageManager.instance().createPage( Payment.class, getWebDriver());
			objPayment.CheckBillingEditableFields(tcID, softAssert);
			
		}
		else
		{*/
			
			if(!func._isEnabled(getElement(txt_PandingCancelDate)))
			{
				CustomReporting.logReport("","","Pending Cancel Date Text Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());

			}
			else
			{
				CustomReporting.logReport("","", "Pending Cancel Date Text Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			}
			if(!func._isEnabled(getElement(txt_FinalCancelDate)))
			{
				CustomReporting.logReport("","","Final Cancel Date Text Box  is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());

			}
			else
			{
				CustomReporting.logReport("","", "Final Cancel Date Text Box  is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			}
			
			if(!func._isEnabled(getElement(txt_ReinstatementDate)))
			{
				CustomReporting.logReport("","","Reinstatement Date Text Box is displayed as disabled in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());

			}
			else
			{
				CustomReporting.logReport("","", "Reinstatement Date Text Box is not displayed as disabled in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			}
			if(func._isReadOnly((getElement(txt_BillingComments))))
			{
				CustomReporting.logReport("","","BillingComments Text Box is displayed as Readonly in Payment screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());

			}
			else
			{
				CustomReporting.logReport("","", "BillingComments Text Box is not displayed as Readonly in Payment screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			}
		
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			Thread.sleep(2000);
			_click(getElement(btn_Save));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 Thread.sleep(2000);
			 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if(func._checkAttributeValue(getElement(PaymentSuccMsg), "TEXT", "Payment information updated successfully", softAssert))
		 	{
				CustomReporting.logReport("","","Payment information updated successfully!" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());

			}
			else
			{
				CustomReporting.logReport("","", "Payment information is not updated!","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			}
		
		
	}
	
	
	@Override
	public void CheckBillingEditableFields (String tcID, SoftAssert softAssert) throws Exception{
		WebElement elm =null;
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		PageData dataPayment = PageDataManager.instance().getPageData("Payment",tcID);
		
		if(!func._isEnabled(getElement(txt_PandingCancelDate)))
		{
			CustomReporting.logReport("","", "Pending Cancel Date Text Box is displayed as disabled in Payment screen before billing user enter data and saved","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			
		}
		else
		{
			if(!dataPayment.getData("PendingCancelDate").equals(""))
			{
			 _setValue(getElement(txt_PandingCancelDate),dataPayment.getData("PendingCancelDate"));
			 elm = (WebElement) getElement(txt_PandingCancelDate).getNative();
	         elm.sendKeys(Keys.TAB);
			 func._waitForPageToLoad(getWebDriver(),50L);
			}
			else
			{
				 _setValue(getElement(txt_PandingCancelDate),func.Date_Manipulation("", "Now", 0));
				 elm = (WebElement) getElement(txt_PandingCancelDate).getNative();
		         elm.sendKeys(Keys.TAB);
				 func._waitForPageToLoad(getWebDriver(),50L);
			}
					
			
		}
		if(!func._isEnabled(getElement(txt_FinalCancelDate)))
		{
			CustomReporting.logReport("","", "Final Cancel Date Text Box is displayed as disabled in Payment screen before billing user enter data and saved","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null); 
		}
		else
		{
			if(!dataPayment.getData("FinalCancelDate").equals(""))
			{
			 _setValue(getElement(txt_FinalCancelDate),dataPayment.getData("FinalCancelDate"));
			 elm = (WebElement) getElement(txt_FinalCancelDate).getNative();
	         elm.sendKeys(Keys.TAB);
			 func._waitForPageToLoad(getWebDriver(),50L);
			}
			else
			{
				 _setValue(getElement(txt_FinalCancelDate),func.Date_Manipulation("", "Now", 0));
				 elm = (WebElement) getElement(txt_FinalCancelDate).getNative();
		         elm.sendKeys(Keys.TAB);
				 func._waitForPageToLoad(getWebDriver(),50L);
			}
			
							
			
		}
		if(!func._isEnabled(getElement(txt_ReinstatementDate)))
		{
			CustomReporting.logReport("","", "Reinstatement Date Text Box is  displayed as disabled in Payment screen before billing user enter data and saved","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null); 
		}
		else
		{
			if(!dataPayment.getData("ReinstatementDate").equals(""))
			{
			 _setValue(getElement(txt_ReinstatementDate),dataPayment.getData("ReinstatementDate"));
			 elm = (WebElement) getElement(txt_ReinstatementDate).getNative();
	         elm.sendKeys(Keys.TAB);
			 func._waitForPageToLoad(getWebDriver(),50L);
			}
			else
			{
				 _setValue(getElement(txt_ReinstatementDate),func.Date_Manipulation("", "Now", 0));
				 elm = (WebElement) getElement(txt_ReinstatementDate).getNative();
		         elm.sendKeys(Keys.TAB);
				 func._waitForPageToLoad(getWebDriver(),50L);
			}
			
		}
		if(func._isReadOnly((getElement(txt_BillingComments))))
		{
			CustomReporting.logReport("","", "BillingComments Text Box is displayed as ReadOnly in Payment screen before billing user enter data and saved","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null); 
		}
		else
		{
			 _setValue(getElement(txt_BillingComments),dataPayment.getData("BillingComments"));
			 func._waitForPageToLoad(getWebDriver(),50L);	
			
		}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(btn_Save));	
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(3000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		if(func._checkAttributeValue(getElement(PaymentSuccMsg), "TEXT", "Payment information updated successfully", softAssert))
		{
			CustomReporting.logReport("","","Payment information is updated successfully" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
		}
		else
		{
			CustomReporting.logReport("","", "Payment information updated failed!","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		}
		if(!func._isEnabled(getElement(txt_PandingCancelDate)))
		{
			CustomReporting.logReport("","", "Pending Cancel Date Text Box is displayed as disabled in Payment screen after billing user enter data and  saved","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			
		}
		if(!func._isEnabled(getElement(txt_FinalCancelDate)))
		{
			CustomReporting.logReport("","", "Final Cancel Date Text Box is displayed as disabled in Payment screen after Billing user enter data and click saved","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null); 
		}
		if(!func._isEnabled(getElement(txt_ReinstatementDate)))
		{
			CustomReporting.logReport("","", "Reinstatement Date Text Box is  displayed as disabled in Payment screen after Billing user enter data and clicked saved","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null); 
		}
		
		if(func._isReadOnly((getElement(txt_BillingComments))))
		{
			CustomReporting.logReport("","", "BillingComments Text Box is displayed as ReadOnly in Payment screen after Billing user enter data and clicked saved","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null); 
		}
		
	}
	
	
}
