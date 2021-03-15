package com.everest.webservice.insureon.spi;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.functions.GenericFunctions;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;
import com.everest.utility.ExcelDataReader;
import com.everest.webservice.insureon.EscapePage;

public class EscapePageImpl extends CustomAbstractPage implements EscapePage {
	
	long startTime = System.currentTimeMillis();
	@SuppressWarnings("static-access")
	@Override
	public void verifySubmissionStatusReasonInEscape(String tcID, SoftAssert softAssert, String DeviceName,String ExpectedStatus) throws Exception {
		try {
		PageData data = PageDataManager.instance().getPageData("EscapeApplicationPage", tcID);
		PageData environmentData = PageDataManager.instance().getPageData("Config", tcID);
		
		
		
		
		String env=GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV"); 
		String a="";
		String environment = environmentData.getData("Environment");
		String[] submissionID = GenericFunctions.instance()._getGlobalVariableValue("submissionId").split("-");
		//new addition
		String SubmissionStatus = GenericFunctions.instance()._getGlobalVariableValue("SubmissionStatus");
		String CrimeRetentionValue = GenericFunctions.instance()._getGlobalVariableValue("CrimeRetentionValue");
		String underwriterName = GenericFunctions.instance()._getGlobalVariableValue("underwriterName");
		String respStateCode = GenericFunctions.instance()._getGlobalVariableValue("respStateCode");
		String respZipCode = GenericFunctions.instance()._getGlobalVariableValue("resZipCode");
		
		
		
		
		Map<String, String> stateCodeMapKeyValue= new LinkedHashMap<String, String>();
		ExcelDataReader stateCodeMap=new ExcelDataReader("./resources/TestData.xlsx");
		
	for (int j=2;j<=stateCodeMap.getLastRowNumber("StateCodeAndAbbreviations")+1;j++) {
		String stateCodeKey=stateCodeMap.getCellData("StateCodeAndAbbreviations","Abbreviation",j).toString();
		String stateCodeValue=stateCodeMap.getCellData("StateCodeAndAbbreviations","USState",j).toString();
		stateCodeMapKeyValue.put(stateCodeKey.trim(), stateCodeValue.trim());
		
	}
		                 
        
		if (!env.isEmpty()) {
            if (env.equalsIgnoreCase("DEV")) {
          	  a= "window.open('https://everestnational-d/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx','_blank');";
            } else {
          	  if(env.equalsIgnoreCase("QA")) {
          		  a= "window.open('https://everestnational-qa/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx','_blank');";
          	  }else {
          		  a= "window.open('https://everestnational-s/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE_SIT%2fDefault.aspx','_blank');";
          		 
          	  }
            }
      }
      else {
            if (environment.equals("DEV")) {
          	  a= "window.open('https://everestnational-d/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx','_blank');";
            } else {
          	  if(environment.equals("QA")) {
          		  a= "window.open('https://everestnational-qa/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx','_blank');";
            	  }else {
            		a= "window.open('https://everestnational-s/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE_SIT%2fDefault.aspx','_blank');";
            	  }
            }
      }
        
        
        if(DeviceName.equalsIgnoreCase("MicrosoftEdge")) {
       	 Robot r = new Robot();                          
            r.keyPress(KeyEvent.VK_CONTROL); 
            r.keyPress(KeyEvent.VK_T); 
            r.keyRelease(KeyEvent.VK_CONTROL); 
            r.keyRelease(KeyEvent.VK_T);
            
           Thread.sleep(5000);
       }else {
       ((JavascriptExecutor) getWebDriver()).executeScript(a);
       func._waitForPageToLoad(getWebDriver(), 120L);
       }
        Thread.sleep(5000);
		String mainWindowHandle = getWebDriver().getWindowHandles().iterator().next();
		ArrayList<String> tabs = new ArrayList<String>(getWebDriver().getWindowHandles());
		String strParentWindowID=getWebDriver().getWindowHandle();
		if (DeviceName.equalsIgnoreCase("chrome")) {
			getWebDriver().switchTo().window(tabs.get(1));
		}
		
		if (DeviceName.equalsIgnoreCase("Internet Explorer"))
		{
				//getWebDriver().switchTo().window(tabs.get(1));
			    String b=a.split(",")[0].split("\\(")[1].replace("'", "");
				func._switchWindows(getWebDriver(), "BY_WINURL", b);
		}
		
		if (DeviceName.equalsIgnoreCase("MicrosoftEdge"))
		{
			getWebDriver().switchTo().window(tabs.get(1));
	        //To navigate to new link/URL in 2nd new tab
	        
	        if (!env.isEmpty()) {
	              if (env.equalsIgnoreCase("DEV")) {
	            	  getWebDriver().get("https://everestnational-d/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx");
	            	 
	              } else {
	            	  if(env.equalsIgnoreCase("QA")) {
	            		  getWebDriver().get("https://everestnational-qa/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx");
	            		  
	            	  }else {
	            		  getWebDriver().get("https://everestnational-s/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE_SIT%2fDefault.aspx");
	            		  
	            	  }
	              }
	        }
	        else {
	              if (environment.equals("DEV")) {
	            	  getWebDriver().get("https://everestnational-d/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx");
	              } else {
	            	  if(environment.equals("QA")) {
	            		  getWebDriver().get("https://everestnational-qa/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx");
	              	  }else {
	              		 getWebDriver().get("https://everestnational-s/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE_SIT%2fDefault.aspx");
	              	  }
	              }
	        }
		
		
		}
		Thread.sleep(5000);
		if (DeviceName.equalsIgnoreCase("MicrosoftEdge"))
		{
			if (func._isVisible(getElement(lnk_EdgeCertificate)))
			{
				_click(getElement(lnk_EdgeCertificate));

			}
		}
		if (DeviceName.equalsIgnoreCase("Internet Explorer"))
		{
			if (func._isVisible(getElement(lnk_certificate)))
			{
				_click(getElement(lnk_certificate));

			}
			if(func._isVisible(getElement(lnk_Block))) {
				_click(getElement(lnk_Block));
				Thread.sleep(1000);
				_click(getElement(lnk_certificate));
			}
		}
		getWebDriver().manage().window().maximize();
		Thread.sleep(5000);
		getWebDriver().findElement(By.xpath("//*[@type='text']")).sendKeys(data.getData("ESCUserName"));
		
		Thread.sleep(1000);
		getWebDriver().findElement(By.xpath("//*[@type='password']")).sendKeys(data.getData("ESCPassword"));
		Thread.sleep(1000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		getWebDriver().findElement(By.xpath("//input[contains(@id,'LoginButton')]")).click();
		CustomReporting.instance().logReport("Sucessfully logged into Escape application");
		func._waitForPageToLoad(getWebDriver(), 200L);
		
		Thread.sleep(2000);
		
		getWebDriver().findElement(By.xpath("//a[text()='Search']")).click();
		
		Thread.sleep(2000);
		
		getWebDriver().findElement(By.xpath("//a[@class='search-choice-close']")).click();
		Thread.sleep(2000);
		System.out.println(data.getData("BussinessSegment"));
		
		getWebDriver().findElement(By.xpath("//input[@class='default']")).click();
		getWebDriver().findElement(By.xpath("//input[@class='default']")).sendKeys(data.getData("BussinessSegment"));
		getWebDriver().findElement(By.xpath("//input[@class='default']")).sendKeys((Keys.chord(Keys.ENTER)));
		Thread.sleep(5000);
    	getWebDriver().findElement(By.id("ContentPlaceHolder1_tbSubmissionNumber")).sendKeys(Keys.chord(Keys.CONTROL, "a"), submissionID[0]);
		Thread.sleep(1000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		getWebDriver().findElement(By.xpath("//input[contains(@id,'btnSearch')]")).click();
		Thread.sleep(30000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		Thread.sleep(1000);
		getWebDriver().findElement(By.xpath("//table[contains(@id,'gvSearch')]//tr[2]/td[2]/a")).click();
		func._waitForPageToLoad(getWebDriver(), 200L);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		
		String submsStatus = getWebDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlSubmissionStatus']/option[@selected='selected']")).getText();
		if(submsStatus.trim().equalsIgnoreCase(ExpectedStatus)) {
			CustomReporting.logReport("", "",
					"Submission Status  in Escape "+ submsStatus +" is as Expected value  "  + data.getData("ExpectedStatus"),
					StepStatus.SUCCESS, new String[] {}, startTime);
		}else {
			CustomReporting.logReport("", "",
					"Submission Status  in Escape "+ submsStatus +" is not as Expected value  "  + data.getData("ExpectedStatus"),
					StepStatus.FAILURE, new String[] {}, startTime);
		}
		String predominantState=getWebDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlPredominantState']/option[@selected='selected']")).getText();
		if(stateCodeMapKeyValue.get(respStateCode).equalsIgnoreCase(predominantState)) {
		
		CustomReporting.logReport("", "",
					"StateCode in response "+ respStateCode +" is updated in escape as expected "  + predominantState,
				StepStatus.SUCCESS, new String[] {}, startTime);		
	}else {			CustomReporting.logReport("", "",
					"StateCode in response "+ respStateCode +" is not updated in escape as expected "  + predominantState,
				StepStatus.FAILURE, new String[] {}, startTime);
	}
		
		String bussinessSegment=getWebDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlBusinessSegment']/option[@selected='selected']")).getText();
		
		if(bussinessSegment.equalsIgnoreCase(data.getData("BussinessSegment"))){
			
			CustomReporting.logReport("", "",
					"Business segmentin Escape "+ bussinessSegment +" is updated in  as expected "  + "",
				StepStatus.SUCCESS, new String[] {}, startTime);	
			
		}else {
			CustomReporting.logReport("", "",
					"Business segment in Escape "+ bussinessSegment +" is not updated in  as expected "  + "",
				StepStatus.FAILURE, new String[] {}, startTime);
			
		}
		
		
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		Thread.sleep(1000);
		
		getWebDriver().close();
		getWebDriver().switchTo().window(mainWindowHandle);
		
		
		}catch(RuntimeException ex) {
			func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
			CustomReporting.logReport("","", "Error occurred in Page" + getPageName(), "", StepStatus.FAILURE,
					new String[] { }, startTime, null);
			throw ex;
		}

	}
	
	
	@SuppressWarnings("static-access")
	@Override
	public void verifyAccountDetailsInEscape(String tcID, SoftAssert softAssert, String DeviceName, String ExpectedSubStstus, List<Boolean> list) throws Exception {
        try {
              PageData data = PageDataManager.instance().getPageData("EscapeApplicationPage", tcID);
              PageData environmentData = PageDataManager.instance().getPageData("Config", tcID);
              
            	  String strScreenShots = data.getData("PrintScreens");
            	         if (strScreenShots.equalsIgnoreCase("Yes"))
            	               func._takeBrowserScreenShot(getWebDriver(), "START", "", ""); 
            	  //func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
            	 //	       func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), "");
            	 	
            	  

              String env = GenericFunctions.instance()._getGlobalVariableValue("PARAMETER_ENV");
              String a = "";
              String environment = environmentData.getData("Environment");
              
             String resSubmissionStatus = GenericFunctions.instance()._getGlobalVariableValue("SubmissionStatus");
      		String resCrimeRetentionValue = GenericFunctions.instance()._getGlobalVariableValue("CrimeRetentionValue");
      		String resunderwriterName = GenericFunctions.instance()._getGlobalVariableValue("resUnderwriterName");
      		String respStateCode = GenericFunctions.instance()._getGlobalVariableValue("respStateCode");
      		
      		String respInsuredName=GenericFunctions.instance()._getGlobalVariableValue("respInsuredName");
      		String respLocality=GenericFunctions.instance()._getGlobalVariableValue("resLocality");
      		String resRegion=GenericFunctions.instance()._getGlobalVariableValue("respRegion");
      		String respAddressLine1=GenericFunctions.instance()._getGlobalVariableValue("resAddressLine1");
      		String respZipCode=GenericFunctions.instance()._getGlobalVariableValue("resZipCode");
      		String respOtherTradeName=GenericFunctions.instance()._getGlobalVariableValue("resOtherTradeName");
    		String respTradeName=GenericFunctions.instance()._getGlobalVariableValue("resTradeName");
    		String respSubEffectiveDate=GenericFunctions.instance()._getGlobalVariableValue("resSubEffectiveDate");
    		String resProducerName= GenericFunctions.instance()._getGlobalVariableValue("resProducerName");
            String respQuoteProducerName=GenericFunctions.instance()._getGlobalVariableValue("resAgencyName");
            String respQuoteDate=GenericFunctions.instance()._getGlobalVariableValue("respQuoteDate");
            String respSubNaicsCode=GenericFunctions.instance()._getGlobalVariableValue("resSubNaicsCode");
            String respQuotedPremium=GenericFunctions.instance()._getGlobalVariableValue("resQuotedPremium");
            String respDeductionValue="";
            String respLimitValue="";
            String resretentionValue  = "";
            String resCoveragePartCode=GenericFunctions.instance()._getGlobalVariableValue("resCoveragePartCode");
            String reqExpectedLimitValueEscape=GenericFunctions.instance()._getGlobalVariableValue("reqExpectedLimitValueEscape");
        
            if(resCoveragePartCode.equalsIgnoreCase("CRIME")) {
            	respLimitValue = GenericFunctions.instance()._getGlobalVariableValue("respLimitValue");
            	respDeductionValue=GenericFunctions.instance()._getGlobalVariableValue("respDeductionValue");
            	
            }else if(resCoveragePartCode.equalsIgnoreCase("DIRECTORS_AND_OFFICERS")
            		|| resCoveragePartCode.equalsIgnoreCase("EMPLOYMENT_PRACTICES_LIABILITY")
            		||resCoveragePartCode.equalsIgnoreCase("FIDUCIARY_LIABILITY")) {
            	respLimitValue = GenericFunctions.instance()._getGlobalVariableValue("respLimitValue"+"_"+resCoveragePartCode);
            	respDeductionValue=GenericFunctions.instance()._getGlobalVariableValue("respRetentionValue"+"_"+resCoveragePartCode);
            	//resretentionValue=GenericFunctions.instance()._getGlobalVariableValue("respAdjustedRetentionValue"+"_"+resCoveragePartCode);
            	
            }
           
            resretentionValue=GenericFunctions.instance()._getGlobalVariableValue("respAdjustedRetentionValue");
      		
      		Map<String, String> stateCodeMapKeyValue= new LinkedHashMap<String, String>();
      		ExcelDataReader stateCodeMap=new ExcelDataReader("./resources/TestData.xlsx");
      		
      	for (int j=2;j<=stateCodeMap.getLastRowNumber("StateCodeAndAbbreviations")+1;j++) {
      		String stateCodeKey=stateCodeMap.getCellData("StateCodeAndAbbreviations","Abbreviation",j).toString();
      		String stateCodeValue=stateCodeMap.getCellData("StateCodeAndAbbreviations","USState",j).toString();
      		System.out.println(stateCodeValue);
      		stateCodeMapKeyValue.put(stateCodeKey.trim(), stateCodeValue.trim());
      		
      	}
      	
              if (!env.isEmpty()) {
                    if (env.equalsIgnoreCase("DEV")) {
                          a = "window.open('https://everestnational-d/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx','_blank');";
                    } else {
                          if (env.equalsIgnoreCase("QA")) {
                                a = "window.open('https://everestnational-qa.everestre.net/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx','_blank');";
                          } else {
                                a = "window.open('https://everestnational-s.everestre.net/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx','_blank');";
                          }
                    }
              } else {
                    if (environment.equals("DEV")) {
                          a = "window.open('https://everestnational-d/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx','_blank');";
                    } else {
                          if (environment.equals("QA")) {
                                a = "window.open('https://everestnational-qa.everestre.net/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx','_blank');";
                          } else {
                                a = "window.open('https://everestnational-s.everestre.net/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx','_blank');";
                                                   
                          }
                    }
              }

              if (DeviceName.equalsIgnoreCase("MicrosoftEdge")) {
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
              String strParentWindowID=getWebDriver().getWindowHandle();
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
                                getWebDriver().get(
                                            "https://everestnational-d/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx");

                          } else {
                                if (env.equalsIgnoreCase("QA")) {
                                      getWebDriver().get(
                                                  "https://everestnational-qa.everestre.net/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx");

                                } else {
                                      getWebDriver().get(
                                                  "https://everestnational-s.everestre.net/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx");

                                }
                          }
                    } else {
                          if (environment.equals("DEV")) {
                                getWebDriver().get(
                                            "https://everestnational-d/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx");
                          } else {
                                if (environment.equals("QA")) {
                                      getWebDriver().get(
                                                  "https://everestnational-qa.everestre.net/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx");
                                } else {
                                      getWebDriver().get(
                                                  "https://everestnational-s.everestre.net/memberLogin/LoginMember.aspx?appname=ESCAPE&ReturnUrl=%2fESCAPE%2fDefault.aspx");
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
              String[] submissionID = GenericFunctions.instance()._getGlobalVariableValue("submissionId").split("-");
              getWebDriver().manage().window().maximize();
              Thread.sleep(3000);              
              func._waitForPageToLoad(getWebDriver(),(long) 10000);
             
              if(getWebDriver().getTitle().equalsIgnoreCase("Certificate Error: Navigation Blocked")||getWebDriver().getTitle().equalsIgnoreCase("This site isn�t secure")) {
            	  getWebDriver().findElement(By.xpath("//a[text()='More information']")).click();
            	  
              getWebDriver().findElement(By.xpath("//a[@id='overridelink']")).click();
              }
              Thread.sleep(2000);
              getWebDriver().findElement(By.xpath("//*[@type='text']")).sendKeys(data.getData("ESCUserName"));

              Thread.sleep(1000);
              getWebDriver().findElement(By.xpath("//*[@type='password']")).sendKeys(data.getData("ESCPassword"));
              Thread.sleep(1000);
              func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
              getWebDriver().findElement(By.xpath("//input[contains(@id,'LoginButton')]")).click();
              CustomReporting.instance().logReport("Sucessfully logged into Escape application");
              func._waitForPageToLoad(getWebDriver(), 200L);
              Thread.sleep(4000);
              if(!(getWebDriver().findElements(By.xpath("//a[@class='search-choice-close']")).size()==0)){
      		  getWebDriver().findElement(By.xpath("//a[@class='search-choice-close']")).click();
              }
      		 Thread.sleep(5000);
      		 System.out.println(data.getData("BussinessSegment"));
      		for(int i=0;i<100;i++)
      		{
	      		if(getWebDriver().findElement(By.xpath("//input[@class='default']")).isEnabled())    
	      			break;
	      		else
	      			wait(5000);
	      		System.out.println("Break");
	      		
      		}
      		getWebDriver().findElement(By.xpath("//input[@class='default']")).click();
      		getWebDriver().findElement(By.xpath("//input[@class='default']")).sendKeys(data.getData("BussinessSegment"));
      		getWebDriver().findElement(By.xpath("//input[@class='default']")).sendKeys((Keys.chord(Keys.ENTER)));
      		Thread.sleep(5000);
      		for(int i=0;i<100;i++)
      		{
	      		if(getWebDriver().findElement(By.id("ContentPlaceHolder1_tbSubmissionNumber")).isEnabled())    
	      			break;
	      		else
	      			wait(5000);
	      		System.out.println("Break");
	      		
      		}
      		  getWebDriver().findElement(By.id("ContentPlaceHolder1_tbSubmissionNumber")).click();
      		  getWebDriver().findElement(By.id("ContentPlaceHolder1_tbSubmissionNumber")).clear();
      		  
              getWebDriver().findElement(By.id("ContentPlaceHolder1_tbSubmissionNumber"))
                          .sendKeys(Keys.chord(Keys.CONTROL, "a"), submissionID[0]);
              Thread.sleep(1000);
              func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
              
              ((JavascriptExecutor) getWebDriver()).executeScript("window.scrollTo(0,800)");
              
              Thread.sleep(5000);
              getWebDriver().findElement(By.xpath("//input[contains(@id,'btnSearch')]")).click();
              
              Thread.sleep(5000);
              func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
              Thread.sleep(1000);

              String accountId = getWebDriver().findElement(By.xpath("//table[contains(@id,'gvSearch')]//tr[2]/td[1]/a"))
                          .getText();
              Thread.sleep(1000);
              getWebDriver().findElement(By.xpath("//table[contains(@id,'gvSearch')]//tr[2]/td[1]/a")).click();
              func._waitForPageToLoad(getWebDriver(), 250L);
              func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

              Thread.sleep(3000);
              
              String fName = getWebDriver().findElement(By.id("txtprimaryInsuredName_1")).getAttribute("value");
              if(fName.equalsIgnoreCase(respInsuredName)) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "Isured First Name  in Escape "+ fName +" is as Expected value  "  + respInsuredName,
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "Insured First Name  in Escape "+ fName +" is not as Expected value  "  + respInsuredName,
                                StepStatus.FAILURE, new String[] {}, startTime);
              }
              String city = getWebDriver().findElement(By.id("txtMailingCity")).getAttribute("value");
              if(city.equalsIgnoreCase(respLocality)) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "City Name  in Escape "+ city +" is as Expected value  "  + respLocality,
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "City Name  in Escape "+ city +" is not as Expected value  "  + respLocality,
                                StepStatus.FAILURE, new String[] {}, startTime);
              }
              String addressLine1 = getWebDriver().findElement(By.id("txtStreetAddress")).getAttribute("value");
              if(addressLine1.equalsIgnoreCase(respAddressLine1)) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "AddressLine1  in Escape "+ addressLine1 +" is as Expected value  "  +respAddressLine1,
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "AddressLine1  in Escape "+ addressLine1 +" is not as Expected value  "  +respAddressLine1,
                                StepStatus.FAILURE, new String[] {}, startTime);
              }
              String zipCode = getWebDriver().findElement(By.id("txtMailingzipCode")).getAttribute("value");
              if(zipCode.equalsIgnoreCase(respZipCode)) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "ZIP code  in Escape "+ zipCode +" is as Expected value  "  + respZipCode,
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "ZIP code  in Escape "+ zipCode +" is not as Expected value  "  + respZipCode,
                                StepStatus.FAILURE, new String[] {}, startTime);
              }
//              String OthertradeName = getWebDriver().findElement(By.xpath("//input[@id='additionalnames_txtprimaryInsuredName_21']"))
//            		  .getAttribute("value");
         //     ,
//              if(OthertradeName.equalsIgnoreCase(respOtherTradeName)) {
//            	  list.add(true);
//                    CustomReporting.logReport("", "",
//                                "Other Trade Name  in Escape "+ OthertradeName +" is as Expected value  "  + respOtherTradeName,
//                                StepStatus.SUCCESS, new String[] {}, startTime);
//              }else {
//            	  list.add(false);
//                    CustomReporting.logReport("", "",
//                                "Old Trade Name  in Escape "+ OthertradeName +" is not as Expected value  "  + respOtherTradeName,
//                                StepStatus.FAILURE, new String[] {}, startTime);
//              }
//              
           
//              String tradeName = getWebDriver().findElement(By.xpath("//input[@id='additionalnames_txtprimaryInsuredName_10']"))
//                      .getAttribute("value");
//              
//              if(tradeName.equalsIgnoreCase(respTradeName)) {
//            	  list.add(true);
//                  CustomReporting.logReport("", "",
//                              "Trade name in Escape "+ tradeName +" is as Expected value  "  + respTradeName,
//                              StepStatus.SUCCESS, new String[] {}, startTime);
//            }else {
//            	list.add(false);
//                  CustomReporting.logReport("", "",
//                              "Trade Name  in Escape "+ tradeName +" is not as Expected value  "  + respTradeName,
//                              StepStatus.FAILURE, new String[] {}, startTime);
//            }
              // verify fields
              String SubId=GenericFunctions.instance()._getGlobalVariableValue("submissionId").toString().trim();
              Thread.sleep(3000);
              getWebDriver().findElement(By.xpath("//a[text()='"+SubId+"']")).click();
              Thread.sleep(6000);
              CustomReporting.logReport("Clicked On Submission Number Successfully");
              func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
              Thread.sleep(10000);

              func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
              
              String predominantState = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlPredominantState']/option[@selected='selected']"))
                          .getText();
              if(!(predominantState.equalsIgnoreCase(null))) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "Predominant sate in Escape "+ predominantState +" is as Expected value  "  + stateCodeMapKeyValue.get(respStateCode),
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "Predominnat state  in Escape "+ predominantState +" is not as Expected value  "  + stateCodeMapKeyValue.get(respStateCode),
                                StepStatus.FAILURE, new String[] {}, startTime);
              }
              // verify state
              String businessSegment = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlBusinessSegment']/option[@selected='selected']"))
                          .getText();
              if(businessSegment.equalsIgnoreCase(data.getData("BussinessSegment"))) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "Bussiness Segment  in Escape "+ businessSegment +" is as Expected value  "  + data.getData("BussinessSegment"),
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "Bussiness Segment in Escape "+ businessSegment +" is not as Expected value  "  + data.getData("BussinessSegment"),
                                StepStatus.FAILURE, new String[] {}, startTime);
              }

              String submsStatus = getWebDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlSubmissionStatus']/option[@selected='selected']")).getText();
      		if(submsStatus.trim().equalsIgnoreCase(data.getData("ExpectedStatus"))) {
      			CustomReporting.logReport("", "",
      					"Submission Status  in Escape "+ submsStatus +" is as Expected value  "  + data.getData("ExpectedStatus"),
      					StepStatus.SUCCESS, new String[] {}, startTime);
      		}else {
      			CustomReporting.logReport("", "",
      					"Submission Status  in Escape "+ submsStatus +" is not as Expected value  "  + data.getData("ExpectedStatus"),
      					StepStatus.FAILURE, new String[] {}, startTime);
      		}
                
             String branchOffice = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlBranchOffice']/option[@selected='selected']"))
                          .getText();
              if (branchOffice.equalsIgnoreCase(data.getData("BranchOffice"))) {
            	  list.add(true);
                    CustomReporting.logReport("", "", "Branch Office value is " + branchOffice, StepStatus.SUCCESS,
                                new String[] {}, startTime);
              } else {
            	  list.add(false);
                    CustomReporting.logReport("", "", "Branch Office value :"+branchOffice+" is not matching ", StepStatus.FAILURE, new String[] {},
                                startTime);
              }
              String marketSegment = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlMarketSegment']/option[@selected='selected']"))
                          .getText();
              if(!(marketSegment.equalsIgnoreCase(null))) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "Market Segment  in Escape "+ marketSegment +" is as Expected value  "  + "",
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "Market Segment   in Escape "+ marketSegment +" is not as Expected value  "  + "",
                                StepStatus.FAILURE, new String[] {}, startTime);
              }
              
              String submissionType = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlSubmissionType']/option[@selected='selected']"))
                          .getText();
              if(submissionType.equalsIgnoreCase(data.getData("SubmissionType"))) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "Submission Type in Escape "+ submissionType +" is as Expected value  "  + data.getData("SubmissionType"),
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "Submission Type  in Escape "+ submissionType +" is not as Expected value  "  + data.getData("SubmissionType"),
                                StepStatus.FAILURE, new String[] {}, startTime);
              }
              
              ;
              String submissionEffectiveDate = getWebDriver().findElement(By.id(
                          "ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_tbSubmissionEffectiveDate"))
                          .getAttribute("value");
              String submissionExpirationDate = getWebDriver().findElement(By.id(
                      "ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_tbSubmissionExpirationDate"))
                      .getAttribute("value");
              GenericFunctions.instance()._addToGlobalVariableList("respSubEffectiveDate", submissionEffectiveDate);
              GenericFunctions.instance()._addToGlobalVariableList("respExpirationDate", submissionExpirationDate);
              if(submissionEffectiveDate.equalsIgnoreCase(convertDateFormat(respSubEffectiveDate))) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "Submission Effective date in Escape "+ submissionEffectiveDate +" is as Expected value  "  + convertDateFormat(respSubEffectiveDate),
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "Submission Effective date in Escape"+ submissionEffectiveDate +" is not as Expected value  "  + convertDateFormat(respSubEffectiveDate),
                                StepStatus.FAILURE, new String[] {}, startTime);
              }
              String incumbantCarrier = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlIncumbentCarrier']/option[@selected='selected']"))
                          .getText();
              if(incumbantCarrier.equalsIgnoreCase(data.getData("IncumbantCarrier"))) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "Incumbant Carier in Escape "+ incumbantCarrier +" is as Expected value  "  + data.getData("IncumbantCarrier"),
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "Incumbant Carier in Escape "+ incumbantCarrier +" is not as Expected value  "  + data.getData("IncumbantCarrier"),
                                StepStatus.FAILURE, new String[] {}, startTime);
              }

              String submittedLOB = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlSubmittedLineBusiness']/option[@selected='selected']"))
                          .getText();
              
              if(submittedLOB.equalsIgnoreCase(data.getData("SubmittedLOB"))) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "Submitted Line Of Bussiness in Escape "+ submittedLOB +" is as Expected value  "  + data.getData("SubmittedLOB"),
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "Submitted Line Of Bussiness  in Escape "+ submittedLOB +" is not as Expected value  "  + data.getData("SubmittedLOB"),
                                StepStatus.FAILURE, new String[] {}, startTime);
              }
//              
              if(!(tcID.contains("DS_SubmsOFACBlock_")||tcID.contains("DS_SubmBlockDueToName_")||tcID.contains("DS_SubmsRefrl_Crime_01")||data.getData("ExpectedStatus").equalsIgnoreCase("Working")||
            		  data.getData("ExpectedStatus").equalsIgnoreCase("Blocked")||data.getData("ExpectedStatus").equalsIgnoreCase("Declined"))) {
              
              String limitValue= getWebDriver().findElement(By.xpath(
                      "//input[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_tbLimit']"))
                      .getAttribute("value").replace(",", "");
          if (limitValue.equalsIgnoreCase(reqExpectedLimitValueEscape)) {
        	  list.add(true);
                CustomReporting.logReport("", "", "Limit value in Esacpe  " + limitValue +" equals the value in the quote response" + respLimitValue , StepStatus.SUCCESS,
                            new String[] {}, startTime);
          } else {
        	  list.add(false);
                CustomReporting.logReport("", "", "Limit value in Esacpe  " + limitValue +" not equals the value in the quote response " + respLimitValue , StepStatus.FAILURE, new String[] {},
                            startTime);
          }
          String retentionValue= getWebDriver().findElement(By.id(
                  "ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_tbRetentionAttachment"))
                  .getAttribute("value").replace(",", "");
        if(resretentionValue.equals("0")) {
        	if (retentionValue.equals("")||retentionValue.equalsIgnoreCase("null")) {
          	  list.add(true);
                  CustomReporting.logReport("", "", "Retention/Attachment value is Blank in Escape as rentention value is 0"  , StepStatus.SUCCESS,
                              new String[] {}, startTime);
            } else {
          	  list.add(false);
                  CustomReporting.logReport("", "", "Retention/Attachment value is not Blank in Escape as rentention value is not  0" + resretentionValue, StepStatus.FAILURE, new String[] {},
                              startTime);
            }
        }else {
      if (retentionValue.equalsIgnoreCase(resretentionValue)) {
    	  list.add(true);
            CustomReporting.logReport("", "", "Retention/Attachment value in Escape"   + retentionValue +" equals the value in the quote response" + resretentionValue , StepStatus.SUCCESS,
                        new String[] {}, startTime);
      } else {
    	  list.add(false);
            CustomReporting.logReport("", "", "Retention/Attachment value in Escape  " + retentionValue +" not equals the value in the quote response" + resretentionValue , StepStatus.FAILURE, new String[] {},
                        startTime);
      }
        }
        } 
              
              String producerName = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlProducerName']/option[@selected='selected']"))
                          .getText();
              if(resCoveragePartCode.equalsIgnoreCase("CYBER_LIABILITY")) {
            	  if (producerName.equalsIgnoreCase(data.getData("ExpectedProducerName"))) {
                	  list.add(true);
                        CustomReporting.logReport("", "", "Producer Name value in Esacpe  " + producerName +" equals the value in the quote response " + respQuoteProducerName , StepStatus.SUCCESS,
                                    new String[] {}, startTime);
                  } else {
                	  list.add(false);
                        CustomReporting.logReport("", "", "Producer Name value in Esacpe  " + producerName +" not equals the value in the quote response " + respQuoteProducerName , StepStatus.FAILURE, new String[] {},
                                    startTime);
                  }
              }else {
              if (producerName.equalsIgnoreCase(resProducerName)) {
            	  list.add(true);
                    CustomReporting.logReport("", "", "Producer Name value in Esacpe  " + producerName +" equals the value in the quote response " + respQuoteProducerName , StepStatus.SUCCESS,
                                new String[] {}, startTime);
              } else {
            	  list.add(false);
                    CustomReporting.logReport("", "", "Producer Name value in Esacpe  " + producerName +" not equals the value in the quote response " + respQuoteProducerName , StepStatus.FAILURE, new String[] {},
                                startTime);
              }
              }

              String producerOffice = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlProducerOffice']/option[@selected='selected']"))
                          .getText();

              if (!(producerOffice.equals("")||producerOffice.equalsIgnoreCase("null"))) {
            	  list.add(true);
                    CustomReporting.logReport("", "", "Producer Office value : " + producerOffice+" is as expected", StepStatus.SUCCESS,
                                new String[] {}, startTime);
              } else {
            	  list.add(false);
                    CustomReporting.logReport("", "", "Producer Office  value : "+ producerOffice+" is not as expected ", StepStatus.FAILURE,
                                new String[] {}, startTime);
              }

              String underwriterName = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlUnderwriterName']/option[@selected='selected']"))
                          .getText();

              if (underwriterName.equals(resunderwriterName)) {
            	  list.add(true);
                    CustomReporting.logReport("", "", "Underwriter Name value in escape is :" + underwriterName +" is matching with the response value :"+resunderwriterName, StepStatus.SUCCESS,
                                new String[] {}, startTime);
              } else {
            	  list.add(false);
                    CustomReporting.logReport("", "", "Underwriter Name value in escape is :" + underwriterName +" is not matching with the response value :"+resunderwriterName, StepStatus.FAILURE,
                                new String[] {}, startTime);
              }

              String underwriterAssistant = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlUnderwritingAssistant']/option[@selected='selected']"))
                          .getText();

              if (underwriterAssistant.equals(data.getData("UnderwritingAssistant"))) {
            	  list.add(true);
                    CustomReporting.logReport("", "", "underwriterAssistant Name value is " + underwriterAssistant,
                                StepStatus.SUCCESS, new String[] {}, startTime);
              } else {
            	  list.add(false);
                    CustomReporting.logReport("", "", "underwriterAssistant Name  value "+ underwriterAssistant+ "is not exepected ", StepStatus.FAILURE,
                                new String[] {}, startTime);
              }

              String insuringCompanyId = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlEverestCompany']/option[@selected='selected']"))
                          .getText();

              if (!(insuringCompanyId.equals("") || insuringCompanyId.equalsIgnoreCase("NULL"))) {
            	  list.add(true);
                    CustomReporting.logReport("", "", "Insuring Company Name value is " + insuringCompanyId,
                                StepStatus.SUCCESS, new String[] {}, startTime);
              } else {
            	  list.add(false);
                    CustomReporting.logReport("", "", "Insuring Company Name  value is BLANK ", StepStatus.FAILURE,
                                new String[] {}, startTime);
              }


              
              if(!(tcID.contains("DS_SubmsOFACBlock_")||tcID.contains("DS_SubmBlockDueToName_")||tcID.contains("DS_SubmsRefrl_Crime_01")||
            		  data.getData("ExpectedStatus").equalsIgnoreCase("Working")||data.getData("ExpectedStatus").equalsIgnoreCase("Blocked")||data.getData("ExpectedStatus").equalsIgnoreCase("Declined"))) {
              String quotedDate = getWebDriver().findElement(By.id(
                          "ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_tbDateQuoted"))
                          .getAttribute("value");
              
            
              if(quotedDate.equalsIgnoreCase(convertDateFormatOfQuoteDate(respQuoteDate))) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "Quoted date  in Escape "+ quotedDate +" is as Expected value  "  + convertDateFormatOfQuoteDate(respQuoteDate),
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "Quoted date in Escape "+ quotedDate +" is not as Expected value  "  + convertDateFormatOfQuoteDate(respQuoteDate),
                                StepStatus.FAILURE, new String[] {}, startTime);
              }
              String quotedPremium = getWebDriver().findElement(By.id(
                          "ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_tbQuotedPremium"))
                          .getAttribute("value").replace(",", "").replace(".00","");
             String quotePremium = respQuotedPremium.replace(".0", "");
              if(quotedPremium.equalsIgnoreCase(quotePremium)) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "Quoted Premium  in Escape "+ quotedPremium +" is as Expected value  "  + quotePremium,
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "Quoted Premium  in Escape "+ quotedPremium +" is not as Expected value  "  + quotePremium,
                                StepStatus.FAILURE, new String[] {}, startTime);
              }
              }
              
              String naicsCode = getWebDriver()
                          .findElement(By.xpath(
                                      "//input[contains(@id,'TabAccountContainer_TabSubmission_ctrlSubmission_tbNaicsCode')]"))
                          .getAttribute("value");
              if(naicsCode.equalsIgnoreCase(respSubNaicsCode)) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "Naics Code in Escape "+ naicsCode +" is as Expected value  "  + respSubNaicsCode,
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "Naics Code in Escape "+ naicsCode +" is not as Expected value  "  + respSubNaicsCode,
                                StepStatus.FAILURE, new String[] {}, startTime);
              }
              if(!(tcID.contains("DS_SubmsOFACBlock_")||tcID.contains("DS_SubmBlockDueToName_")||data.getData("ExpectedStatus").equalsIgnoreCase("Working")||data.getData("ExpectedStatus").equalsIgnoreCase("Blocked")||
            		  data.getData("ExpectedStatus").equalsIgnoreCase("Declined"))) {
              String quotedLOB = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabSubmission_ctrlSubmission_ddlQuotedLineBusiness']/option[@selected='selected']"))
                          .getText();

              if(quotedLOB.equalsIgnoreCase(data.getData("SubmittedLOB"))) {
            	  list.add(true);
                    CustomReporting.logReport("", "",
                                "Quoted LOB in Escape "+ quotedLOB +" is as Expected value  "  + data.getData("SubmittedLOB"),
                                StepStatus.SUCCESS, new String[] {}, startTime);
              }else {
            	  list.add(false);
                    CustomReporting.logReport("", "",
                                "Quoted LOB  in Escape "+ quotedLOB +" is not as Expected value  "  + data.getData("SubmittedLOB"),
                                StepStatus.FAILURE, new String[] {}, startTime);
              }
              Thread.sleep(1000);
              }
              /******Policy Screen verification*********/
              /*getWebDriver().findElement(By.id("ContentPlaceHolder1_WebSplitter1_tmpl0_TreeAccountt2")).click();

              Thread.sleep(5000);
              CustomReporting.logReport("Clicked On Policy  Number Successfully");
              func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");

              Boolean commDisplay = getWebDriver()
                          .findElement(By.id("TabAccountContainer_TabPolicy_ctrlPolicy_tbCommission")).isDisplayed();
              if (commDisplay) {
                    CustomReporting.logReport("Successfully naviaged to Policy Screen");
              } else {
                    throw new RuntimeException();
              }
              String escComission = getWebDriver()
                          .findElement(By.id("TabAccountContainer_TabPolicy_ctrlPolicy_tbCommission")).getAttribute("value");
              if (escComission.equals("commValue")) {
                    CustomReporting.logReport(
                                "", "", "Commission value   in Escape " + escComission
                                            + " is equal to value in Insureon portal  " + "commValue",
                                StepStatus.SUCCESS, new String[] {}, startTime);
              } else {
                    CustomReporting.logReport(
                                "", "", "Commission value  in Escape " + escComission
                                            + " is equal to value in Insureon portal  " + "commValue",
                                StepStatus.FAILURE, new String[] {}, startTime);

              }
              
              * func._checkAttributeValue(getElement(txt_PolicyEffectiveDate),
              * "value",func._getGlobalVariableValue("EffectiveDateValue") , softAssert);
              * func._checkAttributeValue(getElement(lbl_BillType), "TEXT","Direct Bill" ,
              * softAssert); func._checkAttributeValue(getElement(txt_PolicyStatus),
              * "TEXT","New" , softAssert);
              * func._checkAttributeValue(getElement(txt_PolicyPremium), "value",premium ,
              * softAssert); func._checkAttributeValue(getElement(txt_PolicyCommission),
              * "value","14.00" , softAssert);
              * func._checkAttributeValue(getElement(txt_ProductCode), "TEXT","WCA" ,
              * softAssert);
              

              String policyEffectiveDate = getWebDriver().findElement(By.id(
                          "ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabPolicy_ctrlPolicy_tbPolicyEffectiveDate"))
                          .getAttribute("value");
              String billType = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabPolicy_ctrlPolicy_ddlBillType']/option[@selected='selected']"))
                          .getText();
              String policyStatus = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabPolicy_ctrlPolicy_ddlPolicyStatus']/option[@selected='selected']"))
                          .getText();
              String pPremium = getWebDriver().findElement(By.id(
                          "ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabPolicy_ctrlPolicy_tbPolicyPremium"))
                          .getAttribute("value");
              String pCommission = getWebDriver().findElement(By
                          .id("ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabPolicy_ctrlPolicy_tbCommission"))
                          .getAttribute("value");

              String productCode = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabPolicy_ctrlPolicy_ddlProductCode']/option[@selected='selected']"))
                          .getText();
              String escapePaymentPlan = getWebDriver().findElement(By.xpath(
                          "//select[@id='ContentPlaceHolder1_WebSplitter1_tmpl1_TabAccountContainer_TabPolicy_ctrlPolicy_ddlPaymentPlan']/option[@selected='selected']"))
                          .getText();
              if (escapePaymentPlan.contains("PaymentOptionValue")) {
                    CustomReporting.logReport(
                                "", "", "Payment Plan  in Escape " + escapePaymentPlan
                                            + " is equal to value in Insureon portal  " + "PaymentOptionValue",
                                StepStatus.SUCCESS, new String[] {}, startTime);
              } else {
                    CustomReporting.logReport(
                                "", "", "Payment Plan  in Escape " + escapePaymentPlan
                                            + " is equal to value in Insureon portal  " + "PaymentOptionValue",
                                StepStatus.FAILURE, new String[] {}, startTime);
                                
              }*/
              
              Thread.sleep(3000);
              getWebDriver().findElement(By.xpath("//a[@id='lbtnLogOut']")).click();
              getWebDriver().close();
              getWebDriver().switchTo().window(strParentWindowID);

        } catch (RuntimeException ex) {
              func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
              CustomReporting.logReport("", "", "Error occurred in Page" + getPageName(), "", StepStatus.FAILURE,
                          new String[] {}, startTime, null);
              throw ex;
        }

  }

	@Override
	public void closeScreenshots(String tcID, SoftAssert softAssert) throws Exception {
		
		func._takeBrowserScreenShot(getWebDriver(), "FINISH", getWebDriver().getCurrentUrl(), tcID);
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




