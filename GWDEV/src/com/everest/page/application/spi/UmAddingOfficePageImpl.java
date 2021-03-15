package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.GenericFunctions;
import com.everest.page.application.UmAddingOfficePage;
import com.everest.utility.CustomAbstractPage;

public class UmAddingOfficePageImpl extends CustomAbstractPage implements UmAddingOfficePage {

	@Override
	public void UmAddingOffice(String tcID, SoftAssert softAssert) throws Exception
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmAddingOffice", tcID);
		PageData dataUmLogin1 = PageDataManager.instance().getPageData("UmLogin", tcID); 
		func._waitForPageToLoad(getWebDriver(), 50L);
		String strURL = "";
		 if(!dataUmLogin.getData("tcID_BC_PartB").equals(""))
			{
			 dataUmLogin = PageDataManager.instance().getPageData("UmAddingOffice", dataUmLogin.getData("tcID_BC_PartB"));	
			}
		_wait(4000);
		
		_click(getElement(lnkSubmission));
		_wait(5000);
		_setValue(getElement(txtWebsite), dataUmLogin.getData("Website"));
		_wait(1000);
	
		_click(getElement(btnCarrierBranch));
		_setValue(getElement(txtCarrierBranch), dataUmLogin.getData("Carrier"));
		
		_wait(4000);
		String expoption= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("Carrier")+"\")]";
		WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
		expectedOption.click();
		_wait(3000);
		WebElement weBranchCarrier=(WebElement)getElement(btnCarrierBranch).getNative();
		weBranchCarrier.sendKeys(Keys.PAGE_DOWN);
		_wait(10000);
		_click(getElement(btnOffice));
		_wait(4000);
		_setValue(getElement(txtOffice), dataUmLogin.getData("Office"));
		_wait(4000);
		String expoption3= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("Office")+"\")]";
		WebElement expectedOption3 = (getWebDriver().findElement(By.xpath(expoption3)));
		expectedOption3.click();
		_clickTab();
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

		_wait(8000);
		WebElement weUW=(WebElement)getElement(btnUW).getNative();
		weUW.sendKeys(Keys.PAGE_DOWN);
		_wait(8000);
		_click(getElement(btnUW));
		_wait(5000);
		
		String UWName="";
		String UWAsstName="";
		String env = GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV");
		
		if (!env.isEmpty()) 
		{
			if (env.equalsIgnoreCase("DEV")) 
			{
				UWName=dataUmLogin.getData("DevUnderWriter");
				UWAsstName= dataUmLogin.getData("DevUWAssistant");
			}
			else if(env.equalsIgnoreCase("QA")) //UM QA3
			{
				UWName=dataUmLogin.getData("QAUnderWriter");
				UWAsstName= dataUmLogin.getData("QAUWAssistant");
			}
			else if(env.equalsIgnoreCase("STAGE")) //Preprod
			{
				UWName=dataUmLogin.getData("Underwriter");
				UWAsstName= dataUmLogin.getData("UWAssistant");
			}
		}
		else
		{
			
			if(dataUmLogin1.getData("Environment").equals("QA"))
			{
				UWName=dataUmLogin.getData("QAUnderWriter");
				UWAsstName= dataUmLogin.getData("QAUWAssistant");	
			}
			else if(dataUmLogin1.getData("Environment").equals("DEV"))
			{
				UWName=dataUmLogin.getData("DevUnderWriter");
				UWAsstName= dataUmLogin.getData("DevUWAssistant");	
			}
			else
			{
				UWName=dataUmLogin.getData("Underwriter");
				UWAsstName= dataUmLogin.getData("UWAssistant");
				
			}
		}
		_setValue(getElement(txtUW), UWName);
		_wait(2000); 
		
		
		String expoption2= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+UWName+"\")]";
		WebElement expectedOption2 = (getWebDriver().findElement(By.xpath(expoption2)));
		expectedOption2.click();
		_clickTab();
		_wait(3000);
		_click(getElement(btnUWAssistant));
		_wait(5000);
		_setValue(getElement(txtUWAssistant), UWAsstName);
		_wait(2000);
		String expoption1= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+UWAsstName+"\")]";
		WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
		expectedOption1.click();
		_clickTab();
		_wait(3000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_wait(3000);

	}



@Override
public void Edit_UmAddingOffice(String tcID, SoftAssert softAssert) throws Exception
{
	PageData dataUmLogin = PageDataManager.instance().getPageData("Edit_UmAddingOffice", tcID);
	func._waitForPageToLoad(getWebDriver(), 50L);
	String strURL = "";

	_wait(4000);
	_click(getElement(lnkSubmission));
	_wait(10000);
	
	if(!dataUmLogin.getData("Website").equals("")) {
	_setValue(getElement(txtWebsite), dataUmLogin.getData("Website"));
	_wait(1000);
	}
	
	if(!dataUmLogin.getData("Carrier").equals("")) {
	_click(getElement(btnCarrierBranch));
	_setValue(getElement(txtCarrierBranch), dataUmLogin.getData("Carrier"));
	_wait(4000);
	String expoption= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("Carrier")+"\")]";
	WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
	expectedOption.click();
	
	}
	_wait(3000);
	
	if(!dataUmLogin.getData("Office").equals("")) {
	_click(getElement(btnOffice));
	_wait(4000);
	_setValue(getElement(txtOffice), dataUmLogin.getData("Office"));
	_wait(4000);
	String expoption3= "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("Office")+"\")]";
	WebElement expectedOption3 = (getWebDriver().findElement(By.xpath(expoption3)));
	expectedOption3.click();
	_clickTab();
	WebElement weOT=(WebElement)getElement(btnOffice).getNative();
	weOT.sendKeys(Keys.PAGE_DOWN);
	_wait(10000);
	}
	func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	if(!dataUmLogin.getData("Underwriter").equals("")) {
	_wait(8000);
	_click(getElement(btnUW));
	_wait(5000);
	_setValue(getElement(txtUW), dataUmLogin.getData("Underwriter"));
	_wait(2000);
	// _clickEnter();
	//func.setValue2(getElement(txtUW));
	String expoption2= "//um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("Underwriter")+"\")]";
	WebElement expectedOption2 = (getWebDriver().findElement(By.xpath(expoption2)));
	expectedOption2.click();
	_clickTab();
	_wait(3000);
	}
	
	if(!dataUmLogin.getData("UWAssistant").equals("")) {
	_click(getElement(btnUWAssistant));
	_wait(5000);
	_setValue(getElement(txtUWAssistant), dataUmLogin.getData("UWAssistant"));
	// _clickEnter();
	//func.setValue2(getElement(txtUWAssistant));
	_wait(2000);
	String expoption1= "//um-dropdown-list//*[contains(text(),\""+dataUmLogin.getData("UWAssistant")+"\")]";
	WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
	expectedOption1.click();
	_clickTab();
	_wait(3000);
	}
	func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

	// _click(getElement(btnApplication));
	_wait(3000);
}


}
