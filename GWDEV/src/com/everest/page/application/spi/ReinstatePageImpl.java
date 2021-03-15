package com.everest.page.application.spi;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.ReinstatePage;
import com.everest.utility.CustomAbstractPage;

public class ReinstatePageImpl extends CustomAbstractPage implements ReinstatePage  {
	@SuppressWarnings("static-access")
	@Override
	public void Reinstate(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataReinstate = PageDataManager.instance().getPageData("Reinstate", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(2000);
		/*String strScreenShots = dataReinstate.getData("PrintScreens");
		if (strScreenShots.equalsIgnoreCase("Yes")) {
			func._takeScreenShot(getWebDriver(), "START", "", "");
		}*/
		_click(getElement(tabActions));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(lnkReinstate));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		_click(getElement(txtReason));
		
		_setValue(getElement(txtReason), dataReinstate.getData("Reason"));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		_click(getElement(btnQuote));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(10000);
		if(dataReinstate.getData("PremiumChange").equalsIgnoreCase("Yes")) {
			_wait(4000);
			_click(getElement(lblPayment));
			_wait(4000);
		
				String xpath = "//*[contains(text(),'Total Premium')]/../..//div//div"; 
				String TotalPremium = getWebDriver().findElement(By.xpath(xpath)).getText();
//				String ActualPremium[] = TotalPremium.split(" - ");
				
				String Premiumvalue = TotalPremium.replaceAll("(\\s+|\\$|,)", "");
				double TotalCoveragePremium =Double.parseDouble(Premiumvalue);  
				
				
				
				String Textinputxpath = "//*[contains(text(),'Premium Breakdown')]/../../..//input"; 
				double NumberCvgs = getWebDriver().findElements(By.xpath(Textinputxpath)).size();
				double ActualCvgs = NumberCvgs;	
				double CoveragePremium = (TotalCoveragePremium/ActualCvgs);
				  DecimalFormat df2 = new DecimalFormat("#.##");
				double CvgValue = Double.parseDouble(df2.format(CoveragePremium));
				String CvgPremium = Double.toString(CvgValue);
				double LastPremium = Double.parseDouble(df2.format(TotalCoveragePremium-(CvgValue*(NumberCvgs-1))));
				String LastPrem = Double.toString(LastPremium);
				for (int i=0;i<NumberCvgs;i++)
				{
					if (i==(NumberCvgs-1))
					{
						int n = i+1;
						String Cvgs = "(//*[contains(text(),'Premium Breakdown')]/../../..//input)[" + n + "]";
						WebElement CvgField = getWebDriver().findElement(By.xpath(Cvgs));	
						CvgField.sendKeys(LastPrem);
						_wait(2000);
						func.setValue9();
					}
					else
					{	
					int n = i+1;
					String Cvgs = "(//*[contains(text(),'Premium Breakdown')]/../../..//input)[" + n + "]";
					WebElement CvgField = getWebDriver().findElement(By.xpath(Cvgs));
					CvgField.sendKeys(CvgPremium);
					_wait(2000);
					func.setValue9();
					}
				}
				_wait(4000);
			
		}
		
		_wait(15000);
		
		_click(getElement(btnReinstate));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(8000);
		
//		if (func._isVisible(getElement(btnReinstate)) == true)
//		{
//			_click(getElement(btnReinstate));	
//			_wait(4000);
//		}
		
		try {
			_click(getElement(btnOk));
		} catch (Exception e) {
			_wait(3000);
			WebElement we = (WebElement)getElement(btnOk).getNative();
			we.click();
		}
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
	}
}
