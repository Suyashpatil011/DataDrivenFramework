package Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class Listeners extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		ExtendReportManager.createTest(result.getMethod().getMethodName());

		System.out.println("Test Started: " + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		WebDriver driver = ((BaseTest) result.getInstance()).driver;

		String path = ScreenshotUtil.takeScreenshot(driver, result.getName());

		System.out.println("Test Passed: " + result.getName());
		ScreenshotUtil.takeScreenshot(driver, result.getName());
		ExtendReportManager.getTest();
		ExtendReportManager.getTest().addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = ((BaseTest) result.getInstance()).driver;

		String path = ScreenshotUtil.takeScreenshot(driver, result.getName());

		ExtendReportManager.getTest().fail(result.getThrowable());
		ExtendReportManager.getTest().addScreenCaptureFromPath(path);

		System.out.println("Test Failed: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: " + result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {

		ExtendReportManager.getReportInstance().flush();
		System.out.println("--- Report Flushed ---");

	}

}
