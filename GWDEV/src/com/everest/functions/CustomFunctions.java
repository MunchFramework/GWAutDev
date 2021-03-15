package com.everest.functions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.xmlbeans.impl.soap.MessageFactory;
import org.apache.xmlbeans.impl.soap.MimeHeaders;
import org.apache.xmlbeans.impl.soap.SOAPConnection;
import org.apache.xmlbeans.impl.soap.SOAPConnectionFactory;
import org.apache.xmlbeans.impl.soap.SOAPMessage;
import org.apache.xmlbeans.impl.soap.SOAPPart;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.w3c.dom.Document;
import org.xframium.device.DeviceManager;
import org.xframium.device.ng.AbstractSeleniumTest;
import org.xframium.page.StepStatus;
import org.xframium.page.element.Element;

import com.everest.utility.CustomReporting;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.internal.JsonFormatter;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class CustomFunctions extends AbstractSeleniumTest{
	
private static CustomFunctions singleton = new CustomFunctions();
public static GenericFunctions func = GenericFunctions.instance();

	private CustomFunctions() {

	}

	public static CustomFunctions instance() {
		return singleton;
	}
	
	
	@SuppressWarnings("finally")
	public String getCustomElementName(Element el, String strPage)  {

		//return el.toString();
		
        String strElementName=null;
         try {
        	 
        File directory = new File("./");
 		System.out.println(directory.getAbsolutePath());
 		String strDirectoryPath =directory.getAbsolutePath().split("\\.") [0];
 		String xmlPath=strDirectoryPath+"resources\\pageElements.xml";
 		
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlPath);
        
        XPathFactory xPathfactory = XPathFactory.newInstance();
	  	XPath xpath = xPathfactory.newXPath();
	  	
	  	String strVal=el.toString().split("\\{")[1].split("\\}")[0].trim();
	  	String strPageName=strPage;
	  	String strXPath="//site/page[@name='" + strPageName + "']/element[";

	  	if (strVal.contains("'")){
	  		
	  		
	  		String[] arrList=strVal.split("'");
	  		System.out.println(arrList.length);
	  		for (int i=0;i<=arrList.length-1;i++) {
	  			strXPath=strXPath+"contains(@value,'" + arrList[i] +"') and ";
	  		}
	  		strXPath=strXPath.substring(0, strXPath.length()-5)+"]/@name";
	  		
	  	}
	  	else {
	  		strXPath = strXPath+"contains(@value,'" + strVal +"')" +"]/@name";
	  	}
	  	
	  	  System.out.println(strXPath);
	  	  XPathExpression expr = xpath.compile(strXPath);
	  	  
	  	  strElementName=(String) expr.evaluate(doc, XPathConstants.STRING);
	  	  
		  System.out.println(strElementName);
	  	
        return strElementName;
         }
          catch(Exception ex) {
          //throw ex; 
         }
         finally {
        	 return strElementName; 
         }
	}
	//generate Random numbers
		public String generate_RandomNumber(int Digits) {
			long timeStamp = System.nanoTime(); // to get the current date time value

			double randomNum = Math.random() * 1000; // random number generation

			long midSeed = (long) (timeStamp * randomNum);
			// mixing up the time and random number. variable timeStamp will be unique
			// variable random will ensure no relation between the numbers
			String s = midSeed + "";
			String subStr = s.substring(0, Digits);

			// int finalSeed = Integer.parseInt(subStr);
			return subStr;
		}
		
		
		
		public void writeToProperty(String Key, String Value) throws IOException {
			long startTime = System.currentTimeMillis();
			Properties prop = new Properties();
			//File directory = new File("@/");
			//String strDirectoryPath =directory.getAbsolutePath().split("\\@") [0];
			String propPath = DeviceManager.instance().getConfigurationProperties().getProperty("property.path");
			//propPath = strDirectoryPath + propPath;
			
			InputStream input=new FileInputStream(propPath);
			prop.load(input);
			//input.close();
			FileOutputStream outFile =new FileOutputStream(new File(propPath));
			prop.setProperty(Key, Value);
			prop.store(outFile, Key+" Added");
			outFile.close();
			
			CustomReporting.logReport("","", "Key: "+Key+" added to the Property file with the value: "+Value,StepStatus.SUCCESS,new String[] {},startTime);
		}
		
		public String getFromProperty(String Key) throws IOException {
			long startTime = System.currentTimeMillis();
			Properties prop = new Properties();
			//File directory = new File("@/");
			//String strDirectoryPath =directory.getAbsolutePath().split("\\@") [0];
			String propPath = DeviceManager.instance().getConfigurationProperties().getProperty("property.path");
			//propPath = strDirectoryPath + propPath;
			
			InputStream input=new FileInputStream(propPath);
			prop.load(input);
			String strVal=prop.getProperty(Key);
			return strVal;
		}
		
		public Response webServiceCall(String authKey, String contentType, String endPointUrl,
				String value) {
			Response response=null;
		
			try {
				if (value.equals("")) {
					RequestSpecification requestSpecification = RestAssured.given();
					requestSpecification.header("Authorization", authKey);
					requestSpecification.headers("content-type", contentType);
					response = requestSpecification.get(endPointUrl);
				
				} else  {
					RequestSpecification requestSpecification = RestAssured.given();
					requestSpecification.header("Authorization", authKey);
					requestSpecification.headers("content-type", contentType);
					response = requestSpecification.get(endPointUrl+"/"+value);
					
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return response;

		}
		public Response webServiceCall(String authKey, String contentType, String endPointUrl, Map<String,String> queryParameter) {
			Response response=null;
			
			try {
				RestAssured.useRelaxedHTTPSValidation();
					RequestSpecification requestSpecification = RestAssured.given();
					requestSpecification.header("Authorization", authKey);
					requestSpecification.headers("content-type", contentType);
					response = requestSpecification.parameters(queryParameter).get(endPointUrl);
					CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
					
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return response;

		}
		
		
	public Response postWebServiceCall(String inputStr, String authKey, String contentType, String endPointUrl) {
		Response response = null;

		try {

			RequestSpecification requestSpecification = RestAssured.given();
			requestSpecification.header("Authorization", authKey);
			requestSpecification.headers("content-type", contentType);
			requestSpecification.body(inputStr);
			response = requestSpecification.post(endPointUrl);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}

	public String generateAuthTokenCode(String client_id, String client_secret, String grant_type, String username,
			String password, String url, String contentType) throws Exception {

		String accessToken = "";
		try {
			RestAssured.useRelaxedHTTPSValidation();
			RequestSpecification requestSpecification = RestAssured.given()
					// .auth().basic(username, password)
					.header("Content-Type", contentType).formParam("client_id", client_id)
					.formParam("client_secret", client_secret).formParam("grant_type", grant_type)
					.formParam("username", username).formParam("password", password);
			Response response = requestSpecification.post(url);

			accessToken = response.path("access_token");

		} catch (RuntimeException ex) {
			throw ex;
		}
		return accessToken;

	}
	
	public String getUpdateInputAsString(String path) {
		String inputStr="";
		try {
			File directory = new File("@/");
			String strDirectoryPath =directory.getAbsolutePath().split("\\@") [0];
			String strDestinationPath=DeviceManager.instance().getConfigurationProperties().getProperty("payLoad.path"); 
			String payLoadPath = strDirectoryPath + strDestinationPath + path;
			inputStr = new String(Files.readAllBytes(Paths.get(payLoadPath)));
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return inputStr;
	}
	
	public String generate_RandomText(int length) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(length);
		Random random = new Random();
		for (int i = 0; i < length; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		System.out.println(output);
		return output;
	}
	public void verifySubmissionStatus(String expectedResult, String pageName) {
		long startTime = System.currentTimeMillis();
		String status = getWebDriver().findElement(By.xpath("//eve-submission-step/div[1]/div[2]/div[1]/div/p[2]/b")).getText();
		if(status.contains(expectedResult)) {
			CustomReporting.logReport("", "",
					"Submission status "+ status +" is as expected on page" + pageName,
					StepStatus.SUCCESS, new String[] {}, startTime);
		}else {
			CustomReporting.logReport("", "",
					"Submission status "+ status +" is not as expected on page " + pageName,
					StepStatus.FAILURE, new String[] {}, startTime);
		}
		
	}
	
	
	public Response customWebServiceCall(String inputStr, String authKey, String contentType, String endPointUrl) 
 			throws Exception{
 		Response response=null;
 		long startTime = System.currentTimeMillis();
 		
 		try {
 			RestAssured.useRelaxedHTTPSValidation();
 			RequestSpecification requestSpecification = RestAssured.given();
 			requestSpecification.header("Authorization", authKey);
 			requestSpecification.headers("content-type", contentType);
 			requestSpecification.body(inputStr);
 			response = requestSpecification.post(endPointUrl);
 			//CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
 		}catch(Exception ex) {
 			//ex.printStackTrace();
 			CustomReporting.logReport("","", "Error occurred while retrieving TestRun id from qTest", "", StepStatus.FAILURE,
 					new String[] { }, startTime, ex);
 		}
 		return response;

 	}
	

public static Response customWebServiceCall(String authKey, String contentType, String endPointUrl) 
                     throws Exception{
              Response response=null;
              long startTime = System.currentTimeMillis();
              
              try {
                     RestAssured.useRelaxedHTTPSValidation();
                     RequestSpecification requestSpecification = RestAssured.given();
                     requestSpecification.header("Authorization", authKey);
                     requestSpecification.headers("content-type", contentType);
                     response = requestSpecification.get(endPointUrl);
              }catch(Exception ex) {
                     
                     System.out.println("Response retrieved is null");
                     System.out.println("Error occurred while retrieving the response:  " +
                              "\n Error Description: " + ex.toString());
              }
              return response;

       }

	
	
	public void focusBrowser() throws Exception {

		try {

			// String
			// strDeviceName=GenericFunctions.instance()._getGlobalVariableValue("deviceName");

			File directory = new File("@/");
			System.out.println(directory.getAbsolutePath());
			String strDirectoryPath = directory.getAbsolutePath().split("\\@")[0];
			String strBundlePath = strDirectoryPath + "resources\\Images";
			ImagePath.setBundlePath(strBundlePath);
			Screen screen = new Screen();
			Pattern img_Desktop = new Pattern("Desktop.PNG");
			Robot robot = new Robot();

			try {
				screen.find(img_Desktop);
				robot.keyPress(KeyEvent.VK_ALT);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_ALT);
				robot.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				CustomReporting.logReport("Browser brought to the foreground");
			} catch (Exception ex) {

			}

		}

		finally {

		}
	}
	
	public LinkedHashMap<Integer, String[]> getDataFromDB(String strQuery, int intColumnSize, String databaseName, String sqlServer) 
			throws ClassNotFoundException, SQLException {
		ResultSet res = null;
		Connection con = null;
		LinkedHashMap<Integer, String[]> queryData =new LinkedHashMap<Integer, String[]>();

		try {
			String dburl = "jdbc:sqlserver://"+sqlServer+";databaseName="+databaseName+";integratedSecurity=true";
			/*String dbDetailsQADev = "enicdb-dev\\enic_qa;databaseName="+databaseName+";";
			String dbDetailsStage = "enicdb-stage;databaseName="+databaseName+";";

			if(environment.equalsIgnoreCase("STAGE")) {
				dburl = "jdbc:sqlserver://"+dbDetailsStage+"integratedSecurity=true";
			}
			else {
				dburl = "jdbc:sqlserver://"+dbDetailsQADev+"integratedSecurity=true";
			}*/
			
			String dbUserName = "";
			String dbPassword = "";
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con =  DriverManager.getConnection(dburl, dbUserName, dbPassword);
			
			System.out.println(con + "connected..con");
			Statement stmt =  con.createStatement();
			res = stmt.executeQuery(strQuery);
			
			int j=0;
			while (res.next()) 
			{
				String[] strFieldValues=new String[intColumnSize];
					
				System.out.println("\n Printing data for record: "+j);
				for(int i=1;i<=intColumnSize;i++) {
					strFieldValues[i-1]=res.getString(i);
					System.out.println(strFieldValues[i-1]);
					
				}
				queryData.put(j, strFieldValues);
				j++;

			}


		} catch (Exception e) {
			CustomReporting.logReport(e);
			e.printStackTrace();
		} finally {

			if (con != null) {
				con.close();
			}
		}
		return queryData;
	}
	
	/*==============POST WebService Call===================== */
	/*public Response webServiceCall(String path, String authKey, String contentType, String endPointUrl) 
			throws Exception{
		Response response=null;
		String content;
		
		try {
			File directory = new File("@/");
			String strDirectoryPath =directory.getAbsolutePath().split("\\@") [0];
			String strDestinationPath=DeviceManager.instance().getConfigurationProperties().getProperty("payLoad.path"); 
			String payLoadPath = strDirectoryPath + strDestinationPath + path;
			content = new String(Files.readAllBytes(Paths.get(payLoadPath)));
			RestAssured.useRelaxedHTTPSValidation();
			RequestSpecification requestSpecification = RestAssured.given();
			requestSpecification.header("Authorization", authKey);
			requestSpecification.headers("content-type", contentType);
			requestSpecification.body(content);
			response = requestSpecification.post(endPointUrl);
			CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}*/
	/*public Response customWebServiceCall(String inputStr, String authKey, String contentType, String endPointUrl) 
			throws Exception{
		Response response=null;
		
		
		try {
			RestAssured.useRelaxedHTTPSValidation();
			RequestSpecification requestSpecification = RestAssured.given();
			requestSpecification.header("Authorization", authKey);
			requestSpecification.headers("content-type", contentType);
			requestSpecification.body(inputStr);
			response = requestSpecification.post(endPointUrl);
			CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}*/
	
	public Response customWebServiceCall(String inputStr, String authKey, String contentType, String endPointUrl,String IBMAPIClientID,String IBMAPIClientSecret,String Header) 
			throws Exception{
		Response response=null;
		
		
		try {
			RestAssured.useRelaxedHTTPSValidation();
			RequestSpecification requestSpecification = RestAssured.given();
			requestSpecification.header("Authorization", authKey);
			requestSpecification.headers("content-type", contentType);
			requestSpecification.headers("X-IBM-Client-Id", IBMAPIClientID);
			requestSpecification.headers("X-IBM-Client-Secret", IBMAPIClientSecret);
			requestSpecification.body(inputStr);
			response = requestSpecification.post(endPointUrl);
			CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}
	public Response customWebServiceCall(String inputStr, String authKey, String contentType, String endPointUrl, String queryValue) 
			throws Exception{
		Response response=null;
		
		
		try {
			RestAssured.useRelaxedHTTPSValidation();
			RequestSpecification requestSpecification = RestAssured.given();
			requestSpecification.header("Authorization", authKey);
			requestSpecification.headers("content-type", contentType);
			requestSpecification.body(inputStr);
			response = requestSpecification.post(endPointUrl+queryValue);
			CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}
	
	public Response customWebServiceCall(String inputStr, String authKey, String contentType, String endPointUrl, String queryValue,String IBMAPIClientID, String IBMAPIClienSecret,String Header) 
			throws Exception{
		Response response=null;
		
		
		try {
			RestAssured.useRelaxedHTTPSValidation();
			RequestSpecification requestSpecification = RestAssured.given();
			requestSpecification.header("Authorization", authKey);
			requestSpecification.headers("content-type", contentType);
			requestSpecification.headers("X-IBM-Client-Id", IBMAPIClientID);
			requestSpecification.headers("X-IBM-Client-Secret", IBMAPIClienSecret);
			requestSpecification.body(inputStr);
			response = requestSpecification.post(endPointUrl+queryValue);
			CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}

	public Response customWebServiceCall(String inputStr, String authKey, String contentType, String endPointUrl,
			String queryParameter, String value) throws Exception {
		Response response = null;
		String content;

		try {
			RestAssured.useRelaxedHTTPSValidation();
			RequestSpecification requestSpecification = RestAssured.given();
			requestSpecification.header("Authorization", authKey);
			requestSpecification.headers("content-type", contentType);
			requestSpecification.body(inputStr);
			response = requestSpecification.parameters(queryParameter, value).put(endPointUrl);
			CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}
	
	
	
	
	
	public Response webServiceCall(String path, String authKey, String contentType, String endPointUrl,boolean updateFlag,String pKey, String cKey, String toUpdateKey, String toUpdateValue) throws Exception{
		Response response=null;
		String content;
		
		try {
			File directory = new File("@/");
			String strDirectoryPath =directory.getAbsolutePath().split("\\@") [0];
			String strDestinationPath=DeviceManager.instance().getConfigurationProperties().getProperty("payLoad.path"); 
			String payLoadPath = strDirectoryPath + strDestinationPath + path;
			content = new String(Files.readAllBytes(Paths.get(payLoadPath)));
			if(updateFlag) {
				String updatedContent = updateInputRequest(content, pKey, cKey, toUpdateKey, toUpdateValue);
				RestAssured.useRelaxedHTTPSValidation();
				RequestSpecification requestSpecification = RestAssured.given();
				requestSpecification.header("Authorization", authKey);
				requestSpecification.headers("content-type", contentType);
				requestSpecification.body(updatedContent);
				response = requestSpecification.post(endPointUrl);
				CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
			}else {
				RestAssured.useRelaxedHTTPSValidation();
			RequestSpecification requestSpecification = RestAssured.given();
			requestSpecification.header("Authorization", authKey);
			requestSpecification.headers("content-type", contentType);
			requestSpecification.body(content);
			response = requestSpecification.post(endPointUrl);
			CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}
	/*==============GET/PUT WebService Call===================== */
	public Response webServiceCall(String path, String authKey, String contentType, String endPointUrl,
			String queryParameter, String value, String action) {
		Response response=null;
		String content;
		try {
			if (action.equalsIgnoreCase("put")) {
				File directory = new File("@/");
				String strDirectoryPath =directory.getAbsolutePath().split("\\@") [0];
				String strDestinationPath=DeviceManager.instance().getConfigurationProperties().getProperty("payLoad.path"); 
				String payLoadPath = strDirectoryPath + strDestinationPath + path;
				content = new String(Files.readAllBytes(Paths.get(payLoadPath)));
				RestAssured.useRelaxedHTTPSValidation();
				RequestSpecification requestSpecification = RestAssured.given();
				requestSpecification.header("Authorization", authKey);
				requestSpecification.headers("content-type", contentType);
				requestSpecification.body(content);
			 response = requestSpecification.parameters(queryParameter, value).put(endPointUrl);
			 CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
			
			} else if (action.equalsIgnoreCase("get")) {
				RestAssured.useRelaxedHTTPSValidation();
				RequestSpecification requestSpecification = RestAssured.given();
				requestSpecification.header("Authorization", authKey);
				requestSpecification.headers("content-type", contentType);
				response = requestSpecification.parameters(queryParameter, value).get(endPointUrl);
				CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}
	
	//two values
	public Response webServiceCall_1(String path, String authKey, String contentType, String endPointUrl,
			String queryParameter,String queryParameter1,String value, String value1, String action) {
		Response response=null;
		String content;
		try {
			if (action.equalsIgnoreCase("put")) {
				File directory = new File("@/");
				String strDirectoryPath =directory.getAbsolutePath().split("\\@") [0];
				String strDestinationPath=DeviceManager.instance().getConfigurationProperties().getProperty("payLoad.path"); 
				String payLoadPath = strDirectoryPath + strDestinationPath + path;
				content = new String(Files.readAllBytes(Paths.get(payLoadPath)));
				RestAssured.useRelaxedHTTPSValidation();
				RequestSpecification requestSpecification = RestAssured.given();
				requestSpecification.header("Authorization", authKey);
				requestSpecification.headers("content-type", contentType);
				requestSpecification.body(content);
			 response = requestSpecification.parameters(queryParameter, value).parameters(queryParameter1, value1).put(endPointUrl);
			 CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
			
			} else if (action.equalsIgnoreCase("get")) {
				RestAssured.useRelaxedHTTPSValidation();
				RequestSpecification requestSpecification = RestAssured.given();
				requestSpecification.header("Authorization", authKey);
				requestSpecification.headers("content-type", contentType);
				response = requestSpecification.parameters(queryParameter, value).get(endPointUrl);
				CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}
	//
	public Response webServiceCall(String path, String authKey, String contentType, String endPointUrl,
			String queryParameter, String value, boolean updateFlag,String pKey, String cKey, String toUpdateKey, String toUpdateValue) {
		Response response=null;
		String content;
		String updatedContent="";
		try {
			
				File directory = new File("@/");
				String strDirectoryPath =directory.getAbsolutePath().split("\\@") [0];
				String strDestinationPath=DeviceManager.instance().getConfigurationProperties().getProperty("payLoad.path"); 
				String payLoadPath = strDirectoryPath + strDestinationPath + path;
				content = new String(Files.readAllBytes(Paths.get(payLoadPath)));
				if(updateFlag) {
					updatedContent = updateInputRequest(content, pKey, cKey, toUpdateKey, toUpdateValue);
					RestAssured.useRelaxedHTTPSValidation();
					RequestSpecification requestSpecification = RestAssured.given();
					requestSpecification.header("Authorization", authKey);
					requestSpecification.headers("content-type", contentType);
					requestSpecification.body(updatedContent);
				 response = requestSpecification.parameters(queryParameter, value).put(endPointUrl);
				 CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
				}else {
					RestAssured.useRelaxedHTTPSValidation();
				RequestSpecification requestSpecification = RestAssured.given();
				requestSpecification.header("Authorization", authKey);
				requestSpecification.headers("content-type", contentType);
				requestSpecification.body(content);
			 response = requestSpecification.parameters(queryParameter, value).put(endPointUrl);
			 CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
				}
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}
	
	
	public String updateInputRequest(String content, String parentKey, String childKey, String toUpdateKey,
			String toUpdateValue) {
		String formattedJson = "";
		try {
			
			System.out.println(content);
			JSONObject object = new JSONObject(content);
			if(!childKey.equals("")) {
			@SuppressWarnings("unused")
			JSONObject submissionObject = object.getJSONObject(parentKey).getJSONObject(childKey).put(toUpdateKey,
					toUpdateValue);
			System.out.println(submissionObject.toString());
			formattedJson = JsonFormatter.prettyPrint(object.toString());
			System.out.println(formattedJson);
			}else {
				@SuppressWarnings("unused")
				JSONObject submissionObject = object.getJSONObject(parentKey).put(toUpdateKey,toUpdateValue);
				formattedJson = JsonFormatter.prettyPrint(object.toString());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return formattedJson;

	}

	
	public Response webServiceCall(String inputStr, String authKey, String contentType, String endPointUrl, 
			String value, String action) {
		Response response=null;
		
		try {
			if (action.equalsIgnoreCase("put")) {
				RestAssured.useRelaxedHTTPSValidation();
				RequestSpecification requestSpecification = RestAssured.given();
				requestSpecification.header("Authorization", authKey);
				requestSpecification.headers("content-type", contentType);
				requestSpecification.body(inputStr);
				response = requestSpecification.put(endPointUrl+value);
				CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
			
			} 
			else if (action.equalsIgnoreCase("get")) {
				RestAssured.useRelaxedHTTPSValidation();
				RequestSpecification requestSpecification = RestAssured.given();
				requestSpecification.header("Authorization", authKey);
				requestSpecification.headers("content-type", contentType);
				response = requestSpecification.get(endPointUrl+value);
				CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}
	/*===============fetch value from Response==================*/
	public String getKeyValue(Response res, String key) throws Exception {
		try {
			String value = null;
			if (!key.equalsIgnoreCase("null")) {
				value = res.path(key).toString();
			}
			return value;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public String getKeyValueFromPayLoad(String jsonFileName, String pKey, String cKey) throws Exception {
		try {
			String payloadValue = null;
			File directory = new File("@/");
			String strDirectoryPath = directory.getAbsolutePath().split("\\@")[0];
			String strDestinationPath = DeviceManager.instance().getConfigurationProperties()
					.getProperty("payLoad.path");
			String payLoadPath = strDirectoryPath + strDestinationPath + jsonFileName;
			String content = new String(Files.readAllBytes(Paths.get(payLoadPath)));
			JSONObject inputObj = new JSONObject(content);
			payloadValue = inputObj.getJSONObject(pKey).getString(cKey);
			return payloadValue;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public String getKeyValueFromInputStr(String inputStr, String pKey, String cKey) throws Exception {
		try {
			String payloadValue = null;
			
			
			JSONObject inputObj = new JSONObject(inputStr);
			payloadValue = inputObj.getJSONObject(pKey).getString(cKey);
			
			return payloadValue;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public String getKeyValueFromInputStr(String inputStr, String pKey, String cKey, String key) throws Exception {
		try {
			String payloadValue = null;
			
			
			JSONObject inputObj = new JSONObject(inputStr);
			if(!cKey.equals("")) {
			payloadValue = inputObj.getJSONObject(pKey).getJSONObject(cKey).getString(key);
			}else {
				payloadValue = inputObj.getJSONObject(pKey).getString(key);
			}
			return payloadValue;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public Map<String, String> getListOfKeyValue(String res, String parentkey) throws Exception {
		try {
			String value = null;

			JSONObject responseObj = new JSONObject(res);
			JSONObject subObj = responseObj.getJSONObject(parentkey);
			Map<String, String> mapList = new LinkedHashMap<String, String>();
			Iterator<?> keys = subObj.keys();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				
				value = subObj.get(key).toString();
				
				mapList.put(key, value);
			}

			return mapList;
		} catch (Exception ex) {
			throw ex;
		}
	}
	public Map<String, String> getListOfKeyValue(String res, String parentkey, String childKey) throws Exception {
		try {
			String value = null;

			JSONObject responseObj = new JSONObject(res);
			JSONObject subObj = responseObj.getJSONObject(parentkey).getJSONObject(childKey);
			Map<String, String> mapList = new LinkedHashMap<String, String>();
			Iterator<?> keys = subObj.keys();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				value = subObj.get(key).toString();
				mapList.put(key, value);
			}

			return mapList;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public Map<String, String> getListOfKeyValue(JSONObject obj) throws Exception {
		try {
			String value = null;

			
			Map<String, String> mapList = new LinkedHashMap<String, String>();
			Iterator<?> keys = obj.keys();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				value = obj.get(key).toString();
				mapList.put(key, value);
			}

			return mapList;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public Map<String, String> getListOfKeyValueFromPayLoad(String jsonFileName, String parentkey, String childkey)
			throws Exception {
		try {
			String value = null;
//			File directory = new File("@/");
//			String strDirectoryPath = directory.getAbsolutePath().split("\\@")[0];
//			String strDestinationPath = DeviceManager.instance().getConfigurationProperties()
//				.getProperty("payLoad.path");
//			String payLoadPath = strDirectoryPath + strDestinationPath + jsonFileName;
//			String content = new String(Files.readAllBytes(Paths.get(payLoadPath)));
			JSONObject responseObj = new JSONObject(jsonFileName);
			JSONObject subObj = responseObj.getJSONObject(parentkey).getJSONObject(childkey);
			Map<String, String> mapList = new LinkedHashMap<String, String>();
			Iterator<?> keys = subObj.keys();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				value = subObj.get(key).toString();
				mapList.put(key, value);
			}
			return mapList;
		} catch (Exception ex) {
			throw ex;
		}

	}
	
	public Map<String, String> getListOfKeyValueFromRequestPL(String jsonFileName, String parentkey, String childkey1,String childkey2)
			throws Exception {
		try {
			String value = null;
			JSONObject responseObj = new JSONObject(jsonFileName);
			JSONObject subObj = responseObj.getJSONObject(parentkey).getJSONObject(childkey1).getJSONArray(childkey2).getJSONObject(0);
			Map<String, String> mapList = new LinkedHashMap<String, String>();
			Iterator<?> keys = subObj.keys();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				value = subObj.get(key).toString();
				mapList.put(key, value);
			}
			return mapList;
		} catch (Exception ex) {
			throw ex;
		}

	}
	
	public Map<String, String> getListOfKeyValueFromInputString(String inputStr, String parentkey, String childkey)
			throws Exception {
		try {
			String value = null;
			JSONObject responseObj = new JSONObject(inputStr);
			JSONObject subObj = responseObj.getJSONObject(parentkey).getJSONObject(childkey);
			Map<String, String> mapList = new LinkedHashMap<String, String>();
			Iterator<?> keys = subObj.keys();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				value = subObj.get(key).toString();
				mapList.put(key, value);
			}
			return mapList;
		} catch (Exception ex) {
			throw ex;
		}

	}
	/*=============COMPLEX JSONARRAY PARSING==================*/
	public List<String> jsonArrayParsing(String jsonFileName, String parentKey, String key) throws Exception {
		try {
			File directory = new File("@/");
			String strDirectoryPath = directory.getAbsolutePath().split("\\@")[0];
			String strDestinationPath = DeviceManager.instance().getConfigurationProperties()
					.getProperty("payLoad.path");
			String payLoadPath = strDirectoryPath + strDestinationPath + jsonFileName;
			String content = new String(Files.readAllBytes(Paths.get(payLoadPath)));

			JSONObject object = new JSONObject(content);
			JSONArray jsonArray = object.getJSONObject(parentKey).getJSONArray(key);
			List<String> details = new ArrayList<String>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonSubStr = jsonArray.getJSONObject(i);
				Iterator<?> keysSub = jsonSubStr.keys();
				String subKey = null;
				String subValue = null;
				while (keysSub.hasNext()) {
					subKey = (String) keysSub.next();
					subValue = (String) jsonSubStr.get(subKey).toString();
					details.add(subValue);
				}
			}
			return (details);
		} catch (JSONException ex) {
			throw ex;

		}
	}
	
	public List<String> listOfAllValues(String jsonFileName, String parentKey, String key) throws Exception {
		
		try {
			File directory = new File("@/");
			String strDirectoryPath = directory.getAbsolutePath().split("\\@")[0];
			String strDestinationPath = DeviceManager.instance().getConfigurationProperties()
					.getProperty("payLoad.path");
			String payLoadPath = strDirectoryPath + strDestinationPath + jsonFileName;
			String content = new String(Files.readAllBytes(Paths.get(payLoadPath)));
			JsonPath jsonPath = new JsonPath(content).setRoot(parentKey);
			List<String> strList = jsonPath.get(key);
			return (strList);
		} catch (JSONException ex) {
			throw ex;

		}
		
	}
	
	public List<String> listOfAllValuesFromInputString(String inputStr, String parentKey, String key) throws Exception {

		try {

			JsonPath jsonPath = new JsonPath(inputStr).setRoot(parentKey);
			List<String> strList = jsonPath.get(key);
			return (strList);
		} catch (JSONException ex) {
			throw ex;

		}

	}

	public List<String> jsonArrayParsingFromResponse(String responseObject, String key) throws Exception {
		try {
			JSONObject object = new JSONObject(responseObject);
			JSONArray jsonArray = object.getJSONArray(key);
			List<String> details = new ArrayList<String>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonSubStr = jsonArray.getJSONObject(i);
				Iterator<?> keysSub = jsonSubStr.keys();
				String subKey = null;
				String subValue = null;
				while (keysSub.hasNext()) {
					subKey = (String) keysSub.next();
					subValue = (String) jsonSubStr.get(subKey).toString();
					details.add(subValue);
				}

			}
			return (details);
		} catch (JSONException ex) {
			throw ex;

		}
	}
	
	public List<String> jsonArrayParsingFromResponse(String responseObject, String parentKey, String key) throws Exception {
		try {
			JSONObject object = new JSONObject(responseObject);
			JSONArray jsonArray = object.getJSONObject(parentKey).getJSONArray(key);
			List<String> details = new ArrayList<String>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonSubStr = jsonArray.getJSONObject(i);
				Iterator<?> keysSub = jsonSubStr.keys();
				String subKey = null;
				String subValue = null;
				while (keysSub.hasNext()) {
					subKey = (String) keysSub.next();
					subValue = (String) jsonSubStr.get(subKey).toString();
					details.add(subValue);
				}

			}
			return (details);
		} catch (JSONException ex) {
			throw ex;

		}
	}
	//updating value in payload
	public void updateValueToPayloadJSON(String path, String parentKey,String toUpdateKey, String toUpdateValue)
			throws Exception {
		try {

			File directory = new File("@/");
			String strDirectoryPath = directory.getAbsolutePath().split("\\@")[0];
			String strDestinationPath = DeviceManager.instance().getConfigurationProperties()
					.getProperty("payLoad.path");
			String payLoadPath = strDirectoryPath + strDestinationPath + path;
			String content = new String(Files.readAllBytes(Paths.get(payLoadPath)));
			JSONObject object = new JSONObject(content);
			
			JSONObject submissionObject = object.getJSONObject(parentKey).put(toUpdateKey, toUpdateValue);
			
			PrintWriter writer = new PrintWriter(payLoadPath);
			String formattedJson = JsonFormatter.prettyPrint(object.toString());

			writer.print(formattedJson);
			writer.close();

		} catch (JSONException ex) {
			throw ex;

		}
	}
	public void updateValueToPayloadJSON(String path, String parentKey,String childKey,String toUpdateKey, String toUpdateValue)
			throws Exception {
		try {

			File directory = new File("@/");
			String strDirectoryPath = directory.getAbsolutePath().split("\\@")[0];
			String strDestinationPath = DeviceManager.instance().getConfigurationProperties()
					.getProperty("payLoad.path");
			String payLoadPath = strDirectoryPath + strDestinationPath + path;
			String content = new String(Files.readAllBytes(Paths.get(payLoadPath)));
			JSONObject object = new JSONObject(content);
			
			JSONObject submissionObject = object.getJSONObject(parentKey).getJSONObject(childKey).put(toUpdateKey, toUpdateValue);
			
			PrintWriter writer = new PrintWriter(payLoadPath);
			String formattedJson = JsonFormatter.prettyPrint(object.toString());

			writer.print(formattedJson);
			writer.close();

		} catch (JSONException ex) {
			throw ex;

		}
	}
	
	public void updateArrayValueToPayloadJSON(String path, String parentKey,String childKey,String toUpdateKey, String toUpdateValue)
			throws Exception {
		try {

			File directory = new File("@/");
			String strDirectoryPath = directory.getAbsolutePath().split("\\@")[0];
			String strDestinationPath = DeviceManager.instance().getConfigurationProperties()
					.getProperty("payLoad.path");
			String payLoadPath = strDirectoryPath + strDestinationPath + path;
			String content = new String(Files.readAllBytes(Paths.get(payLoadPath)));
			JSONObject object = new JSONObject(content);
			
			JSONArray submissionArr = object.getJSONObject(parentKey).getJSONArray(childKey);
			for (int i=0; i < submissionArr.length(); i++){
			    JSONObject itemArr = (JSONObject)submissionArr.get(i);
			    itemArr.put(toUpdateKey, toUpdateValue);
			}
			
			PrintWriter writer = new PrintWriter(payLoadPath);
			String formattedJson = JsonFormatter.prettyPrint(object.toString());
			System.out.println(formattedJson);
			writer.print(formattedJson);
			writer.close();

		} catch (JSONException ex) {
			throw ex;

		}
	}
	
	public String updateArrayValueToInputStr(String inputStr, String parentKey,String childKey,String toUpdateKey, String toUpdateValue)
			throws Exception {
		String formattedJson="";
		try {

			
			JSONObject object = new JSONObject(inputStr);
			
			JSONArray submissionArr = object.getJSONObject(parentKey).getJSONArray(childKey);
			for (int i=0; i < submissionArr.length(); i++){
			    JSONObject itemArr = (JSONObject)submissionArr.get(i);
			    itemArr.put(toUpdateKey, toUpdateValue);
			}
			
			
			formattedJson = JsonFormatter.prettyPrint(object.toString());
			
			

		} catch (JSONException ex) {
			throw ex;

		}
		return formattedJson;
	}
	
	public String updateArrayValueToInputStr(String inputStr, String parentKey,String childKey1, String childKey2,String toUpdateKey, String toUpdateValue)
			throws Exception {
		String formattedJson="";
		try {

			
			JSONObject object = new JSONObject(inputStr);
			
			JSONArray submissionArr = object.getJSONObject(parentKey).getJSONArray(childKey1);
			for (int i=0; i < submissionArr.length(); i++){
			    JSONObject itemArr = (JSONObject)submissionArr.get(i);
			    itemArr.getJSONObject(childKey2).put(toUpdateKey, toUpdateValue);
			}
			
			
			formattedJson = JsonFormatter.prettyPrint(object.toString());
			
			

		} catch (JSONException ex) {
			throw ex;

		}
		return formattedJson;
	}
	public void updateArrayValueToPayloadJSON(String path, String parentKey,String childKey,JsonObject toUpdateValue)
			throws Exception {
		try {

			File directory = new File("@/");
			String strDirectoryPath = directory.getAbsolutePath().split("\\@")[0];
			String strDestinationPath = DeviceManager.instance().getConfigurationProperties()
					.getProperty("payLoad.path");
			String payLoadPath = strDirectoryPath + strDestinationPath + path;
			String content = new String(Files.readAllBytes(Paths.get(payLoadPath)));
			JSONObject object = new JSONObject(content);
			String submissionObject = object.getJSONObject(parentKey)
					.getJSONArray(childKey).put(toUpdateValue).toString().replace("\\\"", "\"");
			/*JsonParser jsonParser = new JsonParser();
			JsonArray objectFromString = jsonParser.parse(submissionObject).getAsJsonArray();*/
			/*String submissionObject = object.getJSONObject(parentKey)
					.getJSONArray(childKey).put(toUpdateValue).toString().replaceAll("\\", "");*/
			//System.out.println("inside custom" + objectFromString);
			
			PrintWriter writer = new PrintWriter(payLoadPath);
			
			String formattedJson = JsonFormatter.prettyPrint(object.toString());
			System.out.println("final json" + formattedJson);
			
			writer.print(formattedJson);
			writer.close();

		} catch (JSONException ex) {
			throw ex;

		}
	}
	
	//check all steps verification
	public boolean allStepsResult(List<Boolean> value) {
		for(boolean arr1:value) {
			if(!arr1) {
				return false;
			}
		}
		return true;
	}
	
	//Date validation
	public boolean isThisDateValid(String dateToValidate, String dateFormat) throws Exception {

		if (dateToValidate == null) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
		try {

			// if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);

		} catch (ParseException e) {

			//e.printStackTrace();
			return false;
		}

		return true;

	}
	
	
	
	
	public void createPropertyFile() throws IOException {
		
		String propPath = DeviceManager.instance().getConfigurationProperties().getProperty("property.path");
	      
	    //File directory = new File("@/");
		//String strDirectoryPath =directory.getAbsolutePath().split("\\@") [0];	  
		//propPath = strDirectoryPath + propPath;
		Properties prop = new Properties();
		//InputStream input=new FileInputStream(propPath);
		
		FileOutputStream outFile =new FileOutputStream(new File(propPath));
		prop.store(outFile, "Prop file created");
		outFile.close();
	}
	
	
	
	
	
	
	public void deletePropertyFile() throws IOException {
        
        String propPath = DeviceManager.instance().getConfigurationProperties().getProperty("property.path");
        
        //File directory = new File("@/");
        //String strDirectoryPath =directory.getAbsolutePath().split("\\@") [0];    
        //propPath = strDirectoryPath + propPath;
        
        Files.deleteIfExists(Paths.get(propPath));
        
  }

	public LinkedHashMap<Integer, String[]> getDataFromDB(String strQuery, int intColumnSize) throws ClassNotFoundException, SQLException {
		ResultSet res = null;
		Connection con = null;
		LinkedHashMap<Integer, String[]> queryData =new LinkedHashMap<Integer, String[]>();
		
		try {
			String dburl = "jdbc:sqlserver://ENDWSQLD1\\PR;databaseName=ProducerMDMDB;integratedSecurity=true";
			
	        String dbUserName = "";
	        String dbPassword = "";
	        	                        
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        con =  DriverManager.getConnection(dburl, dbUserName, dbPassword);
	       
	        System.out.println(con + "connected..con");
	        Statement stmt =  con.createStatement();
	        res = stmt.executeQuery(strQuery);
	       	         
	            int j=0;
	            while (res.next()) 
	                {
	            	String[] strFieldValues=new String[intColumnSize];

	            	System.out.println("\n Printing data for record: "+j);
	            	for(int i=1;i<=intColumnSize;i++) {
	            		strFieldValues[i-1]=res.getString(i);
	            		//System.out.println(strFieldValues[i-1]);
	            	}
	            	queryData.put(j, strFieldValues);
	            	j++;
	                  
	             }
	            	            

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				con.close();
			}
		}
		return queryData;
	}
	public LinkedHashMap<Integer, String[]> getDataFromDB1(String strQuery, int intColumnSize) throws ClassNotFoundException, SQLException {
		ResultSet res = null;
		Connection con = null;
		LinkedHashMap<Integer, String[]> queryData =new LinkedHashMap<Integer, String[]>();
		
		try {
			String dburl = "jdbc:sqlserver://ENICDB-DEV\\ENIC_QA;databaseName=MasterReferenceDataHub;integratedSecurity=true";
			
	        String dbUserName = "";
	        String dbPassword = "";
	        	                        
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        con =  DriverManager.getConnection(dburl, dbUserName, dbPassword);
	       
	        System.out.println(con + "connected..con");
	        Statement stmt =  con.createStatement();
	        res = stmt.executeQuery(strQuery);
	       	         
	            int j=0;
	            while (res.next()) 
	                {
	            	String[] strFieldValues=new String[intColumnSize];

	            	System.out.println("\n Printing data for record: "+j);
	            	for(int i=1;i<=intColumnSize;i++) {
	            		strFieldValues[i-1]=res.getString(i);
	            		//System.out.println(strFieldValues[i-1]);
	            	}
	            	queryData.put(j, strFieldValues);
	            	j++;
	                  
	             }
	            	            

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				con.close();
			}
		}
		return queryData;
	}
	public LinkedHashMap<Integer, String[]> getDataFromsqlDB(String strQuery, int intColumnSize) throws ClassNotFoundException, SQLException {
		ResultSet res = null;
		Connection con = null;
		LinkedHashMap<Integer, String[]> queryData =new LinkedHashMap<Integer, String[]>();
		
		try {
			String strSqlServerName=DeviceManager.instance().getConfigurationProperties().getProperty("sqlServername"); 
			String strDatabaseName = DeviceManager.instance().getConfigurationProperties().getProperty("DatabaseName");
			
			String dburl = "jdbc:sqlserver://"+strSqlServerName+";databaseName="+strDatabaseName+";integratedSecurity=true";
			
	        String dbUserName = "";
	        String dbPassword = "";
	        	                        
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        con =  DriverManager.getConnection(dburl, dbUserName, dbPassword);
	       
	        System.out.println(con + "connected..con");
	        Statement stmt =  con.createStatement();
	        res = stmt.executeQuery(strQuery);
	       	         
	            int j=0;
	            while (res.next()) 
	                {
	            	String[] strFieldValues=new String[intColumnSize];

	            	System.out.println("\n Printing data for record: "+j);
	            	for(int i=1;i<=intColumnSize;i++) {
	            		strFieldValues[i-1]=res.getString(i);
	            		System.out.println(strFieldValues[i-1]);
	            	}
	            	queryData.put(j, strFieldValues);
	            	j++;
	                  
	             }
	            	            

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				con.close();
			}
		}
		return queryData;
	}
	public Response putWebServiceCall(String inputStr, String authKey, String contentType, String endPointUrl) {
		Response response=null;
		
		try {
			
			
				RestAssured.useRelaxedHTTPSValidation();
				RequestSpecification requestSpecification = RestAssured.given();
				requestSpecification.header("Authorization", authKey);
				requestSpecification.headers("content-type", contentType);
				requestSpecification.body(inputStr);
				response = requestSpecification.put(endPointUrl);
				CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
				
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}
	
	public Response getWebServiceCall(String authKey, String contentType, String endPointUrl) {
		Response response=null;
	
		try {
			
			
				RestAssured.useRelaxedHTTPSValidation();
				RequestSpecification requestSpecification = RestAssured.given();
				requestSpecification.header("Authorization", authKey);
				requestSpecification.headers("content-type", contentType);
				response = requestSpecification.get(endPointUrl);
				CustomReporting.logReport( endPointUrl + " Response time " + response.getTime() + " ms");
				
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}
	
	public Map<String, String> getListOfKeyValueFromInputString(String inputStr, String parentkey)
			throws Exception {
		try {
			String value = null;
			JSONObject responseObj = new JSONObject(inputStr);
			JSONObject subObj = responseObj.getJSONObject(parentkey);
			Map<String, String> mapList = new LinkedHashMap<String, String>();
			Iterator<?> keys = subObj.keys();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				value = subObj.get(key).toString();
				mapList.put(key, value);
			}
			return mapList;
		} catch (Exception ex) {
			throw ex;
		}

	}
	
	public Response deleteWebServiceCall(String authKey, String contentType, String endPointUrl, 
			String value) {
		Response response=null;
		
		try {
				RestAssured.useRelaxedHTTPSValidation();
				RequestSpecification requestSpecification = RestAssured.given();
				requestSpecification.header("Authorization", authKey);
				requestSpecification.headers("content-type", contentType);
				response = requestSpecification.delete(endPointUrl+value);
				CustomReporting.logReport( endPointUrl+value + " Response time " + response.getTime() + " ms");
				
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;

	}
	
	
	
	public static SOAPMessage callSoapWebService(String soapEndpointUrl, String soapAction, String filename) {

        SOAPMessage soapResponse=null;
        long startTime = System.currentTimeMillis();
        
		try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            CustomReporting.logReport("", "", "Soap Service End Point URL: "
					+ soapEndpointUrl , StepStatus.SUCCESS, new String[] {}, startTime);
            
            SOAPMessage message = MessageFactory.newInstance().createMessage();
    		SOAPPart soapPart = message.getSOAPPart();
    		File directory = new File("./");
			String strDirectoryPath =directory.getAbsolutePath().split("\\.") [0];
			String strDestinationPath=DeviceManager.instance().getConfigurationProperties().getProperty("payLoad.path"); 
			String payLoadPath = strDirectoryPath + strDestinationPath + filename;
    		soapPart.setContent(new StreamSource(new FileInputStream(payLoadPath)));
    		MimeHeaders headers = message.getMimeHeaders();
            headers.addHeader("SOAPAction", soapAction);
            

            message.saveChanges();
            
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            message.writeTo(out);
   	     	String strMessage = new String(out.toByteArray());
   	     	System.out.println(strMessage);
   	     
            soapResponse = soapConnection.call(message, soapEndpointUrl);
                                
            soapConnection.close();
            
        } catch (Exception e) {
        	CustomReporting.logReport("", "", "Error occurred: ", "", StepStatus.FAILURE,
					new String[] {}, startTime, e);
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
		
        return soapResponse;
        
    }
	
	public static void parseXMLnUpdateTextValue(String strXMLName, String strTagName, String strVal)  {
        
        
        try {
              File directory = new File("./");
              String strDirectoryPath =directory.getAbsolutePath().split("\\.") [0];
              String strDestinationPath=DeviceManager.instance().getConfigurationProperties().getProperty("payLoad.path"); 
              String payLoadPath = strDirectoryPath + strDestinationPath + strXMLName;
              File strXML = new File(payLoadPath);
              DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
              DocumentBuilder builder = factory.newDocumentBuilder();
              Document doc = builder.parse(strXML);
              System.out.println(strXML);
              
              if (strTagName.equalsIgnoreCase("StateCode")) {
              doc.getElementsByTagName("soapenv:Body").item(0).getChildNodes().item(1).getChildNodes().item(5).setTextContent(strVal);
              }
              else if(strTagName.equalsIgnoreCase("LegalDescription")) {
              doc.getElementsByTagName("soapenv:Body").item(0).getChildNodes().item(1).getChildNodes().item(9).setTextContent(strVal);
              }
              else if(strTagName.equalsIgnoreCase("EffectiveDate")) {
                  doc.getElementsByTagName("soapenv:Body").item(0).getChildNodes().item(1).getChildNodes().item(1).setTextContent(strVal);
                  }
              // write the content into xml file
              TransformerFactory transformerFactory = TransformerFactory.newInstance();
              Transformer transformer = transformerFactory.newTransformer();
              DOMSource source = new DOMSource(doc);
              StreamResult result = new StreamResult(new File(payLoadPath));
              transformer.transform(source, result);

              System.out.println("Done");
                                            
                          
        }
        catch(Exception ex) {
              System.out.println(ex);
        }
        
        
}
	
	
	
	public LinkedHashMap<Integer, String[]> getDataFromsqlDB(String strSqlServerName, String strDatabaseName,
			String strQuery, int intColumnSize) throws ClassNotFoundException, SQLException {
		ResultSet res = null;
		Connection con = null;
		LinkedHashMap<Integer, String[]> queryData = new LinkedHashMap<Integer, String[]>();

		try {

			String dburl = "jdbc:sqlserver://" + strSqlServerName + ";databaseName=" + strDatabaseName
					+ ";integratedSecurity=true";

			String dbUserName = "";
			String dbPassword = "";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(dburl, dbUserName, dbPassword);

			System.out.println(con + "connected..con");
			Statement stmt = con.createStatement();
			res = stmt.executeQuery(strQuery);

			int j = 0;
			while (res.next()) {
				String[] strFieldValues = new String[intColumnSize];

				System.out.println("\n Printing data for record: " + j);
				for (int i = 1; i <= intColumnSize; i++) {
					strFieldValues[i - 1] = res.getString(i);
					System.out.println(strFieldValues[i - 1]);
				}
				queryData.put(j, strFieldValues);
				j++;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (con != null) {
				con.close();
			}
		}
		return queryData;
	}




	
	
}
