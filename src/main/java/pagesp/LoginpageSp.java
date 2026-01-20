package pagesp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpageSp {
	
	private WebDriver driver;
	
	@FindBy(id="Email")
	WebElement textUserName;
	
	@FindBy(id ="Password")
	WebElement textPassword;
	
	@FindBy(xpath="//button")
	WebElement submitButton; 
	
	public LoginpageSp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void enterUsername(String username) {
		textUserName.clear();
		textUserName.sendKeys(username);
			
	}
	
	public void enterPassword(String password) {
		textPassword.clear();
		textPassword.sendKeys(password);
	}
	
	public void submitButton() {
		submitButton.click();
	}
	

}
