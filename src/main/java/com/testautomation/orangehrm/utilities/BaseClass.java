package com.testautomation.orangehrm.utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

    public WebDriver driver;

    public void setup() throws IOException {
        ConfigReader cr = new ConfigReader();
        driver = new ChromeDriver();
        driver.get(cr.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.manage().window().maximize();
    }

    public void teardown() {
        driver.quit();
    }
}