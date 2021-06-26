package com.mn.insta.page.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.provider.xsd.Element;

import com.mn.insta.page.LoginInsta;
import com.mn.insta.page.utility.CustomAbstractPage;
import com.mn.insta.page.utility.CustomReporting;
import com.thoughtworks.selenium.webdriven.commands.WaitForCondition;

public class LoginInstaImpl extends CustomAbstractPage implements LoginInsta
{

	@Override
	public void LoginToInsta(String tcID, SoftAssert softAssert, String DeviceName) throws Exception 
	{
		func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(5000);
		PageData dataLogin = PageDataManager.instance().getPageData("InstaLogin",tcID);
        String strURL="";
        if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
        {
        	strURL=dataLogin.getData("QA_URL");
        	
        }
        if(dataLogin.getData("Environment").toUpperCase().equals("STAGE"))
        {
        	strURL=dataLogin.getData("Stage_URL");
        	
        }
        if(dataLogin.getData("Environment").toUpperCase().equals("SIT"))
        {
        	strURL=dataLogin.getData("SIT_URL");
        	
        }

		getWebDriver().navigate().to(strURL);
	    getWebDriver().manage().window().maximize();
	    func._waitForPageToLoad(getWebDriver(), 500L);
	    CustomReporting.logReport("Open Application URL : "+  strURL);
	    if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
        {
	    	func._waitForPageToLoad(getWebDriver(), 500L);
	    	func._click(getElement(txt_username));
	    	_setValue(getElement(txt_username),dataLogin.getData("QAUserName"));
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_password),dataLogin.getData("QAPassWord"));
        }
	    
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    Thread.sleep(2000);
	    func._click(getElement(btn_Login));
	    func._record_PageLoadTime(getWebDriver(), 300L);
	    Thread.sleep(2000);
	    func._click(getElement(btn_NotNow));
	    func._waitForPageToLoad(getWebDriver(),150L);
	    func._click(getElement(btn_NotNow));
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");   
	}

	@Override
	public void LogoutInsta(String tcID, SoftAssert softAssert, String DeviceName) throws Exception 
	{
		func._click(getElement(img_Profile));
	    func._record_PageLoadTime(getWebDriver(), 300L);
	    Thread.sleep(2000);
	    func._click(getElement(btn_Logout));
	    func._waitForPageToLoad(getWebDriver(),150L);
	    
		
	}
	

}
