package com.everest.page.application.spi;



import java.io.File;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmCollaborationToolPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;


public class UmCollaborationToolPageImpl extends CustomAbstractPage implements UmCollaborationToolPage {
		
	
	@Override
	public void uploadTaskFile(String tcID, SoftAssert softAssert,String DeviceName) throws Exception
	{
		PageData data = PageDataManager.instance().getPageData("CollaborationTool", tcID); 
		File directory = new File("./");
	 		System.out.println(directory.getAbsolutePath());
	 		String strDirectoryPath =directory.getAbsolutePath().split("\\.") [0];
	 		String filePath=strDirectoryPath+"resources\\Images\\"+data.getData("FileName");
	 		String fileName = data.getData("FileName");
	    _wait(2000);
	    
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    
	    _click(getElement(btn_Tasks));
	    _wait(2000);
	    
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    _click(getElement(btn_NewTask));
	    _wait(2000);
	    
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    _click(getElement(btn_ChooseFile));
	    _wait(5000);
	    func._uploadFile(filePath);
	    _wait(5000);
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    _click(getElement(btn_Type));
	    _wait(3000);
	    int noOfTypes = getWebDriver().findElements(By.xpath("//ul[contains(@class,'attachmentTypeList')]/li")).size();
	    for(int i=1;i<=noOfTypes;i++) {
	    String typeName=getWebDriver().findElement(By.xpath("//ul[contains(@class,'attachmentTypeList')]/li["+i+"]/a")).getText();
	    	if(typeName.equalsIgnoreCase(data.getData("TaskType"))) {
	    		getWebDriver().findElement(By.xpath("//ul[contains(@class,'attachmentTypeList')]/li["+i+"]/a")).click();
	    	}
	    }
	    _wait(2000);
	    _click(getElement(btn_UploadFile));
	    _wait(2000);
	    _click(getElement(btn_CloseTask));
	    _wait(2000);
	    _click(getElement(btn_Files));
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    _wait(2000);
	    func._checkAttributeValue(getElement(lblFileName), "TEXT", fileName, softAssert);
	   
	    func._waitForPageToLoad(getWebDriver(),50L);
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    CustomReporting.logReport("","","File Uploaded successfully" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
	}
		

}
