package com.ui.pages;

import com.ui.utils.BrowserUtil;
import com.ui.utils.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.Browser;

public class LandingPage extends BrowserUtil {


    private By SIGN_IN_LOCATOR = By.xpath(PropertiesUtil.getProperty("sign_in_link_locator"));

    public LandingPage(Browser browserName,boolean isHeadLess) {
        super(browserName,isHeadLess);
        goToZoho("https://www.zoho.com/en-in/crm/");
        maximize();
    }


    public LoginPage signInLink()
    {
        clickOn(SIGN_IN_LOCATOR);
        implicitWait("10");
        LoginPage loginPage = new LoginPage(getWebDriver());
        return loginPage;
    }
}
