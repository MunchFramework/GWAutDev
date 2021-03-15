package com.everest.page.application.spi;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.GenericFunctions;
import com.everest.page.application.InsuredAppLoginPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class InsuredAppLoginPageImpl extends CustomAbstractPage implements InsuredAppLoginPage
{

	@Override
	public void InsuredAppLogin(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
		
		String strURL = "";
		 
			strURL = dataUmLogin.getData("InsuredApp_URL");
			CustomReporting.logReport("", "", "Application launched in Insured App with URL: " + strURL,
					StepStatus.REPORT, new String[] {}, System.currentTimeMillis());


		getWebDriver().navigate().to(strURL);
		func._waitForPageToLoad(getWebDriver(), 50L);
		getWebDriver().manage().window().maximize();
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		_wait(2000);

			_setValue(getElement(txt_username), dataUmLogin.getData("Username"));
			_wait(1000);
			_setValue(getElement(txt_password), dataUmLogin.getData("Password"));
			_wait(2000);
			_click(getElement(btn_Login));
			_wait(2000);
			while(!func._isVisible(getElement(rel_dropdown)))
			{
				_click(getElement(lnkQuotes));
			}
			
			
			
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		_wait(2000);
		

				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		CustomReporting.logReport("", "", "Logged in to the application successfully!", StepStatus.REPORT,
				new String[] {}, System.currentTimeMillis());
	}
	
	@Override
	public void InsuredAppLogOut(String tcID, SoftAssert softAssert) throws Exception 
	{
		_wait(2000);
		_click(getElement(btnLogout));
		_wait(2000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		CustomReporting.logReport("", "", "Logged Out Of the InsuredApp successfully!", StepStatus.REPORT,
				new String[] {}, System.currentTimeMillis());
	}
	
	@Override
	public void InsuredAppValidationPolicyChange(String tcID, SoftAssert softAssert) throws Exception 
	{
		
		PageData dataUmLogin = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
		_wait(4000);
		String Premium = dataUmLogin.getData("Premium2");
		WebElement release_doprdown = (WebElement)getElement(rel_dropdown).getNative();
		Select r_dd = new Select(release_doprdown);
		List<WebElement> all_releases = r_dd.getOptions();
		System.out.println(all_releases.size());
		int last_value = all_releases.size()-1;
		WebElement Latest_Release_Element = all_releases.get(last_value);
		release_doprdown.click();
		CustomReporting.logReport("Latest Insured App Release is : " +Latest_Release_Element.getText());//getAttribute("value"));
		Latest_Release_Element.click();
		_wait(4000);
		if(func._isVisible(getElement(id_txt)))
		{
			_setValue(getElement(id_txt),dataUmLogin.getData("RatingWorkSheetId2"));
			GenericFunctions.instance().setValue7();
			_wait(4000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
		if(func._isVisible(getElement(invalid_id))||func._isVisible(getElement(NoQuotes)))
		{
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			String uurrll = getWebDriver().getCurrentUrl().toString();
			String rel_url = uurrll.split("release=")[0];
			int rel_num = Integer.parseInt(uurrll.split("release=")[1]);
			System.out.println(rel_url+"   "+rel_num); 
			for(int i=1;i<10;i++)
			{
				getWebDriver().navigate().to(rel_url+"release="+(rel_num-i));
				if(func._isVisible(getElement(id_txt)))
				{
					_setValue(getElement(id_txt),dataUmLogin.getData("RatingWorkSheetId2"));
					GenericFunctions.instance().setValue7();
					_wait(4000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
				if(func._isVisible(getElement(premium_insuredapp)))
				{
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("Insured App Release is : " + rel_url+"="+(rel_num-i));
					break;
				}
				
			}
			
		}
		String Actual = func._getAttributeValue(getElement(premium_insuredapp), "TEXT");
		String values[] = Actual.split(" ");
		String Actualvalue = "$" + values[1];
		if (Actualvalue.equals(Premium))

		{
			CustomReporting.logReport("The Actual value in Insured app" + Actualvalue + " and premium value in PC are same during Policy Change " + Premium);
		} 
		else 
		{
			CustomReporting.logReport("The Actual value  in Insured app" + Actualvalue + " and premium value in PC does not match as expected during Policy Change " + Premium);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}

		_wait(2000);
		String targetxpath3 = "//*[contains(text(),'Logout')]";
		WebElement ele3 = (getWebDriver().findElement(By.xpath(targetxpath3)));
		_wait(2000);
		ele3.click();

	}
	
	public void InsuredAppValidationNB(String tcID, SoftAssert softAssert) throws InterruptedException 
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
		PageData dataRater = PageDataManager.instance().getPageData("Rater", tcID);
		String RatingId = dataUmLogin.getData("RatingWorkSheetId");
		String Premium = dataUmLogin.getData("Premium");
		_wait(4000);
		
		WebElement release_doprdown = (WebElement)getElement(rel_dropdown).getNative();
		Select r_dd = new Select(release_doprdown);
		List<WebElement> all_releases = r_dd.getOptions();
		System.out.println(all_releases.size());
		int last_value = all_releases.size()-1;
		WebElement Latest_Release_Element = all_releases.get(last_value);
		release_doprdown.click();
		func._waitForPageToLoad(getWebDriver(), 50L);
		CustomReporting.logReport("Latest Insured App Release is : " +Latest_Release_Element.getText());//getAttribute("value"));
		Latest_Release_Element.click();
		_wait(4000);
		
		if(func._isVisible(getElement(id_txt)))
		{
			_setValue(getElement(id_txt),RatingId);
			GenericFunctions.instance().setValue7();
			_wait(4000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
		if(func._isVisible(getElement(invalid_id))||func._isVisible(getElement(NoQuotes)))
		{
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			String uurrll = getWebDriver().getCurrentUrl().toString();
			String rel_url = uurrll.split("release=")[0];
			int rel_num = Integer.parseInt(uurrll.split("release=")[1]);
			System.out.println(rel_url+"   "+rel_num); 
			for(int i=1;i<10;i++)
			{
				getWebDriver().navigate().to(rel_url+"release="+(rel_num-i));
				if(func._isVisible(getElement(id_txt)))
				{
					_setValue(getElement(id_txt),RatingId);
					GenericFunctions.instance().setValue7();
					_wait(4000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
				if(func._isVisible(getElement(premium_insuredapp)))
				{
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("Insured App Release is : " + rel_url+"="+(rel_num-i));
					break;
				}
				
			}
			
		}
		String Actual = func._getAttributeValue(getElement(premium_insuredapp), "TEXT");
		String values[] = Actual.split(" ");
		String Actualvalue = "$" + values[1];
		if (Actualvalue.equals(Premium))
		{
			CustomReporting.logReport("The Actual value in Insured app" + Actualvalue + " and premium value in PC are same " + Premium);
		} 
		else
		{
			CustomReporting.logReport("The Actual value  in Insured app" + Actualvalue + "and premium value in PC does not match as expected " + Premium,
					StepStatus.SUCCESS);
			  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}

		
		try {
			if(!dataRater.getData("AvgPriorActsFactor").isEmpty())
			{
				func._scrollToElement(getElement(AvgPriorAct));
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				if (dataRater.getData("AvgPriorActsFactor").equals(_getAttributeValue(getElement(AvgPriorAct), "TEXT")))
				{
					CustomReporting.logReport("", "", "As per EPRO-75455 Avg Prior Acts Factor of Rater : "+dataRater.getData("AvgPriorActsFactor")+" matches with Insured App as Expected : "+_getAttributeValue(getElement(AvgPriorAct), "TEXT"), StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				} 
				else
				{
					CustomReporting.logReport("", "", "As per EPRO-75455 Avg Prior Acts Factor of Rater : "+dataRater.getData("AvgPriorActsFactor")+" does NOT matches with Insured App : "+_getAttributeValue(getElement(AvgPriorAct), "TEXT"), StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
					  
				}
			}
			
			if(!dataRater.getData("ExpMod_TableB").isEmpty())
			{
				func._scrollToElement(getElement(ExpMod_TabB));
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				if (dataRater.getData("ExpMod_TableB").equals(_getAttributeValue(getElement(ExpMod_TabB), "TEXT")))
				{
					CustomReporting.logReport("", "", "As per EPRO-75455 Experience Modifier Table B of Rater : "+dataRater.getData("ExpMod_TableB")+" matches with Insured App as Expected : "+_getAttributeValue(getElement(ExpMod_TabB), "TEXT"), StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				} 
				else
				{
					CustomReporting.logReport("", "", "As per EPRO-75455 Experience Modifier Table B of Rater : "+dataRater.getData("ExpMod_TableB")+" does NOT matches with Insured App : "+_getAttributeValue(getElement(ExpMod_TabB), "TEXT"), StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
					  
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_wait(2000);

		String targetxpath3 = "//*[contains(text(),'Logout')]";
		WebElement ele3 = (getWebDriver().findElement(By.xpath(targetxpath3)));
		_wait(2000);
		ele3.click();
		_wait(2000);
		
		if(func._isVisible(getElement(txt_username))==false)
		{
			ele3.click();
		}
	}

	@Override
	public void InsuredAppValidationPolicyChangeRunOff(String tcID, SoftAssert softAssert, String shortRun, String Premium1)
			throws Exception {

		PageData dataUmLogin = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
		_wait(4000);
		String Premium = dataUmLogin.getData(Premium1);
		WebElement release_doprdown = (WebElement)getElement(rel_dropdown).getNative();
		Select r_dd = new Select(release_doprdown);
		List<WebElement> all_releases = r_dd.getOptions();
		System.out.println(all_releases.size());
		int last_value = all_releases.size()-1;
		WebElement Latest_Release_Element = all_releases.get(last_value);
		release_doprdown.click();
		CustomReporting.logReport("Latest Insured App Release is : " +Latest_Release_Element.getText());//getAttribute("value"));
		Latest_Release_Element.click();
		_wait(4000);
		if(func._isVisible(getElement(id_txt)))
		{
			_setValue(getElement(id_txt),dataUmLogin.getData(shortRun));
			GenericFunctions.instance().setValue7();
			_wait(4000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
		if(func._isVisible(getElement(invalid_id))||func._isVisible(getElement(NoQuotes)))
		{
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			String uurrll = getWebDriver().getCurrentUrl().toString();
			String rel_url = uurrll.split("release=")[0];
			int rel_num = Integer.parseInt(uurrll.split("release=")[1]);
			System.out.println(rel_url+"   "+rel_num); 
			for(int i=1;i<10;i++)
			{
				getWebDriver().navigate().to(rel_url+"release="+(rel_num-i));
				if(func._isVisible(getElement(id_txt)))
				{
					_setValue(getElement(id_txt),dataUmLogin.getData(shortRun));
					GenericFunctions.instance().setValue7();
					_wait(4000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
				if(func._isVisible(getElement(premium_insuredapp)))
				{
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("Insured App Release is : " + rel_url+"="+(rel_num-i));
					break;
				}
				
			}
			
		}
		String Actual = func._getAttributeValue(getElement(premium_insuredapp), "TEXT");
		String values[] = Actual.split(" ");
		String Actualvalue = "$" + values[1];
		if (Actualvalue.equals(Premium))

		{
			CustomReporting.logReport("The Actual value in Insured app" + Actualvalue + " and premium value in PC are same during Policy Change " + Premium);
		} 
		else 
		{
			CustomReporting.logReport("The Actual value  in Insured app" + Actualvalue + " and premium value in PC does not match as expected during Policy Change " + Premium);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}

		_wait(2000);
		
		_click(getElement(lnkQuotes));
		
		String targetxpath3 = "//*[contains(text(),'Logout')]";
		WebElement ele3 = (getWebDriver().findElement(By.xpath(targetxpath3)));
		_wait(2000);
		ele3.click();
		
	}
	
	public void InsuredAppValidation_BP(String tcID, SoftAssert softAssert) throws InterruptedException 
	{
		PageData dataInsApp = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
		PageData dataRater = PageDataManager.instance().getPageData("Rater", tcID);
		String RatingId = dataInsApp.getData("RatingWorkSheetId");
		String Premium = dataInsApp.getData("Premium");
		_wait(4000);
		
		WebElement release_doprdown = (WebElement)getElement(rel_dropdown).getNative();
		Select r_dd = new Select(release_doprdown);
		List<WebElement> all_releases = r_dd.getOptions();
		System.out.println(all_releases.size());
		int last_value = all_releases.size()-1;
		WebElement Latest_Release_Element = all_releases.get(last_value);
		release_doprdown.click();
		func._waitForPageToLoad(getWebDriver(), 50L);
		CustomReporting.logReport("Latest Insured App Release is : " +Latest_Release_Element.getText());//getAttribute("value"));
		Latest_Release_Element.click();
		_wait(4000);
		
		if(func._isVisible(getElement(id_txt)))
		{
			_setValue(getElement(id_txt),RatingId);
			GenericFunctions.instance().setValue7();
			_wait(4000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
		if(func._isVisible(getElement(invalid_id))||func._isVisible(getElement(NoQuotes)))
		{
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			String uurrll = getWebDriver().getCurrentUrl().toString();
			String rel_url = uurrll.split("release=")[0];
			int rel_num = Integer.parseInt(uurrll.split("release=")[1]);
			System.out.println(rel_url+"   "+rel_num); 
			for(int i=1;i<10;i++)
			{
				getWebDriver().navigate().to(rel_url+"release="+(rel_num-i));
				if(func._isVisible(getElement(id_txt)))
				{
					_setValue(getElement(id_txt),RatingId);
					GenericFunctions.instance().setValue7();
					_wait(4000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
				if(func._isVisible(getElement(premium_insuredapp)))
				{
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("Insured App Release is : " + rel_url+"="+(rel_num-i));
					break;
				}
				
			}
			
		}
		
		int NoOfCov = getElement("Packaged_Quotes").getCount();
		for(int j=1;j<=NoOfCov;j++)
		{
			String uurrll = getWebDriver().getCurrentUrl().toString();
			String cov_quote_xpath = "(//td/div//a)["+j+"]";
			WebElement link_cov = getWebDriver().findElement(By.xpath(cov_quote_xpath));
			link_cov.click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			String Cov_Name = _getAttributeValue(getElement(Rate_Plan), "TEXT");
			String InsApp_BP =  _getAttributeValue(getElement(BP_InsApp), "TEXT");
			
			switch(Cov_Name)
			{
			case "Cyber": 
				if(dataRater.getData("CYBER_BP").equalsIgnoreCase(InsApp_BP))
				{
					func._scrollToElement(getElement(BP_InsApp));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "CYBER Base Premium of Rater : "+dataRater.getData("CYBER_BP")+" matches with Base Premium on Insured App as Expected : "+InsApp_BP, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
					
				}
				else
				{
					CustomReporting.logReport("", "", "CYBER Base Premium of Rater : "+dataRater.getData("CYBER_BP")+" Does NOT Match with Base Premium on Insured App : "+InsApp_BP, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			case "Employed Lawyers Professional Liability": 
				if(dataRater.getData("EMP_BP").equalsIgnoreCase(InsApp_BP))
				{
					func._scrollToElement(getElement(BP_InsApp));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "EMP Base Premium of Rater : "+dataRater.getData("EMP_BP")+" matches with Base Premium on Insured App as Expected : "+InsApp_BP, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				}
				else
				{
					CustomReporting.logReport("", "", "EMP Base Premium of Rater : "+dataRater.getData("EMP_BP")+" Does NOT Match with Base Premium on Insured App : "+InsApp_BP, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			case "Crime": 
				if(dataRater.getData("CRIME_BP").equalsIgnoreCase(InsApp_BP))
				{
					func._scrollToElement(getElement(BP_InsApp));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "CRIME Base Premium of Rater : "+dataRater.getData("CRIME_BP")+" matches with Base Premium on Insured App as Expected : "+InsApp_BP, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				}
				else
				{
					CustomReporting.logReport("", "", "CRIME Base Premium of Rater : "+dataRater.getData("CRIME_BP")+" Does NOT Match with Base Premium on Insured App : "+InsApp_BP, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			case "Miscellaneous PL": 
				if(dataRater.getData("ENO_BP").equalsIgnoreCase(InsApp_BP))
				{
					func._scrollToElement(getElement(BP_InsApp));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "ENO Base Premium of Rater : "+dataRater.getData("ENO_BP")+" matches with Base Premium on Insured App as Expected : "+InsApp_BP, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				}
				else
				{
					CustomReporting.logReport("", "", "ENO Base Premium of Rater : "+dataRater.getData("ENO_BP")+" Does NOT Match with Base Premium on Insured App : "+InsApp_BP, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			case "Fiduciary": 
				if(dataRater.getData("FID_BP").equalsIgnoreCase(InsApp_BP))
				{
					func._scrollToElement(getElement(BP_InsApp));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "FID Base Premium of Rater : "+dataRater.getData("FID_BP")+" matches with Base Premium on Insured App as Expected : "+InsApp_BP, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				}
				else
				{
					CustomReporting.logReport("", "", "FID Base Premium of Rater : "+dataRater.getData("FID_BP")+" Does NOT Match with Base Premium on Insured App : "+InsApp_BP, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			case "EPL New": 
				if(dataRater.getData("EPL_BP").equalsIgnoreCase(InsApp_BP))
				{
					func._scrollToElement(getElement(BP_InsApp));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "EPL Base Premium of Rater : "+dataRater.getData("EPL_BP")+" matches with Base Premium on Insured App as Expected : "+InsApp_BP, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				}
				else
				{
					CustomReporting.logReport("", "", "EPL Base Premium of Rater : "+dataRater.getData("EPL_BP")+" Does NOT Match with Base Premium on Insured App : "+InsApp_BP, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			case "Kidnap &Ransom": 
				if(dataRater.getData("KNR_BP").equalsIgnoreCase(InsApp_BP))
				{
					func._scrollToElement(getElement(BP_InsApp));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "KNR Base Premium of Rater : "+dataRater.getData("KNR_BP")+" matches with Base Premium on Insured App as Expected : "+InsApp_BP, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				}
				else
				{
					CustomReporting.logReport("", "", "KNR Base Premium of Rater : "+dataRater.getData("KNR_BP")+" Does NOT Match with Base Premium on Insured App : "+InsApp_BP, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			case "D and O New": 
				if(dataRater.getData("DNO_BP").equalsIgnoreCase(InsApp_BP))
				{
					func._scrollToElement(getElement(BP_InsApp));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "DNO Base Premium of Rater : "+dataRater.getData("DNO_BP")+" matches with Base Premium on Insured App as Expected : "+InsApp_BP, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				}
				else
				{
					CustomReporting.logReport("", "", "DNO Base Premium of Rater : "+dataRater.getData("DNO_BP")+" Does NOT Match with Base Premium on Insured App : "+InsApp_BP, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			default:
				break;
				
			}
			
			getWebDriver().navigate().to(uurrll);
			_wait(2000);
		}
		String targetxpath3 = "//*[contains(text(),'Logout')]";
		WebElement ele3 = (getWebDriver().findElement(By.xpath(targetxpath3)));
		_wait(2000);
		ele3.click();

	}
	
	public void InsuredAppValidation_ST(String tcID, SoftAssert softAssert) throws InterruptedException 
	{
		PageData dataInsApp = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
		PageData dataRater = PageDataManager.instance().getPageData("Rater", tcID);
		String RatingId = dataInsApp.getData("RatingWorkSheetId");
		_wait(4000);
		
		WebElement release_doprdown = (WebElement)getElement(rel_dropdown).getNative();
		Select r_dd = new Select(release_doprdown);
		List<WebElement> all_releases = r_dd.getOptions();
		System.out.println(all_releases.size());
		int last_value = all_releases.size()-1;
		WebElement Latest_Release_Element = all_releases.get(last_value);
		release_doprdown.click();
		func._waitForPageToLoad(getWebDriver(), 50L);
		CustomReporting.logReport("Latest Insured App Release is : " +Latest_Release_Element.getText());//getAttribute("value"));
		Latest_Release_Element.click();
		_wait(4000);
		
		if(func._isVisible(getElement(id_txt)))
		{
			_setValue(getElement(id_txt),RatingId);
			GenericFunctions.instance().setValue7();
			_wait(4000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
		if(func._isVisible(getElement(invalid_id))||func._isVisible(getElement(NoQuotes)))
		{
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			String uurrll = getWebDriver().getCurrentUrl().toString();
			String rel_url = uurrll.split("release=")[0];
			int rel_num = Integer.parseInt(uurrll.split("release=")[1]);
			System.out.println(rel_url+"   "+rel_num); 
			for(int i=1;i<10;i++)
			{
				getWebDriver().navigate().to(rel_url+"release="+(rel_num-i));
				if(func._isVisible(getElement(id_txt)))
				{
					_setValue(getElement(id_txt),RatingId);
					GenericFunctions.instance().setValue7();
					_wait(4000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
				if(func._isVisible(getElement(premium_insuredapp)))
				{
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("Insured App Release is : " + rel_url+"="+(rel_num-i));
					break;
				}
				
			}
			
		}
		
		int NoOfCov = getElement("Packaged_Quotes").getCount();
		for(int j=1;j<=NoOfCov;j++)
		{
			String uurrll = getWebDriver().getCurrentUrl().toString();
			String cov_quote_xpath = "(//td/div//a)["+j+"]";
			WebElement link_cov = getWebDriver().findElement(By.xpath(cov_quote_xpath));
			link_cov.click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			String Cov_Name = _getAttributeValue(getElement(Rate_Plan), "TEXT");
			String InsApp_SubTotal =  _getAttributeValue(getElement(SubTotal_InsApp), "TEXT");
			
			
			
			switch(Cov_Name)
			{
			case "Cyber": 
				if(dataRater.getData("CYBER_ST").equalsIgnoreCase(InsApp_SubTotal))
				{
					func._scrollToElement(getElement(SubTotal_InsApp));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "CYBER Sub Total of Rater : "+dataRater.getData("CYBER_ST")+" matches with Sub Total on Insured App as Expected : "+InsApp_SubTotal, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
					
				}
				else
				{
					CustomReporting.logReport("", "", "CYBER Sub Total of Rater : "+dataRater.getData("CYBER_ST")+" Does NOT Match with Sub Total on Insured App : "+InsApp_SubTotal, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			case "Employed Lawyers Professional Liability": 
				String InsApp_SubTotal_EMP =  _getAttributeValue(getElement(SubTotal_InsApp_EMP), "TEXT");
				if(dataRater.getData("EMP_ST").equalsIgnoreCase(InsApp_SubTotal_EMP))
				{
					func._scrollToElement(getElement(SubTotal_InsApp_EMP));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "EMP Sub Total of Rater : "+dataRater.getData("EMP_ST")+" matches with Sub Total on Insured App as Expected : "+InsApp_SubTotal_EMP, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				}
				else
				{
					CustomReporting.logReport("", "", "EMP Sub Total of Rater : "+dataRater.getData("EMP_ST")+" Does NOT Match with Sub Total on Insured App : "+InsApp_SubTotal_EMP, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			case "Crime": 
				if(dataRater.getData("CRIME_ST").equalsIgnoreCase(InsApp_SubTotal))
				{
					func._scrollToElement(getElement(SubTotal_InsApp));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "CRIME Sub Total of Rater : "+dataRater.getData("CRIME_ST")+" matches with Sub Total on Insured App as Expected : "+InsApp_SubTotal, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				}
				else
				{
					CustomReporting.logReport("", "", "CRIME Sub Total of Rater : "+dataRater.getData("CRIME_ST")+" Does NOT Match with Sub Total on Insured App : "+InsApp_SubTotal, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			case "Miscellaneous PL": 
				if(dataRater.getData("ENO_ST").equalsIgnoreCase(InsApp_SubTotal))
				{
					func._scrollToElement(getElement(SubTotal_InsApp));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "ENO Sub Total of Rater : "+dataRater.getData("ENO_ST")+" matches with Sub Total on Insured App as Expected : "+InsApp_SubTotal, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				}
				else
				{
					CustomReporting.logReport("", "", "ENO Sub Total of Rater : "+dataRater.getData("ENO_ST")+" Does NOT Match with Sub Total on Insured App : "+InsApp_SubTotal, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			case "Fiduciary": 
				if(dataRater.getData("FID_ST").equalsIgnoreCase(InsApp_SubTotal))
				{
					func._scrollToElement(getElement(SubTotal_InsApp));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "FID Sub Total of Rater : "+dataRater.getData("FID_ST")+" matches with Sub Total on Insured App as Expected : "+InsApp_SubTotal, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				}
				else
				{
					CustomReporting.logReport("", "", "FID Sub Total of Rater : "+dataRater.getData("FID_ST")+" Does NOT Match with Sub Total on Insured App : "+InsApp_SubTotal, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			case "EPL New": 
				String InsApp_SubTotal_EPL =  _getAttributeValue(getElement(SubTotal_InsApp_DNO_EPL), "TEXT");
				
				if(dataRater.getData("EPL_ST").equalsIgnoreCase(InsApp_SubTotal_EPL))
				{
					func._scrollToElement(getElement(SubTotal_InsApp_DNO_EPL));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "EPL Sub Total of Rater : "+dataRater.getData("EPL_ST")+" matches with Sub Total on Insured App as Expected : "+InsApp_SubTotal_EPL, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				}
				else
				{
					CustomReporting.logReport("", "", "EPL Sub Total of Rater : "+dataRater.getData("EPL_ST")+" Does NOT Match with Sub Total on Insured App : "+InsApp_SubTotal_EPL, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			case "Kidnap &Ransom": 
				if(dataRater.getData("KNR_ST").equalsIgnoreCase(InsApp_SubTotal))
				{
					func._scrollToElement(getElement(SubTotal_InsApp));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "KNR Sub Total of Rater : "+dataRater.getData("KNR_ST")+" matches with Sub Total on Insured App as Expected : "+InsApp_SubTotal, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				}
				else
				{
					CustomReporting.logReport("", "", "KNR Sub Total of Rater : "+dataRater.getData("KNR_ST")+" Does NOT Match with Sub Total on Insured App : "+InsApp_SubTotal, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			case "D and O New": 
				String InsApp_SubTotal_DNO =  _getAttributeValue(getElement(SubTotal_InsApp_DNO_EPL), "TEXT");
				if(dataRater.getData("DNO_ST").equalsIgnoreCase(InsApp_SubTotal_DNO))
				{
					func._scrollToElement(getElement(SubTotal_InsApp_DNO_EPL));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					CustomReporting.logReport("", "", "DNO Sub Total of Rater : "+dataRater.getData("DNO_ST")+" matches with Sub Total on Insured App as Expected : "+InsApp_SubTotal_DNO, StepStatus.SUCCESS, new String[] {},
							System.currentTimeMillis());
				}
				else
				{
					CustomReporting.logReport("", "", "DNO Sub Total of Rater : "+dataRater.getData("DNO_ST")+" Does NOT Match with Sub Total on Insured App : "+InsApp_SubTotal_DNO, StepStatus.FAILURE, new String[] {},
							System.currentTimeMillis());
				}
				break;
			default:
				break;
				
			}
			getWebDriver().navigate().to(uurrll);
			_wait(2000);
		}
		String targetxpath3 = "//*[contains(text(),'Logout')]";
		WebElement ele3 = (getWebDriver().findElement(By.xpath(targetxpath3)));
		_wait(2000);
		ele3.click();
		
	}
	
	@Override
	public void verifySubtotalWhenSharedLimitChecked(String tcID, SoftAssert softAssert)
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
		String FIDSubtotal = dataUmLogin.getData("FIDSubtotal").replace("$", "");
		String DNOSubtotal = dataUmLogin.getData("DNOSubtotal").replace("$", "");
		String EPLSubtotal = dataUmLogin.getData("EPLSubtotal").replace("$", "");
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		func._checkAttributeValue(getElement(lblFIDPremium), "TEXT", FIDSubtotal, softAssert);
		func._checkAttributeValue(getElement(lblDNOPremium), "TEXT", DNOSubtotal, softAssert);
		func._checkAttributeValue(getElement(lblEPLPremium), "TEXT", EPLSubtotal, softAssert);
	}
	
	public void InsuredAppSearch(String tcID, SoftAssert softAssert) throws InterruptedException 
	{
				PageData dataUmLogin = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
				String RatingId = dataUmLogin.getData("RatingWorkSheetId");
				
				_wait(4000);
				
				WebElement release_doprdown = (WebElement)getElement(rel_dropdown).getNative();
				Select r_dd = new Select(release_doprdown);
				List<WebElement> all_releases = r_dd.getOptions();
				System.out.println(all_releases.size());
				int last_value = all_releases.size()-1;
				WebElement Latest_Release_Element = all_releases.get(last_value);
				release_doprdown.click();
				func._waitForPageToLoad(getWebDriver(), 50L);
				CustomReporting.logReport("Latest Insured App Release is : " +Latest_Release_Element.getText());//getAttribute("value"));
				Latest_Release_Element.click();
				_wait(4000);
				
				if(func._isVisible(getElement(id_txt)))
				{
					_setValue(getElement(id_txt),RatingId);
					GenericFunctions.instance().setValue7();
					_wait(4000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
				if(func._isVisible(getElement(invalid_id))||func._isVisible(getElement(NoQuotes)))
				{
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					String uurrll = getWebDriver().getCurrentUrl().toString();
					String rel_url = uurrll.split("release=")[0];
					int rel_num = Integer.parseInt(uurrll.split("release=")[1]);
					System.out.println(rel_url+"   "+rel_num); 
					for(int i=1;i<10;i++)
					{
						getWebDriver().navigate().to(rel_url+"release="+(rel_num-i));
						if(func._isVisible(getElement(id_txt)))
						{
							_setValue(getElement(id_txt),RatingId);
							GenericFunctions.instance().setValue7();
							_wait(4000);
							func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						}
						if(func._isVisible(getElement(premium_insuredapp)))
						{
							func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
							CustomReporting.logReport("Insured App Release is : " + rel_url+"="+(rel_num-i));
							break;
						}
					}
				}
	}
	
	@Override
	public void InsuredAppVerifyBaseRate(String tcID, SoftAssert softAssert) throws InterruptedException 
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		func._checkAttributeValue(getElement(BaseRate), "TEXT",dataUmLogin.getData("BaseRate") , softAssert);
		
	}
	
	@Override
	public void InsuredAppVerifyComboFactor(String tcID, SoftAssert softAssert) throws InterruptedException 
	{
		
		PageData data_Exposures = PageDataManager.instance().getPageData("Exposures", tcID);
		PageData data_LplNA = PageDataManager.instance().getPageData("LPLNonAdmitted", tcID);
		PageData data_LplA = PageDataManager.instance().getPageData("LPLAdmitted", tcID);
		String InsuredAppPremForInsured = func._getAttributeValue(getElement(Prem_Insured), "TEXT", softAssert);
		CustomReporting.logReport("Premium For Insured : "+InsuredAppPremForInsured, StepStatus.REPORT);
		String FinalPremium;
		DecimalFormat df = new DecimalFormat("0");
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		if(data_Exposures.getData("WritingApproachInput").equalsIgnoreCase("Non-Admitted"))
		{
			func._checkAttributeValue(getElement(ComboCap), "TEXT",data_LplNA.getData("ComboFactor") , softAssert);
			CustomReporting.logReport("Combo Factor Capped : "+func._getAttributeValue(getElement(ComboCap), "TEXT", softAssert), StepStatus.REPORT);
			 FinalPremium= df.format(Integer.parseInt(InsuredAppPremForInsured)*Double.parseDouble(data_LplNA.getData("ComboFactor"))).toString();
			 func._checkAttributeValue(getElement(Prem_Final), "TEXT",FinalPremium , softAssert);
		}
		else
		{
			func._checkAttributeValue(getElement(ComboCap), "TEXT",data_LplA.getData("ComboFactor") , softAssert);
			CustomReporting.logReport("Combo Factor Capped : "+func._getAttributeValue(getElement(ComboCap), "TEXT", softAssert), StepStatus.REPORT);
			 FinalPremium= df.format(Integer.parseInt(InsuredAppPremForInsured)*Double.parseDouble(data_LplA.getData("ComboFactor"))).toString();
			 func._checkAttributeValue(getElement(Prem_Final), "TEXT",FinalPremium , softAssert);
		}
		
		
		
		
		
		
	}
		
		
	
}
