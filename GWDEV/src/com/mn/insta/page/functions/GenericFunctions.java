
package com.mn.insta.page.functions;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import org.xframium.device.DeviceManager;
import org.xframium.device.ng.AbstractSeleniumTest;
import org.xframium.page.StepStatus;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.Element;
import org.xframium.page.element.Element.WAIT_FOR;

import com.auxilii.msgparser.Message;
import com.auxilii.msgparser.MsgParser;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.mn.insta.page.utility.CustomReporting;
import com.mn.insta.page.utility.GlobalVariableContainer;

public class GenericFunctions extends AbstractSeleniumTest {
	// KeyWordPageImpl

	private String strTokenName;
	private String strTokenValue;
	private FileInputStream pic = null;
	private String screenShotWordDocPath = "";
	private XWPFDocument doc = null;
	private XWPFParagraph p = null;
	private XWPFRun r = null;
	private String reqScreens = "";

	private static GenericFunctions singleton = new GenericFunctions();

	private GenericFunctions() {

	}
	
	public String  generate_RandomNumber (int Digits) 
	{
		long timeStamp = System.nanoTime(); // to get the current date time value
		
		double randomNum= Math.random() * 1000; // random number generation
		
		long midSeed = (long) (timeStamp * randomNum);
		// mixing up the time and random number. variable timeStamp will be unique variable random will ensure no relation between the numbers
		String s = midSeed + "";
		String subStr = s.substring(0, Digits);
		
		//int finalSeed = Integer.parseInt(subStr);
		
		System.out.println(subStr);
		return subStr;
	}
	
	public String dateFormat(String date,String type,String Format)	{
		String newDate=null;
		String strDay="";
		String strMonth="";
		try {

			if(type.equalsIgnoreCase("Add"))
			{
				 strDay=date.split("/")[0];
				if(strDay.length()==1)
				{
					strDay="0"+strDay;
				}
				strMonth=date.split("/")[1];
				if(strMonth.length()==1)
				{
					strMonth="0"+strMonth;
				}
			}
			if(type.equalsIgnoreCase("Sub"))
			{
				 strDay=date.split("/")[0];
				if((strDay.length()==2) && strDay.substring(0, 1).equals("0"))
				{
					strDay=strDay.replace("0", "");
				}
				strMonth=date.split("/")[1];
				if((strMonth.length()==2) && strMonth.substring(0, 1).equals("0"))
				{
					strMonth=strMonth.replace("0", "");;
				}
			}
			if(Format.equalsIgnoreCase("Month"))
			{
			newDate=strMonth+"/"+strDay+"/"+date.split("/")[2];	
			}
			if(Format.equalsIgnoreCase("Day"))
			{
			newDate=strDay+"/"+strMonth+"/"+date.split("/")[2];	
			}
		    
		} catch (Exception e) {
			e.printStackTrace();
            
        }
		
		return newDate;
	}
	
	public boolean _isChecked(Element element)
	{

		
		WebElement ele = (WebElement) element.getNative();
		
		String isDisabled = ele.getAttribute("checked");
		if (isDisabled==null)
			return false;
		else
			return true;
			
			
	}
	
	
     
	
	public List<String> _getValueDropDownBoxAslist(Element element)
	{
		
		WebElement elm = (WebElement) element.getNative();
		Select select=new Select (elm);
		List<String> values = new ArrayList<String>();
		List <WebElement> options=select.getOptions();
		for (WebElement option : options) 
		{
			values.add(option.getText().trim());
		}
		return values;
	}

	public static GenericFunctions instance() {
		return singleton;
	}

	/*******************************************************************
	 * Name : getCustumWebDriver Description : Used to get the webDriver Object
	 * Modification Log : Date Initials Description of Modifications
	 ********************************************************************/
	public WebDriver getCustumWebDriver() {
		return getWebDriver();

		// return CustomFunctions.instance().getCustumWebDriver();

	}

	/*******************************************************************
	 * Name : getCustomPageName Description : Used to get the name of the page
	 * Modification Log : Date Initials Description of Modifications
	 ********************************************************************/
	public String getCustomPageName() {
		// return
		// PageManager.instance().getPageCache().toString().split("Impl")[0].split("spi.")[1];
		return this.strTokenValue;
		// return cFun.getCustomPageName();
	}

	/*******************************************************************
	 * Name : getCustomElementName Description : Used to get the name of the element
	 * Modification Log : Date Initials Description of Modifications
	 ********************************************************************/

	public String getCustomElementName(Element el) {

		return CustomFunctions.instance().getCustomElementName(el, this.strTokenValue);

	}

	/*******************************************************************
	 * Name : _setGlobalToken Description : Used to set the token value in global
	 * scope and _addToken function will called before every function Modification
	 * Log : Date Initials Description of Modifications
	 ********************************************************************/
	public void _setGlobalToken(String strTokenName, String strTokenValue) {
		this.strTokenName = strTokenName;
		this.strTokenValue = strTokenValue;
	}

	/*******************************************************************
	 * Name : _addToken Description : Used to to add the token value to an object in
	 * action Modification Log : Date Initials Description of Modifications
	 ********************************************************************/
	public void _addToken(Element element) {
		element.addToken(this.strTokenName, this.strTokenValue);
	}

	/*******************************************************************
	 * Name : _addToGlobalVariableList Description : Used to add global variable to
	 * HashMap Parameters : strKey - Key Value : strValue - Value Modification Log :
	 * Date Initials Description of Modifications
	 ********************************************************************/
	public void _addToGlobalVariableList(String strKey, String strValue) {
		GlobalVariableContainer.instance().addVariable(strKey, strValue);
	}

	/*******************************************************************
	 * Name : _addToGlobalVariableList Description : Used to get global variable
	 * value from HashMap Parameters : strKey - Key Value Modification Log : Date
	 * Initials Description of Modifications
	 ********************************************************************/
	public String _getGlobalVariableValue(String strKey) {
		return GlobalVariableContainer.instance().getVariable(strKey);
	}

	/*******************************************************************
	 * Name : _setValue Description : Used to set the value to any object, Only when
	 * there is data in DB Modification Log : Date Initials Description of
	 * Modifications
	 ********************************************************************/
	public void _setValue(Element element, String strValue) {

		long startTime = System.currentTimeMillis();
		try {
			if (!(strValue.isEmpty())) {
				element.setValue(strValue);
				// WebElement elm = (WebElement) element.getNative();
				// elm.sendKeys(Keys.TAB);
			}

		} catch (Exception ex) {
			// CustomReporting.logReport(keywordPage.getPageName(),element.getNative().toString(),"setValue","",StepStatus.FAILURE,new
			// String[] { strValue },startTime,ex);

			CustomReporting.logReport(getCustomPageName(), getCustomElementName(element), "setValue", "",
					StepStatus.FAILURE, new String[] { strValue }, startTime, ex);
			throw ex;
			/* throw ex; */

		}
	}
	
		
	public void _record_PageLoadTime(WebDriver driver, Long timeOutInSeconds) {
	    
	    long startTime = System.currentTimeMillis();
	    long elapsedTime=0L;
	    ExpectedCondition < Boolean > pageLoad = new
	                        ExpectedCondition < Boolean > () {
	                            public Boolean apply(WebDriver driver) {
	                                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	                            }
	                        };
	                        
	                        Wait < WebDriver > wait = new WebDriverWait(driver, timeOutInSeconds);
	                        try {
	                            wait.until(pageLoad);
	                            elapsedTime = (new Date()).getTime() - startTime;
	                            //CustomReporting.logReport("","", "Time taken to load the page: "+getCustomPageName()+" is "+elapsedTime +" ms",StepStatus.SUCCESS,new String[] { },startTime);
	                            CustomReporting.logReport("Time taken to load the page: "+getCustomPageName()+" is "+elapsedTime +" ms");
	                        } catch (Exception ex) {
	                                    
	                            //CustomReporting.logReport("","", "Timeout during page load","", StepStatus.FAILURE,
	                                                                                    //new String[] {  }, startTime, ex);
	                            System.out.println(ex);
	                        }
	    
	}
	
	/*******************************************************************
	*	Name              :	_validateDropdownValues
	*	Description       : Used to validate values of a dropdown against given list of values
	*	 
	********************************************************************/
	public boolean _validateDropdownValues(Element dropDownElement,List<String> expOptions,boolean bOrder,boolean bIgnoreCase, SoftAssert assertSoft)
	{
		long startTime = System.currentTimeMillis();
		boolean success = false;
	    try
	    {
	    	Select sel= new Select((WebElement) dropDownElement.getNative());
	    	
	    	List<WebElement> options= sel.getOptions();
	    	
	    	List<String> expected= new ArrayList<String>();
	    	List<String> actual= new ArrayList<String>();
	    	//get actual values and convert to upper case if comparison is not case sensitive
		    for (WebElement option : options) 
		    {
		    	
		    	if(bIgnoreCase)
		    		actual.add(option.getText().toUpperCase().trim());
		    	else 
		    		actual.add(option.getText().trim());	    	

	    	}
		    //get expected values and convert to upper case if comparison is not case sensitive
		    for(String option: expOptions)
		    {
		    	if(bIgnoreCase)
		    		expected.add(option.toUpperCase().trim());
		    	else 
		    		expected.add(option.trim());
		    }
		    //sort the values if order is not matter in comparison
		    if(!bOrder)
		    {
		    	Collections.sort(actual);
		    	Collections .sort(expected);
		    }
		    //compare expected vs actual
		    	
		    if(actual.equals(expected))
	    	{
	    		success=true;
	    		CustomReporting.logReport(getCustomPageName(), getCustomElementName(dropDownElement),"Expected values :"+expected.toString(),StepStatus.SUCCESS,new String[] {expected.toString(),actual.toString()},startTime);
	    	}
	    	else
	    	{
	    		CustomReporting.logReport(getCustomPageName(), getCustomElementName(dropDownElement),"Expected values : "+expected.toString()+" Actual values: "+actual.toString(),StepStatus.FAILURE,new String[] {expected.toString(),actual.toString()},startTime);
	    	}
	    		
	    } catch(Exception ex)
	    {
	    	CustomReporting.logReport(getCustomPageName(), getCustomElementName(dropDownElement),"dropdown","",StepStatus.FAILURE,new String[] {},startTime,ex);
        	throw ex;
	    	
	    }  
	    
	    finally {
	        assertSoft.assertEquals(success, true);
		}
		return success;
	}


	public void _sendkeys(Element element, String strValue) {

		long startTime = System.currentTimeMillis();
		try {
			if (!(strValue.isEmpty())) {
				element.setValue(strValue);

				// WebElement elm = (WebElement) element.getNative();
				// //elm.sendKeys(Keys.TAB);
				// elm.sendKeys("HORTON GROUP INC THE");

			}

		} catch (Exception ex) {
			// CustomReporting.logReport(keywordPage.getPageName(),element.getNative().toString(),"setValue","",StepStatus.FAILURE,new
			// String[] { strValue },startTime,ex);

			CustomReporting.logReport(getCustomPageName(), getCustomElementName(element), "setValue", "",
					StepStatus.FAILURE, new String[] { strValue }, startTime, ex);
			throw ex;
			/* throw ex; */

		}
	}

	/*******************************************************************
	 * Name : _setValueByIndexInDropdown Description : Used to select the dropdown
	 * values based on index
	 * 
	 ********************************************************************/
	public void _setValueByIndexInDropdown(Element element, int index) {
		long startTime = System.currentTimeMillis();
		try {
			Select sel = new Select((WebElement) element.getNative());
			sel.selectByIndex(index - 1);
			CustomReporting.logReport(getCustomPageName(), getCustomElementName(element), "setValue",
					StepStatus.SUCCESS, new String[] { index + "" }, startTime);
		} catch (Exception ex) {

			CustomReporting.logReport(getCustomPageName(), getCustomElementName(element), "setValue", "",
					StepStatus.FAILURE, new String[] { index + "" }, startTime, ex);
			throw ex;

		}
	}

	/*******************************************************************
	 * Name : _checkDefaultValue Description : Used to compare the attribute value
	 * of an object Modification Log : Date Initials Description of Modifications
	 ********************************************************************/
	public void _checkDefaultValue(Element element, String strAttribute, String strExpValue) {
		String strActValue;
		long startTime = System.currentTimeMillis();

		// Get the Attribute value

		if (strAttribute.equalsIgnoreCase("TEXT")) {
			WebElement ele = (WebElement) element.getNative();
			strActValue = ele.getText().trim();
		} else {
			strActValue = element.getAttribute(strAttribute);
		}

		// Compare the value
		if (!strActValue.equals(strExpValue)) {

			// CustomReporting.logReport(getCustomPageName(), element.toString(), "_label",
			// "", StepStatus.FAILURE,
			// new String[] {}, startTime, null);

			CustomReporting.logReport("", "",
					"Expected value: " + strExpValue + " does not match with the actual value: " + strActValue, "",
					StepStatus.FAILURE, new String[] {}, startTime, null);
			throw new RuntimeException();
		} else {
			CustomReporting.logReport("", "",
					"Expected value: " + strExpValue + " matches with the actual value: " + strActValue,
					StepStatus.SUCCESS, new String[] {}, startTime);
		}

		// assertSoft.assertEquals(strExpValue, strActValue);
	}

	/*******************************************************************
	 * Name : _click Description : Used to click any type of object Modification Log
	 * : Date Initials Description of Modifications
	 ********************************************************************/
	public void _click(Element element) {
		// element.click();

		long startTime = System.currentTimeMillis();
		try {

			element.click();
		

		} catch (Exception ex) {

			throw ex;

		}

	}

	/*******************************************************************
	 * Name : _clickXY Description : Used to click any type of object based of its
	 * x,y coordinates Log : Date Initials Description of Modifications
	 * 
	 * @throws Exception
	 ********************************************************************/
	public void _clickXY(int x, int y) throws Exception {
		long startTime = System.currentTimeMillis();
		try {
			Robot bot = new Robot();
			bot.mouseMove(x, y);
			bot.mousePress(InputEvent.BUTTON1_MASK);
			bot.mouseRelease(InputEvent.BUTTON1_MASK);

			CustomReporting.logReport(getCustomPageName(), "Coordinates(" + x + "," + y + ")", "click",
					StepStatus.SUCCESS, new String[] {}, startTime);
		} catch (Exception ex) {

			CustomReporting.logReport(getCustomPageName(), "Coordinates(" + x + "," + y + ")", "click", "",
					StepStatus.FAILURE, new String[] {}, startTime, ex);
			throw ex;

		}
	}

	/*******************************************************************
	 * Name : _getRelativeDate Description : Used to get the relative date wrt
	 * current date Modification Log : Date Initials Description of Modifications
	 * 
	 * @return
	 ********************************************************************/
	public String _getRelativeDate(String strRelation, String intDays, String intMonths, String intYears) {
		DateFormat dateFormate = new SimpleDateFormat("MM/dd/yyyy");
		Date dateTodays = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateTodays);

		if (intDays.isEmpty())
			intDays = "0";

		if (intMonths.isEmpty())
			intMonths = "0";

		if (intYears.isEmpty())
			intYears = "0";

		switch (strRelation.toUpperCase()) {
		case "PAST":
			cal.add(Calendar.DATE, -Integer.parseInt(intDays));
			cal.add(Calendar.MONTH, -Integer.parseInt(intMonths));
			cal.add(Calendar.YEAR, -Integer.parseInt(intYears));
			break;
		case "FUTURE":
			cal.add(Calendar.DATE, Integer.parseInt(intDays));
			cal.add(Calendar.MONTH, Integer.parseInt(intMonths));
			cal.add(Calendar.YEAR, Integer.parseInt(intYears));
			break;

		default:
			break;

		}

		return dateFormate.format(cal.getTime());
	}

	/*******************************************************************
	 * Name : _getRandomString Description : Used to get the relative date wrt
	 * current date Modification Log : Date Initials Description of Modifications
	 * 
	 * @return
	 ********************************************************************/
	public enum DATATYPE {
		number, varchar, character;
	}

	public String _getRandomString(DATATYPE type, int length) {
		String strType = type.toString();
		String defaultString = "";

		if (!strType.equalsIgnoreCase("number"))
			defaultString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		if (!strType.equalsIgnoreCase("character"))
			defaultString = defaultString + "0123456789";

		StringBuilder strCh = new StringBuilder();
		Random rnd = new Random();

		for (int i = 0; i < length; i++)
			strCh.append(defaultString.charAt(rnd.nextInt(defaultString.length())));

		return strCh.toString();
	}

	/*******************************************************************
	 * Name : _alertHandler Description : Used to handle pop-up which comes up
	 * during execution Modification Log : Date Initials Description of
	 * Modifications
	 * 
	 * @return
	 ********************************************************************/
	public void _alertHandler(WebDriver driver, String strOperation) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 300);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			// Accept or dismiss the alert
			switch (strOperation.toUpperCase()) {
			case "OK":
				alert.accept();
				driver.switchTo().defaultContent();
				log.info("Clicked on OK Button successfully");
				break;
			case "CANCEL":
				alert.dismiss();
				driver.switchTo().defaultContent();
				log.info("Clicked on CANCEL Button successfully");
				break;

			default:
				System.out.println("Pass the correct data either as 'OK' or 'CANCEL'");
				// Need to add custom report log and fail the test if needed
				System.exit(1);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*******************************************************************
	 * Name : _closeWindow Description : Used to close popup windows which comes up
	 * during execution Modification Log : Date Initials Description of
	 * Modifications
	 * 
	 * @return
	 ********************************************************************/
	public void _closeWindow(WebDriver driver) {
		String parentWindow = driver.getWindowHandle();

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}

	/*******************************************************************
	 * Name : _handleIMSecurityAlert Description : Used to handle windows
	 * authentication popup which comes up on clicking Alliance URL Modification Log
	 * : Date Initials Description of Modifications
	 * 
	 * @return
	 ********************************************************************/
	public void _handleIMSecurityAlert() throws InterruptedException {
		WebDriver driver = getCustumWebDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());

		driver.switchTo().alert().authenticateUsing(new UserAndPassword("UserId", "Password"));
		driver.switchTo().defaultContent();
	}

	/*******************************************************************
	 * Name : _compareSubStringCaseSensitive Description : Used to compare sub
	 * string with case sensitive Modification Log : Date Initials Description of
	 * Modifications
	 * 
	 * @return
	 ********************************************************************/
	public boolean _compareSubStringCaseSensitive(String strChar, String strSearchChar) {
		Boolean blnCondition = false;

		if (StringUtils.contains(strChar, strSearchChar)) {
			blnCondition = true;
		}

		return blnCondition;
	}

	/*******************************************************************
	 * Name : _compareSubStringIgnorecase Description : Used to compare sub string
	 * with Ignore Case Modification Log : Date Initials Description of
	 * Modifications
	 * 
	 * @return
	 ********************************************************************/
	public boolean _compareSubStringIgnorecase(String strChar, String strSearchChar) {
		boolean blnCondition = false;

		if (StringUtils.containsIgnoreCase(strChar, strSearchChar)) {
			blnCondition = true;
		}

		return blnCondition;
	}

	/*******************************************************************
	 * Name : _compareStringCaseSensitive Description : Used to compare strings with
	 * Case sensitive Modification Log : Date Initials Description of Modifications
	 * 
	 * @return
	 ********************************************************************/
	public boolean _compareStringCaseSensitive(String strChar, String strSearchChar) {
		Boolean blnCondition = false;

		if (strChar.equals(strSearchChar)) {
			blnCondition = true;
		}
		return blnCondition;
	}

	/*******************************************************************
	 * Name : _compareStringIgnorecase Description : Used to compare strings with
	 * Ignore Case Modification Log : Date Initials Description of Modifications
	 * 
	 * @return
	 ********************************************************************/
	public boolean _compareStringIgnorecase(String strChar, String strSearchChar) {
		boolean blnCondition = false;

		if (strChar.equalsIgnoreCase(strSearchChar)) {
			blnCondition = true;
			CustomReporting.logReport("", "", "Both Values Match as Expected. Value1 : "+strChar+" Value2 : "+strSearchChar, StepStatus.SUCCESS, System.currentTimeMillis());

		}
		else
		{
			CustomReporting.logReport("", "", "Both Values Doe NOT Match as Expected. Value1 : "+strChar+" Value2 : "+strSearchChar, StepStatus.FAILURE, System.currentTimeMillis());

		}

		return blnCondition;
	}

	/*******************************************************************
	 * Name : _splitDatabyPosition Description : Used to split and return the data
	 * by position Modification Log : Date Initials Description of Modifications
	 * 
	 * @return
	 ********************************************************************/

	public String _splitDatabyPosition(String strChar, int intStartPosition, int intEndPosition) {
		String strData = null;
		strData = strChar.substring(intStartPosition, intEndPosition);
		return strData;

	}

	/*******************************************************************
	 * Name : _splitDatabyDelimiter Description : Used to split the data by
	 * delimiter and return the data as an array Modification Log : Date Initials
	 * Description of Modifications
	 * 
	 * @return
	 ********************************************************************/

	public String[] _splitDatabyDelimiter(String strChar, String strDelimiter) {
		String[] strData;
		strData = strChar.split(strDelimiter);
		return strData;

	}

	/*******************************************************************
	 * Name : _getAttributeValue Description : Used to retrieve the data from
	 * application either by innerHTML or Value Modification Log : Date Initials
	 * Description of Modifications
	 * 
	 * @return
	 ********************************************************************/

	public String _getAttributeValue(Element element, String strAttribute) {
		String strActValue = null;
		try {
			if (_isVisible(element)) {
				// Get the Attribute value
				if (strAttribute.equalsIgnoreCase("TEXT")) {
					WebElement ele = (WebElement) element.getNative();
					if (ele.getTagName().equalsIgnoreCase("select")) {
						Select sel = new Select(ele);
						strActValue = sel.getFirstSelectedOption().getText().trim();
					} else {
						strActValue = ele.getText().trim();
					}

				} else {
					strActValue = element.getAttribute(strAttribute).trim();
				}

				// String strApplicationValue = null;
				// Get the Attribute value
				// strApplicationValue = element.getAttribute(strAttribute);
				// return strActValue;
			}
		}

		catch (Exception ex) {
			return strActValue;
		}
		return strActValue;

	}

	/*******************************************************************
	 * Name : _takeBrowserScreenShot Description : Used to take screen shot of the
	 * WebDriver and save in word document Modification Log : Date Initials
	 * Description of Modifications
	 * 
	 * @return
	 ********************************************************************/

	public void _takeBrowserScreenShot(WebDriver driver, String strOperation, String strTextEntry, String docName) {
		try {

			switch (strOperation.toUpperCase()) {
			case "START":
				doc = new XWPFDocument();
				p = doc.createParagraph();
				r = p.createRun();
				reqScreens = "Screenshots Initiated";
				log.info("Taking screenshot initiated");
				break;
			case "PRINT":
				if (reqScreens.equalsIgnoreCase("Screenshots Initiated")) {
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					pic = new FileInputStream(scrFile);

					r.addBreak();
					r.setText(strTextEntry);
					r.addBreak();
					r.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, "", Units.toEMU(400), Units.toEMU(300));
					r.addBreak();

					log.info("Screenshot taken successfully");
				}
				break;
			case "FINISH":
				if (reqScreens.equalsIgnoreCase("Screenshots Initiated")) {
					String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
					String strTCID = docName; // added for qTest
					String docname = docName + "_" + timeStamp;
					screenShotWordDocPath = DeviceManager.instance().getConfigurationProperties()
							.getProperty("screenshot.path") + "\\" + docname + ".docx";
					FileOutputStream out = new FileOutputStream(screenShotWordDocPath);
					doc.write(out);
					out.close();
					pic.close();
					GenericFunctions.instance()._addToGlobalVariableList(strTCID, docname); // added for qTest
					log.info("Screenshot saved successfully");
					CustomReporting.instance().logReport(
							"<a href=\"" + screenShotWordDocPath + "\"" + ">Click here to view screenprints</a>");
				}
				break;

			default:
				System.out.println("Please pass the correct operation string");
				// System.exit(1);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*******************************************************************
	 * Name : _takeScreenShot Description : Used to take screen shot of the Desktop
	 * and save in word document Modification Log : Date Initials Description of
	 * Modifications
	 * 
	 * @return
	 ********************************************************************/
	public void _takeScreenShot(WebDriver driver, String strOperation, String strTextEntry, String docName) {
		try {

			switch (strOperation.toUpperCase()) {
			case "START":
				doc = new XWPFDocument();
				p = doc.createParagraph();
				r = p.createRun();
				reqScreens = "Screenshots Initiated";
				log.info("Taking screenshot initiated");
				break;
			case "PRINT":
				if (reqScreens.equalsIgnoreCase("Screenshots Initiated")) {

					log.info("Screenshot taken successfully");

					Rectangle captureSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
					Robot robot = new Robot();
					BufferedImage bufferedImage = robot.createScreenCapture(captureSize);
					// pic = new FileInputStream(bufferedImage);
					ByteArrayOutputStream os = new ByteArrayOutputStream();

					ImageIO.write(bufferedImage, "PNG", os);
					InputStream is = new ByteArrayInputStream(os.toByteArray());

					r.addBreak();
					r.setText(strTextEntry);
					r.addBreak();
					r.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, "", Units.toEMU(400), Units.toEMU(300));

					r.addBreak();
				}
				break;
			case "FINISH":
				if (reqScreens.equalsIgnoreCase("Screenshots Initiated")) {
					String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
					String strTCID = docName; // added for qTest
					String docname = docName + "_" + timeStamp;
					screenShotWordDocPath = DeviceManager.instance().getConfigurationProperties()
							.getProperty("screenshot.path") + "\\" + docname + ".docx";
					FileOutputStream out = new FileOutputStream(screenShotWordDocPath);
					doc.write(out);
					out.close();
					// pic.close();
					GenericFunctions.instance()._addToGlobalVariableList(strTCID, docname); // added for qTest
					log.info("Screenshot saved successfully");
					// CustomReporting.instance().logInfo("Screenshot: ", " ","", "<a href=\"" +
					// screenShotWordDocPath + "\"" + ">Click here to view screenprints</a>");
					CustomReporting.instance().logReport(
							"<a href=\"" + screenShotWordDocPath + "\"" + ">Click here to view screenprints</a>");
				}
				break;

			default:
				System.out.println("Please pass the correct operation string");
				// System.exit(1);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*******************************************************************
	 * Name : _uploadFile Description : Used to upload files
	 * 
	 ********************************************************************/
	public void _uploadFile(String FilePath) {
		long startTime = System.currentTimeMillis();
		try {

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			StringSelection ss = new StringSelection(FilePath);
			clipboard.setContents(ss, ss);
			String result = (String) clipboard.getData(DataFlavor.stringFlavor);
			System.out.println("string from the clipboard " + result);
			Thread.sleep(5000);

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_N);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(8000);

			CustomReporting.logReport("", "", "File uploaded successfully", StepStatus.SUCCESS, new String[] {},
					startTime);
		} catch (Exception ex) {
			CustomReporting.logReport("", "", "File upload failed", "", StepStatus.FAILURE, new String[] {}, startTime,
					ex);
			System.out.println(ex);
		}
	}

	/*******************************************************************
	 * Name : _launchOutlook Description : Used to launch Outlook
	 * 
	 ********************************************************************/
	public void _launchOutlook() throws URISyntaxException {
		try {
			// Desktop.getDesktop().mail( new URI(
			// "mailto:javaexamplecenter@gmail.com?subject=Test%20message" ) );
			// Desktop.getDesktop().mail( );
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Microsoft Office\\Office14\\OUTLOOK.exe");
		} catch (IOException ex) {
		}
	}

	/*******************************************************************
	 * Name : _closeOutlook Description : Used to close Outlook
	 * 
	 ********************************************************************/
	public void _closeOutlook() throws URISyntaxException {
		try {
			// Desktop.getDesktop().mail( new URI(
			// "mailto:javaexamplecenter@gmail.com?subject=Test%20message" ) );
			// Desktop.getDesktop().mail( );
			// Runtime.getRuntime().exec("C:\\Program Files (x86)\\Microsoft
			// Office\\Office14\\OUTLOOK.exe");
			Runtime.getRuntime().exec("taskkill /F /IM OUTLOOK.EXE");
		} catch (IOException ex) {
		}
	}

	/*******************************************************************
	 * Name : _writeToExcel Description : Used for writing data to Excel
	 * 
	 * 
	 ********************************************************************/
	public void _writeToExcel(String Sheetname, String strColName, String strVal, String strTCID) {
		long startTime = System.currentTimeMillis();
		try {
			

			String writeExcelPath = DeviceManager.instance().getConfigurationProperties().getProperty("data.path");
			FileInputStream file = new FileInputStream(new File(writeExcelPath));

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(Sheetname);
			int intRow = findExcelRow(sheet, strTCID);
			int intCol = findExcelCol(sheet, strColName);
			sheet.getRow(intRow).createCell(intCol).setCellValue(strVal);

			FileOutputStream outFile = new FileOutputStream(new File(writeExcelPath));
			workbook.write(outFile);
			if (workbook != null) {
				workbook.close();
			}
			file.close();
			outFile.close();
			CustomReporting.logReport("", "", strVal + " : written to Excel Successfully", StepStatus.SUCCESS,
					new String[] {}, startTime);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			CustomReporting.logReport("", "", strVal + " : writing to Excel failed", "", StepStatus.FAILURE,
					new String[] {}, startTime, e);

		} catch (IOException e) {
			e.printStackTrace();
			CustomReporting.logReport("", "", strVal + " : writing to Excel failed", "", StepStatus.FAILURE,
					new String[] {}, startTime, e);

		}

	}
	
	public boolean _isReadOnly(Element element)
	{

		
		WebElement ele = (WebElement) element.getNative();
		
		String isDisabled = ele.getAttribute("readonly");
		if (isDisabled==null)
			return false;
		else
			return true;
			
			
	}

	public int findExcelCol(XSSFSheet sheet, String strColName) {
		int colNum = 0;
		try {

			String colVal = sheet.getRow(0).getCell(colNum).getStringCellValue();

			while (!colVal.isEmpty()) {
				if (colVal.equalsIgnoreCase(strColName)) {
					break;
				} else {
					colNum = colNum + 1;
					colVal = sheet.getRow(0).getCell(colNum).getStringCellValue();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return colNum;
	}

	public int findExcelRow(XSSFSheet sheet, String strTCID) {
		int intRowNum = 0;
		try {

			int numRow = sheet.getLastRowNum();

			for (int i = 0; i <= numRow; i++) {

				String cellVal = sheet.getRow(i).getCell(0).getStringCellValue();
				if (!cellVal.isEmpty() && cellVal.contains(strTCID)) {
					break;
				} else {
					intRowNum = intRowNum + 1;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return intRowNum;
	}

	public int findExcelRow(XSSFSheet sheet, String strTCID, int colNum) {
		int intRowNum = 0;
		try {

			int numRow = sheet.getLastRowNum();

			for (int i = 0; i <= numRow; i++) {

				String cellVal = sheet.getRow(i).getCell(colNum).getStringCellValue();
				if (!cellVal.isEmpty() && cellVal.contains(strTCID)) {
					break;
				} else {
					intRowNum = intRowNum + 1;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return intRowNum;
	}

	/*******************************************************************
	 * Name : _isVisible Description : Used to check if the object is displayed on
	 * the screen
	 * 
	 ********************************************************************/
	public boolean _isVisible(Element element) {

		boolean success = false;
		getCustumWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		try {
			WebElement ele = (WebElement) element.getNative();
			success = ele.isDisplayed();
			return success;

		} catch (Exception ex) {
			return success;
		} finally {
			getCustumWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	/*******************************************************************
	 * Name : _switchWindows Description : Used for switching to windows
	 * 
	 ********************************************************************/
	public boolean _switchWindows(WebDriver driver, String strswitchOption, String switchExpValue) {
		boolean bolSwitchWindow = false;
		try {

			switch (strswitchOption.toUpperCase()) {
			case "BY_WINTITLE":
				bolSwitchWindow = verifySwitchWindow(driver, strswitchOption, switchExpValue);
				break;
			case "BY_WINURL":
				bolSwitchWindow = verifySwitchWindow(driver, strswitchOption, switchExpValue);
				break;
			case "BY_WINID":
				bolSwitchWindow = verifySwitchWindow(driver, strswitchOption, switchExpValue);
				break;
			case "BY_FRAME":
				driver.switchTo().frame(switchExpValue);
				/*
				 * default: System.out.println("Please pass the correct operation string"); //
				 * System.exit(1);
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bolSwitchWindow;

	}

	private boolean verifySwitchWindow(WebDriver webDriver, String byTitleOrUrl, String winExpValue) {

		boolean bSwitchWindow = false;
		String winActValue = "";
		Set<String> availableWindows = webDriver.getWindowHandles();
		System.out.println("Total available windows: " + availableWindows.size());

		if (!availableWindows.isEmpty()) {
			for (String windowId : availableWindows) {
				if (byTitleOrUrl.equalsIgnoreCase("BY_WINTITLE")) {
					winActValue = webDriver.switchTo().window(windowId).getTitle().trim().toLowerCase();
				} else if (byTitleOrUrl.equalsIgnoreCase("BY_WINURL")) {
					winActValue = webDriver.switchTo().window(windowId).getCurrentUrl().trim().toLowerCase();
				} else {
					webDriver.switchTo().window(windowId);
					winActValue = windowId;
				}

				winExpValue = winExpValue.trim().toLowerCase();

				if (winActValue.contains(winExpValue)) {
					bSwitchWindow = true;
					System.out.println("Switched to window-" + winExpValue);
					break;
				} else {
					bSwitchWindow = true;
					System.out.println("Switched to window id - " + windowId);

				}
			}
		}

		return bSwitchWindow;
	}

	/*******************************************************************
	 * Name : _getValueDropDownBox Description : Used to set the value to any
	 * object, Only when there is data in DB
	 * 
	 ********************************************************************/
	public String[] _getValueDropDownBox(Element element) {

		WebElement elm = (WebElement) element.getNative();
		Select select = new Select(elm);

		List<WebElement> options = select.getOptions();
		String[] values = new String[options.size()];
		int i = 0;
		for (WebElement option : options) {
			values[i] = option.getText();
			i++;
		}
		return values;
	}
	

	public File getLastModifiedFile(String srcpath,String FileName) throws Exception {
  		long startTime = System.currentTimeMillis();
 		try {
 			
 			 File dir = new File(srcpath);
 			    File[] files = dir.listFiles();
 			    Arrays.sort(files, new Comparator<File>(){
 			        public int compare(File f1, File f2) {
 			          return Long.valueOf(f2.lastModified()).compareTo(f1.lastModified());
 			        } 
 			      });
 			    if (files == null || files.length == 0) {
 			    	return null;
 			    }

 			    File lastModifiedFile = files[0];
 			
 			    
 			    /*for (int i = 1; i < files.length; i++) {
 			       if (lastModifiedFile.lastModified() > files[i].lastModified())
 			       	 {
 			    	   lastModifiedFilePath = files[i];
 			    	   break;
 			       	 }
 			       else
 			       {
 			    	   lastModifiedFilePath = files[i];    
 			      
 			       }
 			    }*/
 			    CustomReporting.logReport("", "", "Successfully get the latest file from the folder " + srcpath, StepStatus.SUCCESS, new String[] {},
 						startTime);
 			   
 				return lastModifiedFile;
 		} 
  		catch (Exception ex) {
 			CustomReporting.logReport("", "", "Failed to get the latest updated file in the directory "+ srcpath,"", StepStatus.FAILURE, new String[] {}, startTime,ex);
 			throw ex;
 		}

 	}

public boolean _verifyPDFDocument(String strFilepath,String reqTextInPDF) {
		
		long startTime = System.currentTimeMillis();
		boolean isTextFound=false;
		String parsedText="";
		try {

			PdfReader readertext = new PdfReader(strFilepath);
			PdfReaderContentParser parser = new PdfReaderContentParser(readertext);
			TextExtractionStrategy strategy = null;
			for(int i = 1; i <= readertext.getNumberOfPages(); i++) {
		    	strategy = parser.processContent(i,new SimpleTextExtractionStrategy());
		        parsedText = parsedText+strategy.getResultantText();
			}
			System.out.println(parsedText);
			     
		      if(parsedText.contains(reqTextInPDF)) {
		    	  isTextFound=true;
		    	  CustomReporting.logReport("","", "Given text: "+reqTextInPDF+" - is present in the the given PDF document",StepStatus.SUCCESS,new String[] { },startTime);
				}
		      else 
		      {
		    	  CustomReporting.logReport("","", "Given text: "+reqTextInPDF+" - is not present in the the given PDF document","", StepStatus.FAILURE,
		  					new String[] {  }, startTime, null);
		        	 
		      }
		      
		      //Closing the document
		      //document.close();
		      readertext.close();
			
		}
		catch(Exception ex) 
		{
			try
			{
				PdfReader readertext = new PdfReader(strFilepath);
				PdfReaderContentParser parser = new PdfReaderContentParser(readertext);
				TextExtractionStrategy strategy = null;
				for(int i = 1; i <= readertext.getNumberOfPages(); i++) {
			    	strategy = parser.processContent(i,new SimpleTextExtractionStrategy());
			        parsedText = parsedText+strategy.getResultantText();
				}
				System.out.println(parsedText);
				     
			      if(parsedText.contains(reqTextInPDF)) {
			    	  isTextFound=true;
			    	  CustomReporting.logReport("","", "Given text: "+reqTextInPDF+" - is present in the the given PDF document",StepStatus.SUCCESS,new String[] { },startTime);
					}
			      else 
			      {
			    	  CustomReporting.logReport("","", "Given text: "+reqTextInPDF+" - is not present in the the given PDF document","", StepStatus.FAILURE,
			  					new String[] {  }, startTime, null);
			        	 
			      }
			      
			      //Closing the document
			      //document.close();
			      readertext.close();
			}
			catch(Exception e) 
			{
				CustomReporting.logReport("","", "Error occurred while verifying PDF contents","", StepStatus.FAILURE,
	  					new String[] {  }, startTime, e);
	        	  System.out.println(e);
			}
			
		}
		
		
		
		return isTextFound;
	}

public String  generate_RandomString (int Charactors) 
{
	
	Random ran = new Random();
	int top = Charactors;
	char data = ' ';
	String RandomString = "";

	for (int i=0; i<=top; i++)
	{
	  data = (char)(ran.nextInt(25)+97);
	  RandomString = data + RandomString;
	}

	return RandomString;

}
	/*******************************************************************
	 * Name : _waitFor Description : Used to wait for an object, Default wait_for is
	 * VISIBLE User can pass this option explicitly also
	 * 
	 ********************************************************************/
	public void _waitFor(Element element, long timeOut, WAIT_FOR waitType, String value) {
		long startTime = System.currentTimeMillis();

		try {
			element.waitFor(timeOut, TimeUnit.SECONDS, waitType, value);

		} catch (Exception ex) {
			CustomReporting.logReport(getCustomPageName(), getCustomElementName(element), "present", "",
					StepStatus.FAILURE, new String[] { value }, startTime, ex);
			throw ex;
		}

	}

	public void _waitFor(Element element, long timeOut, WAIT_FOR waitType) {
		_waitFor(element, timeOut, waitType, "");
	}

	public void _waitFor(Element element, long timeOut) {
		long startTime = System.currentTimeMillis();

		try {
			element.waitForVisible(timeOut, TimeUnit.SECONDS);
		} catch (Exception ex) {
			CustomReporting.logReport(getCustomPageName(), getCustomElementName(element), "present", "",
					StepStatus.FAILURE, new String[] { "Visible" }, startTime, ex);
			throw ex;
		}

	}

	public void _wait(long timeOut) {
		try {
			Thread.sleep(timeOut);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void _waitForPageToLoad(WebDriver driver, Long timeOutInSeconds) {

		long startTime = System.currentTimeMillis();
		ExpectedCondition<Boolean> pageLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSeconds);
		try {
			wait.until(pageLoad);
		} catch (Exception ex) {

			// CustomReporting.logReport("","", "Timeout during page load","",
			// StepStatus.FAILURE,
			// new String[] { }, startTime, ex);
			System.out.println(ex);
		}

	}

	

	/*******************************************************************
	 * Name : _getDataAsList Description : Used to get the data from a field
	 * converting them as list items delimited by ;
	 * 
	 ********************************************************************/
	public List<String> _getDataAsList(String tcID, String sheet, String field, SoftAssert assertSoft) {
		PageData dataSubmission = PageDataManager.instance().getPageData(sheet, tcID);
		String expectedValues = dataSubmission.getData(field);
		String[] arraystr;
		arraystr = expectedValues.split(";");

		List<String> expected = new ArrayList<String>();
		for (String opt : arraystr) {
			expected.add(opt.trim());
		}
		return expected;
	}

	/*******************************************************************
	 * Name : _selectDropDownOptions Description : Used to select the options.
	 * 
	 ********************************************************************/
	public void _selectDropDownOptions(WebDriver driver, String strXpath, List<String> expOptions,
			SoftAssert assertSoft) {

		int count = expOptions.size();
		int uWSize = getWebDriver().findElements(By.xpath(strXpath)).size();
		for (int i = 1; i <= uWSize; i++) {
			String strClass = getWebDriver().findElement(By.xpath(strXpath + "[" + i + "]")).getAttribute("class");
			if (strClass.compareToIgnoreCase("divider") != 0) {
				WebElement elem = getWebDriver().findElement(By.xpath(strXpath + "[" + i + "]/a"));
				if (expOptions.contains(elem.getText().trim())) {
					elem.click();
					count--;
					if (count == 0) {
						break;
					}
				}
			}
		}
	}

	/*******************************************************************
	 * Name : _validateDropdownOptions Description : Used to validate values of a
	 * dropdown against given list of values
	 * 
	 ********************************************************************/
	public void _validateDropdownOptions(WebDriver driver, String strXpath, List<String> expOptions, boolean bOrder,
			boolean bIgnoreCase, SoftAssert assertSoft) {
		long startTime = System.currentTimeMillis();
		boolean success = false;
		String ExpValue = "";
		String Actvalue = "";
		try {
			// Select sel= new Select((WebElement) dropDownElement.getNative());
			List<WebElement> options = driver.findElements(By.xpath(strXpath));

			// List<WebElement> options= sel.getOptions();

			List<String> expected = new ArrayList<String>();
			List<String> actual = new ArrayList<String>();
			// get actual values and convert to upper case if comparison is not case
			// sensitive
			int actSize = driver.findElements(By.xpath(strXpath)).size();
			for (int i = 1; i <= actSize; i++) {
				if (bIgnoreCase) {

					String strClass = driver.findElement(By.xpath(strXpath + "[" + i + "]")).getAttribute("class");
					if (strClass.compareToIgnoreCase("divider") != 0) {
						WebElement el = driver.findElement(By.xpath(strXpath + "[" + i + "]/a"));
						actual.add(el.getText().toUpperCase().trim());
						ExpValue = ExpValue + el.getText().toUpperCase().trim() + ";";
					}
				} else {

					String strClass = driver.findElement(By.xpath(strXpath + "[" + i + "]")).getAttribute("class");
					if (strClass.compareToIgnoreCase("divider") != 0) {
						WebElement el = driver.findElement(By.xpath(strXpath + "[" + i + "]/a"));
						actual.add(el.getText().trim());
						ExpValue = ExpValue + el.getText().trim() + ";";
					}
				}

			}
			// get expected values and convert to upper case if comparison is not case
			// sensitive

			for (String option : expOptions) {
				if (bIgnoreCase) {
					expected.add(option.toUpperCase().trim());
					Actvalue = Actvalue + option.toUpperCase().trim() + ";";
				} else {
					expected.add(option.trim());
					Actvalue = Actvalue + option.trim() + ";";
				}

			}
			// sort the values if order is not matter in comparison
			if (!bOrder) {
				Collections.sort(actual);
				Collections.sort(expected);
			}
			// compare expected vs actual

			if (actual.equals(expected)) {
				success = true;
				CustomReporting.logReport(getCustomPageName(), "DropDown",
						"Expected values -" + ExpValue + "-----Match with Actual value--- " + Actvalue,
						StepStatus.SUCCESS, new String[] { expected.toString() }, startTime);
			} else {
				CustomReporting.logReport(getCustomPageName(), "DropDown",
						"Expected values -" + ExpValue + "-----does not Match with Actual value--- " + Actvalue,
						StepStatus.FAILURE, new String[] { expected.toString(), actual.toString() }, startTime);
			}

		} catch (Exception ex) {
			CustomReporting.logReport(getCustomPageName(), "DropDown", "dropdown", "", StepStatus.FAILURE,
					new String[] {}, startTime, ex);
			throw ex;

		}

		finally {
			assertSoft.assertEquals(success, true);
		}
	}

	/********************************************************************
	 * Name : _validateSearchResult Description : Used to validate the search result
	 * based on the specified field.
	 * 
	 ********************************************************************/
	public void _validateSearchResult(WebDriver driver, String field, List<String> Expected, SoftAssert assertSoft) {

		HashMap<String, Integer> searchHeadMap = new HashMap<String, Integer>();
		List<WebElement> tHead = driver.findElements(By.xpath("//th"));

		int count = 1;
		for (WebElement el : tHead) {
			searchHeadMap.put(el.getAttribute("data-field"), count++);
		}
		for (Map.Entry<String, Integer> entry : searchHeadMap.entrySet()) {
			// System.out.println(entry.getKey()+": "+entry.getValue());
			if (entry.getKey().equalsIgnoreCase(field)) {
				int recCount = getWebDriver().findElements(By.xpath("//table/tbody/tr")).size();
				CustomReporting.logReport("Total regords" + recCount + " ");
				int i = 1;
				for (; i <= recCount; i++) {
					String fieldValue = getWebDriver()
							.findElement(By.xpath("//table/tbody/tr[" + i + "]//td[" + entry.getValue() + "]"))
							.getText();
					if (Expected.contains(fieldValue)) {
						// CustomReporting.logReport("Record "+i+" "+dept);

					}

				}
				if (i == recCount + 1) {
					CustomReporting.logReport("", "", "All records belong to expected Field -----" + field,
							StepStatus.SUCCESS, new String[] {}, System.currentTimeMillis());
				} else {
					CustomReporting.logReport("", "", "All records not belong to expected Field" + "", "",
							StepStatus.FAILURE, new String[] {}, System.currentTimeMillis(), null);
					throw new RuntimeException();
				}

			}
		}

	}

	/*******************************************************************
	 * Name : _isEnabled Description : Used to check Object is enabled or disabled
	 * 
	 ********************************************************************/
	public boolean _isEnabled(Element element) {

		WebElement ele = (WebElement) element.getNative();

		String isDisabled = ele.getAttribute("disabled");
		if (isDisabled == null)
			return true;
		else
			return false;

	}

	/*******************************************************************
	 * Name : _selectFilterOptions Description : Used to select the options present
	 * in filter.
	 * 
	 ********************************************************************/
	public void _selectFilterOptions(WebDriver driver, String strXpath, List<String> expOptions,
			SoftAssert assertSoft) {
		int count = expOptions.size();
		int uWSize = getWebDriver().findElements(By.xpath(strXpath)).size();
		for (int i = 1; i <= uWSize; i++) {
			WebElement elem = getWebDriver().findElement(By.xpath(strXpath + "[" + i + "]"));
			String actText = elem.getText();
			if (actText.equals("") && expOptions.contains("")) {
				getWebDriver().findElement(By.xpath(strXpath + "/input")).click();
				count--;
				if (count == 0) {
					break;
				}

			}
			if (expOptions.contains(actText.trim())) {
				elem.click();
				count--;
				if (count == 0) {
					break;
				}
			}

		}
	}

	/*******************************************************************
	 * Name : _checkAttributeValue Description : Used to compare the attribute value
	 * of an object
	 * 
	 ********************************************************************/
	public boolean _checkAttributeValue(Element element, String strAttribute, String strExpValue,
			SoftAssert assertSoft) {
		String strActValue = "";
		long startTime = System.currentTimeMillis();

		// Compare the value
		try {
			if (_isVisible(element)) {
				// Get the Attribute value
				if (strAttribute.equalsIgnoreCase("TEXT")) {
					WebElement ele = (WebElement) element.getNative();
					if (ele.getTagName().equalsIgnoreCase("select")) {
						Select sel = new Select(ele);
						strActValue = sel.getFirstSelectedOption().getText().trim();
					} else {
						strActValue = ele.getText().trim();
					}
					// CustomReporting.logReport(getCustomPageName(), getCustomElementName(element),
					// "attribute",StepStatus.SUCCESS,new String[] { strAttribute,
					// strExpValue},startTime);
				} else {
					strActValue = element.getAttribute(strAttribute).trim();
				}

				if (!strActValue.equalsIgnoreCase(strExpValue.trim())) {
					// CustomReporting.logReport(getCustomPageName(), getCustomElementName(element),
					// "attrValue","",StepStatus.FAILURE,new String[] { strAttribute,
					// strExpValue},startTime,null);
					CustomReporting.logReport("", "",
							" Expected values: " + strExpValue + " : does not match the actual values: " + strActValue,
							"", StepStatus.FAILURE, new String[] {}, startTime, null);
					return false;
				} else {
					// CustomReporting.logReport(getCustomPageName(), getCustomElementName(element),
					// "attrValue",StepStatus.SUCCESS,new String[] { strAttribute,
					// strExpValue},startTime);
					CustomReporting.logReport("", "",
							" Expected values: " + strExpValue + " : match the actual values: " + strActValue,
							StepStatus.SUCCESS, new String[] {}, startTime);

					return true;
				}
			} else {
				CustomReporting.logReport(getCustomPageName(), getCustomElementName(element), "_attrValue", "",
						StepStatus.FAILURE, new String[] { strAttribute, strExpValue, " Object not visible" },
						startTime, null);
				return false;
			}

		} catch (Exception ex) {
			CustomReporting.logReport(getCustomPageName(), getCustomElementName(element), "attrValue", "",
					StepStatus.FAILURE, new String[] { strAttribute, strExpValue }, startTime, ex);
			// throw ex;
			return false;
		} finally {
			assertSoft.assertEquals(strExpValue.toUpperCase(), strActValue.toUpperCase());
		}
	}

	/*
	 * public boolean _checkAttributeValue(Element element, String strAttribute,
	 * String strExpValue, SoftAssert assertSoft) { String strActValue = ""; long
	 * startTime = System.currentTimeMillis();
	 * 
	 * // Compare the value try { if (_isVisible(element)) { // Get the Attribute
	 * value if (strAttribute.equalsIgnoreCase("TEXT")) { WebElement ele =
	 * (WebElement) element.getNative(); if
	 * (ele.getTagName().equalsIgnoreCase("select")) { Select sel = new Select(ele);
	 * strActValue = sel.getFirstSelectedOption().getText().trim(); } else {
	 * strActValue = ele.getText().trim(); }
	 * CustomReporting.logReport(getCustomPageName(), getCustomElementName(element),
	 * "attribute", StepStatus.SUCCESS, new String[] { strAttribute, strExpValue },
	 * startTime); } else { strActValue = element.getAttribute(strAttribute).trim();
	 * }
	 * 
	 * if (!strActValue.equalsIgnoreCase(strExpValue.trim())) {
	 * //CustomReporting.logReport(getCustomPageName(),
	 * getCustomElementName(element), "attrValue", "", //StepStatus.FAILURE, new
	 * String[] { strAttribute, strExpValue }, startTime, null);
	 * CustomReporting.logReport(getCustomPageName(), getCustomElementName(element),
	 * " Expected values: "+strExpValue+" : does not match the actual values: "
	 * +strActValue, "", StepStatus.FAILURE, new String[] { }, startTime, null);
	 * 
	 * return false;
	 * 
	 * } else { //CustomReporting.logReport(getCustomPageName(),
	 * getCustomElementName(element), "attrValue", //StepStatus.SUCCESS, new
	 * String[] { strAttribute, strExpValue }, startTime);
	 * CustomReporting.logReport(getCustomPageName(), getCustomElementName(element),
	 * " Expected values: "+strExpValue+" : match the actual values: "+strActValue,
	 * StepStatus.SUCCESS, new String[] { }, startTime); return true; } } else {
	 * CustomReporting.logReport(getCustomPageName(), getCustomElementName(element),
	 * "_attrValue", "", StepStatus.FAILURE, new String[] { strAttribute,
	 * strExpValue, " Object not visible" }, startTime, null); return false; }
	 * 
	 * } catch (Exception ex) { CustomReporting.logReport(getCustomPageName(),
	 * getCustomElementName(element), "attrValue", "", StepStatus.FAILURE, new
	 * String[] { strAttribute, strExpValue }, startTime, ex); // throw ex; return
	 * false; } finally { assertSoft.assertEquals(strExpValue.toUpperCase(),
	 * strActValue.toUpperCase()); } }
	 */

	/*******************************************************************
	 * Name : _getAttributeValue Description : Used to retrive the attribute value
	 * of an object
	 * 
	 ********************************************************************/
	@SuppressWarnings("finally")
	public String _getAttributeValue(Element element, String strAttribute, SoftAssert assertSoft) {
		String strActValue = "";
		long startTime = System.currentTimeMillis();
		boolean blnStatus = false;

		// Compare the value
		try {
			// Get the Attribute value
			if (strAttribute.equalsIgnoreCase("TEXT")) {
				WebElement ele = (WebElement) element.getNative();
				if (ele.getTagName().equalsIgnoreCase("select")) {
					Select sel = new Select(ele);
					strActValue = sel.getFirstSelectedOption().getText().trim();
				} else {
					strActValue = ele.getText();
				}
				CustomReporting.logReport(getCustomElementName(element), getCustomPageName(), "attribute",
						StepStatus.SUCCESS, new String[] { strAttribute, strActValue }, startTime);
			} else {
				strActValue = element.getAttribute(strAttribute);
			}

			blnStatus = true;

		} catch (Exception ex) {
			CustomReporting.logReport(getCustomElementName(element), getCustomPageName(), "attribute", "",
					StepStatus.FAILURE, new String[] { strAttribute, strActValue }, startTime, ex);
			throw ex;
		} finally {
			assertSoft.assertEquals(true, blnStatus);
			return strActValue;
		}
	}

	/*******************************************************************
	 * Name : CheckFileExist Description : to check if the given file exists in the
	 * directory and delete if present
	 * 
	 ********************************************************************/
	public boolean CheckFileExist(String directory, String file) {
		File dir = new File(directory);
		File[] dir_contents = dir.listFiles();
		String temp = file;
		boolean isFileExist = false;
		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().contains(file)) {
				isFileExist = true;
				// dir_contents[i].delete();
				break;

			}
		}

		return isFileExist;
	}

	/*******************************************************************
	 * Name : Date_Manipulation Description : Working with Dates
	 * 
	 ********************************************************************/
	public String Date_Manipulation(String strDate, String strSelectOption, int num) throws Exception {
		String datevalue = "";

		try {

			//DateFormat dateFormate = new SimpleDateFormat("yyyy/MM/dd");
			DateFormat dateFormate = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			if (!strDate.equals("")) {
				cal.setTime(dateFormate.parse(strDate));
			} else {
				cal.setTime(date);
			}

			switch (strSelectOption.toUpperCase()) {
			case "YEAR":
			case "YEARS":

				cal.add(Calendar.YEAR, num);
				datevalue = dateFormate.format(cal.getTime());
				break;

			case "DAYS":
			case "DAY":
				cal.add(Calendar.DAY_OF_MONTH, num);
				datevalue = dateFormate.format(cal.getTime());
				break;

			case "MONTHS":
			case "MONTH":
				cal.add(Calendar.MONTH, num);
				datevalue = dateFormate.format(cal.getTime());
				break;

			case "NOW":

				datevalue = dateFormate.format(date);
				break;

			}
		} catch (Exception ex) {

			throw ex;

		}
		return datevalue;

	}

	public String Date_ManipulationFormat(String strDate, String strSelectOption, int num) throws Exception {
		String datevalue = "";

		try {

			DateFormat dateFormate = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			if (!strDate.equals("")) {
				cal.setTime(dateFormate.parse(strDate));
			} else {
				cal.setTime(date);
			}

			switch (strSelectOption.toUpperCase()) {

			case "MONTHS":
			case "MONTH":
				cal.add(Calendar.MONTH, num);
				datevalue = dateFormate.format(cal.getTime());
				break;

			case "DAYS":
			case "DAY":
				cal.add(Calendar.DAY_OF_MONTH, num);
				datevalue = dateFormate.format(cal.getTime());
				break;

			case "YEAR":
			case "YEARS":

				cal.add(Calendar.YEAR, num);
				datevalue = dateFormate.format(cal.getTime());
				break;

			case "NOW":

				datevalue = dateFormate.format(date);
				break;

			}
		} catch (Exception ex) {

			throw ex;

		}
		return datevalue;

	}

	/*******************************************************************
	 * Name : DownloadFileIE Description : to download file from IE browser
	 * 
	 ********************************************************************/

	public void _downloadFile(String FilePath, String fileName) {
		long startTime = System.currentTimeMillis();
		try {

			//GenericFunctions.instance().CheckFileExist(FilePath, fileName);
			FilePath = FilePath + fileName;
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			StringSelection ss = new StringSelection(FilePath);

			clipboard.setContents(ss, ss);
			String result = (String) clipboard.getData(DataFlavor.stringFlavor);
			System.out.println("string from the clipboard " + result);
			Thread.sleep(5000);

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_N);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(8000);

			CustomReporting.logReport("", "", "File downloaded successfully", StepStatus.SUCCESS, new String[] {},
					startTime);
		} catch (Exception ex) {
			CustomReporting.logReport("", "", "File download failed", "", StepStatus.FAILURE, new String[] {},
					startTime, ex);
			System.out.println(ex);
		}
	}
	// public void DownloadFileIE( Element element)
	// {
	//
	// try {
	// Robot robot = new Robot();
	// //get the focus on the element..don't use click since it stalls the driver
	// WebElement elm = (WebElement) element.getNative();
	// //Edit By siva Kumari
	// elm.click();
	// //elm.sendKeys("");
	// //simulate pressing enter
	//
	// // robot.keyPress(KeyEvent.VK_ENTER);
	// //robot.keyRelease(KeyEvent.VK_ENTER);
	// //wait for the modal dialog to open
	// Thread.sleep(2000);
	// //press s key to save
	// robot.keyPress(KeyEvent.VK_ALT);
	//
	// robot.keyPress(KeyEvent.VK_S);
	// robot.keyRelease(KeyEvent.VK_ALT);
	// robot.keyRelease(KeyEvent.VK_S);
	// Thread.sleep(2000);
	// }
	//
	// catch (Exception e)
	// {
	//
	// e.printStackTrace();
	//
	// }
	// }

	/*******************************************************************
	 * Name : _saveMail Description : Used to save outlook files at the specified
	 * location
	 * 
	 ********************************************************************/
	public void _saveMail(String FilePath, String fileName) {
		long startTime = System.currentTimeMillis();
		try {

			GenericFunctions.instance().CheckFileExist(FilePath, fileName);
			FilePath = FilePath + fileName;
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			StringSelection ss = new StringSelection(FilePath);

			clipboard.setContents(ss, ss);
			String result = (String) clipboard.getData(DataFlavor.stringFlavor);
			System.out.println("string from the clipboard " + result);
			Thread.sleep(5000);

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_N);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(8000);

			CustomReporting.logReport("", "", "Outlook File saved successfully", StepStatus.SUCCESS, new String[] {},
					startTime);
		} catch (Exception ex) {
			CustomReporting.logReport("", "", "Outlook file save failed", "", StepStatus.FAILURE, new String[] {},
					startTime, ex);
			System.out.println(ex);
		}
	}

	/*******************************************************************
	 * Name : _verifyEmailContent Description : Used to verify the contents in the
	 * saved outlook file
	 * 
	 ********************************************************************/
	public void _verifyEmailContent(String strAttribute, String strExpValue, String strFilePath,
			SoftAssert assertSoft) {
		String strActValue = "";
		long startTime = System.currentTimeMillis();

		try {
			strFilePath = strFilePath + ".msg";
			File initialFile = new File(strFilePath);
			InputStream targetStream = new FileInputStream(initialFile);

			MsgParser msgp = new MsgParser();
			Message msg = msgp.parseMsg(targetStream);

			// String fromEmail = msg.getFromEmail();
			// String fromName = msg.getFromName();
			String subject = msg.getSubject();
			String strBody = msg.getBodyText();
			System.out.println(subject);
			System.out.println(strBody);

			if (strAttribute.equalsIgnoreCase("BODY")) {

				if (strBody.contains(strExpValue)) {
					CustomReporting.logReport("MICROSOFT OUTLOOK", "OUTLOOK FILE - ",
							strExpValue + ": is present in the body of the Outlook mail", StepStatus.SUCCESS,
							new String[] {}, startTime);
				} else {
					CustomReporting.logReport("MICROSOFT OUTLOOK", "OUTLOOK FILE - ",
							strExpValue + ": is NOT present in the body of the Outlook mail", "", StepStatus.FAILURE,
							new String[] {}, startTime, null);
				}

			} else if (strAttribute.equalsIgnoreCase("SUBJECT")) {
				if (subject.equalsIgnoreCase(strExpValue)) {
					CustomReporting.logReport("MICROSOFT OUTLOOK", "OUTLOOK FILE - ",
							strExpValue + ": is present in the Outlook mail Subject", StepStatus.SUCCESS,
							new String[] {}, startTime);
				} else {
					CustomReporting.logReport("MICROSOFT OUTLOOK", "OUTLOOK FILE - ",
							strExpValue + ": is NOT present in the Outlook mail Subject", "", StepStatus.FAILURE,
							new String[] {}, startTime, null);
				}
			}

		} catch (Exception ex) {
			CustomReporting.logReport("MICROSOFT OUTLOOK", "OUTLOOK FILE - ", "attrValue", "", StepStatus.FAILURE,
					new String[] { strAttribute, strExpValue }, startTime, ex);
			// throw ex;
		} finally {
			assertSoft.assertEquals(strExpValue.toUpperCase(), strActValue.toUpperCase());
		}
	}

	public void _scrollToElement(Element ele) {
		WebElement element = (WebElement) ele.getNative();

		Actions actions = new Actions(getWebDriver());
		actions.moveToElement(element);
		actions.perform();

	}

	public boolean isAlertPresent() {
		boolean alertFlag = false;
		try {
			getWebDriver().switchTo().alert();
			System.out.println(" Alert Present");
			alertFlag = true;

		} catch (NoAlertPresentException e) {
			System.out.println("No Alert Present");
			alertFlag = false;

		} finally {
			return alertFlag;
		}
	}

	public void robot() throws InterruptedException {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(1000);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// Thread.sleep(1000);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// Thread.sleep(1000);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// Thread.sleep(1000);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// Thread.sleep(1000);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// Thread.sleep(1000);
		// robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);

	}
	
	public void _sendRobotKeys(String strVal) throws Exception {
		long startTime = System.currentTimeMillis();
	
		try {
			Robot robot = new Robot();
			//System.out.println("string value" + strVal);
			if(!strVal.equals("")) {
			for (char c : strVal.toCharArray()) {
				if (c == '@') {
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_2);
					robot.keyRelease(KeyEvent.VK_2);
					robot.keyRelease(KeyEvent.VK_SHIFT);
				} else if (c == '#') {
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_3);
					robot.keyRelease(KeyEvent.VK_3);
					robot.keyRelease(KeyEvent.VK_SHIFT);
				} else if (c == '&') {
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_7);
					robot.keyRelease(KeyEvent.VK_7);
					robot.keyRelease(KeyEvent.VK_SHIFT);
				} else if (c == '%') {
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_5);
					robot.keyRelease(KeyEvent.VK_5);
					robot.keyRelease(KeyEvent.VK_SHIFT);
				} else {
					int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);

					if (KeyEvent.CHAR_UNDEFINED == keyCode) {
						throw new RuntimeException("Key code not found for character '" + c + "'");
					}

					robot.keyPress(keyCode);
					robot.delay(100);
					robot.keyRelease(keyCode);
					robot.delay(100);
				}

			}
			
			//CustomReporting.logReport("", "", "Entered the value: " + strVal, StepStatus.SUCCESS, new String[] {},
					//startTime);
			
			CustomReporting.logReport("", "", "Set the value of the  " + " field on the screen " + getCustomPageName() + " to: "+ strVal, StepStatus.SUCCESS, new String[] {},
					startTime);
			
			//getCustomPageName()
			}

		} catch (Exception ex) {
			CustomReporting.logReport("", "", "Failed to set the value of the "+ " field on the screen" + getCustomPageName() + " to: ", "", StepStatus.FAILURE, new String[] {}, startTime, ex);
			throw ex;
		}

	}

	public void clickTab() throws InterruptedException {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_TAB);

	}

	public void clickEnter() throws InterruptedException {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

	}

	public void clickDown() throws InterruptedException {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);

	}

	/*******************************************************************
	 * Name : _getValue Description : Used to get the value to any object, Only when
	 * there is data in DB Modification Log : Date Initials Description of
	 * Modifications
	 ********************************************************************/
	public void _getValue(Element element) {

		long startTime = System.currentTimeMillis();
		try {

			element.getValue();

		} catch (Exception ex) {
			CustomReporting.logReport(getCustomPageName(), getCustomElementName(element), "setValue", "",
					StepStatus.FAILURE, new String[] {}, startTime, ex);
			throw ex;

		}
	}

	public void _getNative(Element element) {

		long startTime = System.currentTimeMillis();
		try {

			element.getNative();

		} catch (Exception ex) {
			CustomReporting.logReport(getCustomPageName(), getCustomElementName(element), "setValue", "",
					StepStatus.FAILURE, new String[] {}, startTime, ex);
			throw ex;

		}
	}

	public void _Forms(Element element) {

		long startTime = System.currentTimeMillis();
		try {

			element.getNative();

		} catch (Exception ex) {
			CustomReporting.logReport(getCustomPageName(), getCustomElementName(element), "setValue", "",
					StepStatus.FAILURE, new String[] {}, startTime, ex);
			throw ex;

		}

	}

	// ***************************************************************************************************
	public void selectDropDownValue(WebDriver driver, String xpath, String strvalue)

	{
		if (!strvalue.equals(null)) {
			long startTime = System.currentTimeMillis();
			List<WebElement> listOfElements = driver.findElements(By.xpath(xpath));
			for (WebElement element : listOfElements) {
				if (element.getText().trim().equalsIgnoreCase(strvalue)) {
					element.click();
					CustomReporting.logReport("", "",
							"Expected value: " + strvalue + " has been selected from the dropdown: ",
							StepStatus.SUCCESS, new String[] {}, startTime);

					break;
				}
			}
		}

	}

	// ***************************************************************************************************
	public void validateExposure(String tcID) {
		_wait(3000);
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		long startTime = System.currentTimeMillis();
		if (dataUmLogin.getData("CRIME").equalsIgnoreCase("Yes")) {
			String targetxpath = "//*[contains(text(),'Revenue')] /../following-sibling::div//div";
			WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath)));
			String ExpectedValue = ele.getText();
			String ActualValue = dataUmLogin.getData("txtRevenue");

			if (ExpectedValue.equals(dataUmLogin.getData("txtRevenue")))

			{
				CustomReporting.logReport("", "",
						"Expected value: " + ExpectedValue
								+ " is same as selected for Revenue(CRIME) Exposure in UM i.e " + (ActualValue),
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				CustomReporting.logReport("", "",
						"Expected value: " + ExpectedValue
								+ " is not the same as selected for Revenue(CRIME) Exposure in UM i.e " + (ActualValue),
						StepStatus.SUCCESS, new String[] {}, startTime);
				 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
			_wait(2000);
		}
		if (dataUmLogin.getData("DNO").equalsIgnoreCase("Yes")) {
			String targetxpath = "//*[contains(text(),'Corporate Assets')] /../following-sibling::div//div";
			WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath)));
			String ExpectedValue = ele.getText();
			String ActualValue = dataUmLogin.getData("txtCorporateAssets");

			if (ExpectedValue.equals(dataUmLogin.getData("txtCorporateAssets")))

			{
				CustomReporting.logReport("", "",
						"Expected value: " + ExpectedValue
								+ " is same as selected for Corporate Assests(DNO) Exposure in UM i.e " + (ActualValue),
						StepStatus.SUCCESS, new String[] {}, startTime);
			} else {
				CustomReporting.logReport("", "", "Expected value: " + ExpectedValue
						+ " is not the same as selected for Corporate Assests(DNO) Exposure in UM i.e " + (ActualValue),
						StepStatus.SUCCESS, new String[] {}, startTime);
				 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}

			_wait(2000);
		}
		if (dataUmLogin.getData("EPL").equalsIgnoreCase("Yes")) {

			_wait(2000);
		}

	}

	// ***************************************************************************************************
	public void validateUMStatus(String tcID, String strValue) {
		_wait(3000);
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		long startTime = System.currentTimeMillis();
		String targetxpath = "//*[contains(text(),'Status:')]/../span/following-sibling::span";
		WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath)));
		String Actualvalue = ele.getText();
		if (Actualvalue.equals(strValue))

		{
			CustomReporting.logReport("", "", "Status is: " + Actualvalue, StepStatus.SUCCESS, new String[] {},
					startTime);
		} else {
			CustomReporting.logReport("", "", "Status is: " + Actualvalue + " and not as expected " + strValue,
					StepStatus.FAILURE, new String[] {}, startTime);
			 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
		_wait(2000);
	}

	// ***************************************************************************************************
	public void validatePCStatus(String tcID, String strValue) {
		_wait(3000);
		PageData dataUmLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		long startTime = System.currentTimeMillis();

		String targetxpath = "//*[contains(text(),'Submission')]//span";
		WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath)));
		String Actualvalue = ele.getText();
		if (Actualvalue.equals(strValue))

		{
			CustomReporting.logReport("", "", "Status is: " + Actualvalue, StepStatus.SUCCESS, new String[] {},
					startTime);
		} else {
			CustomReporting.logReport("", "", "Status is: " + Actualvalue + " and not as expected " + strValue,
					StepStatus.FAILURE, new String[] {}, startTime);
			 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}
		_wait(2000);
	}

	// ***************************************************************************************************
	public void InsuredAppValidationNB(String tcID) throws InterruptedException {
		PageData dataUmLogin = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
		long startTime = System.currentTimeMillis();
		_wait(4000);
		
		String f = "//*[@id='body']/div/div[1]/select";
		WebElement ele4 = (getWebDriver().findElement(By.xpath(f)));
		
		ele4.click();
//	String targetxpath4 = f  + "[contains(text(),\""+dataUmLogin.getData("Release")+"\")]";
	
	String targetxpath4 = "//*[contains(text(),'Release 181')]";
	
	WebElement ele5 = (getWebDriver().findElement(By.xpath(targetxpath4)));
	
	ele5.click();
//	selectDropDownValue(getWebDriver(), targetxpath4, dataUmLogin.getData("Release"));
		_waitForPageToLoad(getWebDriver(), 50L);

		_wait(1000);
		
		String targetxpath = "//*[@id='id']";
		WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath)));
		_wait(4000);
		String RatingId = dataUmLogin.getData("RatingWorkSheetId");
		ele.sendKeys(RatingId);
		_wait(2000);
		GenericFunctions.instance().setValue7();
		_wait(4000);
		String Premium = dataUmLogin.getData("Premium");

		String targetxpath2 = "//*[contains(text(),'Total Premium')]/../../following-sibling::tr/td[4]";
		WebElement ele2 = (getWebDriver().findElement(By.xpath(targetxpath2)));
		String Actual = ele2.getText();
		String values[] = Actual.split(" ");
		String Actualvalue = "$" + values[1];
		if (Actualvalue.equals(Premium))

		{
			CustomReporting.logReport("The Actual value in Insured app" + Actualvalue + " and premium value in PC are same " + Premium);
		} else {
			CustomReporting.logReport("The Actual value  in Insured app" + Actualvalue + "and premium value in PC does not match as expected " + Premium,
					StepStatus.SUCCESS);
			  _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}

		_wait(2000);

		String targetxpath3 = "//*[contains(text(),'Logout')]";
		WebElement ele3 = (getWebDriver().findElement(By.xpath(targetxpath3)));
		_wait(2000);
		ele3.click();
	}
	// ***************************************************************************************************

	public void InsuredAppValidationPolicyChange(String tcID) throws InterruptedException {
		PageData dataUmLogin = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
		_wait(4000);
		String f = "//*[@id='body']/div/div[1]/select";
		WebElement ele4 = (getWebDriver().findElement(By.xpath(f)));
		
		ele4.click();
//	String targetxpath4 = f  + "[contains(text(),\""+dataUmLogin.getData("Release")+"\")]";
	
	String targetxpath4 = "//*[contains(text(),'Release 181')]";
	
	WebElement ele5 = (getWebDriver().findElement(By.xpath(targetxpath4)));
	
	ele5.click();
	_wait(4000);
		String targetxpath = "//*[@id='id']";
		WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath)));
		String RatingId = dataUmLogin.getData("RatingWorkSheetId2");
		ele.sendKeys(RatingId);
		GenericFunctions.instance().setValue7();;
		_wait(4000);
		String Premium = dataUmLogin.getData("Premium2");

		String targetxpath2 = "//*[contains(text(),'Total Premium')]/../../following-sibling::tr/td[4]";
		WebElement ele2 = (getWebDriver().findElement(By.xpath(targetxpath2)));
		String Actual = ele2.getText();
		String values[] = Actual.split(" ");
		String Actualvalue = "$" + values[1];
		if (Actualvalue.equals(Premium))

		{
			CustomReporting.logReport("The Actual value in Insured app" + Actualvalue + " and premium value in PC are same during Policy Change " + Premium);
		} else {
			CustomReporting.logReport("The Actual value  in Insured app" + Actualvalue + " and premium value in PC does not match as expected during Policy Change " + Premium);
			 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}

		_wait(2000);
		String targetxpath3 = "//*[contains(text(),'Logout')]";
		WebElement ele3 = (getWebDriver().findElement(By.xpath(targetxpath3)));
		_wait(2000);
		ele3.click();

	}
	// ***************************************************************************************************

	public void PremiumValidation(String tcID) throws InterruptedException {
		PageData dataUmLogin = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);

		if (dataUmLogin.getData("Premium").equals(dataUmLogin.getData("Premium2"))) {
			CustomReporting.logReport("The premiums are the same post Change Transaction");
		} else {
			CustomReporting.logReport("The premiums have changed as expected post Change Transaction");
			 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}

	}
	// ***************************************************************************************************

	public void executeJavaScript(String elementName, Element element, String data, String pageName)
			throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		long startTime = System.currentTimeMillis();
		String et = element.getKey().toString();
		String pm = "document.evaluate(\"" + et + "\", document, null, 9, null).singleNodeValue.innerHTML='" + data
				+ "'";

		// element.getValue();
		js.executeScript(pm);
		if (getWebDriver().findElement(By.xpath(et)).getText().equals(data)) {
			CustomReporting.logReport("", "", "Set the value of the " + elementName + " element to " + data
					+ " sucessfully on the page " + pageName + "", StepStatus.SUCCESS, new String[] {}, startTime);
		} else {
			CustomReporting.logReport("", "",
					"Unable to Set the value of the " + elementName + " element in" + pageName + "  to " + data + " ",
					StepStatus.FAILURE, new String[] {}, startTime);

		}
	}

	// ***************************************************************************************************

	public void sendData(String elementName, Element element, String data, String pageName)
			throws InterruptedException {
		long startTime = System.currentTimeMillis();
		String xpath = element.getKey().toString();
		new Actions(getWebDriver()).moveToElement(getWebDriver().findElement(By.xpath(xpath))).click()
				.sendKeys(Keys.BACK_SPACE).sendKeys(data).sendKeys(Keys.TAB).build().perform();
		_wait(500);
		if (getWebDriver().findElement(By.xpath(xpath)).getText().equals(data)) {
			CustomReporting.logReport("", "", "Set the value of the " + elementName + " element to " + data
					+ " sucessfully on the page " + pageName + "", StepStatus.SUCCESS, new String[] {}, startTime);
		} else {
			CustomReporting.logReport("", "",
					"Unable to Set the value of the " + elementName + " element in" + pageName + "  to " + data + " ",
					StepStatus.FAILURE, new String[] {}, startTime);

		}
	}
	// ***************************************************************************************************

	public void sendData1(String elementName, Element element, String data, String pageName)
			throws InterruptedException {
		long startTime = System.currentTimeMillis();
		String xpath = element.getKey().toString();
		_wait(3000);
		new Actions(getWebDriver()).moveToElement(getWebDriver().findElement(By.xpath(xpath))).click()
				.sendKeys(Keys.BACK_SPACE).sendKeys(data).sendKeys(Keys.TAB).build().perform();

		_wait(500);
		if (getWebDriver().findElement(By.xpath(xpath)).getText().equals(data)) {
			CustomReporting.logReport("", "", "Set the value of the " + elementName + " element to " + data
					+ " sucessfully on the page " + pageName + "", StepStatus.SUCCESS, new String[] {}, startTime);
		} else {
			CustomReporting.logReport("", "",
					"Unable to Set the value of the " + elementName + " element in" + pageName + "  to " + data + " ",
					StepStatus.FAILURE, new String[] {}, startTime);

		}
	}
	// ***************************************************************************************************

	public void removeOptionalCov(String tcID) {
		long startTime = System.currentTimeMillis();

		PageData dataLogin = PageDataManager.instance().getPageData("Login", tcID);
		String val = (dataLogin.getData("OptionalCoverages"));
		String values[] = val.split(";");
		int l = values.length;

		for (int i = 0; i < l; i++) {
			// if (Crime.)//
			String targetxpath = "[contains(text(),\"" + values[i] + "\"/../div//following-sibling::div//input)]";
			WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath)));
			ele.click();
			String targetxpath2 = "[contains(text(),\"" + values[i] + "\")";
			// if (_isVisible(targetxpath2)==true))
			{

			}
		}
	}

	// ***************************************************************************************************

	public void checkCoverages_old(String tcID) 
	{
		PageData dataLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		_wait(10000);
		
		String optionalEnd = "//*[contains(text(),'Rating: Optional Endts')]";
		WebElement RatingoptionalEnd = getWebDriver().findElement(By.xpath(optionalEnd));
		RatingoptionalEnd.click();
		
		String val = (dataLogin.getData("AdditionalCoverages"));
		String values[] = val.split(";");
		// List<String> coveragesList = Arrays.asList(values)
		List<String> coveragesList = new ArrayList<>(Arrays.asList(values));
		int l = values.length;
		
		String pages = "//button[contains(@class,'pageButton')]";
		List<WebElement> totalPages = getWebDriver().findElements(By.xpath(pages));
		int totalPageCount = totalPages.size();
		long startTime = System.currentTimeMillis();
		int row = 0;
		// Iterating through all the pages
		for (int i = 0; i < (totalPageCount); i++)
		{

			// Clicking on the pageNo button
			// totalPages.get(i).click();
			StringBuilder xpathBuilder = new StringBuilder(pages).append("[" + (i + 1) + "]");
			getWebDriver().findElement(By.xpath(xpathBuilder.toString())).click();
			String targetxpath = "//ui-repeating-row";
			int noOfRows = getWebDriver().findElements(By.xpath(targetxpath)).size();

			for (int j = 0; j < noOfRows+1; j++) 
			{
				int n=j+1;
				//String rowXpath = "//div[@class='formRowContainer row" + row++ + "']//input[@type='text']";
				String rowXpath = "//ui-repeating-row[" + n + "]/div/ui-text-input[2]/div/div/input";
				//15
				System.out.println(rowXpath);
				try 
				{
					String rowValue = (getWebDriver().findElement(By.xpath(rowXpath)).getAttribute("value"));

					for (String value : coveragesList)
					{
						if (rowValue.equalsIgnoreCase(value)) 
						{
							String checkboxXpath = rowXpath + "/../../../preceding-sibling::ui-checkbox/div//input";
							WebElement checkbox = getWebDriver().findElement(By.xpath(checkboxXpath));

							checkbox.click();
							_wait(2000);

							CustomReporting.logReport("", "",
									"Added the coverage " + value + " sucessfully on the Optional Coverage page",
									StepStatus.SUCCESS, new String[] {}, startTime);
							coveragesList.remove(value);
							break;
						}
					}
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}

			}

		}

		
		if (!coveragesList.isEmpty()) 
		{
			System.out.println("Count of Coverages not found" + coveragesList.size());
			System.out.println("List of Coverages : " + coveragesList);
			CustomReporting.logReport("", "", "List of Coverages not found : " + coveragesList, StepStatus.FAILURE,
					new String[] {}, startTime);
			
		}
		
	}
	
	
	public void checkCoverages(String tcID) 
	{
		PageData dataLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		PageData dataSubDetails = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
		
		String val = (dataLogin.getData("AdditionalCoverages"));
		String values[] = val.split(";");
		long startTime = System.currentTimeMillis();
		List<String> coveragesList = new ArrayList<>(Arrays.asList(values));
		_wait(10000);
		
		String optionalEnd = "//*[contains(text(),'Rating: Optional Endts')]";
		WebElement RatingoptionalEnd = getWebDriver().findElement(By.xpath(optionalEnd));
		RatingoptionalEnd.click();
		
		if(dataSubDetails.getData("KNR").equalsIgnoreCase("Yes"))
		{
			String KNR_xpath ="//div[contains(text(),'Optional Endorsements - KNR')]";
			WebElement KNR_ele = getWebDriver().findElement(By.xpath(KNR_xpath));
			if(KNR_ele.isDisplayed())
			{
				checkCoverages_1(tcID, coveragesList, val, values, "KNR" );
			}
		}
		
		if(dataSubDetails.getData("CyberCov").equalsIgnoreCase("Yes"))
		{
			String CYB_xpath ="//div[contains(text(),'Optional Endorsements - CYB')]";
			WebElement CYB_ele = getWebDriver().findElement(By.xpath(CYB_xpath));
			if(CYB_ele.isDisplayed())
			{
				checkCoverages_1(tcID, coveragesList, val, values, "CYB");
			}
		}
		
		if(dataSubDetails.getData("CRIME").equalsIgnoreCase("Yes"))
		{
			String CRI_xpath ="//div[contains(text(),'Optional Endorsements - CRI')]";
			WebElement CRI_ele = getWebDriver().findElement(By.xpath(CRI_xpath));
			if(CRI_ele.isDisplayed())
			{
				checkCoverages_1(tcID, coveragesList, val, values, "CRI");
			}
		}
		
		if(dataSubDetails.getData("DNO").equalsIgnoreCase("Yes"))
		{
			String DNO_xpath ="//div[contains(text(),'Optional Endorsements - DNO')]";
			WebElement DNO_ele = getWebDriver().findElement(By.xpath(DNO_xpath));
			if(DNO_ele.isDisplayed())
			{
				checkCoverages_1(tcID, coveragesList, val, values, "DNO" );
			}
		}
		
		String Common_xpath ="//div[contains(text(),'Optional Endorsements - Common')]";
		WebElement Common_ele = getWebDriver().findElement(By.xpath(Common_xpath));
		if(Common_ele.isDisplayed())
		{
			checkCoverages_1(tcID, coveragesList, val, values, "Common" );
		}
		
		if (dataSubDetails.getData("Submission_Type").equalsIgnoreCase("RunOff")) 
		{
			String RunOff_xpath = "//div[contains(text(),'Optional Endorsements - Run-Off')]";
			WebElement RunOff_ele = getWebDriver().findElement(By.xpath(RunOff_xpath));
			if (RunOff_ele.isDisplayed()) {
				checkCoverages_1(tcID, coveragesList, val, values, "Run-Off");
			} 
		}
		
		if(dataSubDetails.getData("EMP").equalsIgnoreCase("Yes"))
		{
			String EMP_xpath ="//div[contains(text(),'Optional Endorsements - EMP')]";
			WebElement EMP_ele = getWebDriver().findElement(By.xpath(EMP_xpath));
			if(EMP_ele.isDisplayed())
			{
				checkCoverages_1(tcID, coveragesList, val, values, "EMP" );
			}
		}
		
		if(dataSubDetails.getData("EPL").equalsIgnoreCase("Yes"))
		{
			String EPL_xpath ="//div[contains(text(),'Optional Endorsements - EPL')]";
			WebElement EPL_ele = getWebDriver().findElement(By.xpath(EPL_xpath));
			if(EPL_ele.isDisplayed())
			{
				checkCoverages_1(tcID, coveragesList, val, values, "EPL" );
			}
		}
		
		if(dataSubDetails.getData("ENO").equalsIgnoreCase("Yes"))
		{
			String ENO_xpath ="//div[contains(text(),'Optional Endorsements - ENO')]";
			WebElement ENO_ele = getWebDriver().findElement(By.xpath(ENO_xpath));
			if(ENO_ele.isDisplayed())
			{
				checkCoverages_1(tcID, coveragesList, val, values, "ENO" );
			}
		}
		
		if(dataSubDetails.getData("FID").equalsIgnoreCase("Yes"))
		{
			String FID_xpath ="//div[contains(text(),'Optional Endorsements - FID')]";
			WebElement FID_ele = getWebDriver().findElement(By.xpath(FID_xpath));
			if(FID_ele.isDisplayed())
			{
				checkCoverages_1(tcID, coveragesList, val, values, "FID" );
			}
		}
		
		
		if (!coveragesList.isEmpty()) 
		{
			System.out.println("Count of Coverages not found" + coveragesList.size());
			System.out.println("List of Coverages : " + coveragesList);
			CustomReporting.logReport("", "", "Number of Coverages Not Found : "+ coveragesList.size() + "  List of Coverages not found : " + coveragesList, StepStatus.FAILURE,
					new String[] {}, startTime);
			
		}
		
		
	}
	
	
	
	public void checkCoverages_1(String tcID, List<String> coveragesList, String val, String values[], String Cov) 
	{
			String pages = "//div[contains(text(),'Optional Endorsements - "+Cov+"')]/../../..//button[contains(@class,'pageButton')]";
			List<WebElement> totalPages = getWebDriver().findElements(By.xpath(pages));
			int totalPageCount;
			
			if(totalPages.size()==0)
			{
				totalPageCount = 1;
			}
			else
			{
				totalPageCount = totalPages.size();
			}
			long startTime = System.currentTimeMillis();
			
			// Iterating through all the pages
			for (int i = 0; i < (totalPageCount); i++)
			{
				if(!(totalPageCount==1))
				{
					StringBuilder xpathBuilder = new StringBuilder(pages).append("[" + (i + 1) + "]");
					getWebDriver().findElement(By.xpath(xpathBuilder.toString())).click();
				}
				
				String targetxpath = "//div[contains(text(),'Optional Endorsements - "+Cov+"')]/../../..//ui-repeating-row";
				int noOfRows = getWebDriver().findElements(By.xpath(targetxpath)).size();
		
				for (int j = 0; j < noOfRows+1; j++) 
				{
					int n=j+1;
					//String rowXpath = "//div[@class='formRowContainer row" + row++ + "']//input[@type='text']";
					String rowXpath = "//div[contains(text(),'Optional Endorsements - "+Cov+"')]/../../..//ui-repeating-row[" + n + "]/div/ui-text-input[2]/div/div/input";
					//15
					System.out.println(rowXpath);
					try 
					{
						String rowValue = (getWebDriver().findElement(By.xpath(rowXpath)).getAttribute("value"));
		
						for (String value : coveragesList)
						{
							if (rowValue.equalsIgnoreCase(value)) 
							{
								String checkboxXpath = rowXpath + "/../../../preceding-sibling::ui-checkbox/div//input";
								WebElement checkbox = getWebDriver().findElement(By.xpath(checkboxXpath));
								checkbox.click();
								
								_wait(2000);
		
								CustomReporting.logReport("", "",
								"Added the "+Cov+" coverage " + value + " sucessfully on the Optional Coverage page",
								StepStatus.SUCCESS, new String[] {}, startTime);
								coveragesList.remove(value);
								break;
							}
						}
					} 
					catch (Exception e)
					{
						e.printStackTrace();
					}
		
				}
		
			}
	}
	
	
	// ***************************************************************************************************

	public void UmPcPremiumValidation(String tcID) throws InterruptedException {
		PageData dataUmLogin = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
		long startTime = System.currentTimeMillis();
		
		String ExpectedPremium = (dataUmLogin.getData("Premium").replaceAll("(\\s+|\\$|,)", ""));;
		//String ExpectedPremium = pcPremium.replace("$", "");
		System.out.println("Premium " +ExpectedPremium);
		String UmPremium = (dataUmLogin.getData("UMPremium").replaceAll("(\\s+|\\$|,|USD)", ""));
		//String ActualPremium = UmPremium.replace("$", "");
		String ActualPremium = String.format("%.2f", Float.parseFloat(UmPremium));
		System.out.println("Actual premium "+ActualPremium);
		 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if (ExpectedPremium.equals((ActualPremium))) {
			CustomReporting.logReport("", "", "The UM and PC premiums are the same. Expected PC value: "+ ExpectedPremium + " Actual UM value: "+ActualPremium, StepStatus.SUCCESS, new String[] {},
					startTime);
		} else {
			CustomReporting.logReport("", "", "The UM and PC premiums have changed. Expected PC value: "+ ExpectedPremium + " Actual UM value: "+ActualPremium, StepStatus.FAILURE,
					new String[] {}, startTime);
			 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}

	}
	
	
	public void UmMunicipalTaxValidation(String tcID) throws InterruptedException {
		PageData dataUmLogin = PageDataManager.instance().getPageData("InsuredAppLogin", tcID);
		long startTime = System.currentTimeMillis();
		
		double municipalRate=Double.parseDouble(dataUmLogin.getData("MunicipalTaxRate"));
		double premiumValue=Double.parseDouble(dataUmLogin.getData("Premium").replaceAll("(\\s+|\\$|,)", ""));
		DecimalFormat decimalFormat = new DecimalFormat(".##");
		double expecMunicipalTax = Double.parseDouble(decimalFormat.format(municipalRate*premiumValue));
		double UmActualMucipalTax = Double.parseDouble((dataUmLogin.getData("UMKYMuncipalTax").replaceAll("(\\s+|\\$|,|USD)", "")));
		//String ActualPremium = UmPremium.replace("$", "");
		
		 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		if (expecMunicipalTax==UmActualMucipalTax) {
			CustomReporting.logReport("", "", "The UM is having municipal tax : "+ UmActualMucipalTax + " as expected ", StepStatus.SUCCESS, new String[] {},
					startTime);
		} else {
			CustomReporting.logReport("", "", "The UM is having municipal tax : "+ UmActualMucipalTax + " which is not expected ", StepStatus.FAILURE,
					new String[] {}, startTime);
			 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
		}

	}
	// ********************************
	public void searchExclusion(Iterator<String> coverageListIterator, long startTime) {
		_wait(10000);
		while (coverageListIterator.hasNext()) {
			String value = coverageListIterator.next();
			String rowValue = "//*[(div='" + value + "')]";
			try {
				WebElement exclusion = getWebDriver().findElement(By.xpath(rowValue));

				if (exclusion.getText().equals(value)) {

					CustomReporting.logReport("", "", "Coverage " + value + " is present on the Optional Coverage page",
							StepStatus.SUCCESS, new String[] {}, startTime);
					coverageListIterator.remove();

				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// ***************************************************************************************************

	public void validateExclusions(String tcID) {
		_wait(10000);
		String cov = "//*[contains(text(),'Coverages')]";
		WebElement Coverages = getWebDriver().findElement(By.xpath(cov));

		Coverages.click();
		String optionalcov = "//*[contains(text(),'Optional Coverages')]";
		WebElement OptionalCoverages = getWebDriver().findElement(By.xpath(optionalcov));

		OptionalCoverages.click();
		PageData dataLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		String val = (dataLogin.getData("AdditionalCoverages"));
		String values[] = val.split(";");
		List<String> coveragesList = new ArrayList<>(Arrays.asList(values));
		Iterator<String> coverageListIterator = coveragesList.iterator();
		int l = values.length;
		long startTime = System.currentTimeMillis();
		
		searchExclusion(coverageListIterator, startTime);
		System.out.println(coveragesList);
//		if (!coveragesList.isEmpty()) {
//			String CRItab = "//*[contains(text(),'CRI')]";
//			WebElement CRIOptionalCoverages = getWebDriver().findElement(By.xpath(CRItab));
//			CRIOptionalCoverages.click();
//			searchExclusion(coverageListIterator, startTime);
//		}
//		System.out.println(coveragesList);
//		if (!coveragesList.isEmpty()) {
//			String DNOtab = "//*[contains(text(),'DNO')]";
//			WebElement DNOOptionalCoverages = getWebDriver().findElement(By.xpath(DNOtab));
//			DNOOptionalCoverages.click();
//			searchExclusion(coverageListIterator, startTime);
//			}
		System.out.println(coveragesList);
//		if (!coveragesList.isEmpty()) {
//			String EPLtab = "//*[contains(text(),'CRI')]";
//			WebElement EPLOptionalCoverages = getWebDriver().findElement(By.xpath(EPLtab));
//			EPLOptionalCoverages.click();
//			searchExclusion(coverageListIterator, startTime);		}

//		if (!coveragesList.isEmpty()) {
//			System.out.println("Count of Coverages not found" + coveragesList.size());
//			System.out.println("List of Coverages : " + coveragesList);
//			CustomReporting.logReport("", "", "List of Coverages not found : " + coveragesList, StepStatus.FAILURE,
//					new String[] {}, startTime);
//		}

	}
	// ***************************************************************************************************
		@SuppressWarnings("unlikely-arg-type")
		public void validateTransactionHistory(String tcID, String strValue) {
			_wait(10000);
		long startTime = System.currentTimeMillis();
		PageData dataUmLogin = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);


			
			/*if (dataUmLogin.getData("PrivateCo").equalsIgnoreCase("Yes")) 
			{			
				String targetxpath = "//*[contains(text(),'PCIP')]";
				WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath)));
				ele.click();
				_wait(3000);

			} else if (dataUmLogin.getData("NFP").equalsIgnoreCase("Yes")) {
				String targetxpath1 = "//*[contains(text(),'NFPP')]";
				WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath1)));
				ele.click();
				_wait(3000);

			} else if (dataUmLogin.getData("CYBER").equalsIgnoreCase("Yes")) {
				if (dataUmLogin.getData("Department").equalsIgnoreCase("Financial Institutions"))
				{
					 String targetxpath2 = "//*[contains(text(),'FL5C')]";
						WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath2)));
						ele.click();
						_wait(3000);
				}
				else
				{
				String targetxpath2 = "//*[contains(text(),'SC5CY')]";
				WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath2)));
				ele.click();
				_wait(3000);
				}
			}else if (dataUmLogin.getData("Excess").equalsIgnoreCase("Yes")) {
				if (dataUmLogin.getData("Department").equalsIgnoreCase("Cyber Liability Group"))
				{
					String targetxpath2 = "//*[contains(text(),'C5YE')]";
					WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath2)));
					ele.click();
					_wait(3000);
				}
				else if (dataUmLogin.getData("Department").equalsIgnoreCase("Private Company Group"))
				{
					String targetxpath2 = "//*[contains(text(),'PC5E')]";
					WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath2)));
					ele.click();
					_wait(3000);
				}
				else if (dataUmLogin.getData("Department").equalsIgnoreCase("Professional Liability"))
				{
					String targetxpath2 = "//*[contains(text(),'CY5E')]";
					WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath2)));
					ele.click();
					_wait(3000);
				}
				
				else
				{
					String targetxpath2 = "//*[contains(text(),'SC5E')]";
					WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath2)));
					ele.click();
					_wait(3000);
				}
			} 
			else {
				 if (dataUmLogin.getData("Department").equalsIgnoreCase("Financial Institutions"))
				{
					 String targetxpath2 = "//*[contains(text(),'FL5L')]";
						WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath2)));
						ele.click();
						_wait(3000);
				}
				 else if (dataUmLogin.getData("Department").equalsIgnoreCase("Professional Liability"))
					{
						String targetxpath2 = "//*[contains(text(),'LPLP')]";
						WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath2)));
						ele.click();
						_wait(3000);
					}
				 else
				 {
					 String targetxpath2 = "//*[contains(text(),'LPLP')]";
						WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath2)));
						ele.click();
						_wait(3000);
				 }
			}*/
			
			 String targetxpath = "(//div[@class='treeControlArrow' and button[@tabindex='1']])[2]/..//span";
				WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath)));
				ele.click();
				_wait(3000);
	
			
			if (strValue.equalsIgnoreCase("PolicyChange"))
			{
				try {
					String targetxpath2 = "//*[contains(text(),'Policy Change')]";
					WebElement ele2 = (getWebDriver().findElement(By.xpath(targetxpath2)));
					
				} catch (Exception ex) {
					String exceptionText = ex.toString();
					
					if (exceptionText.contains("org.openqa.selenium.NoSuchElementException: Unable to find element with xpath == //*[contains(text(),'Policy Change')] ")){	
						{
							CustomReporting.logReport("", "", "Policy Change Transaction detail is not present as expected " , StepStatus.SUCCESS, new String[] {},
									startTime);
						} 
						 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
				
			}
						_wait(2000);
		}
			if (strValue.equalsIgnoreCase("Cancellation"))
			{
				String targetxpath3 = "//*[contains(text(),'Cancellation')]";
				WebElement ele3 = (getWebDriver().findElement(By.xpath(targetxpath3)));
				if (!(ele3.equals(""))) 
				{
					{
						CustomReporting.logReport("", "", "Policy Cancellation Transaction details is present as expected " , StepStatus.SUCCESS, new String[] {},
								startTime);
					}
					 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
			}
			if (strValue.equalsIgnoreCase("Reinstatement"))
			{
				String targetxpath4 = "//*[contains(text(),'Reinstatement')]";
				WebElement ele4 = (getWebDriver().findElement(By.xpath(targetxpath4)));
				if (!(ele4.equals(""))) 
				{
					{
						CustomReporting.logReport("", "", "Policy Reinstatement Transaction details is present as expected" , StepStatus.SUCCESS, new String[] {},
								startTime);
					}
				}
			}
			if (strValue.equalsIgnoreCase("Rewrite"))
			{
				try {
					String targetxpath5 = "//*[contains(text(),'Rewrite')]";
					
					WebElement ele5 = (getWebDriver().findElement(By.xpath(targetxpath5)));
					
					
				} catch (Exception ex) {
					String exceptionText = ex.toString();
					
					if (exceptionText.contains("org.openqa.selenium.NoSuchElementException: Unable to find element with xpath == //*[contains(text(),'Rewrite')] ")){	
						{
							CustomReporting.logReport("", "", "Policy Rewrite Transaction detail is not present as expected " , StepStatus.SUCCESS, new String[] {},
									startTime);
						} 
				}
				
			}
						_wait(2000);
		}

		}
// ***************************************************************************************************
				
				public void validateSubmissionNo(String tcID) {
					_wait(10000);
				long startTime = System.currentTimeMillis();

					String targetxpath = "//*[contains(span,'Summary')]";
					WebElement ele = (getWebDriver().findElement(By.xpath(targetxpath)));
					ele.click();
					_wait(3000);
					
					String targetExpectedxpath = "//*[contains(text(),'Cancellation')]/../following-sibling::td[1]";
					WebElement ele1 = (getWebDriver().findElement(By.xpath(targetExpectedxpath)));
					String expectedValue = ele1.getText();
					
					String targetActualxpath = "//*[contains(text(),'Rewrite Full Term')]/../following-sibling::td[1]";
					WebElement ele2 = (getWebDriver().findElement(By.xpath(targetActualxpath)));
					String actualValue = ele2.getText();
					
					if (expectedValue.equals(actualValue))
					{
						CustomReporting.logReport("", "", "The submission numbers are same which is not expected : " , StepStatus.FAILURE,
								new String[] {}, startTime);	
					}
					else
					{
						CustomReporting.logReport("", "", "The submission numbers are different as expected " , StepStatus.SUCCESS,
								new String[] {}, startTime);
					}
					
					
				}
				
				public void clickRight() throws InterruptedException {
					Robot robot = null;
					try {
						robot = new Robot();
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Thread.sleep(1000);
					robot.keyPress(KeyEvent.VK_RIGHT);

				}
				
				
				
				public void _focusBrowser () throws Exception{
					  
					  try {
					           
					   //String strDeviceName=GenericFunctions.instance()._getGlobalVariableValue("deviceName");
						  			
					   File directory = new File("./");
					   System.out.println(directory.getAbsolutePath());
					   String strDirectoryPath =directory.getAbsolutePath().split("\\.") [0];
					   String strBundlePath=strDirectoryPath+"resources\\Images";
					   ImagePath.setBundlePath(strBundlePath);
					            Screen screen = new Screen();
					   Pattern img_Desktop = new Pattern("Desktop.PNG");
					            Robot robot=new Robot();
					            
					            try {
					             screen.find(img_Desktop);
					             robot.keyPress(KeyEvent.VK_ALT);
					    robot.keyPress(KeyEvent.VK_TAB);
					    robot.keyRelease(KeyEvent.VK_ALT);
					    robot.keyRelease(KeyEvent.VK_TAB);
					    _wait(2000); 
					    CustomReporting.logReport("Browser brought to the foreground");
					            }
					            catch(Exception ex){
					             
					            }
					   
					  }
					  
					     finally {
					      
					    }
					 }
				
	/*******************************************************************
	 * Name : _setValue2 Description : Perform enter
	 * 
	 * 
	 ********************************************************************/
	public void setValue2(Element element) throws InterruptedException {
		// long startTime = System.currentTimeMillis();
		String xpath = element.getKey().toString();
		_wait(3000);
		new Actions(getWebDriver()).moveToElement(getWebDriver().findElement(By.xpath(xpath))).sendKeys(Keys.ENTER)
				.build().perform();

		_wait(500);
		/*
		 * if (getWebDriver().findElement(By.xpath(xpath)).getText().equals(data)) {
		 * CustomReporting.logReport("", "", "Set the value of the " + elementName +
		 * " element to " + data + " sucessfully on the page " + pageName + "",
		 * StepStatus.SUCCESS, new String[] {}, startTime); } else {
		 * CustomReporting.logReport("", "", "Unable to Set the value of the " +
		 * elementName + " element in" + pageName + "  to " + data + " ",
		 * StepStatus.FAILURE, new String[] {}, startTime);
		 * 
		 * }
		 */
	}

	public void setValue3(Element element) throws InterruptedException {
		// long startTime = System.currentTimeMillis();
		String xpath = element.getKey().toString();
		_wait(3000);
		new Actions(getWebDriver()).moveToElement(getWebDriver().findElement(By.xpath(xpath))).sendKeys(Keys.TAB)
				.build().perform();

		_wait(500);
	}

	public void setValue4(Element element) throws InterruptedException {
		// long startTime = System.currentTimeMillis();
		String xpath = element.getKey().toString();
		_wait(3000);
		new Actions(getWebDriver()).moveToElement(getWebDriver().findElement(By.xpath(xpath))).sendKeys(Keys.DOWN)
				.build().perform();

		_wait(500);
	}

	public void setValue5(Element element) throws InterruptedException {
		// long startTime = System.currentTimeMillis();
		String xpath = element.getKey().toString();
		_wait(3000);
		new Actions(getWebDriver()).moveToElement(getWebDriver().findElement(By.xpath(xpath))).sendKeys(Keys.ESCAPE)
				.build().perform();

		_wait(500);
	}

	public void setValue6() throws InterruptedException {
		// long startTime = System.currentTimeMillis();
		_wait(3000);
		new Actions(getWebDriver()).sendKeys(Keys.ENTER).build().perform();

		_wait(500);
	}

	public void setValue7() throws InterruptedException {
		// long startTime = System.currentTimeMillis();
		_wait(3000);
		new Actions(getWebDriver()).sendKeys(Keys.ENTER).build().perform();

		_wait(500);
	}

	public void setValue8() throws InterruptedException {
		// long startTime = System.currentTimeMillis();
		_wait(3000);
		new Actions(getWebDriver()).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_RIGHT).build()
				.perform();

		_wait(500);
	}

	public void setValue9() throws InterruptedException {
		// long startTime = System.currentTimeMillis();
		_wait(3000);
		new Actions(getWebDriver()).sendKeys(Keys.TAB).build().perform();

		_wait(500);
	}

	public void setValue10() throws InterruptedException {
		// long startTime = System.currentTimeMillis();
		_wait(3000);
		new Actions(getWebDriver()).sendKeys(Keys.SPACE).build().perform();

		_wait(500);
	}

	public void setValue11() throws InterruptedException {
		// long startTime = System.currentTimeMillis();
		_wait(3000);
		new Actions(getWebDriver()).sendKeys(Keys.ALT).build().perform();

		_wait(500);
	}
	public void setValue12(Element element) throws InterruptedException {
		// long startTime = System.currentTimeMillis();
		String xpath = element.getKey().toString();
		_wait(3000);
		new Actions(getWebDriver()).moveToElement(getWebDriver().findElement(By.xpath(xpath))).sendKeys(Keys.SPACE)
				.build().perform();

		_wait(500);
	}
	public void setValue13() throws InterruptedException {
		// long startTime = System.currentTimeMillis();
		_wait(3000);
		new Actions(getWebDriver()).sendKeys(Keys.BACK_SPACE).build().perform();

		_wait(500);
	}
	public void formsValidation(String tcID) 
	{
		_wait(10000);
		String policyTab = "(//*[contains(text(),'Proposal 1')]/../../..//button[1])[3]";
		WebElement policyTabpage = getWebDriver().findElement(By.xpath(policyTab));
		policyTabpage.click();
		_wait(5000);
		String formTab = "//*[contains(text(),'Policy Forms')]";
		WebElement FormsPage = getWebDriver().findElement(By.xpath(formTab));

		FormsPage.click();
		_wait(5000);
		FormsPage.click();
		_wait(10000);
		PageData dataLogin = PageDataManager.instance().getPageData("Forms", tcID);
		String val = (dataLogin.getData("FormsValidation"));
		String values[] = val.split(";");
		List<String> coveragesList = new ArrayList<>(Arrays.asList(values));
		int l = values.length;
		 String pages = "//button[contains(@class,'pageButton')]";
		 long startTime = System.currentTimeMillis();
		 int row = 0;
		int pg = (getWebDriver().findElements(By.xpath(pages))).size();
		// if(getWebDriver().findElements(By.xpath(pages))!= null)
		 if(pg != 0)
		 {
				 List<WebElement> totalPages = getWebDriver().findElements(By.xpath(pages));
				 int totalPageCount = totalPages.size(); 
				 
				 for (int i = 0; i < (totalPageCount); i++) {
						StringBuilder xpathBuilder = new StringBuilder(pages).append("[" + (i + 1) + "]");
						getWebDriver().findElement(By.xpath(xpathBuilder.toString())).click();
						_wait(3000);
						String targetxpath = "//ui-repeating-row";
						int noOfRows = getWebDriver().findElements(By.xpath(targetxpath)).size();
						
						
						// Iterating through all the pages

						// Clicking on the pageNo button
						// totalPages.get(i).click();
//						String targetxpath1 = "//ui-repeating-row";
//						int noOfRows1 = getWebDriver().findElements(By.xpath(targetxpath1)).size();
						
						for (int j = 0; j < noOfRows; j++) {
							String rowXpath = "//div[@class='formRowContainer row" + row + "']//input[@type='text']";
							row++;
							System.out.println(rowXpath);
							try {
								String rowValue = (getWebDriver().findElement(By.xpath(rowXpath)).getAttribute("value"));

								for (String value : coveragesList) {
									if (rowValue.equalsIgnoreCase(value)) {
										_wait(2000);

										CustomReporting.logReport("", "", "Form " + value + " is present in the Policy form screen",
												StepStatus.SUCCESS, new String[] {}, startTime);
										coveragesList.remove(value);
										break;
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

						}

						
				 }
		 }
	
		 else
				 {
		// List<WebElement> totalPages = getWebDriver().findElements(By.xpath(pages));
		// int totalPageCount = totalPages.size();
					 
		
		
		// Iterating through all the pages

		// Clicking on the pageNo button
		// totalPages.get(i).click();
		String targetxpath = "//ui-repeating-row";
		int noOfRows = getWebDriver().findElements(By.xpath(targetxpath)).size();

		for (int j = 0; j < noOfRows; j++) 
		{
			String rowXpath = "//div[@class='formRowContainer row" + row + "']//input[@type='text'][1]";
			row++;
			System.out.println(rowXpath);
			try {
				String rowValue = (getWebDriver().findElement(By.xpath(rowXpath)).getAttribute("value"));

				for (String value : coveragesList) {
					if (rowValue.equalsIgnoreCase(value)) {
						_wait(2000);

						CustomReporting.logReport("", "", "Form " + value + " is present in the Policy form screen",
								StepStatus.SUCCESS, new String[] {}, startTime);
						coveragesList.remove(value);
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		
	}
		 if (!coveragesList.isEmpty())
		 {
				System.out.println("Count of Forms not found" + coveragesList.size());
				System.out.println("List of Forms : " + coveragesList);
				CustomReporting.logReport("", "", "List of Forms not found : " + coveragesList, StepStatus.FAILURE,
						new String[] {}, startTime);

		}
		 
	}	
	public void checkProducer(String tcID) {
		_wait(10000);
		long startTime = System.currentTimeMillis();
		PageData dataLogin = PageDataManager.instance().getPageData("UmLogin", tcID);
		String val = (dataLogin.getData("Producer"));
		String values[] = val.split(";");
		int l = values.length;

		for (int j=0; j<l; j++) 
		{
			
			if (j==0) {
				String targetxpath = "//*[contains(text(),'Producer Office')]/../../following-sibling::div[1]//button";
				WebElement btn = getWebDriver().findElement(By.xpath(targetxpath));
				btn.click();
				_wait(2000);
				String targetxpath2 = "/html/body/div[5]/um-dropdown-list";
				WebElement btn2 = getWebDriver().findElement(By.xpath(targetxpath2));
				btn2.sendKeys(values[j]);
			} 
			else 
			{
				_wait(2000);
				String targetxpath = "/html/body/div[5]/um-dropdown-search/input";
				WebElement btn = getWebDriver().findElement(By.xpath(targetxpath));
				btn.clear();
				_wait(2000);
				String targetxpath2 = "/html/body/div[5]/um-dropdown-list";
				WebElement btn2 = getWebDriver().findElement(By.xpath(targetxpath2));
				btn2.sendKeys(values[j]);
				_wait(2000);
			}
			String expoption1 = "/html/body/div[5]/um-dropdown-list//*[contains(text(),\"" + values[j] + "\")]";
			
			if (getWebDriver().findElements(By.xpath(expoption1)).size()!=0)
			{
				CustomReporting.logReport("", "", "The Producer code is present :  "+ values[j], StepStatus.SUCCESS,
						new String[] {}, startTime);
			}
//			try {
//				WebElement expectedOption1 = (getWebDriver().findElement(By.xpath(expoption1)));
//				
//		    } 
			else
			{
				CustomReporting.logReport("", "", "The Producer code is not present : "+ values[j], StepStatus.FAILURE,
					new String[] {}, startTime);
			}
//			catch (NoSuchElementException e) {
//				String exceptionText = e.toString();
//				
//				if (exceptionText.contains("org.openqa.selenium.NoSuchElementException: Unable to find element with xpath == /html/body/div[5]/um-dropdown-list//*[contains(text(),\"" + values[j] + "\")]"));
//					{
//		    	CustomReporting.logReport("", "", "The Producer code is not present : ", StepStatus.FAILURE,
//						new String[] {}, startTime);
//					}
//				}
			
	}
	}
	
		public void selectDropdown(String strValue) {
		String expoption = "/html/body/div[3]/um-dropdown-list//*[contains(text(),\""+strValue+"\")]";
		WebElement expectedOption = (getWebDriver().findElement(By.xpath(expoption)));
		expectedOption.click();
	}
		
		public void validateCheckbox(Element element) {
			_wait(3000);
			String xpath = element.getKey().toString();
			
			WebElement checkbox = getWebDriver().findElement(By.xpath(xpath));
			
			 if (!checkbox.isSelected())
			 {
				 element.click();
				
			 }
			 else
			 {
				 element.click();
		}
		}
		public long DateFormatReturns (String strDate, String strSelectOption) throws Exception 
		{
			long returnValue = 0;
			try
			{
				
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
				Date date = new Date();
				System.out.println(dateFormat.format(date));
				Date datenew=new SimpleDateFormat("MM/dd/yyyy").parse(strDate);
				System.out.println(dateFormat.format(datenew));
				Date datecurr = new Date(date.getYear(),date.getMonth(),date.getDay());
		        Date dateexp = new Date(datenew.getYear(),datenew.getMonth(),datenew.getDay());
		        Calendar calendar1 = Calendar.getInstance();
		        Calendar calendar2 = Calendar.getInstance();
		        calendar1.setTime(datecurr);
		        calendar2.setTime(dateexp);
		        long milliseconds1 = calendar1.getTimeInMillis();
		        long milliseconds2 = calendar2.getTimeInMillis();
		       
		        
		        switch (strSelectOption.toUpperCase())
		        {
					case "DAYS":
						 long diff = milliseconds2 - milliseconds1;
						 returnValue=diff / (24 * 60 * 60 * 1000);
						
		        }
			}
			catch(Exception ex)
			{
				
	        	throw ex;
	        	
				
			}
			return returnValue;	
				
		}	
		
		
		public void ValidatePreSelectedForms(String tcID) 
		{
			PageData dataForms = PageDataManager.instance().getPageData("Forms", tcID);
			PageData dataSubDetails = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
			
			String val = (dataForms.getData("PreSelectedFormsValidation"));
			String values[] = val.split(";");
			long startTime = System.currentTimeMillis();
			List<String> FormsList = new ArrayList<>(Arrays.asList(values));
			_wait(10000);
			
			String optionalEnd = "//*[contains(text(),'Rating: Optional Endts')]";
			WebElement RatingoptionalEnd = getWebDriver().findElement(By.xpath(optionalEnd));
			RatingoptionalEnd.click();
			
			if(dataSubDetails.getData("KNR").equalsIgnoreCase("Yes"))
			{
				String KNR_xpath ="//div[contains(text(),'Optional Endorsements - KNR')]";
				WebElement KNR_ele = getWebDriver().findElement(By.xpath(KNR_xpath));
				if(KNR_ele.isDisplayed())
				{
					ValidateFormSelection(tcID, FormsList, val, values, "KNR" );
				}
			}
			
			if(dataSubDetails.getData("CyberCov").equalsIgnoreCase("Yes"))
			{
				String CYB_xpath ="//div[contains(text(),'Optional Endorsements - CYB')]";
				WebElement CYB_ele = getWebDriver().findElement(By.xpath(CYB_xpath));
				if(CYB_ele.isDisplayed())
				{
					ValidateFormSelection(tcID, FormsList, val, values, "CYB");
				}
			}
			
			if(dataSubDetails.getData("CRIME").equalsIgnoreCase("Yes"))
			{
				String CRI_xpath ="//div[contains(text(),'Optional Endorsements - CRI')]";
				WebElement CRI_ele = getWebDriver().findElement(By.xpath(CRI_xpath));
				if(CRI_ele.isDisplayed())
				{
					ValidateFormSelection(tcID, FormsList, val, values, "CRI");
				}
			}
			
			if(dataSubDetails.getData("DNO").equalsIgnoreCase("Yes"))
			{
				String DNO_xpath ="//div[contains(text(),'Optional Endorsements - DNO')]";
				WebElement DNO_ele = getWebDriver().findElement(By.xpath(DNO_xpath));
				if(DNO_ele.isDisplayed())
				{
					ValidateFormSelection(tcID, FormsList, val, values, "DNO" );
				}
			}
			
			String Common_xpath ="//div[contains(text(),'Optional Endorsements - Common')]";
			WebElement Common_ele = getWebDriver().findElement(By.xpath(Common_xpath));
			if(Common_ele.isDisplayed())
			{
				ValidateFormSelection(tcID, FormsList, val, values, "Common" );
			}
			
			if(dataSubDetails.getData("EMP").equalsIgnoreCase("Yes"))
			{
				String EMP_xpath ="//div[contains(text(),'Optional Endorsements - EMP')]";
				WebElement EMP_ele = getWebDriver().findElement(By.xpath(EMP_xpath));
				if(EMP_ele.isDisplayed())
				{
					ValidateFormSelection(tcID, FormsList, val, values, "EMP" );
				}
			}
			
			if(dataSubDetails.getData("EPL").equalsIgnoreCase("Yes"))
			{
				String EPL_xpath ="//div[contains(text(),'Optional Endorsements - EPL')]";
				WebElement EPL_ele = getWebDriver().findElement(By.xpath(EPL_xpath));
				if(EPL_ele.isDisplayed())
				{
					ValidateFormSelection(tcID, FormsList, val, values, "EPL" );
				}
			}
			
			if(dataSubDetails.getData("ENO").equalsIgnoreCase("Yes"))
			{
				String ENO_xpath ="//div[contains(text(),'Optional Endorsements - ENO')]";
				WebElement ENO_ele = getWebDriver().findElement(By.xpath(ENO_xpath));
				if(ENO_ele.isDisplayed())
				{
					ValidateFormSelection(tcID, FormsList, val, values, "ENO" );
				}
			}
			
			if(dataSubDetails.getData("FID").equalsIgnoreCase("Yes"))
			{
				String FID_xpath ="//div[contains(text(),'Optional Endorsements - FID')]";
				WebElement FID_ele = getWebDriver().findElement(By.xpath(FID_xpath));
				if(FID_ele.isDisplayed())
				{
					ValidateFormSelection(tcID, FormsList, val, values, "FID" );
				}
			}
			
			
			if (!FormsList.isEmpty()) 
			{
				System.out.println("Number of Forms not found" + FormsList.size());
				System.out.println("List of Forms : " + FormsList);
				CustomReporting.logReport("", "", "Number of Forms Not Pre Selected : "+ FormsList.size() + "  Name of Forms Not Pre Selected :  " + FormsList, StepStatus.FAILURE,
						new String[] {}, startTime);
				
			}
			
			
		}
		
		public void ValidateFormSelection(String tcID, List<String> FormsList, String val, String values[], String Cov) 
		{
				String pages = "//div[contains(text(),'Optional Endorsements - "+Cov+"')]/../../..//button[contains(@class,'pageButton')]";
				List<WebElement> totalPages = getWebDriver().findElements(By.xpath(pages));
				int totalPageCount;
				Actions actions = new Actions(getWebDriver());
				
				if(totalPages.size()==0)
				{
					totalPageCount = 1;
				}
				else
				{
					totalPageCount = totalPages.size();
				}
				long startTime = System.currentTimeMillis();
				
				// Iterating through all the pages
				for (int i = 0; i < (totalPageCount); i++)
				{
					if(!(totalPageCount==1))
					{
						StringBuilder xpathBuilder = new StringBuilder(pages).append("[" + (i + 1) + "]");
						getWebDriver().findElement(By.xpath(xpathBuilder.toString())).click();
					}
					
					String targetxpath = "//div[contains(text(),'Optional Endorsements - "+Cov+"')]/../../..//ui-repeating-row";
					int noOfRows = getWebDriver().findElements(By.xpath(targetxpath)).size();
			
					for (int j = 0; j < noOfRows+1; j++) 
					{
						int n=j+1;
						
						String rowXpath = "//div[contains(text(),'Optional Endorsements - "+Cov+"')]/../../..//ui-repeating-row[" + n + "]/div/ui-text-input[2]/div/div/input";
						//15
						System.out.println(rowXpath);
						try 
						{
							String rowValue = (getWebDriver().findElement(By.xpath(rowXpath)).getAttribute("value"));
			
							for (String value : FormsList)
							{
								if (rowValue.equalsIgnoreCase(value)) 
								{
									String checkboxXpath = rowXpath + "/../../../preceding-sibling::ui-checkbox/div//input";
									WebElement checkbox = getWebDriver().findElement(By.xpath(checkboxXpath));
									if(checkbox.isSelected()==true)
									{
										actions.moveToElement(checkbox);
										actions.perform();
										_takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
										CustomReporting.logReport("", "",
												"Form "+value+" is Pre Selected as Expected",
												StepStatus.SUCCESS, new String[] {}, startTime);
												
									}
									else
									{
										actions.moveToElement(checkbox);
										actions.perform();
										_takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
										CustomReporting.logReport("", "",
												"Form "+value+" is NOT Pre Selected",
												StepStatus.FAILURE, new String[] {}, startTime);
									}
									FormsList.remove(value);
									break;
									
								}
							}
						} 
						catch (Exception e)
						{
							e.printStackTrace();
						}
			
					}
			
				}
		}
		
		public void PDF_Compare(String file, String tcID) throws IOException 
		{
			long startTime = System.currentTimeMillis();
			File directory = new File("./");
			String strDirectoryPath = directory.getAbsolutePath().split("\\.")[0];
			String PDF_Filepath = DeviceManager.instance().getConfigurationProperties().getProperty("pdf.path")+file+".pdf";
			String actpath = strDirectoryPath+PDF_Filepath;
			PdfReader readertext = new PdfReader(actpath);
	        PdfReaderContentParser parser = new PdfReaderContentParser(readertext);
	        TextExtractionStrategy strategy = null;
	        String temp="";
	        String FormListPage="";
	        int totalpgs = readertext.getNumberOfPages();   
	        
	        PageData dataForms = PageDataManager.instance().getPageData("Forms", tcID);
			String val = (dataForms.getData("FormsValidation"));
			String values[] = val.split(";");
			List<String> FormsList = new CopyOnWriteArrayList<String>();//<>(Arrays.asList(values));new CopyOnWriteArrayList<String>();
			for (String a : values) 
			{
				FormsList.add(a);
			}
			
	        
	         for(int j = 1; j <= totalpgs; j++) 
	          {
	        	  strategy = parser.processContent(j,new SimpleTextExtractionStrategy());
                  FormListPage=" PDF Page No : " +j+strategy.getResultantText();//FormListPage
                  System.out.println();
                  System.out.println(FormListPage);
                 
                  try
		          {
		                  for (String value : FormsList) 
							{
								if(FormListPage.contains(value)) 
								{
									_wait(2000);
									CustomReporting.logReport("", "", "Expected Value " + value + " is present in the PDF Document : "+file+" in Page "+j,
											StepStatus.SUCCESS, new String[] {}, startTime);
									if (j>10) 
									{
										FormsList.remove(value);
									}
									
								}
							}
                  }
                  catch(Exception e)
                  {
                	  e.printStackTrace();
                  }
		        
	          }
	          
	         try {
				if (dataForms.getData("InWitnessForm").equalsIgnoreCase("Yes")) {
					strategy = parser.processContent(totalpgs, new SimpleTextExtractionStrategy());
					FormListPage = FormListPage + " PDF Page No : " + totalpgs + strategy.getResultantText();
					System.out.println();
					System.out.println(FormListPage);
					if (FormListPage.contains("IN WITNESS")) {
						_wait(2000);
						CustomReporting.logReport("", "", "Expected Form IN WITNESS is present in the PDF Document : "
								+ file + " in Last Page " + totalpgs, StepStatus.SUCCESS, new String[] {}, startTime);

					} else {
						_wait(2000);
						CustomReporting
								.logReport("", "",
										"Expected Form IN WITNESS is NOT present in the PDF Document : " + file
												+ " in Last Page " + totalpgs,
										StepStatus.FAILURE, new String[] {}, startTime);
					}
				} 
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (!FormsList.isEmpty())
	 		 {
	 				System.out.println("Number of Forms not found" + FormsList.size());
	 				System.out.println("Name of Forms : " + FormsList);
	 				CustomReporting.logReport("", "", "Expected Values not found in the PDF Document : "+file+" are :" + FormsList+" Count : "+FormsList.size(), StepStatus.FAILURE,
	 						new String[] {}, startTime);
	 		 }
	          
	          
		}
		
		public void PDF_Compare_PC(String file, String tcID) throws IOException 
		{
			long startTime = System.currentTimeMillis();
			File directory = new File("./");
			String strDirectoryPath = directory.getAbsolutePath().split("\\.")[0];
			String PDF_Filepath = DeviceManager.instance().getConfigurationProperties().getProperty("pdf.path")+file+".pdf";
			String actpath = strDirectoryPath+PDF_Filepath;
			PdfReader readertext = new PdfReader(actpath);
	        PdfReaderContentParser parser = new PdfReaderContentParser(readertext);
	        TextExtractionStrategy strategy = null;
	        String temp="";
	        String FormListPage="";
	        int totalpgs = readertext.getNumberOfPages();   
	        
	        PageData dataForms = PageDataManager.instance().getPageData("Forms", tcID);
			String val = (dataForms.getData("FormsValidation"));
			String values[] = val.split(";");
			List<String> FormsList = new CopyOnWriteArrayList<String>();//<>(Arrays.asList(values));new CopyOnWriteArrayList<String>();
			for (String a : values) 
			{
				FormsList.add(a);
			}
			
	        
	         for(int j = 1; j <= totalpgs; j++) 
	          {
	        	  strategy = parser.processContent(j,new SimpleTextExtractionStrategy());
                  FormListPage=" PDF Page No : " +j+strategy.getResultantText();//FormListPage
                  System.out.println();
                  System.out.println(FormListPage);
                 
                  try
		          {
		                  for (String value : FormsList) 
							{
								if(FormListPage.contains(value)) 
								{
									_wait(2000);
									CustomReporting.logReport("", "", "Expected Value " + value + " is present in the PDF Document : "+file+" in Page "+j,
											StepStatus.SUCCESS, new String[] {}, startTime);
									FormsList.remove(value);
									
									
								}
							}
                  }
                  catch(Exception e)
                  {
                	  e.printStackTrace();
                  }
		        
	          }
	        if (!FormsList.isEmpty())
	 		 {
	 				System.out.println("Number of Forms not found" + FormsList.size());
	 				System.out.println("Name of Forms : " + FormsList);
	 				CustomReporting.logReport("", "", "Expected Values not found in the PDF Document : "+file+" are :" + FormsList+" Count : "+FormsList.size(), StepStatus.FAILURE,
	 						new String[] {}, startTime);
	 		 }
	          
	          
		}
		
		public void umpcPremiumValidationIntlAdd(String tcID) throws InterruptedException 
		{
			PageData dataUmLogin = PageDataManager.instance().getPageData("InternationalAddress", tcID);
			PageData dataUmLogin1 = PageDataManager.instance().getPageData("UMSubmissionDetails", tcID);
			long startTime = System.currentTimeMillis();
			CustomReporting.logReport("Validating the Premiums between the UM and PC with International Currency: "+dataUmLogin1.getData("PolicyCurrency")+" and International Address: "+dataUmLogin1.getData("Country"));
			String umTotalPremium = (dataUmLogin.getData("umTotalPremium").replaceAll("\\W", ""));
			String pcTotalPremiumOld = (dataUmLogin.getData("pcTotalPremium"));
			String pcTotalPremiumNew = pcTotalPremiumOld.replaceAll("\\.0*$", "");
			String pcTotalPremium = pcTotalPremiumNew.replaceAll("[^0-9]", "");
			String umBINDFXRate = (dataUmLogin.getData("umBINDFXRate"));
			String pcBINDFXRate = (dataUmLogin.getData("pcBINDFXRate"));
			String umUSDPremium = (dataUmLogin.getData("umUSDPremium").replaceAll("\\W", ""))+".00";
			String pcUSDPremium = (dataUmLogin.getData("pcUSDPremium").replaceAll("(\\s+|\\$|,)", ""));;
			
				
			if (umTotalPremium.equals((pcTotalPremium))) {
				CustomReporting.logReport("", "", "The UM and PC Itl premiums are the same. Expected PC value: "+ umTotalPremium + " Actual UM value: "+pcTotalPremium, StepStatus.SUCCESS, new String[] {},
						startTime);
			} else {
				CustomReporting.logReport("", "", "The UM and PC Itl premiums have changed. Expected PC value: "+ umTotalPremium + " Actual UM value: "+pcTotalPremium, StepStatus.FAILURE,
						new String[] {}, startTime);
				 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			}
			
			
			if(!dataUmLogin.getData("umPolicyCurrency").equalsIgnoreCase("USD"))
			{
				
				if (umBINDFXRate.equals((pcBINDFXRate))) {
					CustomReporting.logReport("", "", "The UM and PC FX Rate are the same. Expected PC value: "+ umBINDFXRate + " Actual UM value: "+pcBINDFXRate, StepStatus.SUCCESS, new String[] {},
							startTime);
				} else {
					CustomReporting.logReport("", "", "The UM and PC FX Rate have changed. Expected PC value: "+ umBINDFXRate + " Actual UM value: "+pcBINDFXRate, StepStatus.FAILURE,
							new String[] {}, startTime);
					 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
				
				if (umUSDPremium.equals((pcUSDPremium))) {
					CustomReporting.logReport("", "", "The UM and PC USD premiums are the same. Expected PC value: "+ umUSDPremium + " Actual UM value: "+pcUSDPremium, StepStatus.SUCCESS, new String[] {},
							startTime);
				} else {
					CustomReporting.logReport("", "", "The UM and PC USD premiums have changed. Expected PC value: "+ umUSDPremium + " Actual UM value: "+pcUSDPremium, StepStatus.FAILURE,
							new String[] {}, startTime);
					 _takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				}
			}

		}
		
		public void VerifyOptionalEndts(String tcID) 
		{
			long startTime = System.currentTimeMillis();
			String optionalEnd = "//*[contains(text(),'Rating: Optional Endts')]";
			WebElement RatingoptionalEnd = getWebDriver().findElement(By.xpath(optionalEnd));
			RatingoptionalEnd.click();
			_takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
			
			String HeaderLabel_OptnlEndts = "//div[contains(text(),'Optional Endorsements')]";
			if(getWebDriver().findElement(By.xpath(HeaderLabel_OptnlEndts)).isDisplayed())
			{
				_takeBrowserScreenShot(getWebDriver(), "PRINT", getWebDriver().getCurrentUrl(), "");
				
				CustomReporting.logReport("", "",
						"Optional Endts Screen is Visible as expected For EPRO79781",
						StepStatus.SUCCESS, new String[] {}, startTime);
			}
			else
			{
				CustomReporting.logReport("", "",
						"Optional Endts Screen is NOT as expected For EPRO79781",
						StepStatus.FAILURE, new String[] {}, startTime);
			}
		}
		
		
		public void PDF_Compare_Pagewise(String file, String tcID) throws IOException 
		{
			long startTime = System.currentTimeMillis();
			File directory = new File("./");
			String strDirectoryPath = directory.getAbsolutePath().split("\\.")[0];
			String PDF_Filepath = DeviceManager.instance().getConfigurationProperties().getProperty("pdf.path")+file+".pdf";
			String actpath = strDirectoryPath+PDF_Filepath;
			PdfReader readertext = new PdfReader(actpath);
	        PdfReaderContentParser parser = new PdfReaderContentParser(readertext);
	        TextExtractionStrategy strategy = null;
	        //String temp="";
	        String FormListPage="";
	        //int totalpgs = readertext.getNumberOfPages();   
	        
	        PageData dataForms = PageDataManager.instance().getPageData("Forms", tcID);
			String val = (dataForms.getData("PageData"));
			String pg_num = (dataForms.getData("PageNumbers"));
			String values[] = val.split(";");
			String pg_num1[] = pg_num.split(";");
			List<String> FormsList = new CopyOnWriteArrayList<String>();//<>(Arrays.asList(values));new CopyOnWriteArrayList<String>();
			List<String> PgList = new CopyOnWriteArrayList<String>();
			for (String a : values) 
			{
				FormsList.add(a);
			}
			for (String b : pg_num1) 
			{
				PgList.add(b);
			}
			
	        for(int i=0;i<PgList.size();i++)
	        {	  strategy = parser.processContent(Integer.parseInt(PgList.get(i)),new SimpleTextExtractionStrategy());
                  FormListPage=" PDF Page No : " +Integer.parseInt(PgList.get(i))+strategy.getResultantText();
                  System.out.println();
                  System.out.println(FormListPage);
                 
                  try
		          {
		                  for (String value : FormsList) 
							{
								if(FormListPage.contains(value)) 
								{
									_wait(2000);
									CustomReporting.logReport("", "", "Expected Value " + value + " is present in the PDF Document : "+file+" in Page "+Integer.parseInt(PgList.get(i)),
											StepStatus.SUCCESS, new String[] {}, startTime);
									FormsList.remove(value);
									
								}
							}
                  }
                  catch(Exception e)
                  {
                	  e.printStackTrace();
                  }
	        }
		    if (!FormsList.isEmpty())
	 		 {
	 				System.out.println("Number of Values not found" + FormsList.size());
	 				System.out.println("Values : " + FormsList);
	 				CustomReporting.logReport("", "", "Expected Values not found in the PDF Document : "+file+" are :" + FormsList+" Count : "+FormsList.size(), StepStatus.FAILURE,
	 						new String[] {}, startTime);
	 		 }
	          
	          
		}
		
		public void _getPDF_PgNo(String file, String tcID) throws IOException 
		{
			long startTime = System.currentTimeMillis();
			File directory = new File("./");
			String strDirectoryPath = directory.getAbsolutePath().split("\\.")[0];
			String PDF_Filepath = DeviceManager.instance().getConfigurationProperties().getProperty("pdf.path")+file+".pdf";
			String actpath = strDirectoryPath+PDF_Filepath;
			PdfReader readertext = new PdfReader(actpath);
	        PdfReaderContentParser parser = new PdfReaderContentParser(readertext);
	        TextExtractionStrategy strategy = null;
	        String temp="";
	        String FormListPage="";
	        int totalpgs = readertext.getNumberOfPages();   
	        
	        PageData dataForms = PageDataManager.instance().getPageData("Forms", tcID);
			String val = (dataForms.getData("FormNameToGetPgNo"));
			String values[] = val.split(";");
			List<String> FormsList = new CopyOnWriteArrayList<String>();//<>(Arrays.asList(values));new CopyOnWriteArrayList<String>();
			for (String a : values) 
			{
				FormsList.add(a);
			}
			
	        
	         for(int j = 1; j <= totalpgs; j++) 
	          {
	        	  strategy = parser.processContent(j,new SimpleTextExtractionStrategy());
                  FormListPage=strategy.getResultantText();
                  /*System.out.println();
                  System.out.println(FormListPage);*/
                 
                  try
		          {
		                  for (String value : FormsList) 
							{
								if(FormListPage.contains(value)) 
								{
									_wait(2000);
									CustomReporting.logReport("", "", "Expected Value " + value + " is present in the PDF Document : "+file+" in Page "+j,
											StepStatus.SUCCESS, new String[] {}, startTime);
									//FormsList.remove(value);
									_writeToExcel("Forms", "PageNumbers", Integer.toString(j)+";", tcID);
									
								}
							}
                  }
                  catch(Exception e)
                  {
                	  e.printStackTrace();
                  }
		        
	          }
	          
		}
		
		
//end functions
}