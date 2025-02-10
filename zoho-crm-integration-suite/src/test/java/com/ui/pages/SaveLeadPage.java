package com.ui.pages;

import com.ui.utils.BrowserUtil;
import com.ui.utils.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SaveLeadPage extends BrowserUtil {

    private By NAVIGATE_TO_LEAD_VIEW = By.linkText(PropertiesUtil.getProperty("lead_view_locator"));
    private By LEAD_CREATED_UPDATED_SAVED = By.xpath(PropertiesUtil.getProperty("lead_created_updated_locator"));

    public SaveLeadPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LeadViewPage navigateToLead()
    {
        clickOn(NAVIGATE_TO_LEAD_VIEW);
        LeadViewPage leadViewPage = new LeadViewPage(getWebDriver());
        return leadViewPage;
    }
    public String leadSaved()
    {
        wait(LEAD_CREATED_UPDATED_SAVED);
        return getText(LEAD_CREATED_UPDATED_SAVED);
    }
}
