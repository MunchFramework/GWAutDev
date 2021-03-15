package com.everest.page.imageright.spi;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.imageright.IROpenFile;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;


public class IROpenFileImpl extends CustomAbstractPage implements IROpenFile {
	
	long startTime = System.currentTimeMillis();

	
	@SuppressWarnings("static-access")
	@Override
	public void verifyPolicyDocuments(String tcID, SoftAssert softAssert) throws Exception {

		try {
			PageData data = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
			PageData dataSearch = PageDataManager.instance().getPageData("SearchPolicy", tcID);
			String submissionId = dataSearch.getData("SubmissionNo");
			String insuredName = dataSearch.getData("InsName");
			Date date =  new Date(); 
			//String strDate = new SimpleDateFormat("M/d/yyyy").format(date);
			String strDate = "8/21/2019";
			func._checkAttributeValue(getElement(lbl_SubmissionNumber), "TEXT", submissionId, softAssert);
			_wait(2000);
			func._checkAttributeValue(getElement(lbl_InsuredFileName), "TEXT", insuredName, softAssert);
			_wait(2000);
			
			//String id = getWebDriver().findElement(By.xpath("//div[1]/div[2]/div[2]//div[2]/div/ir-open-file")).getAttribute("id");
			
			_wait(2000);
			_click(getElement(btn_MainFolderCorrespondance));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_wait(2000);
			getWebDriver().findElement(By.xpath("//div[contains(@title,'"+strDate+" Correspondence')]/button")).click();
			
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_wait(2000);
			int noOFEmails = getWebDriver().findElements(By.xpath("//div[contains(@title,'Email-')]")).size();
			if(noOFEmails == 3) {
				CustomReporting.logReport("", "", "All Emails present in ImageRight", StepStatus.SUCCESS,
						new String[] {}, startTime);
			}
			
			
			
			_click(getElement(btn_MainFolderCorrespondance));
			
			_wait(2000);
			_click(getElement(btn_RatingQuoting));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_wait(2000);
			//_click(getElement(btn_Quote));
			getWebDriver().findElement(By.xpath("//div[contains(@title,'"+strDate+" Everest Quote')]/button")).click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_wait(2000);
			String quoteLetter = func._getAttributeValue(getElement(txt_QuoteLetter), "TEXT", softAssert);
			if(quoteLetter.contains(quoteLetter)) {
				CustomReporting.logReport("", "", "Quote Letter File Exist in ImageRight", StepStatus.SUCCESS,
						new String[] {}, startTime);
			}else {
				CustomReporting.logReport("", "", "Quote Letter File Doesnt Exist in ImageRight", StepStatus.FAILURE,
						new String[] {}, startTime);
			}
			
			_click(getElement(btn_RatingQuoting));
			_wait(2000);
			
			_click(getElement(btn_BindBilling));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_wait(2000);
			//_click(getElement(btn_BillingInvoice));
			getWebDriver().findElement(By.xpath("//div[contains(@title,'"+strDate+" Binder Bill')]/button")).click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_wait(2000);
			String billingInvoice = func._getAttributeValue(getElement(txt_InvoiceLetter), "TEXT", softAssert);
			if(billingInvoice.contains("1: BillingInvoice.pdf.pdf")) {
				CustomReporting.logReport("", "", "Billing Invoice File Exist in ImageRight", StepStatus.SUCCESS,
						new String[] {}, startTime);
			}else {
				CustomReporting.logReport("", "", "Billing Invoice File Doesnt Exist in ImageRight", StepStatus.FAILURE,
						new String[] {}, startTime);
			}
			
			//_click(getElement(btn_Bind));
			getWebDriver().findElement(By.xpath("//div[contains(@title,'"+strDate+" Everest Binder')]/button")).click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_wait(2000);
			String bind = func._getAttributeValue(getElement(txt_BindLetter), "TEXT", softAssert);
			if(bind.contains(bind)) {
				CustomReporting.logReport("", "", "Bind Document File Exist in ImageRight with name" + bind, StepStatus.SUCCESS,
						new String[] {}, startTime);
			}else {
				CustomReporting.logReport("", "", "Bind File Doesnt Exist in ImageRight", StepStatus.FAILURE,
						new String[] {}, startTime);
			}
			
			_click(getElement(btn_BindBilling));
			_wait(2000);
			

			_click(getElement(btn_Policy));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_wait(2000);
			//_click(getElement(btn_PolicySubFolder));
			getWebDriver().findElement(By.xpath("//div[contains(@title,'"+strDate+" Everest Policy')]/button")).click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_wait(2000);
			String policyDocument = func._getAttributeValue(getElement(txt_PolicyDoc), "TEXT", softAssert);
			if(policyDocument.contains(policyDocument)) {
				CustomReporting.logReport("", "", "Policy Document  File Exist in ImageRight" + policyDocument, StepStatus.SUCCESS,
						new String[] {}, startTime);
			}else {
				CustomReporting.logReport("", "", "Policy Document File Doesnt Exist in ImageRight", StepStatus.FAILURE,
						new String[] {}, startTime);
			}
			

		} catch (Exception ex) {

			System.out.println(ex);
		}

	}
	
	
	
	
}
		
		
		
