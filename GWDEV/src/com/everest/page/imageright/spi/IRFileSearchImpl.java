package com.everest.page.imageright.spi;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.imageright.IRFileSearch;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;


public class IRFileSearchImpl extends CustomAbstractPage implements IRFileSearch {
	
	long startTime = System.currentTimeMillis();

	
	@SuppressWarnings("static-access")
	@Override
	public void searchFile(String tcID, SoftAssert softAssert) throws Exception {

		try {
			PageData data = PageDataManager.instance().getPageData("SearchPolicy", tcID);

			_wait(2000);
			_click(getElement(btn_FileSearch));
			_wait(2000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			_setValue(getElement(txt_FileNumber), data.getData("SubmissionNo"));
			_wait(1000);

			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			_click(getElement(btn_IRSearch));
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if (func._isVisible(getElement(lbl_Results))) {
				int noOfFiles = getWebDriver()
						.findElements(By.xpath("//ir-search-results/div/div[2]/div/div/div/div[2]/div")).size();
				for (int i = 1; i <= noOfFiles; i++) {
					_wait(2000);
					getWebDriver()
							.findElement(By.xpath(
									"//ir-search-results/div/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div/a"))
							.click();
				}

			} else {
				if (func._isVisible(getElement(lbl_SubmissionNumber))) {
					CustomReporting.logReport("", "", "Submission Exist in Image Right", StepStatus.SUCCESS,
							new String[] {}, startTime);
				}
			}

			CustomReporting.instance().logReport("Sucessfully Searched and Opened Submission");
			func._waitForPageToLoad(getWebDriver(), 200L);

		} catch (Exception ex) {

			System.out.println(ex);
		}

	}
	
	
	
	
}
		
		
		
