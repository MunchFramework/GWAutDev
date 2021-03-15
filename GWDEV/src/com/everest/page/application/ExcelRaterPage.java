package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;


public interface ExcelRaterPage extends Page{

	@ElementDefinition
	public String CRIBasePremium = "CRIBasePremium";
	@ElementDefinition
	public String CRILimitRetention = "CRILimitRetention";
	@ElementDefinition
	public String CRIDiscretionaryFactors = "CRIDiscretionaryFactors";
	@ElementDefinition
	public String CRIScheduleRating = "CRIScheduleRating";
	@ElementDefinition
	public String CRIOptCovEnhancement = "CRIOptCovEnhancement";
	@ElementDefinition
	public String DNOBasePremium = "DNOBasePremium";
	@ElementDefinition
	public String DNOLimitRetention = "DNOLimitRetention";
	@ElementDefinition
	public String DNODiscretionaryFactors = "DNODiscretionaryFactors";
	@ElementDefinition
	public String DNOScheduleRating = "DNOScheduleRating";
	@ElementDefinition
	public String DNOOptCovEnhancement = "DNOOptCovEnhancement";
	@ElementDefinition
	public String EPLBasePremium = "EPLBasePremium";
	@ElementDefinition
	public String EPLLimitRetention = "EPLLimitRetention";
	@ElementDefinition
	public String EPLDiscretionaryFactors = "EPLDiscretionaryFactors";
	@ElementDefinition
	public String EPLScheduleRating = "EPLScheduleRating";
	@ElementDefinition
	public String EPLOptCovEnhancement = "EPLOptCovEnhancement";

	@ElementDefinition
	public String CriSubtotal = "CriSubtotal";
	@ElementDefinition
	public String DnoSubtotal = "DnoSubtotal";
	@ElementDefinition
	public String EplSubtotal = "EplSubtotal";
	@ElementDefinition
	public String TotalPremium = "TotalPremium";
	

	@ElementDefinition
	public String tabCRI = "tabCRI";
	@ElementDefinition
	public String tabDNO = "tabDNO";
	@ElementDefinition
	public String tabEPL = "tabEPL";
	@ElementDefinition
	public String tabPremiumSummary = "tabPremiumSummary";
	
	

	@TimeMethod
	@ScreenShot
	public void excelRater(String tcID, SoftAssert softAs) throws Exception;
}
