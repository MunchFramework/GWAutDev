package com.everest.webservice.insureon.spi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;
import org.xframium.page.PageManager;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.GenericFunctions;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;
import com.everest.utility.ExcelDataReader;
import com.everest.webservice.insureon.QuoteReferDeclineFileValidation;
import com.everest.webservice.insureon.WebServiceBind;
import com.everest.webservice.insureon.WebServiceSubmission;
import com.jayway.restassured.response.Response;

public class WebServiceSubmissionImpl extends CustomAbstractPage implements WebServiceSubmission {
	PageData data;

	PageData escapeData;
	List<Boolean> list = new ArrayList<Boolean>();
	long startTime = System.currentTimeMillis();

	@SuppressWarnings("unused")
	@Override
	public void CreateAccSubDclnCrime_01(String tcID, SoftAssert softAssert) throws Exception {

		try {

			PageData EnvironmentData = PageDataManager.instance().getPageData("Config", tcID);
			data = PageDataManager.instance().getPageData("Submission", tcID);
			String endPointURL = "";
			String env = GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV");
			if (!env.isEmpty()) {
				if (env.equalsIgnoreCase("DEV")) {
					endPointURL = data.getData("DEVEndPointUrl");
				} else {
					if (env.equalsIgnoreCase("QA")) {
						endPointURL = data.getData("QAEndPointUrl");
					} else {
						endPointURL = data.getData("DEVURL");
					}
				}
			} else {
				if (EnvironmentData.getData("Environment").equals("DEV")) {
					endPointURL = data.getData("DEVEndPointUrl");
				} else {
					if (EnvironmentData.getData("Environment").equals("QA")) {
						endPointURL = data.getData("QAEndPointUrl");
					} else {
						endPointURL = data.getData("STAGEEndPointUrl");
					}
				}
			}
			WebServiceGenerateAuthTokenImpl authcodeobj = new WebServiceGenerateAuthTokenImpl();
			String authcode = authcodeobj.generateAuthTokenCode(tcID, softAssert);
			String path = data.getData("Payloadpath");
			String ReqUrl = endPointURL;
			String authKey = "Bearer " + authcode;
			String cType = data.getData("ContentType");

			String finalStr = modifyAccountSubmissionRequest(path, data);
			System.out.println("updated request " + finalStr);
			Response response = cFunc.customWebServiceCall(finalStr, authKey, cType, ReqUrl);
			String resbody = response.asString();
			System.out.println("Response from Web Service is: " + resbody);
			System.out.println(response.statusCode());

			if (response != null) {
				verifyAccountObj(finalStr, resbody, response, ReqUrl);
				verifySubmissionObj(finalStr, resbody, response, ReqUrl);
				boolean stepResult = cFunc.allStepsResult(list);

				if (stepResult) {
					CustomReporting.logReport("", "", "Successfully Verified All Mandatory Fields In Response ",
							StepStatus.SUCCESS, new String[] {}, startTime);
				} else {
					CustomReporting.logReport("", "", "Verification of Mandatory Field values is failed", "",
							StepStatus.FAILURE, new String[] {}, startTime, null);
					throw new RuntimeException();
				}
			} else {
				CustomReporting.logReport("", "", "Unable to recieve response for create account", "",
						StepStatus.FAILURE, new String[] {}, startTime, null);
				throw new RuntimeException();
			}
		} catch (RuntimeException ex) {
			throw ex;
		}
	}

	@SuppressWarnings("unused")
	@Override
	public void verifySubmissionAgainstState(String tcID, SoftAssert softAssert, String DeviceName) throws Exception {

		try {

			PageData EnvironmentData = PageDataManager.instance().getPageData("Config", tcID);
			data = PageDataManager.instance().getPageData("Submission", tcID);
			escapeData = PageDataManager.instance().getPageData("EscapeApplicationPage", tcID);
			String endPointURL = "";
			String XIBMClientID = null;
			String XIBMClientSecret =null;
			String env = GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV");
			if (!env.isEmpty()) {
				if (env.equalsIgnoreCase("DEV")) {
					endPointURL = data.getData("DEVEndPointUrl");
					XIBMClientID = data.getData("DEVX-IBM-Client-Id");
					XIBMClientSecret = data.getData("DEVX-IBM-Client-Secret");
				} else {
					if (env.equalsIgnoreCase("QA")) {
						endPointURL = data.getData("QAEndPointUrl");
						XIBMClientID = data.getData("QAX-IBM-Client-Id");
						XIBMClientSecret = data.getData("QAX-IBM-Client-Secret");
					} else {
						endPointURL = data.getData("STAGEEndPointUrl");
						XIBMClientID = data.getData("X-IBM-Client-Id");
						XIBMClientSecret = data.getData("X-IBM-Client-Secret");
					}
				}
			} else {
				if (EnvironmentData.getData("Environment").equals("DEV")) {
					endPointURL = data.getData("DEVEndPointUrl");
					XIBMClientID = data.getData("DEVX-IBM-Client-Id");
					XIBMClientSecret = data.getData("DEVX-IBM-Client-Secret");
				} else {
					if (EnvironmentData.getData("Environment").equals("QA")) {
						endPointURL = data.getData("QAEndPointUrl");
						XIBMClientID = data.getData("QAX-IBM-Client-Id");
						XIBMClientSecret = data.getData("QAX-IBM-Client-Secret");
					} else {
						endPointURL = data.getData("STAGEEndPointUrl");
						XIBMClientID = data.getData("X-IBM-Client-Id");
						XIBMClientSecret = data.getData("X-IBM-Client-Secret");
					}
				}
			}
			String strScreenShots = EnvironmentData.getData("PrintScreens");
			if (strScreenShots.equalsIgnoreCase("Yes")) {
				func._takeScreenShot(getWebDriver(), "START", "", "");
			}
			
			
			WebServiceGenerateAuthTokenImpl authcodeobj = new WebServiceGenerateAuthTokenImpl();
			String authcode = authcodeobj.generateAuthTokenCode(tcID, softAssert);
			String path = data.getData("Payloadpath");
			// String ReqUrl = data.getData("EndPointUrl");
			String authKey = "Bearer " + authcode;
			String cType = data.getData("ContentType");
			//String XIBMClientID = data.getData("X-IBM-Client-Id");
			//String XIBMClientSecret = data.getData("X-IBM-Client-Secret");
			String[] stateCodeList = data.getData("StateCode").split("#");
			String[] NaicsCode = data.getData("NaicsCode").split("#");
			func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
				for (int i = 0; i < stateCodeList.length; i++) {
					for (int l = 0; l < NaicsCode.length; l++) {
					String stateCode = stateCodeList[i];
					String finalStr = modifyAccountSubmissionRequest(path, data, stateCode, tcID, NaicsCode[l]);
					System.out.println("request ========" + finalStr);
					CustomReporting
							.logReport("Api call to create the submission account with the valid request payload");
					
					CustomReporting.logReport("Tescase id"+ tcID);
					// String input = cFunc.getUpdateInputAsString(path);
					Response response = cFunc.customWebServiceCall(finalStr, authKey, cType, endPointURL, XIBMClientID,
							XIBMClientSecret, "");
					String resbody = response.asString();
					System.out.println("Create submision response " + resbody);

					System.out.println("Response from Web Service is: " + resbody);
					System.out.println(response.statusCode());
					if (response != null) {
						int code = response.statusCode();
						String statusLine = response.statusLine();

						Collections.fill(list, Boolean.TRUE);

						if (code == 200 || code == 201) {
							list.add(true);
							CustomReporting.logReport("", "",
									"Create Account Service returned response successfully with code: " + code
											+ " and message : " + statusLine,
									StepStatus.SUCCESS, new String[] {}, startTime);
							getSubmissionResponseValue(response);
						} else {
							list.add(false);

							CustomReporting.logReport("", "",
									"Unable to Get Response for Submission Service" + code + statusLine + NaicsCode[l], "",
									StepStatus.FAILURE, new String[] {}, startTime, null);

						}
						if (code == 200) {
							Thread.sleep(5000);

							CustomReporting.logReport(
									"Account detail validation after create submission API call wrt the request payload");
							verifyAccountObj(finalStr, resbody, response, endPointURL);

							CustomReporting.logReport(
									"Submission detail validation after create submission API call wrt the request payload");
							if(data.getData("LOB").equalsIgnoreCase("CY")) {
								verifyCyberSubmissionObj(finalStr, resbody, response, endPointURL);
							}else {
							verifySubmissionObj(finalStr, resbody, response, endPointURL);
							}
							GenericFunctions.instance()._addToGlobalVariableList("submissionData", resbody);
							if (EnvironmentData.getData("Quote").equalsIgnoreCase("yes")) {
								CustomReporting.logReport(
										"Api call to Quote the submission with the valid request(create sub response + UW questions)");
								if (!(tcID.contains("DS_SubmsOFACBlock_") || tcID.contains("DS_SubmBlockDueToName_")
										|| data.getData("ExpectedStatus").equalsIgnoreCase("Blocked"))) {
									WebServiceGetQuoteImpl getQuoteObj = new WebServiceGetQuoteImpl();
									CustomReporting
											.logReport("Quote detail validation after a successfull quote submission");
									getQuoteObj.verifyGetQuoteDetails(tcID, softAssert, "", "");
								}
							}
							
							String strParentWindowID=getWebDriver().getWindowHandle();
							if (EnvironmentData.getData("ESCAPE").equalsIgnoreCase("yes")) {

								EscapePageImpl escObject = new EscapePageImpl();
								String ExpectedStatus = escapeData.getData("ExpectedStatus").trim();
								CustomReporting
										.logReport("Account and Submission detail validation in the ESCAPE protal");
							//	getWebDriver().navigate().refresh();
								escObject.verifyAccountDetailsInEscape(tcID, softAssert, DeviceName, ExpectedStatus,
										list);
								System.out.println(list);
							}
							if (EnvironmentData.getData("PC").equalsIgnoreCase("yes")) {
								CustomReporting.logReport("Account and Submission detail validation in the PC protal");
								PolicyCenterPageImpl pcObject = new PolicyCenterPageImpl();
								pcObject.verifySubmissionDetails(tcID, softAssert, DeviceName, list);								 
								pcObject.verifyCoverageSection(tcID, softAssert, DeviceName, list);
								pcObject.verifyOptionalCoverages(tcID, softAssert, DeviceName, list);
								getWebDriver().close();
								 
							    getWebDriver().switchTo().window(strParentWindowID);
							   

							}
							CustomReporting.logReport(
									"Quote/Referral/Decline letter/mail/mail validation for the created submission");
							QuoteReferDeclineFileValidation objReferenceQuoteLetter = (QuoteReferDeclineFileValidation) PageManager
									.instance().createPage(QuoteReferDeclineFileValidation.class, getWebDriver());
							if (escapeData.getData("ExpectedStatus").equalsIgnoreCase("Quote Outstanding")) {
								//objReferenceQuoteLetter.verifyQuoteDocDetails(tcID, softAssert);
							} else if (escapeData.getData("ExpectedStatus").equalsIgnoreCase("Declined")
									|| escapeData.getData("ExpectedStatus").equalsIgnoreCase("Working")) {
							//objReferenceQuoteLetter.verifyReferalMail(tcID, softAssert);
							}
							
							if(EnvironmentData.getData("Bind").equalsIgnoreCase("yes")) {
								objReferenceQuoteLetter.uploadSignedAppDocument(tcID, softAssert);
								WebServiceBind bindObj = (WebServiceBind) PageManager
										.instance().createPage(WebServiceBind.class, getWebDriver());
								bindObj.verifyBindDetails(tcID, softAssert);
							}

							// escObject.verifySubmissionStatusReasonInEscape(tcID, softAssert,
							// DeviceName,ExpectedStatus);
						} else {
							GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
									tcID);

							CustomReporting.logReport("", "",
									"Unable to Get Response for Submission Service" + code + statusLine, "",
									StepStatus.FAILURE, new String[] {}, startTime, null);
							throw new RuntimeException();
						}
					} else {
						GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
								tcID);
						CustomReporting.logReport("", "", "Unable to recieve response for Submission", "",
								StepStatus.FAILURE, new String[] {}, startTime, null);
					throw new RuntimeException();
					}
					
				}
				
				 
			}
			boolean stepResult = cFunc.allStepsResult(list);
			if (stepResult) {
				CustomReporting.logReport("", "", "Successfully Verified All Mandatory Fields In Response ",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
						tcID);
				CustomReporting.logReport("", "", "Verification of Mandatory Field values is failed", "",
						StepStatus.FAILURE, new String[] {}, startTime, null);
				throw new RuntimeException();
			}

		} catch (RuntimeException ex) {
			GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
			throw ex;
		}
	}

	public String modifyAccountSubmissionRequest(String payLoadPath, PageData data) {
		String finalStr = "";
		try {
			String AccountName = cFunc.generate_RandomText(8);
			String AddressLine1 = cFunc.generate_RandomText(10);

			Date date = new Date();
			String strDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date);

			Date expDate = DateUtils.addYears(new Date(), 1);
			String strExpirationDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(expDate);

			String input = cFunc.getUpdateInputAsString(payLoadPath);
			String str1 = cFunc.updateInputRequest(input, "account", "primary_entity", "name", AccountName);
			String str2 = cFunc.updateInputRequest(str1, "submission", "", "submitted_date", strDate);
			String str3 = cFunc.updateInputRequest(str2, "submission", "", "effective_date", strDate);
			String str4 = cFunc.updateInputRequest(str3, "submission", "", "expiration_date", strExpirationDate);
			String str5 = cFunc.updateInputRequest(str4, "submission", "", "predominant_state_code",
					data.getData("StateCode"));
			String str6 = cFunc.updateInputRequest(str5, "submission", "", "producer_id", data.getData("ProducerID"));
			String str7 = cFunc.updateInputRequest(str6, "submission", "", "submitting_agent_npn",
					data.getData("SubmittingAgentNPN"));
			finalStr = cFunc.updateInputRequest(str7, "account", "account_address", "address_line_1", AddressLine1);

		} catch (Exception ex) {
			throw ex;
		}

		return finalStr;
	}

	public String modifyAccountSubmissionRequest(String payLoadPath, PageData data, String stateCode, String tcID,
			String NaicsCode) throws Exception {
		String finalStr = "";
		try {
			PageData EnvironmentData = PageDataManager.instance().getPageData("Config", tcID);
			data = PageDataManager.instance().getPageData("Submission", tcID);
			String producerID = "";
			String submittingAgent = "";
			String env = GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV");
			if (!env.isEmpty()) {
				if (env.equalsIgnoreCase("DEV")) {
					producerID = data.getData("ProducerID_QA");
					submittingAgent = data.getData("SubmittingAgentNPN_QA");
				} else {
					if (env.equalsIgnoreCase("QA")) {
						producerID = data.getData("ProducerID_QA");
						submittingAgent = data.getData("SubmittingAgentNPN_QA");
					} else {
						producerID = data.getData("ProducerID_Stage");
						submittingAgent = data.getData("SubmittingAgentNPN_Stage");
					}
				}
			} else {
				if (EnvironmentData.getData("Environment").equals("DEV")) {
					producerID = data.getData("ProducerID_QA");
					submittingAgent = data.getData("SubmittingAgentNPN_QA");
				} else {
					if (EnvironmentData.getData("Environment").equals("QA")) {
						producerID = data.getData("ProducerID_QA");
						submittingAgent = data.getData("SubmittingAgentNPN_QA");
					} else {
						producerID = data.getData("ProducerID_Stage");
						submittingAgent = data.getData("SubmittingAgentNPN_Stage");
					}
				}
			}
			String AccountName = cFunc.generate_RandomText(8);
			String AddressLine1 = cFunc.generate_RandomText(10);
			String strDate = null;
			String strEffectiveDate = null;
			String strExpirationDate = null;

			Date date = new Date();
			if (!env.isEmpty()) {
				if (env.equalsIgnoreCase("QA")) {
					 strDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date);
					strDate = strDate.split("T")[0] + "T00:00:01";
					 strEffectiveDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
					Date expDate = DateUtils.addYears(new Date(), 1);
					 strExpirationDate = new SimpleDateFormat("yyyy-MM-dd").format(expDate);
				}else {
					 strDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date);
						strDate = strDate.split("T")[0] + "T00:00:01";
						strEffectiveDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
						Date expDate = DateUtils.addYears(new Date(), 1);
						 strExpirationDate = new SimpleDateFormat("yyyy-MM-dd").format(expDate);
						/* strEffectiveDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date);
						 strEffectiveDate = strEffectiveDate.split("T")[0] + "T00:00:01";
						Date expDate = DateUtils.addYears(new Date(), 1);
						 strExpirationDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(expDate);
						 strExpirationDate = strExpirationDate.split("T")[0] + "T00:00:01";*/
				}
			}else {
				if (EnvironmentData.getData("Environment").equalsIgnoreCase("QA")) {
					strDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date);
					strDate = strDate.split("T")[0] + "T00:00:01";
					 strEffectiveDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
					Date expDate = DateUtils.addYears(new Date(), 1);
					 strExpirationDate = new SimpleDateFormat("yyyy-MM-dd").format(expDate);
				}else {
					 strDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date);
						strDate = strDate.split("T")[0] + "T00:00:01";
						strEffectiveDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
						Date expDate = DateUtils.addYears(new Date(), 1);
						 strExpirationDate = new SimpleDateFormat("yyyy-MM-dd").format(expDate);
						 /*strEffectiveDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date);
						 strEffectiveDate = strEffectiveDate.split("T")[0] + "T00:00:01";
						Date expDate = DateUtils.addYears(new Date(), 1);
						 strExpirationDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(expDate);
						 strExpirationDate = strExpirationDate.split("T")[0] + "T00:00:01";*/
				}
			}
			
			//strExpirationDate = strExpirationDate.split("T")[0] + "T00:00:01";
			String str1 = "";

			String input = cFunc.getUpdateInputAsString(payLoadPath);
			if (data.getData("name").contains("DS_SubmsOFACBlock_")
					|| data.getData("name").contains("DS_SubOFACBlk_")) {
				str1 = cFunc.updateInputRequest(input, "account", "primary_entity", "name",
						data.getData("OFACName/ExistingInsuredName"));
			} else if (data.getData("name").contains("DS_SubmBlockDueToName_")
					|| data.getData("ExpectedStatus").equalsIgnoreCase("Blocked")
							&& !(data.getData("OFACAddress/ExistingAdd").equalsIgnoreCase(""))) {
				str1 = cFunc.updateInputRequest(input, "account", "primary_entity", "name",
						cFunc.getFromProperty(data.getData("OFACName/ExistingInsuredName")));
			// cFunc.writeToProperty(data.getData("name")+"_"+"InsuredName",
			//	 response.path("account.primary_entity.account_address.address_line_1").toString());
			} else {
				str1 = cFunc.updateInputRequest(input, "account", "primary_entity", "name", AccountName);
			}
			String str10 = cFunc.updateInputRequest(str1, "account", "", "primary_naics_code", NaicsCode);
			String str2 = cFunc.updateInputRequest(str10, "submission", "", "submitted_date", strDate);
			String str3 = cFunc.updateInputRequest(str2, "submission", "", "effective_date", strEffectiveDate);
			String str4 = cFunc.updateInputRequest(str3, "submission", "", "expiration_date", strExpirationDate);
			String str5 = cFunc.updateInputRequest(str4, "submission", "", "predominant_state_code", stateCode);
			String str6 = cFunc.updateInputRequest(str5, "submission", "", "producer_id", producerID);
			String str7 = cFunc.updateInputRequest(str6, "submission", "", "submitting_agent_npn", submittingAgent);
			JSONObject requestObject = new JSONObject(str7);
			int noOfcovergaes = requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
					.getJSONObject("management_liability").getJSONArray("coverage_parts").length();

			GenericFunctions.instance()._addToGlobalVariableList("noOfcovergaes", Integer.toString(noOfcovergaes));

			for (int i = 0; i < noOfcovergaes; i++) {
				// requestObject.getJSONObject("submission").getJSONArray("products")
				// .getJSONObject(0).getJSONObject("management_liability").getJSONArray("coverage_parts").getJSONObject(i).put("coverage_part_code",
				// data.getData("CoveragePart"));
				GenericFunctions.instance()._addToGlobalVariableList("noOfcovergaes", Integer.toString(noOfcovergaes));

				String coverageType = requestObject.getJSONObject("submission").getJSONArray("products")
						.getJSONObject(0).getJSONObject("management_liability").getJSONArray("coverage_parts")
						.getJSONObject(i).get("coverage_part_code").toString();

				int respLimitValueComCov = 0;
				if (coverageType.equalsIgnoreCase("CRIME")) {
					requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
							.getJSONObject("management_liability").getJSONArray("coverage_parts").getJSONObject(i)
							.getJSONArray("coverages").getJSONObject(0)
							.put("limit", Integer.parseInt(data.getData(coverageType + "_limit")));
					requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
							.getJSONObject("management_liability").getJSONObject("exposure")
							.put("revenue", Integer.parseInt(data.getData("Revenue")));
					String PLD = "";// requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0).getJSONObject("management_liability").
					// getJSONArray("coverage_parts").getJSONObject(i).getJSONObject(coverageType.toLowerCase()).getJSONObject("expiring_coverage").get("prior_pending_litigation_date").toString();
					GenericFunctions.instance()._addToGlobalVariableList(coverageType + "_" + "PLD", PLD.split("T")[0]);

				}

				else {

					if (coverageType.equalsIgnoreCase("EMPLOYMENT_PRACTICES_LIABILITY")) {

						requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
								.getJSONObject("management_liability").getJSONObject("exposure")
								.put("foreign_employees", Integer.parseInt(data.getData("Foreign_Employee_Count")));
					}
					if (coverageType.equalsIgnoreCase("DIRECTORS_AND_OFFICERS")) {
						requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
								.getJSONObject("management_liability").getJSONObject("exposure")
								.put("corporate_assets", Integer.parseInt(data.getData("Corporate_assets")));
					}
					if (coverageType.equalsIgnoreCase("FIDUCIARY_LIABILITY")) {
						String participants = data.getData("Plan_Participants");
						String PLD = requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
								.getJSONObject("management_liability").getJSONArray("coverage_parts").getJSONObject(i)
								.getJSONObject(coverageType.toLowerCase()).getJSONObject("expiring_coverage")
								.get("prior_pending_litigation_date").toString();
						GenericFunctions.instance()._addToGlobalVariableList(coverageType + "_" + "PLD",
								PLD.split("T")[0]);
						
						requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
						.getJSONObject("management_liability").getJSONArray("coverage_parts").getJSONObject(i)
						.getJSONObject(coverageType.toLowerCase()).getJSONObject("employee_benefit_plans").put("participants", Integer.parseInt(participants));
					}
					requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
							.getJSONObject("management_liability").getJSONArray("coverage_parts").getJSONObject(i)
							.getJSONObject(coverageType.toLowerCase())
							.put("limit", Integer.parseInt(data.getData(coverageType.toLowerCase() + "_limit")));
					if (respLimitValueComCov < Integer.parseInt(data.getData(coverageType.toLowerCase() + "_limit"))) {
						respLimitValueComCov = Integer.parseInt(data.getData(coverageType.toLowerCase() + "_limit"));

					}

				}

				GenericFunctions.instance()._addToGlobalVariableList("respLimitValueComCov",
						Integer.toString(respLimitValueComCov));
				if(!(coverageType.equalsIgnoreCase("CYBER_LIABILITY"))) {

				requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
						.getJSONObject("management_liability").getJSONArray("coverage_parts").getJSONObject(i)
						.getJSONObject(coverageType.toLowerCase()).getJSONObject("expiring_coverage")
						.put("limit", Integer.parseInt(data.getData(coverageType.toLowerCase() + "_Expiringlimit")));
				}
			}

			String FirstCoverageType = requestObject.getJSONObject("submission").getJSONArray("products")
					.getJSONObject(0).getJSONObject("management_liability").getJSONArray("coverage_parts")
					.getJSONObject(0).get("coverage_part_code").toString();
			String reqExpectedLimitValueEscape = "";
			if (FirstCoverageType.equalsIgnoreCase("CRIME")) {

				reqExpectedLimitValueEscape = requestObject.getJSONObject("submission").getJSONArray("products")
						.getJSONObject(0).getJSONObject("management_liability").getJSONArray("coverage_parts")
						.getJSONObject(0).getJSONArray("coverages").getJSONObject(0).get("limit").toString();
			} else {

				reqExpectedLimitValueEscape = requestObject.getJSONObject("submission").getJSONArray("products")
						.getJSONObject(0).getJSONObject("management_liability").getJSONArray("coverage_parts")
						.getJSONObject(0).getJSONObject(FirstCoverageType.toLowerCase()).get("limit").toString();

			}
			
			GenericFunctions.instance()._addToGlobalVariableList("reqExpectedLimitValueEscape",
					reqExpectedLimitValueEscape);
			if(!(FirstCoverageType.equalsIgnoreCase("CYBER_LIABILITY"))) {
			requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
					.getJSONObject("management_liability").getJSONObject("exposure")
					.put("years_in_business", Integer.parseInt(data.getData("YearOfBussiness")));

			requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
					.getJSONObject("management_liability").getJSONObject("exposure")
					.put("number_of_locations", Integer.parseInt(data.getData("NumberOfLocations")));
			requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
					.getJSONObject("management_liability").getJSONObject("exposure")
					.put("percentage_of_voting_shares_owned",
							Integer.parseInt(data.getData("PercentageOfVotingShare")));
			requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
					.getJSONObject("management_liability").getJSONObject("subsidiaries")
					.put("number_of_subsidiaries", Integer.parseInt(data.getData("NumberOfSubsidiaries")));
			}
			/*if(FirstCoverageType.equalsIgnoreCase("CYBER_LIABILITY")) {
				requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
				.getJSONObject("management_liability").getJSONArray("coverage_parts")
				.getJSONObject(0).getJSONObject("cyber_liability")
				.put("total_storage_of_sensitive_data", data.getData("total_storage_of_sensitive_data"))
				.put("limit", Integer.parseInt(data.getData("cyber_liability_limit")))
				.put("retention", Integer.parseInt(data.getData("cyber_liability_retention")));
			if(data.getData("use_of_encryption")!=null) {
				if(data.getData("use_of_encryption")!="") {
				if(data.getData("use_of_encryption").equalsIgnoreCase("true")) {
					requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
					.getJSONObject("management_liability").getJSONArray("coverage_parts")
					.getJSONObject(0).getJSONObject("cyber_liability").put("use_of_encryption", true);
			
				}
				
				if(data.getData("use_of_encryption").equalsIgnoreCase("false")) {
					requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
					.getJSONObject("management_liability").getJSONArray("coverage_parts")
					.getJSONObject(0).getJSONObject("cyber_liability").put("use_of_encryption", false);
			
				}
			}
			}

				if(data.getData("technology_errors_and_omissions")!=null) {
					if(data.getData("technology_errors_and_omissions")!="") {
					if(data.getData("technology_errors_and_omissions").equalsIgnoreCase("true")) {
						requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
						.getJSONObject("management_liability").getJSONArray("coverage_parts")
						.getJSONObject(0).getJSONObject("cyber_liability").put("technology_errors_and_omissions", true);
				
					}
					
					if(data.getData("technology_errors_and_omissions").equalsIgnoreCase("false")) {
						requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
						.getJSONObject("management_liability").getJSONArray("coverage_parts")
						.getJSONObject(0).getJSONObject("cyber_liability").put("technology_errors_and_omissions", false);
				
					}
			}
				}
				//System.out.println(data.getData("cyber_revenue"));
			
			if(!(data.getData("cyber_revenue").equalsIgnoreCase("null"))) {
				if(!(data.getData("cyber_revenue").equals(""))) {
				requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
				.getJSONObject("management_liability").getJSONObject("exposure").put("revenue", Integer.parseInt(data.getData("cyber_revenue")));
			}
			}
			
			if(!(data.getData("prior_year_revenue").equalsIgnoreCase("null"))) {
				if(!(data.getData("prior_year_revenue").equals(""))) {
				requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
				.getJSONObject("management_liability").getJSONObject("exposure").put("prior_year_revenue",Integer.parseInt(data.getData("prior_year_revenue")));
			}
			}
			
			if((data.getData("question_id_1")!=null)) {
				if((data.getData("question_id_1")!="")) {
				int questnSize = requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
				.getJSONObject("management_liability").getJSONArray("underwriting_questions").length();
				for(int q=0;q<questnSize;q++) {
					String questionId =  requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
						.getJSONObject("management_liability").getJSONArray("underwriting_questions").getJSONObject(q).get("question_id").toString();
					if(questionId.equalsIgnoreCase(data.getData("question_id_1"))) {
						if(data.getData("selectedValue").equalsIgnoreCase("true")) {
							requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
							.getJSONObject("management_liability").getJSONArray("underwriting_questions").getJSONObject(q).put("selected", true);
						}else {
							requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
							.getJSONObject("management_liability").getJSONArray("underwriting_questions").getJSONObject(q).put("selected", false);

						}
					}
				}
				}
			}
			if(data.getData("question_id_2")!=null) {
				if(data.getData("question_id_2")!="") {
				int questnSize1 = requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
				.getJSONObject("management_liability").getJSONArray("coverage_parts")
				.getJSONObject(0).getJSONArray("underwriting_questions").length();
				for(int q1=0;q1<questnSize1;q1++) {
					String questionId =  requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
						.getJSONObject("management_liability").getJSONArray("coverage_parts")
						.getJSONObject(0).getJSONArray("underwriting_questions").getJSONObject(q1).get("question_id").toString();
					if(questionId.equalsIgnoreCase(data.getData("question_id_2"))) {
						if(data.getData("selectedValue").equalsIgnoreCase("true")) {
							requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
							.getJSONObject("management_liability").getJSONArray("coverage_parts")
							.getJSONObject(0).getJSONArray("underwriting_questions").getJSONObject(q1).put("selected", true);
						}else {
							requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
							.getJSONObject("management_liability").getJSONArray("coverage_parts")
							.getJSONObject(0).getJSONArray("underwriting_questions").getJSONObject(q1).put("selected", false);
						}
					}
				}
				}
			}
			}*/
			String str8 = requestObject.toString();

			System.out.println(str8);
			if ((data.getData("ExpectedStatus").equalsIgnoreCase("Blocked")
					&& !(data.getData("OFACAddress/ExistingAdd").equalsIgnoreCase("")))) {

				finalStr = cFunc.updateInputRequest(str8, "account", "account_address", "address_line_1",
						cFunc.getFromProperty(data.getData("OFACAddress/ExistingAdd")));
			} else {
				finalStr = cFunc.updateInputRequest(str8, "account", "account_address", "address_line_1", AddressLine1);
			}

			System.out.println(finalStr);
		} catch (Exception ex) {
			throw ex;
		}

		return finalStr;
	}

	public String modifyAccountSubmissionRequestForElligibityQues(String payLoadPath, PageData data, String stateCode)
			throws Exception {
		String finalStr = "";
		try {
			String AccountName = cFunc.generate_RandomText(8);
			String AddressLine1 = cFunc.generate_RandomText(10);

			Date date = new Date();
			String strDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date);
			strDate = strDate.split("T")[0] + "00:00:01";
			Date expDate = DateUtils.addYears(new Date(), 1);
			String strExpirationDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(expDate);
			strExpirationDate = strExpirationDate.split("T")[0] + "00:00:01";
			String input = cFunc.getUpdateInputAsString(payLoadPath);
			String str1 = cFunc.updateInputRequest(input, "account", "primary_entity", "name", AccountName);
			String str2 = cFunc.updateInputRequest(str1, "submission", "", "submitted_date", strDate);
			String str3 = cFunc.updateInputRequest(str2, "submission", "", "effective_date", strDate);
			String str4 = cFunc.updateInputRequest(str3, "submission", "", "expiration_date", strExpirationDate);
			String str5 = cFunc.updateInputRequest(str4, "submission", "", "predominant_state_code", stateCode);
			String str6 = cFunc.updateInputRequest(str5, "submission", "", "producer_id", data.getData("ProducerID"));
			String str7 = cFunc.updateInputRequest(str6, "submission", "", "submitting_agent_npn",
					data.getData("SubmittingAgentNPN"));
			JSONObject requestObject = new JSONObject(str7);
			requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
					.getJSONObject("management_liability").getJSONArray("coverage_parts").getJSONObject(0)
					.put("coverage_part_code", data.getData("CoveragePart"));
			String str8 = requestObject.toString();
			System.out.println(str8);
			finalStr = cFunc.updateInputRequest(str8, "account", "account_address", "address_line_1", AddressLine1);

		} catch (Exception ex) {
			throw ex;
		}

		return finalStr;
	}

	public void verifyAccountObj(String finalStr, String resbody, Response response, String URL) throws Exception {
		long startTime = System.currentTimeMillis();
		try {
			JSONObject requestObject = new JSONObject(finalStr);
			JSONObject responseObject = new JSONObject(resbody);

			String id = cFunc.getKeyValue(response, "account.account_id");

			// to verify account created
			if (!(id.equalsIgnoreCase("null") || id.equals(""))) {
				list.add(true);
				CustomReporting.logReport("", "", "Account Number is generated successfully : Account Id:" + id,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				;
				CustomReporting.logReport("", "", "Unable to Create Account Id", "", StepStatus.FAILURE,
						new String[] {}, startTime, null);
			}
			// to verify the fields of primary Entity.
			Map<String, String> responseAccountchildList = cFunc.getListOfKeyValue(resbody, "account");

			Map<String, String> inputAccountchildList = cFunc.getListOfKeyValue(finalStr, "account");
			for (String key : responseAccountchildList.keySet()) {

				if (!((inputAccountchildList.get(key)).contains("\"") || key.equalsIgnoreCase("account_id"))) {

					String inputAccountchildListvalue = inputAccountchildList.get(key);
					String responseAccountchildListvalue = responseAccountchildList.get(key);
					if (inputAccountchildListvalue.equals(responseAccountchildListvalue)) {
						list.add(true);
						CustomReporting.logReport("", "",
								key.toUpperCase() + "  value :  " + inputAccountchildListvalue.toUpperCase()
										+ " from Request is equal to " + key.toUpperCase() + " value in Response : "
										+ responseAccountchildListvalue.toUpperCase(),
								StepStatus.SUCCESS, new String[] {}, startTime);
					} else {
						list.add(false);
						;
						CustomReporting.logReport("", "",
								key.toUpperCase() + " value : " + inputAccountchildListvalue.toUpperCase()
										+ " from Request is not equal to " + key.toUpperCase() + " value in Response : "
										+ responseAccountchildListvalue.toUpperCase(),
								"", StepStatus.FAILURE, new String[] {}, startTime, null);
					}
				}
			}
			Map<String, String> inputPrimaryEntiyData = cFunc.getListOfKeyValue(resbody, "account", "primary_entity");

			Map<String, String> PrimaryEntiyDataData = cFunc.getListOfKeyValue(finalStr, "account", "primary_entity");
			for (String key1 : inputPrimaryEntiyData.keySet()) {
				if ((inputPrimaryEntiyData.get(key1)).contains("\"")) {
					inputPrimaryEntiyData = cFunc.getListOfKeyValueFromRequestPL(finalStr, "account", "primary_entity",
							key1);
					PrimaryEntiyDataData = cFunc.getListOfKeyValueFromRequestPL(resbody, "account", "primary_entity",
							key1);

					for (String Key2 : inputPrimaryEntiyData.keySet()) {
						if (PrimaryEntiyDataData.containsKey(Key2)) {
							String inputPrimaryEntityKeyValue = inputPrimaryEntiyData.get(Key2);
							String ResponsePrimaryEntityKeyValue = PrimaryEntiyDataData.get(Key2);
							if (inputPrimaryEntityKeyValue.equals(ResponsePrimaryEntityKeyValue)) {
								list.add(true);
								CustomReporting.logReport("", "",
										Key2.toUpperCase() + "  value :  " + inputPrimaryEntityKeyValue.toUpperCase()
												+ " from Request is equal to " + Key2.toUpperCase()
												+ " value in Response : " + ResponsePrimaryEntityKeyValue.toUpperCase(),
										StepStatus.SUCCESS, new String[] {}, startTime);
							} else {
								list.add(false);
								;
								CustomReporting.logReport("", "",
										Key2.toUpperCase() + " value : " + inputPrimaryEntityKeyValue.toUpperCase()
												+ " from Request is not equal to " + Key2.toUpperCase()
												+ " value in Response : " + ResponsePrimaryEntityKeyValue.toUpperCase(),
										"", StepStatus.FAILURE, new String[] {}, startTime, null);
							}
						}
					}

				}
				if (PrimaryEntiyDataData.containsKey(key1)) {
					String inputPrimaryEntityKeyValue = inputPrimaryEntiyData.get(key1);
					String ResponsePrimaryEntityKeyValue = PrimaryEntiyDataData.get(key1);
					if (inputPrimaryEntityKeyValue.equals(ResponsePrimaryEntityKeyValue)) {
						list.add(true);
						CustomReporting.logReport("", "",
								key1.toUpperCase() + "  value :  " + inputPrimaryEntityKeyValue.toUpperCase()
										+ " from Request is equal to " + key1.toUpperCase() + " value in Response : "
										+ ResponsePrimaryEntityKeyValue.toUpperCase(),
								StepStatus.SUCCESS, new String[] {}, startTime);
					} else {
						list.add(false);
						;
						CustomReporting.logReport("", "",
								key1.toUpperCase() + " value : " + inputPrimaryEntityKeyValue.toUpperCase()
										+ " from Request is not equal to " + key1.toUpperCase()
										+ " value in Response : " + ResponsePrimaryEntityKeyValue.toUpperCase(),
								"", StepStatus.FAILURE, new String[] {}, startTime, null);
					}
				}

			}
			// verify address details
			Map<String, String> addressData = cFunc.getListOfKeyValue(resbody, "account", "account_address");
			Map<String, String> inputAddressData = cFunc.getListOfKeyValueFromPayLoad(finalStr, "account",
					"account_address");

			for (String key : inputAddressData.keySet()) {
				if (addressData.containsKey(key)) {
					String inputValue = inputAddressData.get(key);
					String responseValue = addressData.get(key);
					if (responseValue.equals(inputValue)) {
						list.add(true);
						CustomReporting.logReport("", "",
								key.toUpperCase() + " value : " + inputValue.toUpperCase()
										+ " from Request is equal to " + key.toUpperCase() + "  value in Response : "
										+ responseValue.toUpperCase(),
								StepStatus.SUCCESS, new String[] {}, startTime);
					} else {
						list.add(false);
						;
						CustomReporting.logReport("", "",
								key.toUpperCase() + " value : " + inputValue.toUpperCase()
										+ " from Request is not equal to " + key.toUpperCase() + " value in Response : "
										+ responseValue.toUpperCase(),
								"", StepStatus.FAILURE, new String[] {}, startTime, null);
					}

				}
			}

			// Map<String, String> reqOtherEntities = cFunc.getListOfKeyValue(
			// requestObject.getJSONObject("account").getJSONArray("other_entities").getJSONObject(0));
			// Map<String, String> respOtherEntities = cFunc.getListOfKeyValue(
			// responseObject.getJSONObject("account").getJSONArray("other_entities").getJSONObject(0));
			//
			// for (String key : reqOtherEntities.keySet()) {
			// if (respOtherEntities.containsKey(key)) {
			// String inputValue = reqOtherEntities.get(key);
			// String responseValue = respOtherEntities.get(key);
			// if (responseValue.equals(inputValue)) {
			// list.add(true);
			// CustomReporting.logReport("", "",
			// key.toUpperCase() + " value : " + inputValue.toUpperCase()
			// + " from Request is equal to " + key.toUpperCase() + " value in Response : "
			// + responseValue.toUpperCase() + " for Other Entites",
			// StepStatus.SUCCESS, new String[] {}, startTime);
			// } else {
			// list.add(false);
			//
			// CustomReporting.logReport("", "",
			// key.toUpperCase() + " value : " + inputValue.toUpperCase()
			// + " from Request is not equal to " + key.toUpperCase() + " value in Response
			// : "
			// + responseValue.toUpperCase() + " for Other Entites",
			// "", StepStatus.FAILURE, new String[] {}, startTime, null);
			// }
			//
			// }
			//
			 cFunc.writeToProperty(data.getData("name")+"_"+"InsuredName",
			response.path("account.primary_entity.name").toString());
			cFunc.writeToProperty(data.getData("name")+"_"+"Address1",
			response.path("account.account_address.address_line_1").toString());
			// }

		} catch (Exception e) {
			throw e;
		}
	}

	// public void verifySubmissionObjOld(String finalStr, String resbody, Response
	// response, String URL) throws Exception {
	// try {
	//
	// // verify submission id generated
	// String submissionId = cFunc.getKeyValue(response,
	// "submission.submission_id");
	// if (!(submissionId.equalsIgnoreCase("null") || submissionId.equals(""))) {
	// list.add(true);
	// CustomReporting.logReport("", "", " Submission Id generated successfully " +
	// submissionId,
	// StepStatus.SUCCESS, new String[] {}, startTime);
	// } else {
	// list.add(false);
	// CustomReporting.logReport("", "", "Submission Id is not generated " +
	// submissionId,
	// StepStatus.FAILURE, new String[] {}, startTime);
	// }
	// GenericFunctions.instance()._addToGlobalVariableList("submissionId",
	// submissionId);
	//
	// String respSubmissionStatus = cFunc.getKeyValue(response,
	// "submission.submission_status");
	// String respSubmissionStatusCode = cFunc.getKeyValue(response,
	// "submission.submission_status_code");
	// String respStateCode = cFunc.getKeyValue(response,
	// "submission.predominant_state_code");
	//
	// if (respSubmissionStatus.equalsIgnoreCase(data.getData("ExpectedStatus")) ) {
	// list.add(true);
	// CustomReporting.logReport("", "",
	// " Submission Status value in Response is equal to : "
	// + respSubmissionStatus.toUpperCase() + " for predominant state code " +
	// respStateCode + " is as expected" ,
	// StepStatus.SUCCESS, new String[] {}, startTime);
	//
	// }else {
	// list.add(false);
	// CustomReporting.logReport("", "",
	// " Submission Status value in Response : "
	// + respSubmissionStatus.toUpperCase() + " for predominant state code " +
	// respStateCode + " is not as expected",
	// StepStatus.FAILURE, new String[] {}, startTime);
	//
	// }
	//
	// if
	// (respSubmissionStatusCode.equalsIgnoreCase(data.getData("ExpectedStatusCode"))
	// ) {
	// list.add(true);
	// CustomReporting.logReport("", "",
	// " Submission Status Code value in Response is equal to : "
	// + respSubmissionStatus.toUpperCase() + " for predominant state code " +
	// respStateCode + " is as expected" ,
	// StepStatus.SUCCESS, new String[] {}, startTime);
	//
	// }else {
	// list.add(false);
	// CustomReporting.logReport("", "",
	// " Submission Status Code value in Response : "
	// + respSubmissionStatus.toUpperCase() + " for predominant state code " +
	// respStateCode + " is not as expected",
	// StepStatus.FAILURE, new String[] {}, startTime);
	//
	// }
	//
	// String reqSubmissionDate = cFunc.getKeyValueFromInputStr(finalStr,
	// "submission", "submitted_date")
	// .substring(0, 10);
	//
	// String respSubmissionDate = cFunc.getKeyValue(response,
	// "submission.submitted_date").substring(0, 10);
	//
	// if (respSubmissionDate.equals(reqSubmissionDate)) {
	// list.add(true);
	// CustomReporting.logReport("", "",
	// " Submission Date value : " + reqSubmissionDate
	// + " from Request is same as Submission Date value in Response : " +
	// respSubmissionDate,
	// StepStatus.SUCCESS, new String[] {}, startTime);
	// } else {
	// list.add(false);
	// CustomReporting.logReport("", "", " Submission Date value : " +
	// reqSubmissionDate
	// + " from Request is not same as Submission Date value in Response : " +
	// respSubmissionDate,
	// StepStatus.FAILURE, new String[] {}, startTime);
	//
	// }
	//
	// // verify effective date
	// String reqEffectiveDate = cFunc.getKeyValueFromInputStr(finalStr,
	// "submission", "effective_date")
	// .substring(0, 10);
	// String respEffectiveDate = cFunc.getKeyValue(response,
	// "submission.effective_date").substring(0, 10);
	// if (respEffectiveDate.equals(reqEffectiveDate)) {
	// list.add(true);
	// CustomReporting.logReport("", "",
	// " Effective Date value : " + reqEffectiveDate
	// + " from Request is same as Effective Date value in Response : " +
	// respEffectiveDate,
	// StepStatus.SUCCESS, new String[] {}, startTime);
	// } else {
	// list.add(false);
	// CustomReporting.logReport("", "", " Effective Date value : " +
	// respEffectiveDate
	// + " from Request is not same as Effective Date value in Response : " +
	// respEffectiveDate,
	// StepStatus.FAILURE, new String[] {}, startTime);
	//
	// }
	// // verify Expiration date
	// String reqExpirationDate = cFunc.getKeyValueFromInputStr(finalStr,
	// "submission", "expiration_date")
	// .substring(0, 10);
	// String respExpirationDate = cFunc.getKeyValue(response,
	// "submission.expiration_date").substring(0, 10);
	// System.out.println("req " + reqExpirationDate + " respExpirationDate " +
	// respExpirationDate);
	// if (respExpirationDate.equals(reqExpirationDate)) {
	// list.add(true);
	// CustomReporting.logReport("", "",
	// " Expiration Date value : " + reqExpirationDate
	// + " from Request is same as Expiration Date value in Response : " +
	// respExpirationDate,
	// StepStatus.SUCCESS, new String[] {}, startTime);
	// } else {
	// list.add(false);
	// CustomReporting.logReport("", "", " Expiration Date value : " +
	// reqExpirationDate
	// + " from Request is not same as Expiration Date value in Response : " +
	// respExpirationDate,
	// StepStatus.FAILURE, new String[] {}, startTime);
	//
	// }
	// String reqProdId = cFunc.getKeyValueFromInputStr(finalStr, "submission",
	// "producer_id");
	// String respProdId = cFunc.getKeyValue(response, "submission.producer_id");
	// if (respProdId.equalsIgnoreCase(reqProdId)) {
	// list.add(true);
	// CustomReporting.logReport("", "",
	// " Producer Id value : " + reqProdId
	// + " from Request is same as Producer Id value in Response : " + respProdId,
	// StepStatus.SUCCESS, new String[] {}, startTime);
	// } else {
	// list.add(false);
	// CustomReporting.logReport("", "",
	// " Producer Id value : " + reqProdId
	// + " from Request is not same as Producer Id value in Response : " +
	// respProdId,
	// StepStatus.FAILURE, new String[] {}, startTime);
	//
	// }
	//
	// String reqSubmittingAgentNPN = cFunc.getKeyValueFromInputStr(finalStr,
	// "submission", "submitting_agent_npn");
	// String respSubmittingAgentNPN = cFunc.getKeyValue(response,
	// "submission.submitting_agent_npn");
	// if (respSubmittingAgentNPN.equalsIgnoreCase(reqSubmittingAgentNPN)) {
	// list.add(true);
	// CustomReporting.logReport("", "",
	// " Submitting Agent NPN value : " + reqSubmittingAgentNPN
	// + " from Request is same as Submitting Agent NPN value in Response : " +
	// respSubmittingAgentNPN,
	// StepStatus.SUCCESS, new String[] {}, startTime);
	// } else {
	// list.add(false);
	// CustomReporting.logReport("", "",
	// " Submitting Agent NPN value : " + reqSubmittingAgentNPN
	// + " from Request is not same as Submitting Agent NPN value in Response : " +
	// respSubmittingAgentNPN,
	// StepStatus.FAILURE, new String[] {}, startTime);
	//
	// }
	// } catch (Exception e) {
	// throw e;
	// }
	// }

	public void verifySubmissionObj(String finalStr, String resbody, Response response, String URL) throws Exception {
		try {

			// verify submission id generated
			JSONObject reqSubObj = new JSONObject(finalStr);
			JSONObject resSubObj = new JSONObject(resbody);
			String ProducerName = cFunc.getKeyValue(response, "submission.extensions[0].values[5].value");
			GenericFunctions.instance()._addToGlobalVariableList("resProducerName", ProducerName);
			String submissionId = cFunc.getKeyValue(response, "submission.submission_id");
			if (!(submissionId.equalsIgnoreCase("null") || submissionId.equals(""))) {
				list.add(true);
				CustomReporting.logReport("", "", " Submission Id generated successfully " + submissionId,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "", "Submission Id is not generated  " + submissionId, StepStatus.FAILURE,
						new String[] {}, startTime);
			}
			GenericFunctions.instance()._addToGlobalVariableList("submissionId", submissionId);

			String respSubmissionStatus = cFunc.getKeyValue(response, "submission.submission_status");
			String respSubmissionStatusCode = cFunc.getKeyValue(response, "submission.submission_status_code");
			String respStateCode = cFunc.getKeyValue(response, "submission.predominant_state_code");
			String respProductCode = cFunc.getKeyValue(response, "submission.products[0].product_code");
			GenericFunctions.instance()._addToGlobalVariableList("respStateCode", respStateCode);

			if (respSubmissionStatus.equalsIgnoreCase(data.getData("ExpectedStatus"))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"  Submission Status value in Response is equal to : " + respSubmissionStatus.toUpperCase()
								+ " for predominant state code " + respStateCode + " is as expected",
						StepStatus.SUCCESS, new String[] {}, startTime);

			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Submission Status value in Response : " + respSubmissionStatus.toUpperCase()
								+ " for predominant state code " + respStateCode + " is not as expected",
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			if (respSubmissionStatusCode.equalsIgnoreCase(data.getData("ExpectedStatusCode"))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"  Submission Status Code value in Response is equal to : " + respSubmissionStatus.toUpperCase()
								+ " for predominant state code " + respStateCode + " is as expected",
						StepStatus.SUCCESS, new String[] {}, startTime);

			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Submission Status Code value in Response : " + respSubmissionStatus.toUpperCase()
								+ " for predominant state code " + respStateCode + " is not as expected",
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			String reqSubmissionDate = cFunc.getKeyValueFromInputStr(finalStr, "submission", "submitted_date")
					.substring(0, 10);

			String respSubmissionDate = cFunc.getKeyValue(response, "submission.submitted_date").substring(0, 10);

			if (respSubmissionDate.equals(reqSubmissionDate)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Submission Date value : " + reqSubmissionDate
								+ " from Request is same as Submission Date value in Response : " + respSubmissionDate,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "", " Submission Date value : " + reqSubmissionDate
						+ " from Request is not same as Submission Date value in Response : " + respSubmissionDate,
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			// verify effective date
			String reqEffectiveDate = cFunc.getKeyValueFromInputStr(finalStr, "submission", "effective_date")
					.substring(0, 10);
			String respEffectiveDate = cFunc.getKeyValue(response, "submission.effective_date").substring(0, 10);
			GenericFunctions.instance()._addToGlobalVariableList("respEffectiveDate", respEffectiveDate);
			if (respEffectiveDate.equals(reqEffectiveDate)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Effective Date value : " + reqEffectiveDate
								+ " from Request is same as Effective Date value in Response : " + respEffectiveDate,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "", " Effective Date value : " + respEffectiveDate
						+ " from Request is not same as Effective Date value in Response : " + respEffectiveDate,
						StepStatus.FAILURE, new String[] {}, startTime);

			}
			// verify Expiration date
			String reqExpirationDate = cFunc.getKeyValueFromInputStr(finalStr, "submission", "expiration_date")
					.substring(0, 10);
			String respExpirationDate = cFunc.getKeyValue(response, "submission.expiration_date").substring(0, 10);
			GenericFunctions.instance()._addToGlobalVariableList("respExpirationDate", respExpirationDate);
			System.out.println("req " + reqExpirationDate + " respExpirationDate " + respExpirationDate);
			if (respExpirationDate.equals(reqExpirationDate)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Expiration Date value : " + reqExpirationDate
								+ " from Request is same as Expiration Date value in Response : " + respExpirationDate,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "", " Expiration Date value : " + reqExpirationDate
						+ " from Request is not same as Expiration Date value in Response : " + respExpirationDate,
						StepStatus.FAILURE, new String[] {}, startTime);

			}
			String reqProdId = cFunc.getKeyValueFromInputStr(finalStr, "submission", "producer_id");
			String respProdId = cFunc.getKeyValue(response, "submission.producer_id");
			if (respProdId.equalsIgnoreCase(reqProdId)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Producer Id value : " + reqProdId
								+ " from Request is same as Producer Id value in Response : " + respProdId,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Producer Id value : " + reqProdId
								+ " from Request is not same as Producer Id value in Response : " + respProdId,
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			String reqSubmittingAgentNPN = cFunc.getKeyValueFromInputStr(finalStr, "submission",
					"submitting_agent_npn");
			String respSubmittingAgentNPN = cFunc.getKeyValue(response, "submission.submitting_agent_npn");
			if (respSubmittingAgentNPN.equalsIgnoreCase(reqSubmittingAgentNPN)) {
				list.add(true);
				CustomReporting.logReport("", "", " Submitting Agent NPN value : " + reqSubmittingAgentNPN
						+ " from Request is same as Submitting Agent NPN value in Response : " + respSubmittingAgentNPN,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Submitting Agent NPN value : " + reqSubmittingAgentNPN
								+ " from Request is not same as Submitting Agent NPN value in Response : "
								+ respSubmittingAgentNPN,
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			// verification of contacts
			
			JSONArray reqcontactsArry = reqSubObj.getJSONObject("submission").getJSONArray("contacts");
			JSONArray respcontactsArry = resSubObj.getJSONObject("submission").getJSONArray("contacts");

			for (int i = 0; i < reqcontactsArry.length(); i++) {
				Map<String, String> reqContacts = cFunc.getListOfKeyValue(reqcontactsArry.getJSONObject(i));
				Map<String, String> resContacts = cFunc.getListOfKeyValue(respcontactsArry.getJSONObject(i));
				for (String key : reqContacts.keySet()) {
					if (resContacts.containsKey(key)) {
						String inputValue = reqContacts.get(key);
						String responseValue = resContacts.get(key);
						if (responseValue.equals(inputValue)) {
							list.add(true);
							CustomReporting.logReport("", "",
									key.toUpperCase() + " value : " + inputValue.toUpperCase()
											+ " from Request is equal to " + key.toUpperCase()
											+ "  value in Response : " + responseValue.toUpperCase(),
									StepStatus.SUCCESS, new String[] {}, startTime);
						} else {
							list.add(false);

							CustomReporting.logReport("", "",
									key.toUpperCase() + " value : " + inputValue.toUpperCase()
											+ " from Request is not equal to " + key.toUpperCase()
											+ " value in Response : " + responseValue.toUpperCase(),
									"", StepStatus.FAILURE, new String[] {}, startTime, null);
						}

					}
				}

			
			}

			// verification of products section
			JSONArray reqProductsArry = reqSubObj.getJSONObject("submission").getJSONArray("products");
			JSONArray respProductsArry = resSubObj.getJSONObject("submission").getJSONArray("products");
			for (int j = 0; j < reqProductsArry.length(); j++) {
				// verify tax exempt status
				// Map<String, String> reqProducts_tax =
				// cFunc.getListOfKeyValue(reqProductsArry.getJSONObject(j)
				// .getJSONObject("management_liability").getJSONObject("tax_exempt_status"));
				// Map<String, String> resProducts_tax =
				// cFunc.getListOfKeyValue(respProductsArry.getJSONObject(j)
				// .getJSONObject("management_liability").getJSONObject("tax_exempt_status"));
				// for (String key : reqProducts_tax.keySet()) {
				// if (resProducts_tax.containsKey(key)) {
				// String inputValue = reqProducts_tax.get(key);
				// String responseValue = resProducts_tax.get(key);
				// if (responseValue.equals(inputValue)) {
				// list.add(true);
				// CustomReporting.logReport("", "",
				// key.toUpperCase() + " value : " + inputValue.toUpperCase()
				// + " from Request is equal to " + key.toUpperCase()
				// + " value in Response : " + responseValue.toUpperCase(),
				// StepStatus.SUCCESS, new String[] {}, startTime);
				// } else {
				// list.add(false);
				//
				// CustomReporting.logReport("", "",
				// key.toUpperCase() + " value : " + inputValue.toUpperCase()
				// + " from Request is not equal to " + key.toUpperCase()
				// + " value in Response : " + responseValue.toUpperCase(),
				// "", StepStatus.FAILURE, new String[] {}, startTime, null);
				// }
				//
				// }
				// }

				// verify subsidiaries
				
				Map<String, String> reqProducts_subsidiaries = cFunc.getListOfKeyValue(reqProductsArry.getJSONObject(j)
						.getJSONObject("management_liability").getJSONObject("subsidiaries"));
				Map<String, String> resProducts_subsidiaries = cFunc.getListOfKeyValue(respProductsArry.getJSONObject(j)
						.getJSONObject("management_liability").getJSONObject("subsidiaries"));
				for (String key : reqProducts_subsidiaries.keySet()) {
					if (resProducts_subsidiaries.containsKey(key)) {
						String inputValue = reqProducts_subsidiaries.get(key);
						String responseValue = resProducts_subsidiaries.get(key);
						if (responseValue.equals(inputValue)) {
							list.add(true);
							CustomReporting.logReport("", "",
									key.toUpperCase() + " value : " + inputValue.toUpperCase()
											+ " from Request is equal to " + key.toUpperCase()
											+ "  value in Response : " + responseValue.toUpperCase(),
									StepStatus.SUCCESS, new String[] {}, startTime);
						} else {
							list.add(false);

							CustomReporting.logReport("", "",
									key.toUpperCase() + " value : " + inputValue.toUpperCase()
											+ " from Request is not equal to " + key.toUpperCase()
											+ " value in Response : " + responseValue.toUpperCase(),
									"", StepStatus.FAILURE, new String[] {}, startTime, null);
						}

					}
				}
				

				// verify exposures
				Map<String, String> reqProducts_exposure = cFunc.getListOfKeyValue(reqProductsArry.getJSONObject(j)
						.getJSONObject("management_liability").getJSONObject("exposure"));
				Map<String, String> resProducts_exposure = cFunc.getListOfKeyValue(respProductsArry.getJSONObject(j)
						.getJSONObject("management_liability").getJSONObject("exposure"));
				for (String key : reqProducts_exposure.keySet()) {
					if (resProducts_exposure.containsKey(key)) {
						String inputValue = reqProducts_exposure.get(key);

						String responseValue = resProducts_exposure.get(key);
						if (responseValue.equals(inputValue)) {
							list.add(true);
							CustomReporting.logReport("", "",
									key.toUpperCase() + " value : " + inputValue.toUpperCase()
											+ " from Request is equal to " + key.toUpperCase()
											+ "  value in Response : " + responseValue.toUpperCase(),
									StepStatus.SUCCESS, new String[] {}, startTime);
						} else {
							list.add(false);

							CustomReporting.logReport("", "",
									key.toUpperCase() + " value : " + inputValue.toUpperCase()
											+ " from Request is not equal to " + key.toUpperCase()
											+ " value in Response : " + responseValue.toUpperCase(),
									"", StepStatus.FAILURE, new String[] {}, startTime, null);
						}

					}
				}

				JSONArray reqcoveragePartsArr = reqProductsArry.getJSONObject(j).getJSONObject("management_liability")
						.getJSONArray("coverage_parts");
				JSONArray rescoveragePartsArr = respProductsArry.getJSONObject(j).getJSONObject("management_liability")
						.getJSONArray("coverage_parts");
				for (int k = 0; k < reqcoveragePartsArr.length(); k++) {
					String reqcoveragePartCode = reqcoveragePartsArr.getJSONObject(k).get("coverage_part_code")
							.toString();
					String rescoveragePartCode = rescoveragePartsArr.getJSONObject(k).get("coverage_part_code")
							.toString();

					if (rescoveragePartCode.equalsIgnoreCase(reqcoveragePartCode)) {
						list.add(true);
						CustomReporting.logReport("", "", " Coverage Part Code value : " + reqcoveragePartCode
								+ " from Request is same as Coverage Type value in Response : " + rescoveragePartCode,
								StepStatus.SUCCESS, new String[] {}, startTime);
					} else {
						list.add(false);
						CustomReporting.logReport("", "",
								" Coverage Part Code value : " + reqcoveragePartCode
										+ " from Request is not same as Coverage Type value in Response : "
										+ rescoveragePartCode,
								StepStatus.FAILURE, new String[] {}, startTime);

					}
					Map<String, String> reqProducts_expiring_coverage = cFunc.getListOfKeyValue(
							reqcoveragePartsArr.getJSONObject(k).getJSONObject(reqcoveragePartCode.toLowerCase())
									.getJSONObject("expiring_coverage"));
					Map<String, String> resProducts_expiring_coverage = cFunc.getListOfKeyValue(
							rescoveragePartsArr.getJSONObject(k).getJSONObject(rescoveragePartCode.toLowerCase())
									.getJSONObject("expiring_coverage"));
					for (String key : reqProducts_expiring_coverage.keySet()) {
						if (resProducts_expiring_coverage.containsKey(key)) {
							String inputValue = reqProducts_expiring_coverage.get(key);
							String responseValue = resProducts_expiring_coverage.get(key);
							if (responseValue.equals(inputValue)) {
								list.add(true);
								CustomReporting.logReport("", "",
										key.toUpperCase() + " value : " + inputValue.toUpperCase()
												+ " from Request is equal to " + key.toUpperCase()
												+ "  value in Response : " + responseValue.toUpperCase(),
										StepStatus.SUCCESS, new String[] {}, startTime);
							} else {
								list.add(false);

								CustomReporting.logReport("", "",
										key.toUpperCase() + " value : " + inputValue.toUpperCase()
												+ " from Request is not equal to " + key.toUpperCase()
												+ " value in Response : " + responseValue.toUpperCase(),
										"", StepStatus.FAILURE, new String[] {}, startTime, null);
							}

						}
					}

					Map<String, String> reqProducts_crime = cFunc.getListOfKeyValue(
							reqcoveragePartsArr.getJSONObject(k).getJSONObject(reqcoveragePartCode.toLowerCase()));
					Map<String, String> resProducts_crime = cFunc.getListOfKeyValue(
							rescoveragePartsArr.getJSONObject(k).getJSONObject(rescoveragePartCode.toLowerCase()));
					for (String key : reqProducts_crime.keySet()) {
						if (resProducts_crime.containsKey(key)) {
							String inputValue = reqProducts_crime.get(key);
							String responseValue = resProducts_crime.get(key);
							if (!key.equals("retention")) {
								if (responseValue.equals(inputValue)) {
									list.add(true);
									CustomReporting.logReport("", "",
											key.toUpperCase() + " value : " + inputValue.toUpperCase()
													+ " from Request is equal to " + key.toUpperCase()
													+ "  value in Response : " + responseValue.toUpperCase(),
											StepStatus.SUCCESS, new String[] {}, startTime);
								} else {
									list.add(false);

									CustomReporting.logReport("", "",
											key.toUpperCase() + " value : " + inputValue.toUpperCase()
													+ " from Request is not equal to " + key.toUpperCase()
													+ " value in Response : " + responseValue.toUpperCase(),
											"", StepStatus.FAILURE, new String[] {}, startTime, null);
								}
							}
						}
					}
					// JSONArray requnderwriterQuestnArr = reqcoveragePartsArr.getJSONObject(k)
					// .getJSONArray("underwriting_questions");
					// JSONArray resunderwriterQuestnArr = rescoveragePartsArr.getJSONObject(k)
					// .getJSONArray("underwriting_questions");
					// for (int x = 0; x < requnderwriterQuestnArr.length(); x++) {
					// Map<String, String> reqProducts_UW = cFunc
					// .getListOfKeyValue(requnderwriterQuestnArr.getJSONObject(x));
					// Map<String, String> resProducts_UW = cFunc
					// .getListOfKeyValue(resunderwriterQuestnArr.getJSONObject(x));
					// for (String key : reqProducts_UW.keySet()) {
					// if (resProducts_UW.containsKey(key)) {
					// String inputValue = reqProducts_UW.get(key);
					// String responseValue = resProducts_UW.get(key);
					// if (responseValue.equals(inputValue)) {
					// list.add(true);
					// CustomReporting.logReport("", "",
					// key.toUpperCase() + " value : " + inputValue.toUpperCase()
					// + " from Request is equal to " + key.toUpperCase()
					// + " value in Response : " + responseValue.toUpperCase(),
					// StepStatus.SUCCESS, new String[] {}, startTime);
					// } else {
					// list.add(false);
					//
					// CustomReporting.logReport("", "",
					// key.toUpperCase() + " value : " + inputValue.toUpperCase()
					// + " from Request is not equal to " + key.toUpperCase()
					// + " value in Response : " + responseValue.toUpperCase(),
					// "", StepStatus.FAILURE, new String[] {}, startTime, null);
					// }
					//
					// }
					// }
					// }
					// String resCoveragePartCode = cFunc.getKeyValue(response,
					// "submission.products[0].management_liability.coverage_parts[0].coverage_part_code");
					if (rescoveragePartCode.equals("CRIME")) {
						int coveragesArr = reqcoveragePartsArr.getJSONObject(k).getJSONArray("coverages").length();
						for (int c = 0; c < coveragesArr; c++) {
							String reqcoverageType = reqcoveragePartsArr.getJSONObject(k).getJSONArray("coverages")
									.getJSONObject(c).get("type").toString();
							String rescoverageType = rescoveragePartsArr.getJSONObject(k).getJSONArray("coverages")
									.getJSONObject(c).get("type").toString();

							if (rescoverageType.equalsIgnoreCase(reqcoverageType)) {
								list.add(true);
								CustomReporting.logReport("", "",
										" Coverage Type value : " + reqcoverageType
												+ " from Request is same as Coverage Type value in Response : "
												+ rescoverageType,
										StepStatus.SUCCESS, new String[] {}, startTime);
							} else {
								list.add(false);
								CustomReporting.logReport("", "",
										" Coverage Type value : " + reqcoverageType
												+ " from Request is not same as Coverage Type value in Response : "
												+ rescoverageType,
										StepStatus.FAILURE, new String[] {}, startTime);

							}

						}
					}
				}

			}

		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unused")
	@Override
	public void verifySubmissionStatusAgainstElligibilityQues(String tcID, SoftAssert softAssert, String DeviceName,
			String DataSheetName) throws Exception {

		try {

			PageData EnvironmentData = PageDataManager.instance().getPageData("Config", tcID);
			data = PageDataManager.instance().getPageData("Submission", tcID);
			escapeData = PageDataManager.instance().getPageData("EscapeApplicationPage", tcID);
			String endPointURL = "";
			String env = GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV");
			if (!env.isEmpty()) {
				if (env.equalsIgnoreCase("DEV")) {
					endPointURL = data.getData("DEVEndPointUrl");
				} else {
					if (env.equalsIgnoreCase("QA")) {
						endPointURL = data.getData("QAEndPointUrl");
					} else {
						endPointURL = data.getData("DEVURL");
					}
				}
			} else {
				if (EnvironmentData.getData("Environment").equals("DEV")) {
					endPointURL = data.getData("DEVEndPointUrl");
				} else {
					if (EnvironmentData.getData("Environment").equals("QA")) {
						endPointURL = data.getData("QAEndPointUrl");
					} else {
						endPointURL = data.getData("STAGEEndPointUrl");
					}
				}
			}
			String strScreenShots = EnvironmentData.getData("PrintScreens");
			if (strScreenShots.equalsIgnoreCase("Yes")) {
				func._takeScreenShot(getWebDriver(), "START", "", "");
			}
			WebServiceGenerateAuthTokenImpl authcodeobj = new WebServiceGenerateAuthTokenImpl();
			String authcode = authcodeobj.generateAuthTokenCode(tcID, softAssert);
			String path = data.getData("Payloadpath");
			// String ReqUrl = data.getData("EndPointUrl");
			String authKey = "Bearer " + authcode;
			String cType = data.getData("ContentType");
			String stateCodeList = data.getData("StateCode");
			// ques
			JSONObject requestObject = new JSONObject(cFunc.getUpdateInputAsString(path));
			Map<String, String> ObjUpdatedPLmap = new LinkedHashMap<String, String>();
			Map<String, String> ObjPLmap = new LinkedHashMap<String, String>();
			Map<String, String> ObjDataSheetmap = new LinkedHashMap<String, String>();
			int ElligibilityQuesSize = requestObject.getJSONObject("submission").getJSONArray("products")
					.getJSONObject(0).getJSONObject("management_liability").getJSONArray("coverage_parts")
					.getJSONObject(0).getJSONArray("underwriting_questions").length();

			ExcelDataReader EligibilityQuestions = new ExcelDataReader("./resources/TestData.xlsx");
			for (int j = 2; j <= ElligibilityQuesSize + 1; j++) {
				String Questions = EligibilityQuestions.getCellData(DataSheetName, "Underwriting Question", j)
						.toString();
				String value = EligibilityQuestions.getCellData(DataSheetName, "Value", j).toString();
				ObjDataSheetmap.put(Questions.toUpperCase().trim(), value.toUpperCase().trim());

			}

			int i;
			for (i = 0; i < ElligibilityQuesSize; i++) {
				String SelectedValue = requestObject.getJSONObject("submission").getJSONArray("products")
						.getJSONObject(0).getJSONObject("management_liability").getJSONArray("coverage_parts")
						.getJSONObject(0).getJSONArray("underwriting_questions").getJSONObject(i).get("selected")
						.toString();
				Boolean selectedValue = !(Boolean.parseBoolean(SelectedValue));

				String QuestionId = requestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
						.getJSONObject("management_liability").getJSONArray("coverage_parts").getJSONObject(0)
						.getJSONArray("underwriting_questions").getJSONObject(i).get("question_id").toString();
				ObjPLmap.put(QuestionId.toUpperCase().trim(), SelectedValue.toUpperCase().trim());
				ObjUpdatedPLmap.put(QuestionId.trim(), selectedValue.toString().trim());

			}

			System.out.println(ObjDataSheetmap);
			System.out.println(ObjPLmap);

			if (ObjDataSheetmap.equals(ObjPLmap)) {
				list.add(true);
				CustomReporting.logReport("", "",
						"The underwritting Quetionts and its value is matching with the payload: " + "" + "as epected."
								+ "",
						StepStatus.SUCCESS, new String[] {}, startTime);
				System.out.println(ObjDataSheetmap.equals(ObjPLmap));

			} else {
				list.add(false);

				CustomReporting.logReport("", "",
						"The underwritting Questions and its value is not matching with the payload" + "" + "", "",
						StepStatus.FAILURE, new String[] {}, startTime, null);
				throw new Exception();
			}
			int k = 0;

			for (String Keys : ObjUpdatedPLmap.keySet()) {

				String SelectedValueOfElligibilityQues = ObjUpdatedPLmap.get(Keys).toString();
				String str8 = modifyAccountSubmissionRequest(path, data, stateCodeList, tcID, "");
				JSONObject tempRequestObject = new JSONObject(str8);
				String QuestionInTest = requestObject.getJSONObject("submission").getJSONArray("products")
						.getJSONObject(0).getJSONObject("management_liability").getJSONArray("coverage_parts")
						.getJSONObject(0).getJSONArray("underwriting_questions").getJSONObject(k).get("question_id")
						.toString();
				System.out.println(QuestionInTest);
				tempRequestObject.getJSONObject("submission").getJSONArray("products").getJSONObject(0)
						.getJSONObject("management_liability").getJSONArray("coverage_parts").getJSONObject(0)
						.getJSONArray("underwriting_questions").getJSONObject(k)
						.put("selected", SelectedValueOfElligibilityQues);
				String finalStr = tempRequestObject.toString();
				System.out.println(finalStr);

				Response response = cFunc.customWebServiceCall(finalStr, authKey, cType, endPointURL);
				String resbody = response.asString();

				String respInsuredName = cFunc.getKeyValue(response, "account.primary_entity.name");
				GenericFunctions.instance()._addToGlobalVariableList("respInsuredName", respInsuredName);
				String resLocality = cFunc.getKeyValue(response, "account.account_address.locality");
				GenericFunctions.instance()._addToGlobalVariableList("resLocality", resLocality);
				String resRegion = cFunc.getKeyValue(response, "account.account_address.region");
				GenericFunctions.instance()._addToGlobalVariableList("resLocality", resRegion);

				System.out.println("Response from Web Service is: " + resbody);
				System.out.println(response.statusCode());
				if (response != null) {

					CustomReporting.logReport("validation for the Uderwriting quest: " + QuestionInTest);

					int code = response.statusCode();
					String statusLine = response.statusLine();

					Collections.fill(list, Boolean.TRUE);

					if (code == 200 || code == 201) {
						list.add(true);
						CustomReporting.logReport("", "",
								"Create Account Service returned response successfully with code: " + code
										+ " and message : " + statusLine,
								StepStatus.SUCCESS, new String[] {}, startTime);
					} else {
						list.add(false);

						CustomReporting.logReport("", "",
								"Unable to Get Response for Submission Service" + code + statusLine, "",
								StepStatus.FAILURE, new String[] {}, startTime, null);

					}
					if (code == 200) {
						verifySubmissionObj(finalStr, resbody, response, endPointURL);
						GenericFunctions.instance()._addToGlobalVariableList("submissionData", resbody);
						WebServiceGetQuoteImpl getQuoteObj = new WebServiceGetQuoteImpl();
						getQuoteObj.verifyGetQuoteDetails(tcID, softAssert, QuestionInTest,
								SelectedValueOfElligibilityQues);
						EscapePageImpl escObject = new EscapePageImpl();
						String ExpectedStatus = escapeData.getData("ExpectedStatus").trim();
						escObject.verifySubmissionStatusReasonInEscape(tcID, softAssert, DeviceName, ExpectedStatus);
					} else {

						CustomReporting.logReport("", "",
								"Unable to Get Response for Submission Service" + code + statusLine, "",
								StepStatus.FAILURE, new String[] {}, startTime, null);
						throw new RuntimeException();
					}
				} else {
					CustomReporting.logReport("", "", "Unable to recieve response for Submission", "",
							StepStatus.FAILURE, new String[] {}, startTime, null);
					throw new RuntimeException();
				}
				k++;
			}

			boolean stepResult = cFunc.allStepsResult(list);
			if (stepResult) {
				CustomReporting.logReport("", "", "Successfully Verified All Mandatory Fields In Response ",
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				CustomReporting.logReport("", "", "Verification of Mandatory Field values is failed", "",
						StepStatus.FAILURE, new String[] {}, startTime, null);
				throw new RuntimeException();
			}

		} catch (RuntimeException ex) {
			throw ex;
		}
	}

	public void getSubmissionResponseValue(Response response) throws Exception {
		String respAccountId = cFunc.getKeyValue(response, "account.account_id");
		GenericFunctions.instance()._addToGlobalVariableList("respAccountId", respAccountId);
		String respInsuredName = cFunc.getKeyValue(response, "account.primary_entity.name");
		GenericFunctions.instance()._addToGlobalVariableList("respInsuredName", respInsuredName);
		String resLocality = cFunc.getKeyValue(response, "account.account_address.locality");
		GenericFunctions.instance()._addToGlobalVariableList("resLocality", resLocality);
		String resRegion = cFunc.getKeyValue(response, "account.account_address.region");
		GenericFunctions.instance()._addToGlobalVariableList("respRegion", resRegion);
		String resAddressLine1 = cFunc.getKeyValue(response, "account.account_address.address_line_1");
		GenericFunctions.instance()._addToGlobalVariableList("resAddressLine1", resAddressLine1);
		String resZipCode = cFunc.getKeyValue(response, "account.account_address.postal_code");
		GenericFunctions.instance()._addToGlobalVariableList("resZipCode", resZipCode);
		// commenting the below code as other trade name is removed from the latest
		// request
		// String resOtherTradeName = cFunc.getKeyValue(response,
		// "account.other_entities[0].trade_names[0].trade_name");
		// GenericFunctions.instance()._addToGlobalVariableList("resOtherTradeName",
		// resOtherTradeName);
		// String resTradeName = cFunc.getKeyValue(response,
		// "account.primary_entity.trade_names[0].trade_name");
		// GenericFunctions.instance()._addToGlobalVariableList("resTradename",
		// resTradeName);
		String resSubEffectiveDate = cFunc.getKeyValue(response, "submission.effective_date");
		GenericFunctions.instance()._addToGlobalVariableList("resSubEffectiveDate", resSubEffectiveDate);
		String resCoveragePartCode = cFunc
				.getKeyValue(response,
						"submission.products[0].management_liability.coverage_parts[0].coverage_part_code")
				.toLowerCase();
		if(!(resCoveragePartCode.equalsIgnoreCase("CYBER_LIABILITY"))) {
		String resCrimeRetention = cFunc.getKeyValue(response,
				"submission.products[0].management_liability.coverage_parts[0]." + resCoveragePartCode
						+ ".expiring_coverage.retention");
		System.out.println(resCrimeRetention);
		GenericFunctions.instance()._addToGlobalVariableList("resCrimeRetentionValue", resCrimeRetention);
		String resCrimeLimitValue = cFunc.getKeyValue(response,
				"submission.products[0].management_liability.coverage_parts[0]." + resCoveragePartCode
						+ ".expiring_coverage.limit");

		GenericFunctions.instance()._addToGlobalVariableList("resCrimeLimitValue", resCrimeLimitValue);
		

		System.out.println(resCrimeLimitValue);
		}
		String resNaicsCode = cFunc.getKeyValue(response, "account.primary_naics_code");
		GenericFunctions.instance()._addToGlobalVariableList("resSubNaicsCode", resNaicsCode);
		GenericFunctions.instance()._addToGlobalVariableList("resCoveragePartCode", resCoveragePartCode);

		String resUnderwriterName = cFunc.getKeyValue(response, "submission.extensions[1].values[0].value");
		GenericFunctions.instance()._addToGlobalVariableList("resUnderwriterName", resUnderwriterName);

		String resProducerId = cFunc.getKeyValue(response, "submission.producer_id");
		GenericFunctions.instance()._addToGlobalVariableList("resProducerId", resProducerId);

	}
	
	
	public void verifyCyberSubmissionObj(String finalStr, String resbody, Response response, String URL)
			throws Exception {
		try {

			// verify submission id generated
			JSONObject reqSubObj = new JSONObject(finalStr);
			JSONObject resSubObj = new JSONObject(resbody);
			String ProducerName = cFunc.getKeyValue(response, "submission.extensions[0].values[5].value");
			GenericFunctions.instance()._addToGlobalVariableList("resProducerName", ProducerName);
			String submissionId = cFunc.getKeyValue(response, "submission.submission_id");
			if (!(submissionId.equalsIgnoreCase("null") || submissionId.equals(""))) {
				list.add(true);
				CustomReporting.logReport("", "", " Submission Id generated successfully " + submissionId,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "", "Submission Id is not generated  " + submissionId, StepStatus.FAILURE,
						new String[] {}, startTime);
			}
			GenericFunctions.instance()._addToGlobalVariableList("submissionId", submissionId);

			String respSubmissionStatus = cFunc.getKeyValue(response, "submission.submission_status");
			String respSubmissionStatusCode = cFunc.getKeyValue(response, "submission.submission_status_code");
			String respStateCode = cFunc.getKeyValue(response, "submission.predominant_state_code");

			GenericFunctions.instance()._addToGlobalVariableList("respStateCode", respStateCode);

			if (respSubmissionStatus.equalsIgnoreCase(data.getData("ExpectedStatus"))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"  Submission Status value in Response is equal to : " + respSubmissionStatus.toUpperCase()
								+ " for predominant state code " + respStateCode + " is as expected",
						StepStatus.SUCCESS, new String[] {}, startTime);

			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Submission Status value in Response : " + respSubmissionStatus.toUpperCase()
								+ " for predominant state code " + respStateCode + " is not as expected",
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			if (respSubmissionStatusCode.equalsIgnoreCase(data.getData("ExpectedStatusCode"))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"  Submission Status Code value in Response is equal to : " + respSubmissionStatus.toUpperCase()
								+ " for predominant state code " + respStateCode + " is as expected",
						StepStatus.SUCCESS, new String[] {}, startTime);

			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Submission Status Code value in Response : " + respSubmissionStatus.toUpperCase()
								+ " for predominant state code " + respStateCode + " is not as expected",
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			String reqSubmissionDate = cFunc.getKeyValueFromInputStr(finalStr, "submission", "submitted_date")
					.substring(0, 10);

			String respSubmissionDate = cFunc.getKeyValue(response, "submission.submitted_date").substring(0, 10);

			if (respSubmissionDate.equals(reqSubmissionDate)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Submission Date value : " + reqSubmissionDate
								+ " from Request is same as Submission Date value in Response : " + respSubmissionDate,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "", " Submission Date value : " + reqSubmissionDate
						+ " from Request is not same as Submission Date value in Response : " + respSubmissionDate,
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			// verify effective date
			String reqEffectiveDate = cFunc.getKeyValueFromInputStr(finalStr, "submission", "effective_date")
					.substring(0, 10);
			String respEffectiveDate = cFunc.getKeyValue(response, "submission.effective_date").substring(0, 10);
			GenericFunctions.instance()._addToGlobalVariableList("respEffectiveDate", respEffectiveDate);
			if (respEffectiveDate.equals(reqEffectiveDate)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Effective Date value : " + reqEffectiveDate
								+ " from Request is same as Effective Date value in Response : " + respEffectiveDate,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "", " Effective Date value : " + respEffectiveDate
						+ " from Request is not same as Effective Date value in Response : " + respEffectiveDate,
						StepStatus.FAILURE, new String[] {}, startTime);

			}
			// verify Expiration date
			String reqExpirationDate = cFunc.getKeyValueFromInputStr(finalStr, "submission", "expiration_date")
					.substring(0, 10);
			String respExpirationDate = cFunc.getKeyValue(response, "submission.expiration_date").substring(0, 10);
			GenericFunctions.instance()._addToGlobalVariableList("respExpirationDate", respExpirationDate);
			System.out.println("req " + reqExpirationDate + " respExpirationDate " + respExpirationDate);
			if (respExpirationDate.equals(reqExpirationDate)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Expiration Date value : " + reqExpirationDate
								+ " from Request is same as Expiration Date value in Response : " + respExpirationDate,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "", " Expiration Date value : " + reqExpirationDate
						+ " from Request is not same as Expiration Date value in Response : " + respExpirationDate,
						StepStatus.FAILURE, new String[] {}, startTime);

			}
			String reqProdId = cFunc.getKeyValueFromInputStr(finalStr, "submission", "producer_id");
			String respProdId = cFunc.getKeyValue(response, "submission.producer_id");
			if (respProdId.equalsIgnoreCase(reqProdId)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Producer Id value : " + reqProdId
								+ " from Request is same as Producer Id value in Response : " + respProdId,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Producer Id value : " + reqProdId
								+ " from Request is not same as Producer Id value in Response : " + respProdId,
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			String reqSubmittingAgentNPN = cFunc.getKeyValueFromInputStr(finalStr, "submission",
					"submitting_agent_npn");
			String respSubmittingAgentNPN = cFunc.getKeyValue(response, "submission.submitting_agent_npn");
			if (respSubmittingAgentNPN.equalsIgnoreCase(reqSubmittingAgentNPN)) {
				list.add(true);
				CustomReporting.logReport("", "", " Submitting Agent NPN value : " + reqSubmittingAgentNPN
						+ " from Request is same as Submitting Agent NPN value in Response : " + respSubmittingAgentNPN,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Submitting Agent NPN value : " + reqSubmittingAgentNPN
								+ " from Request is not same as Submitting Agent NPN value in Response : "
								+ respSubmittingAgentNPN,
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			// verification of products section
			JSONArray reqProductsArry = reqSubObj.getJSONObject("submission").getJSONArray("products");
			JSONArray respProductsArry = resSubObj.getJSONObject("submission").getJSONArray("products");
			for (int j = 0; j < reqProductsArry.length(); j++) {

				// verify exposures
				Map<String, String> reqProducts_exposure = cFunc.getListOfKeyValue(reqProductsArry.getJSONObject(j)
						.getJSONObject("management_liability").getJSONObject("exposure"));
				Map<String, String> resProducts_exposure = cFunc.getListOfKeyValue(respProductsArry.getJSONObject(j)
						.getJSONObject("management_liability").getJSONObject("exposure"));
				for (String key : reqProducts_exposure.keySet()) {
					if (resProducts_exposure.containsKey(key)) {
						String inputValue = reqProducts_exposure.get(key);

						String responseValue = resProducts_exposure.get(key);
						if (responseValue.equals(inputValue)) {
							list.add(true);
							CustomReporting.logReport("", "",
									key.toUpperCase() + " value : " + inputValue.toUpperCase()
											+ " from Request is equal to " + key.toUpperCase()
											+ "  value in Response : " + responseValue.toUpperCase(),
									StepStatus.SUCCESS, new String[] {}, startTime);
						} else {
							list.add(false);

							CustomReporting.logReport("", "",
									key.toUpperCase() + " value : " + inputValue.toUpperCase()
											+ " from Request is not equal to " + key.toUpperCase()
											+ " value in Response : " + responseValue.toUpperCase(),
									"", StepStatus.FAILURE, new String[] {}, startTime, null);
						}

					}
				}

				JSONArray reqcoveragePartsArr = reqProductsArry.getJSONObject(j).getJSONObject("management_liability")
						.getJSONArray("coverage_parts");
				JSONArray rescoveragePartsArr = respProductsArry.getJSONObject(j).getJSONObject("management_liability")
						.getJSONArray("coverage_parts");
				for (int k = 0; k < reqcoveragePartsArr.length(); k++) {
					String reqcoveragePartCode = reqcoveragePartsArr.getJSONObject(k).get("coverage_part_code")
							.toString();
					String rescoveragePartCode = rescoveragePartsArr.getJSONObject(k).get("coverage_part_code")
							.toString();

					if (rescoveragePartCode.equalsIgnoreCase(reqcoveragePartCode)) {
						list.add(true);
						CustomReporting.logReport("", "", " Coverage Part Code value : " + reqcoveragePartCode
								+ " from Request is same as Coverage Type value in Response : " + rescoveragePartCode,
								StepStatus.SUCCESS, new String[] {}, startTime);
					} else {
						list.add(false);
						CustomReporting.logReport("", "",
								" Coverage Part Code value : " + reqcoveragePartCode
										+ " from Request is not same as Coverage Type value in Response : "
										+ rescoveragePartCode,
								StepStatus.FAILURE, new String[] {}, startTime);

					}

					Map<String, String> reqProducts_cyber = cFunc.getListOfKeyValue(
							reqcoveragePartsArr.getJSONObject(k).getJSONObject(reqcoveragePartCode.toLowerCase()));
					Map<String, String> resProducts_cyber = cFunc.getListOfKeyValue(
							rescoveragePartsArr.getJSONObject(k).getJSONObject(rescoveragePartCode.toLowerCase()));
					for (String key : reqProducts_cyber.keySet()) {
						if (resProducts_cyber.containsKey(key)) {
							String inputValue = reqProducts_cyber.get(key);
							String responseValue = resProducts_cyber.get(key);

							if (responseValue.equals(inputValue)) {
								list.add(true);
								CustomReporting.logReport("", "",
										key.toUpperCase() + " value : " + inputValue.toUpperCase()
												+ " from Request is equal to " + key.toUpperCase()
												+ "  value in Response : " + responseValue.toUpperCase(),
										StepStatus.SUCCESS, new String[] {}, startTime);
							} else {
								list.add(false);

								CustomReporting.logReport("", "",
										key.toUpperCase() + " value : " + inputValue.toUpperCase()
												+ " from Request is not equal to " + key.toUpperCase()
												+ " value in Response : " + responseValue.toUpperCase(),
										"", StepStatus.FAILURE, new String[] {}, startTime, null);
							}

						}
					}

				}

			}

		} catch (Exception e) {
			throw e;
		}
	}



}
