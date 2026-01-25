package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pagesp.ProductCatalog;

public class ProductCatalogTest extends BaseTest {

	@Test(priority=1)
	public void productlinkbutton() throws InterruptedException {
	ProductCatalog pd = new ProductCatalog(driver);
	Thread.sleep(5000);
		pd.productLinks();
		
	}

	@Test(priority = 2)

	public void createproduct() {
		ProductCatalog pd = new ProductCatalog(driver);

		pd.enterProductName("Apple", "New");
		
		pd.productDetails(10, 30000, 400000);
		pd.clickSave();

	}

}
