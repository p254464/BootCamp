package week1.SaturnSprint1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3 {

	public static void main(String[] args) throws InterruptedException {
		// Setup Edge driver and path
		WebDriverManager.edgedriver().setup();

		// Launch Edge Browser
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");

		EdgeDriver driver = new EdgeDriver(options);

		// 1. Launch login.salesforce.com site
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 2) Click Login 3) Login with the credentials
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();

		// 4) Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle_container')]")).click();

		// 5) Click on Accounts
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Accounts");

		driver.findElement(By.xpath("//b[text()='Accounts']")).click();
		// get location of the site
		WebElement lastPage = driver.findElement(By.xpath("//table/tbody/tr[last()]"));
		// System.out.println(lastPage.getLocation());

		// Get AccountNames
		Thread.sleep(5000);
		int i = 1;
		List<String> Li = new ArrayList<String>();
		try {
			while (driver.findElement(By.xpath("//table/tbody/tr[" + i + "]")).isDisplayed()) 
			{
				driver.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//table/tbody/tr[" + i + "]")));
				Li.add(driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/th//a")).getAttribute("title"));
				i++;
			}
		} catch (NoSuchElementException e) {
		}
		System.out.println(Li.size());
		Collections.sort(Li);
		System.out.println(Li);

		// Refresh the page to goto first record
		driver.navigate().refresh();
		// Account tab sorting arrow is clicked 
		Thread.sleep(5000); 
		WebElement sortAr = driver.findElement(By.xpath("//table/thead/tr/th[3]//a"));
		sortAr.click();
		Thread.sleep(2000); 
		// scrolling the screen secondtime and Second list for sorted data 
		i=1;
		List<String> Li2 = new ArrayList<String>();
		try {
			while (driver.findElement(By.xpath("//table/tbody/tr[" + i + "]")).isDisplayed()) {
				driver.executeScript("arguments[0].scrollIntoView();",
						driver.findElement(By.xpath("//table/tbody/tr[" + i + "]")));
				Li2.add(driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/th//a")).getAttribute("title"));
				i++;
			}
		} catch (NoSuchElementException e) {
		}

		System.out.println("secondList Size : " + Li2.size());

		System.out.println(Li2);
		if (Li.equals(Li2)) {
			System.out.println("Account sortlist is matching ");

		} else {
			System.out.println("Account sortlist is not matching ");
		}
		driver.quit();

	}

}
