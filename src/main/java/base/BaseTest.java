package base;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utilities.ExtendReportManager;
import Utilities.Log;

public class BaseTest {

	public WebDriver driver;
	protected static ExtentReports extent;

	@BeforeSuite
	public void setupReport() {
		extent = ExtendReportManager.getReportInstance();
	}

	@AfterSuite
	public void flushReport() {
		extent.flush();
	}

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)

	public void setUp() {
		Log.info("Staring Script");
		driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login");
		Log.info("Launching URL...");
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		{
			if (driver != null) {
				Log.info("Closing Window...");
				driver.quit();

			}
		}
	}
}
