package com.ui.pages;

import com.ui.utils.BrowserUtil;
import com.ui.utils.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BrowserUtil {

    private By NAVIGATE_TO_LEAD_VIEW = By.linkText(PropertiesUtil.getProperty("lead_view_locator"));
    private By LEAD_HOMEPAGE = By.id(PropertiesUtil.getProperty("lead_homepage_username"));

    public HomePage(WebDriver webDriver) {
        super(webDriver);

    }

    public LeadViewPage navigateToLead()
    {
      clickOn(NAVIGATE_TO_LEAD_VIEW);
      LeadViewPage leadViewPage = new LeadViewPage(getWebDriver());
      return leadViewPage;
    }
    public String getUsername()
    {
        wait(LEAD_HOMEPAGE);
        return getText(LEAD_HOMEPAGE);
    }
    public CustomizeLeadPage navigateToCustomize()
    {
        clickOn(NAVIGATE_TO_LEAD_VIEW);
        CustomizeLeadPage customizeLeadPage = new CustomizeLeadPage(getWebDriver());
        return customizeLeadPage;
    }
}
