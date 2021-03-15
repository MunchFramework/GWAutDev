package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmPremiumCapturePage extends Page {

	@ElementDefinition
	public String KY_PubSerCrg = "KY_PubSerCrg" ;
	@ElementDefinition
	public String tabPremiumSummary = "tabPremiumSummary" ;
	@ElementDefinition
	public String lblTotalPremium = "lblTotalPremium" ;
	@ElementDefinition
	public String tabPremiumSummary1 = "tabPremiumSummary1" ;
	@ElementDefinition
	public String tabPremiumSummary2 = "tabPremiumSummary2" ;
	@ElementDefinition
	public String tabPremiumSummary3 = "tabPremiumSummary3" ;
	@ElementDefinition
	public String tabPremiumSummary4 = "tabPremiumSummary4" ;
	@ElementDefinition
	public String tabPremiumSummary5 = "tabPremiumSummary5" ;
	@ElementDefinition
	public String tabPremiumSummary6 = "tabPremiumSummary6" ;
	@ElementDefinition
	public String tabPremiumSummary7 = "tabPremiumSummary7" ;
	@ElementDefinition
	public String tabPremiumSummary8 = "tabPremiumSummary8" ;
	@ElementDefinition
	public String tabPremiumSummary9 = "tabPremiumSummary9" ;
	@ElementDefinition
	public String tabPremiumSummary10 = "tabPremiumSummary10" ;	
	@ElementDefinition
	public String tabPremiumSummary11 = "tabPremiumSummary11" ;	
	@ElementDefinition
	public String tabPremiumSummary12 = "tabPremiumSummary12" ;	
	@ElementDefinition
	public String btnPolicyPage13 = "btnPolicyPage13";
	@ElementDefinition
	public String btnACF = "btnACF";
	@ElementDefinition
	public String btnCRD = "btnCRD";
	@ElementDefinition
	public String btnPRO = "btnPRO";
	@ElementDefinition
	public String btnENO = "btnENO";
	@ElementDefinition
	public String btnPRE = "btnPRE";
	@ElementDefinition
	public String btnPRL = "btnPRL";
	@ElementDefinition
	public String btnPRN = "btnPRN";
	@ElementDefinition
	public String 	btnREP = "btnREP";
	@ElementDefinition
	public String btnTAX = "btnTAX";
	@ElementDefinition
	public String btnSUR = "btnSUR";
	@ElementDefinition
	public String tabPremiumSummary_PC8E = "tabPremiumSummary_PC8E";
	@ElementDefinition
	public String txtUMKYMuncipalTax = "txtUMKYMuncipalTax";
	@ElementDefinition
	public String tabRatingPremiumSummary = "tabRatingPremiumSummary";
	//Premium Breakdown Elements
	@ElementDefinition
	public String Binding_Page = "Binding_Page";
	@ElementDefinition
	public String Crime = "Crime";
	@ElementDefinition
	public String Cyber_1 = "Cyber_1";
	@ElementDefinition
	public String Cyber_2 = "Cyber_2";
	@ElementDefinition
	public String 	DNO = "DNO";
	@ElementDefinition
	public String EMP = "EMP";
	@ElementDefinition
	public String ENO = "ENO";
	@ElementDefinition
	public String EPL = "EPL";
	@ElementDefinition
	public String FID = "FID";
	@ElementDefinition
	public String KNR = "KNR";
	
	
	
	
	@TimeMethod
	@ScreenShot
	public void UmPremiumCapture(String tcID, SoftAssert softAs) throws Exception;
	public void CaptureUMTax_KY(String tcID, SoftAssert softAssert) throws Exception;
	public void CaptureUMTax_NJ(String tcID, SoftAssert softAssert) throws Exception;
	public void CapturePremiumBreakdown(String tcID, SoftAssert softAssert) throws Exception;

}