package com.ui.pages;

import com.ui.utils.BrowserUtil;
import com.ui.utils.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BrowserUtil {

    private By LOGIN_EMAIL_LOCATOR = By.id(PropertiesUtil.getProperty("login_email_locator"));
    private By LOGIN_PASSWORD_LOCATOR = By.id(PropertiesUtil.getProperty("login_password_locator"));
    private By LOGIN_BUTTON_LOCATOR = By.xpath(PropertiesUtil.getProperty("login_button_locator"));
    private By NEXT_BUTTON_LOCATOR = By.xpath(PropertiesUtil.getProperty("login_next_button_locator"));
    private By INVALID_CREDENTIAL_LOCATOR = By.xpath(PropertiesUtil.getProperty("invalid_email_password_error_locator"));

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public HomePage login(String userName, String password) {
        sendText(LOGIN_EMAIL_LOCATOR, userName);
        clickOn(NEXT_BUTTON_LOCATOR);
        sendText(LOGIN_PASSWORD_LOCATOR, password);
        clickOn(LOGIN_BUTTON_LOCATOR);
        implicitWait("30");
        HomePage homePage = new HomePage(getWebDriver());
        return homePage;
    }

    public String invalidEmail(String userName)
    {
        sendText(LOGIN_EMAIL_LOCATOR, userName);
        clickOn(NEXT_BUTTON_LOCATOR);
        wait(INVALID_CREDENTIAL_LOCATOR);
        return getText(INVALID_CREDENTIAL_LOCATOR);
    }
    public String invalidPassword(String userName ,String password)
    {
        sendText(LOGIN_EMAIL_LOCATOR, userName);
        clickOn(NEXT_BUTTON_LOCATOR);
        sendText(LOGIN_PASSWORD_LOCATOR,password);
        clickOn(LOGIN_BUTTON_LOCATOR);
        wait(INVALID_CREDENTIAL_LOCATOR);
        return getText(INVALID_CREDENTIAL_LOCATOR);
    }

    public String blankUserName(String userName)
    {
        clickOn(NEXT_BUTTON_LOCATOR);
        wait(INVALID_CREDENTIAL_LOCATOR);
        return getText(INVALID_CREDENTIAL_LOCATOR);
    }
    public String blankPassword(String userName, String password)
    {
        sendText(LOGIN_EMAIL_LOCATOR, userName);
        clickOn(NEXT_BUTTON_LOCATOR);
        clickOn(LOGIN_BUTTON_LOCATOR);
        wait(INVALID_CREDENTIAL_LOCATOR);
        return getText(INVALID_CREDENTIAL_LOCATOR);
    }

}