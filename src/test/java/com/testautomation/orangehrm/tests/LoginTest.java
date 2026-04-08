package com.testautomation.orangehrm.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testautomation.orangehrm.pages.DashboardPage;
import com.testautomation.orangehrm.pages.LoginPage;
import com.testautomation.orangehrm.utilities.BaseClass;
import com.testautomation.orangehrm.utilities.ScreenshotUtil;

public class LoginTest extends BaseClass{

	@BeforeMethod
	void launch() throws IOException {
	    setup();
	}

	@AfterMethod
	void close() {
	    teardown();
	}
    @DataProvider(name = "testdata")
    Object[][] Data() {
        Object data[][] = new Object[4][2];

        data[0][0] = "Admin";
        data[0][1] = "admin123";

        data[1][0] = "Admin123";
        data[1][1] = "admin@123";

        data[2][0] = "123Admin";
        data[2][1] = "admin1234";

        data[3][0] = "AdminAdmin";
        data[3][1] = "admin_123";

        return data;
    }

    @Test(dataProvider = "testdata")
    void login(String username, String password) throws IOException {

        LoginPage lp = new LoginPage(driver);
        lp.login(username, password);
        
        DashboardPage dp = new DashboardPage(driver);

        String ErrorMSG = "Invalid credentials";
        String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

        if (driver.getCurrentUrl().equals(ExpectedURL) && dp.isDashboardDisplayed()) {
            Assert.assertTrue(true, "Valid login successful");
        } 
        else if (lp.getErrorMessage().equals(ErrorMSG)) {
            Assert.assertTrue(true, "Invalid login handled correctly");
        } 
        else {
            ScreenshotUtil.captureScreenshot(driver, "loginFailure");
            Assert.fail("Unexpected login behavior");
        }
    }
}