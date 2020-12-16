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
		
		adminRegPage.enterFnameTextbox("Final");
		adminRegPage.enterLnameTextbox("Report");
		adminRegPage.enterUnameTextbox("FinalReport");
		adminRegPage.pwdTextbox("Finaltest2020");
		adminRegPage.confirmPwdTextbox("Finaltest2020");
		adminRegPage.emailidTextbox("finalcheckround@gmail.com");
		adminRegPage.saveButton();
	
		/*For admin registration alert popup*/
		adminRegPage.adminAlert();
        
		/* Relaunch the application for Registered admin user*/
		launchApplication("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		adminRegPage.adminReglogin("FinalReport","Finaltest2020");
		
		/*validating home page title for successful login*/
		String actual=driver.findElement(By.xpath("//li[contains(text(),'HOME')]")).getText();
		String expected="HOME";
		Assert.assertEquals(actual, expected);
		Reporter.log("Admin registration done but confirm the code",true);

	 }
}

