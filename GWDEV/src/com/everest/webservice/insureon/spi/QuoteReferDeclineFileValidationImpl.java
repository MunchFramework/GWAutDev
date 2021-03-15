package com.everest.webservice.insureon.spi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.testng.asserts.SoftAssert;
import org.xframium.device.DeviceManager;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.GenericFunctions;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;
import com.everest.utility.ExcelDataReader;
import com.everest.webservice.insureon.QuoteReferDeclineFileValidation;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;


public class QuoteReferDeclineFileValidationImpl extends CustomAbstractPage implements QuoteReferDeclineFileValidation{
	
	
	List<Boolean> list = new ArrayList<Boolean>();
	long startTime = System.currentTimeMillis();
	
	@SuppressWarnings("unused")
	@Override
	public void verifyReferalMail(String tcID, SoftAssert softAssert) throws Exception{
		 long startTime = System.currentTimeMillis();
		PageData QuoteData=PageDataManager.instance().getPageData("GetQuote",tcID);
		PageData data = PageDataManager.instance().getPageData("QuoteLetterValidation", tcID);
		String subID=GenericFunctions.instance()._getGlobalVariableValue("submissionId");
		String ScenarioType=QuoteData.getData("ExpectedStatus");
		PrintWriter writer = new PrintWriter(DeviceManager.instance().getConfigurationProperties().getProperty("Print.Writer")+"\\PayLoads\\EmailContent.txt");
		writer.print("");
		writer.close();
		Runtime.getRuntime().exec("wscript "+DeviceManager.instance().getConfigurationProperties().getProperty("Print.Writer")+"\\Read1.vbs " + subID + " " +ScenarioType);
		//Declined
		//1290668-1
		Thread.sleep(60000);
		String SubmissionMailContent=cFunc.getUpdateInputAsString("EmailContent.txt");
		System.out.println(SubmissionMailContent);
		if(ScenarioType.equalsIgnoreCase("Declined")) {
			
			String ExpectedDclineMailContent=cFunc.getUpdateInputAsString("ExpectedDeclineEmailContent.txt");
			if(SubmissionMailContent.contains(ExpectedDclineMailContent)) {
				CustomReporting.logReport("", "",
						"The Decline mail  : " + SubmissionMailContent
								+ " Contain the correct Decline mail format "+ExpectedDclineMailContent+ " as Expected : " + "",
						StepStatus.SUCCESS, new String[] {}, startTime);
				
				
			}else {
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
						tcID);
				CustomReporting.logReport("", "",
						"The Decline mail  : " + SubmissionMailContent
								+ " doesn't containe the required decline mail content :"+ExpectedDclineMailContent+ "which is unexpected : " + "",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
		}else if (ScenarioType.equalsIgnoreCase("Underwriter Review") && data.getData("RefferalType(State#UW#Others)").equalsIgnoreCase("State")) {
			if(SubmissionMailContent.contains("Insured State CA")) {
				CustomReporting.logReport("", "",
						"The Referal mail  : " + SubmissionMailContent
								+ " Contain the correct referal reason" + " as Expected : " + "",
						StepStatus.SUCCESS, new String[] {}, startTime);
				
				
			}else {
				GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
						tcID);
			CustomReporting.logReport("", "",
					"The Referal mail  : " + SubmissionMailContent
							+ " doesn't Contain the correct referal reason" + ": " + "",
					StepStatus.FAILURE, new String[] {}, startTime);
			}
		}
		
 		else if(ScenarioType.equalsIgnoreCase("Underwriter Review") && data.getData("RefferalType(State#UW#Others)").equalsIgnoreCase("UW")) {
			
			ExcelDataReader EligibilityQuestions=new ExcelDataReader("./resources/TestData.xlsx");
			int ElligibilityQuesSize=EligibilityQuestions.getLastRowNumber("UnderWritingQuestions");
			Map<String, String> ObjDataSheetmap= new LinkedHashMap<String, String>();
			for (int j=2;j<=ElligibilityQuesSize+1;j++) {
			String Questions=EligibilityQuestions.getCellData("UnderWritingQuestions","Underwriting Question",j).toString();
			String RefferalReasons=EligibilityQuestions.getCellData("UnderWritingQuestions","ReferralReasons",j).toString();
			ObjDataSheetmap.put(Questions.toUpperCase().trim(), RefferalReasons.trim());
			}
			WebServiceGetQuoteImpl getQuoteClassObj= new WebServiceGetQuoteImpl();
			
			String finalStr = GenericFunctions.instance()._getGlobalVariableValue("QuoteFinalRequest");
			Set<String> setOfUWQuestins=getQuoteClassObj.RetrieveAllUWQuest(finalStr);
			System.out.println(setOfUWQuestins);
			for(String UWQuestionsSet:setOfUWQuestins) {
				System.out.println(UWQuestionsSet);
				
				System.out.println(ObjDataSheetmap.get(UWQuestionsSet));
				if(SubmissionMailContent.contains(ObjDataSheetmap.get(UWQuestionsSet))) {
					CustomReporting.logReport("", "",
							"The Referal mail  : " + ""
									+ " Contain the referal reason" + ObjDataSheetmap.get(UWQuestionsSet)+" as Expected : " + "",
							StepStatus.SUCCESS, new String[] {}, startTime);
					
				}else {
					GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
							tcID);
				CustomReporting.logReport("", "",
						"The Referal mail  : " +""
								+ " doesn't Contain the correct referal reason" +ObjDataSheetmap.get(UWQuestionsSet) +": " + "",
						StepStatus.FAILURE, new String[] {}, startTime);
				}
			}
		
		}
		}
		
	
	@SuppressWarnings("unused")
	@Override
	public void verifyQuoteDocDetails(String tcID, SoftAssert softAssert) throws Exception {
		PageData authData = PageDataManager.instance().getPageData("GenerateAuthKey", tcID);
		PageData docData = PageDataManager.instance().getPageData("SubmissionDocuments", tcID);
		PageData EnvironmentData = PageDataManager.instance().getPageData("Config", tcID);
		PageData data = PageDataManager.instance().getPageData("QuoteLetterValidation", tcID);
		PageData subData=PageDataManager.instance().getPageData("Submission",tcID);
		String InsuredName=GenericFunctions.instance()._getGlobalVariableValue("respInsuredName");
        long startTime = System.currentTimeMillis();
        String submissionID =GenericFunctions.instance()._getGlobalVariableValue("submissionId");
       
        
        String apiServerUrl=null;
        
        String endPointURL = null;
		String XIBMClientID = null;
		String XIBMClientSecret =null;
		String resourceURL_submissionDocs = docData.getData("SubmissionDocsResourceURL");
		String resourceURL_downloadDocs = docData.getData("DownloadDocsResourceURL");
		
        String env = GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV");
		if (!env.isEmpty()) {
			if (env.equalsIgnoreCase("DEV")) {
				endPointURL = docData.getData("DEVEndPointUrl");
				XIBMClientID = docData.getData("DEVX-IBM-Client-Id");
				XIBMClientSecret = docData.getData("DEVX-IBM-Client-Secret");
			} else {
				if (env.equalsIgnoreCase("QA")) {
					endPointURL = docData.getData("QAServerURL");
					XIBMClientID = docData.getData("QAX-IBM-Client-Id");
					XIBMClientSecret = docData.getData("QAX-IBM-Client-Secret");
				} else {
					endPointURL = docData.getData("STAGEServerURL");
					XIBMClientID = docData.getData("X-IBM-Client-Id");
					XIBMClientSecret = docData.getData("X-IBM-Client-Secret");
				}
			}
		} else {
			if (EnvironmentData.getData("Environment").equals("DEV")) {
				endPointURL = docData.getData("DEVEndPointUrl");
				XIBMClientID = docData.getData("DEVX-IBM-Client-Id");
				XIBMClientSecret = docData.getData("DEVX-IBM-Client-Secret");
			} else {
				if (EnvironmentData.getData("Environment").equals("QA")) {
					endPointURL = docData.getData("QAServerURL");
					XIBMClientID = docData.getData("QAX-IBM-Client-Id");
					XIBMClientSecret = docData.getData("QAX-IBM-Client-Secret");
				} else {
					endPointURL = docData.getData("STAGEServerURL");
					XIBMClientID = docData.getData("X-IBM-Client-Id");
					XIBMClientSecret = docData.getData("X-IBM-Client-Secret");
				}
			}
		}
        
       
      
       int intquotePremium=Integer.parseInt(GenericFunctions.instance()._getGlobalVariableValue("resQuotedPremium").split("[.]")[0]); 
    
    
        
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String quotePremiumAsString = numberFormat.format(intquotePremium);
        
        Thread.sleep(60000);
        String cType = docData.getData("ContentType");
        String accept = docData.getData("Accept");
        
        try {
               
        	WebServiceGenerateAuthTokenImpl authcodeobj = new WebServiceGenerateAuthTokenImpl();
			String authcode = authcodeobj.generateAuthTokenCode(tcID, softAssert);
              
               
               RequestSpecification requestSpecification1 = RestAssured.given();
               requestSpecification1.header("Authorization", "Bearer " + authcode);
               requestSpecification1.headers("content-type", cType);
               requestSpecification1.headers("Accept", accept);
               requestSpecification1.headers("X-IBM-Client-Id", XIBMClientID);
   			requestSpecification1.headers("X-IBM-Client-Secret", XIBMClientSecret);
               Response response2=null;
               for(int i=0;i<3;i++) {
            	  
            	   response2 = requestSpecification1.get(endPointURL+resourceURL_submissionDocs+submissionID);
            	   System.out.println("submission documents" +response2.asString());
            	   String PageId = cFunc.getKeyValue(response2, "[0].page_id");
               }
               response2.asString();
               
               String PageId = cFunc.getKeyValue(response2, "[0].page_id");
				String resbody = response2.asString();
				
				
               Response response1 = requestSpecification1.get(endPointURL+resourceURL_downloadDocs+PageId);
               
               System.out.println("response code" + response1.statusCode());
               
               System.out.println("response header " + response1.getHeader("Content-Disposition"));
               
               System.out.println("response" + response1);
               //GetFileName
               String[] contentDisposition =  response1.getHeader("Content-Disposition").split(";");
               
               String file = "";
               
                for (String filename : contentDisposition) {
        
                    if ((filename.trim().startsWith("filename"))) {
        
                        String[] name = filename.split("=");
                        file = name[1];
                        System.out.println("fileName " + file);
                        break;
                        
                    }
                }
                //convert response to byte array
         
          
                byte[] fileContents = response1.getBody().asByteArray();
                String strResponse=response1.asString();
                
                //writetofile
                String folderName = DeviceManager.instance().getConfigurationProperties().getProperty("pdf.path")+file+"_"+PageId+".pdf";
                File fileN = new File(folderName);
                if (!fileN.exists()) {
                    fileN.createNewFile();
                    System.out.println("file created successfully");
                }
                FileOutputStream fop = new FileOutputStream(fileN);
                fop.write(fileContents);
                fop.flush();
                fop.close();
                
                PdfReader readertext = new PdfReader(DeviceManager.instance().getConfigurationProperties().getProperty("pdf.path")+file+"_"+PageId+".pdf");
                PdfReaderContentParser parser = new PdfReaderContentParser(readertext);
                TextExtractionStrategy strategy = null;
                String temp="";
                String FormListPage="";
               			  
                  for(int i = 1; i <= readertext.getNumberOfPages(); i++) {
                	  if((i==6)||(i==5)){
                		  
                     strategy = parser.processContent(i,new SimpleTextExtractionStrategy());
                		  
                    FormListPage=FormListPage+"Page :" +i+strategy.getResultantText();
                    
                    
                	   //text for each page   
              
                	
                	  }
                	  else {
                		  strategy = parser.processContent(i,new SimpleTextExtractionStrategy());
                      	
                      	temp=temp+"Page :" +i+strategy.getResultantText();
                      	
                		 
                	  }
                		  
                	
                     }
                /* System.out.println(FormListPage);
                  //System.out.println(temp);
                  List<String> LisOfValuesToBeValidated =new ArrayList<String>();
                  LisOfValuesToBeValidated.add(data.getData("UWName_Address"));
                  LisOfValuesToBeValidated.add(data.getData("AdditionalUWInfo"));
                  LisOfValuesToBeValidated.add(data.getData("ProposedCoverage"));                 
                  LisOfValuesToBeValidated.add("Insured Name: "+InsuredName); 
                  LisOfValuesToBeValidated.add("Policy Premium: $"+quotePremiumAsString); 
                  
                  LisOfValuesToBeValidated.add("Insurer: "+data.getData("Insurer"));
                  
                  
                  for (String ExpectedValue:LisOfValuesToBeValidated) {
                	  if(temp.contains(ExpectedValue)) {
                		  CustomReporting.logReport("", "",
  								"The quote letter contains the value: " + ExpectedValue
  										+ " as Expected : " + "",
  								StepStatus.SUCCESS, new String[] {}, startTime);
                		  
                	  }else {
                		  CustomReporting.logReport("", "",
    								"The quote letter does not contains the value: " + ExpectedValue
    										+ "which is not as exepcted : " + "",
    								StepStatus.FAILURE, new String[] {}, startTime);
                	  }
                	  
                  }
                temp=temp.replace("\n", " ");
                temp=temp.replace("  ", " ");
                Set<String> setOfForms= new  HashSet<String>();                
              	ExcelDataReader dataSheet=new ExcelDataReader("./resources/TestData.xlsx");
              	
              	int noOfCoverages=subData.getData("CoveragePart").split("#").length;
              	
              for(int j=0;j<noOfCoverages;j++) {
              	if(subData.getData("CoveragePart").split("#")[j].equalsIgnoreCase("CRI")) {
                int NoOfFormstoBEvalid=	dataSheet.getLastRowNumber("FormsListCrime");           
    			for (int k=2;k<=NoOfFormstoBEvalid+1;k++) {
    			String PolicyEndorsmentForm=dataSheet.getCellData("FormsListCrime","PolicyEndoresementForm",k).toString();    
    			setOfForms.add(PolicyEndorsmentForm);
    			}
    			}else if(subData.getData("CoveragePart").split("#")[j].equalsIgnoreCase("DNO")) {
    				int NoOfFormstoBEvalid=	dataSheet.getLastRowNumber("FormsListDNO");           
        			for (int k=2;k<=NoOfFormstoBEvalid+1;k++) {
        			String PolicyEndorsmentForm=dataSheet.getCellData("FormsListDNO","PolicyEndoresementForm",k).toString();    
        			setOfForms.add(PolicyEndorsmentForm);
    			}
    			}else if(subData.getData("CoveragePart").split("#")[j].equalsIgnoreCase("EPL")) {
    				int NoOfFormstoBEvalid=	dataSheet.getLastRowNumber("FormsListEPL");           
        			for (int k=2;k<=NoOfFormstoBEvalid+1;k++) {
        			String PolicyEndorsmentForm=dataSheet.getCellData("FormsListEPL","PolicyEndoresementForm",k).toString();    
        			setOfForms.add(PolicyEndorsmentForm);
    			}
              }else if(subData.getData("CoveragePart").split("#")[j].equalsIgnoreCase("FID")) {
  				int NoOfFormstoBEvalid=	dataSheet.getLastRowNumber("FormsListFID");           
    			for (int k=2;k<=NoOfFormstoBEvalid+1;k++) {
    			String PolicyEndorsmentForm=dataSheet.getCellData("FormsListFID","PolicyEndoresementForm",k).toString();    
    			setOfForms.add(PolicyEndorsmentForm);
			}
    			
          }else if(subData.getData("CoveragePart").split("#")[j].equalsIgnoreCase("CYBER_LIABILITY")) {
  				int NoOfFormstoBEvalid=	dataSheet.getLastRowNumber("FormsListCyber");           
    			for (int k=2;k<=NoOfFormstoBEvalid+1;k++) {
    			String PolicyEndorsmentForm=dataSheet.getCellData("FormsListCyber","PolicyEndoresementForm",k).toString();    
    			setOfForms.add(PolicyEndorsmentForm);
			}
    			
          }
              }  for(String formsList:setOfForms) {
                	  if(FormListPage.contains(formsList)) {
                		  
                		  CustomReporting.logReport("", "",
    								"The optional form : " + formsList
    										+ " available in the list of forms on the quote letter in page 6 as Expected : " + "",
    								StepStatus.SUCCESS, new String[] {}, startTime);
                	  }else {
                		  CustomReporting.logReport("", "",
  								"The optional form : " + formsList
  										+ " inis not available in the list of forms on the quote letter on  page 6 is not Expected : " + "",
  								StepStatus.FAILURE, new String[] {}, startTime);
                		  
                	  }
                	  
                	  if((temp.toLowerCase()).contains(formsList.toLowerCase())) {
                		  
                		  CustomReporting.logReport("", "",
  								"The optional form : " + formsList
  										+ " is available with the attachemnt as expected " + "",
  								StepStatus.SUCCESS, new String[] {}, startTime);
                	  }else {
                		  CustomReporting.logReport("", "",
    								"The optional form : " + formsList
    										+ " is not available with the attachemnt. " + "",
    								StepStatus.FAILURE, new String[] {}, startTime);
                	  }
                  }
                  
                  
                  
                 
               
               System.out.println(temp);*/
        } catch (RuntimeException ex) {
        	GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
               throw ex;
        }

 }
	
	
	
	public  String convertDateFormatOfQuoteDate(String dateString) throws ParseException {
        System.out.println("Given date is " + dateString);
 
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
        Date date = sdf.parse(dateString);
 
       return new SimpleDateFormat("MM/dd/yyyy").format(date);
        
 
    }


	@Override
	public void uploadSignedAppDocument(String tcID, SoftAssert softAssert) throws Exception {
		try  {
			PageData EnvironmentData = PageDataManager.instance().getPageData("Config", tcID);
			PageData data= PageDataManager.instance().getPageData("UploadDocuments", tcID);
			//escapeData = PageDataManager.instance().getPageData("EscapeApplicationPage", tcID);
			String submissionID =GenericFunctions.instance()._getGlobalVariableValue("submissionId");
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
			
			
			WebServiceGenerateAuthTokenImpl authcodeobj = new WebServiceGenerateAuthTokenImpl();
			String authcode = authcodeobj.generateAuthTokenCode(tcID, softAssert);
			String path = data.getData("Payloadpath");
			
			String authKey = "Bearer " + authcode;
			String cType = data.getData("ContentType");
			String finalStr = cFunc.getUpdateInputAsString(path);
			Response response = cFunc.customWebServiceCall(finalStr, authKey, cType, endPointURL+submissionID, XIBMClientID,
					XIBMClientSecret, "");
			String resbody = response.asString();
			if (response != null) {
				int code = response.statusCode();
				String statusLine = response.statusLine();

				Collections.fill(list, Boolean.TRUE);

				if (code == 200 || code == 201) {
					list.add(true);
					CustomReporting.logReport("", "",
							"Signed Application Document Uploaded Successfully for Submision Id " + submissionID,
							StepStatus.SUCCESS, new String[] {}, startTime);
					
				} else {
					list.add(false);

					CustomReporting.logReport("", "",
							" Unable to upload Signed Application Document for Submission Id " + submissionID + " and returned code "  + code + statusLine, "",
							StepStatus.FAILURE, new String[] {}, startTime, null);

				}
			}
			
		}catch (RuntimeException ex) {
        	GenericFunctions.instance()._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(),
					tcID);
               throw ex;
        }
		
	}
	
	/*@Override 
	public void extractNAICSData(String tcID, SoftAssert softAssert) throws Exception{
		XSSFWorkbook workbook = null;
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File("D:\\NAICS.xlsx"));

			workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Sheet2");
			int rows = sheet.getPhysicalNumberOfRows();
			ArrayList<String> respData = new ArrayList<String>();
			System.out.println(rows);
			for (int i = 0; i < rows; i++) {
				System.out.println(sheet.getRow(i).getCell(CellReference.convertColStringToIndex("A")));
				// System.out.println(sheet.getRow(i));
				// XSSFCell naics =
				// sheet.getRow(i).getCell(CellReference.convertColStringToIndex("A"));
				RequestSpecification requestSpecification1 = RestAssured.given();
				// requestSpecification1.header("Authorization", "Bearer " + accessToken);
				requestSpecification1.headers("content-type", "application/json");
				requestSpecification1.headers("client_id", "esb_mrdh_api");
				requestSpecification1.headers("client_secret", "EsB_MR@dfgjLO)5mvsjwok(;wd67Dv");
				requestSpecification1.headers("scope", "mrdh.read");
				requestSpecification1.headers("X-IBM-Client-Id", "91d2a037-5b25-4a04-9932-8ac350da8a74");
				requestSpecification1.headers("X-IBM-Client-Secret",
						"pM1qG7eD7pJ7dQ2sI4aP6bS1wW8fH1mV0nG6wR2yQ1uR7aH6fA");
				Response resp = requestSpecification1.get(
						"https://qa-services.everestre.com/everest-global-services/qa/mrddbapi/api/NAICS_SIC_GICS/GetNAICS_SIC_GICS?NAICSCode="
								+ sheet.getRow(i).getCell(CellReference.convertColStringToIndex("A")));
				System.out.println(resp.asString());
				if (resp.getStatusCode() == 200) {
					JSONArray naicsArr = new JSONArray(resp.asString());
					String code = naicsArr.getJSONObject(0).get("NAICS_Code").toString();
					String NAICS_Description = naicsArr.getJSONObject(0).get("NAICS_Description").toString();
					String SIC_Code = naicsArr.getJSONObject(0).get("SIC_Code").toString();
					String SIC_Description = naicsArr.getJSONObject(0).get("SIC_Description").toString();
					String Enterprise_Code = naicsArr.getJSONObject(0).get("Enterprise_Code").toString();
					String GICS_Sector_Code = naicsArr.getJSONObject(0).get("GICS_Sector_Code").toString();
					String GICS_Sector = naicsArr.getJSONObject(0).get("GICS_Sector").toString();
					String data = NAICS_Description + ";" + SIC_Code + ";" + SIC_Description + ";" + Enterprise_Code
							+ ";" + GICS_Sector_Code + ";" + GICS_Sector;
					respData.add(code + ";" + data);
				}

			}
			

		} catch (Exception ex) {
			throw ex;
		}finally {
			workbook.close();
		}
	}*/
	
	



	


}
