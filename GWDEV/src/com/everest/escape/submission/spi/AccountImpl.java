package com.everest.escape.submission.spi;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.Element.WAIT_FOR;

import com.everest.escape.submission.Account;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class AccountImpl extends CustomAbstractPage implements Account {

	@Override
	public void CreateAccount (String tcID, SoftAssert softAsser) throws Exception{
		
		
		PageData dataAccount = PageDataManager.instance().getPageData("EscAccount",tcID);
		PageData dataUMSubmissionDetails = PageDataManager.instance().getPageData("UMSubmissionDetails",tcID);
		PageData dataEditSub = PageDataManager.instance().getPageData("Edit_UMSubmissionDetails",tcID);
		Thread.sleep(2000);
		long startTime1 = System.currentTimeMillis();
		long elapsedTime1=0L;
		String insuredName="";
		_click(getElement(btn_NewAccount));
		 func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(1000);
		 elapsedTime1 = (new Date()).getTime() - startTime1; 
		CustomReporting.logReport("Time taken to Complete T13_BeginBinding Transaction :  "+elapsedTime1 +" ms"); 
		 if(dataAccount.getData("InsuredName").contains(";"))
	    	{
			 _setValue(getElement(txt_InsuredName),dataAccount.getData("InsuredName").split(";")[0]);
			 WebElement elm = (WebElement) getElement(txt_InsuredName).getNative();
			 elm.sendKeys(Keys.TAB);
			 func._waitForPageToLoad(getWebDriver(),50L);
		     Thread.sleep(2000);
	    	}
		 
		 else {
			 String timeStamp = (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())).replace(".", "");

				insuredName=dataAccount.getData("InsuredName") + "_" + timeStamp;
				
		 _setValue(getElement(txt_InsuredName),insuredName);
		 
		 
		 
		 //func._writeToExcel("EscAccount", "InsuredName", insuredName, tcID);
		 WebElement elm = (WebElement) getElement(txt_InsuredName).getNative();
		 elm.sendKeys(Keys.TAB);
		 func._waitForPageToLoad(getWebDriver(),50L);
	     Thread.sleep(2000);}
		 if(!dataAccount.getData("FEIN").equals("NA"))
		 {
			 if(!dataAccount.getData("FEIN").equals(""))
				 _setValue(getElement(txt_FEIN),dataAccount.getData("FEIN"));
			 else
			 {
				 String tempFEIN=func.generate_RandomNumber(9);
				 _setValue(getElement(txt_FEIN),tempFEIN); 
				  Thread.sleep(2000);
				 func._writeToExcel("Account", "Sys_Generated_FEIN",tempFEIN, tcID); 
				 if(tcID.equals("DS0054"))
				 {
					 func._writeToExcel("NewBusiness", "System_Generate_FEIN",tempFEIN, tcID); 
				 }
				 
			 }
		 }
		  func._waitForPageToLoad(getWebDriver(),50L);
		  Thread.sleep(2000);
		  if(dataAccount.getData("InsuredName").contains(";"))
	    	{
			  String primaryInsuredArray[]=dataAccount.getData("InsuredName").split(";");
			  for (int i = 1; i < primaryInsuredArray.length; i++) {
				  WebElement addButtonForDBA = getWebDriver().findElement(By.xpath(".//*[@id='btnAddAdditionalName_"+i+"']"));
  					addButtonForDBA.click();
	    	        func._waitForPageToLoad(getWebDriver(),50L);
	    	        Thread.sleep(2000);
	    	        WebElement we=getWebDriver().findElement(By.xpath(".//*[@id='QualifierDropDown_"+i+"']"));
	    			Select selValue=new Select(we);
			    	selValue.selectByVisibleText(primaryInsuredArray[i].split(",")[0]);
			    	Thread.sleep(2000);
			    	func._waitForPageToLoad(getWebDriver(),50L);
			    	getWebDriver().findElement(By.xpath(".//*[@id='additionalnames_"+i+"']")).sendKeys(primaryInsuredArray[i].split(",")[1]);
			}
	    	}
	    if(!dataAccount.getData("MultiFEIN").equals(""))
	    {
	    	if(dataAccount.getData("MultiFEIN").contains(";"))
	    	{
	    		String arrFEIN[]=dataAccount.getData("MultiFEIN").split(";");
	    		for(int i=1;i<=arrFEIN.length;i++)
	    		{
	    			_click(getElement(btn_AddInsured));
	    	        func._waitForPageToLoad(getWebDriver(),50L);
	    	        Thread.sleep(2000);
	    			/*WebElement we=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabAccount_ctrlAccount_GridView1']/tbody/tr["+i+"]/td[1]/select"));
	    			Select selValue=new Select(we);
			    	selValue.selectByVisibleText(arrFEIN[i-1].split(",")[0]);
			    	func._waitForPageToLoad(getWebDriver(),50L);*/
	    			getWebDriver().findElement(By.xpath(".//*[@id='txtprimaryInsuredName_"+(i+1)+"']")).sendKeys(arrFEIN[i-1].split(",")[0]);
	    			 func._waitForPageToLoad(getWebDriver(),50L);
	    			getWebDriver().findElement(By.xpath(".//*[@id='txtprimaryFEIN_"+(i+1)+"']")).sendKeys(arrFEIN[i-1].split(",")[1]);
	    			Thread.sleep(3000);
	    			if(arrFEIN[i-1].split(",").length>2) {
	    				WebElement addButtonForDBA = getWebDriver().findElement(By.xpath(".//*[@id='btnAddAdditionalName_"+(i+1)+"']"));
	    				addButtonForDBA.click();
		    	        func._waitForPageToLoad(getWebDriver(),50L);
		    	        Thread.sleep(2000);
	    				WebElement we=getWebDriver().findElement(By.xpath(".//*[@id='QualifierDropDown_"+(i+1)+"']"));
		    			Select selValue=new Select(we);
				    	selValue.selectByVisibleText(arrFEIN[i-1].split(",")[2]);
				    	Thread.sleep(2000);
				    	func._waitForPageToLoad(getWebDriver(),50L);
				    	getWebDriver().findElement(By.xpath(".//*[@id='additionalnames_"+(i+1)+"']")).sendKeys(arrFEIN[i-1].split(",")[3]);
	    			}
	    			/*getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabAccount_ctrlAccount_GridView1']/tbody/tr["+i+"]/td[3]/input")).sendKeys(arrFEIN[i-1].split(",")[2]);
	    			Thread.sleep(3000);*/
	    		}
	    	}
	    	/*else if(dataAccount.getData("MultiFEIN").contains(","))
	    	{
		    	_click(getElement(btn_AddInsured));
		        func._waitForPageToLoad(getWebDriver(),50L);
		        Thread.sleep(2000);
				WebElement we=getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabAccount_ctrlAccount_GridView1']/tbody/tr[1]/td[1]/select"));
				Select selValue=new Select(we);
		    	selValue.selectByVisibleText(dataAccount.getData("MultiFEIN").split(",")[0]);
		    	func._waitForPageToLoad(getWebDriver(),50L);
				getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabAccount_ctrlAccount_GridView1']/tbody/tr[1]/td[2]/input")).sendKeys(dataAccount.getData("MultiFEIN").split(",")[1]);
				 func._waitForPageToLoad(getWebDriver(),50L);
				 Thread.sleep(2000);
				getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabAccount_ctrlAccount_GridView1']/tbody/tr[1]/td[3]/input")).sendKeys(dataAccount.getData("MultiFEIN").split(",")[2]);
				 func._waitForPageToLoad(getWebDriver(),50L);
				 Thread.sleep(2000);
				 getWebDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabAccount_ctrlAccount_GridView1']/tbody/tr[1]/td[3]/input")).sendKeys(dataAccount.getData("MultiFEIN").split(",")[2]);
				 func._waitForPageToLoad(getWebDriver(),50L);
				 Thread.sleep(2000);
	    	}*/
	    }
	   
	    Thread.sleep(2000);
	    _click(getElement(btn_OFACSearch));
	   
	    Thread.sleep(5000);
	   
	    Robot robot = new Robot();
	    try
	    {
	    func._waitFor(getElement(msg_OFACSearchResult), 200L, WAIT_FOR.VISIBLE);
	    boolean elementExist=func._isVisible(getElement(msg_OFACSearchResult));
	    if(!elementExist)
	    {
	    	
	    	robot.keyPress(KeyEvent.VK_CONTROL);
	    	robot.keyPress(KeyEvent.VK_MINUS);
	    	robot.keyRelease(KeyEvent.VK_CONTROL);
	    	robot.keyRelease(KeyEvent.VK_MINUS);
	    	robot.keyPress(KeyEvent.VK_CONTROL);
	    	robot.keyPress(KeyEvent.VK_MINUS);
	    	robot.keyRelease(KeyEvent.VK_CONTROL);
	    	robot.keyRelease(KeyEvent.VK_MINUS);
	    	robot.keyPress(KeyEvent.VK_CONTROL);
	    	robot.keyPress(KeyEvent.VK_MINUS);
	    	robot.keyRelease(KeyEvent.VK_CONTROL);
	    	robot.keyRelease(KeyEvent.VK_MINUS);
	    	Thread.sleep(5000);
	    	 File directory = new File("./");
	         String strDirectoryPath =directory.getAbsolutePath().split("\\.") [0];
	 			String strBundlePath=strDirectoryPath+"resources\\Images";
	         ImagePath.setBundlePath(strBundlePath);
	         Screen screen = new Screen();
	         Pattern img_Close = new Pattern("CloseOFAC.PNG");
	            
	         screen.wait(img_Close, 5);
	         Thread.sleep(3000);
	         screen.click();
	         Thread.sleep(3000);
    
	    	//_click(getElement(btn_OFACSearchClose));
	 	    func._waitForPageToLoad(getWebDriver(),150L);
	 	    Thread.sleep(2000);
	 	    robot.keyPress(KeyEvent.VK_CONTROL);
	    	robot.keyPress(KeyEvent.VK_EQUALS);
	    	robot.keyRelease(KeyEvent.VK_CONTROL);
	    	robot.keyRelease(KeyEvent.VK_EQUALS);
	    	robot.keyPress(KeyEvent.VK_CONTROL);
	    	robot.keyPress(KeyEvent.VK_EQUALS);
	    	robot.keyRelease(KeyEvent.VK_CONTROL);
	    	robot.keyRelease(KeyEvent.VK_EQUALS);
	    	robot.keyPress(KeyEvent.VK_CONTROL);
	    	robot.keyPress(KeyEvent.VK_EQUALS);
	    	robot.keyRelease(KeyEvent.VK_CONTROL);
	    	robot.keyRelease(KeyEvent.VK_EQUALS);
	    	
	    	 func._waitForPageToLoad(getWebDriver(),150L);
			    Thread.sleep(2000);
	    }
	    else
	    {
	    	func._waitForPageToLoad(getWebDriver(),100L);
		  	func._checkDefaultValue(getElement(msg_OFACSearchResult),"TEXT","search produced no results");
		    _click(getElement(btn_OFACSearchClose));
		    func._waitForPageToLoad(getWebDriver(),150L);
		    Thread.sleep(2000);
		   	
	    }
	    }
	    catch(Exception ex)
	    {
	    	
	    }
	    _setValue(getElement(txt_MailingAddress),dataAccount.getData("MailingAddress"));
	   
	    _setValue(getElement(txt_MailingCity),dataAccount.getData("MailingCity"));
	    
	    _setValue(getElement(lst_MailingCountry),dataAccount.getData("MailingCountry"));
	    
	    Thread.sleep(2000);
	    _setValue(getElement(lst_MailingState),dataAccount.getData("MailingState"));
	    
	    Thread.sleep(2000);
	    _setValue(getElement(txt_MailingZipCode),dataAccount.getData("MailingZipCode"));
	   
	    if(!dataAccount.getData("ZipAddOn").equals(""))
	    {
	    	_setValue(getElement(txt_ZipAddOn),dataAccount.getData("ZipAddOn"));
	    }
	    Thread.sleep(2000);
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    Thread.sleep(1000);
	   
	    if (dataAccount.getData("OwnershipType").length()!=0) {
	    	//Select Ownership Type
		    
		    func._setValue(getElement(lst_OwnershipType), dataAccount.getData("OwnershipType"));
		    Thread.sleep(2000);
	    }
	    try {
	    if(dataUMSubmissionDetails.getData("DuplicateAccount").equalsIgnoreCase("Yes"))
		 {
	    	
			 func._writeToExcel("UMSubmissionDetails", "Sys_Generate_InsureName", insuredName, tcID);
			 
	    	 func._writeToExcel("UMSubmissionDetails", "Street1", dataAccount.getData("MailingAddress"), tcID);
	    	 func._writeToExcel("UMSubmissionDetails", "City", dataAccount.getData("MailingCity"), tcID);
	    	 func._writeToExcel("UMSubmissionDetails", "Country", dataAccount.getData("MailingCountry"), tcID);
	    	 func._writeToExcel("UMSubmissionDetails", "State", dataAccount.getData("MailingCountry"), tcID);
	    	 func._writeToExcel("UMSubmissionDetails", "ZipCode", dataAccount.getData("MailingZipCode"), tcID);
		 }
	    }
	    catch(Exception ex)
	    {
	    	
	    }
	    try
	    {
	    if(dataEditSub.getData("DuplicateAccount").equalsIgnoreCase("Yes"))
		 {
	    	
			 func._writeToExcel("Edit_UMSubmissionDetails", "InsuredName", insuredName, tcID);
			 
	    	 func._writeToExcel("Edit_UMSubmissionDetails", "Street1", dataAccount.getData("MailingAddress"), tcID);
	    	 func._writeToExcel("Edit_UMSubmissionDetails", "City", dataAccount.getData("MailingCity"), tcID);
	    	 func._writeToExcel("Edit_UMSubmissionDetails", "Country", dataAccount.getData("MailingCountry"), tcID);
	    	 func._writeToExcel("Edit_UMSubmissionDetails", "State", dataAccount.getData("MailingCountry"), tcID);
	    	 func._writeToExcel("Edit_UMSubmissionDetails", "ZipCode", dataAccount.getData("MailingZipCode"), tcID);
		 }
	    }
	    catch(Exception ex)
	    {
	    	
	    }
	    
	     startTime1 = System.currentTimeMillis();
		 elapsedTime1=0L;
	    _click(getElement(btn_CreateAccount));
	    func._record_PageLoadTime(getWebDriver(), 300L);
	   func._waitForPageToLoad(getWebDriver(), 300L);
	   Thread.sleep(2000);
	   elapsedTime1 = (new Date()).getTime() - startTime1; 
		CustomReporting.logReport("Time taken to Complete Create Account :  "+elapsedTime1 +" ms"); 
	    func._waitFor(getElement(btn_CreateNewSubmission), 200, WAIT_FOR.CLICKABLE,"");
	    Thread.sleep(2000);
	   
	    WebElement weMsgText=(WebElement)getElement(msg_SuccessAccountCreated).getNative();
	    
	    if(weMsgText.getText().trim().contains("Account information updated successfully"))
		 {
			 CustomReporting.logReport("","","Account is created successfully!" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
		 }
		 else
		 {
			 CustomReporting.logReport("","", "Account is not created","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
				throw new RuntimeException();
		 }
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    Thread.sleep(3000);
	    PageData dataLogin = PageDataManager.instance().getPageData("EscapeLogin",tcID);
	    String accountTab = getElement(tab_Account).getValue();
	    
	    if(dataLogin.getData("Environment").toUpperCase().equals("SIT"))
	    {
	    accountTab=func._splitDatabyPosition(accountTab, 9, accountTab.length());
	    }
	    else
	    {
	    	 accountTab=func._splitDatabyPosition(accountTab, 9, 17);	
	    }
	    
	    	
	    	
	    if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
	    {
	    	//String accountTab = getElement(tab_Account).getValue();
	    	//accountTab=func._splitDatabyPosition(accountTab, 9, 18);
	    	 func._writeToExcel("QASearch", "AccountNumber",accountTab, tcID);	
	    }
	    else
	    {
	    	//String accountTab = getElement(tab_Account).getValue();
	    	//accountTab=func._splitDatabyPosition(accountTab, 9, 17);
	    	func._writeToExcel("Search", "AccountNumber",accountTab, tcID);
	    	 //func._writeToExcel("Search", "AccountNumber",getElement(getAccountNumber).getAttribute("value"), tcID);	
	    }
	   
	    func._writeToExcel("SearchPolicy", "AccountNo",accountTab, tcID);
	    func._writeToExcel("EscAccount", "AccountNumber",accountTab, tcID);
	    func._addToGlobalVariableList("tkn_AccountNum", accountTab);
	    

	}	
	public void clk_CreateNewSubmission (String tcID, SoftAssert softAssert) throws Exception{
		
	  //Thread.sleep(5000);
	  func._waitForPageToLoad(getWebDriver(),100L);
	  Thread.sleep(3000);
	  // func._waitFor(getElement(btn_CreateNewSubmission), 500, WAIT_FOR.CLICKABLE,"");
	  long startTime1 = System.currentTimeMillis();
		long elapsedTime1=0L;
	  _click(getElement(btn_CreateNewSubmission));
	  Thread.sleep(2000);
	  /*func._alertHandler(getWebDriver(), "Ok");
	  Thread.sleep(2000);*/
	  func._waitForPageToLoad(getWebDriver(),50L);
	  Thread.sleep(2000);
	  elapsedTime1 = (new Date()).getTime() - startTime1; 
		CustomReporting.logReport("Time taken to Complete CreateNew Submission Transaction :  "+elapsedTime1 +" ms"); 
		
	}
	
	public void EditAccount (String tcID, SoftAssert softAssert) throws Exception{
		
		PageData dataEditAccount = PageDataManager.instance().getPageData("EditAccount",tcID);
		func._waitForPageToLoad(getWebDriver(),50L);
		 Thread.sleep(2000);
		_click(getElement(tab_Account));
		func._waitForPageToLoad(getWebDriver(),50L);
		Thread.sleep(3000);
		
		if(!dataEditAccount.getData("InsuredName").equals(""))
		{
			getWebDriver().findElement(By.xpath("//*[@id='txtprimaryInsuredName_1']")).clear();
			Thread.sleep(6000);
			getWebDriver().findElement(By.xpath("//*[@id='txtprimaryInsuredName_1']")).sendKeys(dataEditAccount.getData("InsuredName"));
			//_setValue(getElement(txt_InsuredName),dataEditAccount.getData("InsuredName"));
	    	Thread.sleep(2000);
	    	_click(getElement(btn_OFACSearch));
		    func._waitForPageToLoad(getWebDriver(),50L);
		    /*boolean elementExist=_isVisible(getElement(msg_OFACSearchResult));
		    if(!elementExist)
		    {
		    	_click(getElement(btn_OFACSearch));	
		    }
		    func._waitForPageToLoad(getWebDriver(), 300L);*/
		    Thread.sleep(2000);
		    boolean elementExist1=func._isVisible(getElement(msg_OFACSearchResult));
		    Robot robot = new Robot();
		    if(!elementExist1)
		    {
		    	
		    	robot.keyPress(KeyEvent.VK_CONTROL);
		    	robot.keyPress(KeyEvent.VK_MINUS);
		    	robot.keyRelease(KeyEvent.VK_CONTROL);
		    	robot.keyRelease(KeyEvent.VK_MINUS);
		    	robot.keyPress(KeyEvent.VK_CONTROL);
		    	robot.keyPress(KeyEvent.VK_MINUS);
		    	robot.keyRelease(KeyEvent.VK_CONTROL);
		    	robot.keyRelease(KeyEvent.VK_MINUS);
		    	robot.keyPress(KeyEvent.VK_CONTROL);
		    	robot.keyPress(KeyEvent.VK_MINUS);
		    	robot.keyRelease(KeyEvent.VK_CONTROL);
		    	robot.keyRelease(KeyEvent.VK_MINUS);
		    	Thread.sleep(5000);
		    	 File directory = new File("./");
		         String strDirectoryPath =directory.getAbsolutePath().split("\\.") [0];
		 			String strBundlePath=strDirectoryPath+"resources\\Images";
		         ImagePath.setBundlePath(strBundlePath);
		         Screen screen = new Screen();
		         Pattern img_Close = new Pattern("CloseOFAC.PNG");
		            
		         screen.wait(img_Close, 5);
		         Thread.sleep(3000);
		         screen.click();
		         Thread.sleep(3000);
	    
		    	//_click(getElement(btn_OFACSearchClose));
		 	    func._waitForPageToLoad(getWebDriver(),150L);
		 	    Thread.sleep(2000);
		 	    robot.keyPress(KeyEvent.VK_CONTROL);
		    	robot.keyPress(KeyEvent.VK_EQUALS);
		    	robot.keyRelease(KeyEvent.VK_CONTROL);
		    	robot.keyRelease(KeyEvent.VK_EQUALS);
		    	robot.keyPress(KeyEvent.VK_CONTROL);
		    	robot.keyPress(KeyEvent.VK_EQUALS);
		    	robot.keyRelease(KeyEvent.VK_CONTROL);
		    	robot.keyRelease(KeyEvent.VK_EQUALS);
		    	robot.keyPress(KeyEvent.VK_CONTROL);
		    	robot.keyPress(KeyEvent.VK_EQUALS);
		    	robot.keyRelease(KeyEvent.VK_CONTROL);
		    	robot.keyRelease(KeyEvent.VK_EQUALS);
		    	
		    	 func._waitForPageToLoad(getWebDriver(),150L);
				    Thread.sleep(2000);
		    }
		    else
		    {
		    	func._waitForPageToLoad(getWebDriver(),300L);
			  	func._checkDefaultValue(getElement(msg_OFACSearchResult),"TEXT","search produced no results");
			    _click(getElement(btn_OFACSearchClose));
			    func._waitForPageToLoad(getWebDriver(),300L);
			    Thread.sleep(2000);
			   	
		    }
		    
	    	
		}
		
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if(!dataEditAccount.getData("FEIN").equals(""))
		{
			 _setValue(getElement(txt_FEIN),dataEditAccount.getData("FEIN"));
		     //_click(getElement(btn_FEINAdd));
			 Thread.sleep(5000);
		}
		_click(getElement(btn_Save));
		
	}
	
	public void VerifyInsurename (String tcID, SoftAssert softAssert) throws Exception{
		
		PageData dataEditAccount = PageDataManager.instance().getPageData("EditAccount",tcID);

		_click(getElement(tab_Account));
		
		Thread.sleep(4000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		 func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
		String strInsureName=getElement(txt_InsuredName).getAttribute("value").trim().toLowerCase();
		 Long startTime = System.currentTimeMillis();
		if(dataEditAccount.getData("InsuredName").trim().toLowerCase().contains(strInsureName))
		{
			CustomReporting.logReport("","","Old Insuredname is not displayed in expired account" ,StepStatus.SUCCESS,new String[] { },startTime);
		}
		else
		{
			CustomReporting.logReport("","", "Old Insuredname is still displaying in expired account","", StepStatus.FAILURE,new String[] {  }, startTime, null);
			throw new RuntimeException();
		}
		
		
	}
	
	public void VerifyAccountDetails (String tcID, SoftAssert softAssert,String type) throws Exception{
		
		  func._waitForPageToLoad(getWebDriver(),200L);
		  Thread.sleep(2000);
		  func._waitFor(getElement(tab_Account), 200, WAIT_FOR.CLICKABLE);
		  Thread.sleep(5000);
		 PageData dataAccount = PageDataManager.instance().getPageData("Account",tcID);
		 if(!dataAccount.getData("Sys_tcID").equals(""))
		 {
			 dataAccount = PageDataManager.instance().getPageData("Account",dataAccount.getData("Sys_tcID")); 
		 }
		 
		_click(getElement(tab_Account));
		func._waitForPageToLoad(getWebDriver(),200L);
		  Thread.sleep(5000);
		  if(!func._isVisible(getElement(btn_CreateNewSubmission)))
		  {
			  _click(getElement(tab_Account));  
			  Thread.sleep(5000);
		  }
		  
		 func._waitFor(getElement(btn_CreateNewSubmission), 100, WAIT_FOR.VISIBLE,"");
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		 /*if(type.trim().toLowerCase().equals("new"))
		 {
			 func._checkAttributeValue(getElement(getAccountNumber), "value",dataAccount.getData("AccountNumber"), softAssert);
		 }
		 if(type.trim().toLowerCase().equals("renewal"))
		 {
			 int AccountMod=Integer.valueOf(dataAccount.getData("AccountNumber").split("-")[1].trim())+1;
			 //int AccountMod=Integer.valueOf(func._getGlobalVariableValue("tkn_AccountNum").split("-")[1].trim())+1;
			
			 
			 String StrExpAccount=dataAccount.getData("AccountNumber").split("-")[0]+"-"+AccountMod;
			 func._checkAttributeValue(getElement(getAccountNumber), "value",StrExpAccount, softAssert);
			 
		 }*/
		/* if(func._isReadOnly(getElement(getAccountNumber)))
			{
				CustomReporting.logReport("","","AccountNumber field is Read only in account screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", ""," AccountNumber field is not Read only in account screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}*/
		
		func._checkAttributeValue(getElement(txt_InsuredName), "value",dataAccount.getData("InsuredName"), softAssert);
		
		if(func._isEnabled(getElement(txt_InsuredName)))
		{
			CustomReporting.logReport("","","InsuredName field is Enabled in account screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," InsuredName field is Disabled in account screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		//func._checkAttributeValue(getElement(getFEINValue), "TEXT",dataAccount.getData("FEIN"), softAssert);
		
		func._checkAttributeValue(getElement(txt_MailingAddress), "value",dataAccount.getData("MailingAddress"), softAssert);
		if(func._isEnabled(getElement(txt_MailingAddress)))
		
		{
			CustomReporting.logReport("","","MailingAddress field is Enabled in account screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," MailingAddress field is Disabled in account screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(txt_MailingCity), "value",dataAccount.getData("MailingCity"), softAssert);
		
		if(func._isEnabled(getElement(txt_MailingCity)))
		{
			CustomReporting.logReport("","","MailingCity field is Enabled in Account screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," MailingCity field is Disabled in Account screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_MailingState), "TEXT",dataAccount.getData("MailingState"), softAssert);
		
		if(func._isEnabled(getElement(lst_MailingState)))
		{
			CustomReporting.logReport("","","MailingState field is Enabled in Account screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," MailingState field is Disabled in Account screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(lst_MailingCountry), "TEXT",dataAccount.getData("MailingCountry"), softAssert);
		
		if(func._isEnabled(getElement(lst_MailingCountry)))
		{
			CustomReporting.logReport("","","MailingCountry field is Enabled in Account screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," MailingCountry field is Disabled in Account screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(txt_MailingZipCode), "value",dataAccount.getData("MailingZipCode"), softAssert);
		
		if(func._isEnabled(getElement(txt_MailingZipCode)))
		{
			CustomReporting.logReport("","","MailingZipCode field is Enabled in Account screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," MailingZipCode field is Disabled in Account screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		func._checkAttributeValue(getElement(txt_ZipAddOn), "value",dataAccount.getData("ZipAddOn"), softAssert);
	
		if(func._isEnabled(getElement(txt_ZipAddOn)))
		{
			CustomReporting.logReport("","","ZipAddOn field is Enabled in Account screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," ZipAddOn field is Disabled in Account screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(func._isEnabled(getElement(btn_OFACSearch)))
		{
			CustomReporting.logReport("","","OFACSearch button field is Enabled in Account screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," OFACSearch button field is Disabled in Account screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(func._isEnabled(getElement(txt_FEIN)))
		{
			CustomReporting.logReport("","","FEIN  field is Enabled in Account screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," FEIN  field is Disabled in Account screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		/*if(func._isEnabled(getElement(btn_FEINAdd)))
		{
			CustomReporting.logReport("","","FEIN Add button field is Enabled in Account screen" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," FEIN Add button field is Disabled in Account screen","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}*/

	}
	
	public void Verify_Account_ReadOnly_Fields (String tcID, SoftAssert softAssert) throws Exception{
		func._waitForPageToLoad(getWebDriver(), 300L);
		
		Thread.sleep(5000);
		_click(getElement(tab_Account));
		Thread.sleep(5000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 
		/*if(!func._isEnabled(getElement(getAccountNumber)))
		{
			CustomReporting.logReport("","","AccountNumber text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," AccountNumber text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}*/
		
		if(!func._isEnabled(getElement(txt_InsuredName)))
		{
			CustomReporting.logReport("","","InsuredName text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," InsuredName text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(txt_FEIN)))
		{
			CustomReporting.logReport("","","FEIN text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," FEIN text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		
		if(!func._isEnabled(getElement(txt_MailingAddress)))
		{
			CustomReporting.logReport("","","MailingAddress text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," MailingAddress text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(txt_MailingCity)))
		{
			CustomReporting.logReport("","","MailingCity text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," MailingCity text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(lst_MailingState)))
		{
			CustomReporting.logReport("","","MailingState List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," MailingState List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(lst_MailingCountry)))
		{
			CustomReporting.logReport("","","MailingCountry List box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," MailingCountry List box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(txt_MailingZipCode)))
		{
			CustomReporting.logReport("","","MailingZipCode text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," MailingZipCode text box is not displayed as disabled after search the Policy as a BillBilling/PM ing user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(txt_ZipAddOn)))
		{
			CustomReporting.logReport("","","ZipAddOn text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," ZipAddOn text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(txt_ZipAddOn)))
		{
			CustomReporting.logReport("","","ZipAddOn text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," ZipAddOn text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		if(!func._isEnabled(getElement(chk_OfacBlocked)))
		{
			CustomReporting.logReport("","","OFACBlocked check box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," OFACBlocked check box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}
		/*if(!func._isEnabled(getElement(txt_AccompanyingAccount)))
		{
			CustomReporting.logReport("","","AccompanyingAccount text box is displayed as disabled after search the Policy as a Billing/PM  user" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", ""," AccompanyingAccount text box is not displayed as disabled after search the Policy as a Billing/PM  user","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		}*/
		
	}
	
public void verify_OwnershipType_FieldDetails (String tcID, SoftAssert softAssert) throws Exception{
		
		PageData dataAccount = PageDataManager.instance().getPageData("Account",tcID);

		func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(4000);
		/*_click(getElement(btn_NewAccount));
		func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(4000);*/
	
		 Long startTime = System.currentTimeMillis();
		if((!func._isVisible(getElement(lbl_OwnershipType))) && (func._isVisible(getElement(lst_OwnershipType))))
		{
			CustomReporting.logReport("","","'Ownership Type' field is  present and it is optional" ,StepStatus.SUCCESS,new String[] { },startTime);
		}
		else
		{
			CustomReporting.logReport("","", "Ownership Type' field is not present","", StepStatus.FAILURE,new String[] {  }, startTime, null);
			//throw new RuntimeException();
		}
		if(func._isVisible(getElement(lbl_DisplayOrder_OwnershipType)))
		{
			CustomReporting.logReport("","","'Ownership Type' field is present above 'No of Employees' field" ,StepStatus.SUCCESS,new String[] { },startTime);
		}
		else
		{
			CustomReporting.logReport("","", "Ownership Type' field is not present above 'No of Employees' field","", StepStatus.FAILURE,new String[] {  }, startTime, null);
			//throw new RuntimeException();
		}
		List<String> OwnerShipData = func._getDataAsList(tcID, "Account", "VerifyOwnerShipValues", softAssert);
		if(func._validateDropdownValues(getElement(lst_OwnershipType), OwnerShipData, false, true, softAssert))
		{
			CustomReporting.logReport("","","''Ownership Type' list vlues are displaying as following order in dropdown: \r\n" + 
					"1.Private\r\n" + 
					"2.Public\r\n" + 
					"3.Not for Profit" ,StepStatus.SUCCESS,new String[] { },startTime);
		}
		else
		{
			CustomReporting.logReport("","", "Ownership Type' field values are not displaying as following order in dropdown \r\n"+
					"1.Private\r\n" + 
					"2.Public\r\n" + 
					"3.Not for Profit","", StepStatus.FAILURE,new String[] {  }, startTime, null);
			//throw new RuntimeException();
		}
		
		
	}
@Override
public void verify_AccountCustomaerDetails_DB(String tcID, SoftAssert softAs) throws Exception {
	Thread.sleep(2000);
	PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
	String environment = dataLogin.getData("Environment");
	System.out.println("environment "+environment);

	
	
	/***Account Data Validation***/
	//Account UI Data
	Map<String, String> accountUIDataMap = new LinkedHashMap<>();
	PageData dataAccount = PageDataManager.instance().getPageData("Account",tcID);
	String createdAccountID = dataAccount.getData("AccountNumber");
	accountUIDataMap.put("AccountNumber", createdAccountID.split("-")[0]);
	accountUIDataMap.put("AccountVersionNumber", createdAccountID.split("-")[1]);
	accountUIDataMap.put("InsuredName", dataAccount.getData("InsuredName"));
	accountUIDataMap.put("FEIN", dataAccount.getData("FEIN"));
	accountUIDataMap.put("MailingAddress", dataAccount.getData("MailingAddress"));
	accountUIDataMap.put("MailingCity", dataAccount.getData("MailingCity"));
	accountUIDataMap.put("MailingState", dataAccount.getData("MailingState"));
	accountUIDataMap.put("MailingCountry", dataAccount.getData("MailingCountry"));
	accountUIDataMap.put("MailingZipCode", dataAccount.getData("MailingZipCode"));
	Thread.sleep(2000);
	
	Map<String, String> accountDBDataMap = new LinkedHashMap<>();
	LinkedHashMap<Integer, String[]> accountDBDetails = 
			cFunc.getDataFromDB("select Account_Nbr,Account_Version_Nbr, Full_Insured_Name, FEIN, Mailing_Street_Address, Mailing_City_Name, StateKey,CountryKey, ZIP_Cd, CustomerID from [EscapeDB].[dbo].[SUB_Account] where "
					+ "Account_Nbr="+(createdAccountID.split("-")[0])+" and Account_Version_Nbr="+(createdAccountID.split("-")[1]), 
					10, "EscapeDB", "enicdb-stage");
	String[] accountDBData = accountDBDetails.get(0);
	accountDBDataMap.put("AccountNumber", accountDBData[0].toString());
	accountDBDataMap.put("AccountVersionNumber", accountDBData[1].toString());
	accountDBDataMap.put("InsuredName", accountDBData[2].toString());
	accountDBDataMap.put("FEIN", accountDBData[3].toString());
	accountDBDataMap.put("MailingAddress", accountDBData[4].toString());
	accountDBDataMap.put("MailingCity", accountDBData[5].toString());
	
	LinkedHashMap<Integer, String[]> stateNameDetail = 
			cFunc.getDataFromDB("Select State_Province_Name From [SUB_State] where StateKey='"+accountDBData[6].toString()+"'", 
					1, "EscapeDB", "enicdb-stage");
	String[] stateNameData = stateNameDetail.get(0);
	accountDBDataMap.put("MailingState", stateNameData[0].toString());
	
	LinkedHashMap<Integer, String[]> countryNameDetail = 
			cFunc.getDataFromDB("Select Country_Name from [DimCountry] where CountryKey='"+accountDBData[7].toString()+"'", 
					1, "EscapeDB", "enicdb-stage");
	String[] countryNameData = countryNameDetail.get(0);
	accountDBDataMap.put("MailingCountry", countryNameData[0].toString());
	
	accountDBDataMap.put("MailingZipCode", accountDBData[8].toString());
	accountDBDataMap.put("CustomerID", accountDBData[9].toString());

	CustomReporting.logReport("==== ESCAPE Account UI validation against DB ==== ");
	
	for(String key : accountUIDataMap.keySet()) {
		String valueUI = accountUIDataMap.get(key);
		String valueDB = accountDBDataMap.get(key);
		
		if(valueUI!=null && valueDB!=null) {
			if(valueUI.equalsIgnoreCase(valueDB)) {
				CustomReporting.logReport("","", "Created Account Data for Key "+key+" the value "+valueUI+" is Available in DB","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
			}
			else {
				CustomReporting.logReport("","", "Created Account Data for Key "+key+" the value "+valueUI+" is NOT Available in DB","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
			}
		}
		else {
			CustomReporting.logReport("Created Account Data for Key "+key+" the UI value "+valueUI+" and DB Value "+valueDB);
		}
	}
	
	
	//Customer Data Validation
	String dbAccountCustomerID = accountDBDataMap.get("CustomerID");
	
	LinkedHashMap<Integer, String[]> customerDBDetails = 
			cFunc.getDataFromDB("select CustomerID from [CustomerHub].[dbo].[Customer] where customerID='"+dbAccountCustomerID+"'", 
					1, "CustomerHub", "enicdb-stage");
	String[] customerDBData = customerDBDetails.get(0);
	String dbCustomerID = customerDBData[0].toString();
	if(dbAccountCustomerID.equalsIgnoreCase(dbCustomerID)) {
		CustomReporting.logReport("","", "Created Account's  Customer Data "+dbAccountCustomerID+" for AccountNo "+createdAccountID+" is Available in DB","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
	}
	else {
		CustomReporting.logReport("","", "Created Account's  Customer Data "+dbAccountCustomerID+" for AccountNo "+createdAccountID+" is NOT Available in DB","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
	}
	
	//Account Data Error Log Validation
	LinkedHashMap<Integer, String[]> errorLogCustomerDBDetails = 
			cFunc.getDataFromDB("select CustomerID from [CustomerHub].[dbo].[CustomerEnrichment_ErrorLog] where customerID='"+dbAccountCustomerID+"'", 
					1, "CustomerHub", "enicdb-stage");
	String[] errorLogCustomerDBData = errorLogCustomerDBDetails.get(0);
	String dbErrorLogCustomerDB = customerDBData[0].toString();
	if(errorLogCustomerDBData==null) {
		CustomReporting.logReport("","", "Error Log for Created Account's  Customer Data "+dbAccountCustomerID+" for AccountNo "+createdAccountID+" is NOT Available in DB","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
	}
	else {
		CustomReporting.logReport("","", "Error Log for Created Account's  Customer Data "+dbAccountCustomerID+" for AccountNo "+createdAccountID+" is Available in DB","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
	}
}
@Override
public void verify_Account_InDWHDB(String tcID, SoftAssert softAs,String DBServer) throws Exception 
{
	 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
	 PageData dataAccount = PageDataManager.instance().getPageData("Account",tcID);
     LinkedHashMap<Integer, String[]>AccountDHWDBvalues =null;
     LinkedHashMap<Integer, String[]>StateValues =null;
     LinkedHashMap<Integer, String[]>CountryValues =null;         
     Map<String, String> newBusinessUIDataMap = new LinkedHashMap<>();
     Map<String, String> newBusinessAccountDBDataMap = new LinkedHashMap<>();
     String stateValue = null;
     String countryValue =null;
     Boolean isMatched =true;
   
     /***New Business Data Validation***/
		//New Business UI Data 
		String  accountNumber = dataAccount.getData("AccountNumber").split("-")[0];
		String accountVersionNumber=dataAccount.getData("AccountNumber").split("-")[1];
		String stateName= dataAccount.getData("MailingState");
		String countryName=dataAccount.getData("MailingCountry");
		newBusinessUIDataMap.put("AccountNumber", accountNumber);
		newBusinessUIDataMap.put("AccountVersionNumber", accountVersionNumber);
		newBusinessUIDataMap.put("InsuredName", dataAccount.getData("InsuredName"));
		newBusinessUIDataMap.put("MailingAddress", dataAccount.getData("MailingAddress"));
		newBusinessUIDataMap.put("MailingCity", dataAccount.getData("MailingCity"));
		newBusinessUIDataMap.put("MailingState", dataAccount.getData("MailingState"));
		newBusinessUIDataMap.put("MailingCountry", dataAccount.getData("MailingCountry"));
		newBusinessUIDataMap.put("MailingZipCode", dataAccount.getData("MailingZipCode"));
		newBusinessUIDataMap.put("ZipAddOn", dataAccount.getData("ZipAddOn"));
		newBusinessUIDataMap.put("FEIN", dataAccount.getData("FEIN"));
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
            	AccountDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [EscapeDB].[dbo].[SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 36, "EscapeDB","enicdb-dev\\enic_qa");	 
            } 
            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
            {
            	AccountDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [IRF_EscapeDB].[dbo].[SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 36, "IRF_EscapeDB", "ENDWSQLS");
            	StateValues=cFunc.getDataFromDB("SELECT StateKey,State_Province_Name FROM [IRF_EscapeDB].[dbo].[SUB_State] WHERE State_Province_Name ='"+stateName+"'", 2, "IRF_EscapeDB", "ENDWSQLS");
            	CountryValues=cFunc.getDataFromDB("SELECT CountryKey,Country_Name FROM [IRF_EscapeDB].[dbo].[SUB_Country] WHERE Country_Name ='"+countryName+"'", 2, "IRF_EscapeDB", "ENDWSQLS");
            }
            else
            {
            	AccountDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [EscapeDB].[dbo].[IRF_EscapeDB]  WHERE Account_Nbr ='"+accountNumber+"'", 36, "IRF_EscapeDB", "ENDWSQLS");
            	StateValues=cFunc.getDataFromDB("SELECT StateKey,State_Province_Name FROM [IRF_EscapeDB].[dbo].[SUB_State] WHERE State_Province_Name ='"+stateName+"'", 2, "IRF_EscapeDB", "ENDWSQLS");
            	CountryValues=cFunc.getDataFromDB("SELECT CountryKey,Country_Name FROM [IRF_EscapeDB].[dbo].[SUB_Country] WHERE Country_Name ='"+countryName+"'", 2, "IRF_EscapeDB", "ENDWSQLS");
             }
       }
            
            String[] AccountStageDHWDBvalues1;
            AccountStageDHWDBvalues1=AccountDHWDBvalues.get(0);
            stateValue = StateValues.get(0)[1];
            countryValue = CountryValues.get(0)[1];
            newBusinessAccountDBDataMap.put("AccountNumber", AccountStageDHWDBvalues1[1]);
            newBusinessAccountDBDataMap.put("AccountVersionNumber", AccountStageDHWDBvalues1[2]);
    		newBusinessAccountDBDataMap.put("InsuredName", AccountStageDHWDBvalues1[3]);		
    		newBusinessAccountDBDataMap.put("MailingAddress", AccountStageDHWDBvalues1[4]);
    		newBusinessAccountDBDataMap.put("MailingCity", AccountStageDHWDBvalues1[5]);
    		newBusinessAccountDBDataMap.put("MailingState", stateValue);
    	    newBusinessAccountDBDataMap.put("MailingCountry", countryValue);
    		newBusinessAccountDBDataMap.put("MailingZipCode", AccountStageDHWDBvalues1[7]);
    		newBusinessAccountDBDataMap.put("ZipAddOn", AccountStageDHWDBvalues1[8]);
    		newBusinessAccountDBDataMap.put("FEIN", AccountStageDHWDBvalues1[21]);
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
  }
@Override
public void verify_OnlyAccount_InBothDB(String tcID, SoftAssert softAs, String DBServer) throws Exception {
	 PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
	 PageData dataAccount = PageDataManager.instance().getPageData("Account",tcID);
     LinkedHashMap<Integer, String[]>AccountDBvalues =null;
     LinkedHashMap<Integer, String[]> CustomerDHWDBvalues =null;
     Map<String, String> dataAccountUIDataMap = new LinkedHashMap<>();
     Map<String, String> dataAccountDBDataMap = new LinkedHashMap<>();
     Boolean isMatched =true;
     String customerID = null ;
     String[] AccountStageDHWDBvalues1;
     String  accountNumber = null;
     
     if(!dataAccount.getData("Sys_tcID").equals(""))
		{
			dataAccount = PageDataManager.instance().getPageData("Account",dataAccount.getData("Sys_tcID"));	
		}
     else {
    	 dataAccount = PageDataManager.instance().getPageData("Account",tcID);
     }
     accountNumber = dataAccount.getData("AccountNumber").split("-")[0];
     dataAccountUIDataMap.put("AccountNumber", accountNumber);
     
     try
     {
       if(DBServer.equalsIgnoreCase("EscapeDB"))
       {
    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
            {
    		   AccountDBvalues =cFunc.getDataFromDB("SELECT Account_Nbr,CustomerID,NoOfEmployee,Revenue,FEIN  FROM [EscapeDB].[dbo].[SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 5, "EscapeDB","enicdb-dev\\enic_qa");	 
            } 
            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
            {
            	AccountDBvalues =cFunc.getDataFromDB("SELECT Account_Nbr,CustomerID,NoOfEmployee,Revenue,FEIN  FROM [EscapeDB_SIT].[dbo].[SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 5, "EscapeDB_SIT","ENICDB-STAGE");
            	
            }
            else
            {
            	AccountDBvalues =cFunc.getDataFromDB("SELECT Account_Nbr,CustomerID,NoOfEmployee,Revenue,FEIN  FROM [EscapeDB].[dbo].[SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 5, "EscapeDB","ENICDB-STAGE");
            }
       }
       if(DBServer.equalsIgnoreCase("DWH"))
       {
    	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
            {
    		   AccountDBvalues =cFunc.getDataFromDB("SELECT Account_Nbr,CustomerID,NoOfEmployee,Revenue,FEIN  FROM [IRF_EscapeDB].[dbo].[HST_SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 5, "IRF_EscapeDB","ENDWSQLS2");	 
            } 
            else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
            {
            	AccountDBvalues =cFunc.getDataFromDB("SELECT Account_Nbr,CustomerID,NoOfEmployee,Revenue,FEIN  FROM [IRF_EscapeDB].[dbo].[HST_SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 5, "IRF_EscapeDB", "ENDWSQLS");
            }
            else
            {
            	AccountDBvalues =cFunc.getDataFromDB("SELECT Account_Nbr,CustomerID,NoOfEmployee,Revenue,FEIN  FROM [IRF_EscapeDB].[dbo].[HST_SUB_Account]  WHERE Account_Nbr ='"+accountNumber+"'", 5, "IRF_EscapeDB", "ENDWSQLS");
            }
       }
       
       AccountStageDHWDBvalues1=AccountDBvalues.get(0);
      dataAccountDBDataMap.put("AccountNumber", AccountStageDHWDBvalues1[0]);
      dataAccountDBDataMap.put("CustomerID", AccountStageDHWDBvalues1[1]);
      customerID = dataAccountDBDataMap.get("CustomerID");
      dataAccountDBDataMap.put("NoOfEmployee", AccountStageDHWDBvalues1[2]);
      dataAccountDBDataMap.put("Revenue", AccountStageDHWDBvalues1[3]);
      dataAccountDBDataMap.put("FEIN", AccountStageDHWDBvalues1[4]);
      
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
            	CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [CustomerHub].[dbo].[Customer]  WHERE customerID ='"+customerID+"'", 10, "CustomerHub","enicdb-dev\\enic_qa");	 
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
     
     try
     {
            if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
            {
            	CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [CustomerHub].[dbo].[CustomerEnrichment_ErrorLog]   WHERE customerID ='"+customerID+"'", 10, "CustomerHub","enicdb-dev\\enic_qa");	 
             }
            else
            {
            	CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT * FROM [CustomerHub].[dbo].[CustomerEnrichment_ErrorLog]   WHERE customerID ='"+customerID+"'", 10, "CustomerHub","ENICDB-STAGE");
                   
             }
          
            
             int totalRecord=CustomerDHWDBvalues.size();
             	if(totalRecord==0)
                   {
                          CustomReporting.logReport("","", "In [CustomerHub].[dbo].[CustomerEnrichment_ErrorLog] table, new row is not added for the above created Customer ID '"+customerID,StepStatus.REPORT,new String[] { },System.currentTimeMillis());     
                          
                   }
                   else
                   {
                          CustomReporting.logReport("","", "In [CustomerHub].[dbo].[CustomerEnrichment_ErrorLog] table, new row is added for the above created Customer ID '"+customerID,"", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
                          //throw new RuntimeException();
                   }
           
      }
      catch(Exception e)
      {   
    	  CustomReporting.logReport("","", "In [CustomerHub].[dbo].[CustomerEnrichment_ErrorLog] table, new row is added for the above created Customer ID '"+customerID,"", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
            	 
      }
     
     
}
@Override
public void verify_Customer_DnB_EIN_InDB(String tcID, SoftAssert softAs, String DBServer) throws Exception {
	PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
	PageData dataAccount = PageDataManager.instance().getPageData("Account",tcID);
    LinkedHashMap<Integer, String[]>DnB_EINDBvalues =null;
    LinkedHashMap<Integer, String[]> CustomerDHWDBvalues =null;
    LinkedHashMap<Integer, String[]> InstancedataDBvalues =null;
    
    Map<String, String> dataAccountUIDataMap = new LinkedHashMap<>();
    Map<String, String> dataCustomerDBDataMap = new LinkedHashMap<>();
    
    Boolean isMatched =true;
    String[] CustomerStageDHWDBvalues1;
    String CustomerId = null;
    
    
    String addr1 =  dataAccount.getData("MailingAddress");
    dataAccountUIDataMap.put("Address1",addr1);
    
    try
    {
      if(DBServer.equalsIgnoreCase("EscapeDB"))
      {
   	   if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
           {
   		   		CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT customerID, addressLine1 FROM [CustomerHub].[dbo].[Customer] WHERE addressLine1='"+addr1+"'", 2, "EscapeDB","enicdb-dev\\enic_qa");	 
           } 
           else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
           {
        	   CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT customerID, addressLine1 FROM [CustomerHub].[dbo].[Customer] WHERE addressLine1='"+addr1+"'", 2, "EscapeDB_SIT","ENICDB-STAGE");
           	
           }
           else
           {
        	   CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT customerID, addressLine1 FROM [CustomerHub].[dbo].[Customer] WHERE addressLine1='"+addr1+"'", 2, "EscapeDB","ENICDB-STAGE");
           }
      }
      
      CustomerStageDHWDBvalues1=CustomerDHWDBvalues.get(0);
      dataCustomerDBDataMap.put("customerID", CustomerStageDHWDBvalues1[0]);
      dataCustomerDBDataMap.put("addressLine1", CustomerStageDHWDBvalues1[1]);
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
	 CustomReporting.logReport("","", "Customer created in stage env is not exist in the DWH DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
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
 		 InstancedataDBvalues = cFunc.getDataFromDB("select DISTINCT  dataSourceKey from CustomerHub.dbo.InstanceData where addressLine1='"+addr1+"' order by dataSourceKey", 1, "CustomerHub", "enicdb-dev\\enic_qa");
         } 
         else if(dataLogin.getData("Environment").equalsIgnoreCase("SIT"))
         {
        	 DnB_EINDBvalues =cFunc.getDataFromDB(query, 1, "EscapeDB_SIT","ENICDB-STAGE");
        	 InstancedataDBvalues =cFunc.getDataFromDB("select DISTINCT  dataSourceKey from CustomerHub.dbo.InstanceData where addressLine1='"+addr1+"' order by dataSourceKey", 1, "EscapeDB_SIT","ENICDB-STAGE");	
         }
         else
         {
        	 DnB_EINDBvalues =cFunc.getDataFromDB(query, 1, "CustomerHub","ENICDB-STAGE");
        	 InstancedataDBvalues =cFunc.getDataFromDB("select DISTINCT  dataSourceKey from CustomerHub.dbo.InstanceData where addressLine1='"+addr1+"' order by dataSourceKey", 1, "CustomerHub","ENICDB-STAGE");
         }
    }
   //LinkedHashMap<Integer, String[]>newList = removeDuplicates(DnB_EINDBvalues); 

    dataSrcKey1 = DnB_EINDBvalues.get(0)[0];
    dataSrcKey2 = DnB_EINDBvalues.get(1)[0];
    dataSrcKey3 = DnB_EINDBvalues.get(2)[0];
    
    InsSrcKey1 = InstancedataDBvalues.get(0)[0];
    InsSrcKey2 = InstancedataDBvalues.get(1)[0];
    InsSrcKey3 = InstancedataDBvalues.get(2)[0];
    if(dataSrcKey1.trim().equals(InsSrcKey1) && dataSrcKey2.trim().equals(InsSrcKey2) && dataSrcKey3.trim().equals(InsSrcKey3))
    {
    	CustomReporting.logReport("","", " 'D&B', 'Escape', 'EIN' records are created along with timestamp",StepStatus.REPORT,new String[] { },System.currentTimeMillis());     
        
    }
    else
    {
           CustomReporting.logReport("","", " 'D&B', 'Escape', 'EIN' records are not created along with timestamp","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
           //throw new RuntimeException();
    }
 	   
    }
    catch(Exception ex) {
    	 CustomReporting.logReport("","", "Customer enrich created data in stage env is not exist in the DWH DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
    	    
    }
 	   
    
    
    
    
}
@Override
public void verify_Revenue_NOEmp_FEINFeilds_Account(String tcID, SoftAssert softAS, String DeviceName)
		throws Exception {
	PageData dataAccount = PageDataManager.instance().getPageData("Account",tcID);
	Thread.sleep(2000);
	if(func._isVisible(getElement(txt_FEIN)) && func._isVisible(getElement(txt_NoOfEmp_Diabled)) && func._isVisible(getElement(txt_Revenue_Diabled)))
    {
    	CustomReporting.logReport("","","'FEIN', 'NoOfEmployess' and 'Revenue' fields are populated in Account screen" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
    	CustomReporting.logReport("","","'NoOfEmployess' and 'Revenue' fields are greyed out and overwritten from the enriched data in Account screen" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
	 }
	 else
	 {
		 CustomReporting.logReport("","", "'FEIN', 'NoOfEmployess' and 'Revenue' fields are not populated in Account screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
		 CustomReporting.logReport("","", "'NoOfEmployess' and 'Revenue' fields are not greyed out and not overwritten from the enriched datain Account screen","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
		 throw new RuntimeException();
	 }
	
}
@Override
public void verify_CustomerID_AddiInsuredName_InDB(String tcID, SoftAssert softAs, String DBServer) throws Exception {
	PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
	PageData dataSearch = PageDataManager.instance().getPageData("Search",tcID);
    LinkedHashMap<Integer, String[]> CustomerDHWDBvalues =null;
    String[] CustomerStageDHWDBvalues1;
    
    String InsuredName = dataSearch.getData("InsuredName");
    
    try
    {
           if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
           {
           	CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT CustomerID,Insured_Name FROM [EscapeDB].[dbo].[SUB_Account] WHERE Insured_Name ='"+InsuredName+"'", 2, "EscapeDB","enicdb-dev\\enic_qa");	 
            }
           else
           {
           	CustomerDHWDBvalues =cFunc.getDataFromDB("SELECT CustomerID,Insured_Name FROM [EscapeDB].[dbo].[SUB_Account] WHERE Insured_Name ='"+InsuredName+"'", 2, "EscapeDB","ENICDB-STAGE");
                  
            }
            CustomerStageDHWDBvalues1=CustomerDHWDBvalues.get(0);
            	if(CustomerStageDHWDBvalues1[1].trim().equals(""))
                  {
                         CustomReporting.logReport("","", "new customer ID is not created for the additional insured names in DB",StepStatus.REPORT,new String[] { },System.currentTimeMillis());     
                         
                  }
                  else
                  {
                         CustomReporting.logReport("","", "new customer ID is created for the additional insured names in DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
                         //throw new RuntimeException();
                  }
          
     }
     catch(Exception e)
     {   
    	 CustomReporting.logReport("","", "Customer created in stage env is not exist in the DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
           	 
     }
    
	
}

@Override
public void verify_PDNew_LOB_InDB(String tcID, SoftAssert softAs, String DBServer) throws Exception {
	PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
	PageData dataSubmission = PageDataManager.instance().getPageData("NewSubmission",tcID);
    LinkedHashMap<Integer, String[]> LOBSublineDBvalues =null;
    
    Map<String, String> dataSubmissiontUIDataMap = new LinkedHashMap<>();
    Map<String, String> dataLOBDBMap = new LinkedHashMap<>();
    Boolean isMatched =true;
    String[] SublineLOBDBvalues1;
    
    String LOB = dataSubmission.getData("SubmissionLOB");
    dataSubmissiontUIDataMap.put("SubmissionLOB", LOB);
    
    try
    {
           if(dataLogin.getData("Environment").equalsIgnoreCase("QA"))
           {
        	   LOBSublineDBvalues =cFunc.getDataFromDB("select * from [EscapeDB].[dbo].[SUB_PD_LobSubline_Map] where LobSubline_Desc ='"+LOB+"'", 2, "EscapeDB","enicdb-dev\\enic_qa");	 
            }
           else
           {
        	   LOBSublineDBvalues =cFunc.getDataFromDB("select * from [EscapeDB].[dbo].[SUB_PD_LobSubline_Map] where LobSubline_Desc ='"+LOB+"'", 2, "EscapeDB","ENICDB-STAGE");
                  
            }
           
           SublineLOBDBvalues1 = LOBSublineDBvalues.get(0); 
           dataLOBDBMap.put("LobSubline_Desc", SublineLOBDBvalues1[0]);
           dataLOBDBMap.put("PDLob", SublineLOBDBvalues1[1]);
           
           for(String key : dataSubmissiontUIDataMap.keySet())
   		{
   			String valueUI = dataSubmissiontUIDataMap.get(key);
   			String valueDB = dataLOBDBMap.get(key);
   			
   			if(valueUI!=null && valueDB!=null)
   			{
   				if(!(valueUI.equalsIgnoreCase(valueDB)))
   				{

   					isMatched=false;
   					CustomReporting.logReport("","", "Created LobSubline and PDLOB for DB Value "+valueDB+" are NOT Equal","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);	
   				}
   			}
   			else {
   				CustomReporting.logReport("Created LobSubline and PDLOB for DB Value "+valueDB);
   			}
   		}
   		if(isMatched)
   		{
   			CustomReporting.logReport("","", "All Escape LOB Details Matched","", StepStatus.SUCCESS,new String[] {  }, System.currentTimeMillis(), null);
   			
   		}
   	}
    catch(Exception ex) {
    	CustomReporting.logReport("","", "LOBs created in stage env is not exist in the DB","", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
        
    }
	
}


@SuppressWarnings("static-access")
@Override
public void verify_UMAccountDetails_InEscape(String tcID, SoftAssert softAssert) throws Exception {

	try {

		
		PageData dataAccount = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		
		PageData dataMarketSeg = PageDataManager.instance().getPageData("UmMarketSegment", tcID);
		PageData data = PageDataManager.instance().getPageData("SearchPolicy", tcID);
		String insuredName = data.getData("InsName");
		String mailingAddress = data.getData("Address1");
		String mailingCity = dataAccount.getData("City");
		String mailingZipCode = dataAccount.getData("ZipCode");
		String ownerShipType = data.getData("OwnershipType");

		_wait(2000);
		_click(getElement(lnk_AccountNum));
		func._waitForPageToLoad(getWebDriver(), 250L);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		func._checkAttributeValue(getElement(txt_InsuredName), "value", insuredName, softAssert);
		func._checkAttributeValue(getElement(txt_MailingAddress), "value", mailingAddress, softAssert);
		func._checkAttributeValue(getElement(txt_MailingCity), "value", mailingCity, softAssert);
		func._checkAttributeValue(getElement(txt_MailingZipCode), "value", mailingZipCode, softAssert);
		func._checkAttributeValue(getElement(lst_OwnershipType), "TEXT", ownerShipType, softAssert);

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		CustomReporting.instance().logReport("Sucessfully Verified Account Details in Escape");

	} catch (Exception ex) {
		throw ex;
	}
}

@Override
public void verify_AccountReAssignment (String tcID, SoftAssert softAssert,String ActionType) throws Exception
{
	PageData dataUmLogin=null;
	String strInsName="";
	if(ActionType.equalsIgnoreCase("New"))
	{
	 dataUmLogin = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
	 strInsName=dataUmLogin.getData("Sys_Generate_InsureName");
	}
	else
	{
		 dataUmLogin = PageDataManager.instance().getPageData("Edit_UMSubmissionDetails", tcID);
		 strInsName=dataUmLogin.getData("TempInsuredName");
	}
	func._waitFor(getElement(tab_Account), 200L, WAIT_FOR.CLICKABLE, "");
	Thread.sleep(4000);
	_click(getElement(tab_Account));
	Thread.sleep(4000);
	func._waitFor(getElement(tab_Account), 200L, WAIT_FOR.CLICKABLE, "");
	WebElement weInsName=(WebElement)getElement(txt_InsuredName).getNative();
	String insName=weInsName.getAttribute("value");
	
	if(strInsName.equalsIgnoreCase(insName))
	{
		CustomReporting.logReport("","","Submission is assigned  to the account that the 'expiring policy' belongs to" + 
				"" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		
	}
	else
	{
		
		CustomReporting.logReport("", "","Submission is not assigned to the account that the 'expiring policy' belongs to","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
	
	}
	
	
	
}

	

}
