
package test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import pagesp.ProductCatalog;

public class ProductCatalogTest extends BaseTest {

	@Test
	public void clickOnCatalog() {

		ProductCatalog pd = new ProductCatalog(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pd.catalogMenu));

		pd.clickCatalog();
	}

	@Test
	public void clickOnProducts() {

		ProductCatalog pd = new ProductCatalog(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pd.productsMenu));

		pd.clickProducts();
	}

	@Test(priority =2)
	public void createProduct() {

		ProductCatalog pd = new ProductCatalog(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(pd.catalogMenu));
		pd.clickCatalog();

		wait.until(ExpectedConditions.elementToBeClickable(pd.productsMenu));
		pd.clickProducts();

		pd.enterProductName("Apple", "New Product");
		pd.productDetails(10, 30000, 400000);
		pd.clickSave();
	}
}
