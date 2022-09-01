package week1.SaturnSprint1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.IfFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class SeleniumAssessment1 {

	public static void main(String[] args) throws InterruptedException {

		String actResult = "Param_Workout";
		String subsConfirm = "You started a dashboard subscription";
		String DeleConfirm = "Dashboard was deleted.";

		// Setup Browser Driver and Path
		WebDriverManager.chromedriver().setup();

		// remove notitifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Launch chrome Browser
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		// implicit wait for all driver elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 1. Launch login.salesforce.com site
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("saturn@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp$123");
		driver.findElement(By.id("Login")).click();

		// 2) Click on toggle menu from left corner
		driver.findElement(By.xpath("//div[@class = 'slds-icon-waffle']")).click();

		// 3) click on view all
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();

		// 4) click sales from app launcher
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//p[text()='Sales']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

		// 5. Select Home from the DropDown
		Thread.sleep(5000);
		WebElement home = driver.findElement(By.xpath("//span[text()='Home']"));
		js.executeScript("arguments[0].click();", home);

		// 6) Add CLOSED + OPEN values and result should set as the GOAL (If the result
		// is less than 10000 then set the goal as 10000)
		// collect closed value
		Thread.sleep(5000);
		String ClosedValue = driver
				.findElement(By.xpath("//span[text()='Closed']/following-sibling::lightning-formatted-text")).getText();
		System.out.println("Closed values is " + ClosedValue);
		// Remove special character
		String NewCloVal = ClosedValue.replaceAll("\\D", "");
		int Int1 = Integer.parseInt(NewCloVal);
		System.out.println(Int1);
		// collect open value
		String OpenValue = driver
				.findElement(
						By.xpath("(//span[contains(text(),'Open')])[2]/following-sibling::lightning-formatted-text"))
				.getText();
		System.out.println("Open Value is " + OpenValue);
		// Remove special character
		String NewOpeVal = OpenValue.replaceAll("\\D", "");
		int Int2 = Integer.parseInt(NewOpeVal);
		System.out.println(Int2);
		// add them as Goal
		int Goal = Int1 + Int2;
		System.out.println("Int Sum " + Goal);
		String Goal1 = Goal + "";
		System.out.println("Int Sum " + Goal1);

		if (Goal < 10000) {
			Goal = 10000;
			System.out.println("Goal Value set to 10000");
		} else {
			System.out.println("Goal Value is :" + Goal);
		}

		// click on Edit button for Goal
		driver.findElement(By.xpath("//button[contains(@title,'Edit Goal')]")).click();
		// clear USD box
		WebElement USD = driver.findElement(By.xpath("//input[@class='slds-input']"));
		USD.click();
		USD.clear();
		USD.sendKeys(Goal1);
		driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();

		// 7) click on Dashboard
		WebElement Dashboard = driver.findElement(By.xpath("(//span[text()='Dashboards'])[1]"));
		js.executeScript("arguments[0].click();", Dashboard);

		// 8) click on new Dashboard
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();

		// 9) click on input as yourname_Workout using Frame
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='dashboard'])[1]")));
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Param_Workout");

		// 10.Enter Description as Testing and Click on Create
		driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("Testing");

		// 11)Click on Create
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();

		// 12)Click on Done using Frame
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.switchTo().defaultContent();

		// 13) Click on Dashboard tab
		js.executeScript("arguments[0].click();", Dashboard);

		// 14)Verify the Dashboard is Created
		List<WebElement> DbRows = driver.findElements(By.xpath("//table/tbody/tr/th"));
		for (int i = 1; i <= DbRows.size(); i++) {
			String verify = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/th/descendant::a"))
					.getAttribute("title");
			if (verify.contains(actResult)) {
				System.out.println("Dashboard is created ");
				break;
			} else {
				System.out.println("Dashboard is not created ");
			}

		}

		// 15. Click on the newly created Dashboard
		for (int i = 1; i < DbRows.size(); i++) {
			String verify = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/th/descendant::a"))
					.getAttribute("title");
			if (verify.contains(actResult)) {
				WebElement firstEle = driver.findElement(By.xpath("//table/tbody/tr[1]/th/descendant::a"));
				js.executeScript("arguments[0].click();", firstEle);
				break;
			}
		}

		// 16. Click on Subscribe
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='dashboard'])[2]")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Subscribe']")).click();
		driver.switchTo().defaultContent();

		// 17. Select Frequency as "Daily"
		driver.findElement(By.xpath("//label[contains(@class,'daily slds-button slds-radio')]")).click();

		// 18. Time as 10:00 AM
		WebElement source = driver.findElement(By.xpath("//select[@class=' select']"));
		Select slt = new Select(source);
		slt.selectByIndex(10);

		// 19.Click on Save
		driver.findElement(By.xpath("//span[text()='Save']")).click();

		// 20.Verify "You started Dashboard Subscription" message displayed or not
		WebElement SubMessage = driver.findElement(By.xpath("//span[text()='You started a dashboard subscription.']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(SubMessage));
		if (SubMessage.isDisplayed()) {
			System.out.println("You started Dashboard Subscription message discplayed successfully ");

		} else {
			System.out.println("You started Dashboard Subscription is not displayed ");
		}

		// 21.Click on Dashboards tab
		js.executeScript("arguments[0].click();", Dashboard);

		// 22. Verify the newly created Dashboard is available
		for (int i = 1; i <= DbRows.size(); i++) {
			String verify = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/th//span/div//a")).getText();
			if (verify.contains(actResult)) {
				System.out.println("new dashboard is created successfully");
				break;
			}
		}

		// 23.Click on dropdown for the item
		Thread.sleep(3000);
		for (int i = 1; i <= DbRows.size(); i++) {
			String name = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/th//span/div//a")).getText();
			if (name.equalsIgnoreCase(actResult)) {
				//WebElement downarrow = driver.findElement(
						//By.xpath("//table/tbody/tr[" + i + "]/td[6]"));
				driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[6]")).click();
				//js.executeScript("arguments[0].click();", downarrow);
				//wait.until(ExpectedConditions.elementToBeClickable(downarrow)).click();
				break;
			}
		}

		// 24. Select Delete
	
		WebElement Delete = driver.findElement(By.xpath("//span[text()='Delete']"));
		wait.until(ExpectedConditions.visibilityOf(Delete)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Delete']/span")).click();

		// 25. Confirm the Delete
		WebElement DashDelete = driver.findElement(By.xpath("//div[contains(@id,'toast')]/span"));
		wait.until(ExpectedConditions.visibilityOf(DashDelete));
		if (DashDelete.isDisplayed()) {
			System.out.println("Dashboard Delete Message is displayed");

		} else {
			System.out.println("Dashboard Delete Message is not displayed");
		}

		// 26.Verify the item is not available under Private Dashboard folder
		driver.findElement(By.xpath("//li/a[@title='Private Dashboards']")).click();
		int count = 0;
		List<WebElement> priDash_Rows = driver.findElements(By.xpath("//table/tbody/tr"));
		for (int j = 1; j <= priDash_Rows.size(); j++) {
			String name = driver.findElement(By.xpath("//table/tbody/tr[" + j + "]/th//span/div//a")).getText();
			if (name.contains(actResult)) {
				count++;
				break;
			}
		}
		if (count == 0) {
			System.out.println("Dashboard Not Present under Private Dashboard");
		} else {
			System.out.println("Dashboard Present under Private Dashboard, Its not deleted");
		}
		driver.quit();

	}

}
