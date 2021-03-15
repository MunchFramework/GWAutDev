package com.everest.page.application;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface CoverageValidationPage extends Page {
	@ElementDefinition
    public String tabCoverages = "tabCoverages";
	@ElementDefinition
    public String tabStandardCoverages = "tabStandardCoverages";
  @ElementDefinition
    public String tabModifiers = "tabModifiers";
  @ElementDefinition
    public String tabExposures = "tabExposures";
  @ElementDefinition
    public String tabEPL = "tabEPL";
  @ElementDefinition
    public String tabCRI = "tabCRI";
  @ElementDefinition
    public String tabDno = "tabDno";
  @ElementDefinition
  	public String tabCYB = "tabCYB";
  @ElementDefinition
	public String tabEMP = "tabEMP";
  @ElementDefinition
	public String tabENO = "tabENO";
  @ElementDefinition
	public String tabFID = "tabFID";
  @ElementDefinition
	public String tabKNR = "tabKNR";
  
  
    @TimeMethod
	@ScreenShot
	public void CoverageValidation(String tcID, SoftAssert softAssert) throws Exception;
  

}
