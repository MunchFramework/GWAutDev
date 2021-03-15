package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.Element.WAIT_FOR;

import com.everest.page.application.UmGetSubmissionNumberPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmGetSubmissionNumberPageImpl extends CustomAbstractPage implements UmGetSubmissionNumberPage {

	@Override
	public void UmSubmissionNumber(String tcID, SoftAssert softAssert) throws Exception {
		
		func._waitForPageToLoad(getWebDriver(), 50L);

	
	_wait(10000);

		_click(getElement(lnkAccountHistory));
		_wait(5000);
		func._waitFor(getElement(lblSubmissionNo), 100, WAIT_FOR.VISIBLE);
		_click(getElement(lblSubmissionNo));
		_wait(10000);

	String Submission = _getAttributeValue(getElement(lblSubmissionNo), "TEXT");
	
	String submissionStatus = _getAttributeValue(getElement(lbl_SubmissionStatus), "TEXT");
	
	String SubmissionNo = Submission.trim();
	 
    

		//_writeToExcel("SearchPolicy", "PolicyNo", SubmissionNo, tcID);
	_writeToExcel("SearchPolicy", "SubmissionNo", SubmissionNo, tcID);
	_writeToExcel("SearchPolicy", "Status", submissionStatus, tcID);
		

		

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		CustomReporting.logReport("", "", "Application created successfully!", StepStatus.REPORT,
				new String[] {}, System.currentTimeMillis());
	}
	
	
	@Override
	public void verify_UMPolicy_Renewaval(String tcID, SoftAssert softAssert) throws Exception {
		
		func._waitForPageToLoad(getWebDriver(), 50L);

	
	_wait(10000);

		_click(getElement(lnkSubmission));
		_wait(5000);
		func._waitFor(getElement(get_SubmissionNumr), 100, WAIT_FOR.VISIBLE);
		WebElement weSubNum=(WebElement)getElement(get_SubmissionNumr).getNative();
		String SubmissionNo= weSubNum.getAttribute("value").trim();

		String SubVer=SubmissionNo.split("-")[1].trim();
		if(Integer.valueOf(SubVer)>1)

		{
			CustomReporting.logReport("","","'"+ "Um submission is renewaled sucessfully" + "" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
			
		}
		
		else
		{
			CustomReporting.logReport("","","'"+ "Um submission is not  renewaled sucessfully" + 
					"" + 
					"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
			
		}
		WebElement PolicyNumber=(WebElement)getElement(get_Policy).getNative();
		
		String PolicyNum = PolicyNumber.getAttribute("value");
		String PolicyVer=PolicyNum.split("-")[1].trim();
			if(Integer.valueOf(PolicyVer)>1)

			{
				CustomReporting.logReport("","","'"+ "Um Policy is renewaled sucessfully" + "" + 
						"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
				
			}
			
			else
			{
				CustomReporting.logReport("","","'"+ "Um Policy is not  renewaled sucessfully" + 
						"" + 
						"", "", StepStatus.FAILURE,new String[] { }, System.currentTimeMillis(), null);
				
			}

		
	}
	
	@Override
	public void UmSubmissionInformation(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmLogin = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		
	
	_wait(10000);

		_click(getElement(lnkSubmission_01));
		_wait(5000);
		
	String submissionNo=getWebDriver().findElement(By.xpath("//input[contains(@class,'formFieldComponent-submissionNumber')]")).getAttribute("value");
	System.out.println(submissionNo);
	String insuredName=getWebDriver().findElement(By.xpath("//input[contains(@class,'formFieldComponent-insuredName')]")).getAttribute("value");
	System.out.println(insuredName);
	String policyPremium=getWebDriver().findElement(By.xpath("//input[contains(@class,'formFieldComponent-submissionPremium')]")).getAttribute("value");
	System.out.println(policyPremium);
	String address1=getWebDriver().findElement(By.xpath("//input[contains(@class,'formFieldComponent-street1B')]")).getAttribute("value");
	System.out.println(address1);
	
	String producerOffice=getWebDriver().findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[7]/ui-row[2]/div/ui-form-dropdown[2]/div/div/um-lazy-load-dropdown/um-dropdown-button/div/button/span[1]")).getText();
	String uwAssistant=getWebDriver().findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[8]/ui-row[3]/div/ui-form-dropdown[2]/div/div/um-lazy-load-dropdown/um-dropdown-button/div/button/span[1]")).getText();
	
	String ownershipType = _getAttributeValue(getElement(txt_OwnerShipType), "TEXT");
	String policylimit=getWebDriver().findElement(By.xpath("//input[contains(@class,'formFieldComponent-attachmentPointLimit')]")).getAttribute("value");
	
	
	if (dataUmLogin.getData("Excess").equalsIgnoreCase("Yes")) 
	{
		String retention=getWebDriver().findElement(By.xpath("//input[contains(@class,'formFieldComponent-attachmentPointPerPolicy')]")).getAttribute("value");
		_writeToExcel("Escapefields", "Retention", retention, tcID);
	}
	
	
	
	_writeToExcel("SearchPolicy", "SubmissionNo", submissionNo, tcID);
	_writeToExcel("SearchPolicy", "InsName", insuredName, tcID);
	
	_writeToExcel("SearchPolicy", "Premium", policyPremium, tcID);
	
	_writeToExcel("SearchPolicy", "OwnershipType", ownershipType, tcID);
	_writeToExcel("SearchPolicy", "Address1", address1, tcID);
	_writeToExcel("SearchPolicy", "ProducerOffice", producerOffice, tcID);
	_writeToExcel("SearchPolicy", "UWAssistant", uwAssistant, tcID);
	_writeToExcel("Escapefields", "policylimit", policylimit, tcID);
	
	_click(getElement(btn_Policy));
	_wait(3000);
	
	_click(getElement(lst_PolicyDetails));
	_wait(5000);
	if(dataUmLogin.getData("SlimProducts").equalsIgnoreCase("Yes")) 
	{
		_click(getElement(btn_RatingSlimLine));
		_wait(5000);
	}else 
	{
		if (dataUmLogin.getData("Excess").equalsIgnoreCase("Yes")) 
		{
			getWebDriver().findElement(By.xpath("//button/span[contains(text(),'Rating: EZ Excess')]")).click();
			_wait(5000);
		}
		else
		{
			getWebDriver().findElement(By.xpath("//button/span[contains(text(),'Rating: Common')]")).click();
			_wait(5000);
		}
		
	}
	
	
	if(dataUmLogin.getData("POL").equalsIgnoreCase("Yes")) 
	{
		String limit=getWebDriver().findElement(By.xpath("//input[contains(@class,'formFieldComponent-polSlimLimit')]")).getAttribute("value");
		_writeToExcel("Escapefields", "Limit", limit, tcID);
	}
	if(dataUmLogin.getData("CON").equalsIgnoreCase("Yes")) 
	{
		String limit=getWebDriver().findElement(By.xpath("//input[contains(@class,'formFieldComponent-conSlimAggregateLimit')]")).getAttribute("value");
		_writeToExcel("Escapefields", "Limit", limit, tcID);
		String retention=getWebDriver().findElement(By.xpath("//input[contains(@class,'formFieldComponent-conSlimRetention')]")).getAttribute("value");
		_writeToExcel("Escapefields", "Retention", retention, tcID);
	}
	String comissionperc = null;
	
	if(dataUmLogin.getData("SlimProducts").equalsIgnoreCase("Yes")) 
	{
		comissionperc= getWebDriver().findElement(By.xpath("//input[contains(@class,'formFieldComponent-slimCommission')]")).getAttribute("value");
	}else {
		comissionperc= getWebDriver().findElement(By.xpath("//input[contains(@class,'ommission')]")).getAttribute("value");//formFieldComponent-commission
	}
	 
	//String lob =getWebDriver().findElement(By.xpath("//input[contains(@class,'SlimClauseName')]")).getAttribute("value");
	//String limit = getWebDriver().findElement(By.xpath("//input[contains(@class,'SlimAggregateLimit')]")).getAttribute("value");
	//String retention = getWebDriver().findElement(By.xpath("//input[contains(@class,'SlimRetention')]")).getAttribute("value");
	
	_writeToExcel("SearchPolicy", "CommissionPerc", comissionperc, tcID);
	//_writeToExcel("SearchPolicy", "lob", lob, tcID);
	//_writeToExcel("SearchPolicy", "Limit", limit, tcID);
	//_writeToExcel("SearchPolicy", "Retention", retention, tcID);
	
	_click(getElement(btn_Quoting));
	_wait(5000);
	
	String insuringCompany = _getAttributeValue(getElement(lbl_InsuringCompany), "TEXT");
	
	
	
	_writeToExcel("SearchPolicy", "InsuringCompany", insuringCompany, tcID);
	
		

		

		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		CustomReporting.logReport("", "", "Application created successfully!", StepStatus.REPORT,
				new String[] {}, System.currentTimeMillis());
	}
	
	@Override
	public void getUWBranchOfficeDetails(String tcID, SoftAssert softAssert) throws Exception {

		func._waitForPageToLoad(getWebDriver(), 50L);

		_wait(10000);

		_click(getElement(lnkSubmission_01));
		_wait(5000);

		String producerOffice = getWebDriver().findElement(By.xpath(
				"/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[7]/ui-row[2]/div/ui-form-dropdown[2]/div/div/um-lazy-load-dropdown/um-dropdown-button/div/button/span[1]"))
				.getText();
		String uwAssistant = getWebDriver().findElement(By.xpath(
				"/html/body/div[2]/div/div[2]/div/div[2]/ui-form-viewer/div/div[2]/div[8]/ui-row[3]/div/ui-form-dropdown[2]/div/div/um-lazy-load-dropdown/um-dropdown-button/div/button/span[1]"))
				.getText();

		_writeToExcel("SearchPolicy", "ProducerOffice", producerOffice, tcID);
		_writeToExcel("SearchPolicy", "UWAssistant", uwAssistant, tcID);

	}
	
	@Override
	public void verifyMNPCIMF4Surcharges(String tcID, SoftAssert softAssert) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
		_click(getElement(btn_Policy));
		_wait(3000);
		
		_click(getElement(lst_PolicyDetails));
		_wait(5000);
		_click(getElement(btn_RatingCRI));
		_wait(8000);
		
		jse.executeScript("window.scrollTo(0,900);");
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		String crimeSubtotal = func._getAttributeValue(getElement(txt_CRIMESubtotal), "value", softAssert).replace("$", "").replace(",", "");
		_wait(5000);
		double crimeValue = Integer.parseInt(crimeSubtotal)*0.005;
		_click(getElement(btn_RatingKNR));
		_wait(8000);
		
		jse.executeScript("window.scrollTo(0,900);");
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		String knrsubtotal = func._getAttributeValue(getElement(txt_KNRSubtotal), "value", softAssert).replace("$", "").replace(",", "");
		double knrValue = Integer.parseInt(knrsubtotal)*0.005;
		double totalSurcharges= Math.round(crimeValue+knrValue);
		_wait(5000);
		_click(getElement(btn_RatingPremiumSummary));
		_wait(8000);
		jse.executeScript("window.scrollTo(0,1200);");
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		String MNsurcharges=func._getAttributeValue(getElement(txt_MNFireSurcharges), "value", softAssert);
		_writeToExcel("Login", "MNFireSurcharges", MNsurcharges, tcID);
		
		String totalOfCRIKNR = Double.toString(totalSurcharges);
		func._checkAttributeValue(getElement(txt_MNFireSurcharges), "value", "$"+totalOfCRIKNR, softAssert);
	}
	
	@Override
	public void verifyFIDPremium(String tcID, SoftAssert softAssert) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
		_click(getElement(btn_Policy));
		_wait(3000);
		
		_click(getElement(lst_PolicyDetails));
		_wait(5000);
		_click(getElement(btn_RatingFID));
		_wait(8000);
		String FIDPremium=func._getAttributeValue(getElement(txt_FIDPremium), "value", softAssert);
		
		_click(getElement(btn_RatingPremiumSummary));
		_wait(8000);
		jse.executeScript("window.scrollTo(0,1200);");
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		func._checkAttributeValue(getElement(txt_FIDSubtotal), "value", FIDPremium, softAssert);
		String FIDSubtotal=func._getAttributeValue(getElement(txt_FIDSubtotal), "value", softAssert);
		String DNOSubtotal=func._getAttributeValue(getElement(txt_DNOSubtotal), "value", softAssert);
		String EPLSubtotal=func._getAttributeValue(getElement(txt_EPLSubtotal), "value", softAssert);
		_writeToExcel("InsuredAppLogin", "FIDSubtotal", FIDSubtotal, tcID);
		_writeToExcel("InsuredAppLogin", "DNOSubtotal", DNOSubtotal, tcID);
		_writeToExcel("InsuredAppLogin", "EPLSubtotal", EPLSubtotal, tcID);
		
	}
	
	@Override
	public void verifyCYBPremiumAgainstRater(String tcID, SoftAssert softAssert) throws Exception {
		PageData data = PageDataManager.instance().getPageData("CYB", tcID);
		JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
		_click(getElement(btn_Policy));
		_wait(3000);
		
		_click(getElement(lst_PolicyDetails));
		_wait(5000);
		_click(getElement(btn_RatingCYB));
		_wait(8000);
		String CYBPremium=func._getAttributeValue(getElement(txt_CYBPremium), "value", softAssert).replace("$", "");
		
		if(CYBPremium.equalsIgnoreCase( data.getData("ExpectedPremium"))) {
			CustomReporting.logReport("","","'"+ " Cyber Premium Value matches with Rater value" + "" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}else {
			CustomReporting.logReport("","","'"+ "Cyber Premium Value does not matches with Rater value" + "" + 
					"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());
		}
		
		
		_click(getElement(btn_RatingPremiumSummary));
		_wait(8000);
		jse.executeScript("window.scrollTo(0,1200);");
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
String CYBPremiumSubtotal=func._getAttributeValue(getElement(txt_CYBPremiumSubtotal), "value", softAssert).replace("$", "");
		
		if(CYBPremiumSubtotal.equalsIgnoreCase( data.getData("ExpectedPremium"))) {
			CustomReporting.logReport("","","'"+ "Cyber Premium Subtotal Value matches with Rater value" + "" + 
					"",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());
		}else {
			CustomReporting.logReport("","","'"+ "Cyber Premium Subtotal Value does not matches with Rater value" + "" + 
					"",StepStatus.FAILURE,new String[] { },System.currentTimeMillis());
		}
		
		
		
	}





}

