package breakDownCheck;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyAdminHomeString {
 static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//try {
		driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		driver.findElement(By.id("username")).sendKeys("Tycheck");
		driver.findElement(By.id("password")).sendKeys("Check1");
		//type=submit and it is available in the html form
		driver.findElement(By.name("admin")).click();
        
	Thread.sleep(500);
	/*
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}*/
	
		System.out.println(driver.getTitle());
		/*validating home page title for successful login*/
		String actual=driver.findElement(By.xpath("//ul/li[contains(text(),'HOME')]")).getText();
		String expected="HOME";
		Assert.assertEquals(actual, expected);
		Reporter.log("Admin registration successful",true);

	}

}
