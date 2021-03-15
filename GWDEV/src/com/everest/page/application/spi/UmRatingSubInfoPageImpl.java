package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmRatingSubInfoPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmRatingSubInfoPageImpl extends CustomAbstractPage implements UmRatingSubInfoPage {

	@Override
	public void UmAddingSubInfo(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmRatingSubInfo = PageDataManager.instance().getPageData("UmRatingSubInfo", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		
		
		
		_click(getElement(lnk_RatingSubInfo));
		_wait(2000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(Verification_Chkbx));
		_wait(2000);
		_click(getElement(dropdown_WritingApproach));
		_wait(2000);
		_setValue(getElement(search_box), dataUmRatingSubInfo.getData("WritingApproachOverride"));
		_wait(2000);
		_click(getClonedElement(Search_Results).addToken("tkn_writingapproach", dataUmRatingSubInfo.getData("WritingApproachOverride")));
		_wait(2000);
		_setValue(getElement(Justification_txtbox), dataUmRatingSubInfo.getData("Justification"));
		_wait(2000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(btnUpdateCoverages));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		long startTime = System.currentTimeMillis();
		String xPath = getElement(txtWritingApproach).getKey().toString();
		String pm = "return document.evaluate(\"" + xPath + "\", document, null, 9, null).singleNodeValue.value";
		String UmWritingApproach = js.executeScript(pm).toString();
		
		if(func._isVisible(getElement(GreenRightTickMark)))//UmWritingApproach.equalsIgnoreCase(dataUmRatingSubInfo.getData("WritingApproachOverride"))
		{
			CustomReporting.logReport("", "", " Writing Approach Override Successful " , StepStatus.SUCCESS, new String[] {},
					startTime);
		}
		else
		{
			CustomReporting.logReport("", "", "Writing Approach Override Failed. Actual Writing Approach after Override is: "+UmWritingApproach , StepStatus.FAILURE, new String[] {},
					startTime);
		}

	}

	
	@Override
	public void UmValidateWritingApproach(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataUmRatingSubInfo = PageDataManager.instance().getPageData("UmRatingSubInfo", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		
		
		
		_click(getElement(lnk_RatingSubInfo));
		_wait(2000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		_click(getElement(Verification_Chkbx));
		_wait(2000);
		_click(getElement(dropdown_WritingApproach));
		_wait(2000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		if(dataUmRatingSubInfo.getData("Active").equalsIgnoreCase("Yes"))
		{
			_setValue(getElement(search_box), dataUmRatingSubInfo.getData("Active_WritingApproach"));
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			if(func._isVisible(getClonedElement(Search_Results).addToken("tkn_writingapproach", dataUmRatingSubInfo.getData("Active_WritingApproach")))==true)
			{
				_click(getClonedElement(Search_Results).addToken("tkn_writingapproach", dataUmRatingSubInfo.getData("Active_WritingApproach")));
				_wait(2000);
				_setValue(getElement(Justification_txtbox), dataUmRatingSubInfo.getData("Justification"));
				_wait(2000);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				_click(getElement(btnUpdateCoverages));
				w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/loading-bar/div/div")));
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				CustomReporting.logReport("", "", " Writing Approach is Active as expected as per EPRO-82397 " , StepStatus.SUCCESS, new String[] {},
						System.currentTimeMillis());
			}
			else
			{
				CustomReporting.logReport("", "", " Writing Approach is Not Available as per EPRO-82397 " , StepStatus.FAILURE, new String[] {},
						System.currentTimeMillis());
			}
		}
		else
		{
			_setValue(getElement(search_box), dataUmRatingSubInfo.getData("Deactive_WritingApproach"));
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			if(func._isVisible(getClonedElement(Search_Results).addToken("tkn_writingapproach", dataUmRatingSubInfo.getData("Deactive_WritingApproach")))==false)
			{
				CustomReporting.logReport("", "", " Writing Approach is DeActive as expected as per EPRO-82397" , StepStatus.SUCCESS, new String[] {},
						System.currentTimeMillis());
			}
			else
			{
				CustomReporting.logReport("", "", "UnExpected Writing Approach is Available NOT Matching as per EPRO-82397" , StepStatus.FAILURE, new String[] {},
						System.currentTimeMillis());
			}
		}
	
	}

}
