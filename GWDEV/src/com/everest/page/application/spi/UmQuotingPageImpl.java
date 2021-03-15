package com.everest.page.application.spi;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import com.everest.page.application.UmQuotingPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmQuotingPageImpl extends CustomAbstractPage implements UmQuotingPage {

	@Override
	public void UmQuoting(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		PageData dataUmSubDet = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		PageData dataUmSearchPolicy = PageDataManager.instance().getPageData("SearchPolicy", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		_wait(20000);
		long startTime10 = System.currentTimeMillis();
		long elapsedTime10 = 0L;
		WebDriverWait w = new WebDriverWait(getWebDriver(), 400);

		/*if (!(getWebDriver().findElements(By.xpath("//div[@class='buttonOverlay ng-scope']")).size() == 0)) 
		{

			_click(getElement(btnUpdateCoverages));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		}*/
		
		if(func._isVisible(getElement(btnUpdateCoverages)))
		{
			_click(getElement(btnUpdateCoverages));
			_wait(3000);
		}
		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
		{	
			try 
			{
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			} 
			catch (Exception e) 
			{
				CustomReporting.logReport("Loading Bar Issue After Clicking on btnUpdateCoverages ");
			}
						
		}
		_wait(3000);

		/*
		 * elapsedTime10 = (new Date()).getTime() - startTime10; CustomReporting.
		 * logReport("Time taken to Complete T05_Click on Update Coverages Transaction :  "
		 * +elapsedTime10 +" ms"); System.out.
		 * println("Time taken to Complete T05_Click on Update Coverages Transaction :  "
		 * +elapsedTime10 +" ms"); _writeToExcel("ResponseTime",
		 * "T05_Click on Update Coverages", ""+elapsedTime10, tcID);
		 */
		_wait(5000);

		_wait(5000);
		long startTime = System.currentTimeMillis();
		long elapsedTime=0L; 
		if (func._isVisible(getElement(btnGetRate)) == true) 
		{
			
			_click(getElement(btnGetRate));
			_wait(10000);
			//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
			{	
				try 
				{
					w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				} 
				catch (Exception e) 
				{
					CustomReporting.logReport("Loading Bar Issue After Clicking on btnGetRate ");
				}
							
			}
			if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
			{
				elapsedTime = (new Date()).getTime() - startTime; 
				CustomReporting.logReport("Time taken to Complete T06_Click Get Rate Transaction :  "+elapsedTime +" ms"); 
				System.out.println("Time taken to Complete T06_Click Get Rate Transaction :  "+elapsedTime +" ms");
				_writeToExcel("ResponseTime", "T06_Click Get Rate", ""+elapsedTime, tcID);
			}
		
		}
		
		if (func._isVisible(getElement(btnGetRate)) == true) 
		{
			
			_click(getElement(btnGetRate));
			_wait(10000);
			//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
			{	
				try 
				{
					w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				} 
				catch (Exception e) 
				{
					CustomReporting.logReport("Loading Bar Issue After Clicking on btnGetRate ");
				}
							
			}
			if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
			{
				elapsedTime = (new Date()).getTime() - startTime; 
				CustomReporting.logReport("Time taken to Complete T06_Click Get Rate Transaction :  "+elapsedTime +" ms"); 
				System.out.println("Time taken to Complete T06_Click Get Rate Transaction :  "+elapsedTime +" ms");
				_writeToExcel("ResponseTime", "T06_Click Get Rate", ""+elapsedTime, tcID);
			}
		
		}
		
		
		_wait(5000);
		if (func._isVisible(getElement(btnOK)) == true) 
		{
			_click(getElement(btnOK));
			//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
			{	
				try 
				{
					w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				} 
				catch (Exception e) 
				{
					CustomReporting.logReport("Loading Bar Issue After Clicking on btnOK ");
				}
							
			}
			//_wait(10000);
			_wait(5000);
		}
		//Non Rate Bearing Transaction : Start
		
		/*if (dataUmSubDet.getData("NonRateBearingTran").equalsIgnoreCase("Yes")) 
		{
			_click(getElement(lblSubmissionNo));
			_wait(5000);
			String timeStamp = (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())).replace(".", "");
			_setValue(getElement(txtStreet1), dataUmSubDet.getData("Street1_NonRateBearing") + "_" + timeStamp);
			func._waitForPageToLoad(getWebDriver(), 50L);
			
		}*/
		
		
		//Non Rate Bearing Transaction : End
		if(dataUmLogin.getData("CRIME").equalsIgnoreCase("Yes")) {
			verifyCRIPremium(tcID,softAssert);
		}
		if (dataUmLogin.getData("CyberCov").equalsIgnoreCase("Yes")) {
			if (func._isVisible(getElement(btnOK)) == true) {
				_click(getElement(btnOK));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(10000);
			}
			}
		
		
		//AMS Ticket EPRO76555 Start
				if (func._isVisible(getElement(Label_SelectedPolicyForms)) == false) 
				{
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "Screen shown after Clicking on Get Rate is same as it was before clicking on Get Rate as Per AMS Ticket EPRO76555" , StepStatus.SUCCESS, new String[] {},
							startTime);
				}
				else
				{
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "Screen shown after Clicking on Get Rate is different as it was before clicking on Get Rate as Per AMS Ticket EPRO76555", StepStatus.FAILURE, new String[] {},
							startTime);
				}
		//AMS Ticket EPRO76555 End
		
		if (dataUmLogin.getData("CyberCov").equalsIgnoreCase("Yes")) {
			if (func._isVisible(getElement(btnOK)) == true) {
				_click(getElement(btnOK));
				//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
				{	
					try 
					{
						w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
					} 
					catch (Exception e) 
					{
						CustomReporting.logReport("Loading Bar Issue After Clicking on btnOK ");
					}
								
				}
				_wait(10000);
			}
			}
		
		if (tcID.equalsIgnoreCase("DS_SIT_E2E_SC_05") || tcID.equalsIgnoreCase("DS_SIT_E2E_SC_12") || tcID.equalsIgnoreCase("DS_SIT_E2E_SC_13")) 
			{	
		_wait(5000);
		String optionalEnd = "//*[contains(text(),'Rating: Optional Endts')]";
		WebElement RatingoptionalEnd = getWebDriver().findElement(By.xpath(optionalEnd));
		RatingoptionalEnd.click();
		_wait(5000);
		
		String updateButton = "//*[contains(text(),'Update Forms List')]";
		WebElement BtnUpdateFormsList = getWebDriver().findElement(By.xpath(updateButton));
		BtnUpdateFormsList.click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		
		
		}
		func._waitForPageToLoad(getWebDriver(), 50L);
		long startTime1 = System.currentTimeMillis();
		long elapsedTime1=0L; 

		if (func._isVisible(getElement(btnConvertQuote)) == true) 
		{

			_click(getElement(btnConvertQuote));
			if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
			{	
			try {
				w.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			} catch (Exception e) {
				CustomReporting.logReport("Loading Bar Did Not Come After Clicking on btnConvertQuote");
			}
			}

		}
		if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
		{
			elapsedTime1 = (new Date()).getTime() - startTime1;
			CustomReporting.logReport("Time taken to Complete T07_Convert to Quote Transaction :  " + elapsedTime1 + " ms");
			System.out.println("Time taken to Complete T07_Convert to Quote Transaction :  " + elapsedTime1 + " ms");
			_writeToExcel("ResponseTime", "T07_Convert to Quote", "" + elapsedTime1, tcID);
		}

		if (func._isVisible(getElement(btnConvertQuote)) == true)
		{
			long startTime2 = System.currentTimeMillis();
			long elapsedTime2=0L;
			_click(getElement(btnConvertQuote));
			if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
			{	
			try {
				w.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			} catch (Exception e) {
				CustomReporting.logReport("Loading Bar Did Not Come After Clicking on btnConvertQuote");
			}
			}
			if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
			{
				elapsedTime2 = (new Date()).getTime() - startTime2; 
				CustomReporting.logReport("Time taken to Complete T07_Convert to Quote Transaction :  "+elapsedTime2 +" ms"); 
				System.out.println("Time taken to Complete T07_Convert to Quote Transaction :  "+elapsedTime2 +" ms");
				_writeToExcel("ResponseTime", "T07_Convert to Quote", ""+elapsedTime2, tcID);
			}
		}
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		//Start EPRO-77312
		if(dataUmLogin.getData("NonBindingEmail").equalsIgnoreCase("Yes"))
		{
			_click(getElement(Quoting_link));
			_wait(1000);
			_click(getElement(Indication_chkbx));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			WebElement we = (WebElement) getClonedElement(Indication_chkbx).getNative();
			if(we.isSelected())
			{
				CustomReporting.logReport("", "", "Release NonBinding Indication Selected", StepStatus.SUCCESS, new String[] {},
						startTime);
			}
			else
			{
				_click(getElement(Indication_chkbx));
				CustomReporting.logReport("", "", "Release NonBinding Indication Selected Again ", StepStatus.SUCCESS, new String[] {},
						startTime);
			}
			
		}
		//End EPRO-77312

		if(dataUmSubDet.getData("PolicyForms").equalsIgnoreCase("Yes"))
		{
			_click(getElement(btnPolicyForms));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
		
		if(dataUmSubDet.getData("ChangeCompany").equalsIgnoreCase("Yes"))
		{
			_click(getElement(Quoting_Link));
			_wait(3000);
			func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_click(getElement(WritingComp_Dropdown));
			_wait(1000);
			_click(getElement(Search_Field));
			_wait(1000);
			_setValue(getElement(Search_Field), dataUmSubDet.getData("CompanyToChange"));
			_wait(1000);
			_click(getClonedElement(Search_Result_WC).addToken("tkn_WritingCompanyName", dataUmSubDet.getData("CompanyToChange")));
			_wait(5000);
			func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
		}
		
		
		
		/*if (func._isVisible(getElement(btnNYFTZClass)) == true)
		{
		_wait(4000);
		_click(getElement(btnNYFTZClass));
		
		
		_wait(2000);
		_setValue(getElement(txtNYFTZClass), dataUmLogin.getData("txtNYFTZClass"));
		_wait(2000);
		String expoption2= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("txtNYFTZClass")+"\")]";
		WebElement expectedOption2 = (getWebDriver().findElement(By.xpath(expoption2)));
		expectedOption2.click();

		_wait(2000);
		
		_click(getElement(btnNYFTZCode));
		
		_wait(2000);
		_setValue(getElement(txtNYFTZCode), dataUmLogin.getData("txtNYFTZCode"));
		_wait(2000);
		String expoption= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("txtNYFTZCode")+"\")]";
		WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
		expectedOption.click();
		_wait(2000);
		}*/	
		
		if (func._isVisible(getElement(drpdwn_NYFT)) == true)
		{
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_wait(4000);
			_click(getElement(drpdwn_NYFT));
			_wait(2000);
			_setValue(getElement(txtNYFTZClass), dataUmLogin.getData("txtNYFTZClass"));
			_wait(2000);
			String expoption2= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("txtNYFTZClass")+"\")]";
			WebElement expectedOption2 = (getWebDriver().findElement(By.xpath(expoption2)));
			expectedOption2.click();
			_wait(2000);
			_click(getElement(drpdwn_Code));
			_wait(2000);
			_setValue(getElement(txtNYFTZCode), dataUmLogin.getData("txtNYFTZCode"));
			_wait(2000);
			String expoption= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("txtNYFTZCode")+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			expectedOption.click();
			_wait(2000);
		}
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");


		_wait(2000);
		long startTime3 = System.currentTimeMillis();
		long elapsedTime3=0L;
		_click(getElement(btnGenerateQuote));
		if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
		{	
		try {
			w.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		} catch (Exception e) {
			CustomReporting.logReport("Loading Bar Issue After Clicking on btnGenerateQuote ");
		}
		}
		if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
		{
			elapsedTime3 = (new Date()).getTime() - startTime3; 
			CustomReporting.logReport("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime3 +" ms"); 
			System.out.println("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime3 +" ms");
			_writeToExcel("ResponseTime", "T08_Generate Quote", ""+elapsedTime3, tcID);
		}
		_wait(3000);
		
		if (func._isVisible(getElement(btnOK)) == true) {
			_click(getElement(btnOK));
			//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
			{	
				try 
				{
					w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				} 
				catch (Exception e) 
				{
					CustomReporting.logReport("Loading Bar Issue After Clicking on btnOK ");
				}
							
			}
			//_wait(10000);
			_wait(5000);
		}
		if (func._isVisible(getElement(btnGenerateQuote)) == true)
		{
			long startTime4 = System.currentTimeMillis();
			long elapsedTime4=0L;
			_click(getElement(btnGenerateQuote));
			if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
			{	
			try {
				w.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			} catch (Exception e) {
				CustomReporting.logReport("Loading Bar Issue After Clicking on btnGenerateQuote ");
			}
			}
		//	_wait(5000);
			if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
			{
				elapsedTime4 = (new Date()).getTime() - startTime4; 
				CustomReporting.logReport("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime4 +" ms"); 
				System.out.println("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime4 +" ms");
				_writeToExcel("ResponseTime", "T08_Generate Quote", ""+elapsedTime4, tcID);
			}
		
			if (func._isVisible(getElement(btnOK)) == true)
			{
				_click(getElement(btnOK));
				if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
				{	
					try 
					{
						w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
					} 
					catch (Exception e) 
					{
						CustomReporting.logReport("Loading Bar Issue After Clicking on btnOK ");
					}
								
				}
				//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				//_wait(10000);
				_wait(5000);
			}
		}
		getWebDriver().navigate().refresh();
		_wait(1000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if (dataUmSubDet.getData("SlimProducts").equalsIgnoreCase("Yes")) {	
			
		}
		else 
		{
		/*_click(getElement(btnAction));
		_wait(1000);
		if (func._isVisible(getElement(btnFinalizeQuote)) == false)
		{
			_wait(10000);
			
			getWebDriver().navigate().refresh();
			_click(getElement(btnAction));
		}*/
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				_wait(2000);
		
				long startTime5 = System.currentTimeMillis();
				long elapsedTime5=0L;
			if(func._isVisible(getElement(btnFinalizeQuote)))
			{
				_click(getElement(btnFinalizeQuote));
			    //w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
				{	
					try 
					{
						w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
					} 
					catch (Exception e) 
					{
						CustomReporting.logReport("Loading Bar Issue After Clicking on btnFinalizeQuote");
					}
								
				}
			    if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
				{
					elapsedTime5 = (new Date()).getTime() - startTime5; 
					CustomReporting.logReport("Time taken to Complete T09_Finalize Quote Transaction :  "+elapsedTime5 +" ms"); 
					System.out.println("Time taken to Complete T09_Finalize Quote  Transaction :  "+elapsedTime5 +" ms");
					_writeToExcel("ResponseTime", "T09_Finalize Quote ", ""+elapsedTime5, tcID);
				}
			}
		
		}
		long startTime6 = System.currentTimeMillis();
		long elapsedTime6=0L;
				_click(getElement(btnSendProposal));
				if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
				{
					elapsedTime6 = (new Date()).getTime() - startTime6; 
					CustomReporting.logReport("Time taken to Complete T10_Send Transaction :  "+elapsedTime6 +" ms"); 
					System.out.println("Time taken to Complete T10_Send Transaction :  "+elapsedTime6 +" ms");
					_writeToExcel("ResponseTime", "T10_Send", ""+elapsedTime6, tcID);
				}
				_wait(5000);
				
				if(func._isVisible(getElement(btnYes))==false)
				{
					_click(getElement(btnSendProposal));
					if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
					{
						elapsedTime6 = (new Date()).getTime() - startTime6; 
						CustomReporting.logReport("Time taken to Complete T10_Send Transaction :  "+elapsedTime6 +" ms"); 
						System.out.println("Time taken to Complete T10_Send Transaction :  "+elapsedTime6 +" ms");
						_writeToExcel("ResponseTime", "T10_Send", ""+elapsedTime6, tcID);
					}
					_wait(5000);
				}
				
				_click(getElement(btnYes));
				//_wait(5000);
				_wait(3000);
				if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
				{	
				try {
					w.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				} catch (Exception e) {
					CustomReporting.logReport("Loading Bar Issue After Clicking on btnSendProposal");
				}
				}
				_click(getElement(btn_yes_custom));
				//_wait(5000);
				_wait(3000);
				if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
				{	
					try 
					{
						w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
					} 
					catch (Exception e) 
					{
						CustomReporting.logReport("Loading Bar Issue After Clicking on btn_yes_custom ");
					}
								
				}
				long startTime7 = System.currentTimeMillis();
				long elapsedTime7=0L;
				_click(getElement(btnOK));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
				{
					elapsedTime7 = (new Date()).getTime() - startTime7; 
					CustomReporting.logReport("Time taken to Complete T11_ClickOktoEmail Transaction :  "+elapsedTime7 +" ms"); 
					System.out.println("Time taken to Complete T11_ClickOktoEmail Transaction :  "+elapsedTime7 +" ms");
					_writeToExcel("ResponseTime", "T11_ClickOktoEmail", ""+elapsedTime7, tcID);
				}
				//_wait(15000);
				_wait(5000);
				
				if(dataUmSubDet.getData("MPL").equalsIgnoreCase("Yes") && !tcID.contains("DS_BC")) 
				{
					String ProposalDocmentName=getWebDriver().findElement(By.xpath("//a[@ng-click='onAttachmentDownloadClick($item)']")).getText().trim();
				    String ExpectedProposalDocName="Proposal for "+dataUmSearchPolicy.getData("InsName")+".pdf";
				    
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				    
				    if(ProposalDocmentName.equals(ExpectedProposalDocName)) {
				    	
				    	CustomReporting.logReport("", "", "The Proposal document attached in the quote mail have expectd naming format : "+ProposalDocmentName, StepStatus.SUCCESS, new String[] {},
								startTime);
				    }
				    else {
				    	
				    	CustomReporting.logReport("", "", "The Proposal document attached in the quote mail have not expectd naming format : "+ProposalDocmentName, StepStatus.FAILURE, new String[] {},
								startTime);
				    }
				    
					}
				int i=1;
				while(!(func._isVisible(getElement(email_icon))&&func._isVisible(getElement(correct_emailid))))//Email Sending 
				{
					
					if(func._isVisible(getElement(UW_emailid))) //Removing UW Email
					{
						startTime = System.currentTimeMillis();
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						String UWEmail = _getAttributeValue(getElement(UW_emailid), "TEXT");
						System.out.println(UWEmail);
						CustomReporting.logReport("UW Email ID is : "+UWEmail); 
						if(!UWEmail.isEmpty())
						{
							CustomReporting.logReport("", "", "UW Email Exists in Quote : "+UWEmail, StepStatus.SUCCESS, new String[] {},
									startTime);
						}
						else
						{
							CustomReporting.logReport("", "", "UW Email Does NOT Exists in Quote : "+UWEmail, StepStatus.FAILURE, new String[] {},
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
							CustomReporting.logReport("", "", "UW Email Removed Successfully from Quote : ", StepStatus.SUCCESS, new String[] {},
									startTime);
						}
						else
						{
							CustomReporting.logReport("", "", "UW Email is still present and is NOT Removed from Quote : "+UWEmail, StepStatus.FAILURE, new String[] {},
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
						startTime = System.currentTimeMillis();
						String TestEmail = _getAttributeValue(getElement(correct_emailid), "TEXT");
						CustomReporting.logReport("", "", "Quote Email is being sent to : "+TestEmail, StepStatus.SUCCESS, new String[] {},
								startTime);
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						break;
					}
					
					else if(func._isVisible(getElement(Wrong_emailid))) 
					{
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						startTime = System.currentTimeMillis();
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
					
					i++;
					if(i==7)
					{
						break;
					}
				}//Email Sending
				
				if(dataUmLogin.getData("NonBindingEmail").equalsIgnoreCase("Yes"))//Start EPRO-77312
				{
					func._isVisible(getElement(NonBinding_Email));
					String DearLine = _getAttributeValue(getElement(NonBinding_Email), "TEXT");
					String ExpectedLine = "Dear "+dataUmSearchPolicy.getData("InsName")+",";
					if(DearLine.equalsIgnoreCase(ExpectedLine))
					{
						CustomReporting.logReport("", "", "Release NonBinding Indication Quote Email is as expected. Actual Value : "+DearLine+" Expected Value : "+ExpectedLine, StepStatus.SUCCESS, new String[] {},
								startTime);
					}
					else
					{
						CustomReporting.logReport("", "", "Release NonBinding Indication Quote Email is NOT as expected. Actual Value : "+DearLine+" Expected Value : "+ExpectedLine, StepStatus.FAILURE, new String[] {},
								startTime);
					}
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					
				}//End EPRO-77312
				
				long startTime8 = System.currentTimeMillis();
				long elapsedTime8=0L;
				_click(getElement(btnSendEmail));
				if (func._isVisible(getElement(btnSendEmail)) == true)
				{
					_click(getElement(btnSendEmail));
					_wait(3000);
				}
				_wait(2000);
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
				{
					elapsedTime8 = (new Date()).getTime() - startTime8; 
					CustomReporting.logReport("Time taken to Complete T12_SendEmail Transaction :  "+elapsedTime8 +" ms"); 
					System.out.println("Time taken to Complete T12_SendEmail Transaction :  "+elapsedTime8 +" ms");
					_writeToExcel("ResponseTime", "T12_SendEmail", ""+elapsedTime8, tcID);
				}
				_wait(5000);
				
				if (func._isVisible(getElement(btnOK)) == true)
				{
					_click(getElement(btnOK));
					_wait(3000);
				}
				
				GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				_wait(4000);
				
				
	}
	
	public void UM_DownloadProposal(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmLogin1 = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		PageData dataUmSearchPolicy = PageDataManager.instance().getPageData("SearchPolicy", tcID);
		
		if (dataUmLogin1.getData("DownloadProposal").equalsIgnoreCase("Yes"))
		{
			if(func._isVisible(getElement(FilesIcon))==false)
			{
				_click(getElement(CollaborationIcon));
				_wait(1000);
			}
			_click(getElement(FilesIcon));
			_wait(1000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			Setup.LoadData();
			String InsuredName = dataUmSearchPolicy.getData("InsName");
			
			String ProposalDocName ="Proposal for "+InsuredName+".pdf";
			_click(getClonedElement(LnkProposalDoc).addToken("tkn_proposal",ProposalDocName));
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
				_click(getClonedElement(LnkProposalDoc).addToken("tkn_proposal",ProposalDocName));
				_wait(9000);
			}
			s.click(SaveIconPatrn);
	        func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	        String QVDownloadFilePath ="";
			String DownloadFilePath = DeviceManager.instance().getConfigurationProperties().getProperty("download.path");
			QVDownloadFilePath =strDirectoryPath+DownloadFilePath;
			String strFileName = ProposalDocName;//+".PDF"
			func._downloadFile(QVDownloadFilePath, strFileName);
			
			CustomReporting.logReport("", "", "Successfully downloaded the Proposal Document : "+strFileName, StepStatus.SUCCESS,
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
				func.PDF_Compare("Proposal for "+dataUmSearchPolicy.getData("InsName"), tcID);
			}
			if (dataUmLogin1.getData("ComparePDFPageWise").equalsIgnoreCase("Yes"))
			{
				func.PDF_Compare_Pagewise("Proposal for "+dataUmSearchPolicy.getData("InsName"), tcID);
			}
			
		}
	}
	
	public void UMSendProposal(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		WebDriverWait w = new WebDriverWait(getWebDriver(),300);
		long startTime6 = System.currentTimeMillis();
		long elapsedTime6=0L;
		_wait(5000);
			_click(getElement(btnSendProposal));
			
			elapsedTime6 = (new Date()).getTime() - startTime6; 
			CustomReporting.logReport("Time taken to Complete T10_Send Transaction :  "+elapsedTime6 +" ms"); 
			System.out.println("Time taken to Complete T10_Send Transaction :  "+elapsedTime6 +" ms");
			_writeToExcel("ResponseTime", "T10_Send", ""+elapsedTime6, tcID);
			_wait(5000);
			_click(getElement(btnYes));
			_wait(5000);				
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

			_click(getElement(btn_yes_custom));
			_wait(5000);
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			long startTime7 = System.currentTimeMillis();
			long elapsedTime7=0L;
			_click(getElement(btnOK));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			
			elapsedTime7 = (new Date()).getTime() - startTime7; 
			CustomReporting.logReport("Time taken to Complete T11_ClickOktoEmail Transaction :  "+elapsedTime7 +" ms"); 
			System.out.println("Time taken to Complete T11_ClickOktoEmail Transaction :  "+elapsedTime7 +" ms");
			_writeToExcel("ResponseTime", "T11_ClickOktoEmail", ""+elapsedTime7, tcID);
			_wait(15000);
			
			GenericFunctions.instance().validateUMStatus(tcID, "Quoted");
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_wait(4000);
			
			
			
			if (func._isVisible(getElement(txtSendEmail)) == true)//Email Sending
			{
				_wait(2000);
				_click(getElement(txtSendEmail));
				_wait(3000);
				Actions a = new Actions(getWebDriver());
				String xpath = "//*[contains(text(),'To:')]/..//input";
				String EmailId = dataUmLogin.getData("EmailID");
				a.moveToElement(getWebDriver().findElement(By.xpath(xpath))).sendKeys(EmailId).build().perform();
			    _wait(5000);
				func.setValue10();
				func.setValue10();
				func.setValue10();
				func.setValue10();
				func.setValue10();
				func.setValue9();	
				_clickTab();
				func._scrollToElement(getElement(btnSendEmail));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				if(func._isVisible(getElement(email_icon))&&func._isVisible(getElement(correct_emailid)))
				{
					long startTime8 = System.currentTimeMillis();
					long elapsedTime8=0L;
					_click(getElement(btnSendEmail));
					if (func._isVisible(getElement(btnSendEmail)) == true)
					{
						_click(getElement(btnSendEmail));
						_wait(3000);
					}
					_wait(2000);
					w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
					
					elapsedTime8 = (new Date()).getTime() - startTime8; 
					CustomReporting.logReport("Time taken to Complete T12_SendEmail Transaction :  "+elapsedTime8 +" ms"); 
					System.out.println("Time taken to Complete T12_SendEmail Transaction :  "+elapsedTime8 +" ms");
					_writeToExcel("ResponseTime", "T12_SendEmail", ""+elapsedTime8, tcID);
					_wait(5000);
          
					if (func._isVisible(getElement(btnOK)) == true)
					{
						_click(getElement(btnOK));
						_wait(3000);
					}
				}
				else if(func._isVisible(getElement(Close_emailid))) 
				{
					_click(getElement(Close_emailid));
					_wait(2000);
					if (func._isVisible(getElement(Close_emailid)) == true)
					{
						_click(getElement(Close_emailid));
						_wait(3000);
					}
					_click(getElement(txtSendEmail));
					_wait(3000);
					a.moveToElement(getWebDriver().findElement(By.xpath(xpath))).sendKeys(dataUmLogin.getData("EmailID")).build().perform();
				    _wait(5000);
					func.setValue10();
					func.setValue10();
					func.setValue10();
					func.setValue10();
					func.setValue10();
					func.setValue9();	
					_clickTab();
					func._scrollToElement(getElement(btnSendEmail));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					
					if(func._isVisible(getElement(email_icon))&&func._isVisible(getElement(correct_emailid)))
					{
						long startTime9 = System.currentTimeMillis();
						long elapsedTime9=0L;
						_click(getElement(btnSendEmail));
						_wait(2000);
						if (func._isVisible(getElement(btnSendEmail)) == true)
						{
							_click(getElement(btnSendEmail));
							_wait(3000);
						}
						w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
						
						elapsedTime9 = (new Date()).getTime() - startTime9; 
						CustomReporting.logReport("Time taken to Complete T12_SendEmail Transaction :  "+elapsedTime9 +" ms"); 
						System.out.println("Time taken to Complete T12_SendEmail Transaction :  "+elapsedTime9 +" ms");
						_writeToExcel("ResponseTime", "T12_SendEmail", ""+elapsedTime9, tcID);
						_wait(5000);
	          
						if (func._isVisible(getElement(btnOK)) == true)
						{
							_click(getElement(btnOK));
							_wait(3000);
						}
					}
					
				}
			}//Email Sending
			
			_wait(3000);
			if (func._isVisible(getElement(btnOK)) == true)
			{
				_click(getElement(btnOK));
				_wait(3000);
			}
}
	
	public void UmGetRate(String tcID, SoftAssert softAssert) throws Exception 
	{
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(20000);
		long startTime11 = System.currentTimeMillis();
		long elapsedTime11=0L; 
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
	
		_click(getElement(btnUpdateCoverages));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			
		elapsedTime11 = (new Date()).getTime() - startTime11; 
		CustomReporting.logReport("Time taken to Complete T05_Click on Update Coverages Transaction :  "+elapsedTime11 +" ms"); 
		System.out.println("Time taken to Complete T05_Click on Update Coverages Transaction :  "+elapsedTime11 +" ms");
		_writeToExcel("ResponseTime", "T05_Click on Update Coverages", ""+elapsedTime11, tcID);
		_wait(5000);
	
		_wait(5000);
		long startTime12 = System.currentTimeMillis();
		long elapsedTime12=0L; 
		
		_click(getElement(btnGetRate));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		
		elapsedTime12 = (new Date()).getTime() - startTime12; 
		CustomReporting.logReport("Time taken to Complete T06_Click Get Rate Transaction :  "+elapsedTime12 +" ms"); 
		System.out.println("Time taken to Complete T06_Click Get Rate Transaction :  "+elapsedTime12 +" ms");
		_writeToExcel("ResponseTime", "T06_Click Get Rate", ""+elapsedTime12, tcID);
		
		_wait(5000);
		if (func._isVisible(getElement(btnOK)) == true) 
		{
			_click(getElement(btnOK));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(10000);
		}
	}
	
	public void UmGenQuote(String tcID, SoftAssert softAssert) throws Exception 
	{
			
			PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
			func._waitForPageToLoad(getWebDriver(), 50L);
			
			_wait(20000);
			long startTime10 = System.currentTimeMillis();
			long elapsedTime10=0L; 
			WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		
				
				_wait(5000);
		
			_wait(5000);
			long startTime = System.currentTimeMillis();
			long elapsedTime=0L; 

		if (!((getWebDriver().findElements(By.xpath("//span[text()='Rating: Submission Information']")).size() == 0))) {

			getWebDriver().findElement(By.xpath("//span[text()='Rating: Submission Information']")).click();

			_wait(2000);
		}
			if (func._isVisible(getElement(btnGetRate)) == true) 
			{
			_click(getElement(btnGetRate));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			}
			elapsedTime = (new Date()).getTime() - startTime; 
			CustomReporting.logReport("Time taken to Complete T06_Click Get Rate Transaction :  "+elapsedTime +" ms"); 
			System.out.println("Time taken to Complete T06_Click Get Rate Transaction :  "+elapsedTime +" ms");
			_writeToExcel("ResponseTime", "T06_Click Get Rate", ""+elapsedTime, tcID);
			
			_wait(5000);
			if (func._isVisible(getElement(btnOK)) == true) 
			{
				_click(getElement(btnOK));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(10000);
			}
			
			
			if (dataUmLogin.getData("CyberCov").equalsIgnoreCase("Yes")) {
				if (func._isVisible(getElement(btnOK)) == true) {
					_click(getElement(btnOK));
					w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
					_wait(10000);
				}
				}
			
			if (tcID.equalsIgnoreCase("DS_SIT_E2E_SC_05") || tcID.equalsIgnoreCase("DS_SIT_E2E_SC_12") || tcID.equalsIgnoreCase("DS_SIT_E2E_SC_13")) 
				{	
			_wait(5000);
			String optionalEnd = "//*[contains(text(),'Rating: Optional Endts')]";
			WebElement RatingoptionalEnd = getWebDriver().findElement(By.xpath(optionalEnd));
			RatingoptionalEnd.click();
			_wait(5000);
			
			String updateButton = "//*[contains(text(),'Update Forms List')]";
			WebElement BtnUpdateFormsList = getWebDriver().findElement(By.xpath(updateButton));
			BtnUpdateFormsList.click();
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			
			}
			func._waitForPageToLoad(getWebDriver(), 50L);
			long startTime1 = System.currentTimeMillis();
			long elapsedTime1=0L; 
		
			_click(getElement(btnConvertQuote));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			
			elapsedTime1 = (new Date()).getTime() - startTime1; 
			CustomReporting.logReport("Time taken to Complete T07_Convert to Quote Transaction :  "+elapsedTime1 +" ms"); 
			System.out.println("Time taken to Complete T07_Convert to Quote Transaction :  "+elapsedTime1 +" ms");
			_writeToExcel("ResponseTime", "T07_Convert to Quote", ""+elapsedTime1, tcID);
		
			if (func._isVisible(getElement(btnConvertQuote)) == true)
			{
				long startTime2 = System.currentTimeMillis();
				long elapsedTime2=0L;
				_click(getElement(btnConvertQuote));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				
				elapsedTime2 = (new Date()).getTime() - startTime2; 
				CustomReporting.logReport("Time taken to Complete T07_Convert to Quote Transaction :  "+elapsedTime2 +" ms"); 
				System.out.println("Time taken to Complete T07_Convert to Quote Transaction :  "+elapsedTime2 +" ms");
				_writeToExcel("ResponseTime", "T07_Convert to Quote", ""+elapsedTime2, tcID);
			}
			
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		
			if (func._isVisible(getElement(btnNYFTZClass)) == true)
			{
			_wait(4000);
			_click(getElement(btnNYFTZClass));
			
			
			_wait(2000);
			_setValue(getElement(txtNYFTZClass), dataUmLogin.getData("txtNYFTZClass"));
			_wait(2000);
			String expoption2= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("txtNYFTZClass")+"\")]";
			WebElement expectedOption2 = (getWebDriver().findElement(By.xpath(expoption2)));
			expectedOption2.click();
		
			_wait(2000);
			
			_click(getElement(btnNYFTZCode));
			
			_wait(2000);
			_setValue(getElement(txtNYFTZCode), dataUmLogin.getData("txtNYFTZCode"));
			_wait(2000);
			String expoption= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("txtNYFTZCode")+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			expectedOption.click();
			_wait(2000);
			}	
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		
			_wait(2000);
			long startTime3 = System.currentTimeMillis();
			long elapsedTime3=0L;
			_click(getElement(btnGenerateQuote));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			
			elapsedTime3 = (new Date()).getTime() - startTime3; 
			CustomReporting.logReport("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime3 +" ms"); 
			System.out.println("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime3 +" ms");
			_writeToExcel("ResponseTime", "T08_Generate Quote", ""+elapsedTime3, tcID);
			_wait(3000);
			
			if (func._isVisible(getElement(btnOK)) == true) 
			{
				_click(getElement(btnOK));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(10000);
			}
			if (func._isVisible(getElement(btnGenerateQuote)) == true)
			{
				long startTime4 = System.currentTimeMillis();
				long elapsedTime4=0L;
				_click(getElement(btnGenerateQuote));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));	
			
			
				elapsedTime4 = (new Date()).getTime() - startTime4; 
				CustomReporting.logReport("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime4 +" ms"); 
				System.out.println("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime4 +" ms");
				_writeToExcel("ResponseTime", "T08_Generate Quote", ""+elapsedTime4, tcID);
			
				   if (func._isVisible(getElement(btnOK)) == true)
					{
						_click(getElement(btnOK));
						w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
						_wait(10000);
					}
			}
	}

	public void UmCreateProposal(String tcID, SoftAssert softAssert) throws Exception {
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(20000);
		long startTime11 = System.currentTimeMillis();
		long elapsedTime11 = 0L;
		WebDriverWait w = new WebDriverWait(getWebDriver(), 250);

		_click(getElement(btnAction));
		_wait(1000);
		if (func._isVisible(getElement(btnCreateProposal)) == false) {
			_wait(10000);

			getWebDriver().navigate().refresh();
			_click(getElement(btnAction));
		}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(2000);

		long startTime5 = System.currentTimeMillis();
		long elapsedTime5 = 0L;

		_click(getElement(btnCreateProposal));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

		elapsedTime5 = (new Date()).getTime() - startTime5;
		CustomReporting.logReport("Time taken to Complete T09_Create Propposal Transaction :  " + elapsedTime5 + " ms");
		System.out.println("Time taken to Complete T09_Finalize Quote  Transaction :  " + elapsedTime5 + " ms");
		_writeToExcel("ResponseTime", "T09_Finalize Quote ", "" + elapsedTime5, tcID);

	}

	public void UmCopySubmission(String tcID, SoftAssert softAssert, String CopySubType) throws Exception {
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(20000);
		long startTime11 = System.currentTimeMillis();
		long elapsedTime11 = 0L;
		WebDriverWait w = new WebDriverWait(getWebDriver(), 250);

		_click(getElement(btnAction));
		_wait(1000);
		if (func._isVisible(getElement(btnCopySubmission)) == false) {
			_wait(10000);

			getWebDriver().navigate().refresh();
			_click(getElement(btnAction));
		}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(2000);

		long startTime5 = System.currentTimeMillis();
		long elapsedTime5 = 0L;

		_click(getElement(btnCopySubmission));

		getWebDriver().findElement(By.xpath("//*[text()='Copy Submission']")).getText();

		_wait(2000);

		if (CopySubType.equalsIgnoreCase("Full")) {
			_click(getElement(btnCopy));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		} else if (CopySubType.equalsIgnoreCase("ApplicationOnly")) {

			_click(getElement(btnCopyApplicationOnly));

			_wait(2000);

			_click(getElement(btnCopy));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

		}

		elapsedTime5 = (new Date()).getTime() - startTime5;
		CustomReporting.logReport("Time taken to Complete T09_Create Propposal Transaction :  " + elapsedTime5 + " ms");
		System.out.println("Time taken to Complete T09_Finalize Quote  Transaction :  " + elapsedTime5 + " ms");
		_writeToExcel("ResponseTime", "T09_Finalize Quote ", "" + elapsedTime5, tcID);

	}

	public void UmCreateQuote(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmLogin1 = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(20000);
		long startTime11 = System.currentTimeMillis();
		long elapsedTime11 = 0L;
		WebDriverWait w = new WebDriverWait(getWebDriver(), 250);
		int numOfQcuote = Integer.parseInt(dataUmLogin1.getData("NumberOfQuote"));
		int i;
		// (//div[@class='navigationRow lplQuote1']//div//../following-sibling::div)[4]
		for (i = 2; i <= numOfQcuote; i++) {

			_click(getElement(btnAction));
			_wait(1000);
			if (func._isVisible(getElement(btnCreateQuote)) == false) {
				_wait(10000);

				getWebDriver().navigate().refresh();

				_click(getElement(btnAction));

			}
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_wait(2000);

			long startTime5 = System.currentTimeMillis();
			long elapsedTime5 = 0L;

			_click(getElement(btnCreateQuote));

			_wait(2000);
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

			_wait(10000);

			if (i == 6) {

				String ErrMsg = func._getAttributeValue(getElement(txtMultiQuoteErrorMsg), "TEXT");

				if (ErrMsg.contains("A combined quote letter can�t have more than 5 quote options")) {

					CustomReporting.logReport("", "", "Verified the error message successfully : " + ErrMsg,
							StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());

					_click(getElement(btnOK));
				} else {

					CustomReporting.logReport("", "", "Expeccted error message not pop up", StepStatus.FAILURE,
							new String[] {}, System.currentTimeMillis());

				}

			} else {

				getWebDriver().findElement(By.xpath(
						"//div//button[contains(@class,'btn-link navigationLabel ')]//span[contains(text(),'Proposal')]"))
						.click();
				_wait(5000);

				if (func._isVisible(getElement(btnGenProposalDisabled))) {
					CustomReporting.logReport("", "", "Verified successfully  the Generate Proposal is disabled :",
							StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				} else {

					CustomReporting.logReport("", "", "The Geneproposal with disable status is not present",
							StepStatus.FAILURE, new String[] {}, System.currentTimeMillis());
				}

				getWebDriver().findElement(By.xpath("//span[contains(text(),'Quote ')]")).click();

				_wait(5000);
				getWebDriver().findElement(By.xpath("//span[contains(text(),'Quote ')]")).click();

				_wait(3000);
				UmConvertToQuote(tcID, softAssert);

			}
		}

	}

	public void UmConvertToQuote(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		PageData dataUmLogin1 = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		_wait(20000);
		long startTime10 = System.currentTimeMillis();
		long elapsedTime10=0L; 
		WebDriverWait w = new WebDriverWait(getWebDriver(),300);
		if (func._isVisible(getElement(btnUpdateCoverages)) == true) 
		{
			_click(getElement(btnUpdateCoverages));
			_wait(2000);
			if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
			{
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			}
			
			elapsedTime10 = (new Date()).getTime() - startTime10; 
			CustomReporting.logReport("Time taken to Complete T05_Click on Update Coverages Transaction :  "+elapsedTime10 +" ms"); 
			System.out.println("Time taken to Complete T05_Click on Update Coverages Transaction :  "+elapsedTime10 +" ms");
			_writeToExcel("ResponseTime", "T05_Click on Update Coverages", ""+elapsedTime10, tcID);
			
			_wait(5000);
		}
		if (func._isVisible(getElement(btnUpdateCoverages)) == true) 
		{
			_click(getElement(btnUpdateCoverages));
			_wait(2000);
			if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
			{
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			}
			
			elapsedTime10 = (new Date()).getTime() - startTime10; 
			CustomReporting.logReport("Time taken to Complete T05_Click on Update Coverages Transaction :  "+elapsedTime10 +" ms"); 
			System.out.println("Time taken to Complete T05_Click on Update Coverages Transaction :  "+elapsedTime10 +" ms");
			_writeToExcel("ResponseTime", "T05_Click on Update Coverages", ""+elapsedTime10, tcID);
			
			_wait(5000);
		}
		
		if (!(getWebDriver().findElements(By.xpath("//span[contains(text(),'Quote ')]")).size() == 0)) {

			getWebDriver().findElement(By.xpath("//span[contains(text(),'Quote ')]")).click();
			_wait(5000);
		}
			_wait(5000);
		long startTime = System.currentTimeMillis();
		long elapsedTime=0L; 
		if (func._isVisible(getElement(btnGetRate)) == true) 
		{
			
		_click(getElement(btnGetRate));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		}
		elapsedTime = (new Date()).getTime() - startTime; 
		CustomReporting.logReport("Time taken to Complete T06_Click Get Rate Transaction :  "+elapsedTime +" ms"); 
		System.out.println("Time taken to Complete T06_Click Get Rate Transaction :  "+elapsedTime +" ms");
		_writeToExcel("ResponseTime", "T06_Click Get Rate", ""+elapsedTime, tcID);
		
		_wait(5000);
		if (func._isVisible(getElement(btnConfirmGetRate)) == true) 
		{
				_click(getElement(btnConfirmGetRate));
				if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
				{
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				}
				//_wait(10000);
				_wait(4000);
		}
		if (func._isVisible(getElement(btnOK)) == true)	{
			_click(getElement(btnOK));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(10000);
		}
		//Non Rate Bearing Transaction : Start
		
		/*if (dataUmLogin1.getData("NonRateBearingTran").equalsIgnoreCase("Yes")) 
		{
			_click(getElement(lblSubmissionNo));
			_wait(5000);
			String timeStamp = (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())).replace(".", "");
			_setValue(getElement(txtStreet1), dataUmLogin1.getData("Street1_NonRateBearing") + "_" + timeStamp);
			func._waitForPageToLoad(getWebDriver(), 50L);
			
		}*/
		
		
		//Non Rate Bearing Transaction : End
		
		if (dataUmLogin.getData("CyberCov").equalsIgnoreCase("Yes")) {
			if (func._isVisible(getElement(btnOK)) == true) {
				_click(getElement(btnOK));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(10000);
			}
			}
		
		if (tcID.equalsIgnoreCase("DS_SIT_E2E_SC_05") || tcID.equalsIgnoreCase("DS_SIT_E2E_SC_12") || tcID.equalsIgnoreCase("DS_SIT_E2E_SC_13")) 
			{	
		_wait(5000);
		String optionalEnd = "//*[contains(text(),'Rating: Optional Endts')]";
		WebElement RatingoptionalEnd = getWebDriver().findElement(By.xpath(optionalEnd));
		RatingoptionalEnd.click();
		_wait(5000);
		
		String updateButton = "//*[contains(text(),'Update Forms List')]";
		WebElement BtnUpdateFormsList = getWebDriver().findElement(By.xpath(updateButton));
		BtnUpdateFormsList.click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		
		}
		func._waitForPageToLoad(getWebDriver(), 50L);
		long startTime1 = System.currentTimeMillis();
		long elapsedTime1=0L; 

		if (!(getWebDriver().findElements(By.xpath("//button[contains(@class,'btn-link navigationLabel 3-')]"))
				.size() == 0)) {

			int quoteSize = getWebDriver().findElements(By.xpath(
					"//div[contains(@ng-class,'{ selected: secondLevelItem.selected }')]//button[contains(@class,'btn-link navigationLabel 3-')]"))
					.size();
			getWebDriver()
					.findElement(
							By.xpath("//button[contains(@class,'btn-link navigationLabel 3-" + (quoteSize - 1) + "')]"))
					.click();
			_wait(5000);
		}
		_click(getElement(btnConvertQuote));
		if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
		{	
			try 
			{
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			} 
			catch (Exception e) 
			{
				CustomReporting.logReport("Loading Bar Issue After Clicking on btnConvertQuote ");
			}
						
		}		
		elapsedTime1 = (new Date()).getTime() - startTime1; 
		CustomReporting.logReport("Time taken to Complete T07_Convert to Quote Transaction :  "+elapsedTime1 +" ms"); 
		System.out.println("Time taken to Complete T07_Convert to Quote Transaction :  "+elapsedTime1 +" ms");
		_writeToExcel("ResponseTime", "T07_Convert to Quote", ""+elapsedTime1, tcID);

		if (func._isVisible(getElement(btnConvertQuote)) == true)
		{
			long startTime2 = System.currentTimeMillis();
			long elapsedTime2=0L;
			_click(getElement(btnConvertQuote));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			
			elapsedTime2 = (new Date()).getTime() - startTime2; 
			CustomReporting.logReport("Time taken to Complete T07_Convert to Quote Transaction :  "+elapsedTime2 +" ms"); 
			System.out.println("Time taken to Complete T07_Convert to Quote Transaction :  "+elapsedTime2 +" ms");
			_writeToExcel("ResponseTime", "T07_Convert to Quote", ""+elapsedTime2, tcID);
		}
		
			if (func._isVisible(getElement(btnConfirmGetRate)) == true) {
			_click(getElement(btnConfirmGetRate));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(10000);
		}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");


		if(dataUmLogin1.getData("PolicyForms").equalsIgnoreCase("Yes"))
		{
			_click(getElement(btnPolicyForms));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
		
		if (func._isVisible(getElement(btnNYFTZClass)) == true)
		{
		_wait(4000);
		_click(getElement(btnNYFTZClass));
		
		
		_wait(2000);
		_setValue(getElement(txtNYFTZClass), dataUmLogin.getData("txtNYFTZClass"));
		_wait(2000);
		String expoption2= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("txtNYFTZClass")+"\")]";
		WebElement expectedOption2 = (getWebDriver().findElement(By.xpath(expoption2)));
		expectedOption2.click();

		_wait(2000);
		
		_click(getElement(btnNYFTZCode));
		
		_wait(2000);
		_setValue(getElement(txtNYFTZCode), dataUmLogin.getData("txtNYFTZCode"));
		_wait(2000);
		String expoption= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("txtNYFTZCode")+"\")]";
		WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
		expectedOption.click();
		_wait(2000);
		}	
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

/*
		_wait(2000);
		long startTime3 = System.currentTimeMillis();
		long elapsedTime3=0L;
		_click(getElement(btnGenerateQuote));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		
		elapsedTime3 = (new Date()).getTime() - startTime3; 
		CustomReporting.logReport("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime3 +" ms"); 
		System.out.println("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime3 +" ms");
		_writeToExcel("ResponseTime", "T08_Generate Quote", ""+elapsedTime3, tcID);
		_wait(3000);
		
		if (func._isVisible(getElement(btnOK)) == true) {
			_click(getElement(btnOK));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(10000);
		}
		if (func._isVisible(getElement(btnGenerateQuote)) == true)
		{
			long startTime4 = System.currentTimeMillis();
			long elapsedTime4=0L;
			_click(getElement(btnGenerateQuote));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));	
		//	_wait(5000);
		
			elapsedTime4 = (new Date()).getTime() - startTime4; 
			CustomReporting.logReport("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime4 +" ms"); 
			System.out.println("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime4 +" ms");
			_writeToExcel("ResponseTime", "T08_Generate Quote", ""+elapsedTime4, tcID);
		
			if (func._isVisible(getElement(btnOK)) == true)
			{
				_click(getElement(btnOK));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(10000);
			}
		}
		getWebDriver().navigate().refresh();
		_wait(1000);
*/	}
	
	@Override
	public void UM_GenerateProposal(String tcID, SoftAssert softAssert) throws Exception 
	{	
		_wait(2000);
		WebDriverWait w = new WebDriverWait(getWebDriver(),300);
		long startTime3 = System.currentTimeMillis();
		long elapsedTime3=0L;
		_click(getElement(btnGenerateQuote));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
	
		elapsedTime3 = (new Date()).getTime() - startTime3; 
		CustomReporting.logReport("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime3 +" ms"); 
		System.out.println("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime3 +" ms");
		_writeToExcel("ResponseTime", "T08_Generate Quote", ""+elapsedTime3, tcID);
		_wait(3000);
		
		if (func._isVisible(getElement(btnOK)) == true) {
			_click(getElement(btnOK));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(10000);
		}
		if (func._isVisible(getElement(btnGenerateQuote)) == true)
		{
			long startTime4 = System.currentTimeMillis();
			long elapsedTime4=0L;
			_click(getElement(btnGenerateQuote));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));	
		//	_wait(5000);
		
			elapsedTime4 = (new Date()).getTime() - startTime4; 
			CustomReporting.logReport("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime4 +" ms"); 
			System.out.println("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime4 +" ms");
			_writeToExcel("ResponseTime", "T08_Generate Quote", ""+elapsedTime4, tcID);
		
			if (func._isVisible(getElement(btnOK)) == true)
			{
				_click(getElement(btnOK));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(10000);
			}
		}
		getWebDriver().navigate().refresh();
			_wait(1000);
	}
	@Override
	public void UMFinalizeProposal(String tcID, SoftAssert softAssert) throws Exception 
	{
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(10000);
		WebDriverWait w = new WebDriverWait(getWebDriver(),300);
	
		long startTime5 = System.currentTimeMillis();
		long elapsedTime5=0L;
		if(func._isVisible(getElement(btnFinalizeQuote)))
		{
			_click(getElement(btnFinalizeQuote));
	
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
	
		elapsedTime5 = (new Date()).getTime() - startTime5; 
		CustomReporting.logReport("Time taken to Complete T09_Finalize Quote Transaction :  "+elapsedTime5 +" ms"); 
		System.out.println("Time taken to Complete T09_Finalize Quote  Transaction :  "+elapsedTime5 +" ms");
		_writeToExcel("ResponseTime", "T09_Finalize Quote ", ""+elapsedTime5, tcID);
		}
		

	}
	
	public void verify_UMAccountReAssignment_ErrorPopup(String tcID, SoftAssert softAssert) throws Exception 
	{
			
			PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
			
			_wait(10000);
						
			if(func._isVisible(getElement(msg_AccountReAssigment)))
			{
				CustomReporting.logReport("","","The error message 'The assigned account is no longer valid � a new submission must be created' is displaying and not allowing to renewal the submission when change the name / address completely with account reassignment to a brand new account " ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
			}
			else
			{
				CustomReporting.logReport("", "", "The error message 'The assigned account is no longer valid � a new submission must be created' is not displaying when change the name / address completely with account reassignment to a brand new account","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
			}
	}
				

	public void UmWorkSheetEditVerify(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataWorksheet = PageDataManager.instance().getPageData("WorksheetEdit", tcID);
		PageData dataUmExposures = PageDataManager.instance().getPageData("Exposures", tcID);

		while (!func._isVisible(getElement(lnkUnderwrittingWS))) {
			_click(getElement(lnkWorksheets));
			_wait(5000);
		}

		while (!(func._isVisible(getElement(txtWorksheetCurrentFYE)))) {

			_click(getElement(lnkUnderwrittingWS));

			_wait(5000);
		}

		_setValue(getElement(txtWorksheetCurrentFYE), dataWorksheet.getData("Current FYE"));
		_setValue(getElement(txtWorksheetPriorFYE), dataWorksheet.getData("Prior FYE"));

		String aarWorksheetAtrr[] = { "Total Liabilities","Net Assets", "Total Net Assets", "Cost of Goods Sold", "Total Assets",
				"Total Revenues", "Cash & Equivalents", "Investments", "Accounts Receivable", "Inventory",
				"Current Assets", "Current Liabilities", "Accounts Payable", "Long Term Debt", 
				"Depreciation / Amortization", "Operating Income", "Increase in Unrestricted Net Assets",
				"Interest Expense", "Net income", "Cash from (used in) operations",
				"Cash from (used in) investing activities", "Cash from (used in) financing activities",
				"Net Change in Cash", "Current ratio", "Cash flow Liquidity Ratio" };

		for (String WSAttr : aarWorksheetAtrr) {

			if (WSAttr.equals("Total Assets")) {

				String currYearTotalAsset = getClonedElement(txtWorksheetArribute).addToken("tkn_AttrName", WSAttr)
						.getAttribute("value").replace("$", "");
				currYearTotalAsset = currYearTotalAsset.replace(",", "");
				double currYTAvalue = Double.parseDouble(currYearTotalAsset);

				double corpAssetvalue = Double.parseDouble(dataUmExposures.getData("CorporateAssets"));

				if (currYTAvalue == (corpAssetvalue / 1000)) {
					CustomReporting.logReport("", "",
							"Current Year Total Asset Value :" + currYTAvalue + " is as per the Coporate Asset value",
							StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				} else {

					CustomReporting.logReport("", "",
							"Current Year Total Asset Value :" + currYTAvalue
									+ " is not as per the Coporate Asset value",
							StepStatus.FAILURE, new String[] {}, System.currentTimeMillis());
				}

				if (!(dataWorksheet.getData(WSAttr + "-Prior").equalsIgnoreCase("null")||
						dataWorksheet.getData(WSAttr + "-Prior").equalsIgnoreCase(""))) {

					_setValue(getClonedElement(txtWorksheetArribute1).addToken("tkn_AttrName", WSAttr),
							dataWorksheet.getData(WSAttr + "-Prior"));
					Actions act = new Actions(getWebDriver());
					act.sendKeys(Keys.TAB).build().perform();
					_wait(2000);
					String umChangePerValue = getClonedElement(txtWorksheetArribute2).addToken("tkn_AttrName", WSAttr)
							.getAttribute("value").replace("%", "");
					System.out.println(umChangePerValue);

					double priorAttrValue = Double.parseDouble(dataWorksheet.getData(WSAttr + "-Prior"));
					double currAttrValue = currYTAvalue;
					DecimalFormat decimalFormat = new DecimalFormat(".##");
					String perChangeOfValue = decimalFormat
							.format((currAttrValue - priorAttrValue) / priorAttrValue * 100.0);
					double perChangeOfVal = Double.parseDouble(perChangeOfValue);
					double umChangePerVal = Double.parseDouble(umChangePerValue);
					if (umChangePerVal == perChangeOfVal) {

						CustomReporting.logReport("", "", "% change of value :" + perChangeOfValue + " is as Expected",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					} else {

						CustomReporting.logReport("", "",
								"% change of value :" + perChangeOfValue + " is not as Expected", StepStatus.FAILURE,
								new String[] {}, System.currentTimeMillis());
					}
				}

			} else if (WSAttr.equals("Total Revenues")) {

				String currYearTotalRev = getClonedElement(txtWorksheetArribute).addToken("tkn_AttrName", WSAttr)
						.getAttribute("value").replace("$", "");
				currYearTotalRev = currYearTotalRev.replace(",", "");

				double currYTAvalue = Double.parseDouble(currYearTotalRev);

				double SetRevenueValue = Double.parseDouble(dataUmExposures.getData("Revenue"));

				if (currYTAvalue == (SetRevenueValue / 1000)) {
					CustomReporting.logReport("", "",
							"Current Year Total Revnue in WS :" + currYTAvalue + " is as per Set Revenue value",
							StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				} else {

					CustomReporting.logReport("", "",
							"Current Year Total Revenue in WS :" + currYTAvalue
									+ " is not as per the Set Revenue value",
							StepStatus.FAILURE, new String[] {}, System.currentTimeMillis());
				}

				if (!(dataWorksheet.getData(WSAttr + "-Prior").equalsIgnoreCase("null")||
						dataWorksheet.getData(WSAttr + "-Prior").equalsIgnoreCase(""))) {

					_setValue(getClonedElement(txtWorksheetArribute1).addToken("tkn_AttrName", WSAttr),
							dataWorksheet.getData(WSAttr + "-Prior"));
					Actions act = new Actions(getWebDriver());
					act.sendKeys(Keys.TAB).build().perform();
					_wait(2000);
					String umChangePerValue = getClonedElement(txtWorksheetArribute2).addToken("tkn_AttrName", WSAttr)
							.getAttribute("value").replace("%", "");
					System.out.println(umChangePerValue);

					double priorAttrValue = Double.parseDouble(dataWorksheet.getData(WSAttr + "-Prior"));
					double currAttrValue = currYTAvalue;
					DecimalFormat decimalFormat = new DecimalFormat(".##");
					String perChangeOfValue = decimalFormat
							.format((currAttrValue - priorAttrValue) / priorAttrValue * 100.0);
					double perChangeOfVal = Double.parseDouble(perChangeOfValue);
					double umChangePerVal = Double.parseDouble(umChangePerValue);
					if (umChangePerVal == perChangeOfVal) {

						CustomReporting.logReport("", "", "% change of value :" + perChangeOfValue + " is as Expected",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					} else {

						CustomReporting.logReport("", "",
								"% change of value :" + perChangeOfValue + " is not as Expected", StepStatus.FAILURE,
								new String[] {}, System.currentTimeMillis());
					}
				}

			} else {
				if (!(dataWorksheet.getData(WSAttr + "-Curr").equalsIgnoreCase("null"))) {

					_click(getClonedElement(txtWorksheetArribute).addToken("tkn_AttrName", WSAttr));
					
					if(WSAttr.equalsIgnoreCase("Total Liabilities")) {
						
						String CurrTotalLibBeforeSetValue=getClonedElement(txtWorksheetArribute).addToken("tkn_AttrName", WSAttr)
						.getAttribute("value");
						
						String PriorTotalLibBeforeSetValue=getClonedElement(txtWorksheetArribute1).addToken("tkn_AttrName", WSAttr)
								.getAttribute("value");
						
						if(CurrTotalLibBeforeSetValue.equalsIgnoreCase("")&&PriorTotalLibBeforeSetValue.equalsIgnoreCase("")) {
						CustomReporting.logReport("", "",
								"Prefilled value for the total liability is null which is expected :",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
						}
						else {
							CustomReporting.logReport("", "",
									"Prefilled value for the total liability is not null which is not expected :",
									StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
						}
					}

					_setValue(getClonedElement(txtWorksheetArribute).addToken("tkn_AttrName", WSAttr),
							dataWorksheet.getData(WSAttr + "-Curr"));

					_wait(2000);

				}

				if (!(dataWorksheet.getData(WSAttr + "-Prior").equalsIgnoreCase("null")||
						dataWorksheet.getData(WSAttr + "-Prior").equalsIgnoreCase(""))) {

					_setValue(getClonedElement(txtWorksheetArribute1).addToken("tkn_AttrName", WSAttr),
							dataWorksheet.getData(WSAttr + "-Prior"));
					Actions act = new Actions(getWebDriver());
				//	act.sendKeys(Keys.TAB).build().perform();
					
					_click(getClonedElement(txtWorksheetArribute2).addToken("tkn_AttrName", WSAttr));
					_wait(5000);
					String umChangePerValue = getClonedElement(txtWorksheetArribute2).addToken("tkn_AttrName", WSAttr)
							.getAttribute("value").replace("%", "");
					System.out.println(umChangePerValue);

					double priorAttrValue = Double.parseDouble(dataWorksheet.getData(WSAttr + "-Prior"));
					double currAttrValue = Double.parseDouble(dataWorksheet.getData(WSAttr + "-Curr"));
					DecimalFormat decimalFormat = new DecimalFormat("#.##");
					String perChangeOfValue = decimalFormat
							.format((currAttrValue - priorAttrValue) / priorAttrValue * 100.0);
					double perChangeOfVal = Double.parseDouble(perChangeOfValue);
					double umChangePerVal = Double.parseDouble(umChangePerValue);
					if (umChangePerVal == perChangeOfVal) {

						CustomReporting.logReport("", "",
								"% change of value for" + WSAttr + "  :" + perChangeOfValue + " is as Expected",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					} else {

						CustomReporting.logReport("", "",
								"% change of value for" + WSAttr + "  :" + perChangeOfValue + " is not as Expected",
								StepStatus.FAILURE, new String[] {}, System.currentTimeMillis());
					}
				}

			}

		}
		if (!(getWebDriver().findElements(By.xpath("//span[contains(text(),'Quote ')]")).size() == 0)) {

			getWebDriver().findElement(By.xpath("//span[contains(text(),'Quote ')]")).click();
			_wait(5000);
			getWebDriver().findElement(By.xpath("//span[contains(text(),'Quote ')]")).click();
			_wait(5000);
		}
	}

	public void VerifyForms(String tcID, SoftAssert softAssert) throws Exception {
		PageData FormsData = PageDataManager.instance().getPageData("Forms", tcID);

		LinkedList<String> expectedListOfForms = new LinkedList<String>();

		LinkedList<String> actualListOfForms = new LinkedList<String>();

		if (!((getWebDriver().findElements(By.xpath("(//div[contains(@class,'navigationRow pro')]//button)[2]"))
				.size() == 0))) {

			int i = 0;
			while (((getWebDriver().findElements(By.xpath("//button[@ng-click='openNavItem($event, secondLevelItem)']"))
					.size() == 0)) && i <= 3) {

				getWebDriver().findElement(By.xpath("(//div[contains(@class,'navigationRow pro')]//button)[2]"))
						.click();

				_wait(2000);

				i++;
			}

			if ((!((getWebDriver().findElements(By.xpath("//button[@ng-click='openNavItem($event, secondLevelItem)']"))
					.size() == 0)))
					&& (getWebDriver().findElements(By.xpath("//span[text()='Rating: Submission Information']"))
							.size() == 0)) {

				getWebDriver().findElement(By.xpath("//button[@ng-click='openNavItem($event, secondLevelItem)']"))
						.click();
				_wait(2000);
			}

			if (!((getWebDriver().findElements(By.xpath("//span[text()='Rating: Submission Information']"))
					.size() == 0))) {

				getWebDriver().findElement(By.xpath("//span[text()='Rating: Submission Information']")).click();

				_wait(2000);
			}

		}

		if (!((getWebDriver().findElements(By.xpath("//span[text()='Policy Forms']")).size() == 0))) {
			int i = 1;
			while (i <= 3) {
				getWebDriver().findElement(By.xpath("//span[text()='Policy Forms']")).click();

				i++;
			}
		}

		for (String expFormList : FormsData.getData("FormsValidation").split(";")) {

			expectedListOfForms.add(expFormList);

		}

		int umSizeOfForms = getWebDriver()
				.findElements(By.xpath("//input[@class='formFieldComponent-formNumber']")).size();

		for (int i = 1; i < umSizeOfForms; i++) {

			actualListOfForms.add(
					getClonedElement(txtFormsName).addToken("tkn_formNum", Integer.toString(i)).getAttribute("value"));
		}

		for (String expForm : expectedListOfForms) {

			if (actualListOfForms.contains(expForm)) {

				CustomReporting.logReport("", "", "Form :" + expForm + " is present in the UM", StepStatus.SUCCESS,
						new String[] {}, System.currentTimeMillis());
			} else {
				CustomReporting.logReport("", "", "Form :" + expForm + " is not present in the UM", StepStatus.FAILURE,
						new String[] {}, System.currentTimeMillis());
			}
		}

	}

	@Override
	public void UM_ConvertQuote(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		PageData dataUmLogin1 = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		_wait(20000);
		long startTime10 = System.currentTimeMillis();
		long elapsedTime10=0L; 
		WebDriverWait w = new WebDriverWait(getWebDriver(),300);
		if (func._isVisible(getElement(btnUpdateCoverages)) == true) 
		{
			_click(getElement(btnUpdateCoverages));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			
			elapsedTime10 = (new Date()).getTime() - startTime10; 
			CustomReporting.logReport("Time taken to Complete T05_Click on Update Coverages Transaction :  "+elapsedTime10 +" ms"); 
			System.out.println("Time taken to Complete T05_Click on Update Coverages Transaction :  "+elapsedTime10 +" ms");
			_writeToExcel("ResponseTime", "T05_Click on Update Coverages", ""+elapsedTime10, tcID);
			
			_wait(5000);
		}
			_wait(5000);
		long startTime = System.currentTimeMillis();
		long elapsedTime=0L; 
		if (func._isVisible(getElement(btnGetRate)) == true) 
		{
			
		_click(getElement(btnGetRate));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		}
		elapsedTime = (new Date()).getTime() - startTime; 
		CustomReporting.logReport("Time taken to Complete T06_Click Get Rate Transaction :  "+elapsedTime +" ms"); 
		System.out.println("Time taken to Complete T06_Click Get Rate Transaction :  "+elapsedTime +" ms");
		_writeToExcel("ResponseTime", "T06_Click Get Rate", ""+elapsedTime, tcID);
		
		_wait(5000);
		if (func._isVisible(getElement(btnOK)) == true) 
		{
			_click(getElement(btnOK));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(10000);
		}
		//Non Rate Bearing Transaction : Start
		
		/*if (dataUmLogin1.getData("NonRateBearingTran").equalsIgnoreCase("Yes")) 
		{
			_click(getElement(lblSubmissionNo));
			_wait(5000);
			String timeStamp = (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())).replace(".", "");
			_setValue(getElement(txtStreet1), dataUmLogin1.getData("Street1_NonRateBearing") + "_" + timeStamp);
			func._waitForPageToLoad(getWebDriver(), 50L);
			
		}*/
		
		
		//Non Rate Bearing Transaction : End
		
		if (dataUmLogin.getData("CyberCov").equalsIgnoreCase("Yes")) {
			if (func._isVisible(getElement(btnOK)) == true) {
				_click(getElement(btnOK));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(10000);
			}
			}
		
		if (tcID.equalsIgnoreCase("DS_SIT_E2E_SC_05") || tcID.equalsIgnoreCase("DS_SIT_E2E_SC_12") || tcID.equalsIgnoreCase("DS_SIT_E2E_SC_13")) 
			{	
		_wait(5000);
		String optionalEnd = "//*[contains(text(),'Rating: Optional Endts')]";
		WebElement RatingoptionalEnd = getWebDriver().findElement(By.xpath(optionalEnd));
		RatingoptionalEnd.click();
		_wait(5000);
		
		String updateButton = "//*[contains(text(),'Update Forms List')]";
		WebElement BtnUpdateFormsList = getWebDriver().findElement(By.xpath(updateButton));
		BtnUpdateFormsList.click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		
		}
		func._waitForPageToLoad(getWebDriver(), 50L);
		long startTime1 = System.currentTimeMillis();
		long elapsedTime1=0L; 

		_click(getElement(btnConvertQuote));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		
		elapsedTime1 = (new Date()).getTime() - startTime1; 
		CustomReporting.logReport("Time taken to Complete T07_Convert to Quote Transaction :  "+elapsedTime1 +" ms"); 
		System.out.println("Time taken to Complete T07_Convert to Quote Transaction :  "+elapsedTime1 +" ms");
		_writeToExcel("ResponseTime", "T07_Convert to Quote", ""+elapsedTime1, tcID);

		if (func._isVisible(getElement(btnConvertQuote)) == true)
		{
			long startTime2 = System.currentTimeMillis();
			long elapsedTime2=0L;
			_click(getElement(btnConvertQuote));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			
			elapsedTime2 = (new Date()).getTime() - startTime2; 
			CustomReporting.logReport("Time taken to Complete T07_Convert to Quote Transaction :  "+elapsedTime2 +" ms"); 
			System.out.println("Time taken to Complete T07_Convert to Quote Transaction :  "+elapsedTime2 +" ms");
			_writeToExcel("ResponseTime", "T07_Convert to Quote", ""+elapsedTime2, tcID);
		}
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");


		if(dataUmLogin1.getData("PolicyForms").equalsIgnoreCase("Yes"))
		{
			_click(getElement(btnPolicyForms));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
		
		if (func._isVisible(getElement(btnNYFTZClass)) == true)
		{
		_wait(4000);
		_click(getElement(btnNYFTZClass));
		
		
		_wait(2000);
		_setValue(getElement(txtNYFTZClass), dataUmLogin.getData("txtNYFTZClass"));
		_wait(2000);
		String expoption2= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("txtNYFTZClass")+"\")]";
		WebElement expectedOption2 = (getWebDriver().findElement(By.xpath(expoption2)));
		expectedOption2.click();

		_wait(2000);
		
		_click(getElement(btnNYFTZCode));
		
		_wait(2000);
		_setValue(getElement(txtNYFTZCode), dataUmLogin.getData("txtNYFTZCode"));
		_wait(2000);
		String expoption= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("txtNYFTZCode")+"\")]";
		WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
		expectedOption.click();
		_wait(2000);
		}	
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

/*
		_wait(2000);
		long startTime3 = System.currentTimeMillis();
		long elapsedTime3=0L;
		_click(getElement(btnGenerateQuote));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		
		elapsedTime3 = (new Date()).getTime() - startTime3; 
		CustomReporting.logReport("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime3 +" ms"); 
		System.out.println("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime3 +" ms");
		_writeToExcel("ResponseTime", "T08_Generate Quote", ""+elapsedTime3, tcID);
		_wait(3000);
		
		if (func._isVisible(getElement(btnOK)) == true) {
			_click(getElement(btnOK));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(10000);
		}
		if (func._isVisible(getElement(btnGenerateQuote)) == true)
		{
			long startTime4 = System.currentTimeMillis();
			long elapsedTime4=0L;
			_click(getElement(btnGenerateQuote));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));	
		//	_wait(5000);
		
			elapsedTime4 = (new Date()).getTime() - startTime4; 
			CustomReporting.logReport("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime4 +" ms"); 
			System.out.println("Time taken to Complete T08_Generate Quote Transaction :  "+elapsedTime4 +" ms");
			_writeToExcel("ResponseTime", "T08_Generate Quote", ""+elapsedTime4, tcID);
		
			if (func._isVisible(getElement(btnOK)) == true)
			{
				_click(getElement(btnOK));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(10000);
			}
		}
		getWebDriver().navigate().refresh();
		_wait(1000);
*/	}
	

	@Override
	public void UmCopyCreateQuote(String tcID, SoftAssert softAssert,String QuoteType) throws Exception {
		PageData dataUmLogin1 = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(20000);
		long startTime11 = System.currentTimeMillis();
		long elapsedTime11 = 0L;
		WebDriverWait w = new WebDriverWait(getWebDriver(), 250);
		
			_click(getElement(btnAction));
			_wait(1000);
			if (func._isVisible(getClonedElement(btnCopyCreateQuote).addToken("tkn_QuoteType", QuoteType)) == false) {
				_wait(10000);

				getWebDriver().navigate().refresh();

				_click(getElement(btnAction));

			}
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_wait(2000);

			long startTime5 = System.currentTimeMillis();
			long elapsedTime5 = 0L;

			_click(getClonedElement(btnCopyCreateQuote).addToken("tkn_QuoteType", QuoteType));

			_wait(2000);
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

			_wait(10000);
			
			getWebDriver().findElement(By.xpath("//span[contains(text(),'Quote ')]")).click();

			_wait(5000);
			getWebDriver().findElement(By.xpath("//span[contains(text(),'Quote ')]")).click();

			_wait(3000);
		
	}


	@Override
	public void VerifyWrittingApproach(String tcID, SoftAssert softAssert) throws Exception{
		PageData dataUmLogin = PageDataManager.instance().getPageData("Exposures", tcID);
		PageData dataUmLogin1 = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		long startTime = System.currentTimeMillis();
		_wait(2000);
		
		_click(getElement(lnk_SubInfo));
		
		_wait(10000);
		
		_click(getElement(chk_verificationCheckBox));
		
        _wait(2000);
        
        _click(getElement(dd_writtingApproah));
        
        _wait(10000);
        
        int sizeOfWrittingApproach=getWebDriver().
        		findElements(By.xpath("//div[@class='umPopover uwWritingApproach lazyLoadDropdown']//div[@class='buttonLabel ng-binding']")).size();
		
        ArrayList<String> WrittingApproach=new ArrayList<>();
        
        
        
        for(int i=1;i<=sizeOfWrittingApproach;i++) {
        	
        	WrittingApproach.add(getWebDriver().findElement(By.xpath("(//div[@class='umPopover uwWritingApproach lazyLoadDropdown']//div[@class='buttonLabel ng-binding'])["+i+"]")).getText());
        }
        
       for(String str:WrittingApproach) {
    	   
    	   if(str.equalsIgnoreCase("Admitted")||str.equalsIgnoreCase("Non-Admitted")){
    		   CustomReporting.logReport("", "", "Writting Approach is as per the expected list of Writing Approach : "+str, StepStatus.SUCCESS, new String[] {},
   					startTime);
    	   }else {
    		   
    		   CustomReporting.logReport("", "", "Writting Approach is not as expected : "+str, StepStatus.FAILURE, new String[] {},
      					startTime);
    	   }
       }
       
      
       
		_click(getClonedElement(SelWrittingApproach).addToken("tkn_SelWrittingApproach", dataUmLogin.getData("WritingApproachInput")));
		
		  _wait(2000);
		  
		  _setValue(getElement(txt_Justification), "Test");
		  
		  func.setValue9();
	
	}
	@Override
	public void verifyErrorForLPLClaimExpenses(String tcID, SoftAssert softAs) throws Exception{
		try {
			PageData data = PageDataManager.instance().getPageData("LPLAdmitted", tcID);
			func._waitForPageToLoad(getWebDriver(), 50L);
			
			_wait(20000);
			
			WebDriverWait w = new WebDriverWait(getWebDriver(), 250);

			if (!(getWebDriver().findElements(By.xpath("//div[@class='buttonOverlay ng-scope']")).size() == 0)) {

				_click(getElement(btnUpdateCoverages));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			}

			
			_wait(5000);

			_wait(5000);
			long startTime = System.currentTimeMillis();
			long elapsedTime=0L; 
			if (func._isVisible(getElement(btnGetRate)) == true) 
			{
				
			_click(getElement(btnGetRate));
			_wait(10000);
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			}
			elapsedTime = (new Date()).getTime() - startTime; 
			CustomReporting.logReport("Time taken to Complete T06_Click Get Rate Transaction :  "+elapsedTime +" ms"); 
			System.out.println("Time taken to Complete T06_Click Get Rate Transaction :  "+elapsedTime +" ms");
			_writeToExcel("ResponseTime", "T06_Click Get Rate", ""+elapsedTime, tcID);
			
			_wait(5000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if(func._isVisible(getElement(lblErrorText))) {
				func._checkAttributeValue(getElement(lblErrorText), "TEXT", data.getData("ExpectedCLaimsExpenseError"), softAs);
			}
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
		}catch(Exception ex) {
			
		}
	}
	
	public void verifyCRIPremium(String tcID, SoftAssert softAs) {
		_click(getElement(btnPremiumSummary));
		_wait(5000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		String crimeSubTotal = func._getAttributeValue(getElement(txtCrimeSubTotal), "TEXT", softAs);
		
		_click(getElement(btnRatingCRI));
		_wait(5000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		func._checkAttributeValue(getElement(txtCrimePremium), "TEXT", crimeSubTotal, softAs);
		
		
	}
	
	@Override
	public void Verify_SRMTotalError(String tcID, SoftAssert softAs) throws Exception
	{
		try {
			WebDriverWait w = new WebDriverWait(getWebDriver(), 250);
			_click(getElement(btnGetRate));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_wait(2000);
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if (func._isVisible(getElement(SRMTotal_Error))) {
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				CustomReporting.logReport("", "",
						"Error is thrown as expected if total SRM for all coverages is greater than the limits provided",
						StepStatus.SUCCESS, System.currentTimeMillis());
			} else {
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				CustomReporting.logReport("", "",
						"UnExpected Behavior : Error is NOT thrown even if total SRM for all coverages is greater than the limits provided",
						StepStatus.FAILURE, System.currentTimeMillis());

			} 
			_click(getElement(btnOK));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	

		

	}
	
