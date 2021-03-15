package com.everest.page.application.spi;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.OptionalCovPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;



public class OptionalCovPageImpl extends CustomAbstractPage implements OptionalCovPage {
	long startTime = System.currentTimeMillis();	
	
	@Override
	public void OptionalCov(String tcID, SoftAssert softAssert) throws Exception 
	{
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
		PageData dataPolicyChange = PageDataManager.instance().getPageData("PolicyChange", tcID);
		/*String strScreenShots=dataLogin.getData("PrintScreens");
		 
		
		
        if(strScreenShots.equalsIgnoreCase("Yes"))
        {
          func._takeScreenShot(getWebDriver(), "START", "", "");
        }*/
        	    _wait(7000);
	    //func._splitDatabyDelimiter(dataLogin.getData("OptionalCoverages"),";");
		   
	    _click(getElement(btnCoverages));
	    _wait(4000);

	    _click(getElement(btnOptionalCov));
	    _wait(1000);
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");


	    String val = (dataLogin.getData("OptionalCoverages"));
	    	    String values[] = val.split(";");
	    	    int l = values.length;
	    	    
	    	    for (int i = 0;i<l;i++)
	    	    		{
	    	    	
	    	    	System.out.println( values[i]);
	    	    	_click(getElement(btnAddCoverages));
                    func._waitForPageToLoad(getWebDriver(),50L);
                    _wait(4000);
	    	    	     _setValue(getElement(txtKeyword),values[i]);
	    	    	     func._waitForPageToLoad(getWebDriver(),50L);
	    	    	     if(tcID.equalsIgnoreCase("DS_R2_SIT_E2E_SC13")) {
	    	    	    	 _setValue(getElement(btnCategory), "All");
	    	    	     }
	    	    	     else {
	    	    	     _setValue(getElement(btnCategory), "Optional - Non-Rate Bearing");
	    	    	     }
                         _wait(4000);
                         _click(getElement(txtKeyword));
                         _wait(2000);
                         _click(getElement(btnSearch));
                         _wait(4000);
                         _click(getElement(chkCoverage));
                         _wait(4000);
                         _click(getElement(btnSelectCoverage));
//	                         Actions ac = new Actions(getWebDriver());
//	                         ac.sendKeys(chkCoverage, Keys.SPACE);
	                     func._waitForPageToLoad(getWebDriver(),50L);
	                     _click(getElement(btnAddSelectedCov));
	                     func._waitForPageToLoad(getWebDriver(),50L);
	                     func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	                         
	                         RateBearingOptCovUpdateLimit(values[i]);
	                         
	           if(!dataPolicyChange.getData("FormSelection").isEmpty())
	           {
	        	   _setValue(getElement(txtRunOffFormSelection), dataPolicyChange.getData("FormSelection"));
	        	   _wait(3000);
	        	   func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	           }
	                         
	                         

	    }



	 
	    
	    _wait(2000);
	    func._waitForPageToLoad(getWebDriver(),50L);
	    func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
	    CustomReporting.logReport("","","Logged in to the application successfully!" ,StepStatus.REPORT,new String[] { },System.currentTimeMillis()); 
	}
	
	public void OptionalCovValid(String tcID, SoftAssert softAssert) throws Exception {
		PageData dataSubDetail = PageDataManager.instance().getPageData("UMSubmissionDetails",tcID);
		PageData dataLogin = PageDataManager.instance().getPageData("Login",tcID);
	    _wait(7000);
	    //func._splitDatabyDelimiter(dataLogin.getData("OptionalCoverages"),";");
		   
	    _click(getElement(btnCoverages));
	    _wait(4000);

	    _click(getElement(btnOptionalCov));

	    _wait(4000);
	    
	    
		List<String> selCoverages =new ArrayList<String>();
		
		if(dataSubDetail.getData("DNO").equalsIgnoreCase("Yes")) {
			
			selCoverages.add("DNO");
		}
		
         if(dataSubDetail.getData("EPL").equalsIgnoreCase("Yes")) {
			
			selCoverages.add("EPL");
		}
         
         if(dataSubDetail.getData("CRIME").equalsIgnoreCase("Yes")) {
 			
 			selCoverages.add("CRI");
 		}
         if(dataSubDetail.getData("CYB").equalsIgnoreCase("Yes")) {
  			
  			selCoverages.add("CYB");
  		}
         if(dataSubDetail.getData("FID").equalsIgnoreCase("Yes")) {
  			
  			selCoverages.add("FID");
  		}
         if(dataSubDetail.getData("KNR").equalsIgnoreCase("Yes")) {
  			
  			selCoverages.add("KNR");
  		}
         List<String> listOfNRB_OptCov =new ArrayList<String>();
         
         for(String listOfCov:selCoverages) {
        
        	 _click(getClonedElement(tabCoverage).addToken("tkn_Cov",listOfCov));
        	 
        	 _wait(4000);
        	 int sizeOfSelectedORB=getWebDriver().findElements(By.xpath("(//div[@class='x-container g-dv-column x-container-default x-table-layout-ct'])[1]//div[@class='x-component x-fieldset-header-text x-component-default']")).size();
        	
        	
        	 if (sizeOfSelectedORB>0) {
        	 for(int i=1;i<=sizeOfSelectedORB;i++) {
        		 
        		 System.out.println(i);
        		 
        		 listOfNRB_OptCov.add(getWebDriver().findElement(By.xpath("((//div[@class='x-container g-dv-column x-container-default x-table-layout-ct'])[1]//div[@class='x-component x-fieldset-header-text x-component-default'])["+i+"]")).getText());
        		 
        		 System.out.println(listOfNRB_OptCov);
        	 }
        	 }
         }
         
         String expListOfOptCov[];
         
         if((dataLogin.getData("RateBearingOptCov").equalsIgnoreCase(""))){
        	 
        	  expListOfOptCov =(dataLogin.getData("OptionalCoverages")+";"+dataLogin.getData("RateBearingOptCov")).split(";");
        	 
         }
         else {
         
         expListOfOptCov =dataLogin.getData("OptionalCoverages").split(";");
         }
         
         for(String strCov:expListOfOptCov) {
        	 
        	 if(listOfNRB_OptCov.contains(strCov.trim())) {
        
     		    	CustomReporting.logReport("","","Verified the selected Optiona Cov :"+strCov+" is present in PC",StepStatus.SUCCESS,new String[] { },System.currentTimeMillis());	
     		    }
     		    else
     		    {
     		    	CustomReporting.logReport("","", "Verified the selected Optiona Cov :"+strCov+" is not present in PC","", StepStatus.FAILURE,new String[] {  }, System.currentTimeMillis(), null);
     		    	throw new RuntimeException();
     		    
        		 
        	 }
         }
		
		
		

	}

	
	public void RateBearingOptCovUpdateLimit(String Coverages) throws Exception{
		
		_wait(4000);
		
		 //_click(getClonedElement(tabCoverage).addToken("tkn_Cov","CYB"));
    	 
    	 _wait(4000);
    	 
    	 if(Coverages.equalsIgnoreCase("CYB Separate Defense Cost Coverage")) {
    		 
    	_setValue(getElement(txtSepDefenseCostLmt), "100000");
    		 
  
    		 
    	 }
    	 
    	 if(Coverages.equalsIgnoreCase("Reputation Repair (Additional Public Relations Costs)")) {
    		 
    	    		 
    	    	_setValue(getClonedElement(txtRptnRepSubLmtReten).addToken("tkn_Num", "0"), "10000");
    	    	_wait(2000);
    	    	
    	    	_click(getClonedElement(txtRptnRepSubLmtReten).addToken("tkn_Num", "1"));
    	    	
    	    	_wait(2000);
    	    	
    	    	_setValue(getClonedElement(txtRptnRepSubLmtReten).addToken("tkn_Num", "1"), "1000");
    	    	
    	    	_wait(2000);
    	    		 
    	    	 }
    	 if(Coverages.equalsIgnoreCase("System Failure")) {
    		 
    		 
 	    	_setValue(getClonedElement(txtSysfailLmtReten).addToken("tkn_Num", "0"), "10000");
 	    	_wait(2000);
 	    	
 	    	_click(getClonedElement(txtSysfailLmtReten).addToken("tkn_Num", "1"));
 	    	
 	    	_wait(2000);
 	    	
 	    	_setValue(getClonedElement(txtSysfailLmtReten).addToken("tkn_Num", "1"), "1000");
 	    	
 	    	_wait(2000);
 	    	_click(getClonedElement(txtSysfailLmtReten).addToken("tkn_Num", "2"));
 	    	
 	    	_wait(2000);
             _setValue(getClonedElement(txtSysfailLmtReten).addToken("tkn_Num", "2"), "10");
 	    	
 	    	_wait(2000);
 	    		 
 	    	 }
    	 
    	 if(Coverages.equalsIgnoreCase("Wrongful Collection")) {
    		 
    		 
  	    	_setValue(getClonedElement(txtWrongFullCollLmtReten).addToken("tkn_Num", "0"), "10000");
  	    	_wait(2000);
  	    	
  	    	_click(getClonedElement(txtWrongFullCollLmtReten).addToken("tkn_Num", "1"));
  	    	
  	    	_wait(2000);
  	    	
  	    	_setValue(getClonedElement(txtWrongFullCollLmtReten).addToken("tkn_Num", "1"), "1000");
  	    	
  	    	_wait(2000);
  	    	
  	    		 
  	    	 }
    	 
    	 if(Coverages.equalsIgnoreCase("Social Engineering")) {
    		 
    		 
   	    	_setValue(getClonedElement(txtSocialEnggLmtReten).addToken("tkn_Num", "0"), "10000");
   	    	_wait(2000);
   	    	
   	    	_click(getClonedElement(txtSocialEnggLmtReten).addToken("tkn_Num", "1"));
   	    	_wait(2000);
   	    	_setValue(getClonedElement(txtSocialEnggLmtReten).addToken("tkn_Num", "1"), "1000");
   	    	
   	    	_wait(2000);
   	    	
   	    		 
   	    	 }
		
		
		
	}


	@Override
	public void VerifyRunOffAndERPFields(String tcID, SoftAssert softAssert) throws Exception{
		
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin",tcID);
		
		String ExpectedRunOffPercentageAnnualPrem1="";
		String ExpectedRunOffPercentageAnnualPrem3="";
		String ExpectedRunOffPercentageAnnualPrem6="";
		
		
		
		func._waitForPageToLoad(getWebDriver(), 50L);
		WebDriverWait w = new WebDriverWait(getWebDriver(),250);
		
		
		if(dataUmLogin.getData("RunOffRiskClassification").equalsIgnoreCase("Average")) {
			
			ExpectedRunOffPercentageAnnualPrem1="100";
			ExpectedRunOffPercentageAnnualPrem3="125";
			ExpectedRunOffPercentageAnnualPrem6="150";
		}else if(dataUmLogin.getData("RunOffRiskClassification").equalsIgnoreCase("Low")) {
			ExpectedRunOffPercentageAnnualPrem1="75";
			ExpectedRunOffPercentageAnnualPrem3="100";
			ExpectedRunOffPercentageAnnualPrem6="125";
		}else if(dataUmLogin.getData("RunOffRiskClassification").equalsIgnoreCase("Moderate")) {
			ExpectedRunOffPercentageAnnualPrem1="150";
			ExpectedRunOffPercentageAnnualPrem3="250";
			ExpectedRunOffPercentageAnnualPrem6="350";
		}else if(dataUmLogin.getData("RunOffRiskClassification").equalsIgnoreCase("Moderate")) {
			ExpectedRunOffPercentageAnnualPrem1="200";
			ExpectedRunOffPercentageAnnualPrem3="350";
			ExpectedRunOffPercentageAnnualPrem6="500";
		}
		
		
		Thread.sleep(5000);
		getWebDriver().findElement(By.xpath("//span[text()='Coverages']")).click();
		Thread.sleep(5000);
		func._takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
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
					
					if (value.equals(ExpectedRunOffPercentageAnnualPrem1)) {
						CustomReporting.logReport("", "",
								label + " is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage<b><i><font color='green'> " + coverageName
										+ "</font></i></b> is as expected",
								StepStatus.SUCCESS, new String[] {}, startTime);
					} else {
						
						CustomReporting.logReport("", "",
								label + " is <b><i><font color='red'> " + value + " </font></i></b> for Coverage <b><i><font color='red'>" + coverageName
										+ "</font></i></b> is not as expected",
								StepStatus.FAILURE, new String[] {}, startTime);
					}
				}
				if (label.contains("Percentage of Annual Premium (3 Years)")) {
					
					if (value.equals(ExpectedRunOffPercentageAnnualPrem3)) {
						CustomReporting.logReport("", "",
								label + " is <b><i><font color='green'>  " + value + "</font></i></b>  for Coverage <b><i><font color='green'> " + coverageName
										+ "</font></i></b> is as expected",
								StepStatus.SUCCESS, new String[] {}, startTime);
					} else {
						
						CustomReporting.logReport("", "",
								label + " is  <b><i><font color='red'> " + value + " </font></i></b> for Coverage <b><i><font color='red'> " + coverageName
										+ "</font></i></b> is not as expected",
								StepStatus.FAILURE, new String[] {}, startTime);
					}
				}

				if (label.contains("Percentage of Annual Premium (6 Years)")) {
					
					if (value.equals(ExpectedRunOffPercentageAnnualPrem6)) {
						CustomReporting.logReport("", "<b><i><font color='green'>",
								label + "</font></i></b> is  <b><i><font color='green'>" + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
										+ "</font></i></b> is as expected",
								StepStatus.SUCCESS, new String[] {}, startTime);
					} else {
						
						CustomReporting.logReport("", "<b><i><font color='red'>",
								label + "</font></i></b> is <b><i><font color='red'>" + value + "</font></i></b>  for Coverage <b><i><font color='red'>" + coverageName
										+ "</font></i></b> is as expected",
								StepStatus.FAILURE, new String[] {}, startTime);
					}
				}

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
					
					if (value.equals(dataUmLogin.getData("PercentageAnnualPremium"))) {
						
						CustomReporting.logReport("", "<b><i><font color='green'>",
								label + "</font></i></b> is  <b><i><font color='green'>" + value + " </font></i></b> for Coverage <b><i><font color='green'>" + coverageName
										+ "</font></i></b> is as expected",
								StepStatus.SUCCESS, new String[] {}, startTime);
					} else {
					
						CustomReporting.logReport("", "<b><i><font color='red'>",
								label + "</font></i></b> is  <b><i><font color='red'>" + value + "</font></i></b>  for Coverage <b><i><font color='red'>" + coverageName
										+ "</font></i></b> is not as expected",
								StepStatus.FAILURE, new String[] {}, startTime);
					}
				}
				if (label.contains("Additional Period in Years")) {
					
					if (value.equals("1")) {
					
						CustomReporting.logReport("", "<b><i><font color='green'>",
								label + "</font></i></b> is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
										+ "</font></i></b> is as expected",
								StepStatus.SUCCESS, new String[] {}, startTime);
					} else {
					
						CustomReporting.logReport("", "<b><i><font color='red'>",
								label + "</font></i></b> is <b><i><font color='red'> " + value + " </font></i></b> for Coverage <b><i><font color='red'> " + coverageName
										+ "</font></i></b> is not  as expected",
								StepStatus.FAILURE, new String[] {}, startTime);
					}
				}

				if (label.contains("ERP Coverage Status")) {
					if (value.equalsIgnoreCase(dataUmLogin.getData("ERPCoverageStatus"))) {
						
						CustomReporting.logReport("", "<b><i><font color='green'>",
								label + "</font></i></b> is <b><i><font color='green'> " + value + "</font></i></b>  for Coverage <b><i><font color='green'>" + coverageName
										+ "</font></i></b> is as expected",
								StepStatus.SUCCESS, new String[] {}, startTime);
					} else {
					
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


}
