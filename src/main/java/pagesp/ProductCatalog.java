
package pagesp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalog {

    private WebDriver driver;

    @FindBy(xpath ="(//a[@class='nav-link active'][1])[1]")
    public WebElement catalogMenu;

    @FindBy(xpath = "//p[normalize-space()='Products']/parent::a")
    public WebElement productsMenu;

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

    public void clickCatalog() {
        catalogMenu.click();
    }

    public void clickProducts() {
        productsMenu.click();
    }

    public void enterProductName(String productname, String productdescription) {
        productName.clear();
        productName.sendKeys(productname);
        shortDescription.clear();
        shortDescription.sendKeys(productdescription);
    }

    public void productDetails(int Price, int OldPrice, int ProductCost) {
        priceText.clear();
        priceText.sendKeys(String.valueOf(Price));

        oldPriceText.clear();
        oldPriceText.sendKeys(String.valueOf(OldPrice));

        productCost.clear();
        productCost.sendKeys(String.valueOf(ProductCost));
    }

    public void clickSave() {
        saveButton.click();
    }
}
