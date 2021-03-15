/*******************************************************************
	*	Name              :	AlliancePage
	*	Description       : New class which extends LocalAbstractPage, This class should be extended by all the local pages  	
 	*	Modification Log  :                                                     
	*	Date		Initials     	Description of Modifications 
	********************************************************************
	********************************************************************/

package com.everest.utility;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.xframium.page.LocalAbstractPage;
import org.xframium.page.data.PageData;
import org.xframium.page.data.PageDataManager;
import org.xframium.page.element.Element;

import com.everest.functions.CustomFunctions;
import com.everest.functions.GenericFunctions;

public abstract class CustomAbstractPage extends LocalAbstractPage{

		
	public static PageDataManager dataManager = PageDataManager.instance();
	public GenericFunctions func = GenericFunctions.instance();
	public CustomFunctions cFunc=CustomFunctions.instance();
	protected PageData pageData [];
		
	public      CustomAbstractPage(){
        
        String strpageName=this.getClass().getSimpleName().split("Impl")[0];
        func._setGlobalToken("glbPageName", strpageName);
  }
	
/***********************************************************************/
	@Override
	public void initializePage() {
		// TODO Auto-generated method stub
		dataManager = PageDataManager.instance();
		//className= this.getClass().getSimpleName();
	}


/***********************************************************************/
	public Element getClonedElement(String Name)
	{
		return super.getElement(Name).cloneElement();
	}
	
	
	public Element getClonedElement( String pageName, String elementName )
    {
    	return getElement( pageName, elementName );
    }
/*********************************************************************/
	protected PageData[] getRecords(String tableName)
	{
		//PageData[] pageData =dataManager.getRecords(testName+"-"+tableName);
		PageData[] pageData =dataManager.getRecords(tableName);
		//return pageData;
		return removeDuplicates(pageData);
	}
	
	
/***********************************************************************/
	
/***********************************************************************/
	 
	protected PageData[] removeDuplicates(PageData[] pageData)
	{
				 
		 int noElements = pageData.length;
		
			
		for (int i= 0; i<noElements;i++)
		{
			for(int j=i+1; j<noElements;j++){
				if(pageData[i].getName()==pageData[j].getName()){
					pageData[j]=pageData[noElements-1];
					noElements--;
					j--;
				}
				
			}
			
		}		
		PageData[] pageDatarLocal= Arrays.copyOf(pageData,noElements);
		
		return (PageData[]) pageDatarLocal;
	}
	
	
/***********************************************************************/
 
	protected void _setValue(Element element, String string)
	{
		func._setValue(element, string);
	}
	
	protected void _getValue(Element element)
	{
		func._getValue(element);
	}
	
	protected void _sendkeys(Element element, String string)
	{
		func._sendkeys(element, string);
	}
	
	protected void _writeToExcel(String Sheetname,String strColName,String strVal,String strTCID)
	{
		func._writeToExcel(Sheetname,strColName,strVal,strTCID);
	}
	
	
	
/***********************************************************************/
	 
	protected void _click(Element element)
	{
		func._click(element);
	}
	
/***********************************************************************/
	
	
	 
	protected void _Forms(Element element)
	{
		func._click(element);
	}
	
/***********************************************************************/
		 
	protected void _isVisible(Element element)
	{
		func._click(element);
	}
	
/***********************************************************************/
	 
	protected void _setGlobalToken(String strTokenName, String strTokenValue)
	{
		func._setGlobalToken(strTokenName,strTokenValue);
	}
	
	
/***********************************************************************/
	
	public WebDriver getWebDriver()
	{
		return func.getCustumWebDriver();

	}
	
	
	
	public void _wait(long timeOut)
	{
		func._wait(timeOut);

	}
	
	
	
	protected void _selectValueDropDown(Element element, String string)
	{
		func._setValue(element, string);
	}
	
	protected String _getAttributeValue(Element element,String string)
	{
		return func._getAttributeValue(element, "TEXT");
	}
	
	public void _setValueByIndexInDropdown(Element element, int index)
	{
		func._setValueByIndexInDropdown(element, index);
	}
	
	public void _robotSelect(Element element)
	{
		try {
			func.robot();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void _clickDown()
	{
		try {
			func.clickDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void _clickRight()
	{
		try {
			func.clickRight();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void _clickTab()
	{
		try {
			func.clickTab();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void _clickEnter()
	{
		try {
			func.clickEnter();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String _getNative(Element element)
	{
		func._getNative(element);
		return null;
	}
}
	
