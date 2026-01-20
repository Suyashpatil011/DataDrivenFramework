import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import pagesp.LoginpageSp;

public class LoginPageTest extends BaseTest {

	@Test
	public void testValidData() {

		LoginpageSp login = new LoginpageSp(driver);
		login.enterUsername("suyashpatil01@gmail.com");
		login.enterPassword("Suyash@001");
		login.submitButton();
		
		System.out.println("Suyash");

	}

}
