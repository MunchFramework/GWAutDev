package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface UmCvgLvlPremiumValidatnPage extends Page{
	@ElementDefinition
	public String tabRatingPremiumSummary ="tabRatingPremiumSummary";
	@ElementDefinition
	public String txtCrimeSubtotal ="txtCrimeSubtotal";
	@ElementDefinition
	public String txtCyberSubtotal ="txtCyberSubtotal";
	@ElementDefinition
	public String txtDNOSubtotal ="txtDNOSubtotal";
	@ElementDefinition
	public String txtEMPSubtotal ="txtEMPSubtotal";
	@ElementDefinition
	public String txtEPLSubtotal ="txtEPLSubtotal";
	@ElementDefinition
	public String txtFIDSubtotal ="txtFIDSubtotal";
	@ElementDefinition
	public String  txtKNRSubtotal="txtKNRSubtotal";
	@ElementDefinition
	public String txtENOSubtotal ="txtENOSubtotal";
	@ElementDefinition
	public String txtPolicyTotal ="txtPolicyTotal";
	
		@TimeMethod
		@ScreenShot
		public void UmCvgLvlPremiumValidatn(String tcID, SoftAssert softAs) throws Exception;

	}

