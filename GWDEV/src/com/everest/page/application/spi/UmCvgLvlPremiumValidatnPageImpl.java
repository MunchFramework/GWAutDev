package com.everest.page.application.spi;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.UmCvgLvlPremiumValidatnPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class UmCvgLvlPremiumValidatnPageImpl extends CustomAbstractPage implements UmCvgLvlPremiumValidatnPage {

	@Override
	public void UmCvgLvlPremiumValidatn(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataUmPremium = PageDataManager.instance().getPageData("ExcelRater", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		String strScreenShots = dataUmPremium.getData("PrintScreens");
		if (strScreenShots.equalsIgnoreCase("Yes")) {
			func._takeScreenShot(getWebDriver(), "START", "", "");
		}
		_wait(10000);

		_click(getElement(tabRatingPremiumSummary));
		_wait(5000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		long startTime = System.currentTimeMillis();

		if (func._isVisible(getElement(txtCrimeSubtotal)) == true) {
			_wait(2000);
			String xPath = getElement(txtCrimeSubtotal).getKey().toString();
			String pm = "return document.evaluate(\"" + xPath + "\", document, null, 9, null).singleNodeValue.value";
			String Umvalue = js.executeScript(pm).toString().replaceAll("(\\s+|\\$|,)", "");
			String RaterSheetValue = dataUmPremium.getData("CRISubtotal").replaceAll("(\\s+|\\$|,)", "");
			if (Umvalue.equals((RaterSheetValue))) {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for CRI coverage is the same. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for CRI coverage have changed. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.FAILURE, new String[] {}, startTime);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
		}
		if (func._isVisible(getElement(txtCyberSubtotal)) == true) {
			_wait(2000);
			String xPath = getElement(txtCyberSubtotal).getKey().toString();
			String pm = "return document.evaluate(\"" + xPath + "\", document, null, 9, null).singleNodeValue.value";
			String Umvalue = js.executeScript(pm).toString().replaceAll("(\\s+|\\$|,)", "");
			String RaterSheetValue = dataUmPremium.getData("CYBSubtotal").replaceAll("(\\s+|\\$|,)", "");
			if (Umvalue.equals((RaterSheetValue))) {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for CYB coverage is the same. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for CYB coverage have changed. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.FAILURE, new String[] {}, startTime);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}

		}
		if (func._isVisible(getElement(txtDNOSubtotal)) == true) {
			_wait(2000);
			String xPath = getElement(txtDNOSubtotal).getKey().toString();
			String pm = "return document.evaluate(\"" + xPath + "\", document, null, 9, null).singleNodeValue.value";
			String Umvalue = js.executeScript(pm).toString().replaceAll("(\\s+|\\$|,)", "");
			String RaterSheetValue = dataUmPremium.getData("DNOSubtotal").replaceAll("(\\s+|\\$|,)", "");
			if (Umvalue.equals((RaterSheetValue))) {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for DNO coverage is the same. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for DNO coverage have changed. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.FAILURE, new String[] {}, startTime);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}

		}
		if (func._isVisible(getElement(txtEMPSubtotal)) == true) {
			_wait(2000);
			String xPath = getElement(txtEMPSubtotal).getKey().toString();
			String pm = "return document.evaluate(\"" + xPath + "\", document, null, 9, null).singleNodeValue.value";
			String Umvalue = js.executeScript(pm).toString().replaceAll("(\\s+|\\$|,)", "");
			String RaterSheetValue = dataUmPremium.getData("EMPSubtotal").replaceAll("(\\s+|\\$|,)", "");
			if (Umvalue.equals((RaterSheetValue))) {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for EMP coverage is the same. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for EMP coverage have changed. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.FAILURE, new String[] {}, startTime);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}

		}
		if (func._isVisible(getElement(txtEPLSubtotal)) == true) {
			_wait(2000);
			String xPath = getElement(txtEPLSubtotal).getKey().toString();
			String pm = "return document.evaluate(\"" + xPath + "\", document, null, 9, null).singleNodeValue.value";
			String Umvalue = js.executeScript(pm).toString().replaceAll("(\\s+|\\$|,)", "");
			String RaterSheetValue = dataUmPremium.getData("EPLSubtotal").replaceAll("(\\s+|\\$|,)", "");
			if (Umvalue.equals((RaterSheetValue))) {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for EPL coverage is the same. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for EPL coverage have changed. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.FAILURE, new String[] {}, startTime);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}

		}
		if (func._isVisible(getElement(txtFIDSubtotal)) == true) {
			_wait(2000);
			String xPath = getElement(txtFIDSubtotal).getKey().toString();
			String pm = "return document.evaluate(\"" + xPath + "\", document, null, 9, null).singleNodeValue.value";
			String Umvalue = js.executeScript(pm).toString().replaceAll("(\\s+|\\$|,)", "");
			String RaterSheetValue = dataUmPremium.getData("FIDSubtotal").replaceAll("(\\s+|\\$|,)", "");
			if (Umvalue.equals((RaterSheetValue))) {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for FID coverage is the same. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for FID coverage have changed. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.FAILURE, new String[] {}, startTime);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}

		}
		if (func._isVisible(getElement(txtKNRSubtotal)) == true) {
			_wait(2000);
			String xPath = getElement(txtKNRSubtotal).getKey().toString();
			String pm = "return document.evaluate(\"" + xPath + "\", document, null, 9, null).singleNodeValue.value";
			String Umvalue = js.executeScript(pm).toString().replaceAll("(\\s+|\\$|,)", "");
			String RaterSheetValue = dataUmPremium.getData("KNRSubtotal").replaceAll("(\\s+|\\$|,)", "");
			if (Umvalue.equals((RaterSheetValue))) {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for KNR coverage is the same. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for KNR coverage have changed. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.FAILURE, new String[] {}, startTime);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}

		}
		if (func._isVisible(getElement(txtENOSubtotal)) == true) {
			_wait(2000);
			String xPath = getElement(txtENOSubtotal).getKey().toString();
			String pm = "return document.evaluate(\"" + xPath + "\", document, null, 9, null).singleNodeValue.value";
			String Umvalue = js.executeScript(pm).toString().replaceAll("(\\s+|\\$|,)", "");
			String RaterSheetValue = dataUmPremium.getData("ENOSubtotal").replaceAll("(\\s+|\\$|,)", "");
			if (Umvalue.equals((RaterSheetValue))) {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for ENO coverage is the same. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				CustomReporting.logReport("", "",
						"The UM Premium and Rater sheet premium for ENO coverage have changed. Expected Rater sheet value: "
								+ RaterSheetValue + " Actual UM value: " + Umvalue,
						StepStatus.FAILURE, new String[] {}, startTime);
				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}

		}
		
		_wait(2000);
		String xPath = getElement(txtPolicyTotal).getKey().toString();
		String pm = "return document.evaluate(\"" + xPath + "\", document, null, 9, null).singleNodeValue.value";
		String Umvalue = js.executeScript(pm).toString().replaceAll("(\\s+|\\$|,)", "");
		String RaterSheetValue = dataUmPremium.getData("TotalPremium").replaceAll("(\\s+|\\$|,)", "");
		if (Umvalue.equals((RaterSheetValue))) {
			CustomReporting.logReport("", "",
					"The UM Premium and Rater sheet premium for Total Premmium is the same. Expected Rater sheet value: "
							+ RaterSheetValue + " Actual UM value: " + Umvalue,
					StepStatus.SUCCESS, new String[] {}, startTime);
		} else {
			CustomReporting.logReport("", "",
					"The UM Premium and Rater sheet premium for Total Premmium have changed. Expected Rater sheet value: "
							+ RaterSheetValue + " Actual UM value: " + Umvalue,
					StepStatus.FAILURE, new String[] {}, startTime);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}

	}

}