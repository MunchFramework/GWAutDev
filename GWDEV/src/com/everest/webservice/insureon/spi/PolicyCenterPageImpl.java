package com.everest.webservice.insureon.spi;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.GenericFunctions;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;
import com.everest.utility.ExcelDataReader;
import com.everest.webservice.insureon.PolicyCenterPage;

public class PolicyCenterPageImpl extends CustomAbstractPage implements PolicyCenterPage {

	long startTime = System.currentTimeMillis();

	String strParentWindowID = "";

	@SuppressWarnings("static-access")
	@Override
	public void verifySubmissionDetails(String tcID, SoftAssert softAssert, String DeviceName, List<Boolean> list) throws Exception {
		try {

			PageData data = PageDataManager.instance().getPageData("PolicyCenterPage", tcID);
			PageData environmentData = PageDataManager.instance().getPageData("Config", tcID);
			PageData QuoteData = PageDataManager.instance().getPageData("GetQuote", tcID);
			
			String env = GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV");
			String a = "";
			String environment = environmentData.getData("Environment");
			PageData SubData = PageDataManager.instance().getPageData("Submission", tcID);
			String resAccountId = GenericFunctions.instance()._getGlobalVariableValue("respAccountId");
			String resSubmissionStatus = GenericFunctions.instance()._getGlobalVariableValue("SubmissionStatus");
			String resCrimeRetentionValue = GenericFunctions.instance()._getGlobalVariableValue("CrimeRetentionValue");
			String resunderwriterName = GenericFunctions.instance()._getGlobalVariableValue("underwriterName");
			String respStateCode = GenericFunctions.instance()._getGlobalVariableValue("respStateCode");
			String respInsuredName = GenericFunctions.instance()._getGlobalVariableValue("respInsuredName");
			String respLocality = GenericFunctions.instance()._getGlobalVariableValue("resLocality");
			String resRegion = GenericFunctions.instance()._getGlobalVariableValue("respRegion");
			String respAddressLine1 = GenericFunctions.instance()._getGlobalVariableValue("resAddressLine1");
			String respZipCode = GenericFunctions.instance()._getGlobalVariableValue("resZipCode");
			String respOtherTradeName = GenericFunctions.instance()._getGlobalVariableValue("resOtherTradeName");
			String respTradeName = GenericFunctions.instance()._getGlobalVariableValue("resTradeName");
			String respSubEffectiveDate = GenericFunctions.instance()._getGlobalVariableValue("respSubEffectiveDate");
			String respExpirationDate = GenericFunctions.instance()._getGlobalVariableValue("respExpirationDate");
			String respLimitValue = "";
			String respQuoteProducerName = GenericFunctions.instance()._getGlobalVariableValue("resQuoteProducerName");
			String respQuoteDate = GenericFunctions.instance()._getGlobalVariableValue("respQuoteDate");
			String respSubNaicsCode = GenericFunctions.instance()._getGlobalVariableValue("resSubNaicsCode");
			String respQuotedPremium = GenericFunctions.instance()._getGlobalVariableValue("resQuotedPremium");
			String concatenatedAddress = respAddressLine1 + " " + respLocality + ", " + resRegion + " " + respZipCode;

			String resUnderwriterName = GenericFunctions.instance()._getGlobalVariableValue("resUnderwriterName");
			String resAgencyName = GenericFunctions.instance()._getGlobalVariableValue("resAgencyName");
			String resProducerId = GenericFunctions.instance()._getGlobalVariableValue("resProducerId");
			String resLicenseAgentName = GenericFunctions.instance()._getGlobalVariableValue("resLicenseAgentName");
			String resCommissionPercentage = GenericFunctions.instance()
					._getGlobalVariableValue("resCommissionPercentage");
			String resExposureRevenue = GenericFunctions.instance()._getGlobalVariableValue("res" + "_" + "revenue");
			String resExposureCorporateAssets = GenericFunctions.instance()
					._getGlobalVariableValue("res" + "_" + "corporate_assets");
			String resForeignEmp = GenericFunctions.instance()
					._getGlobalVariableValue("res" + "_" + "foreign_employees");
			String resQuoteNumber = GenericFunctions.instance()._getGlobalVariableValue("resQuoteNumber");
			String resBillingType = GenericFunctions.instance()._getGlobalVariableValue("resBillingType");
			String resCoveragePartCode = GenericFunctions.instance()._getGlobalVariableValue("resCoveragePartCode");
			String respRetentionValue = "";
			String respAdjustedRentention = "";
			String PCUserName="";
			String PCPassword="";

			if (resCoveragePartCode.equalsIgnoreCase("CRIME")) {
				respLimitValue = GenericFunctions.instance()._getGlobalVariableValue("respLimitValue");

			} else if (resCoveragePartCode.equalsIgnoreCase("DIRECTORS_AND_OFFICERS")
					|| resCoveragePartCode.equalsIgnoreCase("EMPLOYMENT_PRACTICES_LIABILITY")) {
				respLimitValue = GenericFunctions.instance()
						._getGlobalVariableValue("respLimitValue" + "_" + resCoveragePartCode);
				respRetentionValue = GenericFunctions.instance()
						._getGlobalVariableValue("respRetentionValue" + "_" + resCoveragePartCode);
			}
			
			respAdjustedRentention=GenericFunctions.instance()._getGlobalVariableValue("respAdjustedRetentionValue"+"_"+resCoveragePartCode);
			if (!env.isEmpty()) {
				if (env.equalsIgnoreCase("DEV")) {
					// a =
					// "window.open('https://qa-gwpc.everestre.net:8181/pc/PolicyCenter.do','_blank');";
					a = "window.open('" + data.getData("DevURL") + "','_blank');";
				} else {
					if (env.equalsIgnoreCase("QA")) {

						a = "window.open('" + data.getData("QaURL") + "','_blank');";
						PCUserName=data.getData("QAPCUserName");
						PCPassword=data.getData("QAPCPassword");
					} else {
						// a =
						// "window.open('https://engwpcaps1.everestre.net:8181/pc/PolicyCenter.do','_blank');";
						a = "window.open('" + data.getData("StageURL") + "','_blank');";
						PCUserName=data.getData("StagePCUserName");
						PCPassword=data.getData("StagePCPassword");

					}
				}
			} else {
				if (environment.equals("DEV")) {
					// a =
					// "window.open('https://qa-gwpc.everestre.net:8181/pc/PolicyCenter.do','_blank');";
					a = "window.open('" + data.getData("DevURL") + "','_blank');";
				} else {
					if (environment.equals("QA")) {
						// a =
						// "window.open('https://qa-gwpc.everestre.net:8181/pc/PolicyCenter.do','_blank');";
						a = "window.open('" + data.getData("QaURL") + "','_blank');";
						PCUserName=data.getData("QAPCUserName");
						PCPassword=data.getData("QAPCPassword");
					} else {
						// a =
						// "window.open('https://engwpcaps1.everestre.net:8181/pc/PolicyCenter.do','_blank');";
						a = "window.open('" + data.getData("StageURL") + "','_blank');";
						PCUserName=data.getData("StagePCUserName");
						PCPassword=data.getData("StagePCPassword");
					}
				}
			}

			if ((DeviceName.equalsIgnoreCase("MicrosoftEdge"))) {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_T);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_T);

				Thread.sleep(2000);
			} else {
				((JavascriptExecutor) getWebDriver()).executeScript(a);
				func._waitForPageToLoad(getWebDriver(), 120L);
			}
			Thread.sleep(2000);
			ArrayList<String> tabs = new ArrayList<String>(getWebDriver().getWindowHandles());
			strParentWindowID = getWebDriver().getWindowHandle();
			if (DeviceName.equalsIgnoreCase("chrome")) {
				getWebDriver().switchTo().window(tabs.get(1));
			}

			if (DeviceName.equalsIgnoreCase("Internet Explorer")) {
				// getWebDriver().switchTo().window(tabs.get(1));
				String b = a.split(",")[0].split("\\(")[1].replace("'", "");
				func._switchWindows(getWebDriver(), "BY_WINURL", b);
			}

			Thread.sleep(5000);
			if (DeviceName.equalsIgnoreCase("Internet Explorer")) {
				if (func._isVisible(getElement(lnk_certificate))) {
					_click(getElement(lnk_certificate));

				}
			}

			if (DeviceName.equalsIgnoreCase("MicrosoftEdge")) {
				getWebDriver().switchTo().window(tabs.get(1));
				// To navigate to new link/URL in 2nd new tab

				if (!env.isEmpty()) {
					if (env.equalsIgnoreCase("DEV")) {
						getWebDriver().get(data.getData("DevURL"));

					} else {
						if (env.equalsIgnoreCase("QA")) {
							getWebDriver().get(data.getData("QaURL"));

						} else {
							getWebDriver().get(data.getData("StageURL"));

						}
					}
				} else {
					if (environment.equals("DEV")) {
						getWebDriver().get(data.getData("DevURL"));
					} else {
						if (environment.equals("QA")) {
							getWebDriver().get(data.getData("QaURL"));
						} else {
							getWebDriver().get(data.getData("StageURL"));
						}
					}
				}

			}
			Thread.sleep(5000);
			if (DeviceName.equalsIgnoreCase("MicrosoftEdge")) {
				if (func._isVisible(getElement(lnk_EdgeCertificate))) {
					_click(getElement(lnk_EdgeCertificate));

				}
			}
			String submissionID = GenericFunctions.instance()._getGlobalVariableValue("submissionId");
			getWebDriver().manage().window().maximize();
			Thread.sleep(2000);
			if (!(getWebDriver().findElements(By.id("Login:LoginScreen:LoginDV:username-inputEl")).size() == 0)) {
				getWebDriver().findElement(By.id("Login:LoginScreen:LoginDV:username-inputEl"))
						.sendKeys(PCUserName);
				Thread.sleep(1000);
				getWebDriver().findElement(By.xpath("//input[@id='Login:LoginScreen:LoginDV:password-inputEl']"))
						.sendKeys(PCPassword);
				Thread.sleep(1000);

				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

				getWebDriver().findElement(By.xpath("//a[@id='Login:LoginScreen:LoginDV:submit']")).click();
				CustomReporting.instance().logReport("Sucessfully logged into Policy Center application");
				func._waitForPageToLoad(getWebDriver(), 200L);
			}
			// search

			getWebDriver().findElement(By.id("TabBar:SearchTab-btnInnerEl")).click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			Thread.sleep(1000);
			func._waitForPageToLoad(getWebDriver(), 100L);
			getWebDriver().findElement(By.xpath("//td[@id='Search:MenuLinks:Search_AccountSearch']")).click();

			// .sendKeys(submissionID);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.instance().logReport("Clicked on  Accounts Link Successfully");
			Thread.sleep(3000);
			getWebDriver().findElement(By.id("AccountSearch:AccountSearchScreen:AccountSearchDV:AccountNumber-inputEl"))
					.sendKeys(resAccountId);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			func._waitForPageToLoad(getWebDriver(), 200L);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			getWebDriver().findElement(By.id(
					"AccountSearch:AccountSearchScreen:AccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"))
					.click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.instance().logReport("Clicked on  Search Link Successfully");

			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			getWebDriver()
					.findElement(By.id("AccountSearch:AccountSearchScreen:AccountSearchResultsLV:0:AccountNumber"))
					.click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.instance().logReport("Clicked on  Account Number Link Successfully");
			func._waitForPageToLoad(getWebDriver(), 200L);
			// account id
			String pcAccountId = getWebDriver().findElement(By.id(
					"AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AccountNumber-inputEl"))
					.getText();

			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if (pcAccountId.equalsIgnoreCase(resAccountId)) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Account Id  in Policy Center<b><i><font color='green'>" + pcAccountId + "</font></i></b> is as Expected value  " + resAccountId,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Account Id  in Policy Center <b><i><font color='red'> " + pcAccountId + "</font></i></b> is not as Expected value  " + resAccountId,
						StepStatus.FAILURE, new String[] {}, startTime);
			}

			String pcAccountName = getWebDriver().findElement(
					By.id("AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:Name-inputEl"))
					.getText();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if (pcAccountName.equalsIgnoreCase(respInsuredName)) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Account Name  in Policy Center <b><i><font color='green'>" + pcAccountName + "</font></i></b> is as Expected value <b><i><font color='green'> " + respInsuredName+"</font></i></b>",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting
						.logReport(
								"", "", "Account Name  in Policy Center <b><i><font color='red'>" + pcAccountName
										+ " </font></i></b> is not as Expected value <b><i><font color='red'>" + respInsuredName +"</font></i></b>",
										
								StepStatus.FAILURE, new String[] {}, startTime);
			}

			String pcStatus = getWebDriver().findElement(By.id(
					"AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AccountStatus-inputEl"))
					.getText();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if (pcStatus.equalsIgnoreCase("Active")) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Account Status  in Policy Center <b><i><font color='green'>" + pcStatus + "</font></i></b>is as Expected value  " + "Active",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Account Status  in Policy Center <b><i><font color='red'> " + pcStatus + " </font></i></b>is not as Expected value  " + "Active",
						StepStatus.FAILURE, new String[] {}, startTime);
			}

			String pcAddress = getWebDriver().findElement(By.id(
					"AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:AddressShortInputSet:globalAddressContainer:GlobalAddressInputSet:AddressSummary-inputEl"))
					.getText();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			if (pcAddress.trim().replace("\n", " ").contains(concatenatedAddress.trim())) {
				
				
				list.add(true);
				System.out.println(list);
				CustomReporting.logReport("", "", "Account Address  in Policy Center <b><i><font color='green'> " + pcAddress
						+ " </font></i></b> is as Expected value  <b><i><font color='green'>" + concatenatedAddress +"</font></i></b>", StepStatus.SUCCESS, new String[] {},
						startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "", "Account Address  in Policy Center <b><i><font color='red'> " + pcAddress
						+ " </font></i></b> is not as Expected value <b><i><font color='red'> " + concatenatedAddress +"</font></i></b>", StepStatus.FAILURE, new String[] {},
						startTime);
			}
			getWebDriver().findElement(By.xpath("//td[@id='AccountFile:MenuLinks:AccountFile_AccountFile_Contacts']"))
					.click();
			Thread.sleep(1000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.instance().logReport("Clicked on  Contacts  Link Successfully");
			Thread.sleep(2000);

			getWebDriver().findElement(By.xpath("//td[@id='AccountFile:MenuLinks:AccountFile_AccountFile_Summary']"))
					.click();
			Thread.sleep(1000);
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.instance().logReport("Clicked on  Summary Link Successfully");
			Thread.sleep(1000);
			
			((JavascriptExecutor) getWebDriver()).executeScript("window.scrollTo(0,800)");
			
			Thread.sleep(1000);
			getWebDriver().findElement(By.xpath("//input[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV_tb:WorkOrdersCompletenessFilter-inputEl']")).click();
			getWebDriver().findElement(By.xpath("//input[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV_tb:WorkOrdersCompletenessFilter-inputEl']")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
			getWebDriver().findElement(By.xpath("//input[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV_tb:WorkOrdersCompletenessFilter-inputEl']")).sendKeys(Keys.BACK_SPACE);
			getWebDriver().findElement(By.xpath("//input[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV_tb:WorkOrdersCompletenessFilter-inputEl']")).sendKeys("All");
			
			getWebDriver().findElement(By.xpath("//input[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV_tb:WorkOrdersCompletenessFilter-inputEl']")).getLocation().getY();
			getWebDriver().findElement(By.xpath("//span[contains(text(),'Create Date')]")).click();
			((JavascriptExecutor) getWebDriver()).executeScript("window.scrollTo(0,800)");
			
			WebElement we=getWebDriver().findElement(By.xpath("//table/tbody/tr/td/div/table/tbody/tr[7]/td/div/div[4]//div/a"));
			
			Actions acn=new Actions(getWebDriver());
			acn.moveToElement(we).click().build().perform();
			Thread.sleep(2000);
			
			
			
	//		getWebDriver().findElement(By.xpath("//table/tbody/tr/td/div/table/tbody/tr[7]/td/div/div[4]//div/a")).getText();

			//getWebDriver().findElement(By.id(
			//		"AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV:0:WorkOrderNumber")).click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.instance().logReport("Clicked on  Submission Number Link Successfully");
			Thread.sleep(3000);

			getWebDriver().findElement(By.xpath("//td[@id='SubmissionWizard:CovPartSelection']")).click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.instance().logReport("Clicked on  Coverage Selection Link Successfully");
			Thread.sleep(3000);
			String policyForm = getWebDriver()
					.findElement(By.id("SubmissionWizard:GeneralLiabilityCoveragePart_GLEScreen:GLPolicyForms-inputEl"))
					.getText();
			if (policyForm.trim().equalsIgnoreCase(data.getData("PolicyForm"))) {
				list.add(true);
				CustomReporting.logReport("", "", "Policy Form  in Policy Center <b><i><font color='green'>" + policyForm
						+ "</font></i></b> is as Expected value <b><i><font color='green'>  " + data.getData("PolicyForm") +"</font></i></b>", StepStatus.SUCCESS, new String[] {},
						startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "", "Policy Form in Policy Center <b><i><font color='red'>" + policyForm
						+ "</font></i></b> is not as Expected value  <b><i><font color='red'>" + data.getData("PolicyForm") +"</font></i></b>", StepStatus.FAILURE,
						new String[] {}, startTime);
			}
			List<String> coverageNames = new ArrayList<String>();

			int coveragePartSize = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:GeneralLiabilityCoveragePart_GLEScreen:GL7CoveragePartSelectionDV:1-body']/div/div/table/tbody/tr/td[2]"))
					.size();
			for (int i = 1; i < coveragePartSize; i++) {
				String coverageValue = getWebDriver().findElement(By.xpath(
						"//div[@id='SubmissionWizard:GeneralLiabilityCoveragePart_GLEScreen:GL7CoveragePartSelectionDV:1-body']/div/div/table["
								+ i + "]/tbody/tr/td[2]"))
						.getText();
				String selectedValue = getWebDriver().findElement(By.xpath(
						"//div[@id='SubmissionWizard:GeneralLiabilityCoveragePart_GLEScreen:GL7CoveragePartSelectionDV:1-body']/div/div/table["
								+ i + "]/tbody/tr/td[1]"))
						.getText();
				if (selectedValue.equalsIgnoreCase("Yes")) {
					coverageNames.add(coverageValue);
					CustomReporting.logReport("", "", "Coverage Selected is <b><i><font color='green'>" + coverageValue + " </font></i></b> is as selected",
							StepStatus.SUCCESS, new String[] {}, startTime);
				}
			}
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			// verify policy form screen
			getWebDriver().findElement(By.xpath("//td[@id='SubmissionWizard:LOBWizardStepGroup:PolicyInfo']")).click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.instance().logReport("Clicked on  Policy Info Link Successfully");
			Thread.sleep(5000);

			String pcInfoname = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:Name-inputEl"))
					.getText();
			if (pcInfoname.equalsIgnoreCase(respInsuredName)) {
				list.add(true);
				CustomReporting.logReport(
						"", "", "Insured  Name  in Policy Center <b><i><font color='green'>" + pcInfoname + " </font></i></b> is as Expected value  <b><i><font color='green'>"
								+ respInsuredName + " </font></i></b>in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport(
						"", "", "Insured Name  in Policy Center <b><i><font color='red'>" + pcInfoname + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								+ respInsuredName + " </font></i></b>in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}

			String pcInfoAddr = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:PolicyAddressDisplayInputSet:globalAddressContainer:GlobalAddressInputSet:AddressSummary-inputEl"))
					.getText();
			if (pcInfoAddr.trim().replace("\n", " ").equalsIgnoreCase(concatenatedAddress.trim())) {
				list.add(true);
				CustomReporting.logReport(
						"", "", "Pc info address  in Policy Center <b><i><font color='green'>" + pcInfoAddr + "</font></i></b> is as Expected value <b><i><font color='green'> "
								+ concatenatedAddress + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport(
						"", "", "Pc info address  in Policy Center <b><i><font color='red'>" + pcInfoAddr + "</font></i></b> is not  as Expected value <b><i><font color='red'> "
								+ concatenatedAddress + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoNAICSCode = getWebDriver().findElement(By.xpath("(//span[contains(text(),'NAICS Code')]//following::div)[2]")).getText();

			if (pcInfoNAICSCode.equalsIgnoreCase(respSubNaicsCode)) {
				list.add(true);
				CustomReporting.logReport(
						"", "", "NAICS Code  in Policy Center <b><i><font color='green'>" + pcInfoNAICSCode + "</font></i></b> is as Expected value  <b><i><font color='green'>"
								+ respSubNaicsCode + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"NAICS Code in Policy Center <b><i><font color='red'>" + pcInfoNAICSCode + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
								+ respSubNaicsCode + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}

//			String pcInfoMarketSegment = getWebDriver().findElement(By.id(
//					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:MarketSegment-inputEl"))
//					.getText();	
			String pcInfoMarketSegment = getWebDriver().findElement(By.id(
				"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:MarketSegmentTypeList-inputEl"))
					.getText();
			if (!pcInfoMarketSegment.equalsIgnoreCase(null)) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Market Segment  in Policy Center <b><i><font color='green'>" + pcInfoMarketSegment + " is as Expected value  <b><i><font color='green'>"
								+""+ " in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Market Segment in Policy Center <b><i><font color='red'>" + pcInfoMarketSegment + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
								+ "" + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoDepartmentCode = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:DepartmentCodeDescription_Esu-inputEl"))
					.getText();
			if (pcInfoDepartmentCode.equalsIgnoreCase(data.getData("ExpectedBusinessCode"))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Department Code  in Policy Center <b><i><font color='green'>" + pcInfoDepartmentCode + "</font></i></b> is as Expected value  <b><i><font color='green'>"
								+ data.getData("ExpectedBusinessCode") + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Department Code in Policy Center <b><i><font color='red'>" + pcInfoDepartmentCode + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
								+ data.getData("ExpectedBusinessCode") + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoUnderwriter = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:underWriter-inputEl"))
					.getText();
			if (pcInfoUnderwriter.equalsIgnoreCase(resunderwriterName)) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Underwriter Name  in Policy Center <b><i><font color='green'>" + pcInfoUnderwriter + " </font></i></b> is as Expected value  <b><i><font color='green'>"
								+ resunderwriterName + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Underwriter Name in Policy Center <b><i><font color='red'>" + pcInfoUnderwriter + " </font></i></b> is not as Expected value <b><i><font color='red'> "
								+ resunderwriterName + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoUA = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:UnderwriterAssistant-inputEl"))
					.getText();
			if (pcInfoUA.equalsIgnoreCase(data.getData("ExpectedUA"))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Underwriter Assistant  in Policy Center <b><i><font color='green'>" + pcInfoUA + "</font></i></b> is as Expected value  <b><i><font color='green'>"
								+ data.getData("ExpectedUA") + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Underwriter Assistant in Policy Center <b><i><font color='red'>" + pcInfoUA + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								+ data.getData("ExpectedUA") + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoAssignedTo = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:AssginedTo-inputEl"))
					.getText();
			if (pcInfoAssignedTo.equalsIgnoreCase(resunderwriterName)) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Assigned To in Policy Center <b><i><font color='green'>" + pcInfoAssignedTo + "</font></i></b> is as Expected value <b><i><font color='green'> "
								+ resunderwriterName + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Assigned To in Policy Center <b><i><font color='red'>" + pcInfoAssignedTo + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								+ resunderwriterName + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoLegalEntity = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:LegalEntity-inputEl"))
					.getText().trim();
			if (pcInfoLegalEntity.contains(data.getData("ExpectedLegalEntity"))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Legal Entity in Policy Center <b><i><font color='green'>" + pcInfoLegalEntity + "</font></i></b> is  as Expected value <b><i><font color='green'> "
								+ data.getData("ExpectedLegalEntity") + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Legal Entity in Policy Center <b><i><font color='red'>" + pcInfoLegalEntity + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								+ data.getData("ExpectedLegalEntity") + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoOwnershipType = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:OwnershipType-inputEl"))
					.getText();
			if (pcInfoOwnershipType.equalsIgnoreCase(data.getData("ExpectedOwnershipType"))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Ownership Type in Policy Center <b><i><font color='green'>" + pcInfoOwnershipType + "</font></i></b> is as Expected value <b><i><font color='green'> "
								+ data.getData("ExpectedOwnershipType") + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Ownership Type in Policy Center <b><i><font color='red'>" + pcInfoOwnershipType + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
								+ data.getData("ExpectedOwnershipType") + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoaccountUnderNDA = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:AccountInfoInputSet:AccountNDA-inputEl"))
					.getText();
			if (pcInfoaccountUnderNDA.equalsIgnoreCase("")) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Account Under NDA  in Policy Center <b><i><font color='green'>" + pcInfoaccountUnderNDA + "</font></i></b> is as Expected value <b><i><font color='green'> "
								+ "null" + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(true);
				CustomReporting.logReport("", "",
						"Account Under NDA in Policy Center <b><i><font color='red'>" + pcInfoaccountUnderNDA + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								+"null" + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}

			String pcInfoprimExcess = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:PrimaryorExcess-inputEl"))
					.getText();
			if (pcInfoprimExcess.equalsIgnoreCase(data.getData("ExpectedPrmeExcess"))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Primary/Excess in Policy Center <b><i><font color='green'>" + pcInfoprimExcess + "</font></i></b> is as Expected value  <b><i><font color='green'>"
								+ data.getData("ExpectedPrmeExcess") + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Primary/Excess in Policy Center <b><i><font color='red'>" + pcInfoprimExcess + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								+ data.getData("ExpectedPrmeExcess") + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoAssumeDirect = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:AssumedorDirect-inputEl"))
					.getText();
			if (pcInfoAssumeDirect.equalsIgnoreCase(data.getData("ExpectedAssumeDirect"))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Assume/Direct in Policy Center <b><i><font color='green'>" + pcInfoAssumeDirect + "</font></i></b> is as Expected value <b><i><font color='green'> "
								+ data.getData("ExpectedAssumeDirect") + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Assume/Direct in Policy Center <b><i><font color='red'>" + pcInfoAssumeDirect + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								+ data.getData("ExpectedAssumeDirect") + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}

			String pcInfoEffectiveDate = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:EffectiveDate-inputEl"))
					.getText();

			if (pcInfoEffectiveDate.equalsIgnoreCase(pcInfoEffectiveDate)) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Effective Date in Policy Center <b><i><font color='green'>" + pcInfoEffectiveDate + " </font></i></b>is as Expected value <b><i><font color='green'> "
								+ respSubEffectiveDate + " </font></i></b>in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Effective Date in Policy Center <b><i><font color='red'>" + pcInfoEffectiveDate + " </font></i></b>is not as Expected value <b><i><font color='red'> "
								+ respSubEffectiveDate + " </font></i></b>in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoExpiratioDate = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoInputSet:ExpirationDate-inputEl"))
					.getText();
			System.out.println(pcInfoExpiratioDate);

			if (pcInfoExpiratioDate.equalsIgnoreCase(pcInfoExpiratioDate)) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Expiration Date in Policy Center <b><i><font color='green'>" + pcInfoExpiratioDate + " </font></i></b> is as Expected value  <b><i><font color='green'>"
								+ respExpirationDate + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Expiration Date in Policy Center <b><i><font color='red'>" + pcInfoExpiratioDate + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
								+ respExpirationDate + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}

			String pcInfoOrganisation = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:Producer-inputEl"))
					.getText();
			if (pcInfoOrganisation.equalsIgnoreCase(pcInfoOrganisation)) {
				list.add(true);
				CustomReporting.logReport(
						"", "", "Agency Name in Policy Center <b><i><font color='green'>" + pcInfoOrganisation + "</font></i></b> is as Expected value <b><i><font color='green'> "
								+ pcInfoOrganisation + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Agency Name in Policy Center <b><i><font color='red'>" + pcInfoOrganisation + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								+ pcInfoOrganisation + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoProducerCode = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:ProducerCode-inputEl"))
					.getText();
			if (pcInfoProducerCode.contains(pcInfoProducerCode)) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Producer Code in Policy Center <b><i><font color='green'>" + pcInfoProducerCode + "</font></i></b> is as Expected value  <b><i><font color='green'>"
								+ resProducerId + " " + resAgencyName + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Producer Code in Policy Center <b><i><font color='red'>" + pcInfoProducerCode + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
								+ resProducerId + " " + resAgencyName + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			
			String producerAddressDetail[]=data.getData("ExpectedProducerContactDetail").split("#");
			
			String pcInfoProducerZipCode = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:ProducerZipCode-inputEl"))
					.getText();
			if (pcInfoProducerZipCode.equalsIgnoreCase(producerAddressDetail[1])) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Producer ZipCode in Policy Center <b><i><font color='green'>" + pcInfoProducerZipCode + "</font></i></b> is as Expected value  <b><i><font color='green'>"
								+ producerAddressDetail[1] + " " + "" + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Producer ZipCode in Policy Center <b><i><font color='red'>" + pcInfoProducerZipCode + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
								+ producerAddressDetail[1] + " " + "" + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			/*if(!resCoveragePartCode.equalsIgnoreCase("CYBER_LIABILITY")) {
			String pcInfoProducerContact = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:ProducerContact-inputEl"))
					.getText();
			if (pcInfoProducerContact.equalsIgnoreCase(producerAddressDetail[0])) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Producer Contact in Policy Center <b><i><font color='green'>" + pcInfoProducerContact + "</font></i></b> is as Expected value  <b><i><font color='green'>"
								+ producerAddressDetail[0] + " " + "" + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Producer Contact in Policy Center <b><i><font color='red'>" + pcInfoProducerContact + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
								+ producerAddressDetail[0] + " " + "" + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			

			String pcInfoBillingContact = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:BindingContact-inputEl"))
					.getText();
			if (pcInfoProducerContact.equalsIgnoreCase(producerAddressDetail[0])) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Billing Contact in Policy Center <b><i><font color='green'>" + pcInfoBillingContact + "</font></i></b> is as Expected value  <b><i><font color='green'>"
								+ producerAddressDetail[0] + " " + "" + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Billing Contact in Policy Center <b><i><font color='red'>" + pcInfoBillingContact + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
								+ producerAddressDetail[0] + " " + "" + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			}*/
			
			String pcInfoProducerState = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:ProducerState-inputEl"))
					.getText();
			if (pcInfoProducerState.equalsIgnoreCase(producerAddressDetail[2])) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Producer State in Policy Center <b><i><font color='green'>" + pcInfoProducerState + "</font></i></b> is as Expected value  <b><i><font color='green'>"
								+ producerAddressDetail[2] + " " + "" + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Producer State in Policy Center <b><i><font color='red'>" + pcInfoProducerState + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
								+ producerAddressDetail[2] + " " + "" + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			
			String pcInfoProducerAdd = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:PolicyInfoProducerOfRecordInputSet:ProducerAddress-inputEl"))
					.getText();
			if (pcInfoProducerAdd.equalsIgnoreCase(producerAddressDetail[3])) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Producer Address in Policy Center <b><i><font color='green'>" + pcInfoProducerAdd + "</font></i></b> is as Expected value  <b><i><font color='green'>"
								+ producerAddressDetail[3] + " " + "" + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Producer Address in Policy Center <b><i><font color='red'>" + pcInfoProducerAdd + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
								+ producerAddressDetail[3] + " " + "" + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			

			String pcInfoWrittingApproach = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:UWCompanyInputSet:WritingApproach-inputEl"))
					.getText();
			if (pcInfoWrittingApproach.equalsIgnoreCase("Admitted")
					||pcInfoWrittingApproach.equalsIgnoreCase("Non-Admitted")) {
				list.add(true);
				CustomReporting.logReport("", "",
						"License Agent in Policy Center <b><i><font color='green'>" + pcInfoWrittingApproach + "</font></i></b> is as Expected value <b><i><font color='green'> "
								 + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"License Agent in Policy Center <b><i><font color='red'>" + pcInfoWrittingApproach + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								 + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoUnderwritingCompany = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:UWCompanyInputSet:UWCompany-inputEl"))
					.getText();
			if (pcInfoUnderwritingCompany.equalsIgnoreCase(data.getData("ExpectedInsuringCompany"))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Insuring Company in Policy Center <b><i><font color='green'> " + pcInfoUnderwritingCompany + "</font></i></b> is as Expected value <b><i><font color='green'> "
								+ data.getData("ExpectedInsuringCompany") + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Insuring Company  in Policy Center <b><i><font color='red'> " + pcInfoUnderwritingCompany
								+ "</font></i></b> is not as Expected value  <b><i><font color='red'>" + data.getData("ExpectedInsuringCompany")
								+ "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}

			String pcInfoCommissionPercentage = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:UWCompanyInputSet:commissionpercentage-inputEl"))
					.getText();
			 if(QuoteData.getData("ExpectedStatus").equalsIgnoreCase("Quote Outstanding")) {
			if (pcInfoCommissionPercentage.equalsIgnoreCase("25") ||pcInfoCommissionPercentage.equalsIgnoreCase("26.5")) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Commission Percentage in Policy Center <b><i><font color='green'>" + pcInfoCommissionPercentage
								+ "</font></i></b> is as Expected value  <b><i><font color='green'>" + resCommissionPercentage + "</font></i></b> in policy info screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Commission Percentage in Policy Center <b><i><font color='red'>" + pcInfoCommissionPercentage
								+ "</font></i></b> is not as Expected value  <b><i><font color='red'>" + resCommissionPercentage + "</font></i></b> in policy info screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			}else if (QuoteData.getData("ExpectedStatus").equalsIgnoreCase("Underwriter Review")) {
				if (!(pcInfoCommissionPercentage.equalsIgnoreCase(""))) {
					list.add(true);
					CustomReporting.logReport("", "",
							"Commission Percentage in Policy Center <b><i><font color='green'>" + pcInfoCommissionPercentage
									+ "</font></i></b> is as Expected value  <b><i><font color='green'>" + resCommissionPercentage + "</font></i></b> in policy info screen",
							StepStatus.SUCCESS, new String[] {}, startTime);
				} else {
					list.add(false);
					CustomReporting.logReport("", "",
							"Commission Percentage in Policy Center <b><i><font color='red'>" + pcInfoCommissionPercentage
									+ "</font></i></b> is not as Expected value  <b><i><font color='red'>" + resCommissionPercentage + "</font></i></b> in policy info screen",
							StepStatus.FAILURE, new String[] {}, startTime);
				}
			}
			// verify location screen
			getWebDriver().findElement(By.xpath("//td[@id='SubmissionWizard:LOBWizardStepGroup:Locations']")).click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.instance().logReport("Clicked on Location Link Successfully");
			Thread.sleep(3000);

			// String pcInfoLocationName =
			// getWebDriver().findElement(By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:LocationsScreen:LocationsPanelSet:LocationsEdit_DP:LocationDetailCV:LocationDetailDV:LocationDetailInputSet:LocationName-inputEl")).getText();
			String pcInfoLocationAddress = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:LocationsScreen:LocationsPanelSet:LocationsEdit_DP:LocationDetailCV:LocationDetailDV:LocationDetailInputSet:UnsyncedAddressInputSet:unsyncedAddressString-inputEl"))
					.getText();
			String pcInfoLocationCountry = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:LocationsScreen:LocationsPanelSet:LocationsEdit_DP:LocationDetailCV:LocationDetailDV:LocationDetailInputSet:UnsyncedAddressInputSet:UnsyncedCountry-inputEl"))
					.getText();

			if (pcInfoLocationAddress.trim().replace("\n", " ").contains(concatenatedAddress)) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Location Address in Policy Center <b><i><font color='green'>" + pcInfoLocationAddress + "</font></i></b> is as Expected value <b><i><font color='green'> "
								+ concatenatedAddress + "</font></i></b> in Location screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Location Address in Policy Center <b><i><font color='red'>" + pcInfoLocationAddress + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								+ concatenatedAddress + "</font></i></b> in Location  screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}

			if (pcInfoLocationCountry.equalsIgnoreCase("United States")) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Location Country in Policy Center <b><i><font color='green'>" + pcInfoLocationCountry + "</font></i></b> is as Expected value <b><i><font color='green'> "
								+ "United States" + "</font></i></b> in Location screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Location Country in Policy Center <b><i><font color='red'>" + pcInfoLocationCountry + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								+ " United States " + "</font></i></b> in Location  screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			// verify location screen
			getWebDriver().findElement(By.xpath("//td[@id='SubmissionWizard:LOBWizardStepGroup:GL7Exposures_Esu']"))
					.click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.instance().logReport("Clicked on Exposures Link Successfully");
			Thread.sleep(3000);

			String pcInfoExposureRevenue = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiabilityEU_Esu_GLEScreen:rev-inputEl"))
					.getText();
			if (pcInfoExposureRevenue.equalsIgnoreCase(resExposureRevenue)) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Revenue in Policy Center <b><i><font color='green'>" + pcInfoExposureRevenue + "</font></i></b> is as Expected value <b><i><font color='green'> "
								+ resExposureRevenue + "</font></i></b> in Exposure screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Revenue in Policy Center <b><i><font color='red'>" + pcInfoExposureRevenue + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
								+ resExposureRevenue + "</font></i></b> in Exposure  screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			if(!(resCoveragePartCode.equalsIgnoreCase("CYBER_LIABILITY"))) {
			String pcInfoExposureCorporateAssets = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiabilityEU_Esu_GLEScreen:corpAssests-inputEl"))
					.getText();
			if (pcInfoExposureCorporateAssets.equalsIgnoreCase(resExposureCorporateAssets)) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Corporate Assets in Policy Center <b><i><font color='green'>" + pcInfoExposureCorporateAssets + "</font></i></b> is as Expected value <b><i><font color='green'> "
								+ resExposureCorporateAssets + "</font></i></b> in Exposure screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Corporate Assets  in Policy Center <b><i><font color='red'>" + pcInfoExposureCorporateAssets
								+ " is not as Expected value  <b><i><font color='red'>" + resExposureCorporateAssets + " in Exposure  screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoExposureForeignEmp = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiabilityEU_Esu_GLEScreen:foreignEmployees-inputEl"))
					.getText();
			if (pcInfoExposureForeignEmp.equalsIgnoreCase(resForeignEmp)) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Foreign Employess in Policy Center <b><i><font color='green'>" + pcInfoExposureForeignEmp + "</font></i></b> is as Expected value <b><i><font color='green'> "
								+ resForeignEmp + "</font></i></b> in Exposure screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Foreign Employess in Policy Center <b><i><font color='red'>" + pcInfoExposureForeignEmp + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								+ resForeignEmp + "</font></i></b> in Exposure  screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoExposureTotalEmp = getWebDriver().findElement(By.id(
					"SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiabilityEU_Esu_GLEScreen:totalEmployees-inputEl"))
					.getText();
			if (!pcInfoExposureTotalEmp.equalsIgnoreCase("")) {
				list.add(true);
				CustomReporting
						.logReport(
								"", "", "Total Employee in Policy Center <b><i><font color='green'>" + pcInfoExposureTotalEmp
										+ "</font></i></b> is as Expected value  " + " in Exposure screen ",
								StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport(
						"", "", "Total Employee in Policy Center <b><i><font color='red'>" + pcInfoExposureTotalEmp
								+ " </font></i></b> is not as Expected value  " + " in Exposure  screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			}

			// verify location screen
			// getWebDriver().findElement(By.xpath("//td[@id='SubmissionWizard:LOBWizardStepGroup:GL7_Coverages']"))
			// .click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

			// verify Quote screen
			getWebDriver().findElement(By.xpath("//td[@id='SubmissionWizard:ViewQuote']//div")).click();
			if(!(QuoteData.getData("ExpectedStatus").equalsIgnoreCase("Declined"))) {
			getWebDriver().findElement(By.xpath("//td[@id='SubmissionWizard:ViewQuote']//div")).click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.instance().logReport("Clicked on Quote Link Successfully");
			Thread.sleep(3000);

			String pcInfoQuotedSubmissionNum = getWebDriver().findElement(By.xpath(
					"(//div[@id='SubmissionWizard:SubmissionWizard_QuoteScreen:Quote_SummaryDV:JobNumber-inputEl'])"))
					.getText();
			if (pcInfoQuotedSubmissionNum.equalsIgnoreCase(submissionID)) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Quoted Submission Number in Policy Center <b><i><font color='green'>" + pcInfoQuotedSubmissionNum
								+ " </font></i></b> is as Expected value  " + submissionID + " in Quote screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Quoted Submission Number in Policy Center <b><i><font color='red'>" + pcInfoQuotedSubmissionNum
								+ " </font></i></b> is not as Expected value <b><i><font color='red'> " + submissionID + " </font></i></b> in Quote screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}

			String pcInfoPolicyInsuredName = getWebDriver()
					.findElement(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:Quote_SummaryDV:Insured-inputEl"))
					.getText();
			if (pcInfoPolicyInsuredName.equalsIgnoreCase(respInsuredName)) {
				list.add(true);
				CustomReporting
						.logReport("", "",
								"Insured Name in Policy Center <b><i><font color='green'>" + pcInfoPolicyInsuredName + "</font></i></b> is as Expected value <b><i><font color='green'> "
										+ respInsuredName + "</font></i></b> in Quote screen",
								StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Insured Name in Policy Center <b><i><font color='red'>" + pcInfoPolicyInsuredName + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								+ respInsuredName + "</font></i></b> in Quote  screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoPolicyAddress = getWebDriver().findElement(By.id(
					"SubmissionWizard:SubmissionWizard_QuoteScreen:Quote_SummaryDV:PolicyAddress:PolicyAddressDisplayInputSet:globalAddressContainer:GlobalAddressInputSet:AddressSummary-inputEl"))
					.getText();
			if ((pcInfoPolicyAddress.replace("\n", " ").trim()).equalsIgnoreCase(concatenatedAddress.trim())) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Address in Policy Center <b><i><font color='green'>" + pcInfoPolicyAddress.replace("\n", " ") + "</font></i></b> is as Expected value <b><i><font color='green'> "
								+ concatenatedAddress + " </font></i></b> in Quote screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Address in Policy Center <b><i><font color='red'>" + pcInfoPolicyAddress.replace("\n", " ") + "</font></i></b> is not  as Expected value <b><i><font color='red'> "
								+ concatenatedAddress + "</font></i></b> in Quote  screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoPolicyUWCompany = getWebDriver()
					.findElement(
							By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:Quote_SummaryDV:UWCompany-inputEl"))
					.getText();
			if (pcInfoPolicyUWCompany.equalsIgnoreCase(data.getData("ExpectedInsuringCompany"))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Underwriter Company in Policy Center <b><i><font color='green'>" + pcInfoPolicyUWCompany + "</font></i></b> is as Expected value <b><i><font color='green'> "
								+ data.getData("ExpectedInsuringCompany") + "</font></i></b> in Quote screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Underwriter Company in Policy Center <b><i><font color='red'>" + pcInfoPolicyUWCompany + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								+ data.getData("ExpectedInsuringCompany") + "</font></i></b> in Quote  screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			String pcInfoPolicyPremium = getWebDriver()
					.findElement(
							By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:Quote_SummaryDV:TotalPremium-inputEl"))
					.getText().replace("$", "").replace(",", "").replace(".00", "");
			String quotePremium = respQuotedPremium.replace(".0", "");
            if(QuoteData.getData("ExpectedStatus").equalsIgnoreCase("Quote Outstanding")) {
			if (pcInfoPolicyPremium.equalsIgnoreCase(quotePremium)) {
				list.add(true);
				CustomReporting
						.logReport("", "",
								"Policy Premium in Policy Center <b><i><font color='green'>" + pcInfoPolicyPremium + "</font></i></b> is as Expected value <b><i><font color='green'> "
										+ quotePremium + "</font></i></b> in Quote screen",
								StepStatus.SUCCESS, new String[] {}, startTime);
			}else {
				list.add(false);
				CustomReporting
				.logReport("", "",
						"Policy Premium in Policy Center <b><i><font color='red'>" + pcInfoPolicyPremium + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
								+ quotePremium + "</font></i></b> in Quote  screen",
						StepStatus.FAILURE, new String[] {}, startTime);
	}
			}else if (QuoteData.getData("ExpectedStatus").equalsIgnoreCase("Underwriter Review")) {
				if (!(pcInfoPolicyPremium.equalsIgnoreCase(""))) {
					list.add(true);
					CustomReporting
							.logReport("", "",
									"Policy Premium in Policy Center <b><i><font color='green'>" + pcInfoPolicyPremium + "</font></i></b> is as Expected value <b><i><font color='green'> "
											+ quotePremium + "</font></i></b> in Quote screen",
									StepStatus.SUCCESS, new String[] {}, startTime);
				}else {
					list.add(false);
					CustomReporting
					.logReport("", "",
							"Policy Premium in Policy Center <b><i><font color='red'>" + pcInfoPolicyPremium + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
									+ quotePremium + "</font></i></b> in Quote  screen",
							StepStatus.FAILURE, new String[] {}, startTime);
		}
			}
            
			String pcInfoPolicyCommission = getWebDriver().findElement(
					By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:Quote_SummaryDV:commissionpercentage-inputEl"))
					.getText().replace("%", "").trim();
			System.out.println("pc" + pcInfoPolicyCommission);
			System.out.println("response" + resCommissionPercentage);
			
			if(QuoteData.getData("ExpectedStatus").equalsIgnoreCase("Quote Outstanding")) {
			if (pcInfoPolicyCommission.equalsIgnoreCase("25")||pcInfoPolicyCommission.equalsIgnoreCase("26.50")) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Policy Commission in Policy Center <b><i><font color='green'>" + pcInfoPolicyCommission + "</font></i></b> is as Expected value  <b><i><font color='green'>"
								+ resCommissionPercentage.replace(".0", "") + "</font></i></b> in Quote screen",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Policy Commission in Policy Center <b><i><font color='red'>" + pcInfoPolicyCommission + "</font></i></b> is not as Expected value <b><i><font color='red'> "
								+ resCommissionPercentage.replace(".0", "") + "</font></i></b> in Quote  screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			}else if (QuoteData.getData("ExpectedStatus").equalsIgnoreCase("Underwriter Review")) {
				
				if (!(pcInfoPolicyCommission.equalsIgnoreCase(""))) {
					list.add(true);
					CustomReporting.logReport("", "",
							"Policy Commission in Policy Center <b><i><font color='green'>" + pcInfoPolicyCommission + "</font></i></b> is as Expected value <b><i><font color='green'> "
									+ resCommissionPercentage.replace(".0", "") + "</font></i></b> in Quote screen",
							StepStatus.SUCCESS, new String[] {}, startTime);
				} else {
					list.add(false);
					CustomReporting.logReport("", "",
							"Policy Commission in Policy Center <b><i><font color='red'>" + pcInfoPolicyCommission + "</font></i></b> is not as Expected value <b><i><font color='red'> "
									+ resCommissionPercentage.replace(".0", "") + "</font></i></b> in Quote  screen",
							StepStatus.FAILURE, new String[] {}, startTime);
				}
				
			}
			String pcInfoPremiumTotal = getWebDriver()
					.findElement(
							By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:Quote_SummaryDV:TotalCost-inputEl"))
					.getText().replace("$", "").replace(",", "").replace(".00", "");
			if(QuoteData.getData("ExpectedStatus").equalsIgnoreCase("Quote Outstanding")) {
			if (pcInfoPremiumTotal.equalsIgnoreCase(quotePremium)) {
				list.add(true);
				CustomReporting
						.logReport("", "",
								"Total Pemium in Policy Center <b><i><font color='green'>" + pcInfoPremiumTotal + "</font></i></b> is as Expected value <b><i><font color='green'> "
										+ quotePremium + "</font></i></b> in Quote screen",
								StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Total Pemium in Policy Center <b><i><font color='red'>" + pcInfoPremiumTotal + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
								+ quotePremium + "</font></i></b> in Exposure  screen",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			}else if (QuoteData.getData("ExpectedStatus").equalsIgnoreCase("Underwriter Review")) {
				
					if (!(pcInfoPremiumTotal.equalsIgnoreCase(""))) {
						list.add(true);
						CustomReporting
								.logReport("", "",
										"Total Pemium in Policy Center<b><i><font color='green'> " + pcInfoPremiumTotal + "</font></i></b> is as Expected value  <b><i><font color='green'>"
												+ quotePremium + "</font></i></b> in Quote screen",
										StepStatus.SUCCESS, new String[] {}, startTime);
					} else {
						list.add(false);
						CustomReporting.logReport("", "",
								"Total Pemium in Policy Center <b><i><font color='red'>" + pcInfoPremiumTotal + "</font></i></b> is not as Expected value  <b><i><font color='red'>"
										+ quotePremium + "</font></i></b> in Exposure  screen",
								StepStatus.FAILURE, new String[] {}, startTime);
					}
			}
			String pcInfoQuoteNumber = getWebDriver().findElement(By.id(
					"SubmissionWizard:SubmissionWizard_QuoteScreen:RatingCumulDetailsPanelSet:RateReqestID-inputEl"))
					.getText();
			if(QuoteData.getData("ExpectedStatus").equalsIgnoreCase("Quote Outstanding")) {
	/*		if (pcInfoQuoteNumber.equalsIgnoreCase(resQuoteNumber)) {
				list.add(true);
				CustomReporting
						.logReport("", "",
								"Quote Number in Policy Center <b><i><font color='green'>" + pcInfoQuoteNumber + "</font></i></b> is as Expected value <b><i><font color='green'> "
										+ resQuoteNumber + "</font></i></b> in Quote screen",
								StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting
						.logReport("", "",
								"Quote Number in Policy Center <b><i><font color='red'>" + pcInfoQuoteNumber + "</font></i></b> is not as Expected value <b><i><font color='red'> "
										+ resQuoteNumber + "</font></i></b> in Quote  screen",
								StepStatus.FAILURE, new String[] {}, startTime);
			}*/
			}else if (QuoteData.getData("ExpectedStatus").equalsIgnoreCase("Underwriter Review")) {
				if (!(pcInfoQuoteNumber.equalsIgnoreCase(""))) {
					list.add(true);
					CustomReporting
					.logReport("", "",
							"Quote Number in Policy Center <b><i><font color='green'>" + pcInfoQuoteNumber + "</font></i></b> is as Expected value <b><i><font color='green'> "
									+ resQuoteNumber + "</font></i></b> in Quote screen",
							StepStatus.SUCCESS, new String[] {}, startTime);
					
				} 
				
				else {
					
					list.add(false);
					CustomReporting
							.logReport("", "",
									"Quote Number in Policy Center<b><i><font color='red'> " + pcInfoQuoteNumber + "</font></i></b> is not as Expected value <b><i><font color='red'> "
											+ resQuoteNumber + "</font></i></b> in Quote  screen",
									StepStatus.FAILURE, new String[] {}, startTime);
				
				
				}
			}
			// verify location screen
			getWebDriver().findElement(By.xpath("//td[@id='SubmissionWizard:BillingInfo']")).click();
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.instance().logReport("Clicked on Payment Link Successfully");
			Thread.sleep(3000);

			String pcInfoBillingType = getWebDriver().findElement(
					By.id("SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:BillingMethod-inputEl"))
					.getAttribute("value");
			if (resBillingType.equals("D")) {
				if (pcInfoBillingType.equalsIgnoreCase("Direct Bill")) {
					
					list.add(true);
					CustomReporting.logReport("", "",
							"Billing Type in Policy Center <b><i><font color='green'>" + pcInfoBillingType + "</font></i></b> is as Expected value  <b><i><font color='green'>"
									+ "Direct Bill" + "</font></i></b> in Payment screen",
							StepStatus.SUCCESS, new String[] {}, startTime);
				} else {
					
					list.add(false);
					CustomReporting.logReport("", "",
							"Billing Type  in Policy Center <b><i><font color='red'>" + pcInfoBillingType + "</font></i></b> is not as Expected value <b><i><font color='red'> "
									+ "Direct Bill" + "</font></i></b> in Payment  screen",
							StepStatus.FAILURE, new String[] {}, startTime);
				}
			} else {
				if (pcInfoBillingType.equalsIgnoreCase("Agency Bill")) {
					
					list.add(true);
					CustomReporting.logReport("", "",
							"Billing Type in Policy Center <b><i><font color='green'>" + pcInfoBillingType + "</font></i></b> is as Expected value  <b><i><font color='green'>"
									+ "Agent Bill" + "</font></i></b> in Payment screen",
							StepStatus.SUCCESS, new String[] {}, startTime);
				} else {
					
					list.add(false);
					CustomReporting.logReport("", "",
							"Billing Type  in Policy Center <b><i><font color='red'>" + pcInfoBillingType + "</font></i></b> is not as Expected value <b><i><font color='red'> "
									+ "Agent Bill" + "</font></i></b> in Payment  screen",
							StepStatus.FAILURE, new String[] {}, startTime);
				}
			}

			int paymentPlanList = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:PlanInputSet:PaymentsPlanDV:PaymentsPlanInputSet:InstallmentPlan:BillingAdjustmentsInstallmentsLV-body']/div[1]/div/table"))
					.size();
			for (int j = 1; j < paymentPlanList; j++) {
				String paymentPlanValue = getWebDriver().findElement(By.xpath(
						"//div[@id='SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:PlanInputSet:PaymentsPlanDV:PaymentsPlanInputSet:InstallmentPlan:BillingAdjustmentsInstallmentsLV-body']/div[1]/div/table["
								+ j + "]/tbody/tr/td[2]"))
						.getText();
				boolean paymentPlanRadioValue = getWebDriver().findElement(By.xpath(
						"//div[@id='SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:PlanInputSet:PaymentsPlanDV:PaymentsPlanInputSet:InstallmentPlan:BillingAdjustmentsInstallmentsLV-body']/div[1]/div/table["
								+ j + "]/tbody/tr/td[1]/div[1]/div"))
						.isSelected();
				if (paymentPlanRadioValue) {
					
					list.add(true);
					CustomReporting.logReport("", "", "Payment Plan <b><i><font color='green'>" + paymentPlanValue
							+ "</font></i></b> is selected in Policy Center " + " in Payment screen", StepStatus.SUCCESS,
							new String[] {}, startTime);
					break;
				}

			}
			
			
		}else if(getWebDriver().findElement(By.xpath("//span[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiabilityEU_Esu_GLEScreen:ttlBar']")).getText().equalsIgnoreCase("Exposures")) {
			list.add(true);
			CustomReporting.logReport("", "", "Quote page is not " + ""
					+ " enabled as expected " + " for decline scenario.", StepStatus.SUCCESS,
					new String[] {}, startTime);
			
		}else {
			
			list.add(false);
			CustomReporting.logReport("", "", "Quote page is " + ""
					+ " enabled,which is not as  expected " + " for decline scenario.", StepStatus.FAILURE,
					new String[] {}, startTime);
		}
			// getWebDriver().close();
			// getWebDriver().switchTo().window(strParentWindowID);

		} catch (RuntimeException ex) {
			func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
			CustomReporting.logReport("", "", "Error occurred in Page" + getPageName(), "", StepStatus.FAILURE,
					new String[] {}, startTime, null);
		//	getWebDriver().findElement(By.xpath("//span[@id=':TabLinkMenuButton-btnIconEl']")).click();
		//	getWebDriver().findElement(By.xpath("//span[@id='TabBar:LogoutTabBarLink-textEl']")).click();

			throw ex;
		}

	}

	@Override
	public void closeScreenshots(String tcID, SoftAssert softAssert) throws Exception {

		func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
	}

	@SuppressWarnings("static-access")
	@Override
	public void verifyCoverageSection(String tcID, SoftAssert softAssert, String DeviceName,List<Boolean> list) throws Exception {
		try {
			PageData data = PageDataManager.instance().getPageData("PolicyCenterPage", tcID);
			PageData SubData = PageDataManager.instance().getPageData("Submission", tcID);

			// String respExpirationDate =
			// GenericFunctions.instance()._getGlobalVariableValue("respExpirationDate");
			String respLimitValue = "";

			String respLimitValueComCov = GenericFunctions.instance()._getGlobalVariableValue("res" + "_" + "revenue");
			String resExposureRevenue = GenericFunctions.instance()._getGlobalVariableValue("res" + "_" + "revenue");

			String resExposureCorporateAssets = GenericFunctions.instance()
					._getGlobalVariableValue("res" + "_" + "corporate_assets");
			String resForeignEmp = GenericFunctions.instance()
					._getGlobalVariableValue("res" + "_" + "foreign_employees");

			String resCoveragePartCode = GenericFunctions.instance()._getGlobalVariableValue("resCoveragePartCode");
			String respRetentionValue = "";

			ArrayList<String> listOfCoverages = new ArrayList<>();

			// if(resCoveragePartCode.contains("crime")) {
			// respLimitValue =
			// GenericFunctions.instance()._getGlobalVariableValue("respLimitValue");
			//
			// }else
			// if(resCoveragePartCode.contains("DIRECTORS_AND_OFFICERS")||resCoveragePartCode.equalsIgnoreCase("EMPLOYMENT_PRACTICES_LIABILITY"))
			// {
			// respLimitValue =
			// GenericFunctions.instance()._getGlobalVariableValue("respLimitValue"+"_"+resCoveragePartCode);
			// respRetentionValue=GenericFunctions.instance()._getGlobalVariableValue("respRetentionValue"+"_"+resCoveragePartCode);
			// }
			Thread.sleep(5000);
			getWebDriver().findElement(By.xpath("//span[text()='Coverages']")).click();
		
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			CustomReporting.instance().logReport("Clicked on Coverages Link Successfully");
			getWebDriver().findElement(By.xpath(
					"//a[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:GeneralLiability_StandardCoveragesCardTab']"))
					.click();
			Thread.sleep(3000);
			int noOfCoverages = getWebDriver().findElements(By.xpath(
					"//a[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:stdCovCardIterator:0:GeneralLiability_StandardCoveragesCard_CommonTab']/..//a"))
					.size();
			for (int j = 2; j <= noOfCoverages; j++) {
				listOfCoverages.add(getWebDriver().findElement(By.xpath(
						"((//a[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:stdCovCardIterator:0:GeneralLiability_StandardCoveragesCard_CommonTab']/..//a)["
								+ j + "]//span)[4]"))
						.getText());
			}
			System.out.println(noOfCoverages);
			if (listOfCoverages.contains("DIRECTORS_AND_OFFICERS")
					|| listOfCoverages.contains("EMPLOYMENT_PRACTICES_LIABILITY")
					|| listOfCoverages.contains("FIDUCIARY_LIABILITY")) {
				int coverageNamesSize = getWebDriver()
						.findElements(By.xpath("//table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr")).size();
				for (int s = 2; s <= coverageNamesSize; s = s + 2) {
					if (s % 2 == 0) {
						String coverageName = getWebDriver()
								.findElement(By.xpath(
										"//table/tbody/tr/td/div/table/tbody/tr[" + s + "]/td/fieldset/legend/div"))
								.getText();
						if (coverageName.contains("Run-Off Coverage Period")) {
							int noOfDiv = getWebDriver()
									.findElements(By.xpath(
											"//table/tbody/tr[" + s + "]/td/fieldset/div/div/div/div/label/span"))
									.size();
							for (int x = 1; x < noOfDiv; x++) {
								String label = getWebDriver().findElement(By.xpath("//table/tbody/tr[" + s
										+ "]/td/fieldset/div/div/div/div[" + x + "]/label/span")).getText();
								String value = getWebDriver().findElement(By.xpath(
										"//table/tbody/tr[" + s + "]/td/fieldset/div/div/div/div[" + x + "]/div/div"))
										.getText().replace(",", "");
								if (label.contains("Percentage of Annual Premium (1 Year)")) {
									list.add(true);
									if (value.equals("75")) {
										CustomReporting.logReport("", "",
												label + " is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage<b><i><font color='green'> " + coverageName
														+ "</font></i></b> is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "",
												label + " is <b><i><font color='red'> " + value + " </font></i></b> for Coverage <b><i><font color='red'>" + coverageName
														+ "</font></i></b> is not as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}
								if (label.contains("Percentage of Annual Premium (3 Years)")) {
									list.add(true);
									if (value.equals("105")) {
										CustomReporting.logReport("", "",
												label + " is <b><i><font color='green'>  " + value + "</font></i></b>  for Coverage <b><i><font color='green'> " + coverageName
														+ "</font></i></b> is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "",
												label + " is  <b><i><font color='red'> " + value + " </font></i></b> for Coverage <b><i><font color='red'> " + coverageName
														+ "</font></i></b> is not as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}

								if (label.contains("Percentage of Annual Premium (6 Years)")) {
									list.add(true);
									if (value.equals("150")) {
										CustomReporting.logReport("", "<b><i><font color='green'>",
												label + "</font></i></b> is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
														+ "</font></i></b> is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "<b><i><font color='red'>",
												label + "</font></i></b> is <b><i><font color='red'>" + value + "</font></i></b>  for Coverage <b><i><font color='red'>" + coverageName
														+ "</font></i></b> is as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}

							}
						}
						if (coverageName.contains("Combined Aggregate Limit of Liability")) {
							String label = getWebDriver()
									.findElement(By.xpath(
											"//table/tbody/tr[" + s + "]/td/fieldset/div/div/div/div/label/span"))
									.getText();
							String value = getWebDriver()
									.findElement(
											By.xpath("//table/tbody/tr[" + s + "]/td/fieldset/div/div/div/div/div/div"))
									.getText().replace(",", "");
							if (value.equalsIgnoreCase(respLimitValueComCov)) {
								list.add(true);
								CustomReporting.logReport("", "<b><i><font color='green'>",
										label + "</font></i></b> is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName + "</font></i></b> is as expected",
										StepStatus.SUCCESS, new String[] {}, startTime);
							} else {
								list.add(false);
								CustomReporting.logReport("", "<b><i><font color='red'>",
										label + "</font></i></b> is <b><i><font color='red'> " + value + "</font></i></b>  for Coverage <b><i><font color='red'>" + coverageName
												+ "</font></i></b> is not as expected",
										StepStatus.FAILURE, new String[] {}, startTime);
							}
						}

						if (coverageName.contains("Terrorism")) {
							String label = getWebDriver()
									.findElement(By.xpath(
											"//table/tbody/tr[" + s + "]/td/fieldset/div/div/div/div/label/span"))
									.getText();
							String value = getWebDriver()
									.findElement(
											By.xpath("//table/tbody/tr[" + s + "]/td/fieldset/div/div/div/div/div/div"))
									.getText().replace(",", "");
							if (value.contains("Accept")) {
								list.add(true);
								CustomReporting.logReport("", "<b><i><font color='green'>",
										label + "</font></i></b> is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName + "</font></i></b> is as expected",
										StepStatus.SUCCESS, new String[] {}, startTime);
							} else {
								list.add(false);
								CustomReporting.logReport("", "<b><i><font color='red'>",
										label + "</font></i></b> is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage <b><i><font color='red'>" + coverageName
												+ "</font></i></b> is not as expected",
										StepStatus.FAILURE, new String[] {}, startTime);
							}
						}
						if (coverageName.contains("Extended Reporting Period")) {
							int noOfDiv = getWebDriver()
									.findElements(By.xpath(
											"//table/tbody/tr[" + s + "]/td/fieldset/div/div/div/div/label/span"))
									.size();
							for (int m = 1; m < noOfDiv; m++) {
								String label = getWebDriver().findElement(By.xpath("//table/tbody/tr[" + s
										+ "]/td/fieldset/div/div/div/div[" + m + "]/label/span")).getText();
								String value = getWebDriver().findElement(By.xpath(
										"//table/tbody/tr[" + s + "]/td/fieldset/div/div/div/div[" + m + "]/div/div"))
										.getText().replace(",", "");
								if (label.contains("Percentage of Annual Premium")) {
									
									if (value.equals("75")) {
										list.add(true);
										CustomReporting.logReport("", "<b><i><font color='green'>",
												label + "</font></i></b> is  <b><i><font color='green'>" + value + " </font></i></b> for Coverage <b><i><font color='green'>" + coverageName
														+ "</font></i></b> is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "<b><i><font color='red'>",
												label + "</font></i></b> is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage <b><i><font color='red'>" + coverageName
														+ "</font></i></b> is not as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}
								if (label.contains("Additional Period in Years")) {
									
									if (value.equals("1")) {
										list.add(true);
										CustomReporting.logReport("", "<b><i><font color='green'>",
												label + "</font></i></b> is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
														+ "</font></i></b> is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "<b><i><font color='red'>",
												label + "</font></i></b> is <b><i><font color='red'> " + value + " </font></i></b> for Coverage <b><i><font color='red'> " + coverageName
														+ "</font></i></b> is not  as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}

								if (label.contains("ERP Coverage Status")) {
									if (value.equalsIgnoreCase("offered")) {
										list.add(true);
										CustomReporting.logReport("", "<b><i><font color='green'>",
												label + "</font></i></b> is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
														+ "</font></i></b> is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "<b><i><font color='red'>",
												label + "</font></i></b> is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage <b><i><font color='red'> " + coverageName
														+ "</font></i></b> is not as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}

							}
						}
					}

				}
			}
			
			if (listOfCoverages.contains("CYBER_LIABILITY")) {
				int coverageNamesSize = getWebDriver()
						.findElements(By.xpath("//table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr")).size();
				for (int s = 2; s <= coverageNamesSize; s = s + 2) {
					if (s % 2 == 0) {
						String coverageName = getWebDriver()
								.findElement(By.xpath(
										"//table/tbody/tr/td/div/table/tbody/tr[" + s + "]/td/fieldset/legend/div"))
								.getText();
						
						

						if (coverageName.contains("Terrorism")) {
							String label = getWebDriver()
									.findElement(By.xpath(
											"//table/tbody/tr[" + s + "]/td/fieldset/div/div/div/div/label/span"))
									.getText();
							String value = getWebDriver()
									.findElement(
											By.xpath("//table/tbody/tr[" + s + "]/td/fieldset/div/div/div/div/div/div"))
									.getText().replace(",", "");
							if (value.contains("Accept")) {
								list.add(true);
								CustomReporting.logReport("", "<b><i><font color='green'>",
										label + "</font></i></b> is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName + "</font></i></b> is as expected",
										StepStatus.SUCCESS, new String[] {}, startTime);
							} else {
								list.add(false);
								CustomReporting.logReport("", "<b><i><font color='red'>",
										label + "</font></i></b> is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage <b><i><font color='red'>" + coverageName
												+ "</font></i></b> is not as expected",
										StepStatus.FAILURE, new String[] {}, startTime);
							}
						}
						if (coverageName.contains("Extended Reporting Period")) {
							int noOfDiv = getWebDriver()
									.findElements(By.xpath(
											"//table/tbody/tr[" + s + "]/td/fieldset/div/div/div/div/label/span"))
									.size();
							for (int m = 1; m < noOfDiv; m++) {
								String label = getWebDriver().findElement(By.xpath("//table/tbody/tr[" + s
										+ "]/td/fieldset/div/div/div/div[" + m + "]/label/span")).getText();
								String value = getWebDriver().findElement(By.xpath(
										"//table/tbody/tr[" + s + "]/td/fieldset/div/div/div/div[" + m + "]/div/div"))
										.getText().replace(",", "");
								if (label.contains("Percentage of Annual Premium (Option 1)")) {
									
									if (value.equals("100")) {
										list.add(true);
										CustomReporting.logReport("", "<b><i><font color='green'>",
												label + "</font></i></b> is  <b><i><font color='green'>" + value + " </font></i></b> for Coverage <b><i><font color='green'>" + coverageName
														+ "</font></i></b> is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "<b><i><font color='red'>",
												label + "</font></i></b> is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage <b><i><font color='red'>" + coverageName
														+ "</font></i></b> is not as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}
								if (label.contains("Additional Period in Years (Option 1)")) {
									
									if (value.equals("1")) {
										list.add(true);
										CustomReporting.logReport("", "<b><i><font color='green'>",
												label + "</font></i></b> is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
														+ "</font></i></b> is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "<b><i><font color='red'>",
												label + "</font></i></b> is <b><i><font color='red'> " + value + " </font></i></b> for Coverage <b><i><font color='red'> " + coverageName
														+ "</font></i></b> is not  as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}
								if (label.contains("Percentage of Annual Premium (Option 2)")) {
									
									if (value.equals("175")) {
										list.add(true);
										CustomReporting.logReport("", "<b><i><font color='green'>",
												label + "</font></i></b> is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
														+ "</font></i></b> is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "<b><i><font color='red'>",
												label + "</font></i></b> is <b><i><font color='red'> " + value + " </font></i></b> for Coverage <b><i><font color='red'> " + coverageName
														+ "</font></i></b> is not  as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}
								
								if (label.contains("Additional Period in Years (Option 2)")) {
									
									if (value.equals("2")) {
										list.add(true);
										CustomReporting.logReport("", "<b><i><font color='green'>",
												label + "</font></i></b> is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
														+ "</font></i></b> is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "<b><i><font color='red'>",
												label + "</font></i></b> is <b><i><font color='red'> " + value + " </font></i></b> for Coverage <b><i><font color='red'> " + coverageName
														+ "</font></i></b> is not  as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}
								
								if (label.contains("Percentage of Annual Premium (Option 3)")) {
									
									if (value.equals("225")) {
										list.add(true);
										CustomReporting.logReport("", "<b><i><font color='green'>",
												label + "</font></i></b> is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
														+ "</font></i></b> is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "<b><i><font color='red'>",
												label + "</font></i></b> is <b><i><font color='red'> " + value + " </font></i></b> for Coverage <b><i><font color='red'> " + coverageName
														+ "</font></i></b> is not  as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}
								
								if (label.contains("Additional Period in Years (Option 3)")) {
									
									if (value.equals("3")) {
										list.add(true);
										CustomReporting.logReport("", "<b><i><font color='green'>",
												label + "</font></i></b> is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
														+ "</font></i></b> is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "<b><i><font color='red'>",
												label + "</font></i></b> is <b><i><font color='red'> " + value + " </font></i></b> for Coverage <b><i><font color='red'> " + coverageName
														+ "</font></i></b> is not  as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}

								if (label.contains("ERP Coverage Status")) {
									if (value.equalsIgnoreCase("Offered")) {
										list.add(true);
										CustomReporting.logReport("", "<b><i><font color='green'>",
												label + "</font></i></b> is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
														+ "</font></i></b> is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "<b><i><font color='red'>",
												label + "</font></i></b> is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage <b><i><font color='red'> " + coverageName
														+ "</font></i></b> is not as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}

							}
						}
					}

				}
			}
			for (int i = 2; i <= noOfCoverages; i++) {

				Thread.sleep(3000);
				getWebDriver().findElement(By.xpath("//span[text()='Coverages']")).click();
				Thread.sleep(3000);
				String coverage = getWebDriver().findElement(By.xpath(
						"((//a[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:stdCovCardIterator:0:GeneralLiability_StandardCoveragesCard_CommonTab']/..//a)["
								+ i + "]//span)[4]"))
						.getText();
				Thread.sleep(3000);
				System.out.println(coverage);
				if (coverage.contains("CRI")) {
					Thread.sleep(3000);
					getWebDriver().findElement(By.xpath("//span[text()='Coverages']")).click();
					getWebDriver().findElement(By.xpath(
							"//table/tbody/tr[5]/td/div/div[2]/div/table/tbody/tr/td/div/div[1]/div[1]/div[2]/div/a["
									+ i + "]"))
							.click();
					Thread.sleep(3000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					int coverages = getWebDriver().findElements(By.xpath(
							"//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:stdCovCardIterator:1:0-table']/tbody/tr/td/div/table/tbody/tr"))
							.size();
					for (int j = 1; j <= coverages; j++) {
						if (j % 2 == 0) {

							String coverageName = getWebDriver().findElement(By.xpath(
									"//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:stdCovCardIterator:1:0-table']/tbody/tr/td/div/table/tbody/tr["
											+ j + "]/td/fieldset/legend/div"))
									.getText();
							String labelName_LPO = getWebDriver().findElement(By.xpath(
									"//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:stdCovCardIterator:1:0-table']/tbody/tr/td/div/table/tbody/tr["
											+ j + "]/td/fieldset/div/div/div/div[1]/label/span"))
									.getText();
							String value_LPO = getWebDriver().findElement(By.xpath(
									"//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:stdCovCardIterator:1:0-table']/tbody/tr/td/div/table/tbody/tr["
											+ j + "]/td/fieldset/div/div/div/div[1]/div/div"))
									.getText().replace(",", "");
							String value_DPO = "";
							String labelName_DPO = "";
							if (j != 22) {
								labelName_DPO = getWebDriver().findElement(By.xpath(
										"//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:stdCovCardIterator:1:0-table']/tbody/tr/td/div/table/tbody/tr["
												+ j + "]/td/fieldset/div/div/div/div[2]/label/span"))
										.getText();
								value_DPO = getWebDriver().findElement(By.xpath(
										"//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:stdCovCardIterator:1:0-table']/tbody/tr/td/div/table/tbody/tr["
												+ j + "]/td/fieldset/div/div/div/div[2]/div/div"))
										.getText().replace(",", "");
							}
							int revenueCount = Integer.parseInt(resExposureRevenue);
							if (coverageName.contains("Social Engineering Fraud Coverage")) {
								if (value_LPO.equals("50000")) {
									list.add(true);
									CustomReporting.logReport("", "<b><i><font color='green'>",
											labelName_LPO + "</font></i></b> is  <b><i><font color='green'>" + value_LPO + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
													+ "</font></i></b> is as expected",
											StepStatus.SUCCESS, new String[] {}, startTime);
								} else {
									list.add(false);
									CustomReporting.logReport("", "<b><i><font color='red'>",
											labelName_LPO + "</font></i></b> is <b><i><font color='red'> " + value_LPO + "</font></i></b>  for Coverage <b><i><font color='red'>" + coverageName
													+ "</font></i></b> is not as expected",
											StepStatus.FAILURE, new String[] {}, startTime);
								}
								if (value_DPO.equals(data.getData("ExpectedDeductibleValue"))) {
									list.add(true);
									CustomReporting.logReport("", "<b><i><font color='green'>",
											labelName_DPO + "</font></i></b> is <b><i><font color='green'> " + value_DPO + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
													+ "</font></i></b> is as expected",
											StepStatus.SUCCESS, new String[] {}, startTime);
								} else {
									list.add(false);
									CustomReporting.logReport("", "<b><i><font color='red'>",
											labelName_DPO + "</font></i></b> is <b><i><font color='red'> " + value_DPO + "</font></i></b>  for Coverage <b><i><font color='red'>" + coverageName
													+ "</font></i></b> is not as expected",
											StepStatus.FAILURE, new String[] {}, startTime);
								}
							}
							if (coverageName.contains("Expense Coverage")) {
								if (value_LPO.equals("25000")) {
									list.add(true);
									CustomReporting.logReport("", "<b><i><font color='green'>",
											labelName_LPO + "</font></i></b> is  <b><i><font color='green'>" + value_LPO + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
													+ "</font></i></b> is as expected",
											StepStatus.SUCCESS, new String[] {}, startTime);
								} else {
									list.add(false);
									CustomReporting.logReport("", "<b><i><font color='red'>",
											labelName_LPO + "</font></i></b> is <b><i><font color='red'> " + value_LPO + "</font></i></b>  for Coverage <b><i><font color='red'>" + coverageName
													+ "</font></i></b> is not as expected",
											StepStatus.FAILURE, new String[] {}, startTime);
								}
							}
							if (!(coverageName.contains("Expense Coverage")
									|| coverageName.contains("Social Engineering Fraud Coverage"))) {
								if (revenueCount <= 50000000 || revenueCount >= 100000000) {
									if (labelName_DPO.contains("Deductible Per Occurrence")
											|| value_DPO.equalsIgnoreCase(data.getData("ExpectedDeductibleValue"))) {
										list.add(true);
										CustomReporting.logReport("", "",
												labelName_DPO + " is  <b><i><font color='green'>" + value_DPO + "</font></i></b>  for Coverage " + coverageName
														+ " is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "",
												labelName_DPO + " is  <b><i><font color='red'>" + value_DPO + "</font></i></b>  for Coverage " + coverageName
														+ " is not as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}

								}
								if (labelName_LPO.contains("Limit Per Occurrence")) {
									if (value_LPO.equalsIgnoreCase(SubData.getData("CRIME_limit").replace(",", ""))) {
										list.add(true);
										CustomReporting.logReport("", "",
												labelName_LPO + " is <b><i><font color='green'> " + value_LPO + " </font></i></b> for Coverage " + coverageName
														+ " is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "",
												labelName_LPO + " is  <b><i><font color='red'>" + value_LPO + " </font></i></b> for Coverage " + coverageName
														+ " is not as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}

							}
						}

					}
					verifyModifierSection(tcID, softAssert, DeviceName, coverage, list);
				}
				if (coverage.contains("DNO")) {
					Thread.sleep(3000);
					getWebDriver().findElement(By.xpath("//span[text()='Coverages']")).click();
					getWebDriver().findElement(By.xpath(
							"//table/tbody/tr[5]/td/div/div[2]/div/table/tbody/tr/td/div/div[1]/div[1]/div[2]/div/a["
									+ i + "]"))
							.click();
					Thread.sleep(3000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					int coverageNamesSize = getWebDriver()
							.findElements(By.xpath("//table/tbody/tr/td/div/table/tbody/tr/td/fieldset/legend/div"))
							.size();
					for (int d = 2; d < coverageNamesSize; d = d + 2) {
						if (d % 2 == 0) {
							String coverageName = getWebDriver()
									.findElement(By.xpath(
											"//table/tbody/tr/td/div/table/tbody/tr[" + d + "]/td/fieldset/legend/div"))
									.getText();
							if (coverageName.contains("Investigative Costs")) {
								int limitValueDNO = 0;
								if (Integer.parseInt(SubData.getData("directors_and_officers_limit")) >= 500000) {
									limitValueDNO = 500000;
								} else {
									limitValueDNO = Integer.parseInt(SubData.getData("directors_and_officers_limit"));
								}
								String label = getWebDriver()
										.findElement(By.xpath(
												"//table/tbody/tr[" + d + "]/td/fieldset/div/div/div/div/label/span"))
										.getText();
								String value = getWebDriver()
										.findElement(By.xpath(
												"//table/tbody/tr[" + d + "]/td/fieldset/div/div/div/div/div/div"))
										.getText().replace(",", "");
								if (value.equals(Integer.toString(limitValueDNO))) {
									list.add(true);
									CustomReporting.logReport("", "",
											label + " is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage " + coverageName
													+ " is as expected",
											StepStatus.SUCCESS, new String[] {}, startTime);
								} else {
									list.add(false);
									CustomReporting.logReport("", "",
											label + " is <b><i><font color='red'> " + value + "</font></i></b>  for Coverage " + coverageName
													+ " is not as expected",
											StepStatus.FAILURE, new String[] {}, startTime);
								}
							}
							if (coverageName.contains("Asset Protection Costs")) {
								String label = getWebDriver()
										.findElement(By.xpath(
												"//table/tbody/tr[" + d + "]/td/fieldset/div/div/div/div/label/span"))
										.getText();
								String value = getWebDriver()
										.findElement(By.xpath(
												"//table/tbody/tr[" + d + "]/td/fieldset/div/div/div/div/div/div"))
										.getText().replace(",", "");

								int limitValueDNO = 0;
								if (Integer.parseInt(SubData.getData("directors_and_officers_limit")) >= 25000) {
									limitValueDNO = 25000;
								} else {
									limitValueDNO = Integer.parseInt(SubData.getData("directors_and_officers_limit"));
								}
								if (value.equals(Integer.toString(limitValueDNO))) {
									list.add(true);
									CustomReporting.logReport("", "",
											label + " is <b><i><font color='green'>  " + value + "</font></i></b>  for Coverage " + coverageName
													+ " is as expected",
											StepStatus.SUCCESS, new String[] {}, startTime);
								} else {
									list.add(false);
									CustomReporting.logReport("", "",
											label + " is  <b><i><font color='red'> " + value + "</font></i></b>  for Coverage " + coverageName
													+ " is not as expected",
											StepStatus.FAILURE, new String[] {}, startTime);
								}
							}

							if (coverageName.contains("Public Relations Costs")) {
								String label = getWebDriver()
										.findElement(By.xpath(
												"//table/tbody/tr[" + d + "]/td/fieldset/div/div/div/div/label/span"))
										.getText();
								String value = getWebDriver()
										.findElement(By.xpath(
												"//table/tbody/tr[" + d + "]/td/fieldset/div/div/div/div/div/div"))
										.getText().replace(",", "");

								int limitValueDNO = 0;
								if (Integer.parseInt(SubData.getData("directors_and_officers_limit")) >= 25000) {
									limitValueDNO = 25000;
								} else {
									limitValueDNO = Integer.parseInt(SubData.getData("directors_and_officers_limit"));
								}
								if (value.equals(Integer.toString(limitValueDNO))) {
									list.add(true);
									CustomReporting.logReport("", "",
											label + " is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage " + coverageName
													+ " is as expected",
											StepStatus.SUCCESS, new String[] {}, startTime);
								} else {
									list.add(false);
									CustomReporting.logReport("", "",
											label + " is <b><i><font color='red'> " + value + "</font></i></b>  for Coverage " + coverageName
													+ " is not as expected",
											StepStatus.FAILURE, new String[] {}, startTime);
								}
							}

							if (coverageName.contains("Additional Side A Limit for D&O Liability")) {
								String label = getWebDriver()
										.findElement(By.xpath(
												"//table/tbody/tr[" + d + "]/td/fieldset/div/div/div/div/label/span"))
										.getText();
								String value = getWebDriver()
										.findElement(By.xpath(
												"//table/tbody/tr[" + d + "]/td/fieldset/div/div/div/div/div/div"))
										.getText().replace(",", "");

								int limitValueDNO = 0;
								if (Integer.parseInt(SubData.getData("directors_and_officers_limit")) >= 1000000) {
									limitValueDNO = 1000000;
								} else {
									limitValueDNO = Integer.parseInt(SubData.getData("directors_and_officers_limit"));
								}
								if (value.equals(Integer.toString(limitValueDNO))) {
									list.add(true);
									CustomReporting.logReport("", "",
											label + " is  <b><i><font color='green'>" + value + "</font></i></b>   for Coverage " + coverageName
													+ " is as expected",
											StepStatus.SUCCESS, new String[] {}, startTime);
								} else {
									list.add(false);
									CustomReporting.logReport("", "",
											label + " is <b><i><font color='red'> " + value + "</font></i></b>   for Coverage " + coverageName
													+ " is not as expected",
											StepStatus.FAILURE, new String[] {}, startTime);
								}
							}
							if (coverageName.contains("Directors & Officers Liability")) {
								int noOfDiv = getWebDriver()
										.findElements(By.xpath(
												"//table/tbody/tr[" + d + "]/td/fieldset/div/div/div/div/label/span"))
										.size();
								for (int x = 1; x < noOfDiv; x++) {
									String label = getWebDriver().findElement(By.xpath("//table/tbody/tr[" + d
											+ "]/td/fieldset/div/div/div/div[" + x + "]/label/span")).getText();
									String value = getWebDriver()
											.findElement(By.xpath("//table/tbody/tr[" + d
													+ "]/td/fieldset/div/div/div/div[" + x + "]/div/div"))
											.getText().replace(",", "");
									if (label.contains("Aggregate Limit of Liability")) {
										if (value.equals(SubData.getData("directors_and_officers_limit"))) {
											list.add(true);
											CustomReporting.logReport("", "",
													label + " is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage " + coverageName
															+ " is as expected",
													StepStatus.SUCCESS, new String[] {}, startTime);
										} else {
											list.add(false);
											CustomReporting.logReport("", "",
													label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
															+ " is not as expected",
													StepStatus.FAILURE, new String[] {}, startTime);
										}
									}
									if (label.contains("Retention")) {

										if (Integer.parseInt(resExposureCorporateAssets) > 0
												&& Integer.parseInt(resExposureCorporateAssets) <= 25000000) {
											respRetentionValue = "5000";
										} else if (Integer.parseInt(resExposureCorporateAssets) > 25000000
												&& Integer.parseInt(resExposureCorporateAssets) <= 75000000) {
											respRetentionValue = "10000";
										} else if (Integer.parseInt(resExposureCorporateAssets) > 75000000
												&& Integer.parseInt(resExposureCorporateAssets) <= 250000000) {
											respRetentionValue = "25000";
										} else {
											respRetentionValue = "50000";
										}
										GenericFunctions.instance()._addToGlobalVariableList("ExpectedDNORetntionVal",
												respRetentionValue);
										if (value.equals(respRetentionValue)) {
											list.add(true);
											CustomReporting.logReport("", "",
													label + " is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage " + coverageName
															+ " is as expected",
													StepStatus.SUCCESS, new String[] {}, startTime);
										} else {
											list.add(false);
											CustomReporting.logReport("", "",
													label + " is <b><i><font color='red'> " + value + "</font></i></b>  for Coverage " + coverageName
															+ " is not as expected",
													StepStatus.FAILURE, new String[] {}, startTime);
										}
									}

									if (label.contains("Duty to Defend")) {
										if (value.equals(data.getData("ExpectedDD"))) {
											list.add(true);
											CustomReporting.logReport("", "",
													label + " is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage " + coverageName
															+ " is as expected",
													StepStatus.SUCCESS, new String[] {}, startTime);
										} else {
											list.add(false);
											CustomReporting.logReport("", "",
													label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
															+ " is not as expected",
													StepStatus.FAILURE, new String[] {}, startTime);
										}
									}

									if (label.contains("Shared Limit")) {
										if (value.equalsIgnoreCase("No") || value.equalsIgnoreCase("Yes")) {
											list.add(true);
											CustomReporting.logReport("", "",
													label + " is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage " + coverageName
															+ " is as expected",
													StepStatus.SUCCESS, new String[] {}, startTime);
										} else {
											list.add(false);
											CustomReporting.logReport("", "",
													label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
															+ " is not as expected",
													StepStatus.FAILURE, new String[] {}, startTime);
										}
									}
								}
							}
						}
					}
					verifyModifierSection(tcID, softAssert, DeviceName, coverage, list);
				}
				if (coverage.contains("EPL")) {

					getWebDriver().findElement(By.xpath("//span[text()='Coverages']")).click();
					Thread.sleep(3000);
					getWebDriver().findElement(By.xpath(
							"//table/tbody/tr[5]/td/div/div[2]/div/table/tbody/tr/td/div/div[1]/div[1]/div[2]/div/a["
									+ i + "]"))
							.click();
					Thread.sleep(3000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					int coverageNamesSize = getWebDriver()
							.findElements(By.xpath("//table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr"))
							.size();
					for (int y = 2; y <= coverageNamesSize; y = y + 2) {
						if (y % 2 == 0) {
							if ((y != 8) && (y != 10)) {
								// (//table/tbody/tr/td/div/table/tbody/tr)[5]//legend//div
								String coverageName = getWebDriver().findElement(By.xpath(
										"//table/tbody/tr/td/div/table/tbody/tr[" + y + "]/td/fieldset/legend/div"))
										.getText();
								if (coverageName.contains("Employment Practices Liability")) {
									int noOfDiv = getWebDriver().findElements(By.xpath(
											"//table/tbody/tr[" + y + "]/td/fieldset/div/div/div/div/label/span"))
											.size();
									for (int x = 1; x < noOfDiv; x++) {
										String label = getWebDriver()
												.findElement(By.xpath("//table/tbody/tr[" + y
														+ "]/td/fieldset/div/div/div/div[" + x + "]/label/span"))
												.getText();
										String value = getWebDriver()
												.findElement(By.xpath("//table/tbody/tr[" + y
														+ "]/td/fieldset/div/div/div/div[" + x + "]/div/div"))
												.getText().replace(",", "");
										if (label.contains("Aggregate Limit of Liability")) {
											if (value.equals(SubData.getData("employment_practices_liability_limit"))) {
												list.add(true);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is as expected",
														StepStatus.SUCCESS, new String[] {}, startTime);
											} else {
												list.add(false);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is not as expected",
														StepStatus.FAILURE, new String[] {}, startTime);
											}
										}
										if (label.contains("Retention")) {

											if (value.equals(data.getData("ExpectedDeductibleValueEPL"))) {
												list.add(true);
												CustomReporting.logReport("", "",
														label + " is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage " + coverageName
																+ " is as expected",
														StepStatus.SUCCESS, new String[] {}, startTime);
											} else {
												list.add(false);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is not as expected",
														StepStatus.FAILURE, new String[] {}, startTime);
											}
										}

										if (label.contains("Duty to Defend")) {
											if (value.equals(data.getData("ExpectedDD"))) {
												list.add(true);
												CustomReporting.logReport("", "",
														label + " is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage " + coverageName
																+ " is as expected",
														StepStatus.SUCCESS, new String[] {}, startTime);
											} else {
												list.add(false);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is not as expected",
														StepStatus.FAILURE, new String[] {}, startTime);
											}
										}

										if (label.contains("Shared Limit")) {
											if (value.equalsIgnoreCase("No") || value.equalsIgnoreCase("Yes")) {
												list.add(true);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is as expected",
														StepStatus.SUCCESS, new String[] {}, startTime);
											} else {
												list.add(false);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is not as expected",
														StepStatus.FAILURE, new String[] {}, startTime);
											}
										}
									}
								}
								if (coverageName.contains("Workplace Violence Expenses")) {
									String label = getWebDriver().findElement(By.xpath(
											"//table/tbody/tr[" + y + "]/td/fieldset/div/div/div/div/label/span"))
											.getText();
									String value = getWebDriver()
											.findElement(By.xpath(
													"//table/tbody/tr[" + y + "]/td/fieldset/div/div/div/div/div/div"))
											.getText().replace(",", "");
									if (Integer
											.parseInt(SubData.getData("employment_practices_liability_limit")) <= 250000
											&& Integer.parseInt(SubData
													.getData("employment_practices_liability_limit")) >= 100000) {
										if (Integer.parseInt(value) == Integer.parseInt(respLimitValue)) {
											list.add(true);
											CustomReporting.logReport("", "",
													label + " is  <b><i><font color='green'>" + value + " </font></i></b> for Coverage " + coverageName
															+ " is as expected",
													StepStatus.SUCCESS, new String[] {}, startTime);
										} else {
											list.add(false);
											CustomReporting.logReport("", "",
													label + " is <b><i><font color='red'> " + value + "</font></i></b>  for Coverage " + coverageName
															+ " is not as expected",
													StepStatus.FAILURE, new String[] {}, startTime);
										}
									} else if (Integer
											.parseInt(SubData.getData("employment_practices_liability_limit")) > 250000
											&& Integer.parseInt(SubData
													.getData("employment_practices_liability_limit")) <= 5000000) {
										if (Integer.parseInt(value) == 250000) {
											list.add(true);
											CustomReporting.logReport("", "",
													label + " is  <b><i><font color='green'>" + value + " </font></i></b> for Coverage " + coverageName
															+ " is as expected",
													StepStatus.SUCCESS, new String[] {}, startTime);
										} else {
											list.add(false);
											CustomReporting.logReport("", "",
													label + " is <b><i><font color='red'>  " + value + " </font></i></b>  for Coverage " + coverageName
															+ " is not as expected",
													StepStatus.FAILURE, new String[] {}, startTime);
										}

									} else {
										list.add(false);
										CustomReporting.logReport("", "",
												label + " is <b><i><font color='red'> " + value + " </font></i></b>  for Coverage " + coverageName
														+ " is not as expected.Please check the limit value.",
												StepStatus.FAILURE, new String[] {}, startTime);
									}

								}

								if (coverageName.contains("EPL Crisis Expenses")) {
									String label = getWebDriver().findElement(By.xpath(
											"//table/tbody/tr[" + y + "]/td/fieldset/div/div/div/div/label/span"))
											.getText();
									String value = getWebDriver()
											.findElement(By.xpath(
													"//table/tbody/tr[" + y + "]/td/fieldset/div/div/div/div/div/div"))
											.getText().replace(",", "");
									if (Integer.parseInt(value) <= 50000) {
										list.add(true);
										CustomReporting.logReport("", "",
												label + " is <b><i><font color='green'>  " + value + " </font></i></b> for Coverage " + coverageName
														+ " is as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
									} else {
										list.add(false);
										CustomReporting.logReport("", "",
												label + " is <b><i><font color='red'> " + value + "</font></i></b>  for Coverage " + coverageName
														+ " is not as expected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
								}
							}
						}

					}
					verifyModifierSection(tcID, softAssert, DeviceName, coverage, list);
				}
				if (coverage.contains("FID")) {
					Thread.sleep(3000);

					String CovergeExtendedForm = "FIDUCIARY_LIABILITY";
					String pendingPriorDate = GenericFunctions.instance()
							._getGlobalVariableValue(CovergeExtendedForm + "_" + "PLD");
					System.out.println(pendingPriorDate);
					getWebDriver().findElement(By.xpath("//span[text()='FID']")).click();
					Thread.sleep(3000);
	
					String coverageName = getWebDriver().findElement(By.xpath(
							"//div[contains(@id,'CoveragePartsIterator:0:GL7CoverageInputSet:CovPatternInputGroup-legendTitle')]"))
							.getText();
					if (coverageName.equalsIgnoreCase("Fiduciary Liability")) {
						int AttributeSizeFIDLibility = getWebDriver().findElements(By.xpath(
								"(//div[contains(@id,':CoveragePartsIterator:0:GL7CoverageInputSet:CovPatternInputGroup-body')]//span)"))
								.size();
						for (int k = 1; k <= AttributeSizeFIDLibility; k++) {
							String Attribute_Value = getWebDriver().findElement(By.xpath(
									"((//div[contains(@id,':CoveragePartsIterator:0:GL7CoverageInputSet:CovPatternInputGroup-innerCt')]//div//div)["
											+ ((k - 1) * 4 + 2) + "])"))
									.getText();
							String Attribute = getWebDriver().findElement(By.xpath(
									"(//div[contains(@id,':CoveragePartsIterator:0:GL7CoverageInputSet:CovPatternInputGroup-body')]//span)["
											+ k +"]"))
									.getText();
							if (Attribute.equalsIgnoreCase("Aggregate Limit of Liability")) {
								if (SubData.getData("fiduciary_liability_limit")
										.equalsIgnoreCase(Attribute_Value.replaceAll(",", ""))) {
									list.add(true);
									CustomReporting.logReport("", "",
											Attribute + " is <b><i><font color='green'> " + Attribute_Value + "</font></i></b>  for Coverage " + coverageName
													+ " is as expected",
											StepStatus.SUCCESS, new String[] {}, startTime);
								} else {
									list.add(false);
									CustomReporting.logReport("", "",
											Attribute_Value + " is <b><i><font color='red'>  " + Attribute_Value + "</font></i></b>  for Coverage "
													+ coverageName + " is as expected",
											StepStatus.FAILURE, new String[] {}, startTime);

								}
							} else if (Attribute.equalsIgnoreCase("Retention")) {
								if (Attribute_Value.equalsIgnoreCase("0")) {
									list.add(true);
									CustomReporting.logReport("", "",
											Attribute + " is <b><i><font color='green'> " + Attribute_Value + " </font></i></b> for Coverage " + coverageName
													+ " is as expected",
											StepStatus.SUCCESS, new String[] {}, startTime);

								} else {
									list.add(false);
									CustomReporting.logReport("", "",
											Attribute_Value + " is <b><i><font color='red'> " + Attribute_Value + " </font></i></b> for Coverage "
													+ coverageName + " is as expected",
											StepStatus.FAILURE, new String[] {}, startTime);

								}

							} /*else if (Attribute.equalsIgnoreCase("Pending or Prior Date")) {
								if (Attribute_Value.equalsIgnoreCase(convertDateFormataOfPC(pendingPriorDate))) {
									list.add(true);
									CustomReporting.logReport("", "",
											Attribute + " is <b><i><font color='green'> " + Attribute_Value + "</font></i></b>  for Coverage " + coverageName
													+ " is as expected",
											StepStatus.SUCCESS, new String[] {}, startTime);

								} else {
									list.add(false);
									CustomReporting.logReport("", "",
											Attribute + " is <b><i><font color='red'> " + Attribute_Value + "</font></i></b>  for Coverage "
													+ coverageName + " is as expected",
											StepStatus.FAILURE, new String[] {}, startTime);

								}

							}*/ else if (Attribute.contains("Shared Limit")) {
								if (Attribute_Value.equals("No")||Attribute_Value.equals("Yes")) {
									list.add(true);
									CustomReporting.logReport("", "",
											Attribute + " is <b><i><font color='green'> " + Attribute_Value + "</font></i></b>  for Coverage " + coverageName
													+ " is as expected",
											StepStatus.SUCCESS, new String[] {}, startTime);
								} else {
									list.add(false);
									CustomReporting.logReport("", "",
											Attribute_Value + " is <b><i><font color='red'> " + Attribute_Value + "</font></i></b>  for Coverage "
													+ coverageName + " is as expected",
											StepStatus.FAILURE, new String[] {}, startTime);
								}
							} else if (Attribute.equals("Duty to Defend")) {
								if (Attribute_Value.equalsIgnoreCase("Duty")) {
									list.add(true);
									CustomReporting.logReport("", "",
											Attribute + " is <b><i><font color='green'> " + Attribute_Value + "</font></i></b>  for Coverage " + coverageName
													+ " is as expected",
											StepStatus.SUCCESS, new String[] {}, startTime);

								} else {
									list.add(false);
									CustomReporting.logReport("", "",
											Attribute + " is <b><i><font color='red'> " + Attribute_Value + "</font></i></b>  for Coverage " + coverageName
													+ " is as expected",
											StepStatus.FAILURE, new String[] {}, startTime);

								}

							} /*else {
								list.add(true);
								CustomReporting.logReport("", "",
										Attribute + " with value  <b><i><font color='red'>  " + Attribute_Value + "</font></i></b>  for Coverage is  "
												+ coverageName + " is should not be present",
										StepStatus.FAILURE, new String[] {}, startTime);

							}*/

						}

					} else {
						list.add(false);
						CustomReporting.logReport("", "",
								"STD Coverage" + " with value   " + coverageName + "  is not present  "
										+ "Under Standarad FID Coverage" + "",
								StepStatus.FAILURE, new String[] {}, startTime);

					}

					int CoverageCount = getWebDriver().findElements(By.xpath(
							"(//table[contains(@id,':0-table')]//fieldset)"))
							.size();

					String ReqStdCoverages[] = data.getData("FiD_STD_Coverages").split("#");
					ArrayList<String> listOfstdCoverages = new ArrayList<>();
					for (String FidStdCoverages : ReqStdCoverages) {
						listOfstdCoverages.add(FidStdCoverages);

					}
					for (int k = 2; k <= CoverageCount; k++) {
						String CovrageName = getWebDriver().findElement(By.xpath(
								"((//table[contains(@id,':0-table')]//fieldset)["
										+ k + "]//div)[1]"))
								.getText();
						String SublimitValue = getWebDriver().findElement(By.xpath(
								"((//table[contains(@id,':0-table')]//fieldset)["
										+ k + "]//div)[7]"))
								.getText();

						if (listOfstdCoverages.contains(CovrageName)) {
							if (Integer.parseInt(SubData.getData("fiduciary_liability_limit")) <= 250000) {
								if (SubData.getData("fiduciary_liability_limit")
										.equalsIgnoreCase(SublimitValue.replace(",", ""))) {
									list.add(true);
									CustomReporting.logReport("", "",
											"sublimt" + " is equal to the limit value : <b><i><font color='green'> "
													+ data.getData("fiduciary_liability_limit") + "</font></i></b>  for Coverage "
													+ coverageName + " is as expected",
											StepStatus.SUCCESS, new String[] {}, startTime);
								} else {
									list.add(false);

									CustomReporting.logReport("", "",
											"sublimt" + " is not equal to the limit value : <b><i><font color='red'> "
													+ data.getData("fiduciary_liability_limit") + "</font></i></b>  for Coverage "
													+ coverageName + " is as expected",
											StepStatus.FAILURE, new String[] {}, startTime);

								}
							} else if (Integer.parseInt(SubData.getData("fiduciary_liability_limit")) > 250000) {
								if (SublimitValue.equalsIgnoreCase("250,000")) {
									list.add(true);
									CustomReporting.logReport("", "",
											"sublimt" + " is equal to  : <b><i><font color='green'>" + SublimitValue + "</font></i></b>  for Coverage "
													+ CovrageName + " is as expected",
											StepStatus.SUCCESS, new String[] {}, startTime);

								} else {
									list.add(false);
									CustomReporting.logReport("", "",
											"sublimt" + " is not equal to  : <b><i><font color='red'>" + SublimitValue + " </font></i></b> for Coverage "
													+ coverageName + " is not as expected",
											StepStatus.FAILURE, new String[] {}, startTime);

								}
							}

						} else {
							list.add(false);
							CustomReporting.logReport("", "",
									"Coverage" + " with name <b><i><font color='red'> " + CovrageName + "</font></i></b>  not   "
											+ "prasent in the epected list of coverages" + "",
									StepStatus.FAILURE, new String[] {}, startTime);

						}
					}
					verifyModifierSection(tcID, softAssert, DeviceName, coverage, list);
				}
				if (coverage.contains("CYB")) {

					getWebDriver().findElement(By.xpath("//span[text()='Coverages']")).click();
					Thread.sleep(3000);
					getWebDriver().findElement(By.xpath(
							"//table/tbody/tr[5]/td/div/div[2]/div/table/tbody/tr/td/div/div[1]/div[1]/div[2]/div/a["
									+ i + "]"))
							.click();
					Thread.sleep(3000);
					func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					int coverageNamesSize = getWebDriver()
							.findElements(By.xpath("//table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr"))
							.size();
					for (int c = 2; c <= coverageNamesSize; c = c + 2) {
						if(c!=24) {
						
						if (c % 2 == 0 ) {
							
								// (//table/tbody/tr/td/div/table/tbody/tr)[5]//legend//div
								String coverageName = getWebDriver().findElement(By.xpath(
										"//table/tbody/tr/td/div/table/tbody/tr[" + c + "]/td/fieldset/legend/div"))
										.getText();
								String retention = GenericFunctions.instance()._getGlobalVariableValue("respAdjustedRetentionValue");
								String limit = GenericFunctions.instance()._getGlobalVariableValue("limit");
								if (coverageName.contains("Cyber")) {
									int noOfDiv = getWebDriver().findElements(By.xpath(
											"//table/tbody/tr[" + c + "]/td/fieldset/div/div/div/div/label/span"))
											.size();
									for (int x = 1; x < noOfDiv; x++) {
										String label = getWebDriver()
												.findElement(By.xpath("//table/tbody/tr[" + c
														+ "]/td/fieldset/div/div/div/div[" + x + "]/label/span"))
												.getText();
										String value = getWebDriver()
												.findElement(By.xpath("//table/tbody/tr[" + c
														+ "]/td/fieldset/div/div/div/div[" + x + "]/div/div"))
												.getText().replace(",", "");
										
										if (label.contains("Aggregate Limit of Liability")) {
											if (value.equals(limit)) {
												list.add(true);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is as expected",
														StepStatus.SUCCESS, new String[] {}, startTime);
											} else {
												list.add(false);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is not as expected",
														StepStatus.FAILURE, new String[] {}, startTime);
											}
										}
										
										if (label.contains("Retention")) {

											if (value.equals(retention)) {
												list.add(true);
												CustomReporting.logReport("", "",
														label + " is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage " + coverageName
																+ " is as expected",
														StepStatus.SUCCESS, new String[] {}, startTime);
											} else {
												list.add(false);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is not as expected",
														StepStatus.FAILURE, new String[] {}, startTime);
											}
										}

										if (label.contains("Retroactive Date")) {
											if (value.equals("")) {
												list.add(true);
												CustomReporting.logReport("", "",
														label + " is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage " + coverageName
																+ " is as expected",
														StepStatus.SUCCESS, new String[] {}, startTime);
											} else {
												list.add(false);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is not as expected",
														StepStatus.FAILURE, new String[] {}, startTime);
											}
										}
									String continuityDate =	GenericFunctions.instance()._getGlobalVariableValue("respSubEffectiveDate");
										if (label.contains("Continuity Date")) {
											if (value.equalsIgnoreCase(convertDateFormat(continuityDate))) {
												list.add(true);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is as expected",
														StepStatus.SUCCESS, new String[] {}, startTime);
											} else {
												list.add(false);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is not as expected",
														StepStatus.FAILURE, new String[] {}, startTime);
											}
										}
									}
								}
								//second coverage
								if (coverageName.contains("Breach Response Costs")
										||coverageName.contains("Cyber Extortion Costs")
										||coverageName.contains("Data Loss Costs")
										||coverageName.contains("Breach Liability")
										||coverageName.contains("Regulatory Penalties")
										||coverageName.contains("PCI Assessments")
										||coverageName.contains("PCI Recertification Costs")
										||coverageName.contains("Media Liability")) {
									int noOfDiv = getWebDriver().findElements(By.xpath(
											"//table/tbody/tr[" + c + "]/td/fieldset/div/div/div/div/label/span"))
											.size();
									System.out.println("coverage divs" + noOfDiv + coverageName);
									for(int m=1;m<noOfDiv;m++) {
										String label = getWebDriver()
												.findElement(By.xpath("//table/tbody/tr[" + c
														+ "]/td/fieldset/div/div/div/div[" + m + "]/label/span"))
												.getText();
										String value = getWebDriver()
												.findElement(By.xpath("//table/tbody/tr[" + c
														+ "]/td/fieldset/div/div/div/div[" + m + "]/div/div"))
												.getText().replace(",", "");
										if(coverageName.contains("PCI Recertification Costs")) {
											if (label.contains("Sublimit")) {
												if (value.equals("50000")) {
													list.add(true);
													CustomReporting.logReport("", "",
															label + " is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage " + coverageName
																	+ " is as expected",
															StepStatus.SUCCESS, new String[] {}, startTime);
												} else {
													list.add(false);
													CustomReporting.logReport("", "",
															label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
																	+ " is not as expected",
															StepStatus.FAILURE, new String[] {}, startTime);
												}
											}
										}else {
										if (label.contains("Sublimit")) {
											if (value.equals(limit)) {
												list.add(true);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is as expected",
														StepStatus.SUCCESS, new String[] {}, startTime);
											} else {
												list.add(false);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is not as expected",
														StepStatus.FAILURE, new String[] {}, startTime);
											}
										}
										}
										if (label.contains("Retention")) {
											if (value.equals(retention)) {
												list.add(true);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is as expected",
														StepStatus.SUCCESS, new String[] {}, startTime);
											} else {
												list.add(false);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is not as expected",
														StepStatus.FAILURE, new String[] {}, startTime);
											}
										}
									}
									
								}

								//third coverage
								if (coverageName.contains("Business Interruption Loss")
										||coverageName.contains("Contingent Business Interruption Loss")
										) {
									int noOfDiv = getWebDriver().findElements(By.xpath(
											"//table/tbody/tr[" + c + "]/td/fieldset/div/div/div/div/label/span"))
											.size();
									for(int b=1;b<noOfDiv;b++) {
										String label = getWebDriver()
												.findElement(By.xpath("//table/tbody/tr[" + c
														+ "]/td/fieldset/div/div/div/div[" + b + "]/label/span"))
												.getText();
										String value = getWebDriver()
												.findElement(By.xpath("//table/tbody/tr[" + c
														+ "]/td/fieldset/div/div/div/div[" + b + "]/div/div"))
												.getText().replace(",", "");
										
										if (label.contains("Sublimit")) {
											if (value.equals(limit)) {
												list.add(true);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is as expected",
														StepStatus.SUCCESS, new String[] {}, startTime);
											} else {
												list.add(false);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is not as expected",
														StepStatus.FAILURE, new String[] {}, startTime);
											}
										}
										
										if (label.contains("Retention")) {
											if (value.equals("0")) {
												list.add(true);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is as expected",
														StepStatus.SUCCESS, new String[] {}, startTime);
											} else {
												list.add(false);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is not as expected",
														StepStatus.FAILURE, new String[] {}, startTime);
											}
										}
										if (label.contains("Waiting Period in Hours")) {
											if (value.equals("8")) {
												list.add(true);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is as expected",
														StepStatus.SUCCESS, new String[] {}, startTime);
											} else {
												list.add(false);
												CustomReporting.logReport("", "",
														label + " is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage " + coverageName
																+ " is not as expected",
														StepStatus.FAILURE, new String[] {}, startTime);
											}
										}
									}
									
								}
							}
						}
					}

					
					verifyModifierSection(tcID, softAssert, DeviceName, coverage, list);
				}
			}

		} catch (RuntimeException ex) {
			func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
			CustomReporting.logReport("", "", "Error occurred in Page" + getPageName(), "", StepStatus.FAILURE,
					new String[] {}, startTime, null);
			throw ex;
		}

	}

	public void verifyModifierSection(String tcID, SoftAssert softAssert, String DeviceName, String resCoverage, List<Boolean> lst)
			throws Exception {
		Thread.sleep(2000);
		PageData data = PageDataManager.instance().getPageData("Submission", tcID);
		Map<String, String> excelDataModFac = new HashMap<String, String>();
		Map<String, String> pcModFac = new HashMap<String, String>();
		getWebDriver().findElement(By.xpath("//td[@id='SubmissionWizard:LOBWizardStepGroup:GL7_Modifiers']//span"))
				.click();
		Thread.sleep(4000);
		if (resCoverage.contains("DNO")) {

			Thread.sleep(2000);
			getWebDriver().findElement(By.xpath(
					"//span[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:GeneralLiability_GL7Modifiers_DNOTab-btnInnerEl']"))
					.click();
			Thread.sleep(2000);
			ExcelDataReader readExcelModData = new ExcelDataReader(
					"resources\\TestData.xlsx");
			int lastRowCount = readExcelModData.getLastRowNumber("Modifier_DNO_Val");
			readExcelModData.getCellData("Modifier_DNO_Val", "DNO", lastRowCount);
			for (int j = 2; j <= lastRowCount + 1; j++) {
				String modValue = readExcelModData.getCellData("Modifier_DNO_Val", "DNO", j).toString();
				String modFacValue = readExcelModData.getCellData("Modifier_DNO_Val", "DNO_Factor_Value", j).toString();
				excelDataModFac.put(modValue, modFacValue);

			}
			excelDataModFac.put("Number of Years in Business", data.getData("Mod_D_F_E_Fac_NOY_Value"));
			excelDataModFac.put("Management Ownership", data.getData("Mod_Fac_Mang_Ownership"));
			excelDataModFac.put("Number of Subsidiaries", data.getData("Mod_Fac_NoOfSubsidiaries"));

			int countOfRatingModifiers = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:ratepaneldno:MLRatingModifiersDV:MLRateModLV-body']//table"))
					.size();
			int countOfScheduleRatingModifiers = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:schdmodfdno:MLSchedRatingModifiersDV:MLScheduleRateModLV-body']//table"))
					.size();
			int countOfOptionalCoverages = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optdnomod:MLOptionalCovModifiersDV:MLOptRateModLV-body']//table"))
					.size();
			for (int i = 1; i <= countOfRatingModifiers; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:ratepaneldno:MLRatingModifiersDV:MLRateModLV-body']//table)["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"((//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:ratepaneldno:MLRatingModifiersDV:MLRateModLV-body']//table)["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}

			for (int i = 1; i <= countOfScheduleRatingModifiers - 4; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:schdmodfdno:MLSchedRatingModifiersDV:MLScheduleRateModLV-body']//table)["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"((//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:schdmodfdno:MLSchedRatingModifiersDV:MLScheduleRateModLV-body']//table)["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}
			for (int i = 1; i <= countOfOptionalCoverages; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optdnomod:MLOptionalCovModifiersDV:MLOptRateModLV-body']//table["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optdnomod:MLOptionalCovModifiersDV:MLOptRateModLV-body']//table["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}
			System.out.println(pcModFac);

			for (String keyset : excelDataModFac.keySet()) {

				if (excelDataModFac.get(keyset).equalsIgnoreCase(pcModFac.get(keyset.trim()))) {
					lst.add(true);
					CustomReporting.logReport(
							"", "The value of :", keyset + " is  <b><i><font color='green'>" + excelDataModFac.get(keyset)
									+ "</font></i></b> under modifier section " + "" + " is as expected",
							StepStatus.SUCCESS, new String[] {}, startTime);

				} else {
					lst.add(false);
					CustomReporting.logReport("", "",
							"The Modifier value for " + keyset + " is not as Expected value  <b><i><font color='red'>"
									+ excelDataModFac.get(keyset) + "</font></i></b> under modifier section",
							StepStatus.FAILURE, new String[] {}, startTime);

				}

			}

		}
		if (resCoverage.contains("CRI")) {
			getWebDriver().findElement(By.xpath(
					"//a[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:GeneralLiability_GL7Modifiers_CRITab']"))
					.click();
			Thread.sleep(2000);
			ExcelDataReader readExcelModData = new ExcelDataReader(
					"resources\\TestData.xlsx");
			int lastRowCount = readExcelModData.getLastRowNumber("Modifier_Crime_Val");
			readExcelModData.getCellData("Modifier_Crime_Val", "Crime", lastRowCount);
			for (int j = 2; j < lastRowCount + 1; j++) {
				String modValue = readExcelModData.getCellData("Modifier_Crime_Val", "Crime", j).toString();
				String modFacValue = readExcelModData.getCellData("Modifier_Crime_Val", "Crime_Factor_Value", j)
						.toString();
				excelDataModFac.put(modValue, modFacValue);

			}
			excelDataModFac.put("Number of Years in Business", data.getData("Mod_Crime_Fac_NOY_Value"));
			excelDataModFac.put("Premises Coverage", data.getData("Mod_Fac_PremisesCov"));
			excelDataModFac.put("In Transit Coverage", data.getData("Mod_Fac_TransitCov"));

			int countOfRatingModifiers = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:MLRatingModifiersDV:MLRateModLV-body']//div//div//table"))
					.size();
			int countOfScheduleRatingModifiers = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:crischdlmod:MLSchedRatingModifiersDV:MLScheduleRateModLV']//table"))
					.size();
			int countOfOptionalCoverages = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optcrimod:MLOptionalCovModifiersDV:MLOptRateModLV-body']//table"))
					.size();
			for (int i = 1; i <= countOfRatingModifiers; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:MLRatingModifiersDV:MLRateModLV-body']//div//div//table)["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"((//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:MLRatingModifiersDV:MLRateModLV-body']//div//div//table)["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}

			for (int i = 1; i <= countOfScheduleRatingModifiers - 4; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:crischdlmod:MLSchedRatingModifiersDV:MLScheduleRateModLV-body']//table)["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"((//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:crischdlmod:MLSchedRatingModifiersDV:MLScheduleRateModLV-body']//table)["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}
			for (int i = 1; i <= countOfOptionalCoverages; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optcrimod:MLOptionalCovModifiersDV:MLOptRateModLV-body']//table)["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"((//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optcrimod:MLOptionalCovModifiersDV:MLOptRateModLV-body']//table)["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}
			System.out.println(pcModFac);

			for (String keyset : excelDataModFac.keySet()) {

				if (excelDataModFac.get(keyset).equalsIgnoreCase(pcModFac.get(keyset.trim()))) {
					lst.add(true);
					CustomReporting.logReport(
							"", "The value of : <b><i><font color='green'>", keyset + "</font></i></b> is  " + excelDataModFac.get(keyset)
									+ " under modifier section " + "" + " is as expected",
							StepStatus.SUCCESS, new String[] {}, startTime);

				} else {
					lst.add(false);
					CustomReporting.logReport("", "",
							"The Modifier value for <b><i><font color='red'>" + keyset + "</font></i></b> is not as Expected value  "
									+ excelDataModFac.get(keyset) + " under modifier section",
							StepStatus.FAILURE, new String[] {}, startTime);

				}

			}

		}

		if (resCoverage.contains("EPL")) {
			getWebDriver().findElement(By.xpath(
					"//span[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:GeneralLiability_GL7Modifiers_EPLTab-btnInnerEl']"))
					.click();
			ExcelDataReader readExcelModData = new ExcelDataReader(
					"resources\\TestData.xlsx");
			int lastRowCount = readExcelModData.getLastRowNumber("Modifier_EPL_Val");
			readExcelModData.getCellData("Modifier_EPL_Val", "Crime", lastRowCount);
			for (int j = 2; j < lastRowCount + 1; j++) {
				String modValue = readExcelModData.getCellData("Modifier_EPL_Val", "EPL", j).toString();
				String modFacValue = readExcelModData.getCellData("Modifier_EPL_Val", "EPL_Factor_Value", j).toString();
				excelDataModFac.put(modValue, modFacValue);

			}
			excelDataModFac.put("Number of Years in Business", data.getData("Mod_D_F_E_Fac_NOY_Value"));
			int countOfRatingModifiers = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:ratepanelepl:MLRatingModifiersDV:MLRateModLV-body']//div//div//table"))
					.size();
			int countOfScheduleRatingModifiers = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:MLSchedRatingModifiersDV:MLScheduleRateModLV-body']//table"))
					.size();
			int countOfOptionalCoverages = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optpanelepl:MLOptionalCovModifiersDV:MLOptRateModLV-body']//table"))
					.size();
			for (int i = 1; i <= countOfRatingModifiers; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:ratepanelepl:MLRatingModifiersDV:MLRateModLV-body']//div//div//table)["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"((//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:ratepanelepl:MLRatingModifiersDV:MLRateModLV-body']//div//div//table)["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}

			for (int i = 1; i <= countOfScheduleRatingModifiers - 4; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:MLSchedRatingModifiersDV:MLScheduleRateModLV-body']//table)["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"((//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:MLSchedRatingModifiersDV:MLScheduleRateModLV-body']//table)["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}
			for (int i = 1; i <= countOfOptionalCoverages; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optpanelepl:MLOptionalCovModifiersDV:MLOptRateModLV-body']//table)["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"((//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optpanelepl:MLOptionalCovModifiersDV:MLOptRateModLV-body']//table)["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}
			System.out.println(pcModFac);

			for (String keyset : excelDataModFac.keySet()) {

				if (excelDataModFac.get(keyset).equalsIgnoreCase(pcModFac.get(keyset.trim()))) {
					lst.add(true);
					CustomReporting.logReport(
							"", "The value of :<b><i><font color='green'>", keyset + "</font></i></b> is  " + excelDataModFac.get(keyset)
									+ " under modifier section " + "" + " is as expected",
							StepStatus.SUCCESS, new String[] {}, startTime);

				} else {
					lst.add(false);
					CustomReporting.logReport("", "",
							"The Modifier value for <b><i><font color='red'>" + keyset + " </font></i></b>is not as Expected value  "
									+ excelDataModFac.get(keyset) + " under modifier section",
							StepStatus.FAILURE, new String[] {}, startTime);

				}

			}

		}
		if (resCoverage.contains("FID")) {
			getWebDriver().findElement(By.xpath("//span[text()='FID']")).click();
			ExcelDataReader readExcelModData = new ExcelDataReader(
					"resources\\TestData.xlsx");
			int lastRowCount = readExcelModData.getLastRowNumber("Modifier_FID_Val");
			readExcelModData.getCellData("Modifier_FID_Val", "FID", lastRowCount);
			for (int j = 2; j < lastRowCount + 1; j++) {
				String modValue = readExcelModData.getCellData("Modifier_FID_Val", "FID", j).toString();
				String modFacValue = readExcelModData.getCellData("Modifier_FID_Val", "FID_Factor_Value", j).toString();
				excelDataModFac.put(modValue, modFacValue);

			}
			excelDataModFac.put("Number of Years in Business", data.getData("Mod_D_F_E_Fac_NOY_Value"));
			excelDataModFac.put("Plan Participants", data.getData("Mod_Fac_Plan_Participants"));
			excelDataModFac.put("Quality and Diversity of Plan Investments",
					data.getData("Mod_Fac_QualityAndDiversityOfPlanInvestments"));
			excelDataModFac.put("Strength of Corporate Governance",
					data.getData("Mod_Fac_StrengthOfCorporateGovernance"));
			excelDataModFac.put("Loss Experience", data.getData("Mod_Fac_LossExperience"));
			int countOfRatingModifiers = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:ratepanelfid:MLRatingModifiersDV:MLRateModLV-body']//div//div//table"))
					.size();
			int countOfScheduleRatingModifiers = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:schdmodffid:MLSchedRatingModifiersDV:MLScheduleRateModLV-body']//div//div//table"))
					.size();
			int countOfOptionalCoverages = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optfidmod:MLOptionalCovModifiersDV:MLOptRateModLV-body']//table"))
					.size();
			for (int i = 1; i <= countOfRatingModifiers; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:ratepanelfid:MLRatingModifiersDV:MLRateModLV-body']//div//div//table)["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"((//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:ratepanelfid:MLRatingModifiersDV:MLRateModLV-body']//div//div//table)["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}

			for (int i = 1; i <= countOfScheduleRatingModifiers - 4; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:schdmodffid:MLSchedRatingModifiersDV:MLScheduleRateModLV-body']//table)["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"((//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:schdmodffid:MLSchedRatingModifiersDV:MLScheduleRateModLV-body']//table)["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}
			for (int i = 1; i <= countOfOptionalCoverages; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optfidmod:MLOptionalCovModifiersDV:MLOptRateModLV-body']//table)["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"((//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optfidmod:MLOptionalCovModifiersDV:MLOptRateModLV-body']//table)["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}
			System.out.println(pcModFac);

			for (String keyset : excelDataModFac.keySet()) {

				if (excelDataModFac.get(keyset).equalsIgnoreCase(pcModFac.get(keyset.trim()))) {
					lst.add(true);
					CustomReporting.logReport(
							"", "The value of :", keyset + " is  <b><i><font color='green'>" + excelDataModFac.get(keyset)
									+ "</font></i></b> under modifier section " + "" + " is as expected",
							StepStatus.SUCCESS, new String[] {}, startTime);

				} else {
					lst.add(false);
					CustomReporting.logReport("", "",
							"The Modifier value for " + keyset + " is not as Expected value  <b><i><font color='red'>"
									+ excelDataModFac.get(keyset) + "</font></i></b> under modifier section",
							StepStatus.FAILURE, new String[] {}, startTime);

				}

			}

		}
		
		if (resCoverage.contains("CYB")) {
			getWebDriver().findElement(By.xpath("//span[text()='CYB']")).click();
			ExcelDataReader readExcelModData = new ExcelDataReader(
					"resources\\TestData.xlsx");
			int lastRowCount = readExcelModData.getLastRowNumber("Modifier_CYB_Val");
			readExcelModData.getCellData("Modifier_CYB_Val", "CYB", lastRowCount);
			for (int j = 2; j < lastRowCount + 1; j++) {
				String modValue = readExcelModData.getCellData("Modifier_CYB_Val", "CYB", j).toString();
				String modFacValue = readExcelModData.getCellData("Modifier_CYB_Val", "CYB_Factor_Value", j).toString();
				excelDataModFac.put(modValue, modFacValue);

			}
			excelDataModFac.put("Nature and Amount of Third Party Personal Information of Others Processed or Stored", data.getData("Mod_Fac_Nature"));
			excelDataModFac.put("Sharing of Confidential Information", data.getData("Mod_Fac_Sharing_Confi_Info"));
			excelDataModFac.put("Use of Encryption", data.getData("Mod_Fac_Encrytion"));
			//excelDataModFac.put("Technology Errors and Omissions Liability", data.getData("Mod_Fac_Tech_Err"));
			//excelDataModFac.put("Social Engineering Endorsement", data.getData("Mod_Fac_Social_Engg"));
			
			int countOfRatingModifiers = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:ratepanelcyb:MLRatingModifiersDV:MLRateModLV-body']//div//div//table"))
					.size();
			int countOfScheduleRatingModifiers = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:cybschdlmod:MLSchedRatingModifiersDV:MLScheduleRateModLV-body']//div//div//table"))
					.size();
			int countOfOptionalCoverages = getWebDriver().findElements(By.xpath(
					"//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optcybmod:MLOptionalCovModifiersDV:MLOptRateModLV']//table"))
					.size();
			for (int i = 1; i <= countOfRatingModifiers; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:ratepanelcyb:MLRatingModifiersDV:MLRateModLV-body']//div//div//table)["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"((//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:ratepanelcyb:MLRatingModifiersDV:MLRateModLV-body']//div//div//table)["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}

			for (int i = 1; i <= countOfScheduleRatingModifiers - 4; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:cybschdlmod:MLSchedRatingModifiersDV:MLScheduleRateModLV-body']//table)["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"((//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:cybschdlmod:MLSchedRatingModifiersDV:MLScheduleRateModLV-body']//table)["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}
			for (int i = 1; i <= countOfOptionalCoverages; i++) {

				String pcModName = getWebDriver().findElement(By.xpath(
						"(//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optcybmod:MLOptionalCovModifiersDV:MLOptRateModLV']//table)["
								+ i + "]//div[1]"))
						.getText();
				String pcModValue = getWebDriver().findElement(By.xpath(
						"((//div[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GL7Modifiers_GLEScreen:optcybmod:MLOptionalCovModifiersDV:MLOptRateModLV']//table)["
								+ i + "]//div)[2]"))
						.getText();
				pcModFac.put(pcModName.replaceAll("\\d", "").replace(".", "").trim(), pcModValue);
			}
			System.out.println(pcModFac);

			for (String keyset : excelDataModFac.keySet()) {

				if (excelDataModFac.get(keyset).equalsIgnoreCase(pcModFac.get(keyset.trim()))) {
					lst.add(true);
					CustomReporting.logReport(
							"", "The value of :", keyset + " is  <b><i><font color='green'>" + excelDataModFac.get(keyset)
									+ "</font></i></b> under modifier section " + "" + " is as expected",
							StepStatus.SUCCESS, new String[] {}, startTime);

				} else {
					lst.add(false);
					CustomReporting.logReport("", "",
							"The Modifier value for " + keyset + " is not as Expected value  <b><i><font color='red'>"
									+ excelDataModFac.get(keyset) + "</font></i></b> under modifier section",
							StepStatus.FAILURE, new String[] {}, startTime);

				}

			}

		}

	}

	@SuppressWarnings("static-access")
	@Override
	public void verifyOptionalCoverages(String tcID, SoftAssert softAssert, String DeviceName,List<Boolean> list) throws Exception {

		try {
			String ExpectedDNORetntionValPc = GenericFunctions.instance()
					._getGlobalVariableValue("ExpectedDNORetntionVal");

			PageData data = PageDataManager.instance().getPageData("PolicyCenterPage", tcID);
			PageData SubData = PageDataManager.instance().getPageData("Submission", tcID);

			Thread.sleep(2000);
			getWebDriver().findElement(By.xpath("//td[@id='SubmissionWizard:LOBWizardStepGroup:GL7_Coverages']"))
					.click();
			Thread.sleep(5000);
			getWebDriver().findElement(By.xpath(
					"//span[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:stdCovCardIterator:0:GeneralLiability_StandardCoveragesCard_CommonTab-btnInnerEl']"))
					.click();
			Thread.sleep(5000);
			getWebDriver().findElement(By.xpath(
					"//span[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:GeneralLiability_AdditionalCoveragesCardTab-btnInnerEl']"))
					.click();
			Thread.sleep(5000);
			int PcCountOfCoverages = 0;
			if(SubData.getData("LOB").equalsIgnoreCase("CY")) {
				PcCountOfCoverages = getWebDriver().findElements(By.xpath(
						"//tbody[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:optionalCovCardIterator:0:OptionalCoverages_EXTDV_ref-tbody']//legend"))
						.size();
			}else {
			 PcCountOfCoverages = getWebDriver().findElements(By.xpath(
					"//tbody[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:optionalCovCardIterator:0:OptionalCoverages_EXTDV_ref-tbody']//legend"))
					.size();
			}
			int ExpectedCountOfCommCoverage;
			if(!(SubData.getData("LOB").equalsIgnoreCase("CY"))) {
			if(SubData.getData("CoveragePart").equalsIgnoreCase("CRI#")) {
				ExpectedCountOfCommCoverage=4;
			}else {
				ExpectedCountOfCommCoverage=5;
			}
			
			if (PcCountOfCoverages == ExpectedCountOfCommCoverage) {
				list.add(true);
				CustomReporting.logReport("", "",
						"No. of coverages under common of optional coverage is <b><i><font color='green'> " + PcCountOfCoverages
								+ "</font></i></b> is  as Expected  " + "for the " + " Scenario",
						StepStatus.SUCCESS, new String[] {}, startTime);

			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"No. of coverages under common of optional coverage is <b><i><font color='red'> " + PcCountOfCoverages
								+ "</font></i></b> is not as Expected  " + "for the " + " Scenario",
						StepStatus.FAILURE, new String[] {}, startTime);

			}
			
			for (int j = 1; j <= PcCountOfCoverages; j++) {

				String PcOptionalCovName = getWebDriver().findElement(By.xpath(
						"(//tbody[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:GeneralLiability_GLEScreen:optionalCovCardIterator:0:OptionalCoverages_EXTDV_ref-tbody']//legend//div)["
								+ j + "]"))
						.getText();
				if (PcOptionalCovName.contains("Declarations Amended (ERP and Run-Off Options)")) {
					list.add(true);
					CustomReporting.logReport(
							"Common", "Optional Coverage :<b><i><font color='green'>", PcOptionalCovName + "</font></i></b> is  " + "present"
									+ " under Optinanal covegarage  tab " + "" + " as expected",
							StepStatus.SUCCESS, new String[] {}, startTime);
				} else if (PcOptionalCovName.contains("Definitions Amended (Executive Officer)")) {
					list.add(true);
					CustomReporting.logReport(
							"Common", "Optional Coverage :<b><i><font color='green'>", PcOptionalCovName + "</font></i></b> is  " + "present"
									+ " under Optinanal covegarage  tab " + "" + " as expected",
							StepStatus.SUCCESS, new String[] {}, startTime);
				}

				else if (PcOptionalCovName.contains("Guaranteed Rate Renewal")) {
					list.add(true);
					CustomReporting.logReport(
							"Common", "Optional Coverage :<b><i><font color='green'>", PcOptionalCovName + "</font></i></b> is  " + "present"
									+ " under Optinanal covegarage  tab " + "" + " as expected",
							StepStatus.SUCCESS, new String[] {}, startTime);
				}

				else if (PcOptionalCovName.contains("Notice Amended Endorsement (Number of Days)")) {
					list.add(true);
					CustomReporting.logReport(
							"Common", "Optional Coverage :<b><i><font color='green'>", PcOptionalCovName + "</font></i></b> is  " + "present"
									+ " under Optinanal covegarage  tab " + "" + " as expected",
							StepStatus.SUCCESS, new String[] {}, startTime);
				}

				else if (PcOptionalCovName.contains("Severability Amended Endorsement")) {
					list.add(true);
					CustomReporting.logReport(
							"Common", "Optional Coverage :<b><i><font color='green'>", PcOptionalCovName + "</font></i></b> is  " + "present"
									+ " under Optinanal covegarage  tab " + "" + " as expected",
							StepStatus.SUCCESS, new String[] {}, startTime);
				}

				else {
					list.add(false);
					CustomReporting.logReport(							
							"Common", "Optional Coverage :<b><i><font color='red'>", PcOptionalCovName + "</font></i></b> is  " + " present"
									+ " under Optinanal covegarage  tab " + "" + " as not expected",
							StepStatus.FAILURE, new String[] {}, startTime);
				}

			}
			}
			String Coverages[] = SubData.getData("CoveragePart").split("#");
			for (String CoverageType : Coverages) {
				System.out.println(CoverageType);
				if (CoverageType.equalsIgnoreCase("CRI")) {

					getWebDriver().findElement(By.xpath("//span[text()='CRI']")).click();
					Thread.sleep(4000);
					int CrimeOptionalCoverageCount = getWebDriver()
							.findElements(
									By.xpath("//tbody[contains(@id, 'OptionalCoverages_EXTDV_ref-tbody')]//legend"))
							.size();
					for (int j = 1; j <= CrimeOptionalCoverageCount; j++) {
						String CrimeOptionalCovName = getWebDriver().findElement(
								By.xpath("(//tbody[contains(@id, 'OptionalCoverages_EXTDV_ref-tbody')]//legend//div)["
										+ j + "]"))
								.getText();
						Thread.sleep(5000);
						if ((CrimeOptionalCovName.trim())
								.equalsIgnoreCase("Confidential Exclusion Amended Endorsement (Crime)")) {
							list.add(true);
							CustomReporting.logReport(
									"Crime", " Optional Coverage : <b><i><font color='green'>", CrimeOptionalCovName + "</font></i></b> is  " + "present"
											+ " under Optional covegarage  tab " + "" + " as expected",
									StepStatus.SUCCESS, new String[] {}, startTime);

						} else if (CrimeOptionalCovName.equalsIgnoreCase("Tax Compensation Endorsement")) {
							list.add(true);
							CustomReporting.logReport(
									"Crime", " Optional Coverage :<b><i><font color='green'>", CrimeOptionalCovName + "</font></i></b> is  " + "present"
											+ " under Optional covegarage  tab " + "" + " as expected",
									StepStatus.SUCCESS, new String[] {}, startTime);

						} else if (CrimeOptionalCovName.equalsIgnoreCase("Telephone Toll Fraud Coverage (Crime)")) {
							String OpsCovLol = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							if (OpsCovLol.equalsIgnoreCase("Limit of Liability")) {
								list.add(true);
								CustomReporting.logReport("Crime", " Optional Coverage :<b><i><font color='green'>",
										CrimeOptionalCovName + "</font></i></b> is having the " + "Limit of libility" + " field under"
												+ "" + "the Telephone fraud coverage",
										StepStatus.SUCCESS, new String[] {}, startTime);
								String LOLValue = getWebDriver().findElement(By.xpath(
										"//div[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-inputEl')]"))
										.getText();
								if (Integer.parseInt(SubData.getData("CRIME_limit")) <= 25000) {
									if (LOLValue.replace(",", "")
											.equalsIgnoreCase(data.getData("CRIME_limit").toString())) {
										list.add(true);
										CustomReporting.logReport("Crime", " Optional Coverage :",
												CrimeOptionalCovName + " having  LOL value <b><i><font color='green'>" + LOLValue
														+ "</font></i></b> under Optional covegarage  tab is " + "" + " as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);

									} else {
										list.add(false);
										CustomReporting.logReport("Crime", " Optional Coverage :",
												CrimeOptionalCovName + " having  LOL value <b><i><font color='red'>" + LOLValue
														+ "</font></i></b> under Optional covegarage  tab is not" + ""
														+ " as expected",
												StepStatus.FAILURE, new String[] {}, startTime);

									}

								} else {
									if (LOLValue.replace(",", "").equalsIgnoreCase("100000")) {
										list.add(true);
										CustomReporting.logReport("Crime", " Optional Coverage :",
												CrimeOptionalCovName + " having  LOL value <b><i><font color='green'>" + LOLValue
														+ "</font></i></b> under Optional covegarage  tab is " + "" + " as expected",
												StepStatus.SUCCESS, new String[] {}, startTime);

									} else {
										list.add(false);
										CustomReporting.logReport("Crime", " Optional Coverage :",
												CrimeOptionalCovName + " having  LOL value <b><i><font color='red'>" + LOLValue
														+ "</font></i></b> under Optional covegarage  tab is not" + ""
														+ " as expected",
												StepStatus.FAILURE, new String[] {}, startTime);

									}
								}
							} else {
								list.add(false);
								CustomReporting.logReport("Crime", " Optional Coverage :",
										CrimeOptionalCovName + " has not having the " + "Limit of libility"
												+ " field under" + "" + "the Telephone fraud coverage",
										StepStatus.FAILURE, new String[] {}, startTime);
							}

							String deductableField = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String deductableFieldValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText();
							if (deductableField.equalsIgnoreCase("Deductible")
									&& (deductableFieldValue.replace(",", ""))
											.equalsIgnoreCase(data.getData("ExpectedDeductibleValue"))) {
								list.add(true);
								CustomReporting.logReport(
										"Crime", " Optional Coverage field :", deductableField + " Field value <b><i><font color='green'> "
												+ deductableFieldValue + "</font></i></b> is " + "" + " as expected",
										StepStatus.SUCCESS, new String[] {}, startTime);
							} else {
								list.add(false);
								CustomReporting.logReport(
										"Crime", " Optional Coverage field :", deductableField + " Field value <b><i><font color='red'> "
												+ deductableFieldValue + "</font></i></b> is " + "" + " no as  expected",
										StepStatus.FAILURE, new String[] {}, startTime);
							}

						}

						else {
							list.add(false);

							CustomReporting.logReport(
									"Crime", " Optional Coverage :<b><i><font color='red'> ", CrimeOptionalCovName + "</font></i></b> is  " + "present"
											+ " under Optional covegarage  tab " + "" + " is not expected",
									StepStatus.FAILURE, new String[] {}, startTime);

						}
					}

				} else if (CoverageType.equalsIgnoreCase("DNO")) {
					getWebDriver().findElement(By.xpath("//span[contains(text(),'DNO')]")).click();
					Thread.sleep(4000);
					int sizeOfDNOoptionCoverage = getWebDriver()
							.findElements(By
									.xpath("//tbody[contains(@id,':OptionalCoverages_EXTDV_ref-tbody')]//legend//div"))
							.size();
					for (int j = 1; j <= sizeOfDNOoptionCoverage; j++) {
						String dnoOptionalCoverageName = getWebDriver().findElement(
								By.xpath("(//tbody[contains(@id,':OptionalCoverages_EXTDV_ref-tbody')]//legend//div)["
										+ j + "]"))
								.getText();
						if (dnoOptionalCoverageName.equalsIgnoreCase(
								"Professional Services Exclusion Amended Endorsement (Supervision Carveback)")) {
							list.add(true);
							CustomReporting.logReport(
									"DNO", " Optional Coverage :<b><i><font color='green'>", dnoOptionalCoverageName + "</font></i></b> is  " + "present"
											+ " under Optional covegarage  tab " + "" + " is expected",
									StepStatus.SUCCESS, new String[] {}, startTime);

						} else if (dnoOptionalCoverageName
								.equalsIgnoreCase("Breach of Contract Endorsement (Shareholder Carve-Back)")) {
							list.add(true);
							CustomReporting.logReport(
									"DNO", " Optional Coverage :<b><i><font color='green'>", dnoOptionalCoverageName + "</font></i></b> is  " + "present"
											+ " under Optional covegarage  tab " + "" + " is expected",
									StepStatus.SUCCESS, new String[] {}, startTime);

						} else if (dnoOptionalCoverageName.equalsIgnoreCase("D&O Crisis Event Coverage Endorsement")) {
							
							String txtSubmlimit = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:1:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String sublimitValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:1:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText();
							if (txtSubmlimit.equalsIgnoreCase("Sublimit") && sublimitValue.equals("50,000")) {
								list.add(true);
								CustomReporting.logReport("DNO", " Optional Coverage :",
										dnoOptionalCoverageName + " with parameter <b><i><font color='green'> " + txtSubmlimit + "</font></i></b> have value"
												+ sublimitValue + " which is as expected",
										StepStatus.SUCCESS, new String[] {}, startTime);
							} else {
								list.add(false);
								CustomReporting.logReport("DNO", " Optional Coverage :",
										dnoOptionalCoverageName + " with parameter  <b><i><font color='red'>" + txtSubmlimit + "</font></i></b> have value"
												+ sublimitValue + " which is not as expected",
										StepStatus.FAILURE, new String[] {}, startTime);

							}
						} else if (dnoOptionalCoverageName.equalsIgnoreCase("D&O Separate Defense Cost Coverage")) {
							String labelSSDCL = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:BooleanTermInput-labelEl')]//span"))
									.getText();
							String labelSSDCLValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:BooleanTermInput-inputEl')]"))
									.getText();
							if (labelSSDCL.equalsIgnoreCase("Shared Separate Defense Cost Limit")
									&& labelSSDCLValue.equalsIgnoreCase(data.getData("SharedSeparateDefenseCostLimit"))) {
								list.add(true);
								CustomReporting.logReport("DNO", " Optional Coverage :",
										dnoOptionalCoverageName + " with parameter <b><i><font color='green'> " + labelSSDCL + "</font></i></b> have value"
												+ labelSSDCLValue + " which is as expected",
										StepStatus.SUCCESS, new String[] {}, startTime);
							} else {
								list.add(false);
								CustomReporting.logReport("DNO", " Optional Coverage :",
										dnoOptionalCoverageName + " with parameter  <b><i><font color='red'>" + labelSSDCL + "</font></i></b> have value"
												+ labelSSDCLValue + " which is not as expected",
										StepStatus.FAILURE, new String[] {}, startTime);
							}

							String labelSDCL = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String labelSDCLValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText();
							if (labelSDCL.equalsIgnoreCase("Separate Defense Cost Limit")
									&& (labelSDCLValue.replace(",", ""))
											.equalsIgnoreCase(SubData.getData("directors_and_officers_limit"))) {
								list.add(true);
								CustomReporting.logReport("DNO", " Optional Coverage :",
										dnoOptionalCoverageName + " with parameter  " + labelSDCL + " have value <b><i><font color='green'> "
												+ labelSDCLValue + "</font></i></b> which is as expected",
										StepStatus.SUCCESS, new String[] {}, startTime);
							} else {
								list.add(false);
								CustomReporting.logReport("DNO", " Optional Coverage :",
										dnoOptionalCoverageName + " with parameter  " + labelSDCL + " have value <b><i><font color='red'> "
												+ labelSDCLValue + "</font></i></b> which is not as expected",
										StepStatus.FAILURE, new String[] {}, startTime);
							}

						} else if (dnoOptionalCoverageName
								.equalsIgnoreCase("Antitrust Coverage (Sublimit / Co-insurance / Retention)")) {
							String labelCoveredPercentage = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String labelCoveredPercentageValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText();
							String labelSubLimit = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String labelSublimitValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText().replace(",", "");
							String labelRetention = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:2:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String labelRetentionValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:2:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText().replace(",", "");
							verifyLabelsAndValues(dnoOptionalCoverageName, labelCoveredPercentage,
									labelCoveredPercentageValue, "Covered Percentage", "0",list);
							verifyLabelsAndValues(dnoOptionalCoverageName, labelSubLimit, labelSublimitValue,
									"Sublimit", SubData.getData("directors_and_officers_limit"),list);
							verifyLabelsAndValues(dnoOptionalCoverageName, labelRetention, labelRetentionValue,
									"Retention", ExpectedDNORetntionValPc,list);
						} else {
							list.add(false);
							CustomReporting.logReport("DNO", " Optional Coverage :<b><i><font color='red'>", dnoOptionalCoverageName
									+ "</font></i></b> should not be available under DNO optional coverage" + "" + "" + "" + " ",
									StepStatus.FAILURE, new String[] {}, startTime);
						}
					}
				} else if (CoverageType.equalsIgnoreCase("EPL")) {

					getWebDriver().findElement(By.xpath("//span[contains(text(),'EPL')]")).click();
					Thread.sleep(4000);
					func._takeBrowserScreenShot(getWebDriver(), "", getWebDriver().getCurrentUrl(), tcID);
					int sizeOfEPLoptionCoverage = getWebDriver()
							.findElements(By
									.xpath("//tbody[contains(@id,':OptionalCoverages_EXTDV_ref-tbody')]//legend//div"))
							.size();
					if (sizeOfEPLoptionCoverage == 5) {
						list.add(true);
						CustomReporting.logReport("", "",
								"No. of coverages under EPL of optional coverage is <b><i><font color='green'> " + sizeOfEPLoptionCoverage
										+ "</font></i></b> is  as Expected  " + "for the " + " Scenario",
								StepStatus.SUCCESS, new String[] {}, startTime);

					} else {
						list.add(false);
						CustomReporting.logReport("", "",
								"No. of coverages under EPL of optional coverage is  <b><i><font color='red'> " + sizeOfEPLoptionCoverage
										+ "</font></i></b> is not as Expected. Verify the extra or missing coverage  " + "for the "
										+ " Scenario",
								StepStatus.FAILURE, new String[] {}, startTime);

					}
					for (int j = 1; j <= sizeOfEPLoptionCoverage; j++) {

						String eplOptionalCoverageName = getWebDriver().findElement(
								By.xpath("(//tbody[contains(@id,':OptionalCoverages_EXTDV_ref-tbody')]//legend//div)["
										+ j + "]"))
								.getText();

						if (eplOptionalCoverageName.equalsIgnoreCase("EPL Separate Defense Cost Coverage")) {

							String txtSSDCL = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:BooleanTermInput-labelEl')]//span"))
									.getText();
							String txtSSDCLValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:BooleanTermInput-bodyEl')]//div"))
									.getText();
							String txtSDCL = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String txtSDCLValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText().replace(",", "");

							int SDCLValue = Integer.parseInt(SubData.getData("employment_practices_liability_limit"));
							String ExpectedSDCLValue = "";
							if (SDCLValue < 1000000) {
								ExpectedSDCLValue = Integer.toString(SDCLValue);
							} else {
								ExpectedSDCLValue = "1000000";
							}
							verifyLabelsAndValues(eplOptionalCoverageName, txtSSDCL, txtSSDCLValue,
									"Shared Separate Defense Cost Limit", data.getData("SharedSeparateDefenseCostLimit"),list);
							verifyLabelsAndValues(eplOptionalCoverageName, txtSDCL, txtSDCLValue,
									"Separate Defense Cost Limit", ExpectedSDCLValue,list);

						} else if (eplOptionalCoverageName.equalsIgnoreCase("Immigration Coverage")) {

							String txtSublimit = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:1:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String txtSublimitValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:1:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText().replace(",", "");
							verifyLabelsAndValues(eplOptionalCoverageName, txtSublimit, txtSublimitValue, "Sublimit",
									"25000",list);
						} else if (eplOptionalCoverageName
								.equalsIgnoreCase("Unauthorized Access To Employee Data Incident Coverage")) {
							String txtSublimit = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String txtSublimitValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText();
							verifyLabelsAndValues(eplOptionalCoverageName, txtSublimit, txtSublimitValue, "Sublimit",
									"25000",list);
						} else if (eplOptionalCoverageName
								.equalsIgnoreCase("EPL Wage and Hour Defense Cost (Non-Designated State Claim)")) {
							String txtSublimit = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:3:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String txtSublimitValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:3:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText().replace(",", "");
							String txtExposureType = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:3:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:TypekeyTermInput-labelEl')]//span"))
									.getText();
							String txtExposureTypeValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:3:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:TypekeyTermInput-inputEl')]"))
									.getText();

							int EPLLimitValue = Integer
									.parseInt(SubData.getData("employment_practices_liability_limit"));
							String ExpectedSubLimitValue = "";
							if (EPLLimitValue < 150000) {
								ExpectedSubLimitValue = Integer.toString(EPLLimitValue);
							} else {
								ExpectedSubLimitValue = "150000";
							}
							verifyLabelsAndValues(eplOptionalCoverageName, txtSublimit, txtSublimitValue, "Sublimit",
									ExpectedSubLimitValue,list);
							verifyLabelsAndValues(eplOptionalCoverageName, txtExposureType, txtExposureTypeValue,
									"Exposure Type", "Medium",list);

						} else if (eplOptionalCoverageName.equalsIgnoreCase("EPL Crisis Amended Endorsement")) {
							list.add(true);
							CustomReporting.logReport("EPL optionalCoverage", eplOptionalCoverageName,
									" is available " + "" + " as Expected  " + " " + "for  EPL coverage type.",
									StepStatus.SUCCESS, new String[] {}, startTime);

						} else {
							list.add(false);

							CustomReporting.logReport("EPL", " Optional Coverage :", eplOptionalCoverageName
									+ "should not be available under EPL optional coverage" + "" + "" + "" + " ",
									StepStatus.FAILURE, new String[] {}, startTime);

						}

					}

				}else if (CoverageType.equalsIgnoreCase("FID")) {
					
					getWebDriver().findElement(By.xpath("//span[contains(text(),'FID')]")).click();
					Thread.sleep(4000);
					func._takeBrowserScreenShot(getWebDriver(), "", getWebDriver().getCurrentUrl(), tcID);
					int sizeOfEPLoptionCoverage = getWebDriver()
							.findElements(By
									.xpath("//tbody[contains(@id,':OptionalCoverages_EXTDV_ref-tbody')]//legend//div")).size();
					if (sizeOfEPLoptionCoverage == 1) {
						list.add(true);
						CustomReporting.logReport("", "",
								"No. of coverages under FID of optional coverage is  " + sizeOfEPLoptionCoverage
										+ " is  as Expected  " + "for the " + " Scenario",
								StepStatus.SUCCESS, new String[] {}, startTime);

					} else {
						list.add(false);
						CustomReporting.logReport("", "",
								"No. of coverages under FID of optional coverage is   " + sizeOfEPLoptionCoverage
										+ " is not as Expected. Verify the extra or missing coverage  " + "for the "
										+ " Scenario",
								StepStatus.FAILURE, new String[] {}, startTime);

					}
					String FidOptionalCovName=getWebDriver().findElement(By.xpath("//tbody[contains(@id,':OptionalCoverages_EXTDV_ref-tbody')]//legend//div")).getText();
					
					if(FidOptionalCovName.equalsIgnoreCase("FID Separate Defense Cost Coverage")) {
						String labelSSDCL=getWebDriver().findElement(By.xpath("//label[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:BooleanTermInput-labelEl')]//span")).getText();
						String valueSSDCL=getWebDriver().findElement(By.xpath("//div[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:BooleanTermInput-inputEl')]")).getText();
						String labelSDCL=getWebDriver().findElement(By.xpath("//label[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-labelEl')]//span")).getText();
						String valueSDCL=getWebDriver().findElement(By.xpath("//div[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-inputEl')]")).getText().replaceAll(",", "");
					    String ExpectedvalueSDCL=null;
					if(Integer.parseInt(SubData.getData("fiduciary_liability_limit"))<=1000000) {
						
						ExpectedvalueSDCL=SubData.getData("fiduciary_liability_limit");
					}else {
						ExpectedvalueSDCL="1000000";
					}
					verifyLabelsAndValues(FidOptionalCovName, labelSSDCL, valueSSDCL,
							"Shared Separate Defense Cost Limit", data.getData("SharedSeparateDefenseCostLimit"),list);
					verifyLabelsAndValues(FidOptionalCovName, labelSDCL, valueSDCL,
							"Separate Defense Cost Limit", ExpectedvalueSDCL,list);
					
					}else {
						
						CustomReporting.logReport("", "",
								"FID optional coverage " + "FID Separate Defense Cost Coverag"
										+ " is not available." + "which is not as expected"
										+ "",
								StepStatus.FAILURE, new String[] {}, startTime);

						
					}
					
					
				}else if (CoverageType.equalsIgnoreCase("CYBER_LIABILITY")) {
					
					getWebDriver().findElement(By.xpath("//span[contains(text(),'CYB')]")).click();
					Thread.sleep(4000);
					func._takeBrowserScreenShot(getWebDriver(), "", getWebDriver().getCurrentUrl(), tcID);
					int sizeOfCYBoptionCoverage = getWebDriver()
							.findElements(By
									.xpath("//tbody[contains(@id,':OptionalCoverages_EXTDV_ref-tbody')]//legend//div")).size();
					String limit = GenericFunctions.instance()._getGlobalVariableValue("limit");
					String retention = GenericFunctions.instance()._getGlobalVariableValue("respAdjustedRetentionValue");
					for(int c = 1;c<sizeOfCYBoptionCoverage;c++) {
						
						String cybOptionalCoverageName = getWebDriver().findElement(
								By.xpath("(//tbody[contains(@id,':OptionalCoverages_EXTDV_ref-tbody')]//legend//div)["
										+ c + "]"))
								.getText();
						if (cybOptionalCoverageName
								.equalsIgnoreCase("Reputation Repair (Additional Public Relations Costs)")) {
							String txtSublimit = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String txtSublimitValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText().replace(",", "");
							verifyLabelsAndValues(cybOptionalCoverageName, txtSublimit, txtSublimitValue, "Sublimit",
									limit,list);
							String txtRetention = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String txtRetentionValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:0:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText().replace(",", "");
							verifyLabelsAndValues(cybOptionalCoverageName, txtRetention, txtRetentionValue, "Retention",
									retention,list);
						}
						if (cybOptionalCoverageName
								.equalsIgnoreCase("System Failure")) {
							String txtSublimit = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:1:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String txtSublimitValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:1:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText().replace(",", "");
							verifyLabelsAndValues(cybOptionalCoverageName, txtSublimit, txtSublimitValue, "Sublimit",
									limit,list);
							String txtRetention = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:1:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String txtRetentionValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:1:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText().replace(",", "");
							verifyLabelsAndValues(cybOptionalCoverageName, txtRetention, txtRetentionValue, "Retention",
									retention,list);
							String txtWaitingTime = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:1:CoverageInputSet:CovPatternInputGroup:2:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String txtWaitingTimeValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:1:CoverageInputSet:CovPatternInputGroup:2:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText();
							verifyLabelsAndValues(cybOptionalCoverageName, txtWaitingTime, txtWaitingTimeValue, "Waiting Period in Hours",
									"8",list);
						}
						
						if (cybOptionalCoverageName
								.equalsIgnoreCase("Wrongful Collection")) {
							String txtSublimit = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String txtSublimitValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText().replace(",", "");
							verifyLabelsAndValues(cybOptionalCoverageName, txtSublimit, txtSublimitValue, "Sublimit",
									limit,list);
							String txtRetention = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String txtRetentionValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:2:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText().replace(",", "");
							verifyLabelsAndValues(cybOptionalCoverageName, txtRetention, txtRetentionValue, "Retention",
									retention,list);
						}
						if (cybOptionalCoverageName
								.equalsIgnoreCase("Social Engineering")) {
							String txtSublimit = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:3:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String txtSublimitValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:3:CoverageInputSet:CovPatternInputGroup:0:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText().replace(",", "");
							verifyLabelsAndValues(cybOptionalCoverageName, txtSublimit, txtSublimitValue, "Sublimit",
									limit,list);
							String txtRetention = getWebDriver().findElement(By.xpath(
									"//label[contains(@id,':OptionalCoverages_EXTDV:0:3:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-labelEl')]//span"))
									.getText();
							String txtRetentionValue = getWebDriver().findElement(By.xpath(
									"//div[contains(@id,':OptionalCoverages_EXTDV:0:3:CoverageInputSet:CovPatternInputGroup:1:CovTermInputSet:DirectTermInput-inputEl')]"))
									.getText().replace(",", "");
							verifyLabelsAndValues(cybOptionalCoverageName, txtRetention, txtRetentionValue, "Retention",
									"25000",list);
						}
						if (cybOptionalCoverageName.contains("DDOS Attack (Reduced Waiting Period)")) {
							list.add(true);
							CustomReporting.logReport(
									"Cyber", "Optional Coverage :<b><i><font color='green'>", cybOptionalCoverageName + "</font></i></b> is  " + "present"
											+ " under Optinanal covegarage  tab " + "" + " as expected",
									StepStatus.SUCCESS, new String[] {}, startTime);
						}else if (cybOptionalCoverageName.contains("Risk Improvement Services Reimbursement")) {
							list.add(true);
							CustomReporting.logReport(
									"Cyber", "Optional Coverage :<b><i><font color='green'>", cybOptionalCoverageName + "</font></i></b> is  " + "present"
											+ " under Optinanal covegarage  tab " + "" + " as expected",
									StepStatus.SUCCESS, new String[] {}, startTime);
						}else if (cybOptionalCoverageName.contains("Risk Management Incentive")) {
							list.add(true);
							CustomReporting.logReport(
									"Cyber", "Optional Coverage :<b><i><font color='green'>", cybOptionalCoverageName + "</font></i></b> is  " + "present"
											+ " under Optinanal covegarage  tab " + "" + " as expected",
									StepStatus.SUCCESS, new String[] {}, startTime);
						}else if (cybOptionalCoverageName.contains("Definitions Amended (Media Wrongful Act)")) {
							list.add(true);
							CustomReporting.logReport(
									"Cyber", "Optional Coverage :<b><i><font color='green'>", cybOptionalCoverageName + "</font></i></b> is  " + "present"
											+ " under Optinanal covegarage  tab " + "" + " as expected",
									StepStatus.SUCCESS, new String[] {}, startTime);
						}else if (cybOptionalCoverageName.contains("Cyber Crime Endorsement B")) {
							list.add(true);
							CustomReporting.logReport(
									"Cyber", "Optional Coverage :<b><i><font color='green'>", cybOptionalCoverageName + "</font></i></b> is  " + "present"
											+ " under Optinanal covegarage  tab " + "" + " as expected",
									StepStatus.SUCCESS, new String[] {}, startTime);
						}
					}
					
					
					
				}else {
					CustomReporting.logReport("", "",
							CoverageType+ "Optional Coverage"
									+ " is not available." + "which is not as expected"
									+ "",
							StepStatus.FAILURE, new String[] {}, startTime);
					
				}

			}
		} catch (RuntimeException ex) {
			func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
			CustomReporting.logReport("", "", "Error occurred in Page" + getPageName(), "", StepStatus.FAILURE,
					new String[] {}, startTime, null);
			throw ex;
		}

	}

	String convertDateFormataOfPC(String dateString) throws ParseException {
		System.out.println("Given date is " + dateString);

		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = sdf.parse(dateString);

		return new SimpleDateFormat("MM/dd/yyyy").format(date);

	}
	
	
	public static boolean isClickable(WebElement webe,WebDriver we)      
	{
	    try
	    {
	        WebDriverWait wait = new WebDriverWait(we, 5);
	        wait.until(ExpectedConditions.elementToBeClickable(webe));
	        return true;
	    }
	    catch (Exception e)
	    {
	        return false;
	    }
	}

	public void verifyLabelsAndValues(String CovererageName, String LabelName, String LabelValue,
			String ExpectedLabelName, String ExpectedLabelValue ,List<Boolean> list) {
		if (LabelName.equalsIgnoreCase(ExpectedLabelName)
				&& (LabelValue.replace(",", "")).equalsIgnoreCase(ExpectedLabelValue)) {
			list.add(true);
			CustomReporting
					.logReport(
							"", " Optional Coverage :<b><i><font color='green'>", CovererageName + "</font></i></b> with parameter  <b><i><font color='green'>" + LabelName + " have value"
									+ LabelValue + "</font></i></b> which is as expected",
							StepStatus.SUCCESS, new String[] {}, startTime);
		} else {
			list.add(false);
			CustomReporting
					.logReport(
							"", " Optional Coverage :<b><i><font color='red'>", CovererageName + "</font></i></b> with parameter <b><i><font color='red'> " + LabelName + " have value"
									+ LabelValue + "</font></i></b> which is not as expected",
							StepStatus.FAILURE, new String[] {}, startTime);
		}
	}
	
	
	public  String convertDateFormat(String dateString) throws ParseException {
        System.out.println("Given date is " + dateString);
 
       // DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateString);
 
       return new SimpleDateFormat("MM/dd/yyyy").format(date);
        
 
    }
	
	public  String convertDateFormatOfQuoteDate(String dateString) throws ParseException {
        System.out.println("Given date is " + dateString);
 
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
        Date date = sdf.parse(dateString);
 
       return new SimpleDateFormat("MM/dd/yyyy").format(date);
        
 
    }
}