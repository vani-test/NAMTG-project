package org.iit.healthcare.mmp.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AdminApproval {
	WebDriver driver;

	public AdminApproval(WebDriver driver)
	{
		this.driver=driver;
	}
	public void searchPatientBySSN(String ssn) throws InterruptedException
	{
		try {
			driver.findElement(By.xpath("//span[text()=\"Patients \"]")).click();
			driver.findElement(By.xpath("id=search")).sendKeys(ssn);
			driver.findElement(By.xpath("class='tfbutton")).click();
			driver.findElement(By.xpath("//tr/td[1]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Joe')]")).click();
			Thread.sleep(400);
			driver.findElement(By.xpath("//p[4]/a/input[@value=\"Reports\"]")).click();
			Thread.sleep(400);

			//we are in Report details page
			WebElement datedropdown=driver.findElement(By.xpath("//select[@id=\"app_date\"]"));
			Select date=new Select(datedropdown);
			date.selectByVisibleText("11/25/2020");
			
			driver.findElement(By.xpath("//input[@id=\"exampleInputcardnumber1\"]")).sendKeys("December annual report");
			driver.findElement(By.xpath("//input[@id=\"file\"]")).sendKeys("C:\\JK\\Vani-new-pc\\IIT workforce-project\\mavenarch.png");
			driver.findElement(By.xpath("//textarea[@class=\"form-control\"]")).sendKeys("december annual report not clear");
			driver.findElement(By.xpath("//input[@value=\"submit\"]")).click();
		}catch(Exception e)
		{
			System.out.println("check the script line by line");
		}

		//????confirm the flow ->after creating report and submitted,where i can see the created data

		/*validating home string after report submission in adminuser login*/
		String actual=driver.findElement(By.xpath("//li[contains(text(),'HOME')]")).getText();
		String expected="HOME";
		Assert.assertEquals(actual, expected,"Page navigation issues");

	}
}