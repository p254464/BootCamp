package week1.SaturnSprint1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifySorting {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		String actResult = "Sorted Ascending";

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class = 'slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		//to scroll until sales option using js executor
		WebElement element = driver.findElement(By.xpath("//p[text()='Sales']"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		//using js click method
		js.executeScript("arguments[0].click();",element);
		WebElement Acct = driver.findElement(By.xpath("//a[@title='Accounts']"));
		js.executeScript("arguments[0].click();", Acct);
		//collections to verify the ascending order
		//before sorting the values

		ArrayList<String> values1 = new ArrayList <String>();
		List<WebElement> listSize = driver.findElements(By.xpath("//table/tbody/tr"));
		int size = listSize.size();
		System.out.println(size);
		for(int i=1;i<size;i++) {
			String List1 = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]/following-sibling::th/span/a")).getText();
			values1.add(List1);
			//System.out.println(values1);

		}
		//sorting the values
		Collections.sort(values1);
		System.out.println(values1);
		Collections.reverse(values1);
		System.out.println(values1);
		
		WebElement Sort = driver.findElement(By.xpath("(//div[@class='slds-cell-fixed'])[2]/a"));
		js.executeScript("arguments[0].click();", Sort);
		Thread.sleep(3000);
		List<WebElement> acc_Name_Sort = driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println("No of Rows: "+acc_Name_Sort.size());

		ArrayList<String> acc_Name_List_Sort = new ArrayList<String>();

		for(int i=1;i<=acc_Name_Sort.size();i++) {
			String dis_Text = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/th//a")).getAttribute("title");
			acc_Name_List_Sort.add(dis_Text);
		}

		System.out.println("Size of acc_Name_List: "+acc_Name_List_Sort.size());
		System.out.println(acc_Name_List_Sort);

		if(acc_Name_List.equals(acc_Name_List_Sort)) {
			System.out.println("Account Name Sorted in Ascending Order");
		} else {
			System.out.println("Account Name NOT Sorted in Ascending Order");
		}
		
		
		
		
		
		
		
		
		
		//adding sorted values in list2
		/*ArrayList<String> values2 = new ArrayList <String>();
		List<WebElement> listSize2 = driver.findElements(By.xpath("//table/tbody/tr"));
		int size2 = listSize2.size();
		System.out.println(size2);
		for(int i=1;i<size2;i++) {
			String List2 = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]/following-sibling::th/span/a")).getText();
			values2.add(List2);
			System.out.println(values2);

		}
		if (values1.equals(values2)==true) {
			System.out.println("Acct details are sorted in ascending order");

		}else {
			System.out.println("Acct details are not sorted in ascending order");

		}
		Thread.sleep(2000); driver.close();
*/

		/*
		 * //verify the sort in alphabetical order Thread.sleep(3000); String sort =
		 * driver.findElement(By.xpath("//span[text()='Sorted Ascending']")).getText();
		 * System.out.println("verified message of first acct is =" + sort);
		 * 
		 * if(sort.contains(actResult)) {
		 * System.out.println("Acct details are sorted in ascending order");
		 * 
		 * }else { System.out.println("Acct details are not sorted in ascending order");
		 * 
		 * }
		 */




	}

}
//





