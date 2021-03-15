package com.everest.page.application.spi;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.Element;

import com.everest.functions.settings.Setup;
import com.everest.page.application.UmExposuresPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmExposuresPageImpl extends CustomAbstractPage implements UmExposuresPage {

	@Override
	public void UmExposures(String tcID, SoftAssert softAssert) throws Exception 
	{
		
		PageData dataUmExposures =null;
				PageData dataUmSubDet =null;
				
		 dataUmExposures = PageDataManager.instance().getPageData("Exposures", tcID);
		 dataUmSubDet = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		 PageData dataUmLogIn = PageDataManager.instance().getPageData("UmLogin", tcID);
		
		
		 if(!dataUmExposures.getData("tcID_BC_PartB").equals(""))
			{
			 dataUmExposures = PageDataManager.instance().getPageData("Exposures", dataUmExposures.getData("tcID_BC_PartB"));	
			}
			if(!dataUmSubDet.getData("tcID_BC_PartB").equals(""))
			{
				dataUmSubDet = PageDataManager.instance().getPageData("UMSubmissionDetails", dataUmSubDet.getData("tcID_BC_PartB"));	
			}
			
		func._waitForPageToLoad(getWebDriver(), 50L);
		
		_wait(5000);
		WebDriverWait w = new WebDriverWait(getWebDriver(), 400);
		_wait(1000);

		_click(getElement(btnproposedWritingApproach));
		_wait(2000);
		_setValue(getElement(txtWritingApproachInput), dataUmExposures.getData("WritingApproachInput"));
		
		_wait(2000);
		String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""
				+ dataUmExposures.getData("WritingApproachInput") + "\")]";
		WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
		expectedOption.click();
		_wait(4000);
		func.setValue9();
		
//		if (func._isVisible(getElement(txtRevenue)) == true) {
			_setValue(getElement(txtRevenue), dataUmExposures.getData("Revenue"));
//		}
		if (func._isVisible(getElement(txtCorporateAssets)) == true) {
			_setValue(getElement(txtCorporateAssets), dataUmExposures.getData("CorporateAssets"));
		}
		
		if (func._isVisible(getElement(txtRepCount)) == true)
		{
			_setValue(getElement(txtRepCount), dataUmExposures.getData("RepCount"));
		}
		
		if (func._isVisible(getElement(txtAssetsUnderManagement)) == true)
		{
			_setValue(getElement(txtAssetsUnderManagement), dataUmExposures.getData("AssetsUnderManagement"));
		}

		if (dataUmSubDet.getData("Department").equalsIgnoreCase("Financial Institutions")) 
		{
			if (dataUmSubDet.getData("InsuredType").equalsIgnoreCase("Security Broker Dealers"))
			{
				_setValue(getElement(txtRepCount), dataUmExposures.getData("RepCount"));
			}
			else if (dataUmSubDet.getData("InsuredType").equalsIgnoreCase("Investment Advisors")) 
			{
			
				_setValue(getElement(txtAssetsUnderManagement), dataUmExposures.getData("AssetsUnderManagement"));
			}
			else if (dataUmSubDet.getData("InsuredType").equalsIgnoreCase("Insurance")) 
			{
				
				_setValue(getElement(txtCommissionRevenue), dataUmExposures.getData("CommissionRevenue"));
				_wait(2000);
				_setValue(getElement(txtGrossPremium), dataUmExposures.getData("GrossPremium"));
				
				if (dataUmSubDet.getData("OwnershipType").equalsIgnoreCase("Public")) 
				{
					_setValue(getElement(txtMarketCap), dataUmExposures.getData("MarketCap"));
				}
				
			}
		
			if (dataUmSubDet.getData("OwnershipType").equalsIgnoreCase("Public")) 
			{
				if (dataUmSubDet.getData("InsuredType").equalsIgnoreCase("Banks")||dataUmSubDet.getData("InsuredType").equalsIgnoreCase("REITs")||dataUmSubDet.getData("InsuredType").equalsIgnoreCase("Other Financial"))
				{
					_setValue(getElement(txtMarketCap), dataUmExposures.getData("MarketCap"));
				}
				
			}
			
		}
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		if (func._isVisible(getElement(txtTotalEmployees)) == true) 
		{
			_setValue(getElement(txtUnionAllClass3), dataUmExposures.getData("UnionAllClass3"));
			_clickTab();
			_wait(1000);
			_setValue(getElement(txtNonUnionFulltimeClass3), dataUmExposures.getData("NonUnionFulltimeClass3"));

			_wait(1000);
			_setValue(getElement(txtNonUnionICsClass3), dataUmExposures.getData("NonUnionICsClass3"));

			_wait(1000);

			_setValue(getElement(txtNonUnionParttimetimeClass3), dataUmExposures.getData("NonUnionParttimetimeClass3"));

			_wait(1000);
			_setValue(getElement(txtUnionAllClass3NJ), dataUmExposures.getData("UnionAllClass3NJ"));
			_clickTab();
			_wait(1000);
			_setValue(getElement(txtNonUnionFulltimeClass3NJ), dataUmExposures.getData("NonUnionFulltimeClass3NJ"));

			_wait(1000);
			_setValue(getElement(txtNonUnionICsClass3NJ), dataUmExposures.getData("NonUnionICsClass3NJ"));

			_wait(1000);

			_setValue(getElement(txtNonUnionParttimetimeClass3NJ), dataUmExposures.getData("NonUnionParttimetimeClass3NJ"));

			_wait(1000);

			_setValue(getElement(txtForeignEmpClass3), dataUmExposures.getData("ForeignEmpClass3"));
			_wait(1000);
			_setValue(getElement(txtUnionAllClass2), dataUmExposures.getData("UnionAllClass2"));

			_wait(1000);
			_setValue(getElement(txtNonUnionFulltimeClass2), dataUmExposures.getData("NonUnionFulltimeClass2"));

			_wait(1000);
			_setValue(getElement(txtNonUnionICsClass2), dataUmExposures.getData("NonUnionICsClass2"));
			_wait(1000);
			_setValue(getElement(txtNonUnionParttimetimeClass2), dataUmExposures.getData("NonUnionParttimetimeClass2"));

			_wait(1000);
			_setValue(getElement(txtUnionAllClass1), dataUmExposures.getData("UnionAllClass1"));

			_wait(1000);
			_setValue(getElement(txtNonUnionFulltimeClass1), dataUmExposures.getData("NonUnionFulltimeClass1"));

			_wait(1000);
			_setValue(getElement(txtNonUnionICsClass1), dataUmExposures.getData("NonUnionICsClass1"));

			_wait(1000);
			_setValue(getElement(txtNonUnionParttimetimeClass1), dataUmExposures.getData("NonUnionParttimetimeClass1"));

			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		}
		
		if (dataUmSubDet.getData("SlimProducts").equalsIgnoreCase("Yes")) 
		{			
			_wait(2000);
			_setValue(getElement(txtEmployeesAll), dataUmExposures.getData("SPEmployeesAll"));
			_wait(2000);
			_setValue(getElement(txtForeignEmployeesAll), dataUmExposures.getData("SPForeignEmployeesAll"));
			_wait(4000);
			
			if (func._isVisible(getElement(txtRegisteredRepresentatives)) == true) {
				_setValue(getElement(txtRegisteredRepresentatives), dataUmExposures.getData("ENORegisteredRepresentatives"));
			}
		}
		func.setValue9();
		_wait(5000);
		
		//Submit Application 3
		long startTime = System.currentTimeMillis();
		long elapsedTime=0L; 
		
		_click(getElement(btnSubmitApplication));
		
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		if (dataUmLogIn.getData("PerfTime").equalsIgnoreCase("Yes")) 
		{
			elapsedTime = (new Date()).getTime() - startTime; 
			CustomReporting.logReport("Time taken to Complete T03_Submit application Transaction :  "+elapsedTime +" ms"); 
			System.out.println("Time taken to Complete T03_Submit application Transaction :  "+elapsedTime +" ms");
			_writeToExcel("ResponseTime", "T03_Submit application", ""+elapsedTime, tcID);
		}
		
		_wait(5000);
	//	w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

		_wait(3000);
		if (func._isVisible(getElement(btnSubmitApplication)) == true) 
		{
			startTime = System.currentTimeMillis();
			elapsedTime=0L;
			_click(getElement(btnSubmitApplication));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			if (dataUmLogIn.getData("PerfTime").equalsIgnoreCase("Yes")) 
			{
				elapsedTime = (new Date()).getTime() - startTime;
				CustomReporting.logReport("Time taken to Complete T03_Submit application Transaction :  "+elapsedTime +" ms"); 
				System.out.println("Time taken to Complete T03_Submit application Transaction :  "+elapsedTime +" ms");
				_writeToExcel("ResponseTime", "T03_Submit application", ""+elapsedTime, tcID);
			}
			_wait(5000);
			//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

		}
		
		if (func._isVisible(getElement(txtStatus)) == true)
		{
			CustomReporting.logReport("", "", "Status of the Application is CLEAR", StepStatus.REPORT.SUCCESS,
					new String[] {}, System.currentTimeMillis());

			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.logReport("", "", "Application created successfully!", StepStatus.REPORT, new String[] {},
					System.currentTimeMillis());
		} 
		else 
		{
			CustomReporting.logReport("", "", "Status of the Application is Not CLEAR", StepStatus.REPORT.FAILURE,
					new String[] {}, System.currentTimeMillis());
		}
		_wait(10000);
		/*getWebDriver().navigate().refresh();
		_wait(10000);*/
	
		if (dataUmExposures.getData("WritingApproachInput").equalsIgnoreCase("Admitted")) 
		{
		String p = dataUmExposures.getData("NumberofAttorneys");

		int k = Integer.parseInt(p); 
		//String PartTime = "/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[5]/ui-row[15]/div/ui-form-viewer/div/div/ui-row[1]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row[" + n + "]/div/ui-checkbox[2]/div/div/input";
		
		if (tcID.equalsIgnoreCase("DS_R3A_SIT_E2E_SC21_TC02"))
		{
			for (int i=0;i<k;i++)
			{
				func._scrollToElement(getElement(txtAttorneyName));
				_click(getElement(txtAttorneyName));
				_wait(2000);
				if (i>14)
				{
				_click(getElement(btnAdd));
				_wait(2000);
				_click(getElement(btnAttorneyNext));
				_wait(4000);
				int n = 1;
				int p1 = i+1;
				String AttornyName = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-text-input[4]/div//input";
				String Date = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-calendar//input";			
				String PartTime = "/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[5]/ui-row[17]/div/ui-form-viewer/div/div/ui-row[1]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row[" + n + "]/div/ui-checkbox[2]/div/div/input";
				String Name ="Name "+p1;
				
				String PriorDate4 = "07/03/19";
						
				_wait(2000);
				WebElement AttornyNameXpath = getWebDriver().findElement(By.xpath(AttornyName));
				AttornyNameXpath.sendKeys(Name);
				_wait(2000);
				if (i==15)
				{
					WebElement PartTimeXpath = getWebDriver().findElement(By.xpath(PartTime));
					PartTimeXpath.click();
				}
				

				
				if (i>11)
				{	
					WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
					DateXpath.sendKeys(PriorDate4);
				}
		
				}
				else
				{
				_wait(4000);
				int n = i+1;
				String AttornyName = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-text-input[4]/div//input";
				String Date = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-calendar//input";			
				String PartTime = "/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[5]/ui-row[17]/div/ui-form-viewer/div/div/ui-row[1]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row[" + n + "]/div/ui-checkbox[2]/div/div/input";
				String Name ="Name "+n;
				String PriorDate = "11/01/12";
				String PriorDate1 = "11/01/14";
				String PriorDate2 = "11/01/15";
				String PriorDate3 = "04/17/16";
				String PriorDate4 = "07/03/19";
						
				_wait(2000);
				WebElement AttornyNameXpath = getWebDriver().findElement(By.xpath(AttornyName));
				AttornyNameXpath.sendKeys(Name);
				_wait(2000);
				if (i==14||i==15)
				{
					WebElement PartTimeXpath = getWebDriver().findElement(By.xpath(PartTime));
					PartTimeXpath.click();
				}
				
				if (i<8)
				{	
					WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
					DateXpath.sendKeys(PriorDate);
				}
				if (i==8)
				{	
					WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
					DateXpath.sendKeys(PriorDate1);
				}
				if (i==9)
				{	
					WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
					DateXpath.sendKeys(PriorDate2);
				}
				if (i==10||i==11)
				{	
					WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
					DateXpath.sendKeys(PriorDate3);
				}
				if (i>11)
				{	
					WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
					DateXpath.sendKeys(PriorDate4);
				}
				
				_wait(2000);
			}
		}
		}
		else if (tcID.equalsIgnoreCase("DS_R3A_SIT_E2E_SC21_TC03"))
		{
			_wait(5000);
			for (int i=0;i<k;i++)
			{
				func._scrollToElement(getElement(txtAttorneyName));
				_click(getElement(txtAttorneyName));
				_wait(2000);
				if (i>0)
				{
//				_click(getElement(btnAdd));
				}
				
				_wait(4000);
				int n = i+1;
				String AttornyName = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-text-input[4]/div//input";
				String Date = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-calendar//input";			
				String PartTime = "/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[5]/ui-row[17]/div/ui-form-viewer/div/div/ui-row[1]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row[" + n + "]/div/ui-checkbox[2]/div/div/input";
				String Name ="Name "+n;
				String PriorDate = "01/01/2000";
				String PriorDate1 = "06/28/2018";
				String PriorDate2 = "10/29/2018";
			
						
				_wait(2000);
				WebElement AttornyNameXpath = getWebDriver().findElement(By.xpath(AttornyName));
				AttornyNameXpath.sendKeys(Name);
				_wait(2000);
				if (i==2||i==4||i==6||i==12)
				{
					WebElement PartTimeXpath = getWebDriver().findElement(By.xpath(PartTime));
					PartTimeXpath.click();
				}
				
				if (i==2)
				{	
					WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
					DateXpath.sendKeys(PriorDate1);
				}
				else if (i==11)
				{	
					WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
					DateXpath.sendKeys(PriorDate2);
				}
				else
				{	
					WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
					DateXpath.sendKeys(PriorDate);
				}
				
				_wait(2000);
				if (i==12)
				{
					for (int g=14;g<16;g++)
					{
					String Include = "/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[5]/ui-row[17]/div/ui-form-viewer/div/div/ui-row[1]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row[" + g + "]/div/ui-checkbox[1]/div/div/input";
					WebElement chkInclude = getWebDriver().findElement(By.xpath(Include));
					chkInclude.click();
					}
			}
		
		}
		}
		else
		{
			for (int i=0;i<11;i++)
			{
				try {
					func._scrollToElement(getElement(txtAttorneyName));
				} catch (Exception e) {
					getWebDriver().navigate().refresh();
					_wait(10000);
					func._scrollToElement(getElement(txtAttorneyName));
				}
				_click(getElement(txtAttorneyName));
				_wait(2000);
				if (i>0)
				{
//				_click(getElement(btnAdd));
				}
				
				
				_wait(4000);
				int n = i+1;
				String AttornyName = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-text-input[4]/div//input";
				String Date = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-calendar//input";			
				String Name ="Name "+n;
				String PriorDate = "10/02/19";
						
				_wait(2000);
				WebElement AttornyNameXpath = getWebDriver().findElement(By.xpath(AttornyName));
				AttornyNameXpath.sendKeys(Name);
				_wait(2000);
				WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
				DateXpath.sendKeys(PriorDate);
				_wait(2000);
				if (i==10)
				{
					for (int g=12;g<16;g++)
					{
					String Include = "/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[5]/ui-row[17]/div/ui-form-viewer/div/div/ui-row[1]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row[" + g + "]/div/ui-checkbox[1]/div/div/input";
					WebElement chkInclude = getWebDriver().findElement(By.xpath(Include));
					chkInclude.click();
					}
			}
		}
				
		}
		}
		if (dataUmSubDet.getData("MPL").equalsIgnoreCase("No")) 
		{
			if (tcID.equalsIgnoreCase("DS_R3A_SIT_E2E_SC21_TC03"))
			{
				_wait(2000);
				_click(getElement(txtBIPDPlaintiff));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtBIPDPlaintiff), dataUmExposures.getData("BIPDPlaintiff"));
				_wait(1000);
				func.setValue9();
				func._scrollToElement(getElement(btnNext));
				_wait(2000);
				_click(getElement(btnNext));
				_wait(2000);
				_click(getElement(txtInusuranceDefense));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtInusuranceDefense), dataUmExposures.getData("InusuranceDefense"));
				_wait(1000);
				func.setValue9();
				func._scrollToElement(getElement(btnNext));
				_wait(2000);
				_click(getElement(btnNext));
				_wait(2000);
				_click(getElement(txtLitigationDefense));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtLitigationDefense), dataUmExposures.getData("LitigationDefense"));
				_wait(1000);
				func.setValue9();
				func._scrollToElement(getElement(btnNext));
				_wait(2000);
			}
			else if (tcID.equalsIgnoreCase("DS_R3A_SIT_E2E_SC21_TC02"))
			{
				_wait(2000);
				_click(getElement(txtBIPDPlaintiff));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtBIPDPlaintiff), dataUmExposures.getData("BIPDPlaintiff"));
				_wait(1000);
				func.setValue9();
				_wait(2000);
				_click(getElement(txtBusinessCoporation));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtBusinessCoporation), dataUmExposures.getData("BusinessCoporation"));
				_wait(1000);
				func.setValue9();
				_wait(2000);
				_click(getElement(txtConstructionBuildingContracts));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtConstructionBuildingContracts), dataUmExposures.getData("ConstructionBuildingContracts"));
				_wait(1000);
				func.setValue9();
				func._scrollToElement(getElement(btnNext));
				_wait(2000);
				_click(getElement(btnNext));
				_wait(5000);
				func._scrollToElement(getElement(btnNext));
				_wait(2000);
				_click(getElement(btnNext));
				_wait(5000);
				_click(getElement(txtLitigationDefense));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtLitigationDefense), dataUmExposures.getData("LitigationDefense"));
				_wait(1000);
				func.setValue9();
				_click(getElement(txtLitigationPlaintiff));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtLitigationPlaintiff), dataUmExposures.getData("LitigationPlaintiff"));
				_wait(1000);
				func.setValue9();
				_click(getElement(txtMedicalMalpractice));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtMedicalMalpractice), dataUmExposures.getData("MedicalMalpractice"));
				_wait(1000);
				func.setValue9();
				_click(getElement(txtOther));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtOther), dataUmExposures.getData("Other"));
				_wait(1000);
				func.setValue9();
			}
			else if (tcID.equalsIgnoreCase("DS_R3A_SIT_E2E_SC21_TC01"))
			{
				_wait(2000);
				_click(getElement(txtAreasofPractice));
				func._scrollToElement(getElement(btnNext));
				_wait(2000);
				_click(getElement(btnNext));
				_wait(5000);
				_click(getElement(btnNext));
				_wait(5000);
				_click(getElement(txtLitigationPlaintiff));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtLitigationPlaintiff), dataUmExposures.getData("LitigationPlaintiff"));
				_wait(1000);
				func.setValue9();
				
			}
			else
			{
				if(func._isVisible(getElement(txtAreasofPractice)))
				{
		_wait(2000);
		_click(getElement(txtAreasofPractice));
		func.setValue13();
		func.setValue13();
		_setValue(getElement(txtAreasofPractice), dataUmExposures.getData("AreasofPractice"));
		_wait(1000);
		func.setValue9();
			}
		}
		}
		
		if (dataUmSubDet.getData("CyberCov").equalsIgnoreCase("Yes")) 
		{
			if (func._isVisible(getElement(btnOK)) == true) {
				_click(getElement(btnOK));
				_wait(10000);
			}
		}
		_wait(5000);

		if (func._isVisible(getElement(txtPlanAsssets)) == true) 
		{
			_setValue(getElement(txtPlanAsssets), dataUmExposures.getData("PlanAsssets"));
			func.setValue9();
		}
		_wait(2000);
		
		//EPRO-76095 AMS 3.3 Start
		
				/*if(dataUmSubDet.getData("Excess").equalsIgnoreCase("Yes") && dataUmSubDet.getData("MPL").equalsIgnoreCase("Yes"))
				{
					if (func._isVisible(getElement(txtMPLHazard)) == true)
					{
						_click(getElement(txtMPLHazard));
						_wait(2000);
						_setValue(getElement(txtMPLHazardInput), dataUmExposures.getData("MPLHazardInput"));
						_wait(2000);
						String expoption1 = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""
								+ dataUmExposures.getData("MPLHazardInput") + "\")]";
						WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
						expectedOption1.click();
						// func.setValue6();
						func.setValue9();
						CustomReporting.logReport("", "", "MPL Hazard Group dropdown is shown as expected for MPL Excess products Only as per EPRO76095", StepStatus.SUCCESS, new String[] {},
								startTime);
					}
					
				}
				else
				{
					CustomReporting.logReport("", "", "MPL Hazard Group dropdown is also shown for Products other than MPL Excess which is UnExpected as per EPRO76095", StepStatus.SUCCESS, new String[] {},
							startTime);
				}*/
				
				
				//EPRO-76095 AMS 3.3 End 
		if (func._isVisible(getElement(txtMPLHazard)) == true)
		{
			_click(getElement(txtMPLHazard));
			_wait(2000);
			_setValue(getElement(txtMPLHazardInput), dataUmExposures.getData("MPLHazardInput"));
			_wait(2000);
			String expoption1 = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""
					+ dataUmExposures.getData("MPLHazardInput") + "\")]";
			WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
			expectedOption1.click();
			// func.setValue6();
			func.setValue9();
		}
		if (func._isVisible(getElement(txtEmployedLawyer)) == true) 
		{
			_setValue(getElement(txtEmployedLawyer), dataUmExposures.getData("EmployedLawyer"));
			_wait(2000);
			func.setValue9();
		}
		_wait(5000);
		if (dataUmSubDet.getData("RemoveDBA").equalsIgnoreCase("Yes"))
		{
				_setValue(getElement(DBA_Name),"");
				_wait(1000);
				_setValue(getElement(DBA_FEIN),"");
				_wait(1000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", "DBA Details Removed", "");
				CustomReporting.logReport("DBA details removed before create proposal as per TC-22012"); 
				
		}
		if (dataUmSubDet.getData("SlimProducts").equalsIgnoreCase("Yes"))
		{			
			_wait(2000);
			long startTime3 = System.currentTimeMillis();
			long elapsedTime3=0L;
			_click(getElement(btnCreateQuote));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			if (dataUmLogIn.getData("PerfTime").equalsIgnoreCase("Yes")) 
			{
				elapsedTime3 = (new Date()).getTime() - startTime3;
				CustomReporting.logReport("Time taken to Complete T04_Create Quote Transaction :  "+elapsedTime3 +" ms"); 
				System.out.println("Time taken to Complete T04_Create Quote Transaction :  "+elapsedTime3 +" ms");
				_writeToExcel("ResponseTime", "T04_Create Quote", ""+elapsedTime3, tcID);
			}
			//_wait(10000);
			_wait(5000);
			
			if (dataUmSubDet.getData("CRD").equalsIgnoreCase("Yes")) {		
				_wait(2000);
				if (dataUmSubDet.getData("CRDAircraftFinance").equalsIgnoreCase("Yes")) {
					_wait(2000);
					_click(getElement(chkAircraftFinance));
				}
				else if (dataUmSubDet.getData("CRDCredit").equalsIgnoreCase("Yes")) {
					_wait(2000);
					_click(getElement(chkCredit));
				}
				else if(dataUmSubDet.getData("CRDProjectFinance").equalsIgnoreCase("Yes")) {
					_wait(2000);
					_click(getElement(chkProjectFinance));
				}
					
			}
				_wait(2000);
				
				if (dataUmSubDet.getData("POL").equalsIgnoreCase("Yes")) {		
					_wait(2000);
					if (dataUmSubDet.getData("POLEquity").equalsIgnoreCase("Yes")) {
						_wait(2000);
						_click(getElement(chkPOLEquity));
					}
					else if (dataUmSubDet.getData("POLLenders").equalsIgnoreCase("Yes")) {
						_wait(2000);
						_click(getElement(chkPOLLenders));
					}
					else if(dataUmSubDet.getData("POLNonHonouring").equalsIgnoreCase("Yes")) {
						_wait(2000);
						_click(getElement(chkPOLNonHonouring));
					}
						
				}
			
		}
		else
		{
			
		_click(getElement(btnCreateProposal));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		_wait(10000);
		}
		
		
		if (func._isVisible(getElement(btnCreateProposal))|| func._isVisible(getElement("btnCreateQuote")) == true) {
			if (dataUmSubDet.getData("SlimProducts").equalsIgnoreCase("Yes")) {			
				_wait(2000);
				long startTime4 = System.currentTimeMillis();
				long elapsedTime4=0L;
				_click(getElement(btnCreateQuote));
				try {
					w.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				} catch (Exception e) {
					CustomReporting.logReport("Loading Bar after create Quote in Exposures");
				}
				if (dataUmLogIn.getData("PerfTime").equalsIgnoreCase("Yes")) 
				{
					elapsedTime4 = (new Date()).getTime() - startTime4;
					CustomReporting.logReport("Time taken to Complete T04_Create Quote Transaction :  "+elapsedTime4 +" ms"); 
					System.out.println("Time taken to Complete T04_Create Quote Transaction :  "+elapsedTime4 +" ms");
					_writeToExcel("ResponseTime", "T04_Create Quote", ""+elapsedTime4, tcID);
				}
				//_wait(10000);
				_wait(5000);
			}
			else
			{
				
			_click(getElement(btnCreateProposal));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			//_wait(10000);
			_wait(5000);
			}
		}
		
		if (dataUmSubDet.getData("MPL").equalsIgnoreCase("No")|| dataUmSubDet.getData("Excess").equalsIgnoreCase("Yes") || dataUmSubDet.getData("SlimProducts").equalsIgnoreCase("Yes")){
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(5000);
		}
		else
		{	
		if (func._isVisible(getElement(lblSelectProduct)) == false) {
			
			_click(getElement(btnCreateProposal));
			_wait(6000);
		}

		if (dataUmSubDet.getData("CyberCov").equalsIgnoreCase("Yes"))
		{
			if (dataUmSubDet.getData("CRIME").equalsIgnoreCase("Yes")
					|| dataUmSubDet.getData("DNO").equalsIgnoreCase("Yes")
					|| dataUmSubDet.getData("EMP").equalsIgnoreCase("Yes")
					|| dataUmSubDet.getData("ENO").equalsIgnoreCase("Yes")
					|| dataUmSubDet.getData("EPL").equalsIgnoreCase("Yes")
					|| dataUmSubDet.getData("FID").equalsIgnoreCase("Yes")
					|| dataUmSubDet.getData("KNR").equalsIgnoreCase("Yes"))

			{
				if (dataUmExposures.getData("NFP").equalsIgnoreCase("Yes")) {
					_click(getElement(chkNFP));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

				}
				if (dataUmExposures.getData("PrivateCo").equalsIgnoreCase("Yes")) {
					_click(getElement(chkPrivateCo));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
			} else {
				if (dataUmExposures.getData("NFP").equalsIgnoreCase("Yes")) {
					_click(getElement(chkCYBNFP));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

				}
				if (dataUmExposures.getData("PrivateCo").equalsIgnoreCase("Yes")) {
					_click(getElement(chkCYBPrivateCo));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
				if (dataUmExposures.getData("CYBER").equalsIgnoreCase("Yes")) {
					_click(getElement(chkCyber));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}

		}

		else {
			if (dataUmExposures.getData("NFP").equalsIgnoreCase("Yes")) {
				_click(getElement(chkNFP));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			}
			if (dataUmExposures.getData("PrivateCo").equalsIgnoreCase("Yes")) {
				_click(getElement(chkPrivateCo));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			}
		}

		
		_wait(2000);
		long startTime1 = System.currentTimeMillis();
		long elapsedTime1=0L; 
		_click(getElement(btnCreateProposal));
		if(getWebDriver().findElements(By.xpath("/html/body/loading-bar/div/div")).size()>0)
		{
			try {
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			} catch (Exception e) {
				CustomReporting.logReport("Loading Bar After Create Proposal"); 

			}
		}
		if (dataUmLogIn.getData("PerfTime").equalsIgnoreCase("Yes")) 
		{
			elapsedTime1 = (new Date()).getTime() - startTime1;
			CustomReporting.logReport("Time taken to Complete T04_Create Quote Transaction :  "+elapsedTime1 +" ms"); 
			System.out.println("Time taken to Complete T04_Create Quote Transaction :  "+elapsedTime1 +" ms");
			_writeToExcel("ResponseTime", "T04_Create Quote", ""+elapsedTime1, tcID);
		}
		_wait(6000);

		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		//_wait(10000);
		if (dataUmSubDet.getData("PrivateCo").equalsIgnoreCase("Yes"))
		{
			func._scrollToElement(getElement(lnkExpQuote1));
			_wait(5000);
			_click(getElement(lnkExpQuote1));
			}
			else if(dataUmSubDet.getData("NFP").equalsIgnoreCase("Yes"))
			{
				func._scrollToElement(getElement(lnkExpQuote2));
				_wait(5000);
				_click(getElement(lnkExpQuote2));
			}
			else if (dataUmSubDet.getData("CYBER").equalsIgnoreCase("Yes"))
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

			if (dataUmExposures.getData("UpdateCoverages").equalsIgnoreCase("Yes"))
			{
				_wait(2000);
				long startTime2 = System.currentTimeMillis();
				long elapsedTime2=0L; 
				_click(getElement(btnUpdateCoverages));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				if (dataUmLogIn.getData("PerfTime").equalsIgnoreCase("Yes")) 
				{
					elapsedTime2 = (new Date()).getTime() - startTime2;
					CustomReporting.logReport("Time taken to Complete T05_Click on Update Coverages Transaction :  "+elapsedTime2 +" ms"); 
					System.out.println("Time taken to Complete T05_Click on Update Coverages Transaction :  "+elapsedTime2 +" ms");
					_writeToExcel("ResponseTime", "T05_Click on Update Coverages", ""+elapsedTime2, tcID);
				}
				
				//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
		}
	}
		
		@Override
		public void SubmitApplication(String tcID, SoftAssert softAssert) throws Exception 
		{
			PageData dataUmLogin = PageDataManager.instance().getPageData("Exposures", tcID);
			PageData dataUmLogin1 = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
			func._waitForPageToLoad(getWebDriver(), 50L);
			
			_wait(5000);
			WebDriverWait w = new WebDriverWait(getWebDriver(), 250);
			_wait(1000);

			_click(getElement(btnproposedWritingApproach));
			_wait(2000);
			_setValue(getElement(txtWritingApproachInput), dataUmLogin.getData("WritingApproachInput"));
			_wait(2000);
			String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""
					+ dataUmLogin.getData("WritingApproachInput") + "\")]";
			WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
			expectedOption.click();
			_wait(4000);
			func.setValue9();
			
//			if (func._isVisible(getElement(txtRevenue)) == true) {
				_setValue(getElement(txtRevenue), dataUmLogin.getData("Revenue"));
//			}
			if (func._isVisible(getElement(txtCorporateAssets)) == true) {
				_setValue(getElement(txtCorporateAssets), dataUmLogin.getData("CorporateAssets"));
			}
			
			if (func._isVisible(getElement(txtRepCount)) == true)
			{
				_setValue(getElement(txtRepCount), dataUmLogin.getData("RepCount"));
			}
			
			if (func._isVisible(getElement(txtAssetsUnderManagement)) == true)
			{
				_setValue(getElement(txtAssetsUnderManagement), dataUmLogin.getData("AssetsUnderManagement"));
			}

			if (dataUmLogin1.getData("Department").equalsIgnoreCase("Financial Institutions")) 
			{
				if (dataUmLogin1.getData("InsuredType").equalsIgnoreCase("Security Broker Dealers"))
				{
					_setValue(getElement(txtRepCount), dataUmLogin.getData("RepCount"));
				}
				else if (dataUmLogin1.getData("InsuredType").equalsIgnoreCase("Investment Advisors")) 
				{
				
					_setValue(getElement(txtAssetsUnderManagement), dataUmLogin.getData("AssetsUnderManagement"));
				}
				else if (dataUmLogin1.getData("InsuredType").equalsIgnoreCase("Insurance")) 
				{
					
					_setValue(getElement(txtCommissionRevenue), dataUmLogin.getData("CommissionRevenue"));
					_wait(2000);
					_setValue(getElement(txtGrossPremium), dataUmLogin.getData("GrossPremium"));
					
					if (dataUmLogin1.getData("OwnershipType").equalsIgnoreCase("Public")) 
					{
						_setValue(getElement(txtMarketCap), dataUmLogin.getData("MarketCap"));
					}
					
				}
			
				if (dataUmLogin1.getData("OwnershipType").equalsIgnoreCase("Public")) 
				{
					if (dataUmLogin1.getData("InsuredType").equalsIgnoreCase("Banks")||dataUmLogin1.getData("InsuredType").equalsIgnoreCase("REITs")||dataUmLogin1.getData("InsuredType").equalsIgnoreCase("Other Financial"))
					{
						_setValue(getElement(txtMarketCap), dataUmLogin.getData("MarketCap"));
					}
					
				}
				
			}
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			if (func._isVisible(getElement(txtTotalEmployees)) == true) 
			{
				_setValue(getElement(txtUnionAllClass3), dataUmLogin.getData("UnionAllClass3"));
				_clickTab();
				_wait(1000);
				_setValue(getElement(txtNonUnionFulltimeClass3), dataUmLogin.getData("NonUnionFulltimeClass3"));

				_wait(1000);
				_setValue(getElement(txtNonUnionICsClass3), dataUmLogin.getData("NonUnionICsClass3"));

				_wait(1000);

				_setValue(getElement(txtNonUnionParttimetimeClass3), dataUmLogin.getData("NonUnionParttimetimeClass3"));

				_wait(1000);
				_setValue(getElement(txtUnionAllClass3NJ), dataUmLogin.getData("UnionAllClass3NJ"));
				_clickTab();
				_wait(1000);
				_setValue(getElement(txtNonUnionFulltimeClass3NJ), dataUmLogin.getData("NonUnionFulltimeClass3NJ"));

				_wait(1000);
				_setValue(getElement(txtNonUnionICsClass3NJ), dataUmLogin.getData("NonUnionICsClass3NJ"));

				_wait(1000);

				_setValue(getElement(txtNonUnionParttimetimeClass3NJ), dataUmLogin.getData("NonUnionParttimetimeClass3NJ"));

				_wait(1000);

				_setValue(getElement(txtForeignEmpClass3), dataUmLogin.getData("ForeignEmpClass3"));
				_wait(1000);
				_setValue(getElement(txtUnionAllClass2), dataUmLogin.getData("UnionAllClass2"));

				_wait(1000);
				_setValue(getElement(txtNonUnionFulltimeClass2), dataUmLogin.getData("NonUnionFulltimeClass2"));

				_wait(1000);
				_setValue(getElement(txtNonUnionICsClass2), dataUmLogin.getData("NonUnionICsClass2"));
				_wait(1000);
				_setValue(getElement(txtNonUnionParttimetimeClass2), dataUmLogin.getData("NonUnionParttimetimeClass2"));

				_wait(1000);
				_setValue(getElement(txtUnionAllClass1), dataUmLogin.getData("UnionAllClass1"));

				_wait(1000);
				_setValue(getElement(txtNonUnionFulltimeClass1), dataUmLogin.getData("NonUnionFulltimeClass1"));

				_wait(1000);
				_setValue(getElement(txtNonUnionICsClass1), dataUmLogin.getData("NonUnionICsClass1"));

				_wait(1000);
				_setValue(getElement(txtNonUnionParttimetimeClass1), dataUmLogin.getData("NonUnionParttimetimeClass1"));

				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			}
			
			if (dataUmLogin1.getData("SlimProducts").equalsIgnoreCase("Yes")) 
			{			
				_wait(2000);
				_setValue(getElement(txtEmployeesAll), dataUmLogin.getData("SPEmployeesAll"));
				_wait(2000);
				_setValue(getElement(txtForeignEmployeesAll), dataUmLogin.getData("SPForeignEmployeesAll"));
				_wait(4000);
				
				if (func._isVisible(getElement(txtRegisteredRepresentatives)) == true) {
					_setValue(getElement(txtRegisteredRepresentatives), dataUmLogin.getData("ENORegisteredRepresentatives"));
				}
			}
			func.setValue9();
			_wait(5000);
			
			//Submit Application 3
			long startTime = System.currentTimeMillis();
			long elapsedTime=0L; 
			
			_click(getElement(btnSubmitApplication));
			
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			elapsedTime = (new Date()).getTime() - startTime; 
			CustomReporting.logReport("Time taken to Complete T03_Submit application Transaction :  "+elapsedTime +" ms"); 
			System.out.println("Time taken to Complete T03_Submit application Transaction :  "+elapsedTime +" ms");
			_writeToExcel("ResponseTime", "T03_Submit application", ""+elapsedTime, tcID);
			
			_wait(5000);
		//	w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

			_wait(3000);
			if (func._isVisible(getElement(btnSubmitApplication)) == true) 
			{
				startTime = System.currentTimeMillis();
				elapsedTime=0L;
				_click(getElement(btnSubmitApplication));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				elapsedTime = (new Date()).getTime() - startTime;
				CustomReporting.logReport("Time taken to Complete T03_Submit application Transaction :  "+elapsedTime +" ms"); 
				System.out.println("Time taken to Complete T03_Submit application Transaction :  "+elapsedTime +" ms");
				
				_wait(5000);
				//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

			}
			
			if (func._isVisible(getElement(txtStatus)) == true)
			{
				CustomReporting.logReport("", "", "Status of the Application is CLEAR", StepStatus.REPORT.SUCCESS,
						new String[] {}, System.currentTimeMillis());

				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				CustomReporting.logReport("", "", "Application created successfully!", StepStatus.REPORT, new String[] {},
						System.currentTimeMillis());
			} 
			else 
			{
				CustomReporting.logReport("", "", "Status of the Application is Not CLEAR", StepStatus.REPORT.FAILURE,
						new String[] {}, System.currentTimeMillis());
			}
			_wait(10000);
			
			WebElement weSubNum=(WebElement)getElement(get_SubmissionNumber).getNative();
			String SubNum=weSubNum.getAttribute("value");
			func._writeToExcel("SearchPolicy", "SubmissionNo", SubNum, tcID);
			Setup.LoadData();

	}
	
		@Override
		public void update_Exposure(String tcID, SoftAssert softAssert) throws Exception 
		{	PageData dataUmLogin1=null;;
			PageData dataUmLogin = PageDataManager.instance().getPageData("Exposures", tcID);
			dataUmLogin1 = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
			
			if(!dataUmLogin1.getData("tcID_BC_PartB").equals(""))
			{
				dataUmLogin1 = PageDataManager.instance().getPageData("UMSubmissionDetails", dataUmLogin1.getData("tcID_BC_PartB"));
			}
			func._waitForPageToLoad(getWebDriver(), 50L);
			WebDriverWait w = new WebDriverWait(getWebDriver(), 250);
			_wait(1000);
		
			if (dataUmLogin.getData("WritingApproachInput").equalsIgnoreCase("Admitted")) 
			{
					String p = dataUmLogin.getData("NumberofAttorneys");

					int k = Integer.parseInt(p); 
						//String PartTime = "/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[5]/ui-row[15]/div/ui-form-viewer/div/div/ui-row[1]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row[" + n + "]/div/ui-checkbox[2]/div/div/input";
		
					if (tcID.equalsIgnoreCase("DS_R3A_SIT_E2E_SC21_TC02"))
					{
						for (int i=0;i<k;i++)
						{
							func._scrollToElement(getElement(txtAttorneyName));
							_click(getElement(txtAttorneyName));
							_wait(2000);
							if (i>14)
							{
							_click(getElement(btnAdd));
							_wait(2000);
							_click(getElement(btnAttorneyNext));
							_wait(4000);
							int n = 1;
							int p1 = i+1;
							String AttornyName = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-text-input[4]/div//input";
							String Date = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-calendar//input";			
							String PartTime = "/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[5]/ui-row[17]/div/ui-form-viewer/div/div/ui-row[1]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row[" + n + "]/div/ui-checkbox[2]/div/div/input";
							String Name ="Name "+p1;
						
							String PriorDate4 = "07/03/19";
									
							_wait(2000);
							WebElement AttornyNameXpath = getWebDriver().findElement(By.xpath(AttornyName));
							AttornyNameXpath.sendKeys(Name);
							_wait(2000);
							if (i==15)
							{
								WebElement PartTimeXpath = getWebDriver().findElement(By.xpath(PartTime));
								PartTimeXpath.click();
							}
				

				
							if (i>11)
							{	
								WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
								DateXpath.sendKeys(PriorDate4);
							}
					
							}
							else
							{
							_wait(4000);
							int n = i+1;
							String AttornyName = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-text-input[4]/div//input";
							String Date = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-calendar//input";			
							String PartTime = "/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[5]/ui-row[17]/div/ui-form-viewer/div/div/ui-row[1]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row[" + n + "]/div/ui-checkbox[2]/div/div/input";
							String Name ="Name "+n;
							String PriorDate = "11/01/12";
							String PriorDate1 = "11/01/14";
							String PriorDate2 = "11/01/15";
							String PriorDate3 = "04/17/16";
							String PriorDate4 = "07/03/19";
						
							_wait(2000);
							WebElement AttornyNameXpath = getWebDriver().findElement(By.xpath(AttornyName));
							AttornyNameXpath.sendKeys(Name);
							_wait(2000);
							if (i==14||i==15)
							{
								WebElement PartTimeXpath = getWebDriver().findElement(By.xpath(PartTime));
								PartTimeXpath.click();
							}
							
							if (i<8)
							{	
								WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
								DateXpath.sendKeys(PriorDate);
							}
							if (i==8)
							{	
								WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
								DateXpath.sendKeys(PriorDate1);
							}
							if (i==9)
							{	
								WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
								DateXpath.sendKeys(PriorDate2);
							}
							if (i==10||i==11)
							{	
								WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
								DateXpath.sendKeys(PriorDate3);
							}
							if (i>11)
							{	
								WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
								DateXpath.sendKeys(PriorDate4);
							}
						
								_wait(2000);
						}
					}
				}
				else if (tcID.equalsIgnoreCase("DS_R3A_SIT_E2E_SC21_TC03"))
				{

					for (int i=0;i<k;i++)
					{
						func._scrollToElement(getElement(txtAttorneyName));
						_click(getElement(txtAttorneyName));
						_wait(2000);
						if (i>0)
						{
		//				_click(getElement(btnAdd));
						}
						
						_wait(4000);
						int n = i+1;
						String AttornyName = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-text-input[4]/div//input";
						String Date = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-calendar//input";			
						String PartTime = "/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[5]/ui-row[17]/div/ui-form-viewer/div/div/ui-row[1]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row[" + n + "]/div/ui-checkbox[2]/div/div/input";
						String Name ="Name "+n;
						String PriorDate = "01/01/2000";
						String PriorDate1 = "06/28/2018";
						String PriorDate2 = "10/29/2018";
					
								
						_wait(2000);
						WebElement AttornyNameXpath = getWebDriver().findElement(By.xpath(AttornyName));
						AttornyNameXpath.sendKeys(Name);
						_wait(2000);
						if (i==2||i==4||i==6||i==12)
						{
							WebElement PartTimeXpath = getWebDriver().findElement(By.xpath(PartTime));
							PartTimeXpath.click();
						}
						
						if (i==2)
						{	
							WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
							DateXpath.sendKeys(PriorDate1);
						}
						else if (i==11)
						{	
							WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
							DateXpath.sendKeys(PriorDate2);
						}
						else
						{	
							WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
							DateXpath.sendKeys(PriorDate);
						}
						
						_wait(2000);
						if (i==12)
						{
							for (int g=14;g<16;g++)
							{
							String Include = "/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[5]/ui-row[17]/div/ui-form-viewer/div/div/ui-row[1]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row[" + g + "]/div/ui-checkbox[1]/div/div/input";
							WebElement chkInclude = getWebDriver().findElement(By.xpath(Include));
							chkInclude.click();
							}
						}
		
					}
				}
				else
				{
					for (int i=0;i<11;i++)
					{
						func._scrollToElement(getElement(txtAttorneyName));
						_click(getElement(txtAttorneyName));
						_wait(2000);
						if (i>0)
						{
		//				_click(getElement(btnAdd));
						}
						
						_wait(4000);
						int n = i+1;
						String AttornyName = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-text-input[4]/div//input";
						String Date = "//*[contains(text(),'Attorney Information')]/../..//ui-repeating-row[" + n + "]//ui-calendar//input";			
						String Name ="Name "+n;
						String PriorDate = "10/02/19";
								
						_wait(2000);
						WebElement AttornyNameXpath = getWebDriver().findElement(By.xpath(AttornyName));
						AttornyNameXpath.sendKeys(Name);
						_wait(2000);
						WebElement DateXpath = getWebDriver().findElement(By.xpath(Date));
						DateXpath.sendKeys(PriorDate);
						_wait(2000);
						if (i==10)
						{
							for (int g=12;g<16;g++)
							{
							String Include = "/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[5]/ui-row[17]/div/ui-form-viewer/div/div/ui-row[1]/div/ui-row-repeater/div/ui-repeating-rows/ui-repeating-row[" + g + "]/div/ui-checkbox[1]/div/div/input";
							WebElement chkInclude = getWebDriver().findElement(By.xpath(Include));
							chkInclude.click();
							}
					}
				}
				
			}
		}
		if (dataUmLogin1.getData("MPL").equalsIgnoreCase("No")) 
		{
			if (tcID.equalsIgnoreCase("DS_R3A_SIT_E2E_SC21_TC03"))
			{
				_wait(2000);
				_click(getElement(txtBIPDPlaintiff));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtBIPDPlaintiff), dataUmLogin.getData("BIPDPlaintiff"));
				_wait(1000);
				func.setValue9();
				func._scrollToElement(getElement(btnNext));
				_wait(2000);
				_click(getElement(btnNext));
				_wait(2000);
				_click(getElement(txtInusuranceDefense));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtInusuranceDefense), dataUmLogin.getData("InusuranceDefense"));
				_wait(1000);
				func.setValue9();
				func._scrollToElement(getElement(btnNext));
				_wait(2000);
				_click(getElement(btnNext));
				_wait(2000);
				_click(getElement(txtLitigationDefense));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtLitigationDefense), dataUmLogin.getData("LitigationDefense"));
				_wait(1000);
				func.setValue9();
				func._scrollToElement(getElement(btnNext));
				_wait(2000);
			}
			else if (tcID.equalsIgnoreCase("DS_R3A_SIT_E2E_SC21_TC02"))
			{
				_wait(2000);
				_click(getElement(txtBIPDPlaintiff));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtBIPDPlaintiff), dataUmLogin.getData("BIPDPlaintiff"));
				_wait(1000);
				func.setValue9();
				_wait(2000);
				_click(getElement(txtBusinessCoporation));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtBusinessCoporation), dataUmLogin.getData("BusinessCoporation"));
				_wait(1000);
				func.setValue9();
				_wait(2000);
				_click(getElement(txtConstructionBuildingContracts));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtConstructionBuildingContracts), dataUmLogin.getData("ConstructionBuildingContracts"));
				_wait(1000);
				func.setValue9();
				func._scrollToElement(getElement(btnNext));
				_wait(2000);
				_click(getElement(btnNext));
				_wait(5000);
				func._scrollToElement(getElement(btnNext));
				_wait(2000);
				_click(getElement(btnNext));
				_wait(5000);
				_click(getElement(txtLitigationDefense));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtLitigationDefense), dataUmLogin.getData("LitigationDefense"));
				_wait(1000);
				func.setValue9();
				_click(getElement(txtLitigationPlaintiff));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtLitigationPlaintiff), dataUmLogin.getData("LitigationPlaintiff"));
				_wait(1000);
				func.setValue9();
				_click(getElement(txtMedicalMalpractice));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtMedicalMalpractice), dataUmLogin.getData("MedicalMalpractice"));
				_wait(1000);
				func.setValue9();
				_click(getElement(txtOther));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtOther), dataUmLogin.getData("Other"));
				_wait(1000);
				func.setValue9();
			}
			else if (tcID.equalsIgnoreCase("DS_R3A_SIT_E2E_SC21_TC01"))
			{
				_wait(2000);
				_click(getElement(txtAreasofPractice));
				func._scrollToElement(getElement(btnNext));
				_wait(2000);
				_click(getElement(btnNext));
				_wait(5000);
				_click(getElement(btnNext));
				_wait(5000);
				_click(getElement(txtLitigationPlaintiff));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtLitigationPlaintiff), dataUmLogin.getData("LitigationPlaintiff"));
				_wait(1000);
				func.setValue9();
				
			}
			else
			{
				if(!dataUmLogin.getData("AreasofPractice").equals(""))
				{
				_wait(2000);
				_click(getElement(txtAreasofPractice));
				func.setValue13();
				func.setValue13();
				_setValue(getElement(txtAreasofPractice), dataUmLogin.getData("AreasofPractice"));
				_wait(1000);
				func.setValue9();
				}
			}
		}
		
		if (dataUmLogin1.getData("CyberCov").equalsIgnoreCase("Yes")) 
		{
			if (func._isVisible(getElement(btnOK)) == true) {
				_click(getElement(btnOK));
				_wait(10000);
			}
		}
		_wait(5000);

		if (func._isVisible(getElement(txtPlanAsssets)) == true) 
		{
			_setValue(getElement(txtPlanAsssets), dataUmLogin.getData("PlanAsssets"));
			func.setValue9();
		}
		_wait(2000);
		if (func._isVisible(getElement(txtMPLHazard)) == true)
		{
			_click(getElement(txtMPLHazard));
			_wait(2000);
			_setValue(getElement(txtMPLHazardInput), dataUmLogin.getData("MPLHazardInput"));
			_wait(2000);
			String expoption1 = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""
					+ dataUmLogin.getData("MPLHazardInput") + "\")]";
			WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
			expectedOption1.click();
			// func.setValue6();
			func.setValue9();
		}
		if (func._isVisible(getElement(txtEmployedLawyer)) == true) 
		{
			_setValue(getElement(txtEmployedLawyer), dataUmLogin.getData("EmployedLawyer"));
			_wait(2000);
			func.setValue9();
		}
		_wait(5000);
		if (dataUmLogin1.getData("SlimProducts").equalsIgnoreCase("Yes"))
		{			
			_wait(2000);
			long startTime3 = System.currentTimeMillis();
			long elapsedTime3=0L;
			_click(getElement(btnCreateQuote));
			
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			
			elapsedTime3 = (new Date()).getTime() - startTime3;
			CustomReporting.logReport("Time taken to Complete T04_Create Quote Transaction :  "+elapsedTime3 +" ms"); 
			System.out.println("Time taken to Complete T04_Create Quote Transaction :  "+elapsedTime3 +" ms");
			_writeToExcel("ResponseTime", "T04_Create Quote", ""+elapsedTime3, tcID);
			_wait(10000);
			
			if (dataUmLogin1.getData("CRD").equalsIgnoreCase("Yes")) {		
				_wait(2000);
				if (dataUmLogin1.getData("CRDAircraftFinance").equalsIgnoreCase("Yes")) {
					_wait(2000);
					_click(getElement(chkAircraftFinance));
				}
				else if (dataUmLogin1.getData("CRDCredit").equalsIgnoreCase("Yes")) {
					_wait(2000);
					_click(getElement(chkCredit));
				}
				else if(dataUmLogin1.getData("CRDProjectFinance").equalsIgnoreCase("Yes")) {
					_wait(2000);
					_click(getElement(chkProjectFinance));
				}
					
			}
				_wait(2000);
				
				if (dataUmLogin1.getData("POL").equalsIgnoreCase("Yes")) {		
					_wait(2000);
					if (dataUmLogin1.getData("POLEquity").equalsIgnoreCase("Yes")) {
						_wait(2000);
						_click(getElement(chkPOLEquity));
					}
					else if (dataUmLogin1.getData("POLLenders").equalsIgnoreCase("Yes")) {
						_wait(2000);
						_click(getElement(chkPOLLenders));
					}
					else if(dataUmLogin1.getData("POLNonHonouring").equalsIgnoreCase("Yes")) {
						_wait(2000);
						_click(getElement(chkPOLNonHonouring));
					}
						
				}
			
		}
		else
		{
		_click(getElement(btnCreateProposal));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		_wait(10000);
		}
		if (func._isVisible(getElement(btnCreateProposal))|| func._isVisible(getElement("btnCreateQuote")) == true) {
			if (dataUmLogin1.getData("SlimProducts").equalsIgnoreCase("Yes")) {			
				_wait(2000);
				long startTime4 = System.currentTimeMillis();
				long elapsedTime4=0L;
				_click(getElement(btnCreateQuote));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				elapsedTime4 = (new Date()).getTime() - startTime4;
				CustomReporting.logReport("Time taken to Complete T04_Create Quote Transaction :  "+elapsedTime4 +" ms"); 
				System.out.println("Time taken to Complete T04_Create Quote Transaction :  "+elapsedTime4 +" ms");
				_writeToExcel("ResponseTime", "T04_Create Quote", ""+elapsedTime4, tcID);
				_wait(10000);
			}
			else
			{
			_click(getElement(btnCreateProposal));
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(10000);
			}
		}
		if (dataUmLogin1.getData("MPL").equalsIgnoreCase("No")|| dataUmLogin1.getData("Excess").equalsIgnoreCase("Yes") || dataUmLogin1.getData("SlimProducts").equalsIgnoreCase("Yes")){
			w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
			_wait(5000);
		}
		else
		{	
		if (func._isVisible(getElement(lblSelectProduct)) == false) {
			_click(getElement(btnCreateProposal));
			_wait(6000);
		}
		

		if (dataUmLogin1.getData("CyberCov").equalsIgnoreCase("Yes"))
		{
			if (dataUmLogin1.getData("CRIME").equalsIgnoreCase("Yes")
					|| dataUmLogin1.getData("DNO").equalsIgnoreCase("Yes")
					|| dataUmLogin1.getData("EMP").equalsIgnoreCase("Yes")
					|| dataUmLogin1.getData("ENO").equalsIgnoreCase("Yes")
					|| dataUmLogin1.getData("EPL").equalsIgnoreCase("Yes")
					|| dataUmLogin1.getData("FID").equalsIgnoreCase("Yes")
					|| dataUmLogin1.getData("KNR").equalsIgnoreCase("Yes"))

			{
				if (dataUmLogin.getData("NFP").equalsIgnoreCase("Yes")) {
					_click(getElement(chkNFP));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

				}
				if (dataUmLogin.getData("PrivateCo").equalsIgnoreCase("Yes")) {
					_click(getElement(chkPrivateCo));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
			} else {
				if (dataUmLogin.getData("NFP").equalsIgnoreCase("Yes")) {
					_click(getElement(chkCYBNFP));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

				}
				if (dataUmLogin.getData("PrivateCo").equalsIgnoreCase("Yes")) {
					_click(getElement(chkCYBPrivateCo));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
				if (dataUmLogin.getData("CYBER").equalsIgnoreCase("Yes")) {
					_click(getElement(chkCyber));
					_wait(2000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}

		}

		else {
			if (dataUmLogin.getData("NFP").equalsIgnoreCase("Yes")) {
				_click(getElement(chkNFP));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			}
			if (dataUmLogin.getData("PrivateCo").equalsIgnoreCase("Yes")) {
				_click(getElement(chkPrivateCo));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			}
		}

		_wait(2000);
		long startTime1 = System.currentTimeMillis();
		long elapsedTime1=0L; 
		_click(getElement(btnCreateProposal));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		
		elapsedTime1 = (new Date()).getTime() - startTime1;
		CustomReporting.logReport("Time taken to Complete T04_Create Quote Transaction :  "+elapsedTime1 +" ms"); 
		System.out.println("Time taken to Complete T04_Create Quote Transaction :  "+elapsedTime1 +" ms");
		_writeToExcel("ResponseTime", "T04_Create Quote", ""+elapsedTime1, tcID);
		_wait(6000);

		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		_wait(10000);
		if (dataUmLogin1.getData("PrivateCo").equalsIgnoreCase("Yes"))
		{
			func._scrollToElement(getElement(lnkExpQuote1));
			_wait(5000);
			_click(getElement(lnkExpQuote1));
			}
			else if(dataUmLogin1.getData("NFP").equalsIgnoreCase("Yes"))
			{
				func._scrollToElement(getElement(lnkExpQuote2));
				_wait(5000);
				_click(getElement(lnkExpQuote2));
			}
			else if (dataUmLogin1.getData("CYBER").equalsIgnoreCase("Yes"))
			{
				func._scrollToElement(getElement(lnkExpQuote3));
				_wait(5000);
				_click(getElement(lnkExpQuote3));
			}
			else if (dataUmLogin1.getData("Excess").equalsIgnoreCase("Yes"))
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

			if (dataUmLogin.getData("UpdateCoverages").equalsIgnoreCase("Yes"))
			{
				_wait(2000);
				long startTime2 = System.currentTimeMillis();
				long elapsedTime2=0L; 
				_click(getElement(btnUpdateCoverages));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				
				elapsedTime2 = (new Date()).getTime() - startTime2;
				CustomReporting.logReport("Time taken to Complete T05_Click on Update Coverages Transaction :  "+elapsedTime2 +" ms"); 
				System.out.println("Time taken to Complete T05_Click on Update Coverages Transaction :  "+elapsedTime2 +" ms");
				_writeToExcel("ResponseTime", "T05_Click on Update Coverages", ""+elapsedTime2, tcID);
				
				//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
			}
		}
	}


		public void submitApp(String tcID, SoftAssert softAssert) throws Exception {
			WebDriverWait w = new WebDriverWait(getWebDriver(), 250);
			long startTime = System.currentTimeMillis();
			long elapsedTime = 0L;
			
			_wait(3000);
			if (func._isVisible(getElement(btnSubmitApplication)) == true) {
				startTime = System.currentTimeMillis();
				elapsedTime = 0L;
				_click(getElement(btnSubmitApplication));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				elapsedTime = (new Date()).getTime() - startTime;
				CustomReporting
						.logReport("Time taken to Complete T03_Submit application Transaction :  " + elapsedTime + " ms");
				System.out.println("Time taken to Complete T03_Submit application Transaction :  " + elapsedTime + " ms");

				_wait(5000);
				// w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));

			}

			if (func._isVisible(getElement(txtStatus)) == true) {
				CustomReporting.logReport("", "", "Status of the Application is CLEAR", StepStatus.REPORT.SUCCESS,
						new String[] {}, System.currentTimeMillis());

				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				CustomReporting.logReport("", "", "Application created successfully!", StepStatus.REPORT, new String[] {},
						System.currentTimeMillis());
			} else {
				CustomReporting.logReport("", "", "Status of the Application is Not CLEAR", StepStatus.REPORT.FAILURE,
						new String[] {}, System.currentTimeMillis());
			}
			_wait(10000);
			
		}

		@Override
		public void EditExposureInformation(String tcID, SoftAssert softAssert) throws Exception {
			PageData dataUmLogin = PageDataManager.instance().getPageData("Exposures", tcID);
			PageData dataUmLogin1 = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
			func._waitForPageToLoad(getWebDriver(), 50L);

			_wait(5000);
			WebDriverWait w = new WebDriverWait(getWebDriver(), 250);
			_wait(1000);
			getWebDriver().findElement(By.xpath("//span[text()='Submission']")).click();

			_wait(5000);
			// if (func._isVisible(getElement(txtRevenue)) == true) {

			if (!(dataUmLogin.getData("Revenue").equalsIgnoreCase(""))) {
				_setValue(getElement(txtRevenue), dataUmLogin.getData("Revenue"));
			}
			if ((func._isVisible(getElement(txtCorporateAssets)) == true)
					&& (!(dataUmLogin.getData("CorporateAssets").equalsIgnoreCase("")))) {
				_setValue(getElement(txtCorporateAssets), dataUmLogin.getData("CorporateAssets"));
			}

			if ((func._isVisible(getElement(txtRepCount)) == true)
					&& (!(dataUmLogin.getData("RepCount").equalsIgnoreCase("")))) {
				_setValue(getElement(txtRepCount), dataUmLogin.getData("RepCount"));
			}

			if ((func._isVisible(getElement(txtAssetsUnderManagement)) == true)
					&& (!(dataUmLogin.getData("AssetsUnderManagement").equalsIgnoreCase("")))) {
				_setValue(getElement(txtAssetsUnderManagement), dataUmLogin.getData("AssetsUnderManagement"));
			}

			if ((func._isVisible(getElement(txtCommissionRevenue)) == true)
					&& (!(dataUmLogin.getData("CommissionRevenue").equalsIgnoreCase("")))) {
				_setValue(getElement(txtCommissionRevenue), dataUmLogin.getData("CommissionRevenue"));
				_wait(2000);
			}

			if ((func._isVisible(getElement(txtGrossPremium)) == true)
					&& (!(dataUmLogin.getData("GrossPremium").equalsIgnoreCase("")))) {
				_setValue(getElement(txtGrossPremium), dataUmLogin.getData("GrossPremium"));
			}
			
			if (!dataUmLogin.getData("MPLHazardInput").equalsIgnoreCase(""))
			{
				_click(getElement(txtMPLHazard));
				_wait(2000);
				_setValue(getElement(txtMPLHazardInput), dataUmLogin.getData("MPLHazardInput"));
				_wait(2000);
				String expoption1 = "//um-dropdown-list//*[contains(text(),\""
						+ dataUmLogin.getData("MPLHazardInput") + "\")]";
				WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
				expectedOption1.click();
				// func.setValue6();
				func.setValue9();
			}
			if (func._isVisible(getElement(txtTotalEmployees)) == true) {
				if (!(dataUmLogin.getData("UnionAllClass3").equalsIgnoreCase(""))) {
					_setValue(getElement(txtUnionAllClass3), dataUmLogin.getData("UnionAllClass3"));
					_clickTab();
					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionFulltimeClass3").equalsIgnoreCase(""))) {
					_setValue(getElement(txtNonUnionFulltimeClass3), dataUmLogin.getData("NonUnionFulltimeClass3"));
					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionICsClass3").equalsIgnoreCase(""))) {
					_setValue(getElement(txtNonUnionICsClass3), dataUmLogin.getData("NonUnionICsClass3"));

					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionParttimetimeClass3").equalsIgnoreCase(""))) {
					_setValue(getElement(txtNonUnionParttimetimeClass3), dataUmLogin.getData("NonUnionParttimetimeClass3"));

					_wait(1000);
				}

				if (!(dataUmLogin.getData("UnionAllClass3NJ").equalsIgnoreCase(""))) {
					_setValue(getElement(txtUnionAllClass3NJ), dataUmLogin.getData("UnionAllClass3NJ"));
					_clickTab();
					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionFulltimeClass3NJ").equalsIgnoreCase(""))) {
					_setValue(getElement(txtNonUnionFulltimeClass3NJ), dataUmLogin.getData("NonUnionFulltimeClass3NJ"));

					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionICsClass3NJ").equalsIgnoreCase(""))) {
					_setValue(getElement(txtNonUnionICsClass3NJ), dataUmLogin.getData("NonUnionICsClass3NJ"));

					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionParttimetimeClass3NJ").equalsIgnoreCase(""))) {
					_setValue(getElement(txtNonUnionParttimetimeClass3NJ),
							dataUmLogin.getData("NonUnionParttimetimeClass3NJ"));

					_wait(1000);
				}
				if (!(dataUmLogin.getData("ForeignEmpClass3").equalsIgnoreCase(""))) {
					_setValue(getElement(txtForeignEmpClass3), dataUmLogin.getData("ForeignEmpClass3"));
					_wait(1000);
				}

				if (!(dataUmLogin.getData("UnionAllClass2").equalsIgnoreCase(""))) {
					_setValue(getElement(txtUnionAllClass2), dataUmLogin.getData("UnionAllClass2"));

					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionFulltimeClass2").equalsIgnoreCase(""))) {
					_setValue(getElement(txtNonUnionFulltimeClass2), dataUmLogin.getData("NonUnionFulltimeClass2"));

					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionICsClass2").equalsIgnoreCase(""))) {

					_setValue(getElement(txtNonUnionICsClass2), dataUmLogin.getData("NonUnionICsClass2"));
					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionParttimetimeClass2").equalsIgnoreCase(""))) {

					_setValue(getElement(txtNonUnionParttimetimeClass2), dataUmLogin.getData("NonUnionParttimetimeClass2"));

					_wait(1000);
				}

				if (!(dataUmLogin.getData("UnionAllClass1").equalsIgnoreCase(""))) {
					_setValue(getElement(txtUnionAllClass1), dataUmLogin.getData("UnionAllClass1"));

					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionFulltimeClass1").equalsIgnoreCase(""))) {

					_setValue(getElement(txtNonUnionFulltimeClass1), dataUmLogin.getData("NonUnionFulltimeClass1"));

					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionICsClass1").equalsIgnoreCase(""))) {
					_setValue(getElement(txtNonUnionICsClass1), dataUmLogin.getData("NonUnionICsClass1"));

					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionParttimetimeClass1").equalsIgnoreCase(""))) {
					_setValue(getElement(txtNonUnionParttimetimeClass1), dataUmLogin.getData("NonUnionParttimetimeClass1"));

				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			}

			if (dataUmLogin1.getData("SlimProducts").equalsIgnoreCase("Yes")) {
				_wait(2000);
				if (!(dataUmLogin.getData("SPEmployeesAll").equalsIgnoreCase(""))) {
					_setValue(getElement(txtEmployeesAll), dataUmLogin.getData("SPEmployeesAll"));
				}

				if (!(dataUmLogin.getData("SPForeignEmployeesAll").equalsIgnoreCase(""))) {
					_wait(2000);
					_setValue(getElement(txtForeignEmployeesAll), dataUmLogin.getData("SPForeignEmployeesAll"));
				}
				_wait(4000);

				if (func._isVisible(getElement(txtRegisteredRepresentatives)) == true) {
					if (!(dataUmLogin.getData("ENORegisteredRepresentatives").equalsIgnoreCase(""))) {
						_setValue(getElement(txtRegisteredRepresentatives),
								dataUmLogin.getData("ENORegisteredRepresentatives"));
					}
				}
			}
		}

		@Override
		public void VerifyExposureInformation(String tcID, SoftAssert softAssert) throws Exception {
			PageData dataUmLogin = PageDataManager.instance().getPageData("Exposures", tcID);
			PageData dataUmLogin1 = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
			func._waitForPageToLoad(getWebDriver(), 50L);

			_wait(5000);
			WebDriverWait w = new WebDriverWait(getWebDriver(), 250);
			_wait(1000);
			getWebDriver().findElement(By.xpath("//span[text()='Submission']")).click();

			_wait(5000);
			// if (func._isVisible(getElement(txtRevenue)) == true) {
			
			CustomReporting.logReport("Vealidaing the updated Exposure Information");

			if (!(dataUmLogin.getData("Revenue").equalsIgnoreCase(""))) {

				WebElement weRevenue = (WebElement) getElement(txtRevenue).getNative();
				String umRevenue = weRevenue.getAttribute("value").trim();
				if (dataUmLogin.getData("Revenue").trim().equalsIgnoreCase(umRevenue.replace(",", ""))) {
					CustomReporting.logReport("", "",
							"Verified Revenue : " + dataUmLogin.getData("Revenue") + " successfully updated",
							StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				} else {
					CustomReporting.logReport("", "", "Revenue : " + dataUmLogin.getData("Revenue") + " is not updated", "",
							StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
					// throw new RuntimeException();
				}

			}
			if ((func._isVisible(getElement(txtCorporateAssets)) == true)
					&& (!(dataUmLogin.getData("CorporateAssets").equalsIgnoreCase("")))) {
				WebElement weCorporateAssets = (WebElement) getElement(txtCorporateAssets).getNative();
				String umCorporateAssets = weCorporateAssets.getAttribute("value").trim();
				if (dataUmLogin.getData("CorporateAssets").trim().equalsIgnoreCase(umCorporateAssets.replace(",", ""))) {
					CustomReporting.logReport("", "",
							"Verified Corporate Asset : " + dataUmLogin.getData("CorporateAssets")
									+ " successfully updated",
							StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				} else {
					CustomReporting.logReport("", "",
							"Corporate Asset  : " + dataUmLogin.getData("CorporateAssets") + " is not updated", "",
							StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
					// throw new RuntimeException();
				}

			}

			if ((func._isVisible(getElement(txtRepCount)) == true)
					&& (!(dataUmLogin.getData("RepCount").equalsIgnoreCase("")))) {
				WebElement weRepCount = (WebElement) getElement(txtRepCount).getNative();
				String umRepCount = weRepCount.getAttribute("value").trim();
				if (dataUmLogin.getData("RepCount").trim().equalsIgnoreCase(umRepCount)) {
					CustomReporting.logReport("", "",
							"Verified Rep Count : " + dataUmLogin.getData("RepCount") + " successfully updated",
							StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				} else {
					CustomReporting.logReport("", "", "Rep Count  : " + dataUmLogin.getData("RepCount") + " is not updated",
							"", StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
					// throw new RuntimeException();
				}

			}

			if ((func._isVisible(getElement(txtAssetsUnderManagement)) == true)
					&& (!(dataUmLogin.getData("AssetsUnderManagement").equalsIgnoreCase("")))) {
				WebElement weAssetUnderManagement = (WebElement) getElement(txtAssetsUnderManagement).getNative();
				String umAssetUnderManagement = weAssetUnderManagement.getAttribute("value").trim();
				if (dataUmLogin.getData("AssetsUnderManagement").trim().equalsIgnoreCase(umAssetUnderManagement)) {
					CustomReporting.logReport("", "",
							"Asset under Management : " + dataUmLogin.getData("AssetsUnderManagement")
									+ " successfully updated",
							StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				} else {
					CustomReporting.logReport("", "",
							"Asset under Management  : " + dataUmLogin.getData("AssetsUnderManagement") + " is not updated",
							"", StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
					// throw new RuntimeException();
				}
			}

			if ((func._isVisible(getElement(txtCommissionRevenue)) == true)
					&& (!(dataUmLogin.getData("CommissionRevenue").equalsIgnoreCase("")))) {

				WebElement weCommissionRevenue = (WebElement) getElement(txtCommissionRevenue).getNative();
				String umCommissionRevenue = weCommissionRevenue.getAttribute("value").trim();
				if (dataUmLogin.getData("CommissionRevenue").trim().equalsIgnoreCase(umCommissionRevenue)) {
					CustomReporting.logReport("", "",
							"Commission Revenue : " + dataUmLogin.getData("CommissionRevenue") + " successfully updated",
							StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				} else {
					CustomReporting.logReport("", "",
							"Commission Revenue : " + dataUmLogin.getData("CommissionRevenue") + " is not updated", "",
							StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
					// throw new RuntimeException();
				}
				_wait(2000);
			}

			if ((func._isVisible(getElement(txtGrossPremium)) == true)
					&& (!(dataUmLogin.getData("GrossPremium").equalsIgnoreCase("")))) {
				WebElement weGrossPremium = (WebElement) getElement(txtGrossPremium).getNative();
				String umGrossPremium = weGrossPremium.getAttribute("value").trim();
				if (dataUmLogin.getData("GrossPremium").trim().equalsIgnoreCase(umGrossPremium)) {
					CustomReporting.logReport("", "",
							"Gross Premium : " + dataUmLogin.getData("GrossPremium") + " successfully updated",
							StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				} else {
					CustomReporting.logReport("", "",
							"Gross Premium : " + dataUmLogin.getData("GrossPremium") + " is not updated", "",
							StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
					// throw new RuntimeException();
				}
			}
			if (func._isVisible(getElement(txtTotalEmployees)) == true) {
				if (!(dataUmLogin.getData("UnionAllClass3").equalsIgnoreCase(""))) {
					WebElement weUnionAllClass3 = (WebElement) getElement(txtUnionAllClass3).getNative();
					String umUnionAllClass3 = weUnionAllClass3.getAttribute("value").trim();
					if (dataUmLogin.getData("UnionAllClass3").trim().equalsIgnoreCase(umUnionAllClass3)) {
						CustomReporting.logReport("", "",
								"UnionAllClass3 : " + dataUmLogin.getData("UnionAllClass3") + " successfully updated",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					} else {
						CustomReporting.logReport("", "",
								"UnionAllClass3 : " + dataUmLogin.getData("UnionAllClass3") + " is not updated", "",
								StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
						// throw new RuntimeException();
					}
					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionFulltimeClass3").equalsIgnoreCase(""))) {

					WebElement weNonUnionFulltimeClass3 = (WebElement) getElement(txtNonUnionFulltimeClass3).getNative();
					String umNonUnionFulltimeClass3 = weNonUnionFulltimeClass3.getAttribute("value").trim();
					if (dataUmLogin.getData("NonUnionFulltimeClass3").trim().equalsIgnoreCase(umNonUnionFulltimeClass3)) {
						CustomReporting.logReport("", "",
								"NonUnionFulltimeClass3 : " + dataUmLogin.getData("NonUnionFulltimeClass3")
										+ " successfully updated",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					} else {
						CustomReporting.logReport("", "",
								"NonUnionFulltimeClass3 : " + dataUmLogin.getData("NonUnionFulltimeClass3")
										+ " is not updated",
								"", StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
						// throw new RuntimeException();
					}

				}

				if (!(dataUmLogin.getData("NonUnionICsClass3").equalsIgnoreCase(""))) {

					WebElement weNonUnionICsClass3 = (WebElement) getElement(txtNonUnionICsClass3).getNative();
					String umNonUnionICsClass3 = weNonUnionICsClass3.getAttribute("value").trim();
					if (dataUmLogin.getData("NonUnionICsClass3").trim().equalsIgnoreCase(umNonUnionICsClass3)) {
						CustomReporting.logReport("", "",
								"NonUnionICsClass3 : " + dataUmLogin.getData("NonUnionICsClass3") + " successfully updated",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					} else {
						CustomReporting.logReport("", "",
								"NonUnionICsClass3 : " + dataUmLogin.getData("NonUnionICsClass3") + " is not updated", "",
								StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
						// throw new RuntimeException();
					}

					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionParttimetimeClass3").equalsIgnoreCase(""))) {

					WebElement weNonUnionParttimetimeClass3 = (WebElement) getElement(txtNonUnionParttimetimeClass3)
							.getNative();
					String umNonUnionParttimetimeClass3 = weNonUnionParttimetimeClass3.getAttribute("value").trim();
					if (dataUmLogin.getData("NonUnionParttimetimeClass3").trim()
							.equalsIgnoreCase(umNonUnionParttimetimeClass3)) {
						CustomReporting.logReport("", "",
								"NonUnionParttimetimeClass3 : " + dataUmLogin.getData("NonUnionParttimetimeClass3")
										+ " successfully updated",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					} else {
						CustomReporting.logReport("", "",
								"NonUnionParttimetimeClass3 : " + dataUmLogin.getData("NonUnionParttimetimeClass3")
										+ " is not updated",
								"", StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
						// throw new RuntimeException();
					}

					_wait(1000);

				}

				if (!(dataUmLogin.getData("UnionAllClass3NJ").equalsIgnoreCase(""))) {

					WebElement weUnionAllClass3NJ = (WebElement) getElement(txtUnionAllClass3NJ).getNative();
					String umUnionAllClass3NJ = weUnionAllClass3NJ.getAttribute("value").trim();
					if (dataUmLogin.getData("UnionAllClass3NJ").trim().equalsIgnoreCase(umUnionAllClass3NJ)) {
						CustomReporting.logReport("", "",
								"UnionAllClass3NJ : " + dataUmLogin.getData("UnionAllClass3NJ") + " successfully updated",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					} else {
						CustomReporting.logReport("", "",
								"UnionAllClass3NJ : " + dataUmLogin.getData("UnionAllClass3NJ") + " is not updated", "",
								StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
						// throw new RuntimeException();
					}

					_wait(1000);

				}

				if (!(dataUmLogin.getData("NonUnionFulltimeClass3NJ").equalsIgnoreCase(""))) {

					WebElement weNonUnionFulltimeClass3NJ = (WebElement) getElement(txtNonUnionFulltimeClass3NJ)
							.getNative();
					String umNonUnionFulltimeClass3NJ = weNonUnionFulltimeClass3NJ.getAttribute("value").trim();
					if (dataUmLogin.getData("NonUnionFulltimeClass3NJ").trim()
							.equalsIgnoreCase(umNonUnionFulltimeClass3NJ)) {
						CustomReporting.logReport("", "",
								"NonUnionFulltimeClass3NJ : " + dataUmLogin.getData("NonUnionFulltimeClass3NJ")
										+ " successfully updated",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					} else {
						CustomReporting.logReport("", "",
								"NonUnionFulltimeClass3NJ : " + dataUmLogin.getData("NonUnionFulltimeClass3NJ")
										+ " is not updated",
								"", StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
						// throw new RuntimeException();
					}

					_wait(1000);

				}

				if (!(dataUmLogin.getData("NonUnionICsClass3NJ").equalsIgnoreCase(""))) {

					WebElement weNonUnionICsClass3NJ = (WebElement) getElement(txtNonUnionICsClass3NJ).getNative();
					String umNonUnionICsClass3NJ = weNonUnionICsClass3NJ.getAttribute("value").trim();
					if (dataUmLogin.getData("NonUnionICsClass3NJ").trim().equalsIgnoreCase(umNonUnionICsClass3NJ)) {
						CustomReporting.logReport("", "",
								"NonUnionICsClass3NJ : " + dataUmLogin.getData("NonUnionICsClass3NJ")
										+ " successfully updated",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					} else {
						CustomReporting.logReport("", "",
								"NonUnionICsClass3NJ : " + dataUmLogin.getData("NonUnionICsClass3NJ") + " is not updated",
								"", StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
						// throw new RuntimeException();
					}

					_wait(1000);

				}

				if (!(dataUmLogin.getData("NonUnionParttimetimeClass3NJ").equalsIgnoreCase(""))) {

					WebElement weNonUnionParttimetimeClass3NJ = (WebElement) getElement(txtNonUnionParttimetimeClass3NJ)
							.getNative();
					String umNonUnionParttimetimeClass3NJ = weNonUnionParttimetimeClass3NJ.getAttribute("value").trim();
					if (dataUmLogin.getData("NonUnionParttimetimeClass3NJ").trim()
							.equalsIgnoreCase(umNonUnionParttimetimeClass3NJ)) {
						CustomReporting.logReport("", "",
								"NonUnionParttimetimeClass3NJ : " + dataUmLogin.getData("NonUnionParttimetimeClass3NJ")
										+ " successfully updated",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					} else {
						CustomReporting.logReport("", "",
								"NonUnionParttimetimeClass3NJ : " + dataUmLogin.getData("NonUnionParttimetimeClass3NJ")
										+ " is not updated",
								"", StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
						// throw new RuntimeException();
					}

					_wait(1000);

				}
				if (!(dataUmLogin.getData("ForeignEmpClass3").equalsIgnoreCase(""))) {

					WebElement weForeignEmpClass3 = (WebElement) getElement(txtForeignEmpClass3).getNative();
					String umForeignEmpClass3 = weForeignEmpClass3.getAttribute("value").trim();
					if (dataUmLogin.getData("ForeignEmpClass3").trim().equalsIgnoreCase(umForeignEmpClass3)) {
						CustomReporting.logReport("", "",
								"ForeignEmpClass3 : " + dataUmLogin.getData("ForeignEmpClass3") + " successfully updated",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					} else {
						CustomReporting.logReport("", "",
								"ForeignEmpClass3 : " + dataUmLogin.getData("ForeignEmpClass3") + " is not updated", "",
								StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
						// throw new RuntimeException();
					}

					_wait(1000);

				}

				if (!(dataUmLogin.getData("UnionAllClass2").equalsIgnoreCase(""))) {

					WebElement weUnionAllClass2 = (WebElement) getElement(txtUnionAllClass2).getNative();
					String umUnionAllClass2 = weUnionAllClass2.getAttribute("value").trim();
					if (dataUmLogin.getData("ForeignEmpClass3").trim().equalsIgnoreCase(umUnionAllClass2)) {
						CustomReporting.logReport("", "",
								"UnionAllClass2 : " + dataUmLogin.getData("UnionAllClass2") + " successfully updated",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					} else {
						CustomReporting.logReport("", "",
								"UnionAllClass2 : " + dataUmLogin.getData("UnionAllClass2") + " is not updated", "",
								StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
						// throw new RuntimeException();
					}

					_wait(1000);

				}

				if (!(dataUmLogin.getData("NonUnionFulltimeClass2").equalsIgnoreCase(""))) {

					WebElement weNonUnionFulltimeClass2 = (WebElement) getElement(txtNonUnionFulltimeClass2).getNative();
					String umNonUnionFulltimeClass2 = weNonUnionFulltimeClass2.getAttribute("value").trim();
					if (dataUmLogin.getData("NonUnionFulltimeClass2").trim().equalsIgnoreCase(umNonUnionFulltimeClass2)) {
						CustomReporting.logReport("", "",
								"NonUnionFulltimeClass2 : " + dataUmLogin.getData("NonUnionFulltimeClass2")
										+ " successfully updated",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
					} else {
						CustomReporting.logReport("", "",
								"NonUnionFulltimeClass2 : " + dataUmLogin.getData("NonUnionFulltimeClass2")
										+ " is not updated",
								"", StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
						// throw new RuntimeException();
					}

					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionICsClass2").equalsIgnoreCase(""))) {

					VerifyAttributeValue("NonUnionICsClass2", getElement(txtNonUnionICsClass2), dataUmLogin);

				}

				if (!(dataUmLogin.getData("NonUnionParttimetimeClass2").equalsIgnoreCase(""))) {

					VerifyAttributeValue("NonUnionParttimetimeClass2", getElement(txtNonUnionParttimetimeClass2),
							dataUmLogin);

				}

				if (!(dataUmLogin.getData("UnionAllClass1").equalsIgnoreCase(""))) {

					VerifyAttributeValue("UnionAllClass1", getElement(txtUnionAllClass1), dataUmLogin);

				}

				if (!(dataUmLogin.getData("NonUnionFulltimeClass1").equalsIgnoreCase(""))) {

					VerifyAttributeValue("NonUnionFulltimeClass1", getElement(txtNonUnionFulltimeClass1), dataUmLogin);

					_wait(1000);
				}

				if (!(dataUmLogin.getData("NonUnionICsClass1").equalsIgnoreCase(""))) {
					_setValue(getElement(txtNonUnionICsClass1), dataUmLogin.getData("NonUnionICsClass1"));

					VerifyAttributeValue("NonUnionICsClass1", getElement(txtNonUnionICsClass1), dataUmLogin);

				}

				if (!(dataUmLogin.getData("NonUnionParttimetimeClass1").equalsIgnoreCase(""))) {

					VerifyAttributeValue("NonUnionParttimetimeClass1", getElement(txtNonUnionParttimetimeClass1),
							dataUmLogin);
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			}

			if (dataUmLogin1.getData("SlimProducts").equalsIgnoreCase("Yes")) {
				_wait(2000);
				if (!(dataUmLogin.getData("SPEmployeesAll").equalsIgnoreCase(""))) {

					VerifyAttributeValue("SPEmployeesAll", getElement(txtEmployeesAll), dataUmLogin);
				}

				if (!(dataUmLogin.getData("SPForeignEmployeesAll").equalsIgnoreCase(""))) {
					_wait(2000);

					VerifyAttributeValue("SPForeignEmployeesAll", getElement(txtForeignEmployeesAll), dataUmLogin);

				}
				_wait(4000);

				if (func._isVisible(getElement(txtRegisteredRepresentatives)) == true) {
					if (!(dataUmLogin.getData("ENORegisteredRepresentatives").equalsIgnoreCase(""))) {
						VerifyAttributeValue("ENORegisteredRepresentatives", getElement(txtRegisteredRepresentatives),
								dataUmLogin);
					}
				}
			}
		}

		public void VerifyAttributeValue(String colmnNameOfExpectedValue, Element ele, PageData dataUmLogin) {
			WebElement weOfFieldToBeVerify = (WebElement) ele.getNative();
			String umActualValue = weOfFieldToBeVerify.getAttribute("value").trim();
			if (dataUmLogin.getData(colmnNameOfExpectedValue).trim().equalsIgnoreCase(umActualValue)) {
				CustomReporting
						.logReport("", "",
								colmnNameOfExpectedValue + " : " + dataUmLogin.getData("colmnNameOfExpectedValue")
										+ " successfully updated",
								StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
			} else {
				CustomReporting.logReport("", "",
						colmnNameOfExpectedValue + " : " + dataUmLogin.getData("colmnNameOfExpectedValue")
								+ " is not updated",
						"", StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
				// throw new RuntimeException();
			}
		}


		@Override	
		public void VerifyCybSharedCheckBox(String tcID, SoftAssert softAssert) throws Exception{
			
			_click(getElement(lnkCybRating));
			
			_wait(10000);
			
			if(func._isVisible(getElement(chkSharedLimitCheckBox))) {
				
				CustomReporting
				.logReport("", "",
						"Check Box for shared field under Optional coverage enahancement is visible for CYB coverage as expected "
								+ "",
						StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				
			}else {
				
				CustomReporting
				.logReport("", "",
						"Check Box for shared field under Optional coverage enahancement is not visible for CYB coverage "
								+ "",
						StepStatus.FAILURE, new String[] {}, System.currentTimeMillis());
			}
		
			
		}
		

}