package TestNG_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC002 extends TestNG_hooks{
	
	@Test
	private void test_TC002() throws InterruptedException {
		//2) Click Login 3) Login with the credentials
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		//implicit wait for all driver elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// 4) Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//div[@class = 'slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		//to scroll until sales option using js executor
		WebElement element = driver.findElement(By.xpath("//p[text()='Sales']"));
	    JavascriptExecutor js= (JavascriptExecutor) driver;
	    //using js click method
	    js.executeScript("arguments[0].click();",element);
	     // 5) Click on Accounts
		 WebElement Acct = driver.findElement(By.xpath("//a[@title='Accounts']"));
		js.executeScript("arguments[0].click();", Acct);
		//6. search by our names
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Param1",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//table/tbody/tr/td[6])/span/div")).click();
		//choose delete option from dropdown
		driver.findElement(By.xpath("//div[@role='menu'and @class='branding-actions actionMenu']/ul/li[2]/a")).click();
		//confirm delete in pop up window
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		//selenium wait to verfify acct Deletion
		   WebElement DeleteAcct = driver.findElement(By.xpath("//span[text()='Param1']"));
		   WebDriverWait wait= new WebDriverWait(driver,5);
	  	   wait.until(ExpectedConditions.visibilityOf(DeleteAcct));
	  	//verify the delete created message
		
	  	 String verifyDeleteAcct = driver.findElement(By.xpath("//div[@data-key='success']/div/div/div/span")).getText();
	  	 if (verifyDeleteAcct.contains(actResult)) {
	  		 System.out.println("Account is deleted successfully");
			
		}else {
			System.out.println("Account is not deleted successfully");
		}

	}
	
	

}
