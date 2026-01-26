package pagesp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {

	WebDriver driver;

	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[1]")
	WebElement clickorder;

	@FindBy(id = "OrderStatusIds")
	WebElement orderStatusDropdown;

	@FindBy(id = "search-orders")
	WebElement searchButton;

	public Dashboard(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void vieworder() {
		clickorder.click();

	}

	public void selectOrderStatus(String Status) {
		Select st = new Select(orderStatusDropdown);
		st.selectByVisibleText(Status);

	}

	public void clickSerach() {
		searchButton.click();

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(
				ExpectedConditions.presenceOfElementLocated
				(By.xpath("//div[@class='dt-scroll-body']//tbody/tr")));

	}

	public int viewOrderCount() {
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='dt-scroll-body']//tbody/tr"));
		return rows.size();

	}
}
