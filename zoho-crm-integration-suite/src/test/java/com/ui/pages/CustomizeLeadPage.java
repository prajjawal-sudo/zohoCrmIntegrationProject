package com.ui.pages;
import com.ui.utils.BrowserUtil;
import com.ui.utils.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomizeLeadPage extends BrowserUtil {

    private By SETTINGS_LOCATOR = By.xpath(PropertiesUtil.getProperty("customize_lead_settings_locator"));
    private By SEARCH_MODULE_LOCATOR = By.xpath(PropertiesUtil.getProperty("customize_lead_search_locator"));
    private By MODULES_OPTION_LOCATOR = By.xpath(PropertiesUtil.getProperty("customize_lead_module_locator"));
    private By LEADS_OPTION_LOCATOR = By.xpath(PropertiesUtil.getProperty("customize_lead_option_locator"));
    private By STANDARDS_LOCATOR = By.xpath(PropertiesUtil.getProperty("customize_standard_layout_locator"));
    private By CUSTOMIZE_EMAIL_LOCATOR = By.xpath(PropertiesUtil.getProperty("customize_email_field_locator"));
    private By EMAIL_MARK_MANDATORY_LOCATOR = By.xpath(PropertiesUtil.getProperty("customize_email_required_locator"));
    private By SAVE_CUSTOMIZE_LEAD_LOCATOR = By.xpath(PropertiesUtil.getProperty("customize_lead_save_locator"));
    private By CUSTOMIZE_SETTINGS_NAVIGATION = By.xpath(PropertiesUtil.getProperty("customize_lead_navigation"));


    public CustomizeLeadPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String navigateToCustomizeLead(String module)
    {
        clickOn(SETTINGS_LOCATOR);
        sendText(SEARCH_MODULE_LOCATOR,module);
        clickOn(MODULES_OPTION_LOCATOR);
        wait(LEADS_OPTION_LOCATOR);
        clickOn(LEADS_OPTION_LOCATOR);
        return getText(STANDARDS_LOCATOR);

    }

    public String openCustomizeLead(String module)
    {
        clickOn(SETTINGS_LOCATOR);
        sendText(SEARCH_MODULE_LOCATOR,module);
        clickOn(MODULES_OPTION_LOCATOR);
        wait(LEADS_OPTION_LOCATOR);
        clickOn(LEADS_OPTION_LOCATOR);
        clickOn(STANDARDS_LOCATOR);
        wait(CUSTOMIZE_SETTINGS_NAVIGATION);
        return getText(CUSTOMIZE_SETTINGS_NAVIGATION);
    }
    public String editEmailLead(String module)
    {
        clickOn(SETTINGS_LOCATOR);
        sendText(SEARCH_MODULE_LOCATOR,module);
        clickOn(MODULES_OPTION_LOCATOR);
        wait(LEADS_OPTION_LOCATOR);
        clickOn(LEADS_OPTION_LOCATOR);
        clickOn(STANDARDS_LOCATOR);
        wait(CUSTOMIZE_EMAIL_LOCATOR);
        clickOn(CUSTOMIZE_EMAIL_LOCATOR);
        clickOn(EMAIL_MARK_MANDATORY_LOCATOR);
        clickOn(SAVE_CUSTOMIZE_LEAD_LOCATOR);
        return getText(STANDARDS_LOCATOR);

    }

}
