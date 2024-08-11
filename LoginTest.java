package com.testautomation.orangehrm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @AfterMethod
    void teardown() {
        driver.quit();
    }

    @DataProvider(name = "testdata")
    Object[][] Data() {
        Object data[][] = new Object[4][2];

        // set1
        data[0][0] = "Admin";
        data[0][1] = "admin123";

        // set2
        data[1][0] = "Admin123";
        data[1][1] = "admin@123";

        // set3
        data[2][0] = "123Admin";
        data[2][1] = "admin1234";

        // set4
        data[3][0] = "AdminAdmin";
        data[3][1] = "admin_123";

        return data;
    }

    @Test(dataProvider = "testdata")
    void login(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
   
        String ErrorMSG = "Invalid credentials";
        String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

        if (driver.getCurrentUrl().equals(ExpectedURL)) {
            Assert.assertTrue(true);
        } else if (driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]")).getText().equals(ErrorMSG)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }
}
