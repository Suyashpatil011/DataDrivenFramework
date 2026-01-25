package pagesp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalog {
	private WebDriver driver;

	@FindBy(xpath = "//a[normalize-space()='Catalog']")
	WebElement catalogMenu;

	@FindBy(xpath = "//a[normalize-space()='Products']")
	WebElement productLink;

	@FindBy(id = "Name")
	WebElement productName;

	@FindBy(id = "ShortDescription")
	WebElement shortDescription;

	@FindBy(id = "Price")
	WebElement priceText;

	@FindBy(id = "OldPrice")
	WebElement oldPriceText;

	@FindBy(id = "ProductCost")
	WebElement productCost;

	@FindBy(xpath = "//button[@name='save']")
	WebElement saveButton;

	public ProductCatalog(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void productLinks() {
		catalogMenu.click();
		productLink.click();
	}

	public void enterProductName(String Productname, String Productdescription) {
		productName.clear();
		productName.sendKeys(Productname);
		shortDescription.clear();
		shortDescription.sendKeys(Productdescription);
	}

	public void productDetails(int Price, int Oldprice, int ProductCost) {
		priceText.clear();
		priceText.sendKeys(String.valueOf(Price));

		oldPriceText.clear();
		oldPriceText.sendKeys(String.valueOf(Oldprice));

		productCost.clear();
		productCost.sendKeys(String.valueOf(ProductCost));
	}

	public void clickSave() {
		saveButton.click();
	}

}
