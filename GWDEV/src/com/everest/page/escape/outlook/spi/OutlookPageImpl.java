package com.everest.page.escape.outlook.spi;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.sikuli.script.App;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;

import com.everest.page.escape.outlook.OutlookPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;


public class OutlookPageImpl extends CustomAbstractPage implements OutlookPage {

	
	@Override
	public void SendEmail (String tcID, SoftAssert softAssert) throws Exception{
		
		App outlook=new App("Outlook");

       try {
    	   
    	    File directory = new File("./");
			System.out.println(directory.getAbsolutePath());
			String strDirectoryPath =directory.getAbsolutePath().split("\\.") [0];
			String strBundlePath=strDirectoryPath+"resources\\Images";
			//ImagePath.setBundlePath(DeviceManager.instance().getConfigurationProperties().getProperty("image.path"));
			ImagePath.setBundlePath(strBundlePath);
			long startTime = System.currentTimeMillis();
			//PageData dataNewBusiness = PageDataManager.instance().getPageData("NewBusiness",tcID);
			Screen screen = new Screen();
			Pattern img_BtnSend = new Pattern("Send.PNG");
			Pattern img_TxtToAddress = new Pattern("ToAddress.PNG");
			Pattern img_TxtSubject = new Pattern("Subject.PNG");
			Pattern img_TxtSubject1 = new Pattern("Subject1.PNG");
			outlook.focus();
			screen.wait(img_TxtToAddress, 10);
			screen.paste("shivaraju.basavaraju@everestre.com");
			func._takeScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
			outlook.focus();
			screen.wait(img_TxtSubject, 10);
			screen.type(img_TxtSubject,"Test");
			screen.type("a",Key.CTRL);
			screen.type(Key.DELETE);
			DateFormat df=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date dat=new Date();
			String strvalue="Submission Dispute Filing_"+ df.format(dat).replace("/", "_").replace(" ", "_").replace(":", "_");
			screen.wait(img_TxtSubject1, 10);
			screen.type(img_TxtSubject1,strvalue);
			screen.wait(img_BtnSend, 10);
			screen.click(img_BtnSend);
		
		CustomReporting.logReport("","", "Email is trigger to Everest contact'shivaraju.basavaraju@everestre.com'successfully", StepStatus.SUCCESS, new String[] { }, startTime);
		Thread.sleep(2000);
       }
       catch(Exception ex)
       {
    	   CustomReporting.logReport("", "", "Email is not trigger to Everest contact.","",StepStatus.FAILURE,new String[] { "", ""},System.currentTimeMillis(),null);
    	   System.out.println(ex);
       }
       
	}
	@Override
	public void VerifyEmailSent (String tcID, SoftAssert softAssert) throws Exception{
		
	}
	
	
}
		
		
		
