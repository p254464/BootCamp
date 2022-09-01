package TestNG_Practice;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.collect.ObjectArrays;

public class TC003 extends TestNG_hooks {


	@Test(dataProvider = "getTestData")
	public void test_TC003(String name, String version) {
		System.out.println("Edge browser is executed ");
		System.out.println("Dataprovider value " + name +","+version);
	}

	@DataProvider
	public Object[][] getTestData() {
		return new Object[][] {
			{"Selenium","v.4.4.0"},
			{"TESTNG","v.4.4.0"}

		};
		
		
	}
}





