package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.ModifiersPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class ModifiersPageImpl extends CustomAbstractPage implements ModifiersPage {
	@SuppressWarnings("static-access")
	@Override
	public void Modifiers(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataUmModifiers = PageDataManager.instance().getPageData("UmModifiers", tcID);
		String strScreenShots = dataUmModifiers.getData("PrintScreens");
		if (strScreenShots.equalsIgnoreCase("Yes")) {
			func._takeScreenShot(getWebDriver(), "START", "", "");
		}
		String strURL = "";
		if (dataUmModifiers.getData("ValidateModifiers").equalsIgnoreCase("Yes")) {
			_wait(10000);
			_click(getElement(tabModifiers));
			_wait(2000);
			if (func._isVisible(getElement(tabEPL))) {
				_wait(3000);
				_click(getElement(tabEPL));
				_wait(2000);
				_wait(3000);
				String expectedValues[] = { "EPLDFHazardCountyLocSel", "EPLDFNatureofOperationsSel",
						"EPLDFNumberofYearsinBusinessSel", "EPLDFMergerAcquisitionorDivestitureActivitySel",
						"EPLDFPastorContemplatedLayofforClosingActivitySel", "EPLDFAnnualCompensationofEmployeesSel",
						"EPLDFEmployeeTurnoverSel", "EPLDFLitigationHistorySel",
						"EPLDFSignificantTransactionorEventSel", "EPLDFManagementStabilitySel",
						"EPLDFHumanResourcesPoliciesandProceduresSel" };
				int l = expectedValues.length;
				for (int i = 1; i < l + 1; i++) {
					WebElement element = getWebDriver().findElement(
							By.xpath("//div[3]/div[1]/div[1]/div[1]/table[" + i + "]/tbody[1]/tr[1]/td[2]/div[1]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = expectedValues[i - 1];
					String expectedValue = dataUmModifiers.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

				}

				_wait(3000);
				String SRexpectedValues[] = { "EPLSRLossExperience", "EPLSROverallFinancialLiquidity",
						"EPLSRStrengthofCorporateGovernance", "EPLSRAffectedbyRecession", "EPLSRQualityofManagement" };
				int k = SRexpectedValues.length;
				for (int i = 1; i < k + 1; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Scheduled Rating Modifications')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = SRexpectedValues[i - 1];
					String expectedValue = dataUmModifiers.getData(currentValue);
					// String expectedValue= (getElement(currentValue).getAttribute("value"));
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				_wait(3000);
				String CMexpectedValues[] = { "EPLCMDutytoDefendSel",
						"EPLCMThirdPartyLiabilityCoverageDeletedFactorSel", "EPLCMThirdPartyExposureSel",
						"EPLCMEndorsementFactorSel","EPLCMEWageandHourDefenseSel" };
				int m = CMexpectedValues.length;
				for (int i = 1; i < m; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Optional Coverage Enhancements')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = CMexpectedValues[i - 1];
					String expectedValue = dataUmModifiers.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

				}
			}
			if (func._isVisible(getElement(tabCRI))) {

				_wait(5000);
				_click(getElement(tabCRI));
				_wait(2000);
				String expectedValues[] = { "CRIDFNatOfOpsSelection", "CRIDFProfOfrkSelection",
						"CRIDFOrgCompSelection", "CRIDFForgnLocExpSelection", "CRIDFHiValProcMatSelection",
						"CRIDFAudFuncSelection", "CRIDFIntContSelection", "CRIDFPreEmpScrSelection",
						"CRIDFInvMngSelection", "CRIDFVendMngGuidSelection", "CRIDFNoOfYrsSelection",
						"CRIDFMergAcqActSelection" };
				int l = expectedValues.length;
				for (int i = 1; i < l + 1; i++) {
					WebElement element = getWebDriver().findElement(
							By.xpath("//div[3]/div[1]/div[1]/div[1]/table[" + i + "]/tbody[1]/tr[1]/td[2]/div[1]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = expectedValues[i - 1];
					String expectedValue = dataUmModifiers.getData(currentValue);
				if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				_wait(3000);
				String SRexpectedValues[] = { "CRISRStrengthOfCorpGovSelection", "CRISRLossExpSelection",
						"CRISROverallFinanLiqSelection", "CRISRAffByRecessionSelection",
						"CRISRQualityOfMngmntSelection" };
				int k = SRexpectedValues.length;
				for (int i = 1; i < k + 1; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Scheduled Rating Modifications')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = SRexpectedValues[i - 1];
					String expectedValue = dataUmModifiers.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
						  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					}
				}

				_wait(3000);
				String CMexpectedValues[] = { "CRICMEndFactSelection", "CRICMPremCovSelection",
						"CRICMInTransitCovSelection", "CRICMForgeryCovSelection", "CRICMCompFraudCovSelection",
						"CRICMFundsTransFraudCovSelection", "CRICMMoneyOrderCountCurrencySelection",
						"CRICMCreditCardFraudCovSelection", "CRICMClientCovSelection",
						"CRICMSocialEnggFraudCovSelection" };
				int m = CMexpectedValues.length;
				for (int i = 1; i < m + 1; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Optional Coverage Enhancements')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = CMexpectedValues[i - 1];
					String expectedValue = dataUmModifiers.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
						  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					}

				}

			}

			if (func._isVisible(getElement(tabDNO))) {
				_wait(5000);
				_click(getElement(tabDNO));
				_wait(2000);
				PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
				if (dataUmLogin.getData("PrivateCo").equalsIgnoreCase("Yes")){
				String expectedValues[] = { "DNODFNatureOpsSelection","DNODFNoYrBusSelection","DNODFNoOfSubsSelection","DNODFMergerActivitySelection","DNODFManageOwnerSelection","DNODFSecurityOffSelection","DNODFLitHisSelection","DNODFSigTranSelection","DNODFMangStabilitySelection","DNODFQualityBalanceSheetSelection","DNODFQualityIncSelection","DNODFQualityCashFlowsSelection"};
				int l = expectedValues.length;
				for (int i = 1; i < l + 1; i++) {
					WebElement element = getWebDriver().findElement(
							By.xpath("//div[3]/div[1]/div[1]/div[1]/table[" + i + "]/tbody[1]/tr[1]/td[2]/div[1]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = expectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				_wait(3000);
				String SRexpectedValues[] = { "DNOSRStregthCorpGovtSelection", "DNOSRLossExpSelection",
						"DNOSROverallFinLiqSelection", "DNOSRAffRecessionSelection", "DNOSRQualityManageSelection" };
				int k = SRexpectedValues.length;
				for (int i = 1; i < k + 1; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Scheduled Rating Modifications')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = SRexpectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				_wait(3000);
				String CMexpectedValues[] = { "DNOCMDutytoDefendSelection", "DNOCMEndFactSelection" };
				int m = CMexpectedValues.length;
				for (int i = 1; i < m + 1; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Optional Coverage Enhancements')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = CMexpectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
				}
				else
				{

					String expectedValues[] = {"DNODFNatureOpsSelection","DNODFNoYrBusSelection","DNODFNoOfSubsSelection","DNODFMergerActivitySelection","DNODFSecuritiesOfferingActivitySelection","DNODFLitigationHistorySelection","DNODFSignificantTransactionorEventSelection","DNODFManagementStabilitySelection","DNODFQualityofStatementofFinancialPositionSelection","DNODFQualityofStatementofActivitiesSelection","DNODFQualityofStatementofCashFlowsSelection"};
					int l = expectedValues.length;
					for (int i = 1; i < l + 1; i++) {
						WebElement element = getWebDriver().findElement(
								By.xpath("//div[3]/div[1]/div[1]/div[1]/table[" + i + "]/tbody[1]/tr[1]/td[2]/div[1]"));
						String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
						String currentValue = expectedValues[i - 1];
						String expectedValue = dataUmLogin.getData(currentValue);
						if (actualValuexpath.matches(expectedValue)) {
							CustomReporting.logReport("Modifier value in PC " + actualValuexpath
									+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
									StepStatus.SUCCESS);
						} else {
							CustomReporting.logReport(
									"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
											+ expectedValue + " for field " + currentValue,
									StepStatus.FAILURE);
						}
						  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					}

					_wait(3000);
					String SRexpectedValues[] = { "DNOSRStregthCorpGovtSelection", "DNOSRLossExpSelection",
							"DNOSROverallFinLiqSelection", "DNOSRAffRecessionSelection", "DNOSRQualityManageSelection" };
					int k = SRexpectedValues.length;
					for (int i = 1; i < k + 1; i++) {
						WebElement element = getWebDriver().findElement(By.xpath(
								"//*[contains(text(),'Scheduled Rating Modifications')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
										+ i + "]//td[2]"));
						String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
						String currentValue = SRexpectedValues[i - 1];
						String expectedValue = dataUmLogin.getData(currentValue);
						if (actualValuexpath.matches(expectedValue)) {
							CustomReporting.logReport("Modifier value in PC " + actualValuexpath
									+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
									StepStatus.SUCCESS);
						} else {
							CustomReporting.logReport(
									"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
											+ expectedValue + " for field " + currentValue,
									StepStatus.FAILURE);
						}
						  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					}

					_wait(3000);
					String CMexpectedValues[] = { "DNOCMDutytoDefendSelection", "DNOCMEndFactSelection" };
					int m = CMexpectedValues.length;
					for (int i = 1; i < m + 1; i++) {
						WebElement element = getWebDriver().findElement(By.xpath(
								"//*[contains(text(),'Optional Coverage Enhancements')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
										+ i + "]//td[2]"));
						String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
						String currentValue = CMexpectedValues[i - 1];
						String expectedValue = dataUmLogin.getData(currentValue);
						if (actualValuexpath.matches(expectedValue)) {
							CustomReporting.logReport("Modifier value in PC " + actualValuexpath
									+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
									StepStatus.SUCCESS);
						} else {
							CustomReporting.logReport(
									"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
											+ expectedValue + " for field " + currentValue,
									StepStatus.FAILURE);
						}
						  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					}

				}
			}
			
			if (func._isVisible(getElement(tabEMP))) {
				_wait(5000);
				_click(getElement(tabEMP));
				_wait(2000);
				PageData dataUmLogin = PageDataManager.instance().getPageData("EMP", tcID);
				String expectedValues[] = { "EMPDFAreaofPracticeSelection","EMPDFLitigationHistorySelection","EMPDFPublicDebtExposureSelection","EMPDFMergerAcquisitionorDivestitureActivitySelection","EMPDFUseofExternalLegalResourcesSelection","EMPDFExperienceofEmployedLawyersSelection","EMPDFOtherLegalServicesPerformedSelection" };
				int l = expectedValues.length;
				for (int i = 1; i < l + 1; i++) {
					WebElement element = getWebDriver().findElement(
							By.xpath("//div[3]/div[1]/div[1]/div[1]/table[" + i + "]/tbody[1]/tr[1]/td[2]/div[1]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = expectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				_wait(3000);
				String SRexpectedValues[] = {"EMPSRStrengthofCorporateGovernance","EMPSRLossExperience","EMPSROverallFinancialLiquidity","EMPSRAffectedbyRecession","EMPSRQualityofManagement"};
				int k = SRexpectedValues.length;
				for (int i = 1; i < k + 1; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Scheduled Rating Modifications')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = SRexpectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				_wait(3000);
				String CMexpectedValues[] = {"CMDutytoDefendSelectionFactorSelection","CMEndorsementFactorSelection","CMSecuritiesCoverageFactorSelection"};
				int m = CMexpectedValues.length;
				for (int i = 1; i < m + 1; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Optional Coverage Enhancements')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = CMexpectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

			}

			if (func._isVisible(getElement(tabENO))) {
				_wait(5000);
				_click(getElement(tabENO));
				_wait(2000);
				PageData dataUmLogin = PageDataManager.instance().getPageData("ENO", tcID);
				String expectedValues[] = {"ENODFYearsinBusinessSelection","ENODFComplexityofRiskSelection","ENODFProfessionalExperienceSelection","ENODFWrittenContractsSelection","ENODFSeverityPotentialSelection","ENODFRiskManagementSelection","ENODFPriorActsCoverageSelection","ENODFTerritoriesofOperationsSelection","ENODFClientIndustriesSelection"};
				int l = expectedValues.length;
				for (int i = 1; i < l + 1; i++) {
					WebElement element = getWebDriver().findElement(
							By.xpath("//div[3]/div[1]/div[1]/div[1]/table[" + i + "]/tbody[1]/tr[1]/td[2]/div[1]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = expectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				_wait(3000);
				String SRexpectedValues[] = {"ENOSRStrengthofCorporateGovernance","ENOSRLossExperience","ENOSROverallFinancialLiquidity","ENOSRAffectedbyRecession","ENOSRQualityofManagement"};
				int k = SRexpectedValues.length;
				for (int i = 1; i < k + 1; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Scheduled Rating Modifications')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = SRexpectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				_wait(3000);
				String CMexpectedValues[] = {"CMDutytoDefendSelectionFactorSelection","CMEndorsementFactorSelection","CMMediaLiabilityCoverageFactorSelection"};
				int m = CMexpectedValues.length;
				for (int i = 1; i < m + 1; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Optional Coverage Enhancements')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = CMexpectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

			}
			if (func._isVisible(getElement(tabFID))) {
				_wait(5000);
				_click(getElement(tabFID));
				_wait(2000);
				PageData dataUmLogin = PageDataManager.instance().getPageData("FID", tcID);
				if (dataUmLogin.getData("PrivateCo").equalsIgnoreCase("Yes")){
				String expectedValues[] = {"FIDDFNatureofOperationsSelection","FIDDFNumberofYearsinBusinessSelection","FIDDFPlanTerminationMergingorFreezingActivitySelection","FIDDFPlanTypeSelection","FIDEXPEmployeeStockOwnershipPlanSelection","FIDEXPFundingStatusofDefinedBenefitPlansSelection","FIDEXPPlanParticipantsSelection","FIDEXPLitigationHistorySelection","FIDEXPSignificantTransactionorEventSelection","FIDEXPQualityandDiversityofPlanInvestmentsSelection" };
				int l = expectedValues.length;
				for (int i = 1; i < l + 1; i++) {
					WebElement element = getWebDriver().findElement(
							By.xpath("//div[3]/div[1]/div[1]/div[1]/table[" + i + "]/tbody[1]/tr[1]/td[2]/div[1]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = expectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				_wait(3000);
				String SRexpectedValues[] = {"FIDSRStrengthofCorporateGovernance","FIDSRLossExperience","FIDSROverallFinancialLiquidity","FIDSRAffectedbyRecession","FIDSRQualityofManagement"};
				int k = SRexpectedValues.length;
				for (int i = 1; i < k + 1; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Scheduled Rating Modifications')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = SRexpectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				_wait(3000);
				String CMexpectedValues[] = {"CMDutytoDefendSelectionFactorSelection","CMEndorsementFactorSelection"};
				int m = CMexpectedValues.length;
				for (int i = 1; i < m + 1; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Optional Coverage Enhancements')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = CMexpectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

			}
				else
				{

					String expectedValues[] = { "FIDDFNatureofOperationsSelection","FIDDFNumberofYearsinBusinessSelection","FIDDFPlanTerminationMergingorFreezingActivitySelection","FIDDFPlanTypeSelection","FIDDFFundingStatusofDefinedBenefitPlansSelection","FIDDFPlanParticipantsSelection","FIDDFLitigationHistorySelection","FIDDFSignificantTransactionorEventSelection","FIDDFQualityandDiversityofPlanInvestmentsSelection"};
					int l = expectedValues.length;
					for (int i = 1; i < l + 1; i++) {
						WebElement element = getWebDriver().findElement(
								By.xpath("//div[3]/div[1]/div[1]/div[1]/table[" + i + "]/tbody[1]/tr[1]/td[2]/div[1]"));
						String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
						String currentValue = expectedValues[i - 1];
						String expectedValue = dataUmLogin.getData(currentValue);
						if (actualValuexpath.matches(expectedValue)) {
							CustomReporting.logReport("Modifier value in PC " + actualValuexpath
									+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
									StepStatus.SUCCESS);
						} else {
							CustomReporting.logReport(
									"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
											+ expectedValue + " for field " + currentValue,
									StepStatus.FAILURE);
						}
						  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					}

					_wait(3000);
					String SRexpectedValues[] = {"FIDSRStrengthofCorporateGovernance","FIDSRLossExperience","FIDSROverallFinancialLiquidity","FIDSRAffectedbyRecession","FIDSRQualityofManagement"};
					int k = SRexpectedValues.length;
					for (int i = 1; i < k + 1; i++) {
						WebElement element = getWebDriver().findElement(By.xpath(
								"//*[contains(text(),'Scheduled Rating Modifications')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
										+ i + "]//td[2]"));
						String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
						String currentValue = SRexpectedValues[i - 1];
						String expectedValue = dataUmLogin.getData(currentValue);
						if (actualValuexpath.matches(expectedValue)) {
							CustomReporting.logReport("Modifier value in PC " + actualValuexpath
									+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
									StepStatus.SUCCESS);
						} else {
							CustomReporting.logReport(
									"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
											+ expectedValue + " for field " + currentValue,
									StepStatus.FAILURE);
						}
						  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					}

					_wait(3000);
					String CMexpectedValues[] = {"CMDutytoDefendSelectionFactorSelection","CMEndorsementFactorSelection"};
					int m = CMexpectedValues.length;
					for (int i = 1; i < m + 1; i++) {
						WebElement element = getWebDriver().findElement(By.xpath(
								"//*[contains(text(),'Optional Coverage Enhancements')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
										+ i + "]//td[2]"));
						String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
						String currentValue = CMexpectedValues[i - 1];
						String expectedValue = dataUmLogin.getData(currentValue);
						if (actualValuexpath.matches(expectedValue)) {
							CustomReporting.logReport("Modifier value in PC " + actualValuexpath
									+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
									StepStatus.SUCCESS);
						} else {
							CustomReporting.logReport(
									"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
											+ expectedValue + " for field " + currentValue,
									StepStatus.FAILURE);
						}
						  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
					}

				
				}
			}
			if (func._isVisible(getElement(tabKNR))) {
				_wait(5000);
				_click(getElement(tabKNR));
				_wait(2000);
				PageData dataUmLogin = PageDataManager.instance().getPageData("KNR", tcID);
				String expectedValues[] = {"KNRDFRiskinessofCountriesTraveledToSelection","KNRDFFrequencyofTravelSelection","KNRDFSecurityMeasuresinForeignCountriesSelection","KNRDFIndustryGroupSelection","KNRDFTravelAdvisoryPolicySelection","KNRDFProductExposureSelection"};
				int l = expectedValues.length;
				for (int i = 1; i < l + 1; i++) {
					WebElement element = getWebDriver().findElement(
							By.xpath("//div[3]/div[1]/div[1]/div[1]/table[" + i + "]/tbody[1]/tr[1]/td[2]/div[1]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = expectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				_wait(3000);
				String SRexpectedValues[] = {"KNRSRStrengthofCorporateGovernance","KNRSRLossExperience","KNRSROverallFinancialLiquidity","KNRSRAffectedbyRecession","KNRSRQualityofManagement"};
				int k = SRexpectedValues.length;
				for (int i = 1; i < k + 1; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Scheduled Rating Modifications')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = SRexpectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				_wait(3000);

			}
			if (func._isVisible(getElement(tabCYB))) {
				_wait(5000);
				_click(getElement(tabCYB));
				_wait(2000);
				PageData dataUmLogin = PageDataManager.instance().getPageData("CYB", tcID);
				String expectedValues[] = {"CYBDFNatureandAmountofThirdPartyPersonalInformationSelection","CYBDFLocationJurisdictionFactorSelection","CYBDFFormalIncidentResponsePlanSelection","CYBDFFormalBusinessContinuityDisasterSelection","CYBDFSharingofConfidentialInformationSelection","CYBDFAssetInventorySelection","CYBDFSecurityConfigurationsSelection","CYBDFVulnerabilityAssessmentandRemediationSelection","CYBDFEmployeeTrainingSelection","CYBDFAccessControlSelection","CYBDFUseofEncryptionSelection","CYBDFRelianceonCriticalVendorsorServiceProvidersSelection","CYBDFOnlineSalesSelection","CYBDFContractbasedRiskManagementControlsSelection","CYBDFMergerandAcquisitionActivitySelection" };
				int l = expectedValues.length;
				for (int i = 1; i < l + 1; i++) {
					WebElement element = getWebDriver().findElement(
							By.xpath("//div[3]/div[1]/div[1]/div[1]/table[" + i + "]/tbody[1]/tr[1]/td[2]/div[1]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = expectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				_wait(3000);
				String SRexpectedValues[] = {"CYBSRStrengthofCorporateGovernance","CYBSRLossExperience","CYBSROverallFinancialLiquidity","CYBSRAffectedbyRecession","CYBSRQualityofManagement"};
				int k = SRexpectedValues.length;
				for (int i = 1; i < k + 1; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Scheduled Rating Modifications')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = SRexpectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

				_wait(3000);
				String CMexpectedValues[] = {"CMEndorsementFactorSelection","CYBOCRegulatoryPenaltiesSelection","CYBOCBreachResponseCostsSelection","CYBOCReputationRepairSelection","CYBOCCyberExtortionCostsSelection","CYBOCBusinessInterruptionLossSelection","CYBOCContingentBusinessInterruptionLossSelection","CYBOCDataLossCostsSelection","CYBOCMediaLiabilitySelection","CYBOCBreachLiabilitySelection","CYBOCPCIAssessmentsSelection","CYBOCPCIRecertificationCostsSelection","CYBOCSocialEngineeringSelection","CYBOCTechnologyErrorsandOmissionsLiabilitySublimit","CYBOCSystemFailureSelection","CYBOCWrongfulCollectionSelection"};
				int m = CMexpectedValues.length;
				for (int i = 1; i < m + 1; i++) {
					WebElement element = getWebDriver().findElement(By.xpath(
							"//*[contains(text(),'Optional Coverage Enhancements')]/../../../../../../../following-sibling::tr/td/div/table//table//table//table["
									+ i + "]//td[2]"));
					String actualValuexpath = String.format("%.2f", Float.parseFloat(element.getText()));
					String currentValue = CMexpectedValues[i - 1];
					String expectedValue = dataUmLogin.getData(currentValue);
					if (actualValuexpath.matches(expectedValue)) {
						CustomReporting.logReport("Modifier value in PC " + actualValuexpath
								+ " matches Modifier value in UM " + expectedValue + " for field " + currentValue,
								StepStatus.SUCCESS);
					} else {
						CustomReporting.logReport(
								"Modifier value in PC " + actualValuexpath + " does not match Modifier value in UM "
										+ expectedValue + " for field " + currentValue,
								StepStatus.FAILURE);
					}
					  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}

			}
			}
//End Validation
		 else {

			PageData dataModifiers = PageDataManager.instance().getPageData("Modifiers", tcID);
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(4000);

			// Common

			func.sendData(txtSharedLimit, getElement(txtSharedLimit), dataModifiers.getData("txtSharedLimit"),
					"Modifiers");
			_wait(2000);
			func.sendData(txtSharedSepDefense, getElement(txtSharedSepDefense),
					dataModifiers.getData("txtSharedSepDefense"), "Modifiers");
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(1000);
			// _click(getElement(btnSaveDraft));
			// CRI
			if (func._isVisible(getElement(tabCRI))) {

				_wait(5000);
				_click(getElement(tabCRI));
				_wait(2000);

				func.sendData(txtNatureofops, getElement(txtNatureofops), dataModifiers.getData("txtNatureofops"),
						"Modifiers");

				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtProfileofWorkspace, getElement(txtProfileofWorkspace),
						dataModifiers.getData("txtProfileofWorkspace"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);

				func.sendData(OrganizationComplx, getElement(OrganizationComplx),
						dataModifiers.getData("OrganizationComplx"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				func.sendData(txtForeignLocExposure, getElement(txtForeignLocExposure),
						dataModifiers.getData("txtForeignLocExposure"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtHighValue, getElement(txtHighValue), dataModifiers.getData("txtHighValue"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtAuditfunc, getElement(txtAuditfunc), dataModifiers.getData("txtAuditfunc"),
						"Modifiers");
				  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtInternalControls, getElement(txtInternalControls),
						dataModifiers.getData("txtInternalControls"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtPreEmpl, getElement(txtPreEmpl), dataModifiers.getData("txtPreEmpl"), "Modifiers");
				  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtInventoryMan, getElement(txtInventoryMan), dataModifiers.getData("txtInventoryMan"),
						"Modifiers");

				func._waitForPageToLoad(getWebDriver(), 50L);

				func.sendData(txtVendorMan, getElement(txtVendorMan), dataModifiers.getData("txtVendorMan"),
						"Modifiers");
				_wait(1000);
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				func.sendData(txtNoOfYears, getElement(txtNoOfYears), dataModifiers.getData("txtNoOfYears"),
						"Modifiers");

				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtMergerandAcq, getElement(txtMergerandAcq), dataModifiers.getData("txtMergerandAcq"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				func.sendData(txtStrengthofCorp, getElement(txtStrengthofCorp),
						dataModifiers.getData("txtStrengthofCorp"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				// _wait(3000);
				// _click(getElement(txtLossExperience));
				_wait(3000);
				func.sendData1(txtLossExperience, getElement(txtLossExperience), dataModifiers.getData("txtLossExp1"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtOverallFinLiq, getElement(txtOverallFinLiq), dataModifiers.getData("txtOverallFinLiq"),
						"Modifiers");

				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(2000);
				// _click(getElement(txtAffectedByRecession));
				func.sendData(txtAffectedByRecession, getElement(txtAffectedByRecession),
						dataModifiers.getData("txtAffectedByRecession"), "Modifiers");

				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtQualityofMan, getElement(txtQualityofMan), dataModifiers.getData("txtQualityofMan"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtEndFactor, getElement(txtEndFactor), dataModifiers.getData("txtEndFactor"),
						"Modifiers");

				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtPremisesCov, getElement(txtPremisesCov), dataModifiers.getData("txtPremisesCov"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtInTransitCov, getElement(txtInTransitCov), dataModifiers.getData("txtInTransitCov"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtForgeryCov, getElement(txtForgeryCov), dataModifiers.getData("txtForgeryCov"),
						"Modifiers");
				  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtFundsTransfercov, getElement(txtFundsTransfercov),
						dataModifiers.getData("txtFundsTransfercov"), "Modifiers");

				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtComputerFraudCov, getElement(txtComputerFraudCov),
						dataModifiers.getData("txtComputerFraudCov"), "Modifiers");

				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtMoneyOrderCov, getElement(txtMoneyOrderCov), dataModifiers.getData("txtMoneyOrderCov"),
						"Modifiers");

				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtCreditCardCov, getElement(txtCreditCardCov), dataModifiers.getData("txtCreditCardCov"),
						"Modifiers");

				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtClientCov, getElement(txtClientCov), dataModifiers.getData("txtClientCov"),
						"Modifiers");
				  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtSocialEngCov, getElement(txtSocialEngCov), dataModifiers.getData("txtSocialEngCov"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				// _wait(4000);
				// _click(getElement(btnSaveDraft));
				  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
			
			// DNO
			if (func._isVisible(getElement(tabDNO))) {
				_wait(5000);
				_click(getElement(tabDNO));
				_wait(2000);
				func.sendData(txtNatureOfOperations, getElement(txtNatureOfOperations),
						dataModifiers.getData("txtNatureOfOperations"), "Modifiers");

				_wait(1000);
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtNoOfYrsBus, getElement(txtNoOfYrsBus), dataModifiers.getData("txtNoOfYrsBus"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtNoOfSubsidaries, getElement(txtNoOfSubsidaries),
						dataModifiers.getData("txtNoOfSubsidaries"), "Modifiers");
				  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtMerger, getElement(txtMerger), dataModifiers.getData("txtMerger"), "Modifiers");

				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtManOwnership, getElement(txtManOwnership), dataModifiers.getData("txtManOwnership"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtSecuritiesOffering, getElement(txtSecuritiesOffering),
						dataModifiers.getData("txtSecuritiesOffering"), "Modifiers");

				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtLitigationHistory, getElement(txtLitigationHistory),
						dataModifiers.getData("txtLitigationHistory"), "Modifiers");
				  func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtSigTransaction, getElement(txtSigTransaction),
						dataModifiers.getData("txtSigTransaction"), "Modifiers");
				_wait(1000);
				func.sendData(txtManStability, getElement(txtManStability), dataModifiers.getData("txtManStability"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtQualityOfBalSheet, getElement(txtQualityOfBalSheet),
						dataModifiers.getData("txtQualityOfBalSheet"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtQualityOfIncState, getElement(txtQualityOfIncState),
						dataModifiers.getData("txtQualityOfIncState"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);

				func.sendData(txtQualityOfCashFlow, getElement(txtQualityOfCashFlow),
						dataModifiers.getData("txtQualityOfCashFlow"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtCorporatGovernance, getElement(txtCorporatGovernance),
						dataModifiers.getData("txtCorporatGovernance"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtLossExper, getElement(txtLossExper), dataModifiers.getData("txtLossExp"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);

				_wait(1000);
				func.sendData(txtOverallFinLiquidity, getElement(txtOverallFinLiquidity),
						dataModifiers.getData("txtOverallFinLiquidity"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);

				_wait(1000);
				func.sendData(txtAffByRecession, getElement(txtAffByRecession),
						dataModifiers.getData("txtAffByRecession"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				_wait(1000);
				func.sendData(txtQualityOfManagement, getElement(txtQualityOfManagement),
						dataModifiers.getData("txtQualityOfManagement"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);

				_wait(1000);
				func.sendData(txtDutyToDefend, getElement(txtDutyToDefend), dataModifiers.getData("txtDutyToDefend"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);

				_wait(1000);
				func.sendData(EndorsementFactor, getElement(EndorsementFactor),
						dataModifiers.getData("EndorsementFactor"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(4000);
				_click(getElement(btnSaveDraft));
			}

			// EPL
			if (func._isVisible(getElement(tabEPL))) {
				_wait(5000);
				_click(getElement(tabEPL));
				_wait(2000);

				// _click(getElement(btnEPLtab));
				// func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtHazardCounty, getElement(txtHazardCounty), dataModifiers.getData("HazardCounty"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtNatureOfOps, getElement(txtNatureOfOps), dataModifiers.getData("NatureOfOps"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtNoOfYrsInBusiness, getElement(txtNoOfYrsInBusiness),
						dataModifiers.getData("NoOfYrsInBusiness"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtMergerAquDivActivity, getElement(txtMergerAquDivActivity),
						dataModifiers.getData("MergerAquDivActivity"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtLayoffClosingActivity, getElement(txtLayoffClosingActivity),
						dataModifiers.getData("LayoffClosingActivity"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtCompensationOfEmployees, getElement(txtCompensationOfEmployees),
						dataModifiers.getData("CompensationOfEmployees"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtEmployeeTurnover, getElement(txtEmployeeTurnover),
						dataModifiers.getData("EmployeeTurnover"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtLitigationHist, getElement(txtLitigationHist), dataModifiers.getData("LitigationHist"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtSignificantTransEvent, getElement(txtSignificantTransEvent),
						dataModifiers.getData("SignificantTransEvent"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtManagementStability, getElement(txtManagementStability),
						dataModifiers.getData("ManagementStability"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtHRPolicyProcedure, getElement(txtHRPolicyProcedure),
						dataModifiers.getData("HRPolicyProcedure"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtStrengthCorporate, getElement(txtStrengthCorporate),
						dataModifiers.getData("StrengthCorporate"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtLossExp, getElement(txtLossExp), dataModifiers.getData("LossExperience"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtFinancialLiquidity, getElement(txtFinancialLiquidity),
						dataModifiers.getData("FinancialLiquidity"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtAffectedByRecession1, getElement(txtAffectedByRecession1),
						dataModifiers.getData("AffectedByRecession1"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtQualityOfManagement1, getElement(txtQualityOfManagement1),
						dataModifiers.getData("QualityOfManagement1"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtDutyToDefend, getElement(txtDutyToDefend), dataModifiers.getData("DutyToDefend1"),
						"Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtThirdPartyLiability, getElement(txtThirdPartyLiability),
						dataModifiers.getData("ThirdPartyLiability"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtThirdPartyExposure, getElement(txtThirdPartyExposure),
						dataModifiers.getData("ThirdPartyExposure"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				func.sendData(txtEndorsementFactor, getElement(txtEndorsementFactor),
						dataModifiers.getData("EndorsementFactor"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);
				
				func.sendData(txtWageandHour, getElement(txtWageandHour),
						dataModifiers.getData("WageandHour"), "Modifiers");
				func._waitForPageToLoad(getWebDriver(), 50L);
				_wait(1000);

				func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				_wait(4000);
				
			}
		}

	}
}