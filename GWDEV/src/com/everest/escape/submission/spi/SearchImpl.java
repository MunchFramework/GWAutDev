package com.everest.escape.submission.spi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.PageManager;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.Element.WAIT_FOR;

import com.everest.escape.submission.Search;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class SearchImpl extends CustomAbstractPage implements Search{
		
	@Override
	public void Search (String tcID, SoftAssert softAssert,String DeviceName) throws Exception{
		
		PageData dataSearch = null;
		 WebElement elm =null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
		}
		_click(getElement( btn_Searchtab));
		Thread.sleep(3000);
		func._waitFor(getElement( btn_Cancel), 500, WAIT_FOR.CLICKABLE, "");
		_click(getElement( btn_Cancel));
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		
		if(func._isChecked(getElement(radio_And)))
		{
	    	CustomReporting.logReport("","","Verified that by default the Search operator is displayed as 'And' on the Search screen" + 
	    			"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "By default the Search operator is not displayed as 'And' on the Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
			
		Search objSearch = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
		if(!dataSearch.getData("BusinessSegment").equals(""))
		{
			/*if(!DeviceName.equalsIgnoreCase("Internet Explorer"))
			{*/
				_click(getElement(img_clearselection));
				func._waitForPageToLoad(getWebDriver(),50L);
				_click(getElement( lst_clkSelectBusinessSegment));
				func._waitForPageToLoad(getWebDriver(),50L);
				
			   _click(getClonedElement(opt_ChoseBusinessSegment).addToken("tkn_BusinessSegment",dataSearch.getData("BusinessSegment")));
			
				func._waitForPageToLoad(getWebDriver(),50L);
				
				
			/*}
			else
			{
				_click(getElement( lst_clkIESelectBusinessSegment));
				func._waitForPageToLoad(getWebDriver(),50L);
				 _click(getClonedElement(opt_IEChoseBusinessSegment).addToken("tkn_BusinessSegment",dataSearch.getData("BusinessSegment")));
				func._waitForPageToLoad(getWebDriver(),50L);
			
			}*/

		}
		Thread.sleep(3000);
		if(!dataSearch.getData("AccountNumber").equals(""))
		{

			if(dataSearch.getData("AccountNumber").indexOf("-")>0)
			{
				_setValue(getElement(txt_AccountNumber),dataSearch.getData("AccountNumber").split("-")[0]);
			}
			else
			{
				_setValue(getElement(txt_AccountNumber),dataSearch.getData("AccountNumber"));
			}

				
		}
		if(!dataSearch.getData("FEIN").equals(""))
		{
			_setValue(getElement(txt_FEIN),dataSearch.getData("FEIN"));	
			
		}
		if(!dataSearch.getData("InsuredName").equals(""))
		{
			 _setValue(getElement(txt_InsuredName),dataSearch.getData("InsuredName"));

		}
		if(!dataSearch.getData("MailingAddress").equals(""))
		{
			_setValue(getElement(txt_MailingAddress),dataSearch.getData("MailingAddress"));

		}
		if(!dataSearch.getData("MailingCity").equals(""))
		{
			_setValue(getElement(txt_MailingCity),dataSearch.getData("MailingCity"));
			
		}
		if(!dataSearch.getData("MailingState").equals(""))
		{
			 _setValue(getElement(lst_MailingState),dataSearch.getData("MailingState"));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 
		}
		if(!dataSearch.getData("ZipCode").equals(""))
		{
			_setValue(getElement(txt_MailZipCode),dataSearch.getData("ZipCode"));
		}
		
		if(!dataSearch.getData("SubmissionNumber").equals(""))
		{
			if(dataSearch.getData("SubmissionNumber").indexOf("-")>0)
			{
				_setValue(getElement(txt_SubmissionNumber),dataSearch.getData("SubmissionNumber").split("-")[0]);
			}
			else
			{
			_setValue(getElement(txt_SubmissionNumber),dataSearch.getData("SubmissionNumber"));
			}
			
		}
		if(!dataSearch.getData("SubmissionStatus").equals(""))
		{
			_setValue(getElement(lst_SubmissionStatus),dataSearch.getData("SubmissionStatus"));
			
			
		}
		if(!dataSearch.getData("MarketSegment").equals(""))
		{
			_setValue(getElement(lst_MarketSegment),dataSearch.getData("MarketSegment"));
			func._waitForPageToLoad(getWebDriver(),150L);
			Thread.sleep(3000);
		}
		if(!dataSearch.getData("Distribution").equals(""))
		{
			_setValue(getElement(lst_Distribution),dataSearch.getData("Distribution"));
			func._waitForPageToLoad(getWebDriver(),50L);
		}
		
		if(!dataSearch.getData("PredominantState").equals(""))
		{
			_setValue(getElement(lst_PredominantState),dataSearch.getData("PredominantState"));
			func._waitForPageToLoad(getWebDriver(),50L);
		}
		if(!dataSearch.getData("BranchOffice").equals(""))
		{
			_setValue(getElement(lst_BranchOffice),dataSearch.getData("BranchOffice"));
			func._waitForPageToLoad(getWebDriver(),50L);
			
		}
		if(!dataSearch.getData("ProducerName").equals(""))
		{
			_setValue(getElement(lst_ProducerName),dataSearch.getData("ProducerName"));
			func._waitForPageToLoad(getWebDriver(),50L);
			Thread.sleep(3000);
			
		}
		
		if(!dataSearch.getData("ProducerOffice").equals(""))
		{
			_setValue(getElement(lst_ProducerOffice),dataSearch.getData("ProducerOffice"));
			func._waitForPageToLoad(getWebDriver(),50L);
			Thread.sleep(2000);
			
		}
		if(!dataSearch.getData("Underwriter").equals(""))
		{
			_setValue(getElement(lst_Underwriter),dataSearch.getData("Underwriter"));
			func._waitForPageToLoad(getWebDriver(),50L);
			
		}
		if(!dataSearch.getData("SubmissionEffDateAfter").equals(""))
		{
			if(dataSearch.getData("SubmissionEffDateAfter").toUpperCase().equals("NOW"))
			{
				_setValue(getElement(dat_SubmissionEffDateAfter),func.Date_Manipulation("","Now", 0));
				 elm = (WebElement) getElement(dat_SubmissionEffDateAfter).getNative();
		         elm.sendKeys(Keys.TAB);
		    	 func._waitForPageToLoad(getWebDriver(),50L);
				
			}
			else
			{
                Date date = DateUtils.addDays(new Date(),Integer.parseInt(dataSearch.getData("SubmissionEffDateAfter")));
                String strDateReceived = new SimpleDateFormat("MM/dd/yyyy").format(date);

   
				//int offset= Integer.valueOf(dataSearch.getData("SubmissionEffDateAfter").split("-")[0].trim());
		    	//String OptValue=dataSearch.getData("SubmissionEffDateAfter").split("-")[1].trim();
		    	_setValue(getElement(dat_SubmissionEffDateAfter),strDateReceived);
		    	 elm = (WebElement) getElement(dat_SubmissionEffDateAfter).getNative();
		         elm.sendKeys(Keys.TAB);
		    	 func._waitForPageToLoad(getWebDriver(),50L);
			}
		}

		if(!dataSearch.getData("SubmissionEffDateBefore").equals(""))
		{
			if(dataSearch.getData("SubmissionEffDateBefore").toUpperCase().equals("NOW"))
			{
				_setValue(getElement(dat_SubmissionEffDateBefore),func.Date_Manipulation("","Now", 0));
				 elm = (WebElement) getElement(dat_SubmissionEffDateAfter).getNative();
		         elm.sendKeys(Keys.TAB);
		    	 func._waitForPageToLoad(getWebDriver(),50L);
				
			}
			else
			{
				Date date = DateUtils.addDays(new Date(),Integer.parseInt(dataSearch.getData("SubmissionEffDateBefore")));
                String strDateReceived = new SimpleDateFormat("MM/dd/yyyy").format(date);
				//int offset= Integer.valueOf(dataSearch.getData("SubmissionEffDateBefore").split("-")[0].trim());
		    	//String OptValue=dataSearch.getData("SubmissionEffDateBefore").split("-")[1].trim();
		    	//_setValue(getElement(dat_SubmissionEffDateBefore),func.Date_Manipulation("",OptValue, offset));
                _setValue(getElement(dat_SubmissionEffDateBefore),strDateReceived);
                 elm = (WebElement) getElement(dat_SubmissionEffDateAfter).getNative();
		         elm.sendKeys(Keys.TAB);
                
				func._waitForPageToLoad(getWebDriver(),50L);
			}
		}
		if(!dataSearch.getData("SubmittedLOB").equals(""))
		{
			_setValue(getElement(lst_SubmittedLOB),dataSearch.getData("SubmittedLOB"));
			func._waitForPageToLoad(getWebDriver(),50L);
			
		}
		if(!dataSearch.getData("PolicyNumber").equals(""))
		{
			_setValue(getElement(txt_PolicyNumber),dataSearch.getData("PolicyNumber"));
			
		}
		if(!dataSearch.getData("PolicyEffectiveDateFrom").equals(""))
		{
			_setValue(getElement(txt_PolicyEffectiveDateFrom),dataSearch.getData("PolicyEffectiveDateFrom"));
			elm = (WebElement) getElement(txt_PolicyEffectiveDateFrom).getNative();
	         elm.sendKeys(Keys.TAB);
			func._waitForPageToLoad(getWebDriver(),50L);
		}
		if(!dataSearch.getData("PolicyEffectiveDateTo").equals(""))
		{
			_setValue(getElement(txt_PolicyEffectiveDateTo),dataSearch.getData("PolicyEffectiveDateTo"));
			elm = (WebElement) getElement(txt_PolicyEffectiveDateTo).getNative();
	         elm.sendKeys(Keys.TAB);
			func._waitForPageToLoad(getWebDriver(),50L);
		}
		if(!dataSearch.getData("PolicyStatus").equals(""))
		{
			_setValue(getElement(lst_PolicyStatus),dataSearch.getData("PolicyStatus"));
			func._waitForPageToLoad(getWebDriver(),50L);
			
		}
		if(!dataSearch.getData("CancelledReasonCode").equals(""))
		{
			_setValue(getElement(lst_CancelledReasonCode),dataSearch.getData("CancelledReasonCode"));
			func._waitForPageToLoad(getWebDriver(),50L);
		}
		if(!dataSearch.getData("RenewalStatus").equals(""))
		{
			_setValue(getElement(lst_RenewalStatus),dataSearch.getData("RenewalStatus"));
			func._waitForPageToLoad(getWebDriver(),50L);
		}
		if(!dataSearch.getData("PaymentDueDateAfter").equals(""))
		{
			_setValue(getElement(dat_PaymentDueDateAfter),dataSearch.getData("PaymentDueDateAfter"));
			func._waitForPageToLoad(getWebDriver(),50L);
		}
		if(!dataSearch.getData("PaymentDueDateBefore").equals(""))
		{
			_setValue(getElement(dat_PaymentDueDateBefore),dataSearch.getData("PaymentDueDateBefore"));
			elm = (WebElement) getElement(dat_PaymentDueDateBefore).getNative();
	         elm.sendKeys(Keys.TAB);
			func._waitForPageToLoad(getWebDriver(),50L);
		}
		if(!dataSearch.getData("CheckNumber").equals(""))
		{
			_setValue(getElement(txt_CheckNumber),dataSearch.getData("CheckNumber"));
			
		}
		if(!dataSearch.getData("AmountReceived").equals(""))
		{
			_setValue(getElement(txt_AmountReceived),dataSearch.getData("AmountReceived"));
		}
		if(!dataSearch.getData("AND_OR").equals(""))
		{
			if(dataSearch.getData("AND_OR").toUpperCase().equals("AND")&&(!func._isChecked(getElement(radio_And))))
			{
				_click(getElement(radio_And));
				func._waitForPageToLoad(getWebDriver(),50L);
				
			}
			if(dataSearch.getData("AND_OR").toUpperCase().equals("OR")&&(!func._isChecked(getElement(radio_Or))))
			{
				try
				{
				_click(getElement(radio_Or));
			    CustomReporting.logReport("","","Verify that user is able to switch to 'OR' operator anytime on the Search screen" + 
			    			"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
				
			    catch(Exception ex)
			    {
			    	CustomReporting.logReport("","", "User is not able to switch to 'OR' operator on the Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    }
				
			}
		}
		
		
		 func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    _click(getElement( btn_Search));
	    func._waitForPageToLoad(getWebDriver(),50L);
	    Thread.sleep(2000);
	    func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");   
	   	    
	}
	
	@Override
	public ArrayList getHeaderNumbers (String tcID, SoftAssert softAssert,String DeviceName,String SearchType) throws Exception
	{
		PageData dataSearch=null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
		}
		Search objSearch = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
		ArrayList ArrSerchCriteria = new ArrayList();
		int CloNum=1;
		if(!dataSearch.getData("BusinessSegment").equals(""))
		{
			if(SearchType.trim().toUpperCase().equals("SEARCH"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Business Segment", softAssert,"SEARCH");
			}
			
			ArrSerchCriteria.add(CloNum+";"+dataSearch.getData("BusinessSegment"));
		}

		if(!dataSearch.getData("AccountNumber").equals(""))
		{
			if(SearchType.trim().toUpperCase().equals("SEARCH"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Account Number", softAssert,"SEARCH");
			}
			
			ArrSerchCriteria.add(CloNum+";"+dataSearch.getData("AccountNumber"));
		}

		if(!dataSearch.getData("FEIN").equals(""))
		{
			if(SearchType.trim().toUpperCase().equals("SEARCH"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "FEIN", softAssert,"SEARCH");
			}
			if(SearchType.trim().toUpperCase().equals("WINS"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "FEIN", softAssert,"WINS");
			}
			
			ArrSerchCriteria.add(CloNum+";"+dataSearch.getData("FEIN"));
		}

		if(!dataSearch.getData("InsuredName").equals(""))
		{
			if(SearchType.trim().toUpperCase().equals("SEARCH"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Insured Name", softAssert,"SEARCH");
			}
			if(SearchType.trim().toUpperCase().equals("WINS"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Insured Name", softAssert,"WINS");
			}
	
			ArrSerchCriteria.add(CloNum+";"+dataSearch.getData("InsuredName"));
		}

		if(!dataSearch.getData("MailingAddress").equals(""))
		{
			if(SearchType.trim().toUpperCase().equals("SEARCH"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Mailing Street Address", softAssert,"SEARCH");
			}
			
			
			ArrSerchCriteria.add(CloNum+";"+dataSearch.getData("MailingAddress"));
		}


		if(!dataSearch.getData("ProducerOffice").equals(""))
		{
			if(SearchType.trim().toUpperCase().equals("SEARCH"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Producer Office", softAssert,"SEARCH");
			}
			
			
			ArrSerchCriteria.add(CloNum+";"+dataSearch.getData("ProducerOffice"));
		}

		if(!dataSearch.getData("Underwriter").equals(""))
		{
			if(SearchType.trim().toUpperCase().equals("SEARCH"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Underwriter", softAssert,"SEARCH");
			}
			
			
			
			ArrSerchCriteria.add(CloNum+";"+dataSearch.getData("Underwriter"));
		}

		if(!dataSearch.getData("SubmittedLOB").equals(""))
		{
			if(SearchType.trim().toUpperCase().equals("SEARCH"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Submitted Line of Business", softAssert,"SEARCH");
			}
			if(SearchType.trim().toUpperCase().equals("WINS"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Submitted Line of Business", softAssert,"WINS");
			}
			
			ArrSerchCriteria.add(CloNum+";"+dataSearch.getData("SubmittedLOB"));
		}


		if(!dataSearch.getData("PolicyNumber").equals(""))
		{
			if(SearchType.trim().toUpperCase().equals("SEARCH"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Policy Number", softAssert,"SEARCH");
			}
			if(SearchType.trim().toUpperCase().equals("WINS"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Policy Number", softAssert,"WINS");
			}
			
			ArrSerchCriteria.add(CloNum+";"+dataSearch.getData("PolicyNumber"));
		}

		if(!dataSearch.getData("PolicyStatus").equals(""))
		{
			if(SearchType.trim().toUpperCase().equals("SEARCH"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Policy Status", softAssert,"SEARCH");
			}
		
			ArrSerchCriteria.add(CloNum+";"+dataSearch.getData("PolicyStatus"));
		}
		if(!dataSearch.getData("CheckNumber").equals(""))
		{
			if(SearchType.trim().toUpperCase().equals("SEARCH"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Check #", softAssert,"SEARCH");
			}
			if(SearchType.trim().toUpperCase().equals("WINS"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Check #", softAssert,"WINS");
			}
			ArrSerchCriteria.add(CloNum+";"+dataSearch.getData("CheckNumber"));
			
		}
		if(!dataSearch.getData("AmountReceived").equals(""))
		{
			if(SearchType.trim().toUpperCase().equals("SEARCH"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Amount Received", softAssert,"SEARCH");
			}
			if(SearchType.trim().toUpperCase().equals("WINS"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Amount Received", softAssert,"WINS");
			}
			ArrSerchCriteria.add(CloNum+";"+dataSearch.getData("AmountReceived"));
		}
		
		if(!dataSearch.getData("SubmissionEffDateAfter").equals(""))
		{
			
			if(SearchType.trim().toUpperCase().equals("SEARCH"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Effective Date", softAssert,"SEARCH");
			}
			if(SearchType.trim().toUpperCase().equals("WINS"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Effective Date", softAssert,"WINS");
			}
			ArrSerchCriteria.add(CloNum+";"+dataSearch.getData("SubmissionEffDateAfter"));
		}
		else if(!dataSearch.getData("SubmissionEffDateBefore").equals(""))
		{
			if(SearchType.trim().toUpperCase().equals("SEARCH"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Effective Date", softAssert,"SEARCH");
			}
			if(SearchType.trim().toUpperCase().equals("WINS"))
			{
				CloNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Effective Date", softAssert,"WINS");
			}
			ArrSerchCriteria.add(CloNum+";"+dataSearch.getData("SubmissionEffDateBefore"));
		}
		
		
		return ArrSerchCriteria;

	}
	@Override
	public void Verify_Policy_Search (String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{

		PageData dataSearch = null;
		PageData dataLogin = PageDataManager.instance().getPageData("EscapeLogin",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
			if(!dataSearch.getData("Sys_tcID").equals(""))
			{
				dataSearch = PageDataManager.instance().getPageData("QASearch",dataSearch.getData("Sys_tcID"));	
			}
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
			if(!dataSearch.getData("Sys_tcID").equals(""))
			{
				dataSearch = PageDataManager.instance().getPageData("Search",dataSearch.getData("Sys_tcID"));	
			}
		}
		
		_click(getElement( btn_Searchtab));
		Thread.sleep(5000);
		func._waitFor(getElement( btn_Cancel), 500, WAIT_FOR.CLICKABLE, "");
		
		_click(getElement( btn_Cancel));
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		
		/*if(!DeviceName.equalsIgnoreCase("Internet Explorer"))
		{*/
		if(!dataSearch.getData("BusinessSegment").equals(""))
		{
			_click(getElement(img_clearselection));
			func._waitForPageToLoad(getWebDriver(),50L);
			_click(getElement( lst_clkSelectBusinessSegment));
			func._waitForPageToLoad(getWebDriver(),50L);
			Thread.sleep(3000);
			_click(getClonedElement(opt_ChoseBusinessSegment).addToken("tkn_BusinessSegment",dataSearch.getData("BusinessSegment")));

			func._waitForPageToLoad(getWebDriver(),50L);
		/*}
		else
		{
			_click(getElement( lst_clkIESelectBusinessSegment));
			func._waitForPageToLoad(getWebDriver(),50L);

			_click(getClonedElement(opt_IEChoseBusinessSegment).addToken("tkn_BusinessSegment",dataSearch.getData("BusinessSegment")));
	
			func._waitForPageToLoad(getWebDriver(),50L);
		
		}*/
		}
		if(!dataSearch.getData("SubmissionNumber").equals(""))
		{
			if(dataSearch.getData("SubmissionNumber").indexOf("-")>0)
			{
				_setValue(getElement(txt_SubmissionNumber),dataSearch.getData("SubmissionNumber").split("-")[0]);
			}
			else
			{
			_setValue(getElement(txt_SubmissionNumber),dataSearch.getData("SubmissionNumber"));
			}
		}
		if(!dataSearch.getData("PolicyNumber").equals(""))
		{
			_setValue(getElement(txt_PolicyNumber),dataSearch.getData("PolicyNumber"));
		}
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 _click(getElement( btn_Search));
		 func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		 func._waitFor(getClonedElement(lnk_SearchPolicy).addToken("tkn_POLICYNUMBER",dataSearch.getData("PolicyNumber")), 500, WAIT_FOR.CLICKABLE, "");
		 if(func._isVisible(getClonedElement(lnk_SearchPolicy).addToken("tkn_POLICYNUMBER",dataSearch.getData("PolicyNumber"))))
		    {
		    	CustomReporting.logReport("","","Policy number is searched successfully in escape search result" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Policy number search failed  in escape","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    }
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 Thread.sleep(3000);
		 _click(getClonedElement(lnk_SearchPolicy).addToken("tkn_POLICYNUMBER",dataSearch.getData("PolicyNumber")));
	
	}
	
	@Override
	public void Verify_Account_Search (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataSearch = null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
			
			if(!dataSearch.getData("Sys_tcID").equals(""))
			{
				dataSearch = PageDataManager.instance().getPageData("QASearch",dataSearch.getData("Sys_tcID"));	
			}
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
			if(!dataSearch.getData("Sys_tcID").equals(""))
			{
				dataSearch = PageDataManager.instance().getPageData("Search",dataSearch.getData("Sys_tcID"));	
			}
			
		}
		_click(getElement( btn_Searchtab));
		func._waitForPageToLoad(getWebDriver(),50L);
		
		func._waitFor(getElement( btn_Cancel), 500, WAIT_FOR.CLICKABLE, "");
		_click(getElement( btn_Cancel));
		func._waitForPageToLoad(getWebDriver(),50L);
	if(dataSearch.getData("AccountNumber").indexOf("-")>0)
		{
			_setValue(getElement(txt_AccountNumber),dataSearch.getData("AccountNumber").split("-")[0]);
		}
		else
		{
			_setValue(getElement(txt_AccountNumber),dataSearch.getData("AccountNumber"));
		}
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 _click(getElement( btn_Search));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 func._waitFor(getClonedElement(lnk_AccountNum).addToken("tkn_ACCOUNTNUMBER",dataSearch.getData("AccountNumber")), 500, WAIT_FOR.CLICKABLE, "");
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 
		if(func._isVisible(getClonedElement(lnk_AccountNum).addToken("tkn_ACCOUNTNUMBER",dataSearch.getData("AccountNumber"))))
		    {
		    	CustomReporting.logReport("","","Account number is searched successfully in search result" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Account Number search failed in search result ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    }
		_click(getClonedElement(lnk_AccountNum).addToken("tkn_ACCOUNTNUMBER",dataSearch.getData("AccountNumber")));
	
	
	}
	@Override
	public void Verify_Submission_Search (String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		Search objSearch = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
		objSearch.Submission_Search(tcID, softAssert, DeviceName);
		objSearch.Open_Submission_Search_Result(tcID, softAssert);
	}
	
	@Override
	public void Verify_Subdesc_InSearchresult (String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	
	{
		Search objSearch = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
		objSearch.Submission_Search(tcID, softAssert, DeviceName);
		objSearch.Verify_SubDesc_lenght_SearchResult(tcID, softAssert);
		
	}
	
	@Override
	public void Submission_Search (String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		PageData dataLogin = PageDataManager.instance().getPageData("EscapeLogin",tcID);
		PageData dataSearch = null;
		
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
			if(!dataSearch.getData("Sys_tcID").equals(""))
			{
				dataSearch = PageDataManager.instance().getPageData("QASearch",dataSearch.getData("Sys_tcID"));	
			}
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
			if(!dataSearch.getData("Sys_tcID").equals(""))
			{
				dataSearch = PageDataManager.instance().getPageData("Search",dataSearch.getData("Sys_tcID"));	
			}
		}
		_click(getElement( btn_Searchtab));
		func._waitForPageToLoad(getWebDriver(),150L);
		Thread.sleep(5000);
		String strSubnum=null;
		func._waitFor(getElement( btn_Cancel), 500, WAIT_FOR.CLICKABLE, "");
	
		_click(getElement( btn_Cancel));
		func._waitForPageToLoad(getWebDriver(),150L);
		Thread.sleep(3000);
		if(!dataSearch.getData("BusinessSegment").equals(""))
		{
				/*if(!DeviceName.equalsIgnoreCase("Internet Explorer"))
				{*/
					_click(getElement(img_clearselection));
					func._waitForPageToLoad(getWebDriver(),50L);
					_click(getElement( lst_clkSelectBusinessSegment));
					func._waitForPageToLoad(getWebDriver(),50L);
					_click(getClonedElement(opt_ChoseBusinessSegment).addToken("tkn_BusinessSegment",dataSearch.getData("BusinessSegment")));
		
					func._waitForPageToLoad(getWebDriver(),50L);
				/*}
				else
				{
						_click(getElement( lst_clkIESelectBusinessSegment));
						func._waitForPageToLoad(getWebDriver(),50L);
						 _click(getClonedElement(opt_IEChoseBusinessSegment).addToken("tkn_BusinessSegment",dataSearch.getData("BusinessSegment")));
						func._waitForPageToLoad(getWebDriver(),50L);
				}*/
				
			}
			
		if(!dataSearch.getData("SubmissionNumber").equals(""))
		{
			if(dataSearch.getData("SubmissionNumber").indexOf("-")>0)
			{
				strSubnum=dataSearch.getData("SubmissionNumber").split("-")[0];
				_setValue(getElement(txt_SubmissionNumber),strSubnum);
			}
			else
			{
				strSubnum=dataSearch.getData("SubmissionNumber");
			  _setValue(getElement(txt_SubmissionNumber),strSubnum);
			}
		}
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement( btn_Search));
		func._waitForPageToLoad(getWebDriver(),100L);
		Thread.sleep(3000);
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		Thread.sleep(3000);
		if(func._isVisible(getClonedElement(lnk_SubmissionNum).addToken("tkn_SUBNUM",strSubnum)))
	    {
	    	CustomReporting.logReport("","","Submission number is searched successfully in search result" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Submission Number search failed in search result ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
	}
	@Override
	public void UM_Submission_Search (String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		PageData dataSearchPolicy = PageDataManager.instance().getPageData("SearchPolicy",tcID);

			
		_click(getElement( btn_Searchtab));
		func._waitForPageToLoad(getWebDriver(),150L);
		Thread.sleep(5000);
		String strSubnum=null;
		func._waitFor(getElement( btn_Cancel), 500, WAIT_FOR.CLICKABLE, "");
	
		_click(getElement( btn_Cancel));
		func._waitForPageToLoad(getWebDriver(),150L);
		Thread.sleep(3000);
					
		if(!dataSearchPolicy.getData("SubmissionNo").equals(""))
		{
			if(dataSearchPolicy.getData("SubmissionNo").indexOf("-")>0)
			{
				strSubnum=dataSearchPolicy.getData("SubmissionNo").split("-")[0];
				_setValue(getElement(txt_SubmissionNumber),strSubnum);
			}
			else
			{
				strSubnum=dataSearchPolicy.getData("SubmissionNo");
			  _setValue(getElement(txt_SubmissionNumber),strSubnum);
			}
		}
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement( btn_Search));
		func._waitForPageToLoad(getWebDriver(),100L);
		Thread.sleep(3000);
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		Thread.sleep(2000);
		_click(getClonedElement(lnk_SubmissionNum).addToken("tkn_SUBNUM",strSubnum));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(3000);
		 
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		
	}
	
	@Override
	public void clonedSubmission_Search (String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		PageData dataSearch = null;
		
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
			/*if(!dataSearch.getData("Sys_tcID").equals(""))
			{
				dataSearch = PageDataManager.instance().getPageData("QASearch",dataSearch.getData("Sys_tcID"));	
			}*/
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
			/*if(!dataSearch.getData("Sys_tcID").equals(""))
			{
				dataSearch = PageDataManager.instance().getPageData("Search",dataSearch.getData("Sys_tcID"));	
			}*/
		}
		_click(getElement( btn_Searchtab));
		func._waitForPageToLoad(getWebDriver(),150L);
		Thread.sleep(5000);
		String strSubnum=null;
		func._waitFor(getElement( btn_Cancel), 500, WAIT_FOR.CLICKABLE, "");
	
		_click(getElement( btn_Cancel));
		func._waitForPageToLoad(getWebDriver(),150L);
		Thread.sleep(3000);
		if(!dataSearch.getData("BusinessSegment").equals(""))
		{
					_click(getElement(img_clearselection));
					func._waitForPageToLoad(getWebDriver(),50L);
					_click(getElement( lst_clkSelectBusinessSegment));
					func._waitForPageToLoad(getWebDriver(),50L);
					_click(getClonedElement(opt_ChoseBusinessSegment).addToken("tkn_BusinessSegment",dataSearch.getData("BusinessSegment")));
		
					func._waitForPageToLoad(getWebDriver(),50L);
				
				
			}
			
		if(!dataSearch.getData("Cloned_Submission_Number").equals(""))
		{
			if(dataSearch.getData("Cloned_Submission_Number").indexOf("-")>0)
			{
				strSubnum=dataSearch.getData("Cloned_Submission_Number").split("-")[0];
				_setValue(getElement(txt_SubmissionNumber),strSubnum);
			}
			else
			{
				strSubnum=dataSearch.getData("Cloned_Submission_Number");
			  _setValue(getElement(txt_SubmissionNumber),strSubnum);
			}
		}
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement( btn_Search));
		func._waitForPageToLoad(getWebDriver(),100L);
		Thread.sleep(3000);
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		Thread.sleep(3000);
		if(func._isVisible(getClonedElement(lnk_SubmissionNum).addToken("tkn_SUBNUM",strSubnum)))
	    {
			Thread.sleep(2000);
			_click(getClonedElement(lnk_SubmissionNum).addToken("tkn_SUBNUM",strSubnum));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 Thread.sleep(3000);
	    	CustomReporting.logReport("","","Submission number is searched successfully in search result" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Submission Number search failed in search result ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
	}
	public void Open_Submission_Search_Result (String tcID, SoftAssert softAssert) throws Exception
	{
		String strSubnum=null;
		PageData dataSearch =null;
		PageData dataLogin = PageDataManager.instance().getPageData("EscapeLogin",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
			if(!dataSearch.getData("Sys_tcID").equals(""))
			{
				dataSearch = PageDataManager.instance().getPageData("QASearch",dataSearch.getData("Sys_tcID"));	
			}
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
			if(!dataSearch.getData("Sys_tcID").equals(""))
			{
				dataSearch = PageDataManager.instance().getPageData("Search",dataSearch.getData("Sys_tcID"));	
			}
		}
		if(!dataSearch.getData("SubmissionNumber").equals(""))
		{
			if(dataSearch.getData("SubmissionNumber").indexOf("-")>0)
			{
				strSubnum=dataSearch.getData("SubmissionNumber").split("-")[0];
				
			}
			else
			{
				strSubnum=dataSearch.getData("SubmissionNumber");
		
			}
		}
	
		Thread.sleep(2000);
		_click(getClonedElement(lnk_SubmissionNum).addToken("tkn_SUBNUM",strSubnum));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(3000);
	}
	
	
	@Override
	public int get_ColumnNum_InSearchGrid(String tcID,String ColName, SoftAssert softAssert,String SearchTpye) throws Exception
	{
		int intColNum=0;
		if(SearchTpye.trim().toUpperCase().equals("SEARCH"))
		{
			int totHeader=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[1]/th|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[1]/th")).size();
			
			for(int i=1;i<totHeader;i++)
			{
				String Headername=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[1]/th["+ i +"]/a|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[1]/th["+ i +"]/a")).getText();
				if(Headername.trim().toLowerCase().equals(ColName.trim().toLowerCase()))
				{
					intColNum=i;
					break;
				}
					
			}
		}
		if(SearchTpye.trim().toUpperCase().equals("WINS"))
		{
			int totHeader=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvWinsSearch']/tbody/tr[1]/th")).size();
			for(int i=1;i<totHeader;i++)
			{
				String Headername=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvWinsSearch']/tbody/tr[1]/th["+ i +"]/a")).getText();
				if(Headername.trim().toLowerCase().equals(ColName.trim().toLowerCase()))
				{
					intColNum=i;
					break;
				}
					
			}
		}
		return intColNum;
	
	
	}
	
	@Override
	public void verify_SearchGrid(String tcID,SoftAssert softAssert) throws Exception
	{
		List<String> expHeader= new ArrayList<String>();
		expHeader.add("Policy Number".toLowerCase());
		expHeader.add("Policy Status".toLowerCase());
		expHeader.add("Policy Cancelled".toLowerCase());
		expHeader.add("Effective Date".toLowerCase());
		expHeader.add("Insured Name".toLowerCase());
		expHeader.add("WINS Agent Code".toLowerCase());
		expHeader.add("Premium".toLowerCase());
		expHeader.add("Taxes, Fees / Surcharges".toLowerCase());
		expHeader.add("Installment Fee".toLowerCase());
		expHeader.add("Comm.%".toLowerCase());
		expHeader.add("Payment Amount".toLowerCase());
		expHeader.add("Bill Type".toLowerCase());
		expHeader.add("Payment Plan".toLowerCase());
		expHeader.add("Payment Due Date".toLowerCase());
		expHeader.add("Payment Received Date".toLowerCase());
		expHeader.add("Amount Received".toLowerCase());
		expHeader.add("Check #".toLowerCase());
		expHeader.add("Cancel Date".toLowerCase());
		expHeader.add("Final Cancel Date".toLowerCase());
		expHeader.add("Reins. Date".toLowerCase());
		
		
		int totHeader=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[1]/th")).size();

		for(int i=1;i<=totHeader;i++)
		{
			try
			{
				WebElement we=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[1]/th["+ i +"]/a"));
				if(expHeader.get(i-1).equals(we.getText().trim().toLowerCase()))
				{
					CustomReporting.logReport("","","Column Header '"+expHeader.get(i-1).toUpperCase()+"' is displayed as expected in search grid" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				}
			}
			catch(Exception e)
			{
				CustomReporting.logReport("","", "Column Header '"+expHeader.get(i-1).toUpperCase()+"' is not displayed as expected in search grid","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			}

			
			try
			{
				WebElement we=getWebDriver().findElement(By.xpath(".//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[1]/th["+ i +"]/a"));
				if(we.isDisplayed())
				{
					CustomReporting.logReport("","","Column Header '"+expHeader.get(i-1).toUpperCase()+"' is displayed as Link in search grid" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());

				}
			}
			catch(Exception e)
			{
				CustomReporting.logReport("","", "Column Header '"+expHeader.get(i-1).toUpperCase()+"' is not displayed as Link in search grid","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			}
			
			
		}
		
	}
	
	@Override
	public boolean verify_General_Search_Result(String tcID,SoftAssert softAssert,String DeviceName) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		Search objSearch = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
		PageData dataSearch = null;
		PageData dataLogin = PageDataManager.instance().getPageData("EscapeLogin",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
		}
		
		objSearch.verify_NonBillinguser_SearchGrid(tcID, softAssert,"SEARCH");
		ArrayList arrSearchCriteria = objSearch.getHeaderNumbers(tcID, softAssert, DeviceName,"SEARCH");
		int expTotalRecord=0;
		 WebElement el1=(WebElement) getElement(SearchTitle).getNative();
		 String strTotRecords=el1.getText().split("-")[1].trim();
		 int totalRecord=Integer.valueOf(strTotRecords.split(" ")[0].trim());
		 double totpage=totalRecord/10;
		 if(totalRecord>10)
		 {
			 _setValue(getElement(lst_RecordsPerPage),"10");
				func._waitForPageToLoad(getWebDriver(),200L);	
				Thread.sleep(2000);
		 }
		 boolean isFound=true;
		 int totpageCount=2;
		 int pagenumber=1;
		 int spanpgNum=11;
		 
		do
		{

			int totRow=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr")).size();
			totRow=totRow-1;
			if(totRow>10)
			{
				try
				{
					func._waitForPageToLoad(getWebDriver(),100L);
					Thread.sleep(3000);
					totpageCount=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[12]/td/table/tbody/tr/td|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[12]/td/table/tbody/tr/td")).size();
					if(getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[12]/td/table/tbody/tr/td["+spanpgNum+"]//a[text()='...']")).isDisplayed())
					{
						totpageCount=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[12]/td/table/tbody/tr/td|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[12]/td/table/tbody/tr/td")).size();
						for(int pagenum=2;pagenum<=totpageCount;pagenum++)
						{
							expTotalRecord=expTotalRecord+10;
							func._waitForPageToLoad(getWebDriver(),100L);
							Thread.sleep(3000);
						
								isFound=objSearch.verify_Search_Records(tcID,pagenumber, totRow, arrSearchCriteria, softAssert,"SEARCH",dataSearch.getData("AND_OR"));
							
								if(totRow>10)
								{
									func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
									try
									{
										
										getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[12]/td/table/tbody/tr/td["+pagenum+"]/a|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[12]/td/table/tbody/tr/td["+pagenum+"]/a")).click();
																																												
										pagenumber=pagenumber+1;
										func._waitForPageToLoad(getWebDriver(),100L);
										 Thread.sleep(4000);
										
									}
									catch(Exception ex)
									{
										
									}
	
								}
								else
								{
									return isFound;	
								}
								
						}
						 spanpgNum=12;
					}
					
				}
				catch(Exception ex)
				{
					//func._waitForPageToLoad(getWebDriver(),100L);
					Thread.sleep(10000);
					totpageCount=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[12]/td/table/tbody/tr/td|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[12]/td/table/tbody/tr/td")).size();
					int intlastpageCount=objSearch.getSpanIndex(totpageCount, softAssert);

					for(int pagenum=intlastpageCount;pagenum<=totpageCount;pagenum++)
					{
						expTotalRecord=expTotalRecord+10;
						
						isFound=objSearch.verify_Search_Records(tcID,pagenumber, totRow, arrSearchCriteria, softAssert,"SEARCH",dataSearch.getData("AND_OR"));
						func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						try
						{
							getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[12]/td/table/tbody/tr/td["+pagenum+"]/a|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[12]/td/table/tbody/tr/td["+pagenum+"]/a")).click();	
							pagenumber=pagenumber+1;
							func._waitForPageToLoad(getWebDriver(),100L);
							 Thread.sleep(5000);
						}
						catch(Exception e)
						{
							
						}
					}

					return isFound;	
	
				}
			}

				
			else
	
				{
					/*int totRow=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr")).size();*/
				totRow=totRow+1;
				expTotalRecord=expTotalRecord+totRow;
				isFound=objSearch.verify_Search_Records(tcID,pagenumber, totRow, arrSearchCriteria, softAssert,"SEARCH",dataSearch.getData("AND_OR"));
				/*for(int rowNum=2;rowNum<=totRow;rowNum++)
					{
						expTotalRecord=expTotalRecord+1;
				
						for(int colNum=0;colNum<arrSearchCriteria.size();colNum++)
						{
							String ExpValue=arrSearchCriteria.get(colNum).toString().split(";")[1];
							int HeaderNum =Integer.valueOf(arrSearchCriteria.get(colNum).toString().split(";")[0]);
							//expTotalRecord=expTotalRecord+1;
							String cellValue=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr["+rowNum+"]/td[" + HeaderNum + "]|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr["+rowNum+"]/td[" + HeaderNum +"]")).getText();
							String actValue=cellValue.replace("$", "").replace(",", "");
							String ExpectValue=ExpValue.replace("$", "").replace(",", "");
							
							
							if(!actValue.trim().toLowerCase().equals(ExpectValue.trim().toLowerCase()))
							{
								CustomReporting.logReport("","", "As Expected Search Result is not displayed correctly in the "+HeaderNum +" col , "+expTotalRecord +" row for the search criteria entered '"+actValue,"", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
								isFound=false;
								break;
							}
						}
						if(!isFound)
						{
							return isFound;
						
						}
					}*/
				}
			
		
		}while(!(expTotalRecord >= totalRecord));
		return isFound;
		
	
	
	}
	
	
	@Override
	public boolean verify_WINS_Search_Result(String tcID,SoftAssert softAssert,String DeviceName) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		Search objSearch = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
		PageData dataSearch = null;
		PageData dataLogin = PageDataManager.instance().getPageData("EscapeLogin",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
		}
		objSearch.verify_NonBillinguser_SearchGrid(tcID, softAssert,"WINS");
		ArrayList arrSearchCriteria = objSearch.getHeaderNumbers(tcID, softAssert, DeviceName,"WINS");
		int expTotalRecord=0;
		 WebElement el1=(WebElement) getElement(SearchWinsTitle).getNative();
		 String strTotRecords=el1.getText().split("-")[1].trim();
		 int totalRecord=Integer.valueOf(strTotRecords.split(" ")[0].trim());
		 double totpage=totalRecord/10;
		 if(totalRecord>10)
		 {
			 _setValue(getElement(lst_WINSRecordsPerPage),"10");
				func._waitForPageToLoad(getWebDriver(),50L);	 
		 }
		 boolean isFound=true;
		 int totpageCount=2;
		 int pagenumber=1;
		 int spanpgNum=11;
		 
		//do
		//{

			int totRow=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvWinsSearch']/tbody/tr")).size();
						
			totRow=totRow-1;
			if(totRow>10)
			{
				try
				{
					totpageCount=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvWinsSearch']/tbody/tr[12]/td/table/tbody/tr/td")).size();
					if(getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvWinsSearch']/tbody/tr[12]/td/table/tbody/tr/td["+spanpgNum+"]//a[text()='...']")).isDisplayed())
					{
						totpageCount=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvWinsSearch']/tbody/tr[12]/td/table/tbody/tr/td|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[12]/td/table/tbody/tr/td")).size();
						for(int pagenum=2;pagenum<=totpageCount;pagenum++)
						{
						
								isFound=objSearch.verify_Search_Records(tcID,pagenumber, totRow, arrSearchCriteria, softAssert,"WINS",dataSearch.getData("AND_OR"));
							
								if(totRow>10)
								{
									func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
									try
									{
										getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvWinsSearch']/tbody/tr[12]/td/table/tbody/tr/td["+pagenum+"]/a|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[12]/td/table/tbody/tr/td["+pagenum+"]/a")).click();
										pagenumber=pagenumber+1;
										func._waitForPageToLoad(getWebDriver(),100L);
										 Thread.sleep(4000);
										
									}
									catch(Exception ex)
									{
										
									}
	
								}
								else
								{
									return isFound;	
								}
								
						}
						 spanpgNum=12;
					}
					
				}
				catch(Exception ex)
				{
					func._waitForPageToLoad(getWebDriver(),100L);
					Thread.sleep(5000);
					totpageCount=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvWinsSearch']/tbody/tr[12]/td/table/tbody/tr/td|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[12]/td/table/tbody/tr/td")).size();
					int intlastpageCount=objSearch.getSpanIndex(totpageCount, softAssert);

					for(int pagenum=intlastpageCount;pagenum<=totpageCount;pagenum++)
					{
					
						isFound=objSearch.verify_Search_Records(tcID,pagenumber, totRow, arrSearchCriteria, softAssert,"WINS",dataSearch.getData("AND_OR"));
						func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						try
						{
							getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvWinsSearch']/tbody/tr[12]/td/table/tbody/tr/td["+pagenum+"]/a|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[12]/td/table/tbody/tr/td["+pagenum+"]/a")).click();	
							pagenumber=pagenumber+1;
							func._waitForPageToLoad(getWebDriver(),100L);
							 Thread.sleep(4000);
						}
						catch(Exception e)
						{
							
						}
					}

					return isFound;	
	
				}
			}

			else
	
				{
					/*int totRow=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr")).size();*/
				totRow=totRow+1;
				isFound=objSearch.verify_Search_Records(tcID,pagenumber, totRow, arrSearchCriteria, softAssert,"WINS",dataSearch.getData("AND_OR"));
				
				/*for(int rowNum=2;rowNum<=totRow;rowNum++)
					{
						//expTotalRecord=expTotalRecord+1;
				
						for(int colNum=0;colNum<arrSearchCriteria.size();colNum++)
						{
							String ExpValue=arrSearchCriteria.get(colNum).toString().split(";")[1];
							int HeaderNum =Integer.valueOf(arrSearchCriteria.get(colNum).toString().split(";")[0]);
							//expTotalRecord=expTotalRecord+1;
							String cellValue=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvWinsSearch']/tbody/tr["+rowNum+"]/td[" + HeaderNum + "]")).getText();
							String actValue=cellValue.replace("$", "").replace(",", "");
							String ExpectValue=ExpValue.replace("$", "").replace(",", "");
							if(!actValue.trim().toLowerCase().contains(ExpectValue.trim().toLowerCase()))
							{
								CustomReporting.logReport("","", "As Expected WINS Search Result is not displayed correctly in the "+expTotalRecord +" row, "+HeaderNum +" col"+" for the search criteria entered '"+ExpectValue,"", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
								isFound=false;
								break;
							}
						}
						if(!isFound)
						{
							return isFound;
						
						}
					}*/
				}
			
		
		//}while(!(expTotalRecord >= totalRecord));
		return isFound;
		
	
	
	}
	
	
	@Override
	public void BillingCashSearchResult(String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{	
		PageData dataSearch =null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
		}
		Thread.sleep(5000);
		func._waitFor(getElement(btn_Searchtab), 100, WAIT_FOR.CLICKABLE, "");
		_click(getElement( btn_Searchtab));
		func._waitForPageToLoad(getWebDriver(),50L);
		func._waitFor(getElement( btn_Cancel), 500, WAIT_FOR.CLICKABLE, "");
	
		_click(getElement( btn_Cancel));
		func._waitForPageToLoad(getWebDriver(),50L);
		
		if(!dataSearch.getData("CheckNumber").equals(""))
		{
			_setValue(getElement(txt_CheckNumber),dataSearch.getData("CheckNumber"));
			
		}
		if(!dataSearch.getData("AmountReceived").equals(""))
		{
			_setValue(getElement(txt_AmountReceived),dataSearch.getData("AmountReceived"));
		}
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 _click(getElement( btn_Search));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 if(func._isVisible(getElement(msg_NoSearchResult)))
		 {
		    	
		    CustomReporting.logReport("","", "Search operation is failed and dispalyed as message as 'No Data available for this search criteria'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    throw new RuntimeException();
		 }
	     else
	     {

			Search objSearch = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
			objSearch.verify_SearchGrid(tcID, softAssert);
			if(!dataSearch.getData("CheckNumber").equals(""))
			{
				int colNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Check #", softAssert,"SEARCH");
				if(objSearch.verify_Search_Result(tcID, colNum, dataSearch.getData("CheckNumber"), softAssert))
				{
			    	CustomReporting.logReport("","","Check Number is displayed as Expected in search result" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "Check Number is not displayed as Expected in search result","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    }
			}
			if(!dataSearch.getData("AmountReceived").equals(""))
			{
				int colNum=objSearch.get_ColumnNum_InSearchGrid(tcID, "Amount Received" ,softAssert,"SEARCH");
				if(objSearch.verify_Search_Result(tcID, colNum, dataSearch.getData("AmountReceived"), softAssert))
				{
			    	CustomReporting.logReport("","","Amount Received is displayed as Expected in search result" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "Amount Received is not displayed as Expected in search result","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    }
				
			}
	     }
		
		
	}
	@Override
	public void Check_Default_SearchScreen(String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		_click(getElement( btn_Searchtab));
		Thread.sleep(3000);
		boolean isDefut=false;
		func._waitFor(getElement( btn_Cancel), 500, WAIT_FOR.CLICKABLE, "");
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		Thread.sleep(3000);
		//WebElement el=(WebElement) getElement(DefaultBusinessSegment).getNative();
		//System.out.println(el.getText());
		if(!DeviceName.equalsIgnoreCase("Internet Explorer"))
		{
			isDefut=func._getAttributeValue(getElement(DefaultBusinessSegment), "TEXT", softAssert).equals("All Business Segments");
		}
		else
		{
			isDefut=func._getAttributeValue(getElement(IEDefaultBusinessSegment), "TEXT", softAssert).equals("All Business Segments");
		}
		if(isDefut)
		//if(el.getText().equals("All Business Segments"))
		{
	    	CustomReporting.logReport("","","'All Business Segments' value is displayed as Default Business Segment Value on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "All Business Segments' value is not displayed as Default Business Search Value on search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._isEnabled(getElement(DefaultBusinessSegment)))
		{
	    	CustomReporting.logReport("","","'Business Segment drop down Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Business Segment drop down Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_AccountNumber), "TEXT", "Account Number", softAssert))
		{
	    	CustomReporting.logReport("","","'Account Number Field is displayed  as 'Account Number' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Account Number Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_AccountNumber), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }	
		func._checkAttributeValue(getElement(txt_AccountNumber), "value", " ", softAssert);
		if(func._isEnabled(getElement(txt_AccountNumber)))
		{
	    	CustomReporting.logReport("","","'Account Number Text Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Account Number Text Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
		if(func._checkAttributeValue(getElement(lbl_FEIN), "TEXT", "FEIN", softAssert))
		{
	    	CustomReporting.logReport("","","'FEIN Field is displayed  as 'FEIN' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "FEIN Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_FEIN), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(txt_FEIN), "value", " ", softAssert);
		if(func._isEnabled(getElement(txt_FEIN)))
		{
	    	CustomReporting.logReport("","","'FEIN Text Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "FEIN Text Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
		if(func._checkAttributeValue(getElement(lbl_InsuredName), "TEXT", "Insured Name", softAssert))
		{
	    	CustomReporting.logReport("","","'Insured Name Field is displayed  as 'Insured Name' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Insured Name Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_InsuredName), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(txt_InsuredName), "value", " ", softAssert);
		if(func._isEnabled(getElement(txt_InsuredName)))
		{
	    	CustomReporting.logReport("","","'Insured Name Text Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Insured Name Text Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
		if(func._checkAttributeValue(getElement(lbl_MailAddress), "TEXT", "Mailing Street Address", softAssert))
		{
	    	CustomReporting.logReport("","","'Mailing Address Field is displayed  as 'Mailing Street Address' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Mailing Street Address Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_MailAddress), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(txt_MailingAddress), "value", " ", softAssert);
		if(func._isEnabled(getElement(txt_MailingAddress)))
		{
	    	CustomReporting.logReport("","","'Mailing Address Text Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Mailing Address Text Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
		
		if(func._checkAttributeValue(getElement(lbl_MailCity), "TEXT", "Mailing City", softAssert))
		{
	    	CustomReporting.logReport("","","'MailCity Field is displayed  as 'Mailing City' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Mailing City Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_MailCity), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(txt_MailingCity), "value", " ", softAssert);
		if(func._isEnabled(getElement(txt_MailingCity)))
		{
	    	CustomReporting.logReport("","","Mailing City Text Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Mailing City Text Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
		if(func._checkAttributeValue(getElement(lbl_MailState), "TEXT", "Mailing State", softAssert))
		{
	    	CustomReporting.logReport("","","'Mailing State Field is displayed  as 'Mailing State' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Mailing State Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_MailState), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(lst_MailingState), "TEXT", "make selection", softAssert);
		if(func._isEnabled(getElement(lst_MailingState)))
		{
	    	CustomReporting.logReport("","","Mailing State drop Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Mailing State drop Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
		if(func._checkAttributeValue(getElement(lbl_MailZipCode), "TEXT", "Mailing Zip Code", softAssert))
		{
	    	CustomReporting.logReport("","","'MailZipCode Field is displayed  as 'Mailing Zip Code' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "MailZipCode Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_MailZipCode), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(txt_MailZipCode), "value", " ", softAssert);
		if(func._isEnabled(getElement(txt_MailZipCode)))
		{
	    	CustomReporting.logReport("","","Mailing ZIPCode Text Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Mailing ZIPCode Text Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }

		if(func._checkAttributeValue(getElement(lbl_SubmissionNum), "TEXT", "Submission Number", softAssert))
		{
	    	CustomReporting.logReport("","","'SubmissionNumber Field is displayed  as 'Submission Number' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "SubmissionNumber Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_SubmissionNum), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(txt_SubmissionNumber), "value", " ", softAssert);
		if(func._isEnabled(getElement(txt_SubmissionNumber)))
		{
	    	CustomReporting.logReport("","","Submission number Text Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Submission number Text Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_SubmissionStatus), "TEXT", "Submission Status", softAssert))
		{
	    	CustomReporting.logReport("","","'Submission Status Field is displayed  as 'Submission Status' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Submission Status Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_SubmissionStatus), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT", "make selection", softAssert);
		if(func._isEnabled(getElement(lst_SubmissionStatus)))
		{
	    	CustomReporting.logReport("","","Submission Status Dropdown Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Submission Status Dropdown Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_PredominantState), "TEXT", "Predominant State", softAssert))
		{
	    	CustomReporting.logReport("","","'PredominantState Field is displayed  as 'Predominant State' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "PredominantState Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_PredominantState), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(lst_PredominantState), "TEXT", "make selection", softAssert);
		if(func._isEnabled(getElement(lst_PredominantState)))
		{
	    	CustomReporting.logReport("","","PredominantState Dropdown Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "PredominantState Dropdown Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_SubmissionLOB), "TEXT", "Submitted Line of Business", softAssert))
		{
	    	CustomReporting.logReport("","","'SubmissionLOB Field is displayed  as 'Submitted Line of Business' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "SubmissionLOB Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_SubmissionLOB), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(lst_SubmittedLOB), "TEXT", "make selection", softAssert);
		if(func._isEnabled(getElement(lst_SubmittedLOB)))
		{
	    	CustomReporting.logReport("","","SubmissionLOB Dropdown Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "SubmissionLOB Dropdown Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
		if(func._checkAttributeValue(getElement(lbl_MarketSegment), "TEXT", "Market Segment", softAssert))
		{
	    	CustomReporting.logReport("","","'MarketSegment Field is displayed  as 'Market Segment' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "MarketSegment Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_MarketSegment), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(lst_MarketSegment), "TEXT", "make selection", softAssert);
		if(func._isEnabled(getElement(lst_MarketSegment)))
		{
	    	CustomReporting.logReport("","","MarketSegment Dropdown Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "MarketSegment Dropdown Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_Distribution), "TEXT", "Distribution", softAssert))
		{
	    	CustomReporting.logReport("","","'Distribution Field is displayed  as 'Distribution' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Distribution Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_Distribution), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(lst_Distribution), "TEXT", "make selection", softAssert);
		if(func._isEnabled(getElement(lst_Distribution)))
		{
	    	CustomReporting.logReport("","","Distribution Dropdown Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Distribution Dropdown Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_ProducerName), "TEXT", "Producer Name", softAssert))
		{
	    	CustomReporting.logReport("","","'ProducerName Field is displayed  as 'Producer Name' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "ProducerName Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_ProducerName), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(lst_ProducerName), "TEXT", "make selection", softAssert);
		if(func._isEnabled(getElement(lst_ProducerName)))
		{
	    	CustomReporting.logReport("","","ProducerName Dropdown Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "ProducerName Dropdown Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_ProducerOffice), "TEXT", "Producer Office", softAssert))
		{
	    	CustomReporting.logReport("","","'ProducerOffice Field is displayed  as 'Producer Office' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "ProducerOffice Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_ProducerOffice), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(lst_ProducerOffice), "TEXT", "make selection", softAssert);
		if(func._isEnabled(getElement(lst_ProducerOffice)))
		{
	    	CustomReporting.logReport("","","ProducerOffice Dropdown Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "ProducerOffice Dropdown Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
		if(func._checkAttributeValue(getElement(lbl_BranchOffice), "TEXT", "Branch Office", softAssert))
		{
	    	CustomReporting.logReport("","","'BranchOffice Field is displayed  as 'Branch Office' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "BranchOffice Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_BranchOffice), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(lst_BranchOffice), "TEXT", "make selection", softAssert);
		if(func._isEnabled(getElement(lst_BranchOffice)))
		{
	    	CustomReporting.logReport("","","BranchOffice Dropdown Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "BranchOffice Dropdown Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_Underwriter), "TEXT", "Underwriter", softAssert))
		{
	    	CustomReporting.logReport("","","'Underwriter Field is displayed  as 'Underwriter' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Underwriter Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_Underwriter), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(lst_Underwriter), "TEXT", "make selection", softAssert);
		if(func._isEnabled(getElement(lst_Underwriter)))
		{
	    	CustomReporting.logReport("","","Underwriter Dropdown Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Underwriter Dropdown Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_SubEffDate_greater), "TEXT", "Submission Eff Date >=", softAssert))
		{
	    	CustomReporting.logReport("","","'SubEffDate >= Field is displayed  as 'Submission Eff Date >=' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "SubEffDate >= Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_SubEffDate_greater), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(dat_SubmissionEffDateAfter), "value", " ", softAssert);
		if(func._isEnabled(getElement(dat_SubmissionEffDateAfter)))
		{
	    	CustomReporting.logReport("","","SubEffDate >= Text Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "SubEffDate >= Text Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_SubEffDate_Less), "TEXT", "Submission Eff Date <=", softAssert))
		{
	    	CustomReporting.logReport("","","'SubEffDate <= Field is displayed  as 'Submission Eff Date <=' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "SubEffDate <= Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_SubEffDate_Less), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(dat_SubmissionEffDateBefore), "value", " ", softAssert);
		if(func._isEnabled(getElement(dat_SubmissionEffDateBefore)))
		{
	    	CustomReporting.logReport("","","SubEffDate <= Text Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "SubEffDate <= Text Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
		
		if(func._checkAttributeValue(getElement(lbl_PolicyNumber), "TEXT", "Policy Number", softAssert))
		{
	    	CustomReporting.logReport("","","PolicyNumber Field is displayed  as 'Policy Number' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "PolicyNumber Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_PolicyNumber), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(txt_PolicyNumber), "value", " ", softAssert);
		if(func._isEnabled(getElement(txt_PolicyNumber)))
		{
	    	CustomReporting.logReport("","","PolicyNumber Text Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "PolicyNumber Text Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_PolicyStatus), "TEXT", "Policy Status", softAssert))
		{
	    	CustomReporting.logReport("","","PolicyStatus Field is displayed  as 'Policy Status' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "PolicyStatus Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_PolicyStatus), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(lst_PolicyStatus), "TEXT", "make selection", softAssert);
		if(func._isEnabled(getElement(lst_PolicyStatus)))
		{
	    	CustomReporting.logReport("","","PolicyStatus Dropdown Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "PolicyStatus Dropdown Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_CancelledReasonCode), "TEXT", "Cancelled Reason Code", softAssert))
		{
	    	CustomReporting.logReport("","","CancelledReasonCode Field is displayed  as 'Cancelled Reason Code' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "CancelledReasonCode Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_CancelledReasonCode), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(lst_CancelledReasonCode), "TEXT", "make selection", softAssert);
		if(func._isEnabled(getElement(lst_CancelledReasonCode)))
		{
	    	CustomReporting.logReport("","","CancelledReasonCode Dropdown Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "CancelledReasonCode Dropdown Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_RenewalStatus), "TEXT", "Renewal Status", softAssert))
		{
	    	CustomReporting.logReport("","","RenewalStatus Field is displayed  as 'Cancelled Reason Code' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "RenewalStatus Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_RenewalStatus), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(lst_RenewalStatus), "TEXT", "make selection", softAssert);
		if(func._isEnabled(getElement(lst_RenewalStatus)))
		{
	    	CustomReporting.logReport("","","RenewalStatus Dropdown Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "RenewalStatus Dropdown Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
		if(func._checkAttributeValue(getElement(lbl_PaymentDueDateFrom), "TEXT", "Payment Due Date From", softAssert))
		{
	    	CustomReporting.logReport("","","PaymentDueDateFrom Field is displayed  as 'Payment Due Date From' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "PaymentDueDateFrom Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_PaymentDueDateFrom), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(dat_PaymentDueDateAfter), "value", " ", softAssert);
		if(func._isEnabled(getElement(dat_PaymentDueDateAfter)))
		{
	    	CustomReporting.logReport("","","PaymentDueDateFrom Text Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "PaymentDueDateFrom Text Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_PaymentDueDateTo), "TEXT", "To", softAssert))
		{
	    	CustomReporting.logReport("","","PaymentDueDateTo Field is displayed  as 'To' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "PaymentDueDateTo Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_PaymentDueDateTo), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(dat_PaymentDueDateBefore), "value", " ", softAssert);
		if(func._isEnabled(getElement(dat_PaymentDueDateBefore)))
		{
	    	CustomReporting.logReport("","","PaymentDueDateTo Text Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "PaymentDueDateTo Text Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_PolicyEffectiveDateFrom), "TEXT", "Policy Effective Date From", softAssert))
		{
	    	CustomReporting.logReport("","","PolicyEffectiveDateFrom Field is displayed  as 'Policy Effective Date From' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "PolicyEffectiveDateFrom Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_PolicyEffectiveDateFrom), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(txt_PolicyEffectiveDateFrom), "value", " ", softAssert);
		if(func._isEnabled(getElement(txt_PolicyEffectiveDateFrom)))
		{
	    	CustomReporting.logReport("","","PolicyEffectiveDateFrom Text Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "PolicyEffectiveDateFrom Text Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._checkAttributeValue(getElement(lbl_PolicyEffectiveDateTo), "TEXT", "To", softAssert))
		{
	    	CustomReporting.logReport("","","PolicyEffectiveDateTo Field is displayed  as 'To' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "PolicyEffectiveDateTo Field is displayed on search Search as '"+ func._getAttributeValue(getElement(lbl_PolicyEffectiveDateTo), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		func._checkAttributeValue(getElement(txt_PolicyEffectiveDateFrom), "value", " ", softAssert);
		if(func._isEnabled(getElement(txt_PolicyEffectiveDateFrom)))
		{
	    	CustomReporting.logReport("","","PolicyEffectiveDateTo Text Box is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "PolicyEffectiveDateTo Text Box is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
		if(func._checkAttributeValue(getElement(radio_And), "value", "AND", softAssert))
		{
	    	CustomReporting.logReport("","","AND radio Button Field is displayed  as 'AND' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "AND Field is displayed on search Search as '"+ func._getAttributeValue(getElement(radio_And), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._isChecked(getElement(radio_And)))
		{
	    	CustomReporting.logReport("","","AND radio Button is selected defaultly on search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "AND radio Button is not selected defaultly on search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._isEnabled(getElement(radio_And)))
		{
	    	CustomReporting.logReport("","","AND radio Button is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "AND radio Button is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
		if(func._checkAttributeValue(getElement(radio_Or), "value", "OR", softAssert))
		{
	    	CustomReporting.logReport("","","OR radio Button Field is displayed  as 'OR' on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "OR Field is displayed on search Search as '"+ func._getAttributeValue(getElement(radio_Or), "TEXT", softAssert)+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(!func._isChecked(getElement(radio_Or)))
		{
	    	CustomReporting.logReport("","","OR radio Button is not selected defaultly on search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "OR radio Button is  selected defaultly on search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		if(func._isEnabled(getElement(radio_Or)))
		{
	    	CustomReporting.logReport("","","OR radio Button is displayed as enabled on Search screen " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "OR radio Button is not displayed as enabled on Search screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
		
	}
	@Override
	public void verify_NonBillinguser_SearchGrid(String tcID,SoftAssert softAssert,String SearchType) throws Exception
	{
		if(SearchType.trim().toUpperCase().equals("SEARCH"))
		{

	    	 WebElement elSearch=(WebElement) getElement(SearchTitle).getNative();
	    
	    	 if(elSearch.getText().trim().equals("Search Results - 0 records"))
			 {
			    	
			    CustomReporting.logReport("","", "Search operation is failed and dispalyed as message as '"+elSearch.getText(),"", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    throw new RuntimeException();
			 }
	    	 else
	    	 {

				int totHeader=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[1]/th|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[1]/th")).size();
				String HeaderValue="";
				for(int i=1;i<=totHeader;i++)
				{
					try
					{
						WebElement we=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[1]/th["+ i +"]/a|//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[1]/th["+i+"]/a"));
																		
						if(we.isDisplayed())
						{
							HeaderValue=HeaderValue+we.getText()+";";
		
						}
					}
					catch(Exception e)
					{
						CustomReporting.logReport("","", "Column Header prasent in row num '"+ i +"' is not displayed as Link in search grid","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
					}
				}
	    	 
				
				CustomReporting.logReport("Following headers are displaying as Link in search result grid - "+HeaderValue);
	    	 }
		}
    	 if(SearchType.trim().toUpperCase().equals("WINS"))
    	 {
	    	 WebElement elWins=(WebElement) getElement(SearchWinsTitle).getNative();
			 if(elWins.getText().trim().equals("Results From WINS - 0 records"))
			 {
				 CustomReporting.logReport("","", "WINS Search operation is failed and dispalyed as message as '"+elWins.getText()+"'","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			   
			 }
			 else
			 {
				 int totHeader=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvWinsSearch']/tbody/tr[1]/th")).size();
				 													
				 String HeaderValue="";
					for(int i=1;i<=totHeader;i++)
					{
						try
						{
							WebElement we=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvWinsSearch']/tbody/tr[1]/th["+ i +"]/a"));
							if(we.isDisplayed())
							{
								HeaderValue=HeaderValue+we.getText()+";";
			
							}
						}
						catch(Exception e)
						{
							CustomReporting.logReport("","", "Column Header prasent in row num '"+ i +"' is not displayed as Link in WINS search grid","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
						}
					}
					
					CustomReporting.logReport("Following headers are displaying as Link in WINS search  result grid - "+HeaderValue);
				 
			 }
    	 }
	     
	}
	
	
	@Override
	public void verify_SearchFilter_Result(String tcID,SoftAssert softAssert,String DeviceName) throws Exception
	{
		PageData dataSearch =null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
		}
		Search objSearch = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
		
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		 WebElement elSearch=(WebElement) getElement(SearchTitle).getNative();
		 if(elSearch.getText().trim().contains("Search Results - 0 records"))
		 {
		    	
		    CustomReporting.logReport("","", "Search operation is failed and dispalyed as message as '"+elSearch.getText(),"", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    throw new RuntimeException();
		 }
    	 else
    	 {
		
    		 boolean isVerified=objSearch.verify_General_Search_Result(tcID, softAssert, DeviceName);
    		 if(isVerified)

			{
		    	CustomReporting.logReport("","","As Expected Search Result is displayed correctly" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		    	if(dataSearch.getData("AND_OR").toUpperCase().equals("AND"))
    			{
		    		CustomReporting.logReport("","","Verified that the combination for 'And' operator displayed records together that contain all entered search parameters" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
    		
    			}
		    	if(dataSearch.getData("AND_OR").toUpperCase().equals("OR"))
    			{
		    		CustomReporting.logReport("","","Verified that the combination for 'OR' operator displayed records together that contain all entered search parameters" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
    		
    			}
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "As Expected Search Result is not displayed correctly","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	if(dataSearch.getData("AND_OR").toUpperCase().equals("AND"))
    			{
		    		CustomReporting.logReport("","","The combination for 'And' operator records are not displayed together on search result" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
    		
    			}
		    	if(dataSearch.getData("AND_OR").toUpperCase().equals("OR"))
    			{
		    		CustomReporting.logReport("","","The combination for 'And' operator records are not displayed together on search result" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
    		
    			}
		    }
    	 }
		
		
		
	}
	
	
	@Override
	public void verify_WINSSearchFilter_Result(String tcID,SoftAssert softAssert,String DeviceName) throws Exception
	{
		
		Search objSearch = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
		
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		if(objSearch.verify_WINS_Search_Result(tcID, softAssert, DeviceName))

			{
		    	CustomReporting.logReport("","","As Expected WINS Search Result is displayed perfectly" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "As Expected WINS Search Result is not displayed perfectly","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    }
		
		
	}
	
	@Override
	public boolean verify_Search_Result(String tcID,int ColNum,String ExpValue, SoftAssert softAssert) throws Exception
	{
		
		_setValue(getElement(lst_RecordsPerPage),"10");
		func._waitForPageToLoad(getWebDriver(),50L);
		int totpageCount=2;
		int totRow=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr")).size();
		if(totRow>10)
		{
			totRow=totRow-1;
			totpageCount=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[12]/td/table/tbody/tr/td")).size();
			
		}
		boolean isFound=false;
		 
		for(int pagenum=2;pagenum<=totpageCount;pagenum++)
		{
			for(int i=2;i<=totRow;i++)
			{
				String cellValue=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr["+i+"]/td[" + ColNum+"]")).getText();
				String expValue=cellValue.replace("$", "").replace(",", "");
	
				if(expValue.trim().toLowerCase().equals(ExpValue.trim().toLowerCase()))
				{
					isFound=true;
					break;
				}
					
			}
			if(isFound)
			{
				return isFound;
			
			}
			else if(totRow>10)
			{
				getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[12]/td/table/tbody/tr/td["+pagenum+"]/a")).click();
			}
			else
			{
				return isFound;	
			}
			
		}
		return isFound;
		
	
	
	}
	
	@Override
	public boolean verify_Search_Records(String tcID,int intpagenum,int totRow,ArrayList arrSearchCriteria, SoftAssert softAssert,String SearchType,String Operator) throws Exception
	{
		boolean isFound=true;
		String cellValue="";
		Search objSearch = (Search) PageManager.instance().createPage( Search.class, getWebDriver());
		for(int rowNum=2;rowNum<=totRow;rowNum++)
		{
			for(int colNum=0;colNum<arrSearchCriteria.size();colNum++)
			{
				String ExpValue=arrSearchCriteria.get(colNum).toString().split(";")[1];
				String Headername="";
				int HeaderNum =Integer.valueOf(arrSearchCriteria.get(colNum).toString().split(";")[0]);
				if(SearchType.trim().toUpperCase().equals("WINS"))
				{
					Headername=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvWinsSearch']/tbody/tr[1]/th[" + HeaderNum + "]/a|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[1]/th[" + HeaderNum +"]/a")).getText();
				}
				else
				{
					Headername=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr[1]/th[" + HeaderNum + "]/a|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[1]/th[" + HeaderNum +"]/a")).getText();
				}
				if(SearchType.trim().toUpperCase().equals("SEARCH"))
				{
					cellValue=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvPaymentSearch']/tbody/tr["+rowNum+"]/td[" + HeaderNum + "]|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr["+rowNum+"]/td[" + HeaderNum +"]")).getText();
				}
				if(SearchType.trim().toUpperCase().equals("WINS"))
				{
					cellValue=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvWinsSearch']/tbody/tr["+rowNum+"]/td[" + HeaderNum + "]|//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr["+rowNum+"]/td[" + HeaderNum +"]")).getText();
					 											
				}
				
				String actValue=cellValue.replace("$", "").replace(",", "");
				String ExpectValue=ExpValue.replace("$", "").replace(",", "");
				if(Operator.toUpperCase().equals("AND"))
				{
					if(Headername.contains("Effective Date"))
					{
						
						isFound=objSearch.Verify_SearchResult_EffectiveDate(tcID, softAssert, cellValue);
						
					}
					else
					{
					
						if(!actValue.trim().toLowerCase().contains((ExpectValue.trim().toLowerCase())))
						{
							if(SearchType.trim().toUpperCase().equals("WINS"))
								{
									CustomReporting.logReport("","", "As Expected WINS Search Result is not displayed correctly in the "+HeaderNum +" col , "+rowNum +" row ,"+intpagenum+" page for the search criteria entered '"+cellValue,"", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
									
								}
							if(SearchType.trim().toUpperCase().equals("SEARCH"))
								{
								CustomReporting.logReport("","", "As Expected Search Result is not displayed correctly in the "+HeaderNum +" col , "+rowNum +" row ,"+intpagenum+" page for the search criteria entered '"+cellValue,"", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
								}
							isFound=false;
							break;
						}
					}
				}
				if(Operator.toUpperCase().equals("OR"))
				{
					if(Headername.contains("Effective Date"))
					{
						
						isFound=objSearch.Verify_SearchResult_EffectiveDate(tcID, softAssert, cellValue);
						
					}
					else
					{
						if(actValue.trim().toLowerCase().contains((ExpectValue.trim().toLowerCase())))
					
						{
							
							isFound=true;
							break;
						}
					}
					
				}
			
			
		
			}
			if(!isFound &&Operator.toUpperCase().equals("OR"))
			{
			
				if(SearchType.trim().toUpperCase().equals("WINS"))
				{
					CustomReporting.logReport("","", "As Expected WINS Search Result is not displayed correctly in the "+rowNum +" row ,"+intpagenum+" page for the search criteria entered '"+cellValue,"", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
					
				}
				if(SearchType.trim().toUpperCase().equals("SEARCH"))
				{
					CustomReporting.logReport("","", "As Expected Search Result is not displayed correctly in the "+rowNum +" row ,"+intpagenum+" page for the search criteria entered '"+cellValue,"", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				}
			}
		
			if(!isFound)
			{
				return isFound;
			
			}
		}
		return isFound;
	}

	@Override
	public int getSpanIndex(int pageCount, SoftAssert softAssert) throws Exception
	{
		int spanpageCount=0;
		for(int i=1;i<=pageCount;i++)
		{
			try
			{
				if(getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[12]/td/table/tbody/tr/td["+i+"]/a")).isDisplayed())
				{
					
				}
			}
			catch(Exception ex)
			{
				spanpageCount= i+1;
			}
			
		}
		return spanpageCount;
	}
	
	@Override
	public void Verify_CommCol_DisplayPlace (String tcID, SoftAssert softAssert) throws Exception
	{
		_click(getElement( btn_Searchtab));
		Thread.sleep(3000);
		func._waitFor(getElement( btn_Cancel), 500, WAIT_FOR.CLICKABLE, "");
		_click(getElement( btn_Cancel));
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		_click(getElement( btn_Search));
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		 func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		boolean isDispalyed=false;
		
		int totHeader=getWebDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[1]/th")).size();

		for(int i=1;i<=totHeader;i++)
		{
			WebElement we=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvSearch']/tbody/tr[1]/th["+ i +"]/a"));
			if(we.getText().trim().equals("Premium"))
			{
				if(we.getText().trim().equals("Comm.%"))
				{
					if(we.getText().trim().equals("Taxes, Fees / Surcharges"))
					{
						isDispalyed=true;
						break;

					}
				}
			}
			
			
		}
		if(isDispalyed)
		{
			CustomReporting.logReport("","","Agency Bill 'Commission' Column field is displayed between 'Premium Billing' and 'Taxes, Fees and Surcharges' columns" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			
		}
		else
		{
			
			CustomReporting.logReport("", "","Agency Bill 'Commission' Column field is not displayed between 'Premium Billing' and 'Taxes, Fees and Surcharges' columns","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			throw new RuntimeException();
		}
	}
	@Override
	public void Verify_Renewal_Records_InSearchScreen (String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),100L);
		_click(getElement( btn_Searchtab));
		Thread.sleep(3000);
		func._waitFor(getElement( btn_Cancel), 500, WAIT_FOR.CLICKABLE, "");
		_click(getElement( btn_Cancel));
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(1000);
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		PageData dataSearch = null;
	
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
		}
		if(!dataSearch.getData("BusinessSegment").equals(""))
		{
			/*if(!DeviceName.equalsIgnoreCase("Internet Explorer"))
			{*/
				_click(getElement(img_clearselection));
				func._waitForPageToLoad(getWebDriver(),50L);
				_click(getElement( lst_clkSelectBusinessSegment));
				func._waitForPageToLoad(getWebDriver(),50L);
				_click(getClonedElement(opt_ChoseBusinessSegment).addToken("tkn_BusinessSegment",dataSearch.getData("BusinessSegment")));

				func._waitForPageToLoad(getWebDriver(),50L);
				
				
			/*}
			else
			{
				_click(getElement( lst_clkIESelectBusinessSegment));
				func._waitForPageToLoad(getWebDriver(),50L);

				_click(getClonedElement(opt_IEChoseBusinessSegment).addToken("tkn_BusinessSegment",dataSearch.getData("BusinessSegment")));
				func._waitForPageToLoad(getWebDriver(),50L);
			
			}
*/
		}
		Thread.sleep(2000);
		if(!dataSearch.getData("AccountNumber").equals(""))
		{

			if(dataSearch.getData("AccountNumber").indexOf("-")>0)
			{
				_setValue(getElement(txt_AccountNumber),dataSearch.getData("AccountNumber").split("-")[0]);
			}
			else
			{
				_setValue(getElement(txt_AccountNumber),dataSearch.getData("AccountNumber"));
			}

				
		}
		if(!dataSearch.getData("SubmissionNumber").equals(""))
		{
			if(dataSearch.getData("SubmissionNumber").indexOf("-")>0)
			{
				_setValue(getElement(txt_SubmissionNumber),dataSearch.getData("SubmissionNumber").split("-")[0]);
			}
			else
			{
			_setValue(getElement(txt_SubmissionNumber),dataSearch.getData("SubmissionNumber"));
			}
			
		}
		 func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		  _click(getElement( btn_Search));
		  func._waitForPageToLoad(getWebDriver(),50L);
		  Thread.sleep(2000);
		  func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if(func._isVisible(getClonedElement(lnk_AccountNum).addToken("tkn_ACCOUNTNUMBER",dataSearch.getData("Renewal_Acc_num"))))
	    {
			if(func._isVisible(getClonedElement(lnk_SubmissionNum).addToken("tkn_SUBNUM",dataSearch.getData("SubmissionNumber"))))
			{			
	    	CustomReporting.logReport("","","Verified that renewal records are displayed on search screen when user search for Account number and submission number after reneweled the submission. " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			}
		    else
		    {
		    	CustomReporting.logReport("","", "Renewal records are not displayed on search screen when user search for Account number and submission number after reneweled the submission ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	throw new RuntimeException();
		    }
	    }
		
		
	}
	
	@Override
	public boolean Verify_SearchResult_EffectiveDate (String tcID, SoftAssert softAssert,String cellValue) throws Exception
	{
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
		boolean isFound=true;
		String SubEffDateBefore="";
		String SubEffDateAfter="";
		DateFormat formatter=null;
		Date expSubEffBeforeDate=null;
		Date expSubEffAfterDate=null;

		formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date actSubEffDate = (Date)formatter.parse(cellValue); 
		if(!dataSearch.getData("SubmissionEffDateAfter").equals(""))
		{
			if(dataSearch.getData("SubmissionEffDateAfter").toUpperCase().equals("NOW"))
			{
				SubEffDateAfter=func.Date_Manipulation("","Now", 0);
			}
			else
			{
				Date date = DateUtils.addDays(new Date(),Integer.parseInt(dataSearch.getData("SubmissionEffDateAfter")));
                SubEffDateAfter = new SimpleDateFormat("MM/dd/yyyy").format(date);
			
			}
			
			formatter = new SimpleDateFormat("MM/dd/yyyy");
			expSubEffAfterDate = (Date)formatter.parse(SubEffDateAfter);
		}
		if(!dataSearch.getData("SubmissionEffDateBefore").equals(""))
		{
			if(dataSearch.getData("SubmissionEffDateBefore").toUpperCase().equals("NOW"))
			{
				SubEffDateBefore=func.Date_Manipulation("","Now", 0);
		    	
				
			}
			else
			{
				Date date = DateUtils.addDays(new Date(),Integer.parseInt(dataSearch.getData("SubmissionEffDateBefore")));
				SubEffDateBefore = new SimpleDateFormat("MM/dd/yyyy").format(date);
			}
			formatter = new SimpleDateFormat("MM/dd/yyyy");
			expSubEffBeforeDate = (Date)formatter.parse(SubEffDateBefore);
		}

		if((!dataSearch.getData("SubmissionEffDateBefore").equals(""))&&(!dataSearch.getData("SubmissionEffDateAfter").equals("")))
		{
			if((!(actSubEffDate.compareTo(expSubEffAfterDate)>=0))&&(!(actSubEffDate.compareTo(expSubEffBeforeDate)<=0)))
			{

				isFound=false;
			}
		}
		else
		{
			
			if((!dataSearch.getData("SubmissionEffDateBefore").equals(""))&&(!(actSubEffDate.compareTo(expSubEffAfterDate)>=0)))
			{
				isFound=false;
				
			}
			if((!dataSearch.getData("SubmissionEffDateBefore").equals(""))&&(!(actSubEffDate.compareTo(expSubEffBeforeDate)<=0)))
			
			{
				isFound=false;
				
			}
			
		}

		return isFound;
	}
	
	@Override
	public void Verify_SubDesc_lenght_SearchResult(String tcID, SoftAssert softAssert) throws Exception
	{
		String strSubnum=null;
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
		 func._waitForPageToLoad(getWebDriver(),50L);
		  Thread.sleep(2000);
		PageData dataSearch = null;
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
		}
		if(!dataSearch.getData("SubmissionNumber").equals(""))
		{
			if(dataSearch.getData("SubmissionNumber").indexOf("-")>0)
			{
				strSubnum=dataSearch.getData("SubmissionNumber").split("-")[0];
				
			}
			else
			{
				strSubnum=dataSearch.getData("SubmissionNumber");
			 
			}
		}
		WebElement el=(WebElement)getClonedElement(lnk_SubmissionNum).addToken("tkn_SUBNUM",strSubnum).getNative();
		String actSubDesc=el.getText().split("\n")[1].trim();
		String expSubDesc=null;
		if(!actSubDesc.equals(""))
		{
			if(dataNewSubmission.getData("SubDescription").length()>10)
			{
				expSubDesc=dataNewSubmission.getData("SubDescription").substring(0, 10)+"...";
			}
			else
			{
				expSubDesc=dataNewSubmission.getData("SubDescription");	
			}
			if(actSubDesc.equals(expSubDesc.trim()))
			{			
				CustomReporting.logReport("","","Verified that the Submission description appears on search result page" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			}
		    else
		    {
		    	CustomReporting.logReport("","", "the Submission description is not appeared on search result page ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	throw new RuntimeException();
		    }
		}
		if(dataNewSubmission.getData("SubDescription").length()>10)
		{
			expSubDesc=dataNewSubmission.getData("SubDescription").substring(0, 10)+"...";
		
			if(actSubDesc.equals(expSubDesc.trim()))
			{			
				CustomReporting.logReport("","","Verified that the Submission description limit to 10 characters in the search result" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			}
		    else
		    {
		    	CustomReporting.logReport("","", "The Submission description is not limit to 10 characters in the search result","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	throw new RuntimeException();
		    }
		}
		
		
	}

	@Override
	public void NewBusiness_Search(String tcID, SoftAssert softAs) throws Exception 
	{
		func._waitForPageToLoad(getWebDriver(),500L);
		Thread.sleep(3000);
		PageData dataNewBusinessSearch = null;
		dataNewBusinessSearch = PageDataManager.instance().getPageData("NewBusiness",tcID);
		_click(getElement( btn_Searchtab));
		Thread.sleep(5000);
		func._waitForPageToLoad(getWebDriver(),500L);
		String strSubnum=null;
		func._waitFor(getElement( btn_Cancel), 500, WAIT_FOR.CLICKABLE, "");
	
		_click(getElement( btn_Cancel));
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		if(!dataNewBusinessSearch.getData("BusinessSegment").equals(""))
		{
				/*if(!DeviceName.equalsIgnoreCase("Internet Explorer"))
				{*/
					_click(getElement(img_clearselection));
					func._waitForPageToLoad(getWebDriver(),50L);
					_click(getElement( lst_clkSelectBusinessSegment));
					func._waitForPageToLoad(getWebDriver(),50L);
					_click(getClonedElement(opt_ChoseBusinessSegment).addToken("tkn_BusinessSegment",dataNewBusinessSearch.getData("BusinessSegment")));
		
					func._waitForPageToLoad(getWebDriver(),50L);
				/*}
				else
				{
						_click(getElement( lst_clkIESelectBusinessSegment));
						func._waitForPageToLoad(getWebDriver(),50L);
						 _click(getClonedElement(opt_IEChoseBusinessSegment).addToken("tkn_BusinessSegment",dataSearch.getData("BusinessSegment")));
						func._waitForPageToLoad(getWebDriver(),50L);
				}*/
				
			}
			
		if(!dataNewBusinessSearch.getData("SubmissionNumber").equals(""))
		{
			if(dataNewBusinessSearch.getData("SubmissionNumber").indexOf("-")>0)
			{
				strSubnum=dataNewBusinessSearch.getData("SubmissionNumber").split("-")[0];
				_setValue(getElement(txt_SubmissionNumber),strSubnum);
			}
			else
			{
				strSubnum=dataNewBusinessSearch.getData("SubmissionNumber");
			  _setValue(getElement(txt_SubmissionNumber),strSubnum);
			}
		}
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement( btn_Search));
		func._waitForPageToLoad(getWebDriver(),100L);
		Thread.sleep(3000);
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		Thread.sleep(3000);
		if(func._isVisible(getClonedElement(lnk_SubmissionNum).addToken("tkn_SUBNUM",strSubnum)))
	    {
	    	CustomReporting.logReport("","","Submission number is searched successfully in search result" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Submission Number search failed in search result ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
	}

	@Override
	public void Open_NewBusiness_Search_Result(String tcID, SoftAssert softAs) throws Exception 
	{
		String strSubnum=null;
		PageData dataNewBusiness =null;
		 dataNewBusiness = PageDataManager.instance().getPageData("NewBusiness",tcID);
		
		 
		if(!dataNewBusiness.getData("SubmissionNumber").equals(""))
		{
			if(dataNewBusiness.getData("SubmissionNumber").indexOf("-")>0)
			{
				strSubnum=dataNewBusiness.getData("SubmissionNumber").split("-")[0];
				
			}
			else
			{
				strSubnum=dataNewBusiness.getData("SubmissionNumber");
		
			}
		}
	
		Thread.sleep(2000);
		_click(getClonedElement(lnk_SubmissionNum).addToken("tkn_SUBNUM",strSubnum));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(3000);
		
	}
	
	@Override
	public void verify_OceanWide_AccountDetails(String tcID, SoftAssert softAssert, String DeviceName,
			String Application) throws Exception {
		PageData dataSearch = null;
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		PageData NewBusiness = PageDataManager.instance().getPageData("NewBusiness",tcID);
		
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
		}
		
		_click(getElement( btn_Searchtab));
		func._waitForPageToLoad(getWebDriver(),50L);
		
		func._waitFor(getElement( btn_Cancel), 500, WAIT_FOR.CLICKABLE, "");
		_click(getElement( btn_Cancel));
		func._waitForPageToLoad(getWebDriver(),50L);
		
		if(Application.equals("WRO")) {
			_setValue(getElement(txt_InsuredName), dataSearch.getData("WROInsuredName"));
			func._waitForPageToLoad(getWebDriver(),50L);
			
			_click(getElement( btn_Search));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 func._waitFor(getClonedElement(lnk_AccountNo).addToken("tkn_InsName",dataSearch.getData("WROInsuredName")), 500, WAIT_FOR.CLICKABLE, "");
			func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			 
			if(func._isVisible(getClonedElement(lnk_AccountNo).addToken("tkn_InsName",dataSearch.getData("WROInsuredName"))))
			    {
			    	CustomReporting.logReport("","","Account number is searched successfully in search result" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "Account Number search failed in search result ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    }
			_click(getClonedElement(lnk_AccountNo).addToken("tkn_InsName",dataSearch.getData("WROInsuredName")));
			func._waitForPageToLoad(getWebDriver(),50L);
			func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			_click(getElement(getSubmissionNumber));
			func._waitForPageToLoad(getWebDriver(),50L);
			func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			Thread.sleep(2000);
		}
		
		else if(Application.equals("CD")) {
			_setValue(getElement(txt_InsuredName), dataSearch.getData("CDInsuredName"));
			func._waitForPageToLoad(getWebDriver(),50L);
			
			_click(getElement( btn_Search));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 func._waitFor(getClonedElement(lnk_AccountNo).addToken("tkn_InsName",dataSearch.getData("CDInsuredName")), 500, WAIT_FOR.CLICKABLE, "");
			func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			 
			if(func._isVisible(getClonedElement(lnk_AccountNo).addToken("tkn_InsName",dataSearch.getData("CDInsuredName"))))
			    {
			    	CustomReporting.logReport("","","Account number is searched successfully in search result" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "Account Number search failed in search result ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    }
			_click(getClonedElement(lnk_AccountNo).addToken("tkn_InsName",dataSearch.getData("CDInsuredName")));
			func._waitForPageToLoad(getWebDriver(),50L);
			func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			Thread.sleep(2000);	
			
			WebElement weFEIN = (WebElement)getElement(txt_AccFEIN).getNative();
			String strFEIN = weFEIN.getText();
			if(dataSearch.getData("name").equals(NewBusiness.getData("name")))
	 	    {
	 	    	func._writeToExcel("NewBusiness", "FEIN",strFEIN, tcID);
	 	    }
			
			_click(getElement(getSubmissionNumber));
			func._waitForPageToLoad(getWebDriver(),50L);
			func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			Thread.sleep(2000);
			
			WebElement we = (WebElement)getElement(txt_SelectedState).getNative();
			String state = we.getText();
			
			//if(func._checkAttributeValue(getElement(txt_SelectedState), "TEXT", "California", softAssert) || func._checkAttributeValue(getElement(txt_SelectedState), "TEXT", "Indiana", softAssert)) {
				if(state.trim().equals("California") || state.trim().equals("Indiana")) {
				
				CustomReporting.logReport("","", "Account page reflect state as  "+state, "", 
						StepStatus.SUCCESS,new String[] { }, System.currentTimeMillis(), null);
			}
			else {
				CustomReporting.logReport("","", "Account page is not reflect state as  "+state, "", 
						StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			}
		
		}
		else if(Application.equals("Dental")) {
			_setValue(getElement(txt_InsuredName), dataSearch.getData("DentalInsuredName"));
			func._waitForPageToLoad(getWebDriver(),250L);
			
			_click(getElement( btn_Search));
			 func._waitForPageToLoad(getWebDriver(),350L);
			 func._waitFor(getClonedElement(lnk_AccountNo).addToken("tkn_InsName",dataSearch.getData("DentalInsuredName")), 500, WAIT_FOR.CLICKABLE, "");
				func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				 
				if(func._isVisible(getClonedElement(lnk_AccountNo).addToken("tkn_InsName",dataSearch.getData("DentalInsuredName"))))
				    {
				    	CustomReporting.logReport("","","Account number is searched successfully in search result" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
				    }
				    else
				    {
				    	CustomReporting.logReport("","", "Account Number search failed in search result ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				    }
				_click(getClonedElement(lnk_AccountNo).addToken("tkn_InsName",dataSearch.getData("DentalInsuredName")));
				func._waitForPageToLoad(getWebDriver(),50L);
				func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				Thread.sleep(2000);			
				
				_click(getElement(getSubmissionNumber));
				func._waitForPageToLoad(getWebDriver(),50L);
				func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				Thread.sleep(2000);
				
				WebElement we = (WebElement)getElement(txt_SelectedState).getNative();
				String state = we.getText();
				
				//if(func._checkAttributeValue(getElement(txt_SelectedState), "TEXT", "California", softAssert) || func._checkAttributeValue(getElement(txt_SelectedState), "TEXT", "Indiana", softAssert)) {
				if(state.trim().equals("California") || state.trim().equals("Indiana")) {
					
					CustomReporting.logReport("","", "Account page reflect state as  "+state, "", 
							StepStatus.SUCCESS,new String[] { }, System.currentTimeMillis(), null);
				}
				else {
					CustomReporting.logReport("","", "Account page is not reflect state as  "+state, "", 
							StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				}
		
		}
		else if(Application.equals("SIG")) {
			_setValue(getElement(txt_InsuredName), dataSearch.getData("SIGInsuredName"));
			func._waitForPageToLoad(getWebDriver(),50L);
			
			_click(getElement( btn_Search));
			func._waitForPageToLoad(getWebDriver(),350L);
			 func._waitFor(getClonedElement(lnk_AccountNo).addToken("tkn_InsName",dataSearch.getData("SIGInsuredName")), 500, WAIT_FOR.CLICKABLE, "");
				func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				 
				if(func._isVisible(getClonedElement(lnk_AccountNo).addToken("tkn_InsName",dataSearch.getData("SIGInsuredName"))))
				    {
				    	CustomReporting.logReport("","","Account number is searched successfully in search result" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
				    }
				    else
				    {
				    	CustomReporting.logReport("","", "Account Number search failed in search result ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				    }
				_click(getClonedElement(lnk_AccountNo).addToken("tkn_InsName",dataSearch.getData("SIGInsuredName")));
				func._waitForPageToLoad(getWebDriver(),50L);
				func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				Thread.sleep(2000);			
				
				_click(getElement(getSubmissionNumber));
				func._waitForPageToLoad(getWebDriver(),50L);
				func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				Thread.sleep(2000);
				
				WebElement we = (WebElement)getElement(txt_SelectedState).getNative();
				String state = we.getText();

				//if(func._checkAttributeValue(getElement(txt_SelectedState), "TEXT", "California", softAssert) || func._checkAttributeValue(getElement(txt_SelectedState), "TEXT", "Indiana", softAssert)) {
				if(state.trim().equals("California") || state.trim().equals("Indiana")) {
					
					CustomReporting.logReport("","", "Account page reflect state as  "+state, "", 
							StepStatus.SUCCESS,new String[] { }, System.currentTimeMillis(), null);
				}
				else {
					CustomReporting.logReport("","", "Account page is not reflect state as  "+state, "", 
							StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				}
		}
		
		WebElement SNo =(WebElement) getElement(getSubmissionNumber).getNative();
		String getSubmissionNum=SNo.getText();
		
		WebElement ANo=(WebElement) getElement(getAccountNumber).getNative();
		String getAccountNum=ANo.getText();
		   
		    
		    if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		    {
		    	if(Application.equals("WRO")) {
		    		func._writeToExcel("QAWRONewSubmission", "WROSubmissionNumber",getSubmissionNum, tcID);	
		    		func._writeToExcel("QASearch", "WROSubmissionNumber",getSubmissionNum, tcID);
		    	
		    		func._writeToExcel("QAWRONewSubmission", "WROAccountNumber",getAccountNum, tcID);	
		    		func._writeToExcel("QASearch", "WROAccountNumber",getAccountNum, tcID);
		    	}
		    	else if(Application.equals("CD")) {
			    	func._writeToExcel("ClQANewSubmission", "CDSubmissionNumber",getSubmissionNum, tcID);	
			    	func._writeToExcel("QASearch", "CDSubmissionNumber",getSubmissionNum, tcID);
			    	
			    	func._writeToExcel("ClQANewSubmission", "CDAccountNumber",getAccountNum, tcID);	
			    	func._writeToExcel("QASearch", "CDAccountNumber",getAccountNum, tcID);
			    }
		    	else if(Application.equals("Dental")) {
			    	func._writeToExcel("DentalQANewSubmission", "DentalNewSubmission",getSubmissionNum, tcID);	
			    	func._writeToExcel("QASearch", "DentalNewSubmission",getSubmissionNum, tcID);
			    	
			    	func._writeToExcel("DentalQANewSubmission", "DentalAccountNum",getAccountNum, tcID);	
			    	func._writeToExcel("QASearch", "DentalAccountNum",getAccountNum, tcID);
			    }
		    	else if(Application.equals("SIG")) {
			    	func._writeToExcel("SIGQANewSubmission", "SIGNewSubmission",getSubmissionNum, tcID);	
			    	func._writeToExcel("QASearch", "SIGNewSubmission",getSubmissionNum, tcID);
			    	
			    	func._writeToExcel("SIGQANewSubmission", "SIGAccountNumber",getAccountNum, tcID);	
			    	func._writeToExcel("QASearch", "SIGAccountNumber",getAccountNum, tcID);
			    }

		    }
		    else
		    {
		    	if(Application.equals("WRO")) {
			    	func._writeToExcel("WRONewSubmission", "WROSubmissionNumber",getSubmissionNum, tcID);	
			    	func._writeToExcel("Search", "WROSubmissionNumber",getSubmissionNum, tcID);
			    	
			    	func._writeToExcel("WRONewSubmission", "WROAccountNumber",getAccountNum, tcID);	
			    	func._writeToExcel("Search", "WROAccountNumber",getAccountNum, tcID);
			    }
			    else if(Application.equals("CD")) {
				    func._writeToExcel("ClNewSubmission", "CDSubmissionNumber",getSubmissionNum, tcID);	
				    func._writeToExcel("Search", "CDSubmissionNumber",getSubmissionNum, tcID);
				    	
				    func._writeToExcel("ClNewSubmission", "CDAccountNumber",getAccountNum, tcID);	
				    func._writeToExcel("Search", "CDAccountNumber",getAccountNum, tcID);
				}
			    else if(Application.equals("Dental")) {
				    func._writeToExcel("DentalNewSubmission", "DentalNewSubmission",getSubmissionNum, tcID);	
				    func._writeToExcel("Search", "DentalNewSubmission",getSubmissionNum, tcID);
				    	
				    func._writeToExcel("DentalNewSubmission", "DentalAccountNum",getAccountNum, tcID);	
				    func._writeToExcel("Search", "DentalAccountNum",getAccountNum, tcID);
				}
			    else if(Application.equals("SIG")) {
				    func._writeToExcel("SIGNewSubmission", "SIGNewSubmission",getSubmissionNum, tcID);	
				    func._writeToExcel("Search", "SIGNewSubmission",getSubmissionNum, tcID);
				    	
				    func._writeToExcel("SIGNewSubmission", "SIGAccountNumber",getAccountNum, tcID);	
				    func._writeToExcel("Search", "SIGAccountNumber",getAccountNum, tcID);
				}
		    }
		
	}
	
	@Override
	public void SisSubmission_Search (String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		PageData dataSearch = null;
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {			
			dataSearch = PageDataManager.instance().getPageData("QASearch",tcID);
			/*if(!dataSearch.getData("Sys_tcID").equals(""))
			{
				dataSearch = PageDataManager.instance().getPageData("QASearch",dataSearch.getData("Sys_tcID"));	
			}*/
		 }
		else
		{
			dataSearch = PageDataManager.instance().getPageData("Search",tcID);
			/*if(!dataSearch.getData("Sys_tcID").equals(""))
			{
				dataSearch = PageDataManager.instance().getPageData("Search",dataSearch.getData("Sys_tcID"));	
			}*/
		}
		if(!dataSearch.getData("Sys_tcID").equals(""))
		{
			dataSearch = PageDataManager.instance().getPageData("Search",dataSearch.getData("Sys_tcID"));	
		}
		_click(getElement( btn_Searchtab));
		func._waitForPageToLoad(getWebDriver(),150L);
		Thread.sleep(5000);
		String strSubnum=null;
		func._waitFor(getElement( btn_Cancel), 500, WAIT_FOR.CLICKABLE, "");
	
		_click(getElement( btn_Cancel));
		func._waitForPageToLoad(getWebDriver(),150L);
		Thread.sleep(3000);
		if(!dataSearch.getData("BusinessSegment").equals(""))
		{
					_click(getElement(img_clearselection));
					func._waitForPageToLoad(getWebDriver(),50L);
					_click(getElement( lst_clkSelectBusinessSegment));
					func._waitForPageToLoad(getWebDriver(),50L);
					_click(getClonedElement(opt_ChoseBusinessSegment).addToken("tkn_BusinessSegment",dataSearch.getData("BusinessSegment")));
		
					func._waitForPageToLoad(getWebDriver(),50L);
				
				
			}
			
		if(!dataSearch.getData("Sister_Sub_num").equals(""))
		{
			if(dataSearch.getData("Sister_Sub_num").indexOf("-")>0)
			{
				strSubnum=dataSearch.getData("Sister_Sub_num").split("-")[0];
				_setValue(getElement(txt_SubmissionNumber),strSubnum);
			}
			else
			{
				strSubnum=dataSearch.getData("Sister_Sub_num");
			  _setValue(getElement(txt_SubmissionNumber),strSubnum);
			}
		}
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement( btn_Search));
		func._waitForPageToLoad(getWebDriver(),100L);
		Thread.sleep(3000);
		func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		Thread.sleep(3000);
		if(func._isVisible(getClonedElement(lnk_SubmissionNum).addToken("tkn_SUBNUM",strSubnum)))
	    {
			Thread.sleep(2000);
			_click(getClonedElement(lnk_SubmissionNum).addToken("tkn_SUBNUM",strSubnum));
			 func._waitForPageToLoad(getWebDriver(),50L);
			 Thread.sleep(3000);
	    	CustomReporting.logReport("","","Submission number is searched successfully in search result" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Submission Number search failed in search result ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    }
		
	}
	
	@Override
	public void searchSubmissionInEscape(String tcID, SoftAssert softAssert) throws Exception {

		try {

			PageData dataTest = PageDataManager.instance().getPageData("SearchPolicy", tcID);
			String[] submissionNumber = dataTest.getData("SubmissionNo").split("-");

			_wait(2000);
			_setValue(getElement(txt_SubmissionNumSearch), submissionNumber[0]);
			_wait(1000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_click(getElement(btn_Search));
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			func._waitForPageToLoad(getWebDriver(), 200L);

		} catch (Exception ex) {
			throw ex;
		}
	}

}
