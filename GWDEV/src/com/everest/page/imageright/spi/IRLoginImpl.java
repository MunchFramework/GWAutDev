package com.everest.page.imageright.spi;
import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.GenericFunctions;
import com.everest.page.imageright.IRLogin;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;


public class IRLoginImpl extends CustomAbstractPage implements IRLogin {

	
	@SuppressWarnings("static-access")
	@Override
	public void loginToImageRight(String tcID, SoftAssert softAssert,String DeviceName) throws Exception {

		try {

			PageData environmentData = PageDataManager.instance().getPageData("Login", tcID);
			PageData data = PageDataManager.instance().getPageData("ImageRight", tcID);
			String env = GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV");
			String userName = data.getData("UserName");
			String password = data.getData("PassWord");
			
			String environment = environmentData.getData("Environment");
			String strURL = null;
			if (!env.isEmpty()) {
				if (env.equalsIgnoreCase("QA") || env.equalsIgnoreCase("STAGE") || env.equalsIgnoreCase("SIT")) {
					//a = "window.open('https://enirwebs1.everestre.net/imageright.web.client/Login/LogIn?ReturnUrl=%2fimageright.web.client%2f','_blank');";
					strURL = data.getData("STAGE_URL");
				} else {
					//a = "window.open('https://enirwebp1.everestre.net/imageright.web.client','_blank');";
					strURL = data.getData("PREPROD_URL");
				}

			} else {
				if (environment.equalsIgnoreCase("QA") || environment.equalsIgnoreCase("STAGE")
						|| environment.equalsIgnoreCase("SIT")) {
					//a = "window.open('https://enirwebs1.everestre.net/imageright.web.client/Login/LogIn?ReturnUrl=%2fimageright.web.client%2f','_blank');";
					strURL = data.getData("STAGE_URL");
				} else {
					//a = "window.open('https://enirwebp1.everestre.net/imageright.web.client','_blank');";
					strURL = data.getData("PREPROD_URL");
				}

			}

			//code to open url
			getWebDriver().navigate().to(strURL);
		    getWebDriver().manage().window().maximize();
		    
		    CustomReporting.logReport("Open Application URL : "+  strURL);

			_wait(5000);
			 if(DeviceName.equalsIgnoreCase("Internet Explorer"))
				{
			    	if(func._isVisible(getElement(lnk_certificate)))
			    	{
			    		Thread.sleep(5000);
			    		_click(getElement(lnk_certificate));
			    		//getWebDriver().findElement(By.xpath("//*[@id='overridelink']")).click();
			    	}
			    	else
			    	{
			    		if(func._isVisible(getElement(lnk_Moreinformation)))
				    	{
				    		Thread.sleep(2000);
				    		_click(getElement(lnk_Moreinformation));
				    		Thread.sleep(5000);
				    		_click(getElement(lnk_Notrecommendedicon));
				    		func._waitForPageToLoad(getWebDriver(), 200L);
				    		Thread.sleep(5000);
				    		
				    	}
			    	}
				}
			if (DeviceName.equalsIgnoreCase("Chrome"))
			{
				if (func._isVisible(getElement(btn_AdvancedCert)))
				{
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					_click(getElement(btn_AdvancedCert));
					_wait(3000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					
					_click(getElement(lnk_ProceedToUnsafe));
					_wait(3000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					
				}
			}

			
			_setValue(getElement(txt_IRUserName), userName);
			_wait(1000);
			_setValue(getElement(txt_IRPassword), password);
			_wait(1000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_click(getElement(btn_IRLogin));
			CustomReporting.instance().logReport("Sucessfully logged into ImageRight application");
			func._waitForPageToLoad(getWebDriver(), 200L);

		} catch (Exception ex) {

			System.out.println(ex);
		}

	}
	
	
	
	
}
		
		
		
