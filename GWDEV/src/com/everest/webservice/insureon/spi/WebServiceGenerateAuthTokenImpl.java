package com.everest.webservice.insureon.spi;

import org.testng.asserts.SoftAssert;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.GenericFunctions;
import com.everest.utility.CustomAbstractPage;
import com.everest.webservice.insureon.WebServiceGenerateAuthToken;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class WebServiceGenerateAuthTokenImpl extends CustomAbstractPage implements WebServiceGenerateAuthToken{
	
	PageData data;
	
	@Override
	public String generateAuthTokenCode(String tcID, SoftAssert softAssert) throws Exception {
		long startTime = System.currentTimeMillis();
		String accessToken = "";

		String username=""; 
		String password="";
		String url="";
		try {

			
			PageData EnvironmentData = PageDataManager.instance().getPageData("Config", tcID);
			
			
			String env= GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV");                  
            if (!env.isEmpty()) {
                  if (env.equalsIgnoreCase("DEV")) {
                	   data = PageDataManager.instance().getPageData("GenerateAuthKey", tcID);
                	   username = data.getData("DevUserName");
           			    password = data.getData("DevPassword");
           			 url =data.getData("DevEndPointUr");
                  } else {
                	  if(env.equalsIgnoreCase("QA")) {
                		   data = PageDataManager.instance().getPageData("GenerateAuthKey", tcID);
                		   
                		   username = data.getData("QAUserName");
               			   password = data.getData("QAPassword");
               			url =data.getData("QAEndPointUrl");
               			
                		  
                	  }else {
                		  data = PageDataManager.instance().getPageData("GenerateAuthKey", tcID); 
                		  username = data.getData("StageUserName");
              			  password = data.getData("StagePassword");
              			  url =data.getData("StageEndPointUrl");
                	  }
                  }
            }
            else {
                  if (EnvironmentData.getData("Environment").equals("DEV")) {
                	  data = PageDataManager.instance().getPageData("GenerateAuthKey", tcID);
                	   username = data.getData("DevUserName");
          			   password = data.getData("DevPassword");
          			   url =data.getData("DevEndPointUr");
                	 
                  } else {
                	  if(EnvironmentData.getData("Environment").equals("QA")) {
                		   data = PageDataManager.instance().getPageData("GenerateAuthKey", tcID);
                		   username = data.getData("QAUserName");
               			   password = data.getData("QAPassword");
               			url =data.getData("QAEndPointUrl");
                  	  }else {
                  		 data = PageDataManager.instance().getPageData("GenerateAuthKey", tcID); 
                  		username = data.getData("StageUserName");
            		    password = data.getData("StagePassword");
            		    url =data.getData("StageEndPointUrl");
                  		
                  	  }
                  }
            }
			String client_id = data.getData("client_id");
			String client_secret = data.getData("client_secret");
			String grant_type = data.getData("grant_type");
			
			
			
		
			String contentType = data.getData("contentType");
			RestAssured.useRelaxedHTTPSValidation();
			RequestSpecification requestSpecification = RestAssured.given()
					// .auth().basic(username, password)
					.header("Content-Type", contentType).formParam("client_id", client_id)
					.formParam("client_secret", client_secret).formParam("grant_type", grant_type)
					.formParam("username", username).formParam("password", password);
			Response response = requestSpecification.post(url);
			
			if (response != null) {
				int code = response.statusCode();
				String statusLine = response.statusLine();
				String resbody = response.asString();
				System.out.println(resbody);
			}

			accessToken = cFunc.getKeyValue(response, "access_token");

		} catch (RuntimeException ex) {
			throw ex;
		}
		return accessToken;

	}
	
	
	@Override
	public String generateAuthTokenCodeForUserDocumentOperation(String tcID, SoftAssert softAssert) throws Exception {
		long startTime = System.currentTimeMillis();
		String accessToken = "";
		PageData updateUserData;
		try {

			
			PageData EnvironmentData = PageDataManager.instance().getPageData("Config", tcID);
			PageData userData = PageDataManager.instance().getPageData("MultiStateData", tcID);
			
			
			String env= GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV");                  
            if (!env.isEmpty()) {
                  if (env.equalsIgnoreCase("DEV")) {
                	   data = PageDataManager.instance().getPageData("GenerateAuthKey_DEV", tcID);
                	   updateUserData = PageDataManager.instance().getPageData("GetUsers_DEV", tcID);
                  } else {
                	  if(env.equalsIgnoreCase("QA")) {
                		   data = PageDataManager.instance().getPageData("GenerateAuthKey_QA", tcID);
                		   updateUserData = PageDataManager.instance().getPageData("GetUsers_QA", tcID);
                	  }else {
                		  data = PageDataManager.instance().getPageData("GenerateAuthKey_STAGE", tcID); 
                		  updateUserData = PageDataManager.instance().getPageData("GetUsers_STAGE", tcID);
                	  }
                  }
            }
            else {
                  if (EnvironmentData.getData("Environment").equals("DEV")) {
                	  data = PageDataManager.instance().getPageData("GenerateAuthKey_DEV", tcID);
                	  updateUserData = PageDataManager.instance().getPageData("GetUsers_DEV", tcID);
                  } else {
                	  if(EnvironmentData.getData("Environment").equals("QA")) {
                		   data = PageDataManager.instance().getPageData("GenerateAuthKey_QA", tcID);
                		   updateUserData = PageDataManager.instance().getPageData("GetUsers_QA", tcID);
                  	  }else {
                  		 data = PageDataManager.instance().getPageData("GenerateAuthKey_STAGE", tcID); 
                  		updateUserData = PageDataManager.instance().getPageData("GetUsers_STAGE", tcID);
                  	  }
                  }
            }
			String client_id = data.getData("client_id");
			String client_secret = data.getData("client_secret");
			String grant_type = data.getData("grant_type");
			String url=data.getData("EndPointUrl");
			String username ="";
			String password ="";
			if(tcID.equalsIgnoreCase("DS_BOB_Agent")||tcID.equalsIgnoreCase("DS_BOB_CSREmployee")
					||tcID.equalsIgnoreCase("DS_BOB_CSR_International")
					||tcID.equalsIgnoreCase("DS_BOB_CSR_Domestic")) {
				username = updateUserData.getData("Username");
				password = data.getData("password");
			}else {
			username = userData.getData("DocUsername");
			password = data.getData("password");
			}
			String contentType = data.getData("contentType");
			RestAssured.useRelaxedHTTPSValidation();
			RequestSpecification requestSpecification = RestAssured.given()
					// .auth().basic(username, password)
					.header("Content-Type", contentType).formParam("client_id", client_id)
					.formParam("client_secret", client_secret).formParam("grant_type", grant_type)
					.formParam("username", username).formParam("password", password);
			Response response = requestSpecification.post(url);
			
			if (response != null) {
				int code = response.statusCode();
				String statusLine = response.statusLine();
				String resbody = response.asString();
				System.out.println(resbody);
			}

			accessToken = cFunc.getKeyValue(response, "access_token");

		} catch (RuntimeException ex) {
			throw ex;
		}
		return accessToken;

	}
	
	
	
}
