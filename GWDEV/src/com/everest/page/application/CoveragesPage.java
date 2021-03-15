package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface CoveragesPage extends Page{

	@ElementDefinition
	public String tabActions = "tabActions";
	@ElementDefinition
	public String menuLinkNewAccount = "menuLinkNewAccount";
	@ElementDefinition
	public String txtCompanyName = "txtCompanyName";
	@ElementDefinition
	public String btnSearch = "btnSearch";
	@ElementDefinition
	public String btnCreateNewAccount = "btnCreateNewAccount";
	@ElementDefinition
	public String LinkCompanyAccount = "LinkCompanyAccount";
	@ElementDefinition
	public String txtName = "txtName";
	@ElementDefinition
	public String txtAddress1 = "txtAddress1";
	@ElementDefinition
	public String txtCity = "txtCity";
	@ElementDefinition
	public String ddState = "ddState";
	@ElementDefinition
	public String txtZipCode = "txtZipCode";
	@ElementDefinition
	public String iconOrganization = "iconOrganization";
	@ElementDefinition
	public String txtOrgName = "txtOrgName";
	@ElementDefinition
	public String btnSearchOrg = "btnSearchOrg";
	@ElementDefinition
	public String btnSelect = "btnSelect";

	@ElementDefinition
	public String btnUpdate = "btnUpdate";
	
	

	@TimeMethod
	@ScreenShot
	public void addStandardCommon(String tcID, SoftAssert softAs) throws Exception;
	public void addStandardCRI(String tcID, SoftAssert softAs) throws Exception;
	public void addStandardDNO(String tcID, SoftAssert softAs) throws Exception;
	public void addStandardEPL(String tcID, SoftAssert softAs) throws Exception;
	
	
	
	
	
}
