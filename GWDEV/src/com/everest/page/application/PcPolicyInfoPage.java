package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface PcPolicyInfoPage extends Page {

	@ElementDefinition
	public String PolicyInfoPageLink = "PolicyInfoPageLink";
	@ElementDefinition
	public String PortfolioGrouping = "PortfolioGrouping";
	@ElementDefinition
	public String BillingMethod = "BillingMethod";
	@ElementDefinition
	public String PaymentPlan = "PaymentPlan";
	@ElementDefinition
	public String QuotaShare = "QuotaShare";
	@ElementDefinition
	public String PolicyReviewLink = "PolicyReviewLink";
	@ElementDefinition
	public String PartOf = "PartOf";
	@ElementDefinition
	public String Issuance_Tran = "Issuance_Tran";
	
	
	@TimeMethod
	@ScreenShot
	public void PcPolicyInfoValidation(String tcID, SoftAssert softAs) throws Exception;
}
