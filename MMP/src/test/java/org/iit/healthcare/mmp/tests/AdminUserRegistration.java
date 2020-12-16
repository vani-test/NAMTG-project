package org.iit.healthcare.mmp.tests;

import org.iit.healthcare.mmp.baseclass.TestBaseClass;
import org.iit.healthcare.mmp.pages.AdminRegistrationPage;
import org.iit.healthcare.mmp.pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AdminUserRegistration extends TestBaseClass{

	@Test
	public void adminRegistration() throws InterruptedException 
	{
		launchApplication("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		
		/*Passing the values to admin registration page*/
		AdminRegistrationPage adminRegPage= new AdminRegistrationPage(driver);
		adminRegPage.registerButtonClick();
		System.out.println("its going to click register button");
		boolean result =adminRegPage.validateAdminPortalMessage();
		Assert.assertTrue(result);
		System.out.println("checking patient portal heading once page loaded");

		System.out.println("enter firstname");
		adminRegPage.enterFnameTextbox("Mars");
		System.out.println("enter lastname");
		adminRegPage.enterLnameTextbox("Part");
		System.out.println("enter username");
		adminRegPage.enterUnameTextbox("lia1");
		adminRegPage.pwdTextbox("Lia12345");
		adminRegPage.confirmPwdTextbox("Lia12345");
		adminRegPage.emailidTextbox("vstest201@gmail.com");
		adminRegPage.saveButton();
	
		/*For admin registration alert popup*/
		adminRegPage.adminAlert();
		
        Thread.sleep(400);
		/* Relaunch the application for Registered admin user*/
		//launchApplication("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		adminRegPage.adminReglogin("lia1","Lia12345");
		adminRegPage.adminHomePageCheck();
		driver.quit();
		
		
	 }
}

