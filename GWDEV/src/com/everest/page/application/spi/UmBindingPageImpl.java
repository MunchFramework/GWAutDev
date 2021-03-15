package com.everest.page.application.spi;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;
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
import org.xframium.page.PageManager;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.GenericFunctions;
import com.everest.functions.settings.Setup;
import com.everest.page.application.UmBindingPage;
import com.everest.page.application.UmCallingCovPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;


public class UmBindingPageImpl extends CustomAbstractPage implements UmBindingPage {

	@Override
	public void UmBinding(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		PageData dataUmSubDet= PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		PageData dataSearchPolicy= PageDataManager.instance().getPageData("SearchPolicy", tcID);
		Actions ac = new Actions(getWebDriver());
		
		if(!dataUmLogin.getData("tcID_BC_PartB").equals(""))
		{
			dataUmLogin = PageDataManager.instance().getPageData("UmLogin", dataUmLogin.getData("tcID_BC_PartB"));	
		}
		if(!dataUmSubDet.getData("tcID_BC_PartB").equals(""))
		{
			dataUmSubDet = PageDataManager.instance().getPageData("UMSubmissionDetails", dataUmSubDet.getData("tcID_BC_PartB"));	
		}
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		String strURL = "";

	    _wait(5000);
		WebDriverWait w = new WebDriverWait(getWebDriver(),400);
		long startTime1 = System.currentTimeMillis();
		long elapsedTime1=0L; 
       
		if(!((getWebDriver().findElements(By.xpath("//div[contains(@class,'navigationRow sentProposal')]//span")).size()==0))) {
		getWebDriver().findElement(By.xpath("//div[contains(@class,'navigationRow sentProposal')]//span")).click();
		
		}
		

		
		_wait(5000);
			
		_click(getElement(btnBeginBinding));
		_wait(2000);
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
				CustomReporting.logReport("Loading Bar Issue After Clicking on btnBeginBinding ");
			}
						
		}
		if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
		{
			elapsedTime1 =(new Date()).getTime() - startTime1; 
			CustomReporting.logReport("Time taken to Complete T13_BeginBinding Transaction :  "+elapsedTime1 +"s"); 
			System.out.println("Time taken to Complete T13_BeginBinding Transaction :  "+elapsedTime1 +"s");
			_writeToExcel("ResponseTime", "T13_BeginBinding", ""+elapsedTime1, tcID);
		}
		
		if (func._isVisible(getElement(btnBeginBinding)) == true) 
		{
			_click(getElement(btnBeginBinding));
			_wait(2000);
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
					CustomReporting.logReport("Loading Bar Issue After Clicking on btnBeginBinding ");
				}
							
			}
			if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
			{
				elapsedTime1 =(new Date()).getTime() - startTime1; 
				CustomReporting.logReport("Time taken to Complete T13_BeginBinding Transaction :  "+elapsedTime1 +"s"); 
				System.out.println("Time taken to Complete T13_BeginBinding Transaction :  "+elapsedTime1 +"s");
				_writeToExcel("ResponseTime", "T13_BeginBinding", ""+elapsedTime1, tcID);
			}
		}

			if (func._isVisible(getElement(btnBeginBinding2)) == true) 
			{
				_wait(2000);
				long startTime2 = System.currentTimeMillis();
				long elapsedTime2=0L; 
				_click(getElement(btnBeginBinding2));
				/*if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
				{
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
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
						CustomReporting.logReport("Loading Bar Issue After Clicking on btnBeginBinding2 ");
					}
								
				}
				if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
				{
					elapsedTime2 = (new Date()).getTime() - startTime2; 
					CustomReporting.logReport("Time taken to Complete T13_BeginBinding Transaction :  "+elapsedTime2 +" ms"); 
					System.out.println("Time taken to Complete T13_BeginBinding Transaction :  "+elapsedTime2 +" ms");
					_writeToExcel("ResponseTime", "T13_BeginBinding", ""+elapsedTime2, tcID);
				}
				_wait(5000);
			}
			
			if (func._isVisible(getElement(btnBeginBinding2)) == true) 
			{
				_wait(2000);
				long startTime2 = System.currentTimeMillis();
				long elapsedTime2=0L; 
				_click(getElement(btnBeginBinding2));
				/*if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
				{
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
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
						CustomReporting.logReport("Loading Bar Issue After Clicking on btnBeginBinding2 ");
					}
								
				}
				if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
				{
					elapsedTime2 = (new Date()).getTime() - startTime2; 
					CustomReporting.logReport("Time taken to Complete T13_BeginBinding Transaction :  "+elapsedTime2 +" ms"); 
					System.out.println("Time taken to Complete T13_BeginBinding Transaction :  "+elapsedTime2 +" ms");
					_writeToExcel("ResponseTime", "T13_BeginBinding", ""+elapsedTime2, tcID);
				}
				_wait(5000);
			}
		
			if(!(getWebDriver().findElements(By.xpath("(//input[@class='quoteRadioGroup'])[1]")).size()==0)) 
			{
			
			getWebDriver().findElement(By.xpath("(//input[@class='quoteRadioGroup'])[1]")).click();
			
			_wait(2000);
			
			_click(getElement(btnConfirm));
			}
		
		if (!dataUmSubDet.getData("BillType").equalsIgnoreCase(""))
		{
			if (dataUmSubDet.getData("BillType").equalsIgnoreCase("Agency")) {
				_click(getElement(rd_AgencyType));
			}
			if (dataUmSubDet.getData("BillType").equalsIgnoreCase("Direct")) {
				_click(getElement(rd_DirectType));
			}
		}
		String PolicyNum="";
		String PolicyVer="";
		
		//code for Surety
		if (dataUmSubDet.getData("SUR").equalsIgnoreCase("Yes")) 
		{
			 
			if(dataUmSubDet.getData("Submission_Type").equalsIgnoreCase("Renewal"))
			{
				PolicyNum=dataSearchPolicy.getData("PolicyNo").split("-")[0];
				PolicyVer=dataSearchPolicy.getData("PolicyNo").split("-")[1];
				int PolicyNewVer=Integer.valueOf(PolicyVer);
				PolicyNewVer=PolicyNewVer+1;
				PolicyNum=PolicyNum+"-"+PolicyNewVer;
				_setValue(getElement(txtSuretyPolicyNo), PolicyNum);
				_wait(2000);
				_setValue(getElement(txtIssueDate), dataUmSubDet.getData("RenewalEffDate"));
				_wait(2000);
				WebElement weEffdt=(WebElement)getElement(txtIssueDate).getNative();
				weEffdt.sendKeys(Keys.TAB);
			}
			else
			{	
				Random rand = new Random();  
		        int rand_int1 = rand.nextInt(900) + 100; 
				String PolicyNo = "ES91000"+rand_int1+"-201";
				_setValue(getElement(txtSuretyPolicyNo), PolicyNo);
				_wait(2000);
				_setValue(getElement(txtIssueDate), "03/31/2020");
				_wait(2000);
			
			}
		}
		
		//R5A Code FOr CON and REP Pol Number
				if (dataUmSubDet.getData("CON").equalsIgnoreCase("Yes")) 
				{
					if (dataUmSubDet.getData("SlimProductExcess").equalsIgnoreCase("Yes")) 
					{
						Random rand = new Random();  
				        int rand_int1 = rand.nextInt(900) + 100; 
						String PolicyNo = "CONX000"+rand_int1+"-201";
						_setValue(getElement(txtConPolicyNo), PolicyNo);
						_wait(2000);
						_setValue(getElement(txtIssueDate), func.Date_Manipulation("","NOW", 0));
						_wait(2000);
					}
					else
					{
						Random rand = new Random();  
				        int rand_int1 = rand.nextInt(900) + 100; 
						String PolicyNo = "CONP000"+rand_int1+"-201";
						_setValue(getElement(txtConPolicyNo), PolicyNo);
						_wait(2000);
						_setValue(getElement(txtIssueDate), func.Date_Manipulation("","NOW", 0));
						_wait(2000);
					}
					
				}
				
				if (dataUmSubDet.getData("REP").equalsIgnoreCase("Yes")) 
				{
					if (dataUmSubDet.getData("SlimProductExcess").equalsIgnoreCase("Yes")) 
					{
						Random rand = new Random();  
				        int rand_int1 = rand.nextInt(900) + 100; 
						String PolicyNo = "RWBX000"+rand_int1+"-201";
						_setValue(getElement(txtRepPolicyNo), PolicyNo);
						_wait(2000);
						_setValue(getElement(txtIssueDate), func.Date_Manipulation("","NOW", 0));
						_wait(2000);
					}
					else
					{
						Random rand = new Random();  
				        int rand_int1 = rand.nextInt(900) + 100; 
						String PolicyNo = "RWBP000"+rand_int1+"-201";
						_setValue(getElement(txtRepPolicyNo), PolicyNo);
						_wait(2000);
						_setValue(getElement(txtIssueDate), func.Date_Manipulation("","NOW", 0));
						_wait(2000);
					}
					
				}
			
		//code for EZExcess
		if (dataUmSubDet.getData("Excess").equalsIgnoreCase("Yes") || dataUmSubDet.getData("Submission_Type").equalsIgnoreCase("RunOff"))
		{
			//AMS Ticket
			if(dataUmSubDet.getData("CyberCov").equalsIgnoreCase("Yes"))
            {
                   if(func._isVisible(getElement(lbl_CYB1ed))&&func._isVisible(getElement(lbl_CYB3ed)))
                  {
                         CustomReporting.logReport("","","Verified that Cyber Excess premium spliptted in the Binding screen as CYB(1st) & CYB(3ed) Party" ,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());            
                  }
                  else
                  {
            
                         CustomReporting.logReport("", "", "Verified that Cyber Excess premium is not spliptted in the Binding screen as CYB(1st) & CYB(3ed) Party","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null); 
                  }
            
            }
			//AMS Ticket

			
			String xpath = "//span[text()='Rating: Submission Information']/../../../../..//*[contains(text(),'USD ')]";//"//*[contains(text(),'EZE: ')]"; 
			String TotalPremium = getWebDriver().findElement(By.xpath(xpath)).getText();
			String ActualPremium[] = TotalPremium.split(" - ");
			
			String Premiumvalue = ActualPremium[1].replaceAll("(\\s+|\\$|,|USD)", "");
			double TotalCoveragePremium =Double.parseDouble(Premiumvalue);  
			
			
			
			
			String Textinputxpath = "//*[text()='Premium Breakout']/../../../../../..//input"; 
			
			
			double NumberCvgs = getWebDriver().findElements(By.xpath(Textinputxpath)).size();
			double ActualCvgs = NumberCvgs-1;	
			double CoveragePremium = (TotalCoveragePremium/ActualCvgs);
			  DecimalFormat df2 = new DecimalFormat("#");
			double CvgValue = Double.parseDouble(df2.format(CoveragePremium));
			String CvgPremium = Double.toString(CvgValue);
			double LastPremium = Double.parseDouble(df2.format(TotalCoveragePremium-(CvgValue*(NumberCvgs-2))));
			String LastPrem = Double.toString(LastPremium);
			for (int i=0;i<NumberCvgs-1;i++)
			{
				if (i==(NumberCvgs-2))
				{
					int n = i+1;
					String Cvgs = "(//*[text()='Premium Breakout']/../../../../../..//input)[" + n + "]";
					WebElement CvgField = getWebDriver().findElement(By.xpath(Cvgs));	
					CvgField.sendKeys(LastPrem);
					_wait(2000);
					func.setValue9();
				}
				else
				{	
				int n = i+1;
				String Cvgs = "(//*[text()='Premium Breakout']/../../../../../..//input)[" + n + "]";
				WebElement CvgField = getWebDriver().findElement(By.xpath(Cvgs));
				CvgField.sendKeys(CvgPremium);
				_wait(2000);
				func.setValue9();
				}
			}
			_wait(4000);
			
			
		}
		if (tcID.equalsIgnoreCase("DS_R3A_SIT_E2E_SC03"))
		{
			_click(getElement(btnFormsFillIn));	
			_wait(5000);
			_click(getElement(txtSublimitCoverageRecognitionEndorsement));	
			String n= "1";
			_setValue(getElement(txtSublimitCoverageRecognitionEndorsement),n) ;
			_wait(1000);
			func.setValue9();
		}
		
		if (dataUmSubDet.getData("DirectBill").equalsIgnoreCase("Yes")) 
		{
			_wait(2000);
			_click(getElement(chkDirectBill));	
			_wait(2000);
		}
		
		if (dataUmSubDet.getData("ChangePaymentPlan").equalsIgnoreCase("Yes")) 
		{
			ac.moveToElement(getWebDriver().findElement(By.xpath("//div[contains(text(),'Billing Method:')]"))).click();
			 for(int i=0;i<5;i++)
			 {
				 ac.sendKeys(Keys.PAGE_DOWN).perform(); 
			 }
			_wait(2000);
			_click(getElement(btnPaymentPlan));	
			_wait(2000);
			_setValue(getElement(txtPaymentPlan), dataUmSubDet.getData("PaymentPlan"));
			_wait(2000);
			//String expoption= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmSubDet.getData("PaymentPlan")+"\")]";
			String expoption= "/html/body/div[3]/um-dropdown-list//*[text()='"+dataUmSubDet.getData("PaymentPlan")+"']";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			expectedOption.click();
		} 
		if (dataUmSubDet.getData("PaymentPlan").equalsIgnoreCase("Other")) 
		{
			_click(getElement(Instalmnt_Amt));	
			_wait(2000);
			_setValue(getElement(Instalmnt_Amt), "1000000");
			_wait(2000);
			_click(getElement(Paymnt_Eff));	
			_wait(2000);
			_setValue(getElement(Paymnt_Eff), dataUmSubDet.getData("EffectiveDate"));
			_wait(2000);
			String Exp_Payment = func.Date_Manipulation(dataUmSubDet.getData("EffectiveDate"), "MONTHS", 12);
			_click(getElement(Paymnt_Exp));	
			_wait(2000);
			_setValue(getElement(Paymnt_Exp), Exp_Payment);
			_wait(2000);
			String Due_Payment = func.Date_Manipulation(dataUmSubDet.getData("EffectiveDate"), "MONTHS", 1);
			_click(getElement(Paymnt_Due));	
			_wait(2000);
			_setValue(getElement(Paymnt_Due), Due_Payment);
			_wait(2000);
			func.setValue9();
		}
		
		
		
		
	if(tcID.equalsIgnoreCase("DS_SIT_E2E_SC_30")) {
			PageImplInvoker classInvoker = new PageImplInvoker();
			classInvoker.Edit_UmAddingOffice(tcID);
			
			if(!((getWebDriver().findElements(By.xpath("//div[contains(@class,'navigationRow sentProposal')]//span")).size()==0))) {
				getWebDriver().findElement(By.xpath("//div[contains(@class,'navigationRow sentProposal')]//span")).click();
				
				}
		} 
		_wait(10000);
		if (func._isVisible(getElement(btnGenerateBinder)) == true) 
		{
			long startTime3 = System.currentTimeMillis();
			long elapsedTime3=0L; 
			_click(getElement(btnGenerateBinder));
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
					CustomReporting.logReport("Loading Bar Issue After Clicking on btnGenerateBinder ");
				}
							
			}
			if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
			{
				elapsedTime3 = (new Date()).getTime() - startTime3; 
				CustomReporting.logReport("Time taken to Complete T14_GenerateBinder Transaction :  "+elapsedTime3 +" ms"); 
				System.out.println("Time taken to Complete T14_GenerateBinder Transaction :  "+elapsedTime3 +" ms");
				_writeToExcel("ResponseTime", "T14_GenerateBinder", ""+elapsedTime3, tcID);
			}
			_wait(5000);
		}
		_wait(10000);
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
				CustomReporting.logReport("Loading Bar Issue After Clicking on btnGenerateBinder ");
			}
						
		}

		if (func._isVisible(getElement(btnGenerateBinder)) == true)
		{
			_wait(5000);
			if (func._isVisible(getElement(btnOK)) == true) 
			{
				_click(getElement(btnOK));
				_wait(5000);
			}
			long startTime4 = System.currentTimeMillis();
			long elapsedTime4=0L; 
			_click(getElement(btnGenerateBinder));
			_wait(1000);
			if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
			{	
				try 
				{
					w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				} 
				catch (Exception e) 
				{
					CustomReporting.logReport("Loading Bar Issue After Clicking on btnGenerateBinder ");
				}
							
			}
			if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
			{
				elapsedTime4 = (new Date()).getTime() - startTime4; 
				CustomReporting.logReport("Time taken to Complete T14_GenerateBinder Transaction :  "+elapsedTime4 +" ms"); 
				System.out.println("Time taken to Complete T14_GenerateBinder Transaction :  "+elapsedTime4 +" ms");
				_writeToExcel("ResponseTime", "T14_GenerateBinder", ""+elapsedTime4, tcID);
			}
			//_wait(10000);
			_wait(5000);
		}
		if (!tcID.equalsIgnoreCase("DS_SIT_E2E_SC_02") && !tcID.equalsIgnoreCase("DS_SIT_E2E_SC_20")) 
		{
			if (dataUmSubDet.getData("SlimProducts").equalsIgnoreCase("Yes")) 
			{			
				_wait(2000);
				_click(getElement(btnBind));
				//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
				{	
					try 
					{
						w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
					} 
					catch (Exception e) 
					{
						CustomReporting.logReport("Loading Bar Issue After Clicking on btnBind ");
					}
								
				}
				_wait(5000);
				_click(getElement(btnYes));
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
				_wait(3000);
			}
			else
			{
			_wait(10000);
			getWebDriver().navigate().refresh();
			_wait(5000);
			try {
			if (dataUmLogin.getData("PrivateCo").equalsIgnoreCase("Yes")){
			func._scrollToElement(getElement(lnkExpQuote1));
			_wait(5000);
			_click(getElement(lnkExpQuote1));
			}
			else if(dataUmLogin.getData("NFP").equalsIgnoreCase("Yes"))
			{
				func._scrollToElement(getElement(lnkExpQuote2));
				_wait(5000);
				_click(getElement(lnkExpQuote2));
			}
			else if (dataUmLogin.getData("CYBER").equalsIgnoreCase("Yes"))
			{
				_wait(5000);
				func._scrollToElement(getElement(lnkExpQuote3));
				_wait(5000);
				_click(getElement(lnkExpQuote3));
			}
			else if (dataUmSubDet.getData("Excess").equalsIgnoreCase("Yes"))
			{
				func._scrollToElement(getElement(lnkExpQuote4));
				_wait(5000);
				_click(getElement(lnkExpQuote4));
			}
			else
			{
				func._scrollToElement(getElement(lnkExpQuote5));
				
				_wait(5000);
				_click(getElement(lnkExpQuote5));
			}
			}
			catch(Exception ex)
			{
				
			}

		_wait(10000);
		getWebDriver().navigate().refresh();
		_wait(3000);
		//_click(getElement(btnAction));
		_wait(3000);

		long startTime5 = System.currentTimeMillis();
		long elapsedTime5=0L; 
		
		_click(getElement(btnFinalizeBinder));
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
				CustomReporting.logReport("Loading Bar Issue After Clicking on btnFinalizeBinder ");
			}
						
		}
		if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
		{
			elapsedTime5 = (new Date()).getTime() - startTime5; 
			CustomReporting.logReport("Time taken to Complete T15_FinalizeBinder Transaction :  "+elapsedTime5 +" ms"); 
			System.out.println("Time taken to Complete T15_FinalizeBinder Transaction :  "+elapsedTime5 +" ms");
			_writeToExcel("ResponseTime", "T15_FinalizeBinder", ""+elapsedTime5, tcID);
		}
		
		_wait(5000);
		
		if (func._isVisible(getElement(btnFinalizeBinder)) == true) 
		{
			_click(getElement(btnFinalizeBinder));
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
					CustomReporting.logReport("Loading Bar Issue After Clicking on btnFinalizeBinder ");
				}
							
			}
			if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
			{
				elapsedTime5 = (new Date()).getTime() - startTime5; 
				CustomReporting.logReport("Time taken to Complete T15_FinalizeBinder Transaction :  "+elapsedTime5 +" ms"); 
				System.out.println("Time taken to Complete T15_FinalizeBinder Transaction :  "+elapsedTime5 +" ms");
				_writeToExcel("ResponseTime", "T15_FinalizeBinder", ""+elapsedTime5, tcID);
			}
			_wait(5000);
			
		}
		
		
		if (func._isVisible(getElement(btnSendBinder)) == true) 
		{
			long startTime6 = System.currentTimeMillis();
			long elapsedTime6=0L; 
			_click(getElement(btnSendBinder));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
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
					CustomReporting.logReport("Loading Bar Issue After Clicking on btnSendBinder ");
				}
							
			}
			if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
			{
				elapsedTime6 = (new Date()).getTime() - startTime6; 
				CustomReporting.logReport("Time taken to Complete T16_SendBinder Transaction :  "+elapsedTime6 +" ms"); 
				System.out.println("Time taken to Complete T16_SendBinder Transaction :  "+elapsedTime6 +" ms");
				_writeToExcel("ResponseTime", "T16_SendBinder", ""+elapsedTime6, tcID);
			}
			
			if (func._isVisible(getElement(btnSend)) == false) 
			{
				_click(getElement(btnSendBinder));
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
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
						CustomReporting.logReport("Loading Bar Issue After Clicking on btnSendBinder ");
					}
								
				}
				if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
				{
					elapsedTime6 = (new Date()).getTime() - startTime6; 
					CustomReporting.logReport("Time taken to Complete T16_SendBinder Transaction :  "+elapsedTime6 +" ms"); 
					System.out.println("Time taken to Complete T16_SendBinder Transaction :  "+elapsedTime6 +" ms");
					_writeToExcel("ResponseTime", "T16_SendBinder", ""+elapsedTime6, tcID);
				}
			}
			
			long startTime7 = System.currentTimeMillis();
			long elapsedTime7=0L;
			_click(getElement(btnSend));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if (func._isVisible(getElement(btnSend)) == true) 
			{
				_click(getElement(btnSend));
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
			if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
			{	
				try 
				{
					w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				} 
				catch (Exception e) 
				{
					CustomReporting.logReport("Loading Bar Issue After Clicking on btnSend ");
				}
							
			}
			if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
			{
				elapsedTime7 = (new Date()).getTime() - startTime7; 
				CustomReporting.logReport("Time taken to Complete T17_ClickSend Transaction :  "+elapsedTime7 +" ms"); 
				System.out.println("Time taken to Complete T17_ClickSend Transaction :  "+elapsedTime7 +" ms");
				_writeToExcel("ResponseTime", "T17_ClickSend", ""+elapsedTime7, tcID);
			}
		}
		//_wait(20000);
		_wait(10000);

			//_wait(20000);
			func._waitForPageToLoad(getWebDriver(), 50L);
			if (func._isVisible(getElement(btnBind)) == false) {
				_wait(10000);

			}
			}
			//_wait(20000);
			//_wait(10000);
			if (func._isVisible(getElement(btn_yes_custom)) == true) {
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				_click(getElement(btn_yes_custom));
			}
			long startTimea = System.currentTimeMillis();
			long elapsedTimea=0L;
			if (func._isVisible(getElement(btnOK)) == true) 
			{
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				_click(getElement(btnOK));
			}
			//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'To:')]/..//input")));
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
				elapsedTimea = (new Date()).getTime() - startTimea; 
				CustomReporting.logReport("Time taken to Complete T18_SendBinderEmailOk Transaction :  "+elapsedTimea +" ms"); 
				System.out.println("Time taken to Complete T18_SendBinderEmailOk Transaction :  "+elapsedTimea +" ms");
				_writeToExcel("ResponseTime", "T18_SendBinderEmailOk", ""+elapsedTimea, tcID);
			}
			//_wait(10000);
			_wait(5000);
			int i=1;
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
				try {
					_click(getElement(txtSendEmail));
					_wait(5000);
				} catch (Exception e) {
					_wait(10000);
					_click(getElement(txtSendEmail));
					_wait(5000);
				}
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
				i++;
				if(i==7)
				{
					break;
				}
			}//Email Sending
			
			long startTime9 = System.currentTimeMillis();
			long elapsedTime9=0L;
			_click(getElement(btnSendEmail));
			_wait(2000);
			if (func._isVisible(getElement(btnSendEmail)) == true)
			{
				_click(getElement(btnSendEmail));
				_wait(2000);
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
				elapsedTime9 = (new Date()).getTime() - startTime9; 
				CustomReporting.logReport("Time taken to Complete T19_SendEmail Transaction :  "+elapsedTime9 +" ms"); 
				System.out.println("Time taken to Complete T19_SendEmail Transaction :  "+elapsedTime9 +" ms");
				_writeToExcel("ResponseTime", "T19_SendEmail", ""+elapsedTime9, tcID);
			}
			_wait(5000);
  
			if (func._isVisible(getElement(btnOK)) == true)
			{
				_click(getElement(btnOK));
				_wait(3000);
			}
			
			
			
			GenericFunctions.instance().validateUMStatus(tcID, "Bound");
			_wait(5000);
			
			
			
			if(func._isVisible(getElement(lnkFinalizePolicyDocuments)))
			{
				
				_click(getElement(lnkFinalizePolicyDocuments));
				
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
						CustomReporting.logReport("Loading Bar Issue After Clicking on lnkFinalizePolicyDocuments ");
					}
								
				}
				_wait(5000);
			
	  /*      while((getWebDriver().findElements(By.xpath
	        		 ("//button[@class='btn-link glyphicon glyphicon-chevron-right ng-scope enableTransition']")).size()>0
	        		) && !(getWebDriver().findElements(By.xpath("//span[text()='Policy Issuance']")).size()>0) ) {
	      		 
	        		 getWebDriver().findElement(By.xpath
	    	        		 ("(//button[@class='btn-link glyphicon glyphicon-chevron-right ng-scope enableTransition'])")).click();
	        		 
	        		 _wait(2000);   		      		
	        	 
	         } 
					
	         if(getWebDriver().findElements(By.xpath("//span[text()='Policy Issuance']")).size()>0) {
  			 
  			 getWebDriver().findElement(By.xpath("//span[text()='Policy Issuance']")).click();
  			 
  			 _wait(10000);
  			 
  			 if(!func._isVisible(getElement(lnkFinalizePolicyDocuments)))
  				{
  				 getWebDriver().findElement(By.xpath("//span[text()='Policy Issuance']")).click();
      			 
      			 _wait(4000);
  				} */
  		 }
			else {
	         
		UmCallingCovPage objReference = (UmCallingCovPage) PageManager.instance().createPage(UmCallingCovPage.class,
					getWebDriver());
			objReference.expendCoverages(tcID, softAssert);
			
			
	 /*       while((getWebDriver().findElements(By.xpath
	        		 ("//button[@class='btn-link glyphicon glyphicon-chevron-right ng-scope enableTransition']")).size()>0
	        		) && !(getWebDriver().findElements(By.xpath("//span[text()='Policy Issuance']")).size()>0) ) {
	      		 
	        		 getWebDriver().findElement(By.xpath
	    	        		 ("(//button[@class='btn-link glyphicon glyphicon-chevron-right ng-scope enableTransition'])")).click();
	        		 
	        		 _wait(2000);   		      		
	        	 
	         } 
					
	         if(getWebDriver().findElements(By.xpath("//span[text()='Policy Issuance']")).size()>0) {
   			 
   			 getWebDriver().findElement(By.xpath("//span[text()='Policy Issuance']")).click();
   			 
   			 _wait(10000);
   			 
   			 if(!func._isVisible(getElement(lnkFinalizePolicyDocuments)))
   				{
   				 getWebDriver().findElement(By.xpath("//span[text()='Policy Issuance']")).click();
       			 
       			 _wait(4000);
   				}
   		 }		*/
			_wait(5000);
				
				

			long startTime10 = System.currentTimeMillis();
			long elapsedTime10=0L;
			
			if(func._isVisible(getElement(lnkFinalizePolicyDocuments)))
			{
				_click(getElement(lnkFinalizePolicyDocuments));
				_wait(5000);
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
					CustomReporting.logReport("Loading Bar Issue After Clicking on lnkFinalizePolicyDocuments ");
				}
							
			}
			if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
			{
				elapsedTime10 = (new Date()).getTime() - startTime10; 
				CustomReporting.logReport("Time taken to Complete T21_FinalizePolicyDocsUnderAction Transaction :  "+elapsedTime10 +" ms"); 
				System.out.println("Time taken to Complete T21_FinalizePolicyDocsUnderAction Transaction :  "+elapsedTime10 +" ms");
				_writeToExcel("ResponseTime", "T21_FinalizePolicyDocsUnderAction", ""+elapsedTime10, tcID);
			}
			
			}
			
			}
		
		long startTime11 = System.currentTimeMillis();
		long elapsedTime11=0L;
		if(func._isVisible(getElement(lnkFinalizePolicyDocuments)))
		{
			_click(getElement(lnkFinalizePolicyDocuments));
			_wait(5000);
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
				CustomReporting.logReport("Loading Bar Issue After Clicking on lnkFinalizePolicyDocuments ");
			}
						
		}
		if (dataUmLogin.getData("PerfTime").equalsIgnoreCase("Yes")) 
		{
			elapsedTime11 = (new Date()).getTime() - startTime11; 
			CustomReporting.logReport("Time taken to Complete T21_FinalizePolicyDocsUnderAction Transaction :  "+elapsedTime11 +" ms"); 
			System.out.println("Time taken to Complete T21_FinalizePolicyDocsUnderAction Transaction :  "+elapsedTime11 +" ms");
			_writeToExcel("ResponseTime", "T21_FinalizePolicyDocsUnderAction", ""+elapsedTime11, tcID);
		}
		
}
	
	@Override
	public void UM_DownloadBinder(String tcID, SoftAssert softAs) throws Exception
	{
		PageData dataUmLogin1= PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		PageData dataSearchPolicy= PageDataManager.instance().getPageData("SearchPolicy", tcID);
		
		if (dataUmLogin1.getData("DownloadBinder").equalsIgnoreCase("Yes"))//Start Comparison and Download
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
			String InsuredName = dataSearchPolicy.getData("InsName");
			String BinderDocName = "Binder for "+InsuredName+".pdf";
			_click(getClonedElement(LnkBinderDoc).addToken("tkn_binder",BinderDocName));
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
				_click(getClonedElement(LnkBinderDoc).addToken("tkn_binder",BinderDocName));
				_wait(9000);
			}
	        s.click(SaveIconPatrn);
	        func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	        String QVDownloadFilePath ="";
			String DownloadFilePath = DeviceManager.instance().getConfigurationProperties().getProperty("download.path");
			QVDownloadFilePath =strDirectoryPath+DownloadFilePath;
			String strFileName = BinderDocName;//+".PDF"
			func._downloadFile(QVDownloadFilePath, strFileName);
			
			CustomReporting.logReport("", "", "Successfully downloaded the Binder Document : "+strFileName, StepStatus.SUCCESS,
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
				func.PDF_Compare("Binder for "+dataSearchPolicy.getData("InsName"), tcID);
			}
			if (dataUmLogin1.getData("ComparePDFPageWise").equalsIgnoreCase("Yes"))
			{
				func.PDF_Compare_Pagewise("Binder for "+dataSearchPolicy.getData("InsName"), tcID);
			}
			
		}//End Comparison and Download
	}
	
	@Override
	public void UmBindPremium(String tcID, SoftAssert softAs) throws Exception
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("InternationalAddress", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
	
		String umTotalPremium = getElement(totalPremium).getAttribute("value");
		String umPolicyCurrency = getElement(policyCurrency).getAttribute("value");
		_writeToExcel("InternationalAddress", "umTotalPremium", umTotalPremium, tcID);
		_writeToExcel("InternationalAddress", "umPolicyCurrency", umPolicyCurrency, tcID);
		if(!umPolicyCurrency.equalsIgnoreCase("USD"))
		{
			String umBINDFXRate = getElement(BindFXRate).getAttribute("value");
			String umUSDPremium = getElement(usdPremium).getAttribute("value");
			_writeToExcel("InternationalAddress", "umBINDFXRate", umBINDFXRate, tcID);
			_writeToExcel("InternationalAddress", "umUSDPremium", umUSDPremium, tcID);
		}
	}
	
	
	@Override
    public void verifyCovUpdatedForProposal (String tcID, SoftAssert softAssert) {
    	
    	PageData dataUmSubDetail= PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
    	
    	PageData dataUmUpdatedSubDetail= PageDataManager.instance().getPageData("Edit_UMSubmissionDetails", tcID);
    	
    	
    	String firstProposalCov=dataUmSubDetail.getData("ExpCovForProposal1");
    	
    	String secondProposalCov=dataUmUpdatedSubDetail.getData("ExpCovForProposal2");
    	
    	int expNumOfQuoteForProposal2=Integer.parseInt(dataUmSubDetail.getData("NumberOfQuote"));
    	   	
    	
    	_click(getElement(lnkProposal));
    	
    	_wait(5000);
    	
    	_click(getElement(lnkProposal));
    	
    	_wait(5000);
    	
    	for(int i=1;i<=expNumOfQuoteForProposal2;i++) {
    		
    		
    		
    		if(func._getAttributeValue(getClonedElement(txtQuoteDesForProp2).addToken("tkn_num", Integer.toString(i)), "text").contains(": "+secondProposalCov+" - USD")) {
    			
    			CustomReporting.logReport("","","Verified Quote "+(i+1)+": of the Proposal2 contain the updated coverage as expected : " +secondProposalCov,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
    		}
    		else {
    			
    			CustomReporting.logReport("","","Verified Quote "+(i+1)+": of the Proposal2 didn't contain the updated coverage : " +secondProposalCov,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
    		}
    		
    	}
    		
    	
    	if(func._getAttributeValue(getElement(txtQuoteDesForProp1),"text").contains(": "+firstProposalCov+" - USD")) {
    		
    		CustomReporting.logReport("","","Verified Quote: of the Proposal1 coverages dosn't get updated after proposal is sent as expected : " +firstProposalCov,StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
    	
    	}else {
    		
    		CustomReporting.logReport("","","Verified Quote: of the Proposal1 coverages are not as expected : " +firstProposalCov,StepStatus.FAILURE,new String[] { },System.currentTimeMillis());
    	}
    }




}

	
