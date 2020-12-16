package org.iit.healthcare.mmp.tests;

import org.iit.healthcare.mmp.baseclass.TestBaseClass;
import org.iit.healthcare.mmp.pages.AdminApproval;
import org.iit.healthcare.mmp.pages.AdminRegistrationPage;
import org.iit.healthcare.mmp.pages.HomePage;
import org.iit.healthcare.mmp.pages.LoginPage;
import org.iit.healthcare.mmp.pages.LogoutPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ViewReportAdmintoPatient extends TestBaseClass{
	@Test
	public void pullthePatientSSN() throws InterruptedException
	{
		/*Fetching Patient SSN data from personal details page*/
		launchApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");	
		LoginPage lPage = new LoginPage(driver);
		lPage.login("ria1","Ria12345");
		HomePage profilepage=new HomePage(driver);
		String UserSSN=profilepage.navigationprofiletab("Profile");
		System.out.println(UserSSN);
		
		/*Log into Admin*/
		launchApplication("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		LoginPage aPage = new LoginPage(driver);
		aPage.adminlogin("ReportTest2","Reporttest2020");
		AdminApproval assnSearch=new AdminApproval(driver);
		assnSearch.searchPatientBySSN(UserSSN);
		profilepage.userLogOut();


		/*Log into Patient portal to view the report submission from Admin*/  
		launchApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		lPage.login("ria1","Ria12345");
		profilepage.navigateToViewReports();
		Reporter.log("Able to view the admin created report details in patient login",true);



	}
}
