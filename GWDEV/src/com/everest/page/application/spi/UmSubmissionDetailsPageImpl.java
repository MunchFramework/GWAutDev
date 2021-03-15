package com.everest.page.application.spi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.Element.WAIT_FOR;

import com.everest.functions.settings.Setup;
import com.everest.page.application.UmSubmissionDetailsPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmSubmissionDetailsPageImpl extends CustomAbstractPage implements UmSubmissionDetailsPage {

	@Override
	public void UmSubmissionDetails(String tcID, SoftAssert softAssert) throws Exception {
		
		PageData dataPolicyNum =null;
		PageData dataUmLogIn = PageDataManager.instance().getPageData("UmLogin", tcID);
		PageData dataUmSubDet = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		PageData dataUMEditSub = PageDataManager.instance().getPageData("Edit_UMSubmissionDetails", tcID);
		dataPolicyNum = PageDataManager.instance().getPageData("SearchPolicy", tcID);
		Actions ac = new Actions(getWebDriver());
		
		try {
			if (!dataPolicyNum.getData("tcID_BC_PartB").equals("")) {
				dataPolicyNum = PageDataManager.instance().getPageData("SearchPolicy",
						dataPolicyNum.getData("tcID_BC_PartB"));
			}
			if (!dataUmSubDet.getData("tcID_BC_PartB").equals("")) {
				dataUmSubDet = PageDataManager.instance().getPageData("UMSubmissionDetails",
						dataUmSubDet.getData("tcID_BC_PartB"));
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		func._waitForPageToLoad(getWebDriver(), 50L); 
		
		WebDriverWait w = new WebDriverWait(getWebDriver(),400);
		String strURL = "";
		_wait(4000);
		
		
		//New Submission 1
		long startTime = System.currentTimeMillis();
		long elapsedTime=0L;
		
		_click(getElement(btnNewSubmission));
		_wait(4000);
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		if(dataUmLogIn.getData("PerfTime").equalsIgnoreCase("Yes"))
		{
			elapsedTime = (new Date()).getTime() - startTime; 
			CustomReporting.logReport("Time taken to Complete T01_Click on new submission Transaction :  "+elapsedTime +" ms"); 
			System.out.println("Time taken to Complete T01_Click on new submission Transaction :  "+elapsedTime +" ms");
			_writeToExcel("ResponseTime", "T01_Click on new submission", ""+elapsedTime, tcID);
		}
		String strInsuredName="";
		_wait(4000);
		
		if(func._isVisible(getElement(txtInsuredName))==false)
		{
			_click(getElement(btnNewSubmission));
			_wait(4000);
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			if (dataUmLogIn.getData("PerfTime").equalsIgnoreCase("Yes")) 
			{
				elapsedTime = (new Date()).getTime() - startTime;
				CustomReporting.logReport(
						"Time taken to Complete T01_Click on new submission Transaction :  " + elapsedTime + " ms");
				System.out.println(
						"Time taken to Complete T01_Click on new submission Transaction :  " + elapsedTime + " ms");
				_writeToExcel("ResponseTime", "T01_Click on new submission", "" + elapsedTime, tcID);
			}
		}

		String timeStamp = (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())).replace(".", "");
		if(!dataUmSubDet.getData("DuplicateAccount").equalsIgnoreCase("Yes"))
		 {
			if (dataUmSubDet.getData("UMDuplicateAccount").equalsIgnoreCase("Yes"))
			{
				strInsuredName=dataUmSubDet.getData("Sys_Generate_InsureName") ;
				//strInsuredName=dataPolicyNum.getData("InsName") ;
			}
			else
			{
			strInsuredName=dataUmSubDet.getData("InsuredName") + "_" + timeStamp;
			}
		 }
		else
		{
			if (dataUmSubDet.getData("Submission_Type").equalsIgnoreCase("Renewal")|| tcID.equals("DS_PCI_ALL_Renewal_2"))
			{
				strInsuredName=dataUmSubDet.getData("Sys_Generate_InsureName") ;
				//strInsuredName=dataPolicyNum.getData("InsName") ;
			}
			if (dataUmSubDet.getData("UMDuplicateAccount").equalsIgnoreCase("Yes"))
			{
				strInsuredName=dataUmSubDet.getData("Sys_Generate_InsureName") ;
				//strInsuredName=dataPolicyNum.getData("InsName") ;
			}
		}
		
		if(tcID.equalsIgnoreCase("DS_4_1_ObligeeClrnc_Blk")) 
		{
			strInsuredName=dataUmSubDet.getData("InsuredName") ;
		}
		
		_setValue(getElement(txtInsuredName),strInsuredName );
		
		/*func._writeToExcel("UMSubmissionDetails", "Sys_Generate_InsureName", strInsuredName, tcID);
		Setup.LoadData();*/
		_clickTab();
		/*_writeToExcel("UMSubmissionDetails", "UpdatedInsuredName", dataUmSubDet.getData("InsuredName") + "_" + timeStamp, tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);*/
		_wait(1000);
		func._writeToExcel("SearchPolicy", "InsName", strInsuredName, tcID);
		Setup.LoadData();
		
		//DBA FEIN Start
		if (!dataUmSubDet.getData("DBA_NAME").isEmpty())
		{
				_setValue(getElement(DBA_Name),dataUmSubDet.getData("DBA_NAME")+timeStamp );
				_wait(1000);
				_setValue(getElement(DBA_FEIN),func.generate_RandomNumber(9) );
				_wait(1000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", "DBA Details", "");
		}
		
		
		/*_setValue(getElement(txtProjectName), dataUmSubDet.getData("ProjectName"));
		_wait(1000);
		_setValue(getElement(txtTargetName), dataUmSubDet.getData("TargetName"));
		_wait(2000);*/
		String FirstAddr=dataUmSubDet.getData("Street1") + "_" + timeStamp;
		if (dataUmSubDet.getData("UMDuplicateAccount").equalsIgnoreCase("Yes"))
		{
			 FirstAddr=dataUmSubDet.getData("Street1");
		}
		
		
		
		_setValue(getElement(txtStreet1),FirstAddr );
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		_wait(1000);
		
		if(!dataUmSubDet.getData("Country").equalsIgnoreCase("UNITED STATES"))
		{
			_click(getElement(btn_Country));
			_setValue(getElement(txt_Cuntry), dataUmSubDet.getData("Country"));
			_wait(2000);
			
			String expoption= "/html/body/div[5]/um-dropdown-list//*[text()=\""+dataUmSubDet.getData("Country")+"\"]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			expectedOption.click();
			_wait(3000);
			_click(getElement(txtStreet1));
			ac.moveToElement(getWebDriver().findElement(By.xpath("//div[contains(text(),'Street 1:')]"))).click();
			ac.sendKeys(Keys.PAGE_DOWN).perform();
			/*Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_PAGE_DOWN);
			rb.keyRelease(KeyEvent.VK_PAGE_DOWN);
			func._scrollToElement(getElement(txt_City));*/
			_setValue(getElement(txt_City), dataUmSubDet.getData("City"));
		}
		_setValue(getElement(txtZipCode), dataUmSubDet.getData("ZipCode"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		
		if(tcID.equalsIgnoreCase("DS_Acc_ReAssign_5B"))
		{
			func._writeToExcel("Edit_UMSubmissionDetails", "InsuredName", strInsuredName, tcID);
			func._writeToExcel("Edit_UMSubmissionDetails", "Street1", FirstAddr, tcID);
			func._writeToExcel("Edit_UMSubmissionDetails", "ZipCode", dataUmSubDet.getData("ZipCode"), tcID);
			
		}
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		_wait(5000);
		
		
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		 Date date = new Date();
		 String EffDate="";
		 String expDate="";
		 if (!dataUmSubDet.getData("Submission_Type").equalsIgnoreCase("Renewal"))
		 {
		 
			 if(!dataUmSubDet.getData("EffectiveDate").equals(""))
			 {
				 if(dataUmSubDet.getData("EffectiveDate").contains("-"))
					{
						Thread.sleep(3000);
				    	int offset= Integer.valueOf(dataUmSubDet.getData("EffectiveDate").split("-")[0].trim());
				    	String OptValue=dataUmSubDet.getData("EffectiveDate").split("-")[1].trim();
				    	EffDate=func.Date_Manipulation("",OptValue, offset);
					}
				 else
				 {
					 EffDate=dataUmSubDet.getData("EffectiveDate").replace("'", "");
				 }
			 }
			 else
			 {
				 EffDate=func.Date_Manipulation("","NOW", 0);
			 }
			 if (dataUmSubDet.getData("SlimProducts").equalsIgnoreCase("Yes")) 
			 {
				 _setValue(getClonedElement(txtEffDate) .addToken("tkn_DivNum", "1"),EffDate);
				 _wait(2000);
			 }
			 else
			 {
				 _setValue(getClonedElement(txtEffDate) .addToken("tkn_DivNum", "1"),EffDate);
			 }
		}
		 else
		 {
		 
			 EffDate=dataUmSubDet.getData("RenewalEffDate").replace("'", "");
			 			 
			 if (dataUmSubDet.getData("SlimProducts").equalsIgnoreCase("Yes")) 
			 {
				 _setValue(getClonedElement(txtEffDate) .addToken("tkn_DivNum", "1"),EffDate);
				 _wait(2000);
			 }
			 else
			 {
				 _setValue(getClonedElement(txtEffDate) .addToken("tkn_DivNum", "1"),EffDate);
			 }

		 }
		 
		 if (!dataUmSubDet.getData("Submission_Type").equalsIgnoreCase("Renewal"))
		{
			if (!dataUmSubDet.getData("ExpiryDate").equals(""))
			{
				 expDate=dataUmSubDet.getData("ExpiryDate").replace("'", "");
				if(dataUmSubDet.getData("ExpiryDate").contains("-"))
				{
					Thread.sleep(3000);
			    	int offset= Integer.valueOf(dataUmSubDet.getData("ExpiryDate").split("-")[0].trim());
			    	String OptValue=dataUmSubDet.getData("ExpiryDate").split("-")[1].trim();
			    	if(!EffDate.equals(""))
			    	{
			    		expDate=func.Date_Manipulation(EffDate,OptValue, offset);
			    	}
			    	else
			    	{
			    		expDate=func.Date_Manipulation("",OptValue, offset);	
			    	}
				}
			
			
				 _click(getClonedElement(txtExpiryDate) .addToken("tkn_DivNum", "1"));
				 WebElement ed = (WebElement)getClonedElement(txtExpiryDate) .addToken("tkn_DivNum", "1").getNative();
				 ed.clear();
				 _setValue(getClonedElement(txtExpiryDate) .addToken("tkn_DivNum", "1"), expDate);
			 
			 func._writeToExcel("UMSubmissionDetails", "RenewalEffDate", expDate, tcID);
			}
		}
		 else
		 {
			 if(tcID.equalsIgnoreCase("DS_LPLAdmitted_Renewal_1"))
			 {
				  expDate=dataUmSubDet.getData("RenewalExpDate");
					if(dataUmSubDet.getData("RenewalExpDate").contains("-"))
					{
						Thread.sleep(3000);
				    	int offset= Integer.valueOf(dataUmSubDet.getData("RenewalExpDate").split("-")[0].trim());
				    	String OptValue=dataUmSubDet.getData("RenewalExpDate").split("-")[1].trim();
				    	if(!EffDate.equals(""))
				    	{
				    		expDate=func.Date_Manipulation(EffDate,OptValue, offset);
				    	}
				    	else
				    	{
				    		expDate=func.Date_Manipulation("",OptValue, offset);	
				    	}
					} 
			 }
			 else
			 {
			 if (!dataUmSubDet.getData("RenewalExpDate").equals(""))
				{
					 expDate=dataUmSubDet.getData("RenewalExpDate");
					if(dataUmSubDet.getData("RenewalExpDate").contains("-"))
					{
						Thread.sleep(3000);
				    	int offset= Integer.valueOf(dataUmSubDet.getData("RenewalExpDate").split("-")[0].trim());
				    	String OptValue=dataUmSubDet.getData("RenewalExpDate").split("-")[1].trim();
				    	if(!EffDate.equals(""))
				    	{
				    		expDate=func.Date_Manipulation(EffDate,OptValue, offset);
				    	}
				    	else
				    	{
				    		expDate=func.Date_Manipulation("",OptValue, offset);	
				    	}
					}
				
				}
			 }
			 _click(getClonedElement(txtExpiryDate) .addToken("tkn_DivNum", "1"));
			 WebElement ed = (WebElement)getClonedElement(txtExpiryDate) .addToken("tkn_DivNum", "1").getNative();
			 ed.clear();
			 _setValue(getClonedElement(txtExpiryDate) .addToken("tkn_DivNum", "1"), expDate);
			
		 }
		func._scrollToElement(getElement(chkAssumed1));
		
		if (dataUmSubDet.getData("SlimProducts").equalsIgnoreCase("Yes")) 
		{			
			_wait(2000);
			_click(getElement(chkSlimProducts));
			_wait(4000);
		}
		else
		{
		_wait(2000);
		_click(getElement(chkProducts));
		_wait(4000);
		}
		//Added as Part of R5A For Runn Off : Juned - Start
		if (dataUmSubDet.getData("Submission_Type").equalsIgnoreCase("RunOff"))
		{
			String eff_date_pol = dataUmSubDet.getData("EffectiveDate");
			String Pol_ExpDate = func.Date_Manipulation(eff_date_pol, "DAYS", 1);
			WebElement we = (WebElement)getClonedElement(txtExpiryDate).addToken("tkn_DivNum", "1").getNative();
			we.clear();
			_wait(2000);
			 _setValue(getClonedElement(txtExpiryDate) .addToken("tkn_DivNum", "1"), Pol_ExpDate);
			_wait(2000);
			_click(getElement(RunOff_Yesbtn));
			_wait(2000);
			int duedate_months_runoff=Integer.parseInt(dataUmSubDet.getData("MonthsAfterPolEffDate"));
			String RunOff_ExpDate = func.Date_Manipulation(eff_date_pol, "MONTHS", duedate_months_runoff);
			_setValue(getElement(ExpDate_RunOff), RunOff_ExpDate);
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
		}
		//Added as Part of R5A For Runn Off : Juned - End
		
		if (dataUmSubDet.getData("Submission_Type").equalsIgnoreCase("Renewal"))
		{
			_click(getElement(rd_RenewalYes));
			_wait(4000);
			ac.moveToElement(getWebDriver().findElement(By.xpath("//div[contains(text(),'Street 1:')]"))).click();
			ac.sendKeys(Keys.PAGE_UP).perform();
			 _setValue(getElement(txt_ExpPolicyNum), dataPolicyNum.getData("PolicyNo"));
			 _wait(4000);
			
		}
		
		
		
		
		if (dataUmSubDet.getData("QuoteShare").equalsIgnoreCase("Yes")) {			
			_wait(2000);
			_click(getElement(chkQuoteShareYes));
			_wait(2000);
		}
		func._scrollToElement(getElement(txtEverestLimit));
		if (dataUmSubDet.getData("Excess").equalsIgnoreCase("Yes")) 
		{
			_wait(2000);
			_click(getElement(chkExcess));
			_wait(4000);
		}
	

			_setValue(getElement(txtEverestLimit),dataUmSubDet.getData("EverestLimit")); 
	
			
		
		if (dataUmSubDet.getData("SlimProducts").equalsIgnoreCase("Yes"))
		{			

			if (dataUmSubDet.getData("CON").equalsIgnoreCase("Yes")) {
				_click(getElement(chkCON));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			}
			if (dataUmSubDet.getData("CRD").equalsIgnoreCase("Yes")) {
				_click(getElement(chkCRD));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			}
			if (dataUmSubDet.getData("SLENO").equalsIgnoreCase("Yes")) {
				_click(getElement(chkSLENO));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			}
			if (dataUmSubDet.getData("POL").equalsIgnoreCase("Yes")) {
				_click(getElement(chkPOL));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			}
			if (dataUmSubDet.getData("REP").equalsIgnoreCase("Yes")) {
				_click(getElement(chkREP));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			}
			if (dataUmSubDet.getData("SUR").equalsIgnoreCase("Yes")) {
				_click(getElement(chkSUR));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			}
			if (dataUmSubDet.getData("TAX").equalsIgnoreCase("Yes")) {
				_click(getElement(chkTAX));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			}
			if (dataUmSubDet.getData("SlimProductExcess").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_click(getElement(chkExcess));
				_wait(4000);
			}
			if (!(dataUmSubDet.getData("PolicyCurrency").equals("")))
			{
			_click(getElement(btnPolicyCurrency));
			_setValue(getElement(txtPolicyCurrency), dataUmSubDet.getData("PolicyCurrency"));
			String expoption= "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("PolicyCurrency")+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			expectedOption.click();
			}
			if (dataUmSubDet.getData("Assumed").equalsIgnoreCase("Yes")) {
				_wait(2000);
				_click(getElement(chkAssumed));
				func.setValue9();
			}
			else
			{
			_click(getElement(chkDirect));
			func.setValue9();
			}
			if ((dataUmSubDet.getData("REP").equals("Yes")||dataUmSubDet.getData("SUR").equals("Yes")))
			{
			_click(getElement(btnSPSubtype));
			_wait(5000);
			_setValue(getElement(txtSPSubtype), dataUmSubDet.getData("SPSubtype"));
			_wait(2000);
			String expoption= "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("SPSubtype")+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			expectedOption.click();
			
			if (func._isVisible(getElement(btnSPBondType)) == true)
			{
				_click(getElement(btnSPBondType));
				_wait(5000);	
				_setValue(getElement(txtSPBondType), dataUmSubDet.getData("SPBondType"));
				_wait(5000);
				String expoption1= "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("SPBondType")+"\")]";
				WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
				expectedOption1.click();
					}
			
			}
			func.setValue9();
		}
		
		else
		{
			
			WebElement weCovType=null;
			String strClass="";
			
		if (dataUmSubDet.getData("CRIME").equalsIgnoreCase("Yes")) {
			//_click(getElement(chkCrime));
			_click(getClonedElement(chkCrime).addToken("tkn_divNum", "1"));
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		}
		if (dataUmSubDet.getData("CyberCov").equalsIgnoreCase("Yes")) {
			//_click(getElement(chkCyber));
			_click(getClonedElement(chkCyber).addToken("tkn_divNum", "2"));
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		}
		if (dataUmSubDet.getData("DNO").equalsIgnoreCase("Yes")) {
			//_click(getElement(chkDNO));
			_click(getClonedElement(chkDNO).addToken("tkn_divNum", "3"));
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		}
		if (dataUmSubDet.getData("EMP").equalsIgnoreCase("Yes")) {
			//_click(getElement(chkEMP));
			_click(getClonedElement(chkEMP).addToken("tkn_divNum", "4"));
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		}
		if (dataUmSubDet.getData("ENO").equalsIgnoreCase("Yes")) {
			//_click(getElement(chkENO));
			_click(getClonedElement(chkENO).addToken("tkn_divNum", "5"));
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		}
		if (dataUmSubDet.getData("EPL").equalsIgnoreCase("Yes")) {
			//_click(getElement(chkEPL));
			_click(getClonedElement(chkEPL).addToken("tkn_divNum", "6"));
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		}
		if (dataUmSubDet.getData("FID").equalsIgnoreCase("Yes")) {
			//_click(getElement(chkFID));
			_click(getClonedElement(chkFID).addToken("tkn_divNum", "7"));
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		}
		if (dataUmSubDet.getData("KNR").equalsIgnoreCase("Yes")) {
			//_click(getElement(chkKNR));
			_click(getClonedElement(chkKNR).addToken("tkn_divNum", "8"));
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		}
		}

		if (func._isVisible(getElement(txtEverestAttachmentPoint)) == true)
		{
			_setValue(getElement(txtEverestAttachmentPoint),dataUmSubDet.getData("EverestAttachmentPoint"));
		}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
		_wait(3000);
		if (func._isVisible(getElement(btnENOSubtype)) == true)
		{if (dataUmSubDet.getData("MPL").equalsIgnoreCase("Yes")) {
			_click(getElement(btnENOSubtype));
			_wait(3000);
			String mplvalue ="MPL";
			String expoption = "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+mplvalue+"\")]";
			WebElement expectedOption;
			try {
				expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			} catch (Exception e) {
				ac.moveToElement(getWebDriver().findElement(By.xpath("//div[contains(text(),'Everest Limit:')]"))).click();
				for(int j=0;j<=3;j++)
				{
				 ac.sendKeys(Keys.ARROW_DOWN).perform();
				}
				_click(getElement(btnENOSubtype));
				expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			}		
			expectedOption.click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		}}
		//_click(getElement(rdbPrimary));
		func._waitForPageToLoad(getWebDriver(), 50L);

		if (dataUmSubDet.getData("Assumed").equalsIgnoreCase("Yes")) {
			_wait(2000);
			_click(getElement(chkAssumed));
			func.setValue9();
		}
		else
		{
		_click(getElement(chkDirect));
		func.setValue9();
		}
		PageImplInvoker classInvoker = new PageImplInvoker();
		classInvoker.UmMarketSegment(tcID);
	/*	_wait(8000);
		WebElement weUW=(WebElement)getElement(txtDepartment).getNative();
		weUW.sendKeys(Keys.PAGE_DOWN);
		_wait(8000);*/
		_wait(5000);
		_click(getElement(btnDepartment));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_setValue(getElement(txtDepartment), dataUmSubDet.getData("Department"));
	
		_wait(3000);
		String expoption = "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("Department")+"\")]";
		WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));		
		expectedOption.click();
		_wait(4000);
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		if (dataUmSubDet.getData("Department").equalsIgnoreCase("Financial Institutions")) {
			_wait(5000);
			_click(getElement(btnInsuredType));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_setValue(getElement(txtInsuredType), dataUmSubDet.getData("InsuredType"));
		
			_wait(3000);
			String expoption1 = "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("InsuredType")+"\")]";
			WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));		
			expectedOption1.click();
			_wait(2000);
		}

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		_wait(2000);
		func._scrollToElement(getElement(btnProducerOrganization));
		_click(getElement(btnProducerOrganization));
		_wait(4000);
		_setValue(getElement(txtProducerOrganization), dataUmSubDet.getData("ProducerOrganization"));
		_wait(8000);
		String expoption1= "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("ProducerOrganization")+"\")]";
		WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
		expectedOption1.click();

		_wait(4000);
		func._scrollToElement(getElement(btnAdminContact));
		_wait(2000);
		_click(getElement(btnProducerOffice));
		_wait(5000);
		_setValue(getElement(txtProducerOffice), dataUmSubDet.getData("ProducerOffice"));
		_wait(5000);
		String expoption2= "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("ProducerOffice")+"\")]";
		WebElement expectedOption2 = (getWebDriver().findElement(By.xpath(expoption2)));
		expectedOption2.click();

		_wait(15000);
		func._waitForPageToLoad(getWebDriver(), 50L);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		 _click(getElement(btnProducerContact));
		 _wait(2000);
		 _setValue(getElement(txtProducerContact),dataUmSubDet.getData("ProducerContact"));
	
		 _wait(2000);
			String expoption3= "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("ProducerContact")+"\")]";
			WebElement expectedOption3 = (getWebDriver().findElement(By.xpath(expoption3)));
			expectedOption3.click();
		

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 _wait(4000);
		 
		 if(tcID.equalsIgnoreCase("DS_ItlAdd_RepsWarE")||tcID.equalsIgnoreCase("DS_ItlAdd_EquityE")||tcID.equalsIgnoreCase("DS_ItlAdd_NonHonoringE"))
		 {
			 ac.moveToElement(getWebDriver().findElement(By.xpath("//div[contains(text(),'Producer Office:')]"))).click();
			 ac.sendKeys(Keys.PAGE_UP).perform(); 
			 ac.sendKeys(Keys.PAGE_UP).perform(); 
			 if (func._isVisible(getElement(txtEverestAttachmentPoint)) == true)
				{
					_setValue(getElement(txtEverestAttachmentPoint),dataUmSubDet.getData("EverestAttachmentPoint"));
					func.setValue9();
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 }
		 
		 if(dataUmSubDet.getData("ObligorRequired").equalsIgnoreCase("Yes"))
		 {
			 _setValue(getElement(Obligor_txtbox), dataUmSubDet.getData("ObligorName"));
			 _wait(2000);
			 _click(getElement(Obligor_Country_dropdown));
			 _wait(2000);
			getWebDriver().findElement(By.xpath("//um-dropdown-search/input")).sendKeys(dataUmSubDet.getData("ObligorCountry"));
			_wait(2000);
			getWebDriver().findElement(By.xpath("//um-dropdown-list//*[contains(text(),'"+dataUmSubDet.getData("ObligorCountry")+"')]")).click();
			_wait(2000);
			/*_click(getElement(Obligee_State_dropdown));
			 _wait(2000);*/
			 _setValue(getElement(Obligor_Address), dataUmSubDet.getData("ObligorAddress"));
			 _wait(2000);
			 _setValue(getElement(Obligor_City), dataUmSubDet.getData("ObligorCity"));
			 _wait(2000);
			 _setValue(getElement(Obligor_Postcode), dataUmSubDet.getData("ObligorPostCode"));
			 _wait(2000);
			 _click(getElement(Obligor_CR));
			 _wait(2000);
			getWebDriver().findElement(By.xpath("//um-dropdown-search/input")).sendKeys(dataUmSubDet.getData("ObligorCR"));
			_wait(2000);
			getWebDriver().findElement(By.xpath("//um-dropdown-list//*[contains(text(),'"+dataUmSubDet.getData("ObligorCR")+"')]")).click();
			_wait(2000);
			 
			 
		 }
		 
		 if(dataUmSubDet.getData("ObligeeRequired").equalsIgnoreCase("Yes")) 
		 {
			 _setValue(getElement(Obligee_txtbox), dataUmSubDet.getData("ObligeeName"));
			 _wait(2000);
			 _click(getElement(Obligee_Country_dropdown));
			 _wait(2000);
			getWebDriver().findElement(By.xpath("//um-dropdown-search/input")).sendKeys(dataUmSubDet.getData("ObligeeCountry"));
			_wait(2000);
			getWebDriver().findElement(By.xpath("//um-dropdown-list//*[contains(text(),'"+dataUmSubDet.getData("ObligeeCountry")+"')]")).click();
			_wait(2000);
			/* _click(getElement(Obligee_State_dropdown));
			 _wait(2000);*/
			 _setValue(getElement(Obligee_Address), dataUmSubDet.getData("ObligeeAddress"));
			 _wait(2000);
			 _setValue(getElement(Obligee_City), dataUmSubDet.getData("ObligeeCity"));
			 _wait(2000);
			 _setValue(getElement(Obligee_Postcode), dataUmSubDet.getData("ObligeePostCode"));
			 _wait(2000);
			 _click(getElement(Obligee_CR));
			 _wait(2000);
			getWebDriver().findElement(By.xpath("//um-dropdown-search/input")).sendKeys(dataUmSubDet.getData("ObligeeCR"));
			_wait(2000);
			getWebDriver().findElement(By.xpath("//um-dropdown-list//*[contains(text(),'"+dataUmSubDet.getData("ObligeeCR")+"')]")).click();
			_wait(2000);
			 
			 
		}
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 
		 
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		
		//Create Application 2
		long startTime1 = System.currentTimeMillis();
		long elapsedTime1=0L; 
		
		_click(getElement(btnCreateApplication));
		_wait(5000);
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		if (dataUmLogIn.getData("PerfTime").equalsIgnoreCase("Yes")) 
		{
			elapsedTime1 = (new Date()).getTime() - startTime1;
			CustomReporting.logReport("Time taken to Complete T02_Click on create application Transaction :  "+elapsedTime1 +" ms"); 
			System.out.println("Time taken to Complete T02_Click on create application Transaction :  "+elapsedTime1 +" ms");
			_writeToExcel("ResponseTime", "T02_Click on create application", ""+elapsedTime1, tcID);
		}
		
		
		_wait(5000);

		CustomReporting.logReport("", "", "Application Created successfully!", StepStatus.REPORT,
				new String[] {}, System.currentTimeMillis());
		
		if(tcID.equalsIgnoreCase("DS_4_1_ObligeeClrnc_Blk")) 
		{
			_click(getElement(btnSubmitApplication));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(5000);
			String status = getWebDriver().findElement(By.xpath("//span[contains(@class,'submissionStatusColumn')]")).getText();
			if(status.equalsIgnoreCase("Not Clear")) {
				
				CustomReporting.logReport("", "", "Submission is Blocked as expected due to same Obligee Details", StepStatus.SUCCESS,
						new String[] {}, startTime);
			}else {
				CustomReporting.logReport("", "", "Submission is NOT Blocked Even After Giving same Obligee Details", StepStatus.FAILURE,
						new String[] {}, startTime);
			}
		}

		
	}


	@Override
	public void updateTheCreatedApplication(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUpdateSubmission = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		String timeStamp = (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())).replace(".", "");
		
		
		_setValue(getElement(txtStreet1), dataUpdateSubmission.getData("Street1") + "_" + timeStamp);
		
		_wait(5000);
		
		PageImplInvoker classInvoker = new PageImplInvoker();
		classInvoker.UpdateUmMarketSegment(tcID);
		
		
		func._scrollToElement(getElement(btnProducerOffice));
		_wait(2000);
		_click(getElement(btnProducerOffice));
		_wait(10000);
		_setValue(getElement(txtProducerOffice), dataUpdateSubmission.getData("ProducerOffice"));
		_wait(5000);
		String expoption2= "//um-dropdown-list//*[contains(text(),\""+dataUpdateSubmission.getData("ProducerOffice")+"\")]";
		WebElement expectedOption2 = (getWebDriver().findElement(By.xpath(expoption2)));
		expectedOption2.click();
		
		_click(getElement(btnProducerContact));
		 _wait(2000);
		 _setValue(getElement(txtProducerContact),dataUpdateSubmission.getData("ProducerContact"));
	
		 _wait(2000);
			String expoption3= "//um-dropdown-list//*[contains(text(),\""+dataUpdateSubmission.getData("ProducerContact")+"\")]";
			WebElement expectedOption3 = (getWebDriver().findElement(By.xpath(expoption3)));
			expectedOption3.click();

	}
	
	@Override
	public void VerifyTheUpdatedFieldValue(String tcID, SoftAssert softAssert) throws Exception {
		
		long startTime = System.currentTimeMillis();
		PageData dataUpdateSubmission = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		getWebDriver().findElement(By.xpath("//span[text()='Submission']")).click();
		
		_wait(5000);
		
        String actualProducerOfficer=((WebElement)getElement(btnProducerOffice).getNative()).getText();
		if(actualProducerOfficer.contains(dataUpdateSubmission.getData("ProducerOffice"))) {
			
			CustomReporting.logReport("", "", "Actual ProducerOffice Value: " + actualProducerOfficer + "is as expected", StepStatus.SUCCESS, new String[] {},
					startTime);
		}else {
			
			CustomReporting.logReport("", "", "Actual ProducerOffice Value: " + actualProducerOfficer + "is not as expected", StepStatus.FAILURE, new String[] {},
					startTime);
		}
		
		 String actualStreet1Value=((WebElement)getElement(txtStreet1).getNative()).getText();
			if(actualProducerOfficer.contains(dataUpdateSubmission.getData("ProducerOffice"))) {
				
				CustomReporting.logReport("", "", "Actual Street1 Value: " + actualStreet1Value + "is as expected", StepStatus.SUCCESS, new String[] {},
						startTime);
			}else {
				
				CustomReporting.logReport("", "", "Actual Street1 Value: " + actualStreet1Value + "is not as expected", StepStatus.FAILURE, new String[] {},
						startTime);
			}
					
			PageImplInvoker classInvoker = new PageImplInvoker();
			classInvoker.verifyUmMarketSegment(tcID);
			
			getWebDriver().findElement(By.xpath("//span[text()='Rating: Submission Information']")).click();
			
			_wait(5000);
			

	}
	
	@Override
	public void edit_UmSubmissionDetails(String tcID, SoftAssert softAssert) throws Exception {
		
		PageData dataUmSubDet = PageDataManager.instance().getPageData("Edit_UMSubmissionDetails", tcID);
		if(!dataUmSubDet.getData("tcID_BC_PartB").equals(""))
		{
			dataUmSubDet = PageDataManager.instance().getPageData("Edit_UMSubmissionDetails", dataUmSubDet.getData("tcID_BC_PartB"));
		}
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		String strURL = "";
		_wait(4000);
		_click(getElement(tab_Submission));
		
		//New Submission 1
		long startTime = System.currentTimeMillis();
		long elapsedTime=0L;
		
		
		_wait(10000);
		
		

		String timeStamp = (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())).replace(".", "");

		if(!dataUmSubDet.getData("InsuredName").equals(""))
		{
			String strInsureName="";
			
			if(!dataUmSubDet.getData("DuplicateAccount").equals("Yes"))
			{	
			 strInsureName=dataUmSubDet.getData("InsuredName") + "_" + timeStamp;
			}
			else
			{
			 strInsureName=dataUmSubDet.getData("InsuredName");
			}
		_setValue(getElement(txtInsuredName), strInsureName);
		_clickTab();
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		func._writeToExcel("Edit_UMSubmissionDetails", "TempInsuredName", strInsureName, tcID);
		}
		if(!dataUmSubDet.getData("ProjectName").equals(""))
		{
			_setValue(getElement(txtProjectName), dataUmSubDet.getData("ProjectName"));
			_wait(1000);	
		}
		if(!dataUmSubDet.getData("Street1").equals(""))
		{
			
			String strFirstAddr1=dataUmSubDet.getData("Street1");
			_setValue(getElement(txtStreet1),strFirstAddr1 );
			func._waitForPageToLoad(getWebDriver(), 50L);

			_wait(1000);
			func._writeToExcel("Edit_UMSubmissionDetails", "System_generate_Addr1", strFirstAddr1, tcID);
		}
		
		if(!dataUmSubDet.getData("ZipCode").equals(""))
		{
			_setValue(getElement(txtZipCode), dataUmSubDet.getData("ZipCode"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(1000);
		}
		
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		_wait(5000);
		
		
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		 Date date = new Date();
		 
		 if(!dataUmSubDet.getData("EffectiveDate").equals(""))
			{
			
			 _setValue(getClonedElement(txtEffDate) .addToken("tkn_DivNum", "2"),dataUmSubDet.getData("EffectiveDate"));
			 _wait(2000);
			}
				
			
		 
		 if (!dataUmSubDet.getData("ExpiryDate").equals(""))
			{
				 _click(getElement(txtExpiryDate));
				WebElement ed = (WebElement)getClonedElement(txtExpiryDate) .addToken("tkn_DivNum", "2").getNative();
				ed.clear();
				
				 
				 _setValue(getClonedElement(txtExpiryDate) .addToken("tkn_DivNum", "2"),dataUmSubDet.getData("ExpiryDate"));
				 _wait(2000);
				 
			}
		func._scrollToElement(getElement(chkAssumed1));
		
		
		if(!dataUmSubDet.getData("QuoteShare").equals(""))
		{
		if (dataUmSubDet.getData("QuoteShare").equalsIgnoreCase("Yes")) {			
			_wait(2000);
			_click(getElement(chkQuoteShareYes));
			_wait(2000);
		}
		}
		func._scrollToElement(getElement(txtEverestLimit));
		if(!dataUmSubDet.getData("Excess").equals(""))
		{
		if (dataUmSubDet.getData("Excess").equalsIgnoreCase("Yes")) {
			_wait(2000);
			_click(getElement(chkExcess));
			_wait(4000);
		}
		}
	
		if(!dataUmSubDet.getData("EverestLimit").equals(""))
		{
			_setValue(getElement(txtEverestLimit),dataUmSubDet.getData("EverestLimit")); 
	
		}
		
		if(!dataUmSubDet.getData("SlimProducts").equals(""))
		{
			if (dataUmSubDet.getData("SlimProducts").equalsIgnoreCase("Yes")) {			
	
				if (dataUmSubDet.getData("CON").equalsIgnoreCase("Yes")) {
					_click(getElement(chkCON));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
				}
				if (dataUmSubDet.getData("CRD").equalsIgnoreCase("Yes")) {
					_click(getElement(chkCRD));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
				}
				if (dataUmSubDet.getData("SLENO").equalsIgnoreCase("Yes")) {
					_click(getElement(chkSLENO));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
				}
				if (dataUmSubDet.getData("POL").equalsIgnoreCase("Yes")) {
					_click(getElement(chkPOL));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
				}
				if (dataUmSubDet.getData("REP").equalsIgnoreCase("Yes")) {
					_click(getElement(chkREP));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
				}
				if (dataUmSubDet.getData("SUR").equalsIgnoreCase("Yes")) {
					_click(getElement(chkSUR));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
				}
				if (dataUmSubDet.getData("TAX").equalsIgnoreCase("Yes")) {
					_click(getElement(chkTAX));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
				}
				if (dataUmSubDet.getData("SlimProductExcess").equalsIgnoreCase("Yes")) {
					_wait(2000);
					_click(getElement(chkExcess));
					_wait(4000);
				}
				if (!(dataUmSubDet.getData("PolicyCurrency").equals("")))
				{
				_click(getElement(btnPolicyCurrency));
				_setValue(getElement(txtPolicyCurrency), dataUmSubDet.getData("PolicyCurrency"));
				String expoption= "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("PolicyCurrency")+"\")]";
				WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
				expectedOption.click();
				}
				if (dataUmSubDet.getData("Assumed").equalsIgnoreCase("Yes")) {
					_wait(2000);
					_click(getElement(chkAssumed));
					func.setValue9();
				}
				else
				{
				_click(getElement(chkDirect));
				func.setValue9();
				}
				if ((dataUmSubDet.getData("REP").equals("Yes")||dataUmSubDet.getData("SUR").equals("Yes")))
				{
				_click(getElement(btnSPSubtype));
				_wait(5000);
				_setValue(getElement(txtSPSubtype), dataUmSubDet.getData("SPSubtype"));
				_wait(2000);
				String expoption= "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("SPSubtype")+"\")]";
				WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
				expectedOption.click();
				
				
				if (func._isVisible(getElement(btnSPBondType)) == true)
				{
					_click(getElement(btnSPBondType));
					_wait(5000);	
					_setValue(getElement(txtSPBondType), dataUmSubDet.getData("SPBondType"));
					_wait(5000);
					String expoption1= "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("SPBondType")+"\")]";
					WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
					expectedOption1.click();
						}
				
				}
				func.setValue9();
			}
			else
			{
				WebElement weCovType=null;
				String strClass="";
				
			if (dataUmSubDet.getData("CRIME").equalsIgnoreCase("Yes")) {
				weCovType=(WebElement)getClonedElement(chk_editCRM).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(strClass.contains("ng-empty"))
				{
				_click(getClonedElement(chk_editCRM).addToken("tkn_divNum", "2"));
				_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			if (dataUmSubDet.getData("CRIME").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkCrime).addToken("tkn_divNum", "2").getNative();
				strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
				{
					
					_click(getClonedElement(chkCrime).addToken("tkn_divNum", "2"));
					_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			if (dataUmSubDet.getData("CyberCov").equalsIgnoreCase("Yes")) {
				
				weCovType=(WebElement)getClonedElement(chkCyber).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(strClass.contains("ng-empty"))
				{
					_click(getClonedElement(chkCyber).addToken("tkn_divNum", "2"));
					_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			if (dataUmSubDet.getData("CyberCov").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkCyber).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
				{
					_click(getClonedElement(chkCyber).addToken("tkn_divNum", "2"));
					_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			if (dataUmSubDet.getData("DNO").equalsIgnoreCase("Yes")) {
				
				weCovType=(WebElement)getClonedElement(chkDNO).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(strClass.contains("ng-empty"))
				{
					_click(getClonedElement(chkDNO).addToken("tkn_divNum", "2"));
					_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			if (dataUmSubDet.getData("DNO").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkDNO).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
				{
					_click(getClonedElement(chkDNO).addToken("tkn_divNum", "2"));
					_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
		    if (dataUmSubDet.getData("EMP").equalsIgnoreCase("Yes")) {
				
				weCovType=(WebElement)getClonedElement(chkEMP).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(strClass.contains("ng-empty"))
				{
					_click(getClonedElement(chkEMP).addToken("tkn_divNum", "2"));
					_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			if (dataUmSubDet.getData("EMP").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkEMP).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
				{
					_click(getClonedElement(chkEMP).addToken("tkn_divNum", "2"));
					_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			
			if (dataUmSubDet.getData("ENO").equalsIgnoreCase("Yes")) {
				
				weCovType=(WebElement)getClonedElement(chkENO).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(strClass.contains("ng-empty"))
				{
					_click(getClonedElement(chkENO).addToken("tkn_divNum", "2"));
					_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			if (dataUmSubDet.getData("ENO").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkENO).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
				{
					_click(getClonedElement(chkENO).addToken("tkn_divNum", "2"));
					_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			if (dataUmSubDet.getData("EPL").equalsIgnoreCase("Yes")) {
				
				weCovType=(WebElement)getClonedElement(chkEPL).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(strClass.contains("ng-empty"))
				{
					_click(getClonedElement(chkEPL).addToken("tkn_divNum", "2"));
					_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			if (dataUmSubDet.getData("EPL").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkEPL).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
				{
					_click(getClonedElement(chkEPL).addToken("tkn_divNum", "2"));
					_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			
			if (dataUmSubDet.getData("FID").equalsIgnoreCase("Yes")) {
				
				weCovType=(WebElement)getClonedElement(chkFID).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(strClass.contains("ng-empty"))
				{
					_click(getClonedElement(chkFID).addToken("tkn_divNum", "2"));
					_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			if (dataUmSubDet.getData("FID").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkFID).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
				{
					_click(getClonedElement(chkFID).addToken("tkn_divNum", "2"));
					_wait(2000);
					
					while(!weCovType.getAttribute("class").contains("ng-empty"))
					{     
						_click(getClonedElement(chkFID).addToken("tkn_divNum", "2"));
						_wait(2000);
					}
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			
		if (dataUmSubDet.getData("KNR").equalsIgnoreCase("Yes")) {
				
				weCovType=(WebElement)getClonedElement(chkKNR).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(strClass.contains("ng-empty"))
				{
					_click(getClonedElement(chkKNR).addToken("tkn_divNum", "2"));
					_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			if (dataUmSubDet.getData("KNR").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkKNR).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
				{
					_click(getClonedElement(chkKNR).addToken("tkn_divNum", "2"));
					_wait(2000);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			
						}
		}
		
		if (func._isVisible(getElement(txtEverestAttachmentPoint)) == true &&(! dataUmSubDet.getData("EverestAttachmentPoint").equals(""))) 
		{
			_setValue(getElement(txtEverestAttachmentPoint),dataUmSubDet.getData("EverestAttachmentPoint"));
		}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
		_wait(10000);
		if (func._isVisible(getElement(btnENOSubtype)) == true)
		{
		if (dataUmSubDet.getData("MPL").equalsIgnoreCase("Yes") &&(!dataUmSubDet.getData("MPL").equals(""))) {
			_click(getElement(btnENOSubtype));
			_wait(3000);
			String mplvalue ="MPL";
			String expoption = "//um-dropdown-list//*[contains(text(),\""+mplvalue+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));		
			expectedOption.click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		}
		}
		//_click(getElement(rdbPrimary));
		/*func._waitForPageToLoad(getWebDriver(), 50L);

		if(!dataUmSubDet.getData("MarketSegment").equals(""))
		{
		PageImplInvoker classInvoker = new PageImplInvoker();
		classInvoker.UmMarketSegment(tcID);
		}*/
		if(!dataUmSubDet.getData("Department").equals(""))
		{
			_click(getElement(btnDepartment));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_setValue(getElement(txtDepartment), dataUmSubDet.getData("Department"));
	
			_wait(3000);
			String expoption = "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("Department")+"\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));		
			expectedOption.click();
			_wait(4000);
			func._waitForPageToLoad(getWebDriver(), 50L);
		}
		
		if (dataUmSubDet.getData("Department").equalsIgnoreCase("Financial Institutions")) {
			_wait(5000);
			_click(getElement(btnInsuredType));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_setValue(getElement(txtInsuredType), dataUmSubDet.getData("InsuredType"));
		
			_wait(3000);
			String expoption1 = "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("InsuredType")+"\")]";
			WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));		
			expectedOption1.click();
			_wait(2000);
		}

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		_wait(2000);
		if(!dataUmSubDet.getData("ProducerOrganization").equals(""))
		{
			func._scrollToElement(getElement(btnProducerOrganization));
			_click(getElement(btnProducerOrganization));
			_wait(4000);
			_setValue(getElement(txtProducerOrganization), dataUmSubDet.getData("ProducerOrganization"));
			_wait(8000);
			String expoption1= "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("ProducerOrganization")+"\")]";
			WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
			expectedOption1.click();

			_wait(4000);
		}
		func._scrollToElement(getElement(btnAdminContact));
		_wait(2000);
		
		if(!dataUmSubDet.getData("ProducerOffice").equals(""))
		{
			_click(getElement(btnProducerOffice));
			_wait(2000);
			_setValue(getElement(txtProducerOffice), dataUmSubDet.getData("ProducerOffice"));
			_wait(5000);
			String expoption2= "//um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("ProducerOffice")+"\")]";
			WebElement expectedOption2 = (getWebDriver().findElement(By.xpath(expoption2)));
			expectedOption2.click();
	
			_wait(6000);
			func._waitForPageToLoad(getWebDriver(), 50L);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}

		if(!dataUmSubDet.getData("ProducerContact").equals(""))
		{
		 _click(getElement(btnProducerContact));
		 _wait(2000);
		 _setValue(getElement(txtProducerContact),dataUmSubDet.getData("ProducerContact"));
	
		 _wait(2000);
			String expoption3= "//um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("ProducerContact")+"\")]";
			WebElement expectedOption3 = (getWebDriver().findElement(By.xpath(expoption3)));
			expectedOption3.click();
		

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 _wait(4000);
		}
		//Create Application 2
		long startTime1 = System.currentTimeMillis();
		long elapsedTime1=0L; 
		
		//_click(getElement(btnCreateApplication));
		
		/*w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		elapsedTime1 = (new Date()).getTime() - startTime1;
		CustomReporting.logReport("Time taken to Complete T02_Click on create application Transaction :  "+elapsedTime1 +" ms"); 
		System.out.println("Time taken to Complete T02_Click on create application Transaction :  "+elapsedTime1 +" ms");
		_writeToExcel("ResponseTime", "T02_Click on create application", ""+elapsedTime1, tcID);
		*/
		_wait(5000);

		CustomReporting.logReport("", "", "Submission details updated successfully!", StepStatus.REPORT,
				new String[] {}, System.currentTimeMillis());
		
if(!((getWebDriver().findElements(By.xpath("(//div[contains(@class,'navigationRow pro')]//button)[2]")).size()==0))) {
			
			int i=0;
		while(((getWebDriver().findElements(By.xpath("//button[@ng-click='openNavItem($event, secondLevelItem)']")).size()==0)) && i<=3) {
			
		getWebDriver().findElement(By.xpath("(//div[contains(@class,'navigationRow pro')]//button)[2]")).click();
		
		_wait(2000);
		
		i++;
		}
		
		if((!((getWebDriver().findElements(By.xpath("//button[@ng-click='openNavItem($event, secondLevelItem)']")).size()==0))) &&
				(getWebDriver().findElements(By.xpath("//span[text()='Rating: Submission Information']")).size()==0)) {
			
			getWebDriver().findElement(By.xpath("//button[@ng-click='openNavItem($event, secondLevelItem)']")).click();
			_wait(2000);
		}
		

		if(!((getWebDriver().findElements(By.xpath("//span[text()='Rating: Submission Information']")).size()==0))) {
			
			getWebDriver().findElement(By.xpath("//span[text()='Rating: Submission Information']")).click();
			
			_wait(2000);
		}
		
}else {
	if(!((getWebDriver().findElements(By.xpath("(//button[contains(@class,'btn-link glyphicon glyphicon-chevron-right ng-scope')])[1]")).size()==0))) {
	
	int i=0;
while(((getWebDriver().findElements(By.xpath("//span[text()='Rating:Slim Common']")).size()==0)) && i<=3) {
	
getWebDriver().findElement(By.xpath("(//button[contains(@class,'btn-link glyphicon glyphicon-chevron-right ng-scope')])[1]")).click();

_wait(2000);

if(getWebDriver().findElements(By.xpath("//span[text()='Rating:Slim Common']")).size()>0) {

getWebDriver().findElement(By.xpath("//span[text()='Rating:Slim Common']")).click();
}
i++;
}
if(getWebDriver().findElements(By.xpath("//span[text()='Rating:Slim Common']")).size()>0) {
getWebDriver().findElement(By.xpath("//span[text()='Rating:Slim Common']")).click();
}
_wait(4000);

}
	}
		
	}
	
	@Override
	public void verify_UmSubmissionDetails(String tcID, SoftAssert softAssert) throws Exception
	{
		
		PageData dataUmSubDet = PageDataManager.instance().getPageData("Edit_UMSubmissionDetails", tcID);
		PageData dataUmMarketSegment = PageDataManager.instance().getPageData("UmMarketSegment", tcID);
		PageData dataAddOffice = PageDataManager.instance().getPageData("UmAddingOffice", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		Setup.LoadData();
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		String strURL = "";
		_wait(4000);
		_click(getElement(tab_Submission));
		_wait(20000);
		/*Robot robt=new Robot();
		WebElement weTable1 = (WebElement)getElement(tab_Submission).getNative();
		 
		 
		 int x=weTable1.getLocation().getX()+100;
		 int y=weTable1.getLocation().getY()+200;
		 robt.mouseMove(x, y);
		
		 _wait(2000);
		
		robt.keyPress(KeyEvent.VK_HOME);
		robt.keyRelease(KeyEvent.VK_HOME);*/
		
		 Actions actions = new Actions(getWebDriver());
	     actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
	     
	     _wait(4000);
		
		if(!dataUmSubDet.getData("TempInsuredName").equals(""))
		{
			WebElement weInsName=(WebElement)getElement(txtInsuredName).getNative();
			String InsureName=weInsName.getAttribute("value").trim();
			if(dataUmSubDet.getData("TempInsuredName").trim().equalsIgnoreCase(InsureName))
			{
		    	CustomReporting.logReport("","","Verified isnured name successfully updated",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Insured name is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		}
		
		if(!dataUmSubDet.getData("System_generate_Addr1").equals(""))
		{
			WebElement weInsAddr=(WebElement)getElement(txtStreet1).getNative();
			String InsAddress=weInsAddr.getAttribute("value").trim();
			if(dataUmSubDet.getData("System_generate_Addr1").trim().equalsIgnoreCase(InsAddress))
			{
		    	CustomReporting.logReport("","","Verified isnured address1 successfully updated",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Insured address1 is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		}
		
		if(!dataUmSubDet.getData("ZipCode").equals(""))
		{
			WebElement weZipCode=(WebElement)getElement(txtZipCode).getNative();
			String ZipCode=weZipCode.getAttribute("value").trim();
			if(dataUmSubDet.getData("ZipCode").trim().equalsIgnoreCase(ZipCode))
			{
		    	CustomReporting.logReport("","","Verified isnured ZipCode successfully updated",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Insured ZipCode is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		}
		
		if(!dataUmSubDet.getData("EffectiveDate").equals(""))
		{
			WebElement weEffDate=(WebElement)getClonedElement(txtEffDate).addToken("tkn_DivNum", "").getNative();//getElement(txtEffDate).getNative();
			String strEffDate=weEffDate.getAttribute("value").trim();
			strEffDate=strEffDate+"20";
			if(dataUmSubDet.getData("EffectiveDate").trim().equalsIgnoreCase(strEffDate))
			{
		    	CustomReporting.logReport("","","Verified effective date successfully updated",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Insured effective date is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		}
		if(!dataUmSubDet.getData("ExpiryDate").equals(""))
		{
			WebElement weEffDate=(WebElement)getElement(txtExpiryDate).getNative();
			String strEffDate=weEffDate.getAttribute("value").trim();
			strEffDate=strEffDate+"00";
			if(dataUmSubDet.getData("ExpiryDate").trim().equalsIgnoreCase(strEffDate))
			{
		    	CustomReporting.logReport("","","Verified expairy date successfully updated",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Insured expairy date is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		}
		/*WebElement weTable11 = (WebElement)getElement(tab_Submission).getNative();
		 
		 
		  x=weTable11.getLocation().getX()+100;
		  y=weTable11.getLocation().getY()+200;
		 robt.mouseMove(x, y);
		 robt.keyPress(KeyEvent.VK_PAGE_DOWN);
		 robt.keyRelease(KeyEvent.VK_PAGE_DOWN);*/
		

        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("window.scrollBy(0,1000)");
       
		//WebElement weExpDt=(WebElement)getElement(txtStreet1).getNative();
//		weExpDt.sendKeys(Keys.PAGE_DOWN);
		//func._scrollToElement(getElement(txtZipCode));
		if(!dataUmSubDet.getData("Excess").equals(""))
		{
			if (dataUmSubDet.getData("Excess").equalsIgnoreCase("Yes")) {
				_wait(2000);
				String weChecked=getElement(chkExcess).getAttribute("class");
				if(weChecked.equals("ng-valid-parse"))
					
					{
				    	CustomReporting.logReport("","","Verified Excess redio button selected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				    }
				    else
				    {
				    	CustomReporting.logReport("","", "Excess redio button is not selected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				    	//throw new RuntimeException();
				    }
				
			}
			if (dataUmSubDet.getData("Excess").equalsIgnoreCase("No")) {
				_wait(2000);
				String weChecked=getElement(chkExcess).getAttribute("class");
				if(!weChecked.equals("ng-valid-parse"))
					
					{
				    	CustomReporting.logReport("","","Verified Excess redio button deselected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				    }
				    else
				    {
				    	CustomReporting.logReport("","", "Excess redio button is not deselected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				    	//throw new RuntimeException();
				    }
				
			}
		}
		if(!dataUmSubDet.getData("Excess").equals(""))
		{
			if (dataUmSubDet.getData("Excess").equalsIgnoreCase("Yes")) {
				_wait(2000);
				String weChecked=getElement(chkExcess).getAttribute("class");
				if(weChecked.equals("ng-valid-parse"))
					
					{
				    	CustomReporting.logReport("","","Verified Excess redio button selected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				    }
				    else
				    {
				    	CustomReporting.logReport("","", "Excess redio button is not selected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				    	//throw new RuntimeException();
				    }
				
			}
			if (dataUmSubDet.getData("Excess").equalsIgnoreCase("No")) {
				_wait(2000);
				String weChecked=getElement(chkExcess).getAttribute("class");
				if(!weChecked.equals("ng-valid-parse"))
					
					{
				    	CustomReporting.logReport("","","Verified Excess redio button deselected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				    }
				    else
				    {
				    	CustomReporting.logReport("","", "Excess redio button is not deselected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				    	//throw new RuntimeException();
				    }
				
			}
		}
	
	
		if(!dataUmSubDet.getData("EverestLimit").equals(""))
		{
			String strEverestLimit=getElement(txtEverestLimit).getAttribute("value");
			if(!strEverestLimit.equals(dataUmSubDet.getData("EverestLimit")))
				
				{
			    	CustomReporting.logReport("","","Verified EverestLimit field value updated successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "EverestLimit field value is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    	//throw new RuntimeException();
			    }
			
	
		}
		
		_wait(4000);
		//func._scrollToElement(getElement(chkExcess));
		//_wait(4000);
		
		if(!dataUmSubDet.getData("SlimProducts").equals(""))
		{
			if (dataUmSubDet.getData("SlimProducts").equalsIgnoreCase("Yes")) {			
	
				if (dataUmSubDet.getData("CON").equalsIgnoreCase("Yes")) {
					_click(getElement(chkCON));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
				}
				if (dataUmSubDet.getData("CRD").equalsIgnoreCase("Yes")) {
					_click(getElement(chkCRD));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
				}
				if (dataUmSubDet.getData("SLENO").equalsIgnoreCase("Yes")) {
					_click(getElement(chkSLENO));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
				}
				if (dataUmSubDet.getData("POL").equalsIgnoreCase("Yes")) {
					_click(getElement(chkPOL));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
				}
				if (dataUmSubDet.getData("REP").equalsIgnoreCase("Yes")) {
					_click(getElement(chkREP));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
				}
				if (dataUmSubDet.getData("SUR").equalsIgnoreCase("Yes")) {
					_click(getElement(chkSUR));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
				}
				if (dataUmSubDet.getData("TAX").equalsIgnoreCase("Yes")) {
					_click(getElement(chkTAX));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
				}
				if (dataUmSubDet.getData("SlimProductExcess").equalsIgnoreCase("Yes")) {
					_wait(2000);
					_click(getElement(chkExcess));
					_wait(4000);
				}
				if (!(dataUmSubDet.getData("PolicyCurrency").equals("")))
				{
				_click(getElement(btnPolicyCurrency));
				_setValue(getElement(txtPolicyCurrency), dataUmSubDet.getData("PolicyCurrency"));
				String expoption= "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("PolicyCurrency")+"\")]";
				WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
				expectedOption.click();
				}
				if(!dataUmSubDet.getData("Assumed").equalsIgnoreCase(""))
				{
				
					if (dataUmSubDet.getData("Assumed").equalsIgnoreCase("Yes")) {
						_wait(2000);
						_click(getElement(chkAssumed));
						func.setValue9();
					}
					else
					{
					_click(getElement(chkDirect));
					func.setValue9();
					}
				}
				if ((dataUmSubDet.getData("REP").equals("")||dataUmSubDet.getData("SUR").equals("")))
				{
					if ((dataUmSubDet.getData("REP").equals("Yes")||dataUmSubDet.getData("SUR").equals("Yes")))
					{
					_click(getElement(btnSPSubtype));
					_wait(5000);
					_setValue(getElement(txtSPSubtype), dataUmSubDet.getData("SPSubtype"));
					_wait(2000);
					String expoption= "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("SPSubtype")+"\")]";
					WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
					expectedOption.click();
					
					
					if (func._isVisible(getElement(btnSPBondType)) == true)
					{
						_click(getElement(btnSPBondType));
						_wait(5000);	
						_setValue(getElement(txtSPBondType), dataUmSubDet.getData("SPBondType"));
						_wait(5000);
						String expoption1= "/html/body/div[5]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("SPBondType")+"\")]";
						WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
						expectedOption1.click();
							}
					
					}
					func.setValue9();
				}
			}
			else
			{
				_wait(10000);
				WebElement weCovType=null;
				String strClass="";
				
			if (dataUmSubDet.getData("CRIME").equalsIgnoreCase("Yes")) {
				weCovType=(WebElement)getClonedElement(chk_editCRM).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
										
					{
				    	CustomReporting.logReport("","","Verified CRIME coverages type is selected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				    }
				    else
				    {
				    	CustomReporting.logReport("","", "CRIME coverages type is not selected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				    	//throw new RuntimeException();
				    }
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
			if (dataUmSubDet.getData("CRIME").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkCrime).addToken("tkn_divNum", "2").getNative();
				strClass=weCovType.getAttribute("class");
				if(strClass.contains("ng-empty"))
				{
			    	CustomReporting.logReport("","","Verified CRIME coverages type is deselected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "CRIME coverages type is not deselected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    	//throw new RuntimeException();
			    }
	
			}
			if (dataUmSubDet.getData("CyberCov").equalsIgnoreCase("Yes")) {
				
				weCovType=(WebElement)getClonedElement(chkCyber).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
				{
			    	CustomReporting.logReport("","","Verified CYBER coverages type is selected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "CYBER coverages type is not selected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    	//throw new RuntimeException();
			    }
	
			}
			if (dataUmSubDet.getData("CyberCov").equalsIgnoreCase("No")) {
			    WebElement weCovType1=null;
			    if(func._isVisible(getClonedElement(chkCyber).addToken("tkn_divNum", "2"))){
			    	
			    	weCovType1=(WebElement)getClonedElement(chkCyber).addToken("tkn_divNum", "2").getNative();
			    	
			    }
			    else {
			    	

			    	
			    	weCovType1=getWebDriver().findElement(By.xpath("//ui-form-viewer/div/div[2]/div[3]/ui-row[10]/div/checkbox-group/div/div/label[2]/input"));
			    	
			   
			    }
				 strClass=weCovType1.getAttribute("class");
				if(strClass.contains("ng-empty"))
				{
			    	CustomReporting.logReport("","","Verified CYBER coverages type is deselected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "CYBER coverages type is not deselected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    	//throw new RuntimeException();
			    }
	
			}
			if (dataUmSubDet.getData("DNO").equalsIgnoreCase("Yes")) {
				
				weCovType=(WebElement)getClonedElement(chkDNO).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
				{
			    	CustomReporting.logReport("","","Verified DNO coverages type is selected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "DNO coverages type is not selected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    	//throw new RuntimeException();
			    }
	
			}
			if (dataUmSubDet.getData("DNO").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkDNO).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(strClass.contains("ng-empty"))
				{
			    	CustomReporting.logReport("","","Verified DNO coverages type is deselected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "DNO coverages type is not deselected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    	//throw new RuntimeException();
			    }
	
			}
		    if (dataUmSubDet.getData("EMP").equalsIgnoreCase("Yes")) {
				
				weCovType=(WebElement)getClonedElement(chkEMP).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
				{
			    	CustomReporting.logReport("","","Verified EMP coverages type is selected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "EMP coverages type is not selected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    	//throw new RuntimeException();
			    }
	
			}
			if (dataUmSubDet.getData("EMP").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkEMP).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(strClass.contains("ng-empty"))
				{
			    	CustomReporting.logReport("","","Verified EMP coverages type is deselected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "EMP coverages type is not deselected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    	//throw new RuntimeException();
			    }
	
			}
			
			if (dataUmSubDet.getData("ENO").equalsIgnoreCase("Yes")) {
				
				weCovType=(WebElement)getClonedElement(chkENO).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
				{
			    	CustomReporting.logReport("","","Verified ENO coverages type is selected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "ENO coverages type is not selected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    	//throw new RuntimeException();
			    }
	
			}
			if (dataUmSubDet.getData("ENO").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkENO).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(strClass.contains("ng-empty"))
				{
			    	CustomReporting.logReport("","","Verified ENO coverages type is deselected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "ENO coverages type is not deselected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    	//throw new RuntimeException();
			    }
			}
			if (dataUmSubDet.getData("EPL").equalsIgnoreCase("Yes")) {
				
				weCovType=(WebElement)getClonedElement(chkEPL).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
			{
			    	CustomReporting.logReport("","","Verified EPL coverages type is selected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
			    			    {
			    	CustomReporting.logReport("","", "EPL coverages type is not selected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    	//throw new RuntimeException();
			    }
	
			}
			if (dataUmSubDet.getData("EPL").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkEPL).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(strClass.contains("ng-empty"))
				{
			    	CustomReporting.logReport("","","Verified EPL coverages type is deselected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "EPL coverages type is not deselected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    	//throw new RuntimeException();
			    }
	
			}
			
			if (dataUmSubDet.getData("FID").equalsIgnoreCase("Yes")) {
				
				weCovType=(WebElement)getClonedElement(chkFID).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				if(!strClass.contains("ng-empty"))
				{
			    	CustomReporting.logReport("","","Verified FID coverages type is selected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "FID coverages type is not selected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    	//throw new RuntimeException();
			    }
	
			}
			if (dataUmSubDet.getData("FID").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkFID).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				 
					if(strClass.contains("ng-empty"))
					{
				    	CustomReporting.logReport("","","Verified FID coverages type is deselected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				    }
				    else
				    {
				    	CustomReporting.logReport("","", "FID coverages type is not deselected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				    	//throw new RuntimeException();
				    }
	
			}
			
		if (dataUmSubDet.getData("KNR").equalsIgnoreCase("Yes")) {
				
				weCovType=(WebElement)getClonedElement(chkKNR).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				 if(!strClass.contains("ng-empty"))
					{
				    	CustomReporting.logReport("","","Verified KNR coverages type is selected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				    }
				    else
				    {
				    	CustomReporting.logReport("","", "KNR coverages type is not selected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				    	//throw new RuntimeException();
				    }
	
			}
			if (dataUmSubDet.getData("KNR").equalsIgnoreCase("No")) {
				weCovType=(WebElement)getClonedElement(chkKNR).addToken("tkn_divNum", "2").getNative();
				 strClass=weCovType.getAttribute("class");
				
					if(strClass.contains("ng-empty"))
					{
				    	CustomReporting.logReport("","","Verified KNR coverages type is deselected successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
				    }
				    else
				    {
				    	CustomReporting.logReport("","", "KNR coverages type is not deselected","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
				    	//throw new RuntimeException();
				    }
	
			}
			
			}
		}
		
		if (func._isVisible(getElement(txtEverestAttachmentPoint)) == true &&(! dataUmSubDet.getData("EverestAttachmentPoint").equals(""))) 
		{
			String strEverAttachpoint=getElement(txtEverestAttachmentPoint).getAttribute("value");
		
			if(strEverAttachpoint.equals(dataUmSubDet.getData("EverestAttachmentPoint")))
			{
		    	CustomReporting.logReport("","","Verified EverestAttachmentPoint value is updated successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "EverestAttachmentPoint value is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		}
				//_click(getElement(rdbPrimary));
		func._waitForPageToLoad(getWebDriver(), 50L);

		if(!dataUmSubDet.getData("Department").equals(""))
		{
			WebElement weDept=getWebDriver().findElement(By.xpath("//*[contains(text(),'Department')]/../../following-sibling::div[1]//button/span[1]"));
			String strDept=weDept.getText().trim();
					
			
			if(strDept.equals(dataUmSubDet.getData("Department").trim()))
			{
		    	CustomReporting.logReport("","","Verified deportment value is updated successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "deportment value is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		}
		if(!dataUmMarketSegment.getData("MarketSegment").equals(""))
		{
			WebElement weMarketSegment=getWebDriver().findElement(By.xpath("//*[contains(text(),'Market Segment')]/../../following-sibling::div[1]//button/span[1]"));
			String strMarketSegment=weMarketSegment.getText().trim();
					
			
			if(strMarketSegment.equals(dataUmMarketSegment.getData("MarketSegment").trim()))
			{
		    	CustomReporting.logReport("","","Verified MarketSegment value is updated successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "MarketSegment value is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		}
		
		
		if(!dataUmSubDet.getData("ProducerOrganization").equals(""))
		{
			WebElement weProdOrg=getWebDriver().findElement(By.xpath("//*[contains(text(),'Producer Organization')]/../../following-sibling::div[1]//button/span[1]"));
			String strProdOrg=weProdOrg.getText().trim();
					
			
			if(strProdOrg.equals(dataUmSubDet.getData("ProducerOrganization").trim()))
			{
		    	CustomReporting.logReport("","","Verified ProducerOrganization value is updated successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "ProducerOrganization value is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		}
		
		if(!dataUmSubDet.getData("ProducerOffice").equals(""))
		{
			WebElement weProdOff=getWebDriver().findElement(By.xpath("//*[contains(text(),'Producer Office')]/../../following-sibling::div[1]//button/span[1]"));
			String strProdOff=weProdOff.getText().trim();
					
			
			if(strProdOff.contains(dataUmSubDet.getData("ProducerOffice").trim()))
			{
		    	CustomReporting.logReport("","","Verified ProducerOffice value is updated successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "ProducerOffice value is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		}
			
		func._scrollToElement(getElement(btnAdminContact));
		
		if(!dataUmSubDet.getData("ProducerContact").equals(""))
		{
			WebElement weProducerContact=getWebDriver().findElement(By.xpath("//*[contains(text(),'Producer Broker Contact')]/../../following-sibling::div[1]//button/span[1]"));
			String strProdContact=weProducerContact.getText().trim();
					
			
			if(strProdContact.equals(dataUmSubDet.getData("ProducerContact").trim()))
			{
		    	CustomReporting.logReport("","","Verified ProducerContact value is updated successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "ProducerContact value is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		}
		
		if(!dataAddOffice.getData("Carrier").equals(""))
		{
			WebElement weCarrierBranch=getWebDriver().findElement(By.xpath("//*[contains(text(),'Carrier Branch')]/../../following-sibling::div[1]//button/span[1]"));
			String strCarrierBranch=weCarrierBranch.getText().trim();
					
			
			if(strCarrierBranch.equals(dataAddOffice.getData("Carrier").trim()))
			{
		    	CustomReporting.logReport("","","Verified Carrier value is updated successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Carrier value is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		}
		if(!dataAddOffice.getData("Office").equals(""))
		{
			WebElement weOffice=getWebDriver().findElement(By.xpath("(//*[contains(text(),'Office:')]/../../following-sibling::div[1]//button/span[1])[last()]"));
			String strOffice=weOffice.getText().trim();
					
			
			if(strOffice.equals(dataAddOffice.getData("Office").trim()))
			{
		    	CustomReporting.logReport("","","Verified UW Office value is updated successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Carrier UW Office is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
	     }
		
		if(!dataAddOffice.getData("Underwriter").equals(""))
		{
			WebElement weUnderwriter=getWebDriver().findElement(By.xpath("//*[contains(text(),'Underwriter:')]/../../following-sibling::div[1]//button/span[1]"));
			String strUnderwriter=weUnderwriter.getText().trim();
					
			
			if(strUnderwriter.equals(dataAddOffice.getData("Underwriter").trim()))
			{
		    	CustomReporting.logReport("","","Verified Underwriter value is updated successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
		    }
		    else
		    {
		    	CustomReporting.logReport("","", "Carrier Underwriter is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
		    	//throw new RuntimeException();
		    }
		}
			if(!dataAddOffice.getData("UWAssistant").equals(""))
			{
				WebElement weUWAssistent=getWebDriver().findElement(By.xpath("//*[contains(text(),'Underwriter Assistant')]/../../following-sibling::div[1]//button/span[1]"));
				String strUWAssistent=weUWAssistent.getText().trim();
						
				
				if(strUWAssistent.equals(dataAddOffice.getData("UWAssistant").trim()))
				{
			    	CustomReporting.logReport("","","Verified UW Assistant value is updated successfully",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
			    }
			    else
			    {
			    	CustomReporting.logReport("","", "Carrier UW Assistant is not updated","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
			    	//throw new RuntimeException();
			    }
		     }
		
		
		

		CustomReporting.logReport("", "", "Submission details verified Before bind  successfully!", StepStatus.REPORT,
				new String[] {}, System.currentTimeMillis());
	}
	
		@Override
	public void validate_Renewal_ErrorMsg(String tcID, SoftAssert softAssert) throws Exception {
		
		_wait(10000);
		func._waitFor(getElement(msg_ErrorMsg), 100L, WAIT_FOR.VISIBLE);
		if(func._isVisible(getElement(msg_ErrorMsg)))
		{
			CustomReporting.logReport("","","Error message 'Renewals Submission effective date cannot be greater than 190 days'is thrown  in UM  when we try to renewal submission with policy expairy date >190" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "","Error message 'Renewals Submission effective date cannot be greater than 190 days'is  not thrown  in UM  when we try to renewal submission with policy expairy date >190","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		
		 throw new RuntimeException();
	}
	}
	
	@Override
	public void edit_UmAccount_Details(String tcID, SoftAssert softAssert) throws Exception {
		
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		String strURL = "";
		_wait(4000);
		_click(getElement(tab_Submission));
		
		//New Submission 1
		long startTime = System.currentTimeMillis();
		long elapsedTime=0L;
		_wait(4000);

		
		_setValue(getElement(txtInsuredName), func._getGlobalVariableValue("InsuredName"));
		_clickTab();
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		
			_setValue(getElement(txtStreet1),func._getGlobalVariableValue("FirstAddress") );
			func._waitForPageToLoad(getWebDriver(), 50L);

		
			_setValue(getElement(txtZipCode), func._getGlobalVariableValue("ZIPCode"));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(1000);
		
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		_wait(5000);

	}
	
	@Override
	public void _click_RiskIsClear(String tcID, SoftAssert softAssert) throws Exception {
		
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		String strURL = "";
		_wait(4000);
		_click(getElement(btn_RiskClear));
		_wait(4000);
		_click(getElement(btn_Yes));
		_wait(4000);
	;

	}
	
	@Override
	public void UMCopySubmission(String tcID, SoftAssert softAssert) throws Exception {
		
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		String strURL = "";
		_wait(4000);
		_click(getElement(btn_Accounts));
		_wait(4000);
		_click(getElement(lnk_CopySubmission));
		_wait(4000);
		_click(getElement(btn_Copy));
		_wait(4000);
		_wait(4000);
		func._waitFor(getElement(tab_Submission), 200L, WAIT_FOR.CLICKABLE);
		_wait(4000);
		_click(getElement(tab_Submission));
		_wait(4000);

	}
	
	@Override
	public void veify_UMSubmission_Status(String tcID, SoftAssert softAssert) throws Exception {
		
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		String strURL = "";
		_wait(4000);
		WebElement weStatus=(WebElement)getElement(get_SubmissionStatus).getNative();
		if("Not Clear".equalsIgnoreCase(weStatus.getText()))
		{
			CustomReporting.logReport("","","Submission status is not clear after update the insure details" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());		
		}
		else
		{
			CustomReporting.logReport("", "","Submission status is Clear after update the insure details" ,"",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);	
		
		 throw new RuntimeException();
	}
	}
		
		

}
