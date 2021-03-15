package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.GenericFunctions;
import com.everest.page.application.UmLoginPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmLoginPageImpl extends CustomAbstractPage implements UmLoginPage {

	@Override
	public void UmlaunchPage(String tcID, SoftAssert softAssert, String DeviceName) throws Exception 
	{
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if(!dataUmLogin.getData("tcID_BC_PartB").equals(""))
		{
			dataUmLogin = PageDataManager.instance().getPageData("UmLogin", dataUmLogin.getData("tcID_BC_PartB"));	
		}
		String strURL = "";
		func._waitForPageToLoad(getWebDriver(), 50L);
		String env = GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV");
		
		if (!env.isEmpty()) 
		{
			
			if (env.equalsIgnoreCase("DEV")) 
			{
				if(dataUmLogin.getData("SSO_DEV").equalsIgnoreCase("Yes"))
				{
					strURL = dataUmLogin.getData("DEVSSO_URL");
				}
				else
				{
					strURL = dataUmLogin.getData("DEV_URL");
				}
			} 
			else if(env.equalsIgnoreCase("QA")) //UM QA3
			{
				if(dataUmLogin.getData("SSO_QA").equalsIgnoreCase("Yes"))
				{
					strURL = dataUmLogin.getData("QASSO_URL");
				}
				else
				{
					strURL = dataUmLogin.getData("QA_URL");
				}
				
			}
			else if(env.equalsIgnoreCase("SIT")) //UM QA2
			{
				if(dataUmLogin.getData("SSO_SIT").equalsIgnoreCase("Yes"))
				{
					strURL = dataUmLogin.getData("SITSSO_URL");
				}
				else
				{
					strURL = dataUmLogin.getData("SIT_URL");
				}
				
			}
			else if(env.equalsIgnoreCase("STAGE")) 
			{
				//env="PREPROD";
				strURL = dataUmLogin.getData("PREPROD_URL");
			}
			

			CustomReporting.logReport(" UM Application launched successfully with " + strURL + " in " + env + " Environment");
		}

		else 
		{
			if (dataUmLogin.getData("Environment").toUpperCase().equals("QA")) 
			{
				if(dataUmLogin.getData("SSO_QA").equalsIgnoreCase("Yes"))
				{
					strURL = dataUmLogin.getData("QASSO_URL");
				}
				else
				{
					strURL = dataUmLogin.getData("QA_URL");
				}
				
				CustomReporting.logReport("", "", " UM Application launched in QA environemnrt with URL: " + strURL,
						StepStatus.REPORT, new String[] {}, System.currentTimeMillis());

			}
			else if (dataUmLogin.getData("Environment").toUpperCase().equals("DEV")) 
			{
				if(dataUmLogin.getData("SSO_DEV").equalsIgnoreCase("Yes"))
				{
					strURL = dataUmLogin.getData("DEVSSO_URL");
				}
				else
				{
					strURL = dataUmLogin.getData("DEV_URL");
				}
				
				CustomReporting.logReport("", "", "UM Application launched in DEV environemnrt with URL: " + strURL,
						StepStatus.REPORT, new String[] {}, System.currentTimeMillis());
			}
			else if (dataUmLogin.getData("Environment").toUpperCase().equals("SIT")) 
			{
				if(dataUmLogin.getData("SSO_SIT").equalsIgnoreCase("Yes"))
				{
					strURL = dataUmLogin.getData("SITSSO_URL");
				}
				else
				{
					strURL = dataUmLogin.getData("SIT_URL");
				}
				
				CustomReporting.logReport("", "", "UM Application launched in SIT environemnrt with URL: " + strURL,
						StepStatus.REPORT, new String[] {}, System.currentTimeMillis());
			}
			else if (dataUmLogin.getData("Environment").toUpperCase().equals("PREPROD")) 
			{
				strURL = dataUmLogin.getData("PREPROD_URL");
				CustomReporting.logReport("", "", "UM Application launched in PREPROD environemnrt with URL: " + strURL,
						StepStatus.REPORT, new String[] {}, System.currentTimeMillis());
			}
		}
		
		

		getWebDriver().navigate().to(strURL);
		func._waitForPageToLoad(getWebDriver(), 50L);
		getWebDriver().manage().window().maximize();
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		_wait(5000);
		
		if (!env.isEmpty())
		{
			
			if (env.equalsIgnoreCase("DEV")) 
			{
				if(dataUmLogin.getData("SSO_DEV").equalsIgnoreCase("Yes"))
				{
					if (func._isVisible(getElement(btnNewSubmission)) == false)
					{
						_wait(6000);
						getWebDriver().navigate().to(strURL);
						_wait(6000);
					}
				}
				else
				{
					if (func._isVisible(getElement(iconLogout)))
					{
							_click(getElement(iconLogout));
							_click(getElement(menuLogout));
					}
					_setValue(getElement(txtUmUserName), dataUmLogin.getData("DEVUserName"));
					_wait(1000);
					_setValue(getElement(txtUmPassword), dataUmLogin.getData("DEVPassWord"));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					_click(getElement(btnUmLogin));
					_wait(2000);
					if (func._isVisible(getElement(btnNewSubmission)) == false)
					{
						_wait(2000);
						_click(getElement(btnUmLogin));
						_wait(2000);
					}
				}
				
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");	
				CustomReporting.logReport("", "", "Logged in to the application successfully!", StepStatus.REPORT,
						new String[] {}, System.currentTimeMillis());
			} 
			
			else if(env.equalsIgnoreCase("QA")) 
			{
				if(dataUmLogin.getData("SSO_QA").equalsIgnoreCase("Yes"))
				{
					if (func._isVisible(getElement(btnNewSubmission)) == false)
					{
						_wait(6000);
						getWebDriver().navigate().to(strURL);
						_wait(6000);
					}
				}
				else
				{
					if (func._isVisible(getElement(iconLogout)))
					{
							_click(getElement(iconLogout));
							_click(getElement(menuLogout));
					}
					_setValue(getElement(txtUmUserName), dataUmLogin.getData("QAUserName"));
					_wait(1000);
					_setValue(getElement(txtUmPassword), dataUmLogin.getData("QAPassWord"));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					_click(getElement(btnUmLogin));
					_wait(2000);
					if (func._isVisible(getElement(btnNewSubmission)) == false)
					{
						_wait(2000);
						_click(getElement(btnUmLogin));
						_wait(2000);
					}
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");	
				CustomReporting.logReport("", "", "Logged in to the application successfully!", StepStatus.REPORT,
						new String[] {}, System.currentTimeMillis());
				
			}
			
			else if(env.equalsIgnoreCase("SIT")) 
			{
				if(dataUmLogin.getData("SSO_SIT").equalsIgnoreCase("Yes"))
				{
					if (func._isVisible(getElement(btnNewSubmission)) == false)
					{
						_wait(6000);
						getWebDriver().navigate().to(strURL);
						_wait(6000);
					}
				}
				else
				{
					if (func._isVisible(getElement(iconLogout)))
					{
							_click(getElement(iconLogout));
							_click(getElement(menuLogout));
					}
					_setValue(getElement(txtUmUserName), dataUmLogin.getData("SITUserName"));
					_wait(1000);
					_setValue(getElement(txtUmPassword), dataUmLogin.getData("SITPassWord"));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					_click(getElement(btnUmLogin));
					_wait(2000);
					if (func._isVisible(getElement(btnNewSubmission)) == false)
					{
						_wait(2000);
						_click(getElement(btnUmLogin));
						_wait(2000);
					}
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");	
				CustomReporting.logReport("", "", "Logged in to the application successfully!", StepStatus.REPORT,
						new String[] {}, System.currentTimeMillis());
				
			}
			else 
			{
				if (func._isVisible(getElement(btnNewSubmission)) == false)
				{
					/*_wait(6000);
					getWebDriver().navigate().to(strURL);
					_wait(6000);*/
					
					//Microsoft Auth Fix  - Start
					
					if (DeviceName.equalsIgnoreCase("Internet Explorer"))
					{
						CustomReporting.logReport("", "", "Microsoft Authorization is Required", StepStatus.REPORT,
								new String[] {}, System.currentTimeMillis());
						_wait(6000);
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						String alternate_url = "https://login.microsoftonline.com/0002cd24-7dd6-4542-acd6-e0c7e184c80c/reprocess?prompt=select_account&sosid=&ctx=rQIIAeNisBJNLUstSi0uKS3XKyhKLSjKT9FLzs8tEuISsFzcEB2ZmeKzOsdr81lvU4FVjAYZJSUFxVb6-ql5mcm6MOWluXrppZkpqeWZRal6eakl-rllyfqhucXBxfkXGBlfMDLeYmINTszNMdrErGJgYGCUnGJkomuekmKma2JqYqSbmAxkpRokm6caWpgkWxgk72JWMTJMSko0NTLVNTQzSwIqS7bUTTSySNE1NzG2NDIzMgUKWz5iVvTNz0jMzU1N0fMqzUtNCUgszkh0gHoH6BSgNy6w8Lxi4TFgtuLg4BJgkGBQYPjBwriIFei50pu7Dzb_OOW9WOetqMrfDQynWPVdA4wrfcLcLcJ9LKsiogwNIw0rjEwqfEzSzMzyc4p8Mjz1oyorkkMzDVN8bQ2tDCew8Z5iY_jAxtjBzriLk-SgaeLh5WAQ4uQUPNz37XDNDY8DvAwA0";
						getWebDriver().navigate().to(alternate_url);
						_wait(6000);
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						String alternate_link = "(//img[@class='tile-img'])[2]";
						WebElement we = getWebDriver().findElement(By.xpath(alternate_link));
						we.click();
						_wait(2000);
						getWebDriver().findElement(By.xpath("//div[text()='someone@example.com']"))
								.sendKeys("Mohammed.JunedPasha@everestre.com");
						_wait(2000);
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						getWebDriver().findElement(By.xpath("//input[@value='Next']")).click();
						_wait(6000);
						getWebDriver().navigate().to(strURL);
						_wait(6000);
						if (func._isVisible(getElement(btnNewSubmission)) == true) {
							CustomReporting.logReport("", "", "Microsoft Authorization Success", StepStatus.REPORT,
									new String[] {}, System.currentTimeMillis());
						} 
					}
					
					else if (DeviceName.equalsIgnoreCase("Chrome"))
					{
						CustomReporting.logReport("", "", "Microsoft Authorization is Required", StepStatus.REPORT,
								new String[] {}, System.currentTimeMillis());
						_wait(3000);
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						getWebDriver().findElement(By.xpath("//input[@type='email']"))
						.sendKeys("Mohammed.JunedPasha@everestre.com");
						_wait(2000);
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						getWebDriver().findElement(By.xpath("//input[@value='Next']")).click();
						_wait(6000);
						getWebDriver().navigate().to(strURL);
						_wait(6000);
						if (func._isVisible(getElement(btnNewSubmission)) == true) 
						{
							CustomReporting.logReport("", "", "Microsoft Authorization Success", StepStatus.REPORT,
							new String[] {}, System.currentTimeMillis());
						} 
					}
						
					//Microsoft Auth Fix  - End
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");	
				CustomReporting.logReport("", "", "Logged in to the application successfully!", StepStatus.REPORT,
						new String[] {}, System.currentTimeMillis());
			}
		}
		
		else
		{
		
			if(dataUmLogin.getData("Environment").toUpperCase().equals("DEV"))
			{
					if(dataUmLogin.getData("SSO_DEV").equalsIgnoreCase("Yes"))
					{
						if (func._isVisible(getElement(btnNewSubmission)) == false)
						{
							_wait(6000);
							getWebDriver().navigate().to(strURL);
							_wait(6000);
						}
					}
					else
					{
						if (func._isVisible(getElement(iconLogout)))
						{
								_click(getElement(iconLogout));
								_click(getElement(menuLogout));
						}
						_setValue(getElement(txtUmUserName), dataUmLogin.getData("DEVUserName"));
						_wait(1000);
						_setValue(getElement(txtUmPassword), dataUmLogin.getData("DEVPassWord"));
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						_click(getElement(btnUmLogin));
						_wait(2000);
						if (func._isVisible(getElement(btnNewSubmission)) == false)
						{
							_wait(2000);
							_click(getElement(btnUmLogin));
							_wait(2000);
						}
					}
					
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");	
					CustomReporting.logReport("", "", "Logged in to the application successfully!", StepStatus.REPORT,
							new String[] {}, System.currentTimeMillis());
					
				}
			
			else if(dataUmLogin.getData("Environment").toUpperCase().equals("QA"))
			{

				if(dataUmLogin.getData("SSO_QA").equalsIgnoreCase("Yes"))
				{
					if (func._isVisible(getElement(btnNewSubmission)) == false)
					{
						_wait(6000);
						getWebDriver().navigate().to(strURL);
						_wait(6000);
					}
				}
				else
				{
					if (func._isVisible(getElement(iconLogout)))
					{
							_click(getElement(iconLogout));
							_click(getElement(menuLogout));
					}
					_setValue(getElement(txtUmUserName), dataUmLogin.getData("QAUserName"));
					_wait(1000);
					_setValue(getElement(txtUmPassword), dataUmLogin.getData("QAPassWord"));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					_click(getElement(btnUmLogin));
					_wait(2000);
					if (func._isVisible(getElement(btnNewSubmission)) == false)
					{
						_wait(2000);
						_click(getElement(btnUmLogin));
						_wait(2000);
					}
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");	
				CustomReporting.logReport("", "", "Logged in to the application successfully!", StepStatus.REPORT,
						new String[] {}, System.currentTimeMillis());
				
			
			}
			
			else if(dataUmLogin.getData("Environment").toUpperCase().equals("SIT"))
			{
				if(dataUmLogin.getData("SSO_SIT").equalsIgnoreCase("Yes"))
				{
					if (func._isVisible(getElement(btnNewSubmission)) == false)
					{
						_wait(6000);
						getWebDriver().navigate().to(strURL);
						_wait(6000);
					}
				}
				else
				{
					if (func._isVisible(getElement(iconLogout)))
					{
							_click(getElement(iconLogout));
							_click(getElement(menuLogout));
					}
					_setValue(getElement(txtUmUserName), dataUmLogin.getData("SITUserName"));
					_wait(1000);
					_setValue(getElement(txtUmPassword), dataUmLogin.getData("SITPassWord"));
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					_click(getElement(btnUmLogin));
					_wait(2000);
					if (func._isVisible(getElement(btnNewSubmission)) == false)
					{
						_wait(2000);
						_click(getElement(btnUmLogin));
						_wait(2000);
					}
				}
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");	
				CustomReporting.logReport("", "", "Logged in to the application successfully!", StepStatus.REPORT,
						new String[] {}, System.currentTimeMillis());
			}
			else
			{
				if (func._isVisible(getElement(btnNewSubmission)) == false)
				{
					/*_wait(6000);
					getWebDriver().navigate().to(strURL);
					_wait(6000);*/
					
					//Microsoft Auth Fix  - Start
					
					if (DeviceName.equalsIgnoreCase("Internet Explorer"))
					{
						CustomReporting.logReport("", "", "Microsoft Authorization is Required", StepStatus.REPORT,
								new String[] {}, System.currentTimeMillis());
						_wait(6000);
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						String alternate_url = "https://login.microsoftonline.com/0002cd24-7dd6-4542-acd6-e0c7e184c80c/reprocess?prompt=select_account&sosid=&ctx=rQIIAeNisBJNLUstSi0uKS3XKyhKLSjKT9FLzs8tEuISsFzcEB2ZmeKzOsdr81lvU4FVjAYZJSUFxVb6-ql5mcm6MOWluXrppZkpqeWZRal6eakl-rllyfqhucXBxfkXGBlfMDLeYmINTszNMdrErGJgYGCUnGJkomuekmKma2JqYqSbmAxkpRokm6caWpgkWxgk72JWMTJMSko0NTLVNTQzSwIqS7bUTTSySNE1NzG2NDIzMgUKWz5iVvTNz0jMzU1N0fMqzUtNCUgszkh0gHoH6BSgNy6w8Lxi4TFgtuLg4BJgkGBQYPjBwriIFei50pu7Dzb_OOW9WOetqMrfDQynWPVdA4wrfcLcLcJ9LKsiogwNIw0rjEwqfEzSzMzyc4p8Mjz1oyorkkMzDVN8bQ2tDCew8Z5iY_jAxtjBzriLk-SgaeLh5WAQ4uQUPNz37XDNDY8DvAwA0";
						getWebDriver().navigate().to(alternate_url);
						_wait(6000);
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						String alternate_link = "(//img[@class='tile-img'])[2]";
						WebElement we = getWebDriver().findElement(By.xpath(alternate_link));
						we.click();
						_wait(2000);
						getWebDriver().findElement(By.xpath("//div[text()='someone@example.com']"))
								.sendKeys("Mohammed.JunedPasha@everestre.com");
						_wait(2000);
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						getWebDriver().findElement(By.xpath("//input[@value='Next']")).click();
						_wait(6000);
						getWebDriver().navigate().to(strURL);
						_wait(6000);
						if (func._isVisible(getElement(btnNewSubmission)) == true) {
							CustomReporting.logReport("", "", "Microsoft Authorization Success", StepStatus.REPORT,
									new String[] {}, System.currentTimeMillis());
						} 
					}
					
					else if (DeviceName.equalsIgnoreCase("Chrome"))
					{
						CustomReporting.logReport("", "", "Microsoft Authorization is Required", StepStatus.REPORT,
								new String[] {}, System.currentTimeMillis());
						_wait(3000);
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						getWebDriver().findElement(By.xpath("//input[@type='email']"))
						.sendKeys("Mohammed.JunedPasha@everestre.com");
						_wait(2000);
						func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
						getWebDriver().findElement(By.xpath("//input[@value='Next']")).click();
						_wait(6000);
						getWebDriver().navigate().to(strURL);
						_wait(6000);
						if (func._isVisible(getElement(btnNewSubmission)) == true) 
						{
							CustomReporting.logReport("", "", "Microsoft Authorization Success", StepStatus.REPORT,
							new String[] {}, System.currentTimeMillis());
						} 
					}
						
					//Microsoft Auth Fix  - End
				}
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");	
					CustomReporting.logReport("", "", "Logged in to the application successfully!", StepStatus.REPORT,
							new String[] {}, System.currentTimeMillis());
			}
		}
		
		
		
		

	}
}