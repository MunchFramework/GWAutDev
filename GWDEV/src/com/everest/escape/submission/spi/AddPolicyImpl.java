package com.everest.escape.submission.spi;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import org.xframium.device.DeviceManager;
import org.xframium.page.PageManager;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.Element.WAIT_FOR;

import com.everest.escape.submission.AddPolicy;
import com.everest.escape.submission.Search;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class AddPolicyImpl extends CustomAbstractPage implements AddPolicy 
{
	
	@Override
	public void IssueNewPolicy (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		
		 PageData dataNewSubmission =null;
		PageData dataLogin = PageDataManager.instance().getPageData("EscapeLogin",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
		 }
		
		 
		
		String cmd = "REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\New Windows\" /F /V \"PopupMgr\" /T REG_SZ /D \"no\"";
	    try {
	        Runtime.getRuntime().exec(cmd);
	    } catch (Exception e) {
	        System.out.println("Error ocured!");
	    }
	    if(dataIssuePolicy.getData("ManualPolicy").equalsIgnoreCase("Yes"))
	    {
	    	
	    	String PolNum="ES9100"+func.generate_RandomNumber(4);
	    	 Thread.sleep(2000);
	    	 _setValue(getElement(getPolicyNumber),PolNum);
	    	 Thread.sleep(2000);
	    	 _setValue(getElement(getPolicyMod),"201");
	    	 
	    	
	    }
	 
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    if(!dataIssuePolicy.getData("PolicyEffectiveDate").equals(""))
		 {
		 _setValue(getElement(dat_PolicyEffectiveDate),dataIssuePolicy.getData("PolicyEffectiveDate"));
		 WebElement elm = (WebElement) getElement(dat_PolicyEffectiveDate).getNative();
         elm.sendKeys(Keys.TAB);
		 func._waitForPageToLoad(getWebDriver(),200L);
		 }
		 else
		 {
			 
				 _setValue(getElement(dat_PolicyEffectiveDate),func.Date_Manipulation("", "Now", 0));
				 WebElement elm = (WebElement) getElement(dat_PolicyEffectiveDate).getNative();
		         elm.sendKeys(Keys.TAB);
				 func._waitForPageToLoad(getWebDriver(),200L);
				 
		 }
		 if(!dataIssuePolicy.getData("PolicyExpirationDate").equals(""))
		{
			 Thread.sleep(3000);
			 int offset= Integer.valueOf(dataIssuePolicy.getData("PolicyExpirationDate").split("-")[0].trim());
		    	String OptValue=dataIssuePolicy.getData("PolicyExpirationDate").split("-")[1].trim();
		    	Thread.sleep(2000);
			_setValue(getElement(dat_PolicyExpirationDate),func.Date_Manipulation("",OptValue, offset));
			WebElement elm = (WebElement) getElement(dat_PolicyExpirationDate).getNative();
	        elm.sendKeys(Keys.TAB);
			func._waitForPageToLoad(getWebDriver(),150L);
			Thread.sleep(2000);
		}
		 Thread.sleep(3000);
		 if(!dataIssuePolicy.getData("DateBound").equals(""))
		 {
		 _setValue(getElement(dat_DateBound),dataIssuePolicy.getData("DateBound"));
			WebElement elm = (WebElement) getElement(dat_DateBound).getNative();
	         elm.sendKeys(Keys.TAB);
	         func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 else
		 {
			 
				 _setValue(getElement(dat_DateBound),func.Date_Manipulation("", "Now", 0));
				 WebElement elm = (WebElement) getElement(dat_DateBound).getNative();
		         elm.sendKeys(Keys.TAB);
				 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 _setValue(getElement(lst_PolicyStatus),dataIssuePolicy.getData("PolicyStatus"));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		 if(!dataIssuePolicy.getData("CancelledReasonCode").equals(""))
		 {
			 _setValue(getElement(lst_CancelledReasonCode),dataIssuePolicy.getData("CancelledReasonCode"));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 if(dataIssuePolicy.getData("CancelledReasonCode").equals("Other Reason(s)"))
			 {
				 _setValue(getElement(txt_ExplainCancelledReason),dataIssuePolicy.getData("ExplainCancelledReason"));
				 func._waitForPageToLoad(getWebDriver(),50L);
				 
			 }
		 }
		 if(!dataIssuePolicy.getData("BoundLineBusiness").equals(""))
		 	{
			 _setValue(getElement(lst_BoundLineBusiness),dataIssuePolicy.getData("BoundLineBusiness"));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 /*if(dataIssuePolicy.getData("BoundLineBusiness").equals("Package")||dataIssuePolicy.getData("BoundLineBusiness").equals("Blend"))
			 {
				 _click(getElement(btn_Policy_Close));
				 
			 }*/
		 }
		 

		 if(!dataIssuePolicy.getData("PolicyPremium").equals(""))
		 {
		Thread.sleep(3000);
		 _setValue(getElement(txt_PolicyPremium),dataIssuePolicy.getData("PolicyPremium"));
		 func._waitForPageToLoad(getWebDriver(),50L);
		
		 }
		 if(!dataIssuePolicy.getData("PropertyPolicyType").equals("")&&dataNewSubmission.getData("BusinessSegment").trim().equals("Wholesale Property"))
		 {
			 _setValue(getElement(lst_PropertyPolicyType),dataIssuePolicy.getData("PropertyPolicyType"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 Thread.sleep(2000);
		 if(dataIssuePolicy.getData("MultiStatePolicy").toLowerCase().contains("yes"))
		 {
			 _click(getElement(red_MultiStatePolicy_Yes));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 Thread.sleep(3000);
			 if(!func._isChecked(getElement(red_MultiStatePolicy_Yes)))
			 {
				 _click(getElement(red_MultiStatePolicy_Yes));
				 func._waitForPageToLoad(getWebDriver(),50L);
				 
			 }
		 }
		 Thread.sleep(3000);
		 
		 if(dataIssuePolicy.getData("MultiStatePolicy").toLowerCase().contains("no"))
		 {
			 _click(getElement(red_MultiStatePolicy_No));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 if(!func._isChecked(getElement(red_MultiStatePolicy_No)))
			 {
				 _click(getElement(red_MultiStatePolicy_No));
				 func._waitForPageToLoad(getWebDriver(),50L);
				 
			 }
		 }
		 if(dataNewSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataNewSubmission.getData("BusinessSegment").contains("Professional Liability")) 
		 {
			 
			 if(!dataIssuePolicy.getData("Limit").equals(""))
			 {
				 _setValue(getElement(txt_PolicyLimit),dataIssuePolicy.getData("Limit"));
				 func._waitForPageToLoad(getWebDriver(),50L);
			 } 
			 if(!dataIssuePolicy.getData("RetentionAttachment").equals(""))
			 {
				 _setValue(getElement(txt_PolRetentionAttachment),dataIssuePolicy.getData("RetentionAttachment"));
				 func._waitForPageToLoad(getWebDriver(),50L);
			 }
			 
			 if(dataIssuePolicy.getData("PrimaryORExcess").trim().toLowerCase().equals("primary"))
			 {
				 _click(getElement(radio_QuotedPrimary));
				 func._waitForPageToLoad(getWebDriver(),50L);
			 }
			 if(dataIssuePolicy.getData("PrimaryORExcess").trim().toLowerCase().equals("excess"))
			 {
				 _click(getElement(radio_QuotedPrimary));
				 func._waitForPageToLoad(getWebDriver(),50L);
			 }
			 
			/* if(dataIssuePolicy.getData("PolPublicPrivate").trim().toLowerCase().equals("public"))
			 {
				 _click(getElement(chk_PolPublic));
				 func._waitForPageToLoad(getWebDriver(),50L);
			 }
			 if(dataIssuePolicy.getData("PolPublicPrivate").trim().toLowerCase().equals("private"))
			 {
				 _click(getElement(chk_Pravite));
				 func._waitForPageToLoad(getWebDriver(),50L);
			 }
			 */
			 if(!dataIssuePolicy.getData("BoundProduct").equals(""))
			 {
				 _setValue(getElement(lst_BoundProduct),dataIssuePolicy.getData("BoundProduct"));
				 func._waitForPageToLoad(getWebDriver(),50L);
			 }
			 
			 if(dataIssuePolicy.getData("isCompanyPortfolio").trim().toLowerCase().equals("yes"))
			 {
				 _click(getElement(red_Portfolio_Yes));
				 func._waitForPageToLoad(getWebDriver(),50L);
			 }
			 if(dataIssuePolicy.getData("isCompanyPortfolio").trim().toLowerCase().equals("no"))
			 {
				 _click(getElement(red_Portfolio_No));
				 func._waitForPageToLoad(getWebDriver(),50L);
			 }
			 
 
		 }
		 
		 Thread.sleep(2000);
		 if(!dataIssuePolicy.getData("Commission").equals(""))
		 {
			 _setValue(getElement(txt_Commission),dataIssuePolicy.getData("Commission"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 
		 if(!dataIssuePolicy.getData("NonCommissionableFee").equals(""))
		 {
			 _setValue(getElement(txt_NonCommissionableFee),dataIssuePolicy.getData("NonCommissionableFee"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 
		 if(!dataIssuePolicy.getData("NonCommissionableFee").equals(""))
		 {
			 _setValue(getElement(txt_NonCommissionableFee),dataIssuePolicy.getData("NonCommissionableFee"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 if(func._getAttributeValue(getElement(lst_BoundLineBusiness), "TEXT", softAssert).equals("Workers Comp"))
		 {
			 _setValue(getElement(txt_ScheduleRatingMod),dataIssuePolicy.getData("ScheduleRatingMod"));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 _setValue(getElement(txt_ExperienceMod),dataIssuePolicy.getData("ExperienceMod"));
			 func._waitForPageToLoad(getWebDriver(),50L);

		 }
		 
		 if(func._getAttributeValue(getElement(lst_TPA), "TEXT", softAssert).equals("make selection"))
		 //if(!dataIssuePolicy.getData("TPA").equals(""))
		 {
			 _setValue(getElement(lst_TPA),dataIssuePolicy.getData("TPA"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 
		
			 if(!dataIssuePolicy.getData("UnbundleIndicator").equals(""))
			 {
				 if(dataIssuePolicy.getData("UnbundleIndicator").equalsIgnoreCase("Yes"))
				 {
					 _click(getElement(chk_Unbundling));
					Thread.sleep(2000);
				 }
				 
			 }
		 
		 
		  
		 if(dataNewSubmission.getData("BusinessSegment").trim().toLowerCase().contains("environmental"))
		 {
			 if(dataIssuePolicy.getData("PremiumAudit").trim().toLowerCase().contains("yes"))
			 {
				 _click(getElement(rb_PremiumAuditInd_Yes));
				 func._waitForPageToLoad(getWebDriver(),50L);
			 }
			 if(dataIssuePolicy.getData("PremiumAudit").trim().toLowerCase().contains("no"))
			 {
				 _click(getElement(rb_PremiumAuditInd_No));
				 func._waitForPageToLoad(getWebDriver(),50L);
			 }
		 }
		 
		 
		 if(!dataIssuePolicy.getData("ProductCode").equals(""))
		 {
			 Thread.sleep(2000);
			 			
			_setValue(getElement(lst_ProductCode),dataIssuePolicy.getData("ProductCode"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 if(!dataIssuePolicy.getData("EverestCompany").equals(""))
		 {
			 Thread.sleep(2000);
			 			
			//_setValue(getElement(lst_EverestCompany),dataIssuePolicy.getData("EverestCompany"));
			 func._waitForPageToLoad(getWebDriver(),200L);
			 Thread.sleep(2000);
		 }
		 func._waitForPageToLoad(getWebDriver(),200L);
		 Thread.sleep(2000);
		 if(!dataIssuePolicy.getData("BillType").equals(""))
		 {
			 Thread.sleep(3000);
			 _setValue(getElement(lst_BillType),dataIssuePolicy.getData("BillType"));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 Thread.sleep(3000);
		 }
		 if(!dataIssuePolicy.getData("CancelState").equals(""))
		 {
			
			 
		 _setValue(getElement(lst_CancelState),dataIssuePolicy.getData("CancelState"));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 
		 if(dataIssuePolicy.getData("FRPurchased").trim().toLowerCase().equals("on"))
		 {
			Thread.sleep(3000);
			 _click(getElement(chk_Policy_FRPurchased)); 
		
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 if(dataIssuePolicy.getData("InstallmentFees").trim().toLowerCase().equals("on"))
		 {
			 Thread.sleep(3000);
			 _click(getElement(chk_InstallmentFees)); 
		
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 
		 
		 if(!dataIssuePolicy.getData("PaymentPlan").equals(""))
		 {
			 func._waitForPageToLoad(getWebDriver(),500L);
			 Thread.sleep(10000);
			 _setValue(getElement(lst_PaymentPlan),dataIssuePolicy.getData("PaymentPlan"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 if(!dataIssuePolicy.getData("DatePolicyIssued").equals(""))
		 {
			 _setValue(getElement(dat_DatePolicyIssued),dataIssuePolicy.getData("DatePolicyIssued"));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 WebElement elm = (WebElement) getElement(dat_DatePolicyIssued).getNative();
	         elm.sendKeys(Keys.TAB);
		 }
		 else
		 {
			 _setValue(getElement(dat_DatePolicyIssued),func.Date_Manipulation("", "Now", 0));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 WebElement elm = (WebElement) getElement(dat_DatePolicyIssued).getNative();
	         elm.sendKeys(Keys.TAB);
		 }
		 if(!dataIssuePolicy.getData("PremiumFinanced").equals(""))
		 {
			 if(dataIssuePolicy.getData("PremiumFinanced").trim().toLowerCase().equals("on"))
			 {
				 _click(getElement(chk_PremiumFinanced)); 
				 func._waitForPageToLoad(getWebDriver(),150L);
				 Thread.sleep(3000);
				 _setValue(getElement(txt_FinanceCompanyName),dataIssuePolicy.getData("CompanyName"));
				 _setValue(getElement(txt_FinanceCompanyAddress1),dataIssuePolicy.getData("Address1"));
				 _setValue(getElement(txt_FinanceCompanyAddress2),dataIssuePolicy.getData("Address2"));
				 _setValue(getElement(txt_FinanceCompanyAddress3),dataIssuePolicy.getData("Address3"));
				 _setValue(getElement(txt_FinanceCompanyCity),dataIssuePolicy.getData("City"));
				 _setValue(getElement(txt_FinanceCompanyState),dataIssuePolicy.getData("State"));
				 func._waitForPageToLoad(getWebDriver(),150L);
				 Thread.sleep(2000);
				 _setValue(getElement(txt_FinanceCompanyZip1),dataIssuePolicy.getData("ZIP1"));
				 _setValue(getElement(txt_FinanceCompanyZip2),dataIssuePolicy.getData("ZIP2"));
				 _setValue(getElement(txt_FinanceCompanyContact),dataIssuePolicy.getData("Contact"));
				 
		
			 }
			
			 
		 }
		 if(!dataIssuePolicy.getData("RenewalStatus").equals(""))
		 {
			 _setValue(getElement(lst_RenewalStatus),dataIssuePolicy.getData("RenewalStatus"));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 if(dataIssuePolicy.getData("RenewalStatus").equals("Not Available")||dataIssuePolicy.getData("RenewalStatus").equals("Non-Renewed")
					 ||dataIssuePolicy.getData("RenewalStatus").equals("Renewal Lost"))
			 {
				 _setValue(getElement(lst_RenewalStatusCode),dataIssuePolicy.getData("RenewalStatusCode"));
				 				 
				 func._waitForPageToLoad(getWebDriver(),50L);
			 }
		 }
		 
		 if(!dataIssuePolicy.getData("DateBound").equals(""))
		 {
		 _setValue(getElement(dat_DateBound),dataIssuePolicy.getData("DateBound"));
			WebElement elm = (WebElement) getElement(dat_DateBound).getNative();
	         elm.sendKeys(Keys.TAB);
	         func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 else
		 {
			 
				 _setValue(getElement(dat_DateBound),func.Date_Manipulation("", "Now", 0));
				 WebElement elm = (WebElement) getElement(dat_DateBound).getNative();
		         elm.sendKeys(Keys.TAB);
				 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 //Robot robot = new Robot();
         //robot.keyPress(KeyEvent.VK_TAB);
         //robot.keyRelease(KeyEvent.VK_TAB);
		 //Thread.sleep(3000);
		 //((JavascriptExecutor)getWebDriver()).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		/* if(!dataIssuePolicy.getData("PolicyExpirationDate").equals(""))
			{
				 Thread.sleep(3000);
				 int offset= Integer.valueOf(dataIssuePolicy.getData("PolicyExpirationDate").split("-")[0].trim());
			    	String OptValue=dataIssuePolicy.getData("PolicyExpirationDate").split("-")[1].trim();
			    	Thread.sleep(2000);
				_setValue(getElement(dat_PolicyExpirationDate),func.Date_Manipulation("",OptValue, offset));
				WebElement elm = (WebElement) getElement(dat_PolicyExpirationDate).getNative();
		        elm.sendKeys(Keys.TAB);
				func._waitForPageToLoad(getWebDriver(),150L);
				Thread.sleep(2000);
			}*/
		 
		 Thread.sleep(3000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 if(!dataIssuePolicy.getData("ManualPolicy").equalsIgnoreCase("Yes"))
		    {
			 _click(getElement(btn_IssuePolicyNumber));
			 func._waitForPageToLoad(getWebDriver(), 200L);
			 	// func._waitFor(getElement(btn_confirmPoliceissue1), 60, WAIT_FOR.CLICKABLE, "");
			 Thread.sleep(5000);
			 func._waitFor(getElement(btn_confirmPoliceissue1), 60, WAIT_FOR.CLICKABLE, "");
			 Thread.sleep(3000);
			 _click(getElement(btn_confirmPoliceissue1));
			 func._waitForPageToLoad(getWebDriver(),150L);
			 Thread.sleep(3000);
			 func._waitFor(getElement(btn_confirmPoliceissue2), 60, WAIT_FOR.CLICKABLE, "");
			 func._waitForPageToLoad(getWebDriver(),200L);
			 Thread.sleep(3000);
		    }else
		    {
		    	 _click(getElement(btn_Save));
				 func._waitForPageToLoad(getWebDriver(), 200L);
				 	// func._waitFor(getElement(btn_confirmPoliceissue1), 60, WAIT_FOR.CLICKABLE, "");
				 Thread.sleep(5000);
				 func._waitFor(getElement(btn_confirmPoliceissue2), 60, WAIT_FOR.CLICKABLE, "");
				 func._waitForPageToLoad(getWebDriver(),200L);
				 Thread.sleep(3000);
		    	
		    }
		/* if(!func._isVisible(getElement(btn_confirmPoliceissue1)))
		 {
			 if(!dataIssuePolicy.getData("PaymentPlan").equals(""))
			 {
				 func._waitForPageToLoad(getWebDriver(),500L);
				 Thread.sleep(5000);
				 _setValue(getElement(lst_PaymentPlan),dataIssuePolicy.getData("PaymentPlan"));
				 func._waitForPageToLoad(getWebDriver(),200L);
				 Thread.sleep(3000);
				 _click(getElement(btn_IssuePolicyNumber));
				 func._waitForPageToLoad(getWebDriver(), 200L);
				 Thread.sleep(3000);
			 }
		 }*/
		 
		
		 
		 if(func._checkAttributeValue(getElement(lbl_BSConfirm), "TEXT", dataNewSubmission.getData("BusinessSegment"), softAssert))
		 {
			 CustomReporting.logReport("","","Business segment Value displayed on the confirm issue policy number screen is correct" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		 }
		 else
		 {
			 CustomReporting.logReport("","", "Business segment Value displayed on the confirm issue policy number screen is not correct.","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
				
		 }
		 if(func._checkAttributeValue(getElement(lbl_BranchOfficeConfirm), "TEXT", dataNewSubmission.getData("BusinessOffice"), softAssert))
		 {
			 CustomReporting.logReport("","","BranchOffice Value displayed on the confirm issue policy number screen is correct" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		 }
		 else
		 {
			 CustomReporting.logReport("","", "BranchOffice Value displayed on the confirm issue policy number screen is not correct.","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
				
		 }
		 
		 if(!dataIssuePolicy.getData("BoundLineBusiness").equals(""))
		 {
			 if(func._checkAttributeValue(getElement(lbl_BoundLOBConfirm), "TEXT", dataIssuePolicy.getData("BoundLineBusiness"), softAssert))
			 {
				 CustomReporting.logReport("","","Bound LOB Value displayed on the confirm issue policy number screen is correct" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
			 }
			 else
			 {
				 CustomReporting.logReport("","", "Bound LOB Value displayed on the confirm issue policy number screen is not correct.","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					
			 }
		 }
		 else
		 {
			 if(func._checkAttributeValue(getElement(lbl_BoundLOBConfirm), "TEXT", dataNewSubmission.getData("SubmissionLOB"), softAssert))
			 {
				 CustomReporting.logReport("","","Bound LOB Value displayed on the confirm issue policy number screen is correct" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
			 }
			 else
			 {
				 CustomReporting.logReport("","", "Bound LOB Value displayed on the confirm issue policy number screen is not correct.","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					
			 }
			 
		 }
		 String policynumber;
		 if(!dataIssuePolicy.getData("PolicyEffectiveDate").equals(""))
		 {
			 policynumber=dataIssuePolicy.getData("PolicyEffectiveDate");
		
		 }
		 else
		 {
			 
			 policynumber=func.Date_Manipulation("", "Now", 0);
				 
		 }
		 if(func._checkAttributeValue(getElement(lbl_PolicyEffDteConfirm), "TEXT", policynumber, softAssert))
		 {
			 CustomReporting.logReport("","","PolicyEffDate Value displayed on the confirm issue policy number screen is correct" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		 }
		 else
		 {
			 CustomReporting.logReport("","", "PolicyEffDate Value displayed on the confirm issue policy number screen is not correct.","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
				
		 }
		 Thread.sleep(3000);
		 _click(getElement(btn_confirmPoliceissue2));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(3000);
		 long startTime1 = System.currentTimeMillis();
			long elapsedTime1=0L;
		    if(func._isVisible(getElement(btn_confirmPoliceissue2)))
		    {
		    	_click(getElement(btn_confirmPoliceissue2));
		    	 func._waitForPageToLoad(getWebDriver(),50L);
		    }
			 func._record_PageLoadTime(getWebDriver(), 300L);
		    Thread.sleep(10000);
		    func._waitFor(getElement(msg_issuePolicy), 200L, WAIT_FOR.VISIBLE);
		    
		    elapsedTime1 = (new Date()).getTime() - startTime1; 
			CustomReporting.logReport("Time taken to Complete Create Policy  :  "+elapsedTime1 +" ms"); 
			
		// _checkDefaultValue(getElement(msg_issuePolicy),"TEXT","Policy number issued successfully!");
		 
		 //if(func._checkAttributeValue(getElement(msg_issuePolicy),"TEXT","Policy number issued successfully!",softAssert))
		 
		   WebElement weSuccMsg=(WebElement)getElement(msg_issuePolicy).getNative();
		   System.out.println(weSuccMsg.getText());
		   CustomReporting.logReport(weSuccMsg.getText());
		    if(weSuccMsg.getText().trim().contains("Policy number issued successfully"))
		 {

			 //CustomReporting.logReport("","","Policy number issued for the submission successfully!" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
			 CustomReporting.logReport("","","Account & Submission information updated successfully!, Policy number issued successfully" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
			 
		 }
		 else
		 {

			 CustomReporting.logReport("","", "Policy number is not issued for the submission.","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				//throw new RuntimeException();
		 }
		 if(!func._isEnabled(getElement(getPolicyNumber)))
		 {
			CustomReporting.logReport("","","Policy number field is Disabled soon after issued policy number" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		 }
		 else
		 {
			CustomReporting.logReport("", "", "Policy number field is Enabled in policy screen.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		 }
		 if(!func._isEnabled(getElement(getPolicyMod)))
		 {
			CustomReporting.logReport("","","Policy Mod ield is Disabled soon after issued policy number" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		 }
		 else
		 {
			CustomReporting.logReport("", "", "Policy Mod field is Enabled in policy screen .","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		 }
		 if(!func._isEnabled(getElement(lst_BoundLineBusiness)))
		 {
			CustomReporting.logReport("","","Bound Line Of Business field is Disabled soon after issued policy number" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		 }
		 else
		 {
			CustomReporting.logReport("", "", "Bound Line Of Business field is Enabled in policy screen.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		 }

		 Thread.sleep(2000);
		 WebElement el=(WebElement) getClonedElement(PolicyNumber).addToken("tkn_SubNum", dataNewSubmission.getData("SubmissionNumber")).getNative();
		 
		 String getPolicyNum=el.getText();
		 Thread.sleep(2000);
	     func._writeToExcel("IssuePolicy", "PolicyNumber",getPolicyNum, tcID);
	     func._writeToExcel("SearchPolicy", "PolicyNo",getPolicyNum, tcID);
	     Thread.sleep(2000);
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			 func._writeToExcel("QASearch", "PolicyNumber",getPolicyNum, tcID);
		 }
		 else
		 {
			 func._writeToExcel("Search", "PolicyNumber",getPolicyNum, tcID);	 
		 }
		
	    /* if((dataNewSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataNewSubmission.getData("BusinessSegment").equals("Alternative Solutions")||dataNewSubmission.getData("BusinessSegment").equals("Private Company Group")||dataNewSubmission.getData("BusinessSegment").equals("Professional Liability")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Executive Solutions")
	    		 ||dataNewSubmission.getData("BusinessSegment").equals("Private Company Group")) &&(dataNewSubmission.getData("SubmissionLOB").equals("Private Co Exp")))
	     {
	    	 if(getPolicyNum.substring(0, 4).equalsIgnoreCase(" PCIP") && ((getPolicyNum.split("-")[0].length()==10) && (getPolicyNum.split("-")[1].length()==3)))
	  
			 {	
		 		CustomReporting.logReport("","","Policy number issued successfully message is displayed with format: PCIPnnnnnn-181" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
			 }
	    	 else
	    	 {
	    		 CustomReporting.logReport("", "", "Policy number issued successfully message is not displayed with format: PCIPnnnnnn-181","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	 
	    		 throw new RuntimeException();
	    	 }
	    	 
	    	 
	    	
	     }*/


	     
	     func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

	}
	@Override
	public void clkAddPolicy (String tcID, SoftAssert softAssert) throws Exception
	{
		//func._waitForPageToLoad(getWebDriver(),350L);
		
		func._waitFor(getElement(btn_AddPolicy), 500, WAIT_FOR.CLICKABLE, "");
		Thread.sleep(3000);
		 long startTime1 = System.currentTimeMillis();
			long elapsedTime1=0L;
		 _click(getElement(btn_AddPolicy));
		 
		 func._waitForPageToLoad(getWebDriver(),500L);
		 Thread.sleep(5000);
		 int loopCount=0;
		 
		 do
		 {
			 Thread.sleep(5000);
			 if(func._isVisible(getElement(btn_IssuePolicyNumber))) {
				break;
			 }
			 
			 loopCount=loopCount+1;
			 
		 }while(loopCount<20);
		 
		 if(!func._isVisible(getElement(btn_IssuePolicyNumber))) {
			 _click(getElement(btn_AddPolicy));
			
			 Thread.sleep(5000);
			 int loopCount1=0;
			 do
			 {
				 Thread.sleep(5000);
				 if(func._isVisible(getElement(btn_IssuePolicyNumber))) {
					break;
				 }
				 
				 loopCount1=loopCount1+1;
				 
			 }while(loopCount1<50);
		 }

		 func._waitForPageToLoad(getWebDriver(),500L);
			Thread.sleep(3000);
			elapsedTime1 = (new Date()).getTime() - startTime1; 
			CustomReporting.logReport("Time taken to Complete Create Policy  :  "+elapsedTime1 +" ms"); 
	    
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
	}
	
	@Override
	public void RenewalPolicy (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataRenewalPolicy = PageDataManager.instance().getPageData("RenewalPolicy",tcID);
		PageData dataNewSubmission= null;
		PageData dataEditSubmission = null;
		String PopUpMsg1;
		String PopUpMsg2;

		WebElement elm = null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
		 }
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			 dataEditSubmission = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
		 }
		 else
		 {
			 dataEditSubmission = PageDataManager.instance().getPageData("EditSubmission",tcID);
		 }
				 
				 
		//func._waitFor(getElement(btn_IssuePolicyNumber), 300, WAIT_FOR.CLICKABLE, "");
		 func._waitForPageToLoad(getWebDriver(),50L);
		if(!dataRenewalPolicy.getData("PolicyEffectiveDate").equals(""))
		{
		 _setValue(getElement(dat_PolicyEffectiveDate),dataRenewalPolicy.getData("PolicyEffectiveDate"));
		  elm = (WebElement) getElement(dat_PolicyEffectiveDate).getNative();
         elm.sendKeys(Keys.TAB);
		}
		 if(!dataRenewalPolicy.getData("PolicyExpirationDate").equals(""))
		{
			 func._waitForPageToLoad(getWebDriver(),250L);
			 Thread.sleep(3000);
			 int offset= Integer.valueOf(dataRenewalPolicy.getData("PolicyExpirationDate").split("-")[0].trim());
		    	String OptValue=dataRenewalPolicy.getData("PolicyExpirationDate").split("-")[1].trim();
			_setValue(getElement(dat_PolicyExpirationDate),func.Date_Manipulation("",OptValue, offset));
			 elm = (WebElement) getElement(dat_PolicyExpirationDate).getNative();
	         elm.sendKeys(Keys.TAB);
			 func._waitForPageToLoad(getWebDriver(),250L);
			 Thread.sleep(5000);
		}
		 if(!dataRenewalPolicy.getData("PolicyStatus").equals(""))
		 {
		 _setValue(getElement(lst_PolicyStatus),dataRenewalPolicy.getData("PolicyStatus"));
		 func._waitForPageToLoad(getWebDriver(),150L);
		 Thread.sleep(2000);
		 }
		 if(!dataRenewalPolicy.getData("CancelledReasonCode").equals(""))
		 {
			 _setValue(getElement(lst_CancelledReasonCode),dataRenewalPolicy.getData("CancelledReasonCode"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 Thread.sleep(3000);
		 if(!dataRenewalPolicy.getData("DateBound").equals(""))
		 {
		 _setValue(getElement(dat_DateBound),dataRenewalPolicy.getData("DateBound"));
		  elm = (WebElement) getElement(dat_DateBound).getNative();
         elm.sendKeys(Keys.TAB);
		 }
		 else
		 {
			 _setValue(getElement(dat_DateBound),func.Date_Manipulation("", "Now", 0));
			  elm = (WebElement) getElement(dat_DateBound).getNative();
	         elm.sendKeys(Keys.TAB);
		 }
		 
		 if(!dataRenewalPolicy.getData("PolicyPremium").equals(""))
		 {
		 _setValue(getElement(txt_PolicyPremium),dataRenewalPolicy.getData("PolicyPremium"));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 if(func._getAttributeValue(getElement(lst_TPA), "TEXT", softAssert).equals("make selection"))
		// if(!dataRenewalPolicy.getData("TPA").equals(""))
		 {
		 _setValue(getElement(lst_TPA),dataRenewalPolicy.getData("TPA"));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 
		 if(!dataRenewalPolicy.getData("PropertyPolicyType").equals(""))
		 {
			 _setValue(getElement(lst_PropertyPolicyType),dataRenewalPolicy.getData("PropertyPolicyType"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 if(dataRenewalPolicy.getData("MultiStatePolicy").toLowerCase().contains("yes"))
		 {
			 _click(getElement(red_MultiStatePolicy_Yes));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 if(dataRenewalPolicy.getData("MultiStatePolicy").toLowerCase().contains("no"))
		 {
			 _click(getElement(red_MultiStatePolicy_No));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 if(dataEditSubmission.getData("BusinessSegment").trim().toLowerCase().contains("environmental")||dataNewSubmission.getData("BusinessSegment").trim().toLowerCase().contains("environmental"))
		 {
			 if(dataRenewalPolicy.getData("PremiumAudit").trim().toLowerCase().contains("yes"))
			 {
				 _click(getElement(rb_PremiumAuditInd_Yes));
				 func._waitForPageToLoad(getWebDriver(),50L);
			 }
			 if(dataRenewalPolicy.getData("PremiumAudit").trim().toLowerCase().contains("no"))
			 {
				 _click(getElement(rb_PremiumAuditInd_No));
				 func._waitForPageToLoad(getWebDriver(),50L);
			 }
		 }
		 
		 
		 if(!dataRenewalPolicy.getData("ProductCode").equals(""))
		 {
			 			
			_setValue(getElement(lst_ProductCode),dataRenewalPolicy.getData("ProductCode"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 func._waitForPageToLoad(getWebDriver(),500L);
		 Thread.sleep(2000);
		 if(!dataRenewalPolicy.getData("BillType").equals(""))
		 {
			
			 func._waitForPageToLoad(getWebDriver(),500L);
			 Thread.sleep(2000);
			 _setValue(getElement(lst_BillType),dataRenewalPolicy.getData("BillType"));
			 func._waitForPageToLoad(getWebDriver(),500L);
			 Thread.sleep(2000);
			 //_click(getElement(btn_Save));
			// func._waitForPageToLoad(getWebDriver(), 200L);
			 //Thread.sleep(2000);
		 }
		 if(!dataRenewalPolicy.getData("CancelState").equals(""))
		 {
			 
		 _setValue(getElement(lst_CancelState),dataRenewalPolicy.getData("CancelState"));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 
		 if(!dataRenewalPolicy.getData("PaymentPlan").equals(""))
		 {
			 _setValue(getElement(lst_PaymentPlan),dataRenewalPolicy.getData("PaymentPlan"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 if(!dataRenewalPolicy.getData("DatePolicyIssued").equals(""))
		 {
			 _setValue(getElement(dat_DatePolicyIssued),dataRenewalPolicy.getData("DatePolicyIssued"));
			  elm = (WebElement) getElement(dat_DatePolicyIssued).getNative();
	         elm.sendKeys(Keys.TAB);
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 if(!dataRenewalPolicy.getData("PolicyStatus").equals(""))
		 {
		 _setValue(getElement(lst_PolicyStatus),dataRenewalPolicy.getData("PolicyStatus"));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 
		 if(!dataRenewalPolicy.getData("DateBound").equals(""))
		 {
		 _setValue(getElement(dat_DateBound),dataRenewalPolicy.getData("DateBound"));
		  elm = (WebElement) getElement(dat_DateBound).getNative();
         elm.sendKeys(Keys.TAB);
		 }
		 else
		 {
			 _setValue(getElement(dat_DateBound),func.Date_Manipulation("", "Now", 0));
			  elm = (WebElement) getElement(dat_DateBound).getNative();
	         elm.sendKeys(Keys.TAB);
		 }
		 if(!dataRenewalPolicy.getData("BillType").equals(""))
		 {
			
			 func._waitForPageToLoad(getWebDriver(),500L);
			 Thread.sleep(2000);
			 _setValue(getElement(lst_BillType),dataRenewalPolicy.getData("BillType"));
			 func._waitForPageToLoad(getWebDriver(),500L);
			 Thread.sleep(2000);
			 //_click(getElement(btn_Save));
			 //Thread.sleep(2000);
		 }
		 if(func._getAttributeValue(getElement(lst_TPA), "TEXT", softAssert).equals("make selection"))
				// if(!dataRenewalPolicy.getData("TPA").equals(""))
				 {
				 _setValue(getElement(lst_TPA),dataRenewalPolicy.getData("TPA"));
				 func._waitForPageToLoad(getWebDriver(),50L);
				 
				/* _click(getElement(btn_Save));
				 Thread.sleep(2000); */
		}
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 Thread.sleep(3000);
  		 _click(getElement(btn_IssuePolicyNumber));
  		 func._waitForPageToLoad(getWebDriver(),250L);
  		 Thread.sleep(2000);
  		if(!dataRenewalPolicy.getData("RNPop1").equals(""))
  		{
  		 
  			PopUpMsg1 = func._getAttributeValue(getElement(lbl_RNConfirm1), "TEXT", softAssert);
  			if(PopUpMsg1.contains(dataRenewalPolicy.getData("RNPop1")))
  		
	  		{
				 CustomReporting.logReport("","",PopUpMsg1+" is displayed" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
			 }
			 else
			 {
				 CustomReporting.logReport("","", PopUpMsg1+" is not sdisplayed","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					
			 }
  		}
  		 
	
		 _click(getElement(btn_confirmPoliceissue1));
		 func._waitForPageToLoad(getWebDriver(),250L);
		 Thread.sleep(2000);
		 if(!dataRenewalPolicy.getData("RNPop2").equals(""))
		 {
		 
			 PopUpMsg2 = func._getAttributeValue(getElement(lbl_RNConfirm2), "TEXT", softAssert);
			
			 if(PopUpMsg2.contains(dataRenewalPolicy.getData("RNPop2")))
		 
	  		{
				 CustomReporting.logReport("","",PopUpMsg2+" is displayed" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
			 }
			 else
			 {
				 CustomReporting.logReport("","", PopUpMsg2+" is not sdisplayed","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					
			 }
		 }
		 Thread.sleep(4000);
		 func._waitFor(getElement(btn_confirmPoliceissue2), 100, WAIT_FOR.CLICKABLE);
		 Thread.sleep(2000);
		 _click(getElement(btn_confirmPoliceissue2));
		 func._waitForPageToLoad(getWebDriver(), 200L);
		 Thread.sleep(4000);
		 //func._waitFor(getElement(msg_issuePolicy), 100, WAIT_FOR.VISIBLE, "");
		 
		// _checkDefaultValue(getElement(msg_issuePolicy),"TEXT","Policy number issued successfully");
		 //if(func._checkAttributeValue(getElement(msg_issuePolicy),"TEXT","Policy number issued successfully",softAssert))
		
		 WebElement weSuccMsg=(WebElement)getElement(msg_issuePolicy).getNative();
		    
		  if(weSuccMsg.getText().contains("Policy number issued successfully"))

		 {
			CustomReporting.logReport("","","Policy is created for Renewal submission" + "" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		 }
		 else
		 {
			CustomReporting.logReport("","", "Policy is not created for Renewal submission","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
		 }
		 func._waitForPageToLoad(getWebDriver(),150L);
		 WebElement el=(WebElement) getElement(tab_Policynumber).getNative();
		 String getPolicyNum=el.getText().split(":")[1].trim();

		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			 func._writeToExcel("QASearch", "PolicyNumber",getPolicyNum, tcID);
		 }
		else
		{
			 func._writeToExcel("Search", "PolicyNumber",getPolicyNum, tcID);
		}

	    
	     func._writeToExcel("RenewalPolicy", "RePolicyNumber",getPolicyNum, tcID);
	     func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	     
	}
	
	
	public void VerifyRenewalPolicyEffDate (String tcID, SoftAssert softAssert) throws Exception
	{
			 
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
			func._waitForPageToLoad(getWebDriver(), 200L);
			func._waitFor(getElement(btn_AddPolicy), 50, WAIT_FOR.VISIBLE, "");
		    _click(getElement(btn_AddPolicy));
		    func._waitForPageToLoad(getWebDriver(), 200L);
		    Thread.sleep(5000);
		    func._waitFor(getElement(btn_IssuePolicyNumber), 50, WAIT_FOR.VISIBLE, "");
		    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			String strPolichyEffDate= getElement(dat_PolicyEffectiveDate).getAttribute("value");
			
			_setValue(getElement(dat_PolicyEffectiveDate),func.Date_Manipulation(strPolichyEffDate, "Day", 1));
			WebElement elm = (WebElement) getElement(dat_PolicyEffectiveDate).getNative();
	         elm.sendKeys(Keys.TAB);
	    	Thread.sleep(5000);
	    	_click(getElement(btn_Save));
	    	func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(5000);
		WebElement ele = (WebElement) getElement(msg_Error).getNative();
		_click(getElement(img_ErrorIcon));
		Thread.sleep(1000);
		boolean isErrorExist=func._isVisible(getElement(msg_Error));
		long startTime = System.currentTimeMillis();
		if(isErrorExist)
		{
			CustomReporting.logReport("","","The following error is displaying when renewal policy effective date is selected greater than prior term exipiration date :-"+ele.getText() ,StepStatus.SUCCESS,new String[] { },startTime);	
		}
		else
		{
			CustomReporting.logReport("","", "error message is not displaying when renewal policy effective date is selected greater than prior term exipiration date","", StepStatus.FAILURE,new String[] {  }, startTime, null);	
		}

		/* cal.add(Calendar.DAY_OF_MONTH,-3);
		 String dt2 = datPolicyEffDate.format(cal.getTime());*/
		_setValue(getElement(dat_PolicyEffectiveDate),func.Date_Manipulation(strPolichyEffDate, "Day", -3));
		 elm = (WebElement) getElement(dat_PolicyEffectiveDate).getNative();
        elm.sendKeys(Keys.TAB);
	    	Thread.sleep(5000);
	    	_click(getElement(btn_Save));
	    	func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(5000);
		_click(getElement(img_ErrorIcon));
		WebElement ele2 = (WebElement) getElement(msg_Error).getNative();
		Thread.sleep(1000);
		String Errmsg=ele2.getText();
		boolean isErrorExist2=func._isVisible(getElement(msg_Error));
		startTime = System.currentTimeMillis();
		if(isErrorExist2)
		{
			CustomReporting.logReport("","","The following error is displaying when renewal policy effective date is selected less than prior term exipiration date :-"+Errmsg ,StepStatus.SUCCESS,new String[] { },startTime);	
		}
		else
		{
			CustomReporting.logReport("","", "error message is not displaying The following error is displaying when renewal policy effective date is selected less than prior term exipiration date.","", StepStatus.FAILURE,new String[] {  }, startTime, null);	
		}
		
		int offset= Integer.valueOf(dataIssuePolicy.getData("PolicyExpirationDate").split("-")[0].trim());
    	String OptValue=dataIssuePolicy.getData("PolicyExpirationDate").split("-")[1].trim();
    			
		 if(strPolichyEffDate.equals(func.Date_Manipulation("",OptValue, offset)))
		 {
			 CustomReporting.logReport("",""," Reneweal Policy effective date displaying as prior term expiration date  while renewal the policy" ,StepStatus.SUCCESS,new String[] { },startTime);	
			 _setValue(getElement(dat_PolicyEffectiveDate),strPolichyEffDate);
			  elm = (WebElement) getElement(dat_PolicyEffectiveDate).getNative();
	         elm.sendKeys(Keys.TAB);
			 Thread.sleep(5000);
			 _click(getElement(btn_Save));
			 func._waitForPageToLoad(getWebDriver(), 200L);
			 Thread.sleep(5000);
		
		 }
		 else
		 {
			 CustomReporting.logReport("","", "Reneweal Policy effective date is not displaying as prior term expiration date  while renewal the policy","", StepStatus.FAILURE,new String[] {  }, startTime, null);
		 }

		 _click(getElement(btn_IssuePolicyNumber));
		Thread.sleep(2000);
		 func._waitFor(getElement(btn_confirmPoliceissue1), 50, WAIT_FOR.VISIBLE, "");
		 _click(getElement(btn_confirmPoliceissue1));
		 Thread.sleep(2000);
		 func._waitFor(getElement(btn_confirmPoliceissue2), 50, WAIT_FOR.VISIBLE, "");
		 _click(getElement(btn_confirmPoliceissue2));
		 func._waitForPageToLoad(getWebDriver(), 200L);
		 Thread.sleep(2000);
		 func._waitFor(getElement(msg_issuePolicy), 50, WAIT_FOR.VISIBLE, "");
		 
		 WebElement weSuccMsg=(WebElement)getElement(msg_issuePolicy).getNative();
		    
		  if(weSuccMsg.getText().contains("Policy number issued successfully"))
		  {
				CustomReporting.logReport("","","Policy is created for Renewal submission" + "" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			 }
			 else
			 {
				CustomReporting.logReport("","", "Policy is not created for Renewal submission","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			 }
		
		 Thread.sleep(5000);
		 WebElement el=(WebElement) getElement(getPolicyNumber).getNative();
		 String getPolicyNum=el.getText();

		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			 func._writeToExcel("QASearch", "PolicyNumber",getPolicyNum, tcID);
		 }
		else
		{
			func._writeToExcel("Search", "PolicyNumber",getPolicyNum, tcID);
		}
	     
	     
	     func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

	}
	
	public void VerifyBillingPage (String tcID, SoftAssert softAssert) throws Exception
	{
		 Thread.sleep(5000);
		 String parentWinHandle="";
		 func._waitFor(getElement(btn_issueBill), 100, WAIT_FOR.CLICKABLE, "");
		 long startTime1 = System.currentTimeMillis();
			long elapsedTime1=0L;
		_click(getElement(btn_issueBill));
		 func._alertHandler(getWebDriver(), "Ok");
		 Thread.sleep(5000);
		 func._waitForPageToLoad(getWebDriver(), 200L);
		 int loopcount=0;
		do
		 {
			 if(func._isVisible(getElement(chk_BillIssued)))
			 {
				break; 
			 }
			 Thread.sleep(10000); 
			 loopcount=loopcount+1;
		 } while(loopcount<100);
		
		
		 Thread.sleep(6000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			 
		 WebElement weBillmsg=(WebElement)getElement(msg_issueBillSuccess).getNative();
		 elapsedTime1 = (new Date()).getTime() - startTime1; 
			CustomReporting.logReport("Time taken to Complete Issue Bill  :  "+elapsedTime1 +" ms"); 
		 if(weBillmsg.getText().trim().contains("Bill issued successfully"))
		 //if(func._checkAttributeValue(getElement(msg_issueBillSuccess),"TEXT","Account & Submission information updated successfully!, Bill issued successfully!",softAssert))
		 {
			 parentWinHandle = getWebDriver().getWindowHandle();
			 CustomReporting.logReport("","","Invoice and Payment schedule screen displayed when user click on Issue Bill button displayed on Policy Screen." + 
			 		"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		 }
		 else
		 {
			 CustomReporting.logReport("","", "Invoice and Payment schedule screen is not displayed when user click on Issue Bill button displayed on Policy Screen.","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
				//throw new RuntimeException();
		 }
		boolean isElementExist;

		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		{
			func._switchWindows(getWebDriver(), "BY_WINURL", "http://everestnational-qa/ESCAPE/DisplayBill.aspx");
		}
		else
		{
			func._switchWindows(getWebDriver(), "BY_WINURL", "http://everestnational-s/ESCAPE/DisplayBill.aspx");
		}
		
		
		isElementExist=func._isVisible(getElement(Btn_Invoice));
		long startTime = System.currentTimeMillis();
		if(isElementExist)
		{
			CustomReporting.logReport("","", "Invoice buttion is exist in Invoice&Payment screen",StepStatus.SUCCESS,new String[] { },startTime);
		}
		else
			
		{
			CustomReporting.logReport("","", "Invoice buttion is not exist in Invoice&Payment screen","", StepStatus.FAILURE,new String[] {  }, startTime, null);
		}
		
		isElementExist=func._isVisible(getElement(Btn_PaymentSchedule));
		
		if(isElementExist)
		{
			CustomReporting.logReport("","", "Payment Schedule buttion is exist in Invoice&Payment screen",StepStatus.SUCCESS,new String[] { },startTime);
		}
		else
		{
			CustomReporting.logReport("","", "Payment Schedule buttion is not exist in Invoice&Payment screen","", StepStatus.FAILURE,new String[] {  }, startTime, null);
		}
		
		
		getWebDriver().close();
		getWebDriver().switchTo().window(parentWinHandle);
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(3000);
		if(func._isVisible(getElement(btn_ReviseBill)))
		{
			CustomReporting.logReport("","", "Revise Bill button is displayed instead of Issue Bill Button after issued bill first time",StepStatus.SUCCESS,new String[] { },startTime);
		}
		else
		{
			CustomReporting.logReport("","", "Revise Bill button is not displayed instead of Issue Bill Button after issued bill first time","", StepStatus.FAILURE,new String[] {  }, startTime, null);
		}
		
	}
	
	public void Check_Invoice_Downloaded (String tcID, SoftAssert softAssert, String Driver,String DownloadType) throws Exception
	{
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		String parentWinHandle="";
		/*if(dataLogin.getData("DownLoad_Invoice").trim().toLowerCase().equals("yes"))
		{	*/
			Thread.sleep(5000);
		
			func._waitFor(getElement(btn_issueBill), 100, WAIT_FOR.CLICKABLE, "");
			_click(getElement(btn_issueBill));
			Thread.sleep(5000);
			 func._alertHandler(getWebDriver(), "Ok");
			 int iCount=0;
			 do
			 {
				 func._waitForPageToLoad(getWebDriver(), 500L);
				Thread.sleep(5000);
				if(func._isVisible(getElement(chk_BillIssued)))
				{
					if(func._isChecked(getElement(chk_BillIssued)))
					{
						break;
					}
				}
				iCount=iCount+1;
			 }while(iCount<30);
			 Thread.sleep(5000);
			 String docname="";
			 String strDownloadFIels="";
			 String DownloadFilePath="";
			 String nFileName="";
			 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			 func._checkDefaultValue(getElement(msg_issueBillSuccess),"TEXT","Bill issued successfully");
			 parentWinHandle = getWebDriver().getWindowHandle();
			 
			
				if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
				{
					func._switchWindows(getWebDriver(), "BY_WINURL", "http://everestnational-qa/ESCAPE/DisplayBill.aspx");
				}
				{
					func._switchWindows(getWebDriver(), "BY_WINURL", "http://everestnational-s/ESCAPE/DisplayBill.aspx");
				}
				
			
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			 if(DownloadType.trim().toLowerCase().equals("invoice"))
			 	{
				Check_Downloaded_InvoicePayment(tcID,softAssert,Driver,"invoice");
			 	}
			 if(DownloadType.trim().toLowerCase().equals("payment"))
				{
				 Check_Downloaded_InvoicePayment(tcID,softAssert,Driver,"payment");
				}
			 if(DownloadType.trim().toLowerCase().equals("both"))
				{
				 Check_Downloaded_InvoicePayment(tcID,softAssert,Driver,"invoice");
				 Check_Downloaded_InvoicePayment(tcID,softAssert,Driver,"payment");
				}
		
	        getWebDriver().close();
			getWebDriver().switchTo().window(parentWinHandle);
	}
		
			

	public void Check_Downloaded_InvoicePayment (String tcID, SoftAssert softAssert, String Driver,String DownloadType) throws Exception
	{
		String DownloadFilePath="";
		String nFileName="";
		String strDownloadFIels="";
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		/*String strUserName = System.getProperty("user.name");
		strDownloadFIels="C:\\Users\\" + strUserName + "\\Downloads\\";*/
		
		//strDownloadFIels="C:\\Users\\sbasavar\\Downloads\\";
		String home = System.getProperty("user.home");
		File directory = new File("./");
		String strDirectoryPath = directory.getAbsolutePath().split("\\.")[0];	
		DownloadFilePath = DeviceManager.instance().getConfigurationProperties().getProperty("download.path");
		DownloadFilePath =strDirectoryPath+DownloadFilePath;	
		strDownloadFIels="C:\\Users\\sbasavar\\Downloads\\";
		/*String strUserName = System.getProperty("user.home");
		strDownloadFIels=strUserName +"\\Downloads\\";*/

        long startTime = System.currentTimeMillis();
        String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date()).replace(".", "_");
        //docname = "ViewBill"+"_"+timeStamp+".pdf";
      
        if(Driver.contains("Internet Explorer"))
		{
        
			if(DownloadType.trim().toLowerCase().equals("invoice"))
			{
				nFileName = "Invoice_ViewBill"+"_"+timeStamp+".pdf";
				_click(getElement(Btn_Invoice));
			}
			if(DownloadType.trim().toLowerCase().equals("payment"))
			{
				nFileName = "Payment_ViewBill"+"_"+timeStamp+".pdf";
				_click(getElement(Btn_PaymentSchedule));	
			}
			Thread.sleep(5000);
			
	        Robot robot = new Robot();
       
	        robot.keyPress(KeyEvent.VK_F6);
	        robot.keyRelease(KeyEvent.VK_F6);
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);
	        robot.keyPress(KeyEvent.VK_DOWN);
	        robot.keyRelease(KeyEvent.VK_DOWN);
	        robot.keyPress(KeyEvent.VK_DOWN);
	        robot.keyRelease(KeyEvent.VK_DOWN);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(3000);
	        func._downloadFile(DownloadFilePath, nFileName);
	        Thread.sleep(3000);
	        if(DownloadType.trim().toLowerCase().equals("invoice"))
	        {
				if(func.CheckFileExist(DownloadFilePath, nFileName))
				{
					CustomReporting.logReport("","", "Invoice is downloaded  successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
					func._writeToExcel("Payment", "BIllingDownloadPath",DownloadFilePath+nFileName, tcID);
				}
				else
				{
					CustomReporting.logReport("","", "Invoice is not downloaded","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				}
	        }
	        if(DownloadType.trim().toLowerCase().equals("payment"))
	        {
				if(func.CheckFileExist(DownloadFilePath, nFileName))
				{
					
					CustomReporting.logReport("","", "Payment Schedule statement is downloaded  successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
					func._writeToExcel("Payment", "PaymentDownloadPath",DownloadFilePath+nFileName, tcID);
				}
				else
				{
					CustomReporting.logReport("","", "Payment Schedule statement is not downloaded","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				}
	        }
		}

    	 else
	        {
    		
    		 String nFileName1="";	
	        	if(DownloadType.trim().toLowerCase().equals("invoice"))
				{
	        		nFileName = "Invoice_ViewBill"+"_"+timeStamp+".pdf";
	        		 nFileName1=home+"/Downloads/" + nFileName;
					_click(getElement(Btn_Invoice));
					  
				}
				if(DownloadType.trim().toLowerCase().equals("payment"))
				{
					nFileName = "Payment_ViewBill"+"_"+timeStamp+".pdf";
					nFileName1=home+"/Downloads/"+nFileName;
					_click(getElement(Btn_PaymentSchedule));
					
				}
				Thread.sleep(3000);
				//String strFilePath="C:\\Users\\" + strUserName + "\\Downloads\\";
				
				//String strFilePath=strDownloadFIels;
				
				File srcDir=new File(home+"/Downloads/");
			    File nFile= new File(nFileName1);
			    File targetDir= new File(DownloadFilePath);
			    
			    File[] dir_contents = srcDir.listFiles();
			    Arrays.sort(dir_contents, new Comparator<File>(){
			        public int compare(File f1, File f2) {
			          return Long.valueOf(f2.lastModified()).compareTo(f1.lastModified());
			        } 
			      });
			    if(dir_contents[0].renameTo(nFile)) {
					   System.out.println("SuccessFully Renamed");
				   }
				   else {
					System.out.println("Failed to Rename");
				}
			  File srcfileDir= func.getLastModifiedFile(home+"\\Downloads", nFileName);

			  FileUtils.copyFileToDirectory(srcfileDir, targetDir);
			  
				//String strFilePath="C:\\Users\\mpm\\Desktop\\Automation_Escape_2-1-2018\\resources\\DownLoadFiles\\";
				//String newFilename=func.RenameFile(strFilePath, docname);
				Thread.sleep(3000);

	       if(DownloadType.trim().toLowerCase().equals("invoice"))
	        {
				if(func.CheckFileExist(DownloadFilePath, nFileName))
				{
					CustomReporting.logReport("","", "Invoice is downloaded  successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
					func._writeToExcel("Payment", "BIllingDownloadPath",DownloadFilePath+nFileName, tcID);
				}
				else
				{
					CustomReporting.logReport("","", "Invoice is not downloaded","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				}
	        }
	        if(DownloadType.trim().toLowerCase().equals("payment"))
	        {
	        	if(func.CheckFileExist(DownloadFilePath, nFileName))
				{
					
					CustomReporting.logReport("","", "Payment Schedule statement is downloaded  successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
					func._writeToExcel("Payment", "PaymentDownloadPath",DownloadFilePath+nFileName, tcID);
				}
				else
				{
					CustomReporting.logReport("","", "Payment Schedule statement is not downloaded","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				}
	        }
				
				
	        	
	        }
   
		
	}
	
	public void Vrify_BusinessIndicator_CarryForward (String tcID, SoftAssert softAssert) throws Exception
	{
		//PageData dataAddPolicy = PageDataManager.instance().getPageData("AddPolicy",tcID);
		PageData dataAddPolicy =null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			dataAddPolicy = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 dataAddPolicy = PageDataManager.instance().getPageData("NewSubmission",tcID);
		 }
		
		
		/*if(dataAddPolicy.getData("SubPublicPrivate").trim().toLowerCase().equals("public"))
		{
			
			if(func._isChecked(getElement(chk_PolPublic)))
			{
				CustomReporting.logReport("","", "Public Business Indicator value is carry forwarded to policy scfreen from  submission screen",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			}
			else
			{
			

				CustomReporting.logReport("","", "Public Business Indicator value is not carry forwarded to policy screen from the  submission screen " + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				throw new RuntimeException();	
				
			}
			
		}
		if(dataAddPolicy.getData("SubPublicPrivate").trim().toLowerCase().equals("private"))
		{
			
			if(func._isChecked(getElement(chk_PolPrivate)))
			{
				CustomReporting.logReport("","", "Private Business Indicator value is carry forwarded to policy screen from the renewal submission",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			}
			else
			
			{
				CustomReporting.logReport("","", "Private Business Indicator value is not carry forwarded to policy screen from the renewal submission" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				throw new RuntimeException();	
			}
			
		}*/
		
	}
	
	public void Vrify_Policy_ScreenDetails (String tcID, SoftAssert softAssert) throws Exception
	{
		
		PageData NewSubmission =null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			NewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 NewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
		 }
				
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		
		PageData PolicyBound=null;
		if(NewSubmission.getData("SubmissionStatus").equals("Policy Bound"))
		{
			PolicyBound = PageDataManager.instance().getPageData("EditSubmission",tcID);	
		}
		else
		{
			PolicyBound = PageDataManager.instance().getPageData("NewSubmission",tcID);		
		}
		Thread.sleep(3000);
		func._waitFor(getElement(tab_Policynumber), 200, WAIT_FOR.VISIBLE);
		Thread.sleep(3000);
		_click(getElement(tab_Policynumber));
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		// func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
		String PolicyNumber=dataIssuePolicy.getData("PolicyNumber").split("-")[0];
		String PolicyMod=dataIssuePolicy.getData("PolicyNumber").split("-")[1];
		if(getElement(getPolicyNumber).getAttribute("value").trim().equals(PolicyNumber))
		{
			CustomReporting.logReport("","","Policy number is generated" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}
		else
		{
			CustomReporting.logReport("", "", "Policy number is not generated.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(getElement(getPolicyMod).getAttribute("value").trim().equals(PolicyMod))
		{
			CustomReporting.logReport("","","Policy Mod is generated" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}
		else
		{
			CustomReporting.logReport("", "", "Policy Mod is not generated.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(getPolicyNumber)))
		{
			CustomReporting.logReport("","","Policy number field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Policy number field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(getPolicyMod)))
		{
			CustomReporting.logReport("","","Policy Mod ield is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Policy Mod field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!func._isEnabled(getElement(chk_BillIssued)))
		{
			CustomReporting.logReport("","","BillIssued CheckBox field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "BillIssued CheckBox field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("PolicyEffectiveDate").equals(""))
		{
		func._checkAttributeValue(getElement(dat_PolicyEffectiveDate), "value", dataIssuePolicy.getData("PolicyEffectiveDate"), softAssert);
		}
		else
		{
						
			func._checkAttributeValue(getElement(dat_PolicyEffectiveDate), "value", func.Date_Manipulation("", "Now", 0), softAssert);	
		}
		if(!func._isEnabled(getElement(dat_PolicyEffectiveDate)))
		{
			CustomReporting.logReport("","","Policy Effective Date field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Policy Effective Date  field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("PolicyExpirationDate").equals(""))
		{
			int offset= Integer.valueOf(dataIssuePolicy.getData("PolicyExpirationDate").split("-")[0].trim());
	    	String OptValue=dataIssuePolicy.getData("PolicyExpirationDate").split("-")[1].trim();
			func._checkAttributeValue(getElement(dat_PolicyExpirationDate), "value",func.Date_Manipulation("",OptValue, offset), softAssert);
		}
		else
		{
			if(!dataIssuePolicy.getData("PolicyEffectiveDate").equals(""))
			{
			String SubmissionExpDate= func.Date_Manipulation(dataIssuePolicy.getData("PolicyEffectiveDate"), "YEAR", 1);
			func._checkAttributeValue(getElement(dat_PolicyExpirationDate), "value",SubmissionExpDate, softAssert);
			}
			else
			{
								
				 String SubmissionExpDate= func.Date_Manipulation("", "YEAR", 1);
					func._checkAttributeValue(getElement(dat_PolicyExpirationDate), "value",SubmissionExpDate, softAssert);
			}
		}
		if(func._isEnabled(getElement(dat_PolicyExpirationDate)))
		{
			CustomReporting.logReport("","","Policy Expairation Date field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Policy Expairation Date field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		
		func._checkAttributeValue(getElement(lst_PolicyStatus), "TEXT", dataIssuePolicy.getData("PolicyStatus"), softAssert);
		if(func._isEnabled(getElement(lst_PolicyStatus)))
		{
			CustomReporting.logReport("","","Policy Status field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Policy Status field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("CancelledReasonCode").equals(""))
		{
			func._checkAttributeValue(getElement(lst_CancelledReasonCode), "TEXT", dataIssuePolicy.getData("CancelledReasonCode"), softAssert);
		}
		else
		{
			func._checkAttributeValue(getElement(lst_CancelledReasonCode), "TEXT", "make selection", softAssert);
		}
		if(func._isEnabled(getElement(lst_CancelledReasonCode)))
		{
			CustomReporting.logReport("","","Cancelled Reason Code  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Cancelled Reason Code field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("DateBound").equals(""))
		{
			func._checkAttributeValue(getElement(dat_DateBound), "value", dataIssuePolicy.getData("DateBound"), softAssert);
		}
		else
		{
			
			func._checkAttributeValue(getElement(dat_DateBound), "value", func.Date_Manipulation("", "Now", 0), softAssert);
		}
		if(func._isEnabled(getElement(dat_DateBound)))
		{
			CustomReporting.logReport("","","Date of Bound field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Date of Bound field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!dataIssuePolicy.getData("BoundLineBusiness").equals(""))
		{
			func._checkAttributeValue(getElement(lst_BoundLineBusiness), "TEXT", dataIssuePolicy.getData("BoundLineBusiness"), softAssert);
		}
		else
		{
			func._checkAttributeValue(getElement(lst_BoundLineBusiness), "TEXT", NewSubmission.getData("SubmissionLOB"), softAssert);
		}
		if(!func._isEnabled(getElement(lst_BoundLineBusiness)))
		{
			CustomReporting.logReport("","","Bound Line Of Business field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Bound Line Of Business field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(NewSubmission.getData("BusinessSegment").equals("Financial Institutions")||NewSubmission.getData("BusinessSegment").contains("Professional Liability"))
		{
			if(!dataIssuePolicy.getData("PrimaryORExcess").equals(""))
			{
				if(dataIssuePolicy.getData("PrimaryORExcess").trim().toLowerCase().equals("primary"))
				{
					
					if(func._isChecked(getElement(rad_PolicyPrimary)))
					{
						CustomReporting.logReport("","","Policy Primary radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Policy Primary radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
						
					if(func._isEnabled(getElement(rad_PolicyPrimary)))
					{
						CustomReporting.logReport("","","Policy Primary radio buttion  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Policy Primary radio button field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
				if(dataIssuePolicy.getData("PrimaryORExcess").trim().toLowerCase().equals("excess"))
				{
					
					
					if(func._isChecked(getElement(rad_PolicyExcess)))
					{
						CustomReporting.logReport("","","Policy Excess radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Policy Excess radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
					if(func._isEnabled(getElement(rad_PolicyExcess)))
					{
						CustomReporting.logReport("","","Policy Excess radio buttion  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Policy Excess radio button field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
			}
			else
			{
				if(NewSubmission.getData("PrimaryORExcess").trim().toLowerCase().equals("primary"))
				{
					if(func._isChecked(getElement(rad_PolicyPrimary)))
					{
						CustomReporting.logReport("","","Policy Primary radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Policy Primary radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					if(func._isEnabled(getElement(rad_PolicyPrimary)))
					{
						CustomReporting.logReport("","","Policy Primary radio buttion  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Policy Primary radio button field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
				if(NewSubmission.getData("PrimaryORExcess").trim().toLowerCase().equals("excess"))
				{
					if(func._isChecked(getElement(rad_PolicyExcess)))
					{
						CustomReporting.logReport("","","Policy Excess radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Policy Excess radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					if(func._isEnabled(getElement(rad_PolicyExcess)))
					{
						CustomReporting.logReport("","","Policy Excess radio buttion  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Policy Excess radio button field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
			}
		}
		if(!dataIssuePolicy.getData("PolicyPremium").equals(""))
		{
			try
			{
				String ExpPolicyPremium=getElement(txt_PolicyPremium).getAttribute("value").trim().replace(",", "");
				if(ExpPolicyPremium.equals(dataIssuePolicy.getData("PolicyPremium")))
				
				{
					CustomReporting.logReport("","","Expected value : "+dataIssuePolicy.getData("PolicyPremium")+" match with Actual value "+ExpPolicyPremium ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "","Expected value : "+dataIssuePolicy.getData("PolicyPremium")+" does not match with Actual value "+ExpPolicyPremium,"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			
			
		}
		else
		{
			if((PolicyBound.getData("SubmissionStatus").equals("Quote Lost")||PolicyBound.getData("SubmissionStatus").equals("Indication Lost")||PolicyBound.getData("SubmissionStatus").equals("Quote Outstanding") 
	    		||PolicyBound.getData("SubmissionStatus").equals("Indication Outstanding")||PolicyBound.getData("SubmissionStatus").equals("Policy Bound")))
			{
				try
				
				{
					String ExpPolicyPremium=getElement(txt_PolicyPremium).getAttribute("value").trim().replace(",", "");
					if(ExpPolicyPremium.equals(PolicyBound.getData("QuotedPremium")))
					
					{
						CustomReporting.logReport("","","Expected value : "+PolicyBound.getData("QuotedPremium")+" match with Actual value "+ExpPolicyPremium ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "","Expected value : "+PolicyBound.getData("QuotedPremium")+" does not match with Actual value "+ExpPolicyPremium,"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
			
		}
		if(func._isEnabled(getElement(txt_PolicyPremium)))
		{
			CustomReporting.logReport("","","Policy Premium field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Policy Premium field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("Commission").equals(""))
		{
			func._checkAttributeValue(getElement(txt_Commission), "value", dataIssuePolicy.getData("Commission"), softAssert);
			
		}
		else
		{
			func._checkAttributeValue(getElement(txt_Commission), "value", "0.00", softAssert);	
		}
		if(func._isEnabled(getElement(txt_Commission)))
		{
			CustomReporting.logReport("","","Commission field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Commission field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!dataIssuePolicy.getData("NonCommissionableFee").equals(""))
		{
			func._checkAttributeValue(getElement(txt_NonCommissionableFee), "value", dataIssuePolicy.getData("NonCommissionableFee"), softAssert);
			
		}
		else
		{
			func._checkAttributeValue(getElement(txt_NonCommissionableFee), "value", "0.00", softAssert);	
		}
		if(func._isEnabled(getElement(txt_NonCommissionableFee)))
		{
			CustomReporting.logReport("","","Non CommissionableFee field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Non CommissionableFee field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(NewSubmission.getData("BusinessSegment").equals("Financial Institutions")||NewSubmission.getData("BusinessSegment").contains("Professional Liability"))
		{
		
			if(!dataIssuePolicy.getData("BoundProduct").equals(""))
			{
				func._checkAttributeValue(getElement(lst_BoundProduct), "TEXT", dataIssuePolicy.getData("BoundProduct"), softAssert);
				
			}
			else
			{
				func._checkAttributeValue(getElement(lst_BoundProduct), "TEXT", NewSubmission.getData("SubmittedProduct"), softAssert);	
			}
	
			if(func._isEnabled(getElement(lst_BoundProduct)))
			{
				CustomReporting.logReport("","","Policy BoundProduct field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Policy BoundProduct field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			
		}
		
		if(!dataIssuePolicy.getData("MultiStatePolicy").equals(""))
		{
			if(dataIssuePolicy.getData("MultiStatePolicy").trim().toLowerCase().equals("yes"))
			{
				
				if(func._isChecked(getElement(red_MultiStatePolicy_Yes)))
				{
					CustomReporting.logReport("","","MultiState Policy Yes radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "MultiState Policy Yes radio button field is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				if(func._isEnabled(getElement(red_MultiStatePolicy_Yes)))
				{
					CustomReporting.logReport("","","MultiState Policy Yes radio buttion  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "MultiState Policy Yes radio button field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				
			}
			if(dataIssuePolicy.getData("MultiStatePolicy").trim().toLowerCase().equals("no"))
			{
				if(func._isChecked(getElement(red_MultiStatePolicy_No)))
				{
					CustomReporting.logReport("","","MultiState Policy No radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "MultiState Policy No radio button field is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				if(func._isEnabled(getElement(red_MultiStatePolicy_No)))
				{
					CustomReporting.logReport("","","MultiState Policy No radio buttion  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "MultiState Policy No radio button field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				
			}
		}

		if(!dataIssuePolicy.getData("PremiumAudit").equals("")&&NewSubmission.getData("BusinessSegment").equals("Environmental"))
		{
			if(dataIssuePolicy.getData("PremiumAudit").trim().toLowerCase().equals("yes"))
			{
				
				if(func._isChecked(getElement(rb_PremiumAuditInd_Yes)))
				{
					CustomReporting.logReport("","","PremiumAudit Yes radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "PremiumAudit Yes radio button field is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				if(func._isEnabled(getElement(rb_PremiumAuditInd_Yes)))
				{
					CustomReporting.logReport("","","PremiumAudit Yes radio buttion  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "PremiumAudit Yes radio button field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				
			}
			if(dataIssuePolicy.getData("PremiumAudit").trim().toLowerCase().equals("no"))
			{
				if(func._isChecked(getElement(rb_PremiumAuditInd_No)))
				{
					CustomReporting.logReport("","","PremiumAudit No radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "PremiumAudit No radio button field is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				if(func._isEnabled(getElement(rb_PremiumAuditInd_No)))
				{
					CustomReporting.logReport("","","PremiumAudit  No radio buttion  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "PremiumAudit  No radio button field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				
			}
		}
		
		
		
		if(!func._isEnabled(getElement(ExpiringPolicyNo)))
		{
			CustomReporting.logReport("","","ExpiringPolicyNo field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "ExpiringPolicyNo field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		
		if(!func._isEnabled(getElement(ExpiringMod)))
		{
			CustomReporting.logReport("","","ExpiringPolicy mode field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "ExpiringPolicy mode field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(NewSubmission.getData("BusinessSegment").equals("Financial Institutions")||NewSubmission.getData("BusinessSegment").contains("Professional Liability"))
		{
			/*if(!dataIssuePolicy.getData("PolPublicPrivate").equals(""))
			{
				if(dataIssuePolicy.getData("PolPublicPrivate").trim().toLowerCase().equals("public"))
				{
									
					if(func._isChecked(getElement(chk_PolPublic)))
					{
						CustomReporting.logReport("","","Policy Public check box  is checked" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Policy Public check field is not checked.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					if(func._isEnabled(getElement(chk_PolPublic)))
					{
						CustomReporting.logReport("","","Policy Public check box field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Policy Public check field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
				if(dataIssuePolicy.getData("PolPublicPrivate").trim().toLowerCase().equals("private"))
				{
					if(func._isChecked(getElement(chk_PolPrivate)))
					{
						CustomReporting.logReport("","","Policy Private check box  is checked" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Policy Private check field is not checked.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					if(func._isEnabled(getElement(chk_PolPrivate)))
					{
						CustomReporting.logReport("","","Policy Private check box  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Policy private check box  field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
				
			}*/
			if(func._getAttributeValue(getElement(lst_BoundLineBusiness), "TEXT", softAssert).equals("Workers Comp"))
			 {
				func._checkAttributeValue(getElement(txt_ScheduleRatingMod), "value", dataIssuePolicy.getData("ScheduleRatingMod"), softAssert);
				if(func._isEnabled(getElement(txt_ScheduleRatingMod)))
				{
					CustomReporting.logReport("","","ScheduleRatingMod field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "ScheduleRatingMod field is not Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				func._checkAttributeValue(getElement(txt_ExperienceMod), "value", dataIssuePolicy.getData("ExperienceMod"), softAssert);
				if(func._isEnabled(getElement(txt_ExperienceMod)))
				{
					CustomReporting.logReport("","","ExperienceMod field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "ExperienceMod field is not Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				
			 }
			if(!dataIssuePolicy.getData("Limit").equals(""))
			{
				try
				{
					String ExpLimit=getElement(txt_PolicyLimit).getAttribute("value").trim().replace(",", "");
					if(ExpLimit.equals(dataIssuePolicy.getData("Limit")))
					
					{
						CustomReporting.logReport("","","Expected value : "+dataIssuePolicy.getData("Limit")+" match with Actual value "+ExpLimit ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "","Expected value : "+dataIssuePolicy.getData("Limit")+" does not match with Actual value "+ExpLimit,"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
					
			}
			else
			{
				if(PolicyBound.getData("SubmissionStatus").equals("Quote Lost")||PolicyBound.getData("SubmissionStatus").equals("Indication Lost")||PolicyBound.getData("SubmissionStatus").equals("Quote Outstanding") 
			    		||PolicyBound.getData("SubmissionStatus").equals("Indication Outstanding")||PolicyBound.getData("SubmissionStatus").equals("Policy Bound"))
				{
					try
					{
						String ExpLimit=getElement(txt_PolicyLimit).getAttribute("value").trim().replace(",", "");
						if(ExpLimit.equals(PolicyBound.getData("Limit")))
						
						{
							CustomReporting.logReport("","","Expected value : "+PolicyBound.getData("Limit")+" match with Actual value "+ExpLimit ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
						}
						else
						{
							CustomReporting.logReport("", "","Expected value : "+PolicyBound.getData("Limit")+" does not match with Actual value "+ExpLimit,"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
						}
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
					
			
			
					if(func._isEnabled(getElement(txt_PolicyLimit)))
					{
						CustomReporting.logReport("","","Policy Limit field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Policy Limit field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
				}
			}
		
		
			if(!dataIssuePolicy.getData("RetentionAttachment").equals(""))
			{
				try
				{
					String ExpRetentionAttachment=getElement(txt_PolRetentionAttachment).getAttribute("value").trim().replace(",", "");
					if(ExpRetentionAttachment.equals(dataIssuePolicy.getData("RetentionAttachment")))
					
					{
						CustomReporting.logReport("","","Expected value : "+dataIssuePolicy.getData("RetentionAttachment")+" match with Actual value "+ExpRetentionAttachment ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "","Expected value : "+dataIssuePolicy.getData("RetentionAttachment")+" does not match with Actual value "+ExpRetentionAttachment,"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
			}
			else
			{
				if(PolicyBound.getData("SubmissionStatus").equals("Quote Lost")||PolicyBound.getData("SubmissionStatus").equals("Indication Lost")||PolicyBound.getData("SubmissionStatus").equals("Quote Outstanding") 
			    		||PolicyBound.getData("SubmissionStatus").equals("Indication Outstanding")||PolicyBound.getData("SubmissionStatus").equals("Policy Bound"))
				{
					try
					{
						String ExpRetentionAttachment=getElement(txt_PolRetentionAttachment).getAttribute("value").trim().replace(",", "");
						if(ExpRetentionAttachment.equals(PolicyBound.getData("RetentionAttachment")))
						
						{
							CustomReporting.logReport("","","Expected value : "+PolicyBound.getData("RetentionAttachment")+" match with Actual value "+ExpRetentionAttachment ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
						}
						else
						{
							CustomReporting.logReport("", "","Expected value : "+PolicyBound.getData("RetentionAttachment")+" does not match with Actual value "+ExpRetentionAttachment,"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
						}
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
					
				
			
					if(func._isEnabled(getElement(txt_PolRetentionAttachment)))
					{
						CustomReporting.logReport("","","Retention/Attachment field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Retention/Attachment  field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
				}
			}
		
		
		
			if(!dataIssuePolicy.getData("isCompanyPortfolio").equals(""))
			{
				if(dataIssuePolicy.getData("isCompanyPortfolio").trim().toLowerCase().equals("yes"))
				{
					
					if(func._isChecked(getElement(red_Portfolio_Yes)))
					{
						CustomReporting.logReport("","","Company Portfolio Yes radio buttion  field is Selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Company Portfolio Yes radio button field is not Selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					if(func._isEnabled(getElement(red_Portfolio_Yes)))
					{
						CustomReporting.logReport("","","Company Portfolio Yes radio buttion  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Company Portfolio Yes radio button field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
				if(dataIssuePolicy.getData("isCompanyPortfolio").trim().toLowerCase().equals("no"))
				{
					if(func._isChecked(getElement(red_Portfolio_No)))
					{
						CustomReporting.logReport("","","Company Portfolio No radio buttion  field is Selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Company Portfolio No radio button field is not Selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					if(func._isEnabled(getElement(red_Portfolio_No)))
					{
						CustomReporting.logReport("","","Company Portfolio No readio button  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Company Portfolio No field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
				
			}
		}
		

		func._checkAttributeValue(getElement(lst_ProductCode), "TEXT", dataIssuePolicy.getData("ProductCode"), softAssert);
		if(func._isEnabled(getElement(lst_ProductCode)))
		{
			CustomReporting.logReport("","","ProductCode  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "ProductCode field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("EverestCompany").equals(""))
		{
			func._checkAttributeValue(getElement(lst_SelectedEverestCompany), "TEXT", dataIssuePolicy.getData("EverestCompany"), softAssert);
		}
		else
		{
			func._checkAttributeValue(getElement(lst_SelectedEverestCompany), "TEXT", NewSubmission.getData("EverestCompany"), softAssert);
			
		}
		if(!func._isEnabled(getElement(lst_EverestCompany)))
		{
			CustomReporting.logReport("","","EverestCompany  field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "EverestCompany field is enable.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(lst_BillType), "TEXT", dataIssuePolicy.getData("BillType"), softAssert);
		if(func._isEnabled(getElement(lst_BillType)))
		{
			CustomReporting.logReport("","","BillType  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "BillType field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(lst_CancelState), "TEXT", dataIssuePolicy.getData("CancelState"), softAssert);
		if(func._isEnabled(getElement(lst_CancelState)))
		{
			CustomReporting.logReport("","","CancelState  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "CancelState field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(lst_PaymentPlan), "TEXT", dataIssuePolicy.getData("PaymentPlan"), softAssert);
		if(func._isEnabled(getElement(lst_PaymentPlan)))
		{
			CustomReporting.logReport("","","PaymentPlan  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "PaymentPlan field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("DatePolicyIssued").equals(""))
		{
			func._checkAttributeValue(getElement(dat_DatePolicyIssued), "value", dataIssuePolicy.getData("DatePolicyIssued"), softAssert);
		}
		if(func._isEnabled(getElement(dat_DatePolicyIssued)))
		{
			CustomReporting.logReport("","","DatePolicyIssued  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "DatePolicyIssued field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!dataIssuePolicy.getData("RenewalStatus").equals(""))
		{
		
			func._checkAttributeValue(getElement(lst_RenewalStatus), "TEXT", dataIssuePolicy.getData("RenewalStatus"), softAssert);
		}
		else
		{
			func._checkAttributeValue(getElement(lst_RenewalStatus), "TEXT", "make selection", softAssert);	
		}
		if(func._isEnabled(getElement(lst_RenewalStatus)))
		{
			CustomReporting.logReport("","","RenewalStatus  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "RenewalStatus field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(dataIssuePolicy.getData("RenewalStatus").equals("Not Available")||dataIssuePolicy.getData("RenewalStatus").equals("Non-Renewed")
				 ||dataIssuePolicy.getData("RenewalStatus").equals("Renewal Lost"))
		 {
			func._checkAttributeValue(getElement(lst_RenewalStatusCode), "TEXT", dataIssuePolicy.getData("RenewalStatusCode"), softAssert);
			if(func._isEnabled(getElement(lst_RenewalStatusCode)))
			{
				CustomReporting.logReport("","","RenewalStatusCode  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "RenewalStatusCode field is not  Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}

		 }
		if(dataIssuePolicy.getData("PremiumFinanced").trim().toLowerCase().equals("on"))
		 {
			if(func._isChecked(getElement(chk_PremiumFinanced)))
			{
				CustomReporting.logReport("","","PremiumFinanced  Check box is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "PremiumFinanced  Check box is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyName), "value", dataIssuePolicy.getData("CompanyName"), softAssert);
			if(func._isEnabled(getElement(txt_FinanceCompanyName)))
			{
				CustomReporting.logReport("","","FinanceCompanyName  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "FinanceCompanyName field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyAddress1), "value", dataIssuePolicy.getData("Address1"), softAssert);
			if(func._isEnabled(getElement(txt_FinanceCompanyAddress1)))
			{
				CustomReporting.logReport("","","FinanceCompanyAddress1  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "FinanceCompanyAddress1 field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyAddress2), "value", dataIssuePolicy.getData("Address2"), softAssert);
			if(func._isEnabled(getElement(txt_FinanceCompanyAddress2)))
			{
				CustomReporting.logReport("","","FinanceCompanyAddress2  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "FinanceCompanyAddress2 field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyAddress3), "value", dataIssuePolicy.getData("Address3"), softAssert);
			if(func._isEnabled(getElement(txt_FinanceCompanyAddress3)))
			{
				CustomReporting.logReport("","","FinanceCompanyAddress3  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "FinanceCompanyAddress3 field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyCity), "value", dataIssuePolicy.getData("City"), softAssert);
			if(func._isEnabled(getElement(txt_FinanceCompanyCity)))
			{
				CustomReporting.logReport("","","FinanceCompanyCity  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "FinanceCompanyCity field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyState), "TEXT", dataIssuePolicy.getData("State"), softAssert);
			if(func._isEnabled(getElement(txt_FinanceCompanyState)))
			{
				CustomReporting.logReport("","","FinanceCompanyState  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "FinanceCompanyState field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyZip1), "value", dataIssuePolicy.getData("ZIP1"), softAssert);
			if(func._isEnabled(getElement(txt_FinanceCompanyZip1)))
			{
				CustomReporting.logReport("","","FinanceCompanyZip1  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "FinanceCompanyZip1 field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyZip2), "value", dataIssuePolicy.getData("ZIP2"), softAssert);
			if(func._isEnabled(getElement(txt_FinanceCompanyZip2)))
			{
				CustomReporting.logReport("","","FinanceCompanyZip2  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "FinanceCompanyZip2 field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyContact), "value", dataIssuePolicy.getData("Contact"), softAssert);
			if(func._isEnabled(getElement(txt_FinanceCompanyContact)))
			{
				CustomReporting.logReport("","","FinanceCompanyContact  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "FinanceCompanyContact field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}

			 
		 }
		if(dataIssuePolicy.getData("PremiumFinanced").trim().toLowerCase().equals("off"))
		{
			if(!func._isChecked(getElement(chk_PremiumFinanced)))
			{
				CustomReporting.logReport("","","PremiumFinanced  Check box is not selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "PremiumFinanced  Check box is selected even though if pass Off from datasheet","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}

	}
	@Override
	public void Verify_BillType_Changes (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataRenewalPolicy = PageDataManager.instance().getPageData("RenewalPolicy",tcID);
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(3000);
		 if(!dataRenewalPolicy.getData("BillType").equals(""))
		 {
			 
			if(func._checkAttributeValue(getElement(lst_BillType), "TEXT",dataRenewalPolicy.getData("BillType"), softAssert))
			{
				CustomReporting.logReport("","","The renewal policy is issued on changing the bill type from "+dataIssuePolicy.getData("BillType")+ "to" +dataRenewalPolicy.getData("BillType"),StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Changing the bill type from " + dataIssuePolicy.getData("BillType")+ "to" +dataRenewalPolicy.getData("BillType") +" is failed during renewal policy ","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				throw new RuntimeException();
			}
			 
			 Thread.sleep(7000);
		 }
	}
	@Override
	public void Verify_RenewalPolicy_Status (String tcID, SoftAssert softAssert) throws Exception
	{
		if(func._checkAttributeValue(getElement(lst_PolicyStatus), "TEXT","Renewal", softAssert))
		{
			CustomReporting.logReport("","","Renewed policy status valve is displayed as Renewel  on the Policy screen for Prior term.",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Renewed policy status valve is not displayed as Renewel  on the Policy screen for Prior term.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			throw new RuntimeException();
		
		}
	
	}
	
	@Override
	public void Verify_DefaultTPA (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataAdmin=PageDataManager.instance().getPageData("Admin", tcID);

			 
		if(func._getAttributeValue(getElement(lst_TPA), "TEXT", softAssert).trim().toLowerCase().equals(dataAdmin.getData("TPA").trim().toLowerCase()))
		{
			CustomReporting.logReport("","","Default TPA value is assigned for the TPA field Depending on Business segment and LOB value in  TPA default assignment table is displayed as default TPA  on Policy screen \r\n" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Default TPA value is assigned for the TPA field Depending on Business segment and LOB value in  TPA default assignment table is not displayed as default TPA  on Policy screen \r\n" + 
					"","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			throw new RuntimeException();
		
		}
	
	}
	
	@Override
	public void Verify_Active_TPAvalues (String tcID, SoftAssert softAssert,List<String> ActiveTPA) throws Exception
	{
		if(func._validateDropdownValues(getElement(lst_TPA), ActiveTPA, false, true, softAssert))
		{
			CustomReporting.logReport("","","All active TPA's are displayed in TPA field on policy screen" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Active TPA's are displayed in TPA field on policy screen are not matching" + 
					"","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			//throw new RuntimeException();

		}
	
	}
	@Override
	public void Verify_ExpairePolicyNum_Retained (String tcID, SoftAssert softAssert) throws Exception
	{
		//WebElement ExpPolnowe=(WebElement)getElement(ExpiringPolicyNo).getNative();
		String ExpiringPolicyNo=getElement("ExpiringPolicyNo").getAttribute("value");
		String ExpiringMod=getElement("ExpiringMod").getAttribute("value");
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		String ActualValue=ExpiringPolicyNo+"-"+ExpiringMod;
		if(ActualValue.equals(dataIssuePolicy.getData("PolicyNumber")))
		{
			CustomReporting.logReport("","","The expired Policy Number is retained in policy screen" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "The expired Policy Number is not retained in policy screen" + 
					"","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			throw new RuntimeException();

		}
	
	}
	
	@Override
	public void Check_BusinessIndicator_Status_InPolicyScreen (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataNewSubmission = null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
		 }
		 
		/*if(func._checkAttributeValue(getElement(lbl_PolPublic),"TEXT","Public",softAssert))
		{
			CustomReporting.logReport("","", "The 'Public' as Label available for selection of Public Business Indicator in policy screen" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}
		else
		{
			CustomReporting.logReport("","", "The 'Public' as Label is not available for selection of Public Business Indicator in policy screen" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();	
		}
		if(func._checkAttributeValue(getElement(lbl_PolPrivate),"TEXT","Private",softAssert))
		{
			CustomReporting.logReport("","", "The 'Private' as Label available for selection of Private Business Indicator in policy screen" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}
		else
		{
			CustomReporting.logReport("","", "The 'Private' as Label is not available for selection of Private Business Indicator in policy screen" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();	
		}
		Thread.sleep(1000);
		String chkPubliclocator=getElement(chk_PolPublic).toString();
		//String chkPubliclocator=func.getCustomElementName(getElement(chk_PolPublic));
		String Publicxpath=chkPubliclocator.split("\\{")[1];
		String chk_PolPublicxpath=Publicxpath.replace("}", "");
		
		if(getWebDriver().findElement(By.xpath(chk_PolPublicxpath)).isEnabled())
		{
			CustomReporting.logReport("","", "Public Business Indicator check box is enable ",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}
		else
		{
			CustomReporting.logReport("","", "Public Business Indicator check box is not enable" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();	
		}
		//String chk_Pravitelocator=func.getCustomElementName(getElement(chk_PolPrivate));
		String chk_Pravitelocator=getElement(chk_PolPrivate).toString();
		String PraviteXpath=chk_Pravitelocator.split("\\{")[1];
		String chk_PraviteXpath=PraviteXpath.replace("}", "");
		if(getWebDriver().findElement(By.xpath(chk_PraviteXpath)).isEnabled())
		{
			CustomReporting.logReport("","", "Private Business Indicator check box is enable ",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}
		else
		{
			CustomReporting.logReport("","", "Private Business Indicator check box is not enable" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();	
		}

			
		if(func._isChecked(getElement(chk_PolPublic)))
		{
			 _click(getElement(chk_PolPublic));
			 func._waitForPageToLoad(getWebDriver(),50L);
		}
	
		if(func._isChecked(getElement(chk_PolPrivate)))
		{
			 _click(getElement(chk_PolPrivate));
			 func._waitForPageToLoad(getWebDriver(),50L);	
		}
		
		
		 _click(getElement(btn_Save));
		// func._waitFor(getElement(msg_SubmissionSuccessmsg), 10, WAIT_FOR.VISIBLE, "");
		   Thread.sleep(5000);	
		   func._waitForPageToLoad(getWebDriver(),50L);
		 if(func._checkAttributeValue(getElement(msg_SubmissionSuccessmsg),"TEXT","Account & Submission information updated successfully!",softAssert))
		 {
			CustomReporting.logReport("","", "Verified that the public/private indicator field are non-mandatory ",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		 }
		 else
		 {
			CustomReporting.logReport("","", "The public/private indicator field are mandatory" + 
						"" + "", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				//throw new RuntimeException();	
		 }*/
	
		
	}
	
	@Override
	public void OpenPolicySearchResult (String tcID, SoftAssert softAssert) throws Exception
	{
		 func._waitForPageToLoad(getWebDriver(),50L);
		 func._waitFor(getElement(lnk_PolicyNum), 500, WAIT_FOR.CLICKABLE, "");
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_click(getElement(lnk_PolicyNum));
			Thread.sleep(5000);
			func._waitForPageToLoad(getWebDriver(),50L);
		
	
	}
	
	@Override
	public void Verify_Policy_ReadOnly_Fields (String tcID, SoftAssert softAssert) throws Exception
	{
		 func._waitForPageToLoad(getWebDriver(),500L);
			Thread.sleep(3000);
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		PageData NewSubmission = null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			NewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 NewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
		 }
		
		
		_click(getElement(tab_Policynumber));
		
		 func._waitForPageToLoad(getWebDriver(),500L);
		Thread.sleep(3000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		Thread.sleep(3000);
		String PolicyNumber=dataIssuePolicy.getData("PolicyNumber").split("-")[0];
		String PolicyMod=dataIssuePolicy.getData("PolicyNumber").split("-")[1];
		if(getElement(getPolicyNumber).getAttribute("value").trim().equals(PolicyNumber))
		{
			CustomReporting.logReport("","","Expected Policy Number : "+PolicyNumber+" match with Actual : " +getElement(getPolicyNumber).getAttribute("value").trim() ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}
		else
		{
			CustomReporting.logReport("", "", "Expected Policy Number : "+PolicyNumber+" does not match with Actual :" +getElement(getPolicyNumber).getAttribute("value").trim(),"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(getPolicyNumber)))
		{
			CustomReporting.logReport("","","PolicyNumber Text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," PolicyNumber Text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(getElement(getPolicyMod).getAttribute("value").trim().equals(PolicyMod))
		{
			CustomReporting.logReport("","","Expected Policy Mod : "+PolicyMod+" match with Actual : " +getElement(getPolicyMod).getAttribute("value").trim() ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}
		else
		{
			CustomReporting.logReport("", "", "Expected Policy Mod : "+PolicyMod+" does not match with Actual :" +getElement(getPolicyMod).getAttribute("value").trim(),"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!func._isEnabled(getElement(getPolicyMod)))
		{
			CustomReporting.logReport("","","PolicyMod List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," PolicyMod List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(chk_BillIssued)))
		{
			CustomReporting.logReport("","","BillIssued Check box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "","BillIssued Check box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("PolicyEffectiveDate").equals(""))
		{
		func._checkAttributeValue(getElement(dat_PolicyEffectiveDate), "value", dataIssuePolicy.getData("PolicyEffectiveDate"), softAssert);
		}
		else
		{
						
			func._checkAttributeValue(getElement(dat_PolicyEffectiveDate), "value", func.Date_Manipulation("", "Now", 0), softAssert);	
		}
		if(!func._isEnabled(getElement(dat_PolicyEffectiveDate)))
		{
			CustomReporting.logReport("","","PolicyEffectiveDate Text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," PolicyEffectiveDate Text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("PolicyExpirationDate").equals(""))
		{
			int offset= Integer.valueOf(dataIssuePolicy.getData("PolicyExpirationDate").split("-")[0].trim());
	    	String OptValue=dataIssuePolicy.getData("PolicyExpirationDate").split("-")[1].trim();
			func._checkAttributeValue(getElement(dat_PolicyExpirationDate), "value",func.Date_Manipulation("",OptValue, offset), softAssert);
		}
		else
		{
			if(!dataIssuePolicy.getData("PolicyEffectiveDate").equals(""))
			{
			String SubmissionExpDate= func.Date_Manipulation(dataIssuePolicy.getData("PolicyEffectiveDate"), "YEAR", 1);
			func._checkAttributeValue(getElement(dat_PolicyExpirationDate), "value",SubmissionExpDate, softAssert);
			}
			else
			{
								
				 String SubmissionExpDate= func.Date_Manipulation("", "YEAR", 1);
					func._checkAttributeValue(getElement(dat_PolicyExpirationDate), "value",SubmissionExpDate, softAssert);
			}
		}
		if(!func._isEnabled(getElement(dat_PolicyExpirationDate)))
		{
			CustomReporting.logReport("","","PolicyExpirationDate Text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," PolicyExpirationDate Text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_PolicyStatus), "TEXT", dataIssuePolicy.getData("PolicyStatus"), softAssert);
		if(!func._isEnabled(getElement(lst_PolicyStatus)))
		{
			CustomReporting.logReport("","","PolicyStatus Text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," PolicyStatus Text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("CancelledReasonCode").equals(""))
		{
			func._checkAttributeValue(getElement(lst_CancelledReasonCode), "TEXT", dataIssuePolicy.getData("CancelledReasonCode"), softAssert);
		}
		else
		{
			func._checkAttributeValue(getElement(lst_CancelledReasonCode), "TEXT", "make selection", softAssert);
		}
		if(!func._isEnabled(getElement(lst_CancelledReasonCode)))
		{
			CustomReporting.logReport("","","CancelledReasonCode List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," CancelledReasonCode List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("DateBound").equals(""))
		{
			func._checkAttributeValue(getElement(dat_DateBound), "value", dataIssuePolicy.getData("DateBound"), softAssert);
		}
		else
		{
			
			func._checkAttributeValue(getElement(dat_DateBound), "value", func.Date_Manipulation("", "Now", 0), softAssert);
		}
		if(!func._isEnabled(getElement(dat_DateBound)))
		{
			CustomReporting.logReport("","","DateBound Text box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," DateBound Text box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("BoundLineBusiness").equals(""))
		{
			func._checkAttributeValue(getElement(lst_BoundLineBusiness), "TEXT", dataIssuePolicy.getData("BoundLineBusiness"), softAssert);
		}
		else
		{
			func._checkAttributeValue(getElement(lst_BoundLineBusiness), "TEXT", NewSubmission.getData("SubmissionLOB"), softAssert);
		}
		if(!func._isEnabled(getElement(lst_BoundLineBusiness)))
		{
			CustomReporting.logReport("","","Bound LOB List box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "","Bound LOB List box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!dataIssuePolicy.getData("PolicyPremium").equals(""))
		{
			try
			{
				String ExpPolicyPremium=getElement(txt_PolicyPremium).getAttribute("value").trim().replace(",", "");
				if(ExpPolicyPremium.equals(dataIssuePolicy.getData("PolicyPremium")))
				
				{
					CustomReporting.logReport("","","Expected value : "+dataIssuePolicy.getData("PolicyPremium")+" match with Actual value "+ExpPolicyPremium ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "","Expected value : "+dataIssuePolicy.getData("PolicyPremium")+" does not match with Actual value "+ExpPolicyPremium,"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			
			
		}
		else
		{
			try
			{
				String ExpPolicyPremium=getElement(txt_PolicyPremium).getAttribute("value").trim().replace(",", "");
				if(ExpPolicyPremium.equals(NewSubmission.getData("QuotedPremium")))
				
				{
					CustomReporting.logReport("","","Expected value : "+NewSubmission.getData("QuotedPremium")+" match with Actual value "+ExpPolicyPremium ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "","Expected value : "+NewSubmission.getData("QuotedPremium")+" does not match with Actual value "+ExpPolicyPremium,"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			
		}
		if(!func._isEnabled(getElement(txt_PolicyPremium)))
		{
			CustomReporting.logReport("","","PolicyPremium text box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," PolicyPremium text box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("NonCommissionableFee").equals(""))
		{
			String ExpNCF=getElement(txt_NonCommissionableFee).getAttribute("value").trim().replace(",", "");
			if(ExpNCF.equals(dataIssuePolicy.getData("NonCommissionableFee")))
				
			{
				CustomReporting.logReport("","","Expected value : "+dataIssuePolicy.getData("NonCommissionableFee")+" match with Actual value "+ExpNCF ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","Expected value : "+dataIssuePolicy.getData("NonCommissionableFee")+" does not match with Actual value "+ExpNCF,"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			
			
		}
		else
		{
			func._checkAttributeValue(getElement(txt_NonCommissionableFee), "value", "0.00", softAssert);	
		}
		if(!func._isEnabled(getElement(txt_NonCommissionableFee)))
		{
			CustomReporting.logReport("","","NonCommissionableFee Text box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," NonCommissionableFee Text box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("Commission").equals(""))
		{
			func._checkAttributeValue(getElement(txt_Commission), "value", dataIssuePolicy.getData("Commission"), softAssert);
			
		}
		else
		{
			func._checkAttributeValue(getElement(txt_Commission), "value", "0.00", softAssert);	
		}
		if(!func._isEnabled(getElement(txt_Commission)))
		{
			CustomReporting.logReport("","","Commission Text box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," Commission Text box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}

		if(dataIssuePolicy.getData("MultiStatePolicy").trim().toLowerCase().equals("yes"))
		{
			if(func._isChecked(getElement(red_MultiStatePolicy_Yes)))
				
			{
				CustomReporting.logReport("","","MultiState Policy Yes radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "MultiState Policy Yes radio button field is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
		if(!func._isEnabled(getElement(red_MultiStatePolicy_Yes)))
		{
			CustomReporting.logReport("","","MultiStatePolicy Yes Radiobutton is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," MultiStatePolicy Yes Radiobutton is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(dataIssuePolicy.getData("MultiStatePolicy").trim().toLowerCase().equals("no"))
		{
			if(func._isChecked(getElement(red_MultiStatePolicy_No)))
			
			{
				CustomReporting.logReport("","","MultiState Policy No radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "MultiState Policy No radio button field is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
		if(!func._isEnabled(getElement(red_MultiStatePolicy_No)))
		{
			CustomReporting.logReport("","","MultiStatePolicy No Radiobutton is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," MultiStatePolicy No Radiobutton is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("ProductCode").equals(""))
		{
			func._checkAttributeValue(getElement(lst_ProductCode), "TEXT", dataIssuePolicy.getData("ProductCode"), softAssert);
			
		}
		if(!func._isEnabled(getElement(lst_ProductCode)))
		{
			CustomReporting.logReport("","","ProductCode) List box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," ProductCode) List box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("EverestCompany").equals(""))
		{
			func._checkAttributeValue(getElement(lst_EverestCompany), "TEXT", dataIssuePolicy.getData("EverestCompany"), softAssert);
			
		}
		else
		if(!NewSubmission.getData("EverestCompany").equals(""))
		{
			func._checkAttributeValue(getElement(lst_EverestCompany), "TEXT", NewSubmission.getData("EverestCompany"), softAssert);
			
		}
			
		
		if(!func._isEnabled(getElement(lst_EverestCompany)))
		{
			CustomReporting.logReport("","","EverestCompany List box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," EverestCompany List box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_BillType), "TEXT", dataIssuePolicy.getData("BillType"), softAssert);
		if(!func._isEnabled(getElement(lst_BillType)))
		{
			CustomReporting.logReport("","","BillType List box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," BillType List box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_CancelState), "TEXT", dataIssuePolicy.getData("CancelState"), softAssert);
		if(!func._isEnabled(getElement(lst_CancelState)))
		{
			CustomReporting.logReport("","","CancelState List box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," CancelState List box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("FRPurchased").equals("")&&dataIssuePolicy.getData("FRPurchased").trim().toLowerCase().equals("on"))
		{
			if(func._isChecked(getElement(chk_Policy_FRPurchased)))
			{
				CustomReporting.logReport("","","Fac Reins Purchased Check Box is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","Fac Reins Purchased Check Box is not selected","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			
		}
		

		if(!func._isEnabled(getElement(chk_Policy_FRPurchased)))
		{
			CustomReporting.logReport("","","Fac Reins Purchased Check Box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," Fac Reins Purchased Check Box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(lst_PaymentPlan), "TEXT", dataIssuePolicy.getData("PaymentPlan"), softAssert);
		if(!func._isEnabled(getElement(lst_PaymentPlan)))
		{
			CustomReporting.logReport("","","PaymentPlan List box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," PaymentPlan List box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!func._isEnabled(getElement(dat_DatePolicyIssued)))
		{
			CustomReporting.logReport("","","Date Policy Issued Text Box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "","Date Policy Issued Text Box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataIssuePolicy.getData("PremiumFinanced").equals("")&&dataIssuePolicy.getData("PremiumFinanced").trim().toLowerCase().equals("on"))
		{
			if(func._isChecked(getElement(chk_PremiumFinanced)))
			{
				CustomReporting.logReport("","","Premium Finance CheckBox is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","Premium Finance CheckBox is not selected","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			
		}
		if(!dataIssuePolicy.getData("PremiumFinanced").equals("")&&dataIssuePolicy.getData("PremiumFinanced").trim().toLowerCase().equals("off"))
		{
			if(func._isChecked(getElement(chk_PremiumFinanced)))
			{
				CustomReporting.logReport("", "","Premium Finance CheckBox is  selected","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
						
			}
			else
			{
				CustomReporting.logReport("","","Premium Finance CheckBox is not selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
					
			}
			
		}
		if(!func._isEnabled(getElement(chk_PremiumFinanced)))
		{
			CustomReporting.logReport("","","Premium Finance CheckBox is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "","Premium Finance CheckBox is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(func._isChecked(getElement(chk_PremiumFinanced)))
		{
			func._checkAttributeValue(getElement(txt_FinanceCompanyName), "value", dataIssuePolicy.getData("CompanyName"), softAssert);
			if(!func._isEnabled(getElement(txt_FinanceCompanyName)))
			{
				CustomReporting.logReport("","","FinanceCompanyName text box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","FinanceCompanyName text box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyAddress1), "value", dataIssuePolicy.getData("Address1"), softAssert);
			if(!func._isEnabled(getElement(txt_FinanceCompanyAddress1)))
			{
				CustomReporting.logReport("","","FinanceCompanyAddress1 text box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","FinanceCompanyAddress1 text box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyAddress2), "value", dataIssuePolicy.getData("Address2"), softAssert);
			if(!func._isEnabled(getElement(txt_FinanceCompanyAddress2)))
			{
				CustomReporting.logReport("","","FinanceCompanyAddress2 text box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","FinanceCompanyAddress2 text box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyAddress3), "value", dataIssuePolicy.getData("Address3"), softAssert);
			if(!func._isEnabled(getElement(txt_FinanceCompanyAddress3)))
			{
				CustomReporting.logReport("","","FinanceCompanyAddress3 text box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","FinanceCompanyAddress3 text box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyCity), "value", dataIssuePolicy.getData("City"), softAssert);
			if(!func._isEnabled(getElement(txt_FinanceCompanyCity)))
			{
				CustomReporting.logReport("","","FinanceCompanyCity text box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","FinanceCompanyCity text box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyState), "TEXT", dataIssuePolicy.getData("State"), softAssert);
			if(!func._isEnabled(getElement(txt_FinanceCompanyState)))
			{
				CustomReporting.logReport("","","FinanceCompanyState List box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","FinanceCompanyState List box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyZip2), "value", dataIssuePolicy.getData("ZIP2"), softAssert);
			if(!func._isEnabled(getElement(txt_FinanceCompanyZip2)))
			{
				CustomReporting.logReport("","","FinanceCompanyZip2 Text box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","FinanceCompanyZip2 Text box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyZip1), "value", dataIssuePolicy.getData("ZIP1"), softAssert);
			if(!func._isEnabled(getElement(txt_FinanceCompanyZip1)))
			{
				CustomReporting.logReport("","","FinanceCompanyZip1 Text box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","FinanceCompanyZip1 Text box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_FinanceCompanyContact), "value", dataIssuePolicy.getData("Contact"), softAssert);
			if(!func._isEnabled(getElement(txt_FinanceCompanyContact)))
			{
				CustomReporting.logReport("","","FinanceCompanyContact Text box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","FinanceCompanyContact Text box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			
		}
		if(!dataIssuePolicy.getData("RenewalStatus").equals(""))
		{
			func._checkAttributeValue(getElement(lst_RenewalStatus), "TEXT", dataIssuePolicy.getData("RenewalStatus"), softAssert);
			
		}
		if(!func._isEnabled(getElement(lst_RenewalStatus)))
		{
			CustomReporting.logReport("","","RenewalStatus List box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "","RenewalStatus List box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(dataIssuePolicy.getData("RenewalStatus").equals("Not Available")||dataIssuePolicy.getData("RenewalStatus").equals("Non-Renewed")
				 ||dataIssuePolicy.getData("RenewalStatus").equals("Renewal Lost"))
		{
			if(!dataIssuePolicy.getData("RenewalStatusCode").equals(""))
			{
				func._checkAttributeValue(getElement(lst_RenewalStatusCode), "TEXT", dataIssuePolicy.getData("RenewalStatusCode"), softAssert);
				
			}
			
			if(!func._isEnabled(getElement(lst_RenewalStatusCode)))
			{
				CustomReporting.logReport("","","RenewalStatusCode List box is displayed as disabled after search the Policy as a Billing/PM user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","RenewalStatusCode List box is not displayed as disabled after search the Policy as a Billing/PM user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
		
	
	}
	
	@Override
	public void Verify_ChkInstallFee_DefaultValue(String tcID, SoftAssert softAssert) throws Exception
	{
		
		Thread.sleep(5000);
		 func._waitForPageToLoad(getWebDriver(),50L);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if(func._isChecked((getElement(chk_InstallmentFees))))
			{
				CustomReporting.logReport("", ""," Installment Fee checkbox is default to Y on Payment Plan Details","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
				//throw new RuntimeException();
			}
			else
			{
				CustomReporting.logReport("",""," Installment Fee checkbox is default to N on Payment Plan Details" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());			
			}
		
	}
	@Override
	public void Verify_ColInstallFee_BillInstalment(String tcID, SoftAssert softAssert,String PaymentType) throws Exception
	{
		PageData dataPayment = PageDataManager.instance().getPageData("Payment",tcID);
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		StringBuilder result = new StringBuilder();
		String PDFPath="";
		if(PaymentType.equals("payment"))
		{
			PDFPath=dataPayment.getData("PaymentDownloadPath");
		}
		else
		{
			PDFPath=dataPayment.getData("BIllingDownloadPath");	
		}
		
		if(!dataIssuePolicy.getData("InstallmentFees").equals(""))
		 {
			if(dataIssuePolicy.getData("BillType").trim().equals("Agent Bill"))
			{
				String expValue=result.append("Installment ").append("\n").append("Fee").toString();	
				if(func._verifyPDFDocument(PDFPath,expValue))
					//if(func._verifyPDFDocument("D:\\Users\\sbasavar\\Desktop\\git\\Automation_Escape\\resources\\DownLoadFiles\\ViewBill_20_36_04.pdf",expValue))
				{
					CustomReporting.logReport("","","Installment Fee' column is displayed on Agent  Bill Installment Schedule after selected it in Policy screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
					
				}
				else
				{
					
					CustomReporting.logReport("", "","'Installment Fee' column is not displayed on Agent Bill Installment Schedule even if selected it in Policy screen,","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
					throw new RuntimeException();
				}
			}
			if(dataIssuePolicy.getData("BillType").trim().equals("Direct Bill"))
			{
				//String expValue=result.append("Installment ").append("\n").append("Fee").toString();	
				if(func._verifyPDFDocument(PDFPath,"Installment Fee"))
				{
					CustomReporting.logReport("","","Installment Fee' column is displayed on Direct  Bill Installment Schedule after selected it in Policy screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
					
				}
				else
				{
					
					CustomReporting.logReport("", "","'Installment Fee' column is not displayed on Direct Bill Installment Schedule even if selected it in Policy screen,","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
					throw new RuntimeException();
				}
			}
		 }
		else
		{
			if(dataIssuePolicy.getData("BillType").trim().equals("Agent Bill"))
			{
				String expValue=result.append("Installment ").append("\n").append("Fee").toString();	
				if(!func._verifyPDFDocument(PDFPath,expValue))
					
				{
					CustomReporting.logReport("","","Installment Fee' column is not displayed on Agent Bill Installment Schedule when Installment Fee checkbox is not selected in Policy screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
					
				}
				else
				{
					
					CustomReporting.logReport("", "","'Installment Fee' column is still displaying on Agent Bill Installment Schedule even if Installment Fee checkbox is not selected in Policy screen,","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
					throw new RuntimeException();
				}
			}
			if(dataIssuePolicy.getData("BillType").trim().equals("Direct Bill"))
			{
				String expValue=result.append("Installment ").append("\n").append("Fee").toString();	
				if(func._verifyPDFDocument(PDFPath,expValue))
				{
					CustomReporting.logReport("","","Installment Fee' column is not displayed on Direct Bill Installment Schedule when Installment Fee checkbox is not selected in Policy screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
					
				}
				else
				{
					
					CustomReporting.logReport("", "","'Installment Fee' column is still displaying on Direct Bill Installment Schedule even if Installment Fee checkbox is not selected in Policy screen,","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
					throw new RuntimeException();
				}
			}
		 
			
		}
		
	}
	
	
	@Override
	public void Verify_Column_TaxesFees_and_Surcharges(String tcID, SoftAssert softAssert,String PaymentType) throws Exception
	{
		Thread.sleep(5000);
		PageData dataPayment = PageDataManager.instance().getPageData("Payment",tcID);
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		StringBuilder result = new StringBuilder();
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), "");
		String PDFPath="";
		if(PaymentType.equals("payment"))
		{
			PDFPath=dataPayment.getData("PaymentDownloadPath");
		}
		else
		{
			PDFPath=dataPayment.getData("BIllingDownloadPath");	
		}
		
		if(dataIssuePolicy.getData("BillType").trim().equals("Agent Bill"))
		{

			String expValue=result.append("Taxes, Fees and ").append("\n").append("Surcharges").toString();	
			if(func._verifyPDFDocument(PDFPath,expValue))
				
			{
				CustomReporting.logReport("","","'Assessment Fees/Surcharges' header is renamed  to 'Taxes, Fees and Surcharges' on Agency Bill Installment" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","'Assessment Fees/Surcharges' header is not renamed  to 'Taxes, Fees and Surcharges' on Agency Bill Installment","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
				throw new RuntimeException();
			}
		}
		if(dataIssuePolicy.getData("BillType").trim().equals("Direct Bill"))
		{
			String expValue=result.append("Taxes, Fees and ").append("\n").append("Surcharges").toString();		
			if(func._verifyPDFDocument(PDFPath,expValue))
			{
				CustomReporting.logReport("","","'Assessment Fees/Surcharges' header is renamed  to 'Taxes, Fees and Surcharges' on Direct Bill Installment" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","'Assessment Fees/Surcharges' header is not renamed  to 'Taxes, Fees and Surcharges' on Direct Bill Installment","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
				throw new RuntimeException();
			}
		}
				
	}
	

	@Override
	public void Verify_Wording_Bills_InstallmentSchedule(String tcID, SoftAssert softAssert,String PaymentType) throws Exception
	{
		
		Thread.sleep(10000);
		PageData dataPayment = PageDataManager.instance().getPageData("Payment",tcID);
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		StringBuilder result = new StringBuilder();
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), "");
		String PDFPath="";
		if(PaymentType.equals("payment"))
		{
			PDFPath=dataPayment.getData("PaymentDownloadPath");
		}
		else
		{
			PDFPath=dataPayment.getData("BIllingDownloadPath");	
		}
		
		if(dataIssuePolicy.getData("BillType").trim().equals("Agent Bill"))
		{
			
			String expValue=result.append("Everest Insurance is committed to providing you with the best possible Customer Service. We are ").append("\n").append("available for your calls Monday through Friday between the hours of 8:30 AM and 7:00 PM ET. ").append("\n").append("Billing/Accounting Questions: Please call 1-877-604-1995").toString();
			
			if(func._verifyPDFDocument(PDFPath,expValue))
				
			{
				CustomReporting.logReport("","","'" + expValue+"' displayed on Agency Bill Installment document" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","'" +expValue+ "'  is not displayed on Agency Bill Installment document","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
				//throw new RuntimeException();
			}
		}
		if(dataIssuePolicy.getData("BillType").trim().equals("Direct Bill"))
		{
			String expValue=result.append("Everest Insurance is committed to providing you with the best possible Customer Service. We are available ").append("\n").append("for your calls Monday through Friday between the hours of 8:30 AM and 7:00 PM ET. Billing/Accounting ").append("\n").append("Questions: Please call 1-877-604-1995").toString();	
			if(func._verifyPDFDocument(PDFPath,expValue))
				
			{
				CustomReporting.logReport("","","'" + expValue+"' displayed on Direct Bill Installment document" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","'" +expValue+ "'  is not displayed on Direct Bill Installment document","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
				//throw new RuntimeException();
			}
		}
				
	}
	
	
	
	@Override
	public void Verify_RenewalPolicy_Stataus (String tcID, SoftAssert softAssert) throws Exception
	{
		if(func._checkAttributeValue(getElement(lst_PolicyStatus), "TEXT", "make selection", softAssert))
		{
			CustomReporting.logReport("","","Renewal status drop down value is displayed as '"+func._getAttributeValue(getElement(lst_PolicyStatus), "TEXT", softAssert)+"' on Policy screen for Prior term." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			
			CustomReporting.logReport("", "","Renewal status drop down value is displayed as '"+func._getAttributeValue(getElement(lst_PolicyStatus),"TEXT", softAssert)+"' instead of 'make selection' on Policy screen for Prior term.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			throw new RuntimeException();
		}
			
	}
	
	@Override
	public void Verify_GateKeeper_Editable_PolicyEffDate (String tcID, SoftAssert softAssert) throws Exception
	{
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		if(func._isEnabled(getElement(dat_PolicyEffectiveDate)))
		{
			CustomReporting.logReport("","","Gate Keeper user has the ability to edit the Eff date on the Policy screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			
			CustomReporting.logReport("", "","Gate Keeper user has not the ability to edit the Eff date on the Policy screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			throw new RuntimeException();
		}
			
	}
	
	@Override
	public void Verify_Otherthen_GateKeeperUser_Editable_PolicyEffDate (String tcID, SoftAssert softAssert) throws Exception
	{
		
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		if(!func._isEnabled(getElement(dat_PolicyEffectiveDate)))
		{
			CustomReporting.logReport("","","No Other then Gate Keeper user has the ability to edit the Eff date on the Policy screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			
			CustomReporting.logReport("", ""," Other then Gate Keeper user has the the ability to edit the Eff date on the Policy screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			throw new RuntimeException();
		}
			
	}
	
	@Override
	public void verify_AdminUser_Edit_EffDate (String tcID, SoftAssert softAssert) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		 PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 PageData dataNewSubmission =null;
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
 		 {
 	
	 		dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
 		 }
 		 else
 		 {
 			dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
 		 }
		
		String currEffDate=func._getAttributeValue(getElement(dat_PolicyEffectiveDate), "value", softAssert);
		String BUser=getWebDriver().findElement(By.xpath("//a[text()='Logout']/..")).getText();
		if(BUser.contains("Escape Admin"))
		{
			if(func._isEnabled(getElement(dat_PolicyEffectiveDate)))
			{
				 _setValue(getElement(dat_PolicyEffectiveDate),func.Date_Manipulation(currEffDate, "Days", 2));
				 WebElement elm = (WebElement) getElement(dat_PolicyEffectiveDate).getNative();
		         elm.sendKeys(Keys.TAB);
				 func._waitForPageToLoad(getWebDriver(),50L);
				 
				CustomReporting.logReport("","","Verified that the user admin is the responsible for updating the policy effective date" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","Admin user is not able updating the policy effective date","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
			
			//_setValue(getElement(lst_PaymentPlan),dataIssuePolicy.getData("PaymentPlan"));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 Thread.sleep(10000);
			 _click(getElement(btn_Save));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 Thread.sleep(2000);
			 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
		}
		else
		{
			 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if(!func._isEnabled(getElement(dat_PolicyEffectiveDate)))
			{
				CustomReporting.logReport("","","Verified that that other then user admin is not able to  update the policy effective date" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","Other then admin user is also able to updating the policy effective date","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
		}

	}
	
	@Override
	public void verify_PaymentPlan_editable_After_AddPayment (String tcID, SoftAssert softAssert,String transType) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(5000);
		//String currEffDate=func._getAttributeValue(getElement(dat_PolicyEffectiveDate), "value", softAssert);
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 PageData dataNewSubmission =null;
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			 dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
		 }
		 
		
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if(transType.toLowerCase().equals("new"))
		{
			if(func._isEnabled(getElement(lst_PaymentPlan)))
			{
				CustomReporting.logReport("","","PaymentPlan field is editable  after the admin user changes the policy effective date ,add payment and saves the screen." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","PaymentPlan field is not editable  after the admin user changes the policy effective date ,add payment and saves the screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			}
			
			if(func._isEnabled(getElement(lst_BillType)))
			{
				CustomReporting.logReport("","","BillType field is editable  after the admin user changes the policy effective date ,add payment and saves the screen." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","BillType field is not editable  after the admin user changes the policy effective date ,add payment and saves the screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			}
			
			if(func._isEnabled(getElement(lst_ProductCode)))
			{
				CustomReporting.logReport("","","ProductCode field is editable  after the admin user changes the policy effective date ,add payment and saves the screen." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","ProductCode field is not editable  after the admin user changes the policy effective date ,add payment and saves the screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			}
			if(!func._isEnabled(getElement(lst_EverestCompany)))
			{
				CustomReporting.logReport("","","EverestCompany field is editable  after the admin user changes the policy effective date ,add payment and saves the screen." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","EverestCompany field is not editable  after the admin user changes the policy effective date ,add payment and saves the screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			}
			if(func._isEnabled(getElement(lst_CancelState)))
			{
				CustomReporting.logReport("","","CancelState field is editable  after the admin user changes the policy effective date ,add payment and saves the screen." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","CancelState field is not editable  after the admin user changes the policy effective date ,add payment and saves the screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			}
		}
		/*if(transType.toLowerCase().equals("renewal"))
		{
			if(func._isEnabled(getElement(lst_PaymentPlan)))
			{
				CustomReporting.logReport("","","PaymentPlan field is enable after Admin changes the effective date, payment plan and save the changes while renewal the transaction" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","PaymentPlan field is not enable even after Admin changes the effective date , payment plan  and save the changes while renewal the transaction","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			}
			if(func._isEnabled(getElement(lst_BillType)))
			{
				CustomReporting.logReport("","","BillType field is enable after Admin changes the effective date, payment plan and save the changes while renewal the transaction" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				 
			}
			else
			{
				
				CustomReporting.logReport("", "","BillType field is not enable even after Admin changes the effective date , payment plan  and save the changes while renewal the transaction","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
				
			}
			if(func._isEnabled(getElement(lst_ProductCode)))
			{
				CustomReporting.logReport("","","ProductCode field is enable after Admin changes the effective date, payment plan and save the changes while renewal the transaction" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","ProductCode field is not enable even after Admin changes the effective date , payment plan  and save the changes while renewal the transaction","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
				
			}
			if(func._isEnabled(getElement(lst_EverestCompany)))
			{
				CustomReporting.logReport("","","EverestCompany field is enable after Admin changes the effective date, payment plan and save the changes while renewal the transaction" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","EverestCompany field is not enable even after Admin changes the effective date , payment plan  and save the changes while renewal the transaction","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
				
			}
			if(func._isEnabled(getElement(lst_CancelState)))
			{
				CustomReporting.logReport("","","CancelState field is enable after Admin changes the effective date, payment plan and save the changes while renewal the transaction" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","CancelState field is not enable even after Admin changes the effective date , payment plan  and save the changes while renewal the transaction","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
		}*/
		if(func._checkAttributeValue(getElement(lst_PaymentPlan), "TEXT", "make selection", softAssert))
		
		 {
			 
			 Thread.sleep(2000);
			 _setValue(getElement(lst_PaymentPlan),dataIssuePolicy.getData("PaymentPlan"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }

	}
	
	@Override
	public void verify_PaymentPlan_editable_Before_AddPayment (String tcID, SoftAssert softAssert,String transType) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(5000);
		//String currEffDate=func._getAttributeValue(getElement(dat_PolicyEffectiveDate), "value", softAssert);
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 PageData dataNewSubmission =null;
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			 dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
		 }
		 
		 
		
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if(transType.toLowerCase().equals("new"))
		{
			if(func._isEnabled(getElement(lst_PaymentPlan)))
			{
				CustomReporting.logReport("","","PaymentPlan field is editable after the admin user created a policy ,added  the policy effective date ,but  did not add payment and saves the screen." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","PaymentPlan field is not editable after the admin user created a policy added  the policy effective date ,but  did not add payment and saves the screen.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			}
			
			if(func._isEnabled(getElement(lst_BillType)))
			{
				CustomReporting.logReport("","","BillType field is editable after the admin user created a policy added  the policy effective date ,but  did not add payment and saves the screen." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","BillType field is not editable after the admin user created a policy added  the policy effective date ,but  did not add payment and saves the screen.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			}
			
			if(func._isEnabled(getElement(lst_ProductCode)))
			{
				CustomReporting.logReport("","","ProductCode field is editable after the admin user created a policy added  the policy effective date ,but  did not add payment and saves the screen." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","ProductCode field is not editable after the admin user created a policy added  the policy effective date ,but  did not add payment and saves the screen.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			}
			if(!func._isEnabled(getElement(lst_EverestCompany)))
			{
				CustomReporting.logReport("","","EverestCompany field is disabled after the admin user created a policy added  the policy effective date ,but  did not add payment and saves the screen." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","EverestCompany field is  editable after the admin user created a policy added  the policy effective date ,but  did not add payment and saves the screen.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			}
			if(func._isEnabled(getElement(lst_CancelState)))
			{
				CustomReporting.logReport("","","CancelState field is editable  after the admin user created a policy added  the policy effective date ,but  did not add payment and saves the screen." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","CancelState field is not editable after the admin user created a policy added  the policy effective date ,but  did not add payment and saves the screen.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			}
		}
	}
	@Override
	public void verify_PaymentPlan_MakeSelection (String tcID, SoftAssert softAssert,String transType) throws Exception
	{
		String currEffDate=func._getAttributeValue(getElement(dat_PolicyEffectiveDate), "value", softAssert);
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 PageData dataNewSubmission =null;
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			 dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
		 }
		 
		
		String BUser=getWebDriver().findElement(By.xpath("//a[text()='Logout']/..")).getText();
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if(BUser.contains("Escape Admin"))
		{
			AddPolicy objPolicy = (AddPolicy) PageManager.instance().createPage( AddPolicy.class, getWebDriver());
			objPolicy.verify_AdminUser_Edit_EffDate(tcID, softAssert);
			
			if(transType.toLowerCase().equals("new"))
			{
				if(func._checkAttributeValue(getElement(lst_PaymentPlan), "TEXT", "make selection", softAssert))
				{
					CustomReporting.logReport("","","Verify that 'Payment Plan' changed to 'make selection'  when policy's original date is changed" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
				}
				else
				{
					
					CustomReporting.logReport("", "","Verify that 'Payment Plan' value is not changed to 'make selection'  when policy's original date is changed","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
				
				}
			}
			/*if(transType.toLowerCase().equals("renewal"))
			{
				if(func._checkAttributeValue(getElement(lst_PaymentPlan), "TEXT", "make selection", softAssert))
				{
					CustomReporting.logReport("","","Verify that 'Payment Plan' changed to 'make selection'  when policy's original date is changed while renewal the transaction" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
				}
				else
				{
					
					CustomReporting.logReport("", "","Verify that 'Payment Plan' value is not changed to 'make selection'  when policy's original date is changed while renewal the transaction","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
				
				}
			}*/
		}
		if(transType.toLowerCase().equals("new"))
		{
	
			if(func._isEnabled(getElement(lst_BillType)))
			{
				CustomReporting.logReport("","","Verified that 'BillType' value is remain opend after admin user changed policy's original date and saved" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","The'BillType'value is not remain opend after Admin user policy's original date is changed saved","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
		 
			if(func._isEnabled(getElement(lst_ProductCode)))
			{
				CustomReporting.logReport("","","Verified that 'ProductCode' value is remain opend after admin user changed policy's original date and save" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","The 'ProductCode' value is not remain opend after admin user  changed the policy's original date and save ","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
			if(func._isEnabled(getElement(lst_CancelState)))
			{
				CustomReporting.logReport("","","Verified that 'CancelState' value is remain opend after admin user changed the policy's original date and save" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","The 'CancelState' value is not remain opend after admin user changed policy's original date and save","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
			if(!func._isEnabled(getElement(lst_EverestCompany)))
			
			{
				CustomReporting.logReport("","","Verified that 'EverestCompany' field is disabled after Admin user changed the policy's original date and save" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","The 'EverestCompany' value is remain editable after admin user changed the policy's original date and save","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
			
			
		}
		/*if(transType.toLowerCase().equals("renewal"))
		{
			
			if(func._isEnabled(getElement(lst_BillType)))
			{
				CustomReporting.logReport("","","Verified that 'BillType' value is remain opend after admin user changed policy's original date and saved" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","The'BillType'value is not remain opend after Admin user policy's original date is changed saved","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
		 
			if(func._isEnabled(getElement(lst_ProductCode)))
			{
				CustomReporting.logReport("","","Verified that 'ProductCode' value is remain opend after admin user changed policy's original date and save" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","The 'ProductCode' value is not remain opend after admin user  changed the policy's original date and save ","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
			if(func._isEnabled(getElement(lst_CancelState)))
			{
				CustomReporting.logReport("","","Verified that 'CancelState' value is remain opend after admin user changed the policy's original date and save" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","The 'CancelState' value is not remain opend after admin user changed policy's original date and save","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
			if(func._isEnabled(getElement(lst_EverestCompany)))
			
			{
				CustomReporting.logReport("","","Verified that 'EverestCompany' value is remain opend after Admin user changed the policy's original date and save" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","The 'EverestCompany' value is not remain Opend after admin user changed the policy's original date and save","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
			
			
		
			if(func._checkAttributeValue(getElement(lst_BillType), "TEXT", dataIssuePolicy.getData("BillType"), softAssert))
			{
				CustomReporting.logReport("","","Verified that 'BillType' value is remain same when policy's original date is changed while renewal the transaction" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","The'BillType'value is not remain same after policy's original date is changed while renewal the transaction","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
		 
			if(func._checkAttributeValue(getElement(lst_ProductCode), "TEXT", dataIssuePolicy.getData("ProductCode"), softAssert))
			{
				CustomReporting.logReport("","","Verified that 'ProductCode' value is remain same when policy's original date is changed while renewal the transaction" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","The 'ProductCode' value is not remain same after policy's original date is changed while renewal the transaction","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
			if(func._checkAttributeValue(getElement(lst_CancelState), "TEXT", dataIssuePolicy.getData("CancelState"), softAssert))
			{
				CustomReporting.logReport("","","Verified that 'CancelState' value is remain same when policy's original date is changed while renewal the transaction" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","The 'CancelState' value is not remain same after policy's original date is changed while renewal the transaction","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
			if(!dataIssuePolicy.getData("EverestCompany").equals(""))
			{
			 	if(func._checkAttributeValue(getElement(lst_EverestCompany), "TEXT", dataIssuePolicy.getData("EverestCompany"), softAssert))
				{
					CustomReporting.logReport("","","Verified that 'EverestCompany' value is remain same when policy's original date is changed while renewal the transaction" + 
							"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
					
				}
				else
				{
					
					CustomReporting.logReport("", "","The 'EverestCompany' value is not remain same after policy's original date is changed while renewal the transaction","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
				
				}
			}
			else
			 {
				 if(func._checkAttributeValue(getElement(lst_EverestCompany), "TEXT", dataNewSubmission.getData("EverestCompany"), softAssert))
					{
						CustomReporting.logReport("","","Verified that 'EverestCompany' value is remain same when policy's original date is changed while renewal the transaction" + 
								"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
						
					}
					else
					{
						
						CustomReporting.logReport("", "","The 'EverestCompany' value is not remain same after policy's original date is changed while renewal the transaction","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
					
					}
				 
			 }
		}*/
		 _setValue(getElement(lst_PaymentPlan),dataIssuePolicy.getData("PaymentPlan"));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		 _click(getElement(btn_Save));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
	}
	
	@Override
	public void verify_PaymentPlan_CarryForward_Renewal (String tcID, SoftAssert softAssert) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		 PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 if(func._checkAttributeValue(getElement(lst_PaymentPlan), "TEXT", dataIssuePolicy.getData("PaymentPlan"), softAssert))
		{
			CustomReporting.logReport("","","Verify that for renewal transactions  the payment plan is available for the previous policy is carry  forward to the renewal. " + 
					"" + 
					"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			
			CustomReporting.logReport("", "","Verify that for renewal transactions  the payment plan is not available for the previous policy and it is not carry  forward to the renewal. ","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
		
		}
	
	
	}
	
	@Override
	public void verify_PolicyScreen_BeforeEnterDetails (String tcID, SoftAssert softAssert) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),500L);
		 Thread.sleep(2000);
		 
		 
		 
		 
		 PageData dataSubmission =null;
		 PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 
		
		 if(dataLogin.getData("Environment").equalsIgnoreCase("STAGE") || dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
		 {
			  dataSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID); 
		 }
		 else
		 {
			  dataSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		  
		 
		 WebElement weLOB=(WebElement)getElement(lst_SelectedSubmissionLOB).getNative();
		 if(weLOB.getText().trim().equals(dataSubmission.getData("SubmissionLOB")))
		 {
			 CustomReporting.logReport("","","Verify that Bound Line of Business is auto populated as "+weLOB.getText() ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		 }
		 else
		 {
			 CustomReporting.logReport("","","Verify that Bound Line of Business is not auto populated as "+weLOB.getText(), "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null); 
		 }
		 WebElement wePN=(WebElement)getElement(getPolicyNumber).getNative();
		 if(wePN.getAttribute("value").equals(""))
		 {
			 CustomReporting.logReport("","","Policy number field is empty when policy screen open initially",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		 }
		 else
		 {
			 CustomReporting.logReport("","","Policy number field is not empty when policy screen open initially", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null); 
		 }
		 WebElement wePMod=(WebElement)getElement(getPolicyMod).getNative();
		 if(wePMod.getAttribute("value").equals(""))
		 {
			 CustomReporting.logReport("","","Policy MOD field is empty when policy screen open initially",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		 }
		 else
		 {
			 CustomReporting.logReport("","","Policy MOD field is not empty when policy screen open initially", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null); 
		 }
		 WebElement weExpPN=(WebElement)getElement(ExpiringPolicyNo).getNative();
		 if(weExpPN.getAttribute("value").equals(""))
		 {
			 CustomReporting.logReport("","","Expaired Policy number field is empty when policy screen open initially",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		 }
		 else
		 {
			 CustomReporting.logReport("","","Expaired Policy number field is not empty when policy screen open initially", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null); 
		 }
		 WebElement weExpPMod=(WebElement)getElement(ExpiringMod).getNative();
		 if(wePMod.getAttribute("value").equals(""))
		 {
			 CustomReporting.logReport("","","Expaired Policy Mod field is empty when policy screen open initially",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
		 }
		 else
		 {
			 CustomReporting.logReport("","","Expaired Policy Mod field is not empty when policy screen open initially", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null); 
		 }
		 
		/* func._checkAttributeValue(getElement(lst_BoundLineBusiness), "TEXT", dataSubmission.getData("SubmissionLOB"), softAssert);
		 func._checkAttributeValue(getElement(getPolicyNumber), "TEXT", "", softAssert);
		 func._checkAttributeValue(getElement(getPolicyMod), "TEXT", "", softAssert);
		 func._checkAttributeValue(getElement(ExpiringPolicyNo), "TEXT", "", softAssert);
		 func._checkAttributeValue(getElement(ExpiringMod), "TEXT", "", softAssert);*/
		 
		 if((dataSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataSubmission.getData("BusinessSegment").equals("Alternative Solutions")||dataSubmission.getData("BusinessSegment").equals("Private Company Group")||dataSubmission.getData("BusinessSegment").equals("Professional Liability")||dataSubmission.getData("BusinessSegment").equalsIgnoreCase("Executive Solutions"))&&(dataSubmission.getData("SubmissionLOB").equals("Private Co Exp")||dataSubmission.getData("SubmissionLOB").equals("Blend")))
			    
	  		{
	  			if(func._isVisible(getElement(tab_BoundProfileHeader)))
	  			{
	  				CustomReporting.logReport("","","Bound Profile section is displayed for the LOB 'Priv Co Expedition'" + "" + 
	  					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

	  				_click(getElement(tab_BoundProfileHeader));
	  				func._waitForPageToLoad(getWebDriver(),50L);
	  				Thread.sleep(2000);
	  				String[] arrSelect=null;
	  				String[] arrverifyboundProfile=null;
	  			
	  				if(dataSubmission.getData("SubmittedProfile").contains(";"))
	  				{
	  					arrverifyboundProfile=dataSubmission.getData("SubmittedProfile").split(";");
	  					
	  					for(int i=0;i<arrverifyboundProfile.length;i++)
	  					{
	  					System.out.println(arrverifyboundProfile[i]);
	  						if(func._isChecked(getClonedElement(chk_BoundProfile).addToken("tkn_BoundProfile",arrverifyboundProfile[i].trim())))
	  						{
	  							CustomReporting.logReport("","","'"+ arrverifyboundProfile[i] +"' check exist in the Bound profile  for the LOB 'Priv Co Expedition'" + "" + 
	  									"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
	  							
	  						}
	  						
	  						else
	  						{
	  							CustomReporting.logReport("","","'"+ arrverifyboundProfile[i] + " Bound Profile  is not displayed for the LOB 'Priv Co Expedition" + 
	  									"" + 
	  									"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	  							
	  						}
	  					}				
	  				
	  				}
	  				_click(getElement(tab_BoundProfileHeader));
	  				func._waitForPageToLoad(getWebDriver(),50L);
	  				Thread.sleep(2000);
	  				}
	  			else
	  			{
	  				CustomReporting.logReport("","", "Bound Profile section is not dispalyed  for the LOB 'Priv Co Expedition'" + 
	  						"" + 
	  						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);	
	  				throw new RuntimeException();
	  			}

	  		    }
		 
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
	
	
	}
	
	@Override
	public void verify_RenewalPolicyScreen_BeforeEnterDetails (String tcID, SoftAssert softAssert) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);

		 PageData dataEditSubmission =null;
		// PageData dataRenewalPolicy = PageDataManager.instance().getPageData("RenewalPolicy",tcID);
		 PageData dataRenewalPolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		 
		 
		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 
		 if(dataLogin.getData("Environment").equalsIgnoreCase("STAGE")||dataLogin.getData("Environment").equalsIgnoreCase("SIT"))

		 {
			  dataEditSubmission = PageDataManager.instance().getPageData("EditSubmission",tcID); 
		 }
		 else
		 {
			 dataEditSubmission = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
		 }
		  
		WebElement weBLOB=(WebElement)getElement(lst_SelectedSubmissionLOB).getNative();
		System.out.println("Lob value " +weBLOB.getText());
		if(weBLOB.getText().trim().equals(dataEditSubmission.getData("SubmissionLOB")))
		{
				CustomReporting.logReport("","","Bound Line of Business field is  auto populated",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				
		}
		
		else
		{
			CustomReporting.logReport("","","Bound Line of Business field is  not auto populated", 
					 "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
		WebElement wePN=(WebElement)getElement(getPolicyNumber).getNative();
		if(wePN.getText().trim().equals(""))
		{
				CustomReporting.logReport("","","Policy number field is empty",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				
		}
		
		else
		{
			CustomReporting.logReport("","","Policy number field is not empty", 
					 "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
		WebElement wePNMod=(WebElement)getElement(getPolicyMod).getNative();
		if(wePNMod.getText().trim().equals(""))
		{
				CustomReporting.logReport("","","Policy Mod field is empty",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				
		}
		
		else
		{
			CustomReporting.logReport("","","Policy Mod field is not empty", 
					 "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
		if(tcID.contains("-"))
		{
			dataRenewalPolicy= PageDataManager.instance().getPageData("RenewalPolicy",tcID.split("-")[0]);
		}
		if(tcID.contains("_"))
		{
			dataRenewalPolicy = PageDataManager.instance().getPageData("RenewalPolicy",tcID.split("_")[0]);
		}
		
		WebElement weExpPN=(WebElement)getElement(ExpiringPolicyNo).getNative();
		String actExpPolNum=weExpPN.getAttribute("value");
		String ExpExpPN=dataRenewalPolicy.getData("PolicyNumber").split("-")[0].trim();
		if(tcID.contains("-")||tcID.contains("_"))
			
		{
			ExpExpPN=dataRenewalPolicy.getData("RePolicyNumber").split("-")[0].trim();	
		}
		else
		{
			ExpExpPN=dataRenewalPolicy.getData("PolicyNumber").split("-")[0].trim();

		}
		
		
		if(actExpPolNum.equals(ExpExpPN))
		{
				CustomReporting.logReport("","","Expiring Everest Policy # field is populated with previously expired policy number ",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				
		}
		
		else
		{
			CustomReporting.logReport("","","Expiring Everest Policy # field is not populated with previously expired policy number", 
					 "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
		WebElement weExpPNMod=(WebElement)getElement(ExpiringMod).getNative();
		String actExpPNMod=weExpPNMod.getAttribute("value");
		String ActExpPNMod="";
		if(tcID.contains("-")||tcID.contains("_"))
		{
			ActExpPNMod=dataRenewalPolicy.getData("RePolicyNumber").split("-")[1].trim();	
		}
		else
		{
			ActExpPNMod=dataRenewalPolicy.getData("PolicyNumber").split("-")[1].trim();
		}
		if(actExpPNMod.equals(ActExpPNMod))
		{
				CustomReporting.logReport("","","Expiring Everest Policy # Mod field is populated with previously expired policy MOd ",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				
		}
		
		else
		{
			CustomReporting.logReport("","","Expiring Everest Policy # Mod field is not populated with previously expired policy MOd", 
					 "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
		
		
		
		 
		 
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

	}
	
	@Override
	public void verify_RenewalPolicyNumberFormat(String tcID, SoftAssert softAS, String format, String policyNumber)
			throws Exception {
		func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		
		if(policyNumber.equals("")|| policyNumber==null)
        {
              PageData dataIssuePolicy = PageDataManager.instance().getPageData("RenewalPolicy",tcID);
                policyNumber =dataIssuePolicy.getData("RePolicyNumber");
        }
        String policyNo []= policyNumber.split("-");
        String []regexFormat = format.split("-") ;
        if(policyNo[0].matches(regexFormat[0]) && policyNo[1].matches(regexFormat[1]) )
              {
                    CustomReporting.logReport("","", " Policy Number Schematic is matched with " + policyNumber + "as per the requirement",StepStatus.REPORT,new String[] { },System.currentTimeMillis());      
                    
              }
              else
              {
                    CustomReporting.logReport("","", "Policy Number Schematic is not matched with " + policyNumber, "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
                    //throw new RuntimeException();
                    
              }

	}
		@Override
	public void verify_PolicyNumberFormat(String tcID, SoftAssert softAS, String format,String policyNumber) throws Exception 
	{
			func._waitForPageToLoad(getWebDriver(),50L);
			 Thread.sleep(2000);
		if(policyNumber.equals("")|| policyNumber==null)
		{
			 PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
			  policyNumber =dataIssuePolicy.getData("PolicyNumber");
		}
		String policyNo []= policyNumber.split("-");
		String []regexFormat = format.split("-") ;
		 if(policyNo[0].matches(regexFormat[0]) && policyNo[1].matches(regexFormat[1]) )
			{
				CustomReporting.logReport("","", " Policy Number Format is matched with as per the requirement",StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				CustomReporting.logReport("","", "Policy Number Format is not matched as per the requirement ", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);

				
			}
		
	}
	@Override
	public void remove_BoundProfiles(String tcID, SoftAssert softAS) throws Exception 
	{
		func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);

		 PageData dataSubmission =null;
		 PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 
		
		 if(dataLogin.getData("Environment").equalsIgnoreCase("STAGE"))
		 {
			  dataSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID); 
		 }
		 else
		 {
			  dataSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 if((dataSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataSubmission.getData("BusinessSegment").equals("Alternative Solutions")||dataSubmission.getData("BusinessSegment").equals("Private Company Group")||dataSubmission.getData("BusinessSegment").equals("Professional Liability")||dataSubmission.getData("BusinessSegment").equalsIgnoreCase("Executive Solutions"))&&(dataSubmission.getData("SubmissionLOB").equals("Private Co Exp")))
			    
	  		{
	  			if(func._isVisible(getElement(tab_BoundProfileHeader)))
	  			{
	  				CustomReporting.logReport("","","Bound Profile section is displayed for the LOB 'Priv Co Expedition'" + "" + 
	  					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

	  				_click(getElement(tab_BoundProfileHeader));
	  				func._waitForPageToLoad(getWebDriver(),50L);
	  				Thread.sleep(2000);
	  				String[] arrSelect=null;
	  				String[] arrverifyboundProfile=null;
	  			
	  				if(dataSubmission.getData("RemoveSubmittedProfile").contains(";"))
	  				{		 
	  						arrverifyboundProfile=dataSubmission.getData("RemoveSubmittedProfile").split(";");
	  					
	  					for(int i=0;i<arrverifyboundProfile.length-1;i++)
	  					{
	  						if(func._isVisible(getClonedElement(chk_BoundProfile).addToken("tkn_BoundProfile",arrverifyboundProfile[i].trim())))
	  						{
	  							_click(getClonedElement(chk_BoundProfile).addToken("tkn_BoundProfile",arrverifyboundProfile[i].trim()));
	  						
	  							 func._alertHandler(getWebDriver(), "OK");
	  							 CustomReporting.logReport("","","'"+ arrverifyboundProfile[i] +"' Removed from the Bound Profile'" + "" + 
	  									"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
	  							
	  						}
	  						
	  						else
	  						{
	  							CustomReporting.logReport("","","'"+ arrverifyboundProfile[i] + "  not removed from the Bound Profile" + 
	  									"" + 
	  									"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	  							
	  						}
	  					}				
	  				
	  				}
	  				_click(getElement(tab_BoundProfileHeader));
	  				func._waitForPageToLoad(getWebDriver(),50L);
	  				/*Thread.sleep(2000);
	  				_click(getElement(tab_BoundProfileHeader));*/
	  				
	  				}
	  			else
	  			{
	  				CustomReporting.logReport("","", "Bound Profile section is not dispalyed  for the LOB 'Priv Co Expedition'" + 
	  						"" + 
	  						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);	
	  				throw new RuntimeException();
	  			}

	  		    }
		
	}
	@Override
	public void verify_PolicyNumberFieldEnable( String tcID, SoftAssert softAs) throws Exception 
	{
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 func._waitForPageToLoad(getWebDriver(), 200L);
		 Thread.sleep(3000);
		boolean isEnabled = false; 
		if(func._isEnabled(getElement(getPolicyNumber)))
		{
			isEnabled=true;
			 CustomReporting.logReport("","","Policy Number field is enabled on the page" + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

		}
		else
		{
			CustomReporting.logReport("","","Policy Number field is disabled on the page" + "" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			throw new RuntimeException();
		}
		if(isEnabled)
		{
			try
			{
			_setValue(getElement(getPolicyNumber),"PCIP000001");
			Thread.sleep(3000);
			_setValue(getElement(getPolicyMod),"181");
			Thread.sleep(3000);
			 CustomReporting.logReport("","","User is able to manually inout the policy number with out any error." + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
			catch(Exception ex)
			{
				WebElement wePn=(WebElement)getElement(getPolicyNumber).getNative();
				wePn.sendKeys("PCIP000001");
				WebElement wePnMOd=(WebElement)getElement(getPolicyMod).getNative();
				wePnMOd.sendKeys("181");
				CustomReporting.logReport("","","User is able to manually inout the policy number with out any error." + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
		}
	}
	
	
	@Override
	public void verify_PolicyCreatred_Automatically_AfterBindProcess(String tcID, SoftAssert softAS,String type) throws Exception 
	{
		func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		 
		 PageData dataNewSubmission=null;
		 PageData dataSubmission =null;
		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 PageData dataTestResult = PageDataManager.instance().getPageData("TestResult",tcID);
		 PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID); 
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);	 
		 }
		 
	    
		 if(!dataNewSubmission.getData("Ref_TC_ID").equals(""))
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",dataNewSubmission.getData("Ref_TC_ID")); 
		 }
		 String  SubmissionNumber = "";
		 String SubmNumber ="";
	    if(type.equalsIgnoreCase("sister")) 
	    {
	    	  SubmissionNumber = dataNewSubmission.getData("Sister_Sub_num").split("-")[0];
	    	  SubmNumber = dataNewSubmission.getData("Sister_Sub_num");
	    }
	    else
	    {
	    	  SubmissionNumber = dataNewSubmission.getData("SubmissionNumber").split("-")[0];
	    	   SubmNumber = dataNewSubmission.getData("SubmissionNumber");
	    }
	     //WebElement wePolicyNum=(WebElement)getElement(PolicyNumber).getNative();
		 String policyNubr=dataTestResult.getData("PolicyNum");
		 policyNubr=policyNubr.replace(" ", "").substring(0, 10);
		// expPolicy=expPolicy.split(" ")[0]+expPolicy.split(" ")[1]+"-"+expPolicy.split(" ")[2];
		 if(func._isVisible(getClonedElement(PolicyNumber).addToken("tkn_SubNum", SubmNumber)))
		 {
				CustomReporting.logReport("","", "Successfully verified a Policy creatred automatically as part of the Bind process for the Bind submission",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
		 }
		 
		else
		{
				CustomReporting.logReport("","", "Policy is not  creatred automatically as part of the Bind process for the Bind submission", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);

				throw new RuntimeException();
		}
		 Thread.sleep(5000);
		 
		 _click(getClonedElement(PolicyNumber).addToken("tkn_SubNum", SubmNumber));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		 func._waitFor(getElement(dat_PolicyEffectiveDate), 200, WAIT_FOR.VISIBLE);
		 Thread.sleep(3000);
		 
		 LinkedHashMap<Integer, String[]>SubmissionDB =null;
		 LinkedHashMap<Integer, String[]>SubmissionDBLogs =null;
		 Map<String, String> newSubmissionDBDataMap = new LinkedHashMap<>();
	     Map<String, String> newSubmissionDBXMLDataMap = new LinkedHashMap<>();
	     Boolean isMatched =true;
	     String sqlQury="select Policy_Eff_Dt,Policy_Exp_Dt from escapedb.[dbo].SUB_Policy where Policy_Nbr='"+ policyNubr+ "'";
	   //  String sqlQury="select Submission_Eff_Dt,Submission_Exp_Dt from escapedb.[dbo].[SUB_Submission] where Submission_Nbr='"+SubmissionNumber+"' order by Submission_Eff_Dt desc";
	  		// and sub.Submission_Version_Nbr=2  order by pdlogkey desc"
	     System.out.println(sqlQury);
	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
     {		   
		   SubmissionDB =cFunc.getDataFromDB(sqlQury, 2, "EscapeDB","enicdb-dev\\enic_qa");	 
     } 
     else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
     {
     	
    	 SubmissionDB =cFunc.getDataFromDB(sqlQury, 2, "EscapeDB_SIT","ENICDB-STAGE");
     	
     }
     else
     {
     	
    	 SubmissionDB =cFunc.getDataFromDB(sqlQury ,2, "EscapeDB","ENICDB-STAGE");
     }
	   
	   	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	   	String[] strSubDBarrr=SubmissionDB.get(0);
	   	String DBSubEffDate=strSubDBarrr[0].split(" ")[0];
	 	String DBSubExpDate=strSubDBarrr[1].split(" ")[0];
	 	
	 	Date parsedDate1 = dateFormat.parse(DBSubEffDate);
		Date parsedDate2 = dateFormat.parse(DBSubExpDate);
		 
		DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		String strSubEffDate = dateFormat1.format(parsedDate1).trim();
		String strSuExpDate = dateFormat1.format(parsedDate2).trim();
	 	
		WebElement wePolicyEffDate=(WebElement)getElement(dat_PolicyEffectiveDate).getNative();
		String actPolicyEffDate=wePolicyEffDate.getAttribute("value").trim();
		
		WebElement wePolicyExpDate=(WebElement)getElement(dat_PolicyExpirationDate).getNative();
		String actPolicyExpDate=wePolicyExpDate.getAttribute("value").trim();
		actPolicyEffDate=func.dateFormat(actPolicyEffDate,"Add","Month");
		strSubEffDate=func.dateFormat(strSubEffDate,"Add","Month");
		if(actPolicyEffDate.equals(strSubEffDate))
		 {
				CustomReporting.logReport("","", "Successfully verified effective date changed in PD is updated in the ESCAPE Policy Page",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
		 }
		else
		{
				CustomReporting.logReport("","", "Effective date changed in PD is not updated in the ESCAPE Policy Page. expected value "+strSubEffDate + " Actual "+actPolicyEffDate, "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		}
		if(actPolicyExpDate.equals(strSuExpDate))
		{
			CustomReporting.logReport("","", "Successfully verified exparation date changed in PD is updated in the ESCAPE Policy Page",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
				CustomReporting.logReport("","", "Exparation date changed in PD is not updated in the ESCAPE Policy Page. expected value "+strSuExpDate + " Actual "+actPolicyExpDate, "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);

		}
		
		WebElement wePolicyPremium=(WebElement)getElement(txt_PolicyPremium).getNative();
		String actPolicyPremium=wePolicyPremium.getAttribute("value").trim();
		String expPolicyPremium=func._getGlobalVariableValue("PolicyPremium");
		WebElement wePolicySercharge=(WebElement)getElement(txt_NonCommissionableFee).getNative();
		String actPolicySercharge=wePolicySercharge.getAttribute("value").trim();
		String expPolicySercharge=func._getGlobalVariableValue("Serchage");
		if(actPolicyPremium.equals(expPolicyPremium))
		 {
				CustomReporting.logReport("","", "Successfully verified Policy Premium updated in PD is displaying in the ESCAPE Policy Page",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
		 }
		else
		{
				CustomReporting.logReport("","", "Policy Premium updated in PD is not displaying in the ESCAPE Policy Page. expected value "+expPolicyPremium + " Actual "+actPolicyPremium, "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		}
		if(actPolicySercharge.equals(expPolicySercharge))
		{
			CustomReporting.logReport("","", "Successfully verified Policy Non-Commissionable premium/Sercharge updated in PD is displaying in the ESCAPE Policy Page",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
				CustomReporting.logReport("","", "Non-Commissionable premium/Sercharge updated in PD is not dispalying in the ESCAPE Policy Page", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);

		}
		WebElement weProductCode=(WebElement)getElement(lst_ProductCodeSelected).getNative();
		
		if(weProductCode.getText().trim().contains("make selection"))
		{
			CustomReporting.logReport("","", "ProductCode is not updated by Bind process",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
				CustomReporting.logReport("","", "ProductCode is updated by Bind process", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		}
		WebElement weCanState=(WebElement)getElement(lst_CancelStateSelected).getNative();
		
		if(weCanState.getText().trim().contains("make selection"))
	
		{
			CustomReporting.logReport("","", "CancelState is not updated by Bind process",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
				CustomReporting.logReport("","", "CancelState is updated by Bind process", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		}
		
		WebElement weBillType=(WebElement)getElement(lst_BillTypeSelected).getNative();
		if(weBillType.getText().trim().contains("make selection"))
		{
			CustomReporting.logReport("","", "BillType is not updated by Bind process",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
				CustomReporting.logReport("","", "BillType is updated by Bind process", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		}
		Thread.sleep(5000);
		WebElement wePaymentPlan=(WebElement)getElement(lst_PaymentPlan).getNative();
		Select select=new Select(wePaymentPlan);
		int intcount=select.getOptions().size();
		
		if(intcount==1 && select.getOptions().get(0).getText().contains("make selection"))
		
		{
			CustomReporting.logReport("","", "PaymentPlan is not updated by Bind process",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
				CustomReporting.logReport("","", "PaymentPlan is updated by Bind process", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		}
			
		
		

		 if(!dataIssuePolicy.getData("ProductCode").equals(""))
		 {
			 Thread.sleep(2000);

			_setValue(getElement(lst_ProductCode),dataIssuePolicy.getData("ProductCode"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 
		 func._waitForPageToLoad(getWebDriver(),200L);
		 Thread.sleep(2000);
		 if(!dataIssuePolicy.getData("BillType").equals(""))
		 {
			 Thread.sleep(3000);
			 _setValue(getElement(lst_BillType),dataIssuePolicy.getData("BillType"));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 Thread.sleep(3000);
		 }
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {

			 if(!dataIssuePolicy.getData("CancelState_QA").equals(""))
			 {
	 
			 _setValue(getElement(lst_CancelState),dataIssuePolicy.getData("CancelState_QA"));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 }
		 }
		 else
		 {
			 if(!dataIssuePolicy.getData("CancelState").equals(""))
			 {
	 
			 _setValue(getElement(lst_CancelState),dataIssuePolicy.getData("CancelState"));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 }
			 
		 }
		 if(!dataIssuePolicy.getData("PaymentPlan").equals(""))
		 {
			 func._waitForPageToLoad(getWebDriver(),500L);
			 Thread.sleep(5000);
			 try {
			 _setValue(getElement(lst_PaymentPlan),dataIssuePolicy.getData("PaymentPlan"));
			 Thread.sleep(5000);}
			 catch(Exception ex)
			 {
				 WebElement webPaymentPlan =getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabPolicy_ctrlPolicy_ddlPaymentPlan']"));
				  
					Select optValue=new Select(webPaymentPlan);
					for (int i=0;i<optValue.getOptions().size();i++)
					{
						String strOptValue=optValue.getOptions().get(i).getText().trim();
						String strExpOptValue=dataIssuePolicy.getData("PaymentPlan").trim();
						
						if(strOptValue.equalsIgnoreCase(strExpOptValue))
						{
							optValue.selectByIndex(i);
						}
					}
				
			 }
		 }
		  WebElement weTPA=(WebElement)getElement(lst_TPASelected).getNative();
			if(weTPA.getText().trim().contains("make selection"))
			 {
				

				if(!dataIssuePolicy.getData("TPA").equals(""))
				 {
					 func._waitForPageToLoad(getWebDriver(),500L);
					 Thread.sleep(5000);
					 _setValue(getElement(lst_TPA),dataIssuePolicy.getData("TPA"));
					 func._waitForPageToLoad(getWebDriver(),50L);
				 }
					 
				
			 }
		 
			if(!dataIssuePolicy.getData("UnbundleIndicator").equals(""))
			 {
				if(dataIssuePolicy.getData("UnbundleIndicator").equalsIgnoreCase("Yes"))
				 {
					 _click(getElement(chk_Unbundling));
					Thread.sleep(2000);
				 }
			 }
			
			
			
		 Thread.sleep(5000);
		 _click(getElement(btn_Save));
		 func._waitForPageToLoad(getWebDriver(), 500L);
		Thread.sleep(2000);
		
		 int loopCount=0;
		 do
		 {
			 if(func._isVisible(getElement(msg_AddPolicySuccss)))
			 {
				 break;
			 }
			 loopCount=loopCount+1;
			 Thread.sleep(5000);
		 }while(loopCount<30);
		 
		func._waitFor(getElement(msg_AddPolicySuccss), 250, WAIT_FOR.VISIBLE);
		Thread.sleep(2000);
		
		
		
		 WebElement el=(WebElement) getClonedElement(PolicyNumber).addToken("tkn_SubNum", SubmNumber).getNative();
		 String getPolicyNum=el.getText();
		 Thread.sleep(2000);
	     func._writeToExcel("IssuePolicy", "PolicyNumber",getPolicyNum, tcID);
	     Thread.sleep(2000);
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			 func._writeToExcel("QASearch", "PolicyNumber",getPolicyNum, tcID);
		 }
		 else
		 {
			 func._writeToExcel("Search", "PolicyNumber",getPolicyNum, tcID);	 
		 }
	}
	
	@Override
	public void clk_CancelReWritePolicy (String tcID, SoftAssert softAssert) throws Exception
	{
		
		 func._waitForPageToLoad(getWebDriver(),500L);
		 Thread.sleep(3000);
		 
		 int loopCount=0;
		 do
		 {
			 if(func._isVisible(getElement(tab_Policynumber)))
			 {
				 break;
			 }
			 loopCount=loopCount+1;
			 Thread.sleep(5000);
		 }while(loopCount<30);
		 _click(getElement(tab_Policynumber));
		 func._waitForPageToLoad(getWebDriver(),500L);
		 Thread.sleep(5000);
		 _click(getElement("btn_CancelReWritePolicy"));
		 func._waitForPageToLoad(getWebDriver(),500L);
		 Thread.sleep(5000);
	}
		
		@Override
		public void Verify_OriginalRenpolicy_Voided_Cancelreason_ReWrite (String tcID, SoftAssert softAssert) throws Exception
		{
			func._waitForPageToLoad(getWebDriver(),500L);
			 Thread.sleep(3000);
			 int loopCount=0;
			 do
			 {
				 if(func._isVisible(getElement(tab_Policynumber)))
				 {
					 break;
				 }
				 loopCount=loopCount+1;
				 Thread.sleep(5000);
			 }while(loopCount<30);
				 
			 _click(getElement(tab_Policynumber));
			func._waitForPageToLoad(getWebDriver(),500L);
			 Thread.sleep(3000);
			 WebElement weCanReasonCode=(WebElement)getElement(lst_CancelledReasonCodeSelected).getNative();
			 String strCanResCode=weCanReasonCode.getText().trim();
			 if(strCanResCode.equalsIgnoreCase("Rewrite"))
			 {
				CustomReporting.logReport("","","Verify the Original policy Cancel reason is set to 'ReWrite' in escape after Cancel rewite it" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			 }
			 else
			 {
				CustomReporting.logReport("", "", "The Original policy Cancel reason is not set to 'ReWrite' in escape after Cancel rewite it","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			 }
			 
			 WebElement wePolicyStatus=(WebElement)getElement(lst_PolicyStatusSelected).getNative();
			 String strPolicyStatus=wePolicyStatus.getText().trim();
			 if(strPolicyStatus.equalsIgnoreCase("Voided"))
			 {
				CustomReporting.logReport("","","Verify the Original policy status is set to 'Voided' in escape after Cancel rewite it" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			 }
			 else
			 {
				CustomReporting.logReport("", "", "The Original policy status is not set to 'Voided' in escape after Cancel rewite it","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			 }
				 
			 
		}
		@Override
		public void verify_CancReWritePolicy_button_Available(String tcID, SoftAssert softAS) throws Exception 
		{
			
			Thread.sleep(4000);
			func._waitFor(getElement(tab_Policynumber), 200, WAIT_FOR.CLICKABLE);
			if(!func._isVisible(getElement(btn_CancelReWritePolicy)))
			{
				CustomReporting.logReport("","","Verified that create sister policy buttons is not present in Escape UI after booked and issued the Vosco policy" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Create sister policy buttons is present in Escape UI after booked and issued the Vosco policy","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}	
				
				
			
		}
		
		@Override
		public void verify_errormsg_afterclk_CanReWrte_BeforeBookPolicy (String tcID, SoftAssert softAssert) throws Exception
		{
			
			 func._waitForPageToLoad(getWebDriver(),500L);
			 Thread.sleep(3000);
			 
			 int loopCount=0;
			 do
			 {
				 if(func._isVisible(getElement(tab_Policynumber)))
				 {
					 break;
				 }
				 loopCount=loopCount+1;
				 Thread.sleep(5000);
			 }while(loopCount<30);
			 Thread.sleep(5000);
			 _click(getElement("btn_CancelReWritePolicy"));
			 func._waitForPageToLoad(getWebDriver(),500L);
			 Thread.sleep(5000);
			 func._waitFor(getElement(txt_CancelReWritePolicyErrmsg), 300, WAIT_FOR.VISIBLE);
			 Thread.sleep(5000);
			 WebElement weerrMsg=(WebElement)getElement(txt_CancelReWritePolicyErrmsg).getNative();
			 if(weerrMsg.getText().trim().equals("Error: Policy cannot be cancelled in PD. Please check in PD"))
			 {
					CustomReporting.logReport("","","Verified user is able to see a error message 'Policy cannot be cancelled in PD. Please check in PD after click on Cancel ReWrite Policy button before booked'" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			 }
			 else
			{
				CustomReporting.logReport("", "", "User is not able to see a error message 'Policy cannot be cancelled in PD. Please check in PD after click on Cancel ReWrite Policy button before booked","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
				 
		}
		
		@Override
		public void verify_NoButton_Policy_ToPD_Available (String tcID, SoftAssert softAssert) throws Exception
		{
			 PageData dataSub = PageDataManager.instance().getPageData("NewSubmission",tcID);
			 func._waitForPageToLoad(getWebDriver(),500L);
			 Thread.sleep(5000);
			 if(!func._isVisible(getElement(btn_Send_PolicyNo_ToPD)))
			 {
					CustomReporting.logReport("","","Verified the button 'Send policy# to PD' is not available for user selection for the BS "+dataSub.getData("BusinessSegment") + " and LOB "+dataSub.getData("SubmissionLOB") ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			 }
			 else
			{
				CustomReporting.logReport("", "", " Verified the button 'Send policy# to PD' is available for user selection for the BS "+dataSub.getData("BusinessSegment") + " and LOB "+dataSub.getData("SubmissionLOB"),"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
				 
		}
		
		@SuppressWarnings("static-access")
		@Override
		public void verify_UMPoloicyDetails_inEscape(String tcID, SoftAssert softAssert) throws Exception {

			try {
				 long startTime = System.currentTimeMillis();

				//PageData data = PageDataManager.instance().getPageData("Escape", tcID);
				
				PageData data = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
				PageData dataMarketSeg = PageDataManager.instance().getPageData("UmMarketSegment", tcID);
				PageData dataAddingOffice = PageDataManager.instance().getPageData("UmAddingOffice", tcID);
				//PageData dataPolicy = PageDataManager.instance().getPageData("SearchPolicy", tcID);
				PageData dataPremium = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
				PageData dataSubmission = PageDataManager.instance().getPageData("SearchPolicy", tcID);
				
				PageData dataEscapeFields = PageDataManager.instance().getPageData("Escapefields", tcID);
				
				String[] policyNumber = dataSubmission.getData("PolicyNo").split("-");
				String policyNumberVersion	 = policyNumber[1];
				
				String primaryExcess = dataSubmission.getData("PrimaryExcess");
				String commisssionPercentage = dataSubmission.getData("CommissionPerc")+".00";;
				String productCode = dataEscapeFields.getData("ProductCode");
				String limit = dataEscapeFields.getData("policylimit");
				String retention =dataEscapeFields.getData("Retention");
				

				/*String billType = dataSubmission.getData("BillingType");
				String paymentPlan = dataSubmission.getData("PaymentPlan");*/
				String billType = data.getData("BillType");
				String paymentPlan = data.getData("PaymentPlan");
				
				String policyPremium = dataSubmission.getData("Premium")+".00";
				String effectiveDate = data.getData("EffectiveDate");
				Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(effectiveDate);
				
				Date expDate = DateUtils.addYears(date1, 1);
				String expirationDate = new SimpleDateFormat("MM/dd/yyyy").format(expDate);

				_wait(2000);
				_click(getElement(lnk_SearchBar));
				_wait(2000);
				
				Search objFileVerify = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
				objFileVerify.searchSubmissionInEscape(tcID, softAssert);
				_wait(2000);
				getWebDriver().findElement(By.id("ContentPlaceHolder1_gvSearch_LinkButton3_0")).click();
				func._waitForPageToLoad(getWebDriver(), 250L);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				//func._checkAttributeValue(getElement(PolicyNumber), "value", policyNumber[0], softAssert);

				func._checkAttributeValue(getElement(getPolicyMod), "value", policyNumberVersion, softAssert);

				func._checkAttributeValue(getElement(txt_Commission), "value", commisssionPercentage, softAssert);
			

				func._checkAttributeValue(getElement(dat_PolicyEffectiveDate), "value", effectiveDate, softAssert);
				func._checkAttributeValue(getElement(dat_PolicyExpirationDate), "value", expirationDate, softAssert);
				//func._checkAttributeValue(getElement(lst_BoundLineBusinessSelected), "value", boundLOB, softAssert);
				//func._checkAttributeValue(getElement(lst_ProductCodeSelected), "value", productCode, softAssert);

				

				func._checkAttributeValue(getElement(txt_PolicyPremium), "value", policyPremium, softAssert);
				if (primaryExcess.equalsIgnoreCase("Primary")) {
					func._isEnabled(getElement(rad_PolicyPrimary));
				} else {
					func._isEnabled(getElement(rad_PolicyExcess));
				}

				//func._checkAttributeValue(getElement(txt_PolicyLimit), "value", limit, softAssert);
				//func._checkAttributeValue(getElement(txt_PolRetentionAttachment), "value", retention, softAssert);
				String actuallimit = func._getAttributeValue(getElement(txt_PolicyLimit), "value", softAssert);
				String actualRetention = func._getAttributeValue(getElement(txt_PolRetentionAttachment), "value", softAssert);
				if(actuallimit.equalsIgnoreCase(limit)) {
					CustomReporting.logReport("", "",
							"limit value is " + actuallimit ,
							StepStatus.SUCCESS, new String[] {}, startTime);
				}else {
					CustomReporting.logReport("", "",
							"limit value is not as expected value ",
							StepStatus.FAILURE, new String[] {}, startTime);
				}
				if(actualRetention.equalsIgnoreCase(actualRetention)) {
					CustomReporting.logReport("", "",
							"Retention value is " + actualRetention ,
							StepStatus.SUCCESS, new String[] {}, startTime);
				}else {
					CustomReporting.logReport("", "",
							"Retention value is not as expected value ",
							StepStatus.FAILURE, new String[] {}, startTime);
				}
				
				if(billType.equalsIgnoreCase("Direct")) 
				{
				func._checkAttributeValue(getElement(lst_BillTypeSelected), "TEXT", "Direct Bill", softAssert);
				}
				else 
				{
					func._checkAttributeValue(getElement(lst_BillTypeSelected), "TEXT", "Agent Bill", softAssert);
				}
				
				func._checkAttributeValue(getElement(lst_PaymentPlanSelected), "TEXT", paymentPlan , softAssert);
				
				if(data.getData("Excess").equalsIgnoreCase("Yes")) 
				{
					if(actuallimit.equalsIgnoreCase(limit)) 
					{
						CustomReporting.logReport("", "",
								"Limit value is as expected For Excess Policy as per ESUP-34931 and TC-21748. Limit in Escape : " + actuallimit+" Limit in UM : "+limit ,
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					}else {
						CustomReporting.logReport("", "",
								"Limit value is NOT as expected For Excess Policy as per ESUP-34931 and TC-21748. Limit in Escape : " + actuallimit+" Limit in UM : "+limit,
								StepStatus.FAILURE, new String[] {}, System.currentTimeMillis());
					}
					if(actualRetention.equalsIgnoreCase(retention)) {
						CustomReporting.logReport("", "",
								"Retention value is as expected For Excess Policy as per ESUP-34931 and TC-21748. Retention in Escape : " + actualRetention +" Retention in UM : "+retention,
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					}else {
						CustomReporting.logReport("", "",
								"Retention value is NOT as expected For Excess Policy as per ESUP-34931 and TC-21748. Retention in Escape : " + actualRetention +" Retention in UM : "+retention,
								StepStatus.FAILURE, new String[] {}, System.currentTimeMillis());
					}
					
				}
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

				CustomReporting.instance().logReport("Sucessfully Verified Submission Details in Escape");

			} catch (Exception ex) {
				throw ex;
			}
		}
		@Override
		public void verify_RenewalPolicy_Version (String tcID, SoftAssert softAssert,String RENVertion) throws Exception
		{
			
			func._waitFor(getElement(tab_Policynumber), 200L, WAIT_FOR.CLICKABLE, "");
			Thread.sleep(4000);
			WebElement wePolicyNum=(WebElement)getElement(tab_Policynumber).getNative();
			String PolicyNumVer=wePolicyNum.getText().split("-")[1].trim();
			int intpolver=Integer.valueOf(PolicyNumVer);
			if(intpolver==202)
			{
				CustomReporting.logReport("","","Renewal Policy transaction version incremnted to 2 after renewal the policy in UM" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","Renewal Policy transaction version is not incremnted to 2 after renewal the policy in UM","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
			WebElement weSubNum=(WebElement)getElement(tab_Submission).getNative();
			String SubmissionNumVer=weSubNum.getText().split("-")[1].trim();
			int intSubNumVer=Integer.valueOf(SubmissionNumVer);
			if(intSubNumVer==2)
			{
				CustomReporting.logReport("","","Renewal submission transaction version incremnted to 2 after renewal the policy in UM" + 
						"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("", "","Renewal submission transaction version is not incremnted to 2 after renewal the policy in UM","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			
			}
			
			
			
		}
		
		
			
}