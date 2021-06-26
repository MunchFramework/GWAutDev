package com.mn.insta.page;

import org.testng.asserts.SoftAssert;
import org.xframium.page.Page;

public interface LoginInsta  extends Page 
{
		
		@ElementDefinition
		public String txt_username="txt_username" ;
		@ElementDefinition
		public String txt_password="txt_password" ;
		@ElementDefinition
		public String btn_Login="btn_Login" ;
		@ElementDefinition
		public String btn_NotNow="btn_NotNow" ;
		@ElementDefinition
		public String img_Profile="img_Profile" ;
		@ElementDefinition
		public String btn_Logout="btn_Logout" ;
		

		
		@TimeMethod
		@ScreenShot
		public void LoginToInsta(String tcID, SoftAssert softAssert, String DeviceName) throws Exception;
		public void LogoutInsta(String tcID, SoftAssert softAssert, String DeviceName) throws Exception;
		
}



