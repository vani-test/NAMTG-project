package org.iit.healthcare.mmp.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private final WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver =driver;
	}
	public void login(String uname,String pword)
	{
		//login
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		//type=submit and it is available in the html form
		driver.findElement(By.name("submit")).click();

	}

	public void adminlogin(String uname,String pword)
	{
		/*Admin credentials */
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		//type=submit and it is available in the html form
		driver.findElement(By.name("admin")).click();

	}
	/* In this function tried user registration in the method level*/
	public void adminLoginRegistration(String fname,String lname,String username,String Password,String confirmpwd,String emailid) throws InterruptedException
	{

		driver.findElement((By.xpath("//input[@value=\"Register\"]"))).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@id=\"firstname\"]")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@id=\"lastname\"]")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id=\"cpassword\"]")).sendKeys(confirmpwd);
		driver.findElement(By.xpath("//input[@id=\"officecode\"]")).sendKeys(emailid);
		driver.findElement(By.xpath("//input[@name=\"save\"]")).click();

		Alert alert =driver.switchTo().alert();
		Thread.sleep(350);
		alert.accept();

		/*Log in with the currently created user */
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@name=\"admin\"]")).click();


	}


}