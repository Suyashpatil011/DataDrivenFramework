package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pagesp.Dashboard;

public class OrderCount extends BaseTest {

	@Test(priority =1)
	public void verifyCompleteCountOrder() {

		Dashboard dp = new Dashboard(driver);
		dp.vieworder();
		dp.selectOrderStatus("Complete");
		dp.clickSerach();
		int count = dp.viewOrderCount();

		System.out.println("Completed Orders Count = " + count);

		Assert.assertTrue(count > 0, "No completed orders found!");

	}
	@Test(priority =2)
	public void verifyAllCountOrder() {

		Dashboard dp = new Dashboard(driver);
		dp.vieworder();
		dp.selectOrderStatus("Pending");
		dp.clickSerach();
		int count = dp.viewOrderCount();

		System.out.println("pending Orders Count = " + count);

		Assert.assertTrue(count > 0, "No Pending orders found!");

}
}

