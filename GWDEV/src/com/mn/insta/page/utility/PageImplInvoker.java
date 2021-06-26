package com.mn.insta.page.utility;

import org.testng.asserts.SoftAssert;
import org.xframium.device.ng.AbstractSeleniumTest;
import org.xframium.page.PageManager;

import com.mn.insta.page.LoginInsta;

public class PageImplInvoker extends AbstractSeleniumTest 
{
	SoftAssert softAssert = new SoftAssert();

	/**************** LoginInsta Page *************************/

	public void LoginToInsta(String tcID, String DeviceName) throws Exception 
	{

		LoginInsta objReference = (LoginInsta) PageManager.instance().createPage(LoginInsta.class, getWebDriver());
		objReference.LoginToInsta(tcID, softAssert, DeviceName);
	}
	
	public void LogoutInsta(String tcID, String DeviceName) throws Exception 
	{

		LoginInsta objReference = (LoginInsta) PageManager.instance().createPage(LoginInsta.class, getWebDriver());
		objReference.LogoutInsta(tcID, softAssert, DeviceName);
	}
	
	
}
