package org.iit.healthcare.mmp.pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AdminRegistrationPage{
	 WebDriver driver;
	
	//Registration page webelement declaration
	@FindBy(xpath="//input[@value=\"Register\"]") private WebElement registerButton;
	
	//@FindBy(id="firstname") private WebElement fnameTextBox;
	
	@FindBy(name="Name") private WebElement firstnameTextbox;
	@FindBy(id="lastname") private WebElement lnameTextBox;
	@FindBy(id="username") private WebElement unameTextBox;
	@FindBy(id="password") private WebElement pwdTextBox;
	@FindBy(id="cpassword") private WebElement confirmpwdTextBox;
	@FindBy(id="officecode") private WebElement emailidTextBox;
	@FindBy(name="save") private WebElement saveButton;

	public AdminRegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void registerButtonClick() {
		registerButton.click();
	}
	 
	
	public boolean validateAdminPortalMessage()
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		Boolean result=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1[contains(text(),'PERSONAL DETAILS')]"), "PERSONAL DETAILS"));
		return result;
	}		
			
	public void enterFnameTextbox(String afirstname) {
		firstnameTextbox.sendKeys(afirstname);
	}
	public void enterLnameTextbox(String alastname) {
		lnameTextBox.sendKeys(alastname);
	}
	public void enterUnameTextbox(String auname)
	{
		unameTextBox.sendKeys(auname);
	}
	public void pwdTextbox(String apassword)
	{
		pwdTextBox.sendKeys(apassword);
	}
	public void confirmPwdTextbox(String aconfirmpwd)
	{
		confirmpwdTextBox.sendKeys(aconfirmpwd);
	}

	public void emailidTextbox(String aemailid)
	{
		emailidTextBox.sendKeys(aemailid);
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

	public void adminReglogin(String ausername,String apassword) throws InterruptedException
	{
		/*Admin credentials */
		driver.findElement(By.id("username")).sendKeys(ausername);
		driver.findElement(By.id("password")).sendKeys(apassword);
		//type=submit and it is available in the html form
		driver.findElement(By.name("admin")).click();
		Thread.sleep(400);

	}
	
	public void adminHomePageCheck() {

		System.out.println(driver.getTitle());
		/*validating home page title for successful login*/
		String actual=driver.findElement(By.xpath("//ul/li[contains(text(),'HOME')]")).getText();
		String expected="HOME";
		Assert.assertEquals(actual, expected);
		Reporter.log("Admin registration successful",true);

	}
}
