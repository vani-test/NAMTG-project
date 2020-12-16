package org.iit.healthcare.mmp.tests;

import java.util.HashMap;

import org.iit.healthcare.mmp.baseclass.TestBaseClass;
import org.iit.healthcare.mmp.pages.HomePage;
import org.iit.healthcare.mmp.pages.LoginPage;
import org.iit.healthcare.mmp.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests extends TestBaseClass
{
 
	@Test
	public void validateScheduleAppointment() throws InterruptedException
	{
		launchApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");	
		LoginPage lPage = new LoginPage(driver);
		lPage.login("ria1","Ria12345");
	
		HomePage hPage = new HomePage(driver);
		hPage.navigationMenuItem("Schedule Appointment");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		HashMap<String,String> appointmentDetailsHMap=sPage.bookAnAppointment("Dr.Beth");
	
		boolean result = hPage.validatePatientPortalMessage();
		Assert.assertTrue(result);

		HashMap<String,String> homePageDetailsHMap=hPage.validateApptDetailsinHomePage();
		Assert.assertEquals(appointmentDetailsHMap, homePageDetailsHMap);

		
		hPage.navigationMenuItem("Schedule Appointment");
	 
		 
		HashMap<String,String> sPageHMap=sPage.validateApptDetailsinSPage();
		Assert.assertEquals(appointmentDetailsHMap, sPageHMap);


	}

	}
