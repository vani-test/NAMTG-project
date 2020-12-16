package org.iit.healthcare.mmp.pages;

import org.iit.healthcare.mmp.baseclass.TestBaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminRegistrationPage{
	public WebDriver driver;
	//Registration page webelement declaration
	@FindBy(xpath="//input[@value=\"Register\"]") private WebElement registerButton;
	@FindBy(xpath="//input[@id=\"firstname\"]") private WebElement fnameTextBox;
	@FindBy(xpath="//input[@id=\"lastname\"]") private WebElement lnameTextBox;
	@FindBy(xpath="//input[@id=\"username\"]") private WebElement unameTextBox;
	@FindBy(xpath="//input[@id=\"password\"]") private WebElement pwdTextBox;
	@FindBy(xpath="//input[@id=\"cpassword\"]") private WebElement confirmpwdTextBox;
	@FindBy(xpath="//input[@id=\"officecode\"]") private WebElement emailidTextBox;
	@FindBy(xpath="//input[@name=\"save\"]") private WebElement saveButton;

	public AdminRegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void registerButtonClick() {
		registerButton.click();
	}
	public void enterFnameTextbox(String firstname) {
		fnameTextBox.sendKeys("Final");
	}
	public void enterLnameTextbox(String lastname) {
		lnameTextBox.sendKeys("Report");
	}
	public void enterUnameTextbox(String uname)
	{
		unameTextBox.sendKeys("FinalReport");
	}
	public void pwdTextbox(String password)
	{
		pwdTextBox.sendKeys("Finaltest2020");
	}
	public void confirmPwdTextbox(String confirmpwd)
	{
		confirmpwdTextBox.sendKeys("Finaltest2020");
	}

	public void emailidTextbox(String emailid)
	{
		emailidTextBox.sendKeys("finalcheckround@gmail.com");
	}
	public void saveButton()
	{
		saveButton.click();
	}

	public void adminAlert() 
	{
		Alert alert =driver.switchTo().alert(); 
		alert.accept();
		System.out.println("Admin alert popup step is passed");
	}

	public void adminReglogin(String uname,String pword) throws InterruptedException
	{
		/*Admin credentials */
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		//type=submit and it is available in the html form
		driver.findElement(By.name("admin")).click();
		Thread.sleep(400);

	}
}
