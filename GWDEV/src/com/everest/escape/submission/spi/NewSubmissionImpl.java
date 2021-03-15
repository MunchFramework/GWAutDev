package com.everest.escape.submission.spi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.PageManager;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.Element.WAIT_FOR;

import com.everest.escape.submission.AddPolicy;
import com.everest.escape.submission.NewBusiness;
import com.everest.escape.submission.NewSubmission;
import com.everest.escape.submission.Payment;
import com.everest.escape.submission.Search;
import com.everest.functions.settings.Setup;
import com.everest.page.escape.outlook.OutlookPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class NewSubmissionImpl extends CustomAbstractPage implements NewSubmission 
{
	@Override
	public void NewSubmission (String tcID, SoftAssert softAssert) throws Exception
	{
		 PageData dataNewSubmission = null;
		 	PageData dataLogin = PageDataManager.instance().getPageData("EscapeLogin",tcID);
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID); 
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);	 
		 }
		 
		 System.out.println(dataNewSubmission.getData("Limit"));
		 Thread.sleep(3000);
		 func._waitFor(getElement(lst_BusinessSegment), 200, WAIT_FOR.VISIBLE);
		 Thread.sleep(3000);
		PageData dataAccount = PageDataManager.instance().getPageData("Account",tcID);
		_setValue(getElement(lst_BusinessSegment),dataNewSubmission.getData("BusinessSegment"));
		
		 func._waitForPageToLoad(getWebDriver(),500L);
		 Thread.sleep(5000);
	    _setValue(getElement(lst_BranchOffice),dataNewSubmission.getData("BusinessOffice"));
	    func._waitForPageToLoad(getWebDriver(),50L);
	    Thread.sleep(2000);
	    
	    _setValue(getElement(lst_SubmissionStatus),dataNewSubmission.getData("SubmissionStatus"));
	    func._waitForPageToLoad(getWebDriver(),50L);
	    Thread.sleep(3000);
	    if(dataNewSubmission.getData("SubmissionStatus").equals("Quote Lost")||dataNewSubmission.getData("SubmissionStatus").equals("Indication Lost")|| 
	    dataNewSubmission.getData("SubmissionStatus").equals("Dead")||dataNewSubmission.getData("SubmissionStatus").equals("Declined"))
	    {
	    	_setValue(getElement(lst_SubResonCode),dataNewSubmission.getData("SubmissionReasonCode"));
	    	func._waitForPageToLoad(getWebDriver(),50L);
	    	if(dataNewSubmission.getData("SubmissionReasonCode").equals("Other Reason(s)"))
	    	{
	    		_setValue(getElement(txt_ExplainSubmissionStatus),dataNewSubmission.getData("ExplainSubmissionStatus"));
	    			
	    	}
	    }
	    if(dataNewSubmission.getData("SubmissionStatus").equals("Quote Lost")||dataNewSubmission.getData("SubmissionStatus").equals("Indication Lost"))
	    {
	    	_setValue(getElement(lst_CompetingCarrier),dataNewSubmission.getData("CompetingCarrier"));
	    	func._waitForPageToLoad(getWebDriver(),50L);
	    }
	    if(dataNewSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability")
	    		||dataNewSubmission.getData("BusinessSegment").equals("Specialty Insurance Group"))
	    {
	    	if(dataNewSubmission.getData("AffinityBusiness").trim().toLowerCase().equals("no"))
	    	{
	    		_click(getElement(rdb_AffinityBusiness_No));
	    		
	    	}
	    	if(dataNewSubmission.getData("AffinityBusiness").trim().toLowerCase().equals("yes"))
	    	{
	    		_click(getElement(rdb_AffinityBusiness_Yes));
	    		func._waitForPageToLoad(getWebDriver(),50L);
	    		_setValue(getElement(lst_AffinityBusiness),dataNewSubmission.getData("AffinityBusinessReason"));
	    		func._waitForPageToLoad(getWebDriver(),50L);

	    	}
	    	
	    	
	    }

	    _setValue(getElement(lst_PredominantState),dataNewSubmission.getData("PredominantState"));
	    func._waitForPageToLoad(getWebDriver(),50L);
	    _setValue(getElement(lst_SubmissionType),dataNewSubmission.getData("SubmissionType"));
	    func._waitForPageToLoad(getWebDriver(),50L);
	    Thread.sleep(2000);
	    if(!dataNewSubmission.getData("ReceivedDate").equals(""))
	    {
	    _setValue(getElement(dat_ReceivedDate),dataNewSubmission.getData("ReceivedDate"));
	    WebElement elm = (WebElement) getElement(dat_ReceivedDate).getNative();
	    Thread.sleep(2000);
        //elm.sendKeys(Keys.TAB);
	    func._waitForPageToLoad(getWebDriver(),50L);
	    }
	    else
	    {
	    	_setValue(getElement(dat_ReceivedDate),func.Date_Manipulation("","now", 0));
	    	 WebElement elm = (WebElement) getElement(dat_ReceivedDate).getNative();
	    	 Thread.sleep(2000);
	         elm.sendKeys(Keys.TAB);
	    	 func._waitForPageToLoad(getWebDriver(),50L);

	    }
	    Thread.sleep(2000);
	    //disabled due to application changes
	    //_setValue(getElement(lst_Distribution),dataNewSubmission.getData("Distribution"));
	    //func._waitForPageToLoad(getWebDriver(),50L);
	   if(!dataNewSubmission.getData("SubmissionEffectiveDate").equals("NA"))
	   {
		    if(!dataNewSubmission.getData("SubmissionEffectiveDate").equals(""))
		    {
		    	int offset= Integer.valueOf(dataNewSubmission.getData("SubmissionEffectiveDate").split("-")[0].trim());
		    	String OptValue=dataNewSubmission.getData("SubmissionEffectiveDate").split("-")[1].trim();
		    	_setValue(getElement(dat_SubmissionEffectiveDate),func.Date_Manipulation("",OptValue, offset));
		    	
		   // _setValue(getElement(dat_SubmissionEffectiveDate),dataNewSubmission.getData("SubmissionEffectiveDate"));
		    WebElement elm = (WebElement) getElement(dat_SubmissionEffectiveDate).getNative();
	        elm.sendKeys(Keys.TAB);
		    func._waitForPageToLoad(getWebDriver(),50L);
		    }
		    else
		    {
				 _setValue(getElement(dat_SubmissionEffectiveDate),func.Date_Manipulation("","now", 0));
				  WebElement elm = (WebElement) getElement(dat_SubmissionEffectiveDate).getNative();
			        elm.sendKeys(Keys.TAB);
				 func._waitForPageToLoad(getWebDriver(),50L);
				 
		    }
	   }
	   String SubmissionExpDate="";
	   
	   if(!dataNewSubmission.getData("SubmissionExpaireDate").equals("NA"))
	   {
		    if(!dataNewSubmission.getData("SubmissionExpaireDate").equals(""))
		    {
		    	Thread.sleep(3000);
		    	int offset= Integer.valueOf(dataNewSubmission.getData("SubmissionExpaireDate").split("-")[0].trim());
		    	String OptValue=dataNewSubmission.getData("SubmissionExpaireDate").split("-")[1].trim();
		    	 SubmissionExpDate=func.Date_Manipulation("",OptValue, offset);
		    	_setValue(getElement(dat_SubmissionExpaireDate),func.Date_Manipulation("",OptValue, offset));
		    	  WebElement elm = (WebElement) getElement(dat_SubmissionExpaireDate).getNative();
		          elm.sendKeys(Keys.TAB);
		    	 func._waitForPageToLoad(getWebDriver(),50L);
		    }
	   }
	   
	   func._writeToExcel("UMSubmissionDetails", "RenewalEffDate", "'" +SubmissionExpDate, tcID);
	   
	   Thread.sleep(2000);
	    _setValue(getElement(lst_marketSegment),dataNewSubmission.getData("MarketSegment"));
	    Thread.sleep(2000);
	    func._waitForPageToLoad(getWebDriver(),50L);
	  	_setValue(getElement(lst_IncumbentCarrier),dataNewSubmission.getData("IncumbentCarrier"));
	  	 func._waitForPageToLoad(getWebDriver(),50L);
	    _setValue(getElement(lst_SubmissionLOB),dataNewSubmission.getData("SubmissionLOB"));
	    func._waitForPageToLoad(getWebDriver(),50L);
	    
	    try {
	    	  Alert alert1= getWebDriver().switchTo().alert();
	    	alert1.accept();
	    	
	    }
	    catch(Exception ex)
	    {
	    	
	    }
    
	    if((dataNewSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability"))&&(dataNewSubmission.getData("SubmissionLOB").equals("Package")))
	    	
	    {
			_click(getElement(tab_SubmittedProfile));
			func._waitForPageToLoad(getWebDriver(),50L);
			Thread.sleep(2000);
			String[] arrSelect=null;
			String[] arrLimit=null;
			String[] arrRetention=null;
			String[] arrpremium=null;
			if(dataNewSubmission.getData("SubmittedProfile").contains(";"))
			{
				arrSelect=dataNewSubmission.getData("SubmittedProfile").split(";");
			
			}
			if(dataNewSubmission.getData("Sub_Limit").contains(";"))
			{
				arrLimit=dataNewSubmission.getData("Sub_Limit").split(";");
			}
			if(dataNewSubmission.getData("Sub_Retention").contains(";"))
			{
				arrRetention=dataNewSubmission.getData("Sub_Retention").split(";");
			}
			if(dataNewSubmission.getData("Sub_Premium").contains(";"))
			{
				arrpremium=dataNewSubmission.getData("Sub_Premium").split(";");
			}
			if(dataNewSubmission.getData("SubmittedProfile").contains(";"))
			{
		
				for(int i=0;i<arrSelect.length;i++)
				{
					_click(getClonedElement(chk_SubmittedProfile).addToken("tkn_SubmittedProfile",arrSelect[i].trim()));
					func._waitForPageToLoad(getWebDriver(),50L);
					if(dataNewSubmission.getData("Sub_Limit").contains(";"))
			    	{
						_setValue(getClonedElement(txt_Sublimit).addToken("tkn_SubmittedProfile",arrSelect[i].trim()),arrLimit[i]);
			    	}
					else
					{
						
						_setValue(getElement(txt_Sublimit),dataNewSubmission.getData("Sub_Limit"));
					}
					if(dataNewSubmission.getData("Sub_Retention").contains(";"))
			    	{
						_setValue(getClonedElement(txt_SubRetention).addToken("tkn_SubmittedProfile",arrSelect[i].trim()),arrRetention[i]);
						
			    	}
					else
					{
						
						_setValue(getElement(txt_SubRetention),dataNewSubmission.getData("Sub_Retention"));
					}
					
					if(dataNewSubmission.getData("Sub_Premium").contains(";"))
			    	{
						_setValue(getClonedElement(txt_SubPremium).addToken("tkn_SubmittedProfile",arrSelect[i].trim()),arrpremium[i]);
						
			    	}
					else
					{
						
						_setValue(getElement(txt_SubPremium),dataNewSubmission.getData("Sub_Premium"));
					}
					
					
					
				}
			}
			else
			{
				_click(getClonedElement(chk_SubmittedProfile).addToken("tkn_SubmittedProfile",dataNewSubmission.getData("SubmittedProfile")));
				Thread.sleep(2000);
				_setValue(getElement(txt_Sublimit),dataNewSubmission.getData("Sub_Limit"));
				_setValue(getElement(txt_SubRetention),dataNewSubmission.getData("Sub_Retention"));
				_setValue(getElement(txt_SubPremium),dataNewSubmission.getData("Sub_Premium"));
			
			}
			_click(getElement(tab_SubmittedProfile));
			func._waitForPageToLoad(getWebDriver(),50L);
		}
	    
	       
if((dataNewSubmission.getData("BusinessSegment").equals("Wholesale Property")||dataNewSubmission.getData("BusinessSegment").equals("Retail Property")||dataNewSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataNewSubmission.getData("BusinessSegment").equals("Alternative Solutions")||dataNewSubmission.getData("BusinessSegment").equals("Private Company Group")||dataNewSubmission.getData("BusinessSegment").equals("Professional Liability")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Executive Solutions")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Cyber Liability Group")
		||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Energy/All Other")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Life Sciences")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Surety"))
		&&(dataNewSubmission.getData("SubmissionLOB").equals("Package")|| dataNewSubmission.getData("SubmissionLOB").equals("Lawyers Professional Liability") ||dataNewSubmission.getData("SubmissionLOB").equals("Non Profit Expedition")||dataNewSubmission.getData("SubmissionLOB").equals("Private Co Exp")||dataNewSubmission.getData("SubmissionLOB").equals("Cyber Elevation")||dataNewSubmission.getData("SubmissionLOB").equals("Private Co Exp")||dataNewSubmission.getData("SubmissionLOB").equals("Blend")||dataNewSubmission.getData("SubmissionLOB").equals("Everest EZ Excess")||dataNewSubmission.getData("SubmissionLOB").equals("Surety")||dataNewSubmission.getData("SubmissionLOB").equals("Contingent Liability") 
				||dataNewSubmission.getData("SubmissionLOB").equals("Broker Dealer E&O")||dataNewSubmission.getData("SubmissionLOB").equals("Reps & Warranties")))
	
	{
		if(dataNewSubmission.getData("Sub_Limit").equals(""))
		{
			if(func._isVisible(getElement(tab_SubmittedProfile)))
			{
				CustomReporting.logReport("","","Submitted Profile section is displayed" + "" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	
				_click(getElement(tab_SubmittedProfile));
				func._waitForPageToLoad(getWebDriver(),50L);
				Thread.sleep(2000);
				String[] arrSelect=null;
				String[] arrverifySubProfile=null;
			
				if(dataNewSubmission.getData("Verify Sub Profile").contains(";"))
				{
					arrverifySubProfile=dataNewSubmission.getData("Verify Sub Profile").split(";");
					
					for(int i=0;i<arrverifySubProfile.length;i++)
					{
						if(func._isVisible(getClonedElement(chk_SubmittedProfile).addToken("tkn_SubmittedProfile",arrverifySubProfile[i].trim())))
						{
							CustomReporting.logReport("","","'"+ arrverifySubProfile[i] +"' check exist in the Submissionh profile  for the LOB 'Priv Co Expedition'" + "" + 
									"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
							
						}
						
						else
						{
							CustomReporting.logReport("","","'"+ arrverifySubProfile[i] + "Submitted Profile section is not displayed" + 
									"" + 
									"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
							
						}
					}				
				
				}
				
	
				if(dataNewSubmission.getData("SubmittedProfile").contains(";"))
				{
					arrSelect=dataNewSubmission.getData("SubmittedProfile").split(";");
					for(int i=0;i<arrSelect.length;i++)
					{
						_click(getClonedElement(chk_SubmittedProfile).addToken("tkn_SubmittedProfile",arrSelect[i].trim()));
						func._waitForPageToLoad(getWebDriver(), 150L);
						Thread.sleep(2000);
						
	
					}
				
				}
				
	
				else
				{
					_click(getClonedElement(chk_SubmittedProfile).addToken("tkn_SubmittedProfile",dataNewSubmission.getData("SubmittedProfile")));
					Thread.sleep(2000);
	
				}
				_click(getElement(tab_SubmittedProfile));
				func._waitForPageToLoad(getWebDriver(),50L);
				Thread.sleep(2000);
				}
			else
			{
				CustomReporting.logReport("","", "Submitted Profile section is not dispalyed  for the LOB 'Priv Co Expedition'" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);	
				//throw new RuntimeException();
			}

	    }
	}
	    	
	    if(dataNewSubmission.getData("BusinessSegment").contains("Financial Institutions")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability")
	    		||dataNewSubmission.getData("BusinessSegment").contains("Cyber Liability Group")||dataNewSubmission.getData("BusinessSegment").contains("Private Company Group")||dataNewSubmission.getData("BusinessSegment").contains("Alternative Solutions")||dataNewSubmission.getData("BusinessSegment").contains("Executive Solutions"))
	    {
	    	Thread.sleep(2000);
	    	if(!dataNewSubmission.getData("SubmittedProduct").equals(""))
		    {
		    	_setValue(getElement(lst_SubmittedProduct),dataNewSubmission.getData("SubmittedProduct"));
		    	func._waitForPageToLoad(getWebDriver(),50L);
		    	Thread.sleep(2000);
		    	
		    }
	    }
	    Thread.sleep(4000);
	    _setValue(getElement(lst_Producername),dataNewSubmission.getData("Producername"));
	    func._waitForPageToLoad(getWebDriver(),50L);
	    Thread.sleep(3000);
	    _setValue(getElement(lst_ProducerOffice),dataNewSubmission.getData("ProducerOffice"));
	  
	    func._waitForPageToLoad(getWebDriver(),50L);
	    Thread.sleep(3000);
	    if(!dataNewSubmission.getData("SubProducer").equals(""))
	    {
	    	 Thread.sleep(3000);
	    	_setValue(getElement(lst_SubProducer),dataNewSubmission.getData("SubProducer"));
	    	func._waitForPageToLoad(getWebDriver(),50L);
	    }
	    _setValue(getElement(lst_BranchOffice),dataNewSubmission.getData("BusinessOffice"));
	    func._waitForPageToLoad(getWebDriver(),50L);
	    Thread.sleep(2000);
	    Thread.sleep(3000);
	    _setValue(getElement(lst_UWName),dataNewSubmission.getData("UWName"));
	    func._waitForPageToLoad(getWebDriver(),50L);
	   
	    if(!dataNewSubmission.getData("Currency").equals(""))
	    {	
	    	 Thread.sleep(3000);
	    	 _setValue(getElement(lst_Currency),dataNewSubmission.getData("Currency"));
	    	 func._waitForPageToLoad(getWebDriver(),50L);
	    }
	
	    
	    _setValue(getElement(lst_UWAssistant),dataNewSubmission.getData("UWAssistant"));
	    func._waitForPageToLoad(getWebDriver(),50L);
	    _setValue(getElement(txt_EstimatedPremium),dataNewSubmission.getData("EstimatedPremium"));
	    func._waitForPageToLoad(getWebDriver(),100L);
	    _setValue(getElement(lst_EverestCompany),dataNewSubmission.getData("EverestCompany"));
	    Thread.sleep(5000);	
	    WebElement weEverComp=(WebElement)getElement(lst_EverestCompany).getNative();
	    weEverComp.sendKeys(Keys.TAB);
	    func._waitForPageToLoad(getWebDriver(),50L);
	    
	    WebElement weEverComp1=(WebElement)getElement(lst_EverestCompany).getNative();
	    weEverComp1.sendKeys(Keys.PAGE_DOWN);
	    Thread.sleep(5000);	
	   if(dataNewSubmission.getData("BusinessSegment").contains("Financial Institutions")||dataNewSubmission.getData("BusinessSegment").contains("Commercial Management Liability")|| 
	   dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability")|| dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Executive Solutions")|| 
	   dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Alternative Solutions")|| dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Private Company Group")|| 
	   dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Cyber Liability Group")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Surety")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Surety"))
		       														
	   {
	    if(dataNewSubmission.getData("PrimaryORExcess").trim().toLowerCase().contains("primary"))
	    	 {
	    	Thread.sleep(3000);	 
	    	_click(getElement(radio_Primary)); 
	    		 func._waitForPageToLoad(getWebDriver(),50L);
	    	 }
	    	 if(dataNewSubmission.getData("PrimaryORExcess").trim().toLowerCase().contains("excess"))
	    	 {
	    		 Thread.sleep(3000);
	    		 _click(getElement(radio_Excess)); 
	    		 func._waitForPageToLoad(getWebDriver(),50L);
	    	 }
	    
	    	 
	    }
	    	 

	    if((dataNewSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability")) 
	    		&&(dataNewSubmission.getData("QuotedLineOfBusiness").equals("Package"))&&(dataNewSubmission.getData("SubmissionStatus").equals("Policy Bound")||dataNewSubmission.getData("SubmissionStatus").equals("Quote Lost")))
	 		    
	 	    {
	    		 Thread.sleep(3000);
	 			_click(getElement(tab_QuotedProfileHeader));
	 			func._waitForPageToLoad(getWebDriver(),50L);
	 			
	 			String[] arrSelect=null;
	 			String[] arrLimit=null;
	 			String[] arrRetention=null;
	 			String[] arrpremium=null;
	 			if(dataNewSubmission.getData("QuoteSubmittedProfile").contains(";"))
	 			{
	 				arrSelect=dataNewSubmission.getData("QuoteSubmittedProfile").split(";");
	 			
	 			}
	 			if(dataNewSubmission.getData("Quotelimit").contains(";"))
	 			{
	 				arrLimit=dataNewSubmission.getData("Quotelimit").split(";");
	 			}
	 			if(dataNewSubmission.getData("QuoteRetention").contains(";"))
	 			{
	 				arrRetention=dataNewSubmission.getData("QuoteRetention").split(";");
	 			}
	 			if(dataNewSubmission.getData("QuotePremium").contains(";"))
	 			{
	 				arrpremium=dataNewSubmission.getData("QuotePremium").split(";");
	 			}
	 			if(dataNewSubmission.getData("QuoteSubmittedProfile").contains(";"))
	 			{
	 		
	 				for(int i=0;i<arrSelect.length;i++)
	 				{
	 					Thread.sleep(2000);
	 					_click(getClonedElement(chk_QuotedProfile).addToken("tkn_QuoteProfile",arrSelect[i].trim()));
	 					func._waitForPageToLoad(getWebDriver(),50L);
	 					if(dataNewSubmission.getData("Quotelimit").contains(";"))
	 			    	{
	 						_setValue(getClonedElement(txt_QuotedSublimit).addToken("tkn_QuoteProfile",arrSelect[i].trim()),arrLimit[i]);
	 			    	}
	 					else
	 					{
	 						
	 						_setValue(getElement(txt_QuotedSublimit),dataNewSubmission.getData("Quotelimit"));
	 					}
	 					if(dataNewSubmission.getData("QuoteRetention").contains(";"))
	 			    	{
	 						_setValue(getClonedElement(txt_QuotedSubRetention).addToken("tkn_QuoteProfile",arrSelect[i].trim()),arrRetention[i]);
	 						
	 			    	}
	 					else
	 					{
	 						
	 						_setValue(getElement(txt_QuotedSubRetention),dataNewSubmission.getData("QuoteRetention"));
	 					}
	 					
	 					if(dataNewSubmission.getData("QuotePremium").contains(";"))
	 			    	{
	 						_setValue(getClonedElement(txt_QuotedSubPremium).addToken("tkn_QuoteProfile",arrSelect[i].trim()),arrpremium[i]);
	 						
	 			    	}
	 					else
	 					{
	 						
	 						_setValue(getElement(txt_QuotedSubPremium),dataNewSubmission.getData("QuotePremium"));
	 					}
	 					
	 					
	 					
	 				}
	 			}
	 			else
	 			{
	 				_click(getClonedElement(chk_SubmittedProfile).addToken("tkn_QuoteProfile",dataNewSubmission.getData("QuoteSubmittedProfile")));
	 				func._waitForPageToLoad(getWebDriver(),50L);
	 				_setValue(getElement(txt_QuotedSublimit),dataNewSubmission.getData("Quotelimit"));
	 				_setValue(getElement(txt_QuotedSubRetention),dataNewSubmission.getData("QuoteRetention"));
	 				_setValue(getElement(txt_QuotedSubPremium),dataNewSubmission.getData("QuotePremium"));
	 			
	 			}
	 			_click(getElement(tab_QuotedProfileHeader));
	 			func._waitForPageToLoad(getWebDriver(),50L);
	 			//NewSubmissionImpl newSub=new NewSubmissionImpl();
	 			//newSub.EnterProfileDetails(tcID, softAssert);
	 		}
	    	 
	    	if((dataNewSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataNewSubmission.getData("BusinessSegment").equals("Alternative Solutions")||dataNewSubmission.getData("BusinessSegment").equals("Private Company Group")||dataNewSubmission.getData("BusinessSegment").equals("Professional Liability")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Executive Solutions")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Cyber Liability Group")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Surety")) 
	    			&&(dataNewSubmission.getData("SubmissionLOB").equals("Private Co Exp")|| dataNewSubmission.getData("SubmissionLOB").equals("Lawyers Professional Liability")||dataNewSubmission.getData("SubmissionLOB").equals("Non Profit Expedition")||dataNewSubmission.getData("SubmissionLOB").equals("Contingent Liability")||dataNewSubmission.getData("SubmissionLOB").equals("Cyber Elevation")||dataNewSubmission.getData("SubmissionLOB").equals("Everest EZ Excess")||dataNewSubmission.getData("SubmissionLOB").equals("Surety")||dataNewSubmission.getData("SubmissionLOB").equals("Broker Dealer E&O"))&&(dataNewSubmission.getData("SubmissionStatus").equals("Policy Bound")))
	 		    
	 	    {
	    		Thread.sleep(10000);
	 			_click(getElement(tab_QuotedProfileHeader));
	 			func._waitForPageToLoad(getWebDriver(),50L);
	 			Thread.sleep(2000);
	 			//WebElement weQuoteLOB=(WebElement)getElement(tab_QuotedProfileHeader).getNative();
	 			//weQuoteLOB.sendKeys(Keys.PAGE_DOWN);
	 			Thread.sleep(2000);
	 			String[] arrSelect=null;
	 			String[] arrverifySubProfile=null;
	 		
	 			if(dataNewSubmission.getData("Verify Sub Profile").contains(";"))
	 			{
	 				arrverifySubProfile=dataNewSubmission.getData("Verify Sub Profile").split(";");
	 				
	 				for(int i=0;i<arrverifySubProfile.length;i++)
	 				{
	 					if(func._isVisible(getClonedElement(chk_QuotedProfile).addToken("tkn_QuoteProfile",arrverifySubProfile[i].trim())))
	 					{
	 						CustomReporting.logReport("","","'"+ arrverifySubProfile[i] +"' check exist in the Submissionh profile  for the LOB 'Priv Co Expedition'" + "" + 
	 								"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
	 						
	 					}
	 					
	 					else
	 					{
	 						CustomReporting.logReport("","","'"+ arrverifySubProfile[i] + "check does not exist in the Submissionh profile  for the LOB 'Priv Co Expedition'" + 
	 								"" + 
	 								"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	 						
	 					}
	 				}				
	 			
	 			}
	 			

	 			if(dataNewSubmission.getData("QuoteSubmittedProfile").contains(";"))
	 			{
	 				arrSelect=dataNewSubmission.getData("QuoteSubmittedProfile").split(";");
	 				for(int i=0;i<arrSelect.length;i++)
	 				{
	 					_click(getClonedElement(chk_QuotedProfile).addToken("tkn_QuoteProfile",arrSelect[i].trim()));
	 					func._waitForPageToLoad(getWebDriver(), 150L);
	 					Thread.sleep(2000);
	 					

	 				}
	 			
	 			}
	 			

	 			else
	 			{
	 				Thread.sleep(2000);
	 				_click(getClonedElement(chk_QuotedProfile).addToken("tkn_QuoteProfile",dataNewSubmission.getData("QuoteSubmittedProfile")));
	 				Thread.sleep(2000);

	 			}
	 			_click(getElement(tab_QuotedProfileHeader));
	 			func._waitForPageToLoad(getWebDriver(),50L);
	 			Thread.sleep(2000);
	 		}
	    	

	    //}
	    if(!dataNewSubmission.getData("Comment").equals(""))
	    {
	    	_setValue(getElement(txt_Comment),dataNewSubmission.getData("Comment"));
	    }
	    if(!dataNewSubmission.getData("SubDescription").equals(""))
	    {
	    	_setValue(getElement(txt_SubDescription),dataNewSubmission.getData("SubDescription"));
	    }

	    if((dataNewSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability"))&&(dataNewSubmission.getData("SubmissionLOB").equals("Blend")))
	    
	    {
	    	if(dataNewSubmission.getData("SubmittedProfile").contains(";"))
	    	{
	    		String[] strarr;
	    		strarr=dataNewSubmission.getData("SubmittedProfile").split(";");
	    		for(String vararr:strarr)
	    		{
	    			_click(getClonedElement(chk_SubmittedProfile).addToken("tkn_SubmittedProfile",vararr));
	    		}
	    	}
	    	else
	    	{
	    		_click(getClonedElement(chk_SubmittedProfile).addToken("tkn_SubmittedProfile",dataNewSubmission.getData("SubmittedProfile")));
	    		
	    	}
	    }
	    if(dataNewSubmission.getData("SubmissionStatus").equals("Quote Lost")||dataNewSubmission.getData("SubmissionStatus").equals("Indication Lost")||dataNewSubmission.getData("SubmissionStatus").equals("Quote Outstanding") 
	    		||dataNewSubmission.getData("SubmissionStatus").equals("Indication Outstanding")||dataNewSubmission.getData("SubmissionStatus").equals("Policy Bound"))
	    {
	    	Thread.sleep(3000);
	    	if(!dataNewSubmission.getData("DateQuoted").equals(""))
	    	{
	    		_setValue(getElement(dat_DateQuoted),dataNewSubmission.getData("DateQuoted"));
	    		  WebElement elm = (WebElement) getElement(dat_DateQuoted).getNative();
		          elm.sendKeys(Keys.TAB);
	    		func._waitForPageToLoad(getWebDriver(),50L);
	    	}
	 	    else
	 	    {
	 	    	
				 _setValue(getElement(dat_DateQuoted),func.Date_Manipulation("","now", 0));
				 WebElement elm = (WebElement) getElement(dat_DateQuoted).getNative();
		          elm.sendKeys(Keys.TAB);
				  func._waitForPageToLoad(getWebDriver(),50L);
	 	    	 	    
	 	    }
	 	    _setValue(getElement(txt_QuotedPremium),dataNewSubmission.getData("QuotedPremium"));
	 	   func._waitForPageToLoad(getWebDriver(),500L);
	 	Thread.sleep(3000);
	    }
	    if((dataNewSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Executive Solutions")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Alternative Solutions")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Private Company Group")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Surety")) 
	    		&&(dataNewSubmission.getData("SubmissionStatus").equals("Quote Lost")||dataNewSubmission.getData("SubmissionStatus").equals("Indication Lost")||dataNewSubmission.getData("SubmissionStatus").equals("Quote Outstanding") 
	    		||dataNewSubmission.getData("SubmissionStatus").equals("Indication Outstanding")||dataNewSubmission.getData("SubmissionStatus").equals("Policy Bound")))
	    {
	    	if(dataNewSubmission.getData("PolicyPrimaryORExcess").trim().toLowerCase().equals("primary"))
	    	{
	    	  _click(getElement(radio_QuotedPrimary));
	    	  Thread.sleep(3000);
	    	  func._waitForPageToLoad(getWebDriver(),50L);
	    	}
		    if(dataNewSubmission.getData("PolicyPrimaryORExcess").trim().toLowerCase().equals("excess"))
		    {
		    	  
		    	  _click(getElement(radio_QuotedExcess));
		    	  Thread.sleep(3000);
		    	  func._waitForPageToLoad(getWebDriver(),50L);
		    }
		   // if(!dataNewSubmission.getData("SubmissionLOB").equals("Package"))
		   //{
		    	Thread.sleep(3000);
		    	_setValue(getElement(txt_Limit),dataNewSubmission.getData("Limit"));
		    	func._waitForPageToLoad(getWebDriver(),50L);
		    	_setValue(getElement(txt_RetentionAttachment),dataNewSubmission.getData("RetentionAttachment"));
		    	func._waitForPageToLoad(getWebDriver(),50L);
		    //}
		    
	    }

	    
	    if((dataNewSubmission.getData("SubmissionStatus").equals("Policy Bound")||dataNewSubmission.getData("SubmissionStatus").equals("Indication Lost"))
	    		||dataNewSubmission.getData("SubmissionStatus").equals("Quote Lost")||dataNewSubmission.getData("SubmissionStatus").equals("Declined")||dataNewSubmission.getData("SubmissionStatus").equals("Indication Outstanding"))
	    {
	    	if(!dataNewSubmission.getData("QuotedLineOfBusiness").equals(""))
	   	 	{
		    	_setValue(getElement(lst_QuotedLineBusiness),dataNewSubmission.getData("QuotedLineOfBusiness"));
		    	func._waitForPageToLoad(getWebDriver(),50L);
		    	try {
			    	  Alert alert1= getWebDriver().switchTo().alert();
			    	alert1.accept();
			    	
			    }
			    catch(Exception ex)
			    {
			    	
			    }
	   	 	}
	    	/*Thread.sleep(2000);
	    	 _setValue(getElement(txt_NaicsCode),dataNewSubmission.getData("NaicsCode"));
	    	  func._waitForPageToLoad(getWebDriver(),50L);*/
	    	if(!dataNewSubmission.getData("QuotedSubmittedLineOfBusiness").equals(""))
	   	 	{
		    	_setValue(getElement(lst_QuotedSubmittedProduct),dataNewSubmission.getData("QuotedSubmittedLineOfBusiness"));
		    	func._waitForPageToLoad(getWebDriver(),50L);
		    	try {
			    	  Alert alert1= getWebDriver().switchTo().alert();
			    	alert1.accept();
			    	
			    }
			    catch(Exception ex)
			    {
			    	
			    }
	   	 	}
	    }
	    
	    if((dataNewSubmission.getData("BusinessSegment").equals("Wholesale Property"))&&(dataNewSubmission.getData("QuotedLineOfBusiness").equals("Package")) &&(dataNewSubmission.getData("SubmissionStatus").equals("Policy Bound")))
 		    
 	    {
	    	if(func._isVisible(getElement(tab_QuotedProfileHeader)))
			{
				CustomReporting.logReport("","","Submitted Profile section is displayed" + "" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

				_click(getElement(tab_QuotedProfileHeader));
				func._waitForPageToLoad(getWebDriver(),50L);
				Thread.sleep(2000);
				String[] arrSelect=null;
				String[] arrverifySubProfile=null;
			
				if(dataNewSubmission.getData("Verify Sub Profile").contains(";"))
				{
					arrverifySubProfile=dataNewSubmission.getData("Verify Sub Profile").split(";");
					
					for(int i=0;i<arrverifySubProfile.length;i++)
					{
						if(func._isVisible(getClonedElement(chk_QuotedProfile).addToken("tkn_QuoteProfile",arrverifySubProfile[i].trim())))
						{
							CustomReporting.logReport("","","'"+ arrverifySubProfile[i] +"' check exist in the Quoted profile  for the LOB 'Priv Co Expedition'" + "" + 
									"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
							
						}
						
						else
						{
							CustomReporting.logReport("","","'"+ arrverifySubProfile[i] + "Quote Profile section is not displayed" + 
									"" + 
									"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
							
						}
					}				
				
				}
				

				if(dataNewSubmission.getData("QuoteSubmittedProfile").contains(";"))
				{
					arrSelect=dataNewSubmission.getData("QuoteSubmittedProfile").split(";");
					for(int i=0;i<arrSelect.length;i++)
					{
						_click(getClonedElement(chk_QuotedProfile).addToken("tkn_QuoteProfile",arrSelect[i].trim()));
						func._waitForPageToLoad(getWebDriver(), 150L);
						Thread.sleep(2000);
						

					}
				
				}
				

				else
				{
					_click(getClonedElement(chk_QuotedProfile).addToken("tkn_QuoteProfile",dataNewSubmission.getData("QuoteSubmittedProfile")));
					Thread.sleep(2000);

				}
				_click(getElement(tab_QuotedProfileHeader));
				func._waitForPageToLoad(getWebDriver(),50L);
				Thread.sleep(2000);
				}
			else
			{
				CustomReporting.logReport("","", "Quoted Profile section is not dispalyed  for the LOB 'Priv Co Expedition'" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);	
				//throw new RuntimeException();
			}
 		}
	    
	    if(!dataNewSubmission.getData("NaicsCode").equals(""))
	    {
	    	Thread.sleep(4000);
	    	_setValue(getElement(txt_NaicsCode),dataNewSubmission.getData("NaicsCode"));
	    	Thread.sleep(4000);
   	  		func._waitForPageToLoad(getWebDriver(),50L);
   	  	    WebElement elmNaiceCode = (WebElement) getElement(txt_NaicsCode).getNative();
	   	  	 if(elmNaiceCode.getText().equals(""))
	   	  	 {
	   	  		 _setValue(getElement(txt_NaicsCode),dataNewSubmission.getData("NaicsCode"));
	   	  		 Thread.sleep(4000);
	   	  		 func._waitForPageToLoad(getWebDriver(),50L); 
	   	  	 }
	    }
	    
	    if((dataNewSubmission.getData("SubmissionLOB").equals("Workers Comp"))&&(dataNewSubmission.getData("SubmissionStatus").equals("Policy Bound")||dataNewSubmission.getData("SubmissionStatus").equals("Indication Lost")
	    	||dataNewSubmission.getData("SubmissionStatus").equals("Quote Lost")||dataNewSubmission.getData("SubmissionStatus").equals("Indication Outstanding")
	    	||dataNewSubmission.getData("SubmissionStatus").equals("Quote Outstanding")))
	    
	    {
	    	_setValue(getElement(txt_ScheduleRatingMod),dataNewSubmission.getData("ScheduleRatingMod"));
	    	func._waitForPageToLoad(getWebDriver(),50L);
	    	_setValue(getElement(txt_ExperienceMod),dataNewSubmission.getData("ExperienceMod"));
	    	func._waitForPageToLoad(getWebDriver(),50L);
	    	
	    	
	    }
	    
	    
	    if(dataNewSubmission.getData("BusinessSegment").equals("Wholesale Casualty"))
	    		
		{
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_CreditScore),dataNewSubmission.getData("CreditScore"));
	    	Thread.sleep(1000);
	    	if(dataNewSubmission.getData("SubmissionLOB").equals("Commercial Auto")||dataNewSubmission.getData("SubmissionLOB").equals("GL"))
			{
				_setValue(getElement(lst_IncumbentCarNonRenewal),dataNewSubmission.getData("IncumbentCarNonRenewal"));
				func._waitForPageToLoad(getWebDriver(),50L);
				Thread.sleep(2000);
			}	
		}
	    if(dataNewSubmission.getData("BusinessSegment").equals("Environmental") || dataNewSubmission.getData("BusinessSegment").equals("Excess Casualty"))
    		
		{
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_CreditScore),dataNewSubmission.getData("CreditScore"));
	    	Thread.sleep(1000);
		}
	    
	    if(!dataNewSubmission.getData("CurentlyValuedLossRuns").equals(""))
	    {
	    	if(dataNewSubmission.getData("CurentlyValuedLossRuns").trim().equalsIgnoreCase("No"))
	    		_click(getElement(radio_CurrentlyLossNo));
	    	else if(dataNewSubmission.getData("CurentlyValuedLossRuns").trim().equals("Yes"))
	    		_click(getElement(radio_CurrentlyLossYes));
	    }
	    
	    if(!dataNewSubmission.getData("ProductCoveragePeril").equals(""))
	    {
	    	_setValue(getElement(lst_ProductCoveragePeril), dataNewSubmission.getData("ProductCoveragePeril"));
	    }
	    if((dataNewSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability")|| 
		dataNewSubmission.getData("BusinessSegment").equalsIgnoreCase("Cyber Liability Group")||dataNewSubmission.getData("BusinessSegment").equals("Private Company Group")|| 
		dataNewSubmission.getData("BusinessSegment").equals("Alternative Solutions")||dataNewSubmission.getData("BusinessSegment").equals("Executive Solutions")) 
		&&(dataNewSubmission.getData("SubmissionStatus").equals("Quote Lost")||dataNewSubmission.getData("SubmissionStatus").equals("Indication Lost")||dataNewSubmission.getData("SubmissionStatus").equals("Quote Outstanding") 
	    		||dataNewSubmission.getData("SubmissionStatus").equals("Indication Outstanding")||dataNewSubmission.getData("SubmissionStatus").equals("Policy Bound")))
	    {
	    	if(dataNewSubmission.getData("PolicyPrimaryORExcess").trim().toLowerCase().equals("primary"))
	    	{  Thread.sleep(2000);
	    	  _click(getElement(radio_QuotedPrimary));
	    	  func._waitForPageToLoad(getWebDriver(),50L);
	    	}
		    if(dataNewSubmission.getData("PolicyPrimaryORExcess").trim().toLowerCase().equals("excess"))
		    {  Thread.sleep(2000);
		    	  
		    	  _click(getElement(radio_QuotedExcess));
		    	  func._waitForPageToLoad(getWebDriver(),50L);
		    }
		   // if(!dataNewSubmission.getData("SubmissionLOB").equals("Package"))
		   //{
		    	Thread.sleep(3000);
		    	_setValue(getElement(txt_Limit),dataNewSubmission.getData("Limit"));
		    	func._waitForPageToLoad(getWebDriver(),50L);
		    	_setValue(getElement(txt_RetentionAttachment),dataNewSubmission.getData("RetentionAttachment"));
		    	func._waitForPageToLoad(getWebDriver(),50L);
		    //}
		    
	    }
	    
	    	

	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    func._waitForPageToLoad(getWebDriver(),150L);
	    Thread.sleep(3000);
	   _click(getElement(btn_CreateThisSubmission));
	   Thread.sleep(10000);

	   if(!dataNewSubmission.getData("BusinessSegment").equals("Wholesale Property") && (dataNewSubmission.getData("SubmissionLOB").equals("Workers Comp")||dataNewSubmission.getData("SubmissionLOB").equals("Property"))&&dataAccount.getData("FEIN").toUpperCase().equals("NA") )
	   {
		  
		   try
		   {
			  
			   if(func._isVisible(getElement(txt_FEINMissed)))
				{
					CustomReporting.logReport("","", "FEIN Pop up is displayed when missed to enter FEIN value in Account screen  and tried to create new submission","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);	
				}
				else
				{
					CustomReporting.logReport("","", "FEIN Pop up is not displayed when missed to enter FEIN value in Account screen  and tried to create new submission","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					throw new RuntimeException();
				
				}
				_click(getElement(btn_FEINCancel));
				func._waitForPageToLoad(getWebDriver(), 200L);
				Thread.sleep(2000);
				 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				_click(getElement(btn_CreateThisSubmission));
				func._waitForPageToLoad(getWebDriver(), 200L);
				Thread.sleep(2000);
				 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				if(func._isVisible(getElement(txt_FEINMissed)))
				{
					CustomReporting.logReport("","", "The 'Cancel' button will allow the user to return to their incomplete submission, and will not allow them to create a new submission until the FEIN has been entered","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);	
				}
				else
				{
					CustomReporting.logReport("","", "The 'Cancel' button will allow the user to return to their incomplete submission, and it is allow them to create a new submission even if the FEIN has not been entered","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					throw new RuntimeException();
				
				}
				_setValue(getElement(txt_FEINMissed),dataNewSubmission.getData("FEIN"));
				Thread.sleep(2000);
				 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				_click(getElement(btn_FEINSaved));
				func._waitForPageToLoad(getWebDriver(), 200L);
				Thread.sleep(2000);

			   _click(getElement(btn_CreateThisSubmission));
			   Thread.sleep(2000);
			  /* Alert alert1= getWebDriver().switchTo().alert();
		    	alert1.accept();*/
		    	
			  func._alertHandler(getWebDriver(), "OK");
			   Thread.sleep(2000);
			   if(dataNewSubmission.getData("SubmissionStatus").equals("Policy Bound"))
			    {
			    	/*Alert alert2= getWebDriver().switchTo().alert();
			    	alert2.accept();*/
			    	  func._alertHandler(getWebDriver(), "OK");
			    	
			    }
			    func._waitForPageToLoad(getWebDriver(),150L);
			    Thread.sleep(5000);
		   
		   }
		   catch(Exception ex)
		   {
			   
		   }
	   }
	   else if((dataNewSubmission.getData("BusinessSegment").equals("Wholesale Property"))&&(dataNewSubmission.getData("SubmissionLOB").equals("Property"))&& dataAccount.getData("FEIN").toUpperCase().equals("NA"))
	   {
		  
		   try
		   {
			   
			   if(func._isVisible(getElement(txt_FEINMissed)))
				{
					CustomReporting.logReport("","", "FEIN Pop up is  displayed when missed to enter FEIN value in Account screen  and tried to create new submission","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					throw new RuntimeException();
				}
				else
				{
					CustomReporting.logReport("","", "FEIN Pop up is not displayed when missed to enter FEIN value in Account screen  and tried to create new submission","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);	
					
				
				}
			  // _click(getElement(btn_CreateThisSubmission));
			   Thread.sleep(2000);
			   /*Alert alert1= getWebDriver().switchTo().alert();
		    	alert1.accept();*/
 
			  func._alertHandler(getWebDriver(), "OK");
			   Thread.sleep(2000);
			   if(dataNewSubmission.getData("SubmissionStatus").equals("Policy Bound"))
			    {
			    	Alert alert2= getWebDriver().switchTo().alert();
			    	alert2.accept();
			    	  func._alertHandler(getWebDriver(), "OK");
			    	
			    }
			    func._waitForPageToLoad(getWebDriver(),150L);
			    Thread.sleep(5000);
		   }
		   catch(Exception e) {
			   
		   }
	   }
	   else
	   {
		  // _click(getElement(btn_CreateThisSubmission));
		   try {
		   //Thread.sleep(2000);
		   //func._alertHandler(getWebDriver(), "OK");
		   Thread.sleep(5000);
		   
		  //func._alertHandler(getWebDriver(), "OK");
		   Alert alert1= getWebDriver().switchTo().alert();
		   alert1.accept();
		   Thread.sleep(2000);
		    if(dataNewSubmission.getData("SubmissionStatus").equals("Policy Bound"))
		    {
		    	
		    	
		    		Alert alert2= getWebDriver().switchTo().alert();
		    	
		    	alert2.accept();
		    	  //func._alertHandler(getWebDriver(), "OK");
		    	
		    	
		    	
		    }
		   }
		    catch(Exception ex)
	    	{
	    		_click(getElement(btn_CreateThisSubmission));
				func._waitForPageToLoad(getWebDriver(), 200L);
				Thread.sleep(10000);
				func._alertHandler(getWebDriver(), "OK");
				   Thread.sleep(10000);
				
	    		 func._alertHandler(getWebDriver(), "OK");
	  		   Thread.sleep(5000);	
	    	}
		    func._record_PageLoadTime(getWebDriver(), 300L);
		    func._waitForPageToLoad(getWebDriver(),50L);
		    Thread.sleep(10000);
	   }
	   
	    func._waitFor(getElement(msg_SubmissionSuccessmsg),600, WAIT_FOR.VISIBLE, "");
	   // _checkDefaultValue(getElement(msg_SubmissionSuccessmsg),"TEXT","Account & Submission information updated successfully!");  
	   
	    WebElement sussmsg=(WebElement)getElement(msg_SubmissionSuccessmsg).getNative();
	    
	    if(sussmsg.getText().contains("Account & Submission information updated successfully"))
	    {
			 CustomReporting.logReport("","","Submission is created for the account successfully!" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
		 }
		 else
		 {
			 CustomReporting.logReport("","", "Submission is not created for the account","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
				//throw new RuntimeException();
		 }
	    
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    //Thread.sleep(5000);
	   WebElement el=(WebElement) getElement(getSubmissionNumber).getNative();
	   //String[] arrSubNumber;
	   String getSubmissionNum=el.getText();
	   //arrSubNumber=getSubmissionNum.split("-");
	   
	    
	    if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
	    {
	    	func._writeToExcel("QANewSubmission", "SubmissionNumber",getSubmissionNum, tcID);	
	    	func._writeToExcel("QASearch", "SubmissionNumber",getSubmissionNum, tcID);
	    	func._writeToExcel("SearchPolicy", "SubmissionNo",getSubmissionNum, tcID);

	    }
	    else
	    {
	    	func._writeToExcel("NewSubmission", "SubmissionNumber",getSubmissionNum, tcID);
	    	func._writeToExcel("Search", "SubmissionNumber",getSubmissionNum, tcID);
	    	func._writeToExcel("SearchPolicy", "SubmissionNo",getSubmissionNum, tcID);
	    }
	   
	   

	}
	
	@Override
	public void verify_Submission_InDWHDB (String tcID, SoftAssert softAssert) throws Exception
	{
		
		PageData dataSub=null;
		dataSub = PageDataManager.instance().getPageData("NewSubmission",tcID);
		if(!dataSub.getData("Ref_TC_ID").equals(""))
		{
			dataSub = PageDataManager.instance().getPageData("NewSubmission",dataSub.getData("Ref_TC_ID"));
		}
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		String SubNum=dataSub.getData("SubmissionNumber").split("-")[0];
		 LinkedHashMap<Integer, String[]> SubmissionDHWDBvalues =null;
		 LinkedHashMap<Integer, String[]> SubmissionEscDBvalues =null;
				 
		 try
		 {
			 if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
			 {
				SubmissionDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [IRF_EscapeDB].[dbo].[SUB_DW_Submissions] WHERE Submission_Number ='"+SubNum+"'",
							10, "IRF_EscapeDB", "ENDWSQLS2");  
			 }
			 else
			 {
				SubmissionDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [IRF_EscapeDB].[dbo].[SUB_DW_Submissions] WHERE Submission_Number ='"+SubNum+"'",
							10, "IRF_EscapeDB", "ENDWSQLS"); 
				 
			 }
			
			 String[] strSubDWHDBValues;
			 strSubDWHDBValues=SubmissionDHWDBvalues.get(0);
			
			 if(strSubDWHDBValues[2].trim().equals(SubNum))
				{
					CustomReporting.logReport("","", "Submission created in '" + dataLogin.getData("Environment") +" env is exist in the DWH DB",StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
					
				}
				else
				{
					CustomReporting.logReport("","", "Submission created in '" + dataLogin.getData("Environment") +" env is not exist in the DWH DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
					throw new RuntimeException();
					
				}
		 }
		 catch(Exception ex)
		 {
			 CustomReporting.logReport("","", "Submission created in '" + dataLogin.getData("Environment") +" env is not exist in the DWH DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				throw new RuntimeException(); 
		 }

		try
		{
			if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
			 {
				SubmissionEscDBvalues =cFunc.getDataFromDB("SELECT * FROM [EscapeDB].[dbo].[SUB_Submission] WHERE Submission_Nbr='"+SubNum+"'",
						10, "EscapeDB", "enicdb-dev\\enic_qa");	
			 }
			else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
			 {
				SubmissionEscDBvalues=cFunc.getDataFromDB("SELECT * FROM [ESCAPEDB_SIT].[dbo].[SUB_Submission] WHERE Submission_Nbr='"+SubNum+"'",
							10, "EscapeDB", "ENICDB-STAGE");
				
			 }
			
			else
			{
				SubmissionEscDBvalues=cFunc.getDataFromDB("SELECT * FROM [EscapeDB].[dbo].[SUB_Submission] WHERE Submission_Nbr='"+SubNum+"'",
						10, "EscapeDB", "ENICDB-STAGE");
				
				
			}
		
		
		 String[] strSubEscDBValues;
		 strSubEscDBValues=SubmissionEscDBvalues.get(0);
		
		 if(strSubEscDBValues[1].trim().equals(SubNum))
			{
				CustomReporting.logReport("","", "Submission created in '" + dataLogin.getData("Environment") +"' env is exist in the ESCAPE DB",StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
				
			}
			else
			{
				
				CustomReporting.logReport("","", "Submission created in '" + dataLogin.getData("Environment") +"' env is not exist in the ESCAPE DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				throw new RuntimeException();
				
			}
		}
		
		 catch(Exception ex)
		 {
			 
			 CustomReporting.logReport("","", "Submission created in '" + dataLogin.getData("Environment") +"' env is not exist in the ESCAPE DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
			throw new RuntimeException();
		 }
				 
	
	}
	
	@Override
	public void AddNewPolicy (String tcID, SoftAssert softAssert,String type) throws Exception
	{
		 func._waitForPageToLoad(getWebDriver(),500L);
		 Thread.sleep(2000);
		PageData dataAddPolicy=null;
		PageData dataNewSubmission=null;
		PageData dataLogin = PageDataManager.instance().getPageData("EscapeLogin",tcID);
		if(type.trim().toLowerCase().equals("new"))
		{
			if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
		
				 dataAddPolicy = PageDataManager.instance().getPageData("QANewSubmission",tcID);
			 }
			 else
			 {
				 dataAddPolicy = PageDataManager.instance().getPageData("NewSubmission",tcID); 
			 }
			
			
		}
		if(type.trim().toLowerCase().equals("renewal"))
		{
			if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
		
				 dataAddPolicy = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
			 }
			 else
			 {
				 dataAddPolicy = PageDataManager.instance().getPageData("EditSubmission",tcID);
			 }
			
			
			
		}
		
	
		 _setValue(getElement(lst_SubmissionStatus),"Policy Bound");
		 //func._waitFor(getElement(lst_PolicyBound), 10, WAIT_FOR.SELECTABLE, "");
		 func._waitForPageToLoad(getWebDriver(),500L);
		 Thread.sleep(5000);

		 if(dataAddPolicy.getData("BusinessSegment").contains("Financial Institutions")||dataAddPolicy.getData("BusinessSegment").equalsIgnoreCase("Professional Liability"))
		 {
			 _setValue(getElement(txt_Limit),dataAddPolicy.getData("Limit"));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 _setValue(getElement(txt_RetentionAttachment),dataAddPolicy.getData("RetentionAttachment"));
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 if(!dataAddPolicy.getData("DateQuoted").equals(""))
		 {
			 _setValue(getElement(dat_DateQuoted),dataAddPolicy.getData("DateQuoted"));
			 WebElement elm = (WebElement) getElement(dat_DateQuoted).getNative();
	          elm.sendKeys(Keys.TAB);
			 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 else
		 {

				 _setValue(getElement(dat_DateQuoted),func.Date_Manipulation("","now", 0));
				 WebElement elm = (WebElement) getElement(dat_DateQuoted).getNative();
		          elm.sendKeys(Keys.TAB);
				 func._waitForPageToLoad(getWebDriver(),50L);
		 }
		 _setValue(getElement(txt_NaicsCode),dataAddPolicy.getData("NaicsCode"));
		 func._waitForPageToLoad(getWebDriver(),50L);
	    _setValue(getElement(txt_QuotedPremium),dataAddPolicy.getData("QuotedPremium"));
	    WebElement elm = (WebElement) getElement(txt_QuotedPremium).getNative();
        elm.sendKeys(Keys.TAB);
	    func._waitForPageToLoad(getWebDriver(),50L);
	    
	    if(dataAddPolicy.getData("BusinessSegment").equals("Wholesale Casualty"))
    		
		{
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_CreditScore),dataAddPolicy.getData("CreditScore"));
	    	Thread.sleep(1000);
	    	if(dataAddPolicy.getData("SubmissionLOB").equals("Commercial Auto")||dataAddPolicy.getData("SubmissionLOB").equals("GL"))
			{
				_setValue(getElement(lst_IncumbentCarNonRenewal),dataAddPolicy.getData("IncumbentCarNonRenewal"));
				func._waitForPageToLoad(getWebDriver(),50L);
				Thread.sleep(2000);
			}	
		}
	    
	    //_click(getElement(btn_NAICSCodeSearch));
	    //Thread.sleep(5000);
	    if(dataAddPolicy.getData("BusinessSegment").contains("Financial Institutions")||dataAddPolicy.getData("BusinessSegment").equalsIgnoreCase("Professional Liability"))
	    {
		    /*if(!dataAddPolicy.getData("SubPublicPrivate").equals(""))
		    {
		    	
		    	 if(dataAddPolicy.getData("SubPublicPrivate").trim().toLowerCase().contains("public"))
		    	 {
		    		 _click(getElement(chk_Public));
		    		 func._waitForPageToLoad(getWebDriver(),50L);
		    	 }
		    	 if(dataAddPolicy.getData("SubPublicPrivate").trim().toLowerCase().contains("private"))
		    	 {
		    		 _click(getElement(chk_Pravite));
		    		 func._waitForPageToLoad(getWebDriver(),50L);
		    	 }
		    }*/
		    	 
	    	 if(dataAddPolicy.getData("PrimaryORExcess").trim().toLowerCase().contains("primary"))
	    	 {
	    		 _click(getElement(radio_QuotedPrimary));
	    		 Thread.sleep(5000);
	    	 }
	    	 if(dataAddPolicy.getData("PrimaryORExcess").trim().toLowerCase().contains("excess"))
	    	 {
	    		 _click(getElement(radio_QuotedExcess));
	    		 func._waitForPageToLoad(getWebDriver(),50L);
	    	 }
	    	 
	    }
	    if(!dataAddPolicy.getData("QuotedLineOfBusiness").equals(""))
   	 	{
	    	_setValue(getElement(lst_QuotedLineBusiness),dataAddPolicy.getData("QuotedLineOfBusiness"));
	    	 func._waitForPageToLoad(getWebDriver(),50L);
	    	 if(!dataNewSubmission.getData("QuotedSubmittedLineOfBusiness").equals(""))
		   	 	{
			    	_setValue(getElement(lst_QuotedSubmittedProduct),dataNewSubmission.getData("QuotedSubmittedLineOfBusiness"));
			    	func._waitForPageToLoad(getWebDriver(),50L);
		   	 	}
   	 	}
	   
	    Thread.sleep(2000);

	    _click(getElement(btn_Save));
	    func._waitForPageToLoad(getWebDriver(),200L);
		 Thread.sleep(3000);
		 try
		 {
		 Alert alert=getWebDriver().switchTo().alert();
		 alert.accept();
		 //func._alertHandler(getWebDriver(), "Ok");
		 Thread.sleep(30000);
		 }
		 catch(Exception e)
		 {
			 
		 }
	    //func._waitForPageToLoad(getWebDriver(),350L);
	    func._waitFor(getElement(btn_AddPolicy), 100, WAIT_FOR.CLICKABLE, "");
	    Thread.sleep(5000);
	}

	@Override
	public void ProcessForNextYearRenewal (String tcID,SoftAssert softAssert) throws Exception
	{
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(3000);
		
		int offset= Integer.valueOf(dataIssuePolicy.getData("PolicyExpirationDate").split("-")[0].trim());
    	String OptValue=dataIssuePolicy.getData("PolicyExpirationDate").split("-")[1].trim();
		String strPolicyExpDate=func.Date_Manipulation("",OptValue, offset);
		
		func._waitFor(getElement(tab_TabSubmission), 100, WAIT_FOR.CLICKABLE, "");
		_click(getElement(tab_TabSubmission));
		 func._waitForPageToLoad(getWebDriver(),100L);
		 Thread.sleep(10000);
		 func._waitFor(getElement(dat_SubmissionEffectiveDate), 200L, WAIT_FOR.VISIBLE);
		
		 WebElement weEffDate=(WebElement)getElement(dat_SubmissionEffectiveDate).getNative();
		 func._addToGlobalVariableList("EffDate", weEffDate.getAttribute("value").trim());
		 WebElement weExpDate=(WebElement)getElement(dat_SubmissionExpaireDate).getNative();
		 func._addToGlobalVariableList("ExpDate", weExpDate.getAttribute("value").trim());
		 
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if((func.DateFormatReturns(strPolicyExpDate, "Days")>120))
		{
				
			if(func._isEnabled(getElement(btn_ProcessNextYearRenewal)))
			{
				CustomReporting.logReport("","Process Next Year Renewal button is Disabled when policy expaire date selected greater then 120 days", "",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			
			}
			else
			{
				CustomReporting.logReport("","", "Process Next Year Renewal button is enabled even if policy expaire datre selected greater then 12o days" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				throw new RuntimeException();
			}
		
			
		}
		if(func.DateFormatReturns(strPolicyExpDate, "Days")<=120)
		{
			
				
			if(!func._isEnabled(getElement(btn_ProcessNextYearRenewal)))
			{
				CustomReporting.logReport("","", "Process Next Year Renewal button is Disabled even if policy expaire date selected less then or equal to 120 days" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				//throw new RuntimeException();
			}
			
			else
			{
				CustomReporting.logReport("","Process Next Year Renewal button is enabled when policy expaire date selected less then or equal to 120 days ", "",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			}
		
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			 func._waitForPageToLoad(getWebDriver(),500L);
			 
			 Thread.sleep(3000);
			 func._waitFor(getElement(btn_ProcessNextYearRenewal), 300, WAIT_FOR.CLICKABLE);
			// func._waitFor(getElement(btn_ProcessNextYearRenewal), 300);
			 Thread.sleep(6000);
			 long startTime1 = System.currentTimeMillis();
				long elapsedTime1=0L;
			 try
			 {
				
			_click(getElement(btn_ProcessNextYearRenewal));
			Thread.sleep(3000);
			 }
			 catch(Exception ex)
			 {
				 Thread.sleep(3000); 
				 _click(getElement(btn_ProcessNextYearRenewal));
					Thread.sleep(3000); 
			 }
			func._alertHandler(getWebDriver(), "Ok");
			func._waitForPageToLoad(getWebDriver(),500L);
			Thread.sleep(3000);
			elapsedTime1 = (new Date()).getTime() - startTime1; 
			CustomReporting.logReport("Time taken to Complete CreateNew Submission Transaction :  "+elapsedTime1 +" ms");
			
			//func._waitFor(getElement(btn_OFACSearchProcessRenewal), 100, WAIT_FOR.CLICKABLE, "");
           // Thread.sleep(2000);
		    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);		 
		   // _click(getElement(btn_OFACSearchProcessRenewal));
		    
		    //was commented till 837
		    
		    /*func._waitFor(getElement(btn_OFACSearch), 30);
		    _click(getElement(btn_OFACSearch));
		    
			//func._alertHandler(getWebDriver(), "Ok");
			//func._waitForPageToLoad(getWebDriver(),50L);
			Thread.sleep(3000);
			func._waitFor(getElement(btn_OFACSearchProcessRenewal), 30);
			_click(getElement(btn_OFACSearchProcessRenewal));
			//_click(getElement(btn_ProcessNextYearRenewal));
			func._waitForPageToLoad(getWebDriver(),50L);
			Thread.sleep(3000);*/
			/*if(type.toLowerCase().equals("new"))
			{
				func._waitFor(getElement(msg_SubmissionRenewal), 500, WAIT_FOR.VISIBLE, "");
				Thread.sleep(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				Thread.sleep(2000);
				WebElement el=(WebElement) getElement(tab_TabSubmission).getNative();
				String getSubmissionNum=el.getText().split(":")[1].trim();
				func._writeToExcel("Search", "SubmissionNumber",getSubmissionNum, tcID);
			}*/
		}
			
	}
	
	@Override
	public void Renewal_SisterPolicy (String tcID,SoftAssert softAssert) throws Exception
	{
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(3000);

		func._waitFor(getElement(tab_TabSubmission), 200, WAIT_FOR.CLICKABLE, "");
		Thread.sleep(3000);
		_click(getElement(tab_TabSubmission));
		func._waitFor(getElement(btn_ProcessNextYearRenewal), 300, WAIT_FOR.CLICKABLE);
		 Thread.sleep(3000);
		 try
		 {
			 _click(getElement(btn_ProcessNextYearRenewal));
			 Thread.sleep(3000);
		 }
		 catch(Exception ex)
		 {
			 Thread.sleep(3000); 
			 _click(getElement(btn_ProcessNextYearRenewal));
				Thread.sleep(3000); 
		 }
		func._alertHandler(getWebDriver(), "Ok");
		func._waitForPageToLoad(getWebDriver(),500L);
		Thread.sleep(3000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);		 
			
	}
	
	@Override
	
	
	public void ProspectFromPreviousYear (String tcID,SoftAssert softAssert) throws Exception
	{
		PageData dataNewSubmission=null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID); 
		 }
		
		
		int offset= Integer.valueOf(dataNewSubmission.getData("SubmissionExpaireDate").split("-")[0].trim());
    	String OptValue=dataNewSubmission.getData("SubmissionExpaireDate").split("-")[1].trim();
		String strSubmissionExpDate=func.Date_Manipulation("",OptValue, offset);
		func._waitFor(getElement(tab_TabSubmission), 500, WAIT_FOR.CLICKABLE, "");
		Thread.sleep(2000);
		_click(getElement(tab_TabSubmission));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if((func.DateFormatReturns(strSubmissionExpDate, "Days")>90))
		{
		
				
				if(!func._isEnabled(getElement(chk_ProspectForNextYear)))
				{
					CustomReporting.logReport("","Processed Renewal Submission check box is Disabled", "",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				}

				else
				{
					CustomReporting.logReport("","", "Processed Renewal Submission check box is enabled even if Submissiion expaire date greater then 90 days from received date" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
					throw new RuntimeException();
				}
		
	
				
				if(!func._isEnabled(getElement(btn_WorkOnProspect)))
				{
					CustomReporting.logReport("","Work on Prospect From Previous Year button is Disabled", "",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				
				}
				else
				{
			
		
					CustomReporting.logReport("","", "Work on Prospect From Previous Year button is enabled even if Submissiion expaire date selected grater then 90 days from received date" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
					throw new RuntimeException();
				}
		
			
		}
		if(func.DateFormatReturns(strSubmissionExpDate, "Days")<=90)
		{
			
				
				if(!func._isEnabled(getElement(chk_ProspectForNextYear)))
				{
					CustomReporting.logReport("","", "Processed Renewal Submission check box is Disabled even if submission expaire date selected less then or equal to 90 days from received date" + 
							"" + 
							"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
					throw new RuntimeException();
				}
				else
				{
					CustomReporting.logReport("","Processed Renewal Submission check box is enabled when submission expaire date selected less then or equal to 90 days from received date", "",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
					_click(getElement(chk_ProspectForNextYear));	
				}
		
			
			
				
				if(!func._isEnabled(getElement(btn_WorkOnProspect)))
				{
					CustomReporting.logReport("","", "Work on Prospect From Previous Year button is Disabled even if submission expaire date selected less then or equal to 90 days from received date" + 
							"" + 
							"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
					throw new RuntimeException();
				}
				else
				{
					CustomReporting.logReport("","Work on Prospect From Previous Year button is enabled when submission expaire date selected less then or equal to 90 days from received date", "",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				}
			
				
			
		
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			Thread.sleep(3000);
			_click(getElement(btn_WorkOnProspect));
			Thread.sleep(2000);
			func._alertHandler(getWebDriver(), "Ok");
			 func._waitForPageToLoad(getWebDriver(),50L);
			 Thread.sleep(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			WebElement el=(WebElement) getElement(tab_TabSubmission).getNative();
			String getSubmissionNum=el.getText().split(":")[1].trim();
			

			
			if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
				func._writeToExcel("QASearch", "SubmissionNumber",getSubmissionNum, tcID);
			 }
			else
			{
				func._writeToExcel("Search", "SubmissionNumber",getSubmissionNum, tcID);
			}
				
			}
			
	}


	
	@Override
	public void OpenSubSearchResult (String tcID, SoftAssert softAssert) throws Exception
	{
		 Thread.sleep(2000);
		func._waitFor(getElement(lnk_SubmissionNum), 500, WAIT_FOR.CLICKABLE, "");
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_click(getElement( lnk_SubmissionNum));
			 func._waitForPageToLoad(getWebDriver(),50L);
		
	
	}
	@Override
	public void VerifyProcessNextYearRenewal (String tcID, SoftAssert softAssert) throws Exception
	{
		 func._waitForPageToLoad(getWebDriver(),150L);
		 Thread.sleep(3000);
		func._waitFor(getElement(msg_SubmissionRenewal), 500, WAIT_FOR.VISIBLE, "");
		
		if(func._isVisible(getElement(lst_BusinessSegment)))
		{
			if(func._checkAttributeValue(getElement(msg_SubmissionRenewal),"TEXT","Renewal Processed Successfully",softAssert))
			 {
				 CustomReporting.logReport("","","Renewal submission screen is displayed when user click on Process Next Year Renewal button." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis()); 
			 }
			 else
			 {
				 CustomReporting.logReport("","", "Renewal submission screen is not displayed when user click on Process Next Year Renewal button.","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					//throw new RuntimeException();
			 }
		}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		 //func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
		 if(func._checkAttributeValue(getElement(msg_SubmissionRenewal),"TEXT","Renewal Processed Successfully",softAssert))
		 {
			 CustomReporting.logReport("","","Submission is renewed successfully" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
		 }
		 else
		 {
			 CustomReporting.logReport("","", "Submission is not Renewed","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		 }
		 WebElement el=(WebElement) getElement(tab_TabSubmission).getNative();
		String getSubmissionVersion=el.getText().split("-")[1].trim();
		String getSubmissionNum=el.getText().split(":")[1].trim();
		int intSubVer=Integer.valueOf(getSubmissionVersion);
		if(intSubVer>1)
		//if(getSubmissionNum.split("-")[1].equals("2"))
		{
			 CustomReporting.logReport("","","Verified a Renewal submission created with the Same submission # with different Version#" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
		}
		 else
		 {
			 CustomReporting.logReport("","", "Failed to verify a Renewal submission created with the Same submission # with different Version#","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			
		 }
		
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			func._writeToExcel("QASearch","SubmissionNumber",getSubmissionNum, tcID);
			func._writeToExcel("QANewSubmission","SubmissionNumber",getSubmissionNum, tcID);
		 }
		else
		{
			func._writeToExcel("Search","SubmissionNumber",getSubmissionNum, tcID);
			func._writeToExcel("NewSubmission","SubmissionNumber",getSubmissionNum, tcID);
		}


	
	}
	
	@Override
	public void clkOFACSearchProcessRenewal (String tcID, SoftAssert softAssert,String type) throws Exception
	{
		PageData dataAccount=null;
		if(type.trim().toLowerCase().equals("new"))
		{
			dataAccount = PageDataManager.instance().getPageData("Account",tcID);
			if(!dataAccount.getData("Sys_tcID").equals(""))
			{
				dataAccount = PageDataManager.instance().getPageData("Account",dataAccount.getData("Sys_tcID"));	
			}
		}
		if(type.trim().toLowerCase().equals("edit"))
		{
			dataAccount = PageDataManager.instance().getPageData("EditAccount",tcID);
			if(!dataAccount.getData("Sys_tcID").equals(""))
			{
				dataAccount = PageDataManager.instance().getPageData("EditAccount",dataAccount.getData("Sys_tcID"));	
			}
		}
		Thread.sleep(3000);
		func._waitFor(getElement(btn_OFACSearch), 300, WAIT_FOR.CLICKABLE, "");
		if(func._isVisible(getElement(btn_OFACSearch)))
		{

			CustomReporting.logReport("","","Forcing OFAC search while renewal of existing submission " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		}
		else
		{
			CustomReporting.logReport("","", "Not Forcing OFAC search while renewal of existing submission","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			throw new RuntimeException();
		}
		if(type.trim().toLowerCase().equals("edit"))
		{
			if(func._checkAttributeValue(getElement(OFC_insureName), "value", dataAccount.getData("InsuredName"), softAssert)) 
			{
	
			CustomReporting.logReport("","","Edited Insure Name is dispalyed in OFAC search while renewal submission " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			}
			else
			{
				CustomReporting.logReport("","", "Edited Insure Name is not dispalyed in OFAC search while renewal submission","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
				throw new RuntimeException();
			}
		}
		if(type.trim().toLowerCase().equals("new"))
		{
			String strExpInsureName="";
			if(dataAccount.getData("InsuredName").contains(";"))
			{
				strExpInsureName=dataAccount.getData("InsuredName").split(";")[0].trim();
			}
			else
			{
				strExpInsureName=dataAccount.getData("InsuredName").trim();
			}
			if(func._checkAttributeValue(getElement(OFC_insureName), "value", strExpInsureName, softAssert)) 
			{
	
			CustomReporting.logReport("","","Insure Name is dispalyed in OFAC search while renewal submission " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			}
			else
			{
				CustomReporting.logReport("","", "Insure Name is not dispalyed in OFAC search while renewal submission","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
				//throw new RuntimeException();
			}
		}
		Thread.sleep(4000);
		_click(getElement(btn_OFACSearch));
		
		func._waitFor(getElement(btn_OFACSearchProcessRenewal), 500, WAIT_FOR.CLICKABLE, "");
		
			//Thread.sleep(5000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		 Thread.sleep(4000);
			 //func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
		_click(getElement(btn_OFACSearchProcessRenewal));
		
		int loocCount=0;
		do
		{
			if(func._isVisible(getElement(msg_SubmissionRenewal)))
			{
				break;
			}
			loocCount=loocCount+1;
		}while(loocCount<100);
		func._waitForPageToLoad(getWebDriver(),500L);
		Thread.sleep(5000);
		//func._waitFor(getElement(msg_SubmissionRenewal), 700, WAIT_FOR.VISIBLE, "");
		 func._checkDefaultValue(getElement(msg_SubmissionRenewal),"TEXT","Renewal Processed Successfully");
		 WebElement el=(WebElement) getElement(tab_TabSubmission).getNative();
		String getSubmissionNum=el.getText().split(":")[1].trim();
		
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		PageData dataSub = PageDataManager.instance().getPageData("NewSubmission",tcID);
		if(!dataSub.getData("Ref_TC_ID").equals(""))
		{
			tcID=dataSub.getData("Ref_TC_ID");
		}
		
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			func._writeToExcel("NewSubmission", "SubmissionNumber",getSubmissionNum, tcID);
			func._writeToExcel("QASearch", "SubmissionNumber",getSubmissionNum, tcID);
		 }
		else
		{
			func._writeToExcel("NewSubmission", "SubmissionNumber",getSubmissionNum, tcID);
			func._writeToExcel("Search", "SubmissionNumber",getSubmissionNum, tcID);
		}
		
		
	}
	
	@Override
	public void VerifyRenewalSubEffDate (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataNewSubmission =null;
		WebElement elm =null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
		 }
		
		_click(getElement(tab_TabSubmission));
		func._waitForPageToLoad(getWebDriver(),50L);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		String strSubEffDate= getElement(dat_SubmissionEffectiveDate).getAttribute("value");

		_setValue(getElement(dat_SubmissionEffectiveDate),func.Date_Manipulation(strSubEffDate, "Days", 1));
		 elm = (WebElement) getElement(dat_SubmissionEffectiveDate).getNative();
         elm.sendKeys(Keys.TAB);
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(2000);
    	_click(getElement(btn_Save));
    	func._waitForPageToLoad(getWebDriver(),150L);
    	Thread.sleep(15000);
    	_click(getElement(img_ErrorIcon));
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 func._waitForPageToLoad(getWebDriver(),50L);
		WebElement ele = (WebElement) getElement(msg_Error).getNative();
		boolean isErrorExist=func._isVisible(getElement(msg_Error));
		long startTime = System.currentTimeMillis();
		if(isErrorExist)
		{
			CustomReporting.logReport("","","The following error message is displaying when  renewal submission effective date is selected greater than prior term exipiration date :"+ele.getText() ,StepStatus.SUCCESS,new String[] { },startTime);	
		}
		else
		{
			CustomReporting.logReport("","", "Error message is not Displayed when  renewal submission effective date is selected greater than prior term exipiration date :","", StepStatus.FAILURE,new String[] {  }, startTime, null);	
		}

		/* cal.add(Calendar.DAY_OF_MONTH,-3);
		 String dt2 = datSubEffDate.format(cal.getTime());*/
		 _setValue(getElement(dat_SubmissionEffectiveDate),func.Date_Manipulation(strSubEffDate, "Days", -3));
		 elm = (WebElement) getElement(dat_SubmissionEffectiveDate).getNative();
         elm.sendKeys(Keys.TAB);
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
	    	_click(getElement(btn_Save));
	    	func._waitForPageToLoad(getWebDriver(),150L);
	    	Thread.sleep(20000);
		_click(getElement(img_ErrorIcon));
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 func._waitForPageToLoad(getWebDriver(),50L);
		WebElement ele2 = (WebElement) getElement(msg_Error).getNative();
		String errmsg=ele2.getText();
		boolean isErrorExist2=func._isVisible(getElement(msg_Error));
	    startTime = System.currentTimeMillis();
		if(isErrorExist2)
		{

			CustomReporting.logReport("","","The following error message is displaying when  renewal submission effective date is selected less than prior term exipiration date :"+errmsg ,StepStatus.SUCCESS,new String[] { },startTime);	
		}
		else
		{
			CustomReporting.logReport("","", "error message is not displayed when  renewal submission effective date is selected less than prior term exipiration date","", StepStatus.FAILURE,new String[] {  }, startTime, null);	
		}
		int offset= Integer.valueOf(dataNewSubmission.getData("SubmissionExpaireDate").split("-")[0].trim());
    	String OptValue=dataNewSubmission.getData("SubmissionExpaireDate").split("-")[1].trim();
    	
		if(strSubEffDate.equals(func.Date_Manipulation("",OptValue, offset)))
		 {
			CustomReporting.logReport("","","Renewal submission effective date displaying as prior term expiration date while renewal the submission" ,StepStatus.SUCCESS,new String[] { },startTime);	
			 _setValue(getElement(dat_SubmissionEffectiveDate),strSubEffDate);
			  elm = (WebElement) getElement(dat_SubmissionEffectiveDate).getNative();
	         elm.sendKeys(Keys.TAB);
			 func._waitForPageToLoad(getWebDriver(),50L);
			 Thread.sleep(2000);
			 _click(getElement(btn_Save));
			 func._waitForPageToLoad(getWebDriver(),150L);
			 Thread.sleep(20000);
			 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 func._checkDefaultValue(getElement(msg_SubmissionSuccessmsg),"TEXT","Account & Submission information updated successfully");
		 }
		else
		{
			CustomReporting.logReport("","", "Renewal submission effective date is not displaying as prior term expiration date while renewal the submission","", StepStatus.FAILURE,new String[] {  }, startTime, null);
		}
	
	}
	
	@Override
	public void VerifySubDescription (String tcID, SoftAssert softAssert,String CopyOREdit) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),150L);
    	Thread.sleep(2000);
		PageData dataSearch = null;
		PageData dataEditSubmission = null;
		PageData dataCopySubmission = null;
		String strDesc="";
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(CopyOREdit.trim().toLowerCase().equals("edit"))
		{
			
			if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
		
			dataEditSubmission = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
			 dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
			 }
			 else
			 {
				 dataEditSubmission = PageDataManager.instance().getPageData("EditSubmission",tcID);
				  dataSearch = PageDataManager.instance().getPageData("Search",tcID);
			 }
			
			
		}
		if(CopyOREdit.trim().toLowerCase().equals("copy"))
		{

			if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
		
			dataCopySubmission = PageDataManager.instance().getPageData("CopySubmission",tcID);
			 dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
			 }
			 else
			 {
				 dataCopySubmission = PageDataManager.instance().getPageData("CopySubmission",tcID);
				  dataSearch = PageDataManager.instance().getPageData("Search",tcID);
			 }
		}
		if(CopyOREdit.trim().toLowerCase().equals("new"))
		{
			if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
		
				dataEditSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
				 dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
			 }
			 else
			 {
				 dataEditSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
				 dataSearch = PageDataManager.instance().getPageData("Search",tcID);
			 }
			
			
		}
		StringBuilder result = new StringBuilder();
		if(!CopyOREdit.trim().toLowerCase().equals("new"))
		{
			if(!CopyOREdit.trim().toLowerCase().equals("copy"))
			{
				if(dataEditSubmission.getData("SubDescription").length()>9)
				{
					//strDesc=result.append(dataSearch.getData("SubmissionNumber").substring(0, 9).trim()).append("\n").append(dataEditSubmission.getData("SubDescription").substring(0, 10).trim()+"...").toString();
				
					strDesc=dataEditSubmission.getData("SubDescription").trim();
				} 
				else
				{
					strDesc=result.append(dataSearch.getData("SubmissionNumber").trim()).append("\n").append(dataEditSubmission.getData("SubDescription").substring(0, 10).trim()).toString();
				}
			}
			else
			{
				if(dataCopySubmission.getData("SubDescription").trim().length()>9)
				{
					strDesc=result.append(dataSearch.getData("SubmissionNumber").trim().substring(0, 9).trim()).append("\n").append(dataCopySubmission.getData("SubDescription").substring(0, 10).trim()+"...").toString();
				} 
				else
				{
					strDesc=result.append(dataSearch.getData("SubmissionNumber").trim()).append("\n").append(dataCopySubmission.getData("SubDescription").substring(0, 10).trim()).toString();
				}
			}
		}
		else
		{
			strDesc=dataSearch.getData("SubmissionNumber");
		}
		if(CopyOREdit.trim().toLowerCase().equals("edit")||(CopyOREdit.trim().toLowerCase().equals("new")))
		{
			func._waitFor(getElement(getSubmissionNumber), 300, WAIT_FOR.CLICKABLE);
			Thread.sleep(3000);
			WebElement weDesc=(WebElement)getElement(getSubmissionNumber).getNative();
			
			String Title=weDesc.getAttribute("title");
			
			System.out.println(Title);
			
			
			
			if(Title.contains(strDesc))
			
			//if(func._checkAttributeValue(getElement(getSubmissionNumber),"TEXT",strDesc,softAssert))
			{
				CustomReporting.logReport("","","Submission description is displayed with submission number on transaction tree like-"+strDesc,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Submission description is not displayed with submission number on transaction tree","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
		if(CopyOREdit.trim().toLowerCase().equals("copy"))
		{
		
			/*_checkDefaultValue(getElement(getSubmissionNumber2),"TEXT",dataSearch.getData("SubmissionNumber").trim());*/
			WebElement weDesc=(WebElement)getElement(getSubmissionNumber2).getNative();
			System.out.println(weDesc.getText());
			if(weDesc.getText().contains(strDesc))
			
			
			//if(func._checkAttributeValue(getElement(getSubmissionNumber2),"TEXT",strDesc,softAssert))
			{
				CustomReporting.logReport("",""," submission description value is carry forwarded from new submission screen to copy submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", " submission description value is not carry forwarded from new submission screen to copy submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
		
		if(CopyOREdit.trim().toLowerCase().equals("edit")||(CopyOREdit.trim().toLowerCase().equals("new")))
		{
		if(func._checkAttributeValue(getElement(txt_SubDescription),"value",dataEditSubmission.getData("SubDescription"),softAssert))
			{
				CustomReporting.logReport("",""," submission description field value is carry forwarded next submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", " submission description field value is not carry forwarded next submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		// func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
		}
	}
	
	
	@Override
	public void Verify_Delete_SubDescription (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataSearch = null;
		PageData dataEditSubmission = null;
		PageData dataSubmission =null;
		String strDesc;
		_setValue(getElement(txt_SubDescription)," ");
		NewSubmission objNewSubmission = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
		objNewSubmission.clkSave(tcID, softAssert);
		func._waitForPageToLoad(getWebDriver(),50L);
		
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			dataSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
			 dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
		 }
		 else
		 {
			  dataSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
			   dataSearch = PageDataManager.instance().getPageData("Search",tcID);
		 }
		 
		
		WebElement el=(WebElement)getElement(getSubmissionNumber).getNative();
		String getSubmissionNum=el.getText().trim();
		if(!getSubmissionNum.equals(dataSearch.getData("SubmissionNumber").trim()))
		{
			CustomReporting.logReport("","","Verified that no submission description is displayed on transaction tree after removed prevous value and save." + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Still submission description is displayed on transaction tree even though after removed prevous value and save","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			throw new RuntimeException();
		}
		
		
		
		 
	}

	
	@Override
	public void Verify_Renewal_SubDescription (String tcID, SoftAssert softAssert) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(), 300L);
		Thread.sleep(5000);
		PageData dataSearch = null;;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		PageData dataEditSubmission =null;
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			dataEditSubmission = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
			 dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
		 }
		 else
		 {
			  dataEditSubmission = PageDataManager.instance().getPageData("EditSubmission",tcID);
			   dataSearch = PageDataManager.instance().getPageData("Search",tcID);
		 }
	
		
		String Subnum=dataSearch.getData("SubmissionNumber").split("-")[0]+"-2";
		String strDesc;
		
		StringBuilder result = new StringBuilder();
		if(dataEditSubmission.getData("SubDescription").length()>10)
		{
			strDesc=result.append(Subnum).append("\n").append(dataEditSubmission.getData("SubDescription").substring(0, 10).trim()+"...").toString();
		} 
		
		else
		{
			strDesc=result.append(Subnum).append("\n").append(dataEditSubmission.getData("SubDescription").substring(0, 10).trim()).toString();
		}
		Thread.sleep(5000);
		func._waitFor(getElement(getRenewalSubmissionNumber), 300, WAIT_FOR.CLICKABLE);
		
		WebElement desc=(WebElement)getElement(getRenewalSubmissionNumber).getNative();
		//if(func._checkAttributeValue(getElement(getRenewalSubmissionNumber),"TEXT",strDesc,softAssert))
		if(desc.getText().contains(strDesc))
			{
				CustomReporting.logReport("","","Submisison description value is carry forward from the submission screen to renewal submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Submisison description value is not carry forward from the submission screen to renewal submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		 _setValue(getElement(txt_SubDescription),dataEditSubmission.getData("RenewalSubDescription"));
		 func._waitForPageToLoad(getWebDriver(),500L);
		 Thread.sleep(2000);
		 _click(getElement(btn_Save));
		 func._waitForPageToLoad(getWebDriver(),500L);
		 Thread.sleep(5000);
		 int intloopCount=0;
		 do
		 {
			 if(func._isVisible(getElement(msg_SubmissionSuccessmsg)))
			 {
				 break;
			 }
			 Thread.sleep(10000);
			 intloopCount=intloopCount+1;
		 }while(intloopCount<100);
		 String strRenewalDesc;
		 StringBuilder SB = new StringBuilder();
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 if(dataEditSubmission.getData("RenewalSubDescription").length()>10)
		{
			 strRenewalDesc=SB.append(Subnum).append("\n").append(dataEditSubmission.getData("RenewalSubDescription").substring(0, 10).trim()+"...").toString();
		} 
		else
		{
			strRenewalDesc=SB.append(Subnum).append("\n").append(dataEditSubmission.getData("RenewalSubDescription").substring(0, 10).trim()).toString();
		}
		 try
		 {
			 WebElement weRenAccountExp=(WebElement)getElement(lnk_RenevalAccount_expOrColpse).getNative();
			 String strColpseOrExp=weRenAccountExp.getAttribute("alt").trim().toLowerCase();
			 if(strColpseOrExp.contains("expand"))
			 {
				_click(getElement(lnk_RenevalAccount_expOrColpse)) ;
				Thread.sleep(3000);
			 }
		 }
		 catch(Exception ex)
		 {
			 
		 }
		 WebElement desc1=(WebElement)getElement(lnk_RenevalSubNum).getNative();
		 
		// if(func._checkAttributeValue(getElement(getRenewalSubmissionNumber),"TEXT",strRenewalDesc,softAssert))
		 if(desc1.getText().contains(strRenewalDesc))
			{
				CustomReporting.logReport("","","Edited submission description in the renewal submission screen  is displayed with submission number in transaction tree" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Edited submission description in the renewal submission screen  is not displayed with submission number on transaction tree","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		 //func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
	}
	
	@Override
	public void EditSubmission (String tcID, SoftAssert softAssert,String CopyOREdit) throws Exception
	{
		PageData dataEditSubmission = null;
		 String BSValue;
		 String SSValue;
		 String SLOB;
		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(CopyOREdit.trim().toLowerCase().equals("edit"))
		{
			if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
		
				dataEditSubmission = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
			 }
			 else
			 {
				 dataEditSubmission = PageDataManager.instance().getPageData("EditSubmission",tcID);
			 }
		

		}
		if(CopyOREdit.trim().toLowerCase().equals("copy"))
		{
		dataEditSubmission = PageDataManager.instance().getPageData("CopySubmission",tcID);
		}
		if(CopyOREdit.trim().toLowerCase().equals("resubmit"))
		{
		dataEditSubmission = PageDataManager.instance().getPageData("EditSubmission",tcID);
		}
		Thread.sleep(3000);

		func._waitFor(getElement(tab_TabSubmission), 500, WAIT_FOR.CLICKABLE, "");
		_click(getElement(tab_TabSubmission));
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(5000);
		
		if(!dataEditSubmission.getData("BusinessSegment").equals(""))
		{
			if(!func._getAttributeValue(getElement(lst_BusinessSegment),"TEXT",softAssert).equals(dataEditSubmission.getData("BusinessSegment")))
			{
			_setValue(getElement(lst_BusinessSegment),dataEditSubmission.getData("BusinessSegment"));
			func._waitForPageToLoad(getWebDriver(),50L);
			}
		}
		if(!dataEditSubmission.getData("BusinessOffice").equals(""))
		{
	    _setValue(getElement(lst_BranchOffice),dataEditSubmission.getData("BusinessOffice"));
	    func._waitForPageToLoad(getWebDriver(),50L);
		}
		if(!dataEditSubmission.getData("PredominantState").equals("")) {
		 _setValue(getElement(lst_PredominantState),dataEditSubmission.getData("PredominantState"));
		 func._waitForPageToLoad(getWebDriver(),50L);
		}
		 Thread.sleep(5000);
		 SSValue=func._getAttributeValue(getElement(lst_SubmissionStatus), "TEXT", softAssert);
		if(!dataEditSubmission.getData("SubmissionStatus").equals(""))
		{
			//if(SSValue.equals("Working")||SSValue.equals("Received"))
			if(!SSValue.equals("Policy Bound"))
			{
				if(!dataEditSubmission.getData("SubmissionStatus").equals(""))
				{
				_setValue(getElement(lst_SubmissionStatus),dataEditSubmission.getData("SubmissionStatus"));
				func._waitForPageToLoad(getWebDriver(),50L);
				}
			}
		}
		Thread.sleep(3000);
		if(!dataEditSubmission.getData("SubmissionType").equals(""))
		{
	    _setValue(getElement(lst_SubmissionType),dataEditSubmission.getData("SubmissionType"));
	    func._waitForPageToLoad(getWebDriver(),50L);
		}
		if(!dataEditSubmission.getData("ReceivedDate").equals(""))
		{
	    _setValue(getElement(dat_ReceivedDate),dataEditSubmission.getData("ReceivedDate"));
	    WebElement elm = (WebElement) getElement(dat_ReceivedDate).getNative();
        elm.sendKeys(Keys.TAB);
	    func._waitForPageToLoad(getWebDriver(),50L);
		}
		/*if(!dataEditSubmission.getData("Distribution").equals(""))
		{
	    _setValue(getElement(lst_Distribution),dataEditSubmission.getData("Distribution"));
	    func._waitForPageToLoad(getWebDriver(),50L);
		}*/
		if(!dataEditSubmission.getData("SubmissionEffectiveDate").equals("NA"))
		{
			if(!dataEditSubmission.getData("SubmissionEffectiveDate").equals(""))
			{
		    _setValue(getElement(dat_SubmissionEffectiveDate),dataEditSubmission.getData("SubmissionEffectiveDate"));
		    WebElement elm = (WebElement) getElement(dat_SubmissionEffectiveDate).getNative();
	        elm.sendKeys(Keys.TAB);
		    func._waitForPageToLoad(getWebDriver(),50L);
			}
		}
		
		if(!dataEditSubmission.getData("SubmissionExpaireDate").equals("NA"))
		{
		    if(!dataEditSubmission.getData("SubmissionExpaireDate").equals(""))
		    {
		    	int offset= Integer.valueOf(dataEditSubmission.getData("SubmissionExpaireDate").split("-")[0].trim());
		    	String OptValue=dataEditSubmission.getData("SubmissionExpaireDate").split("-")[1].trim();
		    	_setValue(getElement(dat_SubmissionExpaireDate),func.Date_Manipulation("",OptValue, offset));
		    	   WebElement elm = (WebElement) getElement(dat_SubmissionExpaireDate).getNative();
		           elm.sendKeys(Keys.TAB);
		    	func._waitForPageToLoad(getWebDriver(),50L);
		    }
		}
		if(!dataEditSubmission.getData("MarketSegment").equals(""))
		{
	    	if(dataLogin.getData("Environment").toUpperCase().equals("SIT"))
			 {
	    		_setValue(getElement(lst_marketSegment),dataEditSubmission.getData("MarketSegment_SIT"));
	    		func._waitForPageToLoad(getWebDriver(),50L);
			 }
	    	else
	    	{
	    		_setValue(getElement(lst_marketSegment),dataEditSubmission.getData("MarketSegment"));
	    		func._waitForPageToLoad(getWebDriver(),50L);	
	    	}
		}
	    if(!dataEditSubmission.getData("IncumbentCarrier").equals(""))
		{
	  	_setValue(getElement(lst_IncumbentCarrier),dataEditSubmission.getData("IncumbentCarrier"));
	  	func._waitForPageToLoad(getWebDriver(),50L);
		}
	    if(!dataEditSubmission.getData("SubmissionLOB").equals(""))
		{
	    	_setValue(getElement(lst_SubmissionLOB),dataEditSubmission.getData("SubmissionLOB"));
	    	func._waitForPageToLoad(getWebDriver(),50L);
	    	/*if(dataEditSubmission.getData("SubmissionLOB").equals("Workers Comp"))
		    {
	    		_setValue(getElement(txt_ScheduleRatingMod),dataEditSubmission.getData("ScheduleRatingMod"));
	    		func._waitForPageToLoad(getWebDriver(),50L);
	    		_setValue(getElement(txt_ExperienceMod),dataEditSubmission.getData("ExperienceMod"));
	    		func._waitForPageToLoad(getWebDriver(),50L);
		    }*/
		}
	    
	    if((dataEditSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataEditSubmission.getData("BusinessSegment").equals("Alternative Solutions")||dataEditSubmission.getData("BusinessSegment").equals("Private Company Group")||dataEditSubmission.getData("BusinessSegment").equals("Professional Liability")||dataEditSubmission.getData("BusinessSegment").equalsIgnoreCase("Executive Solutions") 
	    		||dataEditSubmission.getData("BusinessSegment").equals("Wholesale Property")||dataEditSubmission.getData("BusinessSegment").equals("Cyber Liability Group")) 
	    		&&(dataEditSubmission.getData("SubmissionLOB").equals("Private Co Exp") ||dataEditSubmission.getData("SubmissionLOB").equals("Cyber Elevation")|| dataEditSubmission.getData("QuotedLineOfBusiness").equals("Package")))

		{
			if(func._isVisible(getElement(tab_SubmittedProfile)))
			{
				CustomReporting.logReport("","","Submitted Profile section is displayed for the LOB 'Priv Co Expedition'" + "" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

				_click(getElement(tab_SubmittedProfile));
				func._waitForPageToLoad(getWebDriver(),50L);
				Thread.sleep(2000);
				String[] arrSelect=null;
				String[] arrverifySubProfile=null;
			
				if(dataEditSubmission.getData("Verify Sub Profile").contains(";"))
				{
					arrverifySubProfile=dataEditSubmission.getData("Verify Sub Profile").split(";");
					
					for(int i=0;i<arrverifySubProfile.length;i++)
					{
						if(func._isVisible(getClonedElement(chk_SubmittedProfile).addToken("tkn_SubmittedProfile",arrverifySubProfile[i].trim())))
						{
							CustomReporting.logReport("","","'"+ arrverifySubProfile[i] +"' check exist in the Submissionh profile  for the LOB 'Priv Co Expedition'" + "" + 
									"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
							
						}
						
						else
						{
							CustomReporting.logReport("","","'"+ arrverifySubProfile[i] + "Submitted Profile section is not displayed for the LOB 'Priv Co Expedition" + 
									"" + 
									"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
							
						}
					}				
				
				}
				

				if(dataEditSubmission.getData("SubmittedProfile").contains(";"))
				{
					arrSelect=dataEditSubmission.getData("SubmittedProfile").split(";");
					for(int i=0;i<arrSelect.length;i++)
					{
						_click(getClonedElement(chk_SubmittedProfile).addToken("tkn_SubmittedProfile",arrSelect[i].trim()));
						func._waitForPageToLoad(getWebDriver(), 150L);
						Thread.sleep(2000);
						

					}
				
				}
				

				else
				{
					_click(getClonedElement(chk_SubmittedProfile).addToken("tkn_SubmittedProfile",dataEditSubmission.getData("SubmittedProfile")));
					Thread.sleep(2000);

				}
				_click(getElement(tab_SubmittedProfile));
				func._waitForPageToLoad(getWebDriver(),50L);
				Thread.sleep(2000);
				}
			else
			{
				CustomReporting.logReport("","", "Submitted Profile section is not dispalyed  for the LOB 'Priv Co Expedition'" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);	
				throw new RuntimeException();
			}

		    }
	    Thread.sleep(5000);
	    if(!dataEditSubmission.getData("Producername").equals(""))
		{
	    	if(dataEditSubmission.getData("Producername").equals("10421"))
	    	{
	    		getWebDriver().findElement(By.xpath(".//*[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlProducerName']//*[text()='United Valley Insurance Services, Inc.']")).click();
	    		func._waitForPageToLoad(getWebDriver(),50L);
	    	}
	    	else
	    	{
	    	
	    		_setValue(getElement(lst_Producername),dataEditSubmission.getData("Producername"));
	    		func._waitForPageToLoad(getWebDriver(),50L);
	    	}
		}
	    if(!dataEditSubmission.getData("ProducerOffice").equals(""))
		{
	    	 Thread.sleep(5000);
	    _setValue(getElement(lst_ProducerOffice),dataEditSubmission.getData("ProducerOffice"));
	    func._waitForPageToLoad(getWebDriver(),50L);
		}
	    if(!dataEditSubmission.getData("SubProducer").equals(""))
	    {
	    	_setValue(getElement(lst_SubProducer),dataEditSubmission.getData("SubProducer"));
	    	func._waitForPageToLoad(getWebDriver(),50L);
	    }
	    Thread.sleep(2000);
	    if(!dataEditSubmission.getData("UWName").equals(""))
		{
	    _setValue(getElement(lst_UWName),dataEditSubmission.getData("UWName"));
	    func._waitForPageToLoad(getWebDriver(),50L);
		}
	    if(!dataEditSubmission.getData("UWAssistant").equals(""))
		{
	    _setValue(getElement(lst_UWAssistant),dataEditSubmission.getData("UWAssistant"));
	    func._waitForPageToLoad(getWebDriver(),50L);
		}
	    if(!dataEditSubmission.getData("EstimatedPremium").equals(""))
		{
	    _setValue(getElement(txt_EstimatedPremium),dataEditSubmission.getData("EstimatedPremium"));
	    func._waitForPageToLoad(getWebDriver(),50L);
		}
	    if(!dataEditSubmission.getData("EverestCompany").equals(""))
		{
	    _setValue(getElement(lst_EverestCompany),dataEditSubmission.getData("EverestCompany"));
	    func._waitForPageToLoad(getWebDriver(),50L);
		}
	    Thread.sleep(3000);
	    BSValue=func._getAttributeValue(getElement(lst_SelectedBusinessSegment), "TEXT", softAssert);
	    SSValue=func._getAttributeValue(getElement(lst_SubmissionStatus), "TEXT", softAssert);
	    SLOB=func._getAttributeValue(getElement(lst_SubmissionLOB), "TEXT", softAssert);
	    
	    //if(((BSValue.equals("Wholesale Property"))||((BSValue.equals("Financial Institutions")))&&(SLOB.equals("Blend"))||(SSValue.equals("Policy Bound"))))
	    if((BSValue.equals("Wholesale Property")||BSValue.equals("Financial Institutions"))&&(SLOB.equals("Blend")))   
	    {
			_click(getElement(tab_SubmittedProfile));
			func._waitForPageToLoad(getWebDriver(),50L);
			Thread.sleep(3000);
	    	if(dataEditSubmission.getData("SubmittedProfile").contains(";"))
	    	{
	    		String[] strarr;
	    		strarr=dataEditSubmission.getData("SubmittedProfile").split(";");
	    		for(String vararr:strarr)
	    		{
	    			_click(getClonedElement(chk_SubmittedProfile).addToken("tkn_SubmittedProfile",vararr.trim()));
	    			func._waitForPageToLoad(getWebDriver(),50L);
	    		}
	    	}
	    	else
	    	{
	    		_click(getClonedElement(chk_SubmittedProfile).addToken("tkn_SubmittedProfile",dataEditSubmission.getData("SubmittedProfile")));
	    		func._waitForPageToLoad(getWebDriver(),50L);
	    		
	    	}
	    	func._checkAttributeValue(getElement(lbl_SublinesStatus), "TEXT", dataEditSubmission.getData("SubmittedProfile").replace(";", "|"), softAssert);
	    }
		
		if(BSValue.equals("Financial Institutions")&&(SLOB.equals("Package")))
		    
	    {
			func._waitForPageToLoad(getWebDriver(),50L);
			_click(getElement(tab_SubmittedProfile));
			func._waitForPageToLoad(getWebDriver(),50L);
			Thread.sleep(2000);
			String[] arrSelect=null;
			String[] arrLimit=null;
			String[] arrRetention=null;
			String[] arrpremium=null;
	    	if(dataEditSubmission.getData("SubmittedProfile").contains(";"))
	    	{
	    		arrSelect=dataEditSubmission.getData("SubmittedProfile").split(";");
	    	
	    	}
	    	if(dataEditSubmission.getData("Sub_Limit").contains(";"))
	    	{
	    		arrLimit=dataEditSubmission.getData("Sub_Limit").split(";");
	    	}
	    	if(dataEditSubmission.getData("Sub_Retention").contains(";"))
	    	{
	    		arrRetention=dataEditSubmission.getData("Sub_Retention").split(";");
	    	}
	    	if(dataEditSubmission.getData("Sub_Premium").contains(";"))
	    	{
	    		arrpremium=dataEditSubmission.getData("Sub_Premium").split(";");
	    	}
	    	if(dataEditSubmission.getData("SubmittedProfile").contains(";"))
	    	{

	    		for(int i=0;i<arrSelect.length;i++)
	    		{
	    			_click(getClonedElement(chk_SubmittedProfile).addToken("tkn_SubmittedProfile",arrSelect[i].trim()));
	    			Thread.sleep(5000);
	    			if(dataEditSubmission.getData("Sub_Limit").contains(";"))
	    	    	{
	    				_setValue(getClonedElement(txt_Sublimit).addToken("tkn_SubmittedProfile",arrSelect[i].trim()),arrLimit[i]);
	    	    	}
	    			else
	    			{
	    				
	    				_setValue(getElement(txt_Sublimit),dataEditSubmission.getData("Sub_Limit"));
	    			}
	    			if(dataEditSubmission.getData("Sub_Retention").contains(";"))
	    	    	{
	    				_setValue(getClonedElement(txt_SubRetention).addToken("tkn_SubmittedProfile",arrSelect[i].trim()),arrRetention[i]);
	    				
	    	    	}
	    			else
	    			{
	    				
	    				_setValue(getElement(txt_SubRetention),dataEditSubmission.getData("Sub_Retention"));
	    			}
	    			
	    			if(dataEditSubmission.getData("Sub_Premium").contains(";"))
	    	    	{
	    				_setValue(getClonedElement(txt_SubPremium).addToken("tkn_SubmittedProfile",arrSelect[i].trim()),arrpremium[i]);
	    				
	    	    	}
	    			else
	    			{
	    				
	    				_setValue(getElement(txt_SubPremium),dataEditSubmission.getData("Sub_Premium"));
	    			}
	    			
	    			
	    			
	    		}
	    	}
	    	else
	    	{
	    		_click(getClonedElement(chk_SubmittedProfile).addToken("tkn_SubmittedProfile",dataEditSubmission.getData("SubmittedProfile")));
	    		func._waitForPageToLoad(getWebDriver(),50L);
	    		_setValue(getElement(txt_Sublimit),dataEditSubmission.getData("Sub_Limit"));
	    		_setValue(getElement(txt_SubRetention),dataEditSubmission.getData("Sub_Retention"));
	    		_setValue(getElement(txt_SubPremium),dataEditSubmission.getData("Sub_Premium"));
	    	
	    	}
	    	func._checkAttributeValue(getElement(lbl_SublinesStatus), "TEXT", dataEditSubmission.getData("SubmittedProfile").trim().replace(";", "|"), softAssert);
	    }
		
	    
	    
	  if(BSValue.contains("Financial Institutions")||BSValue.equalsIgnoreCase("Professional Liability")||BSValue.contains("Executive Solutions")||BSValue.equalsIgnoreCase("Cyber Liability Group")
			  ||BSValue.contains("Alternative Solutions")||BSValue.contains("Private Company Group"))
	  {
	    if(!dataEditSubmission.getData("PrimaryORExcess").equals(""))
	    {
	    	 if(dataEditSubmission.getData("PrimaryORExcess").trim().toLowerCase().contains("primary"))
	    	 {
	    		 _click(getElement(radio_Primary)); 
	    		 func._waitForPageToLoad(getWebDriver(),50L);
	    	 }
	    	 if(dataEditSubmission.getData("PrimaryORExcess").trim().toLowerCase().contains("excess"))
	    	 {
	    		 _click(getElement(radio_Excess)); 
	    		 func._waitForPageToLoad(getWebDriver(),50L);
	    	 }
	    }
		/*if(!dataEditSubmission.getData("SubPublicPrivate").equals(""))
		 {
	    	 if(dataEditSubmission.getData("SubPublicPrivate").trim().toLowerCase().contains("public"))
	    	 {
	    		 WebElement el=(WebElement) getElement(chk_Public).getNative();
	    		Actions actions = new Actions(getWebDriver());
	    		 actions.moveToElement(el).perform();
	    		actions.moveToElement(el).click();
	    		// ((JavascriptExecutor)getWebDriver()).executeScript("arguments[0].scrollIntoView();", el);
	      		 //_click(getElement(chk_Public));
	    		 func._waitForPageToLoad(getWebDriver(),50L);
	    	 }
	    	 if(dataEditSubmission.getData("SubPublicPrivate").trim().toLowerCase().contains("Private"))
	    	 {
	    		 _click(getElement(chk_Pravite));
	    		 func._waitForPageToLoad(getWebDriver(),50L);
	    	 }
		 }*/

		if(!dataEditSubmission.getData("SubmittedProduct").equals(""))
		{
		_setValue(getElement(lst_SubmittedProduct),dataEditSubmission.getData("SubmittedProduct"));
		func._waitForPageToLoad(getWebDriver(),50L);
		}
    	Thread.sleep(2000);
    	if(!dataEditSubmission.getData("Limit").equals(""))
		{
    		_setValue(getElement(txt_Limit),dataEditSubmission.getData("Limit"));
    		func._waitForPageToLoad(getWebDriver(),50L);
		}
    	if(!dataEditSubmission.getData("RetentionAttachment").equals(""))
		{
    		 _setValue(getElement(txt_RetentionAttachment),dataEditSubmission.getData("RetentionAttachment"));
    		 func._waitForPageToLoad(getWebDriver(),50L);
		}
	    
	  }
	  
	  if((dataEditSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataEditSubmission.getData("BusinessSegment").equals("Alternative Solutions")||dataEditSubmission.getData("BusinessSegment").equals("Private Company Group") 
			  ||dataEditSubmission.getData("BusinessSegment").equals("Professional Liability")||dataEditSubmission.getData("BusinessSegment").equalsIgnoreCase("Executive Solutions")||dataEditSubmission.getData("BusinessSegment").equalsIgnoreCase("Cyber Liability Group")) 
			  &&(dataEditSubmission.getData("SubmissionLOB").equals("Private Co Exp")||dataEditSubmission.getData("SubmissionLOB").equals("Cyber Elevation")))
		    
	    {
			_click(getElement(tab_QuotedProfileHeader));
			func._waitForPageToLoad(getWebDriver(),50L);
			Thread.sleep(2000);
			String[] arrSelect=null;
			String[] arrverifySubProfile=null;
		
			/*if(dataNewSubmission.getData("Verify Sub Profile").contains(";"))
			{
				arrverifySubProfile=dataNewSubmission.getData("Verify Sub Profile").split(";");
				
				for(int i=0;i<arrverifySubProfile.length;i++)
				{
					if(func._isVisible(getClonedElement(chk_QuotedProfile).addToken("tkn_QuoteProfile",arrverifySubProfile[i].trim())))
					{
						CustomReporting.logReport("","","'"+ arrverifySubProfile[i] +"' check exist in the Submissionh profile  for the LOB 'Priv Co Expedition'" + "" + 
								"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
						
					}
					
					else
					{
						CustomReporting.logReport("","","'"+ arrverifySubProfile[i] + "check does not exist in the Submissionh profile  for the LOB 'Priv Co Expedition'" + 
								"" + 
								"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
						
					}
				}				
			
			}
			*/

			if(dataEditSubmission.getData("QuoteSubmittedProfile").contains(";"))
			{
				arrSelect=dataEditSubmission.getData("QuoteSubmittedProfile").split(";");
				for(int i=0;i<arrSelect.length;i++)
				{
					_click(getClonedElement(chk_QuotedProfile).addToken("tkn_QuoteProfile",arrSelect[i].trim()));
					func._waitForPageToLoad(getWebDriver(), 150L);
					Thread.sleep(2000);
					

				}
			
			}
			

			else
			{
				_click(getClonedElement(chk_QuotedProfile).addToken("tkn_QuoteProfile",dataEditSubmission.getData("QuoteSubmittedProfile")));
				Thread.sleep(2000);

			}
			_click(getElement(tab_QuotedProfileHeader));
			func._waitForPageToLoad(getWebDriver(),50L);
			Thread.sleep(2000);
		}
	  
	    if(!dataEditSubmission.getData("SubDescription").equals(""))
		{
	    _setValue(getElement(txt_SubDescription),dataEditSubmission.getData("SubDescription"));
	    func._waitForPageToLoad(getWebDriver(),50L);
		}
	    if(!dataEditSubmission.getData("Comment").equals(""))
	    {
	    	_setValue(getElement(txt_Comment),dataEditSubmission.getData("Comment"));
	    }
	    
	    if(SSValue.equals("Quote Lost")||SSValue.equals("Indication Lost")||SSValue.equals("Quote Outstanding") 
	    		||SSValue.equals("Indication Outstanding")||SSValue.equals("Policy Bound"))
	    {
	    	if(!dataEditSubmission.getData("DateQuoted").equals(""))
	    	{
	    		_setValue(getElement(dat_DateQuoted),dataEditSubmission.getData("DateQuoted"));
	    		  WebElement elm = (WebElement) getElement(dat_DateQuoted).getNative();
		           elm.sendKeys(Keys.TAB);
	    		func._waitForPageToLoad(getWebDriver(),50L);
	    	}
	    	else
	    	{
	    		_setValue(getElement(dat_DateQuoted),func.Date_Manipulation("", "Now", 0));
	    		WebElement elm = (WebElement) getElement(dat_DateQuoted).getNative();
		           elm.sendKeys(Keys.TAB);
	    		func._waitForPageToLoad(getWebDriver(),50L);
	    		
	    	}
	    	if(!dataEditSubmission.getData("QuotedPremium").equals(""))
	    	{
	    		_setValue(getElement(txt_QuotedPremium),dataEditSubmission.getData("QuotedPremium"));
	    		func._waitForPageToLoad(getWebDriver(),50L);
	    	}
	 	 
	    }
	    if((BSValue.equals("Financial Institutions")||BSValue.equalsIgnoreCase("Professional Liability"))||BSValue.equalsIgnoreCase("Executive Solutions")||BSValue.equalsIgnoreCase("Alternative Solutions")||BSValue.equalsIgnoreCase("Private Company Group")||BSValue.equalsIgnoreCase("Cyber Liability Group")&&(SSValue.equals("Quote Lost")||SSValue.equals("Indication Lost")||SSValue.equals("Quote Outstanding") 
	    		||SSValue.equals("Indication Outstanding")||SSValue.equals("Policy Bound")))
	    {
	    	if(dataEditSubmission.getData("QuotedPrimary").trim().toLowerCase().equals("primary"))
	    	{
	    	  _click(getElement(radio_QuotedPrimary));
	    	  func._waitForPageToLoad(getWebDriver(),50L);
	    	}
		    if(dataEditSubmission.getData("QuotedPrimary").trim().toLowerCase().equals("excess"))
		    {
		    	  
		    	  _click(getElement(radio_QuotedExcess));
		    	  func._waitForPageToLoad(getWebDriver(),50L);
		    }

	    }

	    
	    if((SSValue.equals("Policy Bound")||SSValue.equals("Indication Lost"))||SSValue.equals("Quote Lost")||SSValue.equals("Declined"))
	    {
	    	if(!dataEditSubmission.getData("QuotedLineOfBusiness").equals(""))
	   	 	{
		    	_setValue(getElement(lst_QuotedLineBusiness),dataEditSubmission.getData("QuotedLineOfBusiness"));
		    	func._waitForPageToLoad(getWebDriver(),50L);
	   	 	}
	    	/*if(!dataEditSubmission.getData("NaicsCode").equals(""))
	   	 	{
		    	_setValue(getElement(txt_NaicsCode),dataEditSubmission.getData("NaicsCode"));
		    	func._waitForPageToLoad(getWebDriver(),50L);
	   	 	}*/
	    	if(!dataEditSubmission.getData("QuotedSubmittedLineOfBusiness").equals(""))
	   	 	{
		    	_setValue(getElement(lst_QuotedSubmittedProduct),dataEditSubmission.getData("QuotedSubmittedLineOfBusiness"));
		    	func._waitForPageToLoad(getWebDriver(),50L);
	   	 	}
	    	
	    	
	    }
	    
	    if(!dataEditSubmission.getData("NaicsCode").equals(""))
	    {
	    	Thread.sleep(4000);
	    	_setValue(getElement(txt_NaicsCode),dataEditSubmission.getData("NaicsCode"));
	    	Thread.sleep(4000);
   	  		func._waitForPageToLoad(getWebDriver(),50L);
   	  	    WebElement elmNaiceCode = (WebElement) getElement(txt_NaicsCode).getNative();
	   	  	 if(elmNaiceCode.getText().equals(""))
	   	  	 {
	   	  		 _setValue(getElement(txt_NaicsCode),dataEditSubmission.getData("NaicsCode"));
	   	  		 Thread.sleep(4000);
	   	  		 func._waitForPageToLoad(getWebDriver(),50L); 
	   	  	 }
	    }

	    if(BSValue.contentEquals("Wholesale Casualty"))
	    		
		{
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_CreditScore),dataEditSubmission.getData("CreditScore"));
	    	Thread.sleep(1000);
	    	if(SLOB.equals("Commercial Auto")||SLOB.equals("GL"))
	    	{
	    		_setValue(getElement(lst_IncumbentCarNonRenewal),dataEditSubmission.getData("IncumbentCarNonRenewal"));
	    		func._waitForPageToLoad(getWebDriver(),50L);
	    		Thread.sleep(2000);
	    	}
		}
	    
	    if(BSValue.equals("Environmental"))
    		
		{
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_CreditScore),dataEditSubmission.getData("CreditScore"));
	    	Thread.sleep(1000);
	    	
		}
	    if((dataEditSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataEditSubmission.getData("BusinessSegment").equals("Alternative Solutions")||dataEditSubmission.getData("BusinessSegment").equals("Private Company Group")||dataEditSubmission.getData("BusinessSegment").equals("Professional Liability")||dataEditSubmission.getData("BusinessSegment").equalsIgnoreCase("Executive Solutions"))&&(dataEditSubmission.getData("SubmissionLOB").equals("Private Co Exp")))
		    
	  		{
	  			if(func._isVisible(getElement(tab_QuotedProfileHeader)))
	  			{
	  				CustomReporting.logReport("","","Quoted Profile section is displayed for the LOB 'Priv Co Expedition'" + "" + 
	  					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

	  				_click(getElement(tab_QuotedProfileHeader));
	  				func._waitForPageToLoad(getWebDriver(),50L);
	  				Thread.sleep(2000);
	  				String[] arrSelect=null;
	  				String[] arrverifyQuoteProfile=null;
	  			
	  				if(dataEditSubmission.getData("Verify Quoted Profile").contains(";"))
	  				{
	  					arrverifyQuoteProfile=dataEditSubmission.getData("Verify Quoted Profile").split(";");
	  					
	  					for(int i=0;i<arrverifyQuoteProfile.length;i++)
	  					{
	  						if(func._isVisible(getClonedElement(chk_QuotedProfile).addToken("tkn_QuoteProfile",arrverifyQuoteProfile[i].trim())))
	  						{
	  							CustomReporting.logReport("","","'"+ arrverifyQuoteProfile[i] +"' check exist in the Quoted profile  for the LOB 'Priv Co Expedition'" + "" + 
	  									"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
	  							
	  						}
	  						
	  						else
	  						{
	  							CustomReporting.logReport("","","'"+ arrverifyQuoteProfile[i] + "Quoted Profile section is not displayed for the LOB 'Priv Co Expedition" + 
	  									"" + 
	  									"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	  							
	  						}
	  					}				
	  				
	  				}
	  				_click(getElement(tab_QuotedProfileHeader));
	  				func._waitForPageToLoad(getWebDriver(),50L);
	  				Thread.sleep(2000);
  				}
	  			else
	  			{
	  				CustomReporting.logReport("","", "Quoted Profile section is not dispalyed  for the LOB 'Priv Co Expedition'" + 
	  						"" + 
	  						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);	
	  				throw new RuntimeException();
	  			}

	  		   }
	   
	  		    	
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	//	String SSValue=func._getAttributeValue(getElement(lst_SubmissionStatus), "TEXT", softAssert);
	   
	    if((dataEditSubmission.getData("BusinessSegment").equals("Wholesale Property"))&&(dataEditSubmission.getData("QuotedLineOfBusiness").equals("Package")))
		    
  		{
  			if(func._isVisible(getElement(tab_QuotedProfileHeader)))
  			{		_click(getElement(tab_QuotedProfileHeader));
  					func._waitForPageToLoad(getWebDriver(),150L);
  					Thread.sleep(2000);
  					String[] arrSelect=null;
  					String[] arrverifyQuoteProfile=null;
  			
  				if(dataEditSubmission.getData("QuotedProfile").contains(";"))
  				{
  					arrverifyQuoteProfile=dataEditSubmission.getData("QuotedProfile").split(";");
  					
  					for(int i=0;i<arrverifyQuoteProfile.length;i++)
  					{
  						_click(getClonedElement(chk_QuotedProfile).addToken("tkn_QuoteProfile",arrverifyQuoteProfile[i].trim()));
  					}
  					_click(getElement(tab_QuotedProfileHeader));
  					func._waitForPageToLoad(getWebDriver(),50L);
  					Thread.sleep(2000);
  				}
	  			else
	  			{	_click(getClonedElement(chk_QuotedProfile).addToken("tkn_QuoteProfile",dataEditSubmission.getData("QuotedProfile")));
	  				
	  			}

  		    }
  		}
	    WebElement weQuotedLOB1=(WebElement)getElement(lst_QuotedLineBusinessSelected).getNative();
	    String QuoteLOB=weQuotedLOB1.getText().trim();
	   if(QuoteLOB.equals("Workers Comp") && dataEditSubmission.getData("SubmissionStatus").equals("Policy Bound"))
	    {
    		_setValue(getElement(txt_ScheduleRatingMod),dataEditSubmission.getData("ScheduleRatingMod"));
    		func._waitForPageToLoad(getWebDriver(),50L);
    		_setValue(getElement(txt_ExperienceMod),dataEditSubmission.getData("ExperienceMod"));
    		func._waitForPageToLoad(getWebDriver(),50L);
	    }
  		    	
	    if(CopyOREdit.trim().toLowerCase().equals("edit"))
	    {
	    	Thread.sleep(3000);
	    	_click(getElement(btn_Save));
	    	//func._waitForPageToLoad(getWebDriver(),500L);
	    	
	    	try
	    	{
	    	    if(dataEditSubmission.getData("SubmissionStatus").equals("Policy Bound"))
			    {
	    	    	Thread.sleep(10000);
	    		
	    			//Alert alrt=getWebDriver().switchTo().alert();
	    			//alrt.accept();
			    	func._alertHandler(getWebDriver(), "Ok");
			    	func._waitForPageToLoad(getWebDriver(),150L);
			    	Thread.sleep(5000);
				   
			    }
	    	}
	    	catch(Exception ex)
	    	{
	    		Thread.sleep(3000);
		    	_click(getElement(btn_Save));
		    	//func._waitForPageToLoad(getWebDriver(),500L);
		    	Thread.sleep(10000);
		    	 if(dataEditSubmission.getData("SubmissionStatus").equals("Policy Bound"))
				    {
			    		try
			    		{
			    			Alert alrt=getWebDriver().switchTo().alert();
			    			alrt.accept();
					    	//func._alertHandler(getWebDriver(), "Ok");
					    	func._waitForPageToLoad(getWebDriver(),150L);
					    	Thread.sleep(5000);
			    			
			    		}
			    			catch(Exception e)
			    		{
			    				func._alertHandler(getWebDriver(), "Ok");
						    	func._waitForPageToLoad(getWebDriver(),150L);
						    	Thread.sleep(5000);
			    				
			    		}
					   
				    }
	    		
	    	}
	    	
	    }
	    try
    	{
	    	Thread.sleep(4000);
	    	WebElement weMS=(WebElement)getElement(lst_SelectedMarketSegment).getNative();
	    	WebElement weQuotedLOB=(WebElement)getElement(lst_QuotedLineBusiness).getNative();

	    	if(weMS.getText().contains("make selection")||weQuotedLOB.getText().contains("make selection"))
	    	{
	    		if(!dataEditSubmission.getData("MarketSegment").equals(""))
	    		{
	    		_setValue(getElement(lst_marketSegment),dataEditSubmission.getData("MarketSegment"));
	    		func._waitForPageToLoad(getWebDriver(),50L);
	    		}
	    		if(!dataEditSubmission.getData("QuotedLineOfBusiness").equals(""))
		   	 	{
			    	_setValue(getElement(lst_QuotedLineBusiness),dataEditSubmission.getData("QuotedLineOfBusiness"));
			    	func._waitForPageToLoad(getWebDriver(),50L);
		   	 	}
	    		
	    		if(CopyOREdit.trim().toLowerCase().equals("edit"))
	    		{
			    	Thread.sleep(3000);
			    	_click(getElement(btn_Save));
			    	func._waitForPageToLoad(getWebDriver(),150L);
			    	Thread.sleep(30000);
			    		
			    	if(dataEditSubmission.getData("SubmissionStatus").equals("Policy Bound"))
					    {
				    		
			    			Alert alrt=getWebDriver().switchTo().alert();
			    			alrt.accept();
					    	//func._alertHandler(getWebDriver(), "Ok");
					    	func._waitForPageToLoad(getWebDriver(),50L);
					    	Thread.sleep(5000);
						   
					    }
			     	
			    	
			   }
		    
			}
    	}
	    catch(Exception ex)
    	{
    		
    	}
	    int loopcount=0;
	    do
	    {
	    	if(func._isVisible(getElement(msg_SubmissionSuccessmsg)))
	    	{
	    		break;
	    	}
	    	Thread.sleep(5000);
	    	loopcount=loopcount+1;
	    }while(loopcount<20);
	  
  		

	}
	
	@Override
	public void clkCopySubmission (String tcID, SoftAssert softAssert) throws Exception
	{
		 Thread.sleep(3000);
		_click(getElement(tab_TabSubmission));
		func._waitForPageToLoad(getWebDriver(),100L);
		func._waitFor(getElement(btn_CopySubmission), 100, WAIT_FOR.CLICKABLE, "");
		 Thread.sleep(4000);
	   
		try
		{
			if(func._isVisible(getElement(btn_CopySubmission)))
			{
				CustomReporting.logReport("","", "Copy Submission button is displayed in the New Submission page",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				 _click(getElement(btn_CopySubmission));
				 func._waitForPageToLoad(getWebDriver(),100L);
				 Thread.sleep(5000);
				func._waitFor(getElement(btn_CreateThisSubmission), 100, WAIT_FOR.CLICKABLE, "");
				
				 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				 if(func._checkAttributeValue(getElement(tab_CopySubmission),"TEXT","Submission: New Submission",softAssert))
				   {
					CustomReporting.logReport("","","Submission is copied sucessfully" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				   }
				 	else
					{
						CustomReporting.logReport("", "", "Submission is not copied sucessfully.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
						throw new RuntimeException();
					}
			}
		}
		catch(Exception e)
		{
		
			CustomReporting.logReport("","", "Copy Submission button is not displayed" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();	
		
		
		}
		
	}
	@Override
	public void clkSave (String tcID, SoftAssert softAssert) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),150L);
		Thread.sleep(2000);
		String SSValue=func._getAttributeValue(getElement(lst_SubmissionStatus), "TEXT", softAssert);
		Thread.sleep(5000);
		 _click(getElement(btn_Save));
		 func._waitForPageToLoad(getWebDriver(),500L);
		 Thread.sleep(20000);
		 
		 
		    
		 PageData dataNewSubmission =null;
		 PageData dataEditSubmission=null;
		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
 			dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
 			dataEditSubmission=PageDataManager.instance().getPageData("QAEditSubmission",tcID);
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
			 dataEditSubmission=PageDataManager.instance().getPageData("EditSubmission",tcID);
		 }
		 
		 try
		 {
			 WebElement weMS=(WebElement)getElement(lst_SelectedMarketSegment).getNative();
		    
			 if(weMS.getText().contains("make selection"))
			 {
			   _setValue(getElement(lst_marketSegment),dataEditSubmission.getData("MarketSegment"));
			    func._waitForPageToLoad(getWebDriver(),50L);
		    	Thread.sleep(3000);
		    	_click(getElement(btn_Save));
		    	func._waitForPageToLoad(getWebDriver(),150L);
		    	Thread.sleep(20000);
			 }
		 }
		 catch(Exception e)
		 {
			 
		 }
		    
		

		 if(!dataNewSubmission.getData("SubmissionStatus").equals("Policy Bound")&&SSValue.equals("Policy Bound"))
		    {
		     //alert.accept();
		    	func._alertHandler(getWebDriver(), "Ok");
		    	func._waitForPageToLoad(getWebDriver(),150L);
		    	Thread.sleep(2000);
			   
		    }
		 
		 int loopcount=0;
		    do
		    {
		    	if(func._isVisible(getElement(msg_SubmissionSuccessmsg)))
		    	{
		    		break;
		    	}
		    	Thread.sleep(5000);
		    	loopcount=loopcount+1;
		    
		    }while(loopcount<20);
		    
	}
	
	
	
	@Override
	public void clkCreateThisSubmission (String tcID, SoftAssert softAssert) throws Exception
	{
	 _click(getElement(btn_CreateThisSubmission));
	 func._alertHandler(getWebDriver(), "Ok");
	 func._waitForPageToLoad(getWebDriver(),100L);
	 //func._waitFor(getElement(msg_SubmissionSuccessmsg), 100, WAIT_FOR.VISIBLE, "");
	 Thread.sleep(5000);
	    func._checkDefaultValue(getElement(msg_SubmissionSuccessmsg),"TEXT","Account & Submission information updated successfully");  
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    func._waitForPageToLoad(getWebDriver(),50L);
	   WebElement el=(WebElement) getElement(tab_TabSubmission).getNative();
	   String getSubmissionNum=el.getText().split(":")[1];
       int intsubnum=Integer.valueOf(getSubmissionNum.trim().replace("-", ""));
		if(intsubnum>0)
		{
			CustomReporting.logReport("","", "Submission number is successfully generated after copy submission and click Create this Submission button ",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}
		else
		{
			CustomReporting.logReport("","", "Submission number is not generated after copy submission and click Create this Submission button " + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();
		}
	   

		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);

		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			 func._writeToExcel("QASearch", "SubmissionNumber",getSubmissionNum, tcID);
		 }
		else
		{
			 func._writeToExcel("Search", "SubmissionNumber",getSubmissionNum, tcID);
		}

	   

	}
	
	@Override
	public void Verify_MarketSegment_FieldValuee (String tcID, SoftAssert softAssert,String type) throws Exception
	{
		 PageData dataEditSubmission =null;
		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			 dataEditSubmission = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
		 }
		 else
		 {
			 dataEditSubmission = PageDataManager.instance().getPageData("EditSubmission",tcID);
		 }
		
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		 func._waitForPageToLoad(getWebDriver(),50L);
		 String strmrktSegmentVALUE="";
		String strActValue=func._getAttributeValue(getElement(lst_marketSegment), "TEXT", softAssert);
		if(type.trim().toLowerCase().equals("renewal"))
		{
			if(dataLogin.getData("Environment").toUpperCase().equals("SIT"))
			 {
	    		strmrktSegmentVALUE=dataEditSubmission.getData("MarketSegment_SIT");

			 }
	    	else
	    	{
	    		strmrktSegmentVALUE=dataEditSubmission.getData("MarketSegment");
	    		
	    	}
		 
			 if (!strActValue.contains(strmrktSegmentVALUE))
				{
					
					CustomReporting.logReport("","", "Market Segment field is not edited with the new value ' "+dataEditSubmission.getData("MarketSegment")+"' in renewal submission screen "+strActValue, "", StepStatus.FAILURE,
							new String[] { }, System.currentTimeMillis(), null);
					throw new RuntimeException();
				}
				else
				{
					CustomReporting.logReport("","", "Market Segment field is edited with the new value '"+dataEditSubmission.getData("MarketSegment")+"' in renewal submission screen successfully "+strActValue,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				}
		}
		if(type.trim().toLowerCase().equals("new"))
		{
			String strMrkSegment="";
			if(dataLogin.getData("Environment").toUpperCase().equals("SIT"))
			 {
	    		 strMrkSegment=dataEditSubmission.getData("MarketSegment_SIT");

			 }
	    	else
	    	{
	    		strMrkSegment=dataEditSubmission.getData("MarketSegment");
	    			
	    	}
			
		 
			 if (!strActValue.contains(strMrkSegment))
				{
					
					CustomReporting.logReport("","", "Market Segment field is not edited with the new value ' "+dataEditSubmission.getData("MarketSegment")+"' in submission screen "+strActValue, "", StepStatus.FAILURE,
							new String[] { }, System.currentTimeMillis(), null);
					throw new RuntimeException();
				}
				else
				{
					CustomReporting.logReport("","", "Market Segment field is edited with the new value '"+dataEditSubmission.getData("MarketSegment")+"' in submission screen successfully "+strActValue,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				}
		}
	
	}
	
	@Override
	public void Check_DescLength_TransTree (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataEditSubmission =null;
		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			 dataEditSubmission = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
		 }
		 else
		 {
			 dataEditSubmission = PageDataManager.instance().getPageData("EditSubmission",tcID);
		 }
		
		 
		func._waitFor(getElement(getSubmissionNumber), 200, WAIT_FOR.CLICKABLE);
		Thread.sleep(4000);
		String strsubstring=dataEditSubmission.getData("SubDescription").substring(0, 10);
		WebElement weSubDes=(WebElement)getElement(getSubmissionNumber).getNative();
		/*String locator=getElement(getSubmissionNumber).toString();
		//String locator=func.getCustomElementName(getElement(getSubmissionNumber));
		String strXpath=locator.split("\\{")[1];
		String Xpath=strXpath.replace("}", "");
		
		WebElement ele=getWebDriver().findElement(By.xpath(Xpath));*/
		String Desc=weSubDes.getText().split("\n")[1].trim().replace(".", "");
		if((Desc.length()<=10)&&(Desc.equals(strsubstring)))
		{
			CustomReporting.logReport("","", "Only 10 characters of submission description is displayed on transaction tree",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			
		}
		else
		{
			CustomReporting.logReport("","", "More then 10 characters of submission description is displayed on transaction tree" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();	
		}
	}
	
	@Override
	public void Check_BusinessIndicator_Status_RenewalSubmission (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataNewSubmission =null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
		 }
		
		
		
		/*if(dataNewSubmission.getData("SubPublicPrivate").trim().toLowerCase().equals("public"))
		{
				
			if(func._isChecked(getElement(chk_Public)))
			{
				CustomReporting.logReport("","", "Public Business Indicator value is carry forwarded from the submission" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				throw new RuntimeException();		
			}
			
			else
			{
				CustomReporting.logReport("","", "Public Business Indicator value is not carry forwarded from the submission",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			}
		}
			
		
		if(dataNewSubmission.getData("SubPublicPrivate").trim().toLowerCase().equals("private"))
		{
			
			if(func._isChecked(getElement(chk_Pravite)))
			{
				CustomReporting.logReport("","", "Private Business Indicator value is carry forwarded from the submission" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				throw new RuntimeException();		
			}
			
			else
			{
				CustomReporting.logReport("","", "Private Business Indicator value is not carry forwarded from the submission",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			}
			
		}
		
		if((func._checkAttributeValue(getElement(lbl_chkPublic), "TEXT", "Public", softAssert)))
		{
			CustomReporting.logReport("","", "The value available for the selection of Public Business Indicator is 'Public' ",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			
		}
		else
		{
			CustomReporting.logReport("","", "The value available for the selection of Public Business Indicator is not 'Public'" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
		
		if((func._checkAttributeValue(getElement(lbl_chkprivate), "TEXT", "Private", softAssert)))
		{
			CustomReporting.logReport("","", "The value available for the selection of Private Business Indicator is 'Private' ",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			
		}
		else
		{
			CustomReporting.logReport("","", "The value available for the selection of Private Business Indicator is not 'Private'" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
		
		//String chkPubliclocator=func.getCustomElementName(getElement(chk_Public));
		String chkPubliclocator=getElement(chk_Public).toString();
		String Publicxpath=chkPubliclocator.split("\\{")[1];
		String chk_Publicxpath=Publicxpath.replace("}", "");
		
		if(getWebDriver().findElement(By.xpath(chk_Publicxpath)).isEnabled())
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
		String chk_Pravitelocator=getElement(chk_Pravite).toString();
		//String chk_Pravitelocator=func.getCustomElementName(getElement(chk_Pravite));
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

			
		if(!func._isVisible(getElement(isMandatroychkPublic)))
		{
			CustomReporting.logReport("","", "Public business indicator check box is displayed as non madatory field on submission screen" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				
		}
		
		else
		{
			CustomReporting.logReport("","", "Public business indicator check box is not displayed as non madatory field on submission screen" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		
			
		}
		if(!func._isVisible(getElement(isMandatroychkPrivate)))
		{
			CustomReporting.logReport("","", "Private business indicator check box is displayed as non madatory field on submission screen" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				
		}
		
		else
		{
			CustomReporting.logReport("","", "Private business indicator check box is not displayed as non madatory field on submission screen" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
			
		}
		*/
		
		
	}
	
	public void Verify_CopySub_fieldvalues (String tcID, SoftAssert softAssert,String type) throws Exception
	{
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		//func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
		PageData dataEditSubmission=null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(type.equals("edit"))
		{
			if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
		
				dataEditSubmission = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
			 }
			 else
			 {
				 dataEditSubmission = PageDataManager.instance().getPageData("EditSubmission",tcID);
			 }
			
			
		}
		if(type.equals("new"))
		{
			
			if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
		
				dataEditSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
			 }
			 else
			 {
				 dataEditSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
			 }
			
			
		}
/*		if(type.equals("copy"))
		{
			dataEditSubmission = PageDataManager.instance().getPageData("CopySubmission",tcID);
			
			
		}*/
		
		WebElement we=(WebElement) getElement(tab_CopySubmission).getNative();
		
		if(we.getText().split(":")[1].trim().equals("New Submission"))
		{
			CustomReporting.logReport("","","Copied submission successfully" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		}
		else
		{
			CustomReporting.logReport("", "", "Copy submission failed","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			throw new RuntimeException();
		}
		

		func._checkAttributeValue(getElement(lst_BusinessSegment), "TEXT", dataEditSubmission.getData("BusinessSegment"), softAssert);
		func._checkAttributeValue(getElement(lst_BranchOffice), "TEXT", dataEditSubmission.getData("BusinessOffice"), softAssert);
		func._checkAttributeValue(getElement(lst_PredominantState), "TEXT", dataEditSubmission.getData("PredominantState"), softAssert);
		func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT","Working", softAssert);
		if(type.equals("new"))
		{
			if(!dataEditSubmission.getData("SubmissionEffectiveDate").equals(""))
			{
			func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value", dataEditSubmission.getData("SubmissionEffectiveDate"), softAssert);
			}
			else
			{
				
				func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value", func.Date_Manipulation("", "now", 0), softAssert);
			}
			if(!dataEditSubmission.getData("SubmissionExpaireDate").equals(""))
			{
				int offset= Integer.valueOf(dataEditSubmission.getData("SubmissionExpaireDate").split("-")[0].trim());
		    	String OptValue=dataEditSubmission.getData("SubmissionExpaireDate").split("-")[1].trim();
		    	
		    	func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value", func.Date_Manipulation("",OptValue, offset), softAssert);
			}
			else
			{

				String strSubEffDate= getElement(dat_SubmissionEffectiveDate).getAttribute("value");
				/*SimpleDateFormat  datSubEffDate=new SimpleDateFormat("MM/dd/yyyy");
		
				Calendar cal = Calendar.getInstance();
				cal.setTime(datSubEffDate.parse(strSubEffDate));
				cal.add(Calendar.YEAR,1);
				String dt1 = datSubEffDate.format(cal.getTime());*/
				func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value", func.Date_Manipulation(strSubEffDate, "Year", 1), softAssert);
				
			}
		}
		if(!dataEditSubmission.getData("PrimaryORExcess").equals(""))
		{
			if(dataEditSubmission.getData("PrimaryORExcess").trim().toLowerCase().equals("primary"))
			{
				//func._checkAttributeValue(getElement(radio_Primary), "checked", "true", softAssert);
				
				if(func._isChecked(getElement(radio_Primary)))
				{
					CustomReporting.logReport("","","Primary radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "Primary radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				
			}
			if(dataEditSubmission.getData("PrimaryORExcess").trim().toLowerCase().equals("excess"))
			{
				
				if(func._isChecked(getElement(radio_Excess)))
				{
					CustomReporting.logReport("","","Excess radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "Excess radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				
			}
		}
			
		func._checkAttributeValue(getElement(lst_SubmissionType), "TEXT", dataEditSubmission.getData("SubmissionType"), softAssert);
		func._checkAttributeValue(getElement(lst_marketSegment), "TEXT", dataEditSubmission.getData("MarketSegment"), softAssert);
		//func._checkAttributeValue(getElement(lst_Distribution), "TEXT", dataEditSubmission.getData("Distribution"), softAssert);
		func._checkAttributeValue(getElement(lst_IncumbentCarrier), "TEXT", dataEditSubmission.getData("IncumbentCarrier"), softAssert);
		func._checkAttributeValue(getElement(lst_SubmissionLOB), "TEXT", "make selection", softAssert);
		func._checkAttributeValue(getElement(lst_Producername), "TEXT", dataEditSubmission.getData("Producername"), softAssert);
		func._checkAttributeValue(getElement(lst_ProducerOffice), "TEXT", dataEditSubmission.getData("ProducerOffice"), softAssert);
		func._checkAttributeValue(getElement(lst_UWName), "TEXT", dataEditSubmission.getData("UWName"), softAssert);
		func._checkAttributeValue(getElement(txt_EstimatedPremium), "value", "", softAssert);
		func._checkAttributeValue(getElement(lst_EverestCompany), "TEXT", dataEditSubmission.getData("EverestCompany"), softAssert);
		func._checkAttributeValue(getElement(txt_Comment), "TEXT", "", softAssert);
		
		if(!func._isEnabled(getElement(dat_DateQuoted)))
		{
			CustomReporting.logReport("","","DateQuoted field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "DateQuoted field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!func._isEnabled(getElement(txt_QuotedPremium)))
		{
			CustomReporting.logReport("","","QuotedPremium field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "QuotedPremium field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(lst_QuotedLineBusiness)))
		{
			CustomReporting.logReport("","","QuotedLineBusiness field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "QuotedLineBusiness field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		Thread.sleep(2000);
		if(!dataEditSubmission.getData("NaicsCode").equals(""))
		{
		func._checkAttributeValue(getElement(txt_NaicsCode), "value", dataEditSubmission.getData("NaicsCode"), softAssert);
		}
		
		
	}
	public void Verify_CopySubbtn_exist_NS (String tcID, SoftAssert softAssert) throws Exception
	{
		try
		{
			if(func._isVisible(getElement(btn_CopySubmission)))
			{
				CustomReporting.logReport("","", "Copy Submission button is displayed in the New Submission page " + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				throw new RuntimeException();	
			}
		}
		catch(Exception e)
		{
			CustomReporting.logReport("","", "Copy Submission button is not displayed in the New Submission page",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}
	}
	
	public void Verify_RenewalSub_fieldvalues (String tcID, SoftAssert softAssert,String type) throws Exception
	{
		
		PageData dataEditSubmission=null;
		PageData EditSubmission=null;
		
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			dataEditSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
			EditSubmission = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
		 }
		 else
		 {
			 dataEditSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID); 
			 EditSubmission = PageDataManager.instance().getPageData("EditSubmission",tcID);
		 }
		
		PageData dataPolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		_click(getElement(tab_TabSubmission));
		func._waitFor(getElement(btn_CopySubmission), 500, WAIT_FOR.CLICKABLE, "");
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		
		int SubmissionMod=Integer.valueOf(dataEditSubmission.getData("SubmissionNumber").split("-")[1].trim())+1;
		String ExpSubNum=dataEditSubmission.getData("SubmissionNumber").split("-")[0]+"-"+SubmissionMod;
		//String ExpSubNum=dataEditSubmission.getData("SubmissionNumber").trim();
		WebElement ActSubNowe=(WebElement)getElement(tab_TabSubmission).getNative();
		String ActualSubNum=ActSubNowe.getText().split(":")[1].trim();
		
		if(ActualSubNum.equals(ExpSubNum))
		{
			CustomReporting.logReport("","","Renewal submission page is displayed" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Renewal submission page is not displayed.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			throw new RuntimeException();	
		}
		func._checkAttributeValue(getElement(lst_BusinessSegment), "TEXT", dataEditSubmission.getData("BusinessSegment"), softAssert);
		func._checkAttributeValue(getElement(lst_BranchOffice), "TEXT", dataEditSubmission.getData("BusinessOffice"), softAssert);
		func._checkAttributeValue(getElement(lst_PredominantState), "TEXT", dataEditSubmission.getData("PredominantState"), softAssert);
		func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT","Received", softAssert);
		String SubmissionEffDate;
		if(type.trim().toUpperCase().equals("PFNY"))
		{
			if(!dataEditSubmission.getData("SubmissionEffectiveDate").contentEquals(""))
			{
				SubmissionEffDate= func.Date_Manipulation(dataEditSubmission.getData("SubmissionEffectiveDate"), "YEAR", 1);
			}
			else
			{
				SubmissionEffDate= func.Date_Manipulation("" ,"YEAR", 1);
			}
			func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value",SubmissionEffDate, softAssert);
			
			String SubmissionExpDate;
			if(!dataEditSubmission.getData("SubmissionExpaireDate").equals(""))
			{
				int offset= Integer.valueOf(dataEditSubmission.getData("SubmissionExpaireDate").split("-")[0].trim());
		    	String OptValue=dataEditSubmission.getData("SubmissionExpaireDate").split("-")[1].trim();
	
				func._checkAttributeValue(getElement(dat_SubmissionExpaireDate),"value",func.Date_Manipulation(func.Date_Manipulation("",OptValue, offset),"Year",1), softAssert);
				
			}
			else
			{
				SubmissionExpDate= func.Date_Manipulation("", "YEAR", 1);
				func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value",SubmissionExpDate, softAssert);
	
			}
		}
		if(type.trim().toUpperCase().equals("PNYR"))
		{
			if(!dataPolicy.getData("PolicyExpirationDate").equals(""))
			{
				int offset= Integer.valueOf(dataPolicy.getData("PolicyExpirationDate").split("-")[0].trim());
		    	String OptValue=dataPolicy.getData("PolicyExpirationDate").split("-")[1].trim();
				SubmissionEffDate= func.Date_Manipulation("", OptValue, offset);
			}
			else
			{
				SubmissionEffDate= func.Date_Manipulation("", "Year", 1);
			}
		
			func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value",SubmissionEffDate, softAssert);
		
			String SubmissionExpDate;
			if(!dataPolicy.getData("PolicyExpirationDate").equals(""))
			{
				int offset= Integer.valueOf(dataPolicy.getData("PolicyExpirationDate").split("-")[0].trim());
		    	String OptValue=dataPolicy.getData("PolicyExpirationDate").split("-")[1].trim();
	
				func._checkAttributeValue(getElement(dat_SubmissionExpaireDate),"value",func.Date_Manipulation(func.Date_Manipulation("",OptValue, offset),"Year",1), softAssert);
				
			}
			else
			{
				SubmissionExpDate= func.Date_Manipulation("", "YEAR", 2);
				func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value",SubmissionExpDate, softAssert);
	
			}
		}
		if(type.trim().toUpperCase().equals("PFNY"))
		{
		
			if(!dataEditSubmission.getData("PrimaryORExcess").equals(""))
			{
				if(dataEditSubmission.getData("PrimaryORExcess").trim().toLowerCase().equals("primary"))
				{
					
					if(!func._isChecked(getElement(radio_Primary)))
					{
						CustomReporting.logReport("","","Primary radio buttion  is not selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Primary radio button is still selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
				if(dataEditSubmission.getData("PrimaryORExcess").trim().toLowerCase().equals("excess"))
				{
					
					if(func._isChecked(getElement(radio_Excess)))
					{
						CustomReporting.logReport("","","Excess radio buttion  is not selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Excess radio button is still selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
			}
		}
		else
		{
			if(!dataEditSubmission.getData("PrimaryORExcess").equals(""))
			{
				if(dataEditSubmission.getData("PrimaryORExcess").trim().toLowerCase().equals("primary"))
				{
					
					if(func._isChecked(getElement(radio_Primary)))
					{
						CustomReporting.logReport("","","Primary radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Primary radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
				if(dataEditSubmission.getData("PrimaryORExcess").trim().toLowerCase().equals("excess"))
				{
					
					if(func._isChecked(getElement(radio_Excess)))
					{
						CustomReporting.logReport("","","Excess radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Excess radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
			}
			
		}
		
		if(type.trim().toUpperCase().equals("PNYR"))
		{
		func._checkAttributeValue(getElement(lst_SubmissionType), "TEXT", "Renewal", softAssert);
		}
		if(type.trim().toUpperCase().equals("PFNY"))
		{
		func._checkAttributeValue(getElement(lst_SubmissionType), "TEXT", "New", softAssert);
		}
		func._checkAttributeValue(getElement(lst_marketSegment), "TEXT", dataEditSubmission.getData("MarketSegment"), softAssert);
		if(type.trim().toUpperCase().equals("PFNY"))
		{
		func._checkAttributeValue(getElement(dat_ReceivedDate), "value","", softAssert);
		func._checkAttributeValue(getElement(lst_IncumbentCarrier), "TEXT", dataEditSubmission.getData("IncumbentCarrier"), softAssert);
		}
		if(type.trim().toUpperCase().equals("PNYR"))
		{
		func._checkAttributeValue(getElement(dat_ReceivedDate), "value",func.Date_Manipulation("", "Now", 0), softAssert);
		func._checkAttributeValue(getElement(lst_IncumbentCarrier), "TEXT", "Everest", softAssert);
		}
		
		if(type.trim().toUpperCase().equals("PFNY"))
		{
			//func._checkAttributeValue(getElement(lst_Distribution), "TEXT", dataEditSubmission.getData("Distribution"), softAssert);
			func._checkAttributeValue(getElement(lst_SelectedSubmissionLOB), "TEXT",dataEditSubmission.getData("SubmissionLOB") , softAssert);
			func._checkAttributeValue(getElement(lst_SelectdProdName), "TEXT", "make selection", softAssert);
			func._checkAttributeValue(getElement(lst_SelectedProducerOffice), "TEXT", "make selection", softAssert);
			func._checkAttributeValue(getElement(lst_SelectedEverestCompany), "TEXT", "make selection", softAssert);
		}
		else
		{
			//func._checkAttributeValue(getElement(lst_Distribution), "TEXT", dataEditSubmission.getData("Distribution"), softAssert);
			func._checkAttributeValue(getElement(lst_SelectedSubmissionLOB), "TEXT",dataEditSubmission.getData("SubmissionLOB") , softAssert);
			func._checkAttributeValue(getElement(lst_SelectdProdName), "TEXT", dataEditSubmission.getData("Producername"), softAssert);
			func._checkAttributeValue(getElement(lst_SelectedProducerOffice), "TEXT", dataEditSubmission.getData("ProducerOffice"), softAssert);
			func._checkAttributeValue(getElement(lst_SelectedEverestCompany), "TEXT", dataEditSubmission.getData("EverestCompany"), softAssert);
		}
	
		
		
		if(!dataEditSubmission.getData("SubmittedProduct").equals(""))
		{
		func._checkAttributeValue(getElement(lst_SelectedSubmittedProduct), "TEXT", dataEditSubmission.getData("SubmittedProduct"), softAssert);
		}
		
		func._checkAttributeValue(getElement(lst_UWName), "TEXT", dataEditSubmission.getData("UWName"), softAssert);
		func._checkAttributeValue(getElement(txt_EstimatedPremium), "value", "", softAssert);
		
		func._checkAttributeValue(getElement(txt_Comment), "TEXT", "", softAssert);
		if(!func._isEnabled(getElement(dat_DateQuoted)))
		{
			CustomReporting.logReport("","","DateQuoted field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "DateQuoted field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!func._isEnabled(getElement(txt_QuotedPremium)))
		{
			CustomReporting.logReport("","","QuotedPremium field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "QuotedPremium field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(lst_QuotedLineBusiness)))
		{
			CustomReporting.logReport("","","QuotedLineBusiness field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "QuotedLineBusiness field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}

		func._checkAttributeValue(getElement(txt_NaicsCode), "value", dataEditSubmission.getData("NaicsCode"), softAssert);
		
		if(type.trim().toUpperCase().equals("PFNY"))
		{
			if(!EditSubmission.getData("SubmittedProduct").equals(""))
			{
				_setValue(getElement(lst_SubmittedProduct),EditSubmission.getData("SubmittedProduct"));
				func._waitForPageToLoad(getWebDriver(),50L);
			}
			
			 _setValue(getElement(dat_ReceivedDate),func.Date_Manipulation("", "Now", 0));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 if(!EditSubmission.getData("EstimatedPremium").equals(""))
			 {
				 _setValue(getElement(txt_EstimatedPremium),EditSubmission.getData("EstimatedPremium"));
				 func._waitForPageToLoad(getWebDriver(),50L);
			 }
			 if(!EditSubmission.getData("Producername").equals(""))
			 {
			  _setValue(getElement(lst_Producername),EditSubmission.getData("Producername"));
			    func._waitForPageToLoad(getWebDriver(),200L);
			    Thread.sleep(10000);
			    _setValue(getElement(lst_ProducerOffice),EditSubmission.getData("ProducerOffice"));
			    Thread.sleep(10000);
			 }
			 if(!EditSubmission.getData("EverestCompany").equals(""))
			 {
			   _setValue(getElement(lst_EverestCompany), EditSubmission.getData("EverestCompany"));
			    func._waitForPageToLoad(getWebDriver(),50L);
			    Thread.sleep(3000);
			 }
			    
			 if(!EditSubmission.getData("PolicyPrimaryORExcess").equals(""))
			    {
			    	 if(EditSubmission.getData("PolicyPrimaryORExcess").trim().toLowerCase().contains("primary"))
			    	 {
			    		 _click(getElement(radio_Primary)); 
			    		 func._waitForPageToLoad(getWebDriver(),50L);
			    	 }
			    	 if(EditSubmission.getData("PolicyPrimaryORExcess").trim().toLowerCase().contains("excess"))
			    	 {
			    		 _click(getElement(radio_Excess)); 
			    		 func._waitForPageToLoad(getWebDriver(),50L);
			    	 }
			    }
		}
		
		 func._waitForPageToLoad(getWebDriver(),200L);
		 Thread.sleep(3000);
	}
	
	@Override
	public void Verify_PANBValues (String tcID, SoftAssert softAssert) throws Exception
	{
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		//func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
		PageData dataNewBusiness = PageDataManager.instance().getPageData("NewBusiness",tcID);
		
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		{
			func._checkAttributeValue(getElement(lst_BusinessSegment), "TEXT", dataNewBusiness.getData("QABusinessSegment"), softAssert);
		}
		else
		{
			func._checkAttributeValue(getElement(lst_BusinessSegment), "TEXT", dataNewBusiness.getData("BusinessSegment"), softAssert);
		}
		
		if(!func._isEnabled(getElement(lst_BusinessSegment)))
		{
			CustomReporting.logReport("","","BusinessSegment  field is Disabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "BusinessSegment field is Enabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT", dataNewBusiness.getData("SubmissionStatus"), softAssert);
		if(!func._isEnabled(getElement(lst_SubmissionStatus)))
		{
			CustomReporting.logReport("","","SubmissionStatus  field is Disabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "SubmissionStatus field is Enabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(lst_BranchOffice), "TEXT", dataNewBusiness.getData("BranchOffice"), softAssert);
		if(!func._isEnabled(getElement(lst_BranchOffice)))
		{
			CustomReporting.logReport("","","BranchOffice  field is Disabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "BranchOffice field is Enabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_PredominantState), "TEXT", dataNewBusiness.getData("PredominantState"), softAssert);
		if(func._isEnabled(getElement(lst_PredominantState)))
		{
			CustomReporting.logReport("","","PredominantState  field is Enabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "PredominantState field is Disabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(lst_marketSegment), "TEXT", dataNewBusiness.getData("MarketSegment"), softAssert);
		if(func._isEnabled(getElement(lst_marketSegment)))
		{
			CustomReporting.logReport("","","marketSegment  field is Enabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "marketSegment field is Disabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
	
		

		func._checkAttributeValue(getElement(dat_ReceivedDate), "value", func.Date_Manipulation("", "Now", 0) , softAssert);
		
		if(!func._isEnabled(getElement(dat_ReceivedDate)))
		{
			CustomReporting.logReport("","","ReceivedDate  field is Disabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "ReceivedDate field is Enabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		//func._checkAttributeValue(getElement(lst_Distribution), "TEXT", dataNewBusiness.getData("Distribution"), softAssert);
		
		/*if(!func._isEnabled(getElement(lst_Distribution)))
		{
			CustomReporting.logReport("","","Distribution  field is Disabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Distribution field is Enabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}*/
		if(!dataNewBusiness.getData("Submission_EffDate").equals(""))
		{
			
			func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value", dataNewBusiness.getData("Submission_EffDate"), softAssert);
		}
		else
		{
			
			
			func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value",func.Date_Manipulation("", "Now", 0), softAssert);
		}
		if(func._isEnabled(getElement(dat_SubmissionEffectiveDate)))	
		{
			CustomReporting.logReport("","","SubmissionEffectiveDate  field is Enabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "SubmissionEffectiveDate field is Disabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		String SubExpaireDate=getElement(dat_SubmissionExpaireDate).getAttribute("value");
		if(!dataNewBusiness.getData("Submission_ExpDate").equals(""))
		{
			int offset= Integer.valueOf(dataNewBusiness.getData("Submission_ExpDate").split("-")[0].trim());
	    	String OptValue=dataNewBusiness.getData("Submission_ExpDate").split("-")[1].trim();
	    		    	
			func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value", func.Date_Manipulation("",OptValue, offset), softAssert);
		}
		else
		{
			if(!dataNewBusiness.getData("Submission_EffDate").equals(""))
			{
				String SubmissionExpDate= func.Date_Manipulation(dataNewBusiness.getData("Submission_EffDate"), "YEAR", 1);
				func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value", SubmissionExpDate, softAssert);
			}
			else
			{
								
				String SubmissionExpDate= func.Date_Manipulation("", "YEAR", 1);
				func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value", SubmissionExpDate, softAssert);
			}
		}
		
		if(func._isEnabled(getElement(dat_SubmissionExpaireDate)))	
		{
			CustomReporting.logReport("","","Submission ExpaireDate  field is Enabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Submission ExpaireDate field is Disabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataNewBusiness.getData("IncumbentCarrier").equals(""))
		{	
			func._checkAttributeValue(getElement(lst_IncumbentCarrier), "TEXT", dataNewBusiness.getData("IncumbentCarrier"), softAssert);
		}
		else
		{
			func._checkAttributeValue(getElement(lst_IncumbentCarrier), "TEXT", "make selection", softAssert);
		}
		if(func._isEnabled(getElement(lst_IncumbentCarrier)))
		{
			CustomReporting.logReport("","","IncumbentCarrier field is Enabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "IncumbentCarrier field is Disabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_SubmissionLOB), "TEXT", dataNewBusiness.getData("SubmittedLOB"), softAssert);
		
		if(!func._isEnabled(getElement(lst_SubmissionLOB)))
		{
			CustomReporting.logReport("","","SubmissionLOB field is Disabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "SubmissionLOB field is Enabled in submission screen.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
	
		if(!func._isEnabled(getElement(lst_Producername)))
		{
			CustomReporting.logReport("","","Producername field is Disabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Producername field is Enabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		
		if(func._isEnabled(getElement(lst_EverestCompany)))
		{
			CustomReporting.logReport("","","EverestCompany field is Enabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "EverestCompany field is Disabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!func._isEnabled(getElement(dat_DateQuoted)))
		{
			CustomReporting.logReport("","","DateQuoted field is Disabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "DateQuoted field is Enabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!func._isEnabled(getElement(txt_QuotedPremium)))
		{
			CustomReporting.logReport("","","QuotedPremium field is Disabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "QuotedPremium field is Enabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(lst_QuotedLineBusiness)))
		{
			CustomReporting.logReport("","","QuotedLineBusiness field is Disabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "QuotedLineBusiness field is Enabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(func._isEnabled(getElement(txt_NaicsCode)))
		{
			CustomReporting.logReport("","","NaicsCode field is Enabled v" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "NaicsCode field is Disabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(func._isEnabled(getElement(txt_PaSubmission)))
		{
			CustomReporting.logReport("","","Pa's Submission # field is Enabled in submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "PA'sSubmission # field is Disabled in submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		WebElement ele=(WebElement) getElement(get_SubmissionStatusValue).getNative();
		if(ele.getText().trim().toLowerCase().contains("blocked"))
		{
			

			_click(getElement("btn_Submission_Email"));
			Thread.sleep(5000);
			OutlookPage objReference = (OutlookPage) PageManager.instance().createPage( OutlookPage.class, getWebDriver());
	 		objReference.SendEmail(tcID, softAssert);
		}
		
	
		if(func.DateFormatReturns(SubExpaireDate, "Days")<=90)
		{
			NewBusiness NBimpl = (NewBusiness) PageManager.instance().createPage( NewBusiness.class, getWebDriver());
			_click(getElement(btn_ResubmitCurYear));
			Thread.sleep(5000);
			try
			{
			 func._alertHandler(getWebDriver(), "Ok");
			}
			catch(Exception ex)
			{
			
			}
			func._waitForPageToLoad(getWebDriver(), 300L);
			Thread.sleep(5000);
			NewSubmission objSubmission = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
			objSubmission.EditSubmission(tcID, softAssert, "resubmit");
			_click(getElement(btn_ResubmitCurYear));
		
			Thread.sleep(5000);
			 func._alertHandler(getWebDriver(), "Ok");
			 func._waitForPageToLoad(getWebDriver(), 300L);
				Thread.sleep(5000);

			func._waitFor(NBimpl.getElement("btn_NBCreateThisSubmission"), 500, WAIT_FOR.VISIBLE, "");
			NBimpl.Verify_RFCYValues(tcID, softAssert);

			
		}
		
	}
		
	
	@Override
	public void Verify_NewSubmission_Fieldvalues (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData NewSubmission = null;
		PageData EditSub =null;
		PageData PolicyBound=null;
		
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			NewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 NewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID); 
		 }
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			 EditSub = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
		 }
		 else
		 {
			 EditSub = PageDataManager.instance().getPageData("EditSubmission",tcID);
		 }
				 
	
		
		if(NewSubmission.getData("SubmissionStatus").equals("Policy Bound"))
		{
			if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
		
				PolicyBound = PageDataManager.instance().getPageData("QANewSubmission",tcID);
			 }
			 else
			 {
				 PolicyBound = PageDataManager.instance().getPageData("NewSubmission",tcID); 
			 }
			
		}
		if(EditSub.getData("SubmissionStatus").equals("Policy Bound"))
		{
			 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
		
				 PolicyBound = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
			 }
			 else
			 {
				 PolicyBound = PageDataManager.instance().getPageData("EditSubmission",tcID);
			 }
				
			
		}
		func._waitFor(getElement(tab_TabSubmission), 200, WAIT_FOR.CLICKABLE);
		 Thread.sleep(5000);
		_click(getElement(tab_TabSubmission));
		 func._waitForPageToLoad(getWebDriver(),200L);
		 Thread.sleep(5000);
		 
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);

		func._checkAttributeValue(getElement(lst_BusinessSegment), "TEXT", NewSubmission.getData("BusinessSegment"), softAssert);
		if(func._isEnabled(getElement(lst_BusinessSegment)))
		{
			CustomReporting.logReport("","","BusinessSegment  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "BusinessSegment field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_BranchOffice), "TEXT", NewSubmission.getData("BusinessOffice"), softAssert);
		if(func._isEnabled(getElement(lst_BranchOffice)))
		{
			CustomReporting.logReport("","","BusinessOffice  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "BusinessOffice field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_PredominantState), "TEXT", NewSubmission.getData("PredominantState"), softAssert);
		if(func._isEnabled(getElement(lst_PredominantState)))
		{
			CustomReporting.logReport("","","PredominantState  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "PredominantState field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT",PolicyBound.getData("SubmissionStatus"), softAssert);
		
		
		if(PolicyBound.getData("SubmissionStatus").equals("Policy Bound"))
		{
			if(!func._isEnabled(getElement(lst_SubmissionStatus)))
			{
				CustomReporting.logReport("","","SubmissionStatus field is Disabled." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "SubmissionStatus field is not Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
		else
		{
		
			if(func._isEnabled(getElement(lst_SubmissionStatus)))
			{
				CustomReporting.logReport("","","SubmissionStatus field is Enabled." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "SubmissionStatus field is not Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
		
		if(!NewSubmission.getData("SubmissionEffectiveDate").equals(""))
		{
			int offset= Integer.valueOf(NewSubmission.getData("SubmissionEffectiveDate").split("-")[0].trim());
	    	String OptValue=NewSubmission.getData("SubmissionEffectiveDate").split("-")[1].trim();
			
			
			func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value",func.Date_Manipulation("",OptValue, offset), softAssert);
		}
		else
		{
			
			 func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value",func.Date_Manipulation("", "Now", 0), softAssert);
			
		}
		if(func._isEnabled(getElement(dat_SubmissionEffectiveDate)))
		{
			CustomReporting.logReport("","","SubmissionEffectiveDate  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "SubmissionEffectiveDate field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!NewSubmission.getData("SubmissionExpaireDate").equals(""))
		{
			int offset= Integer.valueOf(NewSubmission.getData("SubmissionExpaireDate").split("-")[0].trim());
	    	String OptValue=NewSubmission.getData("SubmissionExpaireDate").split("-")[1].trim();
			func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value",func.Date_Manipulation("",OptValue, offset), softAssert);
			
		}
		else
		{
			if(!NewSubmission.getData("SubmissionEffectiveDate").equals(""))
			{
				
				String SubmissionExpDate= func.Date_Manipulation(NewSubmission.getData("SubmissionEffectiveDate"), "YEAR", 1);
				func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value",SubmissionExpDate, softAssert);
			}
			else
			{
				
				String SubmissionExpDate= func.Date_Manipulation("", "YEAR", 1);
				func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value",SubmissionExpDate, softAssert);
			}

		}
		if(func._isEnabled(getElement(dat_SubmissionExpaireDate)))
		{
			CustomReporting.logReport("","","SubmissionExpaireDate  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "SubmissionExpaireDate field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!NewSubmission.getData("PrimaryORExcess").equals("")&&NewSubmission.getData("BusinessSegment").equals("Financial Institutions")||NewSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability"))
		{
			if(NewSubmission.getData("PrimaryORExcess").trim().toLowerCase().equals("primary"))
			{
				
				if(func._isChecked(getElement(radio_Primary)))
				{
					CustomReporting.logReport("","","Primary radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "Primary radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				
				
				
			}
			if(NewSubmission.getData("PrimaryORExcess").trim().toLowerCase().equals("excess"))
			{
				
				if(func._isChecked(getElement(radio_Excess)))
				{
					CustomReporting.logReport("","","Excess radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "Excess radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				
			}
			if(func._isEnabled(getElement(radio_Primary)))
			{
				CustomReporting.logReport("","","Primary radio button  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Primary radio button field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			if(func._isEnabled(getElement(radio_Excess)))
			{
				CustomReporting.logReport("","","Excess radio button  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Excess radio button field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
		
		

		func._checkAttributeValue(getElement(lst_SubmissionType), "TEXT", "New", softAssert);
		if(func._isEnabled(getElement(lst_SubmissionType)))
		{
			CustomReporting.logReport("","","SubmissionType  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "SubmissionType field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_marketSegment), "TEXT", NewSubmission.getData("MarketSegment"), softAssert);
		if(func._isEnabled(getElement(lst_marketSegment)))
		{
			CustomReporting.logReport("","","MarketSegment  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "MarketSegment field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!NewSubmission.getData("ReceivedDate").equals(""))
		{
			func._checkAttributeValue(getElement(dat_ReceivedDate), "value", NewSubmission.getData("ReceivedDate"), softAssert);
		}
		else
		{
			
			func._checkAttributeValue(getElement(dat_ReceivedDate), "value", func.Date_Manipulation("", "Now", 0), softAssert);
			
		}
		if(func._isEnabled(getElement(dat_ReceivedDate)))
		{
			CustomReporting.logReport("","","MarketSegment  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "MarketSegment field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		//func._checkAttributeValue(getElement(lst_Distribution), "TEXT", NewSubmission.getData("Distribution"), softAssert);
		/*if(func._isEnabled(getElement(lst_Distribution)))
		{
			CustomReporting.logReport("","","Distribution  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Distribution field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}*/
		func._checkAttributeValue(getElement(lst_IncumbentCarrier), "TEXT", NewSubmission.getData("IncumbentCarrier"), softAssert);
		if(func._isEnabled(getElement(lst_IncumbentCarrier)))
		{
			CustomReporting.logReport("","","IncumbentCarrier  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "IncumbentCarrier field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_SubmissionLOB), "TEXT",NewSubmission.getData("SubmissionLOB") , softAssert);
		if(func._isEnabled(getElement(lst_SubmissionLOB)))
		{
			CustomReporting.logReport("","","SubmissionLOB  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "SubmissionLOB field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_Producername), "TEXT", NewSubmission.getData("Producername"), softAssert);
		if(func._isEnabled(getElement(lst_Producername)))
		{
			CustomReporting.logReport("","","Producername  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Producername field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!NewSubmission.getData("SubmittedProduct").equals("")&&NewSubmission.getData("BusinessSegment").equals("Financial Institutions")||NewSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability"))
		{
			func._checkAttributeValue(getElement(lst_SubmittedProduct), "TEXT", NewSubmission.getData("SubmittedProduct"), softAssert);
			if(func._isEnabled(getElement(lst_SubmittedProduct)))
			{
				CustomReporting.logReport("","","SubmittedProduct  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "SubmittedProduct field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
		
		func._checkAttributeValue(getElement(lst_ProducerOffice), "TEXT", NewSubmission.getData("ProducerOffice"), softAssert);
		if(func._isEnabled(getElement(lst_ProducerOffice)))
		{
			CustomReporting.logReport("","","ProducerOffice  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "ProducerOffice field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_UWName), "TEXT", NewSubmission.getData("UWName"), softAssert);
		if(func._isEnabled(getElement(lst_UWName)))
		{
			CustomReporting.logReport("","","UnderWriter Name  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "UnderWriter name field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(txt_EstimatedPremium), "value",NewSubmission.getData("EstimatedPremium"), softAssert);
		if(func._isEnabled(getElement(txt_EstimatedPremium)))
		{
			CustomReporting.logReport("","","EstimatedPremium  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "EstimatedPremium field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_EverestCompany), "TEXT", NewSubmission.getData("EverestCompany"), softAssert);
		if(func._isEnabled(getElement(lst_EverestCompany)))
		{
			CustomReporting.logReport("","","EverestCompany  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "EverestCompany field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(txt_Comment), "TEXT", NewSubmission.getData("Comment"), softAssert);
		if(func._isEnabled(getElement(txt_Comment)))
		{
			CustomReporting.logReport("","","Comment  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Comment field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if((PolicyBound.getData("SubmissionStatus").equals("Policy Bound")||PolicyBound.getData("SubmissionStatus").equals("Indication Lost"))||PolicyBound.getData("SubmissionStatus").equals("Quote Lost")||PolicyBound.getData("SubmissionStatus").equals("Declined"))
		{
			if(!PolicyBound.getData("DateQuoted").equals(""))
			{
			func._checkAttributeValue(getElement(dat_DateQuoted), "value", PolicyBound.getData("DateQuoted"), softAssert);
			}
			else
			{
			func._checkAttributeValue(getElement(dat_DateQuoted), "value", func.Date_Manipulation("", "Now", 0), softAssert);	
			}
		
			if(func._isEnabled(getElement(dat_DateQuoted)))
			{
				CustomReporting.logReport("","","DateQuoted  field is Enabled in New Submission screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "DateQuoted field is not Enabled in New Submission screen even though if submission status is selected as Policy Bound/Indication Lost/Quote Lost","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			if(!PolicyBound.getData("QuotedLineOfBusiness").equals(""))
			{
			func._checkAttributeValue(getElement(lst_QuotedLineBusiness), "TEXT", PolicyBound.getData("QuotedLineOfBusiness"), softAssert);
			}
			else
			{
				func._checkAttributeValue(getElement(lst_QuotedLineBusiness), "TEXT", NewSubmission.getData("SubmissionLOB"), softAssert);	
			}
			if(func._isEnabled(getElement(lst_QuotedLineBusiness)))
			{
				CustomReporting.logReport("","","QuotedLineBusiness  field is Enabled in new Submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "QuotedLineBusiness field is not Enabled in New Submission screen even though if submission status is selected as Policy Bound/Indication Lost/Quote Lost","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			
			try
			{
				String ExpQuotedPremium=getElement(txt_QuotedPremium).getAttribute("value").trim().replace(",", "");
				if(ExpQuotedPremium.equals(PolicyBound.getData("QuotedPremium")))
				
				{
					CustomReporting.logReport("","","Expected value : "+PolicyBound.getData("QuotedPremium")+" match with Actual value "+ExpQuotedPremium ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "","Expected value : "+PolicyBound.getData("QuotedPremium")+" does not match with Actual value "+ExpQuotedPremium,"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}

		
			if(func._isEnabled(getElement(txt_QuotedPremium)))
			{
				CustomReporting.logReport("","","QuotedPremium  field is Enabled in new Submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "QuotedPremium field is not Enabled in New Submission screen even though if submission status is selected as Policy Bound/Indication Lost/Quote Lost","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
		else
		{
			if(!func._isEnabled(getElement(dat_DateQuoted)))
			{
				CustomReporting.logReport("","","DateQuoted  field is Disabled in New Submission screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "DateQuoted field is not Disabled in New Submission screen even though if submission status is not selected as Policy Bound/Indication Lost/Quote Lost","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}

			if(!func._isEnabled(getElement(lst_QuotedLineBusiness)))
			{
				CustomReporting.logReport("","","QuotedLineBusiness  field is Disabled in new Submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "QuotedLineBusiness field is not Disabled in New Submission screen even though if submission status is not selected as Policy Bound/Indication Lost/Quote Lost","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		
			if(!func._isEnabled(getElement(txt_QuotedPremium)))
			{
				CustomReporting.logReport("","","QuotedPremium  field is Disabled in new Submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "QuotedPremium field is not Disabled in New Submission screen even though if submission status is not selected as Policy Bound/Indication Lost/Quote Lost","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
		if(!PolicyBound.getData("NaicsCode").equals(""))
		{
			func._checkAttributeValue(getElement(txt_NaicsCode), "value", PolicyBound.getData("NaicsCode"), softAssert);
		}
		
		if(func._isEnabled(getElement(txt_NaicsCode)))
		{
			CustomReporting.logReport("","","NaicsCode  field is Enabled in new Submission screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "NaicsCode field is Disabled in New Submission screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if((PolicyBound.getData("BusinessSegment").equals("Financial Institutions")||PolicyBound.getData("BusinessSegment").equalsIgnoreCase("Professional Liability"))&&(PolicyBound.getData("SubmissionStatus").equals("Quote Lost")||PolicyBound.getData("SubmissionStatus").equals("Indication Lost")||PolicyBound.getData("SubmissionStatus").equals("Quote Outstanding") 
	    		||PolicyBound.getData("SubmissionStatus").equals("Indication Outstanding")||PolicyBound.getData("SubmissionStatus").equals("Policy Bound")))

		{
			try
			{
				String limitvalue=getElement(txt_Limit).getAttribute("value").trim().replace(",", "");
				if(limitvalue.equals(PolicyBound.getData("Limit")))
				
				{
					CustomReporting.logReport("","","Expected value : "+PolicyBound.getData("Limit")+" match with Actual value "+limitvalue ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "","Expected value : "+PolicyBound.getData("Limit")+" does not match with Actual value "+limitvalue,"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			
			
			if(func._isEnabled(getElement(txt_Limit)))
			{
				CustomReporting.logReport("","","Limit field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", ""," Limit field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			
			try
			{
				String RetentionAttachment=getElement(txt_RetentionAttachment).getAttribute("value").trim().replace(",", "");
				if(RetentionAttachment.equals(PolicyBound.getData("RetentionAttachment")))
				
				{
					CustomReporting.logReport("","","Expected value : "+PolicyBound.getData("RetentionAttachment")+" match with Actual value "+RetentionAttachment ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "","Expected value : "+PolicyBound.getData("RetentionAttachment")+" does not match with Actual value "+RetentionAttachment,"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			
		
			if(func._isEnabled(getElement(txt_RetentionAttachment)))
			{
				CustomReporting.logReport("","","Retention/Attachment field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", ""," Retention/Attachment field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			
			if(!PolicyBound.getData("PolicyPrimaryORExcess").equals(""))
			{
				if(PolicyBound.getData("PolicyPrimaryORExcess").trim().toLowerCase().equals("primary"))
				{
					
					if(func._isChecked(getElement(radio_Primary)))
					{
						CustomReporting.logReport("","","Primary radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Primary radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
				if(PolicyBound.getData("PolicyPrimaryORExcess").trim().toLowerCase().equals("excess"))
				{
					
					if(func._isChecked(getElement(radio_Excess)))
					{
						CustomReporting.logReport("","","Excess radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Excess radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
			}
			if(func._isEnabled(getElement(radio_Primary)))
			{
				CustomReporting.logReport("","","Policy Primary radio buttion field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","Policy Primary radio buttion field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			if(func._isEnabled(getElement(radio_Excess)))
			{
				CustomReporting.logReport("","","Policy Excess radio buttion field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "","Policy Excess radio buttion field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
		if((NewSubmission.getData("SubmissionLOB").equals("Workers Comp"))&&(PolicyBound.getData("SubmissionStatus").equals("Policy Bound")||NewSubmission.getData("SubmissionStatus").equals("Indication Lost")
		    	||PolicyBound.getData("SubmissionStatus").equals("Quote Lost")||PolicyBound.getData("SubmissionStatus").equals("Indication Outstanding")
		    	||PolicyBound.getData("SubmissionStatus").equals("Quote Outstanding")))
		{
			if(!PolicyBound.getData("ScheduleRatingMod").equals(""))
			{
			func._checkAttributeValue(getElement(txt_ScheduleRatingMod), "value", PolicyBound.getData("ScheduleRatingMod"), softAssert);
			}
			else
			{
				func._checkAttributeValue(getElement(txt_ScheduleRatingMod), "value", "0.00", softAssert);	
			}
			if(func._isEnabled(getElement(txt_ScheduleRatingMod)))
			{
				CustomReporting.logReport("","","ScheduleRatingMod field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", ""," ScheduleRatingMod field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			
			if(!PolicyBound.getData("ExperienceMod").equals(""))
			{
			func._checkAttributeValue(getElement(txt_ExperienceMod), "value", PolicyBound.getData("ExperienceMod"), softAssert);
			}
			else
			{
				func._checkAttributeValue(getElement(txt_ExperienceMod), "value", "0.00", softAssert);	
			}
			if(func._isEnabled(getElement(txt_ExperienceMod)))
			{
				CustomReporting.logReport("","","ExperienceMod field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", ""," ExperienceMod field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}

		}

	}
		
		

		@Override
		public void Verify_ClonedSubmission_Fieldvalues (String tcID, SoftAssert softAssert,String type) throws Exception
		{
			PageData NewSubmission = null;
			PageData EditSub =null;
			PageData PolicyBound=null;
			
			
			 
			PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
			if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
				if(type.equalsIgnoreCase("edit"))
				{
					NewSubmission = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
				}
				else
				{
		
					NewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
				}
			 }
			 else
			 {
				 if(type.equalsIgnoreCase("edit"))
					{
						NewSubmission = PageDataManager.instance().getPageData("EditSubmission",tcID);
					}
					else
					{
			
						 NewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID); 
					}
				
			 }
			 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
		
				 EditSub = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
			 }
			 else
			 {
				 EditSub = PageDataManager.instance().getPageData("EditSubmission",tcID);
			 }

			func._waitFor(getElement(tab_TabSubmission), 200, WAIT_FOR.CLICKABLE);
			 Thread.sleep(5000);

			
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);

			func._checkAttributeValue(getElement(lst_BusinessSegment), "TEXT", NewSubmission.getData("BusinessSegment"), softAssert);
			if(func._isEnabled(getElement(lst_BusinessSegment)))
			{
				CustomReporting.logReport("","","BusinessSegment  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "BusinessSegment field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(lst_BranchOffice), "TEXT", NewSubmission.getData("BusinessOffice"), softAssert);
			if(func._isEnabled(getElement(lst_BranchOffice)))
			{
				CustomReporting.logReport("","","BusinessOffice  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "BusinessOffice field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(lst_PredominantState), "TEXT", NewSubmission.getData("PredominantState"), softAssert);
			if(func._isEnabled(getElement(lst_PredominantState)))
			{
				CustomReporting.logReport("","","PredominantState  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "PredominantState field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
	
			func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT","Working", softAssert);	
			
			if(func._isEnabled(getElement(lst_SubmissionStatus)))
			{
				CustomReporting.logReport("","","SubmissionStatus field is Enaabled." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "SubmissionStatus field is not Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			if(!NewSubmission.getData("SubmissionEffectiveDate").equals("NA"))	
			{
			
				if(!NewSubmission.getData("SubmissionEffectiveDate").equals(""))
				{
					int offset= Integer.valueOf(NewSubmission.getData("SubmissionEffectiveDate").split("-")[0].trim());
			    	String OptValue=NewSubmission.getData("SubmissionEffectiveDate").split("-")[1].trim();
					func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value",func.Date_Manipulation("",OptValue, offset), softAssert);
				}
				else
				{
					
					 func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value",func.Date_Manipulation("", "Now", 0), softAssert);
					
				}
			}
			else
			{
				 
				func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value",func._getGlobalVariableValue("EffDate"), softAssert);
			}
		
			if(func._isEnabled(getElement(dat_SubmissionEffectiveDate)))
			{
				CustomReporting.logReport("","","SubmissionEffectiveDate  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "SubmissionEffectiveDate field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			if(!NewSubmission.getData("SubmissionExpaireDate").equals("NA"))	
			{
				if(!NewSubmission.getData("SubmissionExpaireDate").equals(""))
				{
					int offset= Integer.valueOf(NewSubmission.getData("SubmissionExpaireDate").split("-")[0].trim());
			    	String OptValue=NewSubmission.getData("SubmissionExpaireDate").split("-")[1].trim();
					func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value",func.Date_Manipulation("",OptValue, offset), softAssert);
					
				}
				else
				{
					if(!NewSubmission.getData("SubmissionEffectiveDate").equals(""))
					{
						
						String SubmissionExpDate= func.Date_Manipulation(NewSubmission.getData("SubmissionEffectiveDate"), "YEAR", 1);
						func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value",SubmissionExpDate, softAssert);
					}
					else
					{
						
						String SubmissionExpDate= func.Date_Manipulation("", "YEAR", 1);
						func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value",SubmissionExpDate, softAssert);
					}
	
				}
			}
			else
			{
				func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value",func._getGlobalVariableValue("ExpDate"), softAssert);	
			}
			if(func._isEnabled(getElement(dat_SubmissionExpaireDate)))
			{
				CustomReporting.logReport("","","SubmissionExpaireDate  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "SubmissionExpaireDate field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			
			if(!NewSubmission.getData("PrimaryORExcess").equals("")&&NewSubmission.getData("BusinessSegment").equals("Financial Institutions")||NewSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability"))
			{
				if(NewSubmission.getData("PrimaryORExcess").trim().toLowerCase().equals("primary"))
				{
					
					if(func._isChecked(getElement(radio_Primary)))
					{
						CustomReporting.logReport("","","Primary radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Primary radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
					
					
				}
				if(NewSubmission.getData("PrimaryORExcess").trim().toLowerCase().equals("excess"))
				{
					
					if(func._isChecked(getElement(radio_Excess)))
					{
						CustomReporting.logReport("","","Excess radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
					}
					else
					{
						CustomReporting.logReport("", "", "Excess radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
					}
					
				}
				if(func._isEnabled(getElement(radio_Primary)))
				{
					CustomReporting.logReport("","","Primary radio button  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "Primary radio button field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				if(func._isEnabled(getElement(radio_Excess)))
				{
					CustomReporting.logReport("","","Excess radio button  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "Excess radio button field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
			}
			
			

			func._checkAttributeValue(getElement(lst_SubmissionType), "TEXT", "New", softAssert);
			if(func._isEnabled(getElement(lst_SubmissionType)))
			{
				CustomReporting.logReport("","","SubmissionType  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "SubmissionType field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(lst_marketSegment), "TEXT", NewSubmission.getData("MarketSegment"), softAssert);
			if(func._isEnabled(getElement(lst_marketSegment)))
			{
				CustomReporting.logReport("","","MarketSegment  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "MarketSegment field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			if(!NewSubmission.getData("ReceivedDate").equals(""))
			{
				func._checkAttributeValue(getElement(dat_ReceivedDate), "value", NewSubmission.getData("ReceivedDate"), softAssert);
			}
			else
			{
				
				func._checkAttributeValue(getElement(dat_ReceivedDate), "value", func.Date_Manipulation("", "Now", 0), softAssert);
				
			}
			if(func._isEnabled(getElement(dat_ReceivedDate)))
			{
				CustomReporting.logReport("","","MarketSegment  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "MarketSegment field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			
			func._checkAttributeValue(getElement(lst_IncumbentCarrier), "TEXT", NewSubmission.getData("IncumbentCarrier"), softAssert);
			if(func._isEnabled(getElement(lst_IncumbentCarrier)))
			{
				CustomReporting.logReport("","","IncumbentCarrier  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "IncumbentCarrier field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(lst_SubmissionLOB), "TEXT",NewSubmission.getData("SubmissionLOB") , softAssert);
			if(!func._isEnabled(getElement(lst_SubmissionLOB)))
			{
				CustomReporting.logReport("","","SubmissionLOB  field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "SubmissionLOB field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(lst_Producername), "TEXT", NewSubmission.getData("Producername"), softAssert);
			if(func._isEnabled(getElement(lst_Producername)))
			{
				CustomReporting.logReport("","","Producername  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Producername field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			if(!NewSubmission.getData("SubmittedProduct").equals("")&&NewSubmission.getData("BusinessSegment").equals("Financial Institutions")||NewSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability"))
			{
				func._checkAttributeValue(getElement(lst_SubmittedProduct), "TEXT", NewSubmission.getData("SubmittedProduct"), softAssert);
				if(func._isEnabled(getElement(lst_SubmittedProduct)))
				{
					CustomReporting.logReport("","","SubmittedProduct  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "SubmittedProduct field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
			}
			
			func._checkAttributeValue(getElement(lst_ProducerOffice), "TEXT", NewSubmission.getData("ProducerOffice"), softAssert);
			if(func._isEnabled(getElement(lst_ProducerOffice)))
			{
				CustomReporting.logReport("","","ProducerOffice  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "ProducerOffice field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(lst_UWName), "TEXT", NewSubmission.getData("UWName"), softAssert);
			if(func._isEnabled(getElement(lst_UWName)))
			{
				CustomReporting.logReport("","","UnderWriter Name  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "UnderWriter name field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_EstimatedPremium), "value",NewSubmission.getData("EstimatedPremium"), softAssert);
			if(func._isEnabled(getElement(txt_EstimatedPremium)))
			{
				CustomReporting.logReport("","","EstimatedPremium  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "EstimatedPremium field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(lst_EverestCompany), "TEXT", NewSubmission.getData("EverestCompany"), softAssert);
			if(func._isEnabled(getElement(lst_EverestCompany)))
			{
				CustomReporting.logReport("","","EverestCompany  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "EverestCompany field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(txt_Comment), "TEXT", NewSubmission.getData("Comment"), softAssert);
			if(func._isEnabled(getElement(txt_Comment)))
			{
				CustomReporting.logReport("","","Comment  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Comment field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}

		}
	
	public void Verify_ChangeBS_fieldvalues (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataNewSubmission =null;
		PageData dataEditSubmission =null;
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

		
		PageData dataPolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		_setValue(getElement(lst_BusinessSegment),dataEditSubmission.getData("BusinessSegment"));
		func._waitForPageToLoad(getWebDriver(),50L);
		//_click(getElement(tab_TabSubmission));
		//func._waitFor(getElement(btn_CopySubmission), 500, WAIT_FOR.CLICKABLE, "");
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		//func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
		//func._checkAttributeValue(getElement(lst_BusinessSegment), "TEXT", dataNewSubmission.getData("BusinessSegment"), softAssert);
		//func._checkAttributeValue(getElement(lst_BranchOffice), "TEXT", dataNewSubmission.getData("BusinessOffice"), softAssert);
		//func._checkAttributeValue(getElement(lst_PredominantState), "TEXT", dataNewSubmission.getData("PredominantState"), softAssert);
		func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT","Received", softAssert);
		/*String SubmissionEffDate;

		if(!dataNewSubmission.getData("SubmissionEffectiveDate").contentEquals(""))
		{
			
			SubmissionEffDate= func.Date_Manipulation(dataNewSubmission.getData("SubmissionEffectiveDate"), "YEAR", 1);
		}
		else
		{
			SubmissionEffDate= func.Date_Manipulation("" ,"YEAR", 1);
		}
		func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value",SubmissionEffDate, softAssert);

		String SubmissionExpDate;
		if(!dataNewSubmission.getData("SubmissionExpaireDate").equals(""))
		{
			int offset= Integer.valueOf(dataNewSubmission.getData("SubmissionExpaireDate").split("-")[0].trim());
	    	String OptValue=dataNewSubmission.getData("SubmissionExpaireDate").split("-")[1].trim();

			func._checkAttributeValue(getElement(dat_SubmissionExpaireDate),"value",func.Date_Manipulation(func.Date_Manipulation("",OptValue, offset),"Year",1), softAssert);
			
		}
		else
		{
			SubmissionExpDate= func.Date_Manipulation("", "YEAR", 2);
			func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value",SubmissionExpDate, softAssert);

		}*/
	
		
		 if(dataEditSubmission.getData("BusinessSegment").equals("Financial Institutions")||dataEditSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability"))
 
		{
				
			if(!func._isChecked(getElement(radio_Primary)))
			{
				CustomReporting.logReport("","","Primary radio button is de selected after Changed the Business Segment" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Primary radio button is still selected even after Changed the Business Segment","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}

			if(!func._isChecked(getElement(radio_Excess)))
			{
				CustomReporting.logReport("","","Excess radio button is de selected after Changed the Business Segment" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Excess radio button is still selected even after changed the Business Segment","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			func._checkAttributeValue(getElement(lst_SubmittedProduct), "TEXT", "make selection", softAssert);
			
			/*if(!func._isChecked(getElement(chk_Public)))
			{
				CustomReporting.logReport("","","Public check box is de selected after Changed the Business Segment" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Public check box is still selected even after Changed the Business Segment","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}

			if(!func._isChecked(getElement(chk_Pravite)))
			{
				CustomReporting.logReport("","","Pravite checkbox is de selected after Changed the Business Segment" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Pravite checkbox is still selected even after changed the Business Segment","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			*/

		}

		func._checkAttributeValue(getElement(lst_SubmissionType), "TEXT", "make selection", softAssert);
		func._checkAttributeValue(getElement(lst_marketSegment), "TEXT","make selection", softAssert);
		func._checkAttributeValue(getElement(lst_IncumbentCarrier), "TEXT", "make selection", softAssert);
		func._checkAttributeValue(getElement(dat_ReceivedDate), "value",func.Date_Manipulation("", "Now", 0), softAssert);
		//func._checkAttributeValue(getElement(lst_Distribution), "TEXT", dataNewSubmission.getData("Distribution"), softAssert);
		func._checkAttributeValue(getElement(lst_SubmissionLOB), "TEXT","make selection" , softAssert);
		func._checkAttributeValue(getElement(lst_Producername), "TEXT", "make selection", softAssert);
		func._checkAttributeValue(getElement(lst_ProducerOffice), "TEXT", "make selection", softAssert);
		func._checkAttributeValue(getElement(lst_UWName), "TEXT", "make selection", softAssert);
		func._checkAttributeValue(getElement(txt_EstimatedPremium), "value", "", softAssert);
		func._checkAttributeValue(getElement(lst_EverestCompany), "TEXT","make selection", softAssert);
		func._checkAttributeValue(getElement(txt_Comment), "TEXT", "", softAssert);
		func._checkAttributeValue(getElement(txt_SubDescription), "TEXT", "", softAssert);
		if(!func._isEnabled(getElement(dat_DateQuoted)))
		{
			CustomReporting.logReport("","","DateQuoted field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "DateQuoted field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!func._isEnabled(getElement(txt_QuotedPremium)))
		{
			CustomReporting.logReport("","","QuotedPremium field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "QuotedPremium field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(lst_QuotedLineBusiness)))
		{
			CustomReporting.logReport("","","QuotedLineBusiness field is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "QuotedLineBusiness field is Enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}

		//func._checkAttributeValue(getElement(txt_NaicsCode), "value", dataEditSubmission.getData("NaicsCode"), softAssert);
		
	
	}
	
	public void Verify_Submission_ReadOnly_fields (String tcID, SoftAssert softAssert) throws Exception
	{
		_click(getElement(tab_TabSubmission));
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(2000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
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
		
		func._checkAttributeValue(getElement(lst_BusinessSegment), "TEXT", NewSubmission.getData("BusinessSegment"), softAssert);
		if(!func._isEnabled(getElement(lst_BusinessSegment)))
		{
			CustomReporting.logReport("","","BusinessSegment List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," BusinessSegment List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT",NewSubmission.getData("SubmissionStatus"), softAssert);
		if(!func._isEnabled(getElement(lst_SubmissionStatus)))
		{
			CustomReporting.logReport("","","SubmissionStatus List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," SubmissionStatus List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_BranchOffice), "TEXT", NewSubmission.getData("BusinessOffice"), softAssert);
		if(!func._isEnabled(getElement(lst_BranchOffice)))
		{
			CustomReporting.logReport("","","BranchOffice List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "","BranchOffice List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_PredominantState), "TEXT", NewSubmission.getData("PredominantState"), softAssert);
		if(!func._isEnabled(getElement(lst_PredominantState)))
		{
			CustomReporting.logReport("","","PredominantState List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," PredominantState List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_marketSegment), "TEXT", NewSubmission.getData("MarketSegment"), softAssert);
		if(!func._isEnabled(getElement(lst_marketSegment)))
		{
			CustomReporting.logReport("","","marketSegment List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," marketSegment List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_SubmissionType), "TEXT", NewSubmission.getData("SubmissionType"), softAssert);
		if(!func._isEnabled(getElement(lst_SubmissionType)))
		{
			CustomReporting.logReport("","","SubmissionType List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," SubmissionType List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!NewSubmission.getData("ReceivedDate").equals(""))
		{
			func._checkAttributeValue(getElement(dat_ReceivedDate), "value", NewSubmission.getData("ReceivedDate"), softAssert);
		}
		else
		{
			
			func._checkAttributeValue(getElement(dat_ReceivedDate), "value", func.Date_Manipulation("", "Now", 0), softAssert);
			
		}
		
		if(!func._isEnabled(getElement(dat_ReceivedDate)))
		{
			CustomReporting.logReport("","","ReceivedDate text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," ReceivedDate text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		//func._checkAttributeValue(getElement(lst_Distribution), "TEXT", NewSubmission.getData("Distribution"), softAssert);
		/*if(!func._isEnabled(getElement(lst_Distribution)))
		{
			CustomReporting.logReport("","","Distribution List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," Distribution List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}*/
		if(!NewSubmission.getData("SubmissionEffectiveDate").equals(""))
		{
			func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value",NewSubmission.getData("SubmissionEffectiveDate"), softAssert);
		}
		else
		{
			
			 func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value",func.Date_Manipulation("", "Now", 0), softAssert);
			
		}
		if(!func._isEnabled(getElement(dat_SubmissionEffectiveDate)))
		{
			CustomReporting.logReport("","","SubmissionEffectiveDate text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," SubmissionEffectiveDate text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!NewSubmission.getData("SubmissionExpaireDate").equals(""))
		{
			int offset= Integer.valueOf(NewSubmission.getData("SubmissionExpaireDate").split("-")[0].trim());
	    	String OptValue=NewSubmission.getData("SubmissionExpaireDate").split("-")[1].trim();
			func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value",func.Date_Manipulation("",OptValue, offset), softAssert);
			
		}
		else
		{
			if(!NewSubmission.getData("SubmissionEffectiveDate").equals(""))
			{
				
				String SubmissionExpDate= func.Date_Manipulation(NewSubmission.getData("SubmissionEffectiveDate"), "YEAR", 1);
				func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value",SubmissionExpDate, softAssert);
			}
			else
			{
				
				String SubmissionExpDate= func.Date_Manipulation("", "YEAR", 1);
				func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value",SubmissionExpDate, softAssert);
			}

		}

		
		if(!func._isEnabled(getElement(dat_SubmissionExpaireDate)))
		{
			CustomReporting.logReport("","","SubmissionExpaireDate text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," SubmissionExpaireDate text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_IncumbentCarrier), "TEXT", NewSubmission.getData("IncumbentCarrier"), softAssert);
		if(!func._isEnabled(getElement(lst_IncumbentCarrier)))
		{
			CustomReporting.logReport("","","IncumbentCarrier List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," IncumbentCarrier List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_Producername), "TEXT", NewSubmission.getData("Producername"), softAssert);
		if(!func._isEnabled(getElement(lst_Producername)))
		{
			CustomReporting.logReport("","","Producername List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," Producername List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(lst_ProducerOffice), "TEXT", NewSubmission.getData("ProducerOffice"), softAssert);
		
		if(!func._isEnabled(getElement(lst_ProducerOffice)))
		{
			CustomReporting.logReport("","","ProducerOffice List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," ProducerOffice List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(NewSubmission.getData("Producername").equals("United Agencies, Inc."))
		{

			if(!func._isEnabled(getElement(lst_SubProducer)))
			{
				CustomReporting.logReport("","","SubProducer List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", ""," SubProducer List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
		
		func._checkAttributeValue(getElement(lst_UWName), "TEXT", NewSubmission.getData("UWName"), softAssert);
		if(!func._isEnabled(getElement(lst_UWName)))
		{
			CustomReporting.logReport("","","UnderWriterName List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," UnderWriterName List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!NewSubmission.getData("UWAssistant").equals("")) {
		func._checkAttributeValue(getElement(lst_UWName), "TEXT", NewSubmission.getData("UWAssistant"), softAssert);
		}
		if(!func._isEnabled(getElement(lst_UWAssistant)))
		{
			CustomReporting.logReport("","","UnderWriterAssistant List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," UnderWriterAssistant List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_EverestCompany), "TEXT", NewSubmission.getData("EverestCompany"), softAssert);
		if(!func._isEnabled(getElement(lst_EverestCompany)))
		{
			CustomReporting.logReport("","","EverestCompany List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," EverestCompany List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!NewSubmission.getData("DateQuoted").equals(""))
		{
			func._checkAttributeValue(getElement(dat_DateQuoted), "value",NewSubmission.getData("DateQuoted"), softAssert);
		}
		else
		{
			
			 func._checkAttributeValue(getElement(dat_DateQuoted), "value",func.Date_Manipulation("", "Now", 0), softAssert);
			
		}
		
		if(!func._isEnabled(getElement(dat_DateQuoted)))
		{
			CustomReporting.logReport("","","DateQuoted Text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," DateQuoted Text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!NewSubmission.getData("QuotedPremium").equals("")) {
			String ExpPolicyPremium=getElement(txt_QuotedPremium).getAttribute("value").trim().replace(",", "");
			if(ExpPolicyPremium.equals(NewSubmission.getData("QuotedPremium")))
			{
				CustomReporting.logReport("","","Expected QuotedPremium value  :"+ NewSubmission.getData("QuotedPremium")+"match with Actual :"+ExpPolicyPremium ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", ""," Expected QuotedPremium value  :"+ NewSubmission.getData("QuotedPremium")+"match with Actual :"+ExpPolicyPremium,"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}	
		}
		if(!func._isEnabled(getElement(txt_QuotedPremium)))
		{
			CustomReporting.logReport("","","QuotedPremium Text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," QuotedPremium Text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!NewSubmission.getData("QuotedLineOfBusiness").equals("")) {
			func._checkAttributeValue(getElement(lst_QuotedLineBusiness), "TEXT", NewSubmission.getData("QuotedLineOfBusiness"), softAssert);
			}
		
		if(!func._isEnabled(getElement(lst_QuotedLineBusiness)))
		{
			CustomReporting.logReport("","","QuotedLineBusiness List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," QuotedLineBusiness List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!NewSubmission.getData("NaicsCode").equals("")) {
			func._checkAttributeValue(getElement(txt_NaicsCode), "value", NewSubmission.getData("NaicsCode"), softAssert);
			}
		
		if(!func._isEnabled(getElement(txt_NaicsCode)))
		{
			CustomReporting.logReport("","","NaicsCode Text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," NaicsCode Text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(NewSubmission.getData("BusinessSegment").contains("Financial Institutions")||NewSubmission.getData("BusinessSegment").contains("Commercial Management Liability")|| 
				NewSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability"))
			    
		    {
			if(NewSubmission.getData("PrimaryORExcess").trim().toLowerCase().equals("primary"))
			{
				
				if(func._isChecked(getElement(radio_Primary)))
				{
					CustomReporting.logReport("","","Primary radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "Primary radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				
				
				
			}
			if(NewSubmission.getData("PrimaryORExcess").trim().toLowerCase().equals("excess"))
			{
				
				if(func._isChecked(getElement(radio_Excess)))
				{
					CustomReporting.logReport("","","Excess radio buttion  is selected" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", "", "Excess radio button is not selected.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
				
			}
			 if(!func._isEnabled(getElement(radio_Primary)))
				{
					CustomReporting.logReport("","","Primary Radio button is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", ""," Primary Radio button is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
			 	if(!func._isEnabled(getElement(radio_Excess)))
				{
					CustomReporting.logReport("","","Excess Radio button is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", ""," Excess Radio button is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
			 	if(!NewSubmission.getData("SubmittedProduct").equals("")) {
					func._checkAttributeValue(getElement(lst_SubmittedProduct), "TEXT", NewSubmission.getData("SubmittedProduct"), softAssert);
					}
			 	if(!func._isEnabled(getElement(lst_SubmittedProduct)))
				{
					CustomReporting.logReport("","","SubmittedProduct ListBox is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", ""," SubmittedProduct ListBox is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
			 	/*if(!func._isEnabled(getElement(chk_Public)))
				{
					CustomReporting.logReport("","","Public Check box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", ""," Public Check box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
			 	if(!func._isEnabled(getElement(chk_Pravite)))
				{
					CustomReporting.logReport("","","Pravite Check box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", ""," Pravite Check box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}*/

		    }
		 	if((NewSubmission.getData("BusinessSegment").equals("Financial Institutions")||NewSubmission.getData("BusinessSegment").equalsIgnoreCase("Professional Liability"))&&(NewSubmission.getData("SubmissionStatus").equals("Quote Lost")||NewSubmission.getData("SubmissionStatus").equals("Indication Lost")||NewSubmission.getData("SubmissionStatus").equals("Quote Outstanding") 
		    		||NewSubmission.getData("SubmissionStatus").equals("Indication Outstanding")||NewSubmission.getData("SubmissionStatus").equals("Policy Bound")))
		 	{
		 		if(!NewSubmission.getData("Limit").equals("")) {
					func._checkAttributeValue(getElement(txt_Limit), "value", NewSubmission.getData("Limit"), softAssert);
					}
		 		if(!func._isEnabled(getElement(txt_Limit)))
				{
					CustomReporting.logReport("","","Limit Text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", ""," Limit Text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
		 		if(!NewSubmission.getData("RetentionAttachment").equals("")) {
					func._checkAttributeValue(getElement(txt_RetentionAttachment), "value", NewSubmission.getData("RetentionAttachment"), softAssert);
					}
		 		if(!func._isEnabled(getElement(txt_RetentionAttachment)))
				{
					CustomReporting.logReport("","","RetentionAttachment Text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
				}
				else
				{
					CustomReporting.logReport("", ""," RetentionAttachment Text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
				}
			 
		 
		 	}
		
	}
	public void Verify_Sub_Pol_Billing_UnderWriter (String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		PageData dataNewSubmission =null;	
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID); 
		 }
		
			NewSubmission objNewSubmission = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
			String SSValue;
			String BSValue;
			objNewSubmission.NewSubmission(tcID,softAssert);
			Setup.LoadData();
			Search objSearch = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
			objSearch.Verify_Submission_Search(tcID, softAssert,DeviceName);
			objNewSubmission.EditSubmission(tcID, softAssert, "edit");
			//objNewSubmission.clkSave(tcID, softAssert);
			 BSValue=func._getAttributeValue(getElement(lst_BusinessSegment), "TEXT", softAssert);
			 SSValue=func._getAttributeValue(getElement(lst_SubmissionStatus), "TEXT", softAssert);
			/*if(SSValue.equals("Quote Lost")||SSValue.equals("Indication Lost")||SSValue.equals("Quote Outstanding") 
		    		||SSValue.equals("Indication Outstanding")||SSValue.equals("Policy Bound"))*/
			if(SSValue.equals("Policy Bound"))
			{
			AddPolicy objPolicy = (AddPolicy) PageManager.instance().createPage( AddPolicy.class, getWebDriver());
			objPolicy.clkAddPolicy(tcID, softAssert);
			objPolicy.IssueNewPolicy(tcID,softAssert);
			Setup.LoadData();
			objSearch.Verify_Policy_Search(tcID, softAssert,DeviceName);
			Payment objPayment = (Payment) PageManager.instance().createPage( Payment.class, getWebDriver());
			objPolicy.VerifyBillingPage(tcID,softAssert);
			Setup.LoadData();
			objPolicy.Check_Invoice_Downloaded(tcID, softAssert, "", "invoice");
			Setup.LoadData();
			objPolicy.Check_Invoice_Downloaded(tcID, softAssert, "", "payment");
			Setup.LoadData();
			objPayment.Payment_page_Verification(tcID,softAssert);
			}
		
	}
		
	@Override
	public void Check_BusinessIndicator_Status_Submission (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataNewSubmission =null;	
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
	
			dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID); 
		 }
		
	
		_setValue(getElement(lst_BusinessSegment),dataNewSubmission.getData("BusinessSegment"));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		 _setValue(getElement(lst_SubmissionStatus),dataNewSubmission.getData("SubmissionStatus"));
		    func._waitForPageToLoad(getWebDriver(),50L);
				
			/*if(func._isVisible(getElement(chk_Public)))
			{
				CustomReporting.logReport("","", "Public business indicator check box is displayed on submission screen for Financial Institution business segment" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
					
			}
			
			else
			{
				CustomReporting.logReport("","", "Public business indicator check box is not displayed on submission screen for Financial Institution business segment" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				
			}*/
			
			/*if(func._isVisible(getElement(chk_Pravite)))
			{
				CustomReporting.logReport("","", "Pravite business indicator check box is displayed on submission screen for Financial Institution business segment" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
					
			}
			
			else
			{
				CustomReporting.logReport("","", "Pravite business indicator check box is not displayed on submission screen for Financial Institution business segment" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				
			}
			
			if(func._isVisible(getElement(DisplayOrderPublic)))
			{
				CustomReporting.logReport("","", "The Public business indicator check box is placed next to 'Everest Company' field on submission screen" + 
						"" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
					
			}
			
			else
			{
				CustomReporting.logReport("","", "The Public business indicator check box is not placed next to 'Everest Company' field on submission screen" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				
			}
			Thread.sleep(2000);
			if(func._isVisible(getElement(DisplayOrderPrivate)))
			{
				CustomReporting.logReport("","", "The Private business indicator check box is placed next to 'Everest Company' field on submission screen" + 
						"" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
					
			}
			
			else
			{
				CustomReporting.logReport("","", "The Private business indicator check box is not placed next to 'Everest Company' field on submission screen" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				
			}
			
			
			if(!func._isChecked(getElement(chk_Public)))
			{
				CustomReporting.logReport("","", "Verified that Public check box  is not selected defaultly" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
					
			}
			
			else
			{
				CustomReporting.logReport("","", "Public check box  is selected defaultly" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				
			}
			if(!func._isChecked(getElement(chk_Pravite)))
			{
				CustomReporting.logReport("","", "Verified that Pravite check box is not selected defaultly" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
					
			}
			
			else
			{
				CustomReporting.logReport("","", "Pravite check box is selected defaultly" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
				
			}

		Thread.sleep(2000);
		String chkPubliclocator=getElement(chk_Public).toString();
		//String chkPubliclocator=func.getCustomElementName(getElement(chk_Public));
		Thread.sleep(2000);
		String Publicxpath=chkPubliclocator.split("\\{")[1];
		String chk_Publicxpath=Publicxpath.replace("}", "");
//		if(getWebDriver().findElement(By.xpath(chk_Public)).isEnabled())
		if(getWebDriver().findElement(By.xpath(chk_Publicxpath)).isEnabled())
		{
			CustomReporting.logReport("","", "Public Business Indicator check box is enable ",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}
		else
		{
			CustomReporting.logReport("","", "Public Business Indicator check box is not enable" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
		String chk_Pravitelocator=getElement(chk_Pravite).toString();
		//String chk_Pravitelocator=func.getCustomElementName(getElement(chk_Pravite));
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
		
		}
		
		if(!func._isVisible(getElement(isMandatroychkPublic)))
		{
			CustomReporting.logReport("","", "Public business indicator check box is displayed as non madatory field on submission screen for Financial Institution business segment" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				
		}
		
		else
		{
			CustomReporting.logReport("","", "Public business indicator check box is not displayed as non madatory field on submission screen for Financial Institution business segment" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		
			
		}
		if(!func._isVisible(getElement(isMandatroychkPrivate)))
		{
			CustomReporting.logReport("","", "Private business indicator check box is displayed as non madatory field on submission screen for Financial Institution business segment" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				
		}
		
		else
		{
			CustomReporting.logReport("","", "Private business indicator check box is not displayed as non madatory field on submission screen for Financial Institution business segment" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
			
		}
		*/
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
	}
	
	
	@Override
	public void Verify_RenSub_EffDate_ExpDate (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataIssuePolicy = PageDataManager.instance().getPageData("IssuePolicy",tcID);
		int offset= Integer.valueOf(dataIssuePolicy.getData("PolicyExpirationDate").split("-")[0].trim());
    	String OptValue=dataIssuePolicy.getData("PolicyExpirationDate").split("-")[1].trim();
    	String strSubEffDate=func._getAttributeValue(getElement(dat_SubmissionEffectiveDate), "value", softAssert);
    	String actSubExpDate=func._getAttributeValue(getElement(dat_SubmissionExpaireDate), "value", softAssert);
		if(strSubEffDate.equals(func.Date_Manipulation("",OptValue, offset)))
		 {
			CustomReporting.logReport("","","Renewal submission effective date is displaying as prior term expiration date while renewal the submission and its value on UI '"+strSubEffDate+"'" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		 }
		else
		{
			CustomReporting.logReport("","", "Renewal submission effective date is not displaying as prior term expiration date while renewal the submission and its value on UI '"+strSubEffDate+"'"  + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();
				
		}
		String expSubExpDate=func.Date_Manipulation(func.Date_Manipulation("",OptValue, offset), "Year", 1);
		if(actSubExpDate.equals(expSubExpDate))
		 {
			CustomReporting.logReport("","","The submission expiration date is annualized based upon the effective date and  its value on UI '"+actSubExpDate+"'" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		 }
		else
		{
			CustomReporting.logReport("","", "The submission expiration date is not annualized based upon the effective date and  its value on UI' "+actSubExpDate+"'" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();
		}
		
	
	}
	
	@Override
	public void Verify_Submission_Field_Charactorstic (String tcID, SoftAssert softAssert) throws Exception
	{
		if(func._checkAttributeValue(getElement(txt_SubDescription), "maxlength", "30", softAssert))
		{
			CustomReporting.logReport("","","Verified that the Description field accepts"+ func._getAttributeValue(getElement(txt_SubDescription), "maxlength", softAssert)+ " characters" + 
					"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}
		else
		{
			CustomReporting.logReport("","", "The Description field is accepting " + func._getAttributeValue(getElement(txt_SubDescription), "maxlength", softAssert)+ " characters" + 
					"" + "", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);

		}
		
		if(func._checkAttributeValue(getElement(txt_SubDescription), "type", "text", softAssert))
		{
			CustomReporting.logReport("","","Verified that the Description field is text and takes alpha numeric values"+ 
					"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}
		else
		{
			CustomReporting.logReport("","", "The Description field is not  text and not taking alpha numeric values", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);

		}
		
		if(!func._isVisible(getElement(isMandatroySubDesc)))
		{
			CustomReporting.logReport("","", "Submission Description text box is displayed as non madatory field on submission screen" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				
		}
		
		else
		{
			CustomReporting.logReport("","", "Submission Description text box is not displayed as non madatory field on submission screen" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		
			
		}
		
		if(func._isVisible(getElement(txt_SubDescription)))
		{
			CustomReporting.logReport("","", "Submission Description Text box is Visible for all Business Segment on submission screen" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				
		}
		
		else
		{
			CustomReporting.logReport("","", "Submission Description Text box is not Visible for all Business Segment on submission screen " + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
		
	}
	@Override
	public void Verify_OFACSearch_Screen_Renewal (String tcID, SoftAssert softAssert) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),100L);
		Thread.sleep(2000);
		 func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		PageData dataAccount = PageDataManager.instance().getPageData("Account",tcID);
		PageData dataSearch = null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
		}
		_click(getElement(btn_ProcessNextYearRenewal));
	
		Thread.sleep(3000);

		try
		{
			Alert alrt=getWebDriver().switchTo().alert();
			String popMsg=alrt.getText().trim();
			if(popMsg.equals("Are you sure you want to create this submission?"))
			{
			CustomReporting.logReport("","", "Verified that when user click on 'Precess Next Year Renewal' button on submission screen then Confirmation message is displayed with 'OK' and 'Cancel' button" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
					
			}
		}
		catch(Exception ex)
		{
			CustomReporting.logReport("","", "Confirmation message is not displayed  when user click on 'Precess Next Year Renewal' button on submission screen. " + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();
			
		}
		
		func._alertHandler(getWebDriver(), "Ok");
		Thread.sleep(4000);
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if(func._isVisible(getElement(OFACSearchReq)))
		{
			CustomReporting.logReport("","", "Verified that 'Required OFAC search' screen is displayed when user click on 'OK' button on confirmation message." + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			if(func._isVisible(getElement(btn_OFACSearch))&&func._isVisible(getElement(OFC_insureName)))
			{
				CustomReporting.logReport("","", "Verified that 'OFAC search' button and 'InsuredName' textbox are displayed on required OFAC search screen." + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			}
			else
			{
				CustomReporting.logReport("","", "'OFAC search' button and 'InsuredName' textbox are not displayed on required OFAC search screen. " + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				throw new RuntimeException();
				
			}
			
		}
		else
		{
			CustomReporting.logReport("","", "'Required OFAC search' screen is not displayed when user click on 'OK' button on confirmation message. " + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();
		}
		if(getElement(OFC_insureName).getAttribute("value").trim().equals(dataAccount.getData("InsuredName")))
		{
			CustomReporting.logReport("","", "Verified that by default Insured name '"+dataAccount.getData("InsuredName")+"' is displayed on Required OFAC search screen" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			CustomReporting.logReport("","", "The default Insured name is not displayed on Required OFAC search screen" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
		
		if(func._isEnabled(getElement(OFC_insureName)))
		{
			CustomReporting.logReport("","", "Verified that Insured Name is displayed in Editable format on Required OFAC search screen." + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			CustomReporting.logReport("","", "The Insured Name is not displayed in Editable format on Required OFAC search screen." + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
		if(func._isVisible((getElement(InsuredNameReq))))
		{
			CustomReporting.logReport("","", "Verified that Insured Name is dispalyed as Mandatory on the OFAC search screen" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			CustomReporting.logReport("","", "Verified that Insured Name is not dispalyed as Mandatory on the OFAC search screen" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
		_click(getElement(btn_OFACSearch));
		func._waitFor(getElement(OFACSearchResults), 100, WAIT_FOR.VISIBLE, "");
		Thread.sleep(3000);
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if(func._isVisible((getElement(OFACSearchResults))))
		{
			CustomReporting.logReport("","", "Verified that when user click on OFAC Search button then user is redirected to the OFAC Search result screen for the given insured name" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			CustomReporting.logReport("","", "User is not redirected to the OFAC Search result screen when user click on OFAC Search button" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();
			
		}
		
		
		if(func._isVisible((getElement(btn_OFACSearchProcessRenewal))))
		{
			CustomReporting.logReport("","", "Verified that Process Next Year renewal button is displayed on OFAC search result screen." + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			CustomReporting.logReport("","", "The Process Next Year renewal button is not displayed on OFAC search result screen." + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();
			
		}
		
		_click(getElement(btn_OFACSearchProcessRenewal));
		Thread.sleep(5000);
		func._waitFor(getElement(msg_SubmissionRenewal), 500, WAIT_FOR.VISIBLE, "");

		if(func._checkAttributeValue(getElement(msg_SubmissionRenewal),"TEXT","Renewal Processed Successfully",softAssert))
		{
			CustomReporting.logReport("","", "Verified that user is redirected to the Submission screen with Renewal details when they click on Process Next Year Renewal button" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			CustomReporting.logReport("","", "Verified that Renewal Precessed Successfully message is displayed on Submission." + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			CustomReporting.logReport("","", "user is not redirected to the Submission screen with Renewal details when they click on Process Next Year Renewal button" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
			CustomReporting.logReport("","", "Renewal Precessed Successful message is not displayed on Submission" + 
				"" + 
				"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		
		}
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		int Subpreviousmod=Integer.valueOf(dataSearch.getData("SubmissionNumber").split("-")[1].trim());
		int ExpSubmod=Subpreviousmod+1;
		String SubNum=func._getAttributeValue(getElement(tab_TabSubmission), "TEXT", softAssert);
		func._writeToExcel("Search", "Renewal_Sub_Num",SubNum.split(":")[1].trim(), tcID);
		int ActSubmod=Integer.valueOf(SubNum.split("-")[1].trim());
		
		if(ExpSubmod==ActSubmod)
		{
			CustomReporting.logReport("","", "Verified that submission number is displayed with new mode "+ ActSubmod+ " on the Renewal submission screen"+"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			CustomReporting.logReport("","", "The submission number is not displayed with new mode on the Renewal submission screen" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
	
		int Accpreviousmod=Integer.valueOf(dataSearch.getData("AccountNumber").split("-")[1]);
		int ExpAccbmod=Accpreviousmod+1;
		String AccountNum=func._getAttributeValue(getElement(tab_AccountNum), "TEXT", softAssert);

		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			func._writeToExcel("QASearch", "Renewal_Acc_num",AccountNum.split(":")[1].trim(), tcID);
		 }
		else
		{
			func._writeToExcel("Search", "Renewal_Acc_num",AccountNum.split(":")[1].trim(), tcID);
		}
		
		int ActAccmod=Integer.valueOf(AccountNum.split("-")[1].trim());
		if(ExpAccbmod==ActAccmod)
		{
			CustomReporting.logReport("","", "Verified that Account number is displayed with new mode "+ ActAccmod+ " on the Renewal submission screen"+"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			CustomReporting.logReport("","", "The Account number is not displayed with new mode on the Renewal submission screen" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
		
		
		
		
	}
	
	@Override
	public void sendTo_PD (String tcID, SoftAssert softAssert) throws Exception
	{
		int intloopCount=0;
		func._waitForPageToLoad(getWebDriver(),100L);
		do
		{
			if(func._isVisible(getElement(btn_SendToPD)))
			{
				break;
				
			}
			Thread.sleep(5000);
			intloopCount=intloopCount+1;
		}while(intloopCount<20);
		func._waitFor(getElement(btn_SendToPD), 200, WAIT_FOR.VISIBLE);
		Thread.sleep(2000);
		_click(getElement(btn_SendToPD));
		func._waitForPageToLoad(getWebDriver(),500L);
		Thread.sleep(5000);
		int intCount=0;
		do {
			if(func._isVisible(getElement(txt_PDQuoteNumber)))
			{
				break;
			}
			Thread.sleep(5000);
			intCount=intCount+1;
		}while(intCount<10);
		if(func._isVisible(getElement(btn_SendToPD)))
		{
			_click(getElement(btn_SendToPD));
			func._waitForPageToLoad(getWebDriver(),500L);
			Thread.sleep(5000);
		}
		
		func._waitFor(getElement(txt_PDQuoteNumber), 200, WAIT_FOR.VISIBLE);
		Thread.sleep(5000);

		
		
		String PDQuoteNumber=func._getAttributeValue(getElement(txt_PDQuoteNumber), "value", softAssert);
		if(!PDQuoteNumber.equals(""))
		{
			func._writeToExcel("TestResult", "QuoteNumber",PDQuoteNumber, tcID);
			func._writeToExcel("PD", "PDQuoteNumber",PDQuoteNumber, tcID);
			CustomReporting.logReport("","", "Verified'Quote Num' received from PD displayed in ESCAPE Submission page :" + PDQuoteNumber,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			CustomReporting.logReport("","", "Quote Number is not received from PD and its not displayed in ESCAPE submission page." + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();
			
		}	
		
		if(PDQuoteNumber.split("-")[1].trim().equals("1"))
		{
			CustomReporting.logReport("","", "Verify a Quote Number with Sequence  is received from PD and displayed in ESCAPE Submission page " + PDQuoteNumber,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			CustomReporting.logReport("","", "Quote Number with Sequence  is not received from PD and displayed in ESCAPE Submission page" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
			
		}
			
		
		if(func._checkAttributeValue(getElement(msg_SubmissionSuccessmsg), "TEXT", "The submission was successfully sent to PD", softAssert))
		{
			CustomReporting.logReport("","", "The submission is successfully sent to PD and the PD quote Number is " + PDQuoteNumber,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			CustomReporting.logReport("","", "The submission is not successfully sent to PD" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();
			
		}
		
		
		 func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
	}
	
	@Override
	public void verify_SendTo_PD_buttion (String tcID, SoftAssert softAssert) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(), 100L);
		Thread.sleep(5000);
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
		int intloopCount=0;
		
		String strBS=dataNewSubmission.getData("BusinessSegment");
		String strLOB=dataNewSubmission.getData("SubmissionLOB");
		
		if(!func._isVisible(getElement(btn_SendToPD)))

		{
			CustomReporting.logReport("","", "Send to rating button is not present in Escape for BS "+strBS + "and LOB "+strLOB,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			CustomReporting.logReport("","", "Send to rating button is present in Escape for BS "+strBS + "and LOB "+strLOB, "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();
			
		}	
		 func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
	}
	

	@Override
	public void verify_AutoPopulated_Priority (String tcID, SoftAssert softAssert) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),200L);
		Thread.sleep(2000);
		PageData dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
		WebElement wePriority=(WebElement)getElement("txt_Priority").getNative();
		String ActPriority=wePriority.getAttribute("value").trim();
		
		if(ActPriority.equals(dataNewSubmission.getData("Priority").trim()))
		{
			CustomReporting.logReport("","", " Priority field is auto populated with the value " + ActPriority + "as per the requirement",StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			CustomReporting.logReport("","", "Priority field is not auto populated with the value " + dataNewSubmission.getData("Priority"), "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			throw new RuntimeException();
			
		}
		
		
		 func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
	}
	
//	New Method
	@Override
	public void verify_Submission_Currency_PredominantState_FieldValue(String tcID, SoftAssert softAs) throws Exception {
		Boolean flagCurrency = func._isVisible(getElement(lst_Currency));

		if(flagCurrency) {
			CustomReporting.logReport("","", "The Submission page Field Currency is Available", "", 
					StepStatus.SUCCESS,new String[] { }, System.currentTimeMillis(), null);
		}
		else {
			CustomReporting.logReport("","", "The Submission page Field Currency is NOT Available", "", 
					StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		}
		
		WebElement weRu = (WebElement)getElement(Sld_DefaultCurrency).getNative();
		String strRu = weRu.getText();
		System.out.println("Text of Currency:" +strRu);
		//if(func._getAttributeValue(getElement(Sld_DefaultCurrency), "TEXT").equalsIgnoreCase("USD")) {
		if(strRu.equalsIgnoreCase("USD")) {
			CustomReporting.logReport("","", "The Submission page Field Currency have the Default value 'USD'", "", 
					StepStatus.SUCCESS,new String[] { }, System.currentTimeMillis(), null);
		}
		else {
			CustomReporting.logReport("","", "The Submission page Field Currency doesn't have the Default value 'USD'", "", 
					StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		}
		
		if(!func._isVisible(getElement(txt_CurrencyMandatory))) {
			CustomReporting.logReport("","", "'Currency' is not a mandatory field", "", 
					StepStatus.SUCCESS,new String[] { }, System.currentTimeMillis(), null);
		}
		else {
			CustomReporting.logReport("","", "'Currency' is a mandatory field", "", 
					StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		}
		
			WebElement westate = (WebElement)getElement(Sld_DefaultPredominantState).getNative();
			String strstate = westate.getText();
			System.out.println("Text of Predominent state:" +strRu);

		//if(func._getAttributeValue(getElement(lst_PredominantState), "TEXT").equalsIgnoreCase("Not Applicable")) {
		if(strstate.equalsIgnoreCase("Not Applicable")) {
			CustomReporting.logReport("","", "The Submission page Field PredominantState have the Default value 'Not Applicable'", "", 
					StepStatus.SUCCESS,new String[] { }, System.currentTimeMillis(), null);
		}
		else {
			CustomReporting.logReport("","", "The Submission page Field PredominantState doesn't have the Default value 'Not Applicable'", "", 
					StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		}
	}

	@Override
	public void verify_SubmissionDetails_DB(String tcID, SoftAssert softAs) throws Exception {
		Thread.sleep(2000);
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		String environment = dataLogin.getData("Environment");

		

		/***Submission Data Validation***/
		//Submission UI Data
		Map<String, String> submissionUIDataMap = new LinkedHashMap<>();
		PageData dataAccount = PageDataManager.instance().getPageData("NewSubmission",tcID);
		String createdSubmissionID = dataAccount.getData("SubmissionNumber");
		submissionUIDataMap.put("SubmissionNumber", createdSubmissionID.split("-")[0]);
		submissionUIDataMap.put("SubmissionVersionNumber", createdSubmissionID.split("-")[1]);
		submissionUIDataMap.put("BusinessSegment", dataAccount.getData("BusinessSegment"));
		submissionUIDataMap.put("SubmissionStatus", dataAccount.getData("SubmissionStatus"));
		submissionUIDataMap.put("BranchOffice", dataAccount.getData("BusinessOffice"));
		//submissionUIDataMap.put("AffinityBusiness", dataAccount.getData(""));
		submissionUIDataMap.put("PredominantState", dataAccount.getData("PredominantState"));
		submissionUIDataMap.put("MarketSegment", dataAccount.getData("MarketSegment"));
		submissionUIDataMap.put("SubmissionType", dataAccount.getData("SubmissionType"));
		//submissionUIDataMap.put("ReceivedDate", dataAccount.getData("ReceivedDate"));
		submissionUIDataMap.put("Distribution", dataAccount.getData("Distribution"));
		//submissionUIDataMap.put("SubmissionEffectiveDate", dataAccount.getData("SubmissionEffectiveDate"));
		//submissionUIDataMap.put("SubmissionExpirationDate", dataAccount.getData("SubmissionExpaireDate"));
		submissionUIDataMap.put("IncumbentCarrier",dataAccount.getData("IncumbentCarrier") );
		submissionUIDataMap.put("SubmittedLineOfBusiness", dataAccount.getData("SubmissionLOB"));
		submissionUIDataMap.put("PrimaryExcess", dataAccount.getData("PrimaryORExcess").substring(0, 1));
		submissionUIDataMap.put("ProductCoveragePeril", dataAccount.getData("SubmittedProduct"));
		submissionUIDataMap.put("Limit", dataAccount.getData("Limit"));
		submissionUIDataMap.put("RetentionAttachment", dataAccount.getData("RetentionAttachment"));
		submissionUIDataMap.put("ProducerName", dataAccount.getData("Producername"));
		submissionUIDataMap.put("ProducerOffice", dataAccount.getData("ProducerOffice"));
		submissionUIDataMap.put("UnderwriterName", dataAccount.getData("UWName"));
		submissionUIDataMap.put("UnderwritingAssistant", dataAccount.getData("UWAssistant"));
		submissionUIDataMap.put("Currency", dataAccount.getData("Currency"));
		//submissionUIDataMap.put("DateQuoted", dataAccount.getData("DateQuoted"));
		submissionUIDataMap.put("QuotedPremium", dataAccount.getData("QuotedPremium"));
							//submissionUIDataMap.put("QuotedLineOfBusiness", dataAccount.getData(""));
		submissionUIDataMap.put("NAICSCode", dataAccount.getData("NaicsCode"));
							//submissionUIDataMap.put("NDA", dataAccount.getData(""));
		Thread.sleep(2000);
		
		Map<String, String> submissionDBDataMap = new LinkedHashMap<>();
		LinkedHashMap<Integer, String[]> submissionDBDetails = 
				cFunc.getDataFromDB("select Submission_Nbr, Submission_Version_Nbr, BusinessSegmentKey, SubmissionStatusKey, BranchOfficeKey, "
						+ "AffinityBusinessKey, PredominantStateKey, MarketSegmentKey, SubmissionTypeKey, Submission_Received_Dt, "
						+ "DistributionChannelKey, Submission_Eff_Dt, Submission_Exp_Dt, Incumbent_Car_Non_Renewal, SubmittedLOBKey, "
						+ "Submitted_Excess_Primary, SubmittedBusSegLobIndProductCoveragePerilKey, Limit, Retention_Attachment, ProducerKey, "
						+ "ProducerOfficeKey, UnderwriterKey, UnderwriterAssistantKey, CurrencyCode, Submission_Quoted_Dt, Quoted_Premium_Amt, "
						+ "NAICS_CD from [EscapeDB].[dbo].[SUB_Submission] where "
						+ "Submission_Nbr='"+(createdSubmissionID.split("-")[0])+"' and Submission_Version_Nbr='"+(createdSubmissionID.split("-")[1])+"'", 
						27, "EscapeDB", "enicdb-stage");
		String[] submissionDBData = submissionDBDetails.get(0);
		submissionDBDataMap.put("SubmissionNumber", submissionDBData[0].toString());
		submissionDBDataMap.put("SubmissionVersionNumber", submissionDBData[1].toString());
		
		LinkedHashMap<Integer, String[]> businessSegmentDBDetails = 
				cFunc.getDataFromDB("Select Business_Segment_Desc from SUB_Business_Segment where BusinessSegmentKey='"+submissionDBData[2].toString()+"'",
						1, "EscapeDB", "enicdb-stage");
		submissionDBDataMap.put("BusinessSegment", (businessSegmentDBDetails.get(0))[0]);
		
		LinkedHashMap<Integer, String[]> submissionStatusDBDetails = 
				cFunc.getDataFromDB("select description from Submission_Status_Mapping where status_code='"+submissionDBData[3].toString()+"'",
						1, "EscapeDB", "enicdb-stage");
		submissionDBDataMap.put("SubmissionStatus", (submissionStatusDBDetails.get(0)[0]));
		
		LinkedHashMap<Integer, String[]> branchofficeDBDetails = 
				cFunc.getDataFromDB("select Branch_Office_Name from SUB_Branch_Office where BranchOfficeKey='"+submissionDBData[4].toString()+"'",
						1, "EscapeDB", "enicdb-stage");
		submissionDBDataMap.put("BranchOffice", (branchofficeDBDetails.get(0)[0]));
		
		//submissionDBDataMap.put("AffinityBusiness", submissionDBData[5].toString());

		LinkedHashMap<Integer, String[]> predominantStateDBDetails = 
				cFunc.getDataFromDB("select State_Province_Name from Sub_State where StateKey='"+submissionDBData[6].toString()+"'",
						1, "EscapeDB", "enicdb-stage");
		submissionDBDataMap.put("PredominantState", (predominantStateDBDetails.get(0)[0]));
		
		LinkedHashMap<Integer, String[]> marketSegmentDBDetails = 
				cFunc.getDataFromDB("select Market_Segment_Desc from SUB_Market_Segment where MarketSegmentKey='"+submissionDBData[7].toString()+"'",
						1, "EscapeDB", "enicdb-stage");
		submissionDBDataMap.put("MarketSegment", (marketSegmentDBDetails.get(0)[0]));

		LinkedHashMap<Integer, String[]> submissionTypeDBDetails = 
				cFunc.getDataFromDB("select Submission_Type_Desc from SUB_Submission_Type where SubmissionTypeKey='"+submissionDBData[8].toString()+"'",
						1, "EscapeDB", "enicdb-stage");
		submissionDBDataMap.put("SubmissionType",(submissionTypeDBDetails.get(0)[0]));
		
		//submissionDBDataMap.put("ReceivedDate", submissionDBData[9].toString());

		LinkedHashMap<Integer, String[]> distributionDBDetails = 
				cFunc.getDataFromDB("select Distribution_Channel_Desc from SUB_Distribution_Channel where DistributionChannelKey='"+submissionDBData[10].toString()+"'",
						1, "EscapeDB", "enicdb-stage");
		submissionDBDataMap.put("Distribution", (distributionDBDetails.get(0)[0]));
		
		//submissionDBDataMap.put("SubmissionEffectiveDate", submissionDBData[11].toString());
		//submissionDBDataMap.put("SubmissionExpirationDate", submissionDBData[12].toString());
		submissionDBDataMap.put("IncumbentCarrier", submissionDBData[13]);
		
		LinkedHashMap<Integer, String[]> submittedLineOfBusinessDBDetails = 
				cFunc.getDataFromDB("select LOB_Desc from SUB_LOB where LOBKey='"+submissionDBData[14].toString()+"'",
						1, "EscapeDB", "enicdb-stage");
		submissionDBDataMap.put("SubmittedLineOfBusiness", (submittedLineOfBusinessDBDetails.get(0)[0]));
		
		submissionDBDataMap.put("PrimaryExcess", submissionDBData[15].toString());
		submissionDBDataMap.put("ProductCoveragePeril", submissionDBData[16].toString());
		submissionDBDataMap.put("Limit", (submissionDBData[17].toString().split("\\."))[0]);
		submissionDBDataMap.put("RetentionAttachment", (submissionDBData[18].toString().split("\\."))[0]);
		submissionDBDataMap.put("ProducerName", submissionDBData[19].toString());
		submissionDBDataMap.put("ProducerOffice", submissionDBData[20].toString());
		
		LinkedHashMap<Integer, String[]> underwriterNameDBDetails = 
				cFunc.getDataFromDB("select Underwriter_Name from SUB_Underwriter where UnderwriterKey='"+submissionDBData[21].toString()+"'",
						1, "EscapeDB", "enicdb-stage");
		submissionDBDataMap.put("UnderwriterName", (underwriterNameDBDetails.get(0)[0]));
		
		LinkedHashMap<Integer, String[]> underwriterAssistantNameDBDetails = 
				cFunc.getDataFromDB("select Underwriter_Assistant_Name from SUB_Underwriter_Assistant where UnderwriterAssistantKey='"+submissionDBData[22].toString()+"'",
						1, "EscapeDB", "enicdb-stage");
		if(underwriterAssistantNameDBDetails.get(0)!=null) {
			submissionDBDataMap.put("UnderwritingAssistant", (underwriterAssistantNameDBDetails.get(0)[0]));
		}
		else {
			submissionDBDataMap.put("UnderwritingAssistant", "");
		}
		
		
		LinkedHashMap<Integer, String[]> currencyDBDetails = 
				cFunc.getDataFromDB("select AlphabeticCode from Currency where NumericCode='"+submissionDBData[23].toString()+"'",
						1, "EscapeDB", "enicdb-stage");
		submissionDBDataMap.put("Currency", (currencyDBDetails.get(0)[0]));
		
		//submissionDBDataMap.put("DateQuoted", submissionDBData[24].toString());
		submissionDBDataMap.put("QuotedPremium", (submissionDBData[25].toString().split("\\."))[0]);
		submissionDBDataMap.put("NAICSCode", submissionDBData[26].toString());
		
		CustomReporting.logReport("==== ESCAPE Submission UI validation against DB ==== ");
		
		for(String key : submissionUIDataMap.keySet()) {
			String valueUI = submissionUIDataMap.get(key);
			String valueDB = submissionDBDataMap.get(key);
			
			if(valueUI!=null && valueDB!=null) {
				if(valueUI.equalsIgnoreCase(valueDB)) {
					CustomReporting.logReport("","", "Created Submission Data for Key "+key+" the UI value "+valueUI+" and DB Value "+valueDB+" are Equal","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
				}
				else {
					CustomReporting.logReport("","", "Created Submission Data for Key "+key+" the UI value "+valueUI+" and DB Value "+valueDB+" are NOT Equal","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
				}
			}
			else {
				CustomReporting.logReport("Created Submision Data for Key "+key+" the UI value "+valueUI+" and DB Value "+valueDB);
			}
		}
	}
	
	@Override
	public void verify_FEINPopUp_MissedInAccountScreen(String tcID, SoftAssert softAs) throws Exception {
		func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(2000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
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
		if(func._isVisible(getElement(txt_FEINMissed)))
		{
			CustomReporting.logReport("","", "FEIN Pop up is displayed when missed to enter FEIN value in Account screen  and tried to create new submission","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);	
		}
		else
		{
			CustomReporting.logReport("","", "FEIN Pop up is not displayed when missed to enter FEIN value in Account screen  and tried to create new submission","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			throw new RuntimeException();
		
		}
		_click(getElement(btn_FEINCancel));
		func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(2000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		_click(getElement(btn_CreateThisSubmission));
		func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(2000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if(func._isVisible(getElement(txt_FEINMissed)))
		{
			CustomReporting.logReport("","", "The 'Cancel' button will allow the user to return to their incomplete submission, and will not allow them to create a new submission until the FEIN has been entered","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);	
		}
		else
		{
			CustomReporting.logReport("","", "The 'Cancel' button will allow the user to return to their incomplete submission, and it is allow them to create a new submission even if the FEIN has not been entered","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			throw new RuntimeException();
		
		}
		_setValue(getElement(txt_FEINMissed),dataNewSubmission.getData("FEIN"));
		Thread.sleep(2000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(btn_FEINSaved));
		func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(2000);
		 _click(getElement(btn_CreateThisSubmission));
		 func._alertHandler(getWebDriver(), "Ok");
		 func._waitForPageToLoad(getWebDriver(),100L);
		 //func._waitFor(getElement(msg_SubmissionSuccessmsg), 100, WAIT_FOR.VISIBLE, "");
		 Thread.sleep(5000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 WebElement weSussmsg=(WebElement)getElement(msg_SubmissionSuccessmsg).getNative();
		 
		  if(weSussmsg.getText().contains("Account & Submission information updated successfully"))
		  {
				CustomReporting.logReport("","", "Submission is created successfully after enter missed FEIN and Saveed","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);	
			}
			else
			{
				CustomReporting.logReport("","", "Submission is not created  after enter missed FEIN and Saveed","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
				throw new RuntimeException();
			
			}

		    func._waitForPageToLoad(getWebDriver(),50L);
		   WebElement el=(WebElement) getElement(tab_TabSubmission).getNative();
		   String getSubmissionNum=el.getText().split(":")[1];
	      
		   if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		    {
		    	func._writeToExcel("QANewSubmission", "SubmissionNumber",getSubmissionNum, tcID);	
		    	func._writeToExcel("QASearch", "SubmissionNumber",getSubmissionNum, tcID);

		    }
		    else
		    {
		    	func._writeToExcel("NewSubmission", "SubmissionNumber",getSubmissionNum, tcID);
		    	func._writeToExcel("Search", "SubmissionNumber",getSubmissionNum, tcID);
		    }
		
	}
	
	@Override
	public void Verify_CreditScroreField(String tcID, SoftAssert softAs) throws Exception 
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
   
    Thread.sleep(3000);
       if(!dataNewSubmission.getData("BusinessSegment").equals(""))
    	{
    		   _setValue(getElement(lst_BusinessSegment),dataNewSubmission.getData("BusinessSegment"));
    	}
         func._waitForPageToLoad(getWebDriver(),100L);
		 if(func._isVisible(getElement(txt_CreditScore)))
		 {
			 CustomReporting.logReport("","","Credit Score field is Displayed on the page" + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

		 }
		 else
		 {
			 CustomReporting.logReport("","","Credit Score field is not displayed on the page" + "" + 
						"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());	
		 }
			 
	     if(func._isEnabled(getElement(txt_CreditScore)))
	     {
			 CustomReporting.logReport("","","Credit Score field is Editable" + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

		 }
		 else
		 {
			 CustomReporting.logReport("","","Credit Score field is non-editable" + "" + 
						"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());	
		 }
		 if(func._isVisible(getElement(req_CreditScore)))
		 {
			 CustomReporting.logReport("","","Credit Score field is mandatory" + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

		 }
		 else
		 {
			 CustomReporting.logReport("","","Credit Score field is not mandatory" + "" + 
						"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());	
		 }
		 if(dataNewSubmission.getData("BusinessSegment").equals("Environmental") || dataNewSubmission.getData("BusinessSegment").equals("Excess Casualty")|| dataNewSubmission.getData("BusinessSegment").equals("Wholesale Casualty"))
	    		
			{
		    	Thread.sleep(1000);
		    	_setValue(getElement(txt_CreditScore),dataNewSubmission.getData("CreditScore"));
		    	Thread.sleep(1000);
			}
		    
		
	}
	@Override
	public void Verify_PriorityField(String tcID, SoftAssert softAs) throws Exception 
	{
		 if(func._isVisible(getElement(txt_Priority)))
		 {
			 CustomReporting.logReport("","","Priority field is displayed on the page" + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

		 }
		 else
		 {
			 CustomReporting.logReport("","","Priority field is not displayed on the page" + "" + 
						"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());	
		 }
		 if(!func._isEnabled(getElement(txt_Priority)))
		 {
			 CustomReporting.logReport("","","Priority field is non-editable on the page" + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		 }
		 else
		 {
			 CustomReporting.logReport("","","Priority field is editable on the page" + "" + 
						"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());	
		 }
	
		
	}


	@Override
	public void Verify_CurrentlyValuedLossRunsField(String tcID, SoftAssert softAs) throws Exception 
	{
		if(func._isVisible(getElement(lbl_CurrentlyValuedLoss)))
		 {
			 CustomReporting.logReport("","","Currently Valued Loss Runs field is displayed on the page" + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

		 }
		 else
		 {
			 CustomReporting.logReport("","","Currently Valued Loss Runs field is not displayed on the page" + "" + 
						"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());	
		 }
		 if(func._isVisible(getElement(req_CurrentlyValuedLoss)))
		 {
			 CustomReporting.logReport("","","Currently Valued Loss Runs field is mandatory" + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

		 }
		 else
		 {
			 CustomReporting.logReport("","","Currently Valued Loss Runs field is not mandatory" + "" + 
						"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());	
		 }
		 if(func._isVisible(getElement(radio_CurrentlyLossYes)))
		 {
			 CustomReporting.logReport("","","Currently Valued Loss Runs field is displayed with  option Yes" + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

		 }
		 else
		 {
			 CustomReporting.logReport("","","Currently Valued Loss Runs field is not displayed with  option Yes" + "" + 
						"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());	
		 }
		 if(func._isVisible(getElement(radio_CurrentlyLossNo)))
		 {
			 CustomReporting.logReport("","","Currently Valued Loss Runs field is displayed with  option No" + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

		 }
		 else
		 {
			 CustomReporting.logReport("","","Currently Valued Loss Runs field is not displayed with  option No" + "" + 
						"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());	
		 }
		
		
	}


	@Override
	public void Verify_EstimatedTargetPremiumField(String tcID, SoftAssert softAs) throws Exception 
	{
		if(func._isVisible(getElement(txt_EstimatedPremium)))
		{
			 CustomReporting.logReport("","","Estimated/Target Premium field is displayed on the page" + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

		 }
		 else
		 {
			 CustomReporting.logReport("","","Estimated/Target Premium field is not displayed on the page" + "" + 
						"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());	
		 }
		
	}


	@Override
	public void Verify_IncumbentCarrNonRenewalField(String tcID, SoftAssert softAs) throws Exception
	{
		PageData dataNewSubmission = null;
		boolean isMatched = true;
	 	PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
	    if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
	   {
		 dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID); 
	    }
	   else
	     {
		 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);	 
	   }
	   
	    String[] arrSubLob=null;
	    String[] arrincumbentNon=null;
		if(dataNewSubmission.getData("SubmissionLOB").contains(";"))
		{
			arrSubLob=dataNewSubmission.getData("SubmissionLOB").split(";");
		
		}
		if(dataNewSubmission.getData("IncumbentCarNonRenewal").contains(";"))
		{
			arrincumbentNon=dataNewSubmission.getData("IncumbentCarNonRenewal").split(";");
		
		}
	
		if(dataNewSubmission.getData("SubmissionLOB").contains(";"))
		{
	
			for(int i=0;i<arrSubLob.length;i++)
			{
				_setValue(getElement(lst_SubmissionLOB),arrSubLob[i]);
				func._waitForPageToLoad(getWebDriver(),50L);
				if(!arrSubLob[i].equalsIgnoreCase("Workers Comp"))
				{
				

				if(func._isVisible(getElement(lst_IncumbentCarNonRenewal)))
				{
					 CustomReporting.logReport("","","Incumbent Carrier Non-Renewal field is  displayed on the page" + "" + 
								"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

				}
				else
				{
					 CustomReporting.logReport("","","Incumbent Carrier Non-Renewal field is not displayed on the page" + "" + 
								"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());	
				
				}
				if(func._isVisible(getElement(req_IncumbentCarNonRenewal)))
				{
					 CustomReporting.logReport("","","Incumbent Carrier Non-Renewal field is mandatory" + "" + 
								"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

				}
				else
				{
					 CustomReporting.logReport("","","Incumbent Carrier Non-Renewal field is not mandatory" + "" + 
								"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());	
				
				}
				String[] valueDrop =func._getValueDropDownBox(getElement(lst_IncumbentCarNonRenewal));
				for(int j =0;j<arrincumbentNon.length;j++)
				{
					if(valueDrop!=null && arrincumbentNon!=null)
					{
						if(!valueDrop[j+1].equals(arrincumbentNon[j]))
						{
							isMatched=false;
							CustomReporting.logReport("","","Dropdown values are not present" + "" + 
									"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());	
							
						}
						
					}
				 }
				if(isMatched)
        		{
					CustomReporting.logReport("","", "All Dropdown Values Present","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
					
        		}
				}
				
				
				else
				{
					CustomReporting.logReport("","","Incumbent Carrier Non-Renewal field is not displayed on the page" + "" + 
							"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

				}
			}
		}
		
		
	}


	@Override
	public void Verify_copySubmisssionField(String tcID, SoftAssert softAs) throws Exception 
	{
		if(func._isVisible(getElement(btn_CopySubmission)))
		{
			 CustomReporting.logReport("","","Copy Submission field is displayed on the page" + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	

		 }
		 else
		 {
			 CustomReporting.logReport("","","Copy Submission field is not displayed on the page" + "" + 
						"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());	
		 }
		
	}
	
		@Override
	public void verify_OnlySubmission_InBothDB(String tcID, SoftAssert softAs, String DBServer) throws Exception {
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 PageData dataSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
	     LinkedHashMap<Integer, String[]>SubmissionDHWDBvalues =null;
	     LinkedHashMap<Integer, String[]> CurrencyDBvalues =null;
	     Map<String, String> newBusinessUIDataMap = new LinkedHashMap<>();
	     Map<String, String> newBusinessSubmissionDBDataMap = new LinkedHashMap<>();
	     String CurrencyCode = null ;
	     Boolean isMatched =true;
	     
	     String  SubmissionNumber = dataSubmission.getData("SubmissionNumber").split("-")[0];
	     newBusinessUIDataMap.put("SubmissionNumber", SubmissionNumber);
	     
	     try
	     {
	       if(DBServer.equalsIgnoreCase("EscapeDB"))
	       {
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		   SubmissionDHWDBvalues =cFunc.getDataFromDB("SELECT Submission_Nbr,CurrencyCode,NAICS_CD,SIC_Cd FROM [EscapeDB].[dbo].[SUB_Submission]  WHERE Submission_Nbr ='"+SubmissionNumber+"'", 4, "EscapeDB","enicdb-dev\\enic_qa");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	SubmissionDHWDBvalues =cFunc.getDataFromDB("SELECT Submission_Nbr,CurrencyCode,NAICS_CD,SIC_Cd FROM [EscapeDB_SIT].[dbo].[SUB_Submission]  WHERE Submission_Nbr ='"+SubmissionNumber+"'", 4, "EscapeDB_SIT","ENICDB-STAGE");
	            	
	            }
	            else
	            {
	            	SubmissionDHWDBvalues =cFunc.getDataFromDB("SELECT Submission_Nbr,CurrencyCode,NAICS_CD,SIC_Cd FROM [EscapeDB].[dbo].[SUB_Submission]  WHERE Submission_Nbr ='"+SubmissionNumber+"'", 4, "EscapeDB","ENICDB-STAGE");
	            }
	       }
	       if(DBServer.equalsIgnoreCase("DWH"))
	       {
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		   SubmissionDHWDBvalues =cFunc.getDataFromDB("SELECT Submission_Nbr,CurrencyCode,NAICS_CD,SIC_Cd  FROM [IRF_EscapeDB].[dbo].[HST_SUB_Submission]  WHERE Submission_Nbr ='"+SubmissionNumber+"'", 4, "IRF_EscapeDB","ENDWSQLS2");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	SubmissionDHWDBvalues =cFunc.getDataFromDB("SELECT Submission_Nbr,CurrencyCode,NAICS_CD,SIC_Cd  FROM [IRF_EscapeDB].[dbo].[HST_SUB_Submission]  WHERE Submission_Nbr ='"+SubmissionNumber+"'", 4, "IRF_EscapeDB", "ENDWSQLS");
	            }
	            else
	            {
	            	SubmissionDHWDBvalues =cFunc.getDataFromDB("SELECT Submission_Nbr,CurrencyCode,NAICS_CD,SIC_Cd  FROM [IRF_EscapeDB].[dbo].[HST_SUB_Submission]  WHERE Submission_Nbr ='"+SubmissionNumber+"'", 4, "IRF_EscapeDB", "ENDWSQLS");
	            }
	       }
	       String[] SubmissionStageDHWDBvalues1;
	       SubmissionStageDHWDBvalues1=SubmissionDHWDBvalues.get(0);
	       newBusinessSubmissionDBDataMap.put("SubmissionNumber", SubmissionStageDHWDBvalues1[0]);
	       newBusinessSubmissionDBDataMap.put("Currency", SubmissionStageDHWDBvalues1[1]);
	       CurrencyCode = newBusinessSubmissionDBDataMap.get("Currency");
	       for(String key : newBusinessUIDataMap.keySet())
			{
				String valueUI = newBusinessUIDataMap.get(key);
				String valueDB = newBusinessSubmissionDBDataMap.get(key);
				
				if(valueUI!=null && valueDB!=null)
				{
					if(!(valueUI.equalsIgnoreCase(valueDB)))
					{

						isMatched=false;
						CustomReporting.logReport("","", "Created Submission Data for  "+key+" the UI value "+valueUI+" and DB Value "+valueDB+" are NOT Equal","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					}
				}
				else {
					CustomReporting.logReport("Created Submission Data for  "+key+" the UI value "+valueUI+" and DB Value "+valueDB);
				}
			}
			if(isMatched)
			{
				CustomReporting.logReport("","", "All Submission Details Matched","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
				
			}
		}
	catch(Exception e)
	{   
		 CustomReporting.logReport("","", "Submission created in stage env is not exist in the DWH DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	//throw new RuntimeException(); 
		 
	}
	     
	     try
	     {
	            if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	            	CurrencyDBvalues =cFunc.getDataFromDB("SELECT AlphabeticCode from EscapeDB.dbo.Currency  WHERE NumericCode ='"+CurrencyCode+"'", 1, "EscapeDB","enicdb-dev\\enic_qa");	 
	             }
	            else
	            {
	            	CurrencyDBvalues =cFunc.getDataFromDB("SELECT AlphabeticCode from EscapeDB.dbo.Currency  WHERE NumericCode ='"+CurrencyCode+"'", 1, "EscapeDB","ENICDB-STAGE");
	                   
	             }
	            String[] CurrencyStageDHWDBvalues1;
	            CurrencyStageDHWDBvalues1=CurrencyDBvalues.get(0);
	             	if(CurrencyStageDHWDBvalues1[0].trim().equals(dataSubmission.getData("Currency")))
	                   {
	                          CustomReporting.logReport("","", "Currency field in stage env is exist in the DB",StepStatus.REPORT,new String[] { },System.currentTimeMillis());     
	                          
	                   }
	                   else
	                   {
	                          CustomReporting.logReport("","", "Currency filed in stage env is not exist in the DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	                          //throw new RuntimeException();
	                   }
	           
	      }
	      catch(Exception e)
	      {   
	     	 CustomReporting.logReport("","", "Currency filed in stage env is not exist in the DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	            	 
	      }    
	     
	     
	     
		
	}
	
	@Override
	public void verify_NAISC_SICFiled_Submission(String tcID, SoftAssert softAs, String DeviceName) throws Exception {
		 PageData dataNewSubmission = null;
		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 if(func._isVisible(getElement(txt_NaicsCode)) && func._isVisible(getElement(txt_SICCode)))
		    {
		    	CustomReporting.logReport("","", "'SIC' and 'NAICS' fields are displayed and not overwritten in Submission screen",StepStatus.REPORT,new String[] { },System.currentTimeMillis());     
	            
	        }
	        else
	        {
	               CustomReporting.logReport("","", "'SIC' and 'NAICS' fields are not displayed and not overwritten in Submission screen","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	        }

	}
	
	@Override
	public void verify_LOBValue_Submission(String tcID, SoftAssert softAs, String ActionType) throws Exception {
		
		PageData dataSubmission = null;
		PageData datalogin = PageDataManager.instance().getPageData("Login",tcID);
		 
		if(ActionType.trim().equalsIgnoreCase("new"))
		{
			if(datalogin.getData("Environment").equalsIgnoreCase("QA"))
			{
				dataSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
			}
			else
			{
			 dataSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
			}
		}
		if(ActionType.trim().equalsIgnoreCase("edit"))
		{
			if(datalogin.getData("Environment").equalsIgnoreCase("QA"))
			{
				dataSubmission = PageDataManager.instance().getPageData("QAEditSubmission",tcID);
			}
			else
			{
			 dataSubmission = PageDataManager.instance().getPageData("EditSubmission",tcID);
			}
			
		}
		
		WebElement weLOB=(WebElement)getElement(lst_SelectedSubmissionLOB).getNative();
		String actLOBValue=weLOB.getText().trim();
		 if(actLOBValue.equalsIgnoreCase(dataSubmission.getData("SubmissionLOB")))
		    {
		    	CustomReporting.logReport("","", "Actual value of LOB '"+actLOBValue +"' is matched with expected value '"+dataSubmission.getData("SubmissionLOB")+"' for the submission status "+dataSubmission.getData("SubmissionStatus"),StepStatus.REPORT,new String[] { },System.currentTimeMillis());   
	            
	        }
	        else
	        {
	               CustomReporting.logReport("","",  "Actual value of LOB '"+actLOBValue +"' is not matched with expected value '"+dataSubmission.getData("SubmissionLOB")+"'n for the submission status"+dataSubmission.getData("SubmissionStatus"),"", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	        }
		 
		 
		 if(dataSubmission.getData("SubmittedProduct").contains(";"))
		 {
			 List<String> actualSubProducts;
			 List<String> ExpSubProducts;
			 String strActSubProduct="";
			 actualSubProducts=func._getValueDropDownBoxAslist(getElement(lst_SubmittedProduct));
			 for(int i=0;i<actualSubProducts.size();i++)
			 {
				 strActSubProduct= strActSubProduct + actualSubProducts.get(i)+";";
			 }
			 
			 ExpSubProducts=func._getDataAsList(tcID,"NewSubmission", "Verify_Subproduct",softAs);
			boolean isSubProdictsmatched= func._validateDropdownValues(getElement(lst_SubmittedProduct),ExpSubProducts,false,true, softAs); 
			if(isSubProdictsmatched)
				{
			    	CustomReporting.logReport("","", "Actual value of  Product/Coverage/Peril  '"+strActSubProduct +"' are matched with expected value '"+dataSubmission.getData("Verify_Subproduct")+"' for the submission status "+dataSubmission.getData("SubmissionStatus"),StepStatus.REPORT,new String[] { },System.currentTimeMillis());   
		            
		        }
		        else
		        {
		               CustomReporting.logReport("","",  "Actual value of  Product/Coverage/Peril  '"+strActSubProduct +"' are not matched with expected value '"+dataSubmission.getData("Verify_Subproduct")+"' for the submission status"+dataSubmission.getData("SubmissionStatus"),"", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
		        }
	 
		 
		 }
		 	
		 else
		 {
			 WebElement weSubmittedproduct=(WebElement)getElement(lst_SelectedSubmittedProduct).getNative();
				String Submittedproduct=weSubmittedproduct.getText().trim();
				
				 if(Submittedproduct.equalsIgnoreCase(dataSubmission.getData("SubmittedProduct")))
				    {
				    	CustomReporting.logReport("","", "Actual value of  Product/Coverage/Peril '"+Submittedproduct +"' is matched with expected value '"+dataSubmission.getData("Verify_Subproduct")+"' for the submission status "+dataSubmission.getData("SubmissionStatus"),StepStatus.REPORT,new String[] { },System.currentTimeMillis());   
			            
			        }
			        else
			        {
			               CustomReporting.logReport("","",  "Actual value of  Product/Coverage/Peril '"+Submittedproduct +"' is not matched with expected value '"+dataSubmission.getData("Verify_Subproduct")+"'n for the submission status"+dataSubmission.getData("SubmissionStatus"),"", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			        }
			 
		 }
		
		 	
		 	

	}
	
	

	@Override
	public void verify_PD_Input_Output_XML(String tcID, SoftAssert softAs,String SubType) throws Exception {
		
		
		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 PageData daDBXmlRef = PageDataManager.instance().getPageData("XML_Tag_Ref",tcID);
		 PageData dataNewSubmission=null;
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			 if(SubType.equalsIgnoreCase("edit"))
			 {
				 dataNewSubmission = PageDataManager.instance().getPageData("QAEditSubmission",tcID); 
				 if(!dataNewSubmission.getData("Ref_TC_ID").equals(""))
				 {
					 dataNewSubmission = PageDataManager.instance().getPageData("QAEditSubmission",dataNewSubmission.getData("Ref_TC_ID")); 
				 }
			 }
			 else
			 {
				 dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
				 if(!dataNewSubmission.getData("Ref_TC_ID").equals(""))
				 {
					 dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",dataNewSubmission.getData("Ref_TC_ID")); 
				 }
			 }

		 }
		 else
		 {
			 if(SubType.equalsIgnoreCase("edit"))
			 {
				 dataNewSubmission = PageDataManager.instance().getPageData("EditSubmission",tcID);
				 if(!dataNewSubmission.getData("Ref_TC_ID").equals(""))
				 {
					 dataNewSubmission = PageDataManager.instance().getPageData("EditSubmission",dataNewSubmission.getData("Ref_TC_ID")); 
				 }
			 }
			 else
			 {
				 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);	 
				 if(!dataNewSubmission.getData("Ref_TC_ID").equals(""))
				 {
					 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",dataNewSubmission.getData("Ref_TC_ID")); 
				 }
			 }
				 
		 }
	    
		 
		 
		 LinkedHashMap<Integer, String[]>SubmissionDBXMLLogs =null;
		 LinkedHashMap<Integer, String[]>SubmissionDBLogs =null;
		 Map<String, String> newSubmissionDBDataMap = new LinkedHashMap<>();
	     Map<String, String> newSubmissionDBXMLDataMap = new LinkedHashMap<>();
	     Boolean isMatched =true;
	     String  SubmissionNumber ="";
	     
	     if(SubType.equalsIgnoreCase("Sister"))
	     {
	    	 SubmissionNumber = dataNewSubmission.getData("Sister_Sub_num").split("-")[0];
	     }
	     else
	     {
	    	   SubmissionNumber = dataNewSubmission.getData("SubmissionNumber").split("-")[0]; 
	     }
	     try
	     {
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		   String sqlQury="select sub.Submission_Nbr, sub.Submission_Version_Nbr,l.* from escapedb..sub_pd_log l inner join EscapeDB..SUB_Submission sub on l.SubmissionKey=sub.SubmissionKey where Submission_Nbr in ("+SubmissionNumber+")";
	    		   SubmissionDBXMLLogs =cFunc.getDataFromDB(sqlQury, 36, "EscapeDB","enicdb-dev\\enic_qa");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	String sqlQury="select sub.Submission_Nbr, sub.Submission_Version_Nbr,l.* from escapedb..sub_pd_log l inner join EscapeDB..SUB_Submission sub on l.SubmissionKey=sub.SubmissionKey where Submission_Nbr in ("+SubmissionNumber+")";
	            	SubmissionDBXMLLogs =cFunc.getDataFromDB(sqlQury, 36, "EscapeDB_SIT","ENICDB-STAGE");
	            	
	            }
	            else
	            {
	            	String sqlQury="select sub.Submission_Nbr, sub.Submission_Version_Nbr,l.* from escapedb..sub_pd_log l inner join EscapeDB..SUB_Submission sub on l.SubmissionKey=sub.SubmissionKey where Submission_Nbr in ("+SubmissionNumber+")";
	            	SubmissionDBXMLLogs =cFunc.getDataFromDB(sqlQury ,12, "EscapeDB","ENICDB-STAGE");
	            }
	    	   
	    	  String  sqlSubDB="SELECT  distinct 'Current' Record_type, bs.Business_Segment_Desc,sub.Submission_Nbr, sub.Submission_Version_Nbr, sub.SubmissionTypeKey,st.Submission_Type_Desc, sub.BranchOfficeKey,Branch_Office_CD,Ent_Branch_Office_CD,\r\n" + 
	    	   		"sub.MarketSegmentKey,ms.Market_Segment_Cd,ms.Ent_Market_Segment_Cd,\r\n" + 
	    	   		"sub.External_Reference_Id,sub.PD_Quote_Nbr,ss.Submission_Status_Desc,sub.PredominantStateKey, sst.State_Abbr_Cd,sst.State_Province_Name,sub.Submission_Received_Dt,sub.Submission_Eff_Dt,sub.Submission_Exp_Dt,\r\n" + 
	    	   		"sub.SubmittedLOBKey,lob.LOB_Cd,lob.LOB_Desc ,sub.QuotedLOBKey,Qlob.LOB_Cd quoted_LOB_Cd,Qlob.LOB_Desc quoted_LOB_Desc,sub.Quoted_Premium_Amt,\r\n" + 
	    	   		"sub.UnderwriterKey,uw.Underwriter_Name, uw.UserName,sub.CompanyKey,comp.Company_Cd,comp.Company_Name,sub.NAICS_CD, sub.ProducerKey,sub.ProducerOfficeKey, sub.WINS_Agent_Cd,\r\n" + 
	    	   		"sub.License_Number,sub.Broker_Name,sub.License_Description,sub.CreationTimestamp,sub.LastModifiedUserId,sub.LastModifiedTimestamp\r\n" + 
	    	   		"FROM EscapeDB.dbo.SUB_Submission sub\r\n" + 
	    	   		"left join EscapeDB.[dbo].[SUB_Submission_Status] ss on (sub.SubmissionStatusKey=ss.SubmissionStatusKey)\r\n" + 
	    	   		"left join EscapeDB..SUB_Submission_Type st on st.SubmissionTypeKey=sub.SubmissionTypeKey\r\n" + 
	    	   		"left join EscapeDB.[dbo].[SUB_State] sst on (sub.PredominantStateKey=sst.StateKey)\r\n" + 
	    	   		"left join EscapeDB.[dbo].[SUB_Business_Segment] bs on (sub.BusinessSegmentKey=bs.BusinessSegmentKey)\r\n" + 
	    	   		"left join EscapeDB.[dbo].[SUB_LOB] lob on (sub.SubmittedLOBKey =lob.LOBKey)\r\n" + 
	    	   		"left join EscapeDB.[dbo].[SUB_LOB] Qlob on (sub.QuotedLOBKey =Qlob.LOBKey)\r\n" + 
	    	   		"left join EscapeDB.[dbo].[SUB_Underwriter] uw on (sub.UnderwriterKey=uw.UnderwriterKey)\r\n" + 
	    	   		"left join EscapeDB.[dbo].[DIMCompany] comp on (sub.CompanyKey=comp.CompanyKey)\r\n" + 
	    	   		"left join EscapeDB..SUB_Branch_Office br on sub.BranchOfficeKey=br.BranchOfficeKey\r\n" + 
	    	   		"left join EscapeDB..SUB_Market_Segment ms on sub.MarketSegmentKey=ms.MarketSegmentKey\r\n" + 
	    	   		"where sub.Submission_Nbr='"+SubmissionNumber +"'"+ "order by Submission_Version_Nbr desc";
	       
	    	  if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		  SubmissionDBLogs =cFunc.getDataFromDB(sqlSubDB, 36, "EscapeDB","enicdb-dev\\enic_qa");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	SubmissionDBLogs =cFunc.getDataFromDB(sqlSubDB, 36, "EscapeDB_SIT","ENICDB-STAGE");
	            	
	            }
	            else
	            {
	            	SubmissionDBLogs =cFunc.getDataFromDB(sqlSubDB, 36, "EscapeDB","ENICDB-STAGE");
	            }
	    	  	String[] strSubDBarrr=SubmissionDBLogs.get(0);
	    	  	String[] strSubXMLarr = SubmissionDBXMLLogs.get(0);
	    	  	String PD_XML_Input=strSubXMLarr[4];
	    	  	String PD_XML_Output=strSubXMLarr[5];
	    	  
	    	  newSubmissionDBXMLDataMap.put("SubmissionNumber", daDBXmlRef.getData("XML_Ref_Tags").split(";")[0]);
	    	  newSubmissionDBXMLDataMap.put("BranchOffice_cd",  daDBXmlRef.getData("XML_Ref_Tags").split(";")[1]);
	    	  newSubmissionDBXMLDataMap.put("MarketSegment_cd",  daDBXmlRef.getData("XML_Ref_Tags").split(";")[2]);
	    	  newSubmissionDBXMLDataMap.put("BusinessSegment",  daDBXmlRef.getData("XML_Ref_Tags").split(";")[3]);
			       

		       newSubmissionDBDataMap.put("SubmissionNumber", strSubDBarrr[2]);
		       newSubmissionDBDataMap.put("BranchOffice_cd", strSubDBarrr[8]);
		       newSubmissionDBDataMap.put("MarketSegment_cd", strSubDBarrr[11]);
		       newSubmissionDBDataMap.put("BusinessSegment", strSubDBarrr[1]);
		       
		       func._addToGlobalVariableList("SubmissionNumber", strSubDBarrr[2]);
		       func._addToGlobalVariableList("BranchOffice_cd", strSubDBarrr[8]);
		       func._addToGlobalVariableList("MarketSegment_cd", strSubDBarrr[11]);
		       func._addToGlobalVariableList("BusinessSegment", strSubDBarrr[1]);
		       String xmlValue="";
	       for(String key : newSubmissionDBXMLDataMap.keySet())
			{
				String xmlTags = newSubmissionDBXMLDataMap.get(key);
				if(key.equalsIgnoreCase("SubmissionNumber"))
				{
					 xmlValue=PD_XML_Input.split(xmlTags)[1].split("</")[0].trim();	
					 xmlValue=xmlValue.split("-")[0];
				}
				else
				{
					 xmlValue=PD_XML_Input.split(xmlTags)[1].split("</")[0].trim();	
				}
				
				String DBValue=newSubmissionDBDataMap.get(key);
				//DBValue=func.dateFormat(DBValue);
				//xmlValue=func.dateFormat(xmlValue);
				if(DBValue!=null && xmlValue!=null)
				{
					if(!(xmlValue.contains(DBValue)))
					{

						isMatched=false;
						CustomReporting.logReport("","", "Verified "+ key +" XML value "+ xmlValue + "in PD_INPUT_XML file and DB Value "+DBValue+" are NOT Equal","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					}
				}
				else
				{
					isMatched=false;
					CustomReporting.logReport("","",key +" XML value " + xmlValue +" in PD_INPUT_XML  file and DB Value "+DBValue,"", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				}
				
			}
			if(isMatched)
			{
				CustomReporting.logReport("","", "Verified  EMT_BranchOffice_cd,ENT_MarketSegment_cd,Submission# and Business Segment fields in PD_INPUT_XML file successfully","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
				
			}
		
	     for(String key : newSubmissionDBXMLDataMap.keySet())
			{
				String xmlTags = newSubmissionDBXMLDataMap.get(key);
				
				String DBValue=newSubmissionDBDataMap.get(key);
				if(key.equalsIgnoreCase("SubmissionNumber"))
				{
					 xmlValue=PD_XML_Output.split(xmlTags)[1].split("</")[0].trim();
					 xmlValue=xmlValue.split("-")[0];
				}
				else
				{
					xmlValue=PD_XML_Output.split(xmlTags)[1].split("</")[0].trim();
				}
				if(DBValue!=null && xmlValue!=null)
				{
					if(!(xmlValue.contains(DBValue)))
					{

						isMatched=false;
						CustomReporting.logReport("","", "Verified "+ key +" XML value "+xmlValue+ " in PD_OUTPUT_XMLL file and DB Value "+DBValue+" are NOT Equal","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					}
				}
				else
				{
					isMatched=false;
					CustomReporting.logReport("","",key +" XML value "+ xmlValue +" in PD_OUTPUT_XML file and DB Value "+DBValue,"", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				}
				
			}
			if(isMatched)
			{
				CustomReporting.logReport("","", "Verified  EMT_BranchOffice_cd,ENT_MarketSegment_cd,Submission# and Business Segment fields in PD_OUTPUT_XML file successfully","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
				
			}
		}
	catch(Exception e)
	{
		System.out.println(e); 
		 CustomReporting.logReport("","", "Failed to Verify  EMT_BranchOffice_cd,ENT_MarketSegment_cd,Submission# and Business Segment fields in PD_INPUT_XML and  PD_OutPut_XML files","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	//throw new RuntimeException(); 
		 
	}
	}
	
	@Override
	public void verify_Vosco_Quote_SAN_InDB(String tcID, SoftAssert softAs) throws Exception {
		
		
		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 PageData daDBXmlRef = PageDataManager.instance().getPageData("XML_Tag_Ref",tcID);
		 PageData dataPD = PageDataManager.instance().getPageData("PD",tcID);
		 PageData dataNewBusiness = PageDataManager.instance().getPageData("NewBusiness",tcID);
		 PageData dataEditSub = PageDataManager.instance().getPageData("EditSubmission",tcID);
		 
		 
		 LinkedHashMap<Integer, String[]>SubmissionDBXMLLogs =null;
		 LinkedHashMap<Integer, String[]>SubmissionDBLogs =null;
		 Map<String, String> newSubmissionDBDataMap = new LinkedHashMap<>();
	     Map<String, String> newSubmissionDataMap = new LinkedHashMap<>();
	     
	     Map<String, String> datainputExcludetags = new LinkedHashMap<>();
	     Map<String, String> XMLinputExcludetags = new LinkedHashMap<>();
	     
	     
	     Boolean isMatched =true;
	     String  quoteNumber =quoteNumber=dataPD.getData("PDQuoteNumber").split("-")[0];
	     String  SubmissionNumber =quoteNumber=dataPD.getData("SubmissionNumber").split("-")[0];
	     
	     try
	     {
	    	 String sqlQury="select * from EscapeDB..SUB_PD_Log where PD_Quote_Nbr='"+quoteNumber+"' order by 1 desc";
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		  
	    		   SubmissionDBXMLLogs =cFunc.getDataFromDB(sqlQury, 36, "EscapeDB","enicdb-dev\\enic_qa");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	
	            	SubmissionDBXMLLogs =cFunc.getDataFromDB(sqlQury, 36, "EscapeDB_SIT","ENICDB-STAGE");
	            	
	            }
	            else
	            {
	            	
	            	SubmissionDBXMLLogs =cFunc.getDataFromDB(sqlQury ,12, "EscapeDB","ENICDB-STAGE");
	            }
	    	   
	    	  String  sqlSubDB="SELECT  distinct 'Current' Record_type, bs.Business_Segment_Desc,sub.Submission_Nbr, sub.Submission_Version_Nbr, sub.SubmissionTypeKey,st.Submission_Type_Desc, sub.BranchOfficeKey,Branch_Office_CD,Ent_Branch_Office_CD,\r\n" + 
	    	   		"sub.MarketSegmentKey,ms.Market_Segment_Cd,ms.Ent_Market_Segment_Cd,\r\n" + 
	    	   		"sub.External_Reference_Id,sub.PD_Quote_Nbr,ss.Submission_Status_Desc,sub.PredominantStateKey, sst.State_Abbr_Cd,sst.State_Province_Name,sub.Submission_Received_Dt,sub.Submission_Eff_Dt,sub.Submission_Exp_Dt,\r\n" + 
	    	   		"sub.SubmittedLOBKey,lob.LOB_Cd,lob.LOB_Desc ,sub.QuotedLOBKey,Qlob.LOB_Cd quoted_LOB_Cd,Qlob.LOB_Desc quoted_LOB_Desc,sub.Quoted_Premium_Amt,\r\n" + 
	    	   		"sub.UnderwriterKey,uw.Underwriter_Name, uw.UserName,sub.CompanyKey,comp.Company_Cd,comp.Company_Name,sub.NAICS_CD, sub.ProducerKey,sub.ProducerOfficeKey, sub.WINS_Agent_Cd,\r\n" + 
	    	   		"sub.License_Number,sub.Broker_Name,sub.License_Description,sub.CreationTimestamp,sub.LastModifiedUserId,sub.LastModifiedTimestamp\r\n" + 
	    	   		"FROM EscapeDB.dbo.SUB_Submission sub\r\n" + 
	    	   		"left join EscapeDB.[dbo].[SUB_Submission_Status] ss on (sub.SubmissionStatusKey=ss.SubmissionStatusKey)\r\n" + 
	    	   		"left join EscapeDB..SUB_Submission_Type st on st.SubmissionTypeKey=sub.SubmissionTypeKey\r\n" + 
	    	   		"left join EscapeDB.[dbo].[SUB_State] sst on (sub.PredominantStateKey=sst.StateKey)\r\n" + 
	    	   		"left join EscapeDB.[dbo].[SUB_Business_Segment] bs on (sub.BusinessSegmentKey=bs.BusinessSegmentKey)\r\n" + 
	    	   		"left join EscapeDB.[dbo].[SUB_LOB] lob on (sub.SubmittedLOBKey =lob.LOBKey)\r\n" + 
	    	   		"left join EscapeDB.[dbo].[SUB_LOB] Qlob on (sub.QuotedLOBKey =Qlob.LOBKey)\r\n" + 
	    	   		"left join EscapeDB.[dbo].[SUB_Underwriter] uw on (sub.UnderwriterKey=uw.UnderwriterKey)\r\n" + 
	    	   		"left join EscapeDB.[dbo].[DIMCompany] comp on (sub.CompanyKey=comp.CompanyKey)\r\n" + 
	    	   		"left join EscapeDB..SUB_Branch_Office br on sub.BranchOfficeKey=br.BranchOfficeKey\r\n" + 
	    	   		"left join EscapeDB..SUB_Market_Segment ms on sub.MarketSegmentKey=ms.MarketSegmentKey\r\n" + 
	    	   		"where sub.Submission_Nbr='"+SubmissionNumber +"'";
	       
	    	  if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		  SubmissionDBLogs =cFunc.getDataFromDB(sqlSubDB, 36, "EscapeDB","enicdb-dev\\enic_qa");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	SubmissionDBLogs =cFunc.getDataFromDB(sqlSubDB, 36, "EscapeDB_SIT","ENICDB-STAGE");
	            	
	            }
	            else
	            {
	            	SubmissionDBLogs =cFunc.getDataFromDB(sqlSubDB, 36, "EscapeDB","ENICDB-STAGE");
	            }
	    	  	String[] strSubDBarrr=SubmissionDBLogs.get(0);
	    	  	String[] strSubXMLarr = SubmissionDBXMLLogs.get(0);
	    	  	String PD_XML_Input=strSubXMLarr[2];
	    	  	String PD_XML_Output=strSubXMLarr[3];
	    	  	String PD_DB_SAN=strSubXMLarr[9];

	    	  String xmlSANTags = daDBXmlRef.getData("XML_Ref_Tags").split(";")[0];
			  String xmlSANValue=PD_XML_Output.split(xmlSANTags)[1].split("</")[0].trim();	
			  
			  String xmlQuoteTags = daDBXmlRef.getData("XML_Ref_Tags").split(";")[1];
			  String xmlQuoteValue=PD_XML_Output.split(xmlQuoteTags)[1].split("</")[0].trim();	
			  
			  String ActSANValue="";
			  String ActQuoteValue=dataPD.getData("PDQuoteNumber").split("-")[0];
	    	  
	    	  if(xmlQuoteValue.equalsIgnoreCase(ActQuoteValue))	
	    	  {
	  			CustomReporting.logReport("","","Quote is present in database - Output XML's" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
	  		  }
	  		  else
	  		  {
	  			CustomReporting.logReport("", "", "Quote is not present in database - Output XML's","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
	  		  }
	    	  if(xmlSANValue.equalsIgnoreCase(PD_DB_SAN))	
	    	  {
	  			CustomReporting.logReport("","","SAN number is present in database - Output XML's" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
	  		  }
	  		  else
	  		  {
	  			CustomReporting.logReport("", "", "SAN number is not present in database - Output XML's","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
	  		  }

		       newSubmissionDBDataMap.put("SubmissionNumber", strSubDBarrr[2]);
		       newSubmissionDBDataMap.put("BusinessSegment", strSubDBarrr[1]);
		       newSubmissionDBDataMap.put("PridominentState", strSubDBarrr[17]);
		       newSubmissionDBDataMap.put("LOB", strSubDBarrr[23]);
		       newSubmissionDBDataMap.put("Company", strSubDBarrr[23]);
		       
		       newSubmissionDataMap.put("SubmissionNumber", dataNewBusiness.getData("SubmissionNumber"));
		       newSubmissionDataMap.put("BusinessSegment",  dataNewBusiness.getData("BusinessSegment"));
		       newSubmissionDataMap.put("PridominentState", dataNewBusiness.getData("PredominantState"));
		       newSubmissionDataMap.put("LOB",dataNewBusiness.getData("SubmittedLOB"));
		       newSubmissionDataMap.put("Company", dataEditSub.getData("EverestCompany"));
		       
		       
		       func._addToGlobalVariableList("SubmissionNumber", strSubDBarrr[2]);
		       func._addToGlobalVariableList("PridominentState", strSubDBarrr[17]);
		       func._addToGlobalVariableList("LOB", strSubDBarrr[23]);
		       func._addToGlobalVariableList("BusinessSegment", strSubDBarrr[1]);
		       func._addToGlobalVariableList("Company", strSubDBarrr[23]);
		       
		       
	       for(String key : newSubmissionDBDataMap.keySet())
			{
				String dataValue = newSubmissionDataMap.get(key);
				String DBValue=newSubmissionDBDataMap.get(key);
				if(DBValue!=null && dataValue!=null)
				{
					if(!(DBValue.contains(dataValue)))
					{

						isMatched=false;
						CustomReporting.logReport("","", "Verified "+ key +"value '"+ DBValue + "' prasent in database as not expected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					}
				}
				else
				{
					isMatched=false;
					CustomReporting.logReport("","","Verified "+ key +"value '"+ DBValue + "'prasent in database as not expected","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				}
				
			}
			if(isMatched)
			{
				CustomReporting.logReport("","", "Verified data prasent in database as expected","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
				
			}
			
			boolean isfoundXMLTag=false;
			
			for(String xmltag : daDBXmlRef.getData("XMLInput_ExcludeTags").split(";"))
			{

					if(!(PD_XML_Input.contains(xmltag)))
					{

						isfoundXMLTag=true;
						CustomReporting.logReport("","", "Verified "+ xmltag +"tag prasent in the input xml","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					}
				
			}
			if(!isMatched)
			{
				CustomReporting.logReport("","", "Verify in PD Input sheet xml below fields are not present:\r\n" + 

						"<CoExternalSystemRefCd>\r\n" + "<CoBusSegCd>,\r\n" + "<CoBusSegDesc>,\r\n" +"<CoMktSegCd>,\r\n" + 
 
						"<CoMktSegDesc>","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
				
			}
			
		     
		
	     
			
		}
	catch(Exception e)
	{
		System.out.println(e); 
		 CustomReporting.logReport("","", "Failed to Verify submission data prasent in data base as expected","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	//throw new RuntimeException(); 
		 
	}
	}
	
	@Override
	public void verify_BookPolicyXML_BindPost(String tcID, SoftAssert softAs,String SubType) throws Exception {
		
		
		 PageData dataEnd= PageDataManager.instance().getPageData("CommonInfo",tcID);
		 PageData dataLogin= PageDataManager.instance().getPageData("Login",tcID);
		 PageData daDBXmlRef = PageDataManager.instance().getPageData("XML_Tag_Ref",tcID);
		 PageData dataTestResult = PageDataManager.instance().getPageData("TestResult",tcID);
		 PageData dataNewSubmission=null;
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

		 String  SubmissionNumber ="";
	     
	     if(SubType.equalsIgnoreCase("Sister"))
	     {
	    	 SubmissionNumber = dataNewSubmission.getData("Sister_Sub_num").split("-")[0];
	     }
	     else
	     {
	    	 SubmissionNumber = dataNewSubmission.getData("SubmissionNumber").split("-")[0]; 
	     }	 
		
	     
	    
		 		 
		 LinkedHashMap<Integer, String[]>SubmissionDBXMLLogs =null;
		 LinkedHashMap<Integer, String[]>SubmissionDBLogs =null;
		 Map<String, String> newSubmissionDBDataMap = new LinkedHashMap<>();
	     Map<String, String> newSubmissionDBXMLDataMap = new LinkedHashMap<>();
	     Boolean isMatched =true;
	     
	     try
	     {
	    	  String sqlQury="select sub.Submission_Nbr, sub.Submission_Version_Nbr,l.* from escapedb..sub_pd_log l inner join EscapeDB..SUB_Submission sub on l.SubmissionKey=sub.SubmissionKey where Submission_Nbr in ("+ SubmissionNumber + ")  and SystemIndicator='Bind Post'  order by sub.Submission_Version_Nbr desc";
	    	  		// and sub.Submission_Version_Nbr=2  order by pdlogkey desc"
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		   
	    		   SubmissionDBXMLLogs =cFunc.getDataFromDB(sqlQury, 12, "EscapeDB","enicdb-dev\\enic_qa");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	
	            	SubmissionDBXMLLogs =cFunc.getDataFromDB(sqlQury, 12, "EscapeDB_SIT","ENICDB-STAGE");
	            	
	            }
	            else
	            {
	            	
	            	SubmissionDBXMLLogs =cFunc.getDataFromDB(sqlQury ,12, "EscapeDB","ENICDB-STAGE");
	            }
	    	   
	    	  
	       	   	String[] strSubDBarrr=SubmissionDBXMLLogs.get(0);
	       	   	String DBQuoteNum=strSubDBarrr[7];
	       	 	String DBSAN=strSubDBarrr[11];
	       	 	
	       	 if(dataTestResult.getData("SANNumber").replace("'", "").contains(DBSAN))
	       	 {
	       		CustomReporting.logReport("","", "Successfully Verified the SAN Number is saved in the table Sub_Submission table.","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
	       		
	       	 }
	       	 else
	       	 {
	       		CustomReporting.logReport("","", " The SAN Number is not saved in the table Sub_Submission table","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	       	 }
	       	if(dataTestResult.getData("QuoteNumber").equals(DBQuoteNum))
	       	 {
	       		CustomReporting.logReport("","", "Successfully Verified the Quote Number is saved in the table Sub_Submission table.","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
	       		
	       	 }
	       	 else
	       	 {
	       		CustomReporting.logReport("","", " The Quote Number is not saved in the table Sub_Submission table","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	       	 }
	       	 	
	       	 	
	    	  	String PD_XML_Input=strSubDBarrr[4];
	    	  	String PD_XML_Output=strSubDBarrr[5];
	    	  
	    	  newSubmissionDBXMLDataMap.put("EffDate", daDBXmlRef.getData("XML_BindPost_Ref_Input").split(";")[0]);
	    	  newSubmissionDBXMLDataMap.put("ExpDate",  daDBXmlRef.getData("XML_BindPost_Ref_Input").split(";")[1]);
	    	  newSubmissionDBXMLDataMap.put("CompanyNmae",  daDBXmlRef.getData("XML_BindPost_Ref_Input").split(";")[2]);
	    	  newSubmissionDBXMLDataMap.put("PredState",  daDBXmlRef.getData("XML_BindPost_Ref_Input").split(";")[3]);
	    	  newSubmissionDBXMLDataMap.put("UnderWritername",  daDBXmlRef.getData("XML_BindPost_Ref_Input").split(";")[4]);
			       
	    	  	int offset= Integer.valueOf(dataEnd.getData("PolicyEffDte").split("-")[0].trim());
				//offset=Integer.valueOf("-"+offset);
		    	String OptValue=dataEnd.getData("PolicyEffDte").split("-")[1].trim();
		    	
		    	String strEffDate=func.Date_Manipulation("",OptValue, offset);
		    	strEffDate=func.dateFormat(strEffDate,"Sub","Day");
		       newSubmissionDBDataMap.put("EffDate",strEffDate );
		      
		       offset= Integer.valueOf(dataEnd.getData("PolicyExpDte").split("-")[0].trim());
		        OptValue=dataEnd.getData("PolicyExpDte").split("-")[1].trim();
		    	
		        String strExpDate=func.Date_Manipulation("",OptValue, offset);
		        strExpDate=func.dateFormat(strExpDate,"Sub","Day");
		    	
		       newSubmissionDBDataMap.put("ExpDate",strExpDate);
		       
		       newSubmissionDBDataMap.put("CompanyNmae", dataEnd.getData("InsuranceCompany"));
		       newSubmissionDBDataMap.put("PredState",dataEnd.getData("StateCode"));
		       newSubmissionDBDataMap.put("UnderWritername",dataEnd.getData("UnderWriter").toUpperCase());

		       String xmlValue="";
	       for(String key : newSubmissionDBXMLDataMap.keySet())
			{
				String xmlTags = newSubmissionDBXMLDataMap.get(key);

				xmlValue=PD_XML_Input.split(xmlTags)[1].split("</")[0].trim();	
				
				String DBValue=newSubmissionDBDataMap.get(key);
				if(DBValue!=null && xmlValue!=null)
				{
					if(!(DBValue.contains(xmlValue)))
					{

						isMatched=false;
						CustomReporting.logReport("","", "Verified "+ key +" XML value "+ xmlValue + " in PD_INPUT_XML file and DB Value "+DBValue+" are NOT Equal","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					}
				}
				else
				{
					isMatched=false;
					CustomReporting.logReport("","",key +" XML value " + xmlValue +" in PD_INPUT_XML  file and DB Value "+DBValue,"", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				}
				
			}
	       						
	       String xmlPolicyTag=daDBXmlRef.getData("XML_BindPost_Ref_Input").split(";")[5];

	       xmlValue=PD_XML_Output.split(xmlPolicyTag)[1].split("</")[0].trim();
	       xmlValue=xmlValue.replace("-","");
	       //String DBValue=dataTestResult.getData("PolicyNum").trim().split(" ")[0]+dataTestResult.getData("PolicyNum").trim().split(" ")[1]+"-"+dataTestResult.getData("PolicyNum").trim().split(" ")[2];
	       String DBValue=dataTestResult.getData("PolicyNum").trim();

	       
	       DBValue=DBValue.replace(" ", "");
	       if(!(DBValue.contains(xmlValue)))
			{

				isMatched=false;
				CustomReporting.logReport("","", "Verified "+ daDBXmlRef.getData("XML_BindPost_Ref_Input").split(";")[5] +" XML value "+ xmlValue + "in PD_INPUT_XML file and DB Value "+DBValue+" are NOT Equal","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			}
	      
	      
			if(isMatched)
			{
				CustomReporting.logReport("","", "Successfully Verified 'Book Policy' initiated a Bind POST call to escape","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
				
			}
	     }
		
	     
	catch(Exception e)
	{
		System.out.println(e); 
		 CustomReporting.logReport("","", "Failed to Verify 'Book Policy' initiated a Bind POST call to escape.","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	//throw new RuntimeException(); 
		 
	}
	}
	
	
	@Override
	public void verify_BookPolicyXML_BindPost_VoscoAgent(String tcID, SoftAssert softAs) throws Exception {
		
		
		
		 PageData dataLogin= PageDataManager.instance().getPageData("Login",tcID);
		 PageData dataTestResult = PageDataManager.instance().getPageData("TestResult",tcID);
		 PageData dataNewSubmission=null;
		
			 dataNewSubmission = PageDataManager.instance().getPageData("NewBusiness",tcID);	 
		
	    
		 if(!dataNewSubmission.getData("Sys_TC_ID").equals(""))
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewBusiness",dataNewSubmission.getData("Sys_TC_ID")); 
		 }
		
	     
	     String  SubmissionNumber = dataNewSubmission.getData("SubmissionNumber").split("-")[0];
		 		 
		 LinkedHashMap<Integer, String[]>SubmissionDBXMLLogs =null;
		 
	     
	     try
	     {
	    	  String sqlQury="select sub.Submission_Nbr, sub.Submission_Version_Nbr,l.* from escapedb..sub_pd_log l inner join EscapeDB..SUB_Submission sub on l.SubmissionKey=sub.SubmissionKey where Submission_Nbr in ("+ SubmissionNumber + ")";
	    	  		// and sub.Submission_Version_Nbr=2  order by pdlogkey desc"
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		   
	    		   SubmissionDBXMLLogs =cFunc.getDataFromDB(sqlQury, 12, "EscapeDB","enicdb-dev\\enic_qa");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	
	            	SubmissionDBXMLLogs =cFunc.getDataFromDB(sqlQury, 12, "EscapeDB_SIT","ENICDB-STAGE");
	            	
	            }
	            else
	            {
	            	
	            	SubmissionDBXMLLogs =cFunc.getDataFromDB(sqlQury ,12, "EscapeDB","ENICDB-STAGE");
	            }
	    	   
	    	   	String[] strSubDBarrr=SubmissionDBXMLLogs.get(0);
	       	   	String DBBindPost=strSubDBarrr[6];
	       	 	
		       	 if(!DBBindPost.equalsIgnoreCase("Bind Post"))
		       	 {
		       		CustomReporting.logReport("","", "Verified that No Bind call made to escape UI for Vosco user","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
		       		
		       		
		       		
		       	 }
		       	 else
		       	 {
		       		CustomReporting.logReport("","", " Bind call made to escape UI for Vosco user","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		       	 }
	     }
	     catch(Exception ex)
	     {
	    	 System.out.println(ex);
	     }
	}
	
	@Override
	public void verify_Nocalls_Madeto_Escape(String tcID, SoftAssert softAs,String SubType) throws Exception {
		
		
		 PageData dataEnd= PageDataManager.instance().getPageData("CommonInfo",tcID);
		 PageData dataLogin= PageDataManager.instance().getPageData("Login",tcID);
		 PageData daDBXmlRef = PageDataManager.instance().getPageData("XML_Tag_Ref",tcID);
		 PageData dataTestResult = PageDataManager.instance().getPageData("TestResult",tcID);
		 PageData dataNewSubmission=null;
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

		 String  SubmissionNumber ="";
	     
	     if(SubType.equalsIgnoreCase("Sister"))
	     {
	    	 SubmissionNumber = dataNewSubmission.getData("Sister_Sub_num").split("-")[0];
	     }
	     else
	     {
	    	 SubmissionNumber = dataNewSubmission.getData("SubmissionNumber").split("-")[0]; 
	     }	 

		 LinkedHashMap<Integer, String[]>SubmissionDBLogs =null;
	     
	     try
	     {
	    	  String sqlQury="select sub.Submission_Nbr, sub.Submission_Version_Nbr,l.* from escapedb..sub_pd_log l inner join EscapeDB..SUB_Submission sub on l.SubmissionKey=sub.SubmissionKey where Submission_Nbr in ("+ SubmissionNumber + ") order by sub.Submission_Version_Nbr desc";
	    	  		// and sub.Submission_Version_Nbr=2  order by pdlogkey desc"
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		   
	    		   SubmissionDBLogs =cFunc.getDataFromDB(sqlQury, 12, "EscapeDB","enicdb-dev\\enic_qa");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	
	            	SubmissionDBLogs =cFunc.getDataFromDB(sqlQury, 12, "EscapeDB_SIT","ENICDB-STAGE");
	            	
	            }
	            else
	            {
	            	
	            	SubmissionDBLogs =cFunc.getDataFromDB(sqlQury ,12, "EscapeDB","ENICDB-STAGE");
	            }
	    	   
	       	 	
	       	 if(!(SubmissionDBLogs.size()>=1))
	       	 {
	       		CustomReporting.logReport("","", "No calls are be made to escape for BS "+ dataNewSubmission.getData("BusinessSegment") +" and LOB " +dataNewSubmission.getData("SubmissionLOB"),"", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
	       		
	       	 }
	       	 else
	       	 {
	       		CustomReporting.logReport("","", "No calls are be made to escape for BS "+ dataNewSubmission.getData("BusinessSegment") +" and LOB " +dataNewSubmission.getData("SubmissionLOB"),"", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	       	 }
	     }
	       
	      
	     
	catch(Exception e)
	{
		System.out.println(e); 
		 CustomReporting.logReport("","", "Failed to Verify No calls are be made to escape","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	throw new RuntimeException(); 
		 
	}
	}
	       
	
	@Override
	public void verify_ESCSubmission_WithPDChanges (String tcID, SoftAssert softAssert,String type) throws Exception
	{
		
		PageData dataNewSubmission =null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		PageData dataEnd = PageDataManager.instance().getPageData("CommonInfo",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			if(type.equalsIgnoreCase("edit"))
			{
				dataNewSubmission = PageDataManager.instance().getPageData("QAEditSubmission",tcID);	
			}
			else
			{
			 dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID);
			}
		 }
		 else
			 
		 {
			 if(type.equalsIgnoreCase("edit"))
				{
				 dataNewSubmission = PageDataManager.instance().getPageData("EditSubmission",tcID);	
				}
				else
				{
					dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);	
				}
		 }
		if(!dataNewSubmission.getData("Ref_TC_ID").equals(""))
		{
			dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",dataNewSubmission.getData("Ref_TC_ID"));	
		}

		func._waitFor(getElement(tab_TabSubmission), 200, WAIT_FOR.CLICKABLE);
		 Thread.sleep(5000);
		_click(getElement(tab_TabSubmission));
		 func._waitForPageToLoad(getWebDriver(),200L);
		 Thread.sleep(5000);
		 
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		WebElement weProdState=(WebElement)getElement(lst_PredominantStateSelected).getNative();
		
		if(weProdState.getText().trim().contains(dataEnd.getData("PredominantState").trim()))
		{
			CustomReporting.logReport("","","PredominantState changed in PD is  updated at ESCAPE submission" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "PredominantState changed in PD is not updated at ESCAPE submission","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}	
		
		WebElement weUW=(WebElement)getElement(dat_SubmissionExpaireDate).getNative();
		
	
		WebElement weSubUW=(WebElement)getElement(lst_UWNameSelected).getNative();
		if(dataEnd.getData("UnderWriter").trim().equalsIgnoreCase(weSubUW.getText().trim()))
		{
			CustomReporting.logReport("","","Verified the UnderWriter  is updated after the BIND POST call" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "The UnderWriter is not updated after the BIND POST call.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		WebElement weSubEverestCompany=(WebElement)getElement(lst_SelectedEverestCompany).getNative();
		if(dataEnd.getData("InsuranceCompany").trim().contains(weSubEverestCompany.getText().trim().toUpperCase()))
		{
			CustomReporting.logReport("","","Verified the EverestCompany  is updated after the BIND POST call" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "The EverestCompany is not updated after the BIND POST call.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		WebElement weSubLOB=(WebElement)getElement(lst_SelectedSubmissionLOB).getNative();
		
		if(dataNewSubmission.getData("SubmissionLOB").trim().equals(weSubLOB.getText().trim()))
		{
			CustomReporting.logReport("","","Verified the Submitted LOB did not get updated after the BIND POST call" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "The Submitted LOB is updated after the BIND POST call.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		WebElement weSubStatus=(WebElement)getElement(get_SubmissionStatusValue).getNative();
		
		if("Policy Bound".trim().equals(weSubStatus.getText().trim()))
		{
			CustomReporting.logReport("","","Verified the Submitted status is 'Policy Bound' after the BIND POST call" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "The Submitted ststus is not aupdated as 'Policy Bound'  after the BIND POST call.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(("Policy Bound".trim().equals(weSubStatus.getText().trim())) && (!func._isVisible(getElement(btn_CreateSisterPolicy))))
		{
			CustomReporting.logReport("","","Verified 'clone policy' button is not there on the Submission page when the Submission status Policy Bound" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Verified 'clone policy' button is there on the Submission page when the Submission status Policy Bound","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		

	}
	

	@Override
	public void verify_ClonedSubmission_AfterCancelRewritetoNewPolicy(String tcID, SoftAssert softAS) throws Exception 
	{
		func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 int intLoopCount=0;
		do
		{
			if(func._isVisible(getElement(get_SubmissionStatusValue)))
				
			{
				CustomReporting.logReport("","","Verified ESCAPE created a new Cloned submission." ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());		
				break;
			}
			 Thread.sleep(5000);
			intLoopCount=intLoopCount+1;
			
		}while(intLoopCount<10);
		WebElement el=(WebElement) getElement(tab_TabSubmission).getNative();
    	
		String getSubmissionNum=el.getText().split(":")[1].trim();
		if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
		{
			func._writeToExcel("QASearch", "Cloned_Submission_Number",getSubmissionNum, tcID);
	    	func._writeToExcel("QANewSubmission", "Cloned_Sub_Num",getSubmissionNum, tcID);
	    	func._writeToExcel("QANewSubmission", "SubmissionNumber",getSubmissionNum, tcID);
	    	
		}
		else
		{
			func._writeToExcel("Search", "Cloned_Submission_Number",getSubmissionNum, tcID);
	    	func._writeToExcel("NewSubmission", "Cloned_Sub_Num",getSubmissionNum, tcID);
	    	func._writeToExcel("NewSubmission", "SubmissionNumber",getSubmissionNum, tcID);
	    	
		}
		
		int getSubmissionMod=Integer.valueOf(getSubmissionNum.split("-")[1].trim());
		String getClonedSubmissionNum=getSubmissionNum.split("-")[0].trim();
		if(getSubmissionMod==1)
		{
			CustomReporting.logReport("","","Verified ESCAPE created a new Cloned submission with the version 1 after Cancel reWrite policy." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "ESCAPE is not created a new Cloned submission with the version 1 after Cancel reWrite policy.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		/*
		WebElement weSubType=(WebElement)getElement(lst_SubmissionTypeSelected).getNative();
		
		if("Renewal".trim().equals(weSubType.getText().trim()))
		{
			CustomReporting.logReport("","","Verified the cloned submission Type is 'Renewal' after Cancel reWrite policy" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "The cloned submission Type is not 'Renewal' after Cancel reWrite policy","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}*/
		
		if(!func._isEnabled(getElement(lst_SubmissionLOB)))
		{
			CustomReporting.logReport("","","Verified the Submitted LOB is disabled for the User selection in the Newly cloned submission" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "The Submitted LOB is not disabled for the User selection in the Newly cloned submission","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		 PageData dataNewSubmission=null;
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
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",dataNewSubmission.getData("Sys_TC_ID")); 
		 }
		
	     
	     String  SubmissionNumber = dataNewSubmission.getData("SubmissionNumber").split("-")[0];
		 		 
		 LinkedHashMap<Integer, String[]>SubmissionDBLLogs =null;
		 
		
		try
	     {
	    	  String sqlQury="select  CS.*,pdf.PD_FUNCTION_NAME,pdf.PD_FUNCTION_LOOKUPNAME,pdf.Description from EscapeDB..SUB_CLONED_SUBMISSIONS cs inner join  EscapeDB..sub_pd_functions pdf on cs.EXTERNAL_SYSTEM_FUNCTION_ID=pdf.PD_FUNCTION_ID where CLONEDFROM_SUBMISSION_NBR in ("+ SubmissionNumber + ")";
	    	  		// and sub.Submission_Version_Nbr=2  order by pdlogkey desc"
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		   
	    		   SubmissionDBLLogs =cFunc.getDataFromDB(sqlQury, 12, "EscapeDB","enicdb-dev\\enic_qa");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	
	            	SubmissionDBLLogs =cFunc.getDataFromDB(sqlQury, 12, "EscapeDB_SIT","ENICDB-STAGE");
	            	
	            }
	            else
	            {
	            	
	            	SubmissionDBLLogs =cFunc.getDataFromDB(sqlQury ,12, "EscapeDB","ENICDB-STAGE");
	            }
	    	   
	    	  
	       	   	String[] strSubDBarrr=SubmissionDBLLogs.get(0);
	       	   	String NewClonedSumNum=strSubDBarrr[4];
	       	 	
	       	 if(NewClonedSumNum.equals(getClonedSubmissionNum))
	       	 {
	       		CustomReporting.logReport("","", "Verified the relation between the Original & Cloned submission in the table 'SUB_CLONED_SUBMISSIONS'","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
	       		
	       	 }
	       	 else
	       	 {
	       		CustomReporting.logReport("","", "There is no relation between the Original & Cloned submission in the table 'SUB_CLONED_SUBMISSIONS'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	       	 }
	     }
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	} 
	
	@Override
	public void verify_OriginalSubmissionStatus_AfterCancelRewritetoNewPolicy(String tcID, SoftAssert softAS) throws Exception 
	{
		_click(getElement(tab_TabSubmission));
		func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		 int intLoopCount=0;
		do
		{
			if(func._isVisible(getElement(lst_SubmissionStatus)))
				
			{
				break;
			}
			 Thread.sleep(5000);
			intLoopCount=intLoopCount+1;
			
		}while(intLoopCount<10);
		
		WebElement weSubStatus=(WebElement)getElement(get_SubmissionStatusValue).getNative();
		
		if("Policy Bound".trim().equals(weSubStatus.getText().trim()))
		{
			CustomReporting.logReport("","","Verifed the original submission status did not change in escape after Cancel reWrite policy." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "The original submission status did change in escape after Cancel reWrite policy.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		

		func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);

	}
	
	@Override
	public void verify_Populateonly_BSsupport_SubLOB(String tcID, SoftAssert softAS) throws Exception 
	{
		
		func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		 int intLoopCount=0;
		do
		{
			if(func._isVisible(getElement(lst_SubmissionStatus)))
				
			{
				break;
			}
			 Thread.sleep(5000);
			intLoopCount=intLoopCount+1;
			
		}while(intLoopCount<10);
		
		PageData dataLogin= PageDataManager.instance().getPageData("Login",tcID);
		 PageData dataNewSubmission=null;
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
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",dataNewSubmission.getData("Sys_TC_ID")); 
		 }
		
	     
	     String  SubmissionNumber = dataNewSubmission.getData("Cloned_Sub_Num").split("-")[0].trim();
		 		 
		 LinkedHashMap<Integer, String[]>DBBSList =null;
		 List<String> actBSList=new ArrayList<String>();
		
		try
	     {
	    	  String sqlQury="SELECT distinct bs.Business_Segment_Cd, bs.Business_Segment_Desc, bs.BusinessSegmentKey,sl.LOBKey, sl.LOB_Ind,sl.LOB_Cd,sl.LOB_Desc, bl.Send_To_PD_Ind,\r\n" + 
	    	  		"bl.Policy_Issuance_Ind, bl.valid_from_dt, bl.Valid_To_Dt , Business_Segment_Type_cd ,bs.Active_Ind\r\n" + 
	    	  		"FROM [EscapeDB].[dbo].[SUB_LOB] sl\r\n" + 
	    	  		"inner join EscapeDB.dbo.SUB_Business_Segment__LOB bl on sl.lobkey = bl.lobkey\r\n" + 
	    	  		"inner join escapedb.dbo.SUB_Business_Segment bs on bs.businesssegmentkey = bl.businesssegmentkey\r\n" + 
	    	  		"where  Business_Segment_Type_cd<>'P' and bl.Valid_To_Dt is NULL and bs.Active_Ind='Y'\r\n" + 
	    	  		"and sl.LOBKey = (select SubmittedLOBKey from EscapeDB..SUB_Submission where Submission_Nbr ='"+SubmissionNumber+"' and Submission_Version_Nbr=1) order by 2";
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		   
	    		   DBBSList =cFunc.getDataFromDB(sqlQury, 13, "EscapeDB","enicdb-dev\\enic_qa");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	
	            	DBBSList =cFunc.getDataFromDB(sqlQury, 13, "EscapeDB_SIT","ENICDB-STAGE");
	            	
	            }
	            else
	            {
	            	
	            	DBBSList =cFunc.getDataFromDB(sqlQury ,12, "EscapeDB","ENICDB-STAGE");
	            }
	    	   
	    	   for(int i=0;i<DBBSList.size();i++)
	    	   {
	    		   String[] strSubDBarrr=DBBSList.get(i);
	    		   actBSList.add(strSubDBarrr[1]); 
	    	   }
	    	   actBSList.add("MAKE SELECTION");
	    	  
	    		   
	     }
		catch(Exception ex)
		{
			
		}
		if(func._validateDropdownValues(getElement(lst_BusinessSegment), actBSList, false, true, softAS))

		{
			CustomReporting.logReport("","","Verified for the Cloned submission Business segment field shorten to populate only the Business segments that support the Submitted Line of business." ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "The Cloned submission Business segment field is not populate only the Business segments that support the Submitted Line of business.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}

	}
	
	@Override
	public void clk_SisterPolicy(String tcID, SoftAssert softAS) throws Exception 
	{
		 PageData dataNewSubmission = null;
		 PageData dataSearch = null;
		 	PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",tcID); 
			 if(!dataNewSubmission.getData("Ref_TC_ID").equals(""))
			 {
				 dataNewSubmission = PageDataManager.instance().getPageData("QANewSubmission",dataNewSubmission.getData("Ref_TC_ID"));  
			 }
			 dataSearch = PageDataManager.instance().getPageData("Search",tcID); 
		 }
		 else
		 {
			 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
			 if(!dataNewSubmission.getData("Ref_TC_ID").equals(""))
			 {
				 dataNewSubmission = PageDataManager.instance().getPageData("NewSubmission",dataNewSubmission.getData("Ref_TC_ID"));  
			 }
			 dataSearch = PageDataManager.instance().getPageData("Search",tcID);
		 }
		
		func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		 int intLoopCount=0;
		do
		{
			if(func._isVisible(getElement(btn_CreateSisterPolicy)))
				
			{
				break;
			}
			 Thread.sleep(5000);
			intLoopCount=intLoopCount+1;
			
		}while(intLoopCount<10);
		Thread.sleep(3000);
		if(func._isVisible(getElement(btn_CreateSisterPolicy)))
		{
			CustomReporting.logReport("","","Verified Create Sister policy button is avaialble for user in the renewal submission" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Create Sister policy button is not avaialble for user in the renewal submission","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			throw new RuntimeException();
		}
		
		_click(getElement(btn_CreateSisterPolicy));
		 Thread.sleep(5000);
		 func._waitFor(getElement(msg_SubmissionSuccessmsg), 600, WAIT_FOR.VISIBLE);
		 Thread.sleep(5000);
		 WebElement el=(WebElement) getElement(get_SisterSubNum).getNative();
		  
		   String getSubmissionNum=el.getText().split(":")[1].trim();
		 
		
		   if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		    {
		    	func._writeToExcel("QANewSubmission", "Sister_Sub_num",getSubmissionNum, tcID);	
		    	func._writeToExcel("QASearch", "Sister_Sub_num",getSubmissionNum, tcID);

		    }
		    else
		    {
		    	func._writeToExcel("NewSubmission", "Sister_Sub_num",getSubmissionNum, tcID);
		    	func._writeToExcel("Search", "Sister_Sub_num",getSubmissionNum, tcID);
		    	if(!dataNewSubmission.getData("Ref_TC_ID").equals(""))
				{
					func._writeToExcel("NewSubmission", "Sister_Sub_num",getSubmissionNum, dataNewSubmission.getData("Ref_TC_ID"));
			    	func._writeToExcel("Search", "Sister_Sub_num",getSubmissionNum, dataNewSubmission.getData("Ref_TC_ID"));	
				}
		    }
		 
		 
	}
	
	@Override
	public void verify_OriginalSub_NewClonedSub_SisterPolicy(String tcID, SoftAssert softAS) throws Exception 
	{
		
		func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		 int intLoopCount=0;
		
		
		PageData dataLogin= PageDataManager.instance().getPageData("Login",tcID);
		 PageData dataNewSubmission=null;
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
		
	     
	     String  SubmissionNumber = dataNewSubmission.getData("SubmissionNumber").split("-")[0].trim();
	     String  ClonedSubNumber = dataNewSubmission.getData("Sister_Sub_num").split("-")[0].trim();
		 		 
		 LinkedHashMap<Integer, String[]>DBBSList =null;
		 String OriginalSub="";
				 String ClonedSub="";
		
		try
	     {
	    	  String sqlQury="select  CS.*,pdf.PD_FUNCTION_NAME,pdf.PD_FUNCTION_LOOKUPNAME,pdf.Description from EscapeDB..SUB_CLONED_SUBMISSIONS cs\r\n" + 
	    	  		"inner join  EscapeDB..sub_pd_functions pdf on cs.EXTERNAL_SYSTEM_FUNCTION_ID=pdf.PD_FUNCTION_ID where CLONEDFROM_SUBMISSION_NBR in (" + SubmissionNumber +")";
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		   
	    		   DBBSList =cFunc.getDataFromDB(sqlQury, 13, "EscapeDB","enicdb-dev\\enic_qa");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	
	            	DBBSList =cFunc.getDataFromDB(sqlQury, 13, "EscapeDB_SIT","ENICDB-STAGE");
	            	
	            }
	            else
	            {
	            	
	            	DBBSList =cFunc.getDataFromDB(sqlQury ,12, "EscapeDB","ENICDB-STAGE");
	            }

	    		String[] strSubDBarrr=DBBSList.get(0);
	    		 OriginalSub=strSubDBarrr[1].trim();
	    		 ClonedSub=strSubDBarrr[4].trim();

	    		   
	     }
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}
		if(OriginalSub.equalsIgnoreCase(SubmissionNumber) && ClonedSub.equalsIgnoreCase(ClonedSubNumber))

		{
			CustomReporting.logReport("","","Verified the relation between the Original & Cloned submission in the table 'SUB_CLONED_SUBMISSIONS' sucessfully" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "The relation between the Original & Cloned submission in the table 'SUB_CLONED_SUBMISSIONS' is not exist","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}

	}
	
	@Override
	public void verify_SisterPolicy_button_Available(String tcID, SoftAssert softAS) throws Exception 
	{
		
		Thread.sleep(4000);
		func._waitFor(getElement(tab_CopySubmission), 200, WAIT_FOR.CLICKABLE);
		if(!func._isVisible(getElement(btn_CreateSisterPolicy)))
		{
			CustomReporting.logReport("","","Verified that create sister policy buttons is not present in Escape UI after booked and issued the Vosco policy" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Create sister policy buttons is present in Escape UI after booked and issued the Vosco policy","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}	
			
			
		
	}
	
	
	@Override
	public void verify_Defult_ProdName_ProdOffice (String tcID, SoftAssert softAssert) throws Exception{
		
		PageData dataNewBusiness = PageDataManager.instance().getPageData("NewBusiness",tcID);
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);

		Thread.sleep(4000);
		func._waitFor(getElement(lst_EverestCompany), 500, WAIT_FOR.CLICKABLE, "");
		WebElement weProdName=(WebElement)getElement(lst_SelectdProdName).getNative();
		WebElement weProdOffice=(WebElement)getElement(lst_SelectedProducerOffice).getNative();
		String actPrdName=weProdName.getText().trim();
		String actPrdOffice=weProdName.getText().trim();
		
		String expPrdName="Victor Insurance Managers, Inc";
		String expPrdOffice="Sacramento, CALIFORNIA - 15100";
		
	
		if(actPrdName.equalsIgnoreCase(expPrdName))

		{
			CustomReporting.logReport("","","Producer name field is auto populating as per the role define" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Producer name field is not auto populating as per the role define","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(actPrdOffice.equalsIgnoreCase(expPrdOffice))

		{
			CustomReporting.logReport("","","Producer officce field is auto populating as per the role define" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Producer office field is not auto populating as per the role define","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
	
	}

	@Override
	public void verify_errorlogs_RecordedInDB(String tcID, SoftAssert softAS) throws Exception 
	{
		
		func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		 int intLoopCount=0;
		
		
		PageData dataLogin= PageDataManager.instance().getPageData("Login",tcID);
		 PageData dataNewSubmission=null;
		
		 LinkedHashMap<Integer, String[]>DBBSList =null;
		 String error1="";
		 String error2="";
		
		try
	     {
			 String sqlQury="select top 10 * from escapedb..SUB_Error_Log  where User_Name='"+ dataLogin.getData("StageUsername")+"' order by  ErrorLogKey desc";
	    	  //String sqlQury="select top 10 * from escapedb..SUB_Error_Log order by ErrorLogKey desc";
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		   
	    		   DBBSList =cFunc.getDataFromDB(sqlQury, 13, "EscapeDB","enicdb-dev\\enic_qa");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	
	            	DBBSList =cFunc.getDataFromDB(sqlQury, 13, "EscapeDB_SIT","ENICDB-STAGE");
	            	
	            }
	            else
	            {
	            	
	            	DBBSList =cFunc.getDataFromDB(sqlQury ,12, "EscapeDB","ENICDB-STAGE");
	            }

	    		String[] strSubDBarrr1=DBBSList.get(0);
	    		String[] strSubDBarrr2=DBBSList.get(1);
	    		  error1=strSubDBarrr1[3].trim();
	    		  error2=strSubDBarrr2[3].trim();

	    		   
	     }
		catch(Exception ex)
		{
			System.out.println(ex);
			
		}
		if(error1.equalsIgnoreCase("CancelRewrite") && error2.equalsIgnoreCase("CancelRewrite"))

		{
			CustomReporting.logReport("","","Verified there is a error log created in escape after try to cancel rewrite the policy before book" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "There is no error log created in escape after try to cancel rewrite the policy before book","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			throw new RuntimeException();
		}

	}
	
	@SuppressWarnings("static-access")
	@Override
	public void verify_UMSUbmissionDetais_inEscape(String tcID, SoftAssert softAssert) throws Exception {

		try {

			PageData data = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
			PageData dataSubmission = PageDataManager.instance().getPageData("SearchPolicy", tcID);
			PageData dataMarketSeg = PageDataManager.instance().getPageData("UmMarketSegment", tcID);
			PageData dataAddingOffice = PageDataManager.instance().getPageData("UmAddingOffice", tcID);
			PageData dataEscapeFields = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageData dataUmLogin = PageDataManager.instance().getPageData("UmRatingSlimCommon", tcID);
			//PageData dataPremium = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
			//PageData dataAccount = PageDataManager.instance().getPageData("Account", tcID);
			String predominantState = data.getData("State");
			String submissionStatus = dataSubmission.getData("Status");//clarify
			String businessSegment = dataEscapeFields.getData("ExpectedBusinessSegment");
			String branchOffice = dataAddingOffice.getData("Office");
			String marketsegment = dataMarketSeg.getData("MarketSegment");

			String submittedLOB = dataEscapeFields.getData("ExpectedLOB");//clarify
			String primaryExcess = dataSubmission.getData("PrimaryExcess");
			String producerName = data.getData("ProducerOrganization");
			String producerOffice = dataEscapeFields.getData("ExpectedOffice");

			String uwName = dataEscapeFields.getData("ExpectedUW");
			String[] uwAssistant = dataSubmission.getData("UWAssistant").split(",");
			String companyId = dataSubmission.getData("InsuringCompany");//clarify
			String quotedLOB = dataEscapeFields.getData("ExpectedLOB");;//clarify
			//values to be updated
			String limit = dataEscapeFields.getData("limit");
			String policylimit = dataEscapeFields.getData("policylimit");
			String retention =dataEscapeFields.getData("Retention");
			
			  
			//clarify
			String quotePremium = dataSubmission.getData("Premium")+".00";
			String effectiveDate = data.getData("EffectiveDate");
			Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(effectiveDate);
			
			Date expDate = DateUtils.addYears(date1, 1);
			String expirationDate = new SimpleDateFormat("MM/dd/yyyy").format(expDate);

			_wait(2000);
			_click(getElement(lnk_SubmissionNum));
			func._waitForPageToLoad(getWebDriver(), 250L);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if(submissionStatus.equalsIgnoreCase("Issued")) {
				func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT", "Policy Bound", softAssert);
			}
			

			func._checkAttributeValue(getElement(lst_PredominantStateSelected), "TEXT", predominantState, softAssert);
			if(!(businessSegment.equalsIgnoreCase("")||businessSegment.equalsIgnoreCase("null"))) {
			func._checkAttributeValue(getElement(lst_SelectedBusinessSegment), "TEXT", businessSegment, softAssert);
			}
			func._checkAttributeValue(getElement(lst_BranchOfficeSelected), "TEXT", branchOffice, softAssert);

			func._checkAttributeValue(getElement(lst_marketSegmentSelected), "TEXT", marketsegment, softAssert);

			func._checkAttributeValue(getElement(dat_SubmissionEffectiveDate), "value", effectiveDate, softAssert);
			func._checkAttributeValue(getElement(dat_SubmissionExpaireDate), "value", expirationDate, softAssert);
			if(!(submittedLOB.equalsIgnoreCase("")||submittedLOB.equalsIgnoreCase("null"))) {
			func._checkAttributeValue(getElement(lst_SelectedSubmissionLOB), "TEXT", submittedLOB, softAssert);
			}
			func._checkAttributeValue(getElement(lst_SelectdProdName), "TEXT", producerName, softAssert);
			func._checkAttributeValue(getElement(lst_SelectedProducerOffice), "TEXT", producerOffice, softAssert);
			func._checkAttributeValue(getElement(lst_UWNameSelected), "TEXT", uwName, softAssert);
			func._checkAttributeValue(getElement(lst_UWAssistantSelected), "TEXT", uwAssistant[1]+" "+uwAssistant[0], softAssert);
			func._checkAttributeValue(getElement(lst_SelectedEverestCompany), "TEXT", companyId, softAssert);
			if(!(quotedLOB.equalsIgnoreCase("")||quotedLOB.equalsIgnoreCase("null"))) {
			func._checkAttributeValue(getElement(lst_QuotedLineBusinessSelected), "TEXT", quotedLOB, softAssert);
			}
			func._checkAttributeValue(getElement(txt_QuotedPremium), "value", quotePremium, softAssert);
			/*if (primaryExcess.equalsIgnoreCase("Excess")) {
				func._isEnabled(getElement(radio_Excess));
			} else {
				func._isEnabled(getElement(radio_Primary));
			}*/
			String actuallimit = func._getAttributeValue(getElement(txt_Limit), "value", softAssert);
			String actualRetention = func._getAttributeValue(getElement(txt_SubRetention), "value", softAssert);
			if(actuallimit.equalsIgnoreCase(actuallimit)) {
				CustomReporting.logReport("", "",
						"limit value is " + actuallimit ,
						StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
			}else {
				CustomReporting.logReport("", "",
						"limit value is not as expected value ",
						StepStatus.FAILURE, new String[] {}, System.currentTimeMillis());
			}
			boolean quoteshare =getWebDriver().findElement(By.id("ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_chkSubmittedQuotaShare")).isSelected();
			if(quoteshare) {
				_writeToExcel("SearchPolicy", "QuoteShare", "Yes", tcID);
			}else {
				_writeToExcel("SearchPolicy", "QuoteShare", "No", tcID);
			}
			/*if(actualRetention.equalsIgnoreCase(actualRetention)) {
				CustomReporting.logReport("", "",
						"Retention value is " + actualRetention ,
						StepStatus.SUCCESS, new String[] {}, startTime);
			}else {
				CustomReporting.logReport("", "",
						"Retention value is not as expected value ",
						StepStatus.FAILURE, new String[] {}, startTime);
			}*/
			//func._checkAttributeValue(getElement(txt_Limit), "value", limit, softAssert);
			//func._checkAttributeValue(getElement(txt_SubRetention), "value", retention, softAssert);
			
			if(data.getData("Excess").equalsIgnoreCase("Yes")) 
			{
				if(actuallimit.equalsIgnoreCase(policylimit)) 
				{
					CustomReporting.logReport("", "",
							"Limit value is as expected For Excess Policy as per ESUP-34931 and TC-21748. Limit in Escape : " + actuallimit+" Limit in UM : "+policylimit ,
							StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				}else {
					CustomReporting.logReport("", "",
							"Limit value is NOT as expected For Excess Policy as per ESUP-34931 and TC-21748. Limit in Escape : " + actuallimit+" Limit in UM : "+policylimit,
							StepStatus.FAILURE, new String[] {}, System.currentTimeMillis());
				}
				if(actualRetention.equalsIgnoreCase(retention)) {
					CustomReporting.logReport("", "",
							"Retention value is as expected For Excess Policy as per ESUP-34931 and TC-21748. Retention in Escape : " + actualRetention +" Retention in UM : "+retention,
							StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				}else {
					CustomReporting.logReport("", "",
							"Retention value is NOT as expected For Excess Policy as per ESUP-34931 and TC-21748.Retention in Escape : " + actualRetention +" Retention in UM : "+retention,
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
	public void verify_LOB(String tcID, SoftAssert softAssert) throws Exception {

		try {

			PageData dataEscapeFields = PageDataManager.instance().getPageData("Escapefields", tcID);
			PageData data= PageDataManager.instance().getPageData("UmMarketSegment", tcID);
			PageData dataSubmission = PageDataManager.instance().getPageData("SearchPolicy", tcID);
			
			PageData dataAddingOffice = PageDataManager.instance().getPageData("UmAddingOffice", tcID);
			
			
			

			String businessSegment = dataEscapeFields.getData("ExpectedBusinessSegment");

			String submittedLOB = dataEscapeFields.getData("ExpectedLOB");// clarify
			String uwName = dataEscapeFields.getData("ExpectedUW");
			String[] uwAssistant = dataSubmission.getData("UWAssistant").split(",");
			String branchOffice = dataAddingOffice.getData("Office");
			func._checkAttributeValue(getElement(lst_BranchOfficeSelected), "TEXT", branchOffice, softAssert);

			// clarify

			getWebDriver().findElement(By.id("ContentPlaceHolder1_gvSearch_LinkButton2_0")).click();
			func._waitForPageToLoad(getWebDriver(), 250L);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			if (!(businessSegment.equalsIgnoreCase("") || businessSegment.equalsIgnoreCase("null"))) {
				func._checkAttributeValue(getElement(lst_SelectedBusinessSegment), "TEXT", businessSegment, softAssert);
			}

			if (!(submittedLOB.equalsIgnoreCase("") || submittedLOB.equalsIgnoreCase("null"))) {
				func._checkAttributeValue(getElement(lst_SelectedSubmissionLOB), "TEXT", submittedLOB, softAssert);
			}
			func._checkAttributeValue(getElement(lst_UWNameSelected), "TEXT", uwName, softAssert);
			func._checkAttributeValue(getElement(lst_UWAssistantSelected), "TEXT", uwAssistant[1]+" "+uwAssistant[0], softAssert);
			func._checkAttributeValue(getElement(txt_NAICSCode), "value", data.getData("NaicsCode"), softAssert);

		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
	
		
