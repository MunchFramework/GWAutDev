package com.everest.escape.submission.spi;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.Element.WAIT_FOR;

import com.everest.escape.submission.Login;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class LoginImpl extends CustomAbstractPage implements Login 
{

	@Override
	public void LoginToEscape (String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(2000);
		PageData dataLogin = PageDataManager.instance().getPageData("EscapeLogin",tcID);
		/*String strScreenShots=dataLogin.getData("PrintScreens");
        if(strScreenShots.equalsIgnoreCase("Yes"))
        {
          func._takeScreenShot(getWebDriver(), "START", "", "");
        }*/
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
	    //focusBrowser();
	    CustomReporting.logReport("Open Application URL : "+  strURL);
	    
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
	    
	    Thread.sleep(2000);
	    if(dataLogin.getData("Environment").toUpperCase().equals("STAGE") || dataLogin.getData("Environment").toUpperCase().equals("SIT"))
        {
	    	func._click(getElement(txt_username));
	    	_setValue(getElement(txt_username),dataLogin.getData("StageUsername"));
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_password),dataLogin.getData("StagePassword"));
        }
	    if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
        {
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
	    func._waitForPageToLoad(getWebDriver(),150L);
	    
	    func._checkDefaultValue(getElement(pag_Search),"TEXT","Search");
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	   
	}
	
	@Override
	public void LogoutFormEscape (String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		 Thread.sleep(3000);
		 func._waitFor(getElement(lnk_LogOut), 50, WAIT_FOR.CLICKABLE, "");
		 _click(getElement(lnk_LogOut));
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		// func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
		 /*Thread.sleep(3000);
		 func._waitFor(getElement(btn_Login), 50, WAIT_FOR.CLICKABLE, "");
		*/
	}
	
	@Override
	public void LoginToEscape2 (String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		Thread.sleep(1000);
		if(dataLogin.getData("Environment").toUpperCase().equals("STAGE")|| dataLogin.getData("Environment").toUpperCase().equals("SIT"))
        {
	    	_setValue(getElement(txt_username),dataLogin.getData("StageUsername1"));
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_password),dataLogin.getData("StagePassword1"));
        }
	    if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
        {
	    	_setValue(getElement(txt_username),dataLogin.getData("QAUsername1"));
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_password),dataLogin.getData("QAPassword1"));
        }
	    
	   
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    _click(getElement(btn_Login));
	    func._waitForPageToLoad(getWebDriver(), 200L);
	    //func._waitFor(getElement(btn_Search), 60, WAIT_FOR.CLICKABLE, "");
	    Thread.sleep(6000);
	    func._checkDefaultValue(getElement(pag_Search),"TEXT","Search");
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

	}
	
	@Override
	public void LoginAsCashUser (String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		PageData dataLoginCash = PageDataManager.instance().getPageData("Payment",tcID);
		
		if(dataLogin.getData("Environment").toUpperCase().equals("STAGE") || (dataLogin.getData("Environment").toUpperCase().equals("SIT")))
        {
	    	_setValue(getElement(txt_username),dataLoginCash.getData("StageUsername"));
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_password),dataLoginCash.getData("StagePassword"));
        }
		if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
        {
	    	_setValue(getElement(txt_username),dataLoginCash.getData("QAUserName"));
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_password),dataLoginCash.getData("QAPassWord"));
        }
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    _click(getElement(btn_Login));
	    func._waitFor(getElement(btn_Search), 60, WAIT_FOR.CLICKABLE, "");
	   // Thread.sleep(6000);
	   func._checkDefaultValue(getElement(pag_Search),"TEXT","Search");
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

	}
	
	public void focusBrowser() throws Exception {

        try {

              // String
              // strDeviceName=GenericFunctions.instance()._getGlobalVariableValue("deviceName");

              File directory = new File("@/");
              System.out.println(directory.getAbsolutePath());
              String strDirectoryPath = directory.getAbsolutePath().split("\\@")[0];
              String strBundlePath = strDirectoryPath + "resources\\Images";
              ImagePath.setBundlePath(strBundlePath);
              Screen screen = new Screen();
              Pattern img_Desktop = new Pattern("Desktop.PNG");
              Robot robot = new Robot();

              try {
                    screen.find(img_Desktop);
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.delay(100);
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.delay(100);
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.delay(100);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    robot.keyRelease(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);
                   /* robot.delay(100);
                   // Thread.sleep(1000);
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    robot.keyRelease(KeyEvent.VK_TAB);
                    robot.delay(100);
                   // Thread.sleep(1000);
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    robot.keyRelease(KeyEvent.VK_TAB);*/
                    CustomReporting.logReport("Browser brought to the foreground");
              } catch (Exception ex) {

              }

        }

        finally {

        }
  }
	@Override
	public void startPrintScreenShots(String tcID, SoftAssert softAssert, String DeviceName) throws Exception {
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		String strScreenShots=dataLogin.getData("PrintScreens");

		if (strScreenShots.equalsIgnoreCase("Yes")) {
			func._takeBrowserScreenShot(getWebDriver(), "START", "", "");
		}
		focusBrowser();
	}
	
	@Override
	public void LoginToMembership (String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(2000);
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		/*String strScreenShots=dataLogin.getData("PrintScreens");
        if(strScreenShots.equalsIgnoreCase("Yes"))
        {
          func._takeScreenShot(getWebDriver(), "START", "", "");
        }*/
        String strURL="";
        if(dataLogin.getData("Environment").toUpperCase().equals("STAGE"))
        {
        	strURL=dataLogin.getData("MembershipSTAGE_URL");
        	
        }
        if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
        {
        	strURL=dataLogin.getData("MembershipQA_URL");
        	
        }
        if(dataLogin.getData("Environment").toUpperCase().equals("SIT"))
        {
        	//strURL=dataLogin.getData("SIT_URL");
        	strURL=dataLogin.getData("MembershipSTAGE_URL");
        	
        }

		getWebDriver().navigate().to(strURL);
	    getWebDriver().manage().window().maximize();
	    focusBrowser();
	    CustomReporting.logReport("Open Application URL : "+  strURL);
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
	    
	    Thread.sleep(2000);
	    if(dataLogin.getData("Environment").toUpperCase().equals("STAGE"))
        {
	    	func._click(getElement(txt_username));
	    	_setValue(getElement(txt_username),dataLogin.getData("MemStageUserName"));
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_password),dataLogin.getData("MemStagePassword"));
        }
	    if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
        {
	    	func._click(getElement(txt_username));
	    	_setValue(getElement(txt_username),dataLogin.getData("MemQAUserName"));
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_password),dataLogin.getData("MemQAPassword"));
        }
	    if(dataLogin.getData("Environment").toUpperCase().equals("SIT"))
        {
	    	func._click(getElement(txt_username));
	    	_setValue(getElement(txt_username),dataLogin.getData("MemStageUserName"));
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_password),dataLogin.getData("MemStagePassword"));
        }
	    
	    	func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    	Thread.sleep(2000);
	    func._click(getElement(btn_Login));
	    func._record_PageLoadTime(getWebDriver(), 300L);
	    Thread.sleep(2000);
	    func._waitForPageToLoad(getWebDriver(),150L);
	}

	
	@Override
	public void MemberShipLogOut(String tcID, SoftAssert softAs, String DeviceName) throws Exception {
		Thread.sleep(3000);
		 func._waitFor(getElement(lnk_MemLogOut), 50, WAIT_FOR.CLICKABLE, "");
		 _click(getElement(lnk_MemLogOut));
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		
	}
	
	@Override
	public void LoginToclariondoor(String tcID, SoftAssert softAssert, String DeviceName) throws Exception {
		func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(2000);
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		/*String strScreenShots=dataLogin.getData("PrintScreens");
        if(strScreenShots.equalsIgnoreCase("Yes"))
        {
          func._takeScreenShot(getWebDriver(), "START", "", "");
        }*/
        String strURL="";
        if(dataLogin.getData("Environment").toUpperCase().equals("STAGE"))
        {
        	strURL=dataLogin.getData("ClariondoorSTAGE_URL");
        	
        }
        if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
        {
        	strURL=dataLogin.getData("ClariondoorQA_URL");
        	
        }
        if(dataLogin.getData("Environment").toUpperCase().equals("SIT"))
        {
        	strURL=dataLogin.getData("SIT_URL");
        	
        }

		getWebDriver().navigate().to(strURL);
	    getWebDriver().manage().window().maximize();
	    focusBrowser();
	    CustomReporting.logReport("Open Application URL : "+  strURL);
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
	    
	    Thread.sleep(2000);
	    if(dataLogin.getData("Environment").toUpperCase().equals("STAGE"))
        {
	    	func._click(getElement(txt_ClUserName));
	    	_setValue(getElement(txt_ClUserName),dataLogin.getData("ClStageUserName"));
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_ClPassword),dataLogin.getData("ClStagePassword"));
        }
	    if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
        {
	    	func._click(getElement(txt_ClUserName));
	    	_setValue(getElement(txt_ClUserName),dataLogin.getData("ClQAUserName"));
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_ClPassword),dataLogin.getData("ClQAPassword"));
        }
	    
	    	func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    	Thread.sleep(2000);
	    func._click(getElement(btn_CILogin));
	    func._record_PageLoadTime(getWebDriver(), 300L);
	    Thread.sleep(2000);
	    func._waitForPageToLoad(getWebDriver(),150L);

		
	}

	@Override
	public void clariondoorLogOut(String tcID, SoftAssert softAs, String DeviceName) throws Exception {
		Thread.sleep(3000);
		 func._waitFor(getElement(lnk_CILogout), 50, WAIT_FOR.CLICKABLE, "");
		 _click(getElement(lnk_CILogout));
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), tcID);
		
	}

	@Override
	public void OceanWide_Applications_Login(String tcID, SoftAssert softAssert, String DeviceName, String Application) throws Exception {
		func._waitForPageToLoad(getWebDriver(), 200L);
		Thread.sleep(2000);
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		/*String strScreenShots=dataLogin.getData("PrintScreens");
        if(strScreenShots.equalsIgnoreCase("Yes"))
        {
          func._takeScreenShot(getWebDriver(), "START", "", "");
        }*/
        String strURL="";
        if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
        {
        	if(Application.equals("SIG")) {
        		strURL=dataLogin.getData("SIG_QA_URL");
        	}
        	else if(Application.equals("WRO")) {
            	strURL=dataLogin.getData("WRO_QA_URL");
            } 
        	else if(Application.equals("Dental")) {
            	strURL=dataLogin.getData("DENTAL_QA_URL");
        		
        	}
        	
        }
        if(dataLogin.getData("Environment").toUpperCase().equals("STAGE"))
        {
        	if(Application.equals("SIG")) {
        		strURL=dataLogin.getData("SIG_STAGE_URL");
        	}
        	else if(Application.equals("WRO")) {
            	strURL=dataLogin.getData("WRO_STAGE_URL");
            } 
        	else if(Application.equals("Dental")) {
            	strURL=dataLogin.getData("DENTAL_STAGE_URL");
            } 
        	
        }
        if(dataLogin.getData("Environment").toUpperCase().equals("SIT"))
        {
        	strURL=dataLogin.getData("SIT_URL");
        	
        }

		getWebDriver().navigate().to(strURL);
	    getWebDriver().manage().window().maximize();
	    focusBrowser();
	    CustomReporting.logReport("Open Application URL : "+  strURL);
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
	    
	    Thread.sleep(2000);
	    if(dataLogin.getData("Environment").toUpperCase().equals("STAGE") || dataLogin.getData("Environment").toUpperCase().equals("SIT"))
        {
	    	func._click(getElement(txt_SIGWROUserName));
	    	
	    	if(Application.equals("SIG")) {
	    		_setValue(getElement(txt_SIGWROUserName),dataLogin.getData("SIGStageUserName"));
	    		Thread.sleep(1000);
	    		_setValue(getElement(txt_SIGWROPassword),dataLogin.getData("SIGStagePassword"));
	    	}
	    	else if(Application.equals("WRO")) {
	    		_setValue(getElement(txt_SIGWROUserName),dataLogin.getData("WROStageUserName"));
	    		Thread.sleep(1000);
	    		_setValue(getElement(txt_SIGWROPassword),dataLogin.getData("WROStagePassword"));
	    	}
	    	else if(Application.equals("Dental")) {
	    		_setValue(getElement(txt_SIGWROUserName),dataLogin.getData("DentalStageUserName"));
	    		Thread.sleep(1000);
	    		_setValue(getElement(txt_SIGWROPassword),dataLogin.getData("DentalStagePassword"));
	    	}
	    	
        }
	    if(dataLogin.getData("Environment").toUpperCase().equals("QA"))
        {
	    	func._click(getElement(txt_SIGWROUserName));
	    	
	    	if(Application.equals("SIG")) {
	    	_setValue(getElement(txt_SIGWROUserName),dataLogin.getData("SIGQAUserName"));
	    	Thread.sleep(1000);
	    	_setValue(getElement(txt_SIGWROPassword),dataLogin.getData("SIGQAPassword"));
	    	}
	    	else if(Application.equals("WRO")) {
	    		_setValue(getElement(txt_SIGWROUserName),dataLogin.getData("WROQAUserName"));
	    		Thread.sleep(1000);
	    		_setValue(getElement(txt_SIGWROPassword),dataLogin.getData("WROQAPassword"));
	    	}
	    	else if(Application.equals("Dental")) {
	    		_setValue(getElement(txt_SIGWROUserName),dataLogin.getData("DentalQAUserName"));
	    		Thread.sleep(1000);
	    		_setValue(getElement(txt_SIGWROPassword),dataLogin.getData("DentalQAPassword"));
	    	}
	    	
        }
	    
	    	func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    	Thread.sleep(2000);
	    func._click(getElement(btn_SIGWROLogin));
	    func._record_PageLoadTime(getWebDriver(), 300L);
	    Thread.sleep(2000);
	    func._waitForPageToLoad(getWebDriver(),150L);
		
	}

	@Override
	public void OceanWide_LogOut(String tcID, SoftAssert softAs, String DeviceName, String Application) throws Exception {
		
		try
		{
		
		if(Application.equals("SIG")) 
		{
			WebElement we = getWebDriver().findElement(By.xpath("//span[text()='SIG Broker QA']"));
			WebElement SigLogout = getWebDriver().findElement(By.xpath("//span[text()='Log Off']"));
			Actions act = new Actions(getWebDriver());
			act.moveToElement(we).moveToElement(SigLogout).click().build().perform();
		}
		else if(Application.equals("WRO")) 
		{
			
			WebElement we = getWebDriver().findElement(By.xpath("//span[text()='Universal Test Agent WRO']"));
			WebElement SigLogout = getWebDriver().findElement(By.xpath("//span[text()='Log Off']"));
			Actions act = new Actions(getWebDriver());
			act.moveToElement(we).moveToElement(SigLogout).click().build().perform();
		}
		}
		catch(Exception ex)
		{
			
		}
	}
	
	
}
