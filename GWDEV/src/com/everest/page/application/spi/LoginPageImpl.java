package com.everest.page.application.spi;



import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.GenericFunctions;
import com.everest.page.application.LoginPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;


public class LoginPageImpl extends CustomAbstractPage implements LoginPage {
		
	
	@Override
	public void launchPage(String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		
        String strURL="";
        
        
        String env=GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV");          
        if (!env.isEmpty()) 
        {
            if (env.equalsIgnoreCase("DEV")) 
            {
                  strURL = dataLogin.getData("DEV_URL");
            }
            else if(env.equalsIgnoreCase("QA"))
            {
                strURL = dataLogin.getData("QA_URL");
            }
            else if(env.equalsIgnoreCase("SIT"))
            {
            	strURL = dataLogin.getData("SIT_URL");   
            	
            }
            else if(env.equalsIgnoreCase("STAGE"))
            {
            	//env="PREPROD";
            	strURL = dataLogin.getData("PREPROD_URL");
            }
            
            
            CustomReporting.logReport("Policy Center Application launched successfully with " + strURL + " in " + env + " Environment");
            
        }
        
        else 
        {
		        if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		        {
		        	strURL=dataLogin.getData("QA_URL");
		        	CustomReporting.logReport("","","Application launched in QA environemnrt with URL: "+strURL ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
		        	
		        }
		        if(dataLogin.getData("Environment").toUpperCase().equals("DEV"))
		        {
		        	strURL=dataLogin.getData("DEV_URL");
		        	CustomReporting.logReport("","","Application launched in DEV environemnrt with URL: "+strURL ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
		        }
		        if(dataLogin.getData("Environment").toUpperCase().equals("SIT"))
		        {
		        	strURL=dataLogin.getData("SIT_URL");
		        	CustomReporting.logReport("","","Application launched in SIT environemnrt with URL: "+strURL ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
		        }
		        if(dataLogin.getData("Environment").toUpperCase().equals("PREPROD"))
		        {
		        	strURL=dataLogin.getData("PREPROD_URL");
		        	CustomReporting.logReport("","","Application launched in PREPROD environemnrt with URL: "+strURL ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
		        }
        }
        
		getWebDriver().navigate().to(strURL);
		func._waitForPageToLoad(getWebDriver(),50L);
	    getWebDriver().manage().window().maximize();
	   
	    _wait(5000);
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");


	    if (!env.isEmpty()) 
	    {
	    	if (env.equalsIgnoreCase("DEV")) 
	    	{
	    		_setValue(getElement(txt_username),dataLogin.getData("DEVUserName"));
		    	_wait(1000);
		    	_setValue(getElement(txt_password),dataLogin.getData("DEVPassWord"));
	    	} 
	    	else if(env.equalsIgnoreCase("QA"))
	    	{
	    		_setValue(getElement(txt_username),dataLogin.getData("QAUserName"));
    	    	_wait(1000);
    	    	_setValue(getElement(txt_password),dataLogin.getData("QAPassWord"));
	    	}
	    	else if(env.equalsIgnoreCase("STAGE")) 
            {
            	_setValue(getElement(txt_username),dataLogin.getData("PREPRODUserName"));
    	    	_wait(1000);
    	    	_setValue(getElement(txt_password),dataLogin.getData("PREPRODPassWord"));
            }
	    	else if(env.equalsIgnoreCase("SIT")) 
            {
	    		_setValue(getElement(txt_username),dataLogin.getData("SITUserName"));
    	    	_wait(1000);
    	    	_setValue(getElement(txt_password),dataLogin.getData("SITPassWord"));
            }
	    	
	    }
	    else
			 {
			    if(dataLogin.getData("Environment").toUpperCase().equals("SIT"))
		        {
			    	_setValue(getElement(txt_username),dataLogin.getData("SITUserName"));
			    	_wait(1000);
			    	_setValue(getElement(txt_password),dataLogin.getData("SITPassWord"));
		        }
			    
			    else if(dataLogin.getData("Environment").toUpperCase().equals("DEV"))
		        {
			    	_setValue(getElement(txt_username),dataLogin.getData("DEVUserName"));
			    	_wait(1000);
			    	_setValue(getElement(txt_password),dataLogin.getData("DEVPassWord"));
		        }
			    
			    else if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
		        {
			    	_setValue(getElement(txt_username),dataLogin.getData("QAUserName"));
			    	_wait(1000);
			    	_setValue(getElement(txt_password),dataLogin.getData("QAPassWord"));
		        }
			    else if(dataLogin.getData("Environment").toUpperCase().equals("PREPROD"))
		        {
			    	_setValue(getElement(txt_username),dataLogin.getData("PREPRODUserName"));
			    	_wait(1000);
			    	_setValue(getElement(txt_password),dataLogin.getData("PREPRODPassWord"));
		        }
	    }
	    
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    _click(getElement(btn_Login));
	    _wait(2000);
	    func._waitForPageToLoad(getWebDriver(),50L);
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    CustomReporting.logReport("","","Logged in to the application successfully!" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
	}
		

}
