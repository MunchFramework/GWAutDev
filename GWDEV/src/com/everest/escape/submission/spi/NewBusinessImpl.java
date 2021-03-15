package com.everest.escape.submission.spi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import org.xframium.page.PageManager;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.Element.WAIT_FOR;

import com.everest.escape.submission.NewBusiness;
import com.everest.escape.submission.NewSubmission;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class NewBusinessImpl extends CustomAbstractPage implements NewBusiness {
	@Override
	public void CreateSubmission_For_NewBusiness (String tcID, SoftAssert softAssert,String duplicateFEIN) throws Exception{
		
		PageData dataNewBusiness = PageDataManager.instance().getPageData("NewBusiness",tcID);
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		Thread.sleep(4000);
		_click(getElement(lnk_NewBusiness));
		Thread.sleep(4000);
		func._waitFor(getElement(btn_NBCreateThisSubmission), 50, WAIT_FOR.CLICKABLE, "");
	   // _setValue(getElement(txt_InsuredName),dataNewBusiness.getData("InsuredName"));
		//String timeStamp ="0"+ (new SimpleDateFormat("dd.HH.mm.ss").format(new Date())).replace(".", "");
		String timeStamp=func.generate_RandomNumber(9);
		String ranInsureName=func.generate_RandomString(10);
		
		Thread.sleep(3000);
		if(!dataNewBusiness.getData("InsuredName").equals(""))
		{
		 _setValue(getElement(txt_InsuredName),dataNewBusiness.getData("InsuredName"));
		}
		else
		{
			if(duplicateFEIN.toLowerCase().equals("dupinsured"))
	    	{
	    		 _setValue(getElement(txt_InsuredName),dataNewBusiness.getData("System_Generate_InsName"));
	    		
	    	}
			else
			{
				_setValue(getElement(txt_InsuredName),ranInsureName);
			}
		}
		if(dataNewBusiness.getData("InsuredName").equals(""))
		{
			func._writeToExcel("NewBusiness", "System_Generate_InsName",ranInsureName, tcID);
		   if(duplicateFEIN.toLowerCase().equals("dupins"))
		    {
		    	func._writeToExcel("NewBusiness", "System_Generate_InsName",ranInsureName, tcID+"_1");	
		    	func._writeToExcel("NewBusiness", "InsuredName",ranInsureName, tcID+"_1");
		    	
		    }
		   if(duplicateFEIN.toLowerCase().equals("dupinsfein"))
		    {
		    	func._writeToExcel("NewBusiness", "System_Generate_InsName",ranInsureName, tcID+"_1");	
		    	func._writeToExcel("NewBusiness", "InsuredName",ranInsureName, tcID+"_1");
		    	
		    }
		   if(duplicateFEIN.toLowerCase().equals("dupins90"))
		    {
		    	func._writeToExcel("NewBusiness", "InsuredName",ranInsureName, tcID+"_3");	
		    	
		    }
		}
		
	    if(dataNewBusiness.getData("SubmissionType").trim().toLowerCase().equals("new"))
	    {
	    	_click(getElement(red_NewSubmissionType));
	    }
	    if(dataNewBusiness.getData("SubmissionType").trim().toLowerCase().equals("renewal"))
	    {
	    	_click(getElement(red_RenewalSubmissionType));
	    }

	    _setValue(getElement(txt_MailingStreetAddress),dataNewBusiness.getData("MailingStreetAddress"));
	    _setValue(getElement(txt_MailingCity),dataNewBusiness.getData("MailingCity"));
	    _setValue(getElement(lst_Country),dataNewBusiness.getData("Country"));
	    Thread.sleep(2000);
	    _setValue(getElement(lst_MailingState),dataNewBusiness.getData("MailingState"));

	    _setValue(getElement(txt_MailingZipCode),dataNewBusiness.getData("MailingZipCode"));
	    _setValue(getElement(txt_MailingZipAddon),dataNewBusiness.getData("MailingZipAddon"));
	    if(!dataNewBusiness.getData("FEIN").equals("")&&(!dataNewBusiness.getData("FEIN").trim().toLowerCase().equals("na")))
	    {
	    	_setValue(getElement(txt_FEIN),dataNewBusiness.getData("FEIN"));
	    	_click(getElement(btn_FEIN));
	    	func._waitForPageToLoad(getWebDriver(),50L);
	    	Thread.sleep(2000);
	    }
	    else
	    {
	    	if(duplicateFEIN.toLowerCase().equals("duplicatefein"))
	    	{
	    		 _setValue(getElement(txt_FEIN),dataNewBusiness.getData("System_Generate_FEIN"));
	    		 _click(getElement(btn_FEIN));
	    		 func._waitForPageToLoad(getWebDriver(),50L);
	 	 	    Thread.sleep(2000);
	    		
	    	}
	    	else if(duplicateFEIN.toLowerCase().equals("duplicateonlyfein"))
	    	{
	    		 _setValue(getElement(txt_FEIN),dataNewBusiness.getData("System_Generate_FEIN"));
	    		 _click(getElement(btn_FEIN));
	    		 func._waitForPageToLoad(getWebDriver(),50L);
	 	 	    Thread.sleep(2000);
	    		
	    	}
	    	else
	    	{
	    		if(!dataNewBusiness.getData("FEIN").trim().toLowerCase().equals("na"))
	    		{
	    			Thread.sleep(2000);
	    			_setValue(getElement(txt_FEIN),timeStamp);
	    			_click(getElement(btn_FEIN));
	    	 	    func._waitForPageToLoad(getWebDriver(),50L);
	    	 	    Thread.sleep(2000);
		    	  	func._writeToExcel("NewBusiness", "System_Generate_FEIN",timeStamp, tcID);
			  	    if(duplicateFEIN.toLowerCase().equals("dupfein"))
			  	    {
			  	    	func._writeToExcel("NewBusiness", "System_Generate_FEIN",timeStamp, tcID+"_1");	
			  	    }
			  	  if(duplicateFEIN.toLowerCase().equals("dupins90"))
				    {
				    	func._writeToExcel("NewBusiness", "FEIN",timeStamp, tcID+"_3");	
				    	
				    }
			  	  if(duplicateFEIN.toLowerCase().equals("dupinsfein"))
				    {
			  		  func._writeToExcel("NewBusiness", "System_Generate_FEIN",timeStamp, tcID+"_1");	
				    }
	    		}
	    	}
	    	
	    }
	    
	   
	    if(!dataNewBusiness.getData("Submission_EffDate").equals(""))
	    {
	    //_setValue(getElement(dat_Submission_EffDate),dataNewBusiness.getData("Submission_EffDate"));
    	int offset= Integer.valueOf(dataNewBusiness.getData("Submission_EffDate").split("-")[0].trim());
    	String OptValue= dataNewBusiness.getData("Submission_EffDate").split("-")[1].trim();
    	_setValue(getElement(dat_Submission_EffDate),func.Date_Manipulation("",OptValue, offset));
    	 WebElement elm = (WebElement) getElement(dat_Submission_EffDate).getNative();
         elm.sendKeys(Keys.TAB);
    	 func._waitForPageToLoad(getWebDriver(),50L);
    	 Thread.sleep(2000);
	   
	    }
	    else
	    {
	    	 _setValue(getElement(dat_Submission_EffDate),func.Date_Manipulation("","Now", 0));
	    	 WebElement elm = (WebElement) getElement(dat_Submission_EffDate).getNative();
	         elm.sendKeys(Keys.TAB);
	    	 func._waitForPageToLoad(getWebDriver(),50L);
	    	 Thread.sleep(2000);
	    }
	    if(!dataNewBusiness.getData("Submission_ExpDate").equals(""))
	    {
	    	int offset= Integer.valueOf(dataNewBusiness.getData("Submission_ExpDate").split("-")[0].trim());
	    	String OptValue= dataNewBusiness.getData("Submission_ExpDate").split("-")[1].trim();
	    	_setValue(getElement(dat_Submission_ExpDate),func.Date_Manipulation("",OptValue, offset));
	    	WebElement elm = (WebElement) getElement(dat_Submission_ExpDate).getNative();
	         elm.sendKeys(Keys.TAB);
	    	 func._waitForPageToLoad(getWebDriver(),50L);
	    	 Thread.sleep(2000);
	    }
	    else
	    {
	    	_setValue(getElement(dat_Submission_ExpDate),func.Date_Manipulation("","Year", 1));
	    	WebElement elm = (WebElement) getElement(dat_Submission_ExpDate).getNative();
	         elm.sendKeys(Keys.TAB);
	    	 func._waitForPageToLoad(getWebDriver(),50L);
	    }
	    
	    
	    if(!dataNewBusiness.getData("BusinessSegment").equals(""))
	    {
	    	
	    	if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
	    	{
	    		_setValue(getElement(lst_BusinessSegment),dataNewBusiness.getData("QABusinessSegment"));
	    	}
	    	else
	    	{
	    		_setValue(getElement(lst_BusinessSegment),dataNewBusiness.getData("BusinessSegment"));
	    	}
	    	 func._waitForPageToLoad(getWebDriver(),50L);
	    }
	    if(!dataNewBusiness.getData("IncumbentCarrier").equals(""))
	    {
	    	_setValue(getElement(lst_IncumbentCarrier),dataNewBusiness.getData("IncumbentCarrier"));
	    }
	    Thread.sleep(3000);
	    if(!dataNewBusiness.getData("PredominantState").equals(""))
	    {
	    	_setValue(getElement(lst_PredominantState),dataNewBusiness.getData("PredominantState"));
	    	 func._waitForPageToLoad(getWebDriver(),50L);
	    }
	    /*if(!dataNewBusiness.getData("Distribution").equals(""))
	    {
	    	_setValue(getElement(lst_Distribution),dataNewBusiness.getData("Distribution"));
	    	 func._waitForPageToLoad(getWebDriver(),50L);
	    }*/
	    
	    if(!dataNewBusiness.getData("MarketSegment").equals(""))
	    {
	    	 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
	    		 _setValue(getElement(lst_MarketSegment),dataNewBusiness.getData("QAMarketSegment"));
			 }
			 else
			 {
				 _setValue(getElement(lst_MarketSegment),dataNewBusiness.getData("MarketSegment"));
			 }
	    	
	    	 func._waitForPageToLoad(getWebDriver(),50L);
	    }
	    
	    if(!dataNewBusiness.getData("BranchOffice").equals(""))
	    {
	    	 func._waitForPageToLoad(getWebDriver(),50L);
	    	 String locator=getElement(lst_BranchOffice).toString();
	    	 
	    	// String locator=func.getCustomElementName(getElement(lst_BranchOffice));
				String strXpath=locator.split("\\{")[1];
				String Xpath=strXpath.replace("}", "");
				
			 WebElement ele=getWebDriver().findElement(By.xpath(Xpath));
		     Select sel=new Select(ele);
		  
				 sel.selectByVisibleText(dataNewBusiness.getData("BranchOffice"));
			
	    	
	    	//_setValue(getElement(lst_BranchOffice),dataNewBusiness.getData("BranchOffice"));
	    	 func._waitForPageToLoad(getWebDriver(),50L);
	    }
	    if(!dataNewBusiness.getData("SubmittedLOB").equals(""))
	    {
	    	 func._waitForPageToLoad(getWebDriver(),50L);
	    	 Thread.sleep(3000);
	    	 if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
			 {
	    		 _setValue(getElement(lst_SubmittedLOB),dataNewBusiness.getData("QASubmittedLOB"));
			 }
			 else
			 {
				 _setValue(getElement(lst_SubmittedLOB),dataNewBusiness.getData("SubmittedLOB"));
			 }
	    	
	    	 func._waitForPageToLoad(getWebDriver(),50L);
	    }
	    if(!dataNewBusiness.getData("UnderwriterName").equals(""))
	    {
	    	_setValue(getElement(lst_UnderwriterName),dataNewBusiness.getData("UnderwriterName"));
	    }
	    String NBLoB="";
	    if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
    	{
	    	 NBLoB=dataNewBusiness.getData("QASubmittedLOB");
    	}
	    else
	    {
	    	NBLoB=dataNewBusiness.getData("SubmittedLOB");
	    }
	    if(NBLoB.equals("Package"))
	    {
	    	func._waitForPageToLoad(getWebDriver(),50L);
			_click(getElement(tab_SubProfile));
			func._waitForPageToLoad(getWebDriver(),50L);
			Thread.sleep(2000);
			String[] arrSelect=null;
			if(dataNewBusiness.getData("SubmittedProfile").contains(";"))
	    	{
	    		arrSelect=dataNewBusiness.getData("SubmittedProfile").split(";");

				for(int i=0;i<arrSelect.length;i++)
	    		{
		
					_click(getClonedElement(chk_SubProfileNames).addToken("tkn_ProfileName",arrSelect[i]));
					
					func._waitForPageToLoad(getWebDriver(),50L);
					Thread.sleep(2000);
	    		}
		
	    	}
	    }
	    
	   
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    _click(getElement(btn_NBCreateThisSubmission));
	    Thread.sleep(3000);
	    func._alertHandler(getWebDriver(), "Ok");
	    func._waitForPageToLoad(getWebDriver(),800L);
	    Thread.sleep(3000);
	   
	    try 
	    {
	    func._waitFor(getElement(SubmissionNumber), 300, WAIT_FOR.CLICKABLE);
	    WebElement accNo=(WebElement) getElement(getAccountNumber).getNative();
		String getAccountNum=accNo.getText();
	    func._writeToExcel("NewBusiness", "AccountNumber", getAccountNum, tcID);
	    WebElement subNo=(WebElement) getElement(SubmissionNumber).getNative();
	    String getSubmissionNum=subNo.getText();
	    func._writeToExcel("NewBusiness", "SubmissionNumber", getSubmissionNum, tcID);
	    
	    Thread.sleep(3000);
	    
	    if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		 {
			func._writeToExcel("QASearch", "AccountNumber", getAccountNum, tcID);
			func._writeToExcel("QASearch", "SubmissionNumber", getSubmissionNum, tcID);
		 }
		else
		{
			func._writeToExcel("Search", "AccountNumber", getAccountNum, tcID);
			func._writeToExcel("Search", "SubmissionNumber", getSubmissionNum, tcID);
		}
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	
	@Override
	public void Vrify_BusinessSubmission_Screen (String tcID, SoftAssert softAssert) throws Exception{
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(35000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 if(func._isVisible(getElement(read_SubmissionStatus)))
		 {
			if(func._checkAttributeValue(getElement(read_SubmissionStatus), "value", "Un-Submitted", softAssert))
			{
				NewBusiness NBimpl = (NewBusiness) PageManager.instance().createPage( NewBusiness.class, getWebDriver());
				NBimpl.Verify_PAUSValues(tcID, softAssert);
			}

		 }
		 
		else
		{
			NewSubmission NSimpl = (NewSubmission) PageManager.instance().createPage( NewSubmission.class, getWebDriver());
			NSimpl.Verify_PANBValues(tcID, softAssert);
			
		}
	}
	
	@Override
	public void Verify_SubmissionStatus_Received (String tcID, SoftAssert softAssert,String type) throws Exception{
		Thread.sleep(5000);
		func._waitFor(getElement(tab_NBSubmission), 500, WAIT_FOR.CLICKABLE, "");
		Thread.sleep(5000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		PageData dataNewBusiness = PageDataManager.instance().getPageData("NewBusiness",tcID);
		
		 WebElement NBAel=(WebElement) getElement(tab_NBAccount).getNative();
		 try
		 {
			 String AccNumber=NBAel.getText().split(":")[1];
			 if(!AccNumber.equals(null))
		     {
		    	CustomReporting.logReport("","","New Business Account created with the Account number " +AccNumber + 
		    			"	" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
		     }
		 }
	    catch(Exception ex)
	    {
	    	CustomReporting.logReport("","", "New Business Account is not created because of the following error"+ex,"", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    	throw new RuntimeException();
	    }
		
	   if(type.trim().toUpperCase().equals("PA"))
	   {
		   if(func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT", "Working", softAssert))
		    {
		    	CustomReporting.logReport("","","Submission status for the new Submission is 'Working' " + 
		    			"	" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
		    	CustomReporting.logReport("","","Submission is cleared and created succesfully " + 
		    			"	" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Submission status for the new submission is not 'Working' ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		   if(func._isEnabled(getElement(lst_SubmissionStatus)))
		    	
		    {
		    	CustomReporting.logReport("","", "Submission status drop down field is enable", StepStatus.REPORT,new String[] { },System.currentTimeMillis());
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Submission status drop down field is not enabled ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
		    	
		    }
		   String[] StatusArr;
		   boolean isDetected=false;
		   StatusArr=func._getValueDropDownBox(getElement(lst_SubmissionStatus));
		   for(int i=0;i<StatusArr.length;i++)
		   {
			   if(StatusArr[i].trim().equalsIgnoreCase("Policy Bound") ||StatusArr[i].trim().equalsIgnoreCase("Blocked"))
			   {
				   isDetected=true;
				   break;
			   }
		   }
		   if(!isDetected)
		    	
		    {
		    	CustomReporting.logReport("","", "Agent is unable to change the submission status from �Working to �Blocked� or �Policy Bound� and vice versa", StepStatus.REPORT,new String[] { },System.currentTimeMillis());
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Agent is able to change the submission status from �Working to �Blocked� or �Policy Bound� and vice versa","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
		    	
		    }
		   
		 
	   }
	   if(type.trim().toUpperCase().equals("AGENT"))
	   {
		   //if(func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT", "Received", softAssert))
		   if(func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT", "Working", softAssert))   
		    {
		    	CustomReporting.logReport("","","Default Submission status for the new Submission is 'Received' " + 
		    			"	" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Default Submission status for the new submission is not 'Received' ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	throw new RuntimeException();
		    }
		   
		   if(!func._isEnabled(getElement(lst_SubmissionStatus)))
		    	
		    {
		    	CustomReporting.logReport("","", "User is not able to update the submission status manually. since Submission status drop down field is disabled", StepStatus.REPORT,new String[] { },System.currentTimeMillis());
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Submission status drop down field is enabled ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
		    	
		    }
	   }
	   
	   if(type.trim().toUpperCase().equals("PF"))
	   {
		   if(func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT", "Working", softAssert))
		    {
		    	CustomReporting.logReport("","","Submission status for the new Submission is 'Working' " + 
		    			"	" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Submission status for the new submission is not 'Working' ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	throw new RuntimeException();
		    }
		   if(func._isEnabled(getElement(lst_SubmissionStatus)))
		    	
		    {
		    	CustomReporting.logReport("","", "User is able to update the submission status manually. since Submission status drop down field is enabled.", StepStatus.REPORT,new String[] { },System.currentTimeMillis());
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "User is not able to update the submission status manually since submission status drop down field is disabled ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
		    	
		    }
		 
	   }
	    
	    func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		//func._takeScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
	    
	    WebElement el=(WebElement) getElement(tab_NBSubmission).getNative();
		 try
		 {
			 String SubNumber=el.getText().split(":")[1];
			 if(!SubNumber.equals(null))
		     {
		    	CustomReporting.logReport("","","Submission created with the submission number " +SubNumber + 
		    			"	" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
		     }
		 }
	    catch(Exception ex)
	    {
	    	CustomReporting.logReport("","", "Submission is not created because of the following error"+ex,"", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    	throw new RuntimeException();
	    }
		
	}
	
	@Override
	public void Verify_SubmissionStatus_Unsubmitted (String tcID, SoftAssert softAssert) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(3000);
		//Thread.sleep(10000);
		func._waitFor(getElement(btn_NBCreateThisSubmission), 100, WAIT_FOR.CLICKABLE, "");

		PageData dataAccount = PageDataManager.instance().getPageData("Account",tcID);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		
		int temploopCount=0;
		do
		{
				WebElement weSubStatus=(WebElement)getElement(read_SubmissionStatus).getNative();
				if(weSubStatus.getAttribute("value").equals("Un-Submitted"))
				{
					break;
				}
				temploopCount=temploopCount+1;
				Thread.sleep(5000);
				
		}while(temploopCount<30);
		WebElement weSubStatus=(WebElement)getElement(read_SubmissionStatus).getNative();
		if(weSubStatus.getAttribute("value").equals("Un-Submitted"))
			
			
	    {
	    	CustomReporting.logReport("","","Verified that submission status is 'Unsubmitted' when user select subEff date after 90 days from current date" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "The submission status is not 'Unsubmitted' even though SubEff date is selected after 90 days from current date.","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    	throw new RuntimeException();
	    }
		WebElement el=(WebElement) getElement(newBusinessMsg).getNative();
		String errmsg=el.getText();
		if(func._isVisible(getElement(newBusinessMsg)))
	    {
	    	CustomReporting.logReport("","","Following error message is displayed when user select SubEffdate prior to 90 days : "+errmsg,StepStatus.REPORT,new String[] { },System.currentTimeMillis());	
	    }
	    else
	    {
	    	CustomReporting.logReport("","", "Error message is not dispalyed even though submission effective date selected after 90 days from current date ","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    	throw new RuntimeException();
	    }
	
		
		
	}
	@Override
	public void Verify_PASubmission_FieldValues (String tcID, SoftAssert softAssert,String type) throws Exception
	{
		PageData dataNewBusiness = PageDataManager.instance().getPageData("NewBusiness",tcID);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		//func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), "");
		if(!dataNewBusiness.getData("InsuredName").equals(""))
		{
		func._checkAttributeValue(getElement(txt_InsuredName), "value",dataNewBusiness.getData("InsuredName") , softAssert);
		}
		else
		{
			func._checkAttributeValue(getElement(txt_InsuredName), "value",dataNewBusiness.getData("System_Generate_InsName") , softAssert);
		}
		if(func._isEnabled(getElement(txt_InsuredName)))
		{
			CustomReporting.logReport("","","Insuredname field is displayed as Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Insuredname field is displayed as Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(dataNewBusiness.getData("SubmissionType").trim().toLowerCase().equals("new"))
		{
			if(func._isChecked(getElement(red_NewSubmissionType)))
			
			{
				CustomReporting.logReport("","","Submission type is selected as New" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Submission type is not selected as New","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			if(func._isEnabled(getElement(red_NewSubmissionType)))
			
			{
				CustomReporting.logReport("","","Submission type - New radio button is enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Submission type - New radio button is  Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
				
		if(dataNewBusiness.getData("SubmissionType").trim().toLowerCase().equals("renewal"))
		{	
			
			if(func._isChecked(getElement(red_RenewalSubmissionType)))
			{
				CustomReporting.logReport("","","Submission type is selected as Renewal" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			}
			else
			{
				CustomReporting.logReport("", "", "Submission type is not selected as Renewal","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
			}
			if(func._isEnabled(getElement(red_RenewalSubmissionType)))
			
			{
				CustomReporting.logReport("","","Submission type - Renewal radio button is enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Submission type - Renewal radio button is  Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			
		}
		
		func._checkAttributeValue(getElement(txt_MailingStreetAddress), "value",dataNewBusiness.getData("MailingStreetAddress") , softAssert);
		
		if(func._isEnabled(getElement(txt_MailingStreetAddress)))
		{
			CustomReporting.logReport("","","Mailing address field is displayed as Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Mailing address field is displayed as Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(txt_MailingCity), "value",dataNewBusiness.getData("MailingCity") , softAssert);
		if(func._isEnabled(getElement(txt_MailingCity)))
		{
			CustomReporting.logReport("","","Mailing city field is displayed as Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Mailing city field is displayed as Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(lst_MailingState), "TEXT",dataNewBusiness.getData("MailingState") , softAssert);
		if(func._isEnabled(getElement(lst_MailingState)))
		{
			CustomReporting.logReport("","","Mailing State field is displayed as Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Mailing State field is displayed as Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(lst_Country), "TEXT",dataNewBusiness.getData("Country") , softAssert);
		if(func._isEnabled(getElement(lst_Country)))
		{
			CustomReporting.logReport("","","Mailing country field is displayed as Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Mailing country field is displayed as Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(txt_MailingZipCode), "value",dataNewBusiness.getData("MailingZipCode") , softAssert);
		if(func._isEnabled(getElement(txt_MailingZipCode)))
		{
			CustomReporting.logReport("","","Mailing ZipCode field is displayed as Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Mailing ZipCode field is displayed as Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataNewBusiness.getData("MailingZipAddon").equals(""))
		{
		func._checkAttributeValue(getElement(txt_MailingZipAddon), "value",dataNewBusiness.getData("MailingZipAddon") , softAssert);
		}
		if(func._isEnabled(getElement(txt_MailingZipAddon)))
		{
			CustomReporting.logReport("","","Mailing ZipCode Add-on field is displayed as Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Mailing ZipCode Add-on field is displayed as Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataNewBusiness.getData("FEIN").equals(""))
		{
		func._checkAttributeValue(getElement(get_FIEN), "value",dataNewBusiness.getData("FEIN") , softAssert);
		}
		else
		{
			func._checkAttributeValue(getElement(get_FIEN), "value",dataNewBusiness.getData("System_Generate_FEIN") , softAssert);	
		}
		if(func._isEnabled(getElement(txt_FEIN)))
		{
			CustomReporting.logReport("","","FEIN field is displayed as Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "FEIN field is displayed as Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(func._isEnabled(getElement(btn_FEIN)))
		{
			CustomReporting.logReport("","","FEIN button field is displayed as Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "FEIN button field is displayed as Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(txt_NaicsCode), "value",dataNewBusiness.getData("NaicsCode") , softAssert);
		if(func._isEnabled(getElement(txt_NaicsCode)))
		{
			CustomReporting.logReport("","","NaicsCode text box is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "NaicsCode textbox field is displayed as Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(type.toLowerCase().equals("new"))
		{
			if(!dataNewBusiness.getData("Submission_EffDate").equals(""))
			{
				int offset= Integer.valueOf(dataNewBusiness.getData("Submission_EffDate").split("-")[0].trim());
		    	String OptValue= dataNewBusiness.getData("Submission_EffDate").split("-")[1].trim();
		    	
				func._checkAttributeValue(getElement(dat_Submission_EffDate), "value",func.Date_Manipulation("",OptValue, offset) , softAssert);
			}
			else
			{
				func._checkAttributeValue(getElement(dat_Submission_EffDate), "value",func.Date_Manipulation("","Now", 0) , softAssert);
			}
			if(!func._isEnabled(getElement(dat_Submission_EffDate)))
			{
				CustomReporting.logReport("","","Submission Effective Date is Disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Submission Effective Date is Enabled","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		
			if(!dataNewBusiness.getData("Submission_ExpDate").equals(""))
			{
				int offset= Integer.valueOf(dataNewBusiness.getData("Submission_ExpDate").split("-")[0].trim());
		    	String OptValue= dataNewBusiness.getData("Submission_ExpDate").split("-")[1].trim();
		    	func._checkAttributeValue(getElement(dat_Submission_ExpDate), "value",func.Date_Manipulation("",OptValue, offset) , softAssert);
			}
			else
			{
				String SubmissionEffExpDate=func.Date_Manipulation("","year", 1);
				func._checkAttributeValue(getElement(dat_Submission_ExpDate), "value",SubmissionEffExpDate , softAssert);
			}
			if(func._isEnabled(getElement(dat_Submission_ExpDate)))
			{
				CustomReporting.logReport("","","Submission expair Date field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Submission expaire Date foeld is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		}
		if(type.toLowerCase().equals("rfcy"))
		{
			String SubmissionEffDate=null;
			if(!dataNewBusiness.getData("Submission_EffDate").equals(""))
			{
				SubmissionEffDate=func.Date_Manipulation(dataNewBusiness.getData("Submission_EffDate"),"year", 1);
			}
			else
			{
				SubmissionEffDate=func.Date_Manipulation("","year", 1);
			}
			func._checkAttributeValue(getElement(dat_Submission_EffDate), "value",SubmissionEffDate , softAssert);
			if(func._isEnabled(getElement(dat_Submission_EffDate)))
			{
				CustomReporting.logReport("","","Submission Effective Date is Enabled in new business screen after submit for RFCY" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Submission Effective Date isDisabled in new business screen after submit for RFCY","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
		
			if(!dataNewBusiness.getData("Submission_ExpDate").equals(""))
			{
				int offset= Integer.valueOf(dataNewBusiness.getData("Submission_ExpDate").split("-")[0].trim());
		    	String OptValue= dataNewBusiness.getData("Submission_ExpDate").split("-")[1].trim();

				String SubmissionExpDate=func.Date_Manipulation(func.Date_Manipulation("",OptValue, offset),"Year",1);
				func._checkAttributeValue(getElement(dat_Submission_ExpDate), "value",SubmissionExpDate , softAssert);
			}
			else
			{
				String SubmissionEffExpDate=func.Date_Manipulation("","Now", 2);
				func._checkAttributeValue(getElement(dat_Submission_ExpDate), "value",SubmissionEffExpDate , softAssert);
			}
			if(func._isEnabled(getElement(dat_Submission_ExpDate)))
			{
				CustomReporting.logReport("","","Submission expair Date field is Enabled in new business screen after submit for RFCY" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "Submission expaire Date foeld is Disabled in new business screen after submit for RFCY.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
			
		}
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		{
			func._checkAttributeValue(getElement(lst_BusinessSegment), "TEXT",dataNewBusiness.getData("QABusinessSegment") , softAssert);
		}
		else
		{
			func._checkAttributeValue(getElement(lst_BusinessSegment), "TEXT",dataNewBusiness.getData("BusinessSegment") , softAssert);
		}
		
		if(func._isEnabled(getElement(lst_BusinessSegment)))
		{
			CustomReporting.logReport("","","BusinessSegment  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "BusinessSegment field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!dataNewBusiness.getData("IncumbentCarrier").equals(""))
		{
		
			func._checkAttributeValue(getElement(lst_IncumbentCarrier), "TEXT",dataNewBusiness.getData("IncumbentCarrier") , softAssert);
		}
		else
		{
			func._checkAttributeValue(getElement(lst_IncumbentCarrier), "TEXT","make selection" , softAssert);	
		}
		if(func._isEnabled(getElement(lst_IncumbentCarrier)))
		{
			CustomReporting.logReport("","","IncumbentCarrier  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "IncumbentCarrier field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!dataNewBusiness.getData("PredominantState").equals(""))
		{
		
			func._checkAttributeValue(getElement(lst_PredominantState), "TEXT",dataNewBusiness.getData("PredominantState") , softAssert);
		}
		else
		{
			func._checkAttributeValue(getElement(lst_PredominantState), "TEXT","make selection" , softAssert);	
		}

		if(func._isEnabled(getElement(lst_PredominantState)))
		{
			CustomReporting.logReport("","","PredominantState  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "PredominantState field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		/*func._checkAttributeValue(getElement(lst_Distribution), "TEXT",dataNewBusiness.getData("Distribution") , softAssert);
		if(func._isEnabled(getElement(lst_Distribution)))
		{
			CustomReporting.logReport("","","Distribution  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Distribution field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}*/
		
		/*func._checkAttributeValue(getElement(lst_UnderwriterName), "value",dataNewBusiness.getData("UnderwriterName") , softAssert);
		if(func._isEnabled(getElement(lst_UnderwriterName)))
		{
			CustomReporting.logReport("","","UnderwriterName  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "UnderwriterName field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}*/
		
		func._checkAttributeValue(getElement(lst_MarketSegment), "TEXT",dataNewBusiness.getData("MarketSegment") , softAssert);
		if(func._isEnabled(getElement(lst_MarketSegment)))
		{
			CustomReporting.logReport("","","MarketSegment  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "MarketSegment field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(lst_BranchOffice), "TEXT",dataNewBusiness.getData("BranchOffice") , softAssert);
		if(func._isEnabled(getElement(lst_BranchOffice)))
		{
			CustomReporting.logReport("","","BranchOffice  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "BranchOffice field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		func._checkAttributeValue(getElement(lst_SubmittedLOB), "TEXT",dataNewBusiness.getData("SubmittedLOB") , softAssert);
		if(func._isEnabled(getElement(lst_SubmittedLOB)))
		{
			CustomReporting.logReport("","","SubmittedLOB  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "SubmittedLOB field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!dataNewBusiness.getData("PaSubmission").equals(""))
		{
			func._checkAttributeValue(getElement(txt_PaSubmission), "value",dataNewBusiness.getData("PaSubmission") , softAssert);
		}
		if(func._isEnabled(getElement(txt_PaSubmission)))
		{
			CustomReporting.logReport("","","PaSubmission  field is Enabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "PaSubmission field is Disabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}

	
	}
	
	@Override
	public void Verify_PAUSValues (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataNewBusiness = PageDataManager.instance().getPageData("NewBusiness",tcID);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 
		 if((getElement(newBusinessMsg).getAttribute("style").contains("red")))
		 {																  

			 WebElement el=(WebElement) getElement(newBusinessMsg).getNative();
			 CustomReporting.logReport("","","Error message :"+el.getText() ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		 }
		 else
		 {
			 CustomReporting.logReport("", "", "Expected error message is not dispalyed","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null); 
		 }
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
		Date date = new Date();
		
		String CurrDate=dateFormat.format(date);
		func._checkAttributeValue(getElement(dat_ReceivedDate), "value",CurrDate , softAssert);
		if(!func._isEnabled(getElement(dat_ReceivedDate)))
		
		{
			CustomReporting.logReport("","","Received Date Text Box is displayed as disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Received Date Text Box is displayed as enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(read_SubmissionStatus)))
		
		{
			CustomReporting.logReport("","","Submitted status field is displayed as disabled" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Submitted status field is displayed as enabled.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(read_SubmissionStatus), "value","Un-Submitted" , softAssert);
		
		NewBusiness NBimpl = (NewBusiness) PageManager.instance().createPage( NewBusiness.class, getWebDriver());
		NBimpl.Verify_PASubmission_FieldValues(tcID, softAssert,"new");

	}
	
	@Override
	public void Verify_RFCYValues  (String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataNewBusiness = PageDataManager.instance().getPageData("NewBusiness",tcID);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		if(!func._isEnabled(getElement(dat_ReceivedDate)))
		{
			CustomReporting.logReport("","","Received Date field is displayed as disabled in New Business screen after submit RFNY" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Received Date Text Box is displayed as enabled in New Business screen after submit RFNY","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(dat_ReceivedDate), "value",func.Date_Manipulation("", "Now", 0) , softAssert);
		if(!func._isEnabled(getElement(read_SubmissionStatus)))
		
		{
			CustomReporting.logReport("","","Submitted status field is displayed as disabled in New Business screen after submit RFNY" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "", "Submitted status field is displayed as enabled in New Business screen after submit RFNY","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(read_SubmissionStatus), "value","Received" , softAssert);
		NewBusiness NBimpl = (NewBusiness) PageManager.instance().createPage( NewBusiness.class, getWebDriver());
		NBimpl.Verify_PASubmission_FieldValues(tcID, softAssert,"RFCY");
		_click(NBimpl.getElement(btn_NBCreateThisSubmission));
		Thread.sleep(3000);
		 func._alertHandler(getWebDriver(), "Ok");
		 func._waitForPageToLoad(getWebDriver(), 120L);
		 Thread.sleep(3000);
		
		
	}
	
	@Override
	public void Verify_SubmissionStatus_Blocked (String tcID, SoftAssert softAssert) throws Exception
	{
		 
		 func._waitFor(getElement(tab_NBSubmission), 50, WAIT_FOR.CLICKABLE, "");
		 Thread.sleep(3000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 WebElement el=(WebElement) getElement(tab_NBSubmission).getNative();
		 try
		 {
			 String SubNumber=el.getText().split(":")[1];
			 if(!SubNumber.equals(null))
		     {
		    	CustomReporting.logReport("","","Submission created with the submission number " +SubNumber + 
		    			"	" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		     }
		 }
	    catch(Exception ex)
	    {
	    	CustomReporting.logReport("","", "Submission is not created because of the following error"+ex,"", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    	throw new RuntimeException();
	    }
		 		
		 if(func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT", "Blocked", softAssert))
		    {
		    	CustomReporting.logReport("","","Submission status is 'Blocked' for the New Submission with duplicate values for any existing FEIN and LOB on the New Business screen " + 
		    			"	" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Submission status is not 'Blocked' for the New Submission with duplicate values for any existing FEIN and LOB on the New Business screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	throw new RuntimeException();
		    }
	
		
	}
	
	@Override
	public void Verify_SubStatus_Blocked_For_DupInsuredName (String tcID, SoftAssert softAssert) throws Exception
	{
		 
		 func._waitFor(getElement(tab_NBSubmission), 50, WAIT_FOR.CLICKABLE, "");
		 Thread.sleep(3000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 WebElement el=(WebElement) getElement(tab_NBSubmission).getNative();
		 try
		 {
			 String SubNumber=el.getText().split(":")[1];
			 if(!SubNumber.equals(null))
		     {
		    	CustomReporting.logReport("","","Submission created with the submission number " +SubNumber + 
		    			"	" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		     }
		 }
	    catch(Exception ex)
	    {
	    	CustomReporting.logReport("","", "Submission is not created because of the following error"+ex,"", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
	    	throw new RuntimeException();
	    }
		 		
		 if(func._checkAttributeValue(getElement(lst_SubmissionStatus), "TEXT", "Blocked", softAssert))
		    {
		    	CustomReporting.logReport("","","Submission status is 'Blocked' for the New Submission with no FEIN, duplicate Insured Name,Address and LOB " + 
		    			"	" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Submission status is not 'Blocked' for the New Submission with no FEIN,duplicate Insured Name,Address and LOB","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	throw new RuntimeException();
		    }
	
		
	}

	@Override
	public void verify_NewBusiness_InDWHDB (String tcID, SoftAssert softAs,String DBServer) throws Exception 
	{
		 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 PageData dataAccount = PageDataManager.instance().getPageData("NewBusiness",tcID);
		 if(!dataAccount.getData("Sys_TC_ID").equals(""))
		 {
			  dataAccount = PageDataManager.instance().getPageData("NewBusiness",dataAccount.getData("Sys_TC_ID"));	 
		 }
		 
         LinkedHashMap<Integer, String[]>AccountDHWDBvalues =null;
         LinkedHashMap<Integer, String[]>StateValues =null;
         LinkedHashMap<Integer, String[]>CountryValues =null;         
         LinkedHashMap<Integer, String[]> CustomerDHWDBvalues =null;
         LinkedHashMap<Integer, String[]> SubmissionDHWDBvalues =null;
         Map<String, String> newBusinessUIDataMap = new LinkedHashMap<>();
         Map<String, String> newBusinessAccountDBDataMap = new LinkedHashMap<>();
         String customerID = null ;
         String stateValue = null;
         String countryValue =null;
         Boolean isMatched =true;
       
         /***New Business Data Validation***/
 		//New Business UI Data 
 		String  accountNumber = dataAccount.getData("AccountNumber").split("-")[0];
 		String accountVersionNumber=dataAccount.getData("AccountNumber").split("-")[1];
 		String stateName= dataAccount.getData("MailingState");
 		String countryName=dataAccount.getData("Country");
 		newBusinessUIDataMap.put("AccountNumber", accountNumber);
 		newBusinessUIDataMap.put("AccountVersionNumber", accountVersionNumber);
 		newBusinessUIDataMap.put("InsuredName", dataAccount.getData("InsuredName"));
 		newBusinessUIDataMap.put("MailingStreetAddress", dataAccount.getData("MailingStreetAddress"));
 		newBusinessUIDataMap.put("MailingCity", dataAccount.getData("MailingCity"));
 		newBusinessUIDataMap.put("MailingState", dataAccount.getData("MailingState"));
 		newBusinessUIDataMap.put("Country", dataAccount.getData("Country"));
 		newBusinessUIDataMap.put("MailingZipCode", dataAccount.getData("MailingZipCode"));
 		newBusinessUIDataMap.put("MailingZipAddon", dataAccount.getData("MailingZipAddon"));
 		newBusinessUIDataMap.put("System_Generate_FEIN", dataAccount.getData("System_Generate_FEIN"));
 		Thread.sleep(2000);
         
        try
         {
           if(DBServer.equalsIgnoreCase("EscapeDB"))
           {
        	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
                {
                	AccountDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [EscapeDB].[dbo].[SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 36, "EscapeDB","enicdb-dev\\enic_qa");	 
                } 
                else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
                {
                	AccountDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [EscapeDB_SIT].[dbo].[SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 36, "EscapeDB_SIT","ENICDB-STAGE");
                	StateValues=cFunc.getDataFromDB("SELECT StateKey,State_Province_Name FROM [EscapeDB_SIT].[dbo].[SUB_State] WHERE State_Province_Name ='"+stateName+"'", 2, "EscapeDB_SIT","ENICDB-STAGE");
                	CountryValues=cFunc.getDataFromDB("SELECT CountryKey,Country_Name FROM [EscapeDB_SIT].[dbo].[DimCountry] WHERE Country_Name ='"+countryName+"'", 2, "EscapeDB_SIT","ENICDB-STAGE");
                }
                else
                {
                	AccountDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [EscapeDB].[dbo].[SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 36, "EscapeDB","ENICDB-STAGE");
                	StateValues=cFunc.getDataFromDB("SELECT StateKey,State_Province_Name FROM [EscapeDB].[dbo].[SUB_State] WHERE State_Province_Name ='"+stateName+"'", 2, "EscapeDB","ENICDB-STAGE");
                	CountryValues=cFunc.getDataFromDB("SELECT CountryKey,Country_Name FROM [EscapeDB].[dbo].[DimCountry] WHERE Country_Name ='"+countryName+"'", 2, "EscapeDB","ENICDB-STAGE");
                 }
           }
           if(DBServer.equalsIgnoreCase("DWH"))
           {
        	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
                {
                	AccountDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [IRF_EscapeDB].[dbo].[SUB_DW_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 36, "IRF_EscapeDB", "ENDWSQLS2");	 
                } 
                else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
                {
                	AccountDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [IRF_EscapeDB].[dbo].[SUB_DW_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 36, "IRF_EscapeDB", "ENDWSQLS");
                	StateValues=cFunc.getDataFromDB("SELECT StateKey,State_Province_Name FROM [IRF_EscapeDB].[dbo].[SUB_State] WHERE State_Province_Name ='"+stateName+"'", 2, "IRF_EscapeDB", "ENDWSQLS");
                	CountryValues=cFunc.getDataFromDB("SELECT CountryKey,Country_Name FROM [IRF_EscapeDB].[dbo].[SUB_Country] WHERE Country_Name ='"+countryName+"'", 2, "IRF_EscapeDB", "ENDWSQLS");
                }
                else
                {
                	AccountDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [IRF_EscapeDB].[dbo].[SUB_DW_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 36, "IRF_EscapeDB", "ENDWSQLS");
                	StateValues=cFunc.getDataFromDB("SELECT StateKey,State_Province_Name FROM [IRF_EscapeDB].[dbo].[SUB_State] WHERE State_Province_Name ='"+stateName+"'", 2, "IRF_EscapeDB", "ENDWSQLS");
                	CountryValues=cFunc.getDataFromDB("SELECT CountryKey,Country_Name FROM [IRF_EscapeDB].[dbo].[SUB_Country] WHERE Country_Name ='"+countryName+"'", 2, "IRF_EscapeDB", "ENDWSQLS");
                 }
           }
                
                String[] AccountStageDHWDBvalues1;
                AccountStageDHWDBvalues1=AccountDHWDBvalues.get(0);
                customerID=AccountStageDHWDBvalues1[23];
                stateValue = StateValues.get(0)[1];
                countryValue = CountryValues.get(0)[1];
                newBusinessAccountDBDataMap.put("AccountNumber", AccountStageDHWDBvalues1[1]);
                newBusinessAccountDBDataMap.put("AccountVersionNumber", AccountStageDHWDBvalues1[2]);
        		newBusinessAccountDBDataMap.put("InsuredName", AccountStageDHWDBvalues1[3]);		
        		newBusinessAccountDBDataMap.put("MailingStreetAddress", AccountStageDHWDBvalues1[4]);
        		newBusinessAccountDBDataMap.put("MailingCity", AccountStageDHWDBvalues1[5]);
        		newBusinessAccountDBDataMap.put("MailingState", stateValue);
        	    newBusinessAccountDBDataMap.put("Country", countryValue);
        		newBusinessAccountDBDataMap.put("MailingZipCode", AccountStageDHWDBvalues1[7]);
        		newBusinessAccountDBDataMap.put("MailingZipAddon", AccountStageDHWDBvalues1[8]);
        		newBusinessAccountDBDataMap.put("System_Generate_FEIN", AccountStageDHWDBvalues1[21]);
        		for(String key : newBusinessUIDataMap.keySet())
        		{
        			String valueUI = newBusinessUIDataMap.get(key);
        			String valueDB = newBusinessAccountDBDataMap.get(key);
        			
        			if(valueUI!=null && valueDB!=null)
        			{
        				if(!(valueUI.equalsIgnoreCase(valueDB)))
        				{

        					isMatched=false;
        					CustomReporting.logReport("","", "Created Account Data for  "+key+" the UI value "+valueUI+" and DB Value "+valueDB+" are NOT Equal","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
        				}
        			}
        			else {
        				CustomReporting.logReport("Created Account Data for  "+key+" the UI value "+valueUI+" and DB Value "+valueDB);
        			}
        		}
        		if(isMatched)
        		{
					CustomReporting.logReport("","", "All Account Details Matched","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
					
        		}
        	}
         catch(Exception e)
         {   
        	 CustomReporting.logReport("","", "Account created in stage env is not exist in the DWH DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
         //throw new RuntimeException(); 
        	 
         }
         try
         {
                if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
                {
                	CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [CustomerHub].[dbo].[Customer]  WHERE customerID ='"+customerID+"'", 10, "EscapeDB","enicdb-dev\\enic_qa");	 
                 }
                else
                {
                	CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [CustomerHub].[dbo].[Customer]  WHERE customerID ='"+customerID+"'", 10, "CustomerHub","ENICDB-STAGE");
                       
                 }
                String[] CustomerStageDHWDBvalues1;
                 CustomerStageDHWDBvalues1=CustomerDHWDBvalues.get(0);
                 	if(CustomerStageDHWDBvalues1[1].trim().equals(customerID))
                       {
                              CustomReporting.logReport("","", "Customer created in stage env is exist in the DWH DB",StepStatus.REPORT,new String[] { },System.currentTimeMillis());     
                              
                       }
                       else
                       {
                              CustomReporting.logReport("","", "Customer created in stage env is not exist in the DWH DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
                              //throw new RuntimeException();
                       }
               
          }
          catch(Exception e)
          {   
         	 CustomReporting.logReport("","", "Customer created in stage env is not exist in the DWH DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
                	 
          }
       	}

	@Override
	public void verify_NewBusinessAccount_InDB(String tcID, SoftAssert softAs, String DBServer) throws Exception {
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 PageData dataAccount = PageDataManager.instance().getPageData("NewBusiness",tcID);
	     if(!dataAccount.getData("Sys_TC_ID").equals(""))
	     {
	    	dataAccount = PageDataManager.instance().getPageData("NewBusiness",dataAccount.getData("Sys_TC_ID"));
	     }
		 
		 LinkedHashMap<Integer, String[]>AccountDBvalues =null;
	     LinkedHashMap<Integer, String[]> CustomerDHWDBvalues =null;
	     Map<String, String> dataAccountUIDataMap = new LinkedHashMap<>();
	     Map<String, String> dataAccountDBDataMap = new LinkedHashMap<>();
	     Boolean isMatched =true;
	     String customerID = null ;
	     String[] AccountStageDHWDBvalues1;
	     
	     
	     String  accountNumber = dataAccount.getData("AccountNumber").split("-")[0];
	     dataAccountUIDataMap.put("AccountNumber", accountNumber);
	     
	     try
	     {
	       if(DBServer.equalsIgnoreCase("EscapeDB"))
	       {
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		   AccountDBvalues =cFunc.getDataFromDB("SELECT Account_Nbr, CustomerID FROM [EscapeDB].[dbo].[SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 2, "EscapeDB","enicdb-dev\\enic_qa");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	AccountDBvalues =cFunc.getDataFromDB("SELECT Account_Nbr, CustomerID FROM [EscapeDB_SIT].[dbo].[SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 2, "EscapeDB_SIT","ENICDB-STAGE");
	            	
	            }
	            else
	            {
	            	AccountDBvalues =cFunc.getDataFromDB("SELECT Account_Nbr, CustomerID FROM [EscapeDB].[dbo].[SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 2, "EscapeDB","ENICDB-STAGE");
	            }
	       }
	       if(DBServer.equalsIgnoreCase("DWH"))
	       {
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		   AccountDBvalues =cFunc.getDataFromDB("SELECT Account_Nbr, CustomerID FROM [IRF_EscapeDB].[dbo].[HST_SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 2, "IRF_EscapeDB","ENDWSQLS2");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	AccountDBvalues =cFunc.getDataFromDB("SELECT Account_Nbr, CustomerID FROM [IRF_EscapeDB].[dbo].[HST_SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 2, "IRF_EscapeDB", "ENDWSQLS");
	            }
	            else
	            {
	            	AccountDBvalues =cFunc.getDataFromDB("SELECT Account_Nbr, CustomerID FROM [IRF_EscapeDB].[dbo].[HST_SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 2, "IRF_EscapeDB", "ENDWSQLS");
	            }
	       }
	       
	       AccountStageDHWDBvalues1=AccountDBvalues.get(0);
	      dataAccountDBDataMap.put("AccountNumber", AccountStageDHWDBvalues1[0]);
	      dataAccountDBDataMap.put("CustomerID", AccountStageDHWDBvalues1[1]);
	      customerID = dataAccountDBDataMap.get("CustomerID");
	       for(String key : dataAccountUIDataMap.keySet())
			{
				String valueUI = dataAccountUIDataMap.get(key);
				String valueDB = dataAccountDBDataMap.get(key);
				
				if(valueUI!=null && valueDB!=null)
				{
					if(!(valueUI.equalsIgnoreCase(valueDB)))
					{

						isMatched=false;
						CustomReporting.logReport("","", "Created Account Data for  "+key+" the UI value "+valueUI+" and DB Value "+valueDB+" are NOT Equal","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					}
				}
				else {
					CustomReporting.logReport("Created Account Data for  "+key+" the UI value "+valueUI+" and DB Value "+valueDB);
				}
			}
			if(isMatched)
			{
				CustomReporting.logReport("","", "All Account Details Matched","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
				
			}
		}
	catch(Exception e)
	{   
		 CustomReporting.logReport("","", "Account created in stage env is not exist in the DWH DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	//throw new RuntimeException(); 
		 
	}
	 
	     try
	     {
	            if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	            	CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [CustomerHub].[dbo].[Customer]  WHERE customerID ='"+customerID+"'", 10, "EscapeDB","enicdb-dev\\enic_qa");	 
	             }
	            else
	            {
	            	CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [CustomerHub].[dbo].[Customer]  WHERE customerID ='"+customerID+"'", 10, "CustomerHub","ENICDB-STAGE");
	                   
	             }
	            String[] CustomerStageDHWDBvalues1;
	             CustomerStageDHWDBvalues1=CustomerDHWDBvalues.get(0);
	             	if(CustomerStageDHWDBvalues1[1].trim().equals(customerID))
	                   {
	                          CustomReporting.logReport("","", "Customer created in stage env is exist in the DB",StepStatus.REPORT,new String[] { },System.currentTimeMillis());     
	                          
	                   }
	                   else
	                   {
	                          CustomReporting.logReport("","", "Customer created in stage env is not exist in the DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	                          //throw new RuntimeException();
	                   }
	           
	      }
	      catch(Exception e)
	      {   
	     	 CustomReporting.logReport("","", "Customer created in stage env is not exist in the DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	            	 
	      }
	     
		
	}

	@Override
	public void verify_NewBusinessSubmission_InDB(String tcID, SoftAssert softAs, String DBServer) throws Exception {
		
		
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		 PageData dataSubmission = PageDataManager.instance().getPageData("NewBusiness",tcID);
	    
		 if(!dataSubmission.getData("Sys_TC_ID").equals(""))
		 {
			 dataSubmission = PageDataManager.instance().getPageData("NewBusiness",dataSubmission.getData("Sys_TC_ID")); 
		 }
		 
		 LinkedHashMap<Integer, String[]>SubmissionDHWDBvalues =null;
	     Map<String, String> newBusinessUIDataMap = new LinkedHashMap<>();
	     Map<String, String> newBusinessSubmissionDBDataMap = new LinkedHashMap<>();
	     Boolean isMatched =true;
	     
	     String  SubmissionNumber = dataSubmission.getData("SubmissionNumber").split("-")[0];
	     newBusinessUIDataMap.put("SubmissionNumber", SubmissionNumber);
	     
	     try
	     {
	       if(DBServer.equalsIgnoreCase("EscapeDB"))
	       {
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		   SubmissionDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [EscapeDB].[dbo].[SUB_Submission]  WHERE Submission_Nbr ='"+SubmissionNumber+"'", 36, "EscapeDB","enicdb-dev\\enic_qa");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	SubmissionDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [EscapeDB_SIT].[dbo].[SUB_Submission]  WHERE Submission_Nbr ='"+SubmissionNumber+"'", 36, "EscapeDB_SIT","ENICDB-STAGE");
	            	
	            }
	            else
	            {
	            	SubmissionDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [EscapeDB].[dbo].[SUB_Submission]  WHERE Submission_Nbr ='"+SubmissionNumber+"'", 36, "EscapeDB","ENICDB-STAGE");
	            }
	       }
	       if(DBServer.equalsIgnoreCase("DWH"))
	       {
	    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	            {
	    		   SubmissionDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [IRF_EscapeDB].[dbo].[HST_SUB_Submission]  WHERE Submission_Nbr ='"+SubmissionNumber+"'", 36, "IRF_EscapeDB","ENDWSQLS2");	 
	            } 
	            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	            {
	            	SubmissionDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [IRF_EscapeDB].[dbo].[HST_SUB_Submission]  WHERE Submission_Nbr ='"+SubmissionNumber+"'", 36, "IRF_EscapeDB", "ENDWSQLS");
	            }
	            else
	            {
	            	SubmissionDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [IRF_EscapeDB].[dbo].[HST_SUB_Submission]  WHERE Submission_Nbr ='"+SubmissionNumber+"'", 36, "IRF_EscapeDB", "ENDWSQLS");
	            }
	       }
	       String[] SubmissionStageDHWDBvalues1;
	       SubmissionStageDHWDBvalues1=SubmissionDHWDBvalues.get(0);
	       newBusinessSubmissionDBDataMap.put("SubmissionNumber", SubmissionStageDHWDBvalues1[1]);
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
		
	}

	@Override
	public void verify_Business_Customer_DnB_EIN_InDB(String tcID, SoftAssert softAs, String DBServer)
			throws Exception {
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		PageData dataBusiness = PageDataManager.instance().getPageData("NewBusiness",tcID);
	    LinkedHashMap<Integer, String[]>DnB_EINDBvalues =null;
	    LinkedHashMap<Integer, String[]> CustomerDHWDBvalues =null;
	    LinkedHashMap<Integer, String[]> InstancedataDBvalues = null;
	    Map<String, String> dataAccountUIDataMap = new LinkedHashMap<>();
	    Map<String, String> dataCustomerDBDataMap = new LinkedHashMap<>();
	    Boolean isMatched =true;
	    String[] CustomerStageDHWDBvalues1;
	    String CustomerId = null;
	    
	    String addr1 =  dataBusiness.getData("MailingStreetAddress");
	    dataAccountUIDataMap.put("Address1",addr1);
	    
	    try
	    {
	      if(DBServer.equalsIgnoreCase("EscapeDB"))
	      {
	   	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	           {
	   		   		CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT customerID, addressLine1, lastModifiedDate FROM [CustomerHub].[dbo].[Customer] WHERE addressLine1='"+addr1+"' order by lastModifiedDate desc", 2, "CustomerHub","enicdb-dev\\enic_qa");	 
	           } 
	           else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	           {
	        	   CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT customerID, addressLine1,lastModifiedDate FROM [CustomerHub].[dbo].[Customer] WHERE addressLine1='"+addr1+"' order by lastModifiedDate desc", 2, "CustomerHub","ENICDB-STAGE");
	           	
	           }
	           else
	           {											//SELECT customerID, addressLine1 FROM [CustomerHub].[dbo].[Customer] WHERE addressLine1='1401 S Grand Ave' [CustomerHub]
	        	   CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT customerID, addressLine1, lastModifiedDate FROM [CustomerHub].[dbo].[Customer] WHERE addressLine1='"+addr1+"' order by lastModifiedDate desc", 2, "CustomerHub","ENICDB-STAGE");
	           }
	      }
	      
	      CustomerStageDHWDBvalues1=CustomerDHWDBvalues.get(0);
	      dataCustomerDBDataMap.put("customerID", CustomerStageDHWDBvalues1[0]);
	      dataCustomerDBDataMap.put("addressLine1", CustomerStageDHWDBvalues1[1]);
	      dataCustomerDBDataMap.put("lastModifiedDate", CustomerStageDHWDBvalues1[2]);
	      CustomerId = dataCustomerDBDataMap.get("customerID");
	     
	      for(String key : dataAccountUIDataMap.keySet())
			{
				String valueUI = dataAccountUIDataMap.get(key);
				String valueDB = dataCustomerDBDataMap.get(key);
				
				if(valueUI!=null && valueDB!=null)
				{
					if(!(valueUI.equalsIgnoreCase(valueDB)))
					{

						isMatched=false;
						CustomReporting.logReport("","", "Created Customer ID for DB Value "+valueDB+" are NOT Equal","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
					}
				}
				else {
					CustomReporting.logReport("Created Customer ID for DB Value "+valueDB);
				}
			}
			if(isMatched)
			{
				CustomReporting.logReport("","", "All Customer Details Matched","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
				
			}
		}
	catch(Exception e)
	{   
		 CustomReporting.logReport("","", "Customer created in stage env is not exist in the Escaoe DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	//throw new RuntimeException(); 
		 
	}
	    String dataSrcKey1;
	    String dataSrcKey2;
	    String dataSrcKey3;
	    
	    String InsSrcKey1;
	    String InsSrcKey2;
	    String InsSrcKey3;
	    
	    try
	    {
	    String query = "select b.dataSourceKey from CustomerHub.dbo.fn_getLastUpdateBySourceForCustomerID('"+CustomerId+"',null) a join CustomerHub.dbo.DataSource b on a.dataSourceName = b.dataSourceName order by dataSourceKey";
	    if(DBServer.equalsIgnoreCase("EscapeDB"))
	    {
	 	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
	         {
	 		  DnB_EINDBvalues =cFunc.getDataFromDB(query, 1, "CustomerHub","enicdb-dev\\enic_qa");
	 		 InstancedataDBvalues = cFunc.getDataFromDB("select DISTINCT dataSourceKey from CustomerHub.dbo.InstanceData where addressLine1='"+addr1+"' order by dataSourceKey", 1, "CustomerHub", "enicdb-dev\\enic_qa");
	         } 
	         else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
	         {
	        	 DnB_EINDBvalues =cFunc.getDataFromDB(query, 1, "EscapeDB_SIT","ENICDB-STAGE");
	        	 InstancedataDBvalues =cFunc.getDataFromDB("select DISTINCT  dataSourceKey from CustomerHub.dbo.InstanceData where addressLine1='"+addr1+"' order by dataSourceKey", 1, "EscapeDB_SIT","ENICDB-STAGE");	
	         }
	         else
	         {
	        	 DnB_EINDBvalues =cFunc.getDataFromDB(query, 1, "CustomerHub","ENICDB-STAGE");
	        	 InstancedataDBvalues =cFunc.getDataFromDB("select DISTINCT dataSourceKey from CustomerHub.dbo.InstanceData where addressLine1='"+addr1+"' order by dataSourceKey", 1, "CustomerHub","ENICDB-STAGE");
	         }
	    }

	    dataSrcKey1 = DnB_EINDBvalues.get(0)[0];
	    dataSrcKey2 = DnB_EINDBvalues.get(1)[0];
	    dataSrcKey3 = DnB_EINDBvalues.get(2)[0];
	    
	    InsSrcKey1 = InstancedataDBvalues.get(0)[0];
	    InsSrcKey2 = InstancedataDBvalues.get(1)[0];
	    InsSrcKey3 = InstancedataDBvalues.get(2)[0];
	    if(dataSrcKey1.trim().equals(InsSrcKey1) )
	    {
	    	CustomReporting.logReport("","", "'Escape' record is created along with timestamp",StepStatus.REPORT,new String[] { },System.currentTimeMillis());     
	        
	    }
	    else
	    {
	           CustomReporting.logReport("","", "'Escape' record is not created along with timestamp","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	           //throw new RuntimeException();
	    }
	    if( dataSrcKey2.trim().equals(InsSrcKey2) && dataSrcKey3.trim().equals(InsSrcKey3))
	    {
	    	CustomReporting.logReport("","", "'D&B plus', 'EIN' records are created along with timestamp",StepStatus.REPORT,new String[] { },System.currentTimeMillis());     
	        
	    }
	    else
	    {
	           CustomReporting.logReport("","", "'D&B plus', 'EIN' records are not created along with timestamp","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	           //throw new RuntimeException();
	    }
	 	   
	    }
	    catch(Exception ex) {
	    	 CustomReporting.logReport("","", "Customer enrich created data in stage env is not exist in the Escape DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
	    	    
	    } 
		
	}
	
	
	
		
}
