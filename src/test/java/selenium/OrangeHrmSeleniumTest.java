package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmSeleniumTest {
	
	@Test
	public void test_login_with_valid_username_and_password() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// home page
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		// Test Case 1 - Valid input
		driver.findElement(By.name("username")).sendKeys("Admin");
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		driver.close();
	}
	
	@Test
	public void test_login_with_invalid_username_and_password() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// home page
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		// Test Case 1 - Valid input
		driver.findElement(By.name("username")).sendKeys("TestUser");
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("TestUser@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		Assert.assertNotSame(driver.getCurrentUrl(), expectedUrl);
		driver.close();
	}
	
	@Test
	public void test_login_with_empty_username_and_password() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// home page
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		// Test Case 1 - Valid input
		driver.findElement(By.name("username")).sendKeys("");
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		Assert.assertNotSame(driver.getCurrentUrl(), expectedUrl);
		driver.close();
	}

}
