package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.ExcelUtils;  // <-- Make sure this package matches your ExcelUtils class
import base.BaseTest;
import pagesp.LoginpageSp;

import java.io.IOException;

@Listeners(Utilities.Listeners.class)
class LoginPageTest extends BaseTest {

	/*
	 * @DataProvider(name = "LoginData") public Object[][] getLoginData() throws
	 * IOException { String filePath = System.getProperty("user.dir") +
	 * "/testdata/Testdata.xlsx";
	 * 
	 * // Load Excel ExcelUtils.loadExcel(filePath, "LoginData");
	 * 
	 * int rowCount = ExcelUtils.getRowCount(); if (rowCount <= 1) { // assuming
	 * first row is header ExcelUtils.closeExcel(); return new Object[0][0]; // or
	 * throw an exception / fail test with message }
	 * 
	 * // Assuming row 0 is header and two columns: username, password Object[][]
	 * data = new Object[rowCount - 1][2];
	 * 
	 * for (int i = 1; i < rowCount; i++) { data[i - 1][0] = ExcelUtils.getData(i,
	 * 0); // Username data[i - 1][1] = ExcelUtils.getData(i, 1); // Password }
	 * 
	 * ExcelUtils.closeExcel(); return data; }
	 */
    

    // Use DataProvider
    @Test(dataProvider = "LoginData")
    
    public void testValidData(String username, String password) {
        LoginpageSp login = new LoginpageSp(driver);
        login.enterUsername("admin@yourstore.com");
        login.enterPassword("admin");
        login.submitButton();
        
    

    }
}
