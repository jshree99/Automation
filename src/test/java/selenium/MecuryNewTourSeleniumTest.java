package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MecuryNewTourSeleniumTest {

	private static final long PAUSE_TIME = 1000;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		Thread.sleep(1000);
		//Registration
		driver.findElement(By.name("firstName")).sendKeys("Test");
		Thread.sleep(1000);
		driver.findElement(By.name("lastName")).sendKeys("User");
		Thread.sleep(100);
		driver.findElement(By.name("phone")).sendKeys("9876598765");
		Thread.sleep(1000);
		driver.findElement(By.name("userName")).sendKeys("abc123@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.name("address1")).sendKeys("Location");
		Thread.sleep(1000);
		driver.findElement(By.name("city")).sendKeys("City");
		Thread.sleep(1000);
		driver.findElement(By.name("state")).sendKeys("State");
		Thread.sleep(1000);
		driver.findElement(By.name("postalCode")).sendKeys("671708");
		Thread.sleep(1000);
		WebElement dropdown = driver.findElement(By.name("country"));
		Select sel =new Select (dropdown);	
		sel.selectByIndex(24);	
		driver.findElement(By.name("email")).sendKeys("Test User");	
		Thread.sleep(1000);	
		driver.findElement(By.name("password")).sendKeys("TestUser@123");	
		Thread.sleep(1000);	
		driver.findElement(By.name("confirmPassword")).sendKeys("TestUser@123");	
		Thread.sleep(1000);	
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);	
		//Flights selecting
		driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
		Thread.sleep(1000);	
		WebElement oneway=driver.findElement(By.xpath("//input[@value='oneway']"));
		System.out.println(" oneway is displayed:" + oneway.isDisplayed() );
		System.out.println("oneway is Selected:" + oneway.isSelected() );
		System.out.println("oneway is Enabled:" + oneway.isEnabled() );
		System.out.println(driver.findElement(By.xpath("//input[@value='oneway']")).isDisplayed() );
		Thread.sleep(2000);
		selectWebElementByIndex(driver, "passCount", 3);
		Thread.sleep(PAUSE_TIME);
		selectWebElementByIndex(driver,"fromPort", 3);
		Thread.sleep(PAUSE_TIME);
		selectWebElementByIndex(driver,"fromMonth", 7);
		Thread.sleep(PAUSE_TIME);
		selectWebElementByIndex(driver,"fromDay", 6);
		Thread.sleep(PAUSE_TIME);
		selectWebElementByIndex(driver,"toPort", 2);
		Thread.sleep(PAUSE_TIME);
		selectWebElementByIndex(driver,"toMonth", 3);
		Thread.sleep(PAUSE_TIME);
		selectWebElementByIndex(driver,"toDay", 6);
		Thread.sleep(PAUSE_TIME);
		WebElement round=driver.findElement(By.xpath("//input[@value='roundtrip']"));
		System.out.println("Round trip is displayed:" + round.isDisplayed() );
		System.out.println(" Round trip is Selected:" + round.isSelected() );
		System.out.println("Round trip trip is Enabled:" + round.isEnabled() );
		Thread.sleep(2000);
		selectWebElementByIndex(driver,"airline", 1);
		Thread.sleep(PAUSE_TIME);
		driver.findElement(By.name("findFlights")).click();
		Thread.sleep(2000);
		
		driver.close();
	}
	//for dropdown
	public static void selectWebElementByIndex(WebDriver driver, String name, int index) {
		WebElement webElement = driver.findElement(By.name(name));
		Select sel = new Select (webElement);
		sel.selectByIndex(index);
	}
}
