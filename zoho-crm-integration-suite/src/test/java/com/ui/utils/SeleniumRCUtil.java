package com.ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class SeleniumRCUtil {

    private static WebDriver driver;

    public static WebDriver initializeDriver() {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/resources/config.properties");
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String browser = properties.getProperty("browser").toLowerCase();
        String hubURL = properties.getProperty("hubURL");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (browser) {
            case "chrome":
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                break;
            case "firefox":
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
                break;
            case "edge":
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "MicrosoftEdge");
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        try {
            driver = new RemoteWebDriver(new URL(hubURL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
