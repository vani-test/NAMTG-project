package breakDownCheck;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginwithParameter {
	WebDriver driver;
	@Parameters({"Username","Password"})
	@Test
public void parameterinTestNG() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//try {
		driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		System.out.println("enter username");
		driver.findElement(By.id("username")).sendKeys("Username");
		System.out.println("enter pwd");
		driver.findElement(By.id("password")).sendKeys("Password");
		//type=submit and it is available in the html form
		System.out.println("click on submit button");
		driver.findElement(By.name("admin")).click();
		System.out.println("launch successful");
		System.out.println(driver.getTitle());
	}

}
