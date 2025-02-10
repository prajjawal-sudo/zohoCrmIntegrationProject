package com.ui.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BrowserUtil {

    public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public BrowserUtil(WebDriver webDriver) {
        this.webDriver.set(webDriver);
    }

    public BrowserUtil(Browser browserName) {

        if(browserName==Browser.CHROME)
        {
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            webDriver.set(new ChromeDriver(options));
        }
        else if(browserName==Browser.FIREFOX)
        {
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            FirefoxOptions option = new FirefoxOptions();
            option.addPreference("prefs", prefs);
            webDriver.set(new FirefoxDriver(option));
        }
    }
    public BrowserUtil(Browser browserName , boolean isHeadLess)
    {

        if(browserName==Browser.CHROME)
        {
            if(isHeadLess) {
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                chromeOptions.setExperimentalOption("prefs", prefs);
                webDriver.set(new ChromeDriver(chromeOptions));
            }
            else {
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                webDriver.set(new ChromeDriver(options));
            }
        }
        else if(browserName == Browser.FIREFOX)
        {
            if(isHeadLess) {
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless=old");
                firefoxOptions.addArguments("disable-gpu");
                firefoxOptions.addPreference("prefs", prefs);
                webDriver.set(new FirefoxDriver(firefoxOptions));
            }
            else {
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                FirefoxOptions option = new FirefoxOptions();
                option.addPreference("prefs", prefs);
                webDriver.set(new FirefoxDriver(option));
            }
        }
        else {
            System.err.println("Web Browser not available in system");
        }
    }

    public WebDriver getWebDriver() {
        return webDriver.get();
    }

    public void goToZoho(String url)
    {
        webDriver.get().get(url);
    }

    public void maximize()
    {
        webDriver.get().manage().window().maximize();
    }


    public void clickOn(By locator)
    {
        WebElement clickElement = webDriver.get().findElement(locator);
        clickElement.click();
    }

    public void sendText(By locator,String text)
    {
        WebElement textElement = webDriver.get().findElement(locator);
        textElement.sendKeys(text);
    }
    public void wait(By locator)
    {
        WebElement element = webDriver.get().findElement(locator);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver.get(), Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
    public void moveToElement(By locator)
    {
        WebElement element = webDriver.get().findElement(locator);
        Actions actions = new Actions(webDriver.get());
        actions.moveToElement(element).perform();
    }
    public void implicitWait(String seconds)
    {
        int second = Integer.parseInt(seconds);
        webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }
    public String  getText(By locator)
    {
        WebElement element = webDriver.get().findElement(locator);
        return element.getText();
    }
    public void clear(By locator)
    {
        WebElement element = webDriver.get().findElement(locator);
        element.clear();
    }

    public String takeScreenshot(String name)  {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH.mm.ss");
        String timestamp = simpleDateFormat.format(date);
        String path = System.getProperty("user.dir") + "//screenshot//" + name + "-" + timestamp  + ".png";
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver.get();
        File file = new File(path);
        File screenShot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot,file);
        }
        catch (Exception e)
        {
           throw new RuntimeException(e);
        }
        return path;
    }
}
