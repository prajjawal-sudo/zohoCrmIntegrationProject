package com.ui.base;
import com.ui.pages.LandingPage;
import com.ui.utils.BrowserUtil;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    public LandingPage landingPage;

    @BeforeSuite
    public void setup()
    {
         landingPage = new LandingPage(Browser.CHROME,true);
    }

    public BrowserUtil getInstance()
    {
        return landingPage;
    }

    @AfterClass
    public void tearDown()
    {
        if(landingPage.getWebDriver()!=null)
        {
            landingPage.getWebDriver().quit();
        }
    }
}
