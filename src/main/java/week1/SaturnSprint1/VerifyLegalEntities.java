package week1.SaturnSprint1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyLegalEntities {

	public static void main(String[] args) throws InterruptedException {
		// Setup chrome driver and path
		WebDriverManager.chromedriver().setup();
		//remove notitifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// Launch chrome Browser
		WebDriver driver= new ChromeDriver(options);
		//1. Launch login.salesforce.com site
		driver.get("https://login.salesforce.com/");
		//maximize the window
		driver.manage().window().maximize();
		//2) Click Login 3) Login with the credential
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		//implicit wait for all driver elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//click on view all applications
		driver.findElement(By.xpath("//div[@class = 'slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		//click on legal enities 
		Thread.sleep(5000);
		WebElement legalEn = driver.findElement(By.xpath("//lightning-accordion-section[@role='listitem'][2]/section/div[2]/slot/ul/li[53]"));
	    JavascriptExecutor js= (JavascriptExecutor) driver;
	    //using js click method
	    js.executeScript("arguments[0].scrollIntoView();", legalEn);
	    //Get Lastmodified date list
	    //WebElement lastPage = driver.findElement(By.xpath("//table)[2]/tbody/tr[last()]"));
		
		  Thread.sleep(5000); int i = 1; List<String> Li = new ArrayList<String>(); try
		  { while (driver.findElement(By.xpath("(//table)[2]/tbody/tr[" + i +"]")).isDisplayed()) { ((JavascriptExecutor)
		  driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(By.
		  xpath("(//table)[2]/tbody/tr[" + i + "]")));
		  //Li.add(driver.findElement(By.xpath("//table)[2]/tbody/tr[" + i +"]/td[3]/span/span")).getText()); i++; } } catch (NoSuchElementException e) {
		  }
		 
		//System.out.println("size before sort "+Li.size());
		//Collections.sort(Li);
		//System.out.println(Li);

	    
	    
	    
	    
		/*
		 * //click on date modified sort arrow driver.findElement(By.xpath(
		 * "//table/thead/tr/th[4]/div/a/span[text()='Sort']")).click();
		 * 
		 * 
		 * 
		 * 
		 * // to move to next window Set<String> windowHandles =
		 * driver.getWindowHandles(); List<String>ListOfHandles = new
		 * ArrayList(windowHandles); String secondWindowrefer= ListOfHandles.get(1);
		 * driver.switchTo().window(secondWindowrefer); //to click on confirm
		 * driver.findElement(By.xpath("//button[text()='Confirm']")).click(); // to get
		 * the window title Thread.sleep(5000); String title1 = driver.getTitle();
		 * System.out.println("Second window Title is : "+title1); //to close the second
		 * window driver.close(); //to go back to first window String firstwindowref =
		 * ListOfHandles.get(0); driver.switchTo().window(firstwindowref);
		 */
		
	
		  
		  
	
}
}

}
