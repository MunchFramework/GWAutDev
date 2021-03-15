package com.everest.page.application.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;

import com.everest.page.application.RemoveOptionalCovPage;
import com.everest.utility.CustomAbstractPage;
import com.everest.utility.CustomReporting;

public class RemoveOptionalCovPageImpl extends CustomAbstractPage implements RemoveOptionalCovPage  {
	@SuppressWarnings("static-access")
	@Override
	public void RemoveOptionalCov(String tcID, SoftAssert softAssert) throws Exception {

		PageData dataRemoveOptionalCov = PageDataManager.instance().getPageData("RemoveOptionalCov", tcID);
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(4000);
		
		_click(getElement(tabCoverages));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(5000);
		if(func._isVisible(getElement(tabOptionalCov))==false)
		{
			_click(getElement(tabCoverages));
			func._waitForPageToLoad(getWebDriver(), 50L);
			_wait(5000);
		}
		_click(getElement(tabOptionalCov));
		func._waitForPageToLoad(getWebDriver(), 50L);
		_wait(1000);
		
		long startTime = System.currentTimeMillis();
		String val = (dataRemoveOptionalCov.getData("CommonCoverages"));
	    
		if (!val.equals(""))
		{
			_wait(5000);
			_click(getElement(tabCommon));
    	    String values[] = val.split(";");
    	    int l = values.length;
    	    
    	    for (int i = 0;i<l;i++)
    	    		{
    	    String   targetxpath = "//*[contains(text(),\""+values[i]+"\")]/../div//following-sibling::div//input";
    		WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath)));
    		ele.click();
    	
//    		?String targetxpath2 = "[contains(text(),\""+values[i]+"\")";
 //   	if (getWebDriver().findElement(By.xpath(targetxpath2)).isDisplayed())
    		if(!(ele.isSelected()))
    	 {
	    	CustomReporting.logReport("","", "Removed the following coverage: "+values[i]+ " from Optional Coverages ", StepStatus.SUCCESS,new String[] { },startTime);
			}
		else
			{
			CustomReporting.logReport("","", "Unable to remove the following coverage: "+values[i]+ " from Optional Coverages ", StepStatus.FAILURE,new String[] { },startTime);
			
			} 
    		
		}
			}
	
    	  String val1 = (dataRemoveOptionalCov.getData("CRICoverages"));
    	    
    		if (!val1.equals(""))
    		{
    			
    			try {
					_click(getElement(tabCRI));
				} catch (Exception e) {
					WebElement elm = (WebElement)getElement(tabCRI).getNative();
					elm.click();
				}
        	    String values1[] = val1.split(";");
        	    int l1 = values1.length;
        	    
        	    for (int i = 0;i<l1;i++)
        	    		{
        	    String   targetxpath = "//*[contains(text(),\""+values1[i]+"\")]/../div//following-sibling::div//input";
        		WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath)));
        		ele.click();
//        		String targetxpath2 = "[contains(text(),\""+values1[i]+"\")";
 //       	if (getWebDriver().findElement(By.xpath(targetxpath2)).isDisplayed())
        		if(ele.isEnabled())
        	 {
    	    	CustomReporting.logReport("","", "Removed the following coverage: "+values1[i]+ " from Optional Coverages ", StepStatus.SUCCESS,new String[] { },startTime);
    			}
    		else
    			{
    			CustomReporting.logReport("","", "Unable to remove the following coverage: "+values1[i]+ " from Optional Coverages ", StepStatus.FAILURE,new String[] { },startTime);
    			
    			} 
        		
    		}
    		}
        String val2 = (dataRemoveOptionalCov.getData("DNOCoverages"));
        	    
        		if (!val2.equals(""))
        		{
        			
        			_click(getElement(tabDNO));
            	    String values2[] = val2.split(";");
            	    int l2 = values2.length;
            	    
            	    for (int i = 0;i<l2;i++)
            	    		{
            	    String   targetxpath = "//*[contains(text(),\""+values2[i]+"\")]/../div//following-sibling::div//input";
            		WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath)));
            		ele.click();
       //     		String targetxpath2 = "[contains(text(),\""+values2[i]+"\")";
            		if (ele.isEnabled())
            		{
        	    	CustomReporting.logReport("","", "Removed the following coverage: "+values2[i]+ " from Optional Coverages ", StepStatus.SUCCESS,new String[] { },startTime);
        			}
            		else
        			{
        			CustomReporting.logReport("","", "Unable to remove the following coverage: "+values2[i]+ " from Optional Coverages ", StepStatus.FAILURE,new String[] { },startTime);
        			
        			} 
            		
        		}
       	
	}
        		 String val3 = (dataRemoveOptionalCov.getData("EPLCoverages"));
         	    
         		if (!val3.equals(""))
         		{
         			
         			_click(getElement(tabEPL));
             	    String values3[] = val3.split(";");
             	    int l3 = values3.length;
             	    
             	    for (int i = 0;i<l3;i++)
             	    		{
             	    String   targetxpath = "//*[contains(text(),\""+values3[i]+"\")]/../div//following-sibling::div//input";
             		WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath)));
             		ele.click();
  //          		String targetxpath2 = "[contains(text(),\""+values3[i]+"\")";
             		if (ele.isEnabled())
             		{
         	    	CustomReporting.logReport("","", "Removed the following coverage: "+values3[i]+ " from Optional Coverages ", StepStatus.SUCCESS,new String[] { },startTime);
         			}
             		else
         			{
         			CustomReporting.logReport("","", "Unable to remove the following coverage: "+values3[i]+ " from Optional Coverages ", StepStatus.FAILURE,new String[] { },startTime);
         			
         			} 
             		
         		}
         
 		
 		
 	}
	}

	
	}
