package com.everest.page.application.spi;

import java.io.File;
import java.util.Set;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import org.xframium.device.DeviceManager;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.PcSummaryPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class PcSummaryPageImpl extends CustomAbstractPage implements PcSummaryPage {

	@SuppressWarnings("static-access")
	@Override
	public void PcPaymentDetailsValidation(String tcID, SoftAssert softAssert) throws Exception 
	{
		
		_wait(4000);
		PageData dataUmSubDetails = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		
		_click(getElement(Issuance_Tran));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(4000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		_click(getElement(PaymentPageLink));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(4000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
		/*String BillingMethod_PC = _getAttributeValue(getElement(BillingMethod), "TEXT");
		String PaymentPlan_PC = _getAttributeValue(getElement(PaymentPlan), "TEXT");
		CustomReporting.logReport(BillingMethod_PC+PaymentPlan_PC);*/
		
		
		func._checkAttributeValue(getElement(PaymentPlan), "TEXT", dataUmSubDetails.getData("PaymentPlan"), softAssert);
		
		if(dataUmSubDetails.getData("BillType").equalsIgnoreCase("Direct")) 
		{
			func._checkAttributeValue(getElement(BillingMethod), "TEXT", "Direct Bill", softAssert);
		}
		else 
		{
			func._checkAttributeValue(getElement(BillingMethod), "TEXT", "Agency Bill", softAssert);
		}
		
				
	}
	
	@Override
	public void PcPremiumBreakdownValidation(String tcID, SoftAssert softAssert) throws Exception 
	{
		
		_wait(4000);
		PageData dataUmSubDetails = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		PageData dataUmBinding = PageDataManager.instance().getPageData("UmBinding", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		
		_click(getElement(Issuance_Tran));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(4000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		_click(getElement(PaymentPageLink));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(4000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		 
		 String PC_Crime = _getAttributeValue(getElement(Crime), "TEXT").split("\\.")[0];
		 String PC_Cyber1 = _getAttributeValue(getElement(Cyber_1), "TEXT").split("\\.")[0];
		 String PC_Cyber2 = _getAttributeValue(getElement(Cyber_2), "TEXT").split("\\.")[0];
		 String PC_DNO = _getAttributeValue(getElement(DNO), "TEXT").split("\\.")[0];
		 String PC_EMP = _getAttributeValue(getElement(EMP), "TEXT").split("\\.")[0];
		 String PC_ENO = _getAttributeValue(getElement(ENO), "TEXT").split("\\.")[0];
		 String PC_EPL = _getAttributeValue(getElement(EPL), "TEXT").split("\\.")[0];
		 String PC_FID = _getAttributeValue(getElement(FID), "TEXT").split("\\.")[0];
		 String PC_KNR = _getAttributeValue(getElement(KNR), "TEXT").split("\\.")[0];
		 
		 /*func._checkAttributeValue(getElement(Crime), "TEXT", dataUmBinding.getData("UM_CrimeP"), softAssert);
		 func._checkAttributeValue(getElement(Cyber_1), "TEXT", dataUmBinding.getData("UM_Cyber1P").split(".")[0], softAssert);
		 func._checkAttributeValue(getElement(Cyber_2), "TEXT", dataUmBinding.getData("UM_Cyber2P").split(".")[0], softAssert);
		 func._checkAttributeValue(getElement(DNO), "TEXT", dataUmBinding.getData("UM_DNOP").split(".")[0], softAssert);
		 func._checkAttributeValue(getElement(EMP), "TEXT", dataUmBinding.getData("UM_EMPP").split(".")[0], softAssert);
		 func._checkAttributeValue(getElement(ENO), "TEXT", dataUmBinding.getData("UM_ENOP").split(".")[0], softAssert);
		 func._checkAttributeValue(getElement(EPL), "TEXT", dataUmBinding.getData("UM_EPLP").split(".")[0], softAssert);
		 func._checkAttributeValue(getElement(FID), "TEXT", dataUmBinding.getData("UM_FIDP").split(".")[0], softAssert);
		 func._checkAttributeValue(getElement(KNR), "TEXT", dataUmBinding.getData("UM_KNRP").split(".")[0], softAssert);*/
		 
		 func._compareStringIgnorecase(PC_Crime, dataUmBinding.getData("UM_CrimeP"));
		 func._compareStringIgnorecase(PC_Cyber1, dataUmBinding.getData("UM_Cyber1P"));
		 func._compareStringIgnorecase(PC_Cyber2, dataUmBinding.getData("UM_Cyber2P"));
		 func._compareStringIgnorecase(PC_DNO, dataUmBinding.getData("UM_DNOP"));
		 func._compareStringIgnorecase(PC_EMP, dataUmBinding.getData("UM_EMPP"));
		 func._compareStringIgnorecase(PC_ENO, dataUmBinding.getData("UM_ENOP"));
		 func._compareStringIgnorecase(PC_EPL, dataUmBinding.getData("UM_EPLP"));
		 func._compareStringIgnorecase(PC_FID, dataUmBinding.getData("UM_FIDP"));
		 func._compareStringIgnorecase(PC_KNR, dataUmBinding.getData("UM_KNRP"));
	}
	
	@Override
	public void PcDownloadForm(String tcID, SoftAssert softAssert) throws Exception 
	{
		
		
		PageData dataUmSrchPolicy = PageDataManager.instance().getPageData("SearchPolicy", tcID);
		PageData dataUmSubDet= PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		
		_wait(2000);
		_click(getElement(DocumentsPage));
		_wait(5000);
		String Main_win_id = getWebDriver().getWindowHandle();
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(EndDoc_Link));
		_wait(15000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	
		File directory = new File("./");
		String strDirectoryPath = directory.getAbsolutePath().split("\\.")[0];	
		String ImagesFolderPath = DeviceManager.instance().getConfigurationProperties().getProperty("images.path");
		Screen s = new Screen();
        Pattern SaveIconPatrn = new Pattern(strDirectoryPath +ImagesFolderPath+ "SaveIcon.PNG");
        s.wait(SaveIconPatrn, 20);
        s.click(SaveIconPatrn);
       
        String QVDownloadFilePath ="";
		String DownloadFilePath = DeviceManager.instance().getConfigurationProperties().getProperty("download.path");
		QVDownloadFilePath =strDirectoryPath+DownloadFilePath;
		String strFileName = dataUmSrchPolicy.getData("PolicyNo") +"_Endorsement.PDF";
		func._downloadFile(QVDownloadFilePath, strFileName);
		
		CustomReporting.logReport("", "", "Successfully downloaded the Endorsement Document : "+strFileName, StepStatus.SUCCESS,
				new String[] {}, System.currentTimeMillis());
		
		Set<String> allwinids = getWebDriver().getWindowHandles();
		String[] ids =  allwinids.toArray(new String[allwinids.size()]);
		for(int i=0;i<allwinids.size();i++)
		{
			getWebDriver().switchTo().window(ids[i]);
			String current_win_id = getWebDriver().getWindowHandle();
			if(!current_win_id.equalsIgnoreCase(Main_win_id))
			{
				System.out.println("Closed PDF Window");
				CustomReporting.logReport("Closed PDF Window");
				getWebDriver().close();
			}
		}
		getWebDriver().switchTo().window(Main_win_id);
		
		if (dataUmSubDet.getData("ComparePDF").equalsIgnoreCase("Yes"))
		{
			func.PDF_Compare_PC(dataUmSrchPolicy.getData("PolicyNo")+"_Endorsement", tcID);
		}
		
		
				
	}

	
	@Override
	public void PcPrintForm(String tcID, SoftAssert softAssert) throws Exception 
	{
		_wait(2000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(Print_btn));
		_wait(20000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(Finalize_btn));
		_wait(20000);
		 func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
	}
	
	
		

}
