package TestNG_Practice;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC004 extends TestNG_hooks {
	
	@Parameters({"username","password"})
	@Test
	public void test_TC004(String username, String password) {
		
		System.out.println("Chrome browser is executed");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();	
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test2_TC004() {
		driver.findElement(By.xpath("//div[@class = 'slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath(")//input[@type='search']")).sendKeys("Marketting");
		Assert.assertEquals(false, true);
	}
	
	@DataProvider
	public String[][] getTestData() {
		return new[][] {
			{"Marketting"}
			
		};
		}
	
	@AfterMethod
	public void screenShot(ITestResult result) throws IOException {
	if (!result.isSuccess()) {
		System.out.println("Failed Testcase Name is "+ result.getName());
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File Src = scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Src,new File("./Image/"+ result.getName()+".png"));
		
	}

	}

}
