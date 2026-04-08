package com.testautomation.orangehrm.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties p;

    public ConfigReader() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        p = new Properties();
        p.load(fis);
    }

    public String getProperty(String key) {
        return p.getProperty(key);
    }
}