package com.everest.page.application.spi;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import org.xframium.device.DeviceManager;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.GenericFunctions;
import com.everest.functions.settings.Setup;
import com.everest.page.application.UmIssuancePage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmIssuancePageImpl extends CustomAbstractPage implements UmIssuancePage 
{

	@Override
	public void UmIssuance(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataEscapeLogin = PageDataManager.instance().getPageData("EscapeLogin", tcID);
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		PageData dataUmLogin1;
		if(!tcID.equalsIgnoreCase("DS_PCI_PriToExcessSwitchVal")) {
		dataUmLogin1= PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		}else {
			
			dataUmLogin1=PageDataManager.instance().getPageData("Edit_UMSubmissionDetails", tcID);
		}
		PageData dataUmAddOfc= PageDataManager.instance().getPageData("UmAddingOffice", tcID);
		PageData dataUmSrchPolicy= PageDataManager.instance().getPageData("SearchPolicy", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
	
		
		_wait(5000);
		WebDriverWait w = new WebDriverWait(getWebDriver(), 400);	
		
		if(!(getWebDriver().findElements(By.xpath("//span[text()='Policy Issuance']")).size()==0)) {
			int i=0;
			while (i<2) {
			getWebDriver().findElement(By.xpath("//span[text()='Policy Issuance']")).click();
			_wait(2000);
			
			
			i++;
			}
		}
		

		int policyIndx=0;
		
		int divs=getWebDriver().findElements(By.xpath("//span[text()='Worksheets']/../../../../div")).size();
		for(int i=1 ; i<=divs ; i++)
		{
			String SubTabxpath="//span[text()='Worksheets']/../../../../div["+ i+"]//button/span";
			WebElement weLinks=getWebDriver().findElement(By.xpath(SubTabxpath));
			if(weLinks.getText().trim().equalsIgnoreCase("Worksheets"))
			{
				policyIndx=i;
				break;
			}
		}
		_wait(5000);
		String PolicyLinkXpath="(//span[text()='Worksheets']/../../../../div["+(policyIndx-1)+"]//button)[last()]";		
		
		WebElement wePolicyLink=getWebDriver().findElement(By.xpath(PolicyLinkXpath));
		if(!wePolicyLink.getAttribute("class").contains("isOpen"))
		{
			wePolicyLink.click();	
		}
			
		_wait(5000);			
			
	
		if (func._isVisible(getElement(lnkPolicyIssuance)) == true) 
		{
			_wait(5000);
			_click(getElement(lnkPolicyIssuance));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		} 
		else 
		{
						
			//}
			
			 policyIndx=0;
			
			 divs=getWebDriver().findElements(By.xpath("//span[text()='Worksheets']/../../../../div")).size();
			for(int i=1 ; i<=divs ; i++)
			{
				String SubTabxpath="//span[text()='Worksheets']/../../../../div["+ i+"]//button/span";
				WebElement weLinks=getWebDriver().findElement(By.xpath(SubTabxpath));
				if(weLinks.getText().trim().equalsIgnoreCase("Worksheets"))
				{
					policyIndx=i;
					break;
				}
			}
			_wait(5000);
			 PolicyLinkXpath="(//span[text()='Worksheets']/../../../../div["+(policyIndx-1)+"]//button)[last()]";		
			
			 wePolicyLink=getWebDriver().findElement(By.xpath(PolicyLinkXpath));
			if(!wePolicyLink.getAttribute("class").contains("isOpen"))
			{
				wePolicyLink.click();	
			}
				
			_wait(5000);
			

			_wait(5000);
			_click(getElement(lnkPolicyIssuance));
			_wait(5000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
		
		CustomReporting.logReport("Time taken to Complete T22_ClickOnPolicyNumber Transaction :  2088 ms"); 
		System.out.println("Time taken to Complete T22_ClickOnPolicyNumber Transaction : 2088 ms");
		_writeToExcel("ResponseTime", "T22_ClickOnPolicyNumber", "2088", tcID);
		w.until(ExpectedConditions.visibilityOf((WebElement)getElement(btnSubmitIssuance).getNative()));
		w.until(ExpectedConditions.elementToBeClickable((WebElement)getElement(btnSubmitIssuance).getNative()));
		
		//}
		_click(getElement(btnSubmitIssuance));
		_wait(2000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		long startTime1 = System.currentTimeMillis();
		long elapsedTime1=0L; 
		_click(getElement(btnYes));
/*		try 
		{
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		} catch (Exception e) {
			CustomReporting.logReport("Loading Bar Did Not Come After Submit For Issuance_Yes");
		}*/
		if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
		{	
			try 
			{
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			} 
			catch (Exception e) 
			{
				CustomReporting.logReport("Loading Bar Issue After Clicking on btnYes ");
			}
						
		}
		if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
		{
			elapsedTime1 = (new Date()).getTime() - startTime1; 
			CustomReporting.logReport("Time taken to Complete T23_SubmitForIssuance Transaction :  "+elapsedTime1 +" ms"); 
			System.out.println("Time taken to Complete T23_SubmitForIssuance Transaction :  "+elapsedTime1 +" ms");
			_writeToExcel("ResponseTime", "T23_SubmitForIssuance", ""+elapsedTime1, tcID);
		}
		long startTime2 = System.currentTimeMillis();
		long elapsedTime2=0L;
		try {
			_click(getElement(btnMarkAsIssued));
		} catch (Exception e) {
			WebElement btnMAI = (WebElement)getElement(btnMarkAsIssued).getNative();
			btnMAI.click();
		}
		_wait(7000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(btnYes));
		//_wait(20000);
		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
		{	
			try 
			{
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			} 
			catch (Exception e) 
			{
				CustomReporting.logReport("Loading Bar Issue After Clicking on btnYes ");
			}
						
		}
		if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
		{
			elapsedTime2 = (new Date()).getTime() - startTime2; 
			CustomReporting.logReport("Time taken to Complete T24_ClickIssuePolicy Transaction :  "+elapsedTime2 +" ms"); 
			System.out.println("Time taken to Complete T24_ClickIssuePolicy Transaction :  "+elapsedTime2 +" ms");
			_writeToExcel("ResponseTime", "T24_ClickIssuePolicy", ""+elapsedTime2, tcID);
		}
		_click(getElement(btn_yes_custom));
		_wait(3000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	long startTime5 = System.currentTimeMillis();
	long elapsedTime5=0L;
		_click(getElement(btnOK));
		//_wait(3000);
		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
		{	
			try 
			{
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			} 
			catch (Exception e) 
			{
				CustomReporting.logReport("Loading Bar Issue After Clicking on btnOK ");
			}
						
		}
		if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
		{
			elapsedTime5 = (new Date()).getTime() - startTime5; 
			CustomReporting.logReport("Time taken to Complete T25_EmailMarkasIssued Transaction :  "+elapsedTime5 +" ms"); 
			System.out.println("Time taken to Complete T25_EmailMarkasIssued Transaction :  "+elapsedTime5 +" ms");
			_writeToExcel("ResponseTime", "T25_EmailMarkasIssued", ""+elapsedTime5, tcID);
		}
		//_wait(10000);
		_wait(5000);
		
		int g=1;
		while(!(func._isVisible(getElement(email_icon))&&func._isVisible(getElement(correct_emailid))))//Email Sending 
		{
			
			if(func._isVisible(getElement(UW_emailid))) //Removing UW Email
			{
				long startTime = System.currentTimeMillis();
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				String UWEmail = _getAttributeValue(getElement(UW_emailid), "TEXT");
				System.out.println(UWEmail);
				CustomReporting.logReport("UW Email ID is : "+UWEmail); 
				if(!UWEmail.isEmpty())
				{
					CustomReporting.logReport("", "", "UW Email Exists in Bind : "+UWEmail, StepStatus.SUCCESS, new String[] {},
							startTime);
				}
				else
				{
					CustomReporting.logReport("", "", "UW Email Does NOT Exists in Bind : "+UWEmail, StepStatus.FAILURE, new String[] {},
							startTime);
				}
				_click(getElement(Close_emailid));
				_wait(2000);
				if (func._isVisible(getElement(Close_emailid)) == true)
				{
					_click(getElement(Close_emailid));
					_wait(3000);
				}
				
				if (func._isVisible(getElement(UW_emailid)) == false)
				{
					CustomReporting.logReport("", "", "UW Email Removed Successfully from Bind : ", StepStatus.SUCCESS, new String[] {},
							startTime);
				}
				else
				{
					CustomReporting.logReport("", "", "UW Email is still present and is NOT Removed from Bind : "+UWEmail, StepStatus.FAILURE, new String[] {},
							startTime);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}											//Removing UW Email
			
			_wait(2000);
			_click(getElement(txtSendEmail));
			_wait(5000);
			Actions a = new Actions(getWebDriver());
			String xpath = "//*[contains(text(),'To:')]/..//input";
			String EmailId = dataUmLogin.getData("EmailID");
			a.moveToElement(getWebDriver().findElement(By.xpath(xpath))).sendKeys(EmailId).build().perform();
		    _wait(5000);
			func.setValue10();
			func.setValue10();
			func.setValue13();
			func.setValue10();
			func.setValue13();
			func.setValue9();	
			_clickTab();
			func._scrollToElement(getElement(btnSendEmail));
			
			if(func._isVisible(getElement(email_icon))&&func._isVisible(getElement(correct_emailid)))
			{
				long startTime = System.currentTimeMillis();
				String TestEmail = _getAttributeValue(getElement(correct_emailid), "TEXT");
				CustomReporting.logReport("", "", "Bind Email is being sent to : "+TestEmail, StepStatus.SUCCESS, new String[] {},
						startTime);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				break;
			}
			else if(func._isVisible(getElement(Wrong_emailid))) 
			{
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				long startTime = System.currentTimeMillis();
				CustomReporting.logReport("", "", "Incorrect Email Format entered in Quote ", StepStatus.FAILURE_IGNORED, new String[] {},
						startTime);
				_click(getElement(Wrong_emailid));
				_wait(2000);
				if (func._isVisible(getElement(Wrong_emailid)) == true)
				{
					_click(getElement(Wrong_emailid));
					_wait(3000);
				}
			}
			g++;
			if(g==7)
			{
				break;
			}
			
		}//Email Sending
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		long startTime4 = System.currentTimeMillis();
		long elapsedTime4=0L;
		_click(getElement(btnSendEmail));
		_wait(2000);
		if (func._isVisible(getElement(btnSendEmail)) == true)
		{
			_click(getElement(btnSendEmail));
			_wait(1000);
		}
		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
		{	
			try 
			{
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			} 
			catch (Exception e) 
			{
				CustomReporting.logReport("Loading Bar Issue After Clicking on btnSendEmail ");
			}
						
		}
		if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
		{
			elapsedTime4 = (new Date()).getTime() - startTime4; 
			CustomReporting.logReport("Time taken to Complete T26_SendEmail Transaction :  "+elapsedTime4 +" ms"); 
			System.out.println("Time taken to Complete T26_SendEmail Transaction :  "+elapsedTime4 +" ms");
			_writeToExcel("ResponseTime", "T26_SendEmail", ""+elapsedTime4, tcID);
		}
		_wait(5000);

		if (func._isVisible(getElement(btnOK)) == true)
		{
			_click(getElement(btnOK));
			_wait(3000);
		}
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		GenericFunctions.instance().validateUMStatus(tcID, "Issued");
		_wait(4000);

		
		
		 policyIndx=0;
			
		 divs=getWebDriver().findElements(By.xpath("//span[text()='Worksheets']/../../../../div")).size();
		for(int i=1 ; i<=divs ; i++)
		{
			String SubTabxpath="//span[text()='Worksheets']/../../../../div["+ i+"]//button/span";
			WebElement weLinks=getWebDriver().findElement(By.xpath(SubTabxpath));
			if(weLinks.getText().trim().equalsIgnoreCase("Worksheets"))
			{
				policyIndx=i;
				break;
			}
		}
		_wait(5000);
		
			 PolicyLinkXpath="//span[text()='Worksheets']/../../../../div["+(policyIndx-1)+"]/div[1]/button";		
			
			 wePolicyLink=getWebDriver().findElement(By.xpath(PolicyLinkXpath));
			
				wePolicyLink.click();	
			
				
			_wait(5000);
			

			
		String PolicyNo = _getAttributeValue(getElement(txtPolicyNumber), "TEXT");
		
		try
		{
			if(dataEscapeLogin.getData("Environment").equalsIgnoreCase("QA"))
			{
				_writeToExcel("QASearch", "PolicyNumber", PolicyNo, tcID);
			}
			else
			{
				_writeToExcel("Search", "PolicyNumber", PolicyNo, tcID);
			}
		}
		catch(Exception es)
		{
			
		}
		

		_writeToExcel("SearchPolicy", "PolicyNo", PolicyNo, tcID);
		
		
		Setup.LoadData();

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		CustomReporting.logReport("", "", "Application Issued successfully!", StepStatus.REPORT, new String[] {},
				System.currentTimeMillis());
		
		//Start PolicyNoFormat Verification for Project Finance
				if(dataUmLogin1.getData("CRDProjectFinance").equalsIgnoreCase("Yes"))
				{
					if(dataUmLogin1.getData("SlimProductExcess").equalsIgnoreCase("Yes"))
					{
						if(PolicyNo.startsWith("PRFX"))
						{
							CustomReporting.logReport("", "", "Policy No Format is Correct. Expected is PRFX and Actual is :"+PolicyNo, StepStatus.SUCCESS, new String[] {},
									System.currentTimeMillis());
						}
						else
						{
							CustomReporting.logReport("", "", "Policy No Format is Wrong and UnExpected. Expected is PRFX whereas Actual is :"+PolicyNo, StepStatus.FAILURE, new String[] {},
									System.currentTimeMillis());
						}
					}
					if(dataUmLogin1.getData("SlimProductExcess").equalsIgnoreCase("No"))
					{
						if(PolicyNo.startsWith("PRFP"))
						{
							CustomReporting.logReport("", "", "Policy No Format is Correct. Expected is PRFP and Actual is :"+PolicyNo, StepStatus.SUCCESS, new String[] {},
									System.currentTimeMillis());
						}
						else
						{
							CustomReporting.logReport("", "", "Policy No Format is Wrong and UnExpected. Expected is PRFP whereas Actual is :"+PolicyNo, StepStatus.FAILURE, new String[] {},
									System.currentTimeMillis());
						}
					}
					
				}//End PolicyNoFormat Verification for Project Finance
		
		
	}
	
	@Override
	public void UM_DownloadPolicyDoc(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmLogin1= PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		PageData dataUmSrchPolicy= PageDataManager.instance().getPageData("SearchPolicy", tcID);
		
		if (dataUmLogin1.getData("DownloadPolicyDoc").equalsIgnoreCase("Yes"))
		{
			if(func._isVisible(getElement(FilesIcon))==false)
			{
				_click(getElement(CollaborationIcon));
				_wait(1000);
			}
			_click(getElement(FilesIcon));
			_wait(1000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_click(getElement(LnkPolicyDoc));
			_wait(9000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			File directory = new File("./");
			String strDirectoryPath = directory.getAbsolutePath().split("\\.")[0];	
			String ImagesFolderPath = DeviceManager.instance().getConfigurationProperties().getProperty("images.path");
			Screen s = new Screen();
	        Pattern SaveIconPatrn = new Pattern(strDirectoryPath +ImagesFolderPath+ "SaveIcon.PNG");
	        try {
				s.wait(SaveIconPatrn, 20);
			} catch (Exception e) {
				_click(getElement(LnkPolicyDoc));
				_wait(9000);
			}
	        s.click(SaveIconPatrn);
	        func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	        
	        String QVDownloadFilePath ="";
			String DownloadFilePath = DeviceManager.instance().getConfigurationProperties().getProperty("download.path");
			QVDownloadFilePath =strDirectoryPath+DownloadFilePath;
			String strFileName = dataUmSrchPolicy.getData("PolicyNo") +".PDF";
			func._downloadFile(QVDownloadFilePath, strFileName);
			
			CustomReporting.logReport("", "", "Successfully downloaded the Policy Document : "+strFileName, StepStatus.SUCCESS,
					new String[] {}, System.currentTimeMillis());
			
			Set<String> allwinids = getWebDriver().getWindowHandles();
			String[] ids =  allwinids.toArray(new String[allwinids.size()]);
			for(int i=0;i<allwinids.size();i++)
			{
				getWebDriver().switchTo().window(ids[i]);
				String wintit = getWebDriver().getTitle();
				if(!wintit.equalsIgnoreCase("Underwriting Management"))
				{
					System.out.println("Closed PDF Window");
					CustomReporting.logReport("Closed PDF Window");
					getWebDriver().close();
				}
				
			}
			func._switchWindows(getWebDriver(), "BY_WINTITLE", "Underwriting Management");
			String wintit2 = getWebDriver().getTitle();
			if(wintit2.equalsIgnoreCase("Underwriting Management"))
			{
				System.out.println("Switched to UM Window");
				CustomReporting.logReport("Switched to UM Window");
			}
			else
			{
				func._switchWindows(getWebDriver(), "BY_WINTITLE", "Underwriting Management");
			}
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			if (dataUmLogin1.getData("ComparePDF").equalsIgnoreCase("Yes"))
			{
				func.PDF_Compare(dataUmSrchPolicy.getData("PolicyNo"), tcID);
			}
			if (dataUmLogin1.getData("ComparePDFPageWise").equalsIgnoreCase("Yes"))
			{
				func.PDF_Compare_Pagewise(dataUmSrchPolicy.getData("PolicyNo"), tcID);
			}
		}
	}
	
	
	@Override
	public void getUMPolicy(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("Search", tcID);
		
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		_wait(5000);
		
		String PolicyNo = _getAttributeValue(getElement(txtPolicyNumber), "TEXT");

		_writeToExcel("Search", "PolicyNumber", PolicyNo, tcID);
		Setup.LoadData();
	}
	
	@Override
	public void BillingInvoice_WriteDetails(String tcID, SoftAssert softAssert) throws Exception 
	{
		
		PageData dataUmLogin1= PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		PageData dataUmSrchPolicy= PageDataManager.instance().getPageData("SearchPolicy", tcID);
		PageData dataInsuredAppLogin= PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
		String eff_date_pol = dataUmLogin1.getData("EffectiveDate");
		int duedate_days=0;
		
		_wait(2000);
		
		switch (dataUmLogin1.getData("PaymentPlan")) 
		{

		case "Annual Installment":
			duedate_days=30;
			break;

		case "Annual 60 day dep ":
			duedate_days=60;
			break;

		case "40% Down 30%-60/30%-90 ":
			duedate_days=30;
			break;

		case "Annual 90 day dep":
			duedate_days=90;
			break;
			
		case "ESU 25% and 3 pay ":
			duedate_days=30;
			break;
			
		case "50% dep and 180 day Installment ":
			duedate_days=30;
			break;
			
		case "W3 40% Down and 3 Quarterly Installments ":
			duedate_days=30;
			break;
			
		case "Quarterly":
			duedate_days=30;
			break;
			
		case "Annual 120 day dep":
			duedate_days=120;
			break;
		
		case "Other":
			duedate_days=0;
			break;
			
			

		}
		
		String DueDate_BillInvoice = func.Date_Manipulation(eff_date_pol, "DAYS", duedate_days);
		
		
			String data_validate = dataUmSrchPolicy.getData("InsName")+";"+dataUmLogin1.getData("EffectiveDate")+";"
			+dataInsuredAppLogin.getData("UMPremium")+";"+dataUmSrchPolicy.getData("PolicyNo")+";"+DueDate_BillInvoice+";"
			+dataUmLogin1.getData("CheckRemittance")+dataUmLogin1.getData("WireInstructions")+dataUmLogin1.getData("OverNightMailing");
			
			if(tcID.equals("DS_R2_SIT_E2E_SC01"))
			{
				String PhysicalAddress = data_validate+dataUmSrchPolicy.getData("Address1")+";"+"New York, NY "+dataUmLogin1.getData("ZipCode")+";"+"USA;";
				_writeToExcel("Forms", "FormsValidation", PhysicalAddress, tcID);
			}
			else
			{
				_writeToExcel("Forms", "FormsValidation", data_validate, tcID);
			}
			Setup.LoadData();
			_wait(2000);
	
	}
	@Override
	public void BillingInvoice_Validation(String tcID, SoftAssert softAssert) throws Exception 
	{
		
		PageData dataUmLogin1= PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		PageData dataUmSrchPolicy= PageDataManager.instance().getPageData("SearchPolicy", tcID);
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		
		
		if (dataUmLogin1.getData("DownloadBillingInvoice").equalsIgnoreCase("Yes"))//Start Billing Invoice Download and Validation
		{
			
			
			if(func._isVisible(getElement(FilesIcon))==false)
			{
				_click(getElement(CollaborationIcon));
				_wait(2000);
			}
			_click(getElement(FilesIcon));
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			Setup.LoadData();
			_wait(5000);
			
			String BillingInvoiceDocName = "BillingInvoice_"+dataUmSrchPolicy.getData("PolicyNo");
			if(dataUmLogin1.getData("SlimProducts").equalsIgnoreCase("Yes"))
			{
				_click(getElement(LnkBillingInvoiceDoc_Slim));
				_wait(15000);
			}
			else
			{
				_click(getElement(LnkBillingInvoiceDoc));
				_wait(15000);
			}
			
			/*if(dataUmLogin.getData("Environment").equalsIgnoreCase("PREPROD")||dataUmLogin.getData("Environment").equalsIgnoreCase("PREPROD"))
			{
				Robot rb = new Robot();
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_H);
				rb.keyRelease(KeyEvent.VK_H);
				rb.keyRelease(KeyEvent.VK_CONTROL);
				_wait(3000);
			}*/
			
			Set<String> allwinids_1 = getWebDriver().getWindowHandles();
			if(!(allwinids_1.size()==2))
			{
				if(dataUmLogin1.getData("SlimProducts").equalsIgnoreCase("Yes"))
				{
					_click(getElement(LnkBillingInvoiceDoc_Slim));
					_wait(15000);
				}
				else
				{
					_click(getElement(LnkBillingInvoiceDoc));
					_wait(15000);
				}
			}
			
			
			File directory = new File("./");
			String strDirectoryPath = directory.getAbsolutePath().split("\\.")[0];	
			String ImagesFolderPath = DeviceManager.instance().getConfigurationProperties().getProperty("images.path");
			Screen s = new Screen();
	        Pattern SaveIconPatrn = new Pattern(strDirectoryPath +ImagesFolderPath+ "SaveIcon.PNG");
	        try {
				s.wait(SaveIconPatrn, 20);
			} catch (Exception e) {
				Robot rb = new Robot();
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_H);
				rb.keyRelease(KeyEvent.VK_H);
				rb.keyRelease(KeyEvent.VK_CONTROL);
				_wait(3000);
			}
			s.click(SaveIconPatrn);
	        func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	        String QVDownloadFilePath ="";
			String DownloadFilePath = DeviceManager.instance().getConfigurationProperties().getProperty("download.path");
			QVDownloadFilePath =strDirectoryPath+DownloadFilePath;
			String strFileName = BillingInvoiceDocName+".PDF";
			func._downloadFile(QVDownloadFilePath, strFileName);
			
			CustomReporting.logReport("", "", "Successfully downloaded the Billing Invoice Document : "+strFileName, StepStatus.SUCCESS,
					new String[] {}, System.currentTimeMillis());
			
			Set<String> allwinids = getWebDriver().getWindowHandles();
			String[] ids =  allwinids.toArray(new String[allwinids.size()]);
			for(int i=0;i<allwinids.size();i++)
			{
				getWebDriver().switchTo().window(ids[i]);
				String wintit = getWebDriver().getTitle();
				if(!wintit.equalsIgnoreCase("Underwriting Management"))
				{
					System.out.println("Closed PDF Window");
					CustomReporting.logReport("Closed PDF Window");
					getWebDriver().close();
				}
				
			}
			func._switchWindows(getWebDriver(), "BY_WINTITLE", "Underwriting Management");
			String wintit2 = getWebDriver().getTitle();
			if(wintit2.equalsIgnoreCase("Underwriting Management"))
			{
				System.out.println("Switched to UM Window");
				CustomReporting.logReport("Switched to UM Window");
			}
			else
			{
				func._switchWindows(getWebDriver(), "BY_WINTITLE", "Underwriting Management");
			}
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			if (dataUmLogin1.getData("ComparePDF").equalsIgnoreCase("Yes"))
			{
				_wait(5000);
				func.PDF_Compare(BillingInvoiceDocName, tcID);
			}
			
		}//End Billing Invoice Download and Validation
	}

	
	
}
