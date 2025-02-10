package com.ui.pages;

import com.ui.utils.BrowserUtil;
import com.ui.utils.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditLeadPage extends BrowserUtil {

    private By FIRST_NAME_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_first_name_locator"));
    private By LAST_NAME_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_last_name_locator"));
    private By EMAIL_ADDRESS_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_email_address_locator"));
    private By PHONE_NUMBER_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_phone_number_locator"));
    private By SAVE_LEAD_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_save_button_locator"));
    private By COMPANY_MISSING_LOCATOR = By.id(PropertiesUtil.getProperty("lead_company_field_missing_locator"));
    private By LAST_NAME_MISSING_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_last_name_field_missing_locator"));
    private By COMPANY_NAME_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_company_name_locator"));
    private By EDIT_LEAD_CANCEL = By.xpath(PropertiesUtil.getProperty("lead_edit_navigation_locator"));
    private By CANCEL_BUTTON_LOCATOR = By.xpath(PropertiesUtil.getProperty("lead_edit_cancel_button_locator"));




    public EditLeadPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SaveLeadPage newLeadDetails(String newFirstName, String newEmail , String newPhoneNumber)
    {
        wait(FIRST_NAME_LOCATOR);
        clear(FIRST_NAME_LOCATOR);
        sendText(FIRST_NAME_LOCATOR,newFirstName);
        clear(LAST_NAME_LOCATOR);
        sendText(LAST_NAME_LOCATOR,newEmail);
        clear(PHONE_NUMBER_LOCATOR);
        sendText(PHONE_NUMBER_LOCATOR,newPhoneNumber);
        clickOn(SAVE_LEAD_LOCATOR);
        SaveLeadPage saveLeadPage = new SaveLeadPage(getWebDriver());
        return saveLeadPage;
    }

    public String companyDetailsMissing(String firstName , String email, String phoneNumber)
    {
        wait(FIRST_NAME_LOCATOR);
        clear(FIRST_NAME_LOCATOR);
        sendText(FIRST_NAME_LOCATOR,firstName);
        clear(EMAIL_ADDRESS_LOCATOR);
        sendText(EMAIL_ADDRESS_LOCATOR,email);
        clear(PHONE_NUMBER_LOCATOR);
        sendText(PHONE_NUMBER_LOCATOR,phoneNumber);
        clear(COMPANY_NAME_LOCATOR);
        clickOn(SAVE_LEAD_LOCATOR);
        wait(COMPANY_MISSING_LOCATOR);
        return getText(COMPANY_MISSING_LOCATOR);

    }
    public String lastNameDetailsMissing(String firstName , String email, String phoneNumber)
    {
        wait(FIRST_NAME_LOCATOR);
        clear(FIRST_NAME_LOCATOR);
        sendText(FIRST_NAME_LOCATOR,firstName);
        clear(EMAIL_ADDRESS_LOCATOR);
        sendText(EMAIL_ADDRESS_LOCATOR,email);
        clear(PHONE_NUMBER_LOCATOR);
        sendText(PHONE_NUMBER_LOCATOR,phoneNumber);
        clear(LAST_NAME_LOCATOR);
        clickOn(SAVE_LEAD_LOCATOR);
        wait(LAST_NAME_MISSING_LOCATOR);
        return getText(LAST_NAME_MISSING_LOCATOR);
    }

    public String cancelEdit()
    {
        clickOn(CANCEL_BUTTON_LOCATOR);
        wait(EDIT_LEAD_CANCEL);
        return getText(EDIT_LEAD_CANCEL);
    }
}
