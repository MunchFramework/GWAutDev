package com.everest.webservice.insureon.spi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.GenericFunctions;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;
import com.everest.webservice.insureon.WebServiceBind;
import com.jayway.restassured.response.Response;

public class WebServiceBindImpl extends CustomAbstractPage implements WebServiceBind{
	PageData data;
	List<Boolean> list = new ArrayList<Boolean>();
	long startTime = System.currentTimeMillis();
	String respSubmissionStatus ="";
	String respStateCode="";
	String respSubmissionStatusCode;
	//Set<String> setOfUwQuestions= new HashSet<String>();
	
	@SuppressWarnings("unused")
	@Override
	public void verifyBindDetails(String tcID, SoftAssert softAssert) throws Exception {

		try {

			PageData EnvironmentData = PageDataManager.instance().getPageData("Config", tcID);
			PageData data = PageDataManager.instance().getPageData("BindIssuance", tcID);
			PageData subData = PageDataManager.instance().getPageData("Submission", tcID);
			
			String env = GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV");
			String endPointURL = "";
			String XIBMClientID = null;
			String XIBMClientSecret =null;
			
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
			WebServiceGenerateAuthTokenImpl authcodeobj = new WebServiceGenerateAuthTokenImpl();
			String authcode = authcodeobj.generateAuthTokenCode(tcID, softAssert);
			
			String ReqUrl = endPointURL;
			String authKey = "Bearer " + authcode;
			String cType = data.getData("ContentType");
		    

			String finalStr = GenericFunctions.instance()._getGlobalVariableValue("QuoteResponse");
			System.out.println(finalStr);
			String submissionID = GenericFunctions.instance()._getGlobalVariableValue("submissionId");
			
			
			//GenericFunctions.instance()._addToGlobalVariableList("QuoteFinalRequest", finalStr);
			
			
			Response response = cFunc.customWebServiceCall("", authKey, cType, ReqUrl, submissionID,XIBMClientID,XIBMClientSecret,"");
			String resbody = response.asString();
			System.out.println("Response from Quote Response  is: " + resbody);
			
			
			System.out.println(response.statusCode());

			if (response != null) {

				int code = response.statusCode();
				String statusLine = response.statusLine();
				if (code == 200 || code == 201) {
					list.add(true);
					CustomReporting.logReport("", "", "Bind Service returned response successfully with code: "
							+ code + " and message : " + statusLine, StepStatus.SUCCESS, new String[] {}, startTime);
					if(subData.getData("LOB").equalsIgnoreCase("CY")) {
						verifyCyberBindDetails(finalStr, resbody, response,  data);
					}
				} else {
					list.add(false);

					CustomReporting.logReport("", "", "Unable to get response for Bind Service " + code + statusLine, "",
							StepStatus.FAILURE, new String[] {}, startTime, null);

				}
				
				                       			               
				
			} else {
				
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
						tcID);
				CustomReporting.logReport("", "", "Unable to receieve response for Bind Service", "", StepStatus.FAILURE,
						new String[] {}, startTime, null);
				throw new RuntimeException();
			}
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
	
	
	public JSONObject UpdateUWQuestions(String finalStr,String tcID ) {
		
		PageData data = PageDataManager.instance().getPageData("GetQuote", tcID);
		PageData Subdata = PageDataManager.instance().getPageData("Submission", tcID);
		
		
		String UWQuestInputStrComm=cFunc.getUpdateInputAsString(data.getData("PayloadpathComm"));
		String Coverage[]=Subdata.getData("CoveragePart").split("#");	
		JSONArray uwCommonObj=new JSONArray(UWQuestInputStrComm);
		
		
		 JSONObject SubResponseObj=new JSONObject(finalStr);			
	    SubResponseObj.getJSONObject("submission").getJSONArray("products")
				.getJSONObject(0)
				.getJSONObject("management_liability")
				.put("underwriting_questions",uwCommonObj);
				 
		System.out.println(SubResponseObj);
		
		int NumberOfCoverages=Coverage.length;
		
		for(int k=0;k<NumberOfCoverages;k++) {
			String CoverageName=SubResponseObj.getJSONObject("submission").getJSONArray("products")
					.getJSONObject(0).getJSONObject("management_liability").getJSONArray("coverage_parts").getJSONObject(k).get("coverage_part_code").toString();
			if(CoverageName.equalsIgnoreCase("CRIME")) {
				String Crime_UW_Ques_Path=data.getData("PayloadpathCrime");
				String UWQuestInputStrCrime=cFunc.getUpdateInputAsString(Crime_UW_Ques_Path);
				
				JSONArray uwQuestions = new JSONArray(UWQuestInputStrCrime);
				SubResponseObj.getJSONObject("submission").getJSONArray("products")
				.getJSONObject(0).getJSONObject("management_liability").getJSONArray("coverage_parts").getJSONObject(k).put("underwriting_questions", uwQuestions);
			
				
			}else if (CoverageName.equalsIgnoreCase("EMPLOYMENT_PRACTICES_LIABILITY")) {
				
			}else if (CoverageName.equalsIgnoreCase("DIRECTORS_AND_OFFICERS")) {
				
			}else if (CoverageName.equalsIgnoreCase("FIDUCIARY_LIABILITY")) {
				
			}
			
			
		}
		return SubResponseObj;
	}
	
	
public Set RetrieveAllUWQuest(String QuoteRequestSTR) {
	JSONObject requestObject = new JSONObject(QuoteRequestSTR);
	Map<String, String> ObjUpdatedPLmap= new LinkedHashMap<String, String>();
	Set<String> setOfUwQuestions= new HashSet<String>();
	int noOfCoverages=requestObject.getJSONObject("submission").getJSONArray("products")
			.getJSONObject(0).getJSONObject("management_liability").getJSONArray("coverage_parts").length();
	
	for (int l=0;l<noOfCoverages;l++) {
		int ElligibilityQuesSize=requestObject.getJSONObject("submission").getJSONArray("products")
				.getJSONObject(0).getJSONObject("management_liability").getJSONArray("coverage_parts").getJSONObject(l).getJSONArray("underwriting_questions").length();
	int i=0;
	for( i=0;i<ElligibilityQuesSize;i++) {
	String QuestionId=requestObject.getJSONObject("submission").getJSONArray("products")
	.getJSONObject(0).getJSONObject("management_liability").getJSONArray("coverage_parts").getJSONObject(l).getJSONArray("underwriting_questions").getJSONObject(i)
	.get("question_id").toString();
	setOfUwQuestions.add(QuestionId.toUpperCase());
	}
	}
	return setOfUwQuestions;
	
}
	public void getQuoteResponseValue(Response response,PageData data) throws Exception {
		
		respSubmissionStatus = cFunc.getKeyValue(response, "submission.submission_status");
		GenericFunctions.instance()._addToGlobalVariableList("SubmissionStatus", respSubmissionStatus);  
		respSubmissionStatusCode = cFunc.getKeyValue(response, "submission.submission_status_code");
	    respStateCode = cFunc.getKeyValue(response, "submission.predominant_state_code");
		GenericFunctions.instance()._addToGlobalVariableList("respStateCode", respStateCode);
		String resunderwriterName = cFunc.getKeyValue(response, "submission.extensions[0].values[0].value");
		GenericFunctions.instance()._addToGlobalVariableList("underwriterName", resunderwriterName);
		String resQuoteProducerName = cFunc.getKeyValue(response, "submission.extensions[1].values[0].value");
		GenericFunctions.instance()._addToGlobalVariableList("resQuoteProducerName", resQuoteProducerName);
		if(data.getData("ExpectedStatusCode").equalsIgnoreCase("QTOUT")) {
		String resQuoteDate = (cFunc.getKeyValue(response, "quote.quote_date")).split(" ")[0];
		GenericFunctions.instance()._addToGlobalVariableList("respQuoteDate", resQuoteDate);
		String resQuotedPremium = cFunc.getKeyValue(response, "quote.total_premium");
		GenericFunctions.instance()._addToGlobalVariableList("resQuotedPremium", resQuotedPremium);
		//String resCommissionPercentage = cFunc.getKeyValue(response, "quote.commission");
		//GenericFunctions.instance()._addToGlobalVariableList("resCommissionPercentage", resCommissionPercentage);
		//String resQuoteNumber = cFunc.getKeyValue(response, "quote.quote_number");
		//GenericFunctions.instance()._addToGlobalVariableList("resQuoteNumber", resQuoteNumber); 
		}
		String resBillingType = cFunc.getKeyValue(response, "submission.billing_type");
		GenericFunctions.instance()._addToGlobalVariableList("resBillingType", resBillingType);
		String resAgencyName = cFunc.getKeyValue(response, "submission.extensions[1].values[5].value");
		GenericFunctions.instance()._addToGlobalVariableList("resAgencyName", resAgencyName);
		
		String resLicenseAgentName = cFunc.getKeyValue(response, "submission.extensions[1].values[6].value");
		GenericFunctions.instance()._addToGlobalVariableList("resLicenseAgentName", resLicenseAgentName);
		
		
	}
	
	
	public void verifyQuoteDetails(String finalStr, String resbody, Response response, PageData data) throws Exception {
		try {

			// verify submission id generated
			JSONObject reqSubObj = new JSONObject(finalStr);
			JSONObject resSubObj = new JSONObject(resbody);
			String reqAccountId = cFunc.getKeyValueFromInputStr(finalStr, "submission", "account_id");
			String respAccountId = cFunc.getKeyValue(response, "submission.account_id");
			if (respAccountId.equalsIgnoreCase(reqAccountId)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Account ID value : " + reqAccountId
								+ " from Request is same as Account ID value in Response : " + respAccountId,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Account ID value : " + reqAccountId
								+ " from Request is not same as Account ID value in Response : " + respAccountId,
						StepStatus.FAILURE, new String[] {}, startTime);
			}

			String reqSubmissionId = cFunc.getKeyValueFromInputStr(finalStr, "submission", "submission_id");
			String respSubmissionId = cFunc.getKeyValue(response, "submission.submission_id");
			if (respSubmissionId.equalsIgnoreCase(reqSubmissionId)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Submission ID value : " + reqSubmissionId
								+ " from Request is same as Submission ID value in Response : " + respSubmissionId,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Submission ID value : " + reqSubmissionId
								+ " from Request is not same as Submission ID value in Response : " + respSubmissionId,
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			GenericFunctions.instance()._addToGlobalVariableList("submissionId", respSubmissionId);

			String respSubmissionStatus = cFunc.getKeyValue(response, "submission.submission_status");
			String respSubmissionStatusCode = cFunc.getKeyValue(response, "submission.submission_status_code");
			String respStateCode = cFunc.getKeyValue(response, "submission.predominant_state_code");

			if (respSubmissionStatus.equalsIgnoreCase(data.getData("ExpectedStatus"))) {
				list.add(true);
				CustomReporting.logReport(
						"", "", "  Submission Status value in Response is equal to : "
								+ respSubmissionStatus.toUpperCase() + " is as expected",
						StepStatus.SUCCESS, new String[] {}, startTime);

			} else {
				list.add(false);
				CustomReporting.logReport("", "", " Submission Status value in Response : "
						+ respSubmissionStatus.toUpperCase() + " is not as expected", StepStatus.FAILURE,
						new String[] {}, startTime);

			}

			if (respSubmissionStatusCode.equalsIgnoreCase(data.getData("ExpectedStatusCode"))) {
				list.add(true);
				CustomReporting.logReport(
						"", "", "  Submission Status Code value in Response is equal to : "
								+ respSubmissionStatus.toUpperCase() + " is as expected",
						StepStatus.SUCCESS, new String[] {}, startTime);

			} else {
				list.add(false);
				CustomReporting
						.logReport(
								"", "", " Submission Status Code value in Response : "
										+ respSubmissionStatus.toUpperCase() + " is not as expected",
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

			String reqBillingType = cFunc.getKeyValueFromInputStr(finalStr, "submission", "billing_type");
			String respBillingType = cFunc.getKeyValue(response, "submission.billing_type");
			if (respBillingType.equalsIgnoreCase(reqBillingType)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Billing Type value : " + reqBillingType
								+ " from Request is same as Billing Type value in Response : " + respBillingType,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Billing Type value : " + reqBillingType
								+ " from Request is not same as Billing Type value in Response : " + respBillingType,
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			String reqBusinessSegmentCode = cFunc.getKeyValueFromInputStr(finalStr, "submission",
					"business_segment_code");
			String respBusinessSegmentCode = cFunc.getKeyValue(response, "submission.business_segment_code");
			if (respBusinessSegmentCode.equalsIgnoreCase(reqBusinessSegmentCode)) {
				list.add(true);
				CustomReporting.logReport("", "", " Business Segment Code value : " + reqBusinessSegmentCode
						+ " from Request is same as Business Segment value in Response : " + respBusinessSegmentCode,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Business Segment Code value : " + reqBusinessSegmentCode
								+ " from Request is not same as Business Segment Code value in Response : "
								+ respBusinessSegmentCode,
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			String respInsuringCompanyCode = cFunc.getKeyValue(response, "submission.insuring_company_id");
			if (!(respInsuringCompanyCode.equalsIgnoreCase("null") || respInsuringCompanyCode.equals(""))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Insuring Company Code is not null/Blank in Response and returned value is "
								+ respInsuringCompanyCode,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Insuring Company Code is  null/Blank in Response and returned value is "
								+ respInsuringCompanyCode,
						StepStatus.FAILURE, new String[] {}, startTime);

			}
			String respLicensedAgentNPN = cFunc.getKeyValue(response, "submission.licensed_agent_npn");
			if (!(respLicensedAgentNPN.equalsIgnoreCase("null") || respLicensedAgentNPN.equals(""))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"License Agent NPN value is not null/Blank in Response and returned value is "
								+ respLicensedAgentNPN,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"License Agent NPN value is  null/Blank in Response and returned value is "
								+ respLicensedAgentNPN,
						StepStatus.FAILURE, new String[] {}, startTime);

			}
			String respLicenseClassification = cFunc.getKeyValue(response, "submission.license_classification");
			if (!(respLicenseClassification.equalsIgnoreCase("null") || respLicenseClassification.equals(""))) {
				list.add(true);
				CustomReporting.logReport("", "",
						" License Classification is not null/Blank in Response and returned value is "
								+ respLicenseClassification,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"License Classification is  null/Blank in Response and returned value is "
								+ respLicenseClassification,
						StepStatus.FAILURE, new String[] {}, startTime);

			}
			String resplicense_number = cFunc.getKeyValue(response, "submission.license_number");
			if (!(resplicense_number.equalsIgnoreCase("null") || resplicense_number.equals(""))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"License Number is not null/Blank in Response and returned value is " + resplicense_number,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"License Number is  null/Blank in Response and returned value is " + resplicense_number,
						StepStatus.FAILURE, new String[] {}, startTime);
			}

			String reqUnderwriter = cFunc.getKeyValueFromInputStr(finalStr, "submission", "underwriter");
			String respUnderwriter = cFunc.getKeyValue(response, "submission.underwriter");
			if (respUnderwriter.equalsIgnoreCase(reqUnderwriter)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Underwriter value : " + reqUnderwriter
								+ " from Request is same as Underwriter value in Response : " + respUnderwriter,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Underwriter value : " + reqUnderwriter
								+ " from Request is not same as Underwriter value in Response : " + respUnderwriter,
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

				String reqProductCode = reqProductsArry.getJSONObject(j).get("product_code").toString();
				String respProductCode = respProductsArry.getJSONObject(j).get("product_code").toString();
				if (respProductCode.equalsIgnoreCase(reqProductCode)) {
					list.add(true);
					CustomReporting.logReport("", "",
							" Product Code value : " + reqProductCode
									+ " from Request is same as Product Code value in Response : " + respProductCode,
							StepStatus.SUCCESS, new String[] {}, startTime);
				} else {
					list.add(false);
					CustomReporting.logReport("", "", "  Product Code value : " + reqProductCode
							+ " from Request is not same as Product Code Value in Response : " + respProductCode,
							StepStatus.FAILURE, new String[] {}, startTime);
				}

				String reqOfferingCode = reqProductsArry.getJSONObject(j).get("offering_code").toString();
				String respofferingCode = respProductsArry.getJSONObject(j).get("offering_code").toString();
				if (respofferingCode.equalsIgnoreCase(reqOfferingCode)) {
					list.add(true);
					CustomReporting.logReport("", "",
							" Offering Code value : " + reqOfferingCode
									+ " from Request is same as Offering Code value in Response : " + respofferingCode,
							StepStatus.SUCCESS, new String[] {}, startTime);
				} else {
					list.add(false);
					CustomReporting.logReport("", "", "  Offering Code value : " + reqOfferingCode
							+ " from Request is not same as Offering Code Value in Response : " + respofferingCode,
							StepStatus.FAILURE, new String[] {}, startTime);
				}
				// verify tax exempt status
//				Map<String, String> reqProducts_tax = cFunc.getListOfKeyValue(reqProductsArry.getJSONObject(j)
//						.getJSONObject("management_liability").getJSONObject("tax_exempt_status"));
//				Map<String, String> resProducts_tax = cFunc.getListOfKeyValue(respProductsArry.getJSONObject(j)
//						.getJSONObject("management_liability").getJSONObject("tax_exempt_status"));
//				for (String key : reqProducts_tax.keySet()) {
//					if (resProducts_tax.containsKey(key)) {
//						String inputValue = reqProducts_tax.get(key);
//						String responseValue = resProducts_tax.get(key);
//						if (responseValue.equals(inputValue)) {
//							list.add(true);
//							CustomReporting.logReport("", "",
//									key.toUpperCase() + " value : " + inputValue.toUpperCase()
//											+ " from Request is equal to " + key.toUpperCase()
//											+ "  value in Response : " + responseValue.toUpperCase(),
//									StepStatus.SUCCESS, new String[] {}, startTime);
//						} else {
//							list.add(false);
//
//							CustomReporting.logReport("", "",
//									key.toUpperCase() + " value : " + inputValue.toUpperCase()
//											+ " from Request is not equal to " + key.toUpperCase()
//											+ " value in Response : " + responseValue.toUpperCase(),
//									"", StepStatus.FAILURE, new String[] {}, startTime, null);
//						}
//
//					}
//				}

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
						if(key.equals("revenue")||key.equals("corporate_assets")||key.equals("foreign_employees")) {
							GenericFunctions.instance()._addToGlobalVariableList("res"+"_"+key, responseValue);
						}

					}
				}

				JSONArray reqcoveragePartsArr = reqProductsArry.getJSONObject(j).getJSONObject("management_liability")
						.getJSONArray("coverage_parts");
				JSONArray rescoveragePartsArr = respProductsArry.getJSONObject(j).getJSONObject("management_liability")
						.getJSONArray("coverage_parts");
				for (int k = 0; k < reqcoveragePartsArr.length(); k++) {
					String reqcoveragePartCode = reqcoveragePartsArr.getJSONObject(k).get("coverage_part_code")
							.toString().toLowerCase();
					String rescoveragePartCode = rescoveragePartsArr.getJSONObject(k).get("coverage_part_code")
							.toString().toLowerCase();

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
					//String resCoveragePartCode = cFunc.getKeyValue(response, "submission.products[0].management_liability.coverage_parts[0].coverage_part_code").toLowerCase();
					
						GenericFunctions.instance()._addToGlobalVariableList("rescoveragePartCode", rescoveragePartCode);	
					
					
					Map<String, String> reqProducts_expiring_coverage = cFunc.getListOfKeyValue(reqcoveragePartsArr
							.getJSONObject(k).getJSONObject(rescoveragePartCode).getJSONObject("expiring_coverage"));
					Map<String, String> resProducts_expiring_coverage = cFunc.getListOfKeyValue(rescoveragePartsArr
							.getJSONObject(k).getJSONObject(rescoveragePartCode).getJSONObject("expiring_coverage"));
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

					Map<String, String> reqProducts_crime = cFunc
							.getListOfKeyValue(reqcoveragePartsArr.getJSONObject(k).getJSONObject(rescoveragePartCode));
					Map<String, String> resProducts_crime = cFunc
							.getListOfKeyValue(rescoveragePartsArr.getJSONObject(k).getJSONObject(rescoveragePartCode));
					for (String key : reqProducts_crime.keySet()) {
						if (resProducts_crime.containsKey(key)) {
							String inputValue = reqProducts_crime.get(key);
							String responseValue = resProducts_crime.get(key);
							/*if(key.equals("limit")) {*/
							if (responseValue.equals(inputValue)) {
								GenericFunctions.instance()._addToGlobalVariableList("limitValue", responseValue);
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
							if(rescoveragePartsArr.length()>0) {
								if(k==0) {
									if(key.equals("adjusted_retention")) {
										GenericFunctions.instance()._addToGlobalVariableList("respAdjustedRetentionValue", responseValue);
										System.out.println("adjusted retention"+responseValue);
									}
								}
							}
							/*}*/
							if(rescoveragePartCode.equalsIgnoreCase("DIRECTORS_AND_OFFICERS")||
									rescoveragePartCode.equalsIgnoreCase("EMPLOYMENT_PRACTICES_LIABILITY")
									||rescoveragePartCode.equalsIgnoreCase("FIDUCIARY_LIABILITY")) {
								if(key.equals("limit")) {
									GenericFunctions.instance()._addToGlobalVariableList("respLimitValue"+"_"+rescoveragePartCode, responseValue);
									System.out.println("limit"+responseValue);
								}
								
								if(key.equals("retention")) {
									if(responseValue.equalsIgnoreCase("0")) {
										responseValue="";
									}
									GenericFunctions.instance()._addToGlobalVariableList("respRetentionValue"+"_"+rescoveragePartCode, responseValue);
									System.out.println("retention"+responseValue);
								}
							}
							if(rescoveragePartsArr.length()==0) {
							
							if(key.equals("adjusted_retention")) {
								GenericFunctions.instance()._addToGlobalVariableList("respAdjustedRetentionValue", responseValue);
								System.out.println("adjusted retention"+responseValue);
							}
							}

							String limit= GenericFunctions.instance()._getGlobalVariableValue("limitValue");
							
							if(rescoveragePartCode.equalsIgnoreCase("DIRECTORS_AND_OFFICERS")){
								if(key.equals("additional_side_A_Limit")) {
									if(responseValue.equals(limit)) {
									list.add(true);
									CustomReporting.logReport("", "",
											 key.toUpperCase()
													+ "  value in Response : " + responseValue.toUpperCase()+  ""
															+ "is equal to limit value  "  + limit,
											StepStatus.SUCCESS, new String[] {}, startTime);
									}else {
										CustomReporting.logReport("", "",
												 key.toUpperCase()
													+ "  value in Response : " + responseValue.toUpperCase()+  ""
															+ "is not equal to limit value  "  + limit,
												"", StepStatus.FAILURE, new String[] {}, startTime, null);
									}
									GenericFunctions.instance()._addToGlobalVariableList("respAddLimitValue"+"_"+rescoveragePartCode, responseValue);
									System.out.println("additionalLimitValue"+responseValue);
								}
							}
							
							if(key.equals("erisa_fidelity_limit")) {
								
								if(responseValue.equals(limit)) {
								CustomReporting.logReport("", "",
										key.toUpperCase() + " exist  and its " 
												+ " value in Response : " + responseValue.toUpperCase(),
										"", StepStatus.SUCCESS, new String[] {}, startTime, null);
							}
							}
							

						}
						
					}
					
//					JSONArray requnderwriterQuestnArr = reqcoveragePartsArr.getJSONObject(k)
//							.getJSONArray("underwriting_questions");
//					JSONArray resunderwriterQuestnArr = rescoveragePartsArr.getJSONObject(k)
//							.getJSONArray("underwriting_questions");
//					for (int x = 0; x < requnderwriterQuestnArr.length(); x++) {
//						Map<String, String> reqProducts_UW = cFunc
//								.getListOfKeyValue(requnderwriterQuestnArr.getJSONObject(x));
//						Map<String, String> resProducts_UW = cFunc
//								.getListOfKeyValue(resunderwriterQuestnArr.getJSONObject(x));
//						for (String key : reqProducts_UW.keySet()) {
//							if (resProducts_UW.containsKey(key)) {
//								String inputValue = reqProducts_UW.get(key);
//								String responseValue = resProducts_UW.get(key);
//								if (responseValue.equals(inputValue)) {
//									list.add(true);
//									CustomReporting.logReport("", "",
//											key.toUpperCase() + " value : " + inputValue.toUpperCase()
//													+ " from Request is equal to " + key.toUpperCase()
//													+ "  value in Response : " + responseValue.toUpperCase(),
//											StepStatus.SUCCESS, new String[] {}, startTime);
//								} else {
//									list.add(false);
//
//									CustomReporting.logReport("", "",
//											key.toUpperCase() + " value : " + inputValue.toUpperCase()
//													+ " from Request is not equal to " + key.toUpperCase()
//													+ " value in Response : " + responseValue.toUpperCase(),
//											"", StepStatus.FAILURE, new String[] {}, startTime, null);
//								}
//
//							}
//						}
//					}
					if(rescoveragePartCode.equalsIgnoreCase("DIRECTORS_AND_OFFICERS")) {
						JSONArray reqShareHolders= reqcoveragePartsArr.getJSONObject(k).getJSONObject(rescoveragePartCode)
								.getJSONArray("shareholders");
						JSONArray resShraeHolders = rescoveragePartsArr.getJSONObject(k).getJSONObject(rescoveragePartCode)
								.getJSONArray("shareholders");
						for (int t = 0; t < reqShareHolders.length(); t++) {
							Map<String, String> reqProducts_SH = cFunc
									.getListOfKeyValue(reqShareHolders.getJSONObject(t));
							Map<String, String> resProducts_SH = cFunc
									.getListOfKeyValue(resShraeHolders.getJSONObject(t));
							for (String key : reqProducts_SH.keySet()) {
								if (resProducts_SH.containsKey(key)) {
									String inputValue = reqProducts_SH.get(key);
									String responseValue = resProducts_SH.get(key);
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
					if(rescoveragePartCode.equalsIgnoreCase("CRIME")) {
					int coveragesArr = reqcoveragePartsArr.getJSONObject(k).getJSONArray("coverages").length();
					for (int c = 0; c < coveragesArr; c++) {
						String reqcoverageType = reqcoveragePartsArr.getJSONObject(k).getJSONArray("coverages")
								.getJSONObject(c).get("type").toString();
						String rescoverageType = rescoveragePartsArr.getJSONObject(k).getJSONArray("coverages")
								.getJSONObject(c).get("type").toString();

						if (rescoverageType.equalsIgnoreCase(reqcoverageType)) {
							list.add(true);
							CustomReporting.logReport("", "", " Coverage Type value : " + reqcoverageType
									+ " from Request is same as Coverage Type value in Response : " + rescoverageType,
									StepStatus.SUCCESS, new String[] {}, startTime);
						} else {
							list.add(false);
							CustomReporting.logReport("", "",
									" Coverage Type value : " + reqcoverageType
											+ " from Request is not same as Coverage Type value in Response : "
											+ rescoverageType,
									StepStatus.FAILURE, new String[] {}, startTime);

						}
					
						Map<String, String> reqProducts_limit = cFunc.getListOfKeyValue(reqcoveragePartsArr
								.getJSONObject(k).getJSONArray("coverages").getJSONObject(c));
						Map<String, String> resProducts_limit = cFunc.getListOfKeyValue(rescoveragePartsArr
								.getJSONObject(k).getJSONArray("coverages").getJSONObject(c));
						for (String key : reqProducts_limit.keySet()) {
							if (resProducts_limit.containsKey(key)) {
								String inputValue = reqProducts_limit.get(key);
								String responseValue = resProducts_limit.get(key);
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
								if(key.equals("amount")) {
									GenericFunctions.instance()._addToGlobalVariableList("respLimitValue", responseValue);
									System.out.println("crimelimit"+responseValue);
								}
								if(rescoveragePartsArr.length()>0) {
									if(k==0) {
										if(key.equals("adjusted_retention")) {
											GenericFunctions.instance()._addToGlobalVariableList("respAdjustedRetentionValue", responseValue);
											System.out.println("adjusted retention  crime"+responseValue);
										}
									}
								}
								if(rescoveragePartsArr.length()==0) {
								if(key.equals("adjusted_retention")) {
									GenericFunctions.instance()._addToGlobalVariableList("respAdjustedRetentionValue", responseValue);
									System.out.println("respAdjustedRetentionValue"+"_"+rescoveragePartCode +responseValue);
								}
								}

							}

						}

//						Map<String, String> reqProducts_deductible = cFunc
//								.getListOfKeyValue(reqcoveragePartsArr.getJSONObject(k).getJSONArray("coverages")
//										.getJSONObject(c).getJSONObject("deductible"));
//						Map<String, String> resProducts_deductible = cFunc
//								.getListOfKeyValue(rescoveragePartsArr.getJSONObject(k).getJSONArray("coverages")
//										.getJSONObject(c).getJSONObject("deductible"));
//						for (String key : reqProducts_deductible.keySet()) {
//							if (resProducts_deductible.containsKey(key)) {
//								String inputValue = reqProducts_deductible.get(key);
//								String responseValue = resProducts_deductible.get(key);
//								if (responseValue.equals(inputValue)) {
//									list.add(true);
//									CustomReporting.logReport("", "",
//											key.toUpperCase() + " value : " + inputValue.toUpperCase()
//													+ " from Request is equal to " + key.toUpperCase()
//													+ "  value in Response : " + responseValue.toUpperCase(),
//											StepStatus.SUCCESS, new String[] {}, startTime);
//								} else {
//									list.add(false);
//
//									CustomReporting.logReport("", "",
//											key.toUpperCase() + " value : " + inputValue.toUpperCase()
//													+ " from Request is not equal to " + key.toUpperCase()
//													+ " value in Response : " + responseValue.toUpperCase(),
//											"", StepStatus.FAILURE, new String[] {}, startTime, null);
//								}
//								if(key.equals("amount")) {
//									GenericFunctions.instance()._addToGlobalVariableList("respDeductionValue", responseValue);
//									System.out.println("crimedeductible"+responseValue);
//								}
//							}
//							
//						}

					}
				}

				}

			}
if(data.getData("ExpectedStatusCode").equalsIgnoreCase("QTOUT")) {
			// verification of Quote section
			Map<String, String> resQuote = cFunc.getListOfKeyValue(resSubObj.getJSONObject("quote"));
			for (String key : resQuote.keySet()) {
				if (resQuote.containsKey(key)) {

					String responseValue = resQuote.get(key);
					if (!(responseValue.equals("") || responseValue.equalsIgnoreCase("null"))) {
						list.add(true);
						CustomReporting
								.logReport(
										"", "", key.toUpperCase() + "  value in Response : "
												+ responseValue.toUpperCase() + " is not null/Blank",
										StepStatus.SUCCESS, new String[] {}, startTime);
					} else {
						list.add(false);

						CustomReporting
								.logReport("", "",
										key.toUpperCase() + "  value in Response : " + responseValue.toUpperCase()
												+ " is  null/Blank",
										"", StepStatus.FAILURE, new String[] {}, startTime, null);
					}

				}
			}
}
			/*JSONArray reqExtnObj = reqSubObj.getJSONObject("submission").getJSONArray("extensions");
			JSONArray respExtnObj = resSubObj.getJSONObject("submission").getJSONArray("extensions");
			for (int y = 0; y < reqExtnObj.length(); y++) {
				String info = respExtnObj.getJSONObject(y).get("object_name").toString();
				JSONArray reqvalueArray = reqExtnObj.getJSONObject(y).getJSONArray("values");
				JSONArray respvalueArray = respExtnObj.getJSONObject(y).getJSONArray("values");

				for (int z = 0; z < reqvalueArray.length(); z++) {
					if(z==0) {
					Map<String, String> reqExtensions = cFunc.getListOfKeyValue(reqvalueArray.getJSONObject(z));
					Map<String, String> resExtensions = cFunc.getListOfKeyValue(respvalueArray.getJSONObject(z));
					
					for (String key : reqExtensions.keySet()) {
						if (resExtensions.containsKey(key)) {
							String inputValue = reqExtensions.get(key);
							String responseValue = resExtensions.get(key);
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

			}*/

		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public void verifyCyberBindDetails(String finalStr, String resbody, Response response, PageData data)
			throws Exception {
		try {

			// verify submission id generated
			JSONObject reqSubObj = new JSONObject(finalStr);
			JSONObject resSubObj = new JSONObject(resbody);
			String reqAccountId = cFunc.getKeyValueFromInputStr(finalStr, "submission", "account_id");
			String respAccountId = cFunc.getKeyValue(response, "submission.account_id");
			if (respAccountId.equalsIgnoreCase(reqAccountId)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Account ID value : " + reqAccountId
								+ " from Request is same as Account ID value in Response : " + respAccountId,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Account ID value : " + reqAccountId
								+ " from Request is not same as Account ID value in Response : " + respAccountId,
						StepStatus.FAILURE, new String[] {}, startTime);
			}

			String reqSubmissionId = cFunc.getKeyValueFromInputStr(finalStr, "submission", "submission_id");
			String respSubmissionId = cFunc.getKeyValue(response, "submission.submission_id");
			if (respSubmissionId.equalsIgnoreCase(reqSubmissionId)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Submission ID value : " + reqSubmissionId
								+ " from Request is same as Submission ID value in Response : " + respSubmissionId,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Submission ID value : " + reqSubmissionId
								+ " from Request is not same as Submission ID value in Response : " + respSubmissionId,
						StepStatus.FAILURE, new String[] {}, startTime);
			}
			GenericFunctions.instance()._addToGlobalVariableList("submissionId", respSubmissionId);

			String respSubmissionStatus = cFunc.getKeyValue(response, "submission.submission_status");
			String respSubmissionStatusCode = cFunc.getKeyValue(response, "submission.submission_status_code");
			//String respStateCode = cFunc.getKeyValue(response, "submission.predominant_state_code");
			System.out.println("status " + respSubmissionStatus);

			/*if (respSubmissionStatus.equalsIgnoreCase(data.getData("ExpectedStatus"))) {
				list.add(true);
				CustomReporting.logReport(
						"", "", "  Submission Status  value in Response is equal to : "
								+ respSubmissionStatus.toUpperCase() + " is as expected",
						StepStatus.SUCCESS, new String[] {}, startTime);

			} else {
				list.add(false);
				CustomReporting
						.logReport(
								"", "", " Submission Status  value in Response : "
										+ respSubmissionStatus.toUpperCase() + " is not as expected",
								StepStatus.FAILURE, new String[] {}, startTime);

			}*/

			if (respSubmissionStatusCode.equalsIgnoreCase(data.getData("ExpectedStatusCode"))) {
				list.add(true);
				CustomReporting.logReport(
						"", "", "  Submission Status Code value in Response is equal to : "
								+ respSubmissionStatusCode.toUpperCase() + " is as expected",
						StepStatus.SUCCESS, new String[] {}, startTime);

			} else {
				list.add(false);
				CustomReporting
						.logReport(
								"", "", " Submission Status Code value in Response : "
										+ respSubmissionStatusCode.toUpperCase() + " is not as expected",
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

			String reqBillingType = cFunc.getKeyValueFromInputStr(finalStr, "submission", "billing_type");
			String respBillingType = cFunc.getKeyValue(response, "submission.billing_type");
			if (respBillingType.equalsIgnoreCase(reqBillingType)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Billing Type value : " + reqBillingType
								+ " from Request is same as Billing Type value in Response : " + respBillingType,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Billing Type value : " + reqBillingType
								+ " from Request is not same as Billing Type value in Response : " + respBillingType,
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			String reqBusinessSegmentCode = cFunc.getKeyValueFromInputStr(finalStr, "submission",
					"business_segment_code");
			String respBusinessSegmentCode = cFunc.getKeyValue(response, "submission.business_segment_code");
			if (respBusinessSegmentCode.equalsIgnoreCase(reqBusinessSegmentCode)) {
				list.add(true);
				CustomReporting.logReport("", "", " Business Segment Code value : " + reqBusinessSegmentCode
						+ " from Request is same as Business Segment value in Response : " + respBusinessSegmentCode,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Business Segment Code value : " + reqBusinessSegmentCode
								+ " from Request is not same as Business Segment Code value in Response : "
								+ respBusinessSegmentCode,
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			String respInsuringCompanyCode = cFunc.getKeyValue(response, "submission.insuring_company_id");
			if (!(respInsuringCompanyCode.equalsIgnoreCase("null") || respInsuringCompanyCode.equals(""))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"Insuring Company Code is not null/Blank in Response and returned value is "
								+ respInsuringCompanyCode,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"Insuring Company Code is  null/Blank in Response and returned value is "
								+ respInsuringCompanyCode,
						StepStatus.FAILURE, new String[] {}, startTime);

			}
			String respLicensedAgentNPN = cFunc.getKeyValue(response, "submission.licensed_agent_npn");
			if (!(respLicensedAgentNPN.equalsIgnoreCase("null") || respLicensedAgentNPN.equals(""))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"License Agent NPN value is not null/Blank in Response and returned value is "
								+ respLicensedAgentNPN,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"License Agent NPN value is  null/Blank in Response and returned value is "
								+ respLicensedAgentNPN,
						StepStatus.FAILURE, new String[] {}, startTime);

			}
			String respLicenseClassification = cFunc.getKeyValue(response, "submission.license_classification");
			if (!(respLicenseClassification.equalsIgnoreCase("null") || respLicenseClassification.equals(""))) {
				list.add(true);
				CustomReporting.logReport("", "",
						" License Classification is not null/Blank in Response and returned value is "
								+ respLicenseClassification,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"License Classification is  null/Blank in Response and returned value is "
								+ respLicenseClassification,
						StepStatus.FAILURE, new String[] {}, startTime);

			}
			String resplicense_number = cFunc.getKeyValue(response, "submission.license_number");
			if (!(resplicense_number.equalsIgnoreCase("null") || resplicense_number.equals(""))) {
				list.add(true);
				CustomReporting.logReport("", "",
						"License Number is not null/Blank in Response and returned value is " + resplicense_number,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						"License Number is  null/Blank in Response and returned value is " + resplicense_number,
						StepStatus.FAILURE, new String[] {}, startTime);
			}

			String reqUnderwriter = cFunc.getKeyValueFromInputStr(finalStr, "submission", "underwriter");
			String respUnderwriter = cFunc.getKeyValue(response, "submission.underwriter");
			if (respUnderwriter.equalsIgnoreCase(reqUnderwriter)) {
				list.add(true);
				CustomReporting.logReport("", "",
						" Underwriter value : " + reqUnderwriter
								+ " from Request is same as Underwriter value in Response : " + respUnderwriter,
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				list.add(false);
				CustomReporting.logReport("", "",
						" Underwriter value : " + reqUnderwriter
								+ " from Request is not same as Underwriter value in Response : " + respUnderwriter,
						StepStatus.FAILURE, new String[] {}, startTime);

			}

			// verification of products section
			JSONArray reqProductsArry = reqSubObj.getJSONObject("submission").getJSONArray("products");
			JSONArray respProductsArry = resSubObj.getJSONObject("submission").getJSONArray("products");
			for (int j = 0; j < reqProductsArry.length(); j++) {

				String reqProductCode = reqProductsArry.getJSONObject(j).get("product_code").toString();
				String respProductCode = respProductsArry.getJSONObject(j).get("product_code").toString();
				if (respProductCode.equalsIgnoreCase(reqProductCode)) {
					list.add(true);
					CustomReporting.logReport("", "",
							" Product Code value : " + reqProductCode
									+ " from Request is same as Product Code value in Response : " + respProductCode,
							StepStatus.SUCCESS, new String[] {}, startTime);
				} else {
					list.add(false);
					CustomReporting.logReport("", "", "  Product Code value : " + reqProductCode
							+ " from Request is not same as Product Code Value in Response : " + respProductCode,
							StepStatus.FAILURE, new String[] {}, startTime);
				}

				String reqOfferingCode = reqProductsArry.getJSONObject(j).get("offering_code").toString();
				String respofferingCode = respProductsArry.getJSONObject(j).get("offering_code").toString();
				if (respofferingCode.equalsIgnoreCase(reqOfferingCode)) {
					list.add(true);
					CustomReporting.logReport("", "",
							" Offering Code value : " + reqOfferingCode
									+ " from Request is same as Offering Code value in Response : " + respofferingCode,
							StepStatus.SUCCESS, new String[] {}, startTime);
				} else {
					list.add(false);
					CustomReporting.logReport("", "", "  Offering Code value : " + reqOfferingCode
							+ " from Request is not same as Offering Code Value in Response : " + respofferingCode,
							StepStatus.FAILURE, new String[] {}, startTime);
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
						if (key.equals("revenue") || key.equals("corporate_assets")
								|| key.equals("foreign_employees")) {
							GenericFunctions.instance()._addToGlobalVariableList("res" + "_" + key, responseValue);
						}

					}
				}

				JSONArray reqcoveragePartsArr = reqProductsArry.getJSONObject(j).getJSONObject("management_liability")
						.getJSONArray("coverage_parts");
				JSONArray rescoveragePartsArr = respProductsArry.getJSONObject(j).getJSONObject("management_liability")
						.getJSONArray("coverage_parts");
				for (int k = 0; k < reqcoveragePartsArr.length(); k++) {
					String reqcoveragePartCode = reqcoveragePartsArr.getJSONObject(k).get("coverage_part_code")
							.toString().toLowerCase();
					String rescoveragePartCode = rescoveragePartsArr.getJSONObject(k).get("coverage_part_code")
							.toString().toLowerCase();

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
					// String resCoveragePartCode = cFunc.getKeyValue(response,
					// "submission.products[0].management_liability.coverage_parts[0].coverage_part_code").toLowerCase();

					GenericFunctions.instance()._addToGlobalVariableList("rescoveragePartCode", rescoveragePartCode);

					Map<String, String> reqProducts_crime = cFunc
							.getListOfKeyValue(reqcoveragePartsArr.getJSONObject(k).getJSONObject(rescoveragePartCode));
					Map<String, String> resProducts_crime = cFunc
							.getListOfKeyValue(rescoveragePartsArr.getJSONObject(k).getJSONObject(rescoveragePartCode));
					for (String key : reqProducts_crime.keySet()) {
						if (resProducts_crime.containsKey(key)) {
							String inputValue = reqProducts_crime.get(key);
							String responseValue = resProducts_crime.get(key);

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

							if (rescoveragePartCode.equalsIgnoreCase("CYBER_LIABILITY")) {
								if (key.equals("limit")) {
									GenericFunctions.instance()._addToGlobalVariableList(
											"limit", responseValue);
									System.out.println("limit" + responseValue);
								}

								if (key.equals("retention")) {

									GenericFunctions.instance()._addToGlobalVariableList(
											"retention", responseValue);
									System.out.println("retention" + responseValue);
								}
							}

						}

					}

				}

			}
			if (data.getData("ExpectedStatusCode").equalsIgnoreCase("PLYISUD")) {
				// verification of Quote section
				Map<String, String> resPolicy = cFunc.getListOfKeyValue(resSubObj.getJSONObject("policy"));
				for (String key : resPolicy.keySet()) {
					if (resPolicy.containsKey(key)) {

						String responseValue = resPolicy.get(key);
						if (!(responseValue.equals("") || responseValue.equalsIgnoreCase("null"))) {
							list.add(true);
							CustomReporting
									.logReport("", "",
											key.toUpperCase() + "  value in Response : " + responseValue.toUpperCase()
													+ " is not null/Blank",
											StepStatus.SUCCESS, new String[] {}, startTime);
						} else {
							list.add(false);

							CustomReporting.logReport("", "",
									key.toUpperCase() + "  value in Response : " + responseValue.toUpperCase()
											+ " is  null/Blank",
									"", StepStatus.FAILURE, new String[] {}, startTime, null);
						}

					}
				}
				
				
				Map<String, String> resQuote = cFunc.getListOfKeyValue(resSubObj.getJSONObject("quote"));
				for (String key : resQuote.keySet()) {
					if (resQuote.containsKey(key)) {

						String responseValue = resQuote.get(key);
						if (!(responseValue.equals("") || responseValue.equalsIgnoreCase("null"))) {
							list.add(true);
							CustomReporting
									.logReport("", "",
											key.toUpperCase() + "  value in Response : " + responseValue.toUpperCase()
													+ " is not null/Blank",
											StepStatus.SUCCESS, new String[] {}, startTime);
						} else {
							list.add(false);

							CustomReporting.logReport("", "",
									key.toUpperCase() + "  value in Response : " + responseValue.toUpperCase()
											+ " is  null/Blank",
									"", StepStatus.FAILURE, new String[] {}, startTime, null);
						}

					}
				}
			}

		} catch (Exception e) {
			throw e;
		}
	}
	
	}
	
	

